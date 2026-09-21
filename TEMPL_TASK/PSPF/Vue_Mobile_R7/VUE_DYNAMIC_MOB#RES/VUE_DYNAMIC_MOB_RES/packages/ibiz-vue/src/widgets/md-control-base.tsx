import { CodeListService, MobMDControlInterface, Util } from 'ibiz-core'
import { MainControlBase } from './main-control-base';
import { DataServiceHelp } from 'ibiz-core';


/**
 * 多数据部件基类
 *
 * @export
 * @class MDControlBase
 * @extends {MainControlBase}
 */
export class MDControlBase extends MainControlBase implements MobMDControlInterface {
    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof MDControlBase
     */
    public codeListService!: CodeListService;

    /**
     * 选中行数据
     *
     * @type {any[]}
     * @memberof MDControlBase
     */
    public selections: any[] = [];


    /**
     * 是否正在加载中
     *
     * @type {boolean}
     * @memberof MobMDCtrlControlBase
     */
     public isLoadding: boolean = false;

    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public updateAction?: string;

    /**
     * 部件行为--fetch
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public fetchAction?: string;

    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public removeAction?: string;

    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public loadAction?: string;

    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public loaddraftAction?: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public createAction?: string;

    /**
     * 数据映射（数据项名称和UI名称的映射）
     * 
     * @memberof MDControlBase
     */
    public dataMap: Map<string, any> = new Map();

    /**
     * 当前页
     *
     * @type {number}
     * @memberof MDControlBase
     */
    public curPage: number = 0;

    /**
     * 数据
     *
     * @type {any[]}
     * @memberof MDControlBase
     */
    public items: any[] = [];

    /**
     * 是否支持分页
     *
     * @type {boolean}
     * @memberof MDControlBase
     */
    public isEnablePagingBar: boolean = true;

    /**
     * 是否禁用排序
     *
     * @type {boolean}
     * @memberof MDControlBase
     */
    public isNoSort: boolean = false;

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public minorSortDir: string = '';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof MDControlBase
     */
    public minorSortPSDEF: string = '';

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof MDControlBase
     */
    public limit: number = 20;

    /**
     * 总条数
     *
     * @type {number}
     * @memberof MDControlBase
     */
    public totalRecord: number = 0;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof GridControlBase
     */
    public isSingleSelect?: boolean;

    /**
     * 是否默认选中第一条数据
     *
     * @type {boolean}
     * @memberof MDControlBase
     */
    public isSelectFirstDefault: boolean = false;

    /**
     * 启用下拉刷新
     *
     * @type {boolean}
     * @memberof MDControlBase
     */
    public enablePullDownRefresh: boolean = true;

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ListControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            this.isSingleSelect = newVal.isSingleSelect !== false;
            this.isSelectFirstDefault = newVal.isSelectFirstDefault === true;
            this.enablePullDownRefresh = newVal.enablePullDownRefresh === true;
            super.onStaticPropsChange(newVal, oldVal);
        }
    }

    /**
     * 部件模型数据初始化
     *
     * @memberof MEditViewPanelControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        if (this.controlInstance.appDataEntity && !(this.Environment?.isPreviewMode)) {
            this.appEntityService = await DataServiceHelp.getInstance().getService(this.controlInstance?.getPSAppDataEntity(), { context: this.context });
        }
        this.limit = this.controlInstance?.pagingSize ? this.controlInstance.pagingSize : 20;
        this.minorSortDir = this.controlInstance?.minorSortDir ? this.controlInstance.minorSortDir : "";
        this.minorSortPSDEF = this.controlInstance?.getMinorSortPSAppDEField?.()?.codeName?.toLowerCase() || '';
        this.loaddraftAction = this.controlInstance?.getGetDraftPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "GetDraft";
        this.loadAction = this.controlInstance?.getGetPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "Get";
        this.removeAction = this.controlInstance?.getRemovePSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "Remove";
        this.updateAction = this.controlInstance?.getUpdatePSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "Update";
        this.fetchAction = this.controlInstance?.getFetchPSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "FetchDefault";
        this.createAction = this.controlInstance?.getCreatePSControlAction?.()?.getPSAppDEMethod?.()?.codeName || "Create";
        this.initDataMap();
    }

    /**
     * 多数据部件初始化
     *
     * @memberof MDControlBase
     */
    public ctrlInit() {
        super.ctrlInit();
        let _this: any = this;
        this.codeListService = new CodeListService({ $store: _this.$store });
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof MDControlBase
     */
    public ctrlDestroyed() {
        super.ctrlDestroyed();
        if (this.appStateEvent) {
            this.appStateEvent.unsubscribe();
        }
    }

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof MDControlBase
     */
    public getDatas(): any[] {
        return this.selections;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof MDControlBase
     */
    public getData(): any {
        return this.selections[0];
    }


    /**
     * 初始化数据映射
     * 
     * @memberof MDControlBase
     */
    public initDataMap() { }

}
