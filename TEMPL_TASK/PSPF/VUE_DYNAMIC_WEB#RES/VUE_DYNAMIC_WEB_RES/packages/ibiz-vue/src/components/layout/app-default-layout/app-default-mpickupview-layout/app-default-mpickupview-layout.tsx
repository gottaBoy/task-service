import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Prop,Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";

@Component({})
export class AppDefaultMPickupViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultMPickupViewLayout
     */
     public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 选择视图面板实例
        const pickUpViewPanelInstance = ModelTool.findPSControlByType("PICKUPVIEWPANEL", controls);
        let engineOpts = ({
            view: this,
            p2k: '0',
            pickupViewPanel: (this.$refs[pickUpViewPanelInstance?.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
        this.engine.init(engineOpts);
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderContent() {
        return [
            <div class='view-content'>
                {this.$slots.topMessage || this.$slots.quickGroupSearch || this.$slots.quickSearch || this.$slots.searchForm ? <div class="view-content__top">
                    {this.$slots.topMessage}
                    {this.$slots.quickGroupSearch}
                    {this.$slots.quickSearch}
                    {this.$slots.searchForm}
                </div> : null}
                <div class="view-content__body">
                    {this.$slots.bodyMessage}
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