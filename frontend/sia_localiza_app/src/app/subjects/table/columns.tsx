'use client'

import { cellDates } from '@/common/table/cell-dates'
import { Subject } from '@/models/subject'
import { ColumnDef } from '@tanstack/react-table'

export const columns: ColumnDef<Subject>[] = [
  {
    accessorKey: 'code',
    header: 'Código',
  },
  {
    accessorKey: 'name',
    header: 'Nome',
  },
  {
    accessorKey: 'description',
    header: 'Descrição',
  },
  {
    accessorKey: 'course',
    accessorFn: (s) => s.course.name,
    header: 'Curso',
  },
  ...cellDates,
]
