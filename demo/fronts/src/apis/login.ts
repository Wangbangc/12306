import { $http } from '@/apis/index'
export const loginApi = (data: { username: string; password: string }) => {
  return $http({
    url: '/user/login',
    method: 'post',
    data
  })
}
