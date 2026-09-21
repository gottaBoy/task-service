import { Prop, Component } from 'vue-property-decorator';
import { IPSAppDETabExplorerView } from "@ibiz/dynamic-model-api";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

@Component({})
export class AppDefaultTabExpViewLayout extends AppDefaultViewLayout {

    /**
     * 实体分页导航视图模型对象
     *
     * @type {IPSAppDETabExplorerView}
     * @memberof AppDefaultTabExpViewLayout
     */
    @Prop() public declare viewInstance: IPSAppDETabExplorerView;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}]
     * @memberof AppDefaultTabExpViewLayout
     */
    public engineInit(opts: any = {}) {
        let engineOpts = Object.assign({
            view: this,
            p2k: '0',
            isLoadDefault: this.viewInstance?.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase()
        }, opts);
        this.engine.init(engineOpts);
    }

    /**
     * 绘制头部内容
     * 
     * @memberof AppDefaultViewLayout
     */
    public renderViewHeader(): any {
        const offset ={
            root: this.$parent,
            gap: 8,
            targetClass: 'ivu-tabs-bar',
        }
        return [
            <div class="view-header__left">
                {this.showCaption ? <div class="view-header__left__caption" v-tab-offset={offset}>{this.renderViewCaption()}</div> : null}
            </div>,
            this.viewIsshowToolbar && this.$slots.toolbar ? <div class="view-header__right">
                <div class="view-header__right__toolbar">{this.$slots.toolbar}</div>
            </div> : null
        ]
    }

}