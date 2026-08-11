<script setup lang="ts">
import SectionTitle from '@/views/common/sectionTitle/sectionTitle.vue';
</script>

<template>
  <header>
    <p>
      &gt Many projects, many lessons. <br />
      &gt Here are the ones I value most:
    </p>
    <SectionTitle flip="true" checkerboard="right">HIGHLIGHTS</SectionTitle>
  </header>
</template>

<style scoped>
header {
  display: flex;
  align-items: center;
  height: 100%;

  flex-wrap: wrap-reverse;
  justify-content: space-between;
}
p {
  width: fit-content;
}

@media only screen and (max-width: 1000px) {
  header {
    --margin: 1rem;
    margin-top: var(--margin);
    margin-bottom: var(--margin);
  }
}
</style>
