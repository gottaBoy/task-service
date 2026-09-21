import { IPSDEDashboard, IPSDESearchForm } from '@ibiz/dynamic-model-api';
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Prop, Component } from 'vue-property-decorator';
import { ModelTool } from 'ibiz-core';

@Component({})
export class AppDefaultDePortalViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultDePortalViewLayout
     */
     public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 数据看板实例
        const dashboardInstance: IPSDEDashboard = ModelTool.findPSControlByType('DASHBOARD', controls) as IPSDEDashboard;
        // 搜索表单实例
        const searchFormInstance: IPSDESearchForm = ModelTool.findPSControlByType('SEARCHFORM', controls) as IPSDESearchForm;
        this.engine.init({
            view: this,
            dashboard: (this.$refs[dashboardInstance?.name] as any)?.ctrl,
            searchform: (this.$refs[searchFormInstance?.name] as any)?.ctrl,
            p2k: '0',
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
    }

}