# Svetsko prvenstvo

This repository contains a web application developed using Spring Boot, React, and Bootstrap frameworks which represent a football world cup website.

## Features

### Entities:

- **Igrac**: id (Unique identifier), ime (textual value, required), prezime (textual value, required), postignutiGolovi (numerical value), reprezentacija (@ManyToOne relationship with Reprezentacija class)
- **Reprezentacija**: id (Unique identifier), naziv (textual value, unique, required), skraceniNaziv(texutal value, unique, required, max length = 3), igraci (@OneToMany relationship with Igrac class)
- **Utakmica**: id (Unique identifier), goloviA (numerical value), goloviB (numerical value), reprezentacijaA (@ManyToOne relationship to Reprezentacija class), reprezentacijaB (@ManyToOne relationship to Reprezentacija class)

### Implemented REST API:

- `GET /api/utakmice` - Fetch all Utakmica entities
- `GET /api/igraci` - Fetch all Igrac entities
- `GET /api/strelci` - Fetch all Igrac entities who scored a goal
- `GET /api/repke` - Fetch all Reprezentacija entities
- `GET /api/utakmice/{id}` - Fetch one Utakmica entity
- `POST /api/utakmice` - Add a new Utakmica
- `PUT /api/utakmice/{id}` - Modify an existing Utakmica entity 
- `PUT /api/utakmice/goala/{id}` - Modify an existing Utakmica entity: add a goal for reprezentacijaA
- `PUT /api/utakmice/goalb/{id}` - Modify an existing Utakmica entity: add a goal for reprezentacijaB
- `DELETE /api/utakmice/{id}` - Delete an existing Utakmica entity 

## Installation

1. Clone this repository to your local machine.
2. Navigate to the backend directory and run the Spring Boot application.
3. Navigate to the frontend directory and run the React application.

## Usage

- **Admins** have access to all functionalities. (TODO)
- **Users** can add new Zadatak. (TODO)
- Only logged-in users have access to the application. Users log in via the login page.

### Admin Credentials:

- **Username**: miroslav
- **Password**: miroslav

### User Credentials:

- **Username**: petar
- **Password**: petar

## Additional Notes

- Ensure that the backend and frontend are both running to access the full functionality of the application.
- Test data for the database is provided along with the solution.
- HTTPS configuration is not required for this project.
