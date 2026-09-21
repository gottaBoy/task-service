import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Prop, Component } from 'vue-property-decorator';
import { ModelTool } from "ibiz-core";

@Component({})
export class AppDefaultPickupTreeViewLayout extends AppDefaultViewLayout {

    /**
     * 引擎初始化
     *
     * @public
     * @memberof AppDefaultPickupTreeViewLayout
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const controls: any[] = this.containerModel.getPSControls() || [];
        // 树视图实例
        const treeInstance = ModelTool.findPSControlByType("TREEVIEW", controls);
        let engineOpts = ({
            view: this,
            p2k: '0',
            tree: (this.$refs[treeInstance.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
        this.engine.init(engineOpts);
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultPickupTreeViewLayout
     */
    public renderContent() {
        return [
            <div class="view-content">
                {this.$slots.searchForm || this.$slots.topMessage || this.$slots.quickGroupSearch || this.$slots.quickSearch ? <div class="view-content__top">
                    {this.$slots.quickGroupSearch}
                    {this.$slots.quickSearch}
                    {this.$slots.searchForm}
                    {this.$slots.topMessage}
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