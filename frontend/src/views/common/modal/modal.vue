<script setup lang="ts">
import useModal from '@/composables/useModal.ts';
import card from '../card/card.vue';
import { ref } from 'vue';
import { onClickOutside } from '@vueuse/core';

let { isOpen, content, contentProps, closeModal } = useModal();

const modal = ref(null);
onClickOutside(modal, closeModal);
</script>

<template>
  <div id="modal-container" v-if="isOpen">
    <card id="modal-card" ref="modal">
      <component :is="content" v-bind="contentProps"></component>
    </card>
  </div>
</template>

<style>
#modal-container {
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;

  background-color: rgba(0, 0, 0, 0.75);

  min-height: 100dvh;
  width: 100dvw;
  z-index: 10;

  display: flex;
  justify-content: center;
}

#modal-card {
  box-sizing: border-box;

  width: min(var(--website-width), calc(100% - 4rem));
  backdrop-filter: blur(5px);
  overflow-y: auto;

  padding: 4rem;

  scrollbar-width: none;
  /* for old ms browsers */
  -ms-overflow-style: none;
}
</style>
