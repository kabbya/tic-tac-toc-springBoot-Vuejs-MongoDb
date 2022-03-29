
# Tic-Tac-Toe

I have created a game, named tic-tac-toe, a full stack REST API web application using SpringBoot int the Backend, Vue.js in theFrontend and MongoDB to store the game history. Tic-tac-toe is a game in which two players take turns in drawing either an ' O' or an ' X' in one square of the empty squares. The winner is the first player to get three of the same symbols in a row, column or diagonally.
 
## 🔗 Live Porject Link

The game is hosted at Heroku. You can play this game going to this link:
[Play Tic-Tac-Toe](https://tic-tac-toe-kabbya.herokuapp.com)

# Tech Stack
- **Backend**: 
    - Java 11
    - Spring Boot 2.6.3
    - Maven 3.8.1

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

# Screenshots

Game Board of match in progess

<img src="https://github.com/kabbya/tic-tac-toc-springBoot-Vuejs-MongoDb/blob/main/ScreenShots/matchInProgess.PNG">

Game Board after the game ends

<img src="https://github.com/kabbya/tic-tac-toc-springBoot-Vuejs-MongoDb/blob/main/ScreenShots/winning.png">


# Project Setup

**Spring boot dependencies**: Going to the [spring initializr](https://start.spring.io/), add the following dependencies and create project:

- Spring Web (Web) 
- Lombok (Developer Tools) 
- Spring Data MongoDB (NoSQL)

**Vue js dependencies**: We have to add bootstrap and Axios using these commands:
- npm install bootstrap --save
- npm add axios  

# APIs

Here's the APIs need to be provided

Methods	   |   Urls           |	  Actions        
:--------: | :-------------:  |  :-------------:
POST	   | http://localhost:8080/api/game |  calculates game result | 
GET	       | http://localhost:8080/api/game |  shows game statistics  | 

JSON Data:

<img src="https://github.com/kabbya/tic-tac-toc-springBoot-Vuejs-MongoDb/blob/main/ScreenShots/JSONGameData.PNG">

MongoDB Documents

<img src="https://github.com/kabbya/tic-tac-toc-springBoot-Vuejs-MongoDb/blob/main/ScreenShots/MongoDB%20Documents.PNG">

# Future Work

1) Show the game history.
2) As the dimention increases of the board, for n>3, if both player plays optimally, then first player will always win. Hence, with some modified rules, a new game can be introduced - "Reversed Tic-Tac-Toe". 
Here, the player will try not to put three same moves sequentially. If a player draw three moves in a row, column or diagonal then he losses the game. To make the game more interesting, a timer will be added. Based on the total time, the game can be devided into three levels such as easy, medium, hard.