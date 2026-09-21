<template>
    <div id="app">
        <app-debug-actions />
        <router-view v-if="isRouterAlive" />
    </div>
</template>
<script lang="ts">
import { Vue, Component, Provide } from 'vue-property-decorator';
import qs from 'qs';
import { AppServiceBase } from 'ibiz-core';
import store from '@/store';
import { NotificationFactory } from 'ibiz-vue';

@Component({})
export default class App extends Vue {
    /**
     *  控制视图是否显示
     */
    public isRouterAlive: boolean = true;

    /**
     *  向后代注入加载行为
     */
    @Provide()
    public reload = this.viewreload;

    /**
     *  vue生命周期初始化
     */
    public created() {
        const APP = AppServiceBase.getInstance();
        if (!APP.getAppStore()) {
            APP.setAppStore(store);
        }
        this.initThridParam();
    }

    /**
     *  vue生命周期销毁前
     */
    public beforeDestroy(){
        NotificationFactory.getInstance().destroy();
    }

    /**
     *  视图重新加载
     */
    public viewreload() {
        const redirectedFrom:string = window.location.hash.substring(1);
        AppServiceBase.getInstance().setRedirectedFromRoute(redirectedFrom);
        this.isRouterAlive = false;
        this.$nextTick(function () {
            this.isRouterAlive = true;
        });
    }

    /**
     * 初始化第三方参数
     *
     */
    public initThridParam() {
        if (window.location && window.location.href.indexOf('?') > -1) {
            let tempViewParam: any = {};
            const tempViewparam: any = window.location.href.slice(window.location.href.lastIndexOf('?') + 1);
            const viewparamArray: Array<string> = decodeURIComponent(tempViewparam).split(';');
            if (viewparamArray.length > 0) {
                viewparamArray.forEach((item: any) => {
                    Object.assign(tempViewParam, qs.parse(item));
                });
            }
            if (tempViewParam.srffullscreen) {
                this.$store.commit('addCustomParam', { tag: 'srffullscreen', param: tempViewParam.srffullscreen });
            }
            if (tempViewParam.srftoken) {
                sessionStorage.setItem('srftoken', tempViewParam.srftoken);
            }
        }
    }
}
</script>
<style lang='less'>
    #app{
        width: 100vw;
        height: 100vh;
    }
</style>