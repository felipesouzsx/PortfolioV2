<script setup lang="ts">
import SectionTitle from '@/views/common/sectionTitle/sectionTitle.vue';
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
  height: 100%;

  flex-wrap: wrap;
  justify-content: space-between;
}
p {
  width: fit-content;
}

@media only screen and (max-width: 1000px) {
  header {
    justify-content: center;
    flex: 1;
    margin-bottom: 2rem;
    margin-top: 2rem;
  }
}
</style>
