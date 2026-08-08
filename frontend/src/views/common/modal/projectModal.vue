<script setup lang="ts">
import sectionTitle from '../sectionTitle/sectionTitle.vue';
import type ProjectModel from '@/models/ProjectModel.ts';

const props = defineProps<{
  project_data: ProjectModel;
}>();
</script>

<template>
  <div id="project-modal-container" v-if="props.project_data.name">
    <img
      :src="`https://images.felipemontsouza.com/${props.project_data.name}/hero.png`"
      :alt="props.project_data.name + 'logo'"
    />

    <sectionTitle checkerboard="left">{{ props.project_data.name.toUpperCase() }}</sectionTitle>

    <p>
      {{ props.project_data.description }}
    </p>

    <sectionTitle checkerboard="left">ASSETS</sectionTitle>
  </div>
</template>

<style scoped>
#project-modal-container {
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

img {
  display: block;
  margin: 0 auto;
  width: 100%;
}
</style>
