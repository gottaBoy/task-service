import { IPSAppDEMobChartView, IPSDEChart } from '@ibiz/dynamic-model-api';
import { MobChartViewInterface, ModelTool } from 'ibiz-core';
import { MDViewBase } from './md-view-base';

/**
 * 图表视图基类
 *
 * @export
 * @class MobChartViewBase
 * @extends {MDViewBase}
 */
export class MobChartViewBase extends MDViewBase implements MobChartViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MobChartViewBase
     */
    public declare viewInstance: IPSAppDEMobChartView;

    /**
     * 图表实例
     * 
     * @memberof MobChartViewBase
     */
    public chartInstance!: IPSDEChart;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof MobChartViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        if (this.engine) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: true,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                }
            }, opts)
            if (this.chartInstance?.name && this.$refs[this.chartInstance.name]) {
                engineOpts.chart = ((this.$refs[this.chartInstance.name] as any).ctrl);
            }
            if (this.searchFormInstance?.name && this.$refs[this.searchFormInstance.name]) {
                engineOpts.searchform = ((this.$refs[this.searchFormInstance.name] as any).ctrl);
            }
            if (this.searchBarInstance?.name && this.$refs[this.searchBarInstance.name]) {
                engineOpts.searchBar = ((this.$refs[this.searchBarInstance.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }

    /**
      * 初始化图表视图实例
      * 
      * @param opts 
      * @memberof MobChartViewBase
      */
    public async viewModelInit() {
        await this.viewInstance.getPSAppDataEntity()?.fill();
        await super.viewModelInit();
        this.chartInstance = ModelTool.findPSControlByName('chart', this.viewInstance.getPSControls()) as IPSDEChart;
    }

    /**
     * 渲染视图主体内容区
     * 
     * @returns
     * @memberof MobChartViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.chartInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.chartInstance.name, on: targetCtrlEvent });
    }

    /**
     * 渲染内容区
     * 
     * @memberof ViewBase
     */
    public renderContent() {
        const id = this.viewInstance.codeName;
        const content = [this.renderBodyMessage(), this.renderMainContent()]
        return <div class="view-content" slot="content" id={id}>
            {[...content]}
        </div>
    }
}
