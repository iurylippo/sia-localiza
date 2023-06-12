import { Event } from './events'
import { Professor } from './professors'
import { Subject } from './subject'

export interface CampusEvent {
  id: string
  description: string | null
  event: Event
  professor: Professor
  subject: Subject
  created_at: string
  updated_at: string
  event_id: string
  professor_id: string
  subject_id: string
  class: string
}
