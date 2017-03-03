##Locations project

This project defines one endpoint to get UK addresses by postcode. The information return for this endpoint is a list of addresses (street address and building name).
It uses a third party API (ideal-postcodes.co.uk) to return the information.


- To Build the project and execute unit and integration tests, execute:

_gradle build_

- To run the application, execute:

_gradle bootRun_

- To hit the endpoint, execute:

_curl localhost:8080/postcodes/W6 0LG_
