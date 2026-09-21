import { Component } from 'vue-property-decorator';
import { IPSTabExpPanel } from "@ibiz/dynamic-model-api";
import { ModelTool, ThirdPartyService } from "ibiz-core";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

@Component({})
export default class AppDefaultMobTabExpViewLayout extends AppDefaultViewLayout{

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof AppDefaultMobTabExpViewLayout
     */
     public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const tabExpPanelInstance = ModelTool.findPSControlByName('tabexppanel', this.containerModel.getPSControls()) as IPSTabExpPanel;
        if (this.engine && tabExpPanelInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: this.viewInstance?.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            }, opts)
            this.engine.init(engineOpts);
        }
    }

}