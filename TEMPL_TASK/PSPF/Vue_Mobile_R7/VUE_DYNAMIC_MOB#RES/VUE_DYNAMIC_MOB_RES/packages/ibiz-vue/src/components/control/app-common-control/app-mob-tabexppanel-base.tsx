
import { Emit, Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { MobTabExpPanelControlBase } from '../../../widgets';
import { IPSDETabViewPanel } from '@ibiz/dynamic-model-api';

/**
 * 分页导航栏部件基类
 *
 * @export
 * @class AppMobTabExpPanelBase
 * @extends {MobTabExpPanelControlBase}
 */
export class AppMobTabExpPanelBase extends MobTabExpPanelControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppMobTabExpPanelBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppMobTabExpPanelBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobTabExpPanelBase
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
     * 监听部件静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobTabExpPanelBase
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
     * @memberof AppMobTabExpPanelBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobTabExpPanelBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }


    /**
     * 绘制分页视图
     *
     * @param {IPSDETabViewPanel} modelJson
     * @return {*} 
     * @memberof AppMobTabExpPanelBase
     */
    public renderTabViewPanel(modelJson: IPSDETabViewPanel) {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(modelJson);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: modelJson.name, on: targetCtrlEvent })
    }

    /**
     * 绘制视图头部
     *
     * @returns
     * @memberof MobTabExpPanelControlBase
     */
    public readerViewHeadersSegment() {
        const segment = this.controlInstance.getPSControls() as IPSDETabViewPanel[];
        return (
            <ion-toolbar class="app-control-tabexppanel__header__toolbar">
                <ion-segment class="toolbar__segment" ref="segment" value={this.activeTabViewPanel} on-ionChange={($event: any) => { this.tabExpPanelChange($event) }}>
                    {
                        segment?.map((item: IPSDETabViewPanel) => {
                            let viewPanelCount: any = undefined;
                            if (item?.counterId) {
                                const targetCounterService: any = Util.findElementByField(this.counterServiceArray, 'id', item.getPSAppCounterRef()?.id)?.service;
                                viewPanelCount = targetCounterService?.counterData?.[item.counterId.toLowerCase()]
                            }
                            return <ion-segment-button class={{'toolbar__segment__item':true}} value={item.name} layout="icon-start">
                                {item?.getPSSysImage()?.cssClass ? <app-mob-icon name={item.getPSSysImage()?.cssClass}></app-mob-icon> : null}
                                {this.$tl(item.getCapPSLanguageRes()?.lanResTag, item.caption)}
                                {viewPanelCount ? viewPanelCount > 99 ? <div class="toolbar__segment__item__count" color="danger">99+</div> : <div class="toolbar__segment__item__count" color="danger">{viewPanelCount}</div> : null}
                            </ion-segment-button>
                        })
                    }
                </ion-segment>
            </ion-toolbar>
        )
    }

    /**
     * 绘制内容
     *
     * @returns
     * @memberof AppMobTabExpPanelBase
     */
    public render(): any {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        const allControls = this.controlInstance.getPSControls() as IPSDETabViewPanel[];
        return (
            <div class={{ ...controlClassNames }}>
                <div class="control-header app-control-tabexppanel__header">
                    {
                        this.readerViewHeadersSegment()
                    }
                </div>
                <div class="control-content app-control-tabexppanel__content">
                    {allControls.map((item: IPSDETabViewPanel) => {
                        return this.renderTabViewPanel(item);
                    })}
                </div>
            </div>
        )
    }
}
