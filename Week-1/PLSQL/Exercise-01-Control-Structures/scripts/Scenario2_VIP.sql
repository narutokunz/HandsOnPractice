-- Scenario 2: Promote customer to VIP status if their balance is over $10,000.

DECLARE
    -- Cursor fetching customers for update
    CURSOR c_customers IS 
        SELECT customer_id, balance FROM Customers FOR UPDATE;
BEGIN
    FOR r_cust IN c_customers LOOP
        -- Control Structure: IF condition to check balance threshold
        IF r_cust.balance > 10000 THEN
            -- Update the current row in the loop
            UPDATE Customers 
            SET IsVIP = 'TRUE' 
            WHERE CURRENT OF c_customers;
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updated for eligible customers.');
END;
/