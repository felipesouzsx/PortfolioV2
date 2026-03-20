export default async function (namespace: String): Promise<Response> {
  return fetch(`http://localhost:8080/projects?namespace=${namespace}`)
}
