'use client'

import { professorsFake } from '@/@seed/data-fake/professors'
import { DataTable } from '@/components/data-table'
import { Professor } from '@/models/professors'
import { useEffect, useState } from 'react'
import { columns } from './table/columns'
import { cellActions } from '@/common/table/cell-actions'
// import { cellActions } from '@/common/table/cell-actions'

export default function Professors() {
  const [data, setData] = useState<Professor[]>([])

  useEffect(() => {
    setData(professorsFake)
  }, [])

  const handleUpdate = (model: Professor) => {
    console.log('update', model)
  }

  const handleDelete = (id: string) => {
    console.log('delete', id)
  }

  const cols = [
    ...columns,
    cellActions<Professor>({
      onClickUpdate: (model) => handleUpdate(model),
      onClickDelete: (id) => handleDelete(id),
    }),
  ]

  return (
    <div>
      <h1>Professores</h1>

      <div className="container py-10 mx-auto">
        <DataTable columns={cols} data={data} />
      </div>
    </div>
  )
}
