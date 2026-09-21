import { Prop,Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";
import { IPSDESearchForm, IPSSearchBar } from "@ibiz/dynamic-model-api";
import { AppDefaultMDViewLayout } from '../app-default-mdview-layout/app-default-mdview-layout';

@Component({})
export class AppDefaultIndexPickupDataViewLayout extends AppDefaultMDViewLayout {

    /**
     * 绘制头部内容
     * 
     * @memberof AppDefaultIndexPickupDataViewLayout
     */
    public renderViewHeader():any{
        return null;
    }

    /**
     * 引擎初始化
     *
     * @param {*} opts
     * @return {*} 
     * @memberof AppDefaultIndexPickupDataViewLayout
     */
     public engineInit(opts: any) {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 数据视图部件实例对象
        const dataviewInstance = ModelTool.findPSControlByType("DATAVIEW", controls);
        // 搜索表单实例
        const searchFormInstance = ModelTool.findPSControlByType('SEARCHFORM', controls) as IPSDESearchForm;
        // 快速搜索表单实例
        const quickSearchFormInstance = ModelTool.findPSControlByType('QUICKSEARCHFORM', controls) as IPSDESearchForm;
        // 搜索栏实例
        const searchBarInstance = ModelTool.findPSControlByType('SEARCHBAR', controls) as IPSSearchBar;
        if (this.engine && dataviewInstance) {
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
                dataview: (this.$refs[dataviewInstance?.name] as any).ctrl,
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