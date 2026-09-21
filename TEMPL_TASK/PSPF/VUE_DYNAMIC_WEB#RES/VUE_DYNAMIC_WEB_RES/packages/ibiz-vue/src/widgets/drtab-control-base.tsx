import { IPSDEDRTab, IPSDEDRTabPage } from "@ibiz/dynamic-model-api";
import { DrtabControlInterface, Util } from "ibiz-core";
import { Subscription } from "rxjs";
import { MainControlBase } from "./main-control-base";

/**
 * 数据关系分页部件基类
 *
 * @export
 * @class DrtabControlBase
 * @extends {MainControlBase}
 */
export class DrtabControlBase extends MainControlBase implements DrtabControlInterface {

    /**
     * 数据关系分页部件实例对象
     *
     * @type {IPSDEDRTab}
     * @memberof DrtabControlBase
     */
    public declare controlInstance: IPSDEDRTab;

    /**
     * 数据关系分页部件数组
     *
     * @type {Array<any>}
     * @memberof DrtabControlBase
     */
    public drtabItems: any;

    /**
     * 是否显示插槽
     *
     * @type {boolean}
     * @memberof DrtabControlBase
     */
    public needFirstSelected: boolean = true;

    /**
     * 计数器数据
     *
     * @type {any}
     * @memberof DrtabControlBase
     */
    public counterData: any = null;

    /**
     * 选中关系项
     *
     * @protected
     * @type {*}
     * @memberof DrtabControlBase
     */
    protected selectItem: any;

    /**
     * @description 选中项
     * @type {*}
     * @memberof DrtabControlBase
     */
    public selectValue: any;

    /**
     * @description drtab部件事件
     * @type {(Subscription | undefined)}
     * @memberof DrtabControlBase
     */
    public drtabControlEvent: Subscription | undefined;
    
    /**
     * 监听静态参数变化
     *
     * @memberof DrtabControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.needFirstSelected = newVal.needFirstSelected === false ? false : true;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 初始化数据关系分页部件模型
     *
     * @type {*}
     * @memberof DrtabControlBase
     */
    public async ctrlModelInit() {
        await super.ctrlModelInit();
        this.initDrtabBasicData();
        this.initCounterData();
    }

    /**
     * 数据关系分页部件初始化
     *
     * @memberof DrtabControlBase
     */
    public ctrlInit(args?: any) {
        super.ctrlInit(args);
        if (this.viewState) {
            this.drtabControlEvent = this.viewState.subscribe(({ tag, action, data }: { tag: string, action: string, data: any }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('state', action)) {
                    this.handleDataChange(data);
                }
                if (Object.is('change', action)) {
                    this.handleChange(data);
                }
            });
        }
    }

    /**
     * 初始化默认选中
     *
     * @protected
     * @memberof DrtabControlBase
     */
    protected initDefaultSelect() {
        if (this.needFirstSelected && this.drtabItems && this.drtabItems.length > 0) {
            let selectItem = this.selectValue ? this.selectValue : this.drtabItems[0];
            this.handleTab(selectItem);
            this.ctrlEvent({ controlname: this.name, action: 'selectionchange', data: selectItem });
        }
    }

    /**
     * 初始化数据关系分页部件基础数据
     *
     * @memberof DrtabControlBase
     */
    public initDrtabBasicData() {
        const tabPages = this.controlInstance.getPSDEDRTabPages();
        if (tabPages && tabPages.length > 0) {
            this.drtabItems = [];
            tabPages.forEach((element: IPSDEDRTabPage) => {
                this.drtabItems.push(Object.assign(element, { disabled: true }));
            });
        }
    }

    /**
     * 初始化数据关系部件计数器数据
     *
     * @memberof DrtabControlBase
     */
    public initCounterData() {
        const counterRef = this.controlInstance.getPSAppCounterRef?.();
        if (counterRef) {
            const targetCounterService = Util.findElementByField(this.counterServiceArray, 'id', counterRef.id)?.service;
            this.counterData = targetCounterService?.counterData;
        }
    }

    /**
     * 选中项
     *
     * @param {string} tabPaneName 分页name
     * @memberof DrtabControlBase
     */
    public async drTabChange(tab: any, event: MouseEvent) {
        this.selectValue = tab;
        if (tab.disabled) {
            return;
        }
        this.handleCtrlEvents('onselectionchange', { action: '', navContext: this.context, navParam: this.viewparams, navData: this.navdatas, data: tab }).then((res: boolean) => {
            if (res) {
                this.handleTab(tab);
                this.ctrlEvent({ controlname: this.name, action: 'selectionchange', data: tab });
            }
        })
    }

    /**
     * 处理数据关系分页项
     *
     * @param {*} tab 数据关系分页项
     * @memberof DrtabControlBase
     */
    public handleTab(tab: any): void {
        const tempContext = Util.deepCopy(this.context);
        const tempViewParams = Util.deepCopy(this.viewparams);
        if (tab.getPSAppView?.()) {
            Object.assign(tempContext, { viewpath: tab.getPSAppView().modelPath });
        }
        Object.assign(tab, {
            srfnavdata: {
                context: Object.assign(tempContext, tab.localContext ? tab.localContext : {}),
                viewparams: Object.assign(tempViewParams, tab.localViewParam ? tab.localViewParam : {})
            }
        });
    }

    /**
     * 处理数据变更
     *
     * @param {any} args 表单数据
     * @memberof AppDrtabBase
     */
    public handleDataChange(args: any) {
        if (args && Object.is(args.srfuf, '1')) {
            this.drtabItems.forEach((drtabItem: any) => {
                // 取消禁用
                drtabItem.disabled = false;
                // 设置导航参数
                const navigateContexts = drtabItem.getPSNavigateContexts();
                if (navigateContexts && navigateContexts.length > 0) {
                    const localContext = Util.formatNavParam(navigateContexts);
                    let _context: any = Util.computedNavData(args, this.context, this.viewparams, localContext);
                    drtabItem.localContext = _context;
                }
                const navigateParams = drtabItem.getPSNavigateParams();
                if (navigateParams && navigateParams.length > 0) {
                    const localViewParam = Util.formatNavParam(navigateParams);
                    let _param: any = Util.computedNavData(args, this.context, this.viewparams, localViewParam);
                    drtabItem.localViewParam = _param;
                }
            })
        } else {
            this.drtabItems.forEach((drtabItem: any) => {
                drtabItem.disabled = true;
            })
        }
        if (args.srfparentkey) {
            Object.assign(this.context, { srfparentkey: args.srfparentkey })
            Object.assign(this.viewparams, { srfparentkey: args.srfparentkey })
        }
        if (args.srfparentdename) {
            Object.assign(this.context, { srfparentdename: args.srfparentdename })
            Object.assign(this.viewparams, { srfparentdename: args.srfparentdename })
        }
        //  需要默认选中时由选中刷新
        if (this.needFirstSelected) {
            this.initDefaultSelect();
        } else {
            this.$forceUpdate();
        }
    }

    /**
     * 处理关系项切换
     *
     * @protected
     * @param {*} data
     * @memberof DrtabControlBase
     */
    protected handleChange(data: any) {
        this.selectItem = data;
        this.$forceUpdate();
    }

    /**
     * @description 部件销毁
     * @memberof DrtabControlBase
     */
    public ctrlDestroyed() {
        super.ctrlDestroyed();
        if (this.drtabControlEvent) {
            this.drtabControlEvent.unsubscribe();
        }
    }
}
