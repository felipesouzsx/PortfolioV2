import type AssetModel from './AssetModel';

export default interface ProjectModel {
  id: string;
  name: string;
  description: string;
  publisher: string;
  releaseDate: string;
  assets: AssetModel[];
}
