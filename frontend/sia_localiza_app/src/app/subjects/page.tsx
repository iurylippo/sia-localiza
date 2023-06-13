'use client'

import { DataTable } from '@/components/data-table'
import { useEffect, useState } from 'react'
import { cellActions } from '@/common/table/cell-actions'
import { API } from '../../services/api/axios'
import { PageControl } from '@/components/page-control/indext'
import { Subject } from '@/models/subject'
import { columns } from './table/columns'

export default function Subjects() {
  const [data, setData] = useState<Subject[]>([])

  useEffect(() => {
    const loadData = async () => {
      const response = await API.get<Subject[]>('/subjects')
      setData(response.data)
    }
    loadData()
  }, [])

  const handleUpdate = (model: Subject) => {
    console.log('update', model)
  }

  const handleDelete = (id: string) => {
    console.log('delete', id)
  }

  const cols = [
    ...columns,
    cellActions<Subject>({
      onClickUpdate: (model) => handleUpdate(model),
      onClickDelete: (id) => handleDelete(id),
    }),
  ]

  return (
    <div>
      <PageControl title="Disciplinas" />

      <div className="container py-10 mx-auto">
        <DataTable columns={cols} data={data} />
      </div>
    </div>
  )
}
