import { ViewEngine } from './view-engine';

/**
 * 实体选择视图(左右关系)
 *
 * @export
 * @class PickupView2Engine
 * @extends {ViewEngine}
 */
export class PickupView2Engine extends ViewEngine {

    /**
     * 树导航
     *
     * @type {*}
     * @memberof PickupView2Engine
     */
    private treeExpBar: any = null;

    /**
     * 选择视图面板
     *
     * @private
     * @type {*}
     * @memberof PickupView2Engine
     */
    private pickupViewPanel: any = null;

    /**
     * Creates an instance of PickupView2Engine.
     * 
     * @memberof PickupView2Engine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof PickupView2Engine
     */
    public init(options: any): void {
        this.treeExpBar = options.treeExpBar;
        this.pickupViewPanel = options.pickupviewpanel;
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof PickupView2Engine
     */
    public load(): void {
        this.view.viewSelections = [];
        super.load();
        if (this.getTreeExpBar()) {
            const tag = this.getTreeExpBar().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        }
    }

    /**
     * 处理部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof PickupView2Engine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        const treeExpBar = this.getTreeExpBar();
        if (ctrlName === treeExpBar?.name) {
            this.handleTreeExpBarEvents(eventName, args);
        }
        const panel = this.getPickupViewPanel();
        if (ctrlName === panel?.name) {
            this.handlePickupViewPanelEvents(eventName, args);
        }
    }

    /**
     * 处理树导航栏事件
     *
     * @protected
     * @param {string} eventName 事件名称
     * @param {*} args 参数
     * @memberof PickupView2Engine
     */
    protected handleTreeExpBarEvents(eventName: string, args: any) {
        if (eventName === 'selectionchange') {
            this.view.navItem = args;
            this.view.$forceUpdate();
            this.view.$nextTick(() => {
                if (this.getPickupViewPanel()) {
                    this.setViewState2({ tag: this.getPickupViewPanel().name, action: 'load', viewdata: args?.srfnavdata?.viewparams });
                }
            })
        }
        if (Object.is(eventName, 'activated')) {
            this.emitViewEvent('viewdatasactivated', args);
        }
    }

    /**
     * 处理选择视图面板事件
     *
     * @protected
     * @param {string} eventName 事件名称
     * @param {*} args 参数
     * @memberof PickupView2Engine
     */
    protected handlePickupViewPanelEvents(eventName: string, args: any) {
        if (eventName === 'selectionchange') {
            this.onSelectionChange(args);
        }
    }

    /**
     * 值选中变化
     *
     * @param {any[]} args
     * @memberof PickupView2Engine
     */
    public onSelectionChange(args: any[]): void {
        this.view.viewSelections = [];
        this.view.viewSelections = [...args]
        const _disabled: boolean = this.view.viewSelections.length > 0 ? false : true;
        this.view.viewButtonModel.view_okbtn.disabled = _disabled;
        if(!this.view.isShowButton){
            this.emitViewEvent('viewdataschange', [...args]);
        }
    }

    /**
     * 获取树导航
     *
     * @returns {*}
     * @memberof PickupView2Engine
     */
    public getTreeExpBar(): any {
        return this.treeExpBar;
    }

    /**
     * 获取选择视图面板
     *
     * @return {*}  {*}
     * @memberof PickupView2Engine
     */
    public getPickupViewPanel(): any {
        return this.pickupViewPanel;
    }

    /**
     * @description 视图销毁
     * @memberof PickupView2Engine
     */
    public destroyed() {
        super.destroyed();
        this.pickupViewPanel = null;
        this.treeExpBar = null;
    }
}