import { MDViewBase } from './mdview-base';
import { IndexPickupDataViewInterface, ModelTool } from 'ibiz-core';
import { IPSAppDEDataView, IPSDEDataView } from '@ibiz/dynamic-model-api';


/**
 * 索引关系选择视图基类
 *
 * @export
 * @class IndexPickupDataViewBase
 * @extends {MDViewBase}
 * @implements {IndexPickupDataViewInterface}
 */
export class IndexPickupDataViewBase extends MDViewBase implements IndexPickupDataViewInterface {

    /**
     * 实体索引关系选择数据视图（部件视图）
     * 
     * @type {IPSAppDEDataView}
     * @memberof IndexPickupDataViewBase
     */
    public declare viewInstance: IPSAppDEDataView;

    /**
     * 数据视图部件实例对象
     * 
     * @type {IPSDEDataView}
     * @memberof IndexPickupDataViewBase
     */
    private dataviewInstance!: IPSDEDataView;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof IndexPickupDataViewBase
     */
    public isSingleSelect: boolean = false;

    /**
     * 引擎初始化
     *
     * @param {*} opts
     * @return {*} 
     * @memberof IndexPickupDataViewBase
     */
    public engineInit(opts: any) {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.dataviewInstance) {
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
                dataview: (this.$refs[this.dataviewInstance?.name] as any).ctrl,
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
     * 初始化表单选择数据视图实例
     * 
     * @memberof IndexPickupDataViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDEDataView;
        await super.viewModelInit();
        this.dataviewInstance = ModelTool.findPSControlByType("DATAVIEW", this.viewInstance.getPSControls());
    }

    /**
     * 监听视图静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IndexPickupDataViewBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.isSingleSelect = newVal.isSingleSelect;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof IndexPickupDataViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.dataviewInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.dataviewInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof IndexPickupDataViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.staticProps, {
            isSingleSelect: this.isSingleSelect
        });
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

}