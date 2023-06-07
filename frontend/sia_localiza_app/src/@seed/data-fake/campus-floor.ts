import { v4 as uuid } from 'uuid'
import { professorsFake } from './professors'
import { subjectsFake } from './subjects'

export const campusFloorFake = [
  {
    id: uuid(),
    class: 'a109',
    day: 'segunda-feira',
    day_number: 1,
    day_period: 'manhã',
    obs: 'Obs',
    event_id: uuid(),
    guests: [],
    subject_id: uuid(),
    professor_id: uuid(),
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
    id: uuid(),
    class: 'a29',
    day: 'segunda-feira',
    day_number: 1,
    day_period: 'manhã',
    obs: 'Obs',
    event_id: uuid(),
    guests: [],
    subject_id: uuid(),
    professor_id: uuid(),
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
    id: uuid(),
    class: 'l3',
    day: 'segunda-feira',
    day_number: 1,
    day_period: 'manhã',
    obs: 'Obs',
    event_id: uuid(),
    guests: [],
    subject_id: uuid(),
    professor_id: uuid(),
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
