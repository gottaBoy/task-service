import { IPSAppDataEntity } from '@ibiz/dynamic-model-api';
import { Util } from 'ibiz-core';
import { Emit, Prop, Watch } from 'vue-property-decorator';
import { MobSearchBarControlBase } from '../../../widgets/mob-searchbar-control-base';

/**
 * 搜索栏部件基类
 *
 * @export
 * @class AppMobSearchBarBase
 * @extends {MobSearchBarControlBase}
 */
export class AppMobSearchBarBase extends MobSearchBarControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppMobSearchFormBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppMobSearchFormBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 视图实体对象
     *
     * @memberof MobMDViewBase
     */
    get appDataEntity() {
        return (this.controlInstance?.getPSAppDataEntity() as IPSAppDataEntity);
    }

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobSearchFormBase
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
     * @memberof AppMobSearchFormBase
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
     * @memberof AppMobSearchFormBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobSearchFormBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }


    /**
     * 搜索值变化（视图代理模式下）
     *
     * @protected
     * @param {*} value
     * @param {('QUICKSEARCH' | 'QUICKGROUP' | string)} [type='QUICKSEARCH']
     * @memberof AppSearchBarBase
     */
    protected searchValueChange(value: any, type: 'QUICKSEARCH' | 'QUICKGROUP' = 'QUICKSEARCH') {
        if (type === 'QUICKSEARCH') {
            const { detail } = value;
            if (!detail) {
                return;
            }
            const data = detail.value;
            this.queryParams.quickSearchValue = data;
        } else if (type === 'QUICKGROUP') {
            const { value: _value } = value
            this.queryParams.quickGroupData = _value.data;
        }
        this.ctrlEvent({ controlname: this.controlInstance.name, action: 'search', data: Util.deepCopy(this.queryParams) });
    }

    /**
     * 渲染快速搜索（视图代理模式下）
     *
     * @protected
     * @return {*} 
     * @memberof AppSearchBarBase
     */
    protected renderQuickSearch() {
        return (
            <app-search-history appDataEntity={this.appDataEntity} parentModel={this.controlInstance} on-quickValueChange={({ value }: any) => { this.searchValueChange(value) }} ></app-search-history>
        )
    }

    /**
     * 渲染搜索栏分组（视图代理模式下）
     *
     * @protected
     * @return {*} 
     * @memberof AppSearchBarBase
     */
    protected renderSearchBarGroups() {
        if (this.quickGroupItems && this.quickGroupItems.length > 0) {
            return (
                <app-quick-group ref="quickGroup" items={this.quickGroupItems} on-valueChange={(item: any) => this.searchValueChange(item, 'QUICKGROUP')} ></app-quick-group>
            )
        }

    }

    /**
     * 渲染视图代理模式下搜索栏部件
     *
     * @memberof AppSearchBarBase
     */
    renderByViewProxyMode() {
        return (
            <div class={{ 'control-content app-control-searchbar__content': true }}>
                {this.controlInstance.enableQuickSearch ? this.renderQuickSearch() : null}
                {this.renderSearchBarGroups()}
            </div>
        )
    }

    /**
     * 绘制搜索栏
     *
     * @return {*} 
     * @memberof AppMobSearchBarBase
     */
    render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return <div class={controlClassNames}>
            {this.viewIsProxyMode ? this.renderByViewProxyMode() : null}
        </div>
    }
}
