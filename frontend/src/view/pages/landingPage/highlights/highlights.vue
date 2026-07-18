<script setup lang="ts">
import { ref } from 'vue'
import HighlightsHeader from './components/highlightsHeader.vue'
import Project from '@/view/common/project/project.vue'

let projects = ref<Object[]>([])
let loading = ref<boolean>(true)

fetch('http://localhost:8080/projects/simple')
  .then(async (resp) => {
    let json = await resp.json()
    projects.value = json
    loading.value = false
    console.log(json)
  })
  .catch((e) => console.log(e))
</script>

<template>
  <section>
    <div class="section-content">
      <HighlightsHeader></HighlightsHeader>

      <div class="projects">
        <Project
          v-if="!loading"
          v-for="(project, index) in projects"
          :class="{ 'big-project': index < 2 }"
          :project_data="project"
        ></Project>

        <Project
          v-else
          v-for="index in 5"
          :class="{ 'big-project': index - 1 < 2 }"
          :project_data="{}"
        ></Project>
      </div>
    </div>
  </section>
</template>

<style scoped>
@import url('./highlights.css');
</style>
