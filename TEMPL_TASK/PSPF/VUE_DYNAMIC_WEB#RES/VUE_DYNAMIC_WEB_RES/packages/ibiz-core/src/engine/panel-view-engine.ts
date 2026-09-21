import { Util } from "../utils";
import { ViewEngine } from "./view-engine";

/**
 * 实体面板视图引擎
 *
 * @export
 * @class PanelViewEngine
 * @extends {ViewEngine}
 */
export class PanelViewEngine extends ViewEngine {

  /**
   * 面板部件
   *
   * @protected
   * @type {*}
   * @memberof PanelViewEngine
   */
  protected panel: any = null;

  /**
   * 引擎初始化
   *
   * @param {*} options
   * @memberof PanelViewEngine
   */
  public init(options: any) {
    this.panel = options.panel;
    super.init(options);
  }

  /**
   * 引擎加载
   *
   * @memberof PanelViewEngine
   */
  public load(data: any = {}) {
    const panel = this.getPanel();
    if (panel && this.isLoadDefault) {
      this.setViewState2({ tag: panel.name, action: 'load', viewdata: data });
    }
    this.isLoadDefault = false;
  }

    /**
     * 加载模型
     * 
     * @memberof PanelViewEngine
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
   * 刷新
   *
   * @param {*} [args]
   * @memberof PanelViewEngine
   */
  public refresh(args?: any) {
    const panel = this.getPanel();
    if (panel) {
      this.setViewState2({ tag: panel.name, action: 'refresh', viewdata: args });
    }
  }

  /**
   * 获取面板部件
   *
   * @return {*}  {*}
   * @memberof PanelViewEngine
   */
  public getPanel(): any {
    return this.panel;
  }

    /**
     * @description 视图销毁
     * @memberof PanelViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.panel = null;
    }
}