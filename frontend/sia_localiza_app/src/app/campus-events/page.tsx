'use client'

import { DataTable } from '@/components/data-table'
import { useEffect, useState } from 'react'
import { cellActions } from '@/common/table/cell-actions'
import { API } from '../../services/api/axios'
import { PageControl } from '@/components/page-control/indext'
import { columns } from './table/columns'
import { CampusEvent } from '@/models/campus-event'

export default function CampusEvents() {
  const [data, setData] = useState<CampusEvent[]>([])

  useEffect(() => {
    const loadData = async () => {
      const response = await API.get<CampusEvent[]>('/events/campus')
      setData(response.data)
    }
    loadData()
  }, [])

  const handleUpdate = (model: CampusEvent) => {
    console.log('update', model)
  }

  const handleDelete = (id: string) => {
    console.log('delete', id)
  }

  const cols = [
    ...columns,
    cellActions<CampusEvent>({
      onClickUpdate: (model) => handleUpdate(model),
      onClickDelete: (id) => handleDelete(id),
    }),
  ]

  return (
    <div>
      <PageControl title="Campus Eventos" />

      <div className="container py-10 mx-auto">
        <DataTable columns={cols} data={data} />
      </div>
    </div>
  )
}
