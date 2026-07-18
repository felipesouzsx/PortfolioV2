<script setup lang="ts">
import { useProject } from '@/composables/useProject.ts'
import HighlightsHeader from './components/highlightsHeader.vue'
import project from '@/views/common/project/project.vue'
import { onMounted } from 'vue'

const { projects, loading, loadProjects } = useProject()

onMounted(loadProjects)
</script>

<template>
  <section>
    <div class="section-content">
      <HighlightsHeader></HighlightsHeader>

      <div class="projects">
        <project
          v-if="!loading"
          v-for="(project, index) in projects"
          :class="{ 'big-project': index < 2 }"
          :project_data="project"
        ></project>

        <project
          v-else
          v-for="index in 5"
          :class="{ 'big-project': index - 1 < 2 }"
          :project_data="{}"
        ></project>
      </div>
    </div>
  </section>
</template>

<style scoped>
@import url('./highlights.css');
</style>
