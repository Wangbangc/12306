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