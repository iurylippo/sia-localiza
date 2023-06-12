'use client'

import { cellDates } from '@/common/table/cell-dates'
import { CampusEvent } from '@/models/campus-event'
import { ColumnDef } from '@tanstack/react-table'

export const columns: ColumnDef<CampusEvent>[] = [
  {
    accessorKey: 'event',
    header: 'Evento',
    accessorFn: (e) => e.event.summary,
  },
  {
    accessorKey: 'event_day_week',
    header: 'Dia/Semana',
    accessorFn: (e) => e.event.day_week,
  },
  {
    accessorKey: 'event_day_period',
    header: 'Dia/Período',
    accessorFn: (e) => e.event.day_period,
  },
  {
    accessorKey: 'event_start_at',
    header: 'Hora/Inicio',
    accessorFn: (e) => e.event.start_at,
  },
  {
    accessorKey: 'event_end_at',
    header: 'Hora/Fim',
    accessorFn: (e) => e.event.end_at,
  },
  {
    accessorKey: 'professor',
    header: 'Professor',
    accessorFn: (e) => e.professor.name,
  },
  {
    accessorKey: 'subject',
    header: 'Disciplina',
    accessorFn: (e) => e.subject.name,
  },
  {
    accessorKey: 'class',
    header: 'Classe',
    accessorFn: (e) => e.class,
  },
  ...cellDates,
]
