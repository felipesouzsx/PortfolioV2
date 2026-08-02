import { ref, shallowRef } from 'vue';
import type { Component } from 'vue';

const isOpen = ref<boolean>(false);
const content = shallowRef<Component | null>(null);

export default function useModal() {
  function openModal(modalContent: Component) {
    isOpen.value = true;
    content.value = modalContent;
    document.body.style.overflow = 'hidden';
  }

  function closeModal() {
    isOpen.value = false;
    content.value = null;
    document.body.style.overflow = '';
  }

  return { isOpen, content, openModal, closeModal };
}
