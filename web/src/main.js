import Vue from 'vue'
import App from './App.vue'

import router from './router'
import store from './store'
import VueCompositionAPI from '@vue/composition-api'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios';

// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
// axios.defaults.baseURL = 'api'; 
Vue.prototype.$axios = axios;
Vue.config.productionTip = false
Vue.use(ElementUI).use(router).use(store).use(VueCompositionAPI)
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
