import { User } from './user'

export type Repository = {
    description?:string
    fork?:boolean
    url?:string
    updated_at?:string
    pushed_at?:string
    name?:string
    full_name?:string
    private?:boolean
    owner?:User
    html_url?:string
    created_at?:string
    id?:number
}