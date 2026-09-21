import { IPSAppDataEntity, IPSAppDEUIAction, IPSAppView, IPSAppViewRef } from "@ibiz/dynamic-model-api";
import { GetModelService, Http, ModelTool, removeSessionStorage, Util } from "ibiz-core";
import { DataServiceHelp } from "ibiz-core";
import { clearCookie, setCookie } from "qx-util";
import { Dialog } from 'vant';

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
        ['GRIDVIEW_HELPACTION', 'Help'],
        ['EDITVIEW_REFRESHACTION', 'Refresh'],
        ['GRIDVIEW_REMOVEACTION', 'Remove'],
        ['GRIDVIEW_COPYACTION', 'Copy'],
        ['GRIDVIEW_VIEWACTION', 'View'],
        ['GRIDVIEW_SAVEROWACTION', 'SaveRow'],
        ['APP_LOGOUT', 'logout'],
        ['APP_LOGIN', 'login']
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
        const that: any = this;
        const actionTag = this.getActionMethodByTag(tag);
        if (that[actionTag] && that[actionTag] instanceof Function) {
            that[actionTag](args, contextJO, params, $event, xData, actionContext, srfParentDeName, actionModel);
        } else {
            actionContext.$Notice.warning(`${actionTag}未支持`);
        }
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
        let fields: any[] =[];
        const handleLoginItemField:Function = (items:any[]) =>{
            if(items && Array.isArray(items)){
                items.forEach((item:any)=>{
                    if(Object.is(item.itemType,"CONTAINER")){
                        if(item.pspanelitems){
                            handleLoginItemField(item.pspanelitems);
                        }
                    }else if(Object.is(item.itemType,"FIELD")){
                        if(item.pseditor){
                            if(item.pseditor.predefinedType){
                                fields.push({
                                    type:item.pseditor.predefinedType,
                                    name:item.pseditor.name
                                })
                            }
                        }
                    }
                })
            }
        }
        handleLoginItemField(actionContext.viewLayoutPanel?.getRootPSPanelItems());
        const authUserIdName = fields.find((field:any)=> Object.is(field.type,"AUTH_USERID"))?.name;
        const authPassWordName = fields.find((field:any)=> Object.is(field.type,"AUTH_PASSWORD"))?.name;
        const authLoginMsgName = fields.find((field:any)=> Object.is(field.type,"AUTH_LOGINMSG"))?.name;
        const authCaptchaName = fields.find((field:any)=> Object.is(field.type,"AUTH_CAPTCHA"))?.name;
        const authVerCodeName = fields.find((field:any)=> Object.is(field.type,"AUTH_VERIFICATIONCODE"))?.name;
        // 校验
        if (!data) {
            if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: '用户名和密码不能为空' });
                return;
            }
            actionContext.$Notice.error('用户名不能为空');
            return;
        } else {
            if (authUserIdName && !data[authUserIdName]) {
                if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                    actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: '用户名不能为空' });
                    return;
                }
                actionContext.$Notice.error('用户名不能为空');
                return;
            }
            if (authPassWordName && !data[authPassWordName]) {
                if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                    actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: '密码不能为空' });
                    return;
                }
                actionContext.$Notice.error('密码不能为空');
                return;
            }
            if (authCaptchaName && data.hasOwnProperty(authCaptchaName) && !data[authCaptchaName]) {
                if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                    actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: '验证码错误' });
                    return;
                }
                actionContext.$Notice.error('验证码错误');
                return;
            }
            if (authVerCodeName && data.hasOwnProperty(authVerCodeName) && !data[authVerCodeName]) {
                if (authLoginMsgName && data.hasOwnProperty(authLoginMsgName)) {
                    actionContext.onValueChange(authLoginMsgName, { name: authLoginMsgName, value: '请输入验证码' });
                    return;
                }
                actionContext.$Notice.error('请输入验证码');
                return;
            }
        }
        this.clearAppData(actionContext, true)
        // 执行校验 todo
        const loginname: any = data[authUserIdName];
        const requestData = {
            loginname: data[authUserIdName],
            password: data[authPassWordName]
        }
        const handleErrorMessage = (actionContext: any, message: string) => {
            const viewLayoutModelDetails = actionContext.layoutDetailsModel;
            for (const property in viewLayoutModelDetails) {
                if (viewLayoutModelDetails[property].panelItemModel.itemType == 'FIELD') {
                    if (viewLayoutModelDetails[property].panelItemModel.getPSEditor()?.predefinedType == 'AUTH_LOGINMSG') {
                        actionContext.layoutData[viewLayoutModelDetails[property].panelItemModel.name] = message;
                        actionContext.$forceUpdate();
                    }
                }
            }
        }
        Http.getInstance().post('/v7/login', requestData, true).then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                if (data && data.token) {
                    setCookie('ibzuaa-token', data.token, 7, true);
                }
                if (data && data.user) {
                    setCookie('ibzuaa-user', JSON.stringify(data.user), 7, true);
                }
                // 设置cookie,保存账号密码7天
                setCookie('loginname', loginname, 7, true);
                // 跳转首页
                const url: any = actionContext.$route.query.redirect ? actionContext.$route.query.redirect : '*';
                actionContext.$router.push({ path: url });
                handleErrorMessage(actionContext, '');
                return response;
            } else {
                handleErrorMessage(actionContext, response.data?.message);
            }
        }).catch((error: any) => {
            handleErrorMessage(actionContext, error.data?.message);
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
        try {
            Dialog.confirm({
                title: '退出登录',
                message: '你是否确认退出系统'
            }).then((resolve: any) => {
                this.clearAppData(actionContext, true)
                actionContext.$router.push('/login')
            }).catch((reject: any) => { })
        } catch (error) {
            console.error(error);
        }
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
        actionContext.$Notice.error('帮助未支持');
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
                actionContext.$parent.$emit('viewdataschange', [{ ...response.data }]);
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
                if (window.parent) {
                    window.parent.postMessage([{ ...response.data }], '*');
                }
            });
        } else if (actionContext.saveAndExit && actionContext.saveAndExit instanceof Function) {
            actionContext.saveAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                if (window.parent) {
                    window.parent.postMessage([{ ...response.data }], '*');
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
                actionContext.$parent.$emit('viewdataschange', JSON.stringify({ status: 'error', action: 'saveAndNew' }));
                return;
            }
            actionContext.$parent.$emit('viewdataschange', JSON.stringify({ status: 'success', action: 'saveAndNew', data: response.data }));
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
            actionContext.$Notice.error('opendata 视图处理逻辑不存在，请添加!');
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
            actionContext.$Notice.error('opendata 视图处理逻辑不存在，请添加!');
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

            if (actionContext['_context']) {
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
        // todo 导航
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
        actionContext.closeView(args);
        if (window.parent) {
            window.parent.postMessage([{ ...args }], '*');
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
        if (!(xData && await xData.formValidateStatus())) {
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

                        let tempViewParam: any = { actionView: `WFSTART@${item['wfversion']}`, actionForm: item['process-mobform'] };
                        Object.assign(tempContext, { viewpath: targetOpenView.modelFilePath });
                        if (args && args[0]) {
                            let keyFile = xData.appDeCodeName.toLowerCase();
                            if (args[0].srfuf == "0") {
                                tempContext[keyFile] = null;
                            } else {
                                tempContext[keyFile] = args[0][keyFile + 'id'] ? args[0][keyFile + 'id'] : tempContext[keyFile];
                            }
                        }
                        const result = await _this.$appmodal.openModal({ viewname: 'app-view-shell', height: targetOpenView.height, width: targetOpenView.width }, tempContext, tempViewParam);
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
            if ((status !== 200) || (targetData.length === 0)) {
                return;
            }
            if (targetData && targetData.length > 1) {
                targetData.forEach((element: any) => {
                    Object.assign(element, { value: element.definitionkey, label: element.definitionname });
                })
                const h = _this.$createElement;
                // todo 多流程版本
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
        const _this: any = this;
        if (_this.opendata && _this.opendata instanceof Function) {
            const data: any = {};
            if (args.length > 0 && srfParentDeName) {
                Object.assign(data, { [srfParentDeName]: args[0][srfParentDeName] });
            }
            if (!params) params = {};
            Object.assign(params, { copymode: true });
            _this.opendata([{ ...data }], params, $event, xData);
        } else {
            // todo 拷贝
            // Object.assign(actionContext.viewparams,{copymode:true});
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
                if (window.parent) {
                    window.parent.postMessage([{ ...response.data }], '*');
                }
            });
        } else if (actionContext.removeAndExit && actionContext.removeAndExit instanceof Function) {
            actionContext.removeAndExit().then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                if (window.parent) {
                    window.parent.postMessage([{ ...response.data }], '*');
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
        // todo 上一个记录
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
        // 下一个记录
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
            actionContext.$Notice.error('newdata 视图处理逻辑不存在，请添加!');
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
        } else if (xData.newRow && xData.newRow instanceof Function) {
            xData.newRow([{ ...data }], params, $event, xData);
        } else {
            actionContext.$Notice.error('newRow 视图处理逻辑不存在，请添加!');
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
        xData.actualIsOpenEdit = !xData.actualIsOpenEdit;
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
        // todo 最后一个记录
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
                }
            }
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
                actionModel?.getPSAppDataEntity() as IPSAppDataEntity,
                contextJO
            ).then((service: any) => {
                if (service && service['Create'] && (service['Create'] instanceof Function)) {
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
                    service['Create'](context, data).then((response: any) => {
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
            actionContext.$Notice.error(error?.message ? error?.message : '执行建立数据逻辑异常');
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
                actionModel?.getPSAppDataEntity() as IPSAppDataEntity,
                contextJO
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
            actionContext.$Notice.error(error?.message ? error?.message : '执行建立数据逻辑异常');
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
                actionModel?.getPSAppDataEntity() as IPSAppDataEntity,
                contextJO
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
                    if (data.hasOwnProperty(key)) {
                        Object.assign(context, { [name]: data[key] });
                        action = 'Update';
                    } else {
                        action = 'Create';
                    }
                    if (service[action] && (service[action] instanceof Function)) {
                        // 执行新建逻辑
                        service[action](context, data).then((response: any) => {
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
            actionContext.$Notice.error(error?.message ? error?.message : '执行保存变更逻辑异常');
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
        if (xData && xData.refreshDataArea && (xData.refreshDataArea instanceof Function)) {
            xData.refreshDataArea();
        }
    }

}