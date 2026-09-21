import { CreateElement } from 'vue';
import { Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { ListViewBase } from '../../../view/listview-base';
import { AppLayoutService } from '../../../app-service/common-service/app-layout-service';

/**
 * 应用列表视图基类
 *
 * @export
 * @class AppListViewBase
 * @extends {ListViewBase}
 */
export class AppListViewBase extends ListViewBase {

    /**
     * 视图动态参数
     *
     * @type {any}
     * @memberof AppListViewBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {any}
     * @memberof AppListViewBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppListViewBase
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
     * 监听当前视图环境参数变化
     * 
     * @memberof AppListViewBase
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
     * 绘制目标部件
     *
     * @memberof AppListViewBase
     */
    public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderCaptionBar(),
                this.renderDataInfoBar(),
                this.renderTopMessage(),
                this.renderToolBar(),
                this.renderQuickGroup(),
                this.renderQuickSearch(),
                this.renderQuickSearchForm(),
                this.renderSearchForm(),
                this.renderSearchBar(),
                this.renderBodyMessage(),
                this.renderMainContent(),
                this.renderBottomMessage()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 列表视图渲染
     * 
     * @memberof AppListViewBase
     */
    render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance?.viewType}-${this.viewInstance?.viewStyle}`);
        return h(targetViewLayoutComponent, {
            props: { viewInstance: this.viewInstance, model: this.model, modelService: this.modelService, viewparams: this.viewparams, context: this.context },
            ref: `${this.viewInstance.codeName}Layout`,
            scopedSlots: {
                quickSearchFilter: (content: any) => {
                    return this.renderDefaultQuickSearchFilter(content);
                }
            }
        }, this.renderTargetControls());
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppListViewBase
     */
    public destroyed() {
        this.viewDestroyed();
    }
}

