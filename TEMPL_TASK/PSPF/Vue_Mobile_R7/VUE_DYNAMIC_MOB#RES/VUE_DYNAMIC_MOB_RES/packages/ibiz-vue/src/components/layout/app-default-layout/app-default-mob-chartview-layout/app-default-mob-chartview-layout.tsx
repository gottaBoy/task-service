import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

@Component({})
export default class AppDefaultMobChartViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof AppDefaultMobChartViewLayout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        const searchbar = ModelTool.findPSControlByType("SEARCHBAR", this.containerModel.getPSControls());
        const chart = ModelTool.findPSControlByType("CHART", this.containerModel.getPSControls());
        const searchform = ModelTool.findPSControlByType("SEARCHFORM", this.containerModel.getPSControls());
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
            if (chart?.name && this.$refs[chart.name]) {
                engineOpts.chart = ((this.$refs[chart.name] as any).ctrl);
            }
            if (searchform?.name && this.$refs[searchform.name]) {
                engineOpts.searchform = ((this.$refs[searchform.name] as any).ctrl);
            }
            if (searchbar?.name && this.$refs[searchbar.name]) {
                engineOpts.searchBar = ((this.$refs[searchbar.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }

}