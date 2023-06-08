export interface Event {
  id?: string
  day: Date | string
  professor_id: string
  subject_id: string
  startAt: string
  endAt: string
  color: string
  summary: string
  allDay: boolean
}
