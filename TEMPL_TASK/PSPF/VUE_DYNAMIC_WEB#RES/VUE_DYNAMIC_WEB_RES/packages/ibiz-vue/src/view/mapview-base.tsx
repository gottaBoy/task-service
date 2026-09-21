import { IPSAppDataEntity, IPSAppDEField, IPSAppDEMapView, IPSSysMap } from '@ibiz/dynamic-model-api';
import { MapViewInterface, ModelTool } from 'ibiz-core';
import { MDViewBase } from './mdview-base';

/**
 * 地图视图基类
 *
 * @export
 * @class MapViewBase
 * @extends {MDViewBase}
 * @implements {MapViewInterface}
 */
export class MapViewBase extends MDViewBase implements MapViewInterface{

    /**
     * 视图实例
     * 
     * @memberof MapViewBase
     */
    public declare viewInstance: IPSAppDEMapView;

    /**
     * 地图实例
     * 
     * @memberof MapViewBase
     */
    public mapInstance!: IPSSysMap;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof MapViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine && this.mapInstance) {
            let engineOpts = Object.assign({
                view: this,
                p2k: '0',
                isLoadDefault: (this.viewInstance as IPSAppDEMapView)?.loadDefault,
                keyPSDEField: (ModelTool.getContainerAppEntityCodeName(this.viewInstance) as string).toLowerCase(),
                majorPSDEField: (ModelTool.getAppEntityMajorField(this.viewInstance.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase(),
                opendata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.opendata(args, fullargs, params, $event, xData);
                },
                newdata: (args: any[], fullargs?: any[], params?: any, $event?: any, xData?: any) => {
                    this.newdata(args, fullargs, params, $event, xData);
                },
                map: (this.$refs[this.mapInstance.name] as any).ctrl,
            }, opts)
            if (this.searchFormInstance?.name && this.$refs[this.searchFormInstance.name]) {
                engineOpts.searchform = ((this.$refs[this.searchFormInstance.name] as any).ctrl);
            }
            if (this.quickSearchFormInstance?.name && this.$refs[this.quickSearchFormInstance.name]) {
                engineOpts.quicksearchform = ((this.$refs[this.quickSearchFormInstance.name] as any).ctrl);
            }
            if (this.searchBarInstance?.name && this.$refs[this.searchBarInstance.name]) {
                engineOpts.searchbar = ((this.$refs[this.searchBarInstance.name] as any).ctrl);
            }
            this.engine.init(engineOpts);
        }
    }
    
    /**
     * 初始化地图视图实例
     * 
     * @memberof MapViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps.modeldata) as IPSAppDEMapView;
        await super.viewModelInit();
        this.mapInstance = ModelTool.findPSControlByName('map', this.viewInstance.getPSControls()) as IPSSysMap;
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof MapViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.mapInstance);
        return this.$createElement(targetCtrlName, { slot: 'default', props: targetCtrlParam, ref: this.mapInstance?.name, on: targetCtrlEvent });
    }

}
