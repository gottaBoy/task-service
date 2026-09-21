import { Util } from '../utils';
import { ViewEngine } from './view-engine';

/**
 * 实体选择视图
 *
 * @export
 * @class MPickupViewEngine
 * @extends {ViewEngine}
 */
export class MPickupViewEngine extends ViewEngine {

    /**
     * 选择视图面板
     *
     * @type {*}
     * @memberof MPickupViewEngine
     */
    public pickupViewPanel: any = null;

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof MPickupViewEngine
     */
    public init(options: any): void {
        this.pickupViewPanel = options.pickupViewPanel;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @memberof MPickupViewEngine
     */
    public load(): void {
        super.load();
        if (this.getPickupViewPanel()) {
            const tag = this.getPickupViewPanel().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        }
    }

    /**
     * 引擎事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof MPickupViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);

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
     * @memberof MPickupViewEngine
     */
    public onSelectionChange(ctrlName: string, args: any[]): void {
        if (this.view) {
            this.view.ctrlModel[ctrlName].selections = [...Util.deepCopy(args)];
            this.computeButtonStatus();
            if (!this.view.isShowButton) {
                this.emitViewEvent('viewdataschange', [...args]);
            }
        }
    }

    /**
     * 选择视图面板加载完成
     *
     * @param {string} ctrlName 选择视图面板名称
     * @param {any[]} args 选中数据
     * @memberof MPickupViewEngine
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
        //  选择视图面板部件 数据
        //  初始化默认选中
        if (this.view.viewSelections && this.view.viewSelections.length) {
            const tempSelections: any[] = [];
            this.view.viewSelections.forEach((item: any) => {
                if (this.view.ctrlModel[ctrlName].datas.findIndex((data: any) => Object.is(data.srfkey, item.srfkey)) !== -1) {
                    tempSelections.push(item);
                }
            });
            const selections = this.view.ctrlModel[ctrlName].selections || [];
            this.view.ctrlModel[ctrlName].selections = this.duplicates([...selections, ...tempSelections]);
        }
        this.computeButtonStatus();
    }

    /**
     * 计算按钮状态
     *
     * @private
     * @memberof MPickupViewEngine
     */
    private computeButtonStatus() {
        const panel = this.getPickupViewPanel();
        const viewButtonModel = this.view.viewButtonModel;
        //  有选中数据时，全部到左侧按钮 （右侧有数据时启用，否则禁用）
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
            //  到右侧按钮 （面板存在选中数据或右侧有数据时启用）
            if ((ctrlModel[panel.name].selections && ctrlModel[panel.name].selections.length) || (this.view.viewSelections && this.view.viewSelections.length)) {
                viewButtonModel['view_rightbtn'].disabled = false;
            } else {
                viewButtonModel['view_rightbtn'].disabled = true;
            }
        }
    }

    /**
     * 确认
     *
     * @param {*} data
     * @memberof MPickupViewEngine
     */
    public ok(data: any) {
        this.emitViewEvent('viewdataschange', data);
        this.emitViewEvent('close', null);
    }

    /**
     * 取消
     *
     * @memberof MPickupViewEngine
     */
    public cancel() {
        this.emitViewEvent('viewdataschange', null);
        this.emitViewEvent('close', null);
    }

    /**
     * 去重
     *
     * @param {any[]} data
     * @return {*}  {any[]}
     * @memberof MPickupViewEngine
     */
    public duplicates(data: any[]): any[] {
        const uniqueSet = new Set(data);
        return [...uniqueSet];
    }

    /**
     * 到右侧
     *
     * @memberof MPickupViewEngine
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
     * @memberof MPickupViewEngine
     */
    public toAllRight() {
        const panel: any = Object.values(this.view.ctrlModel).find((model: any) => Object.is(model.type, 'PICKUPVIEWPANEL'));
        if (!panel || !panel.datas || panel.datas.length === 0) {
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
     * @memberof MPickupViewEngine
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
     * @memberof MPickupViewEngine
     */
    public toAllLeft() {
        this.view.viewSelections = [];
        this.view.selectedData = JSON.stringify(this.view.viewSelections);
        this.computeButtonStatus();
    }

    /**
     * 获取选择视图面板
     *
     * @returns {*}
     * @memberof MPickupViewEngine
     */
    public getPickupViewPanel(): any {
        return this.pickupViewPanel;
    }

    /**
     * @description 视图销毁
     * @memberof MPickupViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.pickupViewPanel = null;
    }
}