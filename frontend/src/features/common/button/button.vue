<script setup lang="ts">
const props = defineProps(['text'])
</script>

<template>
  <button>
    <slot></slot>
  </button>
</template>

<style scoped>
@import url('./button.css');
</style>
