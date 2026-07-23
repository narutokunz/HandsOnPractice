-- Scenario 1: Apply a 1% discount to loan interest rates for customers above 60 years old.

DECLARE
    -- Cursor to fetch all customers and their ages
    CURSOR c_customers IS 
        SELECT customer_id, age FROM Customers;
BEGIN
    -- Loop through each customer
    FOR r_cust IN c_customers LOOP
        -- Control Structure: IF condition to check age
        IF r_cust.age > 60 THEN
            -- Update the interest rate in the Loans table for this specific customer
            UPDATE Loans 
            SET interest_rate = interest_rate - 1.0
            WHERE customer_id = r_cust.customer_id;
        END IF;
    END LOOP;
    
    -- Commit the transaction to save changes
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Senior citizen discounts applied successfully.');
END;
/