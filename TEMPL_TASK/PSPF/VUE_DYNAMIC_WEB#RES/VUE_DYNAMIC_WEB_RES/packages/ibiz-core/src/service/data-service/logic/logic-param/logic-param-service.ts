import { IPSDELogicParam } from "@ibiz/dynamic-model-api";
import { AppDeLogicAppContextParam } from "./logic-app-context-param";
import { AppDeLogicEntityListParam } from "./logic-entity-list-param";
import { AppDeLogicEntityParam } from "./logic-entity-param";
import { AppDeLogicFilterParam } from "./logic-filter-param";
import { AppDeLogicLastReturnParam } from "./logic-last-return-param";
import { AppDeLogicParamBase } from "./logic-param-base";
import { AppDeLogicSimpleListParam } from "./logic-simple-list-param";
import { AppDeLogicSampleParam } from "./logic-simple-param";

export class AppDeLogicParamService {

    /**
     * 获取逻辑参数实例
     *
     * @static
     * @param {*} actionSession 操作会话
     * @param {*} model 模型
     * @param {*} value 初始值
     * @memberof AppDeLogicParamService
     */
    public static getLogicParamInstance(actionSession: any, model: IPSDELogicParam, value: any) {
        const inputParam = { actionSession, model, value };
        // 逻辑数据对象参数
        if (model.entityParam) {
            return new AppDeLogicEntityParam(inputParam);
        }
        // 逻辑数据对象列表参数
        if (model.entityListParam) {
            return new AppDeLogicEntityListParam(inputParam);
        }
        // 逻辑应用上下文变量参数
        if(model.appContextParam){
            return new AppDeLogicAppContextParam(inputParam);
        }
        // 逻辑过滤对象参数
        if (model.filterParam) {
            return new AppDeLogicFilterParam(inputParam);
        }
        // 逻辑上一次调用返回参数
        if (model.lastReturnParam) {
            return new AppDeLogicLastReturnParam(inputParam);
        }
        // 逻辑简单数据列表参数
        if(model.simpleListParam){
            return new AppDeLogicSimpleListParam(inputParam);
        }
        // 逻辑简单数据参数
        if(model.simpleParam){
            return new AppDeLogicSampleParam(inputParam);
        }
        return new AppDeLogicParamBase(inputParam);
    }
}