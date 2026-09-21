import { MobExpBarControlInterface, ModelTool, Util } from 'ibiz-core';
import { MainControlBase } from './main-control-base';
import { IPSAppDataEntity, IPSDEList, IPSDETree, IPSExpBar, IPSSysCalendar } from '@ibiz/dynamic-model-api';
/**
 * 导航栏部件基类
 *
 *
 */
export class MobExpBarControlBase extends MainControlBase implements MobExpBarControlInterface {
    /**
     * 导航栏部件模型对象
     *
     * @memberof ExpBarControlBase
     */
    public declare controlInstance: IPSExpBar;

    /**
     * 数据部件
     *
     * @memberof ExpBarControlBase
     */
    protected $xDataControl!: IPSDEList | IPSDETree | IPSSysCalendar;

    /**
     * 数据部件名称
     *
     * @memberof ExpBarControlBase
     */
    public xDataControlName!: string;

    /**
     * 导航视图名称
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public navView!: any;

    /**
     * 导航上下文参数
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public navigateContext: any = {};

    /**
     * 导航视图参数
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public navigateParams: any = {};

    /**
     * 导航过滤项
     *
     * @type {string}
     * @memberof ExpBarControlBase
     */
    public navFilter: string = "";

    /**
     * 导航关系
     *
     * @type {string}
     * @memberof ExpBarControlBase
     */
    public navPSDer: string = "";

    /**
     * 选中数据
     *
     * @type {*}
     * @memberof ExpBarControlBase
     */
    public selection: any = {};

    /**
     * 部件模型数据初始化实例
     *
     * @memberof ExpBarControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        this.xDataControlName = this.controlInstance.xDataControlName;
        this.$xDataControl = ModelTool.findPSControlByName(this.xDataControlName, this.controlInstance.getPSControls());
        await this.handleXDataCtrlOptions();
    }


    /**
     * 初始化导航参数
     * 
     * @param params 初始化参数
     * @memberof ExpBarControlBase
     */
    public initNavParam(params: any) {
        if (params && params.length > 0) {
            let navParams: any = {};
            params.forEach((param: any) => {
                const navParam = {
                    [param.key]: param.rawValue ? param.value : "%" + param.value + "%",
                }
                Object.assign(navParams, navParam);
            });
            return navParams;
        } else {
            return null;
        }
    }

    /**
     * 初始化部件参数
     *
     * @memberof MobExpBarControlBase
     */
    public async handleXDataCtrlOptions() {
        //  导航上下文
        const navContext = (this.$xDataControl as any).getPSNavigateContexts();
        if (navContext && navContext.length) {
            this.navigateContext = Util.formatNavParam(navContext);
        }
        //  导航参数
        const navParams = (this.$xDataControl as any).getPSNavigateParams();
        if (navParams && navParams.length) {
            this.navigateParams = Util.formatNavParam(navParams);
        }
    }

    /**
     * 部件初始化
     *
     * @param {*} [args]
     * @memberof ExpBarControlBase
     */
    public ctrlInit(args?: any) {
        super.ctrlInit(args);
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (this.$xDataControl) {
                    this.viewState.next({ tag: this.xDataControlName, action: action, data: data });
                }
            });
        }
    }

    /**
     * 绘制数据部件
     *
     * @memberof ExpBarControlBase
     */
    public renderXDataControl() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.$xDataControl);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.xDataControlName, on: targetCtrlEvent });
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof ExpBarControlBase
     */
    public computeTargetCtrlData(controlInstance: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance);
        Object.assign(targetCtrlParam.staticProps, {
            isSelectFirstDefault: true,
            isSingleSelect: true,
        })
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 刷新
     *
     * @memberof ExpBarControlBase
     */
    public refresh(args?: any): void {
        if (this.$xDataControl) {
            const xDataControl: any = (this.$refs[`${(this.xDataControlName)?.toLowerCase()}`] as any).ctrl;
            if (xDataControl && xDataControl.refresh && xDataControl.refresh instanceof Function) {
                xDataControl.refresh(args);
            }
        }
    }

    /**
     * 选中数据事件
     * 
     * @memberof ExpBarControlBase
     */
    public onSelectionChange(args: any[]): void {
        let tempContext: any = {};
        let tempViewParam: any = {};
        if (args.length === 0) {
            this.ctrlEvent({ controlname: this.xDataControlName, action: 'selectionchange', data: {} });
            return;
        }
        const arg: any = args[0];
        if (this.context) {
            Object.assign(tempContext, JSON.parse(JSON.stringify(this.context)));
        }
        if (this.$xDataControl) {
            const appDataEntity: IPSAppDataEntity | null = this.$xDataControl?.getPSAppDataEntity();
            if (appDataEntity) {
                Object.assign(tempContext, { [`${appDataEntity.codeName?.toLowerCase()}`]: arg[appDataEntity.codeName?.toLowerCase()] });
                Object.assign(tempContext, { srfparentdename: appDataEntity.codeName, srfparentdemapname: (appDataEntity as any)?.getPSDEName(), srfparentkey: arg[appDataEntity.codeName?.toLowerCase()] });
                if (this.navFilter && !Object.is(this.navFilter, "")) {
                    Object.assign(tempViewParam, { [this.navFilter]: arg[appDataEntity.codeName?.toLowerCase()] });
                }
                if (this.navPSDer && !Object.is(this.navPSDer, "")) {
                    Object.assign(tempViewParam, { [this.navPSDer]: arg[appDataEntity.codeName?.toLowerCase()] });
                }
            }
            if (this.navigateContext && Object.keys(this.navigateContext).length > 0) {
                let _context: any = this.$util.computedNavData(arg, tempContext, tempViewParam, this.navigateContext);
                Object.assign(tempContext, _context);
            }
            if (this.navigateParams && Object.keys(this.navigateParams).length > 0) {
                let _params: any = this.$util.computedNavData(arg, tempContext, tempViewParam, this.navigateParams);
                Object.assign(tempViewParam, _params);
            }
            this.handleCtrlEvents('onselectionchange', { action: 'selectionchange', data: Util.deepCopy(this.selection) }).then((res: boolean) => {
                this.selection = {};
                if (this.navView) {
                    Object.assign(tempContext, { viewpath: this.navView.modelPath });
                }
                const eventData = {};
                Object.assign(eventData, { srfnavdata: { context: tempContext, viewparams: tempViewParam } });
                this.ctrlEvent({ controlname: this.xDataControlName, action: 'selectionchange', data: eventData });
                this.$forceUpdate();
            })
        }
    }

    /**
     * load完成事件
     * 
     * @memberof ExpBarControlBase
     */
    public onLoad(args: any, tag?: string, $event2?: any) {
        if (this.$xDataControl) {
            this.$emit('ctrl-event', { controlname: this.xDataControlName, action: "load", data: args });
        }
    }


    /**
     * 部件事件
     *
     * @param {*} controlname
     * @param {*} action
     * @param {*} data
     * @return {*} 
     * @memberof MobExpBarControlBase
     */
    public onCtrlEvent(controlname: any, action: any, data: any) {
        if (controlname && Object.is(controlname, this.xDataControlName)) {
            switch (action) {
                case "selectionchange":
                    this.onSelectionChange(data);
                    return;
                case "load":
                    this.onLoad(data, action);
                    return;
            }
        }
        super.onCtrlEvent(controlname, action, data);
    }

    /**
     * 绘制右侧导航组件
     * 
     * @memberof ExpBarControlBase
     */
    public renderNavView() {
        if (this.selection?.view && !Object.is(this.selection.view.viewname, '')) {
            let targetCtrlParam: any = {
                staticProps: {
                    viewDefaultUsage: 'INCLUDEDVIEW',
                    viewModelData: this.selection.viewModelData
                },
                dynamicProps: {
                    _viewparams: JSON.stringify(this.selection.viewparam),
                    _context: JSON.stringify(this.selection.context),
                }
            };
            return this.$createElement('app-view-shell', {
                class: "view-container2",
                props: targetCtrlParam,
            });
        }
    }
}
