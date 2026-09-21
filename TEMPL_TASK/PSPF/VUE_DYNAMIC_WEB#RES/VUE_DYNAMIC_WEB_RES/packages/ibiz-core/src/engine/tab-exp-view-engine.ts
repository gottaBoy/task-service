import { ViewEngine } from './view-engine';
import { Util } from '../utils';

/**
 * 实体选择视图
 *
 * @export
 * @class TabExpViewEngine
 * @extends {ViewEngine}
 */
export class TabExpViewEngine extends ViewEngine {

    /**
     * 分页导航面板实例
     * 
     * @memberof TabExpviewBase
     */
     public tabExpPanel: any;

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof TabExpViewEngine
     */
    public init(options: any): void {
        this.tabExpPanel = options.tabexppanel;
        super.init(options);
    }

    /**
     * @description 获取分页导航面板实例
     * @return {*}  {*}
     * @memberof TabExpViewEngine
     */
    getTabExpPanelInstance(): any {
        return this.tabExpPanel;
    }


    /**
     * 引擎加载
     *
     * @memberof TabExpViewEngine
     */
    public load(): void {
        super.load();
        if(this.getTabExpPanelInstance()){
            const tag: any = this.getTabExpPanelInstance().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.context });
        }
    }

    /**
     * 加载模型
     * 
     * @memberof TabExpViewEngine
     */
    public loadModel() {
        const _this = this.view;
        if (_this.context[_this.appDeCodeName.toLowerCase()]) {
            let tempContext: any = Util.deepCopy(_this.context);
            if (tempContext && tempContext.srfsessionid) {
                tempContext.srfsessionkey = tempContext.srfsessionid;
                delete tempContext.srfsessionid;
            }
            _this.appEntityService?.getViewData(tempContext, {}, false).then((response: any) => {
                if (!response || response.status !== 200) {
                    _this.$throw(`${response.data?.message ? response.data.message : '发生未知错误！'}`)
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
                if(_data.srfopprivs){
                    _this.$store.commit('authresource/setSrfappdeData', { key: `${_this.deName}-${_data[_this.appDeKeyFieldName.toLowerCase()]}`, value: _data.srfopprivs });
                }
                _this.engine.computeToolbarState(false, _data);
                _this.viewState.next({ tag: 'tabexppanel', action: 'loadmodel', data: _data });
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
     * 计算按钮状态
     *
     * @memberof TabExpViewEngine
     */
    public computeToolbarState(state:boolean,data:any){
        this.calcToolbarItemState(state);
        this.calcToolbarItemAuthState(data);
    }

    /**
     * @description 视图销毁
     * @memberof TabExpViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.tabExpPanel = null;
    }
}