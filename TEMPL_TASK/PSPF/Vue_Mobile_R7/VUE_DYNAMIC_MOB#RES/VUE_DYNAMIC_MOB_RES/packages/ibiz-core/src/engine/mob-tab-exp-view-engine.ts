import { ViewEngine } from './view-engine';

/**
 * 实体移动端分页导航视图界面引擎
 *
 * @export
 * @class MobTabExpViewEngine
 * @extends {ViewEngine}
 */
export class MobTabExpViewEngine extends ViewEngine {

    /**
     * Creates an instance of MobTabExpViewEngine.
     * 
     * 
     * @memberof MobTabExpViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof MobTabExpViewEngine
     */
    public init(options: any): void {
        super.init(options);
    }

    /**
     * 引擎加载
     *
     * @memberof MobTabExpViewEngine
     */
    public load(): void {
        super.load();
        this.loadModel();
    }

    /**
     * 加载模型
     * 
     * @memberof MobTabExpViewBase
     */
    public loadModel() {
        const _this = this.view;
        if (_this.context[_this.appDeCodeName?.toLowerCase() as string]) {
            _this.appEntityService.getDataInfo(JSON.parse(JSON.stringify(_this.context)), {}, false).then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                const { data: _data } = response;
                if (_data.srfopprivs) {
                    _this.$store.commit('authresource/setSrfappdeData', { key: `${_this.deName}-${_data[_this.appDeKeyFieldName.toLowerCase()]}`, value: _data.srfopprivs });
                }
                if (_data[_this.appDeMajorFieldName.toLowerCase()]) {
                    _this.model.dataInfo = _data[_this.appDeMajorFieldName.toLowerCase()];
                    if (_this.$route) {
                        _this.$route.meta.info = _this.model.dataInfo;
                    }
                }
                _this.initNavCaption();
            })
        }
    }

}