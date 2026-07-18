<script setup lang="ts">
import SectionTitle from '@/view/common/sectionTitle/sectionTitle.vue'
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
</style>
