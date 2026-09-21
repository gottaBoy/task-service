import Vue from 'vue';
import Vuex from 'vuex';
import VueRouter from 'vue-router';
import App from '@/App.vue';
import i18n from '@/locale'
import Vant from 'vant';
import 'vant/lib/index.css';
import '@/styles/default.less';
import less from 'less';
import { AppLayoutService, ViewOpenService } from 'ibiz-vue';
import { Environment } from '@/environments/environment';
import { ionicInitialize } from './ionic-initialize';
import { ibizMobileComponentsInitialize } from './ibiz-mobile-components-initialize';
import { Lazyload } from 'vant';
import { installPlugin } from '@/plugin/app-plugin-service';
import VueAMap from "vue-amap";
import { AppComponents } from '@/app-register';
import { UserComponents } from '@/user-register';
import { PageComponents } from '@/page-register';
import store from '@/store';
import router from './router';
import { Interceptors, AppComponentService } from '@/utils';
import { AppServiceBase } from 'ibiz-core';
import { NoticeHandler } from 'ibiz-vue';
// 自定义格式扩展
import format from 'vue-text-format';
// 手势滑动
import VueTouch from 'vue-touch';
// 富文本
import 'quill/dist/quill.snow.css';
import VueQuillEditor from 'vue-quill-editor';
// 多语种
import { translate } from './locale/local-util';
import { vueinstall } from 'ibiz-vue';
ibizMobileComponentsInitialize();
const pathToRegExp = require('path-to-regexp');
Vue.use(VueAMap);
Vue.use(Lazyload,{
    preLoad: 1,
    attempt: 1,
    error: 'https://gitee.com/kk_ah/images/raw/master/images/20201218105218.png',
});
VueAMap.initAMapApiLoader({
    key: "6e350f60986cba316719fdc7bd55d8d3",
    plugin: [
      "AMap.Geocoder",
      "AMap.Geolocation" 
    ],
})
//  注册环境配置
AppServiceBase.getInstance().setAppEnvironment(Environment);
// 消息提示
Vue.prototype.$Notice = {
    error: (err: any, info: any) => {
        NoticeHandler.errorHandler(err, info);
    },
    warning: (message: any, fnName?: string, param?: any) => {
        NoticeHandler.warningHandler(message, { param, caller: this, fnName });
    },
    info: (message: any, fnName?: string, param?: any) => {
        NoticeHandler.infoHandler(message, { param, caller: this, fnName });
    },
    success: (err: any, info: any) => {
        NoticeHandler.successHandler(err, info);
    },
    confirm: async function(title: any, message: any, param?: any) {
        return await NoticeHandler.confirmHandler(title, message, param, this);
    }
};
vueinstall();
installPlugin();
AppComponentService.registerAppComponents();
AppLayoutService.registerLayoutComponent();
Vue.config.errorHandler = function (err: any, vm: any, info: any) {
    console.log(err);
}
ionicInitialize({ mode: 'ios' });
Vue.config.productionTip = false;
Vue.config.ignoredElements =[/^ion-/, /^ibiz-/];

Vue.prototype.$tl = function(key:string,value?:string){
  return translate(key,this,value);
}

Vue.use(Vuex);
Vue.use(VueRouter);
Vue.use(Vant, i18n);
Vue.use(less);
Vue.prototype.$pathToRegExp = pathToRegExp;
Vue.use(AppComponents);
Vue.use(UserComponents);
Vue.use(PageComponents);
Vue.use(VueQuillEditor);
Vue.use(VueTouch, {name: 'v-touch'});
Vue.use(format);
VueTouch.config.press = {
    time: 700
  }
router.beforeEach((to: any, from: any, next: any) => {
    if (to.meta && !to.meta.ignoreAddPage) {
        router.app.$store.commit('addPage', to);
    }
    next();
});
Interceptors.getInstance(router, store);
ViewOpenService.getInstance(router);
// 初始化
const init = async () =>{
    document.title = Environment.AppTitle;
    new Vue({
        i18n,
        store,
        router,
        render: (h: any) => h(App),
    }).$mount('#app');
}
init();