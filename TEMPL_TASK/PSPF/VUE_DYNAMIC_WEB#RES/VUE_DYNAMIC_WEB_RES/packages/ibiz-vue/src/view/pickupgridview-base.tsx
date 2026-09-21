import { MDViewBase } from './mdview-base';
import { ModelTool, PickupGridViewInterface } from 'ibiz-core';
import { IPSAppDEGridView, IPSDEGrid } from '@ibiz/dynamic-model-api';

/**
 * 表格选择视图基类
 *
 * @export
 * @class PickupGridViewBase
 * @extends {MDViewBase}
 * @implements {PickupGridViewInterface}
 */
export class PickupGridViewBase extends MDViewBase implements PickupGridViewInterface {

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof PickupGridViewBase
     */
    public isSingleSelect: boolean = false;

    /**
     * 选中数据字符串
     * 
     * @type {string}
     * @memberof PickupGridViewBase
     */
    public selectedData?: string;

    /**
     * 表格选择视图实例对象
     * 
     * @type {IPSAppDEGridView}
     * @memberof PickupGridViewBase
     */
    public declare viewInstance: IPSAppDEGridView;

    /**
     * 表格实例对象
     * 
     * @type {IPSDEGrid}
     * @memberof PickupGridViewBase
     */
    private gridInstance!: IPSDEGrid;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PickupGridViewBase
     */
    public engineInit(opts: any): void {
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
                grid: (this.$refs[this.gridInstance.name] as any).ctrl,
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
     * 初始化分页导航视图实例
     * 
     * @memberof PickupGridViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDEGridView;
        await super.viewModelInit();
        this.gridInstance = ModelTool.findPSControlByType("GRID", this.viewInstance.getPSControls());
    }

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PickupGridViewBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        super.onDynamicPropsChange(newVal, oldVal);
        if (newVal?.selectedData && newVal.selectedData != oldVal?.selectedData) {
            this.selectedData = newVal.selectedData;
        }
    }

    /**
     * 监听视图静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PickupGridViewBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.isSingleSelect = newVal.isSingleSelect ? true : false;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof PickupGridViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.gridInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.gridInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染搜索表单
     * 
     * @memberof PickupGridViewBase
     */
    public renderSearchForm() {
        if (!this.searchFormInstance) {
            return
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.searchFormInstance);
        Object.assign(targetCtrlParam.staticProps, { enableSaveFilter: false });
        //  继承样式不带插槽名
        if (this.viewInstance.viewStyle === 'EXTEND') {
            return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.searchFormInstance?.name, on: targetCtrlEvent });
        } else {
            return this.$createElement(targetCtrlName, { slot: 'searchForm', props: targetCtrlParam, ref: this.searchFormInstance?.name, on: targetCtrlEvent });
        }
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof PickupGridViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        if (controlInstance.controlType === 'SEARCHFORM') {
            Object.assign(targetCtrlParam.staticProps, { enableSaveFilter: false })
        }
        if (controlInstance.controlType === 'GRID') {
            Object.assign(targetCtrlParam.dynamicProps, {
                selectedData: this.selectedData,
            });
            Object.assign(targetCtrlParam.staticProps, {
                gridRowActiveMode: 2,
                isSingleSelect: this.isSingleSelect
            });
        }
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

    /**
     * 选择全部
     *
     * @memberof PickupGridViewBase
     */
    public selectAll() {
        if (this.engine) {
            this.engine.selectAll();
        }
    }

}