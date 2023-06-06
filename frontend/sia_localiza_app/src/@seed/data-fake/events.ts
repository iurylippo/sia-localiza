import { randomUUID } from 'crypto'

export const eventsFake = [
  {
    id: randomUUID(),
    name: 'Feira de ciências',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
]
