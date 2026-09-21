import { IPSAppDataEntity, IPSAppDEField, IPSAppViewEngine, IPSControl, IPSViewLayoutPanel } from "@ibiz/dynamic-model-api";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";

@Component({})
export default class AppDefaultMobCustomViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof AppDefaultMobCustomViewLayout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const engineOptions: any = {
            view: this,
            keyPSDEField: (ModelTool.getContainerAppEntityCodeName(this.viewLayoutPanel) as string).toLowerCase(),
            majorPSDEField: (ModelTool.getAppEntityMajorField((this.viewLayoutPanel as IPSViewLayoutPanel).getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase()
        };
        if (this.viewLayoutPanel && this.viewLayoutPanel.getPSControls() && (this.viewLayoutPanel.getPSControls() as IPSControl[]).length > 0) {
            const ctrlArray: Array<any> = [];
            (this.viewLayoutPanel.getPSControls() as IPSControl[]).forEach((item: IPSControl) => {
                if (!Object.is(item.controlType, 'TOOLBAR')) {
                    ctrlArray.push({ name: item.name, ctrl: (this.$refs[item.name] as any).ctrl });
                }
            })
            Object.assign(engineOptions, { ctrl: ctrlArray });
        }
        if (this.viewLayoutPanel && this.viewLayoutPanel.getPSAppViewEngines() && (this.viewLayoutPanel.getPSAppViewEngines() as IPSAppViewEngine[]).length > 0) {
            const engineArray: Array<any> = [];
            (this.viewLayoutPanel.getPSAppViewEngines() as IPSAppViewEngine[]).forEach((item: IPSAppViewEngine) => {
                if (Object.is(item.engineCat, 'CTRL')) {
                    engineArray.push(item.M);
                }
            })
            Object.assign(engineOptions, { engine: engineArray });
        }
        this.engine.init(engineOptions);
    }

}