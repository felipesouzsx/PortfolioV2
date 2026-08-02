<script setup lang="ts">
import useModal from '@/composables/useModal.ts';
import card from '../card/card.vue';
import { ref } from 'vue';
import { onClickOutside } from '@vueuse/core';

let { isOpen, openModal, closeModal } = useModal();

const modal = ref(null);
onClickOutside(modal, closeModal);
</script>

<template>
  <div id="modal-container" v-if="isOpen">
    <card id="modal-card" ref="modal">
      <h1>Test Modal</h1>
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

  height: 100dvh;
  width: 100dvw;
  z-index: 10;

  display: flex;
  justify-content: center;
}

#modal-card {
  width: min(var(--website-width), calc(100% - 4rem));
  height: 100dvh;

  backdrop-filter: blur(5px);
}
</style>
