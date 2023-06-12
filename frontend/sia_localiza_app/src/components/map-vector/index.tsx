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
import { classesNames } from '@/common/constants'
import './styles.css'
import { MapBackground } from './background'
import { MapEntraceLabels } from './entrance-label'
import { MapDetails } from './details'
import { MapClasses } from './classes'
import { MapDefs } from './defs'
import { MapEntracePoint } from './entrance-point'
import { MapArea } from './area-path'

export default function MapVector() {
  const [currentClass, setCurrentClass] = useState('a14')
  const [isModalOpen, setIsModalOpen] = useState(false)

  function handleClassClick(className: string) {
    setCurrentClass(className)
    setIsModalOpen(true)
  }

  useEffect(() => {
    console.log(currentClass)
  }, [currentClass])

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
      </div>
      <div>
        <div id="map-container">
          <ClassModal
            title={`Classe: ${currentClass}`}
            isModalOpen={isModalOpen}
            onModalClose={() => setIsModalOpen(false)}
            campusFloor={null}
          />
          <MapEntracePoint />
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
            </g>
            <MapDefs />
          </svg>
        </div>
      </div>
    </>
  )
}
