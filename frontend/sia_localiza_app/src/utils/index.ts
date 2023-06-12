/* eslint-disable no-unused-vars */
import { clsx, type ClassValue } from 'clsx'
import { twMerge } from 'tailwind-merge'
import dayjs from 'dayjs'
import localeData from 'dayjs/plugin/localeData'
import utc from 'dayjs/plugin/utc'
import timezone from 'dayjs/plugin/timezone'
import 'dayjs/locale/pt-br'
dayjs.extend(utc)
dayjs.extend(timezone)
dayjs.extend(localeData)

type DownloadFileFromServerParams = {
  contentType: string
  filename: string
  data: any
}

type ActionTypeMap<T extends string> = { [key in T]: string }

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

export function formatDate(date: string | Date): string {
  if (!date) return ''

  const formattedDate = dayjs(date).format('DD/MM/YYYY')
  return formattedDate
}

export function formatDateHour(date: string | Date): string {
  if (!date) return ''

  const formattedDate = dayjs(date).format('HH:mm')
  return formattedDate
}

export function formatDateDay(date: string | Date): string {
  if (!date) return ''

  const formattedDate = dayjs(date)
    .utc()
    .local()
    .tz('America/Recife')
    .locale('pt-br')
    .format('dddd, D')
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

export const createActionTypesMap = <T extends string>(
  prefix: string,
  types: T[],
): ActionTypeMap<T> =>
  types.reduce(
    (obj, key) => ({
      ...obj,
      [key]: `${prefix}${key}` === '/' ? '' : `${prefix}${key}`,
    }),
    {} as ActionTypeMap<T>,
  )
