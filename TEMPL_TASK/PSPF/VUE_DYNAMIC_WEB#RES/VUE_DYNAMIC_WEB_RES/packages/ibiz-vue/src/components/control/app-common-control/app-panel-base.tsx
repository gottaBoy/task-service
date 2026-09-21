import { Prop, Watch, Emit } from 'vue-property-decorator';
import { IPSDEViewPanel, IPSPanel, IPSPanelButton, IPSPanelContainer, IPSPanelItem, IPSPanelRawItem, IPSPanelTabPage, IPSPanelTabPanel, IPSSysPanelField } from '@ibiz/dynamic-model-api';
import { PanelContainerModel, PluginService, throttle, Util } from 'ibiz-core';
import { PanelControlBase } from '../../../widgets';

/**
 * 面板部件基类
 *
 * @export
 * @class AppPanelBase
 * @extends {PanelControlBase}
 */
export class AppPanelBase extends PanelControlBase {
    /**
     * 部件动态参数
     *
     * @memberof AppPanelBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppPanelBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPanelBase
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
     * @memberof AppPanelBase
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
     * 监听数据对象
     *
     * @memberof AppPanelBase
     */
    @Watch('data', { deep: true })
    public onDataChange(newVal: any, oldVal: any) {
        if (newVal) {
            this.computeButtonState(newVal);
            this.panelLogic({ name: '', newVal: null, oldVal: null });
            this.$forceUpdate();
        }
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppPanelBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppPanelBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }
    
    /**
     * @description 切换容器展开状态
     * @param {PanelContainerModel} container 容器类对象
     * @memberof AppPanelBase
     */
    public switchExtendState(container: PanelContainerModel) {
      if (container.titleBarClose) {
        container.extendState = !container.extendState;
      }
    }

    /**
     * 获取栅格布局的props
     *
     * @param {*} parent 父
     * @param {*} child 子
     * @returns {*}
     * @memberof AppPanelBase
     */
    public getGridLayoutProps(parent: any, child: any): any {
        const layout = parent?.getPSLayout()?.layout;
        const layoutPos = child?.getPSLayoutPos();
        if (layoutPos) {
          let { colXS, colSM, colMD, colLG, colXSOffset, colSMOffset, colMDOffset, colLGOffset } = layoutPos;
          // 设置初始值
          colXS = !colXS || colXS == -1 ? 24 : colXS;
          colSM = !colSM || colSM == -1 ? 24 : colSM;
          colMD = !colMD || colMD == -1 ? 24 : colMD;
          colLG = !colLG || colLG == -1 ? 24 : colLG;
          colXSOffset = !colXSOffset || colXSOffset == -1 ? 0 : colXSOffset;
          colSMOffset = !colSMOffset || colSMOffset == -1 ? 0 : colSMOffset;
          colMDOffset = !colMDOffset || colMDOffset == -1 ? 0 : colMDOffset;
          colLGOffset = !colLGOffset || colLGOffset == -1 ? 0 : colLGOffset;
          if (layout == 'TABLE_12COL') {
              // 重新计算12列的栅格数值
              colXS = Math.min(colXS * 2, 24);
              colSM = Math.min(colSM * 2, 24);
              colMD = Math.min(colMD * 2, 24);
              colLG = Math.min(colXS * 2, 24);
              // 重新计算12列的栅格偏移
              let sign = (num: number) => (num == 0 ? 0 : num / Math.abs(num));
              colXSOffset = sign(colXSOffset) * Math.min(colXSOffset * 2, 24);
              colSMOffset = sign(colSMOffset) * Math.min(colSMOffset * 2, 24);
              colMDOffset = sign(colMDOffset) * Math.min(colMDOffset * 2, 24);
              colLGOffset = sign(colLGOffset) * Math.min(colLGOffset * 2, 24);
          }
          return {
              xs: { span: colXS, offset: colXSOffset },
              sm: { span: colSM, offset: colSMOffset },
              md: { span: colMD, offset: colMDOffset },
              lg: { span: colLG, offset: colLGOffset },
          };
        }
        return {}
    }

    /**
     * 绘制顶级面板成员集合
     *
     * @memberof AppPanelBase
     */
    public renderRootPSPanelItems(controlInstance: IPSPanel) {
        return controlInstance.getRootPSPanelItems()?.map((container: any, index: number) => {
            return this.renderByDetailType(container);
        });
    }

    /**
     * 根据detailType绘制对应detail
     *
     * @param {*} modelJson
     * @memberof AppPanelBase
     */
    public renderByDetailType(modelJson: any, parent?: any, index?: number) {
        if (modelJson.getPSSysPFPlugin()) {
            const pluginInstance: any = PluginService.getInstance().getPluginInstance("CONTROLITEM", modelJson.getPSSysPFPlugin().pluginCode);
            if (pluginInstance) {
                return pluginInstance.renderCtrlItem(this.$createElement, modelJson, this, this.context);
            }
        }
        switch (modelJson.itemType) {
            case 'CONTAINER':
                return this.renderContainer(modelJson, parent, index);
            case 'TABPANEL':
                return this.renderTabPanel(modelJson, parent, index);
            case 'TABPAGE':
                return this.renderTabPage(modelJson, index);
            case 'FIELD':
                return this.renderField(modelJson, index);
            case 'RAWITEM':
                return this.renderRawItem(modelJson, index);
            case 'BUTTON':
                return this.renderButton(modelJson, index);
            case 'CONTROL':
                return this.renderControl(modelJson, parent, index);
            case 'USERCONTROL':
                return this.renderUserControl(modelJson, parent, index);
            default:
                return <span>{`${modelJson.itemType} 类型未支持`}</span>
        }
    }

    /**
     * 绘制面板Container
     *
     * @memberof AppPanelBase
     */

    public renderContainer(container: IPSPanelContainer, parent?: any, index?: number) {
        const panelItems: IPSPanelItem[] = container.getPSPanelItems() || [];
        let name: string = `${container.name}${index === undefined || index === null ? '' : '_' + index}`;
        //  父容器为多数据容器
        let hasMulParent: boolean = false;
        if (index !== undefined || index !== null) {
            hasMulParent = true;
        }
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        let layout = container.getPSLayout()?.layout;
        // 获取盒子宽高/间隔模式
        let detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        // 获取布局设置(约束子,如：flex布局及相关设置)
        const boxLayoutStyle = this.layoutDetailsModel[name].getBoxLayoutStyle();
        // 获取盒子自身应有样式
        Object.assign(detailStyle, boxLayoutStyle);
        // 获取盒子样式表
        let detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        // 合并盒子动态样式表
        if(container.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            detailClass.push(...eval(container.dynaClass))
        }
        if (layout && Object.is(layout, 'BORDER')) {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <div style={detailStyle} class={[detailClass, 'app-control-panel__container', 'panel-container__border']} onClick={(event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) }}>
                    {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                        this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                            return <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems, index)}</app-scroll-container>;
                        }) : hasMulParent ?
                            <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems, index)}</app-scroll-container> :
                            <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems)}</app-scroll-container>}
                    {this.layoutDetailsModel[name].isLoading ? <app-loading /> : null}
                </div>
            )
        } else if (layout && (Object.is(layout, 'FLEX'))) {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <div style={container.showCaption ? '' : detailStyle} class={[detailClass, 'app-control-panel__container', 'panel-container__flex']} onClick={(event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) }}>
                    {container.showCaption ? <row class="app-control-panel__container__header">
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                        {this.layoutDetailsModel[name].titleBarClose ? <i class={{ 'header__icon': true, 'el-icon-arrow-down': this.layoutDetailsModel[name].extendState, 'el-icon-arrow-right': !this.layoutDetailsModel[name].extendState}} on-click={() => this.switchExtendState(this.layoutDetailsModel[name])}></i> : null}
                    </row> : null}
                    {
                        container.showCaption ?
                            <div style={{ ...detailStyle, 'display': !this.layoutDetailsModel[name].titleBarClose || (this.layoutDetailsModel[name].titleBarClose && this.layoutDetailsModel[name].extendState) ? 'block' : 'none'}} class={`app-control-panel__container__content ${this.panelType === 'ITEMLAYOUTPANEL' ? 'is-layout' : ''}`}>
                                {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                    this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                        return this.renderChildItems(container, panelItems, index);
                                    }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)}
                            </div> :
                            container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                    return this.renderChildItems(container, panelItems, index);
                                }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)
                    }
                    {this.layoutDetailsModel[name].isLoading ? <app-loading /> : null}
                </div>
            );
        } else if (layout && Object.is(layout, 'SIMPLEFLEX')){
             //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
             return (
                <div style={container.showCaption ? '' : detailStyle} class={[detailClass, 'app-control-panel__container', 'panel-container__simpleflex']} onClick={(event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) }}>
                    {container.showCaption ? <row class="app-control-panel__container__header">
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                        {this.layoutDetailsModel[name].titleBarClose ? <i class={{ 'header__icon': true, 'el-icon-arrow-down': this.layoutDetailsModel[name].extendState, 'el-icon-arrow-right': !this.layoutDetailsModel[name].extendState}} on-click={() => this.switchExtendState(this.layoutDetailsModel[name])}></i> : null}
                    </row> : null}
                    {
                        container.showCaption ?
                            <div style={{ ...detailStyle, 'display': !this.layoutDetailsModel[name].titleBarClose || (this.layoutDetailsModel[name].titleBarClose && this.layoutDetailsModel[name].extendState) ? 'block' : 'none'}} class={`app-control-panel__container__content ${this.panelType === 'ITEMLAYOUTPANEL' ? 'is-layout' : ''}`}>
                                {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                    this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                        return <app-simpleflex-container inMulParent={true} panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>;
                                    }) : hasMulParent ? <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container> : <app-simpleflex-container panelItems={panelItems} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>}
                            </div> :
                            container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                    return <app-simpleflex-container inMulParent={true} panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>
                                }) : hasMulParent ?  <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container> : <app-simpleflex-container panelItems={panelItems} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>
                    }
                    {this.layoutDetailsModel[name].isLoading ? <app-loading /> : null}
                </div>
            );
        } else {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <row style={detailStyle} class={[detailClass, 'app-control-panel__container', 'panel-container__standard']} nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }}>
                    {container.showCaption ? <row class="app-control-panel__container__header">
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                        {this.layoutDetailsModel[name].titleBarClose ? <i class={{ 'header__icon': true, 'el-icon-arrow-down': this.layoutDetailsModel[name].extendState, 'el-icon-arrow-right': !this.layoutDetailsModel[name].extendState}} on-click={() => this.switchExtendState(this.layoutDetailsModel[name])}></i> : null}
                    </row> : null}
                    <div style={{...detailStyle, 'display': !this.layoutDetailsModel[name].titleBarClose || (this.layoutDetailsModel[name].titleBarClose && this.layoutDetailsModel[name].extendState) ? 'block' : 'none'}} class="app-control-panel__container__content">
                    {
                        container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                        this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                            return this.renderChildItems(container, panelItems, index);
                        }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)
                    }
                    </div>
                    {this.layoutDetailsModel[name].isLoading ? <app-loading /> : null}
                </row>

            );
        }
    }

    /**
     * 渲染子项
     *
     * @param {IPSPanelContainer} parent
     * @param {IPSPanelItem[]} panelItems
     * @param {number} [index]
     * @return {*} 
     * @memberof AppPanelBase
     */
    public renderChildItems(parent: IPSPanelContainer, panelItems: IPSPanelItem[], index?: number) {
        if (!parent || !panelItems || (panelItems.length === 0)) {
            return null;
        }
        const layout = parent.getPSLayout()?.layout;
        return panelItems.map((item: any) => {
            const name = `${item.name}${index === undefined || index === null ? '' : '_' + index}`;
            const childDetailStyle: any = {};
            if (Object.is(layout, 'BORDER')) {
                Object.assign(childDetailStyle, { height: '100%', width: '100%' });
            } else {
                Object.assign(childDetailStyle, this.layoutDetailsModel[name]?.getBoxLayoutPosStyle());
            }

            if (Object.is(layout, 'BORDER')) {
                return (
                    <div style={childDetailStyle} slot={item.name} class={'container-item__pos  container-item__border'}>
                        {this.renderByDetailType(item, parent, index)}
                    </div>
                );
            } else if (Object.is(layout, 'FLEX')) {
                return (
                    <div style={childDetailStyle} class={'container-item__pos  container-item__flex'} >
                        {this.renderByDetailType(item, parent, index)}
                    </div>
                );
            } else if (Object.is(layout, 'TABLE_12COL') || Object.is(layout, 'TABLE_24COL')) {
                const attrs = this.layoutDetailsModel[name]?.getGridLayoutProps(item, layout);
                return (
                    <i-col {...{ props: attrs }} style={childDetailStyle} class={'container-item__pos'}>
                        {this.renderByDetailType(item, parent, index)}
                    </i-col>
                );
            }
        })
    }

    /**
     * 渲染用户组件
     *
     * @param {*} modelJson
     * @param {*} [parent]
     * @param {*} [index]
     * @memberof AppPanelBase
     */
    public renderUserControl(modelJson: any, parent?: any, index?: any) { }

    /**
     * 渲染部件
     *
     * @param {*} modelJson 部件模型
     * @param {*} [parent] 父容器
     * @param {*} [index] 下标
     * @return {*} 
     * @memberof AppPanelBase
     */
    public renderControl(modelJson: any, parent?: any, index?: any) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        let detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        let detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        return <div class={detailClass} style={detailStyle}>
            {this.renderByControlType(modelJson.getPSControl?.())}
        </div>
    }

    /**
     * 绘制面板Button
     *
     * @memberof AppPanelBase
     */

    public renderButton(modelJson: IPSPanelButton, index?: number) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        if(modelJson.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            detailClass.push(...eval(modelJson.dynaClass));
        }   
        return (
            <app-model-button
                data={this.data}
                modelJson={modelJson}
                dynaStyle={detailStyle}
                dynaClass={detailClass}
                disabled={this.layoutDetailsModel[name]?.disabled}
                on-onClick={(event: any) => {
                    throttle(this.buttonClick, [{ modelJson, name, event }], this);
                }}
            >
            </app-model-button>
        )
    }

    /**
     * 绘制面板Field
     *
     * @memberof AppPanelBase
     */

    public renderField(modelJson: IPSSysPanelField, index?: number) {
        //  存在多份属性模型时根据下标获取对应 name
        let name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        let { caption, hidden, showCaption } = modelJson;
        const editor: any = modelJson.getPSEditor();
        let customCode: boolean = false;
        if (this.dataMap && this.dataMap.get(name)) {
            customCode = this.dataMap.get(name).customCode;
        }
        if (this.needFindDEField) {
            this.findDEFieldForPanelField(modelJson);
        }
        let labelPos = 'LEFT';
        const captionClass= {};
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        this.layoutDetailsModel[name].getCssStyle(detailStyle);
        if(modelJson.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            detailClass.push(...eval(modelJson.dynaClass));
        }  
        if(modelJson.labelDynaClass){
            Object.assign(captionClass,...eval(modelJson.labelDynaClass))
        }
        return (
            !hidden && (
                <app-panel-field
                    name={name}
                    labelPos={labelPos}
                    caption={this.$tl(modelJson.getCapPSLanguageRes()?.lanResTag, caption)}
                    captionClass={captionClass}
                    isEmptyCaption={!showCaption}
                    error={this.rules[editor.name]?.message}
                    data={this.data}
                    value={this.data[name]}
                    class={detailClass}
                    style={detailStyle}
                    itemRules={this.rules[editor.name]}
                    required={this.layoutDetailsModel[modelJson.name]?.required}
                >
                    {editor && !customCode && (
                        <app-default-editor
                            value={this.data[editor.name]}
                            editorInstance={editor}
                            containerCtrl={this.controlInstance}
                            parentItem={modelJson}
                            contextData={this.data}
                            valueFormat={modelJson.valueFormat}
                            context={this.context}
                            viewparams={this.viewparams}
                            disabled={this.layoutDetailsModel[modelJson.name]?.disabled}
                            on-change={(value: any) => {
                                this.onPanelItemValueChange(value);
                            }}
                        />
                    )}
                    {
                        customCode && this.$createElement('div', {
                            domProps: {
                                innerHTML: this.data[name],
                            },
                        })
                    }
                </app-panel-field>
            )
        );
    }

    /**
     * 绘制面板Rawitem
     *
     * @memberof AppPanelBase
     */

    public renderRawItem(modelJson: IPSPanelRawItem, index?: number) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        let sysImage = modelJson.getPSSysImage()?.cssClass;
        let sysImgurl = modelJson.getPSSysImage()?.imagePath;
        if(modelJson.getPSSysImage()?.rawContent){
            sysImgurl = modelJson.getPSSysImage()?.rawContent;
        }
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        let content:any = null;
        let { contentType,rawContent} = modelJson;
        if(['VIDEO','DIVIDER','INFO','WARNING','ERROR'].includes(contentType)){
            if(rawContent){
                try{
                    if(typeof rawContent === 'string'){
                        let func = new Function('return (' + rawContent + ');');
                        content  = func();
                    }
                }catch{
                    console.error(`${contentType}类型自定义参数配置错误`);
                    content = null;
                }
            }else{
                content = null
            }
        }
        return (
            <app-rawitem
                class={detailClass}
                style={detailStyle}
                rawItemDetail={modelJson.M.getPSRawItem}
                viewparams={this.viewparams}
                context={this.context}
                contentType={modelJson.contentType}
                imageClass={sysImage}
                imgUrl={sysImgurl}
                content={this.layoutData[name]}
                videoParams={content}
                dividerParams={content}
                alertParams={content}
                nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(modelJson.name, name, 'onclick', { index, event }) } }}
            >
            </app-rawitem>
        );
    }

    /**
     * 绘制面板TabPanel
     *
     * @memberof AppPanelBase
     */

    public renderTabPanel(modelJson: IPSPanelTabPanel, parent?: any, index?: number) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const tabPages: IPSPanelTabPage[] = modelJson.getPSPanelTabPages() || [];
        let activedTabPage: any = this.layoutDetailsModel[name]?.activatedPage;
        let detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        let detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        if(modelJson.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            detailClass.push(...eval(modelJson.dynaClass));
        } 
        return (
            <el-tabs
                value={activedTabPage}
                class={detailClass}
                style={parent ? {} : detailStyle}
                on-tab-click={(event: any) => { this.handlePanelItemEvent(modelJson.name, name, 'onclick', { index, event }) }}
            >
                {tabPages.length > 0 ?
                    tabPages.map((item: IPSPanelTabPage) => {
                        return this.renderTabPage(item, index);
                    }) : null}
            </el-tabs>
        );
    }

    /**
     * 绘制面板TabPage
     *
     * @memberof AppPanelBase
     */
    public renderTabPage(modelJson: IPSPanelTabPage, index?: number) {
        let name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        let label = this.$tl(modelJson.getCapPSLanguageRes?.()?.lanResTag, modelJson.caption);
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        if(modelJson.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            detailClass.push(...eval(modelJson.dynaClass));
        }  
        const panelItems: IPSPanelItem[] = modelJson.getPSPanelItems() || [];
        return (
            <el-tab-pane label={label} name={modelJson.name} class={detailClass}>
                {this.renderChildItems(modelJson, panelItems, index)}
            </el-tab-pane>
        );
    }

    /**
     * 根据controlType绘制对应control
     *
     * @param {*} modelJson
     * @memberof AppPanelBase
     */
    public renderByControlType(modelJson: any) {
        switch (modelJson.controlType) {
            case 'VIEWPANEL':
                return this.renderViewPanel(modelJson);
        }
    }

    /**
     * 绘制ViewPanel
     * 
     * @param {*} control
     * @memberof AppPanelBase
     */
    public renderViewPanel(modelJson: IPSDEViewPanel) {
        let controlAppView = modelJson.getEmbeddedPSAppDEView();
        if (!controlAppView) {
            return;
        }
        const { modelFilePath, name } = controlAppView;
        let tempContext: any = Object.assign(Util.deepCopy(this.context), { viewpath: modelFilePath, });
        const appDeKeyCodeName = this.controlInstance.getPSAppDataEntity()?.codeName?.toLowerCase();
        if (appDeKeyCodeName) {
            Object.assign(tempContext, { [appDeKeyCodeName]: this.data.srfkey })
        }
        return this.$createElement('app-view-shell', {
            props: {
                staticProps: {
                    inputState: this.viewState,
                    viewDefaultUsage: false,
                    viewModelData: controlAppView
                },
                dynamicProps: {
                    viewdata: JSON.stringify(tempContext),
                    viewparam: JSON.stringify(this.viewparams),
                },
            },
            on: {
                'viewIsMounted': () => {
                    this.setIsMounted(controlAppView?.name);
                }
            },
            ref: name,
        });
    }

    /**
     * 绘制面板
     *
     * @returns {*}
     * @memberof AppPanelBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const controlClassNames = this.renderOptions.controlClassNames;
        const { width, height } = this.controlInstance;
        const controlStyle: any = {};
        controlStyle.width = width > 0 ? width + 'px' : '100%';
        controlStyle.height = height > 0 ? height + 'px' : '100%';
        let layoutMode = this.controlInstance.layoutMode;
        if (layoutMode && layoutMode == 'FLEX') {
            Object.assign(controlStyle, { 'display': 'flex', 'flex-direction': 'column' });
        }
        return <row class={controlClassNames} style={controlStyle}>
            <div class={{ 'control-content': true, 'app-control-panel__content': true, 'no-padding': this.noPadding }}>{this.renderRootPSPanelItems(this.controlInstance)}</div>
        </row>
    }
}
