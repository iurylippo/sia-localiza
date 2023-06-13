'use client'
import { useEffect, useState } from 'react'
import { ClassModal } from '../class-modal'
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '../layout/select'
import { classesNames, weekDays } from '@/common/constants'
import './styles.css'
import { MapBackground } from './background'
import { MapEntraceLabels } from './entrance-label'
import { MapDetails } from './details'
import { MapClasses } from './classes'
import { MapDefs } from './defs'
import { MapEntracePoint } from './entrance-point'
import { MapArea } from './area-path'
import { CampusEvent } from '@/models/campus-event'
import { API } from '@/services/api/axios'
import { ComboBox } from '../combo-box'

export default function MapVector() {
  const [currentClass, setCurrentClass] = useState('a14')
  const [selectedDayWeek, setSelectedDayWeek] = useState('')
  const [isModalOpen, setIsModalOpen] = useState(false)
  const [data, setData] = useState<CampusEvent[]>([])

  function handleClassClick(className: string) {
    setCurrentClass(className)
    setIsModalOpen(true)
  }

  useEffect(() => {
    console.log(data)
  }, [data])

  useEffect(() => {
    const loadData = async () => {
      const dayWeek = selectedDayWeek ?? ''
      const dayPeriod = ''
      const professorId = ''
      const subjectId = ''
      const response = await API.get<CampusEvent[]>('/events/campus', {
        params: {
          day_week: dayWeek,
          day_period: dayPeriod,
          professor_id: professorId,
          subject_id: subjectId,
        },
      })
      setData(response.data)
    }
    loadData()
  }, [])

  return (
    <>
      <div className="w-32 mb-4 h-7">
        <Select
          onValueChange={(c) => setCurrentClass(c)}
          defaultValue={currentClass}
        >
          <SelectTrigger>
            <SelectValue placeholder="Selecionar uma sala..." />
          </SelectTrigger>
          <SelectContent>
            {classesNames.map((p) => (
              <SelectItem key={p} value={p}>
                {p}
              </SelectItem>
            ))}
          </SelectContent>
        </Select>
        <ComboBox
          options={weekDays.PT.map((w) => ({ label: w.name, value: w.value }))}
          onSelect={(dayWeek) => setSelectedDayWeek(dayWeek)}
        />
      </div>
      <div>
        <div id="map-container" className="flex justify-center">
          <ClassModal
            title={`Classe: ${currentClass}`}
            isModalOpen={isModalOpen}
            onModalClose={() => setIsModalOpen(false)}
            campusFloor={null}
          />
          <svg
            width="1239"
            height="878"
            viewBox="0 0 1239 878"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <g id="mapa-vetorizado">
              <MapArea />
              <MapBackground />
              <MapEntraceLabels />
              <MapDetails />
              <MapClasses
                currentClass={currentClass}
                handleClassClick={handleClassClick}
              />
              <MapEntracePoint />
            </g>
            <MapDefs />
          </svg>
        </div>
      </div>
    </>
  )
}
