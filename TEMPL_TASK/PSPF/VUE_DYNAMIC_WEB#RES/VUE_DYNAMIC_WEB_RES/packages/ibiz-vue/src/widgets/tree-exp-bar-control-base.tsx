import { IPSAppViewRef, IPSDETree, IPSTreeExpBar, IPSDEPickupViewPanel, IPSAppDERedirectView, IPSAppView, IPSNavigateContext, IPSNavigateParam } from '@ibiz/dynamic-model-api';
import { IParams, ModelTool, StringUtil, TreeExpBarControlInterface, Util, ViewTool } from 'ibiz-core';
import { ExpBarControlBase } from './expbar-control-base';
/**
 * 树视图导航栏部件基类
 *
 * @export
 * @class TreeExpBarControlBase
 * @extends {ExpBarControlBase}
 */
export class TreeExpBarControlBase extends ExpBarControlBase implements TreeExpBarControlInterface {

    /**
     * 部件模型实例对象
     *
     * @type {IPSTreeExpBar}
     * @memberof TreeExpBarControlBase
     */
    public declare controlInstance: IPSTreeExpBar;

    /**
     * 选择视图面板实例对象
     *
     * @type {IPSDEPickupViewPanel}
     * @memberof TreeExpBarControlBase
     */
    public pickupViewPanelInstance?: IPSDEPickupViewPanel;

    /**
     * 数据部件
     *
     * @memberof ListExpBarControlBase
     */
    protected declare $xDataControl: IPSDETree;

    /**
     * 刷新标识
     *
     * @public
     * @type {number}
     * @memberof TreeExpBarControlBase
     */
    public counter: number = 0;


    /**
     * 部件动态参数
     * 
     * @type {any}
     * @memberof TreeExpBarControlBase
     */
    public ctrlParams: any = {};

    /**
     * 分割宽度
     *
     * @public
     * @type {number}
     * @memberof TreeExpBarControlBase
     */
    public split: number = 0.15;

    /**
     * 导航模式
     *
     * @description 'DEFAULT': 默认, 'PICKUPVIEW': 选择视图中
     * @type {('DEFAULT' | 'PICKUPVIEW' | string)}
     * @memberof TreeExpBarControlBase
     */
    public expMode: 'DEFAULT' | 'PICKUPVIEW' | string = 'DEFAULT';

    /**
     * 监听部件静态参数变化
     *
     * @public
     * @type {number}
     * @memberof TreeExpBarControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal.pickupviewpanel) {
            this.pickupViewPanelInstance = newVal.pickupviewpanel;
        }
        this.expMode = newVal.expMode ? newVal.expMode : 'DEFAULT';
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 获取关系项视图
     *
     * @param {*} [arg={}] 额外参数
     * @returns {*}
     * @memberof TreeExpBarControlBase
     */
    public async getExpItemView(arg: any = {}) {
        let expmode = 'EXPITEM:' + arg.nodetype.toUpperCase();
        if (this.controlInstance?.getPSAppViewRefs()) {
            for (let viewRef of (this.controlInstance?.getPSAppViewRefs()) as IPSAppViewRef[]) {
                if (Object.is(expmode, viewRef.name.toUpperCase())) {
                    let view = {
                        viewModelData: viewRef.getRefPSAppView(),
                        parentdata: viewRef.parentDataJO || {},
                        deKeyField: viewRef.getRefPSAppView()?.getPSAppDataEntity()?.codeName?.toLowerCase(),
                    }
                    await view.viewModelData?.fill();
                    return view;
                }
            }
        }
        return null;
    }

    /**
     * 部件模型数据初始化实例
     *
     * @memberof ExpBarControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit(args);
        this.xDataControlName = this.controlInstance.xDataControlName;
        this.$xDataControl = ModelTool.findPSControlByName(this.xDataControlName, this.controlInstance.getPSControls());
        this.ctrlParams = this.controlInstance?.getPSControlParam()?.ctrlParams || {};
    }

    /**
     * 树导航选中
     *
     * @param {any []} args 选中数据
     * @param {string} [tag]
     * @param {*} [$event2]
     * @returns {void}
     * @memberof TreeExpBarControlBase
     */
    public async onSelectionChange(args: any[], tag?: string, $event2?: any): Promise<void> {
        if (args.length === 0) {
            this.calcNavigationToolbarState(true);
            return;
        }
        const arg: any = args[0];
        if (!arg.id) {
            this.calcNavigationToolbarState(true);
            return;
        }
        const nodetype = arg.id.split(';')[0];
        const refview: any = await this.getExpItemView({ nodetype: nodetype });
        if (this.expMode === 'DEFAULT' && !refview) {
            this.calcNavigationToolbarState(true);
            return;
        }
        let { tempContext, tempViewparam } = this.computeNavParams(arg);
        if (refview) {
            if (Object.is(refview.viewModelData.viewType, 'DEREDIRECTVIEW')) {
                const { modelPath } = await this.getRedirectViewModelPath(tempContext, tempViewparam, refview.viewModelData);
                Object.assign(tempContext, { viewpath: modelPath });
            } else {
                Object.assign(tempContext, { viewpath: refview.viewModelData.modelPath });
            }
        }
        this.handleCtrlEvents('onselectionchange', { action: 'selectionchange', data: args }).then((res: boolean) => {
            if (res) {
                const params = {
                    data: args,
                    srfnavdata: {
                        context: tempContext,
                        viewparams: tempViewparam
                    }
                }
                if(this.ctrlParams && this.ctrlParams.NAVURL){
                    const treeCtrl:any = this.$refs[this.xDataControlName];
                    if(treeCtrl && treeCtrl.ctrl.getExpandedTexts().length >0){
                        this.viewparams.srfnav = treeCtrl.ctrl.getExpandedTexts().join('/');
                    }
                    Object.assign(params.srfnavdata,{data: this.viewparams.srfnav});
                }
                this.calcNavigationToolbarState(false, arg);
                this.$emit("ctrl-event", { controlname: this.controlInstance.name, action: "selectionchange", data: params });
            }
        })
    }

    /**
     * 计算导航参数
     * 
     * @param arg  选中数据
     * @memberof TreeExpBarControlBase
     */
    public computeNavParams(arg: any) {
        let tempContext: any = {};
        let tempViewparam: any = {};
        if (arg && arg.navfilter) {
            this.counter += 1;
            Object.defineProperty(tempViewparam, arg.navfilter, {
                value: arg.srfkey,
                writable: true,
                enumerable: true,
                configurable: true
            })
            Object.assign(tempContext, { srfcounter: this.counter });
        }
        Object.assign(tempContext, Util.deepCopy(this.context));
        if (arg.srfappctx) {
            Object.assign(tempContext, Util.deepCopy(arg.srfappctx));
        }
        if (arg.srfparentdename) {
            Object.assign(tempContext, { srfparentdename: arg.srfparentdename });
        }
        if (arg.srfparentdemapname) {
            Object.assign(tempContext, { srfparentdemapname: arg.srfparentdemapname });
        }
        if (arg.srfparentkey) {
            Object.assign(tempContext, { srfparentkey: arg.srfparentkey });
        }
        // 计算导航上下文
        if (arg && arg.navigateContext && Object.keys(arg.navigateContext).length > 0) {
            let tempData: any = arg.curData ? Util.deepCopy(arg.curData) : {};
            Object.assign(tempData, arg);
            let _context = this.$util.computedNavData(tempData, this.context, this.viewparams, arg.navigateContext);
            Object.assign(tempContext, _context);
        }
        // 计算导航参数
        if (arg && arg.navigateParams && Object.keys(arg.navigateParams).length > 0) {
            let tempData: any = arg.curData ? Util.deepCopy(arg.curData) : {};
            Object.assign(tempData, arg);
            let _params = this.$util.computedNavData(tempData, this.context, this.viewparams, arg.navigateParams);
            Object.assign(tempViewparam, _params);
            this.counter += 1;
            Object.assign(tempContext, { srfcounter: this.counter });
        }
        return { tempContext, tempViewparam };
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlInstance] 部件模型类型
     * @returns
     * @memberof TreeExpBarControlBase
     */
    public computeTargetCtrlData(controlInstance: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance);
        Object.assign(targetCtrlParam.staticProps, {
            isBranchAvailable: true
        })
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 执行搜索
     *
     * @memberof TreeExpBarControlBase
     */
    public onSearch(event: any): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.viewState && this.$xDataControl) {
            this.viewState.next({ tag: this.xDataControlName, action: 'filter', data: { srfnodefilter: this.searchText } });
        }
    }

    /**
     * 绘制数据部件
     *
     * @memberof TreeExpBarControlBase
     */
    public renderXDataControl() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.$xDataControl);
        Object.assign(targetCtrlParam.staticProps, {
            isSelectFirstDefault: true,
            isSingleSelect: true,
            isNavUrl: this.ctrlParams.NAVURL ? true : false
        });
        return this.$createElement(targetCtrlName, { key: this.xDataControlName, props: targetCtrlParam, ref: this.xDataControlName, on: targetCtrlEvent });
    }

}
