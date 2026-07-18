<script setup lang="ts">
import Testimonial from './components/testimonial/testimonial.vue'
import TestimonialsHeader from './components/testimonialsHeader.vue'
import { ref } from 'vue'

let testimonials = ref<Object[]>([])
let loaded = ref<boolean>(false)

fetch('http://localhost:8080/testimonials').then(async (response) => {
  let json = await response.json()
  testimonials.value = json
  loaded.value = true
  console.log(json)
})
</script>

<template>
  <section>
    <div class="section-content">
      <TestimonialsHeader></TestimonialsHeader>
      <div id="testimonial-container" v-if="loaded">
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
