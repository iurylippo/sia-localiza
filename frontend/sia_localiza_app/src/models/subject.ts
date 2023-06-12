import { Course } from './course'

export interface Subject {
  id: string
  code: string
  name: string
  description: string | null
  course: Course
  created_at: string
  updated_at: string
  course_id: string
}
