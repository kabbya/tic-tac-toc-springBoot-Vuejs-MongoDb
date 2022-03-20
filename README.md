
# Tic-Tac-Toe

Tic-tac-toe is a game in which two players take turns in drawing either an ' O' or an ' X' in one square of the empty squares. The winner is the first player to get three of the same symbols in a row, column or diagonally. I have created the game tic-tac-toe, a full stack REST API web application using SpringBoot int the Backend, Vue.js in theFrontend and MongoDB to store the game history. 
 
## 🔗 Live Porject Link

The game is hosted at Heroku. You can play this game going to this link:
[Play Tic-Tac-Toe](https://tic-tac-toe-kabbya.herokuapp.com)

# Tech Stack
- **Backend**: 
    - Java 11
    - Spring Boot 2.6.3 with 
        - Spring Web

- **Frontend**: 
    - vue 3
    - axios: 0.21.1
    - bootstrap 5

- **Database**
    - MongoDB

# Project Description

This game is played between two players from the same end-point. The most exciting aspect of this project is, you can play this game in bigger grid sized board. Here you can choose the board size of n*n ( 3 <= n <= 12). In the bigger board size as well one who will able to place three moves in a row, column or diagonally, will win the match. However, if both players able to place three moves one after another, the one who succesfully do it, will be chooses as the winner.

After giving moves alternatively you have to click the 'Submit' button. Player's moves are sent as commands from the frontend to the backend for evaluation as a single chunk using the POST method. You will have one of these four types of verdict.
- X Wins: Game ends and X succesfully placed three moves one after another
- O Wins: Game ends and X succesfully placed three moves one after another
- Draw: Game ends and No one able to placed three moves one after another
- Match in progress: Game continuese, more move possible.

After clicking on the 'New Game' button, a new board will be appeared.

# Feactures

- User login, logout, Registraion
- Password Create, Search, Update, Delete
- Role based Authentication

# Frontend Setup 

- npm install vue-router@4
- npm install vuex@4
- npm install vee-validate@4 yup
- npm install axios
- npm install bootstrap --save
- npm install @fortawesome/fontawesome-svg-core @fortawesome/free-solid-svg-icons @fortawesome/vue-fontawesome@prerelease

# APIs

These are APIs that we need to provide. Testing with Postman:

Methods	   |   Urls           |	  Actions        | Body |
:--------: | :-------------:  |  :-------------: | :-------------:
POST	   | /api/auth/signup |  signup new account|{"username":"tester02","email":"tester02@gmail.com","password":"tester02"}
POST	   | /api/auth/signin |  login an account  | {"username":"tester02","password":"tester02"} |
GET	       | /api/test/all	  |  retrieve public content|
GET        | /api/test/passwords/user/{user_id} | retrive all passwords of an user|  |
GET        | /api/test/passwords/user/{user_id} | search password of an user| {"siteName":"abc"} |
POST |  /api/test/passwords/{user_id} | create new password | {"siteName":"github", "siteUserName":"tester02@gmail.com", "sitePassword":"12345"} |
GET | /api/test/passwords/password_id} | get password id |  |
PUT | /api/test/passwords/{user_id}/{password_id}  | update password id | {"siteName": "abc update","sitePassword": "update Password","siteUserName": "update@gmail.com"}|
DELETE |  /api/test/passwords/{passwor_id} | delete password | |

## Tech Stack

**Client:** React, Redux, TailwindCSS

**Server:** Node, Express

