SELECT Name
FROM Employees send
WHERE Salary >

	(SELECT Salary
     FROM Employees boss
     WHERE boss.EmployeeID = send.BossID)
	 