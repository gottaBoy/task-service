import { Component } from 'vue-property-decorator';
import { AppServiceBase, Util } from "ibiz-core";
import { AppLoadingService, AppNavHistory } from "../../../../app-service";
import { AppStyle2DefaultLayout } from "../app-style2-default-layout/app-style2-default-layout";
import { IPSAppMenu } from '@ibiz/dynamic-model-api';

@Component({})
export class AppStyle2IndexViewLayout extends AppStyle2DefaultLayout {

    /**
     * 应用loading服务
     *
     * @memberof AppLayout
     */
     public appLoadingService = AppLoadingService.getInstance();
     
    /**
     * 菜单实例
     * 
     * @memberof AppStyle2IndexViewLayout
     */
    public menuInstance!: IPSAppMenu;

    /**
     * 抽屉状态
     *
     * @type {boolean}
     * @memberof AppStyle2IndexViewLayout
     */
    public contextMenuDragVisiable: boolean = false;

    /**
     * 导航服务
     * 
     * @memberof TabPageExpStyle2
     */
    protected navHistory: AppNavHistory = AppServiceBase.getInstance().getAppNavDataService();

    /**
     * 是否显示标题栏
     *
     * @readonly
     * @memberof AppDefaultViewLayout
     */
     get showCaption(){
      if(this.viewInstance && this.$parent && Util.isExist(this.viewInstance.showCaptionBar)){
          return this.viewInstance.showCaptionBar && !(this.$parent as any).noViewCaption
      }else{
          return true;
      }
    }

    /**
     * 路由列表
     * 
     * @memberof AppStyle2IndexViewLayout 
     */
    get routerList() {
        if(this.navHistory?.historyList?.length > 0){
            let temp: any = [];
            this.navHistory?.historyList.forEach((item: any)=>{
                temp.push(item.to.fullPath);
            })
            return temp;
        }else{
            return [];
        }
    }

    /**
     * 当前主题
     *
     * @memberof AppStyle2IndexViewLayout
     */
    public selectTheme() {
        let _this: any = this;
        if (_this.$router.app.$store.state.selectTheme) {
            return _this.$router.app.$store.state.selectTheme;
        } else if (localStorage.getItem('theme-class')) {
            return localStorage.getItem('theme-class');
        } else {
            return 'app-theme-studio-dark';
        }
    }

    /**
     * 路由键值
     * 
     * @memberof AppStyle2IndexViewLayout 
     */
    get routerViewKey() {
        let _this: any = this;
        return _this.$route.fullPath;
    }

    /**
     * 初始化
     * 
     * @memberof AppStyle2IndexViewLayout
     */
    public created() {
        document.getElementsByTagName('html')[0].className = this.selectTheme();
        this.$uiState.changeLayoutState({
            styleMode: 'DEFAULT'
        });
    }

    /**
     * 初始化完毕
     * 
     * @memberof AppStyle2IndexViewLayout
     */
    public mounted() {
        setTimeout(() => {
            const el = document.getElementById('app-loading-x');
            if (el) {
                el.style.display = 'none';
            }
        }, 300);
    }

    /**
     * 初始化类名
     * 
     * @memberof AppStyle2IndexViewLayout
     */
    public initRenderOptions(opts: any = {}) {
        this.renderOptions = {};
        const { viewType, viewStyle, codeName } = this.viewInstance;
        const viewClassNames: any = {
            'app-style2-container': true
        };
        if (viewType) {
            Object.assign(viewClassNames, { [viewType?.toLowerCase()]: true });
        }
        if (viewStyle) {
            Object.assign(viewClassNames, { [`app-style-${viewStyle.toLowerCase()}`]: true });
        } else {
            Object.assign(viewClassNames, { [`app-style-default`]: true });
        }
        if (codeName) {
            Object.assign(viewClassNames, { [Util.srfFilePath2(codeName)]: true });
        }
        if (this.viewInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(viewClassNames, { [this.viewInstance.getPSSysCss()?.cssName]: true });
        }
        if (!this.showCaption) {
            Object.assign(viewClassNames, { 'nocaption': true });
        }
        Object.assign(viewClassNames, opts);
        this.$set(this.renderOptions, 'viewClassNames', viewClassNames);
    }

    /**
     * 绘制内容
     * 
     * @memberof AppStyle2IndexViewLayout
     */
    public render(h: any): any {
        const { viewClassNames } = this.renderOptions;
        if (this.viewInstance && this.viewInstance.mainMenuAlign && Object.is(this.viewInstance.mainMenuAlign, "CENTER")) {
            const { codeName } = this.viewInstance;
            return (<studio-view
                viewName={codeName?.toLowerCase()}
                viewTitle={this.model.srfCaption}
                viewInstance={this.viewInstance}
                viewparams={this.viewparams}
                context={this.context}
                class={viewClassNames}>
                {this.$slots.default}
            </studio-view>)
        } else {
            let leftContent = this.$slots.leftNavMenu;
            return (
                <div ref="appLayout" class={viewClassNames}>
                    <app-style2-header>
                        <template slot="left">
                            <div class="app-style2-header__left__caption">
                                {this.viewInstance.enableAppSwitch ? <span class="caption__icon" on-click={() => this.contextMenuDragVisiable = !this.contextMenuDragVisiable}><icon type="md-menu" />&nbsp;</span> : null}
                                {this.showCaption ? this.model.srfCaption : null}
                            </div>
                        </template>
                        <template slot="right">
                            {this.$slots.headerMenus}
                            {this.$topRenderService.rightItemsRenders.map((fun: any) => fun(h))}
                            <app-lang title={this.model.srfTitle || this.model.srfCaption}></app-lang>
                            {<app-orgsector />}
                            {<app-user viewStyle={this.viewInstance.viewStyle} />}
                        </template>
                    </app-style2-header>
                    {this.viewInstance.enableAppSwitch ? <context-menu-drag viewStyle={this.viewInstance.viewStyle} contextMenuDragVisiable={this.contextMenuDragVisiable}></context-menu-drag> : null}
                    <div class="app-style2-content">
                        <div class="app-style2-content__left">{this.$slots.leftNavMenu}</div>
                        <div class="app-style2-content__right">
                            <div class="app-style2-content__top">{this.$slots.tabPageExp}</div>
                            <div class="app-style2-content__body" on-click={() => this.contextMenuDragVisiable = false}>
                                <app-keep-alive routerList={this.routerList}>
                                    <router-view key={this.routerViewKey}></router-view>
                                </app-keep-alive>
                            </div>
                        </div>
                    </div>
                    { this.viewInstance.defaultPage 
                        ? <app-style2-footer v-notification-signal={this.appLoadingService.isLoading} ref="footer" />
                        : <app-style2-footer ref="footer" />
                    }
                </div>
            );
        }

    }
}