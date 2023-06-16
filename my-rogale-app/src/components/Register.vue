/* eslint-disable */
<template>
  <div class="register">
    <h2>Rejestracja</h2>
    <form @submit.prevent="register">
      <div>
        <label for="username">Nazwa użytkownika</label>
        <input type="text" id="username" v-model="username" required />
      </div>
      <div>
        <label for="password">Hasło</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Zarejestruj</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    async register() {
      try {
        const response = await axios.post("http://localhost:8080/register", {
          username: this.username,
          password: this.password,
        });
        // Zapisz token w stanie Vuex
        this.$store.dispatch("setToken", response.data.token);
        // Przekieruj do strony głównej lub innej strony po pomyślnym zalogowaniu
        this.$router.push("/");

      } catch (error) {
        // Obsługa błędów
      }
    },
  },
};
</script>
