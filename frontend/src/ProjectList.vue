<script setup lang="ts">
var projects: object[]
</script>

<template>
  <ul>
    <li v-if="projects.length == 0">
      <p>Tem projetos!</p>
    </li>
    <li v-else><p>Loading</p></li>
  </ul>
</template>
