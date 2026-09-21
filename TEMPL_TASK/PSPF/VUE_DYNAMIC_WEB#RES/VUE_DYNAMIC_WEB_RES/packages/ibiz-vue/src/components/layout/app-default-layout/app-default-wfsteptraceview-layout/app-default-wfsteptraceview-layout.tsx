import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';
import { Util } from "ibiz-core";

@Component({})
export class AppDefaultWfStepTraceViewLayout extends AppDefaultViewLayout {

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultWfStepTraceViewLayout
     */
    public renderContent() {
        return [
            <div class='view-content'>
                <div class="view-content__body">
                    {this.$slots.default}
                </div>
            </div>
        ]
    }
}