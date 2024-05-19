# Dawka Dziecięca REST API

The Dawka Dziecięca REST API is a Java-based web service built using the Javalin library. It serves as the backend component of the Dawka Dziecięca mobile application, handling HTTP requests from the app and performing dosage calculations and medication package information retrieval.

# Key Features:

1. *HTTP Endpoints:*
  - Exposes RESTful endpoints to handle incoming requests from the mobile application.
  - Endpoints are designed to receive data such as age, weight, and medication information.

2. *Dosage Calculation:*
  - Implements dosage calculation logic based on pediatric medication guidelines.
  - Processes input data received from the app to determine the appropriate dosage for the specified age, weight, and medication.

3. *Medication Package Information:*
  - Retrieves data from the local database to provide information about medication packages.
  - Determines the number of packages required based on the calculated dosage and packaging sizes.

# Technology Stack
- **Java**: Programming language used for backend development.
- **Javalin**: Lightweight web framework for building RESTful APIs in Java.
- **JSON**: Data interchange format for communication between the mobile app and the REST API.
