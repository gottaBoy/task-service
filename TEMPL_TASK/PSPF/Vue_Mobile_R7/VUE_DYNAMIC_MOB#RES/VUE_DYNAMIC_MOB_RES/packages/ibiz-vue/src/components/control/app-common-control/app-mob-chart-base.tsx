import { Prop, Watch, Emit, Component } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { MobChartControlBase } from '../../../widgets';

/**
 * 图表部件基类
 *
 * @export
 * @class AppMobChartBase
 * @extends {MobChartControlBase}
 */
@Component({})
export class AppMobChartBase extends MobChartControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppMobChartBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppMobChartBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobChartBase
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
     * @memberof AppMobChartBase
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
     * @memberof AppMobChartBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobChartBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 初始化部件的绘制参数
     *
     * @type {Array<*>}
     * @memberof ViewBase
     */
     public initRenderOptions(opts?: any) {
        this.renderOptions = {};
        const { controlType, codeName } = this.controlInstance;
        // 部件类名
        const controlClassNames: any = {
            'control-container': true,
            'multidata-container':true,
            [`app-control-${controlType.toLowerCase()}`]: true,
            [Util.srfFilePath2(codeName)]: true,
        };
        Object.assign(controlClassNames, opts);
        if (this.controlInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(controlClassNames, { [this.controlInstance.getPSSysCss()?.cssName || '']: true });
        }
        this.$set(this.renderOptions, 'controlClassNames', controlClassNames);
    }

    /**
     * 绘制图表
     *
     * @returns {*}
     * @memberof AppMobChartBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return;
        }
        const { controlClassNames } = this.renderOptions;
        const { width, height } = this.controlInstance;
        return (
            <div class={controlClassNames} >
                {this.isNoData ?
                    <div class="control-content--nodata">{this.$t('app.commonWords.noData')}</div> :
                    <div class="control-content app-control-chart__content" id={this.chartId} style={{ width: width ? `${width}px` : '100%', height: height ? `${height}px` : '80%' }}></div>}
            </div>
        )

    }
}