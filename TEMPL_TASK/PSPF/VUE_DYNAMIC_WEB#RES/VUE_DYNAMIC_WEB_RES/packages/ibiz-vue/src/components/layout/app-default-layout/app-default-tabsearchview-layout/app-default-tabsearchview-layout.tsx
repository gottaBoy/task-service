import { Prop, Component } from 'vue-property-decorator';
import { IPSAppDETabSearchView } from "@ibiz/dynamic-model-api";
import { ModelTool } from "ibiz-core";
import { AppDefaultMDViewLayout } from '../app-default-mdview-layout/app-default-mdview-layout';

@Component({})
export class AppDefaultTabSearchViewLayout extends AppDefaultMDViewLayout {

    /**
     * 分页搜索视图模型对象
     *
     * @type {IPSAppDETabSearchView}
     * @memberof AppDefaultTabSearchViewLayout
     */
    @Prop() public declare viewInstance: IPSAppDETabSearchView;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}]
     * @memberof AppDefaultTabSearchViewLayout
     */
    public engineInit(opts: any = {}) {
        const controls: any[] = this.containerModel.getPSControls() || [];
        const engineOpts = Object.assign({
            view: this,
            p2k: '0',
            isLoadDefault: this.viewInstance?.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase()
        }, opts);
        //  分页导航面板
        const tabexppanel = ModelTool.findPSControlByType('TABEXPPANEL', controls);
        if (tabexppanel) {
            Object.assign(engineOpts, {
                tabexppanel: (this.$refs[tabexppanel.name] as any).ctrl
            });
        }
        //  搜索表单
        const searchForm = ModelTool.findPSControlByType('SEARCHFORM', controls);
        if (searchForm) {
            Object.assign(engineOpts, {
                searchform: (this.$refs[searchForm.name] as any).ctrl
            });
        }
        //  搜索栏
        const searchBar = ModelTool.findPSControlByType('SEARCHBAR', controls);
        if (searchBar) {
            Object.assign(engineOpts, {
                searchform: (this.$refs[searchBar.name] as any).ctrl
            });
        }
        this.engine.init(engineOpts);
    }

    /**
     * 计算目标部件所需参数
     *
     * @param controlInstance 部件模型
     * @param args 额外参数 {staticProps:{xxx},dynamicProps:{xxx},customEvent:{xxx}}
     * @memberof AppDefaultTabSearchViewLayout
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
            //  分页搜索视图下搜索表单和搜索栏走正常模式
            Object.assign(targetCtrlParam.staticProps, {
                viewIsProxyMode: false
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
     * 渲染快速搜索
     *
     * @return {*} 
     * @memberof AppDefaultMDViewLayout
     */
    public renderQuickSearch() {
        if (this.viewInstance.enableQuickSearch && !this.viewInstance.expandSearchForm) {
            const content = this.$scopedSlots.quickSearchFilter?.(this.$slots.searchForm ? this.$slots.searchForm : null);
            return content;
        } else {
            return this.$slots.quickSearch;
        }
    }

    /**
     * 绘制正文内容
     * 
     * @memberof AppDefaultTabSearchViewLayout
     */
    public renderViewContent(): any {
        return [
            this.$slots.topMessage || this.$slots.searchBar || (this.$slots.searchForm && !(this.viewInstance.enableQuickSearch && !this.viewInstance.expandSearchForm)) ? <div class="view-content__top">
                {this.$slots.topMessage}
                {this.viewInstance.enableQuickSearch && !this.viewInstance.expandSearchForm ? null : this.$slots.searchForm}
                {this.$slots.searchBar}
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