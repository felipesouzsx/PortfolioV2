<script setup lang="ts">
import HighlightsHeader from './components/highlightsHeader.vue'
import Project from '@/features/common/project/project.vue'

const projects = [
  {
    name: 'FURNITURE',
    publisher: 'XP GAMES',
    hero_url: '/assets/.temp/Project_Furniture.jpg',
    roles: ['3D Artist', 'Tech Artist'],
  },
  {
    name: 'Vibrant Adventures',
    publisher: 'MINECRAFT',
    hero_url: '/assets/.temp/Project_VibrantAdventures.jpg',
    roles: ['3D Artist'],
  },
  {
    name: 'BIOMECRAFT',
    publisher: 'BLOCKLAB',
    hero_url: '/assets/.temp/Project_Biomecraft.jpg',
    roles: ['3D Artist'],
  },
  {
    name: 'DYNAMIC LIGHT',
    publisher: 'XP GAMES',
    hero_url: '/assets/.temp/Project_DynamicLight.jpg',
    roles: ['3D Artist', 'Tech Artist'],
  },
  {
    name: 'WARDEN 1.0',
    publisher: 'Plank',
    hero_url: '/assets/.temp/Project_Warden1.0.jpg',
    roles: ['3D Artist'],
  },
]
</script>

<template>
  <section>
    <div class="section-content">
      <HighlightsHeader></HighlightsHeader>
      <div class="projects">
        <Project
          v-for="(project, index) in projects"
          :class="{ 'big-project': index < 2 }"
          :project_data="project"
        ></Project>
      </div>
    </div>
  </section>
</template>

<style scoped>
@import url('./highlights.css');
</style>
