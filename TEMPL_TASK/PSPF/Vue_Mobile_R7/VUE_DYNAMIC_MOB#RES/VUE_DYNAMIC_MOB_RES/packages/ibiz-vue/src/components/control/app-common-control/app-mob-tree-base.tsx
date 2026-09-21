import { Prop, Watch, Emit, Component } from 'vue-property-decorator';
import { ModelTool, Util } from 'ibiz-core';
import { MobTreeControlBase } from '../../../widgets';
import { IPSAppDETreeView, IPSDETreeNode, IPSDEContextMenu } from '@ibiz/dynamic-model-api';

/**
 * 树视图部件基类
 *
 * @export
 * @class AppMobTreeBase
 * @extends {MobTreeControlBase}
 */
@Component({})
export class AppMobTreeBase extends MobTreeControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppMobTreeBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppMobTreeBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobTreeBase
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
     * @memberof AppMobTreeBase
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
     * @memberof AppMobTreeBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobTreeBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制上下文菜单
     *
     * @memberof AppMobTreeBase
     */
    public renderContextMenu() {
        if (!Util.isEmpty(this.activeNode)) {
            let treeNodes = this.controlInstance.getPSDETreeNodes() || [];
            let treeNode = treeNodes.find((node: IPSDETreeNode) => this.activeNode == node.nodeType) as IPSDETreeNode;
            let contextMenu = ModelTool.findPSControlByName(treeNode?.getPSDEContextMenu()?.name as string, this.controlInstance.getPSControls());
            if (contextMenu) {
                let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(contextMenu);
                targetCtrlParam.dynamicProps.contextMenuActionModel = this.copyActionModel;
                return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: contextMenu.name, on: targetCtrlEvent, key: contextMenu.codeName + JSON.stringify(this.copyActionModel) });
            }
        }
    }

    /**
     * 绘制普通树
     *
     * @memberof AppMobTreeBase
     */
    public renderDefaultTree() {
        return this.valueNodes.map((item: any) => {
            return <v-touch on-press={() => this.node_touch(item)} key={item.srfkey}>
                <ion-item class="tree__list__item">
                    <ion-label>{item.text}</ion-label>
                </ion-item>
            </v-touch>
        })
    }

    /**
     * 绘制多选树
     *
     * @memberof AppMobTreeBase
     */
    public renderMultipleTree() {
        return <ion-list class="app-control-treeview__content__tree">
            {this.valueNodes.map((item: any) => {
                return <ion-item class="tree__list__item">
                    <ion-checkbox color="secondary" ref={item.srfkey + 'checkbox'} checked={item.selected} value={item.srfkey} slot="end" on-ionChange={this.onChecked.bind(this)}></ion-checkbox>
                    <ion-label class="tree__list__item__label">
                        {item.strIcon != 'default_text'
                            ? (item.strIcon ? <img src={item.strIcon} /> : <div class="text">{item.text?.substring(0, 1)}</div>)
                            : null
                        }
                        {item.text}
                    </ion-label>
                </ion-item>
            })}
        </ion-list>
    }

    /**
     * 绘制单选树
     *
     * @memberof AppMobTreeBase
     */
    public renderSingleTree() {
        return <ion-radio-group value={this.selectedValue} class="app-control-treeview__content__tree">
            {this.valueNodes.map((item: any) => {
                return <ion-item on-click={() => this.onSimpleSelChange(item)} class="tree__list__item">
                    <ion-label class="tree__list__item__label">
                        {item.strIcon != 'default_text'
                            ? (item.strIcon ? <img class="tree__list__item__img" src={item.strIcon} /> : <div class="text">{item.text?.substring(0, 1)}</div>)
                            : null
                        }
                        {item.text}
                    </ion-label>
                    <ion-radio slot="end" checked={item.selected} value={item.srfkey}></ion-radio>
                </ion-item>
            })}
        </ion-radio-group>
    }

    /**
     * 根据视图类型绘制树
     *
     * @memberof AppMobTreeBase
     */
    public renderByViewType() {
        let viewType = '';
        const parent: any = this.controlInstance.getParentPSModelObject();
        // 代理模式需要多拿一级
        if (parent.viewProxyMode) {
            const view = parent.getParentPSModelObject() as IPSAppDETreeView;
            viewType = view.viewType;
        } else {
            viewType = parent.viewType;
        }
        if (viewType == "DEMOBTREEVIEW") {
            return this.renderDefaultTree();
        } else if (viewType == 'DEMOBPICKUPTREEVIEW' && !this.isSingleSelect) {
            return this.renderMultipleTree();
        } else if (viewType == 'DEMOBPICKUPTREEVIEW' && this.isSingleSelect) {
            return this.renderSingleTree();
        }
    }

    /**
     * 树导航栏
     *
     * @return {*} 
     * @memberof AppMobTreeBase
     */
    public renderTreeNav() {
        return <div class="app-control-treeview__header__navigationbar">
            {this.treeNav.map((item: any, index: number) => {
                let className = { 'navigationbar__item': true, 'navigationbar__item--active': index + 1 < this.treeNav.length };
                return [
                    <span key={item.id} class={className} on-click={() => this.nav_click(item)}>{item.text}</span>,
                    index + 1 < this.treeNav.length && <span class="text" key={item.id + 'span'} >{'>'}</span>
                ]
            })}
        </div>
    }

    /**
     * 绘制树内容
     *
     * @returns {*}
     * @memberof AppMobTreeBase
     */
    public renderTreeContent(): any {
        return <div class="app-control-treeview__content__tree">
            {this.valueNodes.length > 0 && <div class="tree__partition" ></div>}
            <ion-list class="tree__list">
                {this.rootNodes.map((item: any, index: number) => {
                    return <v-touch on-press={() => this.node_touch(item)} key={index}>
                        <ion-item on-click={() => this.click_node(item)} class="tree__list__item">
                            <ion-label>{item.text}</ion-label>
                            <app-mob-icon class="tree__list__item__icon" position="end" name="chevron-forward-outline"></app-mob-icon>
                        </ion-item>
                    </v-touch>
                })}
            </ion-list>
            {this.rootNodes.length > 0 && <div class="tree__partition"></div>}
            {this.renderByViewType()}
        </div>

    }

    /**
     * 绘制树视图
     *
     * @returns {*}
     * @memberof AppMobTreeBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={controlClassNames} >
                <div class="control-header app-control-treeview__header">
                    {this.renderTreeNav()}
                </div>
                <div class="control-content app-control-treeview__content">
                    {this.renderTreeContent()}
                    <app-mob-context-menu
                        ref="contextmenu"
                        scopedSlots={{
                            content: () => {
                                return this.renderContextMenu()
                            }
                        }}>
                    </app-mob-context-menu>
                </div>
            </div>
        )
    }
}