import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

@Component({})
export default class AppDefaultMobCalendarViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     * 
     * @memberof AppDefaultMobCalendarViewLayout
     */
    public engineInit() {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        const calendarInstance = ModelTool.findPSControlByName('calendar', this.containerModel.getPSControls() || []);
        this.engine.init({
            view: this,
            calendar: (this.$refs[calendarInstance.name] as any).ctrl,
            p2k: '0',
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault
        });
    }

}