<template>
    <div id="app-html-container" class="app-html-container view-container">
        <iframe ref="iframe" :src="htmlPageUrl" :style="{ height: '100%', width: '100%', 'border-width': 0 }"></iframe>
    </div>
</template>

<script lang="ts">
import { Loading } from 'element-ui';
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppHtmlContainer extends Vue {

    /**
     * 输入参数
     *
     * @type {*}
     * @memberof AppHtmlContainer
     */
    @Prop() public dynamicProps?: any;

    /**
     * html页面
     *
     * @type {string}
     * @memberof AppHtmlContainer
     */
    public htmlPageUrl: string = '';

    /**
     * 加载组件
     *
     * @type {string}
     * @memberof AppHtmlContainer
     */
    public loadingComponent: any;

    /**
     * 组件创建时触发
     *
     * @type {*}
     * @memberof AppHtmlContainer
     */
    public created() {
        const _this: any = this;
        // 模态弹开
        if (this.dynamicProps && this.dynamicProps.viewparam) {
            const inputParams = JSON.parse(this.dynamicProps.viewparam);
            if (inputParams && inputParams.htmlPageUrl) {
                _this.htmlPageUrl = inputParams.htmlPageUrl;
            }
        } else {
            // 路由跳转
            _this.htmlPageUrl = _this.$route.params?.apphtmlview;
            const caption = _this.$route.query?.caption;
            _this.$store.commit('setCurPageCaption', {
                route: _this.$route,
                caption: caption ? caption : '应用HTML视图',
                info: ''
            });
        }
    }

    /**
     * 组件挂载时触发
     *
     * @type {*}
     * @memberof AppHtmlContainer
     */
    public mounted() {
        this.iframeLoad();
    }

    /**
     * iframe加载
     *
     * @memberof AppHtmlContainer
     */
    public iframeLoad() {
        if (!this.htmlPageUrl) {
            return;
        }
        this.beginLoading();
        const iframe: any = this.$refs.iframe;
        if (iframe.attachEvent) {
            iframe.attachEvent('onload', () => {
                this.endLoading();
            })
        } else {
            iframe.onload = () => {
                this.endLoading();
            }
        }
    }

    /**
     * 开始加载
     *
     * @memberof AppHtmlContainer
     */
    public beginLoading() {
        const selection: any = document.getElementById(`app-html-container`);
        if (!selection) {
            return;
        }
        this.loadingComponent = Loading.service({
            fullscreen: true,
            target: selection,
            customClass: 'app-loading',
        });
        // 自定义loading元素
        const userEle = `<div class="app-loading__icon">
                            <div class="app-loading__icon__content">
                                <div class="content__item is-active"></div>
                                <div class="content__item"></div>
                            </div>
                            <div class="app-loading__icon__content">
                                <div class="content__item"></div>
                                <div class="content__item"></div>
                            </div>
                        </div>`;
        const loadingEle = selection.lastChild;
        if (loadingEle) {
            loadingEle.innerHTML = userEle;
        }
    }

    /**
     * 加载结束
     *
     * @memberof AppHtmlContainer
     */
    public endLoading() {
        if (this.loadingComponent) {
            this.loadingComponent.close();
        }
    }

}
</script>
<style lang='less'>
.app-html-container {
    padding: 0px;
}
</style>