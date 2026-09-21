import { IPSAppDEReportView, IPSDEReportPanel } from '@ibiz/dynamic-model-api';
import { ModelTool, ReportViewInterface } from 'ibiz-core';
import { MDViewBase } from './mdview-base';

/**
 * 实体报表视图基类
 *
 * @export
 * @class DeReportViewBase
 * @extends {MDViewBase}
 * @implements {ReportViewInterface}
 */
export class DeReportViewBase extends MDViewBase implements ReportViewInterface {

    /**
     * 视图实例
     * 
     * @memberof DeReportViewBase
     */
    public declare viewInstance: IPSAppDEReportView;

    /**
     * 报表面板实例
     * 
     * @memberof DeReportViewBase
     */
    public reportPanelInstance!: IPSDEReportPanel;

    /**
     * 初始化报表视图实例
     * 
     * @param opts 
     * @memberof DeReportViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDEReportView;
        await super.viewModelInit();
        this.reportPanelInstance = ModelTool.findPSControlByName('reportpanel', this.viewInstance.getPSControls()) as IPSDEReportPanel;
    }

    /**
     * 报表视图引擎初始化
     * 
     * @param opts 
     * @memberof DeReportViewBase
     */
    public engineInit() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.reportPanelInstance) {
            let engineOpts: any = ({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance?.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                reportpanel: (this.$refs[this.reportPanelInstance?.name] as any).ctrl,
            });
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
     * 渲染视图主体内容区
     * 
     * @memberof DeReportViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.reportPanelInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.reportPanelInstance?.name, on: targetCtrlEvent },);
    }

}