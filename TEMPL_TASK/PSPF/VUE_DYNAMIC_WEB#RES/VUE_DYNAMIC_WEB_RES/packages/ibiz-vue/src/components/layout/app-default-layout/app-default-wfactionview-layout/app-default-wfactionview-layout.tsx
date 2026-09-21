import { Component } from 'vue-property-decorator';
import { AppDefaultViewLayout } from '../app-default-view-layout/app-default-view-layout';

@Component({})
export class AppDefaultWFActionViewLayout extends AppDefaultViewLayout {

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultWFActionViewLayout
     */
    public renderContent() {
        return [
            <div class='view-content'>
                {this.$slots.topMessage ? <div class="view-content__top">
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