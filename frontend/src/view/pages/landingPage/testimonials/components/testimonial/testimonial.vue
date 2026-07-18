<script setup lang="ts">
import Card from '@/view/common/card/card.vue'

const props = defineProps(['data'])
const hasData = props.data instanceof Object && Object.keys(props.data).length > 0
</script>

<template>
  <Card :class="{ loading: !hasData }">
    <header v-if="hasData">
      <img
        :src="`https://images.felipemontsouza.com/testimonials/${props.data.author}`"
        :alt="props.data.name"
        v-if="hasData"
      />
      <div>
        <h1>{{ props.data.author }}</h1>
        <h2>{{ props.data.role }}<br />@{{ props.data.company }}</h2>
      </div>
    </header>
    <p v-if="hasData">{{ props.data.message }}</p>
  </Card>
</template>

<style scoped>
.card {
  aspect-ratio: 1/1;

  width: calc((100% - var(--gap) * 3 - var(--card-padding) * 6) / 3);
  min-height: calc((100% - var(--gap) * 2 - var(--card-padding) * 4) / 2);
}

header {
  display: flex;
  justify-content: space-between;
}

img {
  object-fit: cover;
  aspect-ratio: 1/1;
  height: 10ch;
}

h1,
h2 {
  margin: 0;
}

h1 {
  font-size: 2rem;
  text-align: right;
}

h2 {
  font-size: 1rem;
  text-align: end;
  font-weight: 100;
  opacity: 50%;
}

p {
  text-align: justify;
}

@media screen and (max-width: 1000px) {
  .card {
    width: 100%;
  }
}
</style>
