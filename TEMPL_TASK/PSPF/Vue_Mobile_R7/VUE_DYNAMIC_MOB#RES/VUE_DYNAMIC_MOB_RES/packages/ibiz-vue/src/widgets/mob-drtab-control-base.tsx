import { MainControlBase } from "./main-control-base";
import { IPSDEDRTab, IPSDEDRTabPage } from '@ibiz/dynamic-model-api';
import { MobDrtabControlInterface, Util } from "ibiz-core";

/**
 * 数据关系分页部件基类
 *
 * @export
 * @class MobDrtabControlBase
 * @extends {MainControlBase}
 */
export class MobDrtabControlBase extends MainControlBase implements MobDrtabControlInterface {

    /**
     * 部件模型实例对象
     *
     * @type {*}
     * @memberof MobDrtabControlBase
     */
    public declare controlInstance: IPSDEDRTab;

    /**
     * 选中关系项
     *
     * @protected
     * @type {*}
     * @memberof DrtabControlBase
     */
    protected selectItem: any;

    /**
     * 是否需要默认选择
     *
     * @type {boolean}
     * @memberof DrtabControlBase
     */
    public needFirstSelected: boolean = true;


    /**
     * 数据关系分页部件数组
     *
     * @type {Array<any>}
     * @memberof DrtabControlBase
     */
    public drtabItems: any;

    /**
    * 初始化数据关系分页部件模型
    *
    * @type {*}
    * @memberof DrtabControlBase
    */
    public async ctrlModelInit() {
        await super.ctrlModelInit();
        this.initDrtabBasicData();
    }

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
     * 数据关系分页部件初始化
     *
     * @memberof DrtabControlBase
     */
    public ctrlInit(args?: any) {
        super.ctrlInit(args);
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }: { tag: string, action: string, data: any }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('state', action)) {
                    this.handleFormChange(data);
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
            const data = this.handleTab(this.drtabItems[0]);
            this.ctrlEvent({ controlname: this.name, action: 'selectionchange', data: data });
        }
    }

    /**
     * 计算分页项样式
     *
     * @memberof MobDrtabControlBase
     */
    calcDrtabItemStyle() {
        const tabPages: any = this.controlInstance.getPSDEDRTabPages();
        return { width: (100 / tabPages?.length || 1) + '%' }
    }


    /**
     * 处理数据关系分页项
     *
     * @param {*} tab 数据关系分页项
     * @memberof DrtabControlBase
     */
    public handleTab(tab: any): any {
        const tempContext = Util.deepCopy(this.context);
        const tempViewParams = Util.deepCopy(this.viewparams);
        if (tab.getPSAppView?.()) {
            Object.assign(tempContext, { viewpath: tab.getPSAppView().modelPath });
        }
        const eventData = {};
        Object.assign(eventData, { name: tab.name }, {
            srfnavdata: {
                context: Object.assign(tempContext, tab.localContext ? tab.localContext : {}),
                viewparams: Object.assign(tempViewParams, tab.localViewParam ? tab.localViewParam : {})
            }
        });
        return eventData;
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
     * 处理表单数据变更
     *
     * @param {any} args 表单数据
     * @memberof AppDrtabBase
     */
    public handleFormChange(args: any) {
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
     * 选中节点
     *
     * @param {string} tabPaneName 分页name
     * @memberof MobDrtabControlBase
     */
    public tabPanelChange(tab: any): void {
        if (tab.disabled) {
            return;
        }
        this.handleCtrlEvents('onselectionchange', { data: tab }).then((res) => {
            if (res) {
                const data = this.handleTab(tab);
                this.onCtrlEvent(this.controlInstance.name, 'selectionchange', data)
            }
        })
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
}
