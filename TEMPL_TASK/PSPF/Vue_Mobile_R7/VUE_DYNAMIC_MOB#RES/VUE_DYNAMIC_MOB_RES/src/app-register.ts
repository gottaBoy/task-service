import Vue from 'vue';
import { Http, Util, Verify, ViewTool } from 'ibiz-core';
import { AppModal, AppDrawer, AppPopover } from 'ibiz-vue';
import { ComponentsRegister } from 'ibiz-vue';
Vue.use(ComponentsRegister);
import { PluginRegister } from './plugin/app-plugin-register';
import { AppPlugin } from 'ibiz-plugin';

Vue.use(AppPlugin);
Vue.use(PluginRegister);

/**
 * Vue插件
 */
export const AppComponents = {
    install(v: any, opt: any) {
        v.prototype.$http = Http.getInstance();
        v.prototype.$util = Util;
        v.prototype.$verify = Verify;
        v.prototype.$appdrawer = AppDrawer.getInstance();
        v.prototype.$appmodal = AppModal.getInstance();
		v.prototype.$apppopover = AppPopover.getInstance();
        v.prototype.$viewTool = ViewTool;
        v.component('app-cur-org-dept', () => import('./components/app-cur-org-dept/app-cur-org-dept.vue'));
    },
};