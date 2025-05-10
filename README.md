It seems the environment was reset. You can follow the instructions below to create the `README.md` and zip it yourself:

1. **Create the README.md file**:

   * Open a text editor (e.g., Notepad, Visual Studio Code).
   * Copy the content below into your editor:

````markdown
# BFHL Qualifier Backend & Frontend

This project is part of the BFHL Qualifier, which is a backend and frontend application designed to handle user input and file processing. The backend is built with Spring Boot and the frontend uses simple HTML, CSS, and JavaScript.

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Backend API](#backend-api)
- [Frontend](#frontend)
- [Installation and Setup](#installation-and-setup)
- [How to Run](#how-to-run)
- [Contributing](#contributing)
- [License](#license)

## Project Overview
The project handles the following tasks:
- Accepts user input of numbers and alphabets (comma-separated).
- Processes the input data to:
  - Extract numbers and alphabets.
  - Find the highest lowercase alphabet.
  - Check if any number is prime.
  - Process a file (optional) in Base64 encoding.
- Responds with processed data in JSON format.

## Technologies Used
- **Backend**: 
  - Java
  - Spring Boot
  - Maven

- **Frontend**:
  - HTML
  - CSS
  - JavaScript

- **Others**:
  - GitHub for version control
  - Postman for testing API endpoints

## Backend API

### Endpoints
1. **GET `/bfhl`**: 
   - Returns a basic operation code.

2. **POST `/bfhl`**: 
   - Accepts JSON data with the following fields:
     - `data`: List of data (numbers and alphabets).
     - `file_b64`: Optional Base64 encoded file.
   - Returns JSON response with the following fields:
     - `is_success`: Boolean indicating if the request was successful.
     - `user_id`: A mock user ID.
     - `email`: A mock email.
     - `roll_number`: A mock roll number.
     - `numbers`: Extracted numbers from input.
     - `alphabets`: Extracted alphabets from input.
     - `highest_lowercase_alphabet`: Highest lowercase alphabet found in the input.
     - `is_prime_found`: Boolean indicating if any prime number was found.
     - `file_valid`: Boolean indicating if the file was valid.
     - `file_mime_type`: MIME type of the uploaded file.
     - `file_size_kb`: Size of the file in KB.

## Frontend

### Features:
- A simple form to input comma-separated data and upload an optional file.
- Display the result in a pretty JSON format.

### Technologies:
- Basic HTML structure.
- Styled with CSS.
- JavaScript to handle form submission and fetch data from the backend.

## Installation and Setup

### Backend Setup:
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/bfhl-qualifier.git
   cd bfhl-qualifier
````

2. Install dependencies using Maven:

   ```bash
   mvn clean install
   ```

3. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

4. The backend should now be running on `http://localhost:8080`.

### Frontend Setup:

1. Make sure the backend is running on `http://localhost:8080`.
2. Open the `index.html` file in your browser.
3. The frontend will interact with the backend via the API running on `localhost:8080/bfhl`.

## How to Run

1. Make sure you have both the backend and frontend set up as per the instructions above.
2. Start the backend server with `mvn spring-boot:run`.
3. Open the `index.html` file in a browser to interact with the frontend.
4. Input some comma-separated data and select an optional file to test the application.

## Contributing

Feel free to fork this project and submit pull requests if you'd like to contribute improvements, bug fixes, or other features.

### Steps:

1. Fork the repository.
2. Create a new branch for your changes.
3. Commit your changes.
4. Push your changes to your fork.
5. Open a pull request to the main repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

````

2. **Save this as `README.md`**.

3. **Add the README.md file to your GitHub repository**:
   - In your terminal (from your project directory), run the following commands:
   
```bash
git add README.md
git commit -m "Added README file"
git push origin main
````


