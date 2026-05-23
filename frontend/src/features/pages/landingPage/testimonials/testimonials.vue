<script setup lang="ts">
import Testimonial from './components/testimonial/testimonial.vue'
import TestimonialsHeader from './components/testimonialsHeader.vue'
</script>

<template>
  <section>
    <div class="section-content">
      <TestimonialsHeader></TestimonialsHeader>
      <div id="testimonial-container">
        <Testimonial></Testimonial>
        <Testimonial></Testimonial>
        <Testimonial></Testimonial>
        <Testimonial></Testimonial>
        <Testimonial></Testimonial>
        <Testimonial></Testimonial>
      </div>
    </div>
  </section>
</template>

<style>
@import url('./testimonials.css');
</style>
