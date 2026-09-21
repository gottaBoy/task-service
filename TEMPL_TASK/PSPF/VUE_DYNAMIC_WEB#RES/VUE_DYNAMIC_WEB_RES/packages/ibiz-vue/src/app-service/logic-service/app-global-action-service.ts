import { IPSAppDEUIAction, IPSAppView, IPSAppViewRef, IPSPanelContainer, IPSPanelField, IPSPanelItem, IPSPanelTabPage, IPSPanelTabPanel, IPSPanelUserControl } from "@ibiz/dynamic-model-api";
import { clearCookie, setCookie } from "qx-util";
import { AppServiceBase, DataServiceHelp, Http, PluginService, removeSessionStorage, UIServiceHelp, Util, ViewTool } from "ibiz-core";
import { NavDataService } from "../common-service/app-navdata-service";

/**
 * 全局界面行为服务
 * 
 * @export
 * @class AppGlobalService
 */
export class AppGlobalService {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AppGlobalService}
     * @memberof AppGlobalService
     */
    private static appGlobalService: AppGlobalService;

    /**
     * 全局界面行为Map
     *
     * @private
     * @type {Map<string,any>}
     * @memberof AppGlobalService
     */
    private globalPluginAction: Map<string, any> = new Map();

    /**
     * 插件服务
     *
     * @private
     * @type PluginService
     * @memberof AppGlobalService
     */
    private pluginService: PluginService = PluginService.getInstance();

    /**
     * 初始化AppGlobalService
     *
     * @memberof AppGlobalService
     */
    constructor() {
        this.initGlobalPluginAction();
    }

    /**
     * 获取 AppGlobalService 单例对象
     *
     * @static
     * @returns {AppGlobalService}
     * @memberof AppGlobalService
     */
    public static getInstance(): AppGlobalService {
        if (!AppGlobalService.appGlobalService) {
            AppGlobalService.appGlobalService = new AppGlobalService();
        }
        return this.appGlobalService;
    }

    /**
     * 初始化全局界面行为Map
     *
     * @private
     * @memberof AppGlobalService
     */
    private initGlobalPluginAction() {
        const appDEUIActions = AppServiceBase.getInstance().getAppModelDataObject()?.M?.getAllPSAppDEUIActions;
        if (appDEUIActions && appDEUIActions.length > 0) {
            appDEUIActions.forEach((action: any) => {
                if (action.getPSSysPFPlugin) {
                    this.globalPluginAction.set(action.codeName, action);
                }
            });
        }
    }

    /**
     * 预置行为predefinedType与tag映射表
     *
     * @private
     * @type {Map<string,string>}
     * @memberof AppGlobalService
     */
    private predefinedActionMap: Map<string, string> = new Map([
        ['EDITVIEW_EXITACTION', 'Exit'],
        ['EDITVIEW_SAVEANDEXITACTION', 'SaveAndExit'],
        ['TREEVIEW_REFRESHPARENTACTION', 'RefreshParent'],
        ['GRIDVIEW_EXPORTXMLACTION', 'ExportModel'],
        ['GRIDVIEW_EXPORTACTION', 'ExportExcel'],
        ['EDITVIEW_REMOVEANDEXITACTION', 'RemoveAndExit'],
        ['GRIDVIEW_PRINTACTION', 'Print'],
        ['EDITVIEW_NEXTRECORDACTION', 'NextRecord'],
        ['GRIDVIEW_NEWROWACTION', 'NewRow'],
        ['EDITVIEW_LASTRECORDACTION', 'LastRecord'],
        ['EDITVIEW_PREVRECORDACTION', 'PrevRecord'],
        ['GRIDVIEW_SEARCHBAR', 'ToggleFilter'],
        ['EDITVIEW_SAVEANDSTARTWFACTION', 'SaveAndStart'],
        ['EDITVIEW_NEWACTION', 'New'],
        ['EDITVIEW_PRINTACTION', 'Print'],
        ['EDITVIEW_COPYACTION', 'Copy'],
        ['EDITVIEW_HELPACTION', 'Help'],
        ['EDITVIEW_FIRSTRECORDACTION', 'FirstRecord'],
        ['GRIDVIEW_REFRESHACTION', 'Refresh'],
        ['EDITVIEW_SAVEANDNEWACTION', 'SaveAndNew'],
        ['EDITVIEW_VIEWWFSTEPACTORACTION', 'ViewWFStep'],
        ['EDITVIEW_SAVEACTION', 'Save'],
        ['TREEVIEW_REFRESHALLACTION', 'RefreshAll'],
        ['GRIDVIEW_IMPORTBAR', 'Import'],
        ['GRIDVIEW_ROWEDITACTION', 'ToggleRowEdit'],
        ['GRIDVIEW_NEWACTION', 'New'],
        ['GRIDVIEW_EDITACTION', 'Edit'],
        ['GRIDVIEW_HELPACTION', 'Help'],
        ['EDITVIEW_REFRESHACTION', 'Refresh'],
        ['GRIDVIEW_REMOVEACTION', 'Remove'],
        ['GRIDVIEW_COPYACTION', 'Copy'],
        ['GRIDVIEW_VIEWACTION', 'View'],
        ['GRIDVIEW_SAVEROWACTION', 'SaveRow'],
        ['APP_LOGIN', 'login'],
        ['APP_LOGOUT', 'logout']
    ])

    /**
     * 通过传入tag获取行为方法名称（兼容老写法，识别新增属性predefinedType）
     *
     * @private
     * @param {string} tag
     * @memberof AppGlobalService
     */
    private getActionMethodByTag(tag: string): string {
        if (this.predefinedActionMap.get(tag)) {
            return this.predefinedActionMap.get(tag) as string;
        } else {
            return tag;
        }
    }

    /**
     * 执行全局界面行为
     *
     * @param {IPSAppDEUIAction} uiAction 界面行为对象
     * @param {*} $event 事件源
     * @param {*} actionContext 操作上下文环境
     * @param {string} [xDataControlName] 界面行为数据部件名称
     * @param {*} [params={}] 行为数据
     * @memberof AppGlobalService
     */
    public async executeGlobalUIAction(uiAction: IPSAppDEUIAction | null, $event: any, actionContext: any, actionParam: any = {}, params: any = {}) {
        if (uiAction) {
            // 准备参数
            const contextJO: any = Util.deepCopy(actionContext.context ? actionContext.context : {});
            const paramJO: any = Util.deepCopy(actionContext.viewparams ? actionContext.viewparams : {});
            let datas: any[] = [];
            let xData: any = actionContext;
            if (!actionParam.xDataControlName) {
                if (actionContext.getDatas && actionContext.getDatas instanceof Function) {
                    datas = [...actionContext.getDatas()];
                }
            } else {
                //  逻辑事件源为自定义视图布局面板
                if (Object.is(actionContext.type, 'VIEWLAYOUT')) {
                    if ($event && $event.srfid) {
                        xData = actionContext.layoutDetailsModel[$event.srfid];
                    } else {
                        xData = this.getXDataForCustomViewLayoutPanel(actionContext);
                    }
                } else {
                    xData = actionContext.$refs[actionParam.xDataControlName.toLowerCase()].ctrl;
                }
                if (xData && xData.getDatas && xData.getDatas instanceof Function) {
                    datas = [...xData.getDatas()];
                }
            }
            if (params && Object.keys(params).length > 0) {
                datas = [params];
            }
            if (uiAction.predefinedType) {
                if (uiAction && uiAction.getPSAppDataEntity()) {
                    Object.assign(contextJO, { srfparentdemapname: uiAction.getPSAppDataEntity()?.getPSDEName() });
                    this.executeGlobalAction(
                        uiAction.predefinedType,
                        datas,
                        contextJO,
                        paramJO,
                        $event,
                        xData,
                        actionContext,
                        uiAction.getPSAppDataEntity()?.codeName.toLowerCase(),
                        uiAction
                    );
                } else {
                    this.executeGlobalAction(
                        uiAction.predefinedType,
                        datas,
                        contextJO,
                        paramJO,
                        $event,
                        xData,
                        actionContext,
                        actionParam.entityName,
                        uiAction
                    );
                }
            } else {
                if (uiAction && uiAction.getPSAppDataEntity()) {
                    Object.assign(contextJO, { srfparentdemapname: uiAction.getPSAppDataEntity()?.getPSDEName() });
                    const targetUIService: any = await UIServiceHelp.getInstance().getService(
                        uiAction.getPSAppDataEntity(),
                        { context: contextJO }
                    );
                    await targetUIService.loaded();
                    targetUIService.excuteAction(
                        uiAction.uIActionTag,
                        datas,
                        contextJO,
                        paramJO,
                        $event,
                        xData,
                        actionContext,
                        uiAction.getPSAppDataEntity()?.codeName.toLowerCase(),
                    );
                } else {
                    this.executeGlobalAction(
                        uiAction.codeName,
                        datas,
                        contextJO,
                        paramJO,
                        $event,
                        xData,
                        actionContext,
                        undefined,
                        uiAction
                    );
                }
            }
        }
    }

    /**
     * 获取数据部件（数据源为自定义视图布局面板时）
     *
     * @private
     * @param {*} actionContext
     * @return {*} 
     * @memberof AppGlobalService
     */
    private getXDataForCustomViewLayoutPanel(actionContext: any) {
        const xDataMap: string[] = ['GRID', 'LIST', 'FORM', 'TREEVIEW', 'DATAVIEW', 'CALENDAR' ];
        try {
            const controlRefs: any = actionContext.viewProxyMode ? actionContext.$refs : actionContext.$slots;
            const allControls: any[] = actionContext.viewProxyMode ? actionContext.viewLayoutPanel.getPSControls() : actionContext.viewInstance.getPSControls();
            if (controlRefs && allControls && (allControls.length > 0)) {
                const xDataControl = allControls.find((control: any) => xDataMap.indexOf(control.controlType) !== -1);
                // 非视图代理模式
                if (!actionContext.viewProxyMode) {
                    return (controlRefs && xDataControl) ? controlRefs[`layout-${xDataControl.name.toLowerCase()}`]?.[0]?.child?.ctrl : null;
                } else {
                    return (controlRefs && xDataControl) ? controlRefs[`${xDataControl.name.toLowerCase()}`]?.ctrl : null;
                }
            } else {
                return null;
            }
        } catch (error: any) {
            return null;
        }
    }

    /**
     * 执行全局行为
     *
     * @param {string} tag 界面行为标识
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @param {*} [actionModel] 行为模型
     * 
     * @memberof AppGlobalService
     */
    public executeGlobalAction(tag: string, args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (this.globalPluginAction.get(tag)) {
            const curActionPlugin = this.globalPluginAction.get(tag);
            const importPlugin: any = this.pluginService.getPluginInstance('UIACTION', curActionPlugin?.getPSSysPFPlugin?.pluginCode);
            if (importPlugin) {
                importPlugin().then((importModule: any) => {
                    const actionPlugin = new importModule.default(curActionPlugin);
                    actionPlugin.execute(args, contextJO, params, $event, xData, actionContext, srfParentDeName);
                })
            }
        } else {
            const that: any = this;
            const actionTag = this.getActionMethodByTag(tag);
            if (that[actionTag] && that[actionTag] instanceof Function) {
                that[actionTag](args, contextJO, params, $event, xData, actionContext, srfParentDeName, actionModel);
            } else {
                actionContext.$warning(`${actionTag}未支持`, 'executeGlobalAction');
            }
        }
    }

    /**
     * 帮助
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public Help(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        actionContext.$throw('帮助未支持', 'HELP');
    }

    /**
     * 登录
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public login(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        const data = args?.[0] ? args?.[0] : {};
        //进一步处理账户密码
        let authUserIdName: string = '';
        let authPassWordName: string = '';
        let authLoginMsgName: string = '';
        let authCaptchaName: string = '';
        let authVerCodeName: string = '';
        const handleLoginItemField: Function = (items: IPSPanelItem[]) => {
            if (items && Array.isArray(items)) {
                items.forEach((item: IPSPanelItem) => {
                    if (Object.is(item.itemType, 'FIELD') && (item as IPSPanelField).getPSEditor()?.predefinedType) {
                        const editor = (item as IPSPanelField).getPSEditor();
                        switch (editor?.predefinedType) {
                            case 'AUTH_USERID':
                                authUserIdName = editor.name;
                                break;
                            case 'AUTH_PASSWORD':
                                authPassWordName = editor.name;
                                break;
                            case 'AUTH_LOGINMSG':
                                authLoginMsgName = editor.name;
                                break;
                            case 'AUTH_VERIFICATIONCODE':
                                authVerCodeName = editor.name;
                                break;
                        }
                    } else if (Object.is(item.itemType, 'CONTAINER')) {
                        handleLoginItemField((item as IPSPanelContainer).getPSPanelItems());
                    } else if (Object.is(item.itemType, 'TABPANEL')) {
                        ((item as IPSPanelTabPanel).getPSPanelTabPages?.() || []).forEach((tabPage: IPSPanelTabPage) => {
                            handleLoginItemField(tabPage.getPSPanelItems());
                        });
                    } else if (Object.is(item.itemType, 'USERCONTROL')) {
                        switch ((item as IPSPanelUserControl).predefinedType) {
                            case 'AUTH_CAPTCHA':
                                authCaptchaName = item.name;
                                break;
                        }
                    }
                })
            }
        }
        handleLoginItemField(actionContext.viewLayoutPanel?.getRootPSPanelItems());
        // 校验
        if (!data) {
            if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: actionContext.$t('components.login.loginname.message') as string });
                return;
            }
            actionContext.$throw(actionContext.$t('components.login.loginname.message') as string, 'handleSubmit');
            return;
        } else {
            if (authUserIdName && !data[authUserIdName]) {
                if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                    actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: actionContext.$t('components.login.loginname.message') as string });
                    return;
                }
                actionContext.$throw(actionContext.$t('components.login.loginname.message') as string, 'handleSubmit');
                return;
            }
            if (authPassWordName && !data[authPassWordName]) {
                if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                    actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: actionContext.$t('components.login.password.message') as string });
                    return;
                }
                actionContext.$throw(actionContext.$t('components.login.password.message') as string, 'handleSubmit');
                return;
            }
            if (authCaptchaName && data.hasOwnProperty(authCaptchaName) && !data[authCaptchaName]) {
                if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                    actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: actionContext.$t('components.login.authfailed') as string });
                    return;
                }
                actionContext.$throw(actionContext.$t('components.login.authfailed') as string, 'handleSubmit');
                return;
            }
            if (authVerCodeName && data.hasOwnProperty(authVerCodeName) && !data[authVerCodeName]) {
                if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                    actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: actionContext.$t('components.login.entervercode') as string });
                    return;
                }
                actionContext.$throw(actionContext.$t('components.login.entervercode') as string, 'handleSubmit');
                return;
            }
        }
        this.clearAppData(actionContext);
        // 执行校验 todo
        const loginname: any = data[authUserIdName];
        const requestData = {
            loginname: data[authUserIdName],
            password: data[authPassWordName]
        }
        const handleErrorMessage = (actionContext: any, message: string) => {
            const layouDetailsModels = actionContext.layoutDetailsModel;
            for (const property in layouDetailsModels) {
                if (layouDetailsModels[property].panelItemModel.itemType == 'FIELD') {
                    if (layouDetailsModels[property].panelItemModel.getPSEditor()?.predefinedType == 'AUTH_LOGINMSG') {
                        actionContext.layoutData[layouDetailsModels[property].panelItemModel.name] = message;
                        actionContext.$forceUpdate();
                    }
                }
            }
        }
        //  请求头
        const headers = {};
        const tempViewParam = ViewTool.getDcSystemIdViewParam();
        if (tempViewParam && tempViewParam.srfdcsystem) {
            Object.assign(headers, { srfdcsystem: tempViewParam.srfdcsystem });
        }
        Http.getInstance().post('/v7/login', requestData, true, headers).then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                const expirein = Util.formatExpirein(data.expirein);
                if (data && data.token) {
                    setCookie('ibzuaa-token', data.token, expirein, true);
                }
                if (data && data.user) {
                    setCookie('ibzuaa-user', JSON.stringify(data.user), expirein, true);
                }
                // 设置cookie,保存账号密码7天
                setCookie('loginname', loginname, expirein, true);
                // 跳转首页
                const url: any = actionContext.$route.query.redirect ? actionContext.$route.query.redirect : '*';
                actionContext.$router.push({ path: url });
                handleErrorMessage(actionContext, '');
                return response;
            } else {
                if (actionContext.layoutData.hasOwnProperty(authLoginMsgName)) {
                    actionContext.layoutData[authLoginMsgName] = data.message;
                    return;
                }
                handleErrorMessage(actionContext, data.message);
            }

        }).catch((error: any) => {
            handleErrorMessage(actionContext, error.data?.message);
            return error;
        })
    }

    /**
     * 登出
     *
     * @param {any[]} args
     * @param {*} [contextJO]
     * @param {*} [params]
     * @param {*} [$event]
     * @param {*} [xData]
     * @param {*} [actionContext]
     * @param {string} [srfParentDeName]
     * @memberof AppGlobalService
     */
    public logout(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        actionContext.$Modal.confirm({
            title: actionContext.$t('components.appuser.surelogout'),
            onOk: () => {
                Http.getInstance().get('/v7/logout').then((response: any) => {
                    if (response && response.status === 200) {
                        this.clearAppData(actionContext, true);
                        const loginUrl = AppServiceBase.getInstance().getAppEnvironment().loginUrl;
                        if (loginUrl) {
                            window.location.href = `${loginUrl}?redirect=${window.location.href}`;
                        } else {
                            actionContext.$router.push({ name: 'login' });
                        }
                    }
                }).catch((error: any) => {
                    console.error(error);
                });
            },
        });
    }

    /**
     * 清除应用数据
     *
     * @param actionContext 执行行为容器实例
     * @param isLogout 是否为登出
     * @memberof AppGlobalService
     */
    clearAppData(actionContext: any, isLogout: boolean = false) {
        // 清除user、token
        clearCookie('ibzuaa-token', true);
        clearCookie('ibzuaa-expired', true);
        clearCookie('ibzuaa-user', true);
        // 清除应用级数据
        localStorage.removeItem('localdata');
        actionContext.$store.commit('addAppData', {});
        actionContext.$store.dispatch('authresource/commitAuthData', {});
        // 清除租户相关信息
        removeSessionStorage('activeOrgData');
        removeSessionStorage('srfdynaorgid');
        removeSessionStorage('dcsystem');
        removeSessionStorage('orgsData');
        if (isLogout) {
            let leftTime = new Date();
            leftTime.setTime(leftTime.getSeconds() - 1);
            // 重置路由缓存
            const navHistory: any = AppServiceBase.getInstance().getAppNavDataService();
            navHistory.reset();
        }
    }

    /**
     * 保存
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public Save(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (xData && xData.save instanceof Function) {
            xData.save().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
            });
        } else if (actionContext.save && actionContext.save instanceof Function) {
            actionContext.save();
        }
    }

    /**
     * 保存并关闭
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public SaveAndExit(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (xData && xData.saveAndExit instanceof Function) {
            xData.saveAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
            });
        } else if (actionContext.saveAndExit && actionContext.saveAndExit instanceof Function) {
            actionContext.saveAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
            });
        }
    }

    /**
     * 保存并新建
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public SaveAndNew(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (!xData || !(xData.saveAndNew instanceof Function)) {
            return;
        }
        xData.saveAndNew().then((response: any) => {
            if (!response || response.status !== 200) {
                return;
            }
            if (xData.autoLoad instanceof Function) {
                xData.autoLoad();
            }
        });
    }

    /**
     * 保存行
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public SaveRow(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (xData && xData.save instanceof Function) {
            xData.save();
        } else if (actionContext.save && actionContext.save instanceof Function) {
            actionContext.save();
        }
    }

    /**
     * 编辑
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public Edit(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (args.length === 0) {
            return;
        }
        if (actionContext.opendata && actionContext.opendata instanceof Function) {
            const data: any = {};
            if (args.length > 0 && srfParentDeName) {
                Object.assign(data, { [srfParentDeName]: args[0][srfParentDeName] })
            }
            actionContext.opendata([{ ...data }], params, $event, xData);
        } else {
            actionContext.$throw('opendata 视图处理逻辑不存在，请添加!', 'Edit');
        }
    }

    /**
     * 查看
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public View(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (args.length === 0) {
            return;
        }
        if (actionContext.opendata && actionContext.opendata instanceof Function) {
            const data: any = {};
            if (args.length > 0 && srfParentDeName) {
                Object.assign(data, { [srfParentDeName]: args[0][srfParentDeName] })
            }
            actionContext.opendata([{ ...data }], params, $event, xData);
        } else {
            actionContext.$throw('opendata 视图处理逻辑不存在，请添加!', 'View');
        }
    }

    /**
     * 打印
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public Print(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (!xData || !(xData.print instanceof Function) || !$event) {
            return;
        }
        xData.print();
    }

    /**
     * 当前流程步骤
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public ViewWFStep(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (!xData || !(xData.wfsubmit instanceof Function)) {
            return;
        }
        xData.wfsubmit(args).then((response: any) => {
            if (!response || response.status !== 200) {
                return;
            }
            const { data: _data } = response;

            if (actionContext.viewdata) {
                actionContext.$emit('viewdataschange', [{ ..._data }]);
                actionContext.$emit('close');
            } else if (actionContext.$tabPageExp) {
                actionContext.$tabPageExp.onClose(actionContext.$route.fullPath);
            }
        });
    }

    /**
     * 导出
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public ExportExcel(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (!xData || !(xData.exportExcel instanceof Function) || !$event) {
            return;
        }
        xData.exportExcel($event.exportparms);
    }

    /**
     * 第一个记录
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public FirstRecord(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        try {
            // 获取多数据导航数据
            let navDataService = NavDataService.getInstance(actionContext.$store);
            let preNavData: any = navDataService.getPreNavData(actionContext.viewCodeName);
            if (!(preNavData.data?.length > 0)) {
                throw new Error('当前页面不是从多数据页面打开，无法使用该功能!')
            }

            // 获取最后一个记录的数据
            let recordData: any = preNavData.data[0];

            // 用目标数据，刷新当前页面
            navDataService.serviceState.next({ action: 'viewrefresh', name: actionContext.viewCodeName, data: recordData.srfkey });
        } catch (error: any) {
            actionContext.$throw(error.message);
        }
    }

    /**
     * 关闭
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public Exit(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (actionContext.viewProxyMode) {
            actionContext.$emit('view-event', { viewName: actionContext.viewInstance.codeName, action: 'viewClosed', data: $event });
        } else {
            const parentRef = actionContext.$parent;
            if (parentRef.closeView && (parentRef.closeView instanceof Function)) {
                parentRef.closeView(args);
            } else if (actionContext.closeView && (actionContext.closeView instanceof Function)) {
                actionContext.closeView(args);
            }
        }
    }

    /**
     * 过滤
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public ToggleFilter(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (actionContext.hasOwnProperty('isExpandSearchForm')) {
            actionContext.isExpandSearchForm = !actionContext.isExpandSearchForm;
        }
    }

    /**
     * 开始流程
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @memberof AppGlobalService
     */
    public async SaveAndStart(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        const _this: any = actionContext;
        if (!xData || !(xData.wfstart instanceof Function) || (!_this.appEntityService)) {
            return;
        }
        if (!(xData && xData.formValidateStatus())) {
            return;
        }
        const startWorkFlow: Function = (param: any, localdata: any) => {
            xData.wfstart(param, localdata).then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                const { data: _data } = response;
                _this.closeView(_data);
            });
        }
        const openStartView: Function = async (item: any, localdata: any) => {
            if (item['wfversion']) {
                if ((_this.viewInstance as IPSAppView)?.getPSAppViewRefs?.()?.length) {
                    let targetView: IPSAppViewRef = _this.viewInstance.getPSAppViewRefs().find((element: any) => {
                        return `WFSTART@${item['wfversion']}` === element.name;
                    })
                    let targetOpenView: any = targetView.getRefPSAppView();
                    if (targetOpenView) {
                        await targetOpenView.fill(true);
                        // 准备参数
                        let tempContext: any = Util.deepCopy(_this.context);
                        let tempViewParam: any = { actionView: `WFSTART@${item['wfversion']}`, actionForm: item['process-form'] };
                        Object.assign(tempViewParam, { srfwfstartdata: xData.getData() });
                        Object.assign(tempContext, { viewpath: targetOpenView.modelFilePath });
                        const appmodal = _this.$appmodal.openModal({ viewname: 'app-view-shell', title: actionContext.$tl(targetOpenView.getTitlePSLanguageRes()?.lanResTag, targetOpenView.title), height: targetOpenView.height, width: targetOpenView.width }, tempContext, tempViewParam);
                        appmodal.subscribe((result: any) => {
                            if (!result || !Object.is(result.ret, 'OK')) {
                                return;
                            }
                            let tempSubmitData: any = Util.deepCopy(args[0]);
                            if (result.datas && result.datas[0]) {
                                const resultData: any = result.datas[0];
                                if (Object.keys(resultData).length > 0) {
                                    let tempData: any = {};
                                    Object.keys(resultData).forEach((key: any) => {
                                        if (resultData[key] || (resultData[key] === 0) || (resultData[key] === false)) {
                                            tempData[key] = resultData[key];
                                        }
                                    })
                                    Object.assign(tempSubmitData, tempData);
                                }
                            }
                            startWorkFlow([tempSubmitData], localdata);
                        });
                    }
                } else {
                    startWorkFlow(args, localdata);
                }
            } else {
                startWorkFlow(args, localdata);
            }
        }
        let localdata: any;
        let requestResult: Promise<any>;
        let copyContext: any = Util.deepCopy(_this.context);
        requestResult = _this.appEntityService.getStandWorkflow(copyContext);
        requestResult.then((response: any) => {
            const { data: targetData, status: status } = response;
            if (status !== 200) {
                actionContext.$throw(response, 'SaveAndStart');
                return;
            }
            if (targetData.length === 0) {
                return;
            }
            if (targetData && targetData.length > 1) {
                targetData.forEach((element: any) => {
                    Object.assign(element, { value: element.definitionkey, label: element.definitionname });
                })
                const h = _this.$createElement;
                _this.$msgbox({
                    title: '请选择流程版本',
                    message: h('i-select', {
                        key: Util.createUUID(),
                        props: {
                            value: localdata,
                            placeholder: "请选择流程版本...",
                            transfer: true,
                            transferClassName: "start-workflow-select-wraper"
                        },
                        on: {
                            'on-change': ($event: any) => {
                                localdata = { processDefinitionKey: $event };
                            }
                        }
                    }, targetData.map((item: any) => {
                        return h('i-option', {
                            key: item.value,
                            props: {
                                value: item.value,
                                label: item.label
                            }
                        })
                    })),
                    showCancelButton: true,
                    confirmButtonText: '确定',
                    cancelButtonText: '取消'
                }).then((action: string) => {
                    if (Object.is(action, 'confirm') && localdata && Object.keys(localdata).length > 0) {
                        let targetItem: any = targetData.find((item: any) => {
                            return item.definitionkey === localdata.processDefinitionKey;
                        })
                        openStartView(targetItem, localdata);
                    }
                })
            } else {
                localdata = { processDefinitionKey: targetData[0]['definitionkey'] };
                targetData[0]['process-view'] = "WFSTART@1";
                openStartView(targetData[0], localdata);
            }
        })
    }

    /**
     * 拷贝
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public Copy(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (args.length === 0) {
            return;
        }
        const _this: any = actionContext;
        if (_this.newdata && _this.newdata instanceof Function) {
            const data: any = {};
            if (args.length > 0 && srfParentDeName) {
                Object.assign(data, { [srfParentDeName]: args[0][srfParentDeName] });
            }
            if (!params) params = {};
            Object.assign(params, { copymode: true });
            _this.newdata([{ ...data }], params, $event, xData);
        } else {
            // todo 拷贝
            Object.assign(actionContext.viewparams, { copymode: true });
        }
    }

    /**
     * 删除
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public Remove(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (!xData || !(xData.remove instanceof Function)) {
            return;
        }
        xData.remove(args);
    }

    /**
     * 删除并关闭
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public RemoveAndExit(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (xData && xData.removeAndExit instanceof Function) {
            xData.removeAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
            });
        } else if (actionContext.removeAndExit && actionContext.removeAndExit instanceof Function) {
            actionContext.removeAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
            });
        }
    }

    /**
     * 上一个记录
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public PrevRecord(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        try {
            // 获取多数据导航数据
            let navDataService = NavDataService.getInstance(actionContext.$store);
            let preNavData: any = navDataService.getPreNavData(actionContext.viewCodeName);
            if (!(preNavData.data?.length > 0)) {
                throw new Error('当前页面不是从多数据页面打开，无法使用该功能!')
            }

            // 定位当前页面在多数据中的位置,并获取前一个记录的数据
            let currentIndex: number = preNavData.data.findIndex((item: any) => item.srfkey == args?.[0]?.srfkey);
            if (currentIndex == -1) {
                throw new Error('无法定位当前页面!')
            }
            if (currentIndex == 0) {
                throw new Error('已经是第一个记录了!')
            }
            let preIndex: number = currentIndex == 0 ? currentIndex : currentIndex - 1;
            let recordData: any = preNavData.data[preIndex];

            // 用目标数据，刷新当前页面
            navDataService.serviceState.next({ action: 'viewrefresh', name: actionContext.viewCodeName, data: recordData.srfkey });
        } catch (error: any) {
            actionContext.$throw(error.message);
        }
    }

    /**
     * 树刷新父数据
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public RefreshParent(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (xData && xData.refresh_parent && xData.refresh_parent instanceof Function) {
            xData.refresh_parent();
            return;
        }
        if (actionContext.refresh_parent && actionContext.refresh_parent instanceof Function) {
            actionContext.refresh_parent();
            return;
        }
    }

    /**
     * 树刷新全部节点
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public RefreshAll(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (xData && xData.refresh_all && xData.refresh_all instanceof Function) {
            xData.refresh_all();
            return;
        }
        if (actionContext.refresh_all && actionContext.refresh_all instanceof Function) {
            actionContext.refresh_all();
            return;
        }
        if (actionContext.engine) {
            actionContext.engine.load();
        }
    }

    /**
     * 数据导入
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public Import(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (!xData || !(xData.importExcel instanceof Function) || !$event) {
            return;
        }
        xData.importExcel(params);
    }

    /**
     * 刷新
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public Refresh(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (xData && xData.refresh && xData.refresh instanceof Function) {
            xData.refresh(args);
        } else if (actionContext.refresh && actionContext.refresh instanceof Function) {
            actionContext.refresh(args);
        }
    }

    /**
     * 下一个记录
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public NextRecord(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        try {
            // 获取多数据导航数据
            let navDataService = NavDataService.getInstance(actionContext.$store);
            let preNavData: any = navDataService.getPreNavData(actionContext.viewCodeName);
            if (!(preNavData.data?.length > 0)) {
                throw new Error('当前页面不是从多数据页面打开，无法使用该功能!')
            }

            // 定位当前页面在多数据中的位置,并获取前一个记录的数据
            let currentIndex: number = preNavData.data.findIndex((item: any) => item.srfkey == args?.[0]?.srfkey);
            if (currentIndex == -1) {
                throw new Error('无法定位当前页面!')
            }
            if (currentIndex == preNavData.data.length - 1) {
                throw new Error('已经是最后一个记录了!')
            }
            let nextIndex: number = currentIndex == (preNavData.data.length - 1) ? currentIndex : currentIndex + 1;
            let recordData: any = preNavData.data[nextIndex];

            // 用目标数据，刷新当前页面
            navDataService.serviceState.next({ action: 'viewrefresh', name: actionContext.viewCodeName, data: recordData.srfkey });
        } catch (error: any) {
            actionContext.$throw(error.message);
        }
    }

    /**
     * 新建
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public New(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (actionContext.newdata && actionContext.newdata instanceof Function) {
            const data: any = {};
            actionContext.newdata([{ ...data }], [{ ...data }], params, $event, xData);
        } else {
            actionContext.$throw('newdata 视图处理逻辑不存在，请添加!', 'New');
        }
    }

    /**
     * 新建行
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public NewRow(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        const data: any = {};
        if (actionContext.hasOwnProperty('newRow') && actionContext.newRow instanceof Function) {
            actionContext.newRow([{ ...data }], params, $event, xData);
        } else if (xData && xData.newRow && xData.newRow instanceof Function) {
            xData.newRow([{ ...data }], params, $event, xData);
        } else {
            actionContext.$throw('newRow 视图处理逻辑不存在，请添加!', 'NewRow');
        }
    }

    /**
     * 行编辑
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public ToggleRowEdit(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (xData) {
            xData.actualIsOpenEdit = !xData.actualIsOpenEdit;
        }
    }

    /**
     * 最后一个记录
     *
     * @param {any[]} args 当前数据
     * @param {any} contextJO 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {string} [srfParentDeName] 应用实体名称
     * @memberof AppGlobalService
     */
    public LastRecord(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        try {
            // 获取多数据导航数据
            let navDataService = NavDataService.getInstance(actionContext.$store);
            let preNavData: any = navDataService.getPreNavData(actionContext.viewCodeName);
            if (!(preNavData.data?.length > 0)) {
                throw new Error('当前页面不是从多数据页面打开，无法使用该功能!')
            }

            // 获取最后一个记录的数据
            let recordData: any = preNavData.data[preNavData.data.length - 1];

            // 用目标数据，刷新当前页面
            navDataService.serviceState.next({ action: 'viewrefresh', name: actionContext.viewCodeName, data: recordData.srfkey });
        } catch (error: any) {
            actionContext.$throw(error.message);
        }
    }

    /**
     * 建立数据
     *
     * @param {any[]} args
     * @param {*} [contextJO]
     * @param {*} [params]
     * @param {*} [$event]
     * @param {*} [xData]
     * @param {*} [actionContext]
     * @param {string} [srfParentDeName]
     * @memberof AppGlobalService
     */
    public DATA_CREATEOBJECT(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        try {
            if (!args || (args.length === 0)) {
                throw new Error('当前环境无法执行建立数据逻辑[无业务数据]');
            }
            DataServiceHelp.getInstance().getService(
                actionModel ? actionModel.getPSAppDataEntity() : null,
                { context: contextJO }
            ).then((service: any) => {
                if (service) {
                    // 准备上下文参数
                    const context = {};
                    if (contextJO) {
                        Object.assign(context, contextJO);
                    }
                    if (xData && xData.context) {
                        Object.assign(context, xData.context);
                    }
                    // 准备业务数据
                    const data = args[0];
                    if (data.hasOwnProperty(service.APPDEKEY.toLowerCase())) {
                        delete data[service.APPDEKEY.toLowerCase()];
                    }
                    // 执行新建逻辑
                    service.execute('Create', context, data).then((response: any) => {
                        if (!response.status || response.status !== 200) {
                            throw new Error('当前环境无法执行建立数据逻辑[执行行为异常]');
                        }
                    }).catch((error: any) => {
                        throw new Error('当前环境无法执行建立数据逻辑[执行行为异常]');
                    })
                } else {
                    throw new Error('当前环境无法执行建立数据逻辑[无执行行为]');
                }
            })
        } catch (error: any) {
            actionContext.$throw(error?.message ? error?.message : '执行建立数据逻辑异常');
        }
    }

    /**
     * 删除数据
     *
     * @param {any[]} args
     * @param {*} [contextJO]
     * @param {*} [params]
     * @param {*} [$event]
     * @param {*} [xData]
     * @param {*} [actionContext]
     * @param {string} [srfParentDeName]
     * @memberof AppGlobalService
     */
    public DATA_REMOVEOBJECT(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        try {
            if (!args || (args.length === 0)) {
                throw new Error('当前环境无法执行删除数据逻辑[无业务数据]');
            }
            DataServiceHelp.getInstance().getService(
                actionModel ? actionModel.getPSAppDataEntity() : null,
                { context: contextJO }
            ).then((service: any) => {
                if (service && service['Remove'] && (service['Remove'] instanceof Function)) {
                    const key = service.APPDEKEY.toLowerCase();
                    const name = service.APPDENAME.toLowerCase();
                    // 准备参数
                    const context = {};
                    const data = args[0];
                    if (contextJO) {
                        Object.assign(context, contextJO);
                    }
                    if (xData && xData.context) {
                        Object.assign(context, xData.context);
                    }
                    if (data.hasOwnProperty(name)) {
                        Object.assign(context, { [name]: data[name] });
                    }
                    if (data.hasOwnProperty(key)) {
                        Object.assign(context, { [name]: data[key] });
                    }
                    // 执行新建逻辑
                    service['Remove'](context, data).then((response: any) => {
                        if (!response.status || response.status !== 200) {
                            throw new Error('当前环境无法执行删除数据逻辑[执行行为异常]');
                        }
                        actionContext.$emit('view-event', { viewName: actionContext.viewInstance.codeName, action: 'viewClosed', data: $event });
                    }).catch((error: any) => {
                        throw new Error('当前环境无法执行删除数据逻辑[执行行为异常]');
                    })
                } else {
                    throw new Error('当前环境无法执行删除数据逻辑[无执行行为]');
                }
            })
        } catch (error: any) {
            actionContext.$throw(error?.message ? error?.message : '执行建立数据逻辑异常');
        }
    }

    /**
     * 保存变更
     *
     * @param {any[]} args
     * @param {*} [contextJO]
     * @param {*} [params]
     * @param {*} [$event]
     * @param {*} [xData]
     * @param {*} [actionContext]
     * @param {string} [srfParentDeName]
     * @memberof AppGlobalService
     */
    public DATA_SAVECHANGES(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        try {
            if (!args || (args.length === 0)) {
                throw new Error('当前环境无法执行保存变更逻辑[无业务数据]');
            }
            DataServiceHelp.getInstance().getService(
                actionModel ? actionModel.getPSAppDataEntity() : null,
                { context: contextJO }
            ).then((service: any) => {
                if (service) {
                    let action: string | undefined = undefined;
                    const data = args[0];
                    const key = service.APPDEKEY.toLowerCase();
                    const name = service.APPDENAME.toLowerCase();
                    // 准备上下文参数
                    const context = {};
                    if (contextJO) {
                        Object.assign(context, contextJO);
                    }
                    if (xData && xData.context) {
                        Object.assign(context, xData.context);
                    }
                    if (data.hasOwnProperty(key) || data.hasOwnProperty(name)) {
                        if (data.hasOwnProperty(key)) {
                            Object.assign(context, { [name]: data[key] });
                        } else {
                            Object.assign(context, { [name]: data[name] });
                        }
                        action = 'Update';
                    } else {
                        action = 'Create';
                    }
                    if (service) {
                        // 执行新建逻辑
                        service.execute(action, context, data).then((response: any) => {
                            if (!response.status || response.status !== 200) {
                                throw new Error('当前环境无法执行保存变更逻辑[执行行为异常]');
                            }
                        }).catch((error: any) => {
                            throw new Error('当前环境无法执行保存变更逻辑[执行行为异常]');
                        })
                    } else {
                        throw new Error('当前环境无法执行保存变更逻辑[执行行为异常]');
                    }
                } else {
                    throw new Error('当前环境无法执行保存变更逻辑[无执行行为]');
                }
            })
        } catch (error: any) {
            actionContext.$throw(error?.message ? error?.message : '执行保存变更逻辑异常');
        }
    }

    /**
     * 取消变更
     *
     * @param {any[]} args
     * @param {*} [contextJO]
     * @param {*} [params]
     * @param {*} [$event]
     * @param {*} [xData]
     * @param {*} [actionContext]
     * @param {string} [srfParentDeName]
     * @memberof AppGlobalService
     */
    public DATA_CANCELCHANGES(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        //  登录视图取消变更为重置
        if (actionContext?.viewInstance.viewType === 'APPLOGINVIEW') {
            const length = Object.keys(actionContext.layoutData).length;
            for (let i = length - 1; i >= 0; i--) {
                const name = Object.keys(actionContext.layoutData)[i];
                if (actionContext.layoutData.hasOwnProperty(name) && !Object.is(actionContext.layoutDetailsModel[name].itemType, 'CONTAINER')) {
                    actionContext.onValueChange(name, { name, value: null });
                }
            }
            actionContext.$nextTick(() => {
                actionContext.$forceUpdate();
            })
        } else {
            if (actionContext.viewProxyMode) {
                actionContext.$emit('view-event', { viewName: actionContext.viewInstance.codeName, action: 'viewClosed', data: $event });
            } else {
                const parentRef = actionContext.$parent;
                if (parentRef.closeView && (parentRef.closeView instanceof Function)) {
                    parentRef.closeView(args);
                } else if (actionContext.closeView && (actionContext.closeView instanceof Function)) {
                    actionContext.closeView(args);
                }
            }
        }
    }

    /**
     * 同步数据
     *
     * @param {any[]} args
     * @param {*} [contextJO]
     * @param {*} [params]
     * @param {*} [$event]
     * @param {*} [xData]
     * @param {*} [actionContext]
     * @param {string} [srfParentDeName]
     * @memberof AppGlobalService
     */
    public DATA_SYNCHRONIZE(args: any[], contextJO?: any, params?: any, $event?: any, xData?: any, actionContext?: any, srfParentDeName?: string, actionModel?: IPSAppDEUIAction) {
        if (!xData) return;
        // 标准部件
        if (xData.controlInstance) {
            if (xData.refresh && (xData.refresh instanceof Function)) {
                xData.refresh();
            }
        } else {
            // 面板项
            if (xData.refreshDataArea && (xData.refreshDataArea instanceof Function)) {
                xData.refreshDataArea();
            }
        }
    }
}