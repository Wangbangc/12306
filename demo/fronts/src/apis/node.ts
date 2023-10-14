import { $http } from '@/apis/index'
export const addNode = (data: { name: string | undefined; id: number | undefined }) => {
    return $http({
        url: '/node',
        method: 'post',
        data
    })
}
export const query=()=>{
    return $http({
        url:'/node',
        method:'get'
    })
}
export const deleteId=(data:{id:number})=>{
    const id:number=data.id
    return $http({
        url:`/node/${id}`,
        method:'delete',
    })
}