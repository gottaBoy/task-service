import { IPSAppDEChartExplorerView, IPSChartExpBar } from '@ibiz/dynamic-model-api';
import { ChartExpViewEngine, ModelTool } from 'ibiz-core';
import { ExpViewBase } from './expview-base';

export class ChartExpViewBase extends ExpViewBase {

    /**
     * 图表导航视图实例对象
     * 
     * @type {IPSAppDEChartExplorerView}
     * @memberof ChartExpViewBase
     */
    public declare viewInstance: IPSAppDEChartExplorerView;

    /**
     * 图表导航栏实例对象
     * 
     * @type {IPSChartExpBar}
     * @memberof ChartExpViewBase
     */
    public declare expBarInstance: IPSChartExpBar;

    /**
     * 视图模型初始化
     * 
     * @memberof ChartExpViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDEChartExplorerView;
        this.expBarInstance = ModelTool.findPSControlByType('CHARTEXPBAR', this.viewInstance?.getPSControls?.() || []);
    }

    /**
     * 引擎初始化
     * 
     * @memberof ChartExpViewBase
     */
    public engineInit() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let engineOpts = ({
            view: this,
            p2k: '0',
            chartexpbar: (this.$refs[this.expBarInstance.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
        this.engine.init(engineOpts);
    }

    /**
     * 处理占位比例变化
     *
     * @protected
     * @memberof ChartExpViewBase
     */
    protected handleSplitChange() {
        if (this.split) {
            this.$store.commit("setViewSplit", { viewUID: `${this.viewInstance?.codeName}_${this.expBarInstance?.codeName}`, viewSplit: this.split });
            if (this.viewState && this.expBarInstance) {
                this.viewState.next({ tag: this.expBarInstance.name, action: 'updateSize', data: null });
            }
        }
    }
}