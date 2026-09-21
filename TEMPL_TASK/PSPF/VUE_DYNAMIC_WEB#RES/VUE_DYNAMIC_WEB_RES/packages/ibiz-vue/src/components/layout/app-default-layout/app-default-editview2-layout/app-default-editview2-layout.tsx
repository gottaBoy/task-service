import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";

@Component({})
export class AppDefaultEditView2Layout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultEditView2Layout
     */
     public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const editFormInstance = ModelTool.findPSControlByType('FORM', this.containerModel.getPSControls());
        const drbarInstance = ModelTool.findPSControlByType('DRBAR', this.containerModel.getPSControls());
        this.engine.init({
            view: this,
            form: (this.$refs[editFormInstance.name] as any).ctrl,
            drbar: (this.$refs[drbarInstance.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 绘制头部内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderViewHeader(): any {
        return [
            <div class="view-header__left">
                {this.showCaption ? <div class='view-header__left__caption'>{this.renderViewCaption()}</div> : null}
            </div>,
            this.viewIsshowToolbar && this.$slots.toolbar ? <div class="view-header__right">
                <div class="view-header__right__toolbar">{this.$slots.toolbar}</div>
            </div> : null
        ]
    }
    
}