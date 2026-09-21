import { IPSLanguageRes } from '@ibiz/dynamic-model-api';
import { Util } from 'ibiz-core';
import { Emit, Prop, Watch } from 'vue-property-decorator';
import { MobDrtabControlBase } from '../../../widgets/mob-drtab-control-base';

/**
 * 数据关系分页部件基类
 *
 * @export
 * @class AppMobDrtabBase
 * @extends {TabExpPanelBase}
 */
export class AppMobDrtabBase extends MobDrtabControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppMobDrtabBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppMobDrtabBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobDrtabBase
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
     * @memberof AppMobDrtabBase
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
     * @memberof AppMobDrtabBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobDrtabBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制关系分页部件
     *
     * @returns {*}
     * @memberof AppMobDrtabBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        let countService: any = null;
        if (this.counterServiceArray?.length > 0) {
            countService = this.counterServiceArray[0].service;
        }
        return (
            <div class={controlClassNames} >
                {this.drtabItems?.length > 0 && this.drtabItems.map((tabPage: any, index: number) => {
                    return <div class={{ 'drtab__item': true, 'drtab__item--select': this.selectItem && this.selectItem.name == tabPage.name }} style={this.calcDrtabItemStyle()} on-click={() => { this.tabPanelChange(tabPage) }} >
                        {this.$tl((tabPage.getCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, tabPage.caption)}
                        {countService && tabPage.counterId ? <span class="count">{countService?.counterData?.[tabPage.counterId]}</span> : null}
                    </div>
                })}
            </div>
        );
    }
}