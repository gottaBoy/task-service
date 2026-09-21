import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Prop, Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";

@Component({})
export default class AppDefaultMobListExpViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultMobListExpViewLayout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        const listexpbar = ModelTool.findPSControlByName('listexpbar', this.containerModel.getPSControls());
        this.engine.init({
            view: this,
            listexpbar: (this.$refs[listexpbar.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }
}