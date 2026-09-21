import { Emit, Prop, Watch } from 'vue-property-decorator';
import { Util, ViewTool } from 'ibiz-core';
import { MobMDCtrlControlBase } from '../../../widgets';
import { IPSUIAction, IPSUIActionGroupDetail } from '@ibiz/dynamic-model-api';

/**
 * 多数据部件基类
 *
 * @export
 * @class AppMobMDCtrlBase
 * @extends {MobMDCtrlControlBase}
 */
export class AppMobMDCtrlBase extends MobMDCtrlControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppMobMDCtrlBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppMobMDCtrlBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobMDCtrlBase
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
     * @memberof AppMobMDCtrlBase
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
     * @memberof AppMobMDCtrlBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobMDCtrlBase
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
        const { controlType, codeName } = this.controlInstance;
        // 部件类名
        const controlClassNames: any = {
            'control-container': true,
            'multidata-container': true,
            [`app-control-${controlType.toLowerCase()}`]: true,
            [Util.srfFilePath2(codeName)]: true,
        };
        Object.assign(controlClassNames, opts);
        if (this.controlInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(controlClassNames, { [this.controlInstance?.getPSSysCss()?.cssName || '']: true });
        }
        if (this.listMode) {
            Object.assign(controlClassNames, { [`app-control-${controlType.toLowerCase()}__` + this.listMode.toLowerCase()]: true });
        }
        this.$set(this.renderOptions, 'controlClassNames', controlClassNames);
    }

    /**
     * 绘制界面行为组
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderListItemAction(item: any) {
        return [
            this.controlInstance?.getPSDEUIActionGroup?.() ? this.renderActionGroup(item) : null,
            this.controlInstance?.getPSDEUIActionGroup2?.() ? this.renderActionGroup2(item) : null,
        ]
    }

    /**
     * 绘制左滑界面行为组
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase``
     */
    public renderActionGroup(item: any) {
        const details = this.controlInstance?.getPSDEUIActionGroup()?.getPSUIActionGroupDetails?.();
        if (this.controlInstance.controlStyle != 'LISTVIEW3') {
            return <ion-item-options side="start">
                {details && details?.map((detail: IPSUIActionGroupDetail) => {
                    if (detail.getPSUIAction()) {
                        const uiaction: IPSUIAction | null = detail.getPSUIAction();
                        if (uiaction && item[uiaction.codeName]?.visabled) {
                            let iconName = item[uiaction.codeName].icon ? ViewTool.setIcon(item[uiaction.codeName]?.icon) : '';
                            return <ion-item-option disabled={item[uiaction.codeName]?.disabled} color={uiaction.uIActionTag == "Remove" ? 'danger' : 'primary'} on-click={($event: any) => this.mdctrl_click($event, detail, item)}>
                                {item[uiaction.codeName]?.icon && item[uiaction.codeName]?.isShowIcon && <ion-icon name={iconName}></ion-icon>}
                                {item[uiaction.codeName]?.isShowCaption && <ion-label >{this.$tl(uiaction.getCapPSLanguageRes()?.lanResTag, uiaction.caption)}</ion-label>}
                            </ion-item-option>
                        }
                    }
                })}
            </ion-item-options>
        }
    }

    /**
     * 绘制右滑界面行为组
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderActionGroup2(item: any) {
        const details = this.controlInstance?.getPSDEUIActionGroup2()?.getPSUIActionGroupDetails?.();
        if (this.controlInstance.controlStyle != 'LISTVIEW3') {
            return <ion-item-options side="end">
                {details?.map((detail: IPSUIActionGroupDetail) => {
                    if (detail.getPSUIAction()) {
                        const uiaction: IPSUIAction | null = detail.getPSUIAction();
                        if (uiaction && item[uiaction.codeName]?.visabled) {
                            let iconName = item[uiaction.codeName].icon ? ViewTool.setIcon(item[uiaction.codeName]?.icon) : '';
                            return <ion-item-option disabled={item[uiaction.codeName]?.disabled} color={uiaction.uIActionTag == "Remove" ? 'danger' : 'primary'} on-click={($event: any) => this.mdctrl_click($event, detail, item)}>
                                {item[uiaction.codeName]?.icon && item[uiaction.codeName]?.isShowIcon && <ion-icon name={iconName}></ion-icon>}
                                {item[uiaction.codeName]?.isShowCaption && <ion-label >{this.$tl(uiaction.getCapPSLanguageRes()?.lanResTag, uiaction.caption)}</ion-label>}
                            </ion-item-option>
                        }
                    }
                })}
            </ion-item-options>
        }
    }
    /**
     * 绘制导航列表
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderListExpBar() {
        return <van-sidebar
            v-model={this.sidebarValue}
            on-change={this.switchView.bind(this)}>
            {this.items.length>0?this.items.map((item: any, index: number) => {
                return <van-sidebar-item class={{ 'list__sidebar__item': true, 'list__sidebar__item--active': this.sidebarValue === index }} key={item?.srfkey} >
                    <div slot="title">
                        {this.controlInstance?.getItemPSLayoutPanel() ? this.renderItemPSLayoutPanel(item) : <ion-label>{item?.srfmajortext}</ion-label>}
                    </div>
                </van-sidebar-item>
            }):<div class="control-content--nodata">{this.$t('app.commonWords.noData')}</div>}
        </van-sidebar>
    }

    /**
     * 绘制列表项插件
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderPluginItem(item: any) {
        const plugin = this.controlInstance.getPSSysPFPlugin()
        if (plugin) {
            const pluginInstance: any = this.PluginFactory.getPluginInstance("CONTROLITEM", plugin.pluginCode);
            if (pluginInstance) {
                return pluginInstance.renderCtrlItem(this.$createElement, item, this, null);
            }
        }
    }

    /**
     * 绘制列表主体
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderMainMDCtrl() {
        return this.items.length > 0
            ? <ion-list class="app-control-mobmdctrl__content__list" ref="ionlist">
                {this.controlInstance.enableGroup ? this.renderHaveGroup() : this.renderNoGroup()}
            </ion-list>
            : !this.isFirstLoad ? <div class="control-content--nodata">{this.$t('app.commonWords.noData')}</div> : null
    }

    /**
     * 绘制触底加载
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderBottomRefresh() {
        if (this.loadStatus && !this.allLoaded) {
            return <div class="loadding">
                <span >{this.$t('app.loadding') ? this.$t('app.loadding') : "加载中"}</span>
                <ion-spinner name="dots"></ion-spinner>
            </div>
        }
    }

    /**
     * 绘制分组
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderHaveGroup() {
        return this.groupParam.group_data.map((obj: any) => {
            return <div class="item-grouped">
                <van-collapse v-model={this.activeName} on-change={($event: any) => { this.activeName = $event; }}>
                    {obj.items && obj.items.length > 0 &&
                        <van-collapse-item name={obj.text}>
                            <template slot="title">
                                <div>{obj.text}(<label>{obj.items.length}</label>)</div>
                            </template>
                            {obj.items.map((item: any, index: any) => {
                                return <ion-item-sliding ref={item?.srfkey} class="list__sliding__item" on-click={() => this.item_click(item)}>
                                    {this.renderListItemAction(item)}
                                    {
                                        this.controlInstance?.getPSSysPFPlugin()?.pluginType === 'LIST_ITEMRENDER' ? this.renderPluginItem(item) : this.controlInstance?.getItemPSLayoutPanel() ? this.renderItemPSLayoutPanel(item) : this.renderListContent(item, index)
                                    }
                                </ion-item-sliding>
                            })}
                        </van-collapse-item>}
                </van-collapse>
            </div>
        })

    }

    /**
     * 绘制无分组
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderNoGroup() {
        return this.items.length > 0
            ? this.items.map((item: any, index) => {
                return <ion-item-sliding ref={item?.srfkey} class="list__sliding" on-click={() => this.item_click(item)}>
                    {this.renderListItemAction(item)}
                    {
                        this.controlInstance.getPSSysPFPlugin()?.pluginType === 'LIST_ITEMRENDER' ? this.renderPluginItem(item) : this.controlInstance.getItemPSLayoutPanel() ? this.renderItemPSLayoutPanel(item) : this.renderListContent(item, index)
                    }
                </ion-item-sliding>
            })
            : null
    }

    /**
     * 绘制面板部件
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderItemPSLayoutPanel(item: any) {
        if (!this.controlInstance.getItemPSLayoutPanel()) {
            return null
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.controlInstance.getItemPSLayoutPanel(), item);
        Object.assign(targetCtrlParam.dynamicProps, { inputData: item });
        return <div style="width:100%;">
            <ion-item class="list__sliding__item">
                {/* {this.listMode == 'SELECT' ? <ion-checkbox slot="start" class="iconcheck" value={item.srfkey} on-ionChange={($event: any) => { this.selectionchange($event) }}></ion-checkbox> : null} */}
                {this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.controlInstance.getItemPSLayoutPanel()?.name, on: targetCtrlEvent })}
            </ion-item>
        </div>
    }


    /**
     * 绘制列表项集合
     * @return {*} 
     * @memberof AppDefaultMobMDCtrlBase
     */
    public renderListContent(item: any, index: any) {
        return <ion-item class="list__sliding__item">
            <app-list-index-text item={item} index={index}></app-list-index-text>
        </ion-item>
    }


    /**
     * 绘制选择列表
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public renderSelectMDCtrl() {
        return this.items.length > 0
            ? (!this.isSingleSelect ?
                <ion-list>
                    {this.items.map((item: any) => {
                        return <ion-item class="list__sliding__item">
                            <ion-checkbox color="secondary" checked={item.checked} value={item.srfkey} on-ionChange={($event: any) => { this.selectionchange($event) }} slot="end"></ion-checkbox>
                            {this.controlInstance?.getItemPSLayoutPanel() ? this.renderItemPSLayoutPanel(item) : <ion-label>{item.srfmajortext}</ion-label>}
                        </ion-item>
                    })}
                </ion-list>
                : <ion-radio-group value={this.selectedValue} >
                    {this.items.map((item: any) => {
                        return <ion-item class="list__sliding__item" on-click={() => { this.onSimpleSelChange(item) }}>
                            {this.controlInstance?.getItemPSLayoutPanel() ? this.renderItemPSLayoutPanel(item) : <ion-label>{item.srfmajortext}</ion-label>}
                            <ion-radio checked={item.checked} slot="end" value={item.srfkey}></ion-radio>
                        </ion-item>
                    })}
                </ion-radio-group>
            )
            : (!this.isFirstLoad ? <div class="no-data">{this.$t('app.commonWords.noData')}</div> : null)
    }


    /**
     * 绘制列表
     *
     * @returns {*}
     * @memberof AppMobMDCtrlBase
     */
    public render() {
        const { controlClassNames } = this.renderOptions;
        if (!this.controlIsLoaded) {
            return null;
        }
        return (
            <div class={controlClassNames}>
                <div class="control-content app-control-mobmdctrl__content">
                    <van-pull-refresh class="app-control-mobmdctrl__content__refresh" value={this.isLoadding}  on-refresh={() => { this.pullDownToRefresh() }} disabled={!this.enablePullDownRefresh}>
                        {this.listMode == "LISTEXPBAR" ?
                            this.renderListExpBar() :
                            this.listMode == "SELECT" ?
                                this.renderSelectMDCtrl() :
                                [this.renderMainMDCtrl(), this.renderBottomRefresh()]}
                    </van-pull-refresh>
                </div>
            </div>
        );
    }
}
