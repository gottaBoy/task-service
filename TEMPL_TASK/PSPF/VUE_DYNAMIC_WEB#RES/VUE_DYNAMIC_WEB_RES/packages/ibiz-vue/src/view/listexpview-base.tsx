import { IPSAppDEListExplorerView, IPSListExpBar } from '@ibiz/dynamic-model-api';
import { ListExpViewEngine, ListExpViewInterface, ModelTool } from 'ibiz-core';
import { ExpViewBase } from './expview-base';

/**
 * 列表导航视图基类
 *
 * @export
 * @class ListExpViewBase
 * @extends {ExpViewBase}
 * @implements {ListExpViewInterface}
 */
export class ListExpViewBase extends ExpViewBase implements ListExpViewInterface {

    /**
     * 视图实例
     * 
     * @memberof ListExpviewBase
     */
    public declare viewInstance: IPSAppDEListExplorerView;

    /**
     * 导航栏实例
     * 
     * @memberof ListExpviewBase
     */
    public declare expBarInstance: IPSListExpBar;

    /**
     * 视图引擎
     *
     * @public
     * @type {Engine}
     * @memberof ListExpviewBase
     */
    public declare engine: ListExpViewEngine;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof ListExpviewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let engineOpts = ({
            view: this,
            p2k: '0',
            listexpbar: (this.$refs[this.expBarInstance.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
        this.engine.init(engineOpts);
    }

    /**
     * 初始化分页导航视图实例
     * 
     * @memberof ListExpviewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDEListExplorerView;
        await super.viewModelInit();
        this.expBarInstance = ModelTool.findPSControlByType('LISTEXPBAR', this.viewInstance.getPSControls() || []) as IPSListExpBar;
    }
}