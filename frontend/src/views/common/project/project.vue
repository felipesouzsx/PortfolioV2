<script setup lang="ts">
import useModal from '@/composables/useModal.ts';
import card from '../card/card.vue';

const props = defineProps(['project_data']);
const hasData = props.project_data instanceof Object && Object.keys(props.project_data).length > 0;

let projectRoles: string[];
if (hasData) projectRoles = props.project_data.roles.split(',');

let { isOpen, openModal, closeModal } = useModal();
</script>

<template>
  <card class="project" :class="{ loading: !hasData }" @click="openModal">
    <img
      :src="`https://images.felipemontsouza.com/${props.project_data.name}/hero.png`"
      :alt="props.project_data.name + 'logo'"
      v-if="hasData"
    />

    <div class="info-container" :class="{ hidden: !hasData }">
      <h1>Publisher</h1>
      <p>{{ props.project_data.name }}</p>
    </div>
    <div class="info-container" :class="{ hidden: !hasData }">
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
