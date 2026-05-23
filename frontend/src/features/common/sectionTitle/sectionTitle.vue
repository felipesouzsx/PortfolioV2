<script setup lang="ts">
const { checkerboard = 'hidden' } = defineProps<{ checkerboard?: string }>()
console.log(checkerboard)
</script>

<template>
  <div id="container" :class="{ flip: checkerboard == 'right' }">
    <img
      :class="{ hidden: checkerboard == 'hidden' }"
      src="/assets/common/whiteCheckerboardSmall.svg"
      alt=""
    />
    <h1>
      <slot></slot>
    </h1>
  </div>
</template>

<style scoped>
@import url('./sectionTitle.css');
</style>
