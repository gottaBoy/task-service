import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { AppServiceBase } from 'ibiz-core';
import { AppIndexViewShell } from 'ibiz-vue';
import { globalRoutes, indexRoutes } from './route';
Vue.use(Router);

const router:Router = new Router({
    routes: [
        {
            path: '/index/:index?',
            name: 'index',
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
            meta: {  
                captionTag: '',
                caption: '',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'views', parameterName: 'index' },
                ],
                requireAuth: false,
            },
            component: AppIndexViewShell,
            children: [
            {
                path: 'appredirectview',
                meta: {
                    captionTag: '',  
                    caption: '全局应用重定向视图',
                    viewType: 'REDIRECTVIEW',
                    requireAuth: false,
                    ignoreAddPage: true,
                    parameters: [
                      { pathName: 'appredirectview', parameterName: 'appredirectview' },
                      { pathName: 'views', parameterName: 'view' },
                    ],
                },
                component: () => import('@components/app-redirect-view/app-redirect-view.vue'),
            },
            {
                path: 'apphtmlview/:apphtmlview?',
                meta: {
                    captionTag: '',  
                    caption: '应用HTML视图',
                    viewType: 'REHTMLVIEW',
                    requireAuth: false,
                    ignoreAddPage: false,
                    parameters: [
                      { pathName: 'apphtmlview', parameterName: 'apphtmlview' },
                      { pathName: 'views', parameterName: 'view' },
                    ],
                },
                component: () => import('@components/app-html-container/app-html-container.vue'),
            },
            {
                path: 'asyncmessage/:actionid?/preview',
                meta: {
                    captionTag: '',  
                    caption: '数据导入详情',
                    requireAuth: false,
                    parameters: [
                        { pathName: 'asyncmessage', parameterName: 'asyncmessage' },
                        { pathName: 'views', parameterName: 'view' },
                    ],
                },
                component: () => import('@/components/app-async-message/app-async-message.vue'),
            },
            ...indexRoutes,
            ],
        },
        ...globalRoutes,
        {
            path: '/login/:login?',
            name: 'login',
            meta: {
                captionTag: '',
                caption: '登录',
                viewType: 'login',
                requireAuth: false,
                ignoreAddPage: true,
            },
            beforeEnter: (to: any, from: any, next: any) => {
                router.app.$store.commit('resetRootStateData');
                next();
            },
            component: () => import('@components/login/login.vue'),
        },
        {
            path: '/lock',
            name: 'lock',
            meta: {  
                captionTag: '',
                caption: '锁屏',
                viewType: 'lock',
                requireAuth: false,
                ignoreAddPage: true,
            },
            component: () => import('@components/app-lock/app-lock.vue'),
        },
        {
            path: '/appredirectview',
            name: 'appredirectview',
            meta: {
                captionTag: '',  
                caption: '全局应用重定向视图',
                viewType: 'REDIRECTVIEW',
                requireAuth: false,
                ignoreAddPage: true,
            },
            component: () => import('@components/app-redirect-view/app-redirect-view.vue'),
        },
        {
            path: '/todoredirect',
            name: 'todoredirect',
            meta: {
                captionTag: '',  
                caption: '全局待办重定向视图',
                viewType: 'REDIRECTVIEW',
                requireAuth: false,
                ignoreAddPage: true,
            },
            component: () => import('@components/todo-redirect/todo-redirect.vue'),
        },
        {
            path: '/404',
            meta: {  
                caption: '404',
                ignoreAddPage: true,
                requireAuth: false
            },
            component: () => import('@components/404/404.vue')
        },
        {
            path: '/500',
            meta: {  
                caption: '500',
                ignoreAddPage: true,
                requireAuth: false
            },
            component: () => import('@components/500/500.vue')
        },
        {
            path: '/appsharepage',
            meta: {
                caption: '应用分享页',
                requireAuth: true,
                ignoreAddPage: true
            },
            component: () => import('@components/app-share-page/app-share-page.vue')
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