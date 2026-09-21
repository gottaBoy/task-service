import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";

@Component({})
export default class AppDefaultMobEditView3Layout extends AppDefaultViewLayout {


    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultMobEditView3Layout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        const drtab = ModelTool.findPSControlByName('drtab', this.containerModel.getPSControls());
        const form = ModelTool.findPSControlByName('form', this.containerModel.getPSControls());
        this.engine.init({
            view: this,
            drtab: (this.$refs[drtab.name] as any).ctrl,
            form: (this.$refs[form.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }
}