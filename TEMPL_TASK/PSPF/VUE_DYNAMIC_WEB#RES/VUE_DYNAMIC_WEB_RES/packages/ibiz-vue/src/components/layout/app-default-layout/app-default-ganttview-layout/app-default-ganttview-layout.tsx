import { Prop,Component } from 'vue-property-decorator';
import { AppDefaultMDViewLayout } from "../app-default-mdview-layout/app-default-mdview-layout";
import { ModelTool } from 'ibiz-core';
import { IPSDEGantt, IPSDESearchForm, IPSSearchBar } from '@ibiz/dynamic-model-api';

@Component({})
export class AppDefaultGanttViewLayout extends AppDefaultMDViewLayout{
    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof AppDefaultGanttViewLayout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 甘特部件实例
        const ganttInstance = ModelTool.findPSControlByType('GANTT', controls) as IPSDEGantt;
        // 搜索表单实例
        const searchFormInstance = ModelTool.findPSControlByName('SEARCHFORM', controls) as IPSDESearchForm;
        // 快速搜索表单实例
        const quickSearchFormInstance = ModelTool.findPSControlByName('QUICKSEARCHFORM', controls) as IPSDESearchForm;
        // 搜索栏实例
        const searchBarInstance = ModelTool.findPSControlByType('SEARCHBAR', controls) as IPSSearchBar;
        if (this.engine && ganttInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                },
                gantt: (this.$refs[ganttInstance.name] as any).ctrl,
            }, opts)
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