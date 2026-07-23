-- Scenario 1: Calculate and update the balance of all savings accounts by applying an interest rate of 1%.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest 
AS
BEGIN
    -- Update all savings accounts directly in a single SQL statement for maximum performance
    UPDATE Accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'Savings';
    
    -- Save the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all Savings accounts successfully.');
EXCEPTION
    -- Error Handling
    WHEN OTHERS THEN
        ROLLBACK; -- Revert any partial changes if an error occurs
        DBMS_OUTPUT.PUT_LINE('Error processing interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/