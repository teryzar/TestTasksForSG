SELECT
  Departments.Name,
  (
  SELECT
    SUM(Employees.Salary)
  FROM
    Employees
  WHERE
    Departments.DepartmentID = Employees.DepartmentID
)
FROM
  Departments
ORDER BY
  Departments.Name ASC