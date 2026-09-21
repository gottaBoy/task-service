import { MainControlInterface } from "ibiz-core";

/**
 * 导航基类接口
 *
 * @interface ExpBarControlInterface
 */
export interface ExpBarControlInterface extends MainControlInterface{

    /**
     *
     *
     * @param {*} [args] 额外参数
     * @memberof ExpBarControlInterface
     */
    refresh(): void;

    /**
     * 选中数据事件
     *
     * @param {any[]} args 选中数据
     * @memberof ExpBarControlInterface
     */
    onSelectionChange(args: any[]): void;

    /**
     * 工具栏点击
     *
     * @param {*} data
     * @param {*} $event
     * @memberof ExpBarControlInterface
     */
    handleItemClick(data: any, $event: any): void;

}
