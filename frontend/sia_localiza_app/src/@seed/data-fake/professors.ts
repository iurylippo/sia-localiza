import { randomUUID } from 'crypto'

export const professorsFake = [
  {
    id: randomUUID(),
    code: '0001',
    name: 'Felipe Melo',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0002',
    name: 'Iury Lippo',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0003',
    name: 'Juana Dark',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0004',
    name: 'Vanessa Lima',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0005',
    name: 'Línguas',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
]
