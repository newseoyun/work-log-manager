import {createRouter, createWebHistory} from 'vue-router'

const routes = [
  {
    path: '/hihi',
    name: 'hihi',
    component: () => import(
      '@/views/Hihi'
    )
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
