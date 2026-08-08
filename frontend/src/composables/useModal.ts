import { ref, shallowRef } from 'vue';
import type { Component } from 'vue';

const isOpen = ref<boolean>(false);
const content = shallowRef<Component | null>(null);
const contentProps = ref<Record<string, unknown>>({});

export default function useModal() {
  function openModal(modalContent: Component, modalProps: Record<string, unknown> = {}) {
    isOpen.value = true;
    content.value = modalContent;
    contentProps.value = modalProps;
    document.body.style.overflow = 'hidden';
  }

  function closeModal() {
    isOpen.value = false;
    content.value = null;
    document.body.style.overflow = '';
  }

  return { isOpen, content, contentProps, openModal, closeModal };
}
