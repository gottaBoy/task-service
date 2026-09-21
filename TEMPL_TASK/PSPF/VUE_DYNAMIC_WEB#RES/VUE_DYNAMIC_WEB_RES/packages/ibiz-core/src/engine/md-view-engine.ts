import { ViewEngine } from './view-engine';

/**
 * 多数据引擎
 *
 * @export
 * @class MDViewEngine
 * @extends {ViewEngine}
 */
export class MDViewEngine extends ViewEngine {

    /**
     * 表格部件
     *
     * @type {*}
     * @memberof GridViewEngine
     */
    protected md: any;

    /**
     * 表单部件
     *
     * @type {*}
     * @memberof GridViewEngine
     */
    protected searchForm: any;

    /**
     * 快速搜索表单部件
     *
     * @protected
     * @type {*}
     * @memberof MDViewEngine
     */
    protected quickSearchForm: any;

    /**
     * 搜索栏部件
     *
     * @type {*}
     * @memberof GridViewEngine
     */
    protected searchBar: any;

    /**
     * 属性面板
     *
     * @protected
     * @type {*}
     * @memberof PickupGridViewEngine
     */
    protected propertypanel: any;

    /**
     * 打开数据
     *
     * @protected
     * @memberof MDViewEngine
     */
    protected openData?: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => void;

    /**
     * 新建数据
     *
     * @protected
     * @memberof GridViewEngine
     */
    protected newData?: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => void;

    /**
     * Creates an instance of GridViewEngine.
     * @memberof GridViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 引擎初始化
     *
     * @param {*} [options={}]
     * @memberof GridViewEngine
     */
    public init(options: any = {}): void {
        this.propertypanel = options.propertypanel;
        this.searchForm = options.searchform;
        this.quickSearchForm = options.quicksearchform;
        this.searchBar = options.searchbar;
        this.openData = options.opendata;
        this.newData = options.newdata;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof MDViewEngine
     */
    public load(opts: any = {}): void {
        super.load(opts);
        if (this.getSearchForm() && (this.isLoadDefault)) {
            const tag = this.getSearchForm().name;
            this.setViewState2({ tag: tag, action: 'loaddraft', viewdata: this.view.viewparams });
        } else if (this.getMDCtrl() && (this.isLoadDefault)) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: Object.assign(this.view.viewparams, opts) });
        } else {
            this.isLoadDefault = true;
        }
    }

    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof GridViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'searchform')) {
            this.searchFormEvent(eventName, args);
        }
        if (Object.is(ctrlName, 'quicksearchform')) {
            this.quickSearchFromEvent(eventName, args);
        }
        if (Object.is(ctrlName, 'searchbar')) {
            this.searchBarEvent(eventName, args);
        }
    }

    /**
     * 搜索表单事件
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof MDViewEngine
     */
    public searchFormEvent(eventName: string, args: any = {}): void {
        if (Object.is(eventName, 'load')) {
            this.onSearchFormLoad(args);
        }
        if (Object.is(eventName, 'search')) {
            this.onSearchFormLoad(args);
        }
    }

    /**
     * 搜索栏事件
     *
     * @param {string} eventName 事件名
     * @param {*} [args={}] 参数
     * @memberof MDViewEngine
     */
    public searchBarEvent(eventName: string, args: any = {}): void {
        if (Object.is(eventName, 'search')) {
            if (this.getMDCtrl() && this.isLoadDefault) {
                const tag = this.getMDCtrl().name;
                this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
            }
            this.isLoadDefault = true;
        }
    }

    /**
     * 快速搜索表单事件
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof MDViewEngine
     */
    public quickSearchFromEvent(eventName: string, args: any = {}): void {
        //  快速搜索表单值变更则触发搜索
        if (Object.is(eventName, 'valuechange')) {
            if (this.getMDCtrl() && this.isLoadDefault) {
                const tag = this.getMDCtrl().name;
                this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
            }
        }
    }

    /**
     * 多数据部件搜索
     *
     * @memberof MDViewEngine
     */
    public search(arg?: any) {
        if (this.getMDCtrl() && this.isLoadDefault) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        }
        this.isLoadDefault = true;
    }

    /**
     * 事件处理
     *
     * @param {string} eventName
     * @param {any[]} args
     * @memberof MDViewEngine
     */
    public MDCtrlEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'rowclick')) {
            this.doEdit(args);
        }
        if (Object.is(eventName, 'rowdblclick')) {
            this.doEdit(args);
        }
        if (Object.is(eventName, 'selectionchange')) {
            this.selectionChange(args);
        }
        if (Object.is(eventName, 'load')) {
            this.MDCtrlLoad(args);
        }
        if (Object.is(eventName, 'beforeload')) {
            this.MDCtrlBeforeLoad(args)
        }
        if (Object.is(eventName, 'remove')) {
            this.MDCtrlRemove(args)
        }
        if (Object.is(eventName, 'save')) {
            this.MDCtrlSave(args);
        }
    }

    /**
     * 搜索表单加载完成
     *
     * @param {*} [args={}]
     * @memberof MDViewEngine
     */
    public onSearchFormLoad(args: any = {}): void {
        if (this.getMDCtrl() && this.isLoadDefault) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        }
        this.isLoadDefault = true;
    }

    /**
     * 搜索表单搜索
     *
     * @param {*} [args={}]
     * @memberof MDViewEngine
     */
    public onSearchFormSearch(args: any = {}): void {
        if (this.getMDCtrl() && this.isLoadDefault) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        }
        this.isLoadDefault = true;
    }

    /**
     * 多数据项界面_开启行编辑操作
     *
     * @memberof MDViewEngine
     */
    public doOpenRowEdit(): void {
        if (this.getMDCtrl()) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'openEdit', viewdata: {} });
        }
    }

    /**
     * 多数据项界面_关闭行编辑操作
     *
     * @memberof MDViewEngine
     */
    public doCloseRowEdit(): void {
        if (this.getMDCtrl()) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'closeEdit', viewdata: {} });
        }
    }

    /**
     * 多数据项界面_提交编辑数据操作
     *
     * @memberof MDViewEngine
     */
    public doSaveEditRow(): void {
        if (this.getMDCtrl()) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'submitEidt', viewdata: {} });
        }
    }

    /**
     * 多数据项界面_编辑操作
     *
     * @param {*} [params={}]
     * @returns {void}
     * @memberof MDViewEngine
     */
    public doEdit(params: any = {}): void {
        // 获取要编辑的数据集合
        if (params && params.srfkey) {
            if (this.isFunc(this.getMDCtrl().findItem)) {
                params = this.getMDCtrl().findItem('srfkey', params.srfkey);
            }
            const arg = { data: params };
            this.onEditData(arg);
            return;
        }
        if (this.isFunc(this.getMDCtrl().getSelection)) {
            const selectedData = this.getMDCtrl().getSelection();
            if (selectedData == null || selectedData.length === 0) {
                return;
            }
            this.onEditData({ data: selectedData[0] });
        }
    }

    /**
     * 编辑数据
     *
     * @param {*} arg
     * @memberof MDViewEngine
     */
    public onEditData(arg: any): void {
        const loadParam: any = {};
        const otherParam: any = {};
        const { data }: { data: any } = arg;
        if (this.keyPSDEField && data[this.keyPSDEField] && !Object.is(data[this.keyPSDEField], '')) {
            Object.assign(loadParam, { [this.keyPSDEField]: data[this.keyPSDEField] });
        }
        if (this.view && this.view.quickGroupData) {
            Object.assign(otherParam, this.view.quickGroupData);
        }
        if (this.openData && this.isFunc(this.openData)) {
            this.openData([loadParam], [data], otherParam, null, this.getMDCtrl());
        }
    }

    /**
     * 多数据项界面_新建操作
     *
     * @param {*} [params={}]
     * @memberof MDViewEngine
     */
    public doNew(params: any = {}): void {
        this.onNewData();
    }

    /**
     * 新建数据
     *
     * @returns {void}
     * @memberof MDViewEngine
     */
    public onNewData(): void {

        let loadParam: any = {};
        Object.assign(loadParam, this.view.context);
        this.doNewDataNormal(loadParam);
    }

    /**
     * 常规新建数据
     *
     * @param {*} arg
     * @returns {*}
     * @memberof MDViewEngine
     */
    public doNewDataNormal(arg: any): any {
        return this.openDataView(arg);
    }

    /**
     * 多数据项界面_删除操作
     *
     * @memberof MDViewEngine
     */
    public doRemove(): void {
    }


    public openDataView(view: any = {}): boolean {

        if (this.newData && this.isFunc(this.newData)) {
            this.newData([], [], null, null, this.getMDCtrl());
        }

        return true;
    }

    /**
     * 选中变化
     *
     * @param {any[]} args
     * @memberof MDViewEngine
     */
    public selectionChange(args: any[]): void {
        if (this.view) {
            this.emitViewEvent("viewdataschange", args);
        }
        if (this.getPropertyPanel()) {
            const tag = this.getPropertyPanel().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: args[0] });
        }
        const state = args.length > 0 && !Object.is(args[0].srfkey, '') ? false : true;
        this.calcToolbarItemState(state);
        if (args && args.length > 0) {
            this.calcToolbarItemAuthState(this.transformData(args[0]));
        } else {
            this.calcToolbarItemAuthState(null);
        }
    }

    /**
     * 多数据部件加载完成
     *
     * @param {any[]} args
     * @memberof MDViewEngine
     */
    public MDCtrlLoad(args: any[]) {
        let cacheArray: Array<any> = [];
        if (args.length > 0) {
            args.forEach((item: any) => {
                cacheArray.push({ srfkey: item.srfkey, srfmajortext: item.srfmajortext });
            })
        }
        if (this.view) {
            this.view.viewCacheData = cacheArray;
            this.emitViewEvent("viewLoaded", args);
        }
        this.calcToolbarItemState(true);
        this.calcToolbarItemAuthState(null);
        this.executeToolBarItemLogic(args);
        this.setDataCtrlData(args);
    }

    /**
     * 多数据部件加载之前
     *
     * @param {*} [arg={}]
     * @memberof MDViewEngine
     */
    public MDCtrlBeforeLoad(arg: any = {}): void {
        if (this.view && this.view.viewparams && Object.keys(this.view.viewparams).length > 0) {
            Object.assign(arg, this.view.viewparams);
        }
        //  搜索表单
        const searchForm = this.getSearchForm();
        if (searchForm && this.view.isExpandSearchForm) {
            Object.assign(arg, searchForm.getData());
        }
        let otherQueryParam: any = {};
        //  搜索栏
        const searchBar = this.getSearchBar();
        if (searchBar && (this.view.isExpandSearchForm || this.view.viewProxyMode)) {
            const data = searchBar.getData();
            //  视图代理模式下
            if (this.view && this.view.viewProxyMode) {
                if (data && data.hasOwnProperty('quickSearchValue')) {
                    Object.assign(arg, { query: data.quickSearchValue });
                }
                if (data && data.quickGroupData) {
                    Object.assign(otherQueryParam, data.quickGroupData);
                }
            }
            if (data && data.filter) {
                Object.assign(arg, { filter: data.filter });
            }
        }
        if (this.view && this.view.queryParams) {
            //  快速搜索栏
            if (this.view.queryParams.hasOwnProperty('quickSearchValue') && !this.view.isExpandSearchForm) {
                Object.assign(arg, { query: this.view.queryParams.quickSearchValue });
            }
            //  快速分组
            if (this.view.queryParams.quickGroupData) {
                Object.assign(otherQueryParam, this.view.queryParams.quickGroupData);
            }
        }
        //  快速搜索表单
        const quickSearchForm = this.getQuickSearchForm();
        if (quickSearchForm) {
            Object.assign(otherQueryParam, quickSearchForm.getData());
        }
        // 自定义查询条件
        const mdCtrl: any = this.getMDCtrl();
        if (mdCtrl && mdCtrl.controlInstance && mdCtrl.controlInstance.customCond) {
            Object.assign(otherQueryParam, { srfdsscope: mdCtrl.controlInstance.customCond });
        }
        Object.assign(arg, { viewparams: otherQueryParam });
    }

    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof MDViewEngine
     */
    public getMDCtrl(): any {

    }

    /**
     * 获取搜索表单部件
     *
     * @returns {*}
     * @memberof MDViewEngine
     */
    public getSearchForm(): any {
        return this.searchForm;
    }

    /**
     * 获取快速搜索表单部件
     *
     * @return {*}  {*}
     * @memberof MDViewEngine
     */
    public getQuickSearchForm(): any {
        return this.quickSearchForm;
    }

    /**
     * 获取搜索栏部件
     *
     * @returns {*}
     * @memberof MDViewEngine
     */
    public getSearchBar() {
        return this.searchBar;
    }

    /**
     * 获取属性面板
     *
     * @returns
     * @memberof MDViewEngine
     */
    public getPropertyPanel() {
        return this.propertypanel;
    }

    /**
     * 转化数据
     *
     * @memberof EditViewEngine
     */
    public transformData(arg: any) {
        if (!this.getMDCtrl() || !(this.getMDCtrl().transformData instanceof Function)) {
            return null;
        }
        return this.getMDCtrl().transformData(arg);
    }

    /**
     * 多数据部件删除后
     *
     * @param {*} [arg={}]
     * @memberof MDViewEngine
     */
    public MDCtrlRemove(arg: any = {}): void {
        this.emitViewEvent("drdatasremove", arg);
    }

    /**
     * 多数据部件保存后
     *
     * @param {*} [arg={}]
     * @memberof MDViewEngine
     */
    public MDCtrlSave(arg: any = {}): void {
        this.emitViewEvent("drdatasaved", arg);
    }

    /**
     * @description 视图销毁
     * @memberof MDViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.propertypanel = null;
        this.searchBar = null;
        this.searchForm = null;
        this.quickSearchForm = null;
    }
}