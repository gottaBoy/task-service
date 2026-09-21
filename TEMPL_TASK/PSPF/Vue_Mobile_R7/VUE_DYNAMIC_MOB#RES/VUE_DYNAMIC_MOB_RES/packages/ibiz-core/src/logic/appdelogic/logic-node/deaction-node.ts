import { getDstPSAppDEAction, IPSDEDEActionLogic, IPSDELogicParam } from '@ibiz/dynamic-model-api';
import { AppDeLogicNodeBase } from './logic-node-base';
import { ActionContext } from '../action-context';
import { LogUtil, Util } from '../../../utils';
import { LogicParamType } from '../const/logic-param-type';

/**
 * 实体行为处理节点
 *
 * @export
 * @class AppDeLogicDeActionNode
 */
export class AppDeLogicDeActionNode extends AppDeLogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @static
     * @param {IPSDELogicNode} logicNode 逻辑节点
     * @param {ActionContext} actionContext 逻辑上下文
     * @memberof AppDeLogicDeActionNode
     */
    public async executeNode(logicNode: IPSDEDEActionLogic, actionContext: ActionContext) {
        try {
            await this.handleDEAction(logicNode, actionContext);
            return this.computeNextNodes(logicNode, actionContext);
        } catch (error: any) {
            LogUtil.error(`逻辑节点${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理实体行为
     *
     * @private
     * @param {IPSDEDEActionLogic} logicNode
     * @param {ActionContext} actionContext
     * @memberof AppDeLogicDeActionNode
     */
    private async handleDEAction(logicNode: IPSDEDEActionLogic, actionContext: ActionContext) {
        const dstEntity = logicNode.getDstPSAppDataEntity();
        const deAction = await getDstPSAppDEAction(logicNode);
        const dstParam = actionContext.getParam((logicNode.getDstPSDELogicParam() as IPSDELogicParam)?.codeName);
        if (!Object.is(dstParam.logicParamType, LogicParamType.entityListParam) && !Object.is(dstParam.logicParamType, LogicParamType.entityParam)) {
            throw new Error(`实体行为操作参数只能为数据对象变量类型或者数据对象列表类型`);
        }
        const retParam = actionContext.getParam((logicNode.getRetPSDELogicParam() as IPSDELogicParam)?.codeName);
        if (dstEntity && deAction && dstParam) {
            try {
                const service = await (window as any).___ibz___.gs.getService(dstEntity.codeName);
                const getTempContext = (data: any) => {
                    const tempContext = Util.deepCopy(actionContext.context);
                    if (data) {
                        Object.assign(tempContext, data);
                    }
                    return tempContext;
                }
                // 数据对象变量类型
                if (Object.is(dstParam.logicParamType, LogicParamType.entityParam)) {
                    const tempContext = getTempContext(dstParam.getReal());
                    const res = await service[deAction.codeName](tempContext, dstParam.getReal() ? dstParam.getReal() : {});
                    if (res && res.status === 200 && res.data) {
                        if (retParam) {
                            retParam.bind(res.data);
                        }
                        actionContext.bindLastReturnParam(res.data);
                    } else {
                        throw new Error(`执行实体行为失败`);
                    }
                } else {
                    // 数据对象列表类型
                    if (dstParam.getReal() && (dstParam.getReal().length > 0)) {
                        if (dstParam.getReal().length > 20) {
                            throw new Error(`操作数据量超过20条，建议使用后台处理逻辑`);
                        }
                        let promises: any[] = [];
                        dstParam.getReal().forEach((item: any) => {
                            const tempContext = getTempContext(item);
                            promises.push(service[deAction.codeName](tempContext, item ? item : {}));
                        })
                        const resArray = await Promise.all(promises);
                        if (resArray && resArray.length > 0) {
                            const resultArray: any[] = [];
                            resArray.forEach((res: any) => {
                                if (res && res.status === 200 && res.data) {
                                    resultArray.push(res.data);
                                }
                            })
                            if (retParam) {
                                retParam.bind(resultArray);
                            }
                            actionContext.bindLastReturnParam(resultArray);
                        } else {
                            throw new Error(`执行实体行为失败`);
                        }
                    } else {
                        if (retParam) {
                            retParam.bind([]);
                        }
                        actionContext.bindLastReturnParam([]);
                    }
                }
            } catch (error: any) {
                throw new Error(`${error.message ? error.message : '执行实体行为失败'}`);
            }
        } else {
            throw new Error(`执行实体行为所需参数不足`);
        }
    }
}