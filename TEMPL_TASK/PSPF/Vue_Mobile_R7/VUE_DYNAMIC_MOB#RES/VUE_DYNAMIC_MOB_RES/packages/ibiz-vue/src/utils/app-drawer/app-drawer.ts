import Vue from 'vue';
import AppDrawerComponent from "./app-drawer.vue";
import { AppServiceBase } from 'ibiz-core';

/**
 * drawer组件
 *
 * @export
 * @class AppDrawer
 */
export class AppDrawer {

    /**
     * 实例对象
     *
     * @private
     * @static
     * @memberof AppDrawer
     */
    private static drawer = new AppDrawer();

    /**
     * store对象
     *
     * @private
     * @memberof AppDrawer
     */
    private store: any;

    /**
     * i18n对象
     *
     * @private
     * @memberof AppDrawer
     */
    private i18n: any;

    /**
     * 路由对象
     *
     * @private
     * @memberof AppDrawer
     */
    private router: any;

    /**
     * Creates an instance of AppDrawer.
     * 
     * @memberof AppDrawer
     */
    private constructor() {
        if (AppDrawer.drawer) {
            return AppDrawer.drawer;
        }
    }

    /**
     * 初始化基础数据
     * 
     * @memberof AppDrawer
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
     * @returns {AppDrawer}
     * @memberof AppDrawer
     */
    public static getInstance(): AppDrawer {
        if (!AppDrawer.drawer) {
            AppDrawer.drawer = new AppDrawer();
        }
        return AppDrawer.drawer;
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
     * @memberof AppDrawer
     */
    private async createVueExample(view: any, context: any = {}, viewparams: any = {}, customProps: any = {}): Promise<any> {
        const self: any = this;
        if (!self.store || !self.i18n) {
            self.initBasicData();
        }
        let props = { view: view, context: context, viewparams: viewparams, ...customProps };
        let component = AppDrawerComponent;
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
     * @memberof AppDrawer
     */
    public async openDrawer(view: any, context: any = {}, viewparams: any = {}, customProps?: any): Promise<any> {
        const result: any = await this.createVueExample(view, context, viewparams, customProps);
        return result;
    }

}