import { Component, Prop } from 'vue-property-decorator';
import { IPSAppDEEditView, IPSSysCss } from "@ibiz/dynamic-model-api";
import { AppServiceBase, ModelTool, Util } from "ibiz-core";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

@Component({})
export class AppDefaultEditViewLayout extends AppDefaultViewLayout {

    /**
     * 编辑视图模型数据
     *
     * @type {IPSAppDEEditView}
     */
    @Prop() public declare viewInstance: IPSAppDEEditView;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}]
     * @memberof AppDefaultEditViewLayout
     */
    public engineInit(opts: any = {}) {
        const form = ModelTool.findPSControlByType('FORM', this.containerModel.getPSControls());
        if (form) {
            this.engine.init({
                view: this,
                form: (this.$refs[form.name] as any).ctrl,
                p2k: '0',
                isLoadDefault: this.viewInstance.loadDefault,
                keyPSDEField: this.appDeCodeName.toLowerCase(),
                majorPSDEField: this.appDeMajorFieldName.toLowerCase()
            });
        }
    }

    /**
     * 绘制头部内容
     * 
     * @memberof AppDefaultEditViewLayout
     */
    public renderViewHeader(): any {
        if (this.$slots.datapanel) {
            return [
                this.viewIsshowToolbar ? [<div class="view-header__toolbar--top">{this.$slots.toolbar}</div>, <divider />] : null,
                <div class='view-header__info'>
                    {
                        this.showCaption ? <div class='view-header__left__caption'>{this.renderViewCaption()}</div> : null
                    }
                    <div class='info__content'>{this.$slots.datapanel}</div>
                </div>
            ]
        } else {
            return [
                <div class="view-header__left">
                    {this.showCaption ? <div class='view-header__left__caption'>{this.renderViewCaption()}</div> : null}
                </div>,
                this.viewIsshowToolbar && this.$slots.toolbar ? <div class="view-header__right">
                    <div class="view-header__right__toolbar">{this.$slots.toolbar}</div>
                </div> : null
            ]
        }
    }

}