import { CreateElement } from "vue";
import { Component, Prop, Watch } from 'vue-property-decorator';
import { Util, ThirdPartyService } from "ibiz-core";
import { MobDeRedirectViewBase } from "ibiz-vue";
import './${srffilepath2(view.name)}.less';

/**
 * ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {MobDeRedirectViewBase}
 */
@Component({})
export class ${srfclassname('${view.name}')} extends MobDeRedirectViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof ${srfclassname('${view.name}')}
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof ${srfclassname('${view.name}')}
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ${srfclassname('${view.name}')}
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
     * 监听视图静态参数变化
     * 
     * @memberof ${srfclassname('${view.name}')}
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
     * @memberof @memberof ${srfclassname('${view.name}')}
     */
    public destroyed() {
        this.viewDestroyed();
    }
}