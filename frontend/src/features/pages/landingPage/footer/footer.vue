<script setup lang="ts">
import FooterHeader from './components/footerHeader.vue'
import CommissionsCard from './components/commissionsCard.vue'
import ContractorCard from './components/contractorCard.vue'
import ContactLinks from './components/contactLinks.vue'
</script>

<template>
  <section>
    <div class="section-content">
      <FooterHeader></FooterHeader>
      <div id="work-status">
        <CommissionsCard></CommissionsCard>
        <ContractorCard></ContractorCard>
      </div>
      <ContactLinks></ContactLinks>
    </div>
  </section>
</template>

<style scoped>
.section-content {
  gap: 2rem;
}

#work-status {
  display: flex;
  gap: 2rem;
}
</style>
