import { randomUUID } from 'crypto'
import { professorsFake } from './professors'
import { subjectsFake } from './subjects'

export const campusFloorFake = [
  {
    id: randomUUID(),
    class: 'a109',
    day: 'segunda-feira',
    day_number: 1,
    day_period: 'manhã',
    obs: 'Obs',
    event_id: randomUUID(),
    guests: [],
    subject_id: randomUUID(),
    professor_id: randomUUID(),
    professor: {
      ...professorsFake[0],
    },
    subject: {
      ...subjectsFake[0],
    },
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    class: 'a29',
    day: 'segunda-feira',
    day_number: 1,
    day_period: 'manhã',
    obs: 'Obs',
    event_id: randomUUID(),
    guests: [],
    subject_id: randomUUID(),
    professor_id: randomUUID(),
    professor: {
      ...professorsFake[1],
    },
    subject: {
      ...subjectsFake[1],
    },
    created_at: new Date(),
    updated_at: new Date(),
  },
  {
    id: randomUUID(),
    class: 'l3',
    day: 'segunda-feira',
    day_number: 1,
    day_period: 'manhã',
    obs: 'Obs',
    event_id: randomUUID(),
    guests: [],
    subject_id: randomUUID(),
    professor_id: randomUUID(),
    professor: {
      ...professorsFake[2],
    },
    subject: {
      ...subjectsFake[2],
    },
    created_at: new Date(),
    updated_at: new Date(),
  },
]
