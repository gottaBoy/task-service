import { IPSSearchBar } from '@ibiz/dynamic-model-api';
import { MobSearchBarControlInterface } from 'ibiz-core';
import { AppMobSearchBarService } from '../ctrl-service/app-mob-searchbar-service';
import { MDControlBase } from './md-control-base';

/**
 * 搜索栏部件
 *
 * @export
 * @class MobSearchBarControlBase
 * @extends {MDControlBase}
 * @implements {MobSearchBarControlInterface}
 */
export class MobSearchBarControlBase extends MDControlBase implements MobSearchBarControlInterface {
    /**
     * 搜索栏部件实例对象
     *
     * @type {IBizSearchBarModel}
     * @memberof SearchBarControlBase
     */
    public declare controlInstance: IPSSearchBar;

    /**
     * 视图是否是代理模式
     *
     * @type {boolean}
     * @memberof SearchBarControlBase
     */
    viewIsProxyMode: boolean = false;

    /**
     * 快速分组项（TODO 后续删除)
     *
     * @protected
     * @type {any[]}
     * @memberof SearchBarControlBase
     */
    protected quickGroupItems: any[] = [];

    /**
     * 查询参数(视图为代理模式时使用)
     *
     * @protected
     * @type {*}
     * @memberof SearchBarControlBase
     */
    protected queryParams: any = {};

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.viewIsProxyMode = newVal.viewIsProxyMode ? true : false;
        super.onStaticPropsChange(newVal, oldVal);
    }
    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppControlBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        super.onDynamicPropsChange(newVal, oldVal);
    }

    /**
     * 部件创建完毕
     *
     * @memberof SearchFormControlBase
     */
    public ctrlInit(): void {
        super.ctrlInit();
    }

    /**
     * 部件模型数据初始化
     *
     * @memberof SearchBarControlBase
     */
    public async ctrlModelInit() {
        await super.ctrlModelInit();
        this.service = new AppMobSearchBarService();
        if (this.viewIsProxyMode) {
            await this.loadQuickGroupItem();
        }
    }

    /**
     * 获取单项数据
     *
     * @return {*} 
     * @memberof MobSearchBarControlBase
     */
    public getData() {
        let data: any = {};
        if (this.viewIsProxyMode) {
            Object.assign(data, this.queryParams);
        }
        return data;
    }

    /**
     * 加载快速分组项
     *
     * @protected
     * @memberof SearchBarControlBase
     */
    protected async loadQuickGroupItem() {
        //  TODO 待补充搜索栏快速分组代码表模型（补充后此逻辑删除）
        this.quickGroupItems = [];
        (this.controlInstance.getPSSearchBarGroups?.() || []).forEach((item: any) => {
            this.quickGroupItems.push({
                label: item.caption,
                value: item.name,
                data: item.data ? JSON.parse(item.data) : {},
                id: item.name
            });
        });
    }

}
