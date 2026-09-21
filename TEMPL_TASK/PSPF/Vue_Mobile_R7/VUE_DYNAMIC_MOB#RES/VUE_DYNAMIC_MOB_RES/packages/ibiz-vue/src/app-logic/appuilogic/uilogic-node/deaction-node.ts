import { getDstPSAppDEAction, IPSDEUIDEActionLogic, IPSDEUILogicParam } from '@ibiz/dynamic-model-api';
import { LogUtil, Util } from 'ibiz-core';
import { UILogicParamType } from '../const/ui-logic-param-type';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 实体行为调用节点
 *
 * @export
 * @class AppUILogicDeactionNode
 */
export class AppUILogicDeactionNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIDEActionLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicDeactionNode
     */
    public async executeNode(logicNode: IPSDEUIDEActionLogic, actionContext: UIActionContext) {
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
     * @param {IPSDEUIDEActionLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicDeactionNode
     */
    private async handleDEAction(logicNode: IPSDEUIDEActionLogic, actionContext: UIActionContext) {
        const dstEntity = logicNode.getDstPSAppDataEntity();
        const deAction = await getDstPSAppDEAction(logicNode);
        const dstParam = actionContext.getParam((logicNode.getDstPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
        if (!Object.is(dstParam.logicParamType, UILogicParamType.entityListParam) && !Object.is(dstParam.logicParamType, UILogicParamType.entityParam)) {
            throw new Error(`实体行为操作参数只能为数据对象变量类型或者数据对象列表类型`);
        }
        const retParam = actionContext.getParam((logicNode.getRetPSDEUILogicParam() as IPSDEUILogicParam)?.codeName);
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
                if (Object.is(dstParam.logicParamType, UILogicParamType.entityParam)) {
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