import { IPSDEForm } from "@ibiz/dynamic-model-api";
import { ModelTool } from "ibiz-core";
import { Component } from 'vue-property-decorator';
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

@Component({})
export default class AppDefaultMobEditViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultMobEditViewLayout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        const editFormInstance = ModelTool.findPSControlByName('form', this.containerModel.getPSControls()) as IPSDEForm;
        this.engine.init({
            view: this,
            form: (this.$refs[editFormInstance.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

}