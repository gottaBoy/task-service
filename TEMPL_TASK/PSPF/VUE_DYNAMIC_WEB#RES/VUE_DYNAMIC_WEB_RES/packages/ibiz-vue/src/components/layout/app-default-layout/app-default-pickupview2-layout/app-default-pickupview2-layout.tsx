import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Prop, Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";

@Component({})
export class AppDefaultPickupView2Layout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultPickupView2Layout
     */
     public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 树导航实例对象
        const treeExpBarInstance = ModelTool.findPSControlByType("TREEEXPBAR", controls);
        this.engine.init({
            view: this,
            treeExpBar: (this.$refs[treeExpBarInstance?.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultPickupView2Layout
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