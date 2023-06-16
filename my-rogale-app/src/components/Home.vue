/* eslint-disable */
<template>
  <div class="home">
    <h1>Witaj w świecie Rogali Świętomarcińskich!</h1>
    <p>
      Rogale Świętomarcińskie to tradycyjne, pyszne ciastka, które swoją
      popularność zawdzięczają obchodom Dnia Świętego Marcina. Są wspaniałym
      dodatkiem do kawy lub herbaty, a ich wyjątkowy smak sprawia, że każdy
      chce spróbować jeszcze jednego!
    </p>
    <img
        src="https://example.com/path-to-rogale-image.jpg"
        alt="Rogale Świętomarcińskie"
    />
    <div class="cta-container">
      <button @click="redirectToRegister">Zarejestruj się</button>
      <button @click="redirectToLogin">Zaloguj się</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  methods: {
    redirectToRegister() {
      this.$router.push('/register');
    },
    redirectToLogin() {
      this.$router.push('/login');
    },
  },
};
</script>

<style scoped>
.home {
  text-align: center;
  font-family: Arial, sans-serif;
}

h1 {
  color: #4a4a4a;
}

p {
  font-size: 1.1rem;
}

img {
  max-width: 100%;
  height: auto;
  display: block;
  margin: 0 auto;
}

.cta-container {
  display: flex;
  justify-content: center;
  margin-top: 2rem;
}

button {
  background-color: #4a4a4a;
  color: #ffffff;
  border: none;
  border-radius: 5px;
  font-size: 1.1rem;
  padding: 0.5rem 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button:hover {
  background-color: #3a3a3a;
}

button:not(:last-child) {
  margin-right: 1rem;
}
</style>
