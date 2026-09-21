import { IPSAppDEDataSet, IPSDEDQCondition, IPSDEDQFieldCondition, IPSDEDQGroupCondition } from "@ibiz/dynamic-model-api";
import { isEmpty, isNil } from "ramda";
import { IContext, IParams } from "../../../interface";
import { HttpResponse, LogUtil, PSDEDQCondEngine, SearchFilter } from "../../../utils";
import { AppMethod } from "./app-method";

/**
 * 本地模式执行方法
 *
 * @export
 * @class AppLocalMethod
 * @extends {AppMethod}
 */
export class AppLocalMethod extends AppMethod {

    /**
     * 执行方法
     * @param context 
     * @param data
     * @memberof AppLocalMethod
     */
    public async execute(context: IContext, data: IParams): Promise<HttpResponse> {
        LogUtil.log(`执行实体本地模式方法，[方法名称]：${this.codeName}`);
        try {
            await this.appDEMethod.fill();
            const methodType = this.appDEMethod.methodType;
            if (methodType === 'FETCH' || methodType === 'FETCHTEMP' || methodType === 'SELECT') {
                if (!this.dataService.condCache.has(this.codeName)) {
                    const strCond: any[] = this.computeFetchConditions();
                    if (!isNil(strCond) && !isEmpty(strCond)) {
                        const cond = new PSDEDQCondEngine();
                        cond.parse(strCond);
                        this.dataService.condCache.set(this.codeName, cond);
                    }
                }
                const cond = this.dataService.condCache.get(this.codeName)
                if (cond) {
                    return this.dataService.searchAppLocal(cond, new SearchFilter(context, data));
                } else {
                    return this.dataService.searchAppLocal(null, new SearchFilter(context, data));
                }
            }
            return new HttpResponse({ message: `${this.codeName}暂未实现` }, {
                ok: false,
                status: 500
            });
        } catch (error: any) {
            return new HttpResponse({ message: error.message }, {
                ok: false,
                status: 500
            });
        }
    }

    /**
     * 计算查询条件
     *
     * @private
     * @return {*}  {*}
     * @memberof AppLocalMethod
     */
    private computeFetchConditions(): any {
        if (!(this.appDEMethod as IPSAppDEDataSet).getPSDEDQGroupConditions()) {
            return null;
        }
        const conditions: IPSDEDQGroupCondition[] = ((this.appDEMethod as IPSAppDEDataSet).getPSDEDQGroupConditions()) as IPSDEDQGroupCondition[];
        const appConditions: any[] = [];
        for (const condition of conditions) {
            if (condition.condType === 'GROUP') {
                if (condition.notMode) {
                    appConditions.push('!');
                }
                appConditions.push(condition.condOp);
                if (condition.getPSDEDQConditions()) {
                    (condition.getPSDEDQConditions() as IPSDEDQCondition[]).forEach((childCondition: IPSDEDQCondition) => {
                        if (childCondition.condType === 'GROUP' || childCondition.condType === 'SINGLE') {
                            appConditions.push(this.computeNextConditions(childCondition));
                        }
                    });
                }
            }
        }
        return appConditions;
    }

    /**
     * 计算查询子条件
     *
     * @private
     * @param {IPSDEDQCondition} condition
     * @return {*}  {*}
     * @memberof AppLocalMethod
     */
    private computeNextConditions(condition: IPSDEDQCondition): any {
        const targetConditions: any[] = [];
        if (condition.condType === 'GROUP') {
            if ((condition as IPSDEDQGroupCondition).notMode) {
                targetConditions.push('!');
            }
            targetConditions.push(condition.condOp);
            if ((condition as IPSDEDQGroupCondition).getPSDEDQConditions()) {
                ((condition as IPSDEDQGroupCondition).getPSDEDQConditions() as IPSDEDQCondition[]).forEach((childCondition: IPSDEDQCondition) => {
                    if (childCondition.condType === 'GROUP' || childCondition.condType === 'SINGLE') {
                        targetConditions.push(this.computeNextConditions(childCondition));
                    }
                })
            }
        } else {
            targetConditions.push(condition.condOp);
            targetConditions.push((condition as IPSDEDQFieldCondition).fieldName);
            if ((condition as IPSDEDQFieldCondition).condValue) {
                if ((condition as IPSDEDQFieldCondition).getPSVARTypeId()) {
                    // 变量类型 + 条件值 eg:{type:'CONTEXT',value:'XXX'}
                    targetConditions.push({
                        type: (condition as IPSDEDQFieldCondition).getPSVARTypeId(),
                        value: (condition as IPSDEDQFieldCondition).condValue
                    });
                } else {
                    // 直接条件值
                    targetConditions.push((condition as IPSDEDQFieldCondition).condValue);
                }
            } else {
                // 无条件值给空字符串
                targetConditions.push('')
            }
        }
        return targetConditions;
    }

}