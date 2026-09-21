import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";
@Component({})
export class AppDefaultMPickupView2Layout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultMPickupView2Layout
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        const treeExpbarIntance = ModelTool.findPSControlByType('TREEEXPBAR', controls);
        // 选择视图面板实例
        const pickUpViewPanelInstance = ModelTool.findPSControlByType("PICKUPVIEWPANEL", controls);
        let engineOpts = ({
            view: this,
            p2k: '0',
            treeExpBar: (this.$refs[treeExpbarIntance?.name] as any).ctrl,
            pickupViewPanel: ((this.$refs[treeExpbarIntance?.name] as any).ctrl as any)?.$refs[pickUpViewPanelInstance?.name]?.ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
        this.engine.init(engineOpts);
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultMPickupView2Layout
     */
    public renderContent() {
        return [
            <div class='view-content'>
                {this.$slots.topMessage || this.$slots.quickGroupSearch || this.$slots.quickSearch || this.$slots.searchForm ? <div class="view-content__top">
                    {this.$slots.quickGroupSearch}
                    {this.$slots.quickSearch}
                    {this.$slots.searchForm}
                    {this.$slots.topMessage}
                </div> : null}
                <div class="view-content__body">
                    {this.$slots.default}
                </div>
                {this.$slots.bottomMessage ? <div class="view-content__bottom">
                    {this.$slots.bottomMessage}
                </div> : null}
            </div>,
            this.$slots.footer ? <div class="view-footer">
                {this.$slots.footer}
            </div> : null
        ]
    }

}