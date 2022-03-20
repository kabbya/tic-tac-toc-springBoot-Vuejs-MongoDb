<template>
  <div class="body-container">
    <div class="header-container">
      <h1>Tic-Tac-Toe</h1>
    </div>

    <!-- :disabled="turn_count == 0" -->
    <div class="main-container">
      <div class="left-container">
        <label for="grid_select"> Choose board size: </label>
        <select
          id="grid_select"
          class="grid-select"
          v-model="grid_size"
          @change="updateGridSize"
        >
          <option
            v-for="option in options"
            :value="option.name"
            :key="option.id"
          >
            {{ option.name }}
          </option>
        </select>
      </div>

      <div class="center-container">
        <div class="turn-title">
          <h5 v-if="turn">X's turn</h5>
          <h5 v-else>O's turn</h5>
        </div>

        <!-- :style="boxConsistentStyle" -->
        <div v-if="grid_size >= 3 && grid_size <= 12" class="container-fluid">
          <div class="play-area">
            <div class="test-dummy" v-for="row in grid_size" :key="row">
              <div class="test-dummy" v-for="col in grid_size" :key="col">
                <div class="block" @click="draw(col - 1, row - 1)">
                  <div
                    v-if="isWinningBlock(col - 1, row - 1)"
                    class="blockWinning"
                  >
                    {{ content[(col - 1) * grid_size + (row - 1)] }}
                  </div>
                  <div v-else>
                    {{ content[(col - 1) * grid_size + (row - 1)] }}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div v-else>Minimum Grid Size is 3. Maximum Grid Size is 12.</div>
      </div>

      <div class="right-container">
        <label for="game-status"> Status: </label>
        <div v-if="turn_count" class="game-status" id="game-status">
          <p v-if="game_status == 1">X Wins</p>
          <p v-else-if="game_status == 2">O Wins</p>
          <p v-else-if="game_status == 3">Draw</p>
          <p v-else>Match in progess</p>
        </div>
      </div>
    </div>

    <div class="footer-container">
      <div class="mt-2">
        <button :disabled="isDisabled" v-on:click="submit()">Submit</button>
        <button class="ms-3" @click="reloadPage">New Game</button>
      </div>
    </div>
  </div>
</template>

<script>
import GameService from "../services/game.service";

export default {
  name: "board",

  data() {
    return {
      grid_size: 3,
      board_size: 9,
      content: new Array(this.board_size),
      winningMoves: [],
      options: [
        { id: 3, name: "3" },
        { id: 4, name: "4" },
        { id: 5, name: "5" },
        { id: 6, name: "6" },
        { id: 7, name: "7" },
        { id: 8, name: "8" },
        { id: 9, name: "9" },
        { id: 10, name: "10" },
        { id: 11, name: "11" },
        { id: 12, name: "12" },
      ],

      turn: true,
      turn_count: 0,
      game_status: 4,
      move_sound:
        "https://soundbible.com/mp3/Mouse%20Double%20Click-SoundBible.com-1373842393.mp3",
      submit_sound:
        "https://soundbible.com/mp3/Mouse Double Click 3-SoundBible.com-759327266.mp3",

      game: {
        gridSize: 3,
        moves: [
          {
            moveSerial: 0,
            x: 3,
            y: 3,
            value: "X",
            isHighlighted: false,
          },
        ],
      },
    };
  },

  computed: {
    isDisabled() {
      // you can  check your form is filled or not here.
      return this.turn_count == 0 || this.game_status != 4;
    },
    boxConsistentStyle() {
      return {
        background: "red",
      };
    },
  },

  methods: {
    setValue() {
      this.game.moves.splice(0);
      this.game.gridSize = this.grid_size;
      this.board_size = this.grid_size * this.grid_size;
      this.winningMoves = [];
      this.content = new Array(this.board_size);
      this.turn_count = 0;
      this.turn = true;
      this.game_status = 4;
      this.game.moves.push({
        moveSerial: 0,
        x: this.grid_size,
        y: this.grid_size,
        isHighlighted: false,
        value: "X",
      });
    },

    reloadPage() {
      this.setValue();
    },

    isWinningBlock(click_x, click_y) {
      this.cur_index = click_x * this.grid_size + click_y;
      return this.winningMoves.includes(this.cur_index);
    },

    submit() {
      var audio = new Audio(this.submit_sound);
      audio.play();
      GameService.addGame(this.game)
        .then((response) => {
          this.game_status = response.data.gameVerdict;
          this.moves = response.data.moves;
          for (var i = 0; i < this.moves.length; i++) {
            if (this.moves[i].highlighted) {
              this.cur_index =
                this.moves[i].x * this.grid_size + this.moves[i].y;
              this.winningMoves.push(this.cur_index);
            }
          }
       })
        .catch((e) => {
          console.log(e);
        });
    },

    updateGridSize(event) {
      this.grid_size = parseInt(event.target.value);
      this.setValue();
    },

    draw(click_x, click_y) {
      this.cur_index = click_x * this.grid_size + click_y;
      if (this.content[this.cur_index] != null) {
        // do nothing
      } else {
        var audio = new Audio(this.move_sound);
        audio.play();
        if (this.turn) {
          this.content[this.cur_index] = "X";
        } else {
          this.content[this.cur_index] = "O";
        }
        this.turn_count++;
        this.game.moves.push({
          moveSerial: this.turn_count,
          x: click_x,
          y: click_y,
          isHighlighted: false,
          value: this.content[this.cur_index],
        });

        this.turn = !this.turn;
      }
    },

  },
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Varela+Round&display=swap");

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Varela Round", sans-serif;
}

.container-fluid {
  width: fit-content;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.turn-title {
  margin: 0;
  display: flex;
  justify-content: center;
}

.turn-title h5 {
  margin: 10px 0 0 0;
  padding: 5px 0;
  width: 500px;
  border-radius: 5px 5px 0 0;
  background: orange;
}

.play-area {
  display: flex;
  align-items: stretch;
  justify-content: stretch;
  flex-direction: column;
  background: #ffc300;
  width: 500px;
  height: 500px;
}

.block {
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 100%;
  font-weight: bold;
  border: 1px solid black;
  transition: background 0.2s ease-in-out;
  height: 100%;
  width: 100%;
}

.test-dummy {
  display: flex;
  height: 100%;
  width: 100%;
}

.block:hover {
  cursor: pointer;
  background: orange;
}

.occupied:hover {
  background: #ff3a3a;
}

.blockWinning {
  background: red;
}

.win:hover {
  background: #0ff30f;
}

#block_0,
#block_1,
#block_2 {
  border-top: none;
}

#block_0,
#block_3,
#block_6 {
  border-left: none;
}

#block_6,
#block_7,
#block_8 {
  border-bottom: none;
}

#block_2,
#block_5,
#block_8 {
  border-right: none;
}

button {
  outline: none;
  border: 4px solid green;
  padding: 10px 20px;
  font-size: 1rem;
  font-weight: bold;
  background: none;
  transition: all 0.2s ease-in-out;
}

button:hover {
  cursor: pointer;
  background: green;
  color: white;
}

.playerWin {
  color: green;
}

.computerWin {
  color: red;
}

.draw {
  color: orangered;
}

.grid-select {
  padding: 5px;
  width: 100px;
  text-align: center;
  margin-left: 5px;
  border-radius: 10px 10px 0 0;
}

.body-container {
  display: flex;
  flex-direction: column;
}

.header-container {
  background: #ff3a3a;
}

.header-container > * {
  margin: 0;
}

.main-container {
  display: flex;
  justify-self: stretch;
  justify-content: space-around;
}

.center-container {
  display: flex;
  flex-direction: column;
  justify-self: stretch;
}

.left-container,
.right-container {
  width: 300px;
  padding-top: 5px;
}

.right-container {
  display: flex;
  flex-direction: column;
}

.right-container label {
  text-align: left;
}

.game-status p {
  text-align: left;
  font-size: 2.5vw;
}
</style>