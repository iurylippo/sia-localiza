'use client'
import { useEffect, useState } from 'react'
import { ClassModal } from '../class-modal'

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
import { ComboBox, ComboBoxOption } from '../combo-box'
import { weekDays, weekPeriods } from '@/common/constants'
import { SearchButton } from '../buttons/search-button'
import { Professor } from '@/models/professors'
import { Subject } from '@/models/subject'
import { TransformComponent, TransformWrapper } from 'react-zoom-pan-pinch'
import { useToast } from '../layout/use-toast'

export default function MapVector() {
  const [professorsOptions, setProfessorsOptions] = useState<ComboBoxOption[]>(
    [],
  )
  const [subjectsOptions, setSubjectsOptions] = useState<ComboBoxOption[]>([])
  const [isModalOpen, setIsModalOpen] = useState(false)
  const [currentClass, setCurrentClass] = useState('')
  const [selectedDayWeek, setSelectedDayWeek] = useState('')
  const [selectedDayPeriod, setSelectedDayPeriod] = useState('')
  const [selectedProfessor, setSelectedProfessor] = useState('')
  const [selectedSubject, setSelectedSubject] = useState('')
  const { toast } = useToast()
  const [isLoading, setIsLoading] = useState(false)

  function handleClassClick(className: string) {
    setCurrentClass(className)
    setIsModalOpen(true)
  }

  const loadCampusEventData = async () => {
    const dayWeek = selectedDayWeek ?? ''
    const dayPeriod = selectedDayPeriod ?? ''
    const professorId = selectedProfessor ?? ''
    const subjectId = selectedSubject ?? ''
    try {
      setIsLoading(true)

      const response = await API.get<CampusEvent[]>('/events/campus', {
        params: {
          day_week: dayWeek,
          day_period: dayPeriod,
          professor_id: professorId,
          subject_id: subjectId,
        },
      })

      if (response.data.length) {
        const data = response.data[0]
        setCurrentClass(data.class)
        toast({
          title: 'Sala encontrada!',
          description: 'Clique na sala para obter mais detalhes.',
          variant: 'sucess',
        })
      } else {
        toast({
          title: 'Sala nao encontrada!',
          description: 'Tente fazer outro filtro.',
          variant: 'alert',
        })
        setCurrentClass('')
      }
    } catch (ex: any) {
      toast({
        title: 'Houve algum problema!',
        description: 'Por favor, contacte o administrador.',
        variant: 'destructive',
      })
    }
    setIsLoading(false)
  }

  const loadProfessors = async () => {
    const response = await API.get<Professor[]>('/professors')
    setProfessorsOptions(
      response.data.map((p) => ({ label: p.name, value: p.id })),
    )
  }

  const loadSubjects = async () => {
    const response = await API.get<Subject[]>('/subjects')
    setSubjectsOptions(
      response.data.map((p) => ({ label: p.name, value: p.id })),
    )
  }

  const loadFilters = async () => {
    await loadProfessors()
    await loadSubjects()
  }

  useEffect(() => {
    const loadData = loadFilters
    loadData()
  }, [])

  return (
    <>
      <div className="container flex flex-col items-center justify-start w-full gap-4 mb-4 md:flex-row md:h-7">
        <ComboBox
          defaultValue={weekDays.PT[0].value}
          emptyLabel="Dia / semana..."
          options={weekDays.PT.map((w) => ({ label: w.name, value: w.value }))}
          onSelect={(dayWeek) => setSelectedDayWeek(dayWeek)}
        />
        <ComboBox
          defaultValue={weekPeriods.PT[0].value}
          emptyLabel="Dia / período..."
          options={weekPeriods.PT.map((w) => ({
            label: w.name,
            value: w.value,
          }))}
          onSelect={(dayPeriod) => setSelectedDayPeriod(dayPeriod)}
        />
        <ComboBox
          enableUnchek={true}
          emptyLabel="Professor..."
          options={professorsOptions}
          onSelect={(professorId) => setSelectedProfessor(professorId)}
        />
        <ComboBox
          enableUnchek={true}
          emptyLabel="Disciplina..."
          options={subjectsOptions}
          onSelect={(subjectId) => setSelectedSubject(subjectId)}
        />
        <SearchButton
          isLoading={isLoading}
          onClick={loadCampusEventData}
          title="Buscar"
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
          <TransformWrapper
            initialScale={1}
            initialPositionX={0}
            initialPositionY={0}
          >
            <TransformComponent>
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
            </TransformComponent>
          </TransformWrapper>
        </div>
      </div>
    </>
  )
}
