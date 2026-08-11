<script setup lang="ts">
import Modal from '@/views/common/modal/modal.vue';
import Nav from '../../common/nav/nav.vue';
import Footer from './footer/footer.vue';
import Hero from './hero/hero.vue';
import Highlights from './highlights/highlights.vue';
import Testimonials from './testimonials/testimonials.vue';
import { Teleport } from 'vue';

function scrollToSection(section: string): void {
  document.getElementById(section)?.scrollIntoView();
}
</script>

<template>
  <Nav :scrollToSection="scrollToSection"></Nav>

  <Hero id="hero"></Hero>
  <Highlights id="projects"></Highlights>
  <Testimonials id="testimonials"></Testimonials>
  <Footer id="contact"></Footer>

  <Teleport to="#modal">
    <Modal></Modal>
  </Teleport>
</template>
