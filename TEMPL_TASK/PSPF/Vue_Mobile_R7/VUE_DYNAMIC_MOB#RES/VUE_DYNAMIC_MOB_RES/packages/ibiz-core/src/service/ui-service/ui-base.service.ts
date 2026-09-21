import { IPSAppDataEntity, IPSAppDEField, IPSAppDEView, IPSAppView, IPSAppWF, IPSAppWFDE, IPSDEMainState, IPSDEMainStateOPPriv, IPSDEOPPriv } from '@ibiz/dynamic-model-api';
import { IContext, IParams, IRedirectResult, IRunTimeData } from '../../interface';
import { LogUtil, ModelTool } from '../../utils';
import { AppServiceBase } from '../app-service/app-base.service';
import { AuthServiceHelp } from '../auth-service';
import { DataServiceHelp } from '../data-service';

/**
 * 界面服务基类
 *
 * @export
 * @class UIServiceBase
 */
export class UIServiceBase {

    /**
     * 应用实体模型
     *
     * @protected
     * @type {IPSAppDataEntity}
     * @memberof UIServiceBase
     */
    protected appDataEntity !: IPSAppDataEntity;

    /**
     * 应用存储对象
     *
     * @protected
     * @type {any}
     * @memberof UIServiceBase
     */
    protected $store: any;

    /**
     * 流程状态数组
     *
     * @protected
     * @type {Array<string>}
     * @memberof UIServiceBase
     */
    protected InWorkflowArray: Array<string> = ['todo', 'toread'];

    /**
     * 应用上下文
     *
     * @protected
     * @type {any}
     * @memberof UIServiceBase
     */
    protected context: any;

    /**
     * 所依赖权限服务
     *
     * @memberof UIServiceBase
     */
    protected authService: any;

    /**
     * 所依赖数据服务
     *
     * @memberof  UIServiceBase
     */
    protected dataService: any;

    /**
     * 是否支持实体主状态
     *
     * @memberof  UIServiceBase
     */
    protected isEnableDEMainState: boolean = false;

    /**
     * 界面行为Map
     *
     * @memberof  UIServiceBase
     */
    protected actionMap: Map<string, any> = new Map();

    /**
     * 状态值
     *
     * @memberof  UIServiceBase
     */
    protected stateValue: number = 0;

    /**
     * 状态属性
     *
     * @memberof  UIServiceBase
     */
    protected stateField: string = '';

    /**
     * 多表单属性
     *
     * @memberof  UIServiceBase
     */
    protected multiFormDEField: string | null = null;

    /**
     * 索引类型属性
     *
     * @memberof  UIServiceBase
     */
    protected indexTypeDEField: string | null = null;

    /**
     * 临时组织标识属性
     *
     * @memberof  UIServiceBase
     */
    protected tempOrgIdDEField: string | null = null;

    /**
     * 动态实例标记
     *
     * @memberof  UIServiceBase
     */
    protected dynaInstTag: string | null = null;

    /**
     * 主状态属性集合
     *
     * @memberof  UIServiceBase
     */
    protected mainStateFields: Array<any> = [];

    /**
     * 主状态集合Map
     *
     * @memberof  UIServiceBase
     */
    protected allDeMainStateMap: Map<string, string> = new Map();

    /**
     * 主状态操作标识Map
     *
     * @memberof  UIServiceBase
     */
    protected allDeMainStateOPPrivsMap: Map<string, any> = new Map();

    /**
     * Creates an instance of UIServiceBase.
     *
     * @param {*} [opts={}]
     * @memberof UIServiceBase
     */
    constructor(appDataEntity: IPSAppDataEntity | null = null, runTimeData: IRunTimeData = {}) {
        if (appDataEntity) {
            this.appDataEntity = appDataEntity;
        }
        this.$store = AppServiceBase.getInstance().getAppStore();
        this.context = runTimeData && runTimeData.context ? runTimeData.context : {};
    }

    /**
     * 获取应用存储对象
     *
     * @returns {(any | null)}
     * @memberof UIServiceBase
     */
    public getStore() {
        return this.$store;
    }

    /**
     * UI服务初始化（异步）
     *
     * @memberof  UIServiceBase
     */
    public async loaded() {
        if (this.appDataEntity) {
            await this.initBasicData();
            await this.initBasicService();
            await this.initActionMap();
            await this.initDeMainStateMap();
            await this.initDeMainStateOPPrivsMap();
        }
    }

    /**
     * 初始化基础服务
     *
     * @memberof  UIServiceBase
     */
    protected async initBasicService() {
        this.dataService = await DataServiceHelp.getInstance().getService(this.appDataEntity, { context: this.context });
        this.authService = await AuthServiceHelp.getInstance().getService(this.appDataEntity, { context: this.context });
    }

    /**
     * 初始化基础数据
     *
     * @memberof  UIServiceBase
     */
    protected async initBasicData() {
        this.mainStateFields = [];
        if (this.appDataEntity.enableDEMainState) {
            this.isEnableDEMainState = true;
        }
        if (this.appDataEntity.dynaInstTag) {
            this.dynaInstTag = this.appDataEntity.dynaInstTag;
        }
        // 临时组织标识属性
        const orgIdPSAppDEField: IPSAppDEField | null = this.appDataEntity.getOrgIdPSAppDEField();
        if (orgIdPSAppDEField) {
            this.tempOrgIdDEField = (orgIdPSAppDEField as IPSAppDEField).codeName.toLowerCase();
        }
        // 多表单属性
        const formTypePSAppDEField: IPSAppDEField | null = this.appDataEntity.getFormTypePSAppDEField();
        if (formTypePSAppDEField) {
            this.multiFormDEField = (formTypePSAppDEField as IPSAppDEField).codeName.toLowerCase();
        }
        // 索引类型属性
        const indexTypePSAppDEField: IPSAppDEField | null = this.appDataEntity.getIndexTypePSAppDEField();
        if (indexTypePSAppDEField) {
            this.indexTypeDEField = (indexTypePSAppDEField as IPSAppDEField).codeName.toLowerCase();
        }
        // 主状态属性集合
        const mainStatePSAppDEFields: IPSAppDEField[] | null = this.appDataEntity.getMainStatePSAppDEFields();
        if (mainStatePSAppDEFields && mainStatePSAppDEFields.length > 0) {
            mainStatePSAppDEFields.forEach((appField: IPSAppDEField) => {
                this.mainStateFields.push(appField.codeName.toLowerCase());
            })
        }
        // 工作流相关
        const APP = AppServiceBase.getInstance().getAppModelDataObject();
        const appDeWF: IPSAppWF | null = APP.findPSAppWF(this.appDataEntity.codeName);
        if (appDeWF && appDeWF.getPSAppWFDEs()) {
            const appWFDEs: IPSAppWFDE[] | null = appDeWF.getPSAppWFDEs();
            if (appWFDEs) {
                const curWorkFlow = appWFDEs.find((item: any) => {
                    return item.getPSAppDataEntity()?.codeName === this.appDataEntity.codeName;
                })
                if (curWorkFlow && curWorkFlow.entityWFState) {
                    // 状态值
                    this.stateValue = Number(curWorkFlow.entityWFState);
                }
                if (curWorkFlow && curWorkFlow.getWFStatePSAppDEField()) {
                    // 状态属性
                    this.stateField = (curWorkFlow.getWFStatePSAppDEField() as IPSAppDEField).codeName.toLowerCase();
                }
            }
        }
    }

    /**
     * 初始化界面行为数据
     *
     * @memberof  UIServiceBase
     */
    protected async initActionMap(): Promise<void> {
        const actions = this.appDataEntity.getAllPSAppDEUIActions();
        if (actions && actions.length > 0) {
            for (const element of actions) {
                const targetAction: any = await (window as any).AppActionFactory.getInstance(element, this.context);
                this.actionMap.set(element.uIActionTag, targetAction);
            }
        }
    }

    /**
     * 初始化主状态集合
     *
     * @memberof  UIServiceBase
     */
    protected async initDeMainStateMap() {
        if (
            this.appDataEntity &&
            this.appDataEntity.getAllPSDEMainStates() &&
            (this.appDataEntity.getAllPSDEMainStates() as IPSDEMainState[]).length > 0
        ) {
            (this.appDataEntity.getAllPSDEMainStates() as IPSDEMainState[]).forEach((element: IPSDEMainState) => {
                this.allDeMainStateMap.set(element.mSTag, element.mSTag);
            });
        }
    }

    /**
     * 初始化主状态操作标识
     *
     * @memberof  UIServiceBase
     */
    protected async initDeMainStateOPPrivsMap() {
        if (
            this.appDataEntity &&
            this.appDataEntity.getAllPSDEMainStates() &&
            (this.appDataEntity.getAllPSDEMainStates() as IPSDEMainState[]).length > 0
        ) {
            (this.appDataEntity.getAllPSDEMainStates() as IPSDEMainState[]).forEach((element: IPSDEMainState) => {
                let tempMainStateOPPrivs: any = {};
                if (
                    this.appDataEntity &&
                    this.appDataEntity.getAllPSDEOPPrivs() &&
                    (this.appDataEntity.getAllPSDEOPPrivs() as IPSDEOPPriv[]).length > 0
                ) {
                    (this.appDataEntity.getAllPSDEOPPrivs() as IPSDEOPPriv[]).forEach((deOPPriv: IPSDEOPPriv) => {
                        if (element.oPPrivAllowMode) {
                            tempMainStateOPPrivs[deOPPriv.name] = 0;
                        } else {
                            tempMainStateOPPrivs[deOPPriv.name] = 1;
                        }
                    });
                }
                if (
                    element.getPSDEMainStateOPPrivs() &&
                    (element.getPSDEMainStateOPPrivs() as IPSDEMainStateOPPriv[]).length > 0
                ) {
                    (element.getPSDEMainStateOPPrivs() as IPSDEMainStateOPPriv[]).forEach(
                        (mainStateOPPriv: IPSDEMainStateOPPriv) => {
                            if (element.oPPrivAllowMode) {
                                tempMainStateOPPrivs[mainStateOPPriv.name] = 1;
                            } else {
                                tempMainStateOPPrivs[mainStateOPPriv.name] = 0;
                            }
                        },
                    );
                }
                this.allDeMainStateOPPrivsMap.set(element.mSTag, tempMainStateOPPrivs);
            });
        }
    }

    /**
     * 获取资源标识是否有权限(无数据目标)
     *
     * @param tag 资源标识
     * @memberof  UIServiceBase
     */
    protected getResourceOPPrivs(tag: any) {
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        if (!Environment.enablePermissionValid) {
            return 1;
        }
        return this.authService.getResourcePermission(this.authService.sysOPPrivsMap.get(tag)) ? 1 : 0;
    }

    /**
     * 获取指定数据的重定向页面
     *
     * @param context 应用上下文
     * @param viewparam 视图参数
     * @param data  业务数据
     * @param redirectParam 重定向视图参数 (获取数据行为和数据识别参数)
     * @memberof  UIServiceBase
     */
    protected async getRDAppView(context: IContext, viewParam: IParams, data: IParams = {}, redirectParam: IParams = {}): Promise<IRedirectResult> {
        // 进行数据查询
        let returnData: IRedirectResult = {};
        const key: string = this.appDataEntity.codeName.toLowerCase();
        let srfkey: string | null = null;
        if (data && data.hasOwnProperty(key)) {
            srfkey = data[key];
        } else if (context && context[key]) {
            srfkey = context[key];
        } else if (viewParam && viewParam[key]) {
            srfkey = viewParam[key];
        }
        Object.assign(context, { [key]: srfkey });
        let result: any = {};
        try {
            if (
                redirectParam && redirectParam.action && this.dataService
            ) {
                result = await this.dataService.execute(redirectParam.action, context, viewParam);
            } else {
                result = await this.dataService.execute('Get', context, viewParam);
            }
        } catch (error: any) {
            AppServiceBase.getInstance().getNotification().error(error?.message ? error.message : '获取数据异常');
            throw new Error(error?.message ? error.message : '获取数据异常');
        }
        const curData: any = result.data;
        // 设置原始数据
        if (curData && Object.keys(curData).length > 0) {
            Object.assign(returnData, { 'srfdata': curData });
        }
        let bDataInWF: boolean = false;
        // 计算数据模式
        if (
            (viewParam &&
                viewParam.srfwf &&
                this.InWorkflowArray.indexOf(viewParam.srfwf) !== -1)
        ) {
            bDataInWF = true;
        }
        let strPDTViewParam: string = await this.getDESDDEViewPDTParam(bDataInWF, curData, redirectParam);
        // 工作流
        if (bDataInWF) {
            Object.assign(returnData, { 'param': strPDTViewParam, 'srfstate': 'inwf' });
            return returnData;
        }
        // 多表单识别属性
        if (this.multiFormDEField) {
            Object.assign(returnData, { 'param': strPDTViewParam, 'srfstate': 'multiform' });
            return returnData;
        }
        // 索引类型属性
        if (this.indexTypeDEField) {
            Object.assign(returnData, { 'param': strPDTViewParam, 'srfstate': 'indextype' });
            return returnData;
        }
        // 自定义重定向
        if (redirectParam && redirectParam.type) {
            Object.assign(returnData, { 'param': strPDTViewParam, 'srfstate': 'redirectitem' });
            return returnData;
        }
        //返回视图功能数据
        Object.assign(returnData, { 'param': strPDTViewParam, 'srfstate': 'funcview' });
        return returnData;
    }

    /**
     * 获取实际的数据类型
     *
     * @memberof  UIServiceBase
     */
    protected getRealDEType(entity: any) { }

    /**
     * 获取实体单数据实体视图预定义参数
     *
     * @param bDataInWF 是否有数据在工作流中
     * @param curData 当前数据
     * @param redirectParam 重定向参数
     * @memberof  UIServiceBase
     */
    protected async getDESDDEViewPDTParam(bDataInWF: boolean, curData: any, redirectParam: any) {
        let strPDTParam: string = '';
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        if (bDataInWF) {
            // 存在多表单属性
            if (this.multiFormDEField) {
                strPDTParam = '';
                const formFieldValue: string = curData[this.multiFormDEField] ? curData[this.multiFormDEField] : '';
                if (formFieldValue) {
                    if (!Environment.isAppMode) {
                        strPDTParam += 'MOBWFEDITVIEW:' + formFieldValue;
                    }
                    strPDTParam += 'WFEDITVIEW:' + formFieldValue;
                    return strPDTParam;
                }
            }
            // 存在索引类型属性
            if (this.indexTypeDEField) {
                strPDTParam = '';
                const indexTypeValue: string = curData[this.indexTypeDEField] ? curData[this.indexTypeDEField] : '';
                if (indexTypeValue) {
                    if (!Environment.isAppMode) {
                        strPDTParam += 'MOBWFEDITVIEW:' + indexTypeValue;
                    }
                    strPDTParam += 'WFEDITVIEW:' + indexTypeValue;
                }
                return strPDTParam;
            }
            return strPDTParam ? strPDTParam : 'MOBWFEDITVIEW';
        }
        // 存在多表单属性
        if (this.multiFormDEField) {
            const formFieldValue: string = curData[this.multiFormDEField] ? curData[this.multiFormDEField] : '';
            if (formFieldValue) {
                if (!Environment.isAppMode) {
                    let tempParam = 'MOBEDITVIEW:' + formFieldValue;
                    return tempParam;
                }
                let tempParam = 'EDITVIEW:' + formFieldValue;
                return tempParam;
            }
        }
        // 存在索引类型属性
        if (this.indexTypeDEField) {
            const indexTypeValue: string = curData[this.indexTypeDEField] ? curData[this.indexTypeDEField] : '';
            if (indexTypeValue) {
                if (!Environment.isAppMode) {
                    return 'MOBEDITVIEW:' + indexTypeValue;
                }
                return 'EDITVIEW:' + indexTypeValue;
            }
        }
        // 自定义重定向
        if (redirectParam && redirectParam.type) {
            const typeValue = curData[redirectParam.type.toLowerCase()];
            if (typeValue) {
                if (!Environment.isAppMode) {
                    let tempParam = typeValue;
                    return tempParam;
                }
                let tempParam = typeValue;
                return tempParam;
            }
        }
        if (!Environment.isAppMode) {
            if (this.getDEMainStateTag(curData)) {
                return `MOBEDITVIEW:MSTAG:${this.getDEMainStateTag(curData)}`;
            }
            return 'MOBEDITVIEW:';
        }
        if (this.getDEMainStateTag(curData)) {
            return `EDITVIEW:MSTAG:${this.getDEMainStateTag(curData)}`;
        }
        return 'MOBEDITVIEW:';
    }

    /**
     * 获取数据对象的主状态标识
     *
     * @param curData 当前数据
     * @memberof  UIServiceBase
     */
    protected getDEMainStateTag(curData: any) {
        if (this.mainStateFields.length === 0) return null;

        this.mainStateFields.forEach((singleMainField: any) => {
            if (!(singleMainField in curData)) {
                LogUtil.warn(
                    `当前数据对象不包含属性「${singleMainField}」，根据「${singleMainField}」属性进行的主状态计算默认为空值`,
                );
            }
        });
        for (let i = 0; i <= 1; i++) {
            let strTag: string =
                curData[this.mainStateFields[0]] != null && curData[this.mainStateFields[0]] !== ''
                    ? i == 0
                        ? `${curData[this.mainStateFields[0]]}`
                        : ''
                    : '';
            if (this.mainStateFields.length >= 2) {
                for (let j = 0; j <= 1; j++) {
                    let strTag2: string =
                        curData[this.mainStateFields[1]] != null && curData[this.mainStateFields[1]] !== ''
                            ? `${strTag}__${j == 0 ? `${curData[this.mainStateFields[1]]}` : ''}`
                            : strTag;
                    if (this.mainStateFields.length >= 3) {
                        for (let k = 0; k <= 1; k++) {
                            let strTag3: string =
                                curData[this.mainStateFields[2]] != null && curData[this.mainStateFields[2]] !== ''
                                    ? `${strTag2}__${k == 0 ? `${curData[this.mainStateFields[2]]}` : ''}`
                                    : strTag2;
                            // 判断是否存在
                            return this.allDeMainStateMap.get(strTag3);
                        }
                    } else {
                        return this.allDeMainStateMap.get(strTag2);
                    }
                }
            } else {
                return this.allDeMainStateMap.get(strTag);
            }
        }
        return null;
    }

    /**
     * 获取数据对象当前操作标识
     *
     * @param data 当前数据
     * @memberof  UIServiceBase
     */
    protected getDEMainStateOPPrivs(data: any) {
        if (this.getDEMainStateTag(data)) {
            return this.allDeMainStateOPPrivsMap.get(this.getDEMainStateTag(data) as string);
        } else {
            return null;
        }
    }

    /**
     * 应用实体映射实体名称
     *
     * @readonly
     * @memberof UIServiceBase
     */
    get deName() {
        return (this.appDataEntity as any)?.getPSDEName() || '';
    }

    /**
     * 应用实体主键属性
     *
     * @readonly
     * @memberof UIServiceBase
     */
    get appDeKeyFieldName() {
        return (
            (ModelTool.getAppEntityKeyField(this.appDataEntity) as IPSAppDEField)?.codeName || ''
        );
    }
}