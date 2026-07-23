-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days.

DECLARE
    -- Cursor to fetch loans due in exactly the next 30 days
    CURSOR c_loans IS
        SELECT c.customer_name, l.loan_id, l.due_date
        FROM Customers c
        JOIN Loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    -- Enable output printing
    DBMS_OUTPUT.ENABLE;
    
    FOR r_loan IN c_loans LOOP
        -- Print a reminder message for each fetched record
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || r_loan.customer_name || 
                             ', your loan account (ID: ' || r_loan.loan_id || 
                             ') is due on ' || TO_CHAR(r_loan.due_date, 'DD-MON-YYYY') || '.');
    END LOOP;
END;
/