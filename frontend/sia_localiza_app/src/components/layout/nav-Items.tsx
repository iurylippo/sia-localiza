'use-client'
import React from 'react'
import {
  MapIcon,
  UsersIcon,
  PencilSquareIcon,
  BookOpenIcon,
  CalendarDaysIcon,
} from '@heroicons/react/24/outline'
import { NavItem } from './sidebar'

export const defaultNavItems: NavItem[] = [
  {
    label: 'Mapa',
    href: '/map',
    icon: <MapIcon className="w-6 h-6" />,
  },
  {
    label: 'Eventos',
    href: '/events',
    icon: <CalendarDaysIcon className="w-6 h-6" />,
  },
  {
    label: 'Cursos',
    href: '/courses',
    icon: <BookOpenIcon className="w-6 h-6" />,
  },
  {
    label: 'Disciplinas',
    href: '/subjects',
    icon: <PencilSquareIcon className="w-6 h-6" />,
  },
  {
    label: 'Professores',
    href: '/professors',
    icon: <UsersIcon className="w-6 h-6" />,
  },
]
