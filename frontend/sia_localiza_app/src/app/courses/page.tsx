'use client'

import { DataTable } from '@/components/data-table'
import { useEffect, useState } from 'react'
import { cellActions } from '@/common/table/cell-actions'
import { API } from '../../services/api/axios'
import { PageControl } from '@/components/page-control/indext'
import { Course } from '@/models/course'
import { columns } from './table/columns'

export default function Courses() {
  const [data, setData] = useState<Course[]>([])

  useEffect(() => {
    const loadData = async () => {
      const response = await API.get<Course[]>('/courses')
      setData(response.data)
    }
    loadData()
  }, [])

  const handleUpdate = (model: Course) => {
    console.log('update', model)
  }

  const handleDelete = (id: string) => {
    console.log('delete', id)
  }

  const cols = [
    ...columns,
    cellActions<Course>({
      onClickUpdate: (model) => handleUpdate(model),
      onClickDelete: (id) => handleDelete(id),
    }),
  ]

  return (
    <div>
      <PageControl title="Cursos" />

      <div className="container py-10 mx-auto">
        <DataTable columns={cols} data={data} />
      </div>
    </div>
  )
}
