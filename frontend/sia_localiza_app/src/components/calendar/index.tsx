'use client'
import React, { useEffect, useState } from 'react'
import { DateTime } from 'luxon'
import Kalend, { CalendarView, KalendProps, OnEventDragFinish } from 'kalend'
import { generateDemoEvents } from './helpers'
import { NewEventClickData } from 'kalend/common/interface'
import { EventModal } from '../event-modal'
import { Event } from '@/models/events'

const CalendComponent = (props: KalendProps) => {
  const [openCreateEventModal, setOpenCreateEventModal] = useState(false)
  const [demoEvents, setDemoEvents] = useState([])
  const [eventData, setEventData] = useState<Event>()
  const [type, setType] = useState<'create' | 'update'>('create')

  // Create and load demo events
  useEffect(() => {
    setDemoEvents(generateDemoEvents(DateTime.now(), 80))
  }, [])

  const handleCreateEventModalClose = () => setOpenCreateEventModal(false)

  const onNewEventClick = ({ day, endAt, startAt }: NewEventClickData) => {
    setType('create')
    setEventData({
      day,
      summary: '',
      color: '',
      allDay: false,
      professor_id: '',
      subject_id: '',
      endAt: endAt ?? '',
      startAt: startAt ?? '',
    })
    setOpenCreateEventModal(true)
  }

  const onEventClick = (data: Event) => {
    setType('update')
    setEventData(data)
    setOpenCreateEventModal(true)
    const msg = `Click on event action\n\n Callback data:\n\n${JSON.stringify(
      data,
    )}`
    console.log(msg)
    console.log(data)
  }

  // Callback after dragging is finished
  const onEventDragFinish: OnEventDragFinish = (
    prev: any,
    current: any,
    data: any,
  ) => {
    setDemoEvents(data)
  }

  return (
    <>
      <EventModal
        isModalOpen={openCreateEventModal}
        onModalClose={() => handleCreateEventModalClose()}
        type={type}
        eventData={eventData}
      />

      <Kalend
        {...props}
        kalendRef={props.kalendRef}
        onNewEventClick={onNewEventClick}
        initialView={CalendarView.WEEK}
        disabledViews={[]}
        onEventClick={(data: any) => onEventClick(data)}
        events={demoEvents}
        initialDate={new Date().toISOString()}
        hourHeight={60}
        timeFormat="24"
        showWeekNumbers={true}
        timezone={'America/Recife'}
        // draggingDisabledConditions={{
        //   summary: 'Computers',
        //   allDay: false,
        //   color: 'pink',
        // }}
        disabledDragging={true}
        onEventDragFinish={onEventDragFinish}
        onStateChange={props.onStateChange}
        selectedView={props.selectedView}
        showTimeLine={true}
        autoScroll={true}
        language="ptBR"
        colors={{
          light: {
            primaryColor: 'blue',
          },
          dark: {
            primaryColor: 'orange',
          },
        }}
      />
    </>
  )
}

export default CalendComponent
