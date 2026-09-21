
import { AppMobMenuModel } from 'ibiz-vue';
import { ControlServiceBase } from 'ibiz-core';
import { IPSAppMenu } from '@ibiz/dynamic-model-api';

/**
 * 菜单部件服务对象
 * 
 * 
 */
export class AppMobMenuService extends ControlServiceBase {

    /**
    * 菜单实例对象
    *
    * @memberof AppMobMenuService
    */
    public MenuInstance !: IPSAppMenu;

    /**
     * 部件模型
     *
     * @type {(any | null)}
     * @memberof AppMobMenuService
     */
    public model: AppMobMenuModel | null = null;

    /**
     * Creates an instance of AppMobMenuService.
     * 
     * @memberof AppMobMenuService
     */
     constructor(opts: any = {}, context?: any, args?: any) {
        super(opts, context, args);
        this.MenuInstance = opts;
    }

    /**
     * 加载服务参数
     *
     * @type {boolean}
     * @memberof AppMobChartService
     */
    public async loaded(context: any, opt: any) {
        await this.initServiceParam(context, opt);
    }

    /**
     * 初始化服务参数
     *
     * @memberof AppMobMenuService
     */
    public async initServiceParam(context: any, opts: IPSAppMenu) {
        this.model = new AppMobMenuModel(context, opts);
        await this.model.loaded();
    }

    /**
     * 获取所有菜单项
     *
     * @memberof AppMobMenuService
     */
    public getAllMenuItems() {
        return this.model?.getAllMenuItems();
    }

    /**
     * 获取所有应用功能
     *
     * @memberof AppMobMenuService
     */
    public getAllFuncs() {
        return this.model?.getAllFuncs();
    }

    /**
     * 是否启用预制功能
     *
     * @readonly
     * @memberof AppMobMenuModel
     */
    get isEnablePrecutFuncs() {
        return this.model?.isEnablePrecutFuncs || false;
    }

    /**
     * 预制模型
     *
     * @memberof AppMobMenuModel
     */
    public getAllPrecutFuncs() {
        return this.model?.getAllPrecutFuncs() || [];
    }


    /**
     * 预制功能对应菜单
     *
     * @return {*} 
     * @memberof AppMobMenuModel
     */
    public getPrecutMenu() {
        return this.model?.getPrecutMenu();
    }
}