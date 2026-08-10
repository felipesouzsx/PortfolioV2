<script setup lang="ts">
import type AssetModel from '@/models/AssetModel';

const props = defineProps<{
  projectName: string;
  asset: AssetModel;
}>();
const baseUrl = 'https://images.felipemontsouza.com';
</script>

<template>
  <div id="container">
    <img :src="`${baseUrl}/${projectName}/${asset.id}`" alt="" />
    <div id="description-container" v-if="asset.description">
      <p>{{ asset.description }}</p>
    </div>
  </div>
</template>

<style scoped>
#container {
  position: relative;
  height: 100%;
  width: 100%;
  aspect-ratio: 1/1;
}

#description-container {
  position: absolute;
  bottom: 0;
  right: 0;
  left: 0;

  box-sizing: border-box;

  background-color: rgba(0, 0, 0, 0.32);
  backdrop-filter: blur(10px);
  padding: 0.25rem 1rem 0.25rem 1rem;
}

img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

p {
  text-align: center;
}
</style>
