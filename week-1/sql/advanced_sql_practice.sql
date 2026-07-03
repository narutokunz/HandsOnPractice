-- =========================================================
-- WEEK 1: ADVANCED SQL PRACTICE
-- =========================================================


CREATE TABLE departments (
    dept_id   INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

CREATE TABLE employees (
    emp_id    INT PRIMARY KEY,
    emp_name  VARCHAR(50),
    dept_id   INT,
    salary    DECIMAL(10,2),
    manager_id INT,
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

INSERT INTO departments VALUES (1, 'Engineering'), (2, 'Sales'), (3, 'HR');

INSERT INTO employees VALUES
 (1, 'Aditi', 1, 95000, NULL),
 (2, 'Rohan', 1, 82000, 1),
 (3, 'Meera', 1, 78000, 1),
 (4, 'Kabir', 2, 65000, NULL),
 (5, 'Sana',  2, 61000, 4),
 (6, 'Ishaan', 3, 55000, NULL);

-- 1. JOIN: employees with their department name
SELECT e.emp_name, d.dept_name, e.salary
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id;

-- 2. SELF JOIN: employee with their manager's name
SELECT e.emp_name AS employee, m.emp_name AS manager
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.emp_id;

-- 3. SUBQUERY: employees earning above their department's average salary
SELECT emp_name, salary, dept_id
FROM employees e
WHERE salary > (
    SELECT AVG(salary) FROM employees WHERE dept_id = e.dept_id
);

-- 4. CTE (Common Table Expression): department-wise average salary
WITH dept_avg AS (
    SELECT dept_id, AVG(salary) AS avg_salary
    FROM employees
    GROUP BY dept_id
)
SELECT d.dept_name, da.avg_salary
FROM dept_avg da
JOIN departments d ON d.dept_id = da.dept_id;

-- 5. WINDOW FUNCTION: rank employees by salary within each department
SELECT
    emp_name,
    dept_id,
    salary,
    RANK() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS salary_rank
FROM employees;

-- 6. WINDOW FUNCTION: running total of salaries ordered by emp_id
SELECT
    emp_id, emp_name, salary,
    SUM(salary) OVER (ORDER BY emp_id) AS running_total
FROM employees;

-- 7. GROUP BY + HAVING: departments with more than 1 employee earning > 60000
SELECT dept_id, COUNT(*) AS high_earners
FROM employees
WHERE salary > 60000
GROUP BY dept_id
HAVING COUNT(*) > 1;

-- 8. INDEX: speed up lookups on a frequently filtered column
CREATE INDEX idx_emp_dept ON employees(dept_id);

-- 9. VIEW: reusable virtual table for reporting
CREATE VIEW employee_report AS
SELECT e.emp_name, d.dept_name, e.salary
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id;

SELECT * FROM employee_report;
