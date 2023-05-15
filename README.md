# Enoca Backend Developer Case

This project is for the company and its employees; it offers adding, deleting, listing, updating operations.


## Tech Stack
Java17, Spring Boot, MySQL, Lombok

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
  GET http://localhost:8080/api/v1/company/get-all-company
```

| Parameter | Type  | Description  |
| :-------- |:------|:-------------|
| `page`    | `int` | Page Number. |
| `size`    | `int` | Data Number. |

```
KEY = size
KEY = page
```

#### Save Employee

```http
  POST http://localhost:8080/api/v1/employee
```

| Parameter         | Type     | Description         |
|:------------------|:---------|:--------------------|
| `employeeName`    | `string` | Employee name.      |
| `employeeLastName`| `string` | Employee last name. |
| `company`         | `company`| Company name.       |

```
{
    "employeeName" : "",
    "employeeLastName" : "",
    "company" : ""
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
  GET http://localhost:8080/api/v1/employee/get-all-employee
```

| Parameter | Type  | Description  |
| :-------- |:------|:-------------|
| `page` | `int`    | Page Number. |
| `size` | `int`    | Data Number. |

```
KEY = size
KEY = page
```

