import { Emit, Prop, Watch } from 'vue-property-decorator';
import { throttle, Util } from 'ibiz-core'
import { KanbanControlBase } from '../../../widgets';
import { IPSUIAction, IPSUIActionGroup, IPSUIActionGroupDetail } from '@ibiz/dynamic-model-api';

/**
 * 实体看板部件基类
 *
 * @export
 * @class AppKanbanBase
 * @extends {KanbanControlBase}
 */
export class AppKanbanBase extends KanbanControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppKanbanBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppKanbanBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppKanbanBase
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
     * @memberof AppKanbanBase
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
     * @memberof AppKanbanBase
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
     * 绘制itemPSLayoutPanel部件
     *
     * @returns {*}
     * @memberof AppKanbanBase
     */
    public renderItemPSLayoutPanel(item: any) {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.controlInstance.getItemPSLayoutPanel(), item);
        Object.assign(targetCtrlParam.staticProps, { isLoadDefault: true });
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.controlInstance?.getItemPSLayoutPanel?.name, on: targetCtrlEvent });
    }

    /**
     * 绘制折叠栏
     * 
     * @param group 分组
     * @param index 下标
     * @memberof AppKanbanBase
     */
    public renderDragbar(group: any, index: any) {
        return (
            <draggable
                list={group?.items}
                class="group__foldingbar"
                ghostClass="group__foldingbar__ghost"
                handle=".foldingarea__content__item"
                group={{ name: 'bar', put: group?.folding ? false : true }}
                on-change={($event: any) => this.onDragChange($event, group?.value)}>
                {
                    !group.folding ?
                        <div class="group__foldingbar__content" on-click={() => throttle(this.onClick, [group, index], this)}>
                            <div class="foldingbar__content__icon">
                                <i class="el-icon-s-unfold" title={this.$t('components.content.open')}></i>
                            </div>
                            <div class="foldingbar__content__title">
                                <span>{this.getGroupText(group?.value)}{"(" + group?.items?.length + ")"}</span>
                            </div>
                        </div> : null
                }
            </draggable>
        );
    }

    /**
     * 绘制分组界面行为
     * 
     * @param ActionGroup 分组界面行为组
     * @param group 分组类型
     * @memberof AppKanbanBase
     */
    public renderGroupAction(ActionGroup: IPSUIActionGroup | null, group: any) {
        return (
            <poptip trigger="hover" content="content" placement={!Object.is(this.controlInstance?.groupLayout, 'COLUMN') ? 'bottom-end' : 'right-start'} class="foldingarea__header__action">
                <icon type={!Object.is(this.controlInstance?.groupLayout, 'COLUMN') ? 'md-more' : 'ios-more'} />
                <div slot="content" class="header__action__content">
                    {
                        ActionGroup?.getPSUIActionGroupDetails()?.map((uiActionDetail: IPSUIActionGroupDetail) => {
                            const uiAction = uiActionDetail.getPSUIAction() as IPSUIAction;
                            if (uiAction) {
                                return (
                                    <div class="header__action__content__item">
                                        <i-button long on-click={($event: any) => throttle(this.uiActionClick, [uiActionDetail, $event, group], this)}>
                                            {uiAction.getPSSysImage()?.imagePath ? <img class="item__icon" src={uiAction.getPSSysImage()?.imagePath} /> : null}
                                            {uiAction.getPSSysImage()?.cssClass ? <i class={[uiAction.getPSSysImage()?.cssClass, "item__icon"]}></i> : null}
                                            <span class="item__caption">{this.$tl(uiAction.getCapPSLanguageRes()?.lanResTag, uiAction.caption)}</span>
                                        </i-button>
                                    </div>
                                )
                            }
                        })
                    }
                </div>
            </poptip>
        )
    }

    /**
     * 绘制项内容
     * 
     * @param item 看板项
     * @memberof AppKanbanBase
     */
    public renderItemContent(item: any) {
        if (this.controlInstance?.getItemPSSysPFPlugin()) {
            const pluginInstance: any = this.PluginFactory.getPluginInstance("CONTROLITEM", this.controlInstance?.getItemPSSysPFPlugin()?.pluginCode || '');
            if (pluginInstance) {
                return pluginInstance.renderCtrlItem(this.$createElement, this.controlInstance, this, item);
            }
        } else {
            return item.srfmajortext
        }
    }

    /**
     * 绘制分组看板
     * 
     * @param group 分组
     * @param index 下标
     * @memberof AppKanbanBase
     */
    public renderGroup(group: any, index: any) {
        const groupStyle = {
            'flex-grow': this.controlInstance?.groupWidth || this.controlInstance.groupHeight ? false : '1'
        }
        this.controlInstance?.groupWidth ? Object.assign(groupStyle, { width: this.controlInstance?.groupWidth + 'px' }) : null;
        this.controlInstance?.groupHeight ? Object.assign(groupStyle, { height: this.controlInstance?.groupHeight + 'px' }) : null;
        return (
            group.folding ?
                <div class="group__foldingarea" style={groupStyle}>
                    <div class={["group__foldingarea__header", this.controlInstance?.getGroupPSSysCss()?.cssName]}>
                        <div class="foldingarea__header__icon" on-click={() => throttle(this.onClick, [group, index], this)}>
                            <i class="el-icon-s-fold" title={this.$t('components.content.close')}></i>
                        </div>
                        <span class="foldingarea__header__title">
                            {this.getGroupText(group.value)}
                        </span>
                        {this.controlInstance.getGroupPSUIActionGroup() ? this.renderGroupAction(this.controlInstance.getGroupPSUIActionGroup(), group) : null}
                    </div>
                    <draggable list={group.items} group={this.controlInstance?.name} filter=".foldingarea__content__empty" class="group__foldingarea__content" on-change={($event: any) => this.onDragChange($event, group.value)} on-end={() => this.onDragEnd()}>
                        {group.items.length > 0 ?
                            group.items.map((item: any) => {
                                return (
                                    <div class={{ "foldingarea__content__item": true, "is-active": item.srfchecked === 1 }} on-click={() => throttle(this.handleClick, [item], this)} on-dblclick={() => throttle(this.handleDblClick, [item], this)}>
                                        {this.controlInstance.getItemPSLayoutPanel() ? this.renderItemPSLayoutPanel(item) : this.renderItemContent(item)}
                                    </div>
                                )
                            }) :
                            <div class="foldingarea__content__empty">
                                <span>{this.$tl(this.controlInstance.getEmptyTextPSLanguageRes()?.lanResTag, this.$t('app.commonwords.nodata'))}</span>
                            </div>
                        }
                    </draggable>
                </div> : null
        );
    }

    /**
     * 绘制部件
     * 
     * @param h 
     * @memberof AppKanbanBase
     */
    public render(h: any) {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={{ ...controlClassNames, "app-control-kanban__row": !Object.is(this.controlInstance?.groupLayout, 'COLUMN'), "app-control-kanban__column": Object.is(this.controlInstance.groupLayout, 'COLUMN') }}>
                <div class="control-content app-control-kanban__content">
                    {
                        this.groups.map((item, index) => {
                            if (this.controlInstance?.getGroupPSSysPFPlugin()) {
                                const pluginInstance: any = this.PluginFactory.getPluginInstance("CONTROLITEM", this.controlInstance.getGroupPSSysPFPlugin()?.pluginCode || '');
                                if (pluginInstance) {
                                    return pluginInstance.renderCtrlItem(this.$createElement, this.controlInstance, this, item);
                                }
                            } else {
                                return (
                                    <div class={{"app-control-kanban__content__group": true, 'is-folding': !item.folding}}>
                                        {this.renderDragbar(item, index)}
                                        {this.renderGroup(item, index)}
                                    </div>
                                )
                            }
                        })
                    }
                    {this.renderQuickToolbar()}
                </div>
            </div>
        )
    }
}