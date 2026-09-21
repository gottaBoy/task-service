import { Vue, Component, Prop } from 'vue-property-decorator';
import { AppServiceBase, ModelTool, Util } from 'ibiz-core';
import { IPSDEToolbar } from '@ibiz/dynamic-model-api';

@Component({})
export class AppStyle2DefaultLayout extends Vue {
    
    /**
     * 视图实例对象
     * 
     * @protected
     * @type {*}
     * @memberof AppStyle2DefaultLayout
     */
    @Prop() protected viewInstance!: any;

    /**
     * 应用上下文
     * 
     * @public
     * @type {*}
     * @memberof AppStyle2DefaultLayout
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     * 
     * @public
     * @type {*}
     * @memberof AppStyle2DefaultLayout
     */
    @Prop() public viewparams!: any;

    /**
     * 模型服务对象
     * 
     * @memberof AppStyle2DefaultLayout
     */
    @Prop() public modelService!:any;

    /**
     * 视图模型数据
     * 
     * @memberof AppStyle2DefaultLayout
     */
     @Prop() public model!: any;

    /**
     * 当前字体
     *
     * @memberof AppStyle2DefaultLayout
     */
    get selectFont() {
        const appStore: any = AppServiceBase.getInstance().getAppStore();
        if (appStore && appStore.state) {
            return appStore.state.selectFont;
        } else if (localStorage.getItem('font-family')) {
            return localStorage.getItem('font-family');
        } else {
            return 'Microsoft YaHei';
        }
    }

    /**
     * 绘制参数
     *
     * @readonly
     * @memberof AppStyle2DefaultLayout
     */
    public renderOptions: any = {
        viewClassNames: {}
    };

    /**
     * 是否展示视图工具栏
     * 
     * @memberof AppStyle2DefaultLayout
     */
    public viewIsshowToolbar: boolean = false;

    /**
     * @description Vue生命周期，实例创建完成
     * @memberof AppStyle2DefaultLayout
     */
    public created() {
        if(this.viewInstance){
            this.initRenderOptions();
            const viewToolBar: IPSDEToolbar = ModelTool.findPSControlByType("TOOLBAR", this.viewInstance?.getPSControls());
            if (viewToolBar && viewToolBar.getPSDEToolbarItems()) {
                this.viewIsshowToolbar = true;
            } else {
                this.viewIsshowToolbar = false;
            }
        }
    }

    /**
     * 初始化类名
     * 
     * @memberof AppStyle2DefaultLayout
     */
    public initRenderOptions(opts: any = {}) {
        this.renderOptions = {};
        const { viewType, viewStyle, codeName } = this.viewInstance;
        const viewClassNames: any = {
            'view-style2-container': true
        };
        if (viewType) {
            Object.assign(viewClassNames, { [viewType?.toLowerCase()]: true });
        }
        if (viewStyle) {
            Object.assign(viewClassNames, { [`view-style-${viewStyle.toLowerCase()}`]: true });
        } else {
            Object.assign(viewClassNames, { [`view-style-default`]: true });
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
        if (this.$uiState.layoutState.styleMode) {
            Object.assign(viewClassNames, { 'view-style2-mode': Object.is(this.$uiState.layoutState.styleMode, 'STYLE2') });
        }
        Object.assign(viewClassNames, opts);
        this.$set(this.renderOptions, 'viewClassNames', viewClassNames);
    }

    /**
     * 是否显示标题栏
     *
     * @readonly
     * @memberof AppStyle2DefaultLayout
     */
    get showCaption(){
        if(this.viewInstance && this.$parent && Util.isExist(this.viewInstance.showCaptionBar)){
            return this.viewInstance.showCaptionBar && !(this.$parent as any).noViewCaption
        }else{
            return true;
        }
    }

    /**
     * 绘制视图标题
     *  
     * @memberof AppStyle2DefaultLayout
     */
    public renderViewCaption() {
        const { viewSysImage } = this.viewInstance;
        if(this.showCaption) {
            return (
                <div slot="title">
                    {viewSysImage?.cssClass && viewSysImage.cssClass != '' ? 
                        <span class="caption__image">
                            <i class={viewSysImage.cssClass}></i>
                        </span> : 
                        viewSysImage?.imagePath && viewSysImage.imagePath != '' ? 
                            <span class="caption__image">
                                <img src={viewSysImage.imagePath}></img>
                            </span> : null}
                    <span class="caption__info">{this.$slots.captionInfo?this.$slots.captionInfo:this.model.srfCaption}</span>
                </div>
            );
        }
    }

    /**
     * 绘制视图内容
     *
     * @protected
     * @returns {*}
     * @memberof StudioViewBase
     */
    protected renderContent(): any {
        return [
            (this.$slots.title || (this.viewIsshowToolbar && this.$slots.toolbar) || this.$slots.quickSearch) && (
                <div class='view-header'>
                    {this.renderViewHeader()}
                </div>
            ),
            <div class='view-content'>
                {this.renderViewContent()}
            </div>,
            this.$slots.footer && (
                <div class="view-footer">
                    {this.renderViewFooter()}
                </div>
            )
        ]
    }

    /**
     * @description 视图头部
     * @return {*} 
     * @memberof StudioViewBase
     */
     public renderViewHeader() {
        return [
            <div class="view-header__left">
                {this.$slots.title ? <div class="view-header__left__caption">{this.$slots.title}</div> : null}
                {this.$slots.quickGroupSearch ? <div class="view-header__left__quickgroup">{this.$slots.quickGroupSearch}</div> : null}
            </div>,
            this.$slots.quickSearch || (this.viewIsshowToolbar && this.$slots.toolbar) ?
                <div class="view-header__right">
                    <div class="view-header__right__quicksearch">
                        {this.$slots.quickSearch}
                    </div>
                    {this.viewIsshowToolbar ? <div class="view-header__right__toolbar">{this.$slots.toolbar}</div> : null}
                </div> : null
        ]
    }

    /**
     * 绘制正文内容
     * 
     * @memberof StudioViewBase
     */
    public renderViewContent(): any {
        return [
            this.$slots.topMessage || (this.$slots.searchForm && !(this.viewInstance.enableQuickSearch && !this.viewInstance.expandSearchForm)) ? <div class="view-content__top">
                {this.$slots.topMessage}
                {this.viewInstance.enableQuickSearch && !this.viewInstance.expandSearchForm ? null : this.$slots.searchForm}
            </div> : null,
            <div class="view-content__body">
                {this.$slots.bodyMessage}
                {this.$slots.default}
            </div>,
            this.$slots.bottomMessage ? <div class="view-content__bottom">
                {this.$slots.bottomMessage}
            </div> : null
        ]
    }

    /**
     * 绘制底部内容
     * 
     * @memberof StudioViewBase
     */
    public renderViewFooter(): any {
        return this.$slots.footer;
    }

    /**
     * 绘制视图
     * 
     * @memberof AppStyle2DefaultLayout
     */
    public render(h: any): any {
        const { viewClassNames } = this.renderOptions;
        return (
            <div class={viewClassNames}>
                <app-studioaction
                    viewInstance={this.viewInstance}
                    context={this.context}
                    viewparams={this.viewparams}
                    viewTitle={this.model?.srfCaption}
                    viewName={this.viewInstance.codeName.toLowerCase()} />
                {this.renderContent()}
            </div>
        );
    }
}