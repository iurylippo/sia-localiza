'use client'

import { cellDates } from '@/common/table/cell-dates'
import { Course } from '@/models/course'
import { ColumnDef } from '@tanstack/react-table'

export const columns: ColumnDef<Course>[] = [
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
  ...cellDates,
]
