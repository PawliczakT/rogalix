/* eslint-disable */
<template>
  <div>
    <h2>Dodaj ocenę</h2>
    <form @submit.prevent="submitRating">
      <div>
        <label for="pastryId">ID Rogalika:</label>
        <input id="pastryId" type="number" v-model.number="rating.pastryId" required />
      </div>
      <div>
        <label for="score">Ocena (1-5):</label>
        <input id="score" type="number" min="1" max="5" v-model.number="rating.score" required />
      </div>
      <div>
        <button type="submit">Dodaj ocenę</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      rating: {
        pastryId: null,
        score: null,
      },
    };
  },
  methods: {
    async submitRating() {
      try {
        const response = await axios.post('/api/ratings', this.rating);
        console.log('Ocena dodana pomyślnie:', response.data);
        this.$emit('ratingAdded', response.data);
        this.rating.pastryId = null;
        this.rating.score = null;
      } catch (error) {
        console.error('Błąd podczas dodawania oceny:', error);
      }
    },
  },
};
</script>
