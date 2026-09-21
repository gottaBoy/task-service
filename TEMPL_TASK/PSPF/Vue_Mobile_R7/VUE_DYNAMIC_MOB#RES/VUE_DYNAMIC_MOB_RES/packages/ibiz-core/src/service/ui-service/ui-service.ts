import { IPSAppDataEntity } from "@ibiz/dynamic-model-api";
import { IRunTimeData } from "../../interface";
import { LogUtil } from "../../utils";
import { AppServiceBase } from "../app-service";
import { UIServiceBase } from "./ui-base.service";
/**
 * UI服务对象类
 *
 * @export
 * @class UIService
 */
export class UIService extends UIServiceBase {

    /**
     * Creates an instance of UIService.
     * @param {(IPSAppDataEntity | null)} [appDataEntity=null]
     * @param {*} [runTimeData]
     * @memberof UIService
     */
    constructor(appDataEntity: IPSAppDataEntity | null = null, runTimeData: IRunTimeData = {}) {
        super(appDataEntity, runTimeData);
    }

    /**
     * 执行界面行为统一入口
     *
     * @param {string} uIActionTag 界面行为tag
     * @param {any[]} args 当前数据
     * @param {any} context 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {*} [srfParentDeName] 父实体名称
     *
     * @memberof UIService
     */
    public async excuteAction(
        uIActionTag: string,
        args: any[],
        context: any = {},
        params: any = {},
        $event?: any,
        xData?: any,
        actionContext?: any,
        srfParentDeName?: string,
    ) {
        if (this.actionMap.has(uIActionTag)) {
            const action = this.actionMap.get(uIActionTag);
            if (action) {
                return action.execute(args, context, params, $event, xData, actionContext, srfParentDeName, this);
            } else {
                LogUtil.warn(`当前实例${uIActionTag}界面行为未实现`);
            }
        } else {
            LogUtil.warn(`当前实例${uIActionTag}界面行为未实现`);
        }
    }

    /**
     * 获取数据对象所有的操作标识
     *
     * @param data 当前数据
     * @param dataaccaction 数据操作标识
     * @memberof  UIServiceBase
     */
    public getAllOPPrivs(data: any, dataaccaction: string) {
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        if (!Environment.enablePermissionValid) {
            return 1;
        }
        if (data && (Object.keys(data).length > 0)) {
            const curActiveKey: string = `${data[this.appDeKeyFieldName?.toLowerCase()]}`;
            const result = this.authService.getOPPrivs(curActiveKey, dataaccaction, this.getDEMainStateOPPrivs(data));
            return result[dataaccaction];
        } else {
            const result = this.authService.getOPPrivs(undefined, dataaccaction, undefined);
            return result[dataaccaction];
        }
    }
}