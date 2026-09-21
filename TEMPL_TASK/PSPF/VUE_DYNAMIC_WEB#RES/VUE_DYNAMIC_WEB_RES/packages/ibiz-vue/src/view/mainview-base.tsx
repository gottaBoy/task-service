import { MainViewInterface } from 'ibiz-core';
import { ViewBase } from './view-base';
import { IPSAppDataEntity, IPSAppDEView } from '@ibiz/dynamic-model-api';

/**
 * 主数据视图基类
 *
 * @export
 * @class MainViewBase
 * @extends {ViewBase}
 * @implements {MainViewInterface}
 */
export class MainViewBase extends ViewBase implements MainViewInterface {

    /**
     * 视图实例
     *
     * @memberof MainViewBase
     */
    public declare viewInstance: any;

    /**
     * 视图初始化
     *
     * @memberof MainViewBase
     */
    public viewInit() {
        super.viewInit();
        this.opendata = this.opendata.bind(this);
        this.newdata = this.newdata.bind(this);
    }

    /**
     * @description 视图销毁
     * @memberof MainViewBase
     */
    public viewDestroyed() {
        super.viewDestroyed();
        if (this.engine) {
            this.engine.destroyed();
        }
    }

    /**
     * 处理指定视图控制关系将父键转为父实体上下文
     *
     * @memberof MainViewBase
     */
    public async handleviewRes() {
        if ((this.viewInstance as IPSAppDEView)?.getParentPSAppDataEntity?.()) {
            // 先从导航上下文取数，没有再从导航参数（URL）取数，如果导航上下文和导航参数都没有则为null
            const parentEntityCodeName = ((this
                .viewInstance as IPSAppDEView).getParentPSAppDataEntity() as IPSAppDataEntity).codeName.toLowerCase();
            if (this.context.srfparentkey) {
                Object.assign(this.context, { [parentEntityCodeName]: this.context.srfparentkey });
            } else if (this.viewparams.srfparentkey) {
                Object.assign(this.context, { [parentEntityCodeName]: this.viewparams.srfparentkey });
            }
        }
    }

}
