import { IPSExpBar } from '@ibiz/dynamic-model-api';
import { IParams, Util } from 'ibiz-core';
import { ExpViewInterface } from 'ibiz-core/src/interface/view/exp-view';
import { MainViewBase } from './mainview-base';

/**
 * 导航视图基类
 *
 * @export
 * @class ExpViewBase
 * @extends {MainViewBase}
 * @implements {ExpViewInterface}
 */
export class ExpViewBase extends MainViewBase implements ExpViewInterface {
    /**
     * 视图唯一标识
     *
     * @type {string}
     * @memberof ExpViewBase
     */
    public viewUID: string = '';

    /**
     * 导航栏实例
     * 
     * @memberof ExpViewBase
     */
    public expBarInstance!: IPSExpBar;

    /**
     * 导航项
     *
     * @type {*}
     * @memberof ExpViewBase
     */
    public navItem: any;

    /**
     * 分隔占位比例
     *
     * @type {number}
     * @memberof ExpViewBase
     */
    public split: number = 0.15;

    /**
     * 分隔占位比例（备份）
     *
     * @description 当导航视图关闭时备份比例
     * @type {number}
     * @memberof ExpViewBase
     */
    public backSplit: number = 0;

    /**
     * 快速分组数据
     *
     * @type {*}
     * @memberof ExpViewBase
     */
    public quickGroupData: any;

    /**
     * 是否提交快速分组值
     *
     * @protected
     * @type {boolean}
     * @memberof ExpViewBase
     */
    protected isEmitQuickGroupValue: boolean = false;

    /**
     * 导航视图key属性模式
     *
     * @protected
     * @type {('DEFAULT' | 'VIEWPATH')}
     * @memberof ExpViewBase
     */
    protected keyMode: 'DEFAULT' | 'VIEWPATH' = 'DEFAULT';

    /**
     * 容器挂载完成
     *
     * @memberof ExpViewBase
     */
    public containerMounted() {
        super.containerMounted();
        this.initSplit();
        if (this.expBarInstance) {
            const ctrlParams = this.expBarInstance.getPSControlParam()?.ctrlParams;
            if (ctrlParams && ctrlParams.KEYMODE) {
                this.keyMode = ctrlParams.KEYMODE.toUpperCase();
            }
        }
    }

    /**
     * 初始化分隔值
     *
     * @protected
     * @memberof ExpViewBase
     */
    protected initSplit() {
        const tempSplit = this.$store.getters.getViewSplit(`${this.viewInstance?.codeName}_${this.expBarInstance?.codeName}`);
        let split: number = this.split;
        if (tempSplit) {
            split = Number(tempSplit);
        } else {
            //  上下
            if (this.viewInstance.sideBarLayout === 'TOP') {
                const height = this.expBarInstance?.height;
                if (height && height > 0) {
                    split = height / (this.$el as any).offsetHeight;
                }
            } else {
                const width = this.expBarInstance?.width;
                if (width && width > 0) {
                    split = width / (this.$el as any).offsetWidth;
                }
            }
            this.$store.commit("setViewSplit", { viewUID: `${this.viewInstance?.codeName}_${this.expBarInstance?.codeName}`, viewSplit: split });
        }
        // IVIEW 分隔面板组件监听value为 0.5 时不执行计算逻辑
        this.split = split === 0.5 ? split + 0.0000001 : split;
    }

    /**
     * 获取导航视图key
     *
     * @protected
     * @param {IParams} navContext
     * @return {*} 
     * @memberof ExpViewBase
     */
    protected getNavViewKey(navContext: IParams) {
        if (this.keyMode === 'VIEWPATH') {
            return navContext.viewpath;
        } else {
            return navContext.viewpath + navContext.srfparentkey;
        }
    }

    /**
     * 处理占位比例变化
     *
     * @protected
     * @memberof ExpViewBase
     */
    protected handleSplitChange() {
        if (this.split) {
            this.$store.commit("setViewSplit", { viewUID: `${this.viewInstance?.codeName}_${this.expBarInstance?.codeName}`, viewSplit: this.split });
        }
    }

    /**
     * 快速分组值变化
     *
     * @param {*} event
     * @memberof ExpViewBase
     */
    public quickGroupValueChange(event: any) {
        if (event) {
            this.quickGroupData = event.data;
            if (this.isEmitQuickGroupValue && this.engine) {
                this.engine.search(event);
            }
        }
        this.isEmitQuickGroupValue = true;
    }

    /**
     * 渲染快速分组
     *
     * @return {*}  {*}
     * @memberof ExpViewBase
     */
    public renderQuickGroup(): any {
        if (!this.viewInstance.enableQuickGroup) {
            return;
        }
        let counterService: any;
        if (this.viewInstance?.getPSAppCounterRef?.()?.id) {
            counterService = Util.findElementByField(this.counterServiceArray, 'id', this.viewInstance?.getPSAppCounterRef?.()?.id)?.service;
        }
        const codeList = this.viewInstance.getQuickGroupPSCodeList?.();
        return <div class="quick-group-container" slot="quickGroupSearch">
            <app-quick-group context={this.context} viewparams={this.viewparams} codeList={codeList} on-valuechange={this.quickGroupValueChange.bind(this)} counterService={counterService}></app-quick-group>
        </div>;
    }

    /**
     * 渲染导航视图
     *
     * @return {*} 
     * @memberof ExpViewBase
     */
    public renderNavView() {
        if (this.navItem && this.navItem.data[0] && Object.keys(this.navItem.data[0]).length > 0) {
            const navContext = this.navItem.srfnavdata ? this.navItem.srfnavdata.context : {};
            const navViewParam = this.navItem.srfnavdata ? this.navItem.srfnavdata.viewparams : {};
            if(this.navItem.srfnavdata && this.navItem.srfnavdata.data){
                Object.assign(navViewParam,{srfnav: this.navItem.srfnavdata.data});
            }
            const targetCtrlParam: any = {
                staticProps: {
                    viewDefaultUsage: false,
                    inputState: this.viewState,
                    isNavView: true
                },
                dynamicProps: {
                    viewdata: JSON.stringify(navContext),
                    viewparam: JSON.stringify(navViewParam)
                }
            }
            return this.$createElement('app-view-shell', {
                class: "view-container2",
                key: this.getNavViewKey(navContext),
                props: targetCtrlParam,
                on: {
                    close: (data: any) => {
                        if (this.engine) {
                            this.engine.closeNavView();
                        }
                    },
                    viewNeedRefresh: (data: any, tag: string) => {
                        if (this.engine) {
                            this.engine.handleNavViewRefresh(tag);
                        }
                    }
                }
            });
        }
        return null;
    }

    /**
     * 渲染导航栏
     *
     * @return {*} 
     * @memberof ExpViewBase
     */
    public renderExpBar() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.expBarInstance);
        return this.$createElement(targetCtrlName, { key: this.expBarInstance.name, props: targetCtrlParam, ref: this.expBarInstance?.name, on: targetCtrlEvent }, [this.renderQuickGroup()]);
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof ExpViewBase
     */
    public renderMainContent() {
        return (
            <split
                v-model={this.split}
                class="app-vc-expbar"
                mode={this.viewInstance.sideBarLayout === 'TOP' ? 'vertical' : 'horizontal'}
                on-on-move-end={() => this.handleSplitChange()}>
                <div class={`app-vc-expbar__${this.viewInstance.sideBarLayout === 'TOP' ? 'top' : 'left'}`} slot={this.viewInstance.sideBarLayout === 'TOP' ? 'top' : 'left'}>
                    {this.renderExpBar()}
                </div>
                <div class='app-vc-expbar__body' slot={this.viewInstance.sideBarLayout === 'TOP' ? 'bottom' : 'right'}>
                    {this.renderNavView()}
                </div>
            </split>
        )
    }
}