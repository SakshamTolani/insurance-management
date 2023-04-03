# INSURANCE MANAGEMENT SYSTEM USING SPRING BOOT WITH BASIC AUTH
[Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) is a powerful and flexible toolkit for create Java applications.

[INSURANCE MANAGEMENT SYSTEM](#insurance-management-system-using-spring-boot) can be used by insurance management companies where they can add clients, add insurance policies which has the fields mainly type, dates, amount and client who has bought. Also, claims can be added with the parameters such as dates, status and policy-id which already exists in insurance policies data storage.

**Note: All these features can only be accesed after basic authentication.**

## Requirements
- Java 8
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 Database
- Netbeans
- Postman

## Quick Start

- Fork and Clone the repository using or Download Zip-
```
git clone https://github.com/SakshamTolani/insurance-management or Top Right Corner Code>Local>Download ZIP
```
- Make sure to have Netbeans or any other IDE suitable.
- Open Netbeans, and follow the given commands:
```
File > Import Project > From ZIP...> Select Zip File.
```
- Now, head to InsuranceManagementApplication.java file by:
```
Insurance-Management > Source Packages > com.insurancemanagement > Open InsuranceManagementApplication.java
```
- Right Click in between the opened file and select **Run File**.
- Now the server is ready and running on **PORT 8080**.

## Structure
In a RESTful API, endpoints (URLs) define the structure of the API and how end users access data from our application using the HTTP methods - GET, POST, PUT, DELETE. Endpoints should be logically organized around _collections_ and _elements_, both of which are resources.

In our case, we have three resources `clients`,`insurance policies` & `claims`, so we will use the following URLS - `/api/clients`,`/api/clients/{id}`,`api/policies`, `/api/policies/{id}`, `/api/claims` & `/api/claims/{id}` for collections and elements, respectively:

#### **CLIENTS**
Endpoint |HTTP Method | CRUD Method | Result
-- | -- |-- |--
`api/clients` | GET | READ | Get all Clients
`api/clients/{id}` | GET | READ | Get client by id
`api/clients`| POST | CREATE | Create a new client
`api/clients/{id}` | PUT | UPDATE | Update client profile by id
`api/clients/{id}` | DELETE | DELETE | Delete client by id

#### **INSURANCE POLICIES**
Endpoint |HTTP Method | CRUD Method | Result
-- | -- |-- |--
`api/policies` | GET | READ | Get all Policies
`api/policies/{id}` | GET | READ | Get policy by id
`api/policies`| POST | CREATE | Create a new insurance Policy
`api/policies/{id}` | PUT | UPDATE | Update insurance policy profile by id
`api/policies/{id}` | DELETE | DELETE | Delete policy by id

#### **CLAIMS**
Endpoint |HTTP Method | CRUD Method | Result
-- | -- |-- |--
`api/claims` | GET | READ | Get all Claims
`api/claims/{id}` | GET | READ | Get claim by id
`api/claims`| POST | CREATE | Create a new claim
`api/claims/{id}` | PUT | UPDATE | Update claim profile by id
`api/claims/{id}` | DELETE | DELETE | Delete claim by id

## Use
We can test the API using [Postman](https://www.postman.com/)

Only authenticated user can use the API services, for that reason if we try this:
```
http  http://localhost:8080/api/clients
```
we get:
```
{
    //Empty Object
}
```
Instead, if we try to access with credentials:
- **Username: saksham**
- **Password: password**

In order to use above credentials, steps are given as: 
- Open Postman and enter `http://localhost:8080/api/clients` in the url box.
- Select Authorization and choose Type as **Basic Auth**.
- Enter Username as **saksham**.
- Enter Password as **password**
- Click on **Send**.


The API has some restrictions:
-   The insurance policies are always associated with a client (through client-id).
-   The claims are always associated with a policy (through policy-id).
-   APIs can only be used by [Authenticated Users](#use)
-   The API doesn't allow unauthenticated requests.


### Commands

- CLIENTS

```
Get all clients
http GET http://localhost:8080/api/clients

Get client by client-id
http GET http://localhost:8080/api/clients/{id}

Create a new client
http POST http://localhost:8080/api/clients "name":"Saksham", "dob":"2002-01-16", "address":"Varanasi", "contact":"9452865121", "createdAt":"2023-04-02"

Get Client Details by client-id
http GET http://localhost:8080/api/clients/{id}

Update client profile using client-id
http PUT http://localhost:8080/api/clients/{id}
```

- INSURANCE POLICIES

```
Get all insurance policies
http GET http://localhost:8080/api/policies

Get insurance policy by policy-id
http GET http://localhost:8080/api/policies/{id}

Create a new insurance policy
http POST http://localhost:8080/api/policies "policyType":"monthly","startDate":"2020-04-02", "endDate":"2023-04-02", "coverageAmount":15000, "premium":250, "clientId":1 (Should be the one which exists in client table in the database)

Get insurance policy details by policy-id
http GET http://localhost:8080/api/policies/{id}

Update insurance policy details using policy-id
http PUT http://localhost:8080/api/policies/{id}
```

- CLAIMS

```
Get all claims
http GET http://localhost:8080/api/claims

Get claim by claim-id
http GET http://localhost:8080/api/claims/{id}

Create a new claim
http POST http://localhost:8080/api/claims "description":"Hello WORLD","claimDate":"2023-04-02","claimStatus":"Active","policyId":1 (Should be the one which exists in insurance policies table in the database)

Get claim details by claim-id
http GET http://localhost:8080/api/claims/{id}

Update claim details using claim-id
http PUT http://localhost:8080/api/claims/{id}

```


> Made with ❤️ by Saksham Tolani



[![forthebadge made-with-java](http://ForTheBadge.com/images/badges/made-with-java.svg)](https://www.java.com)  [![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

