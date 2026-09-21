import { Util } from "ibiz-core";
import { Prop, Watch, Emit, Component } from "vue-property-decorator";
import { MobCalendarExpBarControlBase } from "../../../widgets";

/**
 * 实体列表导航栏部件基类
 *
 * @export
 * @class AppMobCalendarExpBar
 * @extends {CalendarExpBarControlBase}
 */
@Component({})
export class AppMobCalendarExpBarBase extends MobCalendarExpBarControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppMobCalendarExpBar
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppMobCalendarExpBar
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobCalendarExpBar
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
     * @memberof AppMobCalendarExpBar
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
     * 初始化部件
     *
     * @memberof AppMobCalendarExpBar
     */
    public ctrlInit() {
        super.ctrlInit();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobCalendarExpBar
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制列表导航栏
     *
     * @return {*} 
     * @memberof AppMobCalendarExpBarBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return <div class={controlClassNames}>
            <div class="control-content app-control-calendarexpbar__content"> {this.renderXDataControl()}</div>
        </div>
    }
}
