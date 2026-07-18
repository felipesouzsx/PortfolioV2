<script setup lang="ts">
import { onMounted, useTemplateRef } from 'vue'
import { Cubemap } from '@hatchibombotar/cubemap'

import HeroHeader from './components/header/heroHeader.vue'
import SeeMore from './components/seeMore.vue'

function createPanorama(container: HTMLElement) {
  const Panorama = new Cubemap(
    container,
    [
      'assets/landingPage/pano0.png',
      'assets/landingPage/pano1.png',
      'assets/landingPage/pano2.png',
      'assets/landingPage/pano3.png',
      'assets/landingPage/pano4.png',
      'assets/landingPage/pano5.png',
    ],
    { rotate_type: 'auto', rotate_speed: 1.5, width: '100dvw', height: '100dvh' },
  )
  return Panorama
}

/*
Cubemap breaks if you're not using hardware acceleration.
Fallback to static image maybe? 
*/
const cubemapContainer = useTemplateRef('cubemap-container')

onMounted(() => {
  if (!cubemapContainer.value) {
    return
  }
  let Panorama = createPanorama(cubemapContainer.value)
  window.addEventListener('resize', () => {
    Panorama.update()
  })
})
</script>

<template>
  <div id="cubemap" ref="cubemap-container"></div>
  <section>
    <div class="section-content">
      <HeroHeader></HeroHeader>
    </div>
    <SeeMore></SeeMore>
  </section>
</template>

<style scoped>
@import url('./hero.css');

#cubemap {
  position: absolute;
}
</style>
