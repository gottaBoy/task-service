import { Prop, Watch, Emit } from 'vue-property-decorator';
import { throttle, Util } from 'ibiz-core';
import { MobPanelControlBase } from '../../../widgets';
import { IPSDEViewPanel, IPSPanelContainer, IPSPanelControl, IPSPanelItem, IPSPanelTabPage, IPSPanelTabPanel} from '@ibiz/dynamic-model-api';

/**
 * 面板部件基类
 *
 * @export
 * @class AppMobPanelBase
 * @extends {PanelControlBase}
 */
export class AppMobPanelBase extends MobPanelControlBase {
    /**
     * 部件动态参数
     *
     * @memberof AppMobPanelBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof PanelControlBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobPanelBase
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
     * @memberof AppMobPanelBase
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
     * @memberof AppMobPanelBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppDefaultTree
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制顶级面板成员集合
     *
     * @memberof AppMobPanelBase
     */

    public renderRootPSPanelItems(controlInstance: any) {
        return controlInstance.getRootPSPanelItems()?.map((container: any, index: number) => {
            return this.renderByDetailType(container, index);
        });
    }

    /**
     * 根据detailType绘制对应detail
     *
     * @param {*} modelJson
     * @param {number} index
     * @memberof AppMobPanelBase
     */
    public renderByDetailType(modelJson: any, parent?: any, index?: number) {
        if (modelJson.getPSSysPFPlugin()) {
            const pluginInstance: any = this.PluginFactory.getPluginInstance("CONTROLITEM", modelJson.getPSSysPFPlugin().pluginCode);
            if (pluginInstance) {
                return pluginInstance.renderCtrlItem(this.$createElement, modelJson, this, this.data);
            }
        } else {
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
                    return this.renderRawitem(modelJson, index);
                case 'BUTTON':
                    return this.renderButton(modelJson, index);
                case 'CONTROL':
                    return this.renderControl(modelJson, index);
            }
        }
    }

    /**
     * 绘制面板Container
     *
     * @memberof AppMobPanelBase
     */

    public renderContainer(container: IPSPanelContainer, parent?: any, index?: number) {
        const panelItems: IPSPanelItem[] = container.getPSPanelItems() || [];
        let name: string = container.name;
        //  父容器为多数据容器
        let hasMulParent: boolean = false;
        if (parent && parent.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[parent.name]?.getData()?.length > 0) {
            hasMulParent = true;
            name += `_${index}`;
        }
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const layout = container.getPSLayout()?.layout;
        // 获取盒子宽高/间隔模式
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        // 获取布局设置(约束子,如：flex布局及相关设置)
        const boxLayoutStyle = this.layoutDetailsModel[name].getBoxLayoutStyle();
        // 获取盒子自身应有样式
        Object.assign(detailStyle, boxLayoutStyle);
        // 获取盒子样式表
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        // 合并盒子动态样式表
        if (container.dynaClass) {
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            detailClass.push(...eval(container.dynaClass));
        }
        if (layout && Object.is(layout, 'BORDER')) {
            return (
                <van-col style={detailStyle} class={detailClass} nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }} >
                    {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                        this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                            return <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems, index)}</app-scroll-container>;
                        }) : hasMulParent ?
                            <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems, index)}</app-scroll-container> :
                            <app-scroll-container panelItems={panelItems}>{this.renderChildItems(container, panelItems)}</app-scroll-container>}
                    {this.layoutDetailsModel[name].isLoading ? <app-loading-mask/> : null}
                </van-col>
            );
        } else if (layout && (Object.is(layout, 'FLEX'))) {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <van-row style={container.showCaption ? '' : detailStyle} class={detailClass} nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }} >
                    {container.showCaption ? <div class={`app-control-panel__container__header`}>
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                    </div> : null}
                    {<div class={`app-control-panel__container__content ${this.panelType === 'ITEMLAYOUTPANEL' ? 'is-layout' : ''}`} style={detailStyle}>
                        {
                            container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                    return this.renderChildItems(container, panelItems, index);
                                }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)
                        }
                    </div>}
                    {this.layoutDetailsModel[name].isLoading ? <app-loading-mask/> : null}
                </van-row>
            );
        } else if (layout && Object.is(layout, 'SIMPLEFLEX')) {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <van-row style={container.showCaption ? '' : detailStyle} class={detailClass} nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }} >
                    {container.showCaption ? <div class={`app-control-panel__container__header`}>
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                    </div> : null}
                    {<div class={`app-control-panel__container__content ${this.panelType === 'ITEMLAYOUTPANEL' ? 'is-layout' : ''}`} style={detailStyle}>
                        {
                            container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                                this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                                    return <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>
                                }) : hasMulParent ? <app-simpleflex-container panelItems={panelItems} index={index} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container> : <app-simpleflex-container panelItems={panelItems} renderCallBack={this.renderByDetailType.bind(this)}></app-simpleflex-container>
                        }
                    </div>}
                    {this.layoutDetailsModel[name].isLoading ? <app-loading-mask/> : null}
                </van-row>
            );
        } else {
            //  存在三种情况(1：该容器为多数据容器; 2: 父容器为多数据容器; 3: 正常容器)
            return (
                <van-row style={detailStyle} class={detailClass} nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(container.name, name, 'onclick', { hasMulParent, index, event }) } }} >
                    {container.showCaption ? <div class={`app-control-panel__container__header`}>
                        <span>{this.$tl(container.getCapPSLanguageRes?.()?.lanResTag, container.caption)}</span>
                    </div> : null}
                    {container.dataRegionType === 'MULTIDATA' && this.layoutDetailsModel[name]?.getData()?.length > 0 ?
                        this.layoutDetailsModel[name]?.getData().map((data: any, index: number) => {
                            return this.renderChildItems(container, panelItems, index);
                        }) : hasMulParent ? this.renderChildItems(container, panelItems, index) : this.renderChildItems(container, panelItems)}
                    {this.layoutDetailsModel[name].isLoading ? <app-loading-mask /> : null}
                </van-row>

            );
        }
    }

    /**
     * 绘制子项
     *
     * @param {IPSPanelContainer} parent
     * @param {IPSPanelItem[]} panelItems
     * @param {number} [index]
     * @return {*} 
     * @memberof AppMobPanelBase
     */
    public renderChildItems(parent: IPSPanelContainer, panelItems: IPSPanelItem[], index?: number) {
        if (!parent || !panelItems || (panelItems.length === 0)) {
            return null;
        }
        const layout = parent.getPSLayout()?.layout;
        return panelItems.map((item: any) => {
            const name = `${item.name}${index === undefined || index === null ? '' : '_' + index}`;
            const childDetailStyle: any = {};
            Object.assign(childDetailStyle, this.layoutDetailsModel[name]?.getBoxLayoutPosStyle());
            if (Object.is(layout, 'BORDER')) {
                return (
                    <div style={childDetailStyle} slot={item.name} class={'app-control-panel__container__item'}>
                        {this.renderByDetailType(item, parent, index)}
                    </div>
                );
            } else if (Object.is(layout, 'FLEX')) {
                return (
                    <div style={childDetailStyle} class={'app-control-panel__container__item'} >
                        {this.renderByDetailType(item, parent, index)}
                    </div>
                );
            } else if (Object.is(layout, 'TABLE_12COL') || Object.is(layout, 'TABLE_24COL')) {
                const attrs = this.layoutDetailsModel[name]?.getGridLayoutProps(item, layout);
                return (
                    <van-col {...{ props: attrs?.md }} style={childDetailStyle} class={'app-control-panel__container__item'}>
                        {this.renderByDetailType(item, parent, index)}
                    </van-col>
                );
            }
        })

    }

    /**
     * 绘制面板Button
     *
     * @memberof AppMobPanelBase
     */

    public renderButton(modelJson: any, index?: number) {
        const { caption, showCaption } = modelJson;
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name].getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        if (modelJson?.M?.buttonCssStyle) {
            Object.assign(detailStyle, this.getContentStyle(modelJson?.M?.buttonCssStyle))
        }
        return (
            <app-mob-button
                id={name}
                modelJson={modelJson}
                style={detailStyle}
                text={showCaption ? caption : ''}
                disabled={this.layoutDetailsModel[name]?.disabled}
                class={detailClass}
                showDefaultIcon={false}
                on-click={($event: any) => {
                    this.buttonClick(this.controlInstance.name, { tag: name }, $event);
                }}
            ></app-mob-button>
        );
    }

    /**
     * 获取内容样式
     *
     * @param {*} data
     * @return {*} 
     * @memberof AppMobPanelBase
     */
    getContentStyle(data: any) {
        if (data) {
            const res = data.split('\n');
            const target: string[] = [];
            res.forEach((item: any) => {
                target.push(...item.split(';').filter((value: any) => value));
            });
            let btnstyle = target.filter((value: string) => {
                return value.split(':').length === 2;
            })
            let detail = {}
            btnstyle.forEach(item => {
                let obj = item.split(":")
                Object.assign(detail, { [obj[0]]: obj[1] })
            })
            return detail;
        }
    }

    /**
     * 绘制面板Field
     *
     * @memberof AppMobPanelBase
     */

    public renderField(modelJson: any, index?: number) {
        const { caption, hidden, showCaption } = modelJson;
        //  存在多份属性模型时根据下标获取对应 name
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name].getDetailClass();
        Object.assign(detailClass, { 'item-field': true });
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        const editor: any = modelJson.getPSEditor();
        const labelPos = 'LEFT';
        // 合并盒子动态样式表
        const captionClass = {};
        const context = this.context;
        const viewparams = this.viewparams;
        const data = this.data;
        if (modelJson.dynaClass) {
            detailClass.push(...eval(modelJson.dynaClass));
        }
        if (modelJson.labelDynaClass) {
            Object.assign(captionClass, ...eval(modelJson.labelDynaClass));
        }
        return (
            !hidden && (<app-panel-field
                name={name}
                labelPos={labelPos}
                caption={this.$tl(modelJson.getCapPSLanguageRes()?.lanResTag, caption)}
                isEmptyCaption={!showCaption}
                captionClass={captionClass}
                error={this.rules[editor.name]?.message}
                data={this.data}
                value={this.data[name]}
                itemRules={this.rules[editor.name]}
                required={this.layoutDetailsModel[modelJson.name]?.required}
                class={detailClass}
                style={detailStyle}
            >
                {editor && (
                    <app-default-editor
                        value={this.data[name]}
                        editorInstance={editor}
                        containerComponent={this}
                        containerCtrl={this.controlInstance}
                        parentItem={modelJson}
                        contextData={this.data}
                        context={this.context}
                        viewparams={this.viewparams}
                        disabled={this.layoutDetailsModel[modelJson.name]?.disabled}
                        on-change={(event: any) => {
                            this.onPanelItemValueChange(event);
                        }}
                    />
                )}
            </app-panel-field>
            )
        )
    }
    /**
     * 绘制面板Rawitem
     *
     * @memberof AppMobPanelBase
     */

    public renderRawitem(modelJson: any, index?: number) {
        const { contentType } = modelJson;
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name].getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        const rawItemDetail = modelJson.M.getPSRawItem;
        const imageDetail = { imageClass: modelJson.getPSSysImage()?.cssClass, imagePath: modelJson.getPSSysImage()?.imagePath };
        if (modelJson.getPSSysImage()?.rawContent) {
            Object.assign(imageDetail, { imagePath: modelJson.getPSSysImage()?.rawContent });
        }
        const content = this.layoutData[name];
        return (
            <app-rawitem
                class={detailClass}
                style={detailStyle}
                context={this.context}
                viewparams={this.viewparams}
                contentType={contentType}
                rawItemDetail={rawItemDetail}
                imageDetail={imageDetail}
                content={content}
                nativeOn={{ 'click': (event: any) => { this.handlePanelItemEvent(modelJson.name, name, 'onclick', { index, event }) } }}
            >
            </app-rawitem>
        );
    }

    /**
     * 绘制面板TabPanel
     *
     * @memberof AppMobPanelBase
     */

    public renderTabPanel(modelJson: IPSPanelTabPanel, parent?: any, index?: number) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const tabPages: IPSPanelTabPage[] = modelJson.getPSPanelTabPages() || [];
        const activedTabPage: any = this.layoutDetailsModel[name]?.activatedPage;
        const detailClass = this.layoutDetailsModel[name].getDetailClass();
        const detailStyle = this.layoutDetailsModel[name].getBoxStyle();
        // 合并盒子动态样式表
        if (modelJson.dynaClass) {
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            detailClass.push(...eval(modelJson.dynaClass));
        }
        return (
            <van-tabs
                type="card"
                animated={true}
                value={activedTabPage}
                class={detailClass}
                style={parent ? {} : detailStyle}
                on-click={($event: any) => throttle(this.handleTabPanelClick, [modelJson.name, $event], this)}
            >
                {tabPages.length > 0 ?
                    tabPages.map((item: IPSPanelTabPage) => {
                        return this.renderTabPage(item, index);
                    }) : null}
            </van-tabs>
        );
    }

    /**
     * 绘制面板TabPage
     *
     * @memberof AppMobPanelBase
     */
    public renderTabPage(modelJson: IPSPanelTabPage, index?: number) {
        const name: string = !this.layoutDetailsModel[`${modelJson.name}_${index}`] ? modelJson.name : `${modelJson.name}_${index}`;
        if (!this.layoutDetailsModel[name]) {
            return null;
        }
        const detailClass = this.layoutDetailsModel[name]?.getDetailClass();
        const label = this.$tl(modelJson.getCapPSLanguageRes?.()?.lanResTag, modelJson.caption);
        const panelItems: IPSPanelItem[] = modelJson.getPSPanelItems() || [];
        return (
            <van-tab title={label} name={modelJson.name} class={detailClass}>
                {this.renderChildItems(modelJson, panelItems, index)}
            </van-tab>
        );
    }

    /**
     * 绘制面板Control
     *
     * @memberof AppMobPanelBase
     */
    public renderControl(modelJson: IPSPanelControl, parent?: any, index?: number) {
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
     * 根据controlType绘制对应control
     *
     * @param {*} modelJson
     * @memberof AppMobPanelBase
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
     * @memberof AppMobPanelBase
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
                    portletState: this.viewState,
                    viewDefaultUsage: 'INCLUDEDVIEW',
                    viewModelData: controlAppView
                },
                dynamicProps: {
                    _context: JSON.stringify(tempContext),
                    _viewparams: JSON.stringify(this.viewparams),
                },
            },
            class: "view-container2",
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
     * @memberof AppMobPanelBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        let rootStyle = { height: '100%', width: '100%' };
        let layoutMode = this.controlInstance?.getPSLayout()?.layout;
        if (layoutMode && layoutMode == 'FLEX') {
            Object.assign(rootStyle, { 'display': 'flex', 'flex-direction': 'column' });
        } else {
            Object.assign(rootStyle, { overflow: 'auto' });
        }
        return <div class={controlClassNames} style={rootStyle}>
            <div class="control-content app-control-panel__content">
                <van-row>
                    {this.controlInstance.getRootPSPanelItems()?.map((container: any, index: number) => {
                        return this.renderByDetailType(container);
                    })}
                </van-row>
            </div>
        </div>
    }
}
