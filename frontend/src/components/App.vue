<script setup lang="ts">
import { onMounted, ref, type Ref } from 'vue'
import ProjectCard from './ProjectCard.vue'
import type Project from '@/types/Project'

var projects: Ref<Project[]> = ref([])

async function fetchProjects() {
  let response = await fetch('http://localhost:8080/projects')
  response.json().then((json) => {
    projects.value = json
  })
}

onMounted(() => {
  fetchProjects()
})
</script>

<template>
  <ul v-if="projects.length > 0">
    <li v-for="project in projects">
      <ProjectCard :project="project"></ProjectCard>
    </li>
  </ul>
  <p v-else>Loading...</p>
</template>

<style scoped>
body {
  width: 90ch;
}

ul {
  list-style: none;
  padding: 0;
}
</style>
