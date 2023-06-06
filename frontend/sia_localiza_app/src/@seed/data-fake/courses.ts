import { randomUUID } from 'crypto'

export const coursesFake = [
  {
    id: randomUUID(),
    code: '0001',
    name: 'Sistema da informação',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0002',
    name: 'Administração',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0003',
    name: 'Engenharia de Software',
    description: 'Desc',
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0004',
    name: 'Ciências da Computação',
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
