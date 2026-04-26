<script setup lang="ts">
import SectionTitle from '@/features/common/sectionTitle/sectionTitle.vue'
</script>

<template>
  <header>
    <p>
      > Many projects, many lessons. <br />
      > Here are the ones I value most:
    </p>
    <SectionTitle flip="true">HIGHLIGHTS</SectionTitle>
  </header>
</template>

<style scoped>
header {
  display: flex;
  align-items: center;
  width: 100%;
  gap: 1rem;

  --margin: 2rem;
  margin-top: var(--margin);
  margin-bottom: var(--margin);

  flex-wrap: wrap-reverse;
  justify-content: space-between;
}
p {
  width: fit-content;
}
</style>
