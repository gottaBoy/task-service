import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { IPSDEForm } from "@ibiz/dynamic-model-api";
import { ModelTool } from "ibiz-core";

@Component({})
export class AppDefaultOptViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultOptViewLayout
     */
     public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 编辑表单实例
        const editFormInstance = ModelTool.findPSControlByType('FORM', controls) as IPSDEForm;
        this.engine.init({
            view: this,
            form: (this.$refs[editFormInstance?.name] as any).ctrl,
            p2k: '0',
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
    }

}