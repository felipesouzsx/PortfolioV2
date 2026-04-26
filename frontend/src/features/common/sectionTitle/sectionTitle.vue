<script setup lang="ts">
const props = defineProps(['flip'])
</script>

<template>
  <div id="container" :class="{ flip: props.flip == 'true' }">
    <img src="/assets/common/whiteCheckerboardSmall.svg" alt="" />
    <h1>
      <slot></slot>
    </h1>
  </div>
</template>

<style scoped>
@import url('./sectionTitle.css');
</style>
