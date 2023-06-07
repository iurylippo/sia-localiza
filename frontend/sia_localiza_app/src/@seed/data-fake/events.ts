import { v4 as uuid } from 'uuid'

export const eventsFake = [
  {
    id: uuid(),
    name: 'Feira de ciências',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
]
