# Springboot - GraphQL
To access the application using GraphQL
Certainly! Here are the Postman setups for all the cases based on your GraphQL schema:
Fetching All Books:
Method: POST
URL: http://localhost:8080/graphql
Headers:
Key: Content-Type
Value: application/json
Body:
Type: GraphQL
Query:
graphql
{
  allBooks {
    id
    bookName
    authorName
    authorId
  }
}


Fetching a Single Book by ID:
Method: POST
URL: http://localhost:8080/graphql
Headers:
Key: Content-Type
Value: application/json
Body:
Type: GraphQL
Query:
graphql
query getBook($id: ID!) {
  getBook(id: $id) {
    id
    bookName
    authorName
    authorId
  }
}

Variables:
json
{
  "id": "1"
}


Creating a New Book:
Method: POST
URL: http://localhost:8080/graphql
Headers:
Key: Content-Type
Value: application/json
Body:
Type: GraphQL
Query:
graphql
mutation createBook($input: BookInput!) {
  createBook(input: $input) {
    id
    bookName
    authorName
    authorId
  }
}

Variables:
json
{
  "input": {
    "bookName": "New Book Title",
    "authorName": "New Author Name",
    "authorId": "New Author ID"
  }
}


Updating an Existing Book:
Method: POST
URL: http://localhost:8080/graphql
Headers:
Key: Content-Type
Value: application/json
Body:
Type: GraphQL
Query:
graphql
mutation updateBook($id: ID!, $input: BookInput!) {
  updateBook(id: $id, input: $input) {
    id
    bookName
    authorName
    authorId
  }
}

Variables:
json
{
  "id": "1",
  "input": {
    "bookName": "Updated Book Title",
    "authorName": "Updated Author Name",
    "authorId": "Updated Author ID"
  }
}


Deleting a Book:
Method: POST
URL: http://localhost:8080/graphql
Headers:
Key: Content-Type
Value: application/json
Body:
Type: GraphQL
Query:
graphql
mutation deleteBook($id: ID!) {
  deleteBook(id: $id)
}

Variables:
json
{
  "id": "1"
}


Remember to adjust the id, input values, and the endpoint URL as necessary to match the data in your system. If authentication is required, ensure to include the appropriate headers (like Authorization: Bearer <your_token>).
To execute any of these operations, paste the query into the GraphQL body section in Postman, set the variables if needed, and hit the Send button to make the request. The response will be displayed below the
request setup.

