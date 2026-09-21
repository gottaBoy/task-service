import { IPSAppDERedirectView, IPSAppViewRef } from '@ibiz/dynamic-model-api';
import qs from 'qs';
import { IContext, IParams } from '../../interface';
import { AppServiceBase } from '../../service';
import { getSessionStorage, Util } from '../util/util';

export class ViewTool {
    /**
     * 解析参数，返回viewdata
     *
     * @static
     * @param {any[]} [args] 多项数据
     * @param {*} [viewParam] 视图参数
     * @param {any[]} [deResParameters] 关系实体参数对象
     * @param {any[]} [parameters] 当前应用视图参数对象
     * @param {*} [data] 行为参数
     * @returns
     * @memberof ViewTool
     */
    public static getViewdata(viewParam: any = {}, deResParameters: any[], parameters: any[], args: any[], data: any = {}): any {
        let viewdata: any = {};

        let [arg] = args;
        arg = arg ? arg : {};

        // 首页视图参数
        const indexViewParam: any = ViewTool.getIndexViewParam();
        Object.assign(viewdata, indexViewParam);

        // 关系应用实体参数
        deResParameters.forEach(({ pathName, parameterName }: { pathName: string, parameterName: string }) => {
            if (viewParam[parameterName] && !Object.is(viewParam[parameterName], '')) {
                Object.assign(viewdata, { [parameterName]: viewParam[parameterName] });
            } else if (arg[parameterName] && !Object.is(arg[parameterName], '')) {
                Object.assign(viewdata, { [parameterName]: arg[parameterName] });
            }
        });

        // 当前视图参数（应用实体视图）
        parameters.forEach(({ pathName, parameterName }: { pathName: string, parameterName: string }) => {
            if (arg[parameterName] && !Object.is(arg[parameterName], '')) {
                Object.assign(viewdata, { [parameterName]: arg[parameterName] });
            }
        });

        // 视图常规参数
        Object.assign(viewdata, data);
        // 传入父视图的srfsessionid
        Object.assign(viewdata, { srfsessionid: viewParam['srfsessionid'] });
        return viewdata;
    }

    /**
     * 处理路由路径
     *
     * @static
     * @param {Route} route 路由
     * @param {*} [viewParam={}]
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} data 行为参数
     * @returns {string}
     * @memberof ViewTool
     */
    public static buildUpRoutePath(route: any, viewParam: any = {}, deResParameters: any[], parameters: any[], args: any[], data: any): string {
        const indexRoutePath = this.getIndexRoutePath(route);
        const deResRoutePath = this.getDeResRoutePath(viewParam, deResParameters, args);
        const deRoutePath = this.getActiveRoutePath(parameters, args, data, viewParam);
        return `${indexRoutePath}${deResRoutePath}${deRoutePath}`;
    }

    /**
     * 获取首页根路由路径
     *
     * @static
     * @param {Route} route 路由对象
     * @returns {string}
     * @memberof ViewTool
     */
    public static getIndexRoutePath(route: any): string {
        const { parameters: _parameters }: { parameters: any[] } = route.meta;
        const { pathName: _pathName, parameterName: _parameterName }: { pathName: string, parameterName: string } = _parameters[0];
        const param = route.params[_parameterName];
        if (Util.isExistAndNotEmpty(param)) {
            return `/${_parameterName}/${encodeURIComponent(`${param}`)}`;
        }
        return `/${_parameterName}`;
    }

    /**
     * 获取关系实体路径
     *
     * @static
     * @param {*} [viewParam={}] 视图参数
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} args 多项数据
     * @returns {string}
     * @memberof ViewTool
     */
    public static getDeResRoutePath(viewParam: any = {}, deResParameters: any[], args: any[]): string {
        let routePath: string = '';
        let [arg] = args;
        arg = arg ? arg : {};
        if (deResParameters && deResParameters.length > 0) {
            deResParameters.forEach(({ pathName, parameterName }: { pathName: string, parameterName: string }) => {
                let value: any = null;
                if (viewParam[parameterName] && !Object.is(viewParam[parameterName], '') && !Object.is(viewParam[parameterName], 'null')) {
                    value = viewParam[parameterName];
                } else if (arg[parameterName] && !Object.is(arg[parameterName], '') && !Object.is(arg[parameterName], 'null')) {
                    value = arg[parameterName];
                }
                routePath = `${routePath}/${pathName}` + (Util.isExistAndNotEmpty(value) ? `/${encodeURIComponent(`${value}`)}` : '');
            });
        }
        return routePath;
    }

    /**
     * 当前激活路由路径
     *
     * @static
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} data 行为参数
     * @returns {string}
     * @memberof ViewTool
     */
    public static getActiveRoutePath(parameters: any[], args: any[], data: any, viewParam: any = {}): string {
        let routePath: string = '';
        // 不存在应用实体
        if (parameters && parameters.length > 0) {
            if (parameters.length === 1) {
                const [{ parameterName }] = parameters;
                routePath = `/views/${parameterName}`;
                if (Object.keys(data).length > 0) {
                    routePath = `${routePath}?${qs.stringify(data, { delimiter: ';' })}`;
                }
            } else if (parameters.length === 2) {
                let [arg] = args;
                arg = arg ? arg : {};
                const [{ pathName: _pathName, parameterName: _parameterName }, { pathName: _pathName2, parameterName: _parameterName2 }] = parameters;
                const _value: any = arg[_parameterName] || viewParam[_parameterName] || null;
                routePath = `/${_pathName}${Util.isExistAndNotEmpty(_value) ? `/${encodeURIComponent(`${_value}`)}` : ''}/views/${_parameterName2}`;
                if (Object.keys(data).length > 0) {
                    routePath = `${routePath}?${encodeURIComponent(`${qs.stringify(data, { delimiter: ';' })}`)}`;
                }
            }
        }
        return routePath;
    }

    /**
     * 格式化路由参数
     *
     * @static
     * @param {*} params
     * @returns {*}
     * @memberof ViewTool
     */
    public static formatRouteParams(params: any, route: any, context: any, viewparams: any): void {
        Object.keys(params).forEach((key: string, index: number) => {
            const param: string | null | undefined = params[key];
            if (!param || Object.is(param, '') || Object.is(param, 'null')) {
                return;
            }
            if (param.indexOf('=') > 0) {
                const _param = qs.parse(param, { delimiter: ';' });
                Object.assign(context, _param);
            } else {
                Object.assign(context, { [key]: param });
            }
        });
        if (route && route.fullPath && route.fullPath.indexOf("?") > -1) {
            const _viewparams: any = route.fullPath.slice(route.fullPath.indexOf("?") + 1);
            const _viewparamArray: Array<string> = decodeURIComponent(_viewparams).split(";")
            if (_viewparamArray.length > 0) {
                _viewparamArray.forEach((item: any) => {
                    Object.assign(viewparams, qs.parse(item));
                })
            }
        }
    }

    /**
     * 首页路由结构参数
     *
     * @private
     * @static
     * @type {any[]}
     * @memberof ViewTool
     */
    private static indexParameters: any[] = [];

    /**
     * 设置首页路由结构参数
     *
     * @static
     * @param {any[]} parameters
     * @memberof ViewTool
     */
    public static setIndexParameters(parameters: any[]): void {
        this.indexParameters = [...parameters]
    }

    /**
     * 获取首页路由结构参数
     *
     * @static
     * @returns {any[]}
     * @memberof ViewTool
     */
    public static getIndexParameters(): any[] {
        return this.indexParameters;
    }

    /**
     * 首页视图参数
     *
     * @static
     * @type {*}
     * @memberof ViewTool
     */
    public static indexViewParam: any = {};

    /**
     * 设置首页视图参数
     *
     * @static
     * @param {*} [viewParam={}]
     * @memberof ViewTool
     */
    public static setIndexViewParam(viewParam: any = {}): void {
        Object.assign(this.indexViewParam, viewParam);
    }

    /**
     * 获取首页视图参数
     *
     * @static
     * @returns {*}
     * @memberof ViewTool
     */
    public static getIndexViewParam(): any {
        return this.indexViewParam;
    }

    /**
     * 计算界面行为项权限状态
     *
     * @static
     * @param {*} [data] 传入数据
     * @param {*} [ActionModel] 界面行为模型
     * @param {*} [UIService] 界面行为服务
     * @memberof ViewTool
     */
    public static calcActionItemAuthState(data: any, ActionModel: any, UIService: any) {
        let result: any[] = [];
        if (!UIService)
            return;
        for (const key in ActionModel) {
            if (!ActionModel.hasOwnProperty(key)) {
                return result;
            }
            const _item = ActionModel[key];
            let dataActionResult: any;
            if (_item && _item['dataAccessAction']) {
                if (Object.is(_item['actionTarget'], "NONE") || Object.is(_item['actionTarget'], "")) {
                    dataActionResult = UIService.getAllOPPrivs(undefined, _item['dataAccessAction']);
                } else {
                    if (data && Object.keys(data).length > 0) {
                        dataActionResult = UIService.getAllOPPrivs(data, _item['dataAccessAction']);
                    }
                }
            } else {
                dataActionResult = 1;
            }
            // 无权限:0;有权限:1
            if (dataActionResult === 0) {
                // 禁用:1;隐藏:2;隐藏且默认隐藏:6
                if (_item.getNoPrivDisplayMode === 1) {
                    _item.disabled = true;
                }
                if ((_item.getNoPrivDisplayMode === 2) || (_item.getNoPrivDisplayMode === 6)) {
                    _item.visabled = false;
                } else {
                    _item.visabled = _item.visabled && true;
                }
            }
            if (dataActionResult === 1) {
                _item.visabled = _item.visabled && true;
                _item.disabled = _item.disabled || false;
            }
            // 返回权限验证的结果
            _item.dataActionResult = dataActionResult;
            result.push(dataActionResult);
        }
        return result;
    }

    /**
     * 计算界面行为项权限状态（树节点版本）
     *
     * @static
     * @param {*} [data] 传入数据
     * @param {*} [ActionModel] 界面行为模型
     * @param {*} [UIService] 界面行为服务
     * @memberof ViewTool
     */
    public static calcTreeActionItemAuthState(data: any, ActionModel: any, UIService: any) {
        let result: any[] = [];
        if (!UIService)
            return;
        for (const key in ActionModel) {
            if (!ActionModel.hasOwnProperty(key)) {
                return result;
            }
            const _item = ActionModel[key];
            let dataActionResult: any;
            if (Object.is(_item['actiontarget'], "NONE") || Object.is(_item['actiontarget'], "")) {
                dataActionResult = UIService.getAllOPPrivs(undefined, _item['dataaccaction']);
            } else {
                if (_item && _item['dataaccaction'] && UIService.isEnableDEMainState) {
                    if (data && Object.keys(data).length > 0) {
                        dataActionResult = UIService.getAllOPPrivs(data, _item['dataaccaction']);
                    }
                }
            }
            // 无权限:0;有权限:1
            if (dataActionResult === 0) {
                // 禁用:1;隐藏:2;隐藏且默认隐藏:6
                if (_item.noprivdisplaymode === 1) {
                    _item.disabled = true;
                }
                if ((_item.noprivdisplaymode === 2) || (_item.noprivdisplaymode === 6)) {
                    _item.visabled = false;
                } else {
                    _item.visabled = true;
                }
            }
            if (dataActionResult === 1) {
                _item.visabled = true;
                _item.disabled = false;
            }
            // 返回权限验证的结果
            _item.dataActionResult = dataActionResult;
            result.push(dataActionResult);
        }
        return result;
    }

    /**
     * @description 计算工具栏项状态
     * @param {boolean} state 设置状态
     * @param {*} toolbarModels 工具栏模型
     * @return {*} 
     * @memberof ViewTool
     */
    public static calcToolbarItemState(state: boolean, toolbarModels: any) {
        const computeItemState = (models: any) => {
            if (!models || models.length === 0) {
                return;
            }
            for (const key in models) {
                if (!models.hasOwnProperty(key)) {
                    return;
                }
                const item = models[key];
                if (item.uiaction && (Object.is(item.uiaction.actionTarget, 'SINGLEKEY') || Object.is(item.uiaction.actionTarget, 'MULTIKEY') || Object.is(item.uiaction.actionTarget, 'SINGLEDATA'))) {
                    item.disabled = state;
                }
                item.visabled = true;
                if (item.noprivdisplaymode && item.noprivdisplaymode === 6) {
                    item.visabled = !state;
                }
                if (item && item.itemType === "ITEMS" && item.items && item.items.length) {
                    computeItemState(item.items);
                }
            }
        }
        computeItemState(toolbarModels);
    }

    /**
     * @description 计算工具栏权限状态
     * @static
     * @param {*} data 选中数据
     * @param {*} toolbarModels 工具栏模型
     * @param {*} uiService UI服务
     * @return {*} 
     * @memberof ViewTool
     */
    public static calcToolbarItemAuthState(data: any, toolbarModels: any, uiService: any) {
        if (!uiService)
            return;
        const computeAuthState = (models: any) => {
            for (const key in models) {
                if (!models.hasOwnProperty(key)) {
                    return 
                }
                const item = models[key];
                if(item && item.hiddenItem){
                    models[key].visabled = false;
                } else {
                    if (item && item['dataaccaction']) {
                        let dataActionResult: any;
                        // 不需要数据的界面行为
                        if (item.uiaction && (Object.is(item.uiaction.actionTarget, "NONE") || !item.uiaction.actionTarget)) {
                            if (!item.uiaction.actionTarget && Object.is(item.uiaction.uIActionTag, "Save") && item.view.appUIService.isEnableDEMainState) {
                                if (data && Object.keys(data).length > 0) {
                                    dataActionResult = uiService.getAllOPPrivs(data, item['dataaccaction']);
                                }
                            } else {
                                dataActionResult = uiService.getAllOPPrivs(undefined, item['dataaccaction']);
                            }
                        } else {
                            if (data && Object.keys(data).length > 0 && uiService.isEnableDEMainState) {
                                dataActionResult = uiService.getAllOPPrivs(data, item['dataaccaction']);
                            } else {
                                dataActionResult = uiService.getAllOPPrivs(undefined, item['dataaccaction']);
                            }
                        }
                        // 无权限:0;有权限:1
                        if (dataActionResult === 0) {
                            // 禁用:1;隐藏:2;隐藏且默认隐藏:6
                            if (item.noprivdisplaymode === 1) {
                                models[key].disabled = true;
                            } else {
                                models[key].visabled = false;
                            }
                        }
                        if (dataActionResult === 1) {
                            models[key].visabled = true;
                            models[key].disabled = models[key].disabled || false;
                        }
                    }
                    if (item && item.itemType === "ITEMS" && item.items && item.items.length) {
                        computeAuthState(item.items);
                    }
                }
            }
        }
        computeAuthState(toolbarModels);
    }

    /**
     * 计算重定向上下文
     *
     * @static
     * @param {*} [tempContext] 上下文
     * @param {*} [data] 传入数据
     * @param {*} [redirectAppEntity] 应用实体对象
     * @memberof ViewTool
     */
    public static async calcRedirectContext(tempContext: any, data: any, redirectAppEntity: any) {
        if (redirectAppEntity && redirectAppEntity.getMinorPSAppDERSs() && ((redirectAppEntity.getMinorPSAppDERSs() as []).length > 0)) {
            for (const item of redirectAppEntity.getMinorPSAppDERSs()) {
                const parentPSAppDEFieldCodeName: string = item.M.getParentPSAppDEField?.codeName;
                if (parentPSAppDEFieldCodeName) {
                    const curData: any = data;
                    if (curData && curData[parentPSAppDEFieldCodeName.toLowerCase()]) {
                        const majorAppEntity: any = item.getMajorPSAppDataEntity();
                        await majorAppEntity.fill();
                        if (!tempContext[majorAppEntity.codeName.toLowerCase()]) {
                            Object.assign(tempContext, { [majorAppEntity.codeName.toLowerCase()]: curData[parentPSAppDEFieldCodeName.toLowerCase()] });
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取包含DcSystemId的视图参数
     *
     * @static
     * @return {*} 
     * @memberof ViewTool
     */
    public static getDcSystemIdViewParam() {
        let tempViewParam = this.handleViewParam(window.location.href);
        if (!tempViewParam.srfdcsystem) {
            if (!tempViewParam.redirect) {
                if (getSessionStorage('dcsystem')) {
                    tempViewParam = getSessionStorage('dcsystem');
                }
            } else {
                tempViewParam = this.handleViewParam(tempViewParam.redirect);
            }
        }
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        if (!tempViewParam.srfdcsystem && Environment && Environment.mockDcSystemId) {
            Object.assign(tempViewParam, { srfdcsystem: Environment.mockDcSystemId });
        }
        return tempViewParam;
    }

    /**
     * 处理路径数据
     *
     * @static
     * @param {string} urlStr 路径
     * @return {*}  {*}
     * @memberof ViewTool
     */
    public static handleViewParam(urlStr: string): any {
        let tempViewParam: any = {};
        const tempViewparam: any = urlStr.slice(urlStr.indexOf('?') + 1);
        const viewparamArray: Array<string> = decodeURIComponent(tempViewparam).split(';');
        if (viewparamArray.length > 0) {
            viewparamArray.forEach((item: any) => {
                if (item.startsWith('srfdcsystem=') && item.indexOf('#') !== -1) {
                    item = item.substring(0, item.indexOf('#'));
                }
                Object.assign(tempViewParam, qs.parse(item));
            });
        }
        return tempViewParam;
    }

    /**
     * 获取仿真数据
     *
     * @static
     * @param {string} urlStr
     * @return {*}  {*}
     * @memberof ViewTool
     */
    public static getMockViewParams(urlStr: string):any{
        let tempViewParam: any = {};
        const hashIndex = window.location.href.indexOf('#');
        const dataBeforeHash = window.location.href.slice(0, hashIndex);
        const queryIndex = dataBeforeHash.indexOf('?')
        if(queryIndex !== -1){
            const dataMock = dataBeforeHash.slice(queryIndex + 1);
            if(dataMock){
                const viewParams: Array<string> = decodeURIComponent(dataMock).split(';');
                if (viewParams.length > 0) {
                    viewParams.forEach((item: any) => {
                        Object.assign(tempViewParam, qs.parse(item));
                    });
                }
            }
        }
        return tempViewParam;
    }

    /**
     * 计算重定向目标视图引用
     *
     * @static
     * @param {IPSAppDERedirectView} view 重定向视图
     * @param {IParams} viewParam 视图参数
     * @param {IParams} result 返回结果
     * @memberof ViewTool
     */
    public static computeRedirectViewRef(view: IPSAppDERedirectView, viewParam: IParams, result: IParams) {
        let targetViewRef: any;
        // 尝试找重定向项、多表单、索引类型、常规视图
        if (result.srfstate && ((result.srfstate === 'redirectitem') || (result.srfstate === 'multiform') || (result.srfstate === 'indextype') || (result.srfstate === 'funcview'))) {
            targetViewRef = view.getRedirectPSAppViewRefs()?.find((item: IPSAppViewRef) => {
                return item.name == result.param;
            });
        }
        // 尝试找工作流相关（代办、已办、抄送等）
        if (viewParam && viewParam.srfwf) {
            targetViewRef = view.getRedirectPSAppViewRefs()?.find((item: IPSAppViewRef) => {
                return item.name == `${result.param.split(":")[0]}:${viewParam.srfwf.toUpperCase()}`;
            });
        }
        // 都找不到，找默认视图
        if (!targetViewRef) {
            targetViewRef = view.getRedirectPSAppViewRefs()?.find((item: IPSAppViewRef) => {
                return item.name == result.param.split(':')[0];
            });
        }
        return targetViewRef;
    }

    /**
     * 清除父数据
     *
     * @static
     * @param {IContext} context
     * @param {IParams} viewParam
     * @memberof ViewTool
     */
     public static clearParentParams(context: IContext, viewParam: IParams) {
        if(context && context.srfparentkey){
            delete context.srfparentkey;
        }
        if(context && context.srfparentdename){
            delete context.srfparentdename;
        }
        if(context && context.srfparentdemapname){
            delete context.srfparentdemapname;
        }
        if(viewParam && viewParam.srfparentkey){
            delete viewParam.srfparentkey;
        }
        if(viewParam && viewParam.srfparentdename){
            delete viewParam.srfparentdename;
        }
        if(viewParam && viewParam.srfparentdemapname){
            delete viewParam.srfparentdemapname;
        } 
    }

    /**
     * 通过路径获取视图参数
     *
     * @static
     * @param {string} path
     * @memberof ViewTool
     */
    public static getViewParamsByPath(path: string){
        const viewParams:any = {};
        let startPath: any = '';
        let endPath: any = '';
        if(path.indexOf('?') !== -1){
            startPath = path.slice(0, path.indexOf('?'));
            endPath = path.slice(path.indexOf('?') + 1);
            const viewParamArray: Array<string> = decodeURIComponent(endPath).split(';');
            if (viewParamArray.length > 0) {
                viewParamArray.forEach((item: any) => {
                    Object.assign(viewParams, qs.parse(item));
                });
            }
        }
        return {startPath, endPath, viewParams};
    }

}