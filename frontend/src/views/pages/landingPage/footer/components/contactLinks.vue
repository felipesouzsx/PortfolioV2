<template>
  <div id="container" class="unavailable">
    <p>Not looking for work right now,<br />but feel free to reach out!</p>
    <div id="social-links">
      <img src="/assets/icons/discord.svg" alt="Discord" />
      <img src="/assets/icons/email.svg" alt="Discord" />
    </div>
  </div id="container">
</template>

<style scoped>

.unavailable {
  opacity: 50%;
  color: white;
}

#container {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  justify-content: center;
}

h1 {
  font-size: 1rem;
  font-weight: 100;
}

#social-links {
  display: flex;
  gap: 1rem;
}

img {
  width: 5ch;
}
</style>
