import axios, { AxiosError } from 'axios'
import type { AxiosRequestConfig } from 'axios'
import { ElLoading, ElMessage } from 'element-plus'
export const httpInstance = axios.create({
  baseURL: '/api',
  timeout: 1000
})
export type BkResponse = {
  code: number
  data: any
  msg: string
}
export const $http = async (config: AxiosRequestConfig) => {
  const loadingInstance = ElLoading.service()
  try {
    const response = await httpInstance<BkResponse>(config)
    const bk = response.data
    if (bk.code === 0) {
      ElMessage.error(bk.msg)
      throw new Error(bk.msg)
    }
    return response
  } catch (e) {
    if ((e as AxiosError).isAxiosError) {
      ElMessage.error((e as AxiosError).message)
    }
    throw e
  } finally {
    loadingInstance.close()
  }
}
