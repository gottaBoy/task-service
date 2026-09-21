import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Prop, Component } from 'vue-property-decorator';
import { IPSDEPickupViewPanel } from "@ibiz/dynamic-model-api";

@Component({})
export class AppDefaultPickupView3Layout extends AppDefaultViewLayout {

    /**
     * 视图引擎初始化
     * 
     * @memberof AppDefaultPickupView3Layout
     */
    public engineInit() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let pickupViewPanelModels: any[] = [];
        const controls: any[] = this.containerModel.getPSControls() || [];
        controls.forEach((control: any) => {
            if (control.controlType == 'PICKUPVIEWPANEL') {
                pickupViewPanelModels.push(control as IPSDEPickupViewPanel);
            }
        })
        this.engine.init({
            view: this,
            pickupViewPanelModels: pickupViewPanelModels,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultPickupView3Layout
     */
    public renderContent() {
        return [
            <div class="view-content">
                {this.$slots.topMessage ? <div class="view-content__top">
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