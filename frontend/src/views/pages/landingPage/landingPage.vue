<script setup lang="ts">
import Modal from '@/views/common/modal/modal.vue';
import Nav from '../../common/nav/nav.vue';
import Footer from './footer/footer.vue';
import Hero from './hero/hero.vue';
import Highlights from './highlights/highlights.vue';
import Testimonials from './testimonials/testimonials.vue';
import { Teleport } from 'vue';
</script>

<template>
  <Nav></Nav>

  <Hero></Hero>
  <Highlights></Highlights>
  <Testimonials></Testimonials>
  <Footer></Footer>

  <Teleport to="#modal">
    <Modal></Modal>
  </Teleport>
</template>
