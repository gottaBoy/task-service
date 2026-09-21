import { Prop, Watch, Emit } from 'vue-property-decorator';
import { throttle, Util } from 'ibiz-core';
import { ListControlBase } from '../../../widgets';
import { IPSDEListItem, IPSDEUIAction, IPSDEUIActionGroup, IPSUIActionGroupDetail } from '@ibiz/dynamic-model-api';

/**
 * 实体列表部件基类
 *
 * @export
 * @class AppListBase
 * @extends {ListControlBase}
 */
export class AppListBase extends ListControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppListBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppListBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppListBase
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
     * @memberof AppListBase
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
     * @memberof AppListBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     * 
     * @param 抛出参数 
     * @memberof AppListBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string, action: string, data: any }): void {
        if (action == 'panelDataChange') {
            this.onPanelDataChange(data.item, data.data);
        }
    }

    /**
     * @description 绘制加载更多
     * @return {*} 
     * @memberof AppListBase
     */
    renderLoadMore(){
        return (
            <div onclick={(event: MouseEvent)=>{this.loadMore()}} class="app-control-list__load--more">{this.$tl('app.list.loadmore','加载更多')}</div>
        )
    }

    /**
     * 绘制列表
     *
     * @returns {*}
     * @memberof AppListBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={{...controlClassNames, "app-control-list--empty": this.items.length <= 0}}>
                <div class="control-content app-control-list__content">
                    {
                        this.items.length > 0 ? this.renderHaveItems() 
                        : !this.ctrlLoadingService?.isLoading ? this.renderEmptyDataTip() : this.renderLoadDataTip()
                    }
                    {Object.is(this.totalRecord, this.items.length) ? null : this.renderLoadMore()}
                </div>
                {this.viewStyle == "DEFAULT" ? <el-backtop target={`#${this.controlId}`}></el-backtop> : null}
                {this.renderBatchToolbar()}
            </div>
        )
    }

    /**
     * 绘制列表项内容
     *
     * @returns {*}
     * @memberof AppListBase
     */
    public renderListItemContent(item: any, index: number) {
        const listItem = this.controlInstance.getPSDEListItems?.()?.[0] || null;
        return (
            <div class="item__content">
                <div class="item__content__left">
                    <span class="left__title">{item.srfmajortext}</span>
                    <span class="left__description">{item.content ? item.content : null}</span>
                </div>
                <div class="item__content__right">
                    {listItem ? this.renderListItemAction(item, listItem) : ''}
                </div>
            </div>
        )
    }

    /**
     * 绘制有items的情况
     *
     * @returns {*}
     * @memberof AppListBase
     */
    public renderHaveItems() {
        if (this.isEnableGroup) {
            return this.renderHaveGroup();
        } else {
            return this.items.map((item: any, index: number) => {
                return this.renderDefaultItem(item, index)
            }) 
        }
    }

    /**
     * 绘制面板部件
     *
     * @returns {*}
     * @memberof AppListBase
     */
    public renderItemPSLayoutPanel(item: any) {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.controlInstance.getItemPSLayoutPanel(), item);
        Object.assign(targetCtrlParam.staticProps, { panelType: 'ITEMLAYOUTPANEL', noPadding: true });
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.controlInstance.getItemPSLayoutPanel()?.name, on: targetCtrlEvent });
    }


    /**
     * 绘制默认列表项
     *
     * @returns {*}
     * @memberof AppListBase
     */
    public renderDefaultItem(item: any, index: number) {
        const itemCssName = {
            "app-control-list__content__item": true,
            "is-active": item.srfchecked === 1
        }
        const itemCss = (this.controlInstance as any).M.getItemPSSysCss;
        if (itemCss) {
            Object.assign(itemCssName, {
                [itemCss.cssName] : true,
            })
        }
        return (
            <div
                key={index}
                class={itemCssName}
                on-click={() => throttle(this.handleClick, [item], this)}
                on-dblclick={() => throttle(this.handleDblClick, [item], this)}>
                {this.controlInstance.getItemPSLayoutPanel() ? this.renderItemPSLayoutPanel(item) : this.renderListItemContent(item, index)}
            </div>
        )
    }

    /**
     * 绘制有分组的情况
     *
     * @returns {*}
     * @memberof AppListBase
     */
    public renderHaveGroup() {
        return (
            <el-collapse>
                {this.groupData.map((item: any) => {
                    return (
                        <el-collapse-item class="app-control-list__content__group">
                            <div slot='title' class="group__title">
                                <b>{item.group}</b>
                            </div>
                            {item.children.length > 0 ? (
                                <div class="group__content">
                                    {item.children.map((item: any, index: number) => {
                                        return this.renderDefaultItem(item, index);
                                    })}
                                </div>
                            ) : (
                                <div class="group__empty">{this.$tl('app.commonwords.nodata','暂无数据')}</div>
                            )}
                        </el-collapse-item>
                    )
                })}
            </el-collapse>
        )
    }

    /**
     * 绘制列表项行为
     * @param item 列数据
     * @param listItem
     * @memberof AppListBase
     */
    public renderListItemAction(item: any, listItem: IPSDEListItem) {
        const UIActionGroupDetails: IPSUIActionGroupDetail[] = (listItem.getPSDEUIActionGroup() as IPSDEUIActionGroup)?.getPSUIActionGroupDetails() || [];
        return UIActionGroupDetails.map((uiactionDetail: IPSUIActionGroupDetail, index: number) => {
            const uiaction: IPSDEUIAction = uiactionDetail.getPSUIAction() as IPSDEUIAction;
            if (uiaction && item[uiaction.uIActionTag].visabled) {
                return (
                    <a key={index} class="item__content__right__action" disabled={item[uiaction.uIActionTag].disabled} on-click={($event: any) => { throttle(this.handleActionClick,[item, $event, listItem, uiactionDetail],this) }}>
                        {uiactionDetail.showIcon ? <i class={[uiaction.getPSSysImage()?.cssClass, "item__content__right__action__icon" ]}></i> : ''}
                        <span>{uiactionDetail.showCaption ? this.$tl(uiaction.getCapPSLanguageRes()?.lanResTag, uiaction.caption) : ""}</span>
                    </a>
                )
            }
        });
    }
}