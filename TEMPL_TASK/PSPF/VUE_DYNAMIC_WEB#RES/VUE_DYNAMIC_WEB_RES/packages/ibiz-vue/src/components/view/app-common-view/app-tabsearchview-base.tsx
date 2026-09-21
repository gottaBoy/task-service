import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { TabSearchViewBase } from '../../../view/tabsearchview-base';
import { CreateElement } from 'vue';
import { AppLayoutService } from '../../../app-service/common-service/app-layout-service';

/**
 * 实体分页搜索视图基类
 *
 * @export
 * @class AppTabSearchViewBase
 * @extends {TabExpViewBase}
 */
export class AppTabSearchViewBase extends TabSearchViewBase {


    /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof AppTabSearchViewBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppTabSearchViewBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppTabSearchViewBase
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
     * @memberof AppTabSearchViewBase
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
     * @memberof AppTabSearchViewBase
     */
    public destroyed(){
        this.viewDestroyed();
    }

    /**
     * 绘制目标部件
     *
     * @memberof AppTabSearchViewBase
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderCaptionBar(),
                this.renderDataInfoBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderToolBar(),
                this.renderQuickSearch(),
                this.renderQuickSearchForm(),
                this.renderSearchForm(),
                this.renderSearchBar(),
                this.renderMainContent(),
                this.renderBottomMessage()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 分页导航视图渲染
     * 
     * @memberof AppTabSearchViewBase
     */
    render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance?.viewType}-${this.viewInstance?.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService },
            ref: `${this.viewInstance.codeName}Layout`,
            scopedSlots: {
                quickSearchFilter: (content: any) => {
                    return this.renderDefaultQuickSearchFilter(content);
                }
            }
        }, this.renderTargetControls());
    }
}
