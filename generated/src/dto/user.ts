import { Repository } from './repository'

export type User = {
    login:string
    id:number
    avatar_url?:string
    html_url?:string
    users?:User[]
    repositories?:Repository[]
}