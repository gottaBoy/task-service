import { IPSAppCounterRef, IPSDETabViewPanel, IPSSysImage } from '@ibiz/dynamic-model-api';
import { throttle, Util } from 'ibiz-core';
import { Emit, Prop, Watch } from 'vue-property-decorator';
import { TabExpPanelBase } from '../../../widgets';

/**
 * 分页导航面板部件基类
 *
 * @export
 * @class AppTabExpPanelBase
 * @extends {TabExpPanelBase}
 */
export class AppTabExpPanelBase extends TabExpPanelBase {

    /**
     * 部件静态参数
     *
     * @memberof AppTabExpPanelBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppTabExpPanelBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppTabExpPanelBase
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
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppTabExpPanelBase
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
     * @memberof AppTabExpPanelBase
     */
    public destroyed(){
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppTabExpPanelBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void {}

    /**
     * 绘制分页导航面板Container
     *
     * @memberof AppTabExpPanelBase
     */
    public renderTabPaneContent(tabViewPanel: IPSDETabViewPanel, index: number) {
        let { targetCtrlParam, targetCtrlEvent, targetCtrlName } = this.computeTargetCtrlData(tabViewPanel);
        Object.assign(targetCtrlParam.staticProps,{
            isActivied: index === 0 ? true : false,
            noPadding: true
        });
        //  过滤数据
        if (this.filterData && Object.keys(this.filterData).length) {
            const tempViewParams = Util.deepCopy(this.viewparams);
            Object.assign(targetCtrlParam.dynamicProps, { viewparams: Object.assign(tempViewParams, this.filterData) });
        }
        // 视图面板计数器
        let viewPanelCount: any = undefined;
        const appCounterRef: IPSAppCounterRef = tabViewPanel.getPSAppCounterRef() as IPSAppCounterRef;
        if (appCounterRef && tabViewPanel.counterId) {
            const targetCounterService: any = Util.findElementByField(this.counterServiceArray, 'id', appCounterRef.id)?.service;
            viewPanelCount = targetCounterService?.counterData?.[tabViewPanel.counterId.toLowerCase()]
        }
        const tabsName = `${this.appDeCodeName.toLowerCase()}_${this.controlInstance.controlType?.toLowerCase()}_${this.controlInstance.codeName?.toLowerCase()}`;
        let disabled = this.authResourceObject && this.authResourceObject[tabViewPanel.name]?.disabled;
        const IPSSysImage: IPSSysImage = tabViewPanel.getPSSysImage() as IPSSysImage;
        return (
            <tab-pane lazy={true} name={tabViewPanel.name} class="app-control-tabexppanel__tabpane" tab={tabsName} disabled={disabled}
                label={(h: any) => {
                    return h('div', { class: tabViewPanel.getPSSysCss()?.cssName }, [
                        IPSSysImage ? IPSSysImage.imagePath ?
                            h('img', {
                                src: IPSSysImage.imagePath,
                                class: "tabpane__icon"
                            }) :
                            h('i', {
                                class: [IPSSysImage.cssClass, "tabpane__icon"],
                            }) : '',
                        h('span', this.$tl(tabViewPanel.getCapPSLanguageRes()?.lanResTag, tabViewPanel.caption)),
                        h('Badge', {
                            props: {
                                count: viewPanelCount,
                                type: 'primary'
                            }
                        })
                    ])
                }}>
                {
                    this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: tabViewPanel.name, on: targetCtrlEvent })
                }
            </tab-pane>
        )
    }

    /**
     * 绘制分页导航面板
     *
     * @returns {*}
     * @memberof AppTabExpPanelBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        const IPSDETabViewPanel = this.controlInstance.getPSControls() as IPSDETabViewPanel[];
        const tabsName = `${this.appDeCodeName.toLowerCase()}_${this.controlInstance?.controlType?.toLowerCase()}_${this.controlInstance?.codeName?.toLowerCase()}`;
        return (
            <div class={controlClassNames}>
                <tabs value={this.activiedTabViewPanel} animated={false} class={{'control-content app-control-tabexppanel__content': true, 'no-padding': this.noPadding}} name={tabsName} on-on-click={($event: any) => throttle(this.tabPanelClick,[$event],this)}>
                    {
                        IPSDETabViewPanel?.map((tabViewPanel: IPSDETabViewPanel, index: number) => {
                            return this.authResourceObject && this.authResourceObject[tabViewPanel.name]?.visabled ?
                                this.renderTabPaneContent(tabViewPanel, index) : null
                        })
                    }
                </tabs>
            </div>
        );
    }
}