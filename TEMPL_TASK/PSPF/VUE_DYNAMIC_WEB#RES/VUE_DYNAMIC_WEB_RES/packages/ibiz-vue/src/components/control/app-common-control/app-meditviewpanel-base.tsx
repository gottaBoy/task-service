import { Emit, Prop, Watch } from 'vue-property-decorator';
import { MEditViewPanelControlBase } from '../../../widgets';
import { throttle, Util } from 'ibiz-core';

/**
 * 多编辑面板部件基类
 *
 * @export
 * @class AppListExpBarBase
 * @extends {ListExpBarControlBase}
 */
export class AppMEditViewPanelBase extends MEditViewPanelControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppMEditViewPanelBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppMEditViewPanelBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMEditViewPanelBase
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
     * @memberof AppMEditViewPanelBase
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
     * @memberof AppMEditViewPanelBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMEditViewPanelBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制内容
     * 
     * @memberof AppMEditViewPanelBase
     */
    public renderContent() {
        if (!this.controlInstance.getEmbeddedPSAppView()) {
            return;
        }
        if (Object.is(this.controlInstance.panelStyle, 'TAB_TOP')) {
            return this.renderTabtop();
        }
        return this.renderRow();

    }

    /**
     * 绘制上分页样式
     * 
     * 
     * @memberof AppMEditViewPanelBase
     */
    public renderTabtop() {
        return (
            <tabs v-model={this.activeTab} name={`${this.controlInstance.codeName}-tabs`} class="app-control-multieditviewpanel__content__tab">
                {
                    this.items.map((item: any, index: number) => {
                        return (
                            <tabPane 
                                key={item.id} 
                                name={item.id}
                                tab={`${this.controlInstance.codeName}-tabs`}
                                class="app-control-multieditviewpanel__content__tabpanel"
                                label={(h: any) => {
                                    return (
                                        <div class="tab__label">
                                            <div class="tab__label__caption">{item.srfmajortext}</div>
                                            <icon type="md-close" onClick={() => throttle(this.handleTabDelete, [item, index], this)} />
                                        </div>
                                    )
                                }}>
                                {
                                    this.$createElement('app-view-shell', {
                                        props: {
                                            staticProps: {
                                                viewDefaultUsage: false,
                                                viewModelData: this.controlInstance.getEmbeddedPSAppView(),
                                                inputState: this.panelState,
                                            },
                                            dynamicProps: {
                                                viewdata: JSON.stringify(item.viewdata),
                                                viewparam: JSON.stringify(item.viewparam),
                                            }
                                        },
                                        class: "view-container2",
                                        on: {
                                            viewdataschange: this.viewDataChange.bind(this),
                                            viewLoaded: this.viewLoaded.bind(this),
                                            viewstatechange: this.viewStateChange.bind(this),
                                        }
                                    })
                                }
                            </tabPane>
                        )
                    })
                }
            </tabs>
        )
    }

    /**
     * 绘制行记录样式
     * 
     * @memberof AppMEditViewPanelBase
     */
    public renderRow() {
        return this.items.map((item: any) => {
            return (
                <div class="app-control-multieditviewpanel__content__item" key={item.id}>
                    {
                        [
                            <icon type="md-close" onClick={() => throttle(this.handleDelete, [item], this)} />,
                            this.$createElement('app-view-shell', {
                                props: {
                                    staticProps: {
                                        viewDefaultUsage: false,
                                        viewModelData: this.controlInstance.getEmbeddedPSAppView(),
                                        inputState: this.panelState,
                                    },
                                    dynamicProps: {
                                        viewdata: JSON.stringify(item.viewdata),
                                        viewparam: JSON.stringify(item.viewparam),
                                    }
                                },
                                class: "view-container2",
                                on: {
                                    viewdataschange: this.viewDataChange.bind(this),
                                    viewLoaded: this.viewLoaded.bind(this),
                                    viewstatechange: this.viewStateChange.bind(this),
                                }
                            }),
                            <divider />
                        ]
                    }
                </div>
            )
        })
    }

    /**
     * 绘制部件
     * 
     * @param h 
     * @memberof AppMEditViewPanelBase
     */
    public render(h: any) {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={controlClassNames}>
                <div class="control-content app-control-multieditviewpanel__content">
                    {this.items.length > 0 ? this.renderContent() : null}
                </div>
                {
                    this.showButton ? 
                    <div class="control-footer app-control-multieditviewpanel__footer">
                        <i-button class="footer__button" type="primary" on-click={() => throttle(this.handleAdd, [], this)}>
                            <icon type="md-add"/>
                            {this.$t('app.local.add')}
                        </i-button>
                    </div> : null
                }
            </div>
        )
    }
}