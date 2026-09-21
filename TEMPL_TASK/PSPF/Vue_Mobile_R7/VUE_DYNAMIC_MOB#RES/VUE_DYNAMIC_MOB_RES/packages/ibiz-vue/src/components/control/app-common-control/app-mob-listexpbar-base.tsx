import { Util } from "ibiz-core";
import { Prop, Watch, Emit, Component } from "vue-property-decorator";
import { MobListExpBarControlBase } from "../../../widgets";

/**
 * 实体列表导航栏部件基类
 *
 * @export
 * @class AppMobListExpBar
 * @extends {ListExpBarControlBase}
 */
@Component({})
export class AppMobListExpBarBase extends MobListExpBarControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppMobListExpBar
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppMobListExpBar
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobListExpBar
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
     * @memberof AppMobListExpBar
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
     * @memberof AppMobListExpBar
     */
    public ctrlInit() {
        super.ctrlInit();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobListExpBar
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 绘制列表导航栏
     *
     * @return {*} 
     * @memberof AppMobListExpBarBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return <div class={controlClassNames}>
            <div class="control-content app-control-listexpbar__content"> {this.renderXDataControl()}</div>
        </div>
    }
}
