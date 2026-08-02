import type ProjectModel from '@/models/ProjectModel';
import { ProjectService } from '@/services/ProjectService';
import { ref } from 'vue';

export function useProject() {
  let projects = ref<ProjectModel[]>([]);
  let loading = ref<boolean>(true);

  async function loadProjects() {
    try {
      projects.value = await ProjectService.getAll();
      loading.value = false;
    } catch (e) {
      console.log('Error loading projects.');
    }
  }

  return { projects, loading, loadProjects };
}
