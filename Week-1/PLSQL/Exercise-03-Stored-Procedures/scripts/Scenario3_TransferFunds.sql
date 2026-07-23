-- Scenario 3: Transfer funds between accounts, checking that the source has sufficient balance.

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_target_account_id IN NUMBER,
    p_amount IN NUMBER
) 
AS
    v_current_balance NUMBER;
BEGIN
    -- 1. Check source balance and lock the row so no one else can withdraw at the exact same millisecond
    SELECT balance INTO v_current_balance 
    FROM Accounts 
    WHERE account_id = p_source_account_id 
    FOR UPDATE;
    
    -- 2. Verify sufficient funds
    IF v_current_balance >= p_amount THEN
        -- Deduct from source
        UPDATE Accounts 
        SET balance = balance - p_amount 
        WHERE account_id = p_source_account_id;
        
        -- Add to target
        UPDATE Accounts 
        SET balance = balance + p_amount 
        WHERE account_id = p_target_account_id;
        
        -- Finalize transaction
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer of $' || p_amount || ' successful.');
    ELSE
        -- 3. Abort if insufficient funds
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in the source account.');
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK; -- Crucial for banking: If ANYTHING fails, revert all money movements
        DBMS_OUTPUT.PUT_LINE('Transaction failed: ' || SQLERRM);
END TransferFunds;
/