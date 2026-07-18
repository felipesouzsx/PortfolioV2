<script setup lang="ts">
import useTestimonial from '@/composables/useTestimonial.ts'
import Testimonial from './components/testimonial/testimonial.vue'
import TestimonialsHeader from './components/testimonialsHeader.vue'
import { onMounted } from 'vue'

const { testimonials, loading, loadTestimonials } = useTestimonial()
onMounted(loadTestimonials)
</script>

<template>
  <section>
    <div class="section-content">
      <TestimonialsHeader></TestimonialsHeader>
      <div id="testimonial-container" v-if="!loading">
        <Testimonial v-for="data in testimonials" :data="data"></Testimonial>
      </div>
      <div id="testimonial-container" v-else>
        <Testimonial v-for="index in 6" :data="{}"></Testimonial>
      </div>
    </div>
  </section>
</template>

<style scoped>
#testimonial-container {
  --gap: 1rem;

  display: flex;
  flex-direction: row;
  gap: var(--gap);

  flex-wrap: wrap;
}

section {
  background: linear-gradient(#190b03 0%, #110d0e 50%, #0d131a 100%);
}
</style>
