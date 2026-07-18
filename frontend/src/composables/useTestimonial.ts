import type TestimonialModel from '@/models/TestimonialModel'
import { TestimonialService } from '@/services/TestimonialService'
import { ref } from 'vue'

export default function () {
  const testimonials = ref<TestimonialModel[]>([])
  const loading = ref(true)

  async function loadTestimonials() {
    try {
      testimonials.value = await TestimonialService.getAll()
      loading.value = false
    } catch (error) {
      console.log('Error loading testimonials')
    }
  }

  return { testimonials, loading, loadTestimonials }
}
