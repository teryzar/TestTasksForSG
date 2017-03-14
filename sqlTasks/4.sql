SELECT
  Departments.Name,
  send.Name
FROM
  Departments,
  Employees send
WHERE
  (
    Departments.DepartmentID = send.DepartmentID
  ) AND(
    send.DepartmentID !=(
    SELECT
      boss.EmployeeID
    FROM
      Employees boss
    WHERE
      send.BossID = boss.EmployeeID
  )
  )
ORDER BY
  Departments.Name ASC
