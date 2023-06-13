import { createActionTypesMap } from '@/utils'

export const professors = createActionTypesMap('/professors', [''])
export const events = createActionTypesMap('/events', ['', '/campus'])
export const subjects = createActionTypesMap('/subjects', ['/'])
export const courses = createActionTypesMap('/courses', ['/'])
export const auth = createActionTypesMap('/auth', [
  '/',
  'register',
  'authenticate',
  'refresh-token',
])
