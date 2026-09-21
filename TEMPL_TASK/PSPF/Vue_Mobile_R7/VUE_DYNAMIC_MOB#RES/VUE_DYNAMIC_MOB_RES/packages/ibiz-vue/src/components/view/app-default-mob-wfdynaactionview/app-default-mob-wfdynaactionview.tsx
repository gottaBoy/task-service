import { Component, Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { AppLayoutService } from '../../../app-service';
import { MobWFDynaActionViewBase } from '../../../view/mob-wf-dyna-action-view-base';

/**
 * 应用实体工作流动态操作视图
 *
 * @export
 * @class AppDefaultMobWFDynaActionView
 * @extends {MobWFDynaActionViewBase}
 */
@Component({})
export default class AppDefaultMobWFDynaActionView extends MobWFDynaActionViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWFDynaActionView
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWFDynaActionView
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobWFDynaActionView
     */
    @Watch('dynamicProps', {
        immediate: true,
    })
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onDynamicPropsChange(newVal, oldVal);
        }
    }

    /**
     * 监听视图静态参数变化
     * 
     * @memberof AppDefaultMobWFDynaActionView
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onStaticPropsChange(newVal, oldVal);
        }
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppDefaultMobWFDynaActionView
     */
    public destroyed() {
        this.viewDestroyed();
    }

    /**
     * 渲染视图主体内容区
     *
     * @memberof MobWFDynaActionViewBase
     */
    public renderMainContent() {
        if (!this.editFormInstance) {
            return;
        }
        let {
            targetCtrlName,
            targetCtrlParam,
            targetCtrlEvent,
        } = this.computeTargetCtrlData(this.editFormInstance);
        return this.$createElement(targetCtrlName, {
            props: targetCtrlParam,
            ref: 'form',
            on: targetCtrlEvent,
        })
    }

    /**
     * 渲染底部内容区
     *
     * @memberof MobWFDynaActionViewBase
     */

    public renderFooter() {
        return (
            <div class="view-footer__buttons" slot="footer">
                <app-mob-button
                    class="button__item"
                    color="medium"
                    text={this.$t('app.button.cancel')}
                    on-click={this.onClickCancel.bind(this)}
                />
                <app-mob-button
                    class="button__item"
                    text={this.$t('app.button.confirm')}
                    on-click={this.onClickOk.bind(this)}
                />
            </div>
        );
    }

    /**
    * 绘制目标部件
    *
    * @memberof AppDefaultMobWFDynaActionView
    */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderViewHeaderCaptionBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderBottomMessage(),
                this.renderMainContent(),
                this.renderFooter(),
                ...this.renderToolBars()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 编辑视图渲染
     * 
     * @memberof AppDefaultMobWFDynaActionView
     */
    render(h: any) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, viewparams: this.viewparams, context: this.context }
        }, this.renderTargetControls());
    }

}