export interface Event {
  id: string
  summary: string
  description: string | null
  created_at: string
  updated_at: string
  day_week: string
  day_period: string
  color?: string
  start_at: string
  end_at: string
}
