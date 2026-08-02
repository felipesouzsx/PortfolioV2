import type TestimonialModel from '@/models/TestimonialModel';
import { HttpClient } from './HttpClient';

export class TestimonialService {
  static async getAll(): Promise<TestimonialModel[]> {
    let testimonialsJson: TestimonialModel[] = [];
    try {
      testimonialsJson = await HttpClient.get('/testimonials');
    } catch (error) {
      throw new Error("Couldn't get all testimonials.");
    }
    return testimonialsJson;
  }
}
