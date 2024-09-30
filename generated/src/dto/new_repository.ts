
export type NewRepository = {
    // Name of the new repository
    name:string
    // Repository description
    description?:string
    // Specifies if the repository will be private
    private?:boolean
}