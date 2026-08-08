<script setup lang="ts">
import { useProject } from '@/composables/useProject.ts';
import HighlightsHeader from './components/highlightsHeader.vue';
import projectCard from '@/views/common/projectCard/projectCard.vue';
import { onMounted } from 'vue';

const { projects, loading, loadProjects } = useProject();

onMounted(loadProjects);
</script>

<template>
  <section>
    <div class="section-content">
      <HighlightsHeader></HighlightsHeader>

      <div class="projects">
        <projectCard
          v-if="!loading"
          v-for="(project, index) in projects"
          :class="{ 'big-project': index < 2 }"
          :project_data="project"
        ></projectCard>

        <projectCard
          v-else
          v-for="index in 5"
          :class="{ 'big-project': index - 1 < 2 }"
          :project_data="{}"
        ></projectCard>
      </div>
    </div>
  </section>
</template>

<style scoped>
@import url('./highlights.css');
</style>
