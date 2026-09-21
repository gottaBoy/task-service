import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes } from './router/index';
import { AppIndexViewShell, AppRootViewShell } from 'ibiz-vue';
import { AppServiceBase } from 'ibiz-core';
Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/index',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'index';
                const params: any = {};
                if (to.params && to.params[routerParamsName]) {
                    Object.assign(params, qs.parse(to.params[routerParamsName], { delimiter: ';' }));
                }
                const url: string = '/appdata';
                const auth: Promise<any> = AuthGuard.getInstance().authGuard(url, params, router);
                auth.then((result) => {
                    if (result && to && to.redirectedFrom && to.redirectedFrom !== '/' && to.redirectedFrom !== '/*' && to.redirectedFrom.startsWith('/index')) {
                        AppServiceBase.getInstance().setRedirectedFromRoute(to.redirectedFrom);
                    }else{
                        AppServiceBase.getInstance().setRedirectedFromRoute('');
                    }
                    next(result ? true : false);
                }).catch(() => {
                    next(false);
                });
            },
            name: 'index',
            meta: {
                caption: '',
                info: '',
                viewType: 'ROOT',
                imgPath: '',
                iconCls: '',
                parameters: [
                    { pathName: 'views', parameterName: 'index' },
                ],
                requireAuth: true,
            },
            component: AppRootViewShell,
            children: [
                {
                    path: '',
                    meta: {
                        caption: '',
                        info: '',
                        viewType: 'APPINDEX',
                        imgPath: '',
                        iconCls: '',
                        parameters: [
                            { pathName: 'views', parameterName: 'index' },
                        ],
                        requireAuth: true,
                    },
                    component: AppIndexViewShell
                },
                {
                    path: '/appredirectview',
                    name: 'appredirectview',
                    meta: {
                        caption: '全局应用重定向视图',
                        viewType: 'REDIRECTVIEW',
                        requireAuth: false,
                        ignoreAddPage: true,
                    },
                    component: () => import('@components/app-redirect-view/app-redirect-view.vue')
                },
                ...indexRoutes,
            ]
        },
        ...globalRoutes,
        {
            path: '/login/:login?',
            name: 'login',
            meta: {
                caption: '登录',
                viewType: 'login',
                requireAuth: false,
                ignoreAddPage: true,
            },
            beforeEnter: (to: any, from: any, next: any) => {
                router?.app?.$store?.commit('resetRootStateData');
                next();
            },
            component: () => import('@components/login/login.vue')
        },
        {
            path: '/404',
            component: () => import('@components/404/404.vue')
        },
        {
            path: '/500',
            component: () => import('@components/500/500.vue')
        },
        {
            path: '*',
            redirect: 'index'
        },
    ],
});


// 解决路由跳转路由重复时报错
const originalPush = Router.prototype.push
Router.prototype.push = function push(location: any) {
    let result: any = originalPush.call(this, location);
    return result.catch((err: any) => err);
}
export default router;
