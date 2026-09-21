import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';

@Component({})
export default class AppDefaultMobLoginViewLayout extends AppDefaultViewLayout {
    
    /**
     * 绘制默认内容
     *
     * @return {*} 
     * @memberof AppDefaultMobLoginViewLayout
     */
    public renderDefaultContent() {
        return (<div class="login-container">
            {this.$slots.default}
        </div>)
    }

    /**
     * 绘制布局
     * 
     * @memberof AppDefaultMobLoginViewLayout
     */
    public render(h: any): any {
        if (!this.viewIsInit && this.viewLayoutPanel && !this.viewLayoutPanel.useDefaultLayout) {
            return;
        }
        if (this.viewLayoutPanel && !this.viewLayoutPanel.useDefaultLayout) {
            return (<ion-page className={{ 'login-container': true }}>
                {this.renderViewLayoutPanel()}
            </ion-page>);
        } else {
            return this.renderDefaultContent();
        }
    }

}