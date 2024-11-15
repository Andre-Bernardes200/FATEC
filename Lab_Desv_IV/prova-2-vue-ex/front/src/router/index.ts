import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/gerencie-vocabulos',
      name: 'GerencieVocabulos',
      component: () => import('../views/GerencieVocabulos.vue')
    }
  ]
})

export default router
