import { Component, Prop, Emit, Watch } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Util } from 'ibiz-core';
import { MobWFDynaStartViewBase } from '../../../view';
import { AppLayoutService } from '../../../app-service';

/**
 * 应用实体工作流动态启动视图基类
 *
 * @export
 * @class AppDefaultMobWFDynaStartView
 * @extends {MobWFDynaStartViewBase}
 */
@Component({})
export default class AppDefaultMobWFDynaStartView extends MobWFDynaStartViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWFDynaStartView
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppDefaultMobWFDynaStartView
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDefaultMobWFDynaStartView
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
     * @memberof AppDefaultMobWFDynaStartView
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
     * @memberof AppDefaultMobWFDynaStartView
     */
    public destroyed() {
        this.viewDestroyed();
    }

    /**
     * 
     *
     * @memberof AppDefaultMobWFDynaStartView
     */
    public renderViewFooter() {
        return <div class="view-footer__buttons" slot="footer">
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
    }

    /**
    * 绘制目标部件
    *
    * @memberof AppDefaultMobEditView
    */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderViewHeaderCaptionBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderBottomMessage(),
                this.renderMainContent(),
                this.renderViewFooter(),
                ...this.renderToolBars()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 编辑视图渲染
     * 
     * @memberof AppDefaultMobWFDynaStartView
     */
    render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, viewparams: this.viewparams, context: this.context }
        }, this.renderTargetControls());
    }
}