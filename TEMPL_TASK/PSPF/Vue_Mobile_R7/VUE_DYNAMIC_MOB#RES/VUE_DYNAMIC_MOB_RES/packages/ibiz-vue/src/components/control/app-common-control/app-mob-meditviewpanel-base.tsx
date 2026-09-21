import { Prop, Watch, Emit, Component } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { MobMeditViewPanelControlBase } from '../../../widgets';

/**
 * 多编辑面板部件基类
 *
 * @export
 * @class AppMobMeditViewPanelBase
 * @extends {MobMeditViewPanelControlBase}
 */
@Component({})
export class AppMobMeditViewPanelBase extends MobMeditViewPanelControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppMobMeditViewPanelBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppMobMeditViewPanelBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobMeditViewPanelBase
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
     * @memberof AppMobMeditViewPanelBase
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
     * @memberof AppMobMeditViewPanelBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobMeditViewPanelBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }


    /**
     * 绘制内容
     * 
     * @param item 
     * @memberof AppMEditViewPanelBase
     */
    public renderContent() {
        const appView = this.controlInstance.getEmbeddedPSAppView();
        const style = {
            height: appView?.height ? appView.height + 'px' : 'auto'
        };
        if (appView?.width) {
            Object.assign(style, { width: appView.width + 'px' });
        }
        return this.items.map((item: any) => {
            return [
                    <ion-card>
                        <div class="app-control-multieditviewpanel__icon" >
                            <app-mob-icon on-onClick={() => { this.deleteItem(item) }}  name="close-circle-outline"></app-mob-icon> 
                        </div>
                        <ion-card-content>
                            {
                                this.$createElement("app-view-shell", {
                                    style: style,
                                    props: {
                                        staticProps: {
                                            viewDefaultUsage: 'INCLUDEDVIEW',
                                            viewModelData: appView,
                                            inputState: this.panelState,
                                            showCaption: false,
                                        },
                                        dynamicProps: {
                                            _context: JSON.stringify(item._context),
                                            _viewparams: JSON.stringify(item.viewparam),
                                        },
                                    },
                                    class:"view-container2",
                                    on: {
                                        viewdataschange: this.viewDataChange.bind(this),
                                        viewstatechange: this.viewStateChange.bind(this),
                                    }
                                })
                            }
                        </ion-card-content>
                    </ion-card>
            ]
        })
    }

    /**
     * 绘制多编辑面板
     *
     * @returns {*}
     * @memberof AppMobMeditViewPanelBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={controlClassNames} >
                <div class="control-content app-control-multieditviewpanel__content">
                    {this.items.length > 0 ? this.renderContent() : null}
                </div>
                <div class="control-footer app-control-multieditviewpanel__footer">
                        <app-mob-button iconName='add-outline' on-click={() => { this.addItem() }} text="添加数据"/>
                </div>
            </div>
        )
    }
}