import { Emit, Prop, Watch } from 'vue-property-decorator';
import { LayoutTool, Util } from 'ibiz-core';
import { MobEditFormControlBase } from '../../../widgets';
import { IPSAppDEView, IPSDEEditForm, IPSDEFormDetail, IPSDEFormDRUIPart, IPSDEFormGroupPanel, IPSDEFormItem, IPSDEFormPage, IPSDEFormButton, IPSDEFormRawItem, IPSDEFormTabPage, IPSDEFormTabPanel, IPSLayout, IPSGridLayoutPos, IPSFlexLayout, IPSFlexLayoutPos, IPSDEFormIFrame } from '@ibiz/dynamic-model-api';
/**
 * 编辑表单部件基类
 *
 * @export
 * @class AppMobFormBase
 * @extends {MobFormControlBase}
 */
export class AppMobFormBase extends MobEditFormControlBase {

    /**
     * 表单的模型对象
     *
     * @type {*}
     * @memberof FormControlBase
     */
    public declare controlInstance: IPSDEEditForm;

    /**
     * 部件动态参数
     *
     * @memberof AppMobFormBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppMobFormBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobFormBase
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
     * @memberof AppMobFormBase
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
     * @memberof AppMobFormBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobFormBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 初始化部件的绘制参数
     *
     * @type {Array<*>}
     * @memberof ViewBase
     */
    public initRenderOptions(opts?: any) {
        this.renderOptions = {};
        const { controlType, codeName, noTabHeader } = this.controlInstance;
        // 部件类名
        const controlClassNames: any = {
            'control-container': true,
            [`app-control-${controlType.toLowerCase()}`]: true,
            [`app-control-${controlType.toLowerCase()}--hastabheader`]: !noTabHeader,
            [Util.srfFilePath2(codeName)]: true,

        };
        Object.assign(controlClassNames, opts);
        if (this.controlInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(controlClassNames, { [this.controlInstance.getPSSysCss()?.cssName || '']: true });
        }
        this.$set(this.renderOptions, 'controlClassNames', controlClassNames);
    }
    /**
     * 绘制表单分页
     *
     * @returns
     * @memberof AppMobFormBase
     */
    public renderFormPage(modelJson: IPSDEFormPage, index: number): any {
        const { noTabHeader } = this.controlInstance;
        if (noTabHeader) {
            return this.renderDetails(modelJson);
        }
        let customStyle = this.detailsModel[modelJson.name].visible ? '' : 'display: none;'
        return (
            <app-default-mob-form-page
                detailsInstance={modelJson}
                index={index}
                runtimeModel={this.detailsModel[modelJson.name]}
                controlInstance={this.controlInstance}
                style={customStyle}
                modelService={this.modelService}
            >
                {this.renderDetails(modelJson)}
            </app-default-mob-form-page>
        );
    }

    /**
     * 绘制子表单成员,布局控制
     *
     * @param {*} modelJson
     * @returns
     * @memberof AppMobFormBase
     */
    public renderDetails(modelJson: any) {
        let formDetails: IPSDEFormDetail[] = modelJson.getPSDEFormDetails();
        let layout: IPSLayout = modelJson.getPSLayout();
        // 没有子表单成员
        if (!formDetails || formDetails.length == 0) {
            return null;
        }
        // 无布局
        if (!layout) {
            return formDetails.map((item: any, index: number) => {
                return this.renderByDetailType(item, index);
            });
        }
        // 栅格布局
        if (layout.layout == 'TABLE_24COL' || layout.layout == 'TABLE_12COL' || layout.layout == 'TABLE') {
            return (
                <van-row class="">
                    {formDetails.map((item: IPSDEFormDetail, index: number) => {
                        if ((item as any).hidden) {
                            return;
                        }
                        let attrs = LayoutTool.getGridOptions(item.getPSLayoutPos() as IPSGridLayoutPos);
                        let style: any = this.getGridLayoutStyle(item);
                        const sysCss = item.getPSSysCss();
                        // 表单成员类名
                        const detailClassNames: any = {'form-item__layout':true};
                        if (sysCss?.cssName) {
                            Object.assign(detailClassNames, { [sysCss?.cssName]: true });
                        }
                        return (
                            <van-col
                                class={detailClassNames}
                                {...{ props: attrs }}
                                style={style}
                            >
                                {this.renderByDetailType(item, index)}
                            </van-col>
                        );
                    })}
                </van-row>
            );
        }
        // FLEX布局
        if (layout.layout == 'FLEX') {
            const flexStyle = LayoutTool.getFlexStyle(layout as IPSFlexLayout);
            return (
                <div style={flexStyle}>
                    {formDetails.map((item: IPSDEFormDetail, index: number) => {
                        if ((item as any).hidden) {
                            return;
                        }
                        let detailStyle = LayoutTool.getFlexStyle2(item?.getPSLayoutPos() as IPSFlexLayoutPos);
                        detailStyle += this.detailsModel[item.name].visible ? '' : 'display: none;';
                        const sysCss = item.getPSSysCss();
                        const detailClassNames: any = {'form-item__layout':true};
                        if (sysCss?.cssName) {
                            Object.assign(detailClassNames, { [sysCss?.cssName]: true });
                        }
                        return (
                            <div style={detailStyle} class={detailClassNames}>
                                {this.renderByDetailType(item, index)}
                            </div>
                        );
                    })}
                </div>
            );
        }
        throw new Error(`${layout.layout}${this.$t('app.nosupport.layout')}`);
    }

    /**
     * 获取栅格布局样式
     *
     * @param {*} item
     * @memberof AppFormBase
     */
    public getGridLayoutStyle(item: IPSDEFormDetail) {
        const { name, width, height } = item;
        let style: any = {};
        if (!this.detailsModel[name]?.visible) {
            Object.assign(style, { display: 'none' });
        }
        if (width && width > 0) {
            Object.assign(style, { width: `${width}px` });
        }
        if (height && height > 0) {
            Object.assign(style, { height: `${height}px` });
        }
        return style;
    }

    /**
     * 根据detailType绘制对应detail
     *
     * @param {*} modelJson
     * @param {number} index
     * @memberof AppMobFormBase
     */
    public renderByDetailType(modelJson: any, index: number) {
        if (modelJson.getPSSysPFPlugin()) {
            const pluginInstance: any = this.PluginFactory.getPluginInstance(
                'CONTROLITEM',
                modelJson.getPSSysPFPlugin()?.pluginCode || '',
            );
            if (pluginInstance) {
                return pluginInstance.renderCtrlItem(this.$createElement, modelJson, this, null);
            }
        } else {
            switch (modelJson.detailType) {
                case 'FORMPAGE':
                    return this.renderFormPage(modelJson as IPSDEFormPage, index);
                case 'GROUPPANEL':
                    return this.renderGroupPanel(modelJson as IPSDEFormGroupPanel, index);
                case 'TABPAGE':
                    return this.renderTabPage(modelJson as IPSDEFormTabPage, index);
                case 'TABPANEL':
                    return this.renderTabPanel(modelJson as IPSDEFormTabPanel, index);
                case 'FORMITEM':
                    return this.renderFormItem(modelJson as IPSDEFormItem, index);
                case 'BUTTON':
                    return this.renderButton(modelJson as IPSDEFormButton, index);
                case 'DRUIPART':
                    return this.renderDruipart(modelJson as IPSDEFormDRUIPart, index);
                case 'RAWITEM':
                    return this.renderRawItem(modelJson as IPSDEFormRawItem, index);
                case 'IFRAME':
                    return this.renderIframe(modelJson as IPSDEFormIFrame, index);
            }
        }
    }

    /**
     * 绘制表单项
     *
     * @returns
     * @memberof AppMobFormBase
     */
    public renderFormItem(modelJson: IPSDEFormItem, index: number): any {
        let editor = modelJson.getPSEditor();
        return (
            <app-default-mob-form-item
                detailsInstance={modelJson}
                index={index}
                data={this.data}
                rules={this.rules[modelJson.name]}
                runtimeModel={this.detailsModel[modelJson.name]}
                context={Util.deepCopy(this.context)}
                viewparams={Util.deepCopy(this.viewparams)}
                contextState={this.formState}
                service={this.service}
                modelService={this.modelService}
                ignorefieldvaluechange={this.ignorefieldvaluechange}
                on-formItemValueChange={(value: any) => {
                    this.onFormItemValueChange(value);
                }}
                controlInstance={this.controlInstance}
            >
                {editor && (
                    <app-default-editor
                        editorInstance={editor}
                        containerCtrl={this.controlInstance}
                        parentItem={modelJson}
                        value={this.data[editor?.name]}
                        contextData={this.data}
                        valueFormat={modelJson.valueFormat}
                        context={Util.deepCopy(this.context)}
                        viewparams={Util.deepCopy(this.viewparams)}
                        contextState={this.formState}
                        service={this.service}
                        disabled={this.detailsModel[modelJson.name]?.disabled}
                        ignorefieldvaluechange={this.ignorefieldvaluechange}
                        on-change={(value: any) => {
                            this.onFormItemValueChange(value);
                        }}
                    // on-enter={(value: any) => {
                    //     this.onFormItemEnter(value);
                    // }}
                    // on-leave={(value: any) => {
                    //     this.onFormItemLeave(value);
                    // }}
                    />
                )}
            </app-default-mob-form-item>
        );
    }

    /**
     * 绘制分页部件panel
     *
     * @returns
     * @memberof AppMobFormBase
     */
    public renderTabPanel(modelJson: IPSDEFormTabPanel, index: number): any {
        return (
            <app-default-mob-form-tab-panel
                detailsInstance={modelJson}
                index={index}
                modelService={this.modelService}
                runtimeModel={this.detailsModel[modelJson.name]}
                controlInstance={this.controlInstance}
                context={this.context}
                viewparams={this.viewparams}
                data={this.data}
            >
                {modelJson.getPSDEFormTabPages?.()?.length &&
                    modelJson.getPSDEFormTabPages()?.map((item: IPSDEFormTabPage, index2: number) => {
                        return this.renderTabPage(item, index2);
                    })}
            </app-default-mob-form-tab-panel>
        );
    }

    /**
     * 绘制分页部件
     *
     * @returns
     * @memberof AppMobFormBase
     */
    public renderTabPage(modelJson: IPSDEFormTabPage, index: number): any {
        return (
            <app-default-mob-form-tab-page
                modelService={this.modelService}
                detailsInstance={modelJson}
                index={index}
                runtimeModel={this.detailsModel[modelJson.name]}
                controlInstance={this.controlInstance}
                context={this.context}
                viewparams={this.viewparams}
                data={this.data}
            >
                {this.renderDetails(modelJson)}
            </app-default-mob-form-tab-page>
        );
    }

    /**
     * 绘制分组面板
     *
     * @returns
     * @memberof AppMobFormBase
     */
    public renderGroupPanel(modelJson: IPSDEFormGroupPanel, index: number): any {
        return (
            <app-default-mob-group-panel
                detailsInstance={modelJson}
                index={index}
                runtimeModel={this.detailsModel[modelJson.name]}
                controlInstance={this.controlInstance}
                on-groupUIActionClick={this.handleActionClick.bind(this)}
                context={this.context}
                viewparams={this.viewparams}
                data={this.data}
                modelService={this.modelService}
            >
                {this.renderDetails(modelJson)}
            </app-default-mob-group-panel>
        );
    }


    /**
     * 绘制表单内容
     *
     * @returns
     * @memberof AppMobFormBase
     */
    public renderFormContent() {
        const { noTabHeader, name } = this.controlInstance;
        const formPages = this.controlInstance.getPSDEFormPages();
        if (formPages && formPages.length > 0) {
            if (noTabHeader) {
                return formPages.map((item: any, index: number) => {
                    return this.renderFormPage(item, index);
                });
            } else {
                return (
                    <van-tabs
                        type="card"
                        class="control-content__tabs"
                        color='@app-background-color'
                        animated={true}
                        swipeable={true}
                        scrollspy={false}
                        lazy-render={false}
                        value={this.detailsModel[name]?.activatedPage}
                    >
                        {formPages.map((item: any, index: number) => {
                            const caption = this.$tl(item.getCapPSLanguageRes()?.lanResTag, item.caption);
                            return <van-tab title={caption} class="control-content__tabs__item" name={item.name}>
                                {this.renderFormPage(item, index)}
                            </van-tab>
                        })}
                    </van-tabs>
                );
            }
        }
    }

    /**
     * 绘制表单按钮
     *
     * @param {IPSDEFormButton} modelJson
     * @param {number} index
     * @return {*}  {*}
     * @memberof AppMobFormBase
     */
    public renderButton(modelJson: IPSDEFormButton, index: number): any {
        return (
            <app-default-mob-form-button
                context={this.context}
                viewparams={this.viewparams}
                data={this.data}
                index={index}
                detailsInstance={modelJson}
                disabled={this.detailsModel[modelJson.name].disabled}
                runtimeModel={this.detailsModel[modelJson.name]}
                on-UIAction={this.onFormItemActionClick.bind(this)}>
            </app-default-mob-form-button>
        )
    }

    /**
     * 绘制iframe
     *
     * @returns
     * @memberof AppFormBase
     */
    public renderIframe(modelJson: IPSDEFormIFrame, index: number): any {
        let { contentHeight, iFrameUrl, contentWidth } = modelJson;
        let iframeStyle = {
            height: contentHeight ? contentHeight + 'px' : false,
            width: contentWidth ? contentWidth + 'px' : false,
        };
        return (
            <div style={iframeStyle}>
                <iframe src={iFrameUrl} style="height: 100%;width: 100%;border: 0"></iframe>
            </div>
        );
    }

    /**
     * 渲染直接内容
     *
     * @param {IPSDEFormRawItem} modelJson
     * @param {number} index
     * @return {*} 
     * @memberof AppMobFormBase
     */
    public renderRawItem(modelJson: IPSDEFormRawItem, index: number) {
        return (
            <app-default-mob-form-raw-item
                context={this.context}
                viewparams={this.viewparams}
                index={index}
                data={this.data}
                detailsInstance={modelJson}
                runtimeModel={this.detailsModel[modelJson.name]}>
            </app-default-mob-form-raw-item>
        )
    }

    /**
     * 绘制关系界面
     *
     * @returns
     * @memberof AppFormBase
     */
    public renderDruipart(modelJson: any, index: number): any {
        const { refreshItems, height, parentDataJO } = modelJson;
        const layoutPos = modelJson.getPSLayoutPos();
        const appView = modelJson.getPSAppView() as IPSAppDEView;
        const appDERSPaths = (appView as IPSAppDEView)?.getPSAppDERSPaths();
        const appDataEntity = this.controlInstance.getPSAppDataEntity();
        let tempContext: any = Util.deepCopy(this.context);
        // druipart样式
        let druipartHeight: any;
        if (layoutPos?.layout == 'FlEX') {
            druipartHeight = '100%';
        } else if (!height && appView?.height > 0) {
            druipartHeight = appView.height;
        } else {
            druipartHeight = Util.isNumber(height) && height > 0 ? `${height}px` : '100%';
        }
        let druipartStyle = { height: druipartHeight, overflow: 'auto' };
        let viewName = Util.srfFilePath2(appView?.codeName);
        let partCaption: any = '';
        return (
            <app-form-druipart
                class={modelJson.getPSSysCss()?.cssName}
                formState={this.formState}
                isForbidLoad={this.data?.srfuf === '0'}
                paramItem={appDataEntity?.codeName?.toLowerCase()}
                parentdata={parentDataJO || undefined}
                parameters={Util.formatAppDERSPath(this.context, appDERSPaths)}
                context={tempContext}
                viewparams={this.viewparams}
                parameterName={appDataEntity?.codeName?.toLowerCase()}
                parentName={appDataEntity?.codeName}
                appViewtype={appView?.viewType}
                refreshitems={refreshItems}
                viewModelData={appView}
                ignorefieldvaluechange={this.ignorefieldvaluechange}
                viewname={viewName}
                navigateContext={Util.formatNavParam(modelJson.getPSNavigateContexts())}
                navigateParam={Util.formatNavParam(modelJson.getPSNavigateParams())}
                tempMode={appView?.tempMode ? appView.tempMode : 0}
                data={JSON.stringify(this.data)}
                on-drdatasaved={($event: any) => this.drdatasaved($event)}
                style={druipartStyle}
                caption={partCaption ? partCaption : ''}
            ></app-form-druipart>
        );
    }

    /**
     * 绘制表单
     *
     * @returns {*}
     * @memberof AppMobFormBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        let controlStyle = {
            width: this.controlInstance.width ? this.controlInstance.width + 'px' : '',
            height: this.controlInstance.height ? this.controlInstance.height + 'px' : ''
        };
        const { noTabHeader } = this.controlInstance;
        return (
            <div class={controlClassNames} style={controlStyle}>
                <div class="control-content app-control-form__content"> {this.renderFormContent()}</div>
            </div>
        );
    }
}
