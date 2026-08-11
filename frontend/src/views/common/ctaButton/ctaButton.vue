<template>
  <button>
    <slot></slot>
  </button>
</template>

<style scoped>
button {
  all: unset;
  text-decoration: none;
  color: inherit;
  place-self: center;
  cursor: pointer;
}

button {
  padding: 0.5rem 1rem 0.5rem 1rem;
  background-clip: padding-box;
  background-color: var(--element-bg-color);
  justify-content: center;
  transition: 200ms;
  border-top: 0.5rem solid transparent;
  border-bottom: 0.5rem solid transparent;
}
button:hover,
button:focus {
  background-color: var(--element-bg-color-hover);
  filter: brightness(160%);
  /* Shadow when hover */
  border-bottom: 0.5rem solid var(--shadow-border-color);
  transform: translateY(-0.25rem);
}

button:active {
  transition: 0ms;
  transform: translateY(0.05rem);
  border-bottom: 0.5rem solid transparent;
}
</style>
