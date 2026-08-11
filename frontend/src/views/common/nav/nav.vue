<script setup lang="ts">
import ctaButton from '../ctaButton/ctaButton.vue';

const props = defineProps<{
  scrollToSection: Function;
}>();
</script>

<template>
  <nav>
    <button id="name" class="sectionButton" v-on:click="scrollToSection('hero')">
      Felipe Souza
    </button>

    <div id="links">
      <button class="sectionButton" v-on:click="scrollToSection('projects')">Projects</button>
      <button class="sectionButton" v-on:click="scrollToSection('testimonials')">
        Testimonials
      </button>
      <button class="sectionButton">About</button>
      <ctaButton v-on:click="scrollToSection('contact')">Contact Me</ctaButton>
    </div>
  </nav>
</template>

<style scoped>
@import './nav.css';
</style>
