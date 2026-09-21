import { MDViewEngine } from './md-view-engine';

/**
 * 实体分页搜索视图
 *
 * @export
 * @class TabSearchViewEngine
 * @extends {ViewEngine}
 */
export class TabSearchViewEngine extends MDViewEngine {

    /**
     * 分页导航面板
     *
     * @protected
     * @type {*}
     * @memberof TabSearchViewEngine
     */
    protected tabExpPanel: any;

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof TabSearchViewEngine
     */
    public init(options: any): void {
        this.tabExpPanel = options.tabexppanel;
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @memberof TabSearchViewEngine
     */
    public load(): void { }

    /**
     * 部件事件处理
     *
     * @param {string} ctrlName 部件标识
     * @param {string} eventName 事件标识
     * @param {*} args 事件参数
     * @memberof TabSearchViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (ctrlName === this.getTabExpPanel()?.name) {
            this.handleTabExpPanelEvents(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }

    /**
     * 处理分页导航面板事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof TabSearchViewEngine
     */
    public handleTabExpPanelEvents(eventName: string, args: any) { }

    /**
     * 搜索表单加载完成
     *
     * @param {*} [args={}]
     * @memberof TabSearchViewEngine
     */
    public onSearchFormLoad(args: any = {}): void {
        this.search(args);
    }

    /**
     * 搜索栏事件
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof TabSearchViewEngine
     */
    public searchBarEvent(eventName: string, args: any = {}): void {
        if (Object.is(eventName, 'search')) {
            this.search(args);
        }
    }

    /**
     * 搜索
     *
     * @param {*} args
     * @memberof TabSearchViewEngine
     */
    public search(args: any) {
        const params: any = {};
        //  搜索表单
        const searchForm = this.getSearchForm();
        if (searchForm && this.view.isExpandSearchForm) {
            Object.assign(params, searchForm.getData());
        }
        //  搜索栏
        const searchBar = this.getSearchBar();
        if (searchBar) {
            const data = searchBar.getData();
            if (data && data.filter) {
                Object.assign(params, { filter: data.filter });
            }
        }
        if (this.view && this.view.queryParams) {
            //  快速搜索栏
            if (this.view.queryParams.quickSearchValue && !this.view.isExpandSearchForm) {
                Object.assign(params, { query: this.view.queryParams.quickSearchValue });
            }
        }
        if (this.getTabExpPanel() && this.isLoadDefault) {
            const tag = this.getTabExpPanel().name;
            this.setViewState2({ tag: tag, action: 'search', viewdata: params });
        }
        this.isLoadDefault = true;
    }

    /**
     * 计算按钮状态
     *
     * @memberof TabSearchViewEngine
     */
    public computeToolbarState(state: boolean, data: any) {
        this.calcToolbarItemState(state);
        this.calcToolbarItemAuthState(data);
    }

    /**
     * 获取分页导航面板
     *
     * @return {*} 
     * @memberof TabSearchViewEngine
     */
    public getTabExpPanel() {
        return this.tabExpPanel;
    }

    /**
     * @description 视图销毁
     * @memberof TabSearchViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.tabExpPanel = null;
    }

}