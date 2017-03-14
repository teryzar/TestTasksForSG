SELECT
  Departments.Name
FROM
  Departments
WHERE
  3 >(
  SELECT
    COUNT(Employees.Name)
  FROM
    Employees
  WHERE
    Employees.DepartmentID = Departments.DepartmentID
)
ORDER BY
  Departments.Name ASC