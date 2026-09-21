import { Util } from '../utils';
import { ViewEngine } from './view-engine';

/**
 * 实体数据多项选择视图（左右关系）引擎
 *
 * @export
 * @class MPickupView2Engine
 * @extends {ViewEngine}
 */
export class MPickupView2Engine extends ViewEngine {

    /**
     * 选择视图面板
     *
     * @type {*}
     * @memberof MPickupView2Engine
     */
    public pickupViewPanel: any = null;

    /**
     * 树导航
     *
     * @type {*}
     * @memberof MPickupView2Engine
     */
    public treeExpBar: any = null;

    /**
     * Creates an instance of MPickupView2Engine.
     * 
     * @memberof MPickupView2Engine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof MPickupView2Engine
     */
    public init(options: any): void {
        this.pickupViewPanel = options.pickupViewPanel;
        this.treeExpBar = options.treeExpBar;
        if (options.view.viewdata) {
            const isStr: boolean = typeof options.view.viewdata == 'string';
            let viewdata: any = isStr ? JSON.parse(options.view.viewdata) : options.view.viewdata;
            if (viewdata['selectedData']) {
                options.view.viewSelections = [...viewdata['selectedData']];
                delete viewdata['selectedData'];
            }
            options.view.viewdata = isStr ? JSON.stringify(viewdata) : viewdata;
        }
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof MPickupView2Engine
     */
    public load(): void {
        super.load();
        if (this.getTreeExpBar()) {
            const tag = this.getTreeExpBar().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        }
    }

    /**
     * 引擎事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof MPickupView2Engine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        const treeExpBar = this.getTreeExpBar();
        if (treeExpBar && Object.is(ctrlName, treeExpBar.name)) {
            this.handleTreeExpBarEvents(eventName, args);
        }
        const panel = this.getPickupViewPanel();
        if (panel && Object.is(ctrlName, panel.name)) {
            this.handlePickupViewPanelEvents(ctrlName, eventName, args);
        }

    }

    /**
     * 处理树导航栏事件
     *
     * @protected
     * @param {string} eventName
     * @param {*} args
     * @memberof MPickupView2Engine
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
     * @param {string} ctrlName
     * @param {*} eventName
     * @param {*} args
     * @memberof MPickupView2Engine
     */
    protected handlePickupViewPanelEvents(ctrlName: string, eventName: any, args: any) {
        if (Object.is(eventName, 'selectionchange')) {
            this.onSelectionChange(ctrlName, args);
        }
        if (Object.is(eventName, 'load')) {
            this.onLoad(ctrlName, args);
        }
        if (Object.is(eventName, 'activated')) {
            this.onSelectionChange(ctrlName, args);
            this.view.onCLickRight();
        }
    }

    /**
     * 值选中变化
     *
     * @param {string} ctrlName 选择视图面板名称
     * @param {any[]} args 选中数据
     * @memberof MPickupView2Engine
     */
    public onSelectionChange(ctrlName: any, args: any[]): void {
        if (this.view) {
            this.view.ctrlModel[ctrlName].selections = [...Util.deepCopy(args)];
            this.computeButtonStatus();
            if (!this.view.isShowButton) {
                this.emitViewEvent('viewdataschange', [...args]);
            }
        }
    }

    /**
     * 视图加载完成
     *
     * @param {string} ctrlName 选择视图面板名称
     * @param {any[]} args 选中数据
     * @memberof MPickupView2Engine
     */
    public onLoad(ctrlName: string, args: any[]): void {
        //  多次加载整合数据（适配树）
        const deDuplicate = (items: any[]) => {
            const back: any[] = [];
            const datas = this.view.ctrlModel[ctrlName].datas || [];
            if (datas?.length > 0) {
                datas.forEach((data: any) => {
                    back.push(data.srfkey);
                })
            }
            const filterArray = items.filter((item: any) => {
                if (item.srfkey && back.indexOf(item.srfkey) === -1) {
                    back.push(item.srfkey);
                    return true;
                } else {
                    return false;
                }
            })
            return filterArray.concat(datas);
        }
        const pickupViewPanel = this.getPickupViewPanel();
        //  特殊识别选择树视图
        if (pickupViewPanel?.embedViewType === 'DEPICKUPTREEVIEW') {
            this.view.ctrlModel[ctrlName].datas = [...Util.deepCopy(deDuplicate(args))];
        } else {
            this.view.ctrlModel[ctrlName].datas = [...Util.deepCopy(args)];
        }
        this.computeButtonStatus();
    }

    /**
     * 计算按钮状态
     *
     * @private
     * @memberof MPickupView2Engine
     */
    private computeButtonStatus() {
        const panel = this.getPickupViewPanel();
        const viewButtonModel = this.view.viewButtonModel;
        //  有选中数据时，全部到右侧按钮 （右侧有数据时启用，否则禁用）
        if (this.view.viewSelections && this.view.viewSelections.length) {
            viewButtonModel['view_allleftbtn'].disabled = false;
            //  到左侧按钮（右侧有选中数据时启用，否则禁用）
            if (this.view.viewSelections.some((selection: any) => selection._select)) {
                viewButtonModel['view_leftbtn'].disabled = false;
            } else {
                viewButtonModel['view_leftbtn'].disabled = true;
            }
        } else {
            viewButtonModel['view_allleftbtn'].disabled = true;
            //  到左侧按钮
            viewButtonModel['view_leftbtn'].disabled = true;
        }
        const ctrlModel = this.view.ctrlModel;
        if (panel && ctrlModel[panel.name]) {
            //  全部到右侧按钮(左侧选择面板有数据时启用，无数据禁用)
            if (ctrlModel[panel.name].datas && ctrlModel[panel.name].datas.length) {
                viewButtonModel['view_allrightbtn'].disabled = false;
            } else {
                viewButtonModel['view_allrightbtn'].disabled = true;
            }
            //  到右侧按钮 （面板存在数据或右侧有数据时启用）
            if ((ctrlModel[panel.name].selections && ctrlModel[panel.name].selections.length) || (this.view.viewSelections && this.view.viewSelections.length)) {
                viewButtonModel['view_rightbtn'].disabled = false;
            } else {
                viewButtonModel['view_rightbtn'].disabled = true;
            }
        }
    }

    /**
     * 到右侧
     *
     * @memberof MPickupView2Engine
     */
    public toRight() {
        const panel: any = Object.values(this.view.ctrlModel).find((model: any) => Object.is(model.type, 'PICKUPVIEWPANEL'));
        if (!panel) {
            return;
        }
        const newSelections: any[] = [];
        const backSelections: any[] = this.view.viewSelections || [];
        panel.selections?.forEach((item: any) => {
            const index = this.view.viewSelections.findIndex((select: any) => Object.is(item.srfkey, select.srfkey));
            if (index === -1) {
                let _item = Util.deepCopy(item);
                //  添加右侧区域选中标识
                Object.assign(_item, { _select: false });
                newSelections.push(_item);
            } else {
                newSelections.push(this.view.viewSelections[index]);
            }
        });
        this.view.viewSelections = this.duplicates([...newSelections, ...backSelections]);
        this.computeButtonStatus();
    }

    /**
     * 全部到右侧
     *
     * @memberof MPickupView2Engine
     */
    public toAllRight() {
        const panel: any = Object.values(this.view.ctrlModel).find((model: any) => Object.is(model.type, 'PICKUPVIEWPANEL'));
        if (!panel || !panel.datas || panel.datas.length === 0) {
            return;
        }
        let flag: boolean = false;
        panel.datas.forEach((data: any) => {
            const index = this.view.viewSelections.findIndex((select: any) => Object.is(data.srfkey, select.srfkey));
            if (index > 0) {
                flag = true;
            }
        })
        if (flag && panel.datas.length > 0) {
            return;
        }
        if (this.getPickupViewPanel()) {
            this.getPickupViewPanel().selectAll(panel.datas);
        }
        panel.datas.forEach((data: any) => {
            if (!data.srfmajortext) {
                Object.assign(data, { srfmajortext: data[this.majorPSDEField as string] });
            }
            const index = this.view.viewSelections.findIndex((selection: any) => Object.is(data.srfkey, selection.srfkey));
            if (index === -1) {
                let _item = Util.deepCopy(data);
                //  添加右侧区域选中标识
                Object.assign(_item, { _select: false });
                this.view.viewSelections.push(_item);
            }
        });
        this.view.selectedData = JSON.stringify(this.view.viewSelections);
        panel.selections = [...this.view.viewSelections];
        this.computeButtonStatus();
    }

    /**
     * 到左侧
     *
     * @memberof MPickupView2Engine
     */
    public toLeft() {
        const selections = Util.deepCopy(this.view.viewSelections);
        selections.forEach((item: any) => {
            if (!item._select) {
                return;
            }
            const index = this.view.viewSelections.findIndex((selection: any) => Object.is(item.srfkey, selection.srfkey));
            if (index !== -1) {
                this.view.viewSelections.splice(index, 1);
            }
        });
        this.view.selectedData = JSON.stringify(this.view.viewSelections);
        this.computeButtonStatus();
    }

    /**
     * 全部到左侧
     *
     * @memberof MPickupView2Engine
     */
    public toAllLeft() {
        this.view.viewSelections = [];
        this.view.selectedData = JSON.stringify(this.view.viewSelections);
        this.computeButtonStatus();
    }

    /**
    * 去重
    *
    * @param {any[]} data
    * @return {*}  {any[]}
    * @memberof MPickupView2Engine
    */
    public duplicates(data: any[]): any[] {
        const uniqueSet = new Set(data);
        return [...uniqueSet];
    }

    /**
     * 获取选择视图面板
     *
     * @returns {*}
     * @memberof MPickupView2Engine
     */
    public getPickupViewPanel(): any {
        return this.pickupViewPanel;
    }

    /**
     * 获取树导航
     *
     * @returns {*}
     * @memberof MPickupView2Engine
     */
    public getTreeExpBar(): any {
        return this.treeExpBar;
    }

    /**
     * @description 视图销毁
     * @memberof MPickupView2Engine
     */
    public destroyed() {
        super.destroyed();
        this.pickupViewPanel = null;
        this.treeExpBar = null;
    }
}