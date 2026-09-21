import { MDViewEngine } from './md-view-engine';

/**
 * 实体树视图界面引擎
 *
 * @export
 * @class TreeViewEngine
 * @extends {ViewEngine}
 */
export class TreeViewEngine extends MDViewEngine {

    /**
     * 树部件对象
     *
     * @type {*}
     * @memberof TreeViewEngine
     */
    public tree: any;

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof PickupViewEngine
     */
    public init(options: any): void {
        this.tree = options.tree;
        super.init(options);
    }

    /**
     * 树搜索
     *
     * @param {*} [arg]
     * @memberof TreeViewEngine
     */
    public search(arg?: any) {
        if (this.getMDCtrl()) {
            const tag = this.getMDCtrl().name;
            this.setViewState2({ tag: tag, action: 'filter', viewdata: arg });
        }
    }

    /**
     * 搜索栏事件
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof TreeViewEngine
     */
    public searchBarEvent(eventName: string, args: any = {}): void {
        if (Object.is(eventName, 'search')) {
           this.search({ srfnodefilter: args?.quickSearchValue });
        }
    }
    
    /**
     * 部件事件
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof TreeViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'tree')) {
            this.MDCtrlEvent(eventName, args);
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }

    /**
     * @description 多数据部件加载之前
     * @param {*} [arg={}]
     * @memberof TreeViewEngine
     */
    public MDCtrlBeforeLoad(arg: any = {}): void {
      if (this.view && this.view.viewparams && Object.keys(this.view.viewparams).length > 0) {
          Object.assign(arg, this.view.viewparams);
      }
      let isSearch = false;
      //  搜索表单
      const searchForm = this.getSearchForm();
      if (searchForm && this.view.isExpandSearchForm) {
          const data = searchForm.getData();
          Object.keys(data)?.forEach((key: string) => {
            if (data[key]) {
              isSearch = true;
            }
          })
          Object.assign(arg, data);
      }
      let otherQueryParam: any = {};
      //  搜索栏
      const searchBar = this.getSearchBar();
      if (searchBar && (this.view.isExpandSearchForm || this.view.viewProxyMode)) {
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
      if (arg.query || arg.filter || otherQueryParam.length > 0) {
        isSearch = true;
      }
      Object.assign(arg, { viewparams: otherQueryParam , isSearch });
    }

    /**
     * 
     *获取树视图部件
     * @returns {*}
     * @memberof TreeViewEngine
     */
    public getMDCtrl(): any {
        return this.tree;
    }

    /**
     * @description 视图销毁
     * @memberof TreeViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.tree = null;
    }
}