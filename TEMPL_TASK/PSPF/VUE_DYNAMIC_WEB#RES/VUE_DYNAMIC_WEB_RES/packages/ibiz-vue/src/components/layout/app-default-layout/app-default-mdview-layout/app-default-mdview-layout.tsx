import { IPSControl, IPSDEToolbar, IPSDEToolbarItem } from '@ibiz/dynamic-model-api';
import { AppServiceBase, throttle, Util } from 'ibiz-core';
import { Component } from 'vue-property-decorator';
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";

/**
 * 视图基础布局
 *
 * @export
 * @class AppDefaultViewLayout
 * @extends {Vue}
 */
@Component({})
export class AppDefaultMDViewLayout extends AppDefaultViewLayout {

    /**
     * 实际是否展开搜索表单
     *
     * @type {boolean}
     * @memberof AppDefaultMDViewLayout
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 初始化视图的绘制参数
     *
     * @memberof AppDefaultMDViewLayout
     */
    public initRenderOptions(opts: any = {}) {
        this.renderOptions = {};
        const { viewType, viewStyle, codeName } = this.viewInstance;
        const viewClassNames: any = {
            'view-container': true
        };
        if (viewType) {
            Object.assign(viewClassNames, { [viewType?.toLowerCase()]: true });
        }
        if (viewStyle) {
            Object.assign(viewClassNames, { [`view-style-${viewStyle.toLowerCase()}`]: true });
        } else {
            Object.assign(viewClassNames, { [`view-style-default`]: true });
        }
        if (codeName) {
            Object.assign(viewClassNames, { [Util.srfFilePath2(codeName)]: true });
        }
        if (this.viewInstance?.getPSSysCss?.()?.cssName) {
            Object.assign(viewClassNames, { [this.viewInstance.getPSSysCss()?.cssName]: true });
        }
        if (this.viewProxyMode) {
            Object.assign(viewClassNames, { 'isproxy': true });
        }
        // 无视图头
        const noHeader = !this.showCaption && !this.viewIsshowToolbar && !this.$slots.quickGroupSearch && !this.$slots.quickSearch;
        if (noHeader) {
            Object.assign(viewClassNames, { 'noheader': true });
        }
        if (!this.showCaption) {
            Object.assign(viewClassNames, { 'nocaption': true });
        }
        if (!this.viewIsshowToolbar) {
            Object.assign(viewClassNames, { 'notoolbar': true });
        }
        Object.assign(viewClassNames, opts);
        this.$set(this.renderOptions, 'viewClassNames', viewClassNames);
    }

    /**
     * 初始化视图特有数据
     *
     * @memberof AppDefaultMDViewLayout
     */
    public initViewSpecificData() {
        this.isExpandSearchForm = this.viewInstance?.expandSearchForm ? true : false;
    }

    /**
     * 计算目标部件所需参数
     *
     * @param controlInstance 部件模型
     * @param args 额外参数 {staticProps:{xxx},dynamicProps:{xxx},customEvent:{xxx}}
     * @memberof AppDefaultMDViewLayout
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        let targetCtrlName: string = `app-control-shell`;
        let targetCtrlParam: any = {
            staticProps: {
                containerInstance: this.containerModel,
                modelData: controlInstance,
                ref: controlInstance.name,
                viewLoadingService: this.viewLoadingService,
                layoutLoadingService: this.layoutLoadingService
            },
            dynamicProps: {
                viewparams: this.viewparams,
                context: this.context,
                viewCtx: this.viewCtx
            }
        };
        if (!Object.is(controlInstance?.controlType, 'SEARCHFORM') &&
            !Object.is(controlInstance?.controlType, 'FORM') &&
            !Object.is(controlInstance?.controlType, 'TOOLBAR') &&
            !Object.is(controlInstance?.controlType, 'SEARCHBAR')) {
            Object.assign(targetCtrlParam.staticProps, {
                opendata: this.opendata,
                newdata: this.newdata,
            });
        }
        Object.defineProperty(targetCtrlParam.staticProps, 'containerInstance', { enumerable: false, writable: true });
        Object.defineProperty(targetCtrlParam.staticProps, 'modelData', { enumerable: false, writable: true });
        let targetCtrlEvent: any = {
            'ctrl-event': ({ controlname, action, data }: { controlname: string, action: string, data: any }) => {
                this.onCtrlEvent(controlname, action, data);
            }
        }
        // 合并视图级参数
        Object.assign(targetCtrlParam.staticProps, { viewState: this.viewState, viewtag: this.viewtag, viewIsProxyMode: this.viewProxyMode });
        Object.assign(targetCtrlEvent, {
            closeView: ($event: any) => {
                this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewClosed', data: $event });
            }
        })
        // 合并多数据视图级参数
        if (Object.is(controlInstance.controlType, 'SEARCHFORM') || Object.is(controlInstance.controlType, 'SEARCHBAR')) {
            Object.assign(targetCtrlParam.dynamicProps, {
                isExpandSearchForm: this.isExpandSearchForm
            });
        } else {
            Object.assign(targetCtrlParam.staticProps, {
                mDCtrlActiveMode: (this.viewInstance as any).mDCtrlActiveMode,
            });
        }
        // 合并传入自定义参数
        if (args && args.staticProps && Object.keys(args.staticProps).length > 0) {
            Object.assign(targetCtrlParam.staticProps, args.staticProps);
        }
        if (args && args.dynamicProps && Object.keys(args.dynamicProps).length > 0) {
            Object.assign(targetCtrlParam.dynamicProps, args.dynamicProps);
        }
        if (args && args.customEvent && Object.keys(args.customEvent).length > 0) {
            Object.assign(targetCtrlEvent, args.customEvent);
        }
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 渲染目标部件
     *
     * @param {IPSControl} control
     * @param {boolean} [slotMode=true]
     * @return {*} 
     * @memberof AppDefaultMDViewLayout
     */
    public renderTargetControl(control: IPSControl, slotMode: boolean = true, args?: any) {
        if (Object.is(control.controlType, 'TOOLBAR')) {
            if (Object.is(control.name, 'toolbar')) {
                return this.renderToolBar();
            } else {
                const viewToolBar: IPSDEToolbar = control as IPSDEToolbar;
                const targetViewToolbarItems: any[] = [];
                if (viewToolBar && viewToolBar.getPSDEToolbarItems()) {
                    viewToolBar.getPSDEToolbarItems()?.forEach((toolbarItem: IPSDEToolbarItem) => {
                        targetViewToolbarItems.push(this.initToolBarItems(toolbarItem));
                    });
                }
                return (
                    <view-toolbar
                        slot={`layout-${control.name}`}
                        mode={'DEFAULT'}
                        counterServiceArray={this.counterServiceArray}
                        isViewLoading={this.layoutLoadingService?.isLoading}
                        toolbarModels={targetViewToolbarItems}
                        on-item-click={(data: any, $event: any) => {
                            throttle(this.handleItemClick, [data, $event], this);
                        }}
                    ></view-toolbar>
                );
            }
        } else if(Object.is(control.controlType, 'CAPTIONBAR')){
          return this.renderCaptionBar();
        }  else {
            let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(control, args);
            if (slotMode) {
                return this.$createElement(targetCtrlName, { slot: `layout-${control.name}`, props: targetCtrlParam, ref: control?.name, on: targetCtrlEvent });
            } else {
                return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: control?.name, on: targetCtrlEvent });
            }
        }
    }

    /**
     * 渲染快速搜索
     *
     * @return {*} 
     * @memberof AppDefaultMDViewLayout
     */
    public renderQuickSearch() {
        if (this.viewInstance.enableQuickSearch && !this.viewInstance.expandSearchForm) {
            const content = this.$scopedSlots.quickSearchFilter?.(this.$slots.searchForm ? this.$slots.searchForm : this.$slots.searchBar ? this.$slots.searchBar : null);
            return content;
        } else {
            return this.$slots.quickSearch;
        }
    }

    /**
     * 绘制头部内容
     * 
     * @memberof AppDefaultMDViewLayout
     */
    public renderViewHeader() {
        return [
            <div class="view-header__left">
                {this.showCaption ? <div class='view-header__left__caption'>{this.renderViewCaption()}</div> : null}
                {this.$slots.quickGroupSearch ? <div class="view-header__left__quickgroup">{this.$slots.quickGroupSearch}</div> : null}
            </div>,
            this.$slots.quickSearch || (this.viewIsshowToolbar && this.$slots.toolbar) ?
                <div class="view-header__right">
                    <div class="view-header__right__quicksearch">
                        {this.renderQuickSearch()}
                    </div>
                    {this.viewIsshowToolbar ? <div class="view-header__right__toolbar">{this.$slots.toolbar}</div> : null}
                </div> : null
        ]
    }

    /**
     * 绘制正文内容
     * 
     * @memberof AppDefaultMDViewLayout
     */
    public renderViewContent(): any {
        return [
            this.$slots.topMessage || (this.$slots.searchForm && !(this.viewInstance.enableQuickSearch && !this.viewInstance.expandSearchForm)) ? <div class="view-content__top">
                {this.$slots.topMessage}
                {this.viewInstance.enableQuickSearch && !this.viewInstance.expandSearchForm ? null : this.$slots.searchForm}
            </div> : null,
            <div class="view-content__body">
                {this.$slots.bodyMessage}
                {this.$slots.default}
            </div>,
            this.$slots.bottomMessage ? <div class="view-content__bottom">
                {this.$slots.bottomMessage}
            </div> : null
        ]
    }
}