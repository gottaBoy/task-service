import { IPSAppDEGridView, IPSDEGrid, IPSDEToolbarItem } from '@ibiz/dynamic-model-api';
import { GirdViewInterface, ModelTool, Util } from 'ibiz-core';
import { MDViewBase } from './mdview-base';

/**
 * 表格视图基类
 *
 * @export
 * @class GridViewBase
 * @extends {MDViewBase}
 * @implements {GirdViewInterface}
 */
export class GridViewBase extends MDViewBase implements GirdViewInterface {

    /**
     * 视图实例
     * 
     * @memberof GridViewBase
     */
    public declare viewInstance: IPSAppDEGridView;

    /**
     * 表格实例
     * 
     * @memberof GridViewBase
     */
    public gridInstance!: IPSDEGrid;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof GridViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.gridInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance?.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                },
                grid: (this.$refs[this.gridInstance?.name] as any).ctrl,
            }, opts)
            if (this.searchFormInstance?.name && this.$refs[this.searchFormInstance.name]) {
                engineOpts.searchform = ((this.$refs[this.searchFormInstance.name] as any).ctrl);
            }
            if (this.quickSearchFormInstance?.name && this.$refs[this.quickSearchFormInstance.name]) {
                engineOpts.quicksearchform = ((this.$refs[this.quickSearchFormInstance.name] as any).ctrl);
            }
            if (this.searchBarInstance?.name && this.$refs[this.searchBarInstance.name]) {
                engineOpts.searchbar = ((this.$refs[this.searchBarInstance.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }

    /**
     * 初始化表格视图实例
     * 
     * @memberof GridViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.gridInstance = ModelTool.findPSControlByType("GRID", this.viewInstance.getPSControls());
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof GridViewBase
     */
    public renderMainContent() {
        if (!this.gridInstance) {
            return;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.gridInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.gridInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {any} [controlInstance] 部件模型实例
     * @returns
     * @memberof GridViewBase
     */
     public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.staticProps, {
            isOpenEdit: this.viewInstance?.rowEditDefault,
            gridRowActiveMode: this.viewInstance?.gridRowActiveMode,
        });
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 部件事件
     * @param ctrl 部件 
     * @param action  行为
     * @param data 数据
     * 
     * @memberof GridViewBase
     */
    public onCtrlEvent(controlname: string, action: string, data: any) {
        if(action) {
            switch (action) {
                case "save":
                    this.$emit("view-event", { action: "drdatasaved", data: data });
                    break;
                case "search":
                    this.onSearch(data);
                    break;
                default:
                    super.onCtrlEvent(controlname, action, data);
                    break;
            }
        }
    }

    /**
     * 初始化工具栏项
     *
     * @param {IPSDEToolbarItem} item
     * 
     * @@memberof ViewBase
     */
    initToolBarItems(item: IPSDEToolbarItem): void {
        const tempModel: any = super.initToolBarItems(item);
        // 导出最大行数
        if(tempModel?.uiaction?.uIActionTag == "ExportExcel"){
            const gridInstance = ModelTool.findPSControlByType("GRID",this.viewInstance.getPSControls());
            const maxRowCount = gridInstance.getPSDEDataExport()?.maxRowCount;
            if(maxRowCount){
                tempModel.MaxRowCount = maxRowCount;
            }
        }
        return tempModel;
    }

}
