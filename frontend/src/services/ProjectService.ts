import type ProjectModel from '@/models/ProjectModel';
import { HttpClient } from './HttpClient';

export class ProjectService {
  static async getAll(): Promise<ProjectModel[]> {
    let projectsJson: ProjectModel[] = [];
    try {
      projectsJson = await HttpClient.get<ProjectModel[]>('/projects');
    } catch (error) {
      throw new Error('Error getting all projects');
    }
    return projectsJson;
  }
}
