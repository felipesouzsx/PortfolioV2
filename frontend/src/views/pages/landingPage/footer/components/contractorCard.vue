<script setup lang="ts">
import Card from '@/views/common/card/card.vue';
</script>

<template>
  <Card class="closed">
    <p>working for:</p>
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
  opacity: 50%;
  margin: 0;
  margin-top: 1rem;
}

ul {
  list-style: none;
  padding: 0;
  font-size: var(--h2-font-size);
  font-weight: 500;
  margin: 0;
}
</style>
