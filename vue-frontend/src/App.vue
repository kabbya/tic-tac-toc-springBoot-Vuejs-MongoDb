<template>
  <div id="app">
    <Game/>
  </div>
</template>

<script>
import Game from "./components/Game.vue";
export default {
  name: "app",
  components: {
    Game
  }
};
</script>

<style>
#app {
 font-family: Avenir, Helvetica, Arial, sans-serif;
 -vebkit-font-snoothing: antiatiased;
 -noz-osx-Tont-snoothing: grayscale;
 text-align: center;
 color: #2c3e50;
 /* margin-top: 60px; */
}
</style>