<script setup lang="ts">
import Card from '@/view/common/card/card.vue'
</script>

<template>
  <Card class="closed">
    <h1>working for:</h1>
    <ul>
      <li>XP GAMES</li>
      <li>ETERNAL CREATIONS</li>
    </ul>
    <p id="not-seeking">Not seeking another team<br />right now</p>
  </Card>
</template>

<style scoped>
@import url('./statusCard.css');

#not-seeking {
  font-weight: 100;
  font-size: 1rem;
  opacity: 50%;
  margin: 0;
  margin-top: 1rem;
}

ul {
  list-style: none;
  padding: 0;
  font-size: 2rem;
  font-weight: 500;
  margin: 0;
}
</style>
