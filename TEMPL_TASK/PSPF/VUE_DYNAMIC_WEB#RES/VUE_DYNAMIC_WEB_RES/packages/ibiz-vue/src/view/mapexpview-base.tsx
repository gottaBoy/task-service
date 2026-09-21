import { IPSAppDEMapExplorerView, IPSMapExpBar } from '@ibiz/dynamic-model-api';
import { MapExpViewInterface, ModelTool, MapExpViewEngine } from 'ibiz-core';
import { ExpViewBase } from './expview-base';


/**
 * 地图导航视图基类
 *
 * @export
 * @class MapExpViewBase
 * @extends {ExpViewBase}
 * @implements {MapExpViewInterface}
 */
export class MapExpViewBase extends ExpViewBase implements MapExpViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MapExpViewBase
     */
    public declare viewInstance: IPSAppDEMapExplorerView;

    /**
     * 导航栏实例
     * 
     * @memberof MapExpViewBase
     */
    public declare expBarInstance: IPSMapExpBar;

    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof MapExpViewBase
     */
    public declare engine: MapExpViewEngine;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MapExpViewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let engineOpts = ({
            view: this,
            p2k: '0',
            mapexpbar: (this.$refs[this.expBarInstance.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
        this.engine.init(engineOpts);
    }

    /**
     * 初始化地图导航视图实例
     * 
     * @memberof MapExpViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDEMapExplorerView;
        await super.viewModelInit();
        this.expBarInstance = ModelTool.findPSControlByType('MAPEXPBAR', this.viewInstance.getPSControls() || []) as IPSMapExpBar;
    }

    /**
     * 处理占位比例变化
     *
     * @protected
     * @memberof MapExpViewBase
     */
    protected handleSplitChange() {
        if (this.split) {
            this.$store.commit("setViewSplit", { viewUID: `${this.viewInstance?.codeName}_${this.expBarInstance?.codeName}`, viewSplit: this.split });
            if (this.viewState && this.expBarInstance) {
                this.viewState.next({ tag: this.expBarInstance.name, action: 'updateSize', data: null });
            }
        }
    }

}