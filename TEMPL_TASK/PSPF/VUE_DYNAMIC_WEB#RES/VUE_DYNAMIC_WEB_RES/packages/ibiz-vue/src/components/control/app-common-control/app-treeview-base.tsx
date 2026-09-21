import { Emit, Prop, Watch } from 'vue-property-decorator';
import { Util, ModelTool, throttle } from 'ibiz-core';
import { TreeControlBase } from '../../../widgets';
import { IPSDETreeNode, IPSDEContextMenu } from '@ibiz/dynamic-model-api';

/**
 * 树视图部件基类
 *
 * @export
 * @class AppTreeViewBase
 * @extends {TreeControlBase}
 */
export class AppTreeViewBase extends TreeControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppTreeViewBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppTreeViewBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppTreeViewBase
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
     * @memberof AppTreeViewBase
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
     * @memberof AppTreeViewBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppTreeViewBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制右击菜单
     *
     * @param {*} node
     * @returns
     * @memberof AppTreeViewBase
     */
    public renderContextMenu(node: any) {
        if (node && node.data) {
            const data: any = Util.deepCopy(node.data);
            this.currentselectedNode = { ...data };
            const tags: string[] = data.id.split(';');
            let treeNodes = this.controlInstance.getPSDETreeNodes() || [];
            let treeNode = treeNodes.find((node: IPSDETreeNode) => tags[0] == node.nodeType) as IPSDETreeNode;
            let contextMenu = treeNode.getPSDEContextMenu() as IPSDEContextMenu;;
            if (contextMenu && contextMenu.controlType == "CONTEXTMENU") {
                let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(contextMenu);
                targetCtrlParam.dynamicProps.contextMenuActionModel = this.copyActionModel;
                Object.assign(targetCtrlEvent, {
                    'ctrl-event': ({ controlname, action, data }: { controlname: string, action: string, data: any }) => {
                        this.onCtrlEvent(controlname, action, data, Util.deepCopy(this.currentselectedNode));
                    },
                })
                return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: contextMenu.name, on: targetCtrlEvent });
            }
        }
        return null;
    }

    /**
     * 绘制内容
     *
     * @returns
     * @memberof AppTreeViewBase
     */
    public renderNode(treeNode: any): any {
        const curNode = treeNode.node;
        const nodeData = treeNode.data;
        const data = nodeData?.curData;
        // 绘制图标
        let iconElement = null;
        if (nodeData.iconCustomCode) {
            let icon = '';
            if (nodeData.iconScriptCode.indexOf('return') !== -1) {
                nodeData.iconScriptCode = nodeData.iconScriptCode.replace(new RegExp('return', 'g'), `icon =`);
            }
            eval(nodeData.iconScriptCode);
            iconElement = <span domPropsInnerHTML={icon}></span>;
        } else if (nodeData.iconcls) {
            iconElement = <i class={nodeData.iconcls}></i>
        } else if (nodeData.icon) {
            iconElement = <img src={nodeData.icon} class="icon__img" />
        } else if (this.controlInstance.outputIconDefault) {
            iconElement = <i class="ivu-icon ivu-icon-ios-paper-outline"></i>        
        } else if (nodeData.leaf || curNode.isLeaf){
            iconElement = <span class="is-leaf__symbol"></span>
        }
        const cssName = nodeData.cssName ? nodeData.cssName : "";
        const nodeStyle = {
            'width': '100%',
            // 'padding-left': node.parent?.data?.enablecheck && !node.data?.enablecheck ? '22px' : '0px',
        }
        if (this.ctrlTriggerLogicMap.get('calcnodestyle')) {
            let styleObj = this.ctrlTriggerLogicMap.get('calcnodestyle').executeUILogic({ arg: { node:curNode, data:nodeData } });
            Object.assign(nodeStyle, styleObj);
        }
        // 绘制显示文本
        let textElement = null;

        if (nodeData.textCustomCode) {
            let text = '';
            if (nodeData.textScriptCode.indexOf('return') !== -1) {
                nodeData.textScriptCode = nodeData.textScriptCode.replace(new RegExp('return', 'g'), `text =`);
            }
            eval(nodeData.textScriptCode);
            textElement = <span domPropsInnerHTML={text}></span>;
        } else if (nodeData.html) {
            textElement = <span domPropsInnerHTML={nodeData.html}></span>;
        } else {
            textElement = <span>{Object.is(nodeData.nodeType, "STATIC") ? this.$tl(nodeData.lanResTag, nodeData.text) : nodeData.text}</span>
        }

        // 计数器 
        let nodeCount: any = undefined;
        if (this.controlInstance.getPSAppCounterRef()?.id) {
            let counterService = Util.findElementByField(this.counterServiceArray, 'id', this.controlInstance.getPSAppCounterRef()?.id)?.service;
            nodeCount = counterService?.counterData?.[nodeData.counterId];
        }
        let nodeCountStyle = {
            count: nodeCount,
            showZero: nodeData.counterMode !== 1,
            offset: [4, 7]
        }

        return (
            <context-menu
                ref={nodeData.id}
                isBlocked={true}
                contextMenuStyle={nodeStyle}
                data={curNode}
                renderContent={this.renderContextMenu.bind(this)}
                on-showContext={(e: any) => {
                    this.showContext(nodeData, e);
                }}
            >
                <div
                    class={["tree__node", cssName]}
                    title={nodeData.tooltip ? nodeData.tooltip : Object.is(nodeData.nodeType, "STATIC") ? this.$tl(nodeData.lanResTag, nodeData.text) : nodeData.text}
                    v-badge={nodeCountStyle}
                    on-dblclick={() => {
                        throttle(this.doDefaultAction, [curNode], this);
                    }}
                >
                    {iconElement ? <span class="tree__node__icon">{iconElement}</span> : null}
                    <span class="tree__node__text">
                        {textElement}
                    </span>
                </div>
            </context-menu>
        );
    }

    /**
     * 绘制内容
     *
     * @returns
     * @memberof AppTreeViewBase
     */
    public render(): any {
        if (!this.controlIsLoaded || !this.inited) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={controlClassNames}>
                <context-menu-container class="control-content app-control-treeview__content">
                    <app-element-tree
                        ref={this.name}
                        class="app-control-treeview__content__tree"
                        node-key='id'
                        lazy
                        show-checkbox={!this.isSingleSelect}
                        check-on-click-node={!this.isSingleSelect}
                        default-expanded-keys={this.expandedKeys}
                        props={{
                            props: {
                                label: 'text',
                                isLeaf: 'leaf',
                                children: 'children',
                            }
                        }}
                        draggable={this.draggable}
                        allow-drag={(node: any) => { return throttle(this.allowDrag, [node], this) }}
                        allow-drop={(draggingNode: any, dropNode: any, type: string) => { return this.allowDrop(draggingNode, dropNode, type) }}
                        on-edit-value-change={(value: string, node: any, event: any) => { this.nodeValueChange(value, node, event) }}
                        on-close-edit={(node: any, event: any) => { this.saveAndRefresh(node, event) }}
                        load={this.load.bind(this)}
                        highlight-current={true}
                        expand-on-click-node={false}
                        on-check={(data: any, checkedState: any) => { this.onCheck(data, checkedState) }}
                        on-current-change={this.selectionChange.bind(this)}
                        filter-node-method={this.filterNode.bind(this)}
                        empty-text={this.$t('app.commonwords.nodata')}
                        scopedSlots={{
                            default: this.renderNode.bind(this)
                        }}
                    ></app-element-tree>
                </context-menu-container>
            </div>
        );
    }
}
