import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { Util, AppServiceBase } from "ibiz-core";
import { AppLoadingService } from "../../../../app-service/loading-service/app-loading-service";
import { IPSAppIndexView } from "@ibiz/dynamic-model-api";

@Component({})
export class AppDefaultIndexViewLayout extends AppDefaultViewLayout {

    /**
     * 应用loading服务
     *
     * @memberof AppLayout
     */
    public appLoadingService = AppLoadingService.getInstance();

    /**
     * 当前应用是否为微应用
     *
     * @memberof AppDefaultIndexViewLayout
     */
    public isMicroApp: boolean = false;

    /**
     * 初始化视图的绘制参数
     *
     * @memberof AppDefaultIndexViewLayout
     */
    public initRenderOptions(opts: any = {}) {
        this.renderOptions = {};
        const { viewType, viewStyle, codeName } = this.viewInstance;
        const viewClassNames: any = {
            [`view-style-${viewStyle.toLowerCase()}`]: true,
            'app-container': true,
            [viewType?.toLowerCase()]: true,
            [Util.srfFilePath2(codeName)]: true,
        };
        if (this.viewProxyMode) {
            Object.assign(viewClassNames, { 'isproxy': true });
        }
        Object.assign(viewClassNames, opts);
        if (this.viewInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(viewClassNames, { [this.viewInstance.getPSSysCss()?.cssName]: true });
        }
        // 应用首页菜单方向
        if (this.viewInstance.mainMenuAlign) {
            Object.assign(viewClassNames, { [`app-vc-menu--${this.viewInstance.mainMenuAlign.toLowerCase()}`]: true });
        } else {
            Object.assign(viewClassNames, { [`app-vc-menu--left`]: true });
        }
        // 应用首页tab/应用首页路由
        if (Object.is(this.viewInstance.viewStyle, 'DEFAULT')) {
            Object.assign(viewClassNames, { [`app-content--tab`]: true });
        } else {
            Object.assign(viewClassNames, { [`app-content--route`]: true });
        }
        this.$set(this.renderOptions, 'viewClassNames', viewClassNames);
    }

    /**
     * 路由列表
     * 
     * @memberof AppDefaultIndexViewLayout 
     */
    get routerList() {
        return this.$store.state.historyPathList;
    }

    /**
     * 路由键值
     * 
     * @memberof AppDefaultIndexViewLayout 
     */
    get routerViewKey() {
        let _this: any = this;
        return _this.$route.fullPath;
    }

    /**
     * 是否满屏
     *
     * @type {boolean}
     * @memberof IndexViewBase
     */
    public isFullScreen: boolean = false;

    /**
     * 菜单收缩变化
     *
     * @type {boolean}
     * @memberof AppDefaultIndexViewLayout
     */
    public collapseChange: boolean = false;

    /**
     * 抽屉状态
     *
     * @type {boolean}
     * @memberof AppDefaultIndexViewLayout
     */
    public contextMenuDragVisiable: boolean = false;

    /**
     * 容器挂载完成(重写)
     *
     * @memberof AppDefaultIndexViewLayout
     */
    public containerMounted() {
        if (this.viewProxyMode) {
            super.containerMounted();
            this.$emit('view-event', { viewname: this.viewInstance.name, action: 'viewIsMounted', data: true })
            this.handleContainerPreEvent('onViewMounted').then((result: boolean) => {
                if (!result) {
                    return;
                }
                if (this.viewState) {
                    this.viewState.next({ tag: 'appmenu', action: 'load', data: {} });
                }
                this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewIsInited', data: null });
            })
        }
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
            return 'app-theme-default';
        }
    }

    /**
     * 获取当前语言环境
     *
     * @memberof AppDefaultIndexViewLayout
     */
    public getSelectLanguage() { }

    /**
     * 菜单收缩
     *
     * @memberof AppDefaultIndexViewLayout
     */
    public collapseMenus() {
        if (this.$store.getters['getCustomParamByTag']('srffullscreen')) {
            this.isFullScreen = !this.isFullScreen;
            if (this.isFullScreen) {
                this.collapseChange = true;
            } else {
                this.collapseChange = false;
            }
        } else {
            this.collapseChange = !this.collapseChange;
        }
        this.$emit('onCollapseChange', this.collapseChange);
    }

    /**
     * 是否显示标题栏
     *
     * @readonly
     * @memberof AppDefaultViewLayout
     */
    get showCaption() {
        if (this.viewInstance && this.$parent && Util.isExist(this.viewInstance.showCaptionBar)) {
            return this.viewInstance.showCaptionBar && !(this.$parent as any).noViewCaption
        } else {
            return true;
        }
    }

    /**
     * 初始化
     * 
     * @memberof AppDefaultIndexViewLayout 
     */
    public created() {
        document.getElementsByTagName('html')[0].className = this.selectTheme();
        this.isFullScreen = Boolean(this.$store.getters['getCustomParamByTag']('srffullscreen'));
        const microAppService = AppServiceBase.getInstance().getMicroAppService();
        if (microAppService) {
            this.isMicroApp = microAppService.getIsMicroApp();
        }
    }

    /**
     * 渲染左侧菜单样式
     * 
     * @memberof AppDefaultIndexViewLayout
     */
    public renderContentLeft() {
        return (
            <layout>
                {
                    !this.isMicroApp ? <header class="app-header">
                        <div class="app-header__left" >
                                <div class="app-header__left__logo">
                                    {(this.viewInstance as IPSAppIndexView).enableAppSwitch ? <span class="logo__menuicon" on-click={() => this.contextMenuDragVisiable = !this.contextMenuDragVisiable}><icon type="md-menu" />&nbsp;</span> : null}
                                    {(this.viewInstance as IPSAppIndexView).appIconPath ? <img class="logo__image" src={(this.viewInstance as IPSAppIndexView).appIconPath}></img> : null}
                                    {this.showCaption ? <span class="logo__title">{this.model.srfCaption}</span> : null}
                                    {(this.viewInstance as IPSAppIndexView).enableAppSwitch ? <context-menu-drag viewStyle={this.viewInstance.viewStyle} contextMenuDragVisiable={this.contextMenuDragVisiable}></context-menu-drag> : null}
                                </div>
                                {!this.collapseChange ? <i class="ivu-icon el-icon-s-fold" on-click={() => this.collapseMenus()}></i> : null}
                                {this.collapseChange ? <i class="ivu-icon el-icon-s-unfold" on-click={() => this.collapseMenus()}></i> : null}
                                {Object.is(this.viewInstance.viewStyle, 'STYLE4') ? <app-breadcrumb indexViewTag={this.viewInstance.codeName} /> : null}
                        </div>
                        <div class="app-header__right">
                            <app-header-menus />
                            {this.Environment.showLang && <app-lang title={this.model.srfTitle || this.model.srfCaption} />}
                            {this.Environment.showOrg && <app-orgsector />}
                            <app-user viewStyle={this.viewInstance.viewStyle} />
                            <app-message-popover />
                            <app-full-scren />
                        </div>
                    </header> : null
                }
                <layout class="app-content">
                    <sider class="app-content__left" width={this.isMicroApp ? 0 : this.isFullScreen ? 0 : this.collapseChange ? 68 : 200} hide-trigger value={this.collapseChange}>
                        {this.$slots.default}
                    </sider>
                    <content class="app-content__right" style={{'width':this.isMicroApp ? 'calc(100% - 0px)' : this.isFullScreen ? 'calc(100% - 0px)' : this.collapseChange ? 'calc(100% - 68px)' : 'calc(100% - 200px)'}}>
                        {Object.is(this.viewInstance.viewStyle, 'DEFAULT') ? <tab-page-exp style={{ display: this.isMicroApp ? 'none' : 'block' }} modelService={this.modelService}></tab-page-exp> : null}
                        <app-nav-pos enableCache={true}></app-nav-pos>
                    </content>
                </layout>
            </layout>
        );
    }

    /**
     * 渲染无菜单样式
     * 
     * @memberof AppDefaultIndexViewLayout
     */
    public renderContentOnly() {
        return (
            <layout style={{ 'height': '100vh' }}>
                <header class="app-header">
                    <div class="app-header__left" >
                        <div class="app-header__left__logo">
                                {(this.viewInstance as IPSAppIndexView).enableAppSwitch ? <span class="logo__menuicon" on-click={() => this.contextMenuDragVisiable = !this.contextMenuDragVisiable}><icon type="md-menu" />&nbsp;</span> : null}
                                {(this.viewInstance as IPSAppIndexView).appIconPath ? <img class="logo__image" src={(this.viewInstance as IPSAppIndexView).appIconPath}></img> : null}
                                {this.showCaption ? <span class="logo__title">{this.model.srfCaption}</span> : null}
                                {(this.viewInstance as IPSAppIndexView).enableAppSwitch ? <context-menu-drag viewStyle={this.viewInstance.viewStyle} contextMenuDragVisiable={this.contextMenuDragVisiable}></context-menu-drag> : null}
                        </div>
                    </div>
                    <div class="app-header-right">
                        <app-header-menus />
                        { this.Environment.showLang && <app-lang title={this.model.srfTitle || this.model.srfCaption} style='font-size: 15px;padding: 0 10px;' />}
                        { this.Environment.showOrg && <app-orgsector /> }
                        <app-user viewStyle={this.viewInstance.viewStyle} />
                        <app-message-popover />
                        <app-full-scren />
                    </div>
                </header>
                <layout class="app-content">
                    <sider class="app-content__left" hide-trigger value={this.collapseChange}>
                        {this.$slots.default}
                    </sider>
                    <content class='app-content__content'>
                        <app-nav-pos enableCache={true}></app-nav-pos>
                    </content>
                </layout>
            </layout>
        );
    }

    /**
     * 渲染顶部菜单样式
     * 
     * @memberof AppDefaultIndexViewLayout
     */
    public renderContentTop() {
        return (
            <layout>
                <header class="app-header" >
                    <div class="app-header__left">
                        <div class="app-header__left__logo">
                            {(this.viewInstance as IPSAppIndexView).appIconPath ? <img class="logo__image" src={(this.viewInstance as IPSAppIndexView).appIconPath}></img> : null}
                            {this.showCaption ? <span class="logo__title">{this.model.srfCaption}</span> : null}
                        </div>
                        {this.$slots.default}
                    </div>
                    <div class="app-header__right">
                        <app-header-menus />
                        {this.Environment.showLang && <app-lang title={this.model.srfTitle || this.model.srfCaption}></app-lang>}
                        {this.Environment.showOrg && <app-orgsector></app-orgsector>}
                        <app-user viewStyle={this.viewInstance.viewStyle}></app-user>
                        <app-message-popover></app-message-popover>
                        <app-full-scren />
                    </div>
                </header>
                <content class={'app-content'} on-click={() => this.contextMenuDragVisiable = false}>
                    <tab-page-exp style={{ display: this.isMicroApp ? 'none' : 'block' }} modelService={this.modelService}></tab-page-exp>
                    <app-nav-pos enableCache={true}></app-nav-pos>
                </content>
            </layout>
        );
    }

    /**
     * 渲染中间菜单样式
     * 
     * @memberof AppDefaultIndexViewLayout
     */
    public renderContentMiddle() {
        return (
            <card disHover={true} bordered={false}>
                {this.showCaption ? <div slot='title' class='app-header'>
                    <span class='app-header__caption'>{this.model.srfCaption}</span>
                </div> : null}
                <div class='app-content'>
                    {this.$slots.default}
                </div>
            </card>
        );
    }

    /**
     * 渲染分页导航菜单样式
     *
     * @return {*} 
     * @memberof AppDefaultIndexViewLayout
     */
    public renderContentTabexpView() {
        return (
            <div class='app-content'>
                {this.$slots.default}
            </div>
        );
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultIndexViewLayout
     */
    public renderContent(): any {
        return [
            (Object.is(this.viewInstance.mainMenuAlign, "LEFT") || !this.viewInstance.mainMenuAlign) ? this.renderContentLeft() : null,
            Object.is(this.viewInstance.mainMenuAlign, "TOP") ? this.renderContentTop() : null,
            Object.is(this.viewInstance.mainMenuAlign, "CENTER") ? this.renderContentMiddle() : null,
            Object.is(this.viewInstance.mainMenuAlign, 'TABEXP_LEFT') || Object.is(this.viewInstance.mainMenuAlign, 'TREEEXP') ? this.renderContentTabexpView() : null,
            Object.is(this.viewInstance.mainMenuAlign, 'TABEXP_TOP') ? this.renderContentTabexpView() : null,
            Object.is(this.viewInstance.mainMenuAlign, 'TABEXP_RIGHT') ? this.renderContentTabexpView() : null,
            Object.is(this.viewInstance.mainMenuAlign, 'TABEXP_BOTTOM') ? this.renderContentTabexpView() : null,
            Object.is(this.viewInstance.mainMenuAlign, "NONE") ? this.renderContentOnly() : null,
        ];
    }

    /**
     * 绘制布局
     * 
     * @memberof AppDefaultIndexViewLayout
     */
    public render(h: any): any {
        const { viewClassNames } = this.renderOptions;
        return (
            <div class={viewClassNames}>
                {/* {(this.viewInstance as IPSAppIndexView)?.defaultPage && <div class="loading-bar" v-notification-signal={this.appLoadingService.isLoading}></div>} */}
                <app-studioaction
                    viewInstance={this.viewInstance}
                    context={this.context}
                    viewparams={this.viewparams}
                    viewName={this.viewInstance.codeName.toLowerCase()}
                    viewTitle={this.model?.srfCaption} />
                {this.viewIsInit ? (this.viewLayoutPanel && this.viewLayoutPanel.useDefaultLayout) ? this.renderContent() : this.renderViewLayoutPanel() : this.renderInitLoading()}
            </div>
        );
    }
}