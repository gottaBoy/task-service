import { Prop, Watch, Emit } from 'vue-property-decorator';
import {
    Util,
    LayoutTool,
    throttle,
} from 'ibiz-core';
import { SearchFormControlBase } from '../../../widgets';
import { IPSDEFormButton, IPSDEFormDetail, IPSDEFormDRUIPart, IPSDEFormFormPart, IPSDEFormGroupPanel, IPSDEFormIFrame, IPSDEFormPage, IPSDEFormRawItem, IPSDEFormTabPage, IPSDEFormTabPanel, IPSDESearchFormItem, IPSEditor, IPSFlexLayout, IPSFlexLayoutPos, IPSGridLayoutPos, IPSLayout } from '@ibiz/dynamic-model-api';

/**
 * 搜索表单部件基类
 *
 * @export
 * @class AppSearchFormBase
 * @extends {SearchFormControlBase}
 */
export class AppSearchFormBase extends SearchFormControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppSearchFormBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppSearchFormBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppSearchFormBase
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
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppSearchFormBase
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
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppSearchFormBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 销毁视图回调
     *
     * @memberof AppSearchFormBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 初始化部件的绘制参数
     *
     * @type {Array<*>}
     * @memberof ViewBase
     */
    public initRenderOptions(opts?: any) {
        this.renderOptions = {};
        const { controlType, codeName, searchButtonStyle, searchButtonPos } = this.controlInstance as any;
        // 部件类名
        const controlClassNames: any = {
            'control-container': true,
            [`app-control-${controlType.toLowerCase()}`]: true,
            [Util.srfFilePath2(codeName)]: true,
        };
        Object.assign(controlClassNames, opts);
        const sysCss = this.controlInstance.getPSSysCss();
        if (sysCss) {
            Object.assign(controlClassNames, { [sysCss.cssName]: true });
        }
        if (this.controlInstance.formStyle == 'SEARCHBAR' || searchButtonStyle == 'NONE') {
            Object.assign(controlClassNames, { 'no-action': true });
        }
        this.$set(this.renderOptions, 'controlClassNames', controlClassNames);
    }

    /**
     * 绘制子表单成员,布局控制
     *
     * @param {*} modelJson
     * @returns
     * @memberof AppSearchFormBase
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
        if (layout.layout == 'TABLE_24COL' || layout.layout == 'TABLE_12COL') {
            return (
                <row>
                    {formDetails.map((item: IPSDEFormDetail, index: number) => {
                        if ((item as any).hidden) {
                            return
                        }
                        let attrs = LayoutTool.getGridOptions(item.getPSLayoutPos() as IPSGridLayoutPos);
                        return <i-col class='form-item__layout' {...{ props: attrs }} style={this.detailsModel[item.name]?.visible ? '' : 'display: none;'}>{this.renderByDetailType(item, index)}</i-col>;
                    })}
                </row>
            );
        }

        // FLEX布局
        if (layout.layout == 'FLEX') {
            const flexStyle = LayoutTool.getFlexStyle(layout as IPSFlexLayout);
            return (
                <div style={flexStyle}>
                    {formDetails.map((item: IPSDEFormDetail, index: number) => {
                         if ((item as any).hidden) {
                            return
                        }
                        let detailStyle =  LayoutTool.getFlexStyle2(item?.getPSLayoutPos() as IPSFlexLayoutPos);
                        detailStyle += this.detailsModel[item.name].visible ? '' : 'display: none;'
                        return <div style={detailStyle} class='form-layout-container'>{this.renderByDetailType(item, index)}</div>;
                    })}
                </div>
            );
        }
    }

    /**
     * 根据detailType绘制对应detail
     *
     * @param {*} modelJson
     * @param {number} index
     * @memberof AppSearchFormBase
     */
    public renderByDetailType(modelJson: IPSDEFormDetail, index: number) {
        if (modelJson.getPSSysPFPlugin()) {
            const pluginInstance: any = this.PluginFactory.getPluginInstance("CONTROLITEM", modelJson.getPSSysPFPlugin()?.pluginCode || '');
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
                    return this.renderFormItem(modelJson as IPSDESearchFormItem, index);
                case 'BUTTON':
                    return this.renderButton(modelJson as IPSDEFormButton, index);
                case 'DRUIPART':
                    return this.renderDruipart(modelJson as IPSDEFormDRUIPart, index);
                case 'RAWITEM':
                    return this.renderRawitem(modelJson as IPSDEFormRawItem, index);
                case 'IFRAME':
                    return this.renderIframe(modelJson as IPSDEFormIFrame, index);
                case 'FORMPART':
                    return this.renderFormPart(modelJson as IPSDEFormFormPart, index);
            }
        }
    }

    /**
     * 绘制表单部件
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderFormPart(modelJson: IPSDEFormFormPart, index: number): any {
        let { formPartType, name, codeName } = modelJson;

        // 后续补
        let systemCodeName = '',
            appCodeName = '',
            deCodeName = '',
            formCodeName = '';

        if (formPartType && formPartType == 'DYNASYS') {
            return (
                <app-form-part
                    name={name}
                    context={this.context}
                    viewparams={this.viewparams}
                    formState={this.formState}
                    systemCodeName={systemCodeName}
                    appCodeName={appCodeName}
                    deCodeName={deCodeName}
                    formCodeName={formCodeName}
                    formDetailCodeName={codeName}
                    on-change={this.onFormItemValueChange}
                ></app-form-part>
            );
        }
    }

    /**
     * 绘制iframe
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderIframe(modelJson: any, index: number): any {
        let { contentHeight, iFrameUrl, contentWidth } = modelJson;
        let iframeStyle = { 
            height: contentHeight ? contentHeight + 'px' : false,
            width: contentWidth ? contentWidth + 'px' : false,
        };
        return (
            <div style={iframeStyle}>
                <iframe src={iFrameUrl} class="app-control-searchform__iframe"></iframe>
            </div>
        );
    }

    /**
     * 绘制直接内容
     *
     * @returns
     * @memberof AppSearchFormBaseBase
     */
    public renderRawitem(modelJson: IPSDEFormRawItem, index: number): any {
        let { rawItemHeight, rawItemWidth, contentType, htmlContent, rawContent } = modelJson;
        let sysCssName = modelJson.getPSSysCss()?.cssName;
        let sysImage = modelJson.getPSSysImage()?.cssClass;
        let sysImgurl = modelJson.getPSSysImage()?.imagePath;
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
     * 关系界面保存事件
     *
     * @param {*} e
     * @memberof AppSearchFormBase
     */
    public onDrDataSaved(e: any) {
        this.ctrlEvent({
            controlname: this.controlInstance.name,
            action: 'drdatasaved',
            data: e,
        });
    }

    /**
     * 绘制关系界面
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderDruipart(modelJson: any, index: number): any {
        const { getPSSysCss, refreshItems, getLayoutPos, contentHeight, appView, parentdata, localContext, localParam, appDERSPaths } = modelJson;
        const { dynaModelFilePath } = appView;
        let tempContext: any = Object.assign(this.context, { viewpath: dynaModelFilePath });
        // druipart样式
        let druipartHeight: any;
        if (getLayoutPos?.layout == 'FlEX') {
            druipartHeight = '100%';
        } else if (contentHeight === 0 && appView?.height > 0) {
            druipartHeight = appView.height;
        } else {
            druipartHeight = contentHeight;
        }
        let druipartStyle = { height: druipartHeight, overflow: 'auto' };
        return (
            <app-form-druipart
                class={getPSSysCss?.cssName}
                modelJson={modelJson}
                formState={this.formState}
                isForbidLoad={this.data?.srfuf === '0'}
                paramItem={this.appDeCodeName.toLowerCase()}
                parentdata={parentdata}
                parameters={Util.formatAppDERSPath(this.context, appDERSPaths)}
                context={tempContext}
                viewparams={this.viewparams}
                parameterName={this.appDeCodeName.toLowerCase()}
                parentName={this.appDeCodeName}
                appViewtype={appView?.viewType}
                refreshitems={refreshItems}
                ignorefieldvaluechange={this.ignorefieldvaluechange}
                viewname={'app-view-shell'}
                localContext={Util.formatNavParam(localContext)}
                localParam={Util.formatNavParam(localParam)}
                tempMode={appView?.tempMode ? appView?.tempMode : 0}
                data={JSON.stringify(this.data)}
                on-drdatasaved={($event: any)=>this.drdatasaved($event)}
                style={druipartStyle}
            ></app-form-druipart>
        );
    }

    /**
     * 绘制按钮
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderButton(modelJson: IPSDEFormButton, index: number): any {
        let dynaStyle:string = this.detailsModel[modelJson.name].visible ? '' :  'display:none';
        // 自定义类名
        const dynaClass: string = 'app-form-button';        
        let badge = null;
        // TODO计数器徽章
        // if (uiAction) {
        //     let { appCounter, counterId } = uiAction;
        //     let { codeName } = appCounter;
        //     let count = codeName + 'counterservice.counterData.' + counterId;
        //     badge = <badge type='primary' count={count}></badge>;
        // }
        return (
            <div>
                {badge}
                <app-model-button
                    data={this.data}
                    modelJson={modelJson}
                    dynaStyle={dynaStyle}
                    dynaClass={dynaClass}
                    dynaType='primary'
                    disabled={this.detailsModel[modelJson.name]?.disabled}
                    on-onClick={($event: any) => throttle(this.onFormItemActionClick,[{formdetail:modelJson, event: $event }],this)}
                >
                </app-model-button>                
            </div>
        );
    }

    /**
     * 绘制表单项
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderFormItem(modelJson: IPSDESearchFormItem, index: number): any {
        const editor = modelJson.getPSEditor() as IPSEditor;
        return (
            <app-default-search-form-item
                detailsInstance={modelJson}
                modelService={this.modelService}
                index={index}
                data={this.data}
                rules={this.rules[modelJson.name]}
                runtimeModel={this.detailsModel[modelJson.name]}
                context={Util.deepCopy(this.context)}
                viewparams={Util.deepCopy(this.viewparams)}
                contextState={this.formState}
                service={this.service}
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
                        context={Util.deepCopy(this.context)}
                        viewparams={Util.deepCopy(this.viewparams)}
                        contextState={this.formState}
                        service={this.service}
                        disabled={this.detailsModel[modelJson.name]?.disabled}
                        ignorefieldvaluechange={this.ignorefieldvaluechange}
                        on-change={(value: any) => {
                            this.onFormItemValueChange(value);
                        }}
                    />
                )}
            </app-default-search-form-item>
        );
    }

    /**
     * 绘制分页部件panel
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderTabPanel(modelJson: any, index: number): any {
        return (
            <app-default-search-form-tab-panel
                modelService={this.modelService}
                detailsInstance={modelJson}
                index={index}
                controlInstance={this.controlInstance}>
                { this.renderDetails(modelJson)}
            </app-default-search-form-tab-panel>
        )
    }

    /**
     * 绘制分页部件
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderTabPage(modelJson: IPSDEFormTabPage, index: number): any {
        return (
            <app-default-search-form-tab-page
                modelService={this.modelService}
                detailsInstance={modelJson}
                index={index}
                controlInstance={this.controlInstance}>
                { this.renderDetails(modelJson)}
            </app-default-search-form-tab-page>
        );
    }

    /**
     * 绘制分组面板
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderGroupPanel(modelJson: IPSDEFormGroupPanel, index: number): any {
        return (
            <app-default-group-panel
                modelService={this.modelService}
                detailsInstance={modelJson}
                index={index}
                runtimeModel={this.detailsModel[modelJson.name]}
                controlInstance={this.controlInstance}
                on-groupUIActionClick={(...params: any[]) => throttle(this.handleActionClick,params,this)}
                on-collapseChange={($event: boolean) => { this.formDetailGroupChange(modelJson.codeName, $event) }}
                data={this.data}
            >
                {this.renderDetails(modelJson)}
            </app-default-group-panel>
        );
    }

    /**
     * 绘制表单分页
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderFormPage(modelJson: IPSDEFormPage, index: number): any {
        const { noTabHeader } = this.controlInstance;
        if (noTabHeader) {
            return this.renderDetails(modelJson);
        }
        return (
            <app-default-search-form-page
                modelService={this.modelService}
                detailsInstance={modelJson}
                index={index}
                runtimeModel={this.detailsModel[modelJson.name]}
                controlInstance={this.controlInstance}
            >
                {this.renderDetails(modelJson)}
            </app-default-search-form-page>
        );
    }

    /**
     * 绘制表单内容
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public renderFormContent() {
        const { noTabHeader, codeName, name, controlType } = this.controlInstance;
        const formPages = this.controlInstance.getPSDEFormPages();
        if (formPages && formPages.length > 0) {
            if (noTabHeader) {
                return formPages.map((item: any, index: number) => {
                    return this.renderFormPage(item, index);
                });
            } else {
                const tabsName = `${this.appDeCodeName.toLowerCase()}_${controlType?.toLowerCase()}_${codeName?.toLowerCase()}`;
                return (
                    <tabs 
                        animated={false} name={tabsName}
                        class="app-control-searchform__page"
                        value={this.detailsModel[name]?.activatedPage}
                        on-on-click={(e: any) => {
                          throttle(this.detailsModel[name]?.clickPage,[e],this);
                        }}
                    >
                        {formPages.map((item: any, index: number) => {
                            return this.renderFormPage(item, index);
                        })}
                    </tabs>
                );
            }
        }
    }

    /**
     * @description 点击外部区域关闭下拉
     * @memberof AppSearchFormBase
     */
    public clickOutside(event: any) {
      const className: string = event.target.className;
      if (!className.includes('save-search') && className !== 'ivu-input ivu-input-default' && !className.includes('history-item') && className !== 'ivu-dropdown-item') {
        this.dropdownVisible = false;
      }
    }

    /**
     * 获取搜索内容或按钮样式
     * 
     * @param position 位置
     * @memberof AppSearchFormBase
     */
    public getColStyle(position: string = 'content') {
        const { searchButtonStyle } = this.controlInstance as any;
        switch (searchButtonStyle) {
            case 'DEFAULT':
            case 'SEARCHONLY':
                return { width: 'calc(100% - 100px)', 'padding-right': '8px' };
            case 'NONE':
                return { width: '100%' };
        }
    }

    /**
     * @description 搜索下拉点击
     * @param {string} name 点击项
     * @memberof AppSearchFormBase
     */
    public searchDropdownClick(name: string) {
      switch (name) {
        case 'reset':
          this.reset();
          break
        case 'save':
          break
        default:
          this.fillSearchForm(name);
          break;
      }
    }

    /**
     * 绘制搜索按钮
     *
     * @return {*} 
     * @memberof AppSearchFormBase
     */
    renderSearchButton() {
        return <i-button size="default" type='primary' on-click={(...params: any[]) => throttle(this.search,params,this)}>{this.$t('app.searchbutton.search')}</i-button>;
    }

    /**
     * 绘制搜索下拉
     *
     * @return {*} 
     * @memberof AppSearchFormBase
     */
    renderSearchDropdown() {
        return (
            <dropdown 
                transfer 
                trigger="custom" 
                transfer-class-name="app-control-searchform__dropdown" 
                visible={this.dropdownVisible} 
                placement="bottom-end"
                on-on-click={(name: string) => this.searchDropdownClick(name)}
                on-on-clickoutside={(event: any) => this.clickOutside(event)}>
                <span class="app-control-searchform__dropdown__icon">
                    <icon type="ios-arrow-down" onClick={() => this.dropdownVisible = !this.dropdownVisible}/>
                </span>
                <dropdown-menu slot='list'>
                    <dropdown-item name="reset">
                        <div class="app-control-searchform__dropdown__item">
                        {this.$t('app.searchbutton.reset')}
                        </div>
                    </dropdown-item>
                    <dropdown-item name="save">
                        <poptip
                            ref="propip"
                            trigger="hover"
                            placement="left"
                            title="存储自定义查询"
                            popper-class="app-control-searchform__popover"
                            transfer
                            on-on-popper-show={() => this.saveItemName = ''}>
                                <div class="app-control-searchform__dropdown__item save-search">保存条件</div>
                                <div slot="content">
                                    <i-input class="save-search save-name" v-model={this.saveItemName} placeholder=""></i-input>
                                    <div class="popover__action">
                                        <button class="ivu-btn ivu-btn-default" on-click={(...params: any[]) => throttle(this.onCancel,params,this)}>{this.$t('app.commonwords.cancel')}</button>
                                        <button class="ivu-btn ivu-btn-primary save-search-button" type="primary" on-click={(...params: any[]) => throttle(this.onOk,params,this)}>{this.$t('app.commonwords.save')}</button>
                                    </div>
                                </div>
                        </poptip>
                    </dropdown-item>
                    {
                        this.historyItems?.map((item: any) => {
                            return (
                                <dropdown-item name={item.value}>
                                <div class="app-control-searchform__dropdown__item history-item">
                                    <span class="app-control-searchform__dropdown__item__caption" title={item.name}>{item.name}</span>
                                    <i class="el-icon-close" on-click={(e: any) => throttle(this.removeHistoryItem,[e, item],this)}/>
                                </div>
                                </dropdown-item>
                            )
                        })
                    }
                </dropdown-menu>
            </dropdown>
        )
    }

    /**
     * @description 绘右区域
     * @param {string} style 样式
     * @memberof AppSearchFormBase
     */
    renderRight(style: string) {
        if (this.controlInstance.formStyle != 'SEARCHBAR' && style != 'NONE') {
            return (
                <div class="app-control-searchform__right">
                    <div class="right-top">
                        {
                           style == 'SEARCHONLY' ?
                            this.renderSearchButton() :
                            [
                                this.renderSearchButton(),
                                this.renderSearchDropdown()
                            ]
                        }
                    </div>
                    {
                        this.showCollapse &&
                        <div class="right-bottom">
                            <el-button icon={this.collapsed ? 'el-icon-caret-bottom': 'el-icon-caret-top'} type="text" on-click={() => this.onCollapseChange()}>
                                {
                                    this.collapsed ? this.$t('app.searchform.showmore') : this.$t('app.searchform.hiddenmore')
                                }
                            </el-button>
                        </div>
                    }
                </div>
            )
        }
    }

    /**
     * 绘制内容
     *
     * @returns
     * @memberof AppSearchFormBase
     */
    public render(): any {
        const isShow = this.controlInstance.formStyle != 'SEARCHBAR' ? this.isExpandSearchForm : true;
        if (!(this.controlIsLoaded && isShow)) {
            return
        }
        const { controlClassNames } = this.renderOptions;
        let formId = this.appDeCodeName.toLowerCase() + this.controlInstance.codeName?.toLowerCase();
        if (!this.controlInstance.getPSDEFormItems() || this.controlInstance.getPSDEFormItems()?.length == 0) {
            return null;
        }
        const { searchButtonStyle } = this.controlInstance as any;
        return (
            <i-form
                props={{ model: this.data }}
                class={controlClassNames}
                ref={this.controlInstance.name}
                id={formId}
                on-on-valuidate={this.formItemValidate.bind(this)}
            >   
                <div class="control-content app-control-searchform__content">
                    <row class="app-control-searchform__left" style={this.getColStyle()}>
                        {this.renderFormContent()}
                    </row>
                    {this.renderRight(searchButtonStyle)}
                </div>
            </i-form>
        );
    }
}
