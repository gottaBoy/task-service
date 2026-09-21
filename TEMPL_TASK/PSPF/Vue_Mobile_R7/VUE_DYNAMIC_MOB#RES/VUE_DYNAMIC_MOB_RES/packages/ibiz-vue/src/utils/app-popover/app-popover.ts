import Vue from 'vue';
import AppPopoverComponent from "./app-popover.vue";
import { AppServiceBase, Util } from 'ibiz-core';

/**
 * popover组件
 *
 * @export
 * @class AppPopover
 */
export class AppPopover {

    /**
     * 实例对象
     *
     * @private
     * @static
     * @memberof AppPopover
     */
    private static popover = new AppPopover();

    /**
     * store对象
     *
     * @private
     * @memberof AppPopover
     */
    private store: any;

    /**
     * i18n对象
     *
     * @private
     * @memberof AppPopover
     */
    private i18n: any;

    /**
     * 路由对象
     *
     * @private
     * @memberof AppPopover
     */
    private router: any;

    /**
     * Creates an instance of AppPopover.
     * 
     * @memberof AppPopover
     */
    private constructor() {
        if (AppPopover.popover) {
            return AppPopover.popover;
        }
    }

    /**
     * 初始化基础数据
     * 
     * @memberof AppPopover
     */
    private initBasicData() {
        const appService = AppServiceBase.getInstance();
        this.store = appService.getAppStore();
        this.i18n = appService.getI18n();
        this.router = appService.getRouter();
    }

    /**
     * 获取单例对象
     *
     * @static
     * @returns {AppPopover}
     * @memberof AppPopover
     */
    public static getInstance(): AppPopover {
        if (!AppPopover.popover) {
            AppPopover.popover = new AppPopover();
        }
        return AppPopover.popover;
    }

    /**
     * 创建 Vue 实例对象
     *
     * @private
     * @param {*} view
     * @param {*} [context={}]
     * @param {*} [viewparams={}]
     * @param {string} uuid
     * @return {*}  {Promise<any>}
     * @memberof AppPopover
     */
    private async createVueExample(view: any, context: any = {}, viewparams: any = {}, customProps: any = {}): Promise<any> {
        const self: any = this;
        if (!self.store || !self.i18n) {
            self.initBasicData();
        }
        let props = { view: view, context: context, viewparams: viewparams, ...customProps };
        let component = AppPopoverComponent;
        let vm: any = new Vue({
            store: this.store,
            i18n: this.i18n,
            router: this.router,
            render(h) {
                return h(component, { props });
            },
        }).$mount();
        let app = document.getElementById("app");
        if (app) {
            app.appendChild(vm.$el);
        }
        const comp: any = vm.$children[0];
        return new Promise((resolve, reject) => {
            const sub = comp.getSubject();
            sub.subscribe((result: any) => {
                resolve(result);
            });
        });
    }


    /**
     * 打开模态视图
     *
     * @param {*} view
     * @param {*} [context={}]
     * @param {*} [viewparams={}]
     * @return {*}  {Promise<any>}
     * @memberof AppPopover
     */
    public async openPopOver(view: any, context: any = {}, viewparams: any = {}, customProps?: any): Promise<any> {
        const result: any = await this.createVueExample(view, context, viewparams, customProps);
        return result;
    }

}