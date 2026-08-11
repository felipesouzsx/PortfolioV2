<script setup lang="ts">
import useModal from '@/composables/useModal.ts';
import card from '../card/card.vue';
import { ref, Transition } from 'vue';
import { onClickOutside } from '@vueuse/core';

let { isOpen, content, contentProps, closeModal } = useModal();

const modal = ref(null);
onClickOutside(modal, closeModal);
</script>

<template>
  <transition name="modal">
    <div id="modal-container" v-if="isOpen">
      <card id="modal-card" ref="modal">
        <component :is="content" v-bind="contentProps"></component>
      </card>
      <button id="close-button">
        <img src="/assets/icons/close.svg" alt="" />
      </button>
    </div>
  </transition>
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

  width: min(calc(var(--website-width) - 4rem), calc(100% - 4rem));
  backdrop-filter: blur(5px);
  overflow-y: auto;

  padding: 4rem;

  scrollbar-width: none;
  /* for old ms browsers */
  -ms-overflow-style: none;
}

.modal-enter-active,
.modal-leave-active {
  transition: all 0.25s ease;
}

.modal-enter-from,
.modal-leave-to {
  opacity: 0;
  transform: scale(1.1);
}

#close-button {
  all: unset;

  position: fixed;
  right: calc((100vw - var(--website-width)) / 2 + 4rem);
  top: 2rem;

  background-color: var(--element-bg-color);
  border: 1px solid rgba(244, 239, 231, 0.25);
  backdrop-filter: blur(10px);

  box-sizing: padding-box;
  width: 3rem;
  height: 3rem;

  display: flex;
  place-items: center;
  justify-content: center;
}

#close-button > img {
  width: 75%;
  height: 75%;
}
</style>
