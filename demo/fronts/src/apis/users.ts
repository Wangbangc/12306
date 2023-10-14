import { $http } from '@/apis/index'
export const getUserListApi = (params: { page: number;pageSize: number;name:string }) => {
  return $http({
      url: '/user/page',
      method: 'get',
      params
  })
}
export const modifyStatus=(id:number[])=>{
    return $http({
        url:'/user/status',
        method:'put',
        data:id
    })
}