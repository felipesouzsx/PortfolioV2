<script setup lang="ts">
import card from '../card/card.vue'
import { ref, computed } from 'vue'

const props = defineProps(['project_data'])
const projectName = props.project_data.name
const projectPublisher = props.project_data.publisher
const projectRoles = props.project_data.roles
const imgSrc = ref(props.project_data.hero_url)
const imgAlt = `${projectName} logo.`

const getImage = computed(() => {
  return imgSrc.value
})
</script>

<template>
  <card>
    <img :src="getImage" :alt="imgAlt" />
    <div class="info-container">
      <h1>Publisher</h1>
      <p>{{ projectPublisher }}</p>
    </div>
    <div class="info-container">
      <h1>Worked as</h1>
      <ul>
        <li v-for="role in projectRoles">{{ role }}</li>
      </ul>
    </div>
  </card>
</template>

<style scoped>
@import url('./project.css');
</style>
