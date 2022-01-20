import Vue from 'vue'
import App from './App.vue'

import router from './router'
import store from './store'
import VueCompositionAPI from '@vue/composition-api'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.config.productionTip = false
Vue.use(ElementUI).use(router).use(store).use(VueCompositionAPI)
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
