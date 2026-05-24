<script setup lang="ts">
import SectionTitle from '@/features/common/sectionTitle/sectionTitle.vue'
</script>

<template>
  <header>
    <SectionTitle checkerboard="left">CONTACT</SectionTitle>
    <p>Let's build something amazing &lt</p>
  </header>
</template>

<style scoped>
header {
  display: flex;
  align-items: center;
  width: 100%;
  gap: 1rem;

  flex-wrap: wrap-reverse;
  justify-content: space-between;
}
p {
  width: fit-content;
}
</style>
