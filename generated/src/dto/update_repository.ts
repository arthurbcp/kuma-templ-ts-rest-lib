
export type UpdateRepository = {
    // New repository name
    name?:string
    // New repository description
    description?:string
    // Specifies if the repository will be private
    private?:boolean
}