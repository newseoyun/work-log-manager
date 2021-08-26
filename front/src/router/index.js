import {createRouter, createWebHistory} from 'vue-router'

import MainLayout from '@/layouts/Index'

const routes = [
  {
    path: '/',
    component: MainLayout,
    children: [
      {
        path: '/',
        name: 'Main',
        component: () => import(
          '@/views/Hihi'
        )
      },
      {
        path: '/hihi',
        name: 'hihi',
        component: () => import(
          '@/views/Hihi'
        )
      },
      {
        path: '/data',
        name: 'data',
        component: () => import(
          '@/views/Data'
        )
      }
    ]
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
