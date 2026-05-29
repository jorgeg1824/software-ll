import { createApp } from 'vue'
import App from './App.vue'

import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import 'bootstrap-icons/font/bootstrap-icons.css'

import Toast from 'vue-toastification'
import 'vue-toastification/dist/index.css'

import './styles/main.css'

const app = createApp(App)

app.use(Toast)

app.mount('#app')