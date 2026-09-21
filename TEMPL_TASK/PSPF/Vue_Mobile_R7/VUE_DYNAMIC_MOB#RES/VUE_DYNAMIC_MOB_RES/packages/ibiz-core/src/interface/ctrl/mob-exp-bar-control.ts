import { MobMainControlInterface } from "ibiz-core";

/**
 * 导航基类接口
 *
 * @interface MobExpBarControlInterface
 */
export interface MobExpBarControlInterface extends MobMainControlInterface {

    /**
     * 刷新
     *
     * @param {*} [args] 额外参数
     * @memberof MobExpBarControlInterface
     */
    refresh(): void;


    /**
     * 选中数据事件
     *
     * @param {any[]} args 选中数据
     * @memberof MobExpBarControlInterface
     */
    onSelectionChange(args: any[]): void;

}
