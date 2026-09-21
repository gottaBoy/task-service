import { ModelTool } from 'ibiz-core';
import { Component } from 'vue-property-decorator';
import { AppDefaultViewLayout } from '../app-default-view-layout/app-default-view-layout';

@Component({})
export class AppDefaultWizardViewLayout extends AppDefaultViewLayout { 
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
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 向导面板部件模型实例
        const wizardPanelInstance = ModelTool.findPSControlByType('WIZARDPANEL', controls);
        if(this.engine && wizardPanelInstance){
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: true,
                //TODO IPSAppDEWizardView缺少loaddefault
                // isLoadDefault: this.viewInstance.loadDefault,
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