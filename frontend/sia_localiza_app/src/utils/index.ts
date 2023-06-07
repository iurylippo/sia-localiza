import { clsx, type ClassValue } from 'clsx'
import { twMerge } from 'tailwind-merge'
import dayjs from 'dayjs'

type DownloadFileFromServerParams = {
  contentType: string
  filename: string
  data: any
}

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export function formatBrMoney(value: number): string {
  return new Intl.NumberFormat('pt-BR', {
    style: 'currency',
    currency: 'BRL',
    maximumFractionDigits: 0,
    minimumFractionDigits: 0,
  }).format(value)
}

export function formatDate(date: string): string {
  if (!date) return ''

  const formattedDate = dayjs(date).format('DD/MM/YYYY')
  return formattedDate
}

function makeid(length: any) {
  let result = ''
  const characters =
    'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
  const charactersLength = characters.length
  for (let i = 0; i < length; i++) {
    result += characters.charAt(Math.floor(Math.random() * charactersLength))
  }
  return result
}

export const generateRandString = () => makeid(30)

export function removeDoubleQuotes(s: string) {
  return s.replace(/^"(.*)"$/, '$1')
}

export function downloadFileFromServer({
  contentType,
  data,
  filename,
}: DownloadFileFromServerParams) {
  const blob = new Blob([data], { type: contentType })
  const fileURL = URL.createObjectURL(blob)

  const link = document.createElement('a')

  link.href = fileURL
  link.setAttribute('download', removeDoubleQuotes(filename))

  document.body.appendChild(link)

  link.click()
  link.parentNode?.removeChild(link)
}
