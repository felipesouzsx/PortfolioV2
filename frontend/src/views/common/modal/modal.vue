<script setup lang="ts">
import useModal from '@/composables/useModal.ts';
import card from '../card/card.vue';
import { ref, Transition } from 'vue';
import { onClickOutside } from '@vueuse/core';
import CtaButton from '../ctaButton/ctaButton.vue';

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
      <cta-button id="close-button" v-on:click="closeModal">
        <img src="/assets/icons/close.svg" alt="" />
      </cta-button>
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
  position: fixed;
  right: calc((100vw - var(--website-width)) / 2 + 3rem);
  top: 0.5rem;

  padding: 0.5rem;
  width: 2rem;
  height: 2rem;
}

#close-button > img {
  width: 100%;
  height: 100%;
}
</style>
