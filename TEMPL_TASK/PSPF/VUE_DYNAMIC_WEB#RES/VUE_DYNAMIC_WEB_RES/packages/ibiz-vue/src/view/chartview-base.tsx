import { IPSAppDataEntity, IPSAppDEChartView, IPSAppDEField, IPSDEChart } from '@ibiz/dynamic-model-api';
import { ChartViewEngine, ModelTool, ChartViewInterface } from 'ibiz-core';
import { MDViewBase } from './mdview-base';

/**
 * 图表视图基类
 *
 * @export
 * @class ChartViewBase
 * @extends {MDViewBase}
 * @implements {ChartViewInterface}
 */
export class ChartViewBase extends MDViewBase implements ChartViewInterface {

    /**
     * 视图实例
     * 
     * @memberof ChartViewBase
     */
    public declare viewInstance: IPSAppDEChartView;

    /**
     * 图表实例
     * 
     * @memberof ChartViewBase
     */
    public chartInstance!: IPSDEChart;

    /**
     * 引擎对象
     *
     * @type {ChartViewEngine}
     * @memberof ChartViewBase
     */
    public declare engine: ChartViewEngine;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof ChartViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.chartInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance.loadDefault !== false ? true : false,
                keyPSDEField: (ModelTool.getContainerAppEntityCodeName(this.viewInstance) as string).toLowerCase(),
                majorPSDEField: (ModelTool.getAppEntityMajorField(this.viewInstance.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase(),
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                },
                chart: (this.$refs[this.chartInstance.name] as any).ctrl,
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
      * 初始化图表视图实例
      * 
      * @param opts 
      * @memberof ChartViewBase
      */
    public async viewModelInit() {
        // 填充图表视图实体
        await this.viewInstance.getPSAppDataEntity()?.fill();
        await super.viewModelInit();
        this.chartInstance = ModelTool.findPSControlByName('chart', this.viewInstance.getPSControls()) as IPSDEChart;
    }

    /**
     * 渲染视图主体内容区
     * 
     * @returns
     * @memberof ChartViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.chartInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.chartInstance?.name, on: targetCtrlEvent });
    }

}
