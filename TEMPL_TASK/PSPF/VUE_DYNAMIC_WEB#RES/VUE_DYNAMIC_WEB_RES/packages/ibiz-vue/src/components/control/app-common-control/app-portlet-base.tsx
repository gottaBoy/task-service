
import { Emit, Prop, Watch } from 'vue-property-decorator';
import { AppServiceBase, LayoutTool, ModelTool, throttle, Util } from 'ibiz-core';
import { PortletControlBase } from '../../../widgets';
import { AppGlobalService, AppViewLogicService } from '../../../app-service';
import { IPSDBAppViewPortletPart, IPSDBCustomPortletPart, IPSDBHtmlPortletPart, IPSDBRawItemPortletPart, IPSDEToolbar, IPSLanguageRes, IPSUIActionGroupDetail } from '@ibiz/dynamic-model-api';

/**
 * 门户部件部件基类
 *
 * @export
 * @class AppPortletBase
 * @extends {PortletControlBase}
 */
export class AppPortletBase extends PortletControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppPortletBase
     */
    @Prop() public dynamicProps!: any;

    /**
     * 部件静态参数
     *
     * @memberof AppPortletBase
     */
    @Prop() public staticProps!: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPortletBase
     */
    @Watch('dynamicProps', {
        immediate: true,
    })
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onDynamicPropsChange(newVal, oldVal);
        }
    }

    /**
     * 监听部件静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPortletBase
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onStaticPropsChange(newVal, oldVal);
        }
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppPortletBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppPortletBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制其他部件
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderControl() {
        if (this.controlInstance.getPSControls()?.length) {
            // 绘制其他部件
            let control = this.controlInstance.getPSControls()?.[0];
            let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(control);
            return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: control?.name, on: targetCtrlEvent })
        }
    }

    /**
     * 绘制直接内容
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderRawItem() {
        const { rawItemHeight, rawItemWidth, contentType, rawContent, htmlContent } = this.controlInstance as IPSDBRawItemPortletPart;
        let sysCssName = this.controlInstance.getPSSysCss()?.cssName;
        let sysImage = this.controlInstance.getPSSysImage()?.cssClass;
        let sysImgurl = this.controlInstance.getPSSysImage()?.imagePath;
        const style: any = {
            width: rawItemWidth > 0 ? `${rawItemWidth}px` : false,
            height: rawItemHeight > 0 ? `${rawItemHeight}px` :false,
        }
        let content: any;
        if (['RAW','VIDEO','DIVIDER','INFO','WARNING','ERROR'].includes(contentType)) {
            content = rawContent;
        } else if (Object.is(contentType,'HTML')){
            content = htmlContent;
        }else if(Object.is(contentType,'PLACEHOLDER')){
            content = null;
        }
        if (content) {
            const items = content.match(/\{{(.+?)\}}/g);
            if (items) {
                items.forEach((item: string) => {
                    content = content.replace(/\{{(.+?)\}}/, eval(item.substring(2, item.length - 2)));
                });
            }
            content = content.replaceAll('&lt;','<');
            content = content.replaceAll('&gt;','>');
            content = content.replaceAll('&amp;nbsp;',' ');
            content = content.replaceAll('&nbsp;',' ');
        }
        if(['VIDEO','DIVIDER','INFO','WARNING','ERROR'].includes(contentType)){
            if(content){
                try{
                    if(typeof content === 'string'){
                        let func = new Function('return (' + content + ');');
                        content  = func();
                    }
                }catch{
                    console.error(`${contentType}类型自定义参数配置错误`);
                    content = null;
                }
            }else{
                content = null;
            }
        }
        return (
            <app-rawitem
                class={sysCssName}
                style={style}
                viewparams={this.viewparams}
                context={this.context}
                contentType={contentType}
                imageClass={sysImage}
                imgUrl={sysImgurl}
                content={content}
                videoParams={content}
                dividerParams={content}
                alertParams={content}
            >
            </app-rawitem>
        );
    }

    /**
     * 绘制HTML
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderHtml() {
        let { pageUrl, height } = this.controlInstance as IPSDBHtmlPortletPart;
        height = height > 0 ? height : 400;
        let iframeStyle = `height: ${height}px; width: 100%; border-width: 0px;`;
        return <iframe src={pageUrl} style={iframeStyle}></iframe>;
    }

    /**
     * 绘制工具栏栏
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderToolBar() {
        return (
            <div class='app-control-portlet__content__toolbar'>
                <view-toolbar
                    toolbarModels={this.toolbarModels}
                    on-item-click={(data: any, $event: any) => {
                        throttle(this.handleItemClick, [data, $event], this);
                    }}
                ></view-toolbar>
            </div>
        );
    }

    /**
     * 绘制操作栏
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderActionBar() {
        return <app-actionbar
            viewState={this.viewState}
            uiService={this.appUIService}
            items={this.actionBarModelData}
            on-itemClick={(...params: any[]) => throttle(this.handleItemClick, params, this)}
        ></app-actionbar>;
    }

    /**
     * 绘制自定义
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderCustom() {
        let plugin = (this.controlInstance as IPSDBCustomPortletPart)?.getPSSysPFPlugin?.();;
        // todo自定义绘制
        if (plugin) {
            // todo 自定义门户部件
        } else {
            return <div>{this.$t('app.portlet.noextensions')}</div>;
        }
    }

    /**
     * 绘制应用菜单
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderAppMenu() {
        let menuInstance = this.controlInstance.getPSControls()?.[0];
        if (menuInstance) {
            let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(menuInstance);
            return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: menuInstance.name, on: targetCtrlEvent });
        }
    }

    /**
     * 绘制视图
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderView() {
        let portletAppView = (this.controlInstance as IPSDBAppViewPortletPart)?.getPortletPSAppView();
        if (!portletAppView) {
            return;
        }
        const { modelFilePath, name } = portletAppView;
        let tempContext: any = Object.assign(this.context, { viewpath: modelFilePath });
        return this.$createElement('app-view-shell', {
            props: {
                staticProps: {
                    inputState: this.viewState,
                    viewDefaultUsage: false,
                    isisLoadDefault: false,
                    viewModelData: portletAppView
                },
                dynamicProps: {
                    viewdata: JSON.stringify(tempContext),
                    viewparam: JSON.stringify(this.viewparams),
                },
            },
            class: "view-container2",
            on: {
                'viewIsMounted': () => {
                    this.setIsMounted(portletAppView?.name);
                }
            },
            ref: name,
        });
    }

    /**
     * 根据portletType绘制
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderByPortletType() {
        switch (this.controlInstance.portletType) {
            case 'VIEW':
                return this.renderView();
            case 'APPMENU':
                return this.renderAppMenu();
            case 'CUSTOM':
                return this.renderCustom();
            case 'ACTIONBAR':
                return this.renderActionBar();
            case 'TOOLBAR':
                return this.renderToolBar();
            case 'HTML':
                return this.renderHtml();
            case 'RAWITEM':
                return this.renderRawItem();
            default:
                return this.renderControl();
        }
    }

    /**
     * 绘制标题
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderTitle() {
        const { portletType } = this.controlInstance;
        let image = this.controlInstance?.getPSSysImage?.();
        let labelCaption: any = this.$tl((this.controlInstance.getTitlePSLanguageRes() as IPSLanguageRes)?.lanResTag, this.controlInstance.title);
        return [
            <p class='control-header'>
                <span class="control-header__caption">
                    {image && image?.cssClass && <i class={image?.cssClass} />}
                    {image && image?.imagePath && <img src={image?.imagePath} />}
                    {labelCaption}
                </span>
                <span class='control-header__right'>{portletType != 'ACTIONBAR' && this.renderUiAction()}</span>
            </p>
        ];
    }


    /**
     * 绘制界面行为图标
     *
     * @param {*} actionDetail 界面行为组成员
     * @returns
     * @memberof AppPortletBase
     */
    public renderIcon(actionDetail: any) {
        const { getPSUIAction: uiAction, showIcon } = actionDetail;
        if (showIcon && uiAction?.getPSSysImage) {
            let image = uiAction.getPSSysImage;
            if (image.cssClass) {
                return <i class={image.cssClass} />
            } else {
                return <img src={image.imagePath} />
            }
        }

    }

    /**
     * 绘制界面行为组
     *
     * @returns
     * @memberof AppPortletBase
     */
    public renderUiAction() {
        const actionGroupDetails = this.controlInstance?.getPSUIActionGroup?.()?.getPSUIActionGroupDetails?.();
        if (!actionGroupDetails) {
            return
        }
        return <span class="header__action">
            {actionGroupDetails.map((actionDetail: IPSUIActionGroupDetail) => {
                const { showCaption } = actionDetail;
                let uiAction = actionDetail?.getPSUIAction?.();
                const caption = this.$tl(uiAction?.getCapPSLanguageRes()?.lanResTag, uiAction?.caption || uiAction?.name);
                const tooltipCaption = this.$tl(uiAction?.getTooltipPSLanguageRes()?.lanResTag, uiAction?.caption || uiAction?.name);
                // 显示内容
                // todo 界面行为显示this.actionModel?.[uiactionName]?.visabled 
                let contentElement = <a on-click={(e: any) => { throttle(this.handleActionClick, [e, actionDetail], this) }} v-show={true} >
                    {this.renderIcon(actionDetail)}
                    {showCaption ? caption : null}
                </a>
                if (showCaption) {
                    return <tooltip transfer={true} max-width={600}>
                        {contentElement}
                        <div slot='content'>{tooltipCaption}</div>
                    </tooltip>
                } else {
                    return contentElement
                }
            })}
        </span>
    }

    /**
     * 处理操作列点击
     * 
     * @memberof GridControlBase
     */
    public handleActionClick(event: any, detail: any) {
        const { name } = this.controlInstance;
        let data = Util.deepCopy(this.context);
        if (AppServiceBase.getInstance().getEnableUIModelEx()) {
            AppGlobalService.getInstance().executeGlobalUIAction(detail.getPSUIAction(), event, this,undefined,data);
        }else{
            AppViewLogicService.getInstance().executeViewLogic(`${name}_${detail.name}_click`, event, this, data, this.controlInstance?.getPSAppViewLogics());
        }
    }

    /**
     * 绘制内容
     *
     * @returns
     * @memberof AppPortletBase
     */
    public render(): any {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        const { showTitleBar, title, height, width } = this.controlInstance;
        let isShowTitle = showTitleBar && title;
        let portletStyle;
        if (!this.isAdaptiveSize) {
            portletStyle = {height: LayoutTool.clacStyleSize(height), width: LayoutTool.clacStyleSize(width)};
        }
        return (!this.isAdaptiveSize
            ? <div class={{ 'app-control-portlet--custom': true, ...controlClassNames }}>
                {isShowTitle && this.renderTitle()}
                <div class={{ 'control-content': true,'app-control-portlet__content': true,'portlet--no-title': !isShowTitle }} style={portletStyle}>{this.renderByPortletType()}</div>
            </div>
            : <div class={controlClassNames}>
                {isShowTitle && this.renderTitle()}
                <div class={{ 'control-content': true,'app-control-portlet__content': true,'portlet--no-title': !isShowTitle}}>{this.renderByPortletType()}</div>
            </div>
        )
    }
}
