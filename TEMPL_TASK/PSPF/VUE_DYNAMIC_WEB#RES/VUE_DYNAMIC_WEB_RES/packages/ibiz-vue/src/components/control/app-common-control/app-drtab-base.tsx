import { IPSLanguageRes } from '@ibiz/dynamic-model-api';
import { throttle, Util } from 'ibiz-core';
import { CreateElement } from 'vue';
import { Emit, Prop, Watch } from 'vue-property-decorator';
import { DrtabControlBase } from '../../../widgets/drtab-control-base';

/**
 * 数据关系分页部件基类
 *
 * @export
 * @class AppDrtabBase
 * @extends {TabExpPanelBase}
 */
export class AppDrtabBase extends DrtabControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppDrtabBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppDrtabBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDrtabBase
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
     * @memberof AppDrtabBase
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
     * @memberof AppDrtabBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppDrtabBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * @description 绘制icon图标
     * @param {*} item
     * @return {*} 
     * @memberof AppDrtabBase
     */
     public renderIcon(item: any) {
        const itemPSSysImage = (item as any).getPSSysImage?.()
        return (
            itemPSSysImage?.imagePath ? <img src={itemPSSysImage.imagePath} class="item__icon"></img> :
            itemPSSysImage?.cssClass ? <i class={[itemPSSysImage.cssClass, {'item__icon': true}]}></i> : null
        )
    }

    /**
     * 绘制关系界面
     *
     * @param {*} tabPage
     * @return {*} 
     * @memberof AppDrtabBase
     */
    public renderPanelLabel(tabPage: any) {
        let counter: any = undefined;
        if (tabPage.counterId && this.counterData?.[tabPage.counterId.toLowerCase()]) {
            counter = {
                id: tabPage.counterId,
                count: this.counterData[tabPage.counterId.toLowerCase()],
                showZero: 1,
                offset: [2, 10]
            }
        }
        if (Object.is((this.controlInstance.getParentPSModelObject?.() as any)?.viewType, 'DEEDITVIEW4')) {
            return (
                <span slot="reference" v-badge={counter} >
                    {this.renderIcon(tabPage)}
                    {this.$tl((tabPage.getCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, tabPage.caption)}
                </span>
            )
        }
        return (<el-popover
            content={this.$t("components.appformdruipart.blockuitipinfo")}
            width="150"
            popper-class="app-control-drtab__popover"
            disabled={!tabPage.disabled}
            trigger="hover">
            <span slot="reference" v-badge={counter}>
                {this.renderIcon(tabPage)}
                {this.$tl((tabPage.getCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, tabPage.caption)}
            </span>
        </el-popover>);
    }

    /**
     * 绘制关系分页部件
     *
     * @returns {*}
     * @memberof AppDrtabBase
     */
    public render(h: CreateElement) {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={controlClassNames}>
                <div class={{"control-content app-control-drtab__content": true, "no-padding": this.noPadding}}>
                    {this.drtabItems.length > 0 ? this.drtabItems.map((tab: any, index: number) => {
                        return (
                            <div
                                class={[
                                    "app-control-drtab__item",
                                    this.selectItem && this.selectItem.name == tab.name ? 'is-active' : '',
                                    tab.disabled ? 'is-disable' : ''
                                ]}
                                on-click={(event: MouseEvent) => throttle(this.drTabChange, [tab, event], this)}>
                                {this.renderPanelLabel(tab)}
                            </div>
                        )
                    }) : null}
                </div>
            </div>
        )
    }
}