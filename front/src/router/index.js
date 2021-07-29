import {createRouter, createWebHistory} from 'vue-router'

import MainLayout from '@/layouts/Index'

const routes = [
  {
    path: '/',
    component: MainLayout,
    children: [
      {
        path: '/hihi',
        name: 'hihi',
        component: () => import(
          '@/views/Hihi'
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
