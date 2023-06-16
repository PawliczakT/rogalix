/* eslint-disable */
<template>
  <div>
    <h2>Dodaj nowy rogalik</h2>
    <form @submit.prevent="submitRogal">
      <div>
        <label for="name">Nazwa:</label>
        <input id="name" type="text" v-model="rogal.name" required />
      </div>
      <div>
        <label for="description">Opis:</label>
        <textarea id="description" v-model="rogal.description" required></textarea>
      </div>
      <div>
        <button type="submit">Dodaj rogalika</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      rogal: {
        name: '',
        description: '',
      },
    };
  },
  methods: {
    async submitRogal() {
      try {
        const response = await axios.post('/api/rogale', this.rogal);
        console.log('Rogalik dodany pomyślnie:', response.data);
        this.$emit('rogalAdded', response.data);
        this.rogal.name = '';
        this.rogal.description = '';
      } catch (error) {
        console.error('Błąd podczas dodawania rogalika:', error);
      }
    },
  },
};
</script>
