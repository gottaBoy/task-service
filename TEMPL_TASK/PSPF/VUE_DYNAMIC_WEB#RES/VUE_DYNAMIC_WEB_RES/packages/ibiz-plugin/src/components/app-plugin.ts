import { default as VueImport } from 'vue';

export const AppPlugin = {
    install(vue: typeof VueImport) {
        vue.component('app-json-schema-editor', () => import('./app-json-schema-editor/app-json-schema-editor'));
        vue.component('app-code-editor', () => import('./app-code-editor/app-code-editor'));
        vue.component('app-preset-input', () => import('./app-preset-input/app-preset-input.vue'));
        vue.component('app-preset-title', () => import('./app-preset-title/app-preset-title.vue'));
        vue.component('app-preset-auth', () => import('./app-preset-auth/app-preset-auth.vue'));
        vue.component('app-preset-caption', () => import('./app-preset-caption/app-preset-caption.vue'));
        vue.component('app-preset-smsverification', () => import('./app-preset-smsverification/app-preset-smsverification.vue'));
        vue.component('app-preset-loginmessage', () => import('./app-preset-loginmessage/app-preset-loginmessage.vue'));
        vue.component('app-preset-qrcode', () => import('./app-preset-qrcode/app-preset-qrcode.vue'));
        vue.component('app-preset-switch', () => import('./app-preset-switch/app-preset-switch.vue'));
        vue.component('app-preset-text-input', () => import('./app-preset-text-input/app-preset-text-input.vue'));
        vue.component('app-preset-org-picker', () => import('./app-preset-org-picker/app-preset-org-picker.vue'));
        vue.component('app-preset-carousel', () => import('./app-preset-carousel/app-preset-carousel.vue'));
        vue.component('app-user-control', () => import('./app-user-control/app-user-control.vue'));
        vue.component('app-third-login', () => import('./app-third-login/app-third-login.vue'));
        vue.component('app-video', () => import('./app-video/app-video.vue'));
        vue.component('app-carousel',() => import('./app-carousel/app-carousel.vue'));
        vue.component('app-preset-rawitem', () => import('./app-preset-rawitem/app-preset-rawitem.vue'));
    },
};