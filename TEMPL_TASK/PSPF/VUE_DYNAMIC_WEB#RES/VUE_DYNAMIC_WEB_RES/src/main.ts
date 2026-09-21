import Vue from 'vue';
import Vuex from 'vuex';
import VueRouter from 'vue-router';
import App from '@/App.vue';
import ElementUi from 'element-ui';
import ViewUI from 'view-design';
import ibizLab from 'ibiz-vue-lib';
import axios from "axios";
import { AppComponentService, initNoticeHandler, Interceptors } from '@/utils';
import { Print } from '@/utils/print';
import i18n from '@/locale';
import { vueinstall } from 'ibiz-vue';
import { installPlugin } from '@/plugin/app-plugin-service';
import { Environment } from '@/environments/environment';
import format from 'vue-text-format';
import less from 'less';

import 'element-ui/lib/theme-chalk/index.css';
import 'view-design/dist/styles/iview.css';
import 'ibiz-vue-lib/lib/ibiz-vue-lib.css';
import '@/styles/default.less';
import { AppLayoutService, NoticeHandler } from 'ibiz-vue';

import VueAMap from 'vue-amap';
Vue.use(VueAMap);
AppComponentService.registerAppComponents();
AppLayoutService.registerLayoutComponent();

VueAMap.initAMapApiLoader({
  key: '6ab2751103aea67e817c90a5528181b5',
  plugin: ["AMap.Geolocation", "AMap.PlaceSearch", "AMap.Geocoder", "AMap.Autocomplete"],
  uiVersion: '1.1'
});

// 取消模型包警告输出
import  {install}  from "@ibiz/dynamic-model-api";
install();

const pathToRegExp = require('path-to-regexp');
import { AppComponents } from '@/app-register';
import { PageComponents } from '@/page-register';
import { UserComponents } from '@/user-register';
import store from '@/store';
import router from './router';
import { translate } from '@/locale/local-util';
import { AppServiceBase, Util, ViewTool } from 'ibiz-core';
import { MicroAppService } from '@/micro';
import qs from 'qs';

const win: any = window;
win.axios = axios;
vueinstall();
installPlugin();
initNoticeHandler();
//  注册环境配置
AppServiceBase.getInstance().setAppEnvironment(Environment);

// 异常处理
Vue.config.errorHandler = function (err: any, vm: any, info: any) {
  NoticeHandler.errorHandler(err, info);
}
Vue.prototype.$throw = function (err: any, fnName?: string, param?: any) {
  NoticeHandler.errorHandler(err, { param, caller: this, fnName });
};
Vue.prototype.$success = function (message: any, fnName?: string, param?: any) {
  NoticeHandler.successHandler(message, { param, caller: this, fnName });
};
Vue.prototype.$warning = function (message: any, fnName?: string, param?: any) {
  NoticeHandler.warningHandler(message, { param, caller: this, fnName });
};
Vue.prototype.$info = function (message: any, fnName?: string, param?: any) {
  NoticeHandler.infoHandler(message, { param, caller: this, fnName });
};
Vue.prototype.$tl = function (key: string, value?: string) {
  return translate(key, this, value);
};

// 解决75版本浏览器不支持replaceAll方法
String.prototype.replaceAll = function (FindText: any, RepText: any) {
  let regExp = new RegExp(FindText, "g");
  return this.replace(regExp, RepText as any);
}

Vue.config.productionTip = false;
Vue.use(Print);
Vue.use(ibizLab);
Vue.use(Vuex);
Vue.use(win.AVUE);
Vue.use(format);
Vue.use(VueRouter);;
Vue.use(ElementUi, {
  i18n: (key: any, value: any) => i18n.t(key, value)
});
Vue.use(ViewUI, {
  i18n: (key: any, value: any) => i18n.t(key, value)
});

Vue.prototype.$pathToRegExp = pathToRegExp;
Vue.use(AppComponents);
Vue.use(PageComponents);
Vue.use(UserComponents);
Vue.use(less);

router.beforeEach((to: any, from: any, next: any) => {
    if (sessionStorage.getItem('lockState') && to.path != '/lock') {
        next({ path: '/lock'});
    }else{
        if (to.meta && !to.meta.ignoreAddPage  && !to.path.endsWith('/redirectview')) {
            if (router && router.app && router.app.$store) {
                const { viewParams } = ViewTool.getViewParamsByPath(to.fullPath);
                const historyPathList = router.app.$store.state.historyPathList;
                const historyPaths: string[] = historyPathList.filter((path: string) => path.startsWith(to.path));
                let isAddPage: boolean = true;
                if (historyPaths.length > 0 && viewParams.srfnav) {
                    delete viewParams.srfnav;
                    // 除了srfnav还有其他参数
                    if (Object.keys(viewParams).length > 0) {
                        // 如果参数相同不添加新页面，
                        historyPaths.forEach((historyPath: string) => {
                            if (historyPath && historyPath.indexOf('?') > -1) {
                                const { viewParams: tempViewParams } = ViewTool.getViewParamsByPath(historyPath);
                                delete tempViewParams.srfnav;
                                if (Util.isFieldsSame(viewParams, tempViewParams)) {
                                    isAddPage = false;
                                    router.app.$store.commit('updatePage', { oldPath: historyPath, newRoute: to });
                                }
                            }
                        });
                    } else {
                        // 只有srfnav参数
                        historyPaths.forEach((historyPath: string) => {
                            if (historyPath && historyPath.indexOf('?') >= -1) {
                                const { viewParams: tempViewParams } = ViewTool.getViewParamsByPath(historyPath);
                                delete tempViewParams.srfnav;
                                if (Object.keys(tempViewParams).length == 0) {
                                    router.app.$store.commit('updatePage', { oldPath: historyPath, newRoute: to });
                                }
                            }
                        })
                        isAddPage = false;
                    }
                }
                if (isAddPage) {
                    router.app.$store.commit('addPage', to);
                }
            }
        }
        next();
    }
});

Interceptors.getInstance(router, store);

let instance:any = null;

const init = async (props:any = {}) => {
  const { container } = props;
  instance = new Vue({
      i18n,
      store,
      router,
      render: (h: any) => h(App),
  }).$mount(container?container.querySelector('#app'):'#app');
};

// 动态路由配置
if ((window as any).__POWERED_BY_QIANKUN__) {
  __webpack_public_path__ = (window as any).__INJECTED_PUBLIC_PATH_BY_QIANKUN__;
}

// 非qiankun环境直接渲染
if (!(window as any).__POWERED_BY_QIANKUN__) {
  init();
}
// 父应用已经到了子应用时的生命周期（简单来说：父应用的路由目前等于子应用的activeRule） TODO:activeRule #/child = /child
export async function bootstrap() {
  MicroAppService.getInstance().initMicroApp();
}
// 父应用已经到了子应用具体配置的路由时的生命周期（简单来说：路由地址对应的是子应用的路由地址，前置为父应用的activeRule） TODO:activeRule #/child = /child/子应用路由
export async function mount(props:any) {
  MicroAppService.getInstance().mountMicroApp(props);
  init(props);
}
// 父应用离开子应用时的生命周期（简单来说：路由不拼子应用里的）
export async function unmount() {
  MicroAppService.getInstance().destroyMicroApp({instance});
}