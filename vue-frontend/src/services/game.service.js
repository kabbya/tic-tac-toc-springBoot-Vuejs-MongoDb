import axios from 'axios';
const API_URL = 'http://localhost:8080/api/';

class GameService{

    addGame(game){
        return axios.post(API_URL + `game`, game);  
    }

}

export default new GameService();