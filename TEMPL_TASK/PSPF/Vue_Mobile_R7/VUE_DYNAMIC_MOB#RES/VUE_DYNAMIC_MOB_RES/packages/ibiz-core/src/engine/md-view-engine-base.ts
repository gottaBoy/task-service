import { ViewEngine } from './view-engine';

/**
 * 多数据引擎
 *
 * @export
 * @class MDViewEngineBase
 * @extends {ViewEngine}
 */
export class MDViewEngineBase extends ViewEngine {

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
     * @memberof MDViewEngineBase
     */
    protected openData?: (args: any[], contextJO: any, paramJO: any, $event?: any, xData?: any, container?: any, srfParentDeName?: string) => void;

    /**
     * 新建数据
     *
     * @protected
     * @memberof GridViewEngine
     */
    protected newData?: (args: any[], contextJO: any, paramJO: any, $event?: any, xData?: any, container?: any, srfParentDeName?: string) => void;

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
        this.view = options.view;
        this.propertypanel = options.propertypanel;
        this.searchForm = options.searchform;
        this.searchBar = options.searchBar;
        this.openData = options.opendata;
        this.newData = options.newdata;
        const quickGroup: any = this.view.$refs.quickGroup;
        const quickGroupValue = quickGroup?.getQuickGroupDefaultSelect();
        quickGroupValue && this.quickGroupValueChange(quickGroupValue); 
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof MDViewEngineBase
     */
    public load(opts: any = {}): void {
        super.load(opts);
        const isLoad = this.isUseDefaultLoad ? this.isLoadDefault : false;
        if (this.getSearchForm()) {
            const tag = this.getSearchForm().name;
            this.setViewState2({ tag: tag, action: 'loaddraft', viewdata: { ...this.view.viewparams } });
        } else if (this.getMDCtrl() && isLoad) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: { ...this.view.viewparams } });
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
     * @memberof MDViewEngineBase
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, this.searchForm?.name)) {
            this.searchFormEvent(eventName, args);
        }
        if (Object.is(ctrlName, this.searchBar?.name)) {
            this.searchBarEvent(eventName, args);
        }
    }


    /**
     * 视图事件
     *
     * @param {string} tag
     * @param {*} args
     * @memberof MDViewEngineBase
     */
    onViewEvent(tag: string, args: any) {
        switch (tag) {
            case 'quickValueChange':
                this.quickValueChange(args);
                break;
            case 'quickGroupValueChange':
                this.quickGroupValueChange(args);
                break;
            case 'oncategory':
                this.onCategory(args);
                break;
            case 'onsort':
                this.onSort(args);
                break;

            default:
                break;
        }
    }

    /**
     * 分类搜索
     *
     * @param {*} value
     * @memberof MDViewBase
     */
    public onCategory(value: any) {
        Object.assign(this.view.queryParams.categoryValue, value);
        this.setViewState2({ tag: this.getMDCtrl().name, action: 'refresh', viewdata: this.view.categoryValue });
    }

    /**
     * 排序
     *
     * @param {*} field
     * @memberof MDViewBase
     */
    public onSort(field: any) {
        if (this.view.sortParam.sortCache.desc == field) {
            this.view.sortParam.sortCache.desc = "";
            this.view.queryParams.sortValue = {};
            this.setViewState2({ tag: this.getMDCtrl().name, action: 'refresh', viewdata: this.view.queryParams.sortValue });
            this.view.hasColor = false;
            return
        }
        if (this.view.sortParam.sortCache.asc == field) {
            this.view.sortParam.sortCache.asc = "";
            this.view.sortParam.sortCache.desc = field;
            this.view.queryParams.sortValue = { sort: field + ",desc" };
            this.setViewState2({ tag: this.getMDCtrl().name, action: 'refresh', viewdata: this.view.queryParams.sortValue });
            this.view.hasColor = true;
        } else {
            this.view.sortParam.sortCache.asc = field;
            this.view.sortParam.sortCache.desc = "";
            this.view.queryParams.sortValue = { sort: field + ",asc" };
            this.setViewState2({ tag: this.getMDCtrl().name, action: 'refresh', viewdata: this.view.queryParams.sortValue });
            this.view.hasColor = true;
        }
    }

    /**
     * 快速分组值变化
     *
     * @memberof MDViewBase
     */
    public quickGroupValueChange($event: any) {
        if (!this.view) {
            return;
        }
        if ($event) {
            this.view.queryParams.quickGroupData = $event.data;
            if (this.view.quickGroupParam.isEmitQuickGroupValue) {
                this.setViewState2({ tag: this.getMDCtrl().name, action: 'refresh', viewdata: $event.data });
            }
        }
        this.view.quickGroupParam.isEmitQuickGroupValue = true;
    }

    /**
     * 快速搜索值变化
     *
     * @param {*} event
     * @returns
     * @memberof MDViewBase
     */
    public async quickValueChange(event: any) {
        let { detail } = event;
        if (!detail) {
            return;
        }
        let { value } = detail;
        this.view.queryParams.query = value;
        this.setViewState2({ tag: this.getMDCtrl().name, action: 'quicksearch', viewdata: this.view.queryParams.query });
    }


    /**
     * 搜索栏搜索
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof MDViewEngineBase
     */
    searchBarEvent(eventName: string, args: any = {}) {
        if (Object.is(eventName, 'search')) {
            this.onMDCtrlSearch(args);
        }
    }

    /**
     * 搜索表单事件
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof MDViewEngineBase
     */
    public searchFormEvent(eventName: string, args: any = {}): void {
        if (Object.is(eventName, 'load')) {
            this.onSearchFormLoad(args);
        }
        if (Object.is(eventName, 'search')) {
            this.onMDCtrlSearch(args);
        }
    }

    /**
     * 事件处理
     *
     * @param {string} eventName
     * @param {any[]} args
     * @memberof MDViewEngineBase
     */
    public MDCtrlEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'rowclick')) {
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
        if (Object.is(eventName, 'save')) {
            this.emitViewEvent("drdatasaved", args);
        }
    }

    /**
     * 搜索表单加载完成
     *
     * @param {*} [args={}]
     * @memberof MDViewEngineBase
     */
    public onSearchFormLoad(args: any = {}): void {
        if (this.getMDCtrl() && this.isLoadDefault) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: { ...this.view.viewparams } });
        }
        this.isLoadDefault = true;
    }


    /**
     * 多数据部件搜索
     *
     * @param {*} [args={}]
     * @memberof MDViewEngineBase
     */
    public onMDCtrlSearch(args: any = {}): void {
        if (this.getMDCtrl()) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'search', viewdata: args });
        }
    }

    /**
     * 处理实体界面行为
     *
     * @param {string} tag
     * @param {string} [actionmode]
     * @returns {void}
     * @memberof MDViewEngineBase
     */
    public doSysUIAction(tag: string, actionmode?: string): void {
        if (Object.is(tag, 'Edit')) {
            this.doEdit();
            return;
        }
        if (Object.is(tag, 'Remove')) {
            this.doRemove();
            return;
        }
        if (Object.is(tag, 'SaveRow')) {
            this.doSaveEditRow();
            return;
        }
        if (Object.is(tag, 'New')) {
            this.doNew();
            return;
        }
        if (Object.is(tag, 'OpenRowEdit')) {
            this.doOpenRowEdit();
            return;
        }
        if (Object.is(tag, 'CloseRowEdit')) {
            this.doCloseRowEdit();
            return;
        }
        super.doSysUIAction(tag, actionmode);
    }

    /**
     * 多数据项界面_开启行编辑操作
     *
     * @memberof MDViewEngineBase
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
     * @memberof MDViewEngineBase
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
     * @memberof MDViewEngineBase
     */
    public doSaveEditRow(): void {
        if (this.getMDCtrl()) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'submitEidt', viewdata: {} });
        }
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
     * 多数据项界面_编辑操作
     *
     * @param {*} [params={}]
     * @returns {void}
     * @memberof MDViewEngineBase
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
     * @memberof MDViewEngineBase
     */
    public onEditData(arg: any): void {
        const loadParam: any = {};
        const otherParam: any = {};
        const { data }: { data: any } = arg;
        if (this.keyPSDEField && data[this.keyPSDEField] && !Object.is(data[this.keyPSDEField], '')) {
            Object.assign(loadParam, { [this.keyPSDEField]: data[this.keyPSDEField] });
        }
        if (this.view && this.view.viewparams) {
            Object.assign(otherParam, this.view.viewparams);
        }
        if (this.openData && this.isFunc(this.openData)) {
            this.openData([loadParam], [data], otherParam, null, this.getMDCtrl());
        }
    }

    /**
     * 多数据项界面_新建操作
     *
     * @param {*} [params={}]
     * @memberof MDViewEngineBase
     */
    public doNew(params: any = {}): void {
        this.onNewData();
    }

    /**
     * 新建数据
     *
     * @returns {void}
     * @memberof MDViewEngineBase
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
     * @memberof MDViewEngineBase
     */
    public doNewDataNormal(arg: any): any {
        return this.openDataView(arg);
    }

    /**
     * 多数据项界面_删除操作
     *
     * @memberof MDViewEngineBase
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
     * @memberof MDViewEngineBase
     */
    public selectionChange(args: any[]): void {
        if (this.view) {
            this.emitViewEvent('viewdataschange', args);
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
     * @memberof MDViewEngineBase
     */
    public MDCtrlLoad(args: any[]) {
        if(!this.view){
            return;
        }
        let cacheArray: Array<any> = [];
        if (args.length > 0) {
            args.forEach((item: any) => {
                cacheArray.push({ srfkey: item.srfkey, srfmajortext: item.srfmajortext });
            })
        }
        this.view.viewCacheData = cacheArray;
        if (this.view) {
            this.emitViewEvent("viewLoaded", args);
        }
        this.calcToolbarItemState(true);
        this.calcToolbarItemAuthState(null);
    }

    /**
     * 多数据部件加载之前
     *
     * @param {*} [arg={}]
     * @memberof MDViewEngineBase
     */
    public MDCtrlBeforeLoad(arg: any = {}): void {
        if(!this.view)return;
        if (this.view.viewparams && Object.keys(this.view.viewparams).length > 0) {
            Object.assign(arg, this.view.viewparams);
        }
        if (this.getSearchForm()) {
            Object.assign(arg, this.getSearchForm().getData());
        }
        let otherQueryParam: any = {};
        const searchBar = this.getSearchBar();
        if (searchBar) {
            const data = searchBar.getData();
            //  视图代理模式下
            if (this.view && this.view.viewProxyMode) {
                if (data && data.quickSearchValue) {
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
            if (this.view.queryParams.quickSearchValue && !this.view.isExpandSearchForm) {
                Object.assign(arg, { query: this.view.queryParams.quickSearchValue });
            }
            //  快速分组
            if (this.view.queryParams.quickGroupData) {
                Object.assign(otherQueryParam, this.view.queryParams.quickGroupData);
            }
            // 分类参数
            if (this.view && this.view.queryParams.categoryValue) {
                Object.assign(otherQueryParam, this.view.queryParams.categoryValue);
            }
            // 排序参数
            if (this.view && this.view.queryParams.sortValue) {
                Object.assign(otherQueryParam, this.view.queryParams.sortValue);
            }
        }
        Object.assign(arg, { viewparams: otherQueryParam });
    }

    /**
     * 获取多数据部件
     *
     * @returns {*}
     * @memberof MDViewEngineBase
     */
    public getMDCtrl(): any {

    }

    public getSearchForm(): any {
        return this.searchForm;
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
     * @memberof MDViewEngineBase
     */
    public getPropertyPanel() {
        return this.propertypanel;
    }

}