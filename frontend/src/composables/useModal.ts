import { ref } from 'vue';

const isOpen = ref<boolean>(false);

export default function useModal() {
  function openModal() {
    isOpen.value = true;
  }

  function closeModal() {
    isOpen.value = false;
  }

  return { isOpen, openModal, closeModal };
}
