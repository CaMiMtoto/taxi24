# Taxi24

Taxi24 is a new startup based in Kigali. They would like to disrupt the taxi industry in Rwanda by providing a
white-label solution to the existing taxi companies and hotels. Practically, they will build a set of APIs that other
companies can use to manage their fleet of drivers and allocate drivers to passengers.

#### Get a list of all

##### DRIVERS:

* Get a list of all available drivers
* Get a list of all available drivers within 3km for a specific location
* Get a specific driver by ID

##### TRIPS:

* Create a new ‘Trip’ request by assigning a driver to a rider
* Complete a trip
* Get a list of all active Trips

##### RIDERS:

* Get a list of all riders
* Get a specific rider by ID
* For a specific driver, get a list of the 3 closest drivers

## Prerequisite

* Java >=8
* PostgresSQL

## Getting Started

* Clone the repository from [https://github.com/CaMiMtoto/taxi24.git](https://github.com/CaMiMtoto/taxi24.git)
* cd into the directory and open in intellij
* Change the `application.properties` file to point to your database
* Run the application by clicking on the `play` green button
* Open the application in your browser: [http://localhost:8080/](http://localhost:8080/)
* You can now see the application in action

## API Functionalities

[//]: # (draw table of two columns)

| EndPoint                                                                                 | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
|------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `GET` `/api/v1/drivers`                                                                  | Get a list of all drivers                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| `GET` `/api/v1/drivers/available`                                                        | Get a list of all available drivers                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| `GET`  `/api/v1/drivers/available/in-range?lat={latitude}&lng={longitude}&range={range}` | Get a list of all drivers within 3km for a specific location `{range} in this example is 3 whereas latitude and longitude are the starting point`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| `GET`  `/api/v1/drivers/{id}`                                                            | Get a specific driver by ID                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| `POST`  `/api/v1/trips`                                                                  | Create a new ‘Trip’ request by assigning a driver to a rider <br/>  `{sourceLatitude,sourceLongitude,destinationLatitude,destinationLongitude,driverId,riderId}` <br/><br/> example code: <br/> <pre> var axios = require('axios');<br/> var qs = require('qs'); <br/>var data = qs.stringify({ 'sourceLatitude': '-1.9', 'sourceLongitude': '30', 'destinationLatitude': '-1.983', 'destinationLongitude': '30.8983', 'driverId': '1', 'riderId': '1' });<br/> var config = { method: 'post', url: 'http://localhost:8080/api/v1/trips', headers: { 'Accept': 'application/json', 'Content-Type': 'application/x-www-form-urlencoded', 'Cookie': 'JSESSIONID=9ED528FACB65F7C44E8FF770FA0C23C2' }, data : data };<br/> axios(config)<br/> .then(function (response) {<br/> console.log(JSON.stringify(response.data)); }) <br/>.catch(function (error) { console.log(error); }); </pre> |
| `PUT` `/api/v1/trips/{id}/complete`                                                      | Complete a trip                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| `GET` `/api/v1/trips/active`                                                             | Get a list of all active Trips                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| `GET` `/api/v1/riders`                                                                   | Get a list of all riders                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| `GET` `/api/v1/riders/{id}`                                                              | Get a specific rider by ID                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| `GET` `/api/v1/riders/closest-drivers?lat={latitude}&lng={longitude}`                                                              | For a specific driver, get a list of the 3 closest drivers                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |




### You can find the finished project [http://taxi.codewithcami.xyz/](http://taxi.codewithcami.xyz/)




