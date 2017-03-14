SELECT
  Departments.Name,
  send.Name,
  send.Salary
FROM
  Departments,
  Employees send
WHERE
  (
    Departments.DepartmentID = send.DepartmentID
  ) AND(
    send.Salary =(
    SELECT
      MAX(m.Salary)
    FROM
      Employees m
    WHERE
      m.DepartmentID = send.DepartmentID
  )
  )
ORDER BY
  Departments.Name ASC