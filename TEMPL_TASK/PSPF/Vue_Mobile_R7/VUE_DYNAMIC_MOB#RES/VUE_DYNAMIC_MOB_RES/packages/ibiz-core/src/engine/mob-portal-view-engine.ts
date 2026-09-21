import { ViewEngine } from './view-engine';

/**
 * 实体数据看板视图界面引擎
 *
 * @export
 * @class PortalViewEngine
 * @extends {ViewEngine}
 */
export class MobPortalViewEngine extends ViewEngine {

    /**
     * 数据面板部件
     *
     * @type {*}
     * @memberof PortalViewEngine
     */
    public dashboard: any = null;

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
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof PortalViewEngine
     */
    public load(): void {
        super.load();
        const isLoad = this.isUseDefaultLoad ? this.isLoadDefault : false;
        if (this.getDashboard() && isLoad) {
            const tag = this.getDashboard().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: { ...this.view.viewparams } });
        } else {
            this.isLoadDefault = true;
        }
        this.loadModel();
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
    }

    /**
     * 加载数据
     * 
     * @memberof MobDashboardViewBase
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

}