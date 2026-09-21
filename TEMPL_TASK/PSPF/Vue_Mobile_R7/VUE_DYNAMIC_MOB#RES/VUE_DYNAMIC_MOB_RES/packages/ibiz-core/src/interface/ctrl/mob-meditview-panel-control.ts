import { MobMDControlInterface } from 'ibiz-core';

/**
 * 多编辑视图面板部件接口
 *
 * @interface MobMEditViewPanelControlInterface
 */
export interface MobMEditViewPanelControlInterface extends MobMDControlInterface {
    /**
     * 保存数据
     *
     * @param {*} [data] 数据
     * @memberof MobMEditViewPanelControlInterface
     */
    saveData(data?: any): void;

    /**
     * 数据加载
     *
     * @public
     * @param {*} data 额外参数
     * @memberof MobMEditViewPanelControlInterface
     */
    load(data: any): void;

    /**
     * 增加数据
     * 
     * @memberof MobMEditViewPanelControlInterface
     */
    addItem(): void;

    /**
     * 删除数据
     * @memberof MobMEditViewPanelControlInterface
     */
    deleteItem(item: any): void;

}
