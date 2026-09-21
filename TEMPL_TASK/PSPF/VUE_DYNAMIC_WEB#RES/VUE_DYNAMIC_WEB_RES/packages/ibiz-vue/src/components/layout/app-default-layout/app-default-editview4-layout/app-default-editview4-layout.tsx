import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";
import { IPSDEDRTab, IPSDEForm } from "@ibiz/dynamic-model-api";

@Component({})
export class AppDefaultEditView4Layout extends AppDefaultViewLayout {
    
    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultEditView4Layout
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 编辑表单实例
        const editFormInstance = ModelTool.findPSControlByType('FORM', controls) as IPSDEForm;
        // 数据关系分页部件实例
        const drtabInstance = ModelTool.findPSControlByType("DRTAB", controls) as IPSDEDRTab;
        this.engine.init({
            view: this,
            form: (this.$refs[editFormInstance?.name] as any)?.ctrl,
            drtab: (this.$refs[drtabInstance?.name] as any)?.ctrl,
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

    /**
     * 绘制正文内容
     * 
     * @memberof AppDefaultViewLayout
     */
     public renderViewContent(): any {
        return [
            this.$slots.topMessage ? <div class="view-content__top">
                {this.$slots.topMessage}
            </div> : null,
            <div class="view-content__body">
                {this.$slots.bodyMessage}
                {this.$slots.mainform}
                {this.$slots.default}
            </div>,
            this.$slots.bottomMessage ? <div class="view-content__bottom">
                {this.$slots.bottomMessage}
            </div> : null
        ]
    }

}