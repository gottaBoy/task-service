import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";

@Component({})
export default class AppDefaultWizardViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof AppDefaultWizardViewLayout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const wizardPanelInstance = ModelTool.findPSControlByType('WIZARDPANEL', this.containerModel.getPSControls() || []);
        if (this.engine && wizardPanelInstance) {
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
                },
                wizardpanel: (this.$refs[wizardPanelInstance.name] as any).ctrl,
            }, opts)
            this.engine.init(engineOpts);
        }
    }

}