'use client'
import { useForm } from 'react-hook-form'
import { Modal } from 'react-responsive-modal'
import { zodResolver } from '@hookform/resolvers/zod'
import { Button } from '@/components/layout/button'

import z from 'zod'
import {
  FormField,
  FormItem,
  FormLabel,
  Form,
  FormMessage,
} from '@/components/layout/form'
import { useEffect, useState } from 'react'
import { CampusEvent } from '@/models/campus-event'
import { ComboBox, ComboBoxOption } from '../combo-box'
import { Professor } from '@/models/professors'
import { Event } from '@/models/events'
import { API } from '@/services/api/axios'
import { Subject } from '@/models/subject'
import { classesNames } from '@/common/constants'
import { Input } from '../layout/input'
import { toast } from '../layout/use-toast'
import { AxiosError, HttpStatusCode } from 'axios'

interface ClassModalProps {
  isModalOpen: boolean
  onModalClose: () => void
  data?: CampusEvent
  type: 'create' | 'update'
}

const FormSchema = z.object({
  event_id: z.string({
    required_error: 'Por favor preencha um evento.',
  }),
  subject_id: z.string({
    required_error: 'Por favor selecione uma disicplina.',
  }),
  professor_id: z.string({
    required_error: 'Por favor selecione um(a) professor(a).',
  }),
  class: z.string({
    required_error: 'Por favor selecione uma classe.',
  }),
  description: z.string().optional(),
})

export function CampusEventModal({
  type = 'create',
  isModalOpen,
  onModalClose,
  data,
}: ClassModalProps) {
  const [professorsOptions, setProfessorsOptions] = useState<ComboBoxOption[]>(
    [],
  )
  const [subjectsOptions, setSubjectsOptions] = useState<ComboBoxOption[]>([])
  const [eventsOptions, setEventsOptions] = useState<ComboBoxOption[]>([])
  const [isModalOpenIntern, setIsModalOpenIntern] = useState(false)

  const form = useForm<z.infer<typeof FormSchema>>({
    resolver: zodResolver(FormSchema),
    defaultValues: {
      event_id: data?.event_id,
      professor_id: data?.professor_id,
      subject_id: data?.subject_id,
      class: data?.class,
    },
  })
  useEffect(() => {
    setIsModalOpenIntern(isModalOpen)
  }, [isModalOpen])

  useEffect(() => {
    if (type === 'update') {
      if (data?.event_id) {
        form.setValue('event_id', data.event_id)
      }
      if (data?.professor_id) {
        form.setValue('professor_id', data.professor_id)
      }
      if (data?.subject_id) {
        form.setValue('subject_id', data.subject_id)
      }
      if (data?.class) {
        form.setValue('class', data.class)
      }
      if (data?.description) {
        form.setValue('description', data.description)
      }
    }

    if (type === 'create') {
      form.reset()
    }
  }, [data])

  const getTitle = () => {
    return type === 'create' ? 'Criar Campus evento' : 'Alterar Campus evento'
  }

  async function create(formData: z.infer<typeof FormSchema>) {
    try {
      await API.post('events/campus', formData)
      toast({
        title: 'Campus evento criado com sucesso!',
        variant: 'sucess',
      })
      setIsModalOpenIntern(false)
      onModalClose()
    } catch (err: any) {
      if (err) {
        const erroAxios = err as AxiosError<{ message: string }>
        console.log(erroAxios)
        if (
          erroAxios?.response?.status === HttpStatusCode.BadRequest &&
          erroAxios?.response?.data?.message
        ) {
          const messageError = err.response.data.message as string
          if (
            messageError.includes(
              'CampusEvent Relations combined(event_id,professor_id,subject_id,class) already exists!',
            )
          ) {
            toast({
              title: 'Já existe um Campus evento nesta combinação!',
              variant: 'destructive',
            })
            return
          }
        }
      }
      toast({
        title: 'Houve algum problema!',
        variant: 'destructive',
      })
    }
  }

  async function update(formData: CampusEvent) {
    try {
      await API.put(`events/campus/${data?.id}`, formData)
      toast({
        title: 'Campus evento alterado com sucesso!',
        variant: 'sucess',
      })
      setIsModalOpenIntern(false)
      onModalClose()
    } catch (err: any) {
      if (err) {
        const erroAxios = err as AxiosError<{ message: string }>
        if (
          erroAxios?.response?.status === HttpStatusCode.BadRequest &&
          erroAxios?.response?.data?.message
        ) {
          const messageError = err.response.data.message as string
          if (
            messageError.includes(
              'CampusEvent Relations combined(event_id,professor_id,subject_id,class) already exists!',
            )
          ) {
            toast({
              title: 'Já existe um Campus evento nesta combinação!',
              variant: 'destructive',
            })
            return
          }
        }
      }
      toast({
        title: 'Houve algum problema!',
        variant: 'destructive',
      })
    }
  }

  async function onSubmit(data: z.infer<typeof FormSchema>) {
    if (type === 'create') {
      await create(data)
    }
    if (type === 'update') {
      await update(data as CampusEvent)
    }
  }

  const loadProfessors = async () => {
    const response = await API.get<Professor[]>('/professors')
    setProfessorsOptions(
      response.data.map((p) => ({ label: p.name, value: p.id })),
    )
  }

  const loadEvents = async () => {
    const response = await API.get<Event[]>('/events')
    setEventsOptions(
      response.data.map((p) => ({
        label: `${p.summary}/${p.day_week}/${p.day_period}/${p.start_at}/${p.end_at}`,
        value: p.id,
      })),
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
    await loadEvents()
  }

  useEffect(() => {
    loadFilters()
  }, [])

  return (
    <Modal
      styles={{
        modal: {
          width: '22rem',
        },
      }}
      open={isModalOpenIntern}
      onClose={onModalClose}
      center
    >
      <h2 className="mb-2 text-center">{getTitle()}</h2>
      <div className="text-title">
        <div>
          <Form {...form}>
            <form
              onSubmit={form.handleSubmit(onSubmit)}
              className="flex flex-col w-full p-4 space-y-3 border rounded"
            >
              <FormField
                control={form.control}
                name="event_id"
                render={({ field }) => (
                  <FormItem className="flex flex-col w-fit">
                    <FormLabel>Evento:</FormLabel>
                    <ComboBox
                      defaultValue={field.value}
                      onSelect={field.onChange}
                      emptyLabel="evento..."
                      options={eventsOptions}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="professor_id"
                render={({ field }) => (
                  <FormItem className="flex flex-col w-fit">
                    <FormLabel>Professor:</FormLabel>
                    <ComboBox
                      defaultValue={field.value}
                      onSelect={field.onChange}
                      emptyLabel="professor..."
                      options={professorsOptions}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="subject_id"
                render={({ field }) => (
                  <FormItem className="flex flex-col w-fit">
                    <FormLabel>Disciplina:</FormLabel>
                    <ComboBox
                      defaultValue={field.value}
                      onSelect={field.onChange}
                      emptyLabel="disciplinas..."
                      options={subjectsOptions}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="class"
                render={({ field }) => (
                  <FormItem className="flex flex-col w-fit">
                    <FormLabel>Classe:</FormLabel>
                    <ComboBox
                      defaultValue={field.value}
                      onSelect={field.onChange}
                      emptyLabel="classes..."
                      options={classesNames.map((c) => ({
                        label: c,
                        value: c,
                      }))}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="description"
                render={({ field }) => (
                  <FormItem className="flex flex-col w-fit">
                    <FormLabel>Descrição:</FormLabel>
                    <Input
                      defaultValue={field.value}
                      onChange={field.onChange}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />
              <Button type="submit">Salvar</Button>
            </form>
          </Form>
        </div>
      </div>
    </Modal>
  )
}
