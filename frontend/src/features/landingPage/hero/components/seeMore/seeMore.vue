<template>
  <p>v see more v</p>
</template>

<style scoped>
p {
  position: absolute;

  /* Centering */
  transform: translate(-50%, 0);
  left: 50%;
  bottom: 1rem;

  --padding-sides: 2rem;
  --padding-top: 0.5rem;
  padding: var(--padding-top) var(--padding-sides) var(--padding-top) var(--padding-sides);

  width: max-content;

  letter-spacing: 0.25rem;

  cursor: default;
  user-select: none;

  border-bottom: 0.5rem solid var(--shadow-border-color);
}

/*
  Background done this way so I could add background blur filter.
*/
p::before {
  z-index: -1;
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;

  background-color: black;
  background-position: center;
  filter: opacity(50%);
  backdrop-filter: blur(8rem);
}
</style>
