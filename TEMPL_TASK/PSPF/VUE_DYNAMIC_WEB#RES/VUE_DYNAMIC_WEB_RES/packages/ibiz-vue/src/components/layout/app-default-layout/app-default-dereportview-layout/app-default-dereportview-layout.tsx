import { IPSDEReportPanel, IPSDESearchForm, IPSSearchBar } from '@ibiz/dynamic-model-api';
import { ModelTool } from 'ibiz-core';
import { Component } from 'vue-property-decorator';
import { AppDefaultMDViewLayout } from '../app-default-mdview-layout/app-default-mdview-layout';

@Component({})
export class AppDefaultDeReportViewLayout extends AppDefaultMDViewLayout {
    /**
     * 报表视图引擎初始化
     * 
     * @param opts 
     * @memberof AppDefaultDeReportViewLayout
     */
    public engineInit() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 报表面板实例
        const reportPanelInstance = ModelTool.findPSControlByType('REPORTPANEL', controls) as IPSDEReportPanel;
        // 搜索表单实例
        const searchFormInstance = ModelTool.findPSControlByType('SEARCHFORM', controls) as IPSDESearchForm;
        // 快速搜索表单实例
        const quickSearchFormInstance = ModelTool.findPSControlByType('QUICKSEARCHFORM', controls) as IPSDESearchForm;
        // 搜索栏实例
        const searchBarInstance = ModelTool.findPSControlByType('SEARCHBAR', controls) as IPSSearchBar;
        if (reportPanelInstance) {
            let engineOpts: any = ({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance?.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                reportpanel: (this.$refs[reportPanelInstance?.name] as any).ctrl,
            });
            if (searchFormInstance?.name && this.$refs[searchFormInstance.name]) {
                engineOpts.searchform = ((this.$refs[searchFormInstance.name] as any).ctrl);
            }
            if (quickSearchFormInstance?.name && this.$refs[quickSearchFormInstance.name]) {
                engineOpts.quicksearchform = ((this.$refs[quickSearchFormInstance.name] as any).ctrl);
            }
            if (searchBarInstance?.name && this.$refs[searchBarInstance.name]) {
                engineOpts.searchbar = ((this.$refs[searchBarInstance.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }
}