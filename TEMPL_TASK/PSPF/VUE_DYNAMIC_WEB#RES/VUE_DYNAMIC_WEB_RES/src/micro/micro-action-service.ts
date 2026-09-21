/**
 * 微应用行为处理服务
 *
 * @export
 * @class MicroActionService
 */
 export class MicroActionService {

    /**
     * 唯一实例
     * 
     * @private
     * @static
     * @memberof MicroActionService
     */
    private static readonly instance = new MicroActionService();

    /**
     * 获取唯一实例
     *
     * @static
     * @return {*}  {MicroActionService}
     * @memberof MicroActionService
     */
    public static getInstance(): MicroActionService {
        return MicroActionService.instance;
    }

    /**
     * 处理基座应用通知
     *
     * @param {*} state
     * @memberof MicroActionService
     */
    public handleAction(state: any) {
        const { tag, action, data } = state;
        console.log(`${tag}应用${action}行为未实现`);
    }

}