import { MobMainViewInterface } from 'ibiz-core';
import { ViewBase } from './view-base';
import { IPSAppDEView } from '@ibiz/dynamic-model-api';

/**
 * 编辑视图基类
 *
 * @export
 * @class MainViewBase
 * @extends {ViewBase}
 */
export class MainViewBase extends ViewBase implements MobMainViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MainViewBase
     */
    public declare viewInstance: IPSAppDEView;

    /**
     * 渲染视图头部
     * 
     * @memberof MainViewBase
     */
    public renderViewHeader() {
        return [
            this.viewInstance.showCaptionBar ? <span class='caption-info'>{this.viewInstance.title}</span> : null
        ]
    }

    /**
     * 初始化导航栏标题
     *
     * @param {*} val
     * @param {boolean} isCreate
     * @returns
     * @memberof AppMobWizardPanelService
     */
    public initNavCaption(val?: any, isCreate?: boolean) {

    }

}
