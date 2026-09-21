import {
    getPSUIActionByModelObject,
    IPSAppDataEntity,
    IPSAppDEField,
    IPSAppDEUIAction,
    IPSAppDEView,
    IPSAppView,
    IPSAppViewRef,
    IPSNavigateContext,
    IPSNavigateParam
} from '@ibiz/dynamic-model-api';
import { EleSelector, Http, IContext, IParams, LogUtil, ModelTool, StringUtil, UIActionTool, UIServiceHelp, Util, ViewTool } from 'ibiz-core';
import { Subject } from 'rxjs';
import { AppGlobalService, ViewCacheService } from '../app-service';
import { appPopup } from '../utils';
import { AppDEUIAction } from './app-ui-action';
import { UIActionResult } from './appuilogic';

export class AppFrontAction extends AppDEUIAction {

    /**
     * 初始化AppFrontAction
     *
     * @memberof AppFrontAction
     */
    constructor(opts: IPSAppDEUIAction, context?: any) {
        super(opts, context);
    }

    /**
     * 执行界面行为
     *
     * @param args
     * @param context
     * @param params
     * @param $event
     * @param xData
     * @param actionContext
     * @param srfParentDeName
     *
     * @memberof AppFrontAction
     */
    public async execute(
        args: any[],
        context: any = {},
        params: any = {},
        $event?: any,
        xData?: any,
        actionContext?: any,
        srfParentDeName?: string,
        deUIService?: any,
    ) {
        if (Object.is(this.actionModel?.uILogicAttachMode, 'REPLACE')) {
            return this.executeDEUILogic(args, context, params, $event, xData, actionContext, srfParentDeName);
        }
        const actionTarget: string | null = this.actionModel.actionTarget;
        if (Object.is(actionTarget, 'MULTIDATA')) {
            actionContext.$throw(actionContext.$t('app.commonwords.nosupportmultiple'), 'AppFrontAction');
        } else {
            // 处理数据
            let data: any = {};
            let tempData: any = {};
            let tempContext: any = {};
            let tempViewParam: any = {};
            const _this: any = actionContext;
            if (this.actionModel.saveTargetFirst) {
                const result: any = await xData.save(args, false);
                if (Object.is(actionTarget, 'SINGLEDATA')) {
                    Object.assign(args[0], result.data);
                } else {
                    args = [result.data];
                }
            }
            const _args: any[] = Util.deepCopy(args);
            if (
                this.actionModel.getPSAppDataEntity() &&
                (Object.is(actionTarget, 'SINGLEKEY') || Object.is(actionTarget, 'MULTIKEY'))
            ) {
                const entityName = (this.actionModel.getPSAppDataEntity() as IPSAppDataEntity).codeName.toLowerCase();
                const key = (ModelTool.getAppEntityKeyField(
                    this.actionModel.getPSAppDataEntity(),
                ) as IPSAppDEField)?.codeName.toLowerCase();
                const majorKey = (ModelTool.getAppEntityMajorField(
                    this.actionModel.getPSAppDataEntity(),
                ) as IPSAppDEField)?.codeName.toLowerCase();
                if (_args[0]?.[key]) {
                    Object.assign(tempContext, { [entityName!]: `%${key}%` });
                } else {
                    Object.assign(tempContext, { [entityName!]: `%${entityName}%` });
                }
                Object.assign(tempViewParam, { [key!]: `%${key}%` });
                Object.assign(tempViewParam, { [majorKey]: `%${majorKey}%` });
            } else if (Object.is(actionTarget, 'SINGLEDATA')) {
                data = args[0] ? args[0] : {};
            }
            // 自定义导航参数优先级大于预置导航参数
            if (
                this.actionModel.getPSNavigateContexts() &&
                (this.actionModel.getPSNavigateContexts() as IPSNavigateContext[]).length > 0
            ) {
                const localContext = Util.formatNavParam(this.actionModel.getPSNavigateContexts());
                Object.assign(tempContext, localContext);
            }
            if (
                this.actionModel.getPSNavigateParams() &&
                (this.actionModel.getPSNavigateParams() as IPSNavigateParam[]).length > 0
            ) {
                const localParam = Util.formatNavParam(this.actionModel.getPSNavigateParams());
                Object.assign(tempViewParam, localParam);
            }
            tempContext = UIActionTool.handleContextParam(actionTarget, _args, context, params, tempContext);
            if (Object.is(actionTarget, 'SINGLEDATA')) {
                tempData = UIActionTool.handleActionParam(actionTarget, _args, context, params, tempViewParam);
                Object.assign(data, tempData);
            } else {
                data = UIActionTool.handleActionParam(actionTarget, _args, context, params, tempViewParam);
            }
            Object.assign(context, tempContext);
            Object.assign(params, data);
            // 构建srfparentdename和srfparentkey
            let parentObj: any = {
                srfparentdename: srfParentDeName ? srfParentDeName : null,
                srfparentkey: srfParentDeName ? context[srfParentDeName.toLowerCase()] : null,
            };
            Object.assign(context, parentObj);
            if (Object.is(this.actionModel.frontProcessType, 'OTHER')) {
                await this.executeOther(actionContext, context, params, args);
            }
            // 打印
            else if (Object.is(this.actionModel.frontProcessType, 'PRINT')) {
                await this.executePrint(actionContext, context, params);
            }
            // 数据导入            
            else if (Object.is(this.actionModel.frontProcessType, 'DATAIMP')) {
                await this.executeDataImport(actionContext, context, params);
            }
            // 数据导出
            else if (Object.is(this.actionModel.frontProcessType, 'DATAEXP')) {
                await this.executeDataExport(actionContext, context, params);
            } else {
                const frontPSAppView: IPSAppView | null = this.actionModel.getFrontPSAppView();
                return this.oPenView(
                    frontPSAppView,
                    actionContext,
                    context,
                    args,
                    deUIService,
                    params,
                    $event,
                    xData,
                    _args,
                );
            }
        }
    }



    /**
     * 打开视图
     *
     * @param {*} actionContext
     * @param {*} context
     * @param {*} args
     * @param {*} deUIService
     * @param {*} params
     * @param {*} $event
     * @param {*} xData
     * @param {*} _args
     * @return {*}
     * @memberof AppFrontAction
     */
    async oPenView(
        frontPSAppView: any,
        actionContext: any,
        context: any,
        args: any,
        deUIService: any,
        params: any,
        $event: any,
        xData: any,
        _args: any,
    ): Promise<any> {
        // 打开HTML
        return new Promise(async (resolve: any, reject: any) => {
            //打开视图后续逻辑
            const openViewNextLogic: any = async (actionModel: any, actionContext: any, xData: any, resultDatas?: any) => {
                if (actionModel.reloadData && xData && xData.refresh && xData.refresh instanceof Function) {
                    xData.refresh(args);
                }
                if (actionModel.closeEditView) {
                    actionContext.$store.commit('viewAction/setViewDataChange', { viewTag: actionContext.viewtag, viewDataChange: false });
                    actionContext.closeView(null);
                }
                // 后续界面行为
                if (this.actionModel.M?.getNextPSUIAction) {
                    const nextUIaction: any = await getPSUIActionByModelObject(this.actionModel);
                    if (nextUIaction.getPSAppDataEntity()) {
                        let [tag, appDeName] = (nextUIaction as IPSAppDEUIAction).id.split('@');
                        if (deUIService) {
                            return deUIService.excuteAction(
                                tag,
                                resultDatas,
                                context,
                                params,
                                $event,
                                xData,
                                actionContext,
                                undefined,
                                deUIService,
                            );
                        }
                    } else {
                        return (AppGlobalService.getInstance() as any).executeGlobalAction(
                            nextUIaction.id,
                            resultDatas,
                            context,
                            params,
                            $event,
                            xData,
                            actionContext,
                            undefined,
                        );
                    }
                } else {
                    if (Object.is(actionModel?.uILogicAttachMode, 'AFTER')) {
                        return this.executeDEUILogic(args, context, params, $event, xData, actionContext, context?.srfparentdename);
                    } else {
                        return new UIActionResult({ ok: true, result: resultDatas });
                    }
                }
            };
            if (Object.is(this.actionModel.frontProcessType, 'OPENHTMLPAGE') && this.actionModel.htmlPageUrl) {
                const url = StringUtil.fillStrData(this.actionModel.htmlPageUrl, context, params);
                window.open(url, '_blank');
                resolve(new UIActionResult({ ok: true, result: _args }));
                // 打开顶级视图，打开顶级视图或向导（模态）
            } else if (
                Object.is(this.actionModel.frontProcessType, 'TOP') ||
                Object.is(this.actionModel.frontProcessType, 'WIZARD')
            ) {
                if (!this.actionModel.getFrontPSAppView()) {
                    actionContext.$warning(
                        `${this.actionModel.caption}${actionContext.$t('app.warn.unopenview')}`,
                        'oPenView',
                    );
                    return;
                }
                await frontPSAppView?.fill(true);
                if (!frontPSAppView) {
                    return;
                }
                // 准备deResParameters参数和parameters参数
                let deResParameters: any[] = [];
                let parameters: any[] = [];
                if (frontPSAppView.getPSAppDataEntity()) {
                    // 处理视图关系参数 （只是路由打开模式才计算）
                    if (
                        !frontPSAppView.openMode ||
                        frontPSAppView.openMode == 'INDEXVIEWTAB' ||
                        frontPSAppView.openMode == 'POPUPAPP'
                    ) {
                        deResParameters = Util.formatAppDERSPath(
                            context,
                            (frontPSAppView as IPSAppDEView).getPSAppDERSPaths(),
                        );
                    }
                }
                if (!frontPSAppView.openMode || frontPSAppView.openMode == 'INDEXVIEWTAB') {
                    if (frontPSAppView.getPSAppDataEntity()) {
                        parameters = [
                            {
                                pathName: Util.srfpluralize(
                                    (frontPSAppView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName,
                                ).toLowerCase(),
                                parameterName: (frontPSAppView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase(),
                            },
                            {
                                pathName: 'views',
                                parameterName: ((frontPSAppView as IPSAppDEView).getPSDEViewCodeName() as string).toLowerCase(),
                            },
                        ];
                    } else {
                        parameters = [{ pathName: 'views', parameterName: frontPSAppView.codeName.toLowerCase() }];
                    }
                } else {
                    if (frontPSAppView.getPSAppDataEntity()) {
                        parameters = [
                            {
                                pathName: Util.srfpluralize(
                                    (frontPSAppView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName,
                                ).toLowerCase(),
                                parameterName: (frontPSAppView.getPSAppDataEntity() as IPSAppDataEntity)?.codeName.toLowerCase(),
                            },
                        ];
                    }
                    if (frontPSAppView && frontPSAppView.modelPath) {
                        Object.assign(context, { viewpath: frontPSAppView.modelPath });
                    }
                }
                // 打开重定向视图
                if (frontPSAppView.redirectView) {
                    const redirectUIService: any = await UIServiceHelp.getInstance().getService(frontPSAppView.getPSAppDataEntity(), { context });
                    await redirectUIService.loaded();
                    const redirectAppEntity: IPSAppDataEntity | null = frontPSAppView.getPSAppDataEntity();
                    await ViewTool.calcRedirectContext(context, args[0], redirectAppEntity);
                    redirectUIService.getRDAppView(
                        context,
                        params,
                        args[0],
                        { action: frontPSAppView.getGetDataPSAppDEAction()?.codeName, type: frontPSAppView.getTypePSAppDEField()?.codeName }
                    ).then(async (result: any) => {
                        if (!result) {
                            return;
                        }
                        let targetOpenViewRef:
                            | IPSAppViewRef
                            | undefined = ViewTool.computeRedirectViewRef(frontPSAppView, params, result);
                        if (!targetOpenViewRef) {
                            return;
                        }
                        let targetOpenView: IPSAppView | null = targetOpenViewRef.getRefPSAppView();
                        if (!targetOpenView) {
                            return;
                        }
                        await targetOpenView.fill(true);
                        if (result && result.indextype) {
                            const indexContext: any = Util.formatNavParam(
                                [{ key: targetOpenView?.getPSAppDataEntity()?.codeName, rawValue: false, value: ModelTool.getContainerAppEntityCodeName(frontPSAppView) }],
                                true,
                            );
                            const _context: any = Util.computedNavData(args[0], context, params, indexContext);
                            Object.assign(context, _context);
                        }
                        if (
                            targetOpenViewRef.getPSNavigateContexts() &&
                            (targetOpenViewRef.getPSNavigateContexts() as IPSNavigateContext[]).length > 0
                        ) {
                            let localContextRef: any = Util.formatNavParam(
                                targetOpenViewRef.getPSNavigateContexts(),
                                true,
                            );
                            let _context: any = Util.computedNavData(args[0], context, params, localContextRef);
                            Object.assign(context, _context);
                        }
                        ViewTool.clearParentParams(context, params);
                        return this.oPenView(
                            targetOpenView,
                            actionContext,
                            context,
                            args,
                            deUIService,
                            params,
                            $event,
                            xData,
                            _args
                        );

                    })
                } else if (!frontPSAppView.openMode || frontPSAppView.openMode == 'INDEXVIEWTAB') {
                    const routePath = actionContext.$viewTool.buildUpRoutePath(
                        actionContext.$route,
                        context,
                        deResParameters,
                        parameters,
                        _args,
                        params,
                    );
                    ViewCacheService.setViewCache(frontPSAppView, routePath);
                    actionContext.$router.push(routePath);
                    resolve(openViewNextLogic(this.actionModel, actionContext, xData, args));
                } else if (frontPSAppView.openMode == 'POPUPMODAL') {
                    const view: any = {
                        viewname: 'app-view-shell',
                        height: frontPSAppView.height,
                        width: frontPSAppView.width,
                        title: actionContext.$tl(frontPSAppView.getTitlePSLanguageRes()?.lanResTag, frontPSAppView.title),
                    };
                    let container: Subject<any> = actionContext.$appmodal.openModal(view, context, params, args);
                    container.subscribe((result: any) => {
                        if (!result || !Object.is(result.ret, 'OK')) {
                            return;
                        }
                        resolve(openViewNextLogic(this.actionModel, actionContext, xData, result.datas))
                    });
                } else if (frontPSAppView.openMode?.indexOf('DRAWER') !== -1) {
                    const view: any = {
                        viewname: 'app-view-shell',
                        height: frontPSAppView.height,
                        width: frontPSAppView.width,
                        title: actionContext.$tl(frontPSAppView.getTitlePSLanguageRes()?.lanResTag, frontPSAppView.title),
                        placement: frontPSAppView.openMode,
                    };
                    let container: Subject<any> = actionContext.$appdrawer.openDrawer(
                        view,
                        Util.getViewProps(context, params, args),
                    );
                    container.subscribe((result: any) => {
                        if (!result || !Object.is(result.ret, 'OK')) {
                            return;
                        }
                        resolve(openViewNextLogic(this.actionModel, actionContext, xData, result.datas));
                    });
                } else if (frontPSAppView.openMode === 'POPUP') {
                    const view: any = {
                        viewname: 'app-view-shell',
                        height: frontPSAppView.height,
                        width: frontPSAppView.width,
                        title: actionContext.$tl(frontPSAppView.getTitlePSLanguageRes()?.lanResTag, frontPSAppView.title),
                        placement: frontPSAppView.openMode,
                    };
                    const container = appPopup.openDrawer(
                        view,
                        Util.getViewProps(context, params, args),
                    );
                    container.subscribe((result: any) => {
                        if (!result || !Object.is(result.ret, 'OK')) {
                            return;
                        }
                        resolve(openViewNextLogic(this.actionModel, actionContext, xData, result.datas));
                    });
                } else if (frontPSAppView.openMode == 'POPOVER') {
                    const view: any = {
                        viewname: 'app-view-shell',
                        height: frontPSAppView.height,
                        width: frontPSAppView.width,
                        title: actionContext.$tl(frontPSAppView.getTitlePSLanguageRes()?.lanResTag, frontPSAppView.title),
                        placement: frontPSAppView.openMode,
                    };
                    let container: Subject<any> = actionContext.$apppopover.openPop($event, view, context, params, 'left-end', true, args);
                    container.subscribe((result: any) => {
                        if (!result || !Object.is(result.ret, 'OK')) {
                            return;
                        }
                        resolve(openViewNextLogic(this.actionModel, actionContext, xData, result.datas));
                    });
                } else {
                    actionContext.$warning(
                        `${frontPSAppView.title}${actionContext.$t('app.nosupport.unopen')}`,
                        'oPenView',
                    );
                }
                // 用户自定义
            } else {
                LogUtil.warn(`${this.actionModel.caption}自定义界面行为空执行`);
                resolve(openViewNextLogic(this.actionModel, actionContext, xData, args));
            }
        })
    }

    /**
     * 执行用户自定义
     * 
     * @param actionContext 
     * @param context 
     * @param viewparams 
     * @param data 
     */
    async executeOther(actionContext: any, context: IContext, viewparams: IParams,args:any){
        if(this.actionModel.scriptCode){
            const data = args;
            const eleSelector = new EleSelector(actionContext);
            const selector = eleSelector.selector.bind(eleSelector);
            const viewselector = eleSelector.viewSelector.bind(eleSelector);
            const appselector = eleSelector.appSelector.bind(eleSelector);
            eval(this.actionModel.scriptCode);
        }else{
            LogUtil.warn(`自定义前端界面行为无脚本内容`);
        }
    }

    /**
     * 执行打印行为
     *
     * @param {*} actionContext
     * @param {IContext} context
     * @param {IParams} viewparams
     * @return {*} 
     * @memberof AppFrontAction
     */
    async executePrint(actionContext: any, context: IContext, viewparams: IParams) {
        const appDataEntity: IPSAppDataEntity = this.actionModel.getPSAppDataEntity() as IPSAppDataEntity;
        const appDEPrint = this.actionModel.getPSAppDEPrint();
        if (appDEPrint) {
            let requestUrl: string = '';
            if (context && context[appDataEntity.codeName.toLowerCase()]) {
                requestUrl += `/${Util.srfpluralize(appDataEntity.codeName)}/printdata/${context[appDataEntity.codeName.toLowerCase()]}`;
                //  存在父添加父主键信息
                if (actionContext.context && actionContext.context.srfparentdename && actionContext.context.srfparentkey) {
                    requestUrl = `/${Util.srfpluralize(actionContext.context.srfparentdename).toLowerCase()}/${actionContext.context.srfparentkey}` + requestUrl;
                }
            } else {
                actionContext.$throw(actionContext.$t('app.utilview.nodatakey'), 'execute');
                return;
            }
            requestUrl += `?srfprinttag=${appDEPrint.codeName}`;
            Http.getHttp()({
                url: requestUrl,
                method: 'get',
                responseType: 'blob',
            }).then((response: any) => {
                if (response.status == 200 && response.data) {
                    const link = window.URL.createObjectURL(response.data);
                    window.open(link, '_blank');
                } else {
                    actionContext.$throw(actionContext.$t('app.utilview.printerror'), 'execute');
                }
            });
        } else {
            actionContext.$throw(actionContext.$t('app.utilview.noprint'), 'execute');
        }
    }

    /**
     * 执行数据导入
     *
     * @param {*} actionContext
     * @param {IContext} context
     * @param {IParams} viewparams
     * @memberof AppFrontAction
     */
    async executeDataImport(actionContext: any, context: IContext, viewparams: IParams) {
        const appDataEntity: IPSAppDataEntity = this.actionModel.getPSAppDataEntity() as IPSAppDataEntity;
        const appDEDataImport = this.actionModel.getPSAppDEDataImport();
        if (!appDEDataImport) {
            actionContext.$warning((actionContext.$t("app.utilview.info") as string), 'executeDataImport');
            return;
        }
        const view: any = {
            viewname: 'app-data-upload',
            title: actionContext.$t("app.utilview.importview"),
            width: 544,
            height: 368,
            customClass: 'app-data-upload-modal view-default'
        }
        const tempContext = Util.deepCopy(context);
        //  存在父添加父主键信息
        if (actionContext.context && actionContext.context.srfparentdename && actionContext.context.srfparentkey) {
            Object.assign(tempContext, { srfparentdename: actionContext.context.srfparentdename });
            Object.assign(tempContext, { srfparentkey: actionContext.context.srfparentkey });
        } else {
            if (tempContext.srfparentdename) {
                delete tempContext.srfparentdename;
            }
            if (tempContext.srfparentkey) {
                delete tempContext.srfparentkey;
            }
        }
        let container: Subject<any> = actionContext.$appmodal.openModal(view, tempContext, {
            importId: appDEDataImport.codeName,
            serviceName: appDataEntity.codeName,
            appDeLogicName: appDataEntity.logicName,
            ignoreError: appDEDataImport?.ignoreError
        });
        container.subscribe((result: any) => {
            if (Object.is(result.ret, 'OK')) {
                actionContext.refresh(result.datas);
            }
        });
    }

    /**
     * 执行数据导出
     *
     * @param {*} actionContext
     * @param {IContext} context
     * @param {IParams} viewparams
     * @memberof AppFrontAction
     */
    async executeDataExport(actionContext: any, context: IContext, viewparams: IParams) {
        const appDataEntity: IPSAppDataEntity = this.actionModel.getPSAppDataEntity() as IPSAppDataEntity;
        const appDEDataExport = this.actionModel.getPSAppDEDataExport();
        if (!appDEDataExport) {
            actionContext.$throw(actionContext.$t('app.grid.exportexcel.error'), 'executeDataExport');
            return;
        }
        let url: string = `/${Util.srfpluralize(appDataEntity.codeName).toLowerCase()}/exportdata/fetchdefault`;
        //  存在父添加父主键信息
        if (actionContext.context && actionContext.context.srfparentdename && actionContext.context.srfparentkey) {
            url = `/${Util.srfpluralize(actionContext.context.srfparentdename).toLowerCase()}/${actionContext.context.srfparentkey}` + url;
        }
        //  参数
        const params: any = {};
        url += `?srfexporttag=${appDEDataExport.codeName}`
        Object.assign(params, { page: 0, size: appDEDataExport.maxRowCount ? appDEDataExport.maxRowCount : 1000 });
        Http.getHttp()({
            url: url,
            method: 'post',
            data: params,
            responseType: 'blob'
        }).then((response: any) => {
            if (!response || response.status !== 200) {
                return;
            }
            let fileName = `${appDataEntity.logicName}` + (actionContext.$t('app.grid.grid') as string) + '.xlsx';;
            fileName = decodeURIComponent(fileName);
            let blob = new Blob([response.data], { type: 'application/vnd.ms-excel' });
            let elink = document.createElement('a');
            elink.download = fileName;
            elink.style.display = 'none';
            elink.href = URL.createObjectURL(blob);
            document.body.appendChild(elink);
            elink.click();
            URL.revokeObjectURL(elink.href); // 释放URL 对象
            document.body.removeChild(elink);
        }).catch((error: any) => {
            try {
                const reader = new FileReader();
                reader.readAsText(error.data, 'utf-8');
                reader.onload = (event: any) => {
                    const message = JSON.parse(event.target.result)?.message;
                    actionContext.$throw(message ? message : actionContext.$t('app.grid.exportexcel.error'), 'exportExcel');
                }
            } catch (error) {
                actionContext.$throw(actionContext.$t('app.grid.exportexcel.error'), 'exportExcel');
            }
        })
    }
}