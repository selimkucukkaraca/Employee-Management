# Enoca Backend Developer Case

This project is for the company and its employees; it offers adding, deleting, listing, updating operations.


## Tech Stack
Java17, Spring Boot, MySQL, Lombok, Validation

## API Use Of

#### Save Company

```http
  POST  http://localhost:8080/api/v1/company
```

|  Parameter   | Type     | Description     |
|:-------------|:---------|:----------------|
| `companyName`| `string` | Company Name    |

```
{
    "companyName" : ""
}
```

#### Delete Company

```http
  DELETE  http://localhost:8080/api/v1/company?companyId=
```

|  Parameter  | Type     | Description |
| :---------- |:---------|:------------|
| `companyId` | `string` | Company Id  |

```
  KEY = companyId
```

#### Get All Company

```http
  GET http://localhost:8080/api/v1/company
```

| Parameter | Type  | Description  |
| :-------- |:------|:-------------|
| `size`    | `int` | Data Number. |
| `page`    | `int` | Size Number. |

```
KEY = size
KEY = page
```

#### Update Company

While the company is updating;
First of all, write down the 'companyId' of the company.
Secondly, update the name of the company.

```http
  PUT  http://localhost:8080/api/v1/company
```

|  Parameter   | Type     | Description     |
|:-------------|:---------|:----------------|
| `companyId`  | `string` | Company Id      |
| `companyName`| `string` | Company Name    |


```
{
    "companyId" : "",
    "companyName" : ""
}
```

#### Save Employee

```http
  POST http://localhost:8080/api/v1/employee
```

| Parameter         | Type     | Description         |
|:------------------|:---------|:--------------------|
| `employeeName`    | `string` | Employee name.      |
| `employeeLastName`| `string` | Employee last name. |
| `companyId`       | `string` | Company Id.       |

```
{
    "employeeName" : "",
    "employeeLastName" : "",
    "companyId" : ""
}
```


#### Delete Employee

```http
  DELETE http://localhost:8080/api/v1/employee
```

| Parameter   | Type     | Description |
| :---------- |:---------|:------------|
| `employeeId`| `string` | Employee id |

```
KEY = employeeId
```


#### Get All Employee

```http
  GET http://localhost:8080/api/v1/employee
```

| Parameter | Type  | Description  |
| :-------- |:------|:-------------|
| `size` | `int`    | Data Number. |
| `page` | `int`    | Page Number. |

```
KEY = size
KEY = page
```

#### Update Employee

while the employee is updating;
First of all, type in the employee's 'employeeID'.
Secondly, update the employee's first and last name.

```http
  PUT  http://localhost:8080/api/v1/employee
```

|  Parameter        | Type     | Description       |
|:------------------|:---------|:------------------|
| `employeeName`    | `string` | Employee Name     |
| `employeeLastName`| `string` | Employee Last name|
| `employeeId`      | `string` | Employee Id       |


```
{
    "employeeName" : "",
    "employeeLastName" : "",
    "employeeId" : ""
}
```

