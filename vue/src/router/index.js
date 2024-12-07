import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', redirect: '/manager/home' },
    {
      path: '/manager',
      component: () => import('@/views/Manager.vue'),
      children: [
        { path: 'home', meta: { name: '系统首页' }, component: () => import('@/views/manager/Home.vue'),  },
        { path: 'adminHome', meta: { name: '系统首页' }, component: () => import('@/views/manager/AdminHome.vue'),  },
        { path: 'admin', meta: { name: '管理员信息' }, component: () => import('@/views/manager/Admin.vue'), },
        { path: 'notice', meta: { name: '系统公告' }, component: () => import('@/views/manager/Notice.vue'), },
        { path: 'person', meta: { name: '个人资料' }, component: () => import('@/views/manager/Person.vue'), },
        { path: 'password', meta: { name: '修改密码' }, component: () => import('@/views/manager/Password.vue'), },
        { path: 'cinema', meta: { name: '影院' }, component: () => import('@/views/manager/Cinema.vue'), },
        { path: 'user', meta: { name: '用户信息' }, component: () => import('@/views/manager/User.vue'), },
        { path: 'type', meta: { name: '电影分类' }, component: () => import('@/views/manager/Type.vue'), },
        { path: 'area', meta: { name: '电影区域' }, component: () => import('@/views/manager/Area.vue'), },
        { path: 'film', meta: { name: '电影信息' }, component: () => import('@/views/manager/Film.vue'), },
        { path: 'actor', meta: { name: '演职人员' }, component: () => import('@/views/manager/Actor.vue'), },
        { path: 'video', meta: { name: '预告视频' }, component: () => import('@/views/manager/Video.vue'), },
        { path: 'certificate', meta: { name: '资质认证' }, component: () => import('@/views/manager/Certificate.vue'), },
        { path: 'room', meta: { name: '影厅房间' }, component: () => import('@/views/manager/Room.vue'), },
        { path: 'show', meta: { name: '放映记录' }, component: () => import('@/views/manager/Show.vue'), },
        { path: 'orders', meta: { name: '购票订单' }, component: () => import('@/views/manager/Orders.vue'), },
        { path: 'score', meta: { name: '电影评分' }, component: () => import('@/views/manager/Score.vue'), },
      ]
    },
    {
      path: '/front',
      component: () => import('@/views/Front.vue'),
      children: [
        { path: 'home', component: () => import('@/views/front/Home.vue'),  },
        { path: 'person', component: () => import('@/views/front/Person.vue'),  },
        { path: 'password', component: () => import('@/views/front/Password.vue'),  },
        { path: 'film', component: () => import('@/views/front/Film.vue'),  },
        { path: 'cinema', component: () => import('@/views/front/Cinema.vue'),  },
        { path: 'filmDetail', component: () => import('@/views/front/FilmDetail.vue'),  },
        { path: 'cinemaDetail', component: () => import('@/views/front/CinemaDetail.vue'),  },
        { path: 'filmCinema', component: () => import('@/views/front/FilmCinema.vue'),  },
        { path: 'collect', component: () => import('@/views/front/Collect.vue'),  },
        { path: 'seat', component: () => import('@/views/front/Seat.vue'),  },
        { path: 'orders', component: () => import('@/views/front/Orders.vue'),  },
        { path: 'notice', component: () => import('@/views/front/Notice.vue'),  },
        { path: 'charts', component: () => import('@/views/front/Charts.vue'),  },
        { path: 'search', component: () => import('@/views/front/Search.vue'),  },
      ]
    },
    { path: '/login', component: () => import('@/views/Login.vue') },
    { path: '/register', component: () => import('@/views/Register.vue') },
    { path: '/404', component: () => import('@/views/404.vue') },
    { path: '/:pathMatch(.*)', redirect: '/404' }
  ]
})

export default router
