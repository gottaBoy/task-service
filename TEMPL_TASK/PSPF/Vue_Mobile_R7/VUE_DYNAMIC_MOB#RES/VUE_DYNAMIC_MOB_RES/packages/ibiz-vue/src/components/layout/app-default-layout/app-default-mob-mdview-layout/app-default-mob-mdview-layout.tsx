import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";
import { IPSDEMobMDCtrl, IPSDESearchForm, IPSSearchBar } from '@ibiz/dynamic-model-api';
import { AppDefaultMDDataViewLayout } from '../app-default-mob-multidataview-layout/app-default-mob-multidataview-layout';

@Component({})
export default class AppDefaultMobMdViewLayout extends AppDefaultMDDataViewLayout {

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof AppDefaultMobMdViewLayout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const mdCtrlInstance = ModelTool.findPSControlByName('mdctrl', this.containerModel.getPSControls()) as IPSDEMobMDCtrl;
        if (this.engine && mdCtrlInstance) {
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
                mdctrl: (this.$refs[mdCtrlInstance?.name] as any).ctrl,
            }, opts)
            const searchFormInstance = ModelTool.findPSControlByName('searchform', this.containerModel.getPSControls() || []) as IPSDESearchForm;
            const quickSearchFormInstance = ModelTool.findPSControlByName('quicksearchform', this.containerModel.getPSControls() || []) as IPSDESearchForm;
            const searchBarInstance = ModelTool.findPSControlByType('SEARCHBAR', this.containerModel.getPSControls() || []) as IPSSearchBar;
            if (searchFormInstance?.name && this.$refs[searchFormInstance.name]) {
                engineOpts.searchform = ((this.$refs[searchFormInstance.name] as any).ctrl);
            }
            if (quickSearchFormInstance?.name && this.$refs[quickSearchFormInstance.name]) {
                engineOpts.quicksearchform = ((this.$refs[quickSearchFormInstance.name] as any).ctrl);
            }
            if (searchBarInstance?.name && this.$refs[searchBarInstance.name]) {
                engineOpts.searchBar = ((this.$refs[searchBarInstance.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }

}