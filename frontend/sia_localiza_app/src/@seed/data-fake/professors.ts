import { v4 as uuid } from 'uuid'

export const professorsFake = [
  {
    id: uuid(),
    code: '0001',
    name: 'Felipe Melo',
    description: 'Desc',
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: uuid(),
    code: '0002',
    name: 'Iury Lippo',
    description: 'Desc',
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: uuid(),
    code: '0003',
    name: 'Juana Dark',
    description: 'Desc',
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: uuid(),
    code: '0004',
    name: 'Vanessa Lima',
    description: 'Desc',
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
  {
    id: uuid(),
    code: '0005',
    name: 'Línguas',
    description: 'Desc',
    created_at: new Date().toISOString(),
    updated_at: new Date().toISOString(),
  },
]
