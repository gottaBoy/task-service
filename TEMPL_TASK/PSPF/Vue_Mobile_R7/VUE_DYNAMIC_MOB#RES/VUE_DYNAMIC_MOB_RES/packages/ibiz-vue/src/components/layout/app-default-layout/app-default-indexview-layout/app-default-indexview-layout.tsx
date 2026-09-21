import { Component } from 'vue-property-decorator';
import { IPSAppMenu } from '@ibiz/dynamic-model-api';
import { ModelTool } from 'ibiz-core';
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";


@Component({})
export default class AppDefaultIndexViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultIndexViewLayout
     */
    public engineInit(opts: any = {}): void {
        const menuInstance = (this.containerModel.findPSControl(ModelTool.findPSControlByType("APPMENU", this.containerModel.getPSControls()))) as IPSAppMenu;
        this.engine.init({
            view: this,
            menu: (this.$refs[menuInstance.name] as any).ctrl,
        });
        this.engine.load();
    }

    /**
     * 当前主题
     *
     * @memberof AppDefaultIndexViewLayout
     */
    public selectTheme() {
        let _this: any = this;
        if (_this.$router.app.$store.state.selectTheme) {
            return _this.$router.app.$store.state.selectTheme;
        } else if (localStorage.getItem('theme-class')) {
            return localStorage.getItem('theme-class');
        } else {
            return 'app-dark-blue-theme';
        }
    }

    /**
     * 初始化
     * 
     * @memberof AppDefaultIndexViewLayout 
     */
    public created() {
        let className = this.selectTheme();
        if (document.getElementsByTagName('html')[0] && document.getElementsByTagName('html')[0].classList) {
            document.getElementsByTagName('html')[0].classList.add(className);
        }
        // 初始化视图容器样式
        this.initRenderOptions();
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof AppDefaultIndexViewLayout
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.staticProps, { viewState: this.viewState, viewtag: this.viewtag, viewIsProxyMode: this.viewProxyMode });
        Object.assign(targetCtrlEvent, {
            closeView: ($event: any) => {
                this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewClosed', data: $event });
            }
        })
        const { codeName, defaultPage, name } = this.viewInstance;
        Object.assign(targetCtrlParam.staticProps, {
            viewName: codeName,
            isDefaultPage: defaultPage,
            name: name,

        })
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent }
    }



    /**
     * 绘制主体内容
     *
     * @return {*}  {*}
     * @memberof AppDefaultIndexViewLayout
     */
    public renderContent(): any {
        return (
            <div class='app-content'>
                <div class='app-content__body'>
                    {this.$slots.embedview}
                </div>
                <div class="app-content__footer">
                    {this.$slots.default}
                </div>
            </div>
        );
    }


    /**
     * 绘制布局
     * 
     * @memberof AppDefaultIndexViewLayout
     */
    public render(h: any) {
        const { viewClassNames } = this.renderOptions;
        return <div class={viewClassNames}>
            {this.viewIsInit ? (this.viewLayoutPanel && this.viewLayoutPanel?.useDefaultLayout) ? this.renderContent() : this.renderViewLayoutPanel() : this.renderInitLoading()}
        </div>;
    }

}