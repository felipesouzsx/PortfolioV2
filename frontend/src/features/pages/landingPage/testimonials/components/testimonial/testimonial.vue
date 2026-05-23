<script setup lang="ts">
import Card from '@/features/common/card/card.vue'
</script>

<template>
  <Card>
    <header>
      <img src="/assets/landingPage/profilePicturePlaceholder.svg" alt="" />
      <div>
        <h1>JOHN DOE</h1>
        <h2>Role @Studio</h2>
      </div>
    </header>
    <p>
      Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has
      been the industry's standard dummy text ever since the 1500s.
    </p>
  </Card>
</template>

<style scoped>
.card {
  width: calc((100% - var(--gap) * 2 - var(--card-padding) * 6) / 3);
}

header {
  display: flex;
  justify-content: space-between;
}

h1,
h2 {
  margin: 0;
}

h1 {
  font-size: 2rem;
}

h2 {
  font-size: 1rem;
  text-align: end;
  font-weight: 100;
  opacity: 50%;
}

@media screen and (max-width: 1000px) {
  .card {
    width: 100%;
  }
}
</style>
