import { createApp } from 'vue'
import vuetify from './plugins/vuetify'
import App from './App.vue'
import router from './router'

const app = createApp(App)

app
  .use(vuetify)
  .use(router)
  .mount('#app')
