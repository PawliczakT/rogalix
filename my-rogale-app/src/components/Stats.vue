/* eslint-disable */
<template>
  <div>
    <h2>Statystyki rogali</h2>
    <div class="stats-container">
      <div class="all-rogale">
        <h3>Wszystkie rogale</h3>
        <ul>
          <li v-for="rogal in allRogale" :key="rogal.id">
            <h4>{{ rogal.name }}</h4>
            <img :src="rogal.image" alt="Zdjęcie rogalika" />
            <p>Ilość ocen: {{ rogal.ratingsCount }}</p>
            <p>Średnia ocena: {{ rogal.averageRating.toFixed(2) }}</p>
          </li>
        </ul>
      </div>
      <div class="top-rated-rogale">
        <h3>Top 3 rogale</h3>
        <ol>
          <li v-for="rogal in topRatedRogale" :key="rogal.id">
            <h4>{{ rogal.name }}</h4>
            <img :src="rogal.image" alt="Zdjęcie rogalika" />
            <p>Średnia ocena: {{ rogal.averageRating.toFixed(2) }}</p>
          </li>
        </ol>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      allRogale: [],
      topRatedRogale: [],
    };
  },
  async created() {
    try {
      const allRogaleResponse = await axios.get('/api/rogale');
      this.allRogale = allRogaleResponse.data;

      const topRatedRogaleResponse = await axios.get('/api/rogale/top-rated');
      this.topRatedRogale = topRatedRogaleResponse.data;
    } catch (error) {
      console.error('Błąd podczas ładowania statystyk rogali:', error);
    }
  },
};
</script>

<style scoped>
.stats-container {
  display: flex;
  justify-content: space-around;
}
.all-rogale,
.top-rated-rogale {
  width: 45%;
}
img {
  max-width: 100%;
}
</style>
