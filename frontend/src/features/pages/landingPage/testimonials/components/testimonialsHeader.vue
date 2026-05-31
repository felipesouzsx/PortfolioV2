<script setup lang="ts">
import SectionTitle from '@/features/common/sectionTitle/sectionTitle.vue'
</script>

<template>
  <header>
    <SectionTitle checkerboard="hidden">TESTIMONIALS</SectionTitle>
    <img src="/assets/landingPage/largeHorizontalCheckerboard.svg" alt="" />
  </header>
</template>

<style scoped>
header {
  place-self: center;
  width: min-content;
  height: 100%;

  display: flex;
  flex-direction: column;
  justify-content: center;
}

img {
  width: 100%;
}
</style>
