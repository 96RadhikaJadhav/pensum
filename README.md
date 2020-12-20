# Pensum

**Manage your life with Pensum!**

*Copyright © 2020 Marcus Fihlon*

## License

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

## Running and debugging the application

### Environment variables
To run the application, you need to specify a database (which must exist, but may be empty) using environment variables like in this example:

```
PENSUM_DATASOURCE_URL=jdbc:mysql://localhost:3306/pensum_dev
PENSUM_DATASOURCE_USERNAME=dbuser
PENSUM_DATASOURCE_PASSWORD=dbpassword
```

Adjust the content of the environment variables as necessary. Supported database types are: `mysql`

### Running the application from the command line.
To run from the command line, use `mvn` and open http://localhost:8080 in your browser.

### Running and debugging the application in Intellij IDEA
- Locate the Application.java class in the Project view. It is in the src folder, under the main package's root.
- Right click on the Application class
- Select "Debug 'Application.main()'" from the list

After the application has started, you can view your it at http://localhost:8080/ in your browser. 
You can now also attach break points in code for debugging purposes, by clicking next to a line number in any source file.

### Running and debugging the application in Eclipse
- Locate the Application.java class in the Package explorer. It is in `src/main/java`, under the main package.
- Right click on the file and select `Debug As` --> `Java Application`.

Do not worry if the debugger breaks at a `SilentExitException`. This is a Spring Boot feature and happens on every startup.

After the application has started, you can view your it at http://localhost:8080/ in your browser.
You can now also attach break points in code for debugging purposes, by clicking next to a line number in any source file.
## Project structure

- `MainView.java` in `src/main/java` contains the navigation setup. It uses [App Layout](https://vaadin.com/components/vaadin-app-layout).
- `views` package in `src/main/java` contains the server-side Java views of the application.
- `views` folder in `frontend/src/` contains the client-side JavaScript views of the application.

## Deploying using Docker

To build the Dockerized version of the project, run

```
docker build . -t pensum:latest
```

Once the Docker image is correctly built, you can test it locally using

```
docker run -p 8080:8080 pensum:latest
```
