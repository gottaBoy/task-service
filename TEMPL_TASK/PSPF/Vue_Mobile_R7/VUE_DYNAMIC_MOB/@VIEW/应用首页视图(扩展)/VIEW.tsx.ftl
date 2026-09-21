import { CreateElement } from "vue";
import { Component, Prop, Watch } from 'vue-property-decorator';
import { Util } from "ibiz-core";
import { IndexViewBase } from "ibiz-vue";
import './${srffilepath2(view.name)}.less';

/**
 * ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {IndexViewBase}
 */
@Component({})
export class ${srfclassname('${view.name}')} extends IndexViewBase {

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
     * 渲染视图
     *
     * @memberof ${srfclassname('${view.name}')}
     */
    public render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        let viewClass = {
            'view-container': true,
            'view-default': true,
            '${view.getViewType()?lower_case}': true,
            '${srffilepath2(view.getCodeName())}': true,
            <#if view.getPSSysCss?? && view.getPSSysCss()??>'${view.getPSSysCss().getCssName()}': true</#if>
        };
        return (
            <div class={ viewClass }>
                <div class='app-content'>
                    <div class='app-content__body'>
                        {this.renderEmbedViewContent()}
                    </div>
                    <div class="app-content__footer">
                        {this.renderMainContent()}
                    </div>
                </div>
            </div>
        );
    }

    /**
     * 销毁视图回调
     *
     * @memberof ${srfclassname('${view.name}')}
     */
    public destroyed() {
        this.viewDestroyed();
    }

}