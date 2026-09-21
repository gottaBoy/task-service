import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';

@Component({})
export class AppDefaultLoginViewLayout extends AppDefaultViewLayout {

    /**
     * 绘制默认内容
     *
     * @return {*} 
     * @memberof AppDefaultLoginViewLayout
     */
    public renderDefaultContent() {
        return (<div class="login-container">
            {this.$slots.default}
        </div>)
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultLoginViewLayout
     */
    public render(h: any): any {
        if (!this.viewIsInit && this.viewLayoutPanel && !this.viewLayoutPanel.useDefaultLayout) {
            return;
        }
        return (!this.viewLayoutPanel || (this.viewLayoutPanel && this.viewLayoutPanel.useDefaultLayout)) ? this.renderDefaultContent() : this.renderRootPSPanelItems();
    }
}