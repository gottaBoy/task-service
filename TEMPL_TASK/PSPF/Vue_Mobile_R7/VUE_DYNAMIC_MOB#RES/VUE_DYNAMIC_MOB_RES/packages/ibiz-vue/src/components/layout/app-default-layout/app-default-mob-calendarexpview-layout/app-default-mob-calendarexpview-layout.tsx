import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";

@Component({})
export default class AppDefaultMobCalendarExpViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultMobCalendarExpViewLayout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        const calendarexpbar = ModelTool.findPSControlByName('calendarexpbar', this.containerModel.getPSControls());
        this.engine.init({
            view: this,
            calendarexpbar: (this.$refs[calendarexpbar.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }
}