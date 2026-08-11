<script setup lang="ts">
import Asset from '../asset/asset.vue';
import sectionTitle from '../sectionTitle/sectionTitle.vue';
import type ProjectModel from '@/models/ProjectModel.ts';

const props = defineProps<{
  project_data: ProjectModel;
}>();
console.log(props.project_data.assets);
</script>

<template>
  <div id="project-modal-container" v-if="props.project_data.name">
    <img
      id="project-hero"
      :src="`https://images.felipemontsouza.com/${props.project_data.name}/hero.png`"
      :alt="props.project_data.name + 'logo'"
    />

    <div id="project-info">
      <sectionTitle checkerboard="left">{{ props.project_data.name.toUpperCase() }}</sectionTitle>
      <p>
        by <strong>{{ props.project_data.publisher.toUpperCase() }}</strong>
      </p>
    </div>

    <p>
      {{ props.project_data.description }}
    </p>

    <sectionTitle checkerboard="left">ASSETS</sectionTitle>

    <div id="asset-container">
      <Asset
        v-for="asset in props.project_data.assets"
        :project-name="project_data.name"
        :asset="asset"
      ></Asset>
    </div>
  </div>
</template>

<style scoped>
#project-modal-container {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

#project-info {
  display: flex;
  gap: 2rem;
  justify-content: space-between;
}

#project-info > p {
  width: fit-content;
  place-self: center;
  font-weight: lighter;
  opacity: 0.75;
}

#asset-container {
  display: flex;
  gap: 1rem;
}

#project-hero {
  display: block;
  margin: 0 auto;
  width: 100%;
}
</style>
