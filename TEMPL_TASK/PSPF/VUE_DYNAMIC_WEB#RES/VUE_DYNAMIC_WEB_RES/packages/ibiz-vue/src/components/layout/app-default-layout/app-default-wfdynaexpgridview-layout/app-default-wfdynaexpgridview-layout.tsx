import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Prop,Component } from 'vue-property-decorator';


@Component({})
export class AppDefaultWfDynaExpGridViewLayout extends AppDefaultViewLayout{

        /**
         * 绘制正文内容
         * 
         * @memberof AppDefaultWfDynaExpGridViewLayout
         */
         public renderViewContent(): any {
            return [
                this.$slots.topMessage || !(this.viewInstance.enableQuickSearch && !this.viewInstance.expandSearchForm) ? <div class="view-content__top">
                    {this.$slots.topMessage}
                    {this.$slots.searchForm}
                </div> : null,
                <div class="view-content__body">
                    {this.$slots.bodyMessage}
                    {this.$slots.default}
                </div>,
                this.$slots.bottomMessage ? <div class="view-content__bottom">
                    {this.$slots.bottomMessage}
                </div> : null
            ]
        }
}