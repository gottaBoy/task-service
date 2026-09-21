import { MobFormControlInterface } from "./mob-form-control";

/**
 * 搜索表单基类接口
 *
 * @interface MobSearchFormControlInterface
 */
export interface MobSearchFormControlInterface extends MobFormControlInterface {

    /**
     * 表单加载完成
     *
     * @param {*} [data={}]
     * @param {string} action
     * @memberof MobSearchFormControlInterface
     */
    onFormLoad(data: any, action: string): void 

    /**
     * 搜索
     *
     * @memberof MobSearchFormControlInterface
     */
    search(): void

    /**
     * 重置
     *
     * @memberof MobSearchFormControlInterface
     */
    reset(): void    
}
