import { ViewEngine } from './view-engine';
import { Util } from '../utils';

/**
 * 实体数据看板视图界面引擎
 *
 * @export
 * @class PortalViewEngine
 * @extends {ViewEngine}
 */
export class PortalViewEngine extends ViewEngine {

    /**
     * 数据面板部件
     *
     * @type {*}
     * @memberof PortalViewEngine
     */
    public dashboard: any = null;

    /**
     * 搜索表单
     *
     * @type {*}
     * @memberof PortalViewEngine
     */
    public searchform: any = null;

    /**
     * Creates an instance of PortalViewEngine.
     * 
     * @memberof PortalViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof PortalViewEngine
     */
    public init(options: any): void {
        this.dashboard = options.dashboard;
        this.searchform = options.searchform;
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof PortalViewEngine
     */
    public load(): void {
        super.load();
        if (this.getSearchForm() && this.isLoadDefault) {
            const tag = this.getSearchForm().name;
            this.setViewState2({ tag: tag, action: 'loaddraft', viewdata: this.view.viewparams });
        }
        if (this.getDashboard() && this.isLoadDefault) {
            const tag = this.getDashboard().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: { isSearchMode: this.getSearchForm() ? true : false } });
        }
    }

    /**
     * @description 加载数据
     * @memberof PortalViewEngine
     */
    public loadModel() {
        const _this: any = this.view;
        if (_this.context && _this.context[_this.appDeCodeName.toLowerCase()]) {
            let tempContext: any = Util.deepCopy(_this.context);
            if (tempContext && tempContext.srfsessionid) {
                tempContext.srfsessionkey = tempContext.srfsessionid;
                delete tempContext.srfsessionid;
            }
            _this.appEntityService?.getViewData?.(tempContext, {}, false).then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                const { data: _data } = response;
                if(_this.viewCtx && _this.viewCtx.view){
                    _this.viewCtx['viewGlobal']['srfactiveviewdata'] = _data;
                    // 当前视图为顶层视图
                    if(_this.viewCtx.topview && Object.is(_this.viewCtx.view._uid,_this.viewCtx.topview._uid)){
                        _this.$store.commit('addRouteViewGlobal', { tag: _this.context.srfsessionid, param: { srfactiveviewdata: _data } });
                    }
                    if(_this.forceRefresh && _this.forceRefresh instanceof Function){
                        _this.forceRefresh();
                    }
                }
                if (_data.srfopprivs) {
                    _this.$store.commit('authresource/setSrfappdeData', { key: `${_this.deName}-${_data[_this.appDeKeyFieldName.toLowerCase()]}`, value: _data.srfopprivs });
                }
                _this.viewState.next({ tag: 'all-portlet', action: 'loadmodel', data: _data });
                if (_data[_this.appDeMajorFieldName.toLowerCase()]) {
                    _this.model.dataInfo = _data[_this.appDeMajorFieldName.toLowerCase()];
                    if (_this.$tabPageExp) {
                        _this.$tabPageExp.setCurPageCaption({
                            caption: _this.model.srfCaption,
                            title: _this.model.srfCaption,
                            info: _this.model.dataInfo,
                            viewtag: _this.viewtag,
                            cacheRoutePath: _this.cacheRoutePath
                        });
                    }
                    if (_this.$route) {
                        _this.$route.meta.info = _this.model.dataInfo;
                    }
                }
            })
        }
    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof PortalViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        super.onCtrlEvent(ctrlName, eventName, args);
        if (Object.is(ctrlName, 'dashboard')) {
            this.DashboardEvent(eventName, args);
        }
        if (Object.is(ctrlName, 'searchform')) {
            this.searchFormEvent(eventName, args);
        }
    }

    /**
     * 搜索表单事件
     *
     * @param {string} eventName
     * @param {*} [args={}]
     * @memberof PortalViewEngine
     */
    public searchFormEvent(eventName: string, args: any = {}): void {
        delete args.srfuf;
        if (Object.is(eventName, 'load')) {
            this.onSearchFormLoad(args);
        }
        if (Object.is(eventName, 'search')) {
            this.onSearchFormLoad(args);
        }
    }

    /**
     * 搜索表单加载完成
     *
     * @param {*} [args={}]
     * @memberof PortalViewEngine
     */
    public onSearchFormLoad(args: any = {}): void {
        const searchParam = Object.assign(this.view.viewparams, args);
        if (this.getDashboard() && this.isLoadDefault) {
            const tag = this.getDashboard().name;
            this.setViewState2({ tag: tag, action: 'loaddata', viewdata: searchParam });
        }
        this.isLoadDefault = true;
    }

    /**
     * 搜索表单搜索
     *
     * @param {*} [args={}]
     * @memberof PortalViewEngine
     */
    public onSearchFormSearch(args: any = {}): void {
        const searchParam = Object.assign(this.view.viewparams, args);
        if (this.getDashboard() && this.isLoadDefault) {
            const tag = this.getDashboard().name;
            this.setViewState2({ tag: tag, action: 'loaddata', viewdata: searchParam });
        }
        this.isLoadDefault = true;
    }

    /**
     * 实体数据看板事件
     *
     * @param {string} eventName
     * @param {*} args
     * @memberof PortalViewEngine
     */
    public DashboardEvent(eventName: string, args: any): void {
        if (Object.is(eventName, 'load')) {
            this.emitViewEvent('viewLoaded', args);
        }
        if (Object.is(eventName, 'refreshAll')) {
            this.loadModel();
        }
    }

    /**
     * 获取部件对象
     *
     * @returns {*}
     * @memberof PortalViewEngine
     */
    public getDashboard(): any {
        return this.dashboard;
    }

    /**
     * 获取搜索表单对象
     *
     * @returns {*}
     * @memberof PortalViewEngine
     */
    public getSearchForm(): any {
        return this.searchform;
    }

    /**
     * @description 视图销毁
     * @memberof PortalViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.dashboard = null;
        this.searchform = null;
    }

}