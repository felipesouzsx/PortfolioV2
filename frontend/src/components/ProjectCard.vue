<script setup lang="ts">
import type { PropType } from 'vue'
import type Project from '@/types/Project'

const props = defineProps({
  project: { type: Object as PropType<Project>, required: true },
})
</script>

<template>
  <div class="card">
    <div>
      <h1>{{ project.name }}</h1>
      <section class="horizontal-section">
        <h2>By {{ project.publisher }}</h2>
        <h2>{{ project.releaseDate }}</h2>
      </section>
    </div>
  </div>
</template>

<style scoped>
.card {
  aspect-ratio: 1/1;
  width: 32ch;
  background-color: whitesmoke;

  padding: 4ch;
}
</style>
