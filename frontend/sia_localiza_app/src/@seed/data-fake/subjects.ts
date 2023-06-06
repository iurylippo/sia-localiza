import { randomUUID } from 'crypto'

export const subjectsFake = [
  {
    id: randomUUID(),
    code: '0001',
    name: 'Arquitetura de sistemas',
    description: 'Desc',
    course_id: randomUUID(),
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0002',
    name: 'Programação I',
    description: 'Desc',
    course_id: randomUUID(),
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0003',
    name: 'Programação II',
    description: 'Desc',
    course_id: randomUUID(),
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0004',
    name: 'Estrutura de Dados',
    description: 'Desc',
    course_id: randomUUID(),
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    code: '0005',
    name: 'Banco de dados',
    description: 'Desc',
    course_id: randomUUID(),
    created_at: new Date(),
    updated_at: new Date(),
  },
]
