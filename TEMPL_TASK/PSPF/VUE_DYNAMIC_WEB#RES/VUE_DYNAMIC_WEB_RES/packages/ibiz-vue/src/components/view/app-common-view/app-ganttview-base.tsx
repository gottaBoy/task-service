import { Util } from 'ibiz-core';
import { Prop, Emit, Watch } from 'vue-property-decorator';
import { AppLayoutService } from '../../../app-service';
import { GanttViewBase } from '../../../view/ganttview-base';
import { CreateElement } from 'vue';

/**
 * 应用实体甘特视图基类
 *
 * @export
 * @class AppGanttViewBase
 * @extends {GanttViewBase}
 */
export class AppGanttViewBase extends GanttViewBase {

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppGanttViewBase
     */
     @Prop() public declare dynamicProps: any;

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppGanttViewBase
     */
     @Prop() public declare staticProps: any;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppGanttViewBase
     */
    @Watch('dynamicProps',{
        immediate: true,
    })
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal,oldVal)) {
           super.onDynamicPropsChange(newVal,oldVal);
        }
    }

    /**
     * 监听视图静态参数变化
     * 
     * @memberof AppGanttViewBase
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal,oldVal)) {
            super.onStaticPropsChange(newVal,oldVal);
        }
    }
    
    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppDefaultTree
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void {}

    /**
     * 绘制目标部件
     *
     * @memberof AppGanttViewBase
     */
     public renderTargetControls() {
        if (this.useDefaultLayout) {
            return [
                this.renderCaptionBar(),
                this.renderDataInfoBar(),
                this.renderTopMessage(),
                this.renderBodyMessage(),
                this.renderToolBar(),
                this.renderQuickGroup(),
                this.renderQuickSearch(),
                this.renderSearchForm(),
                this.renderMainContent(),
                this.renderBottomMessage()
            ]
        } else {
            return this.renderViewControls();
        }
    }

    /**
     * 绘制
     * 
     * @param h 
     * @memberof AppGanttViewBase
     */
    render(h: CreateElement) {
        if (!this.viewIsLoaded) {
            return null;
        }
        const targetViewLayoutComponent: any = AppLayoutService.getLayoutComponent(`${this.viewInstance.viewType}-${this.viewInstance.viewStyle}`);
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

    /**
     * 销毁视图回调
     *
     * @memberof AppGanttViewBase
     */
     public destroyed(){
        this.viewDestroyed();
    }
}