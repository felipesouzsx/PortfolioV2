const BASE_URL = 'http://localhost:8080';

export class HttpClient {
  static async get<T>(url: string): Promise<T> {
    try {
      const response = await fetch(BASE_URL + url);
      if (!response.ok) {
        throw new Error(`Error fetching URL: ${response.status}`);
      }
      return response.json();
    } catch (e) {
      throw new Error('Error fetching URL');
    }
  }
}
