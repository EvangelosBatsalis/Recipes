
# Recipes:
"Recipes" is a graduation application project from Hyperskill academy "Java project" from "Backend Development Track"

### About:
An urge to cook something special is too hard to resist sometimes. But what if you lost the recipe? Or your beloved grandma is too busy to answer a call and remind you of your favorite cake recipe? Let's make a program that stores all recipes in one place. Create a multi-user web service with Spring Boot that allows storing, retrieving, updating, and deleting recipes.
### Learning outcomes:
Get to know the backend development. Use Spring Boot to complete this project. Learn about JSON, REST API, Spring Boot Security, H2 database, LocalDateTime, Project Lombok, and other concepts useful for the backend.
### Learning outcomes
Get to know the backend development. Use Spring Boot to complete this project. Learn about JSON, REST API, Spring Boot Security, H2 database, LocalDateTime, Project Lombok, and other concepts useful for the backend.

### What you’ll do and what you’ll learn
    1. Stage 1/5: First recipe: Implement a simple JSON API that supports adding and retrieving a recipe.
    2. Stage 2/5: Multiple recipes: Improve the web service to support multiple recipes.
    3. Stage 3/5: Store a recipe: Add a database to store and delete recipes.
    4. Stage 4/5: Sort & update: Retrieve recipes by their category/name and update them if you need to.
    5. Stage 5/5: More chefs to the table: Improve the web service to support multiple recipes.

### Frameworks and technologies Deployed
- Spring Boot Starter, Spring Boot JPA, Spring Boot JDBC, Spring MVC, Spring Boot Security
- Gradle
- JPA/Hibernate
- H2/SQL
- IntelliJ (IDE)

# REST API
### Register user
#### Request:
```
POST /api/register
```
```
  {
      "email": "test123ewf@mail.ru",
      "password": "qwerty123"
  }
```

### Response:
User is validated. If user registered HTTP status 200 OK returned. If user does not match contraints or already exists HTTP 400 (BAD REQUEST) returned.

# Recipes API (available only for logged in users)
### Create new Recipe
#### Request:
```
POST /api/recipe
```
```
  {
      "name": "first recipe",
      "category": "category",
      "description": "recipe description",
      "ingredients": ["first ingredient", "second ingredient", "3rd ingredient"],
      "directions": ["add solt", "add milk"]
  }
```
### Response:
Recipe is validated. If user is not logged in, 403 (Forbidden) returned. If recipe is not valid 400 (Bad request). After recipe creation, its id returned

```
{ "id": 1 }
```

## Get existing recipe
### Request:
```
GET /api/recipe/{id}
```
#### Response:
If recipe not found, HTTP 404 returned.

```
  {
      "name": "first recipe",
      "category": "category",
      "date": "2022-12-22T16:55:10.075253",
      "description": "recipe description",
      "ingredients": [
          "first ingredient",
          "second ingredient",
          "3rd ingredient"
      ],
      "directions": [
          "add solt",
          "add milk"
      ]
  }
```

## Delete recipe
#### Request:
```
DELETE /api/recipe/{id}
```

### Response
If user logged in not the user which created recipe -> HTTP status 403 FORBIDDEN returned. If recipe is not found 404 HTTPS STATUS (NOT FOUND). If recipe successfully removed -> 204 HTTP returned.

### Update recipe
#### Request:
```
PUT /api/recipe/{id}
```
```
  {
      "name": "updated recipe",
      "category": "category",
      "date": "2022-12-22T16:55:10.075253",
      "description": "recipe description",
      "ingredients": [
          "first ingredient",
          "second ingredient",
          "3rd ingredient"
      ],
      "directions": [
          "add solt",
          "add milk"
      ]
  }
```

#### Response:
If recipe does not exist -> HTTP 404 NOT FOUND

If recipe author and user logged in don`t match -> 403 FORBIDDEN

If recipe updated -> 204 NO content.

Get recipe recipe
Request
GET /api/recipe/search @RequestParam(required = false, name = "category") OR @RequestParam(required = false, name = "name")

Response
Return array of recipes found by category or name request param.
