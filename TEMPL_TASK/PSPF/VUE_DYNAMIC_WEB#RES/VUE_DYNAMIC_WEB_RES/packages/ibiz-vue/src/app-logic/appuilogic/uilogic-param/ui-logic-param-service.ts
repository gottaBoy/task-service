import { IPSDEUILogicParam } from "@ibiz/dynamic-model-api";
import { IParams } from "ibiz-core";
import { UILogicActiveContainerParam } from "./ui-logic-active-container-param";
import { UILogicActiveCtrlParam } from "./ui-logic-active-ctrl-param";
import { UILogicActiveViewParam } from "./ui-logic-active-view-param";
import { UILogicAppGlobalParam } from "./ui-logic-app-global-param";
import { AppDeUILogicAppParam } from "./ui-logic-app-param";
import { UILogicCtrlParam } from "./ui-logic-ctrl-param";
import { AppDeUILogicEntityListParam } from "./ui-logic-entity-list-param";
import { AppDeUILogicEntityPageParam } from "./ui-logic-entity-page-param";
import { AppDeUILogicEntityParam } from "./ui-logic-entity-param";
import { AppDeUILogicFilterParam } from "./ui-logic-filter-param";
import { AppDeUILogicLastReturnParam } from "./ui-logic-last-return-param";
import { UILogicNavContextParam } from "./ui-logic-nav-context-param";
import { UILogicNavViewParam } from "./ui-logic-nav-view-param";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";
import { UILogicRouteViewSessionParam } from "./ui-logic-route-view-session-param";
import { AppDeUILogicSimpleListParam } from "./ui-logic-simple-list-param";
import { AppDeUILogicSampleParam } from "./ui-logic-simple-param";
import { UILogicViewNavDataParam } from "./ui-logic-view-navdata-param";
import { UILogicViewSessionParam } from "./ui-logic-view-session-param";


export class AppDeUILogicParamService {

    /**
     * 获取界面逻辑参数实例
     *
     * @static
     * @param {*} actionSession 操作会话
     * @param {*} model 模型
     * @memberof AppDeUILogicParamService
     */
    public static getLogicParamInstance(actionSession: any, model: IPSDEUILogicParam, params: IParams) {
        const inputParam = { actionSession, model, params };
        // 应用程序变量
        if (model.applicationParam) {
            return new AppDeUILogicAppParam(inputParam);
        }
        // 当前容器对象
        if (model.activeContainerParam) {
            return new UILogicActiveContainerParam(inputParam);
        }
        // 当前部件对象
        if (model.activeCtrlParam) {
            return new UILogicActiveCtrlParam(inputParam);
        }
        // 指定部件对象
        if (model.ctrlParam) {
            return new UILogicCtrlParam(inputParam);
        }
        // 当前视图对象
        if (model.activeViewParam) {
            return new UILogicActiveViewParam(inputParam);
        }
        // 简单数据变量
        if (model.simpleParam) {
            return new AppDeUILogicSampleParam(inputParam);
        }
        // 逻辑数据对象参数
        if (model.entityParam) {
            return new AppDeUILogicEntityParam(inputParam);
        }
        // 数据对象列表变量
        if (model.entityListParam) {
            return new AppDeUILogicEntityListParam(inputParam);
        }
        // 上一次调用返回变量
        if (model.lastReturnParam) {
            return new AppDeUILogicLastReturnParam(inputParam);
        }
        // 简单数据列表变量
        if (model.simpleListParam) {
            return new AppDeUILogicSimpleListParam(inputParam);
        }
        // 分页查询结果变量
        if (model.entityPageParam) {
            return new AppDeUILogicEntityPageParam(inputParam);
        }
        // 应用全局参数绑定参数
        if (model.appGlobalParam) {
            return new UILogicAppGlobalParam(inputParam);
        }
        // 过滤器
        if (model.filterParam) {
            return new AppDeUILogicFilterParam(inputParam);
        }
        // 导航上下文绑定参数
        if (model.navContextParam) {
            return new UILogicNavContextParam(inputParam);
        }
        // 导航视图参数绑定参数
        if (model.navViewParamParam) {
            return new UILogicNavViewParam(inputParam);
        }
        // 顶级视图会话共享参数绑定参数
        if (model.routeViewSessionParam) {
            return new UILogicRouteViewSessionParam(inputParam);
        }
        // 导航数据参数绑定参数
        if (model.viewNavDataParam) {
            return new UILogicViewNavDataParam(inputParam);
        }
        // 当前视图会话共享参数绑定参数
        if (model.viewSessionParam) {
            return new UILogicViewSessionParam(inputParam);
        }
        return new AppDeUILogicParamBase(inputParam);
    }
}