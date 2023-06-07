import { v4 as uuid } from 'uuid'

export const subjectsFake = [
  {
    id: uuid(),
    code: '0001',
    name: 'Arquitetura de sistemas',
    description: 'Desc',
    course_id: uuid(),
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: uuid(),
    code: '0002',
    name: 'Programação I',
    description: 'Desc',
    course_id: uuid(),
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: uuid(),
    code: '0003',
    name: 'Programação II',
    description: 'Desc',
    course_id: uuid(),
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: uuid(),
    code: '0004',
    name: 'Estrutura de Dados',
    description: 'Desc',
    course_id: uuid(),
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: uuid(),
    code: '0005',
    name: 'Banco de dados',
    description: 'Desc',
    course_id: uuid(),
    created_at: new Date(),
    updated_at: new Date(),
  },
]
