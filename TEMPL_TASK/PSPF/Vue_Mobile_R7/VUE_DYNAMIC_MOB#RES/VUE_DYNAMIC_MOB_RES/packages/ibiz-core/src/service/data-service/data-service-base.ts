import { IPSAppDataEntity, IPSAppDEField, IPSAppDELogic, IPSAppDEMethod, IPSAppDEMethodDTO, IPSAppDERS, IPSApplication } from "@ibiz/dynamic-model-api";
import { ascSort, createUUID, descSort, generateOrderValue, notNilEmpty } from "qx-util";
import { clone, equals, isEmpty, isNil, where } from "ramda";
import { IContext, IEntityBase, IEntityLocalDataService, IHttpResponse, IParams, IRunTimeData } from "../../interface";
import { EntityCache, Http, HttpResponse, LogUtil, PSDEDQCondEngine, SearchFilter, Util } from "../../utils";
import { AppServiceBase } from "../app-service/app-base.service";
import { EntityDBService } from "./db";
import { MethodDto } from "./dto";
import { Entity } from "./entity";
import { AppDeLogicService } from "./logic";
import { AppMethodHelp } from "./method";

/**
 * 实体服务基类
 *
 * @export
 * @class DataBaseService
 * @implements {IEntityLocalDataService<T>}
 * @template T
 */
export class DataBaseService<T extends IEntityBase> implements IEntityLocalDataService<T> {
    /**
     * 统一日志输出工具类
     *
     * @protected
     * @memberof DataBaseService
     */
    protected log = LogUtil;

    /**
     * 应用实体模型
     *
     * @protected
     * @type {IPSAppDataEntity}
     * @memberof DataBaseService
     */
    protected appDataEntity !: IPSAppDataEntity;

    /**
     * 应用实体代码名称
     *
     * @protected
     * @memberof DataBaseService
     */
    protected APPDENAME = '';

    /**
     * 应用实体名称(工作流相关)
     *
     * @protected
     * @memberof DataBaseService
     */
    protected APPWFDENAME = '';

    /**
     * 应用实体名称复数形式
     *
     * @protected
     * @memberof DataBaseService
     */
    protected APPDENAMEPLURAL = '';

    /**
     * 应用实体主键
     *
     * @protected
     * @memberof DataBaseService
     */
    protected APPDEKEY = '';

    /**
     * 应用实体主文本
     *
     * @protected
     * @memberof DataBaseService
     */
    protected APPDETEXT = '';

    /**
     * 系统名称
     *
     * @protected
     * @memberof DataBaseService
     */
    protected SYSTEMNAME = '';

    /**
     * 应用名称
     *
     * @protected
     * @memberof DataBaseService
     */
    protected APPNAME = '';

    /**
     * 当前实体服务支持快速搜索的属性
     *
     * @protected
     * @type {string[]}
     * @memberof DataBaseService
     */
    protected quickSearchFields: string[] = [];

    /**
     * 根据关系，select查询时填充额外条件。
     *
     * @protected
     * @type {*}
     * @memberof DataBaseService
     */
    protected selectContextParam: any = null;

    /**
     * 搜索条件引擎实例缓存
     *
     * @protected
     * @type {Map<string, PSDEDQCondEngine>}
     * @memberof DataBaseService
     */
    protected condCache: Map<string, PSDEDQCondEngine> = new Map();

    /**
     * http请求服务
     *
     * @protected
     * @memberof DataBaseService
     */
    protected http = Http.getInstance();

    /**
     * 数据缓存
     *
     * @protected
     * @type {EntityCache<T>}
     * @memberof DataBaseService
     */
    protected cache: EntityCache<T> = new EntityCache();

    /**
     * 实体方法Map
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof DataBaseService
     */
    protected appDEDynaMethodMap: Map<string, any> = new Map();

    /**
     * 应用实体方法DTO映射Map
     *
     * @private
     * @type {Map<string, MethodDto>}
     * @memberof DataBaseService
     */
    public methodDtoMap: Map<string, MethodDto> = new Map();

    /**
     * 实体处理逻辑Map
     *
     * @protected
     * @type {Map<string,any>}
     * @memberof DataBaseService
     */
    public appDeLogicMap: Map<string, any> = new Map();

    /**
     * 实体属性处理逻辑Map
     *
     * @protected
     * @type {Map<string,any>}
     * @memberof DataBaseService
     */
    public appDeFieldLogicMap: Map<string, any> = new Map();

    /**
     * 存储模式
     *
     * @type {(0 | 1 | 3)} 无本地存储 | 仅本地存储 | 本地及远程存储
     */
    readonly storageMode: number = 0;

    /**
     * 数据库
     *
     * @type {DBService<T>}
     */
    db!: EntityDBService<T>;

    /**
     * 是否仅本地存储
     *
     * @readonly
     * @type {boolean}
     * @memberof DataBaseService
     */
    get isLocalStore(): boolean {
        return this.storageMode === 1;
    }

    /**
     * 应用实体全部属性
     * 
     *
     * @readonly
     * @type {string[]}
     * @memberof DataBaseService
     */
    get keys(): string[] {
        const keys: string[] = [];
        if (this.appDataEntity && this.appDataEntity.getAllPSAppDEFields()) {
            const fields = this.appDataEntity.getAllPSAppDEFields() || [];
            if (fields && fields?.length > 0) {
                fields.forEach((field: IPSAppDEField) => {
                    keys.push(field.codeName.toLowerCase());
                })
            }
        }
        return keys;
    }

    /**
     * Creates an instance of DataBaseService.
     * @param {string} [dbName]
     * @param {number} [storageMode]
     * @memberof DataBaseService
     */
    public constructor(appDataEntity: IPSAppDataEntity | null, runTimeData: IRunTimeData = {}) {
        if (appDataEntity) {
            this.appDataEntity = appDataEntity;
            const { codeName, storageMode } = appDataEntity;
            if (notNilEmpty(storageMode)) {
                this.storageMode = storageMode!;
            }
            if (this.isLocalStore && codeName) {
                this.db = new EntityDBService<T>(
                    codeName,
                    (data: any): T => {
                        return this.newEntity(data);
                    },
                    (entity: T): any => {
                        return this.filterEntityData(entity);
                    },
                );
            }
        }
    }

    /**
     * 加载动态数据模型
     *
     * @protected
     * @memberof DataBaseService
     */
    public async loaded() {
        if (this.appDataEntity) {
            this.initAppDEBaseDynaDatas();
            this.initAppDELogics();
            this.initAppDEFieldLogics();
            this.initAppDEMethodDtos();
            await this.initAppDEDynaMethods();
        }
    }

    /**
     * 初始化数据服务基础数据
     *
     * @protected
     * @memberof DataBaseService
     */
    protected initAppDEBaseDynaDatas() {
        const app: IPSApplication = AppServiceBase.getInstance().getAppModelDataObject();
        this.SYSTEMNAME = app.sysCodeName;
        this.APPNAME = app.codeName;
        if (this.appDataEntity) {
            this.APPDENAME = Util.srfClassName(this.appDataEntity.codeName);
            this.APPWFDENAME = this.appDataEntity.name;
            this.APPDENAMEPLURAL = Util.srfpluralize(this.appDataEntity.codeName);
            if (this.appDataEntity && this.appDataEntity.getKeyPSAppDEField()) {
                this.APPDEKEY = (this.appDataEntity.getKeyPSAppDEField() as IPSAppDEField).codeName.toLowerCase();
            }
            if (this.appDataEntity && this.appDataEntity.getMajorPSAppDEField()) {
                this.APPDETEXT = (this.appDataEntity.getMajorPSAppDEField() as IPSAppDEField).codeName.toLowerCase();
            }
            this.quickSearchFields = this.getQuickSearchFields();
            this.selectContextParam = this.getSelectContextParam();
        }
    }

    /**
     * 初始化实体处理逻辑
     *
     * @protected
     * @memberof DataBaseService
     */
    protected initAppDELogics() {
        if (this.appDeLogicMap.size === 0 && this.appDataEntity && this.appDataEntity.getAllPSAppDELogics()) {
            this.appDataEntity.getAllPSAppDELogics()?.forEach((item: IPSAppDELogic) => {
                this.appDeLogicMap.set(item.codeName, item);
            });
        }
    }

    /**
     * 初始化实体属性处理逻辑
     *
     * @protected
     * @memberof DataBaseService
     */
    protected initAppDEFieldLogics() {
        const allAppDEFields: IPSAppDEField[] | null = this.appDataEntity?.getAllPSAppDEFields();
        if (allAppDEFields && allAppDEFields.length > 0 && this.appDeFieldLogicMap.size === 0) {
            allAppDEFields.forEach((item: IPSAppDEField) => {
                if (item.getComputePSAppDEFLogic()) {
                    let computePSAppDEFLogics = this.appDeFieldLogicMap.get('ComputePSAppDEFLogic');
                    if (!computePSAppDEFLogics) {
                        computePSAppDEFLogics = [];
                        this.appDeFieldLogicMap.set('ComputePSAppDEFLogic', computePSAppDEFLogics);
                    }
                    computePSAppDEFLogics.push(item.getComputePSAppDEFLogic());
                }
                if (item.getOnChangePSAppDEFLogic()) {
                    let changePSAppDEFLogics = this.appDeFieldLogicMap.get('ChangePSAppDEFLogic');
                    if (!changePSAppDEFLogics) {
                        changePSAppDEFLogics = [];
                        this.appDeFieldLogicMap.set('ChangePSAppDEFLogic', changePSAppDEFLogics);
                    }
                    changePSAppDEFLogics.push(item.getOnChangePSAppDEFLogic());
                }
                if (item.getDefaultValuePSAppDEFLogic()) {
                    let defaultValuePSAppDEFLogics = this.appDeFieldLogicMap.get('DefaultValuePSAppDEFLogic');
                    if (!defaultValuePSAppDEFLogics) {
                        defaultValuePSAppDEFLogics = [];
                        this.appDeFieldLogicMap.set('DefaultValuePSAppDEFLogic', defaultValuePSAppDEFLogics);
                    }
                    defaultValuePSAppDEFLogics.push(item.getOnChangePSAppDEFLogic());
                }
            });
        }
    }

    /**
     * 应用实体方法DTO对象
     *
     * @protected
     * @memberof DataBaseService
     */
    protected initAppDEMethodDtos() {
        if (this.appDataEntity && this.appDataEntity.getAllPSAppDEMethodDTOs()) {
            (this.appDataEntity.getAllPSAppDEMethodDTOs() as IPSAppDEMethodDTO[]).forEach((appDEMethodDTO: IPSAppDEMethodDTO) => {
                if (appDEMethodDTO.type == 'DEFAULT') {
                    const methodDto = new MethodDto(this.appDataEntity, appDEMethodDTO);
                    this.methodDtoMap.set(appDEMethodDTO.codeName, methodDto);
                }
            })
        }
    }

    /**
     * 获取当前实体服务支持快速搜索的属性
     *
     * @private
     * @return {*} 
     * @memberof DataBaseService
     */
    private getQuickSearchFields() {
        const quickSearchFields: string[] = [];
        if (this.appDataEntity && this.appDataEntity.getQuickSearchPSAppDEFields()) {
            (this.appDataEntity.getQuickSearchPSAppDEFields() as IPSAppDEField[]).forEach((quickSearchField: IPSAppDEField) => {
                quickSearchFields.push(quickSearchField.codeName.toLowerCase());
            })
        }
        return quickSearchFields;
    }

    /**
     * 根据关系，select查询时填充额外条件
     *
     * @private
     * @return {*} 
     * @memberof DataEntityService
     */
    private getSelectContextParam() {
        const selectContextParam = {};
        if (this.appDataEntity && this.appDataEntity.getMinorPSAppDERSs()) {
            (this.appDataEntity.getMinorPSAppDERSs() as IPSAppDERS[]).forEach((minorPSAppDERs: IPSAppDERS) => {
                Object.assign(selectContextParam, { [minorPSAppDERs.majorDECodeName.toLowerCase()]: minorPSAppDERs.getParentPSAppDEField()?.codeName.toLowerCase() });
            })
        }
        return selectContextParam;
    }

    /**
     * 初始化实体方法
     *
     * @protected
     * @memberof DataBaseService
     */
    protected async initAppDEDynaMethods() {
        if (this.appDataEntity && this.appDataEntity.getAllPSAppDEMethods()) {
            (this.appDataEntity.getAllPSAppDEMethods() as IPSAppDEMethod[]).forEach(async (item: IPSAppDEMethod) => {
                this.appDEDynaMethodMap.set(item.codeName.toLowerCase(), await AppMethodHelp.getInstance({ dataEntity: this.appDataEntity, dataService: this }, item));
            });
        }
    }

    /**
     * 执行实体处理逻辑
     *
     * @protected
     * @param {string} tag 逻辑标识
     * @param {*} _context 应用上下文
     * @param {*} _data 当前数据
     * @memberof DataBaseService
     */
    protected async executeAppDELogic(tag: string, _context: any, _data: any) {
        try {
            return await AppDeLogicService.getInstance().onExecute(this.appDeLogicMap.get(tag), _context, _data);
        } catch (error: any) {
            throw new Error(`执行实体处理逻辑异常，[逻辑错误]${error.message}`);
        }
    }

    /**
     * 执行实体属性处理逻辑
     *
     * @protected
     * @param {*} model 模型对象
     * @param {*} _context 应用上下文
     * @param {*} _data 当前数据
     * @memberof DataBaseService
     */
    protected async executeAppDEFieldLogic(model: any, _context: any, _data: any) {
        try {
            return await AppDeLogicService.getInstance().onExecute(model, _context, _data);
        } catch (error: any) {
            throw new Error(`执行实体属性处理逻辑异常，[逻辑错误]${error.message}`);
        }
    }

    /**
     * 执行实体行为之前
     *
     * @protected
     * @param {*} _context 应用上下文
     * @param {*} _data 当前数据
     * @param {string} methodName 方法名
     * @memberof DataBaseService
     */
    protected async beforeExecuteAction(_context: any, _data: any, methodName?: string) {
        // 执行实体属性值变更逻辑
        _data = await this.executeOnChangePSAppDEFLogic(_context, _data);
        if (methodName) {
            LogUtil.log(`执行实体属性值变更逻辑，[方法名称]：${methodName}，[处理后的数据]:`, _data);
        }
        return _data;
    }

    /**
     * 执行实体行为之后
     *
     * @protected
     * @param {*} _context 应用上下文
     * @param {*} _data 当前数据
     * @param {string} methodName 方法名
     * @memberof EntityBaseService
     */
    protected async afterExecuteAction(_context: any, _data: any, methodName?: string) {
        // 执行实体属性值计算逻辑
        _data = await this.executeComputePSAppDEFLogic(_context, _data);
        if (methodName) {
            LogUtil.log(`执行实体属性值计算逻辑，[方法名称]：${methodName}，[处理后的数据]:`, _data);
        }
        return _data;
    }

    /**
     * 执行实体行为之后批处理（主要用于数据集处理）
     *
     * @protected
     * @param {*} _context 应用上下文
     * @param {*} dataSet 当前数据集合
     * @param {string} methodName 方法名
     * @memberof EntityBaseService
     */
    protected async afterExecuteActionBatch(_context: any, dataSet: Array<any>, methodName?: string) {
        if (dataSet && dataSet.length > 0) {
            for (let i = 0; i < dataSet.length; i++) {
                dataSet[i] = await this.afterExecuteAction(_context, dataSet[i]);
            }
        }
        if (methodName) {
            LogUtil.log(`执行实体属性值计算逻辑，[方法名称]：${methodName}，[处理后的数据]:`, dataSet);
        }
        return dataSet;
    }

    /**
     * 执行实体属性值计算逻辑
     *
     * @protected
     * @param {*} _context 应用上下文
     * @param {*} _data 当前数据
     * @memberof EntityBaseService
     */
    protected async executeComputePSAppDEFLogic(_context: any, _data: any) {
        let computePSAppDEFLogics = this.appDeFieldLogicMap.get('ComputePSAppDEFLogic');
        if (computePSAppDEFLogics && computePSAppDEFLogics.length > 0) {
            for (let i = 0; i < computePSAppDEFLogics.length; i++) {
                _data = await this.executeAppDEFieldLogic(computePSAppDEFLogics[i], _context, _data);
            }
        }
        return _data;
    }

    /**
     * 执行实体属性值变更逻辑
     *
     * @protected
     * @param {*} _context 应用上下文
     * @param {*} _data 当前数据
     * @memberof EntityBaseService
     */
    protected async executeOnChangePSAppDEFLogic(_context: any, _data: any) {
        let changePSAppDEFLogics = this.appDeFieldLogicMap.get('ChangePSAppDEFLogic');
        if (changePSAppDEFLogics && changePSAppDEFLogics.length > 0) {
            for (let i = 0; i < changePSAppDEFLogics.length; i++) {
                _data = await this.executeAppDEFieldLogic(changePSAppDEFLogics[i], _context, _data);
            }
        }
        return _data;
    }

    /**
     * 过滤当前实体服务，标准接口数据
     *
     * @return {*}  {*}
     * @memberof DataBaseService
     */
    filterEntityData(entity: T): T {
        const data: any = {};
        this.keys.forEach(key => {
            if (entity[key] !== void 0) {
                data[key] = entity[key];
            }
        });
        return data;
    }

    /**
     * 行为执行之前
     *
     * @protected
     * @param {string} _action 行为名称
     * @param {IContext} _context
     * @param {*} _data
     * @return {*}  {Promise<void>}
     * @memberof DataBaseService
     */
    protected async before(_action: string, _context: IContext, _data: any): Promise<void> { }

    /**
     * 行为执行之后
     *
     * @protected
     * @param {string} _action
     * @param {IContext} _context
     * @param {*} _data
     * @return {*}  {Promise<void>}
     * @memberof DataBaseService
     */
    protected async after(_action: string, _context: IContext, _data: any): Promise<void> { }

    /**
     * 清除临时数据
     *
     * @param context 上下文
     * @memberof DataBaseService
     */
    async clearLocals(context: IContext) {
        if (this.isLocalStore) {
            return this.db.clear();
        } else {
            return this.cache.clear(context);
        }
    }

    /**
     * 批量建立临时数据[解包数据]
     *
     * @protected
     * @param {IContext} context
     * @param {T[]} items
     * @return {*}  {Promise<boolean>}
     * @memberof DataBaseService
     */
    protected async setLocals(context: IContext, items: T[]): Promise<boolean> {
        if (items && items.length > 0) {
            for (let i = 0; i < items.length; i++) {
                const item = items[i];
                item.srfordervalue = generateOrderValue(i);
                await this.addLocal(context, item);
            }
            return true;
        }
        return false;
    }

    /**
     * 批量获取临时数据[打包包数据]
     *
     * @public
     * @param {IContext} context
     * @param {IParams} [params]
     * @param {string} [dataSet]
     * @return {*}  {(Promise<T[]>)}
     * @memberof DataBaseService
     */
    public async getLocals(context: IContext, params?: IParams, dataSet?: string): Promise<T[]> {
        let items: T[] = [];
        const _this: any = this;
        if (_this[dataSet!]) {
            const res = await _this[dataSet!](context, params);
            if (res.ok) {
                items = res.data;
            }
        } else {
            items = await this.selectLocal(context, params);
        }
        if (items && items.length > 0) {
            items = items.sort((a: any, b: any) => a.srfordervalue - b.srfordervalue);
            for (let i = 0; i < items.length; i++) {
                let item = items[i];
                item = this.filterEntityData(item);
                items[i] = item;
            }
        }
        return items;
    }

    /**
     * 通过服务构造实体。
     *
     * @return {*}  {T}
     */
    newEntity(data: any, context: IContext = {}): any {
        if (this.selectContextParam && Object.keys(this.selectContextParam).length > 0) {
            Object.keys(this.selectContextParam).forEach((key) => {
                const dataKey: string = this.selectContextParam[key];
                if (context[key] && !data.hasOwnProperty(dataKey)) {
                    data[dataKey] = context[key];
                }
            })
        }
        return new Entity(this.appDataEntity, data);
    }

    /**
     * 新增本地数据
     *
     * @param {IContext} context
     * @param {T} entity
     * @return {*}  {(Promise<T | null>)}
     * @memberof DataBaseService
     */
    async addLocal(context: IContext, entity: T): Promise<T | null> {
        try {
            if (this.isLocalStore) {
                return this.db.create(context, this.newEntity(entity, context));
            } else {
                return this.cache.add(context, this.newEntity(entity, context));
            }
        } catch (error) {
            throw error;
        }
    }

    /**
     * 新建本地数据
     *
     * @param {IContext} context
     * @param {T} entity
     * @return {*}  {(Promise<T | null>)}
     * @memberof DataBaseService
     */
    async createLocal(context: IContext, entity: T): Promise<T | null> {
        try {
            entity.srfuf = 0;
            const data = await this.addLocal(context, entity);
            return data;
        } catch (error) {
            throw error;
        }
    }

    /**
     * 获取缓存数据
     *
     * @param {IContext} context
     * @param {string} srfKey
     * @return {*}  {Promise<T>}
     * @memberof DataBaseService
     */
    async getLocal2(context: IContext, srfKey: string): Promise<T> {
        try {
            if (this.isLocalStore) {
                return this.db.get(context, srfKey);
            }
            return this.cache.get(context, srfKey)!;
        } catch (error) {
            throw error;
        }
    }

    /**
     * 查找本地数据
     *
     * @param {IContext} context
     * @param {string} srfKey
     * @return {*}  {Promise<T | null>}
     * @memberof DataBaseService
     */
    async getLocal(context: IContext, srfKey: string): Promise<T> {
        try {
            if (this.isLocalStore) {
                return this.db.get(context, srfKey);
            }
            return this.cache.get(context, srfKey)!;
        } catch (error) {
            throw error;
        }
    }

    /**
     * 更新本地数据
     *
     * @param {IContext} context
     * @param {T} entity
     * @return {*}  {Promise<T>}
     * @memberof DataBaseService
     */
    async updateLocal(context: IContext, entity: T): Promise<T> {
        try {
            let data: any = null;
            if (this.isLocalStore) {
                data = await this.db.update(context, this.newEntity(entity, context));
            } else {
                data = this.cache.update(context, this.newEntity(entity, context));
            }
            return data;
        } catch (error) {
            throw error;
        }
    }

    /**
     * 删除本地数据
     *
     * @param {IContext} context
     * @param {string} srfKey
     * @return {*}  {Promise<T>}
     * @memberof DataBaseService
     */
    async removeLocal(context: IContext, srfKey: string): Promise<T> {
        try {
            let data: any = null;
            if (this.isLocalStore) {
                data = await this.db.remove(context, srfKey);
            } else {
                data = this.cache.delete(context, srfKey);
            }
            return data;
        } catch (error) {
            throw error;
        }
    }

    /**
     * 本地获取默认值
     *
     * @param {IContext} _context
     * @param {T} _entity
     * @return {*}  {Promise<T>}
     * @memberof DataBaseService
     */
    async getDraftLocal(context: IContext, entity: T): Promise<T> {
        return this.newEntity(entity, context);
    }

    /**
     * 查询本地数据，根据属性
     *
     * @param {IContext} context
     * @param {IParams} params 根据多实体属性查找，例：{ name: '张三', age: 18, parent: null }
     * @return {*}  {Promise<T[]>}
     * @memberof DataBaseService
     */
    async selectLocal(context: IContext, params: IParams = {}): Promise<T[]> {
        let items: T[] = [];
        if (this.isLocalStore) {
            items = await this.db.search(context);
        } else {
            items = this.cache.getList(context);
        }
        items = ascSort(items, 'srfordervalue');
        if (notNilEmpty(params) || notNilEmpty(context)) {
            // 查询数据条件集
            const data: any = {};
            const nullData: any = {};
            const undefinedData: any = {};
            if (params.srfkey) {
                data.srfkey = equals(params.srfkey);
            }
            if (this.selectContextParam) {
                for (const key in this.selectContextParam) {
                    if (this.selectContextParam.hasOwnProperty(key)) {
                        const val = this.selectContextParam[key];
                        if (notNilEmpty(context[key])) {
                            data[val] = equals(context[key]);
                        }
                    }
                }
            }
            delete params.srfkey;
            for (const key in params) {
                if (params.hasOwnProperty(key)) {
                    const val = params[key];
                    if (val == null) {
                        nullData[key] = equals(null);
                        undefinedData[key] = equals(undefined);
                    } else {
                        data[key] = equals(val);
                    }
                }
            }
            if (!isEmpty(data)) {
                // 返回柯里化函数，用于判断数据是否满足要求
                const pred = where(data);
                const nullPred = where(nullData);
                const undefinedPred = where(undefinedData);
                items = items.filter(obj => {
                    if (isEmpty(nullData)) {
                        if (pred(obj)) {
                            return true;
                        }
                    } else {
                        if (pred(obj) && (nullPred(obj) || undefinedPred(obj))) {
                            return true;
                        }
                    }
                });
            }
        }
        const list = items.map(obj => clone(obj));
        LogUtil.warn('select', params, list);
        return list;
    }

    /**
     * 搜索本地数据
     *
     * @protected
     * @param {PSDEDQCondEngine | null} cond 查询实例
     * @param {SearchFilter} filter 过滤对象
     * @param {string[]} [queryParamKeys=this.quickSearchFields] 当前实体支持快速搜索的属性
     * @return {*}  {Promise<T[]>}
     * @memberof DataBaseService
     */
    protected async searchLocal(
        cond: PSDEDQCondEngine | null,
        filter: SearchFilter,
        queryParamKeys: string[] = this.quickSearchFields,
    ): Promise<HttpResponse> {
        let list = [];
        // 走查询条件
        if (cond) {
            if (this.isLocalStore) {
                list = await this.db.search(filter.context);
            } else {
                list = this.cache.getList(filter.context);
            }
            if (list?.length > 0) {
                list = list.filter(obj => cond.test(obj, filter));
            }
        } else {
            list = await this.selectLocal(filter.context);
            if (list?.length > 0) {
                // 识别query查询
                const condition = filter.data;
                if (condition != null && !isEmpty(condition)) {
                    if (queryParamKeys) {
                        list = list.filter(obj => {
                            const reg = new RegExp(filter.query);
                            for (let i = 0; i < queryParamKeys.length; i++) {
                                const key = queryParamKeys[i];
                                const val: string = obj[key];
                                if (reg.test(val)) {
                                    return true;
                                }
                            }
                        });
                    }
                }
            }
        }
        if (!isNil(filter.sortField) && !isEmpty(filter.sortField)) {
            if (filter.sortMode === 'DESC') {
                // 倒序
                list = descSort(list, filter.sortField);
            } else {
                // 正序
                list = ascSort(list, filter.sortField);
            }
        }
        const { page, size } = filter;
        const start = page * size;
        const end = (page + 1) * size;
        const items = list.slice(start, end).map((item: any) => clone(item));
        LogUtil.warn('search', cond, items);
        const headers = new Headers({
            'x-page': page.toString(),
            'x-per-page': size.toString(),
            'x-total': list.length.toString(),
        });
        return new HttpResponse(items, { headers });
    }

    /**
     * 搜索本地数据
     *
     * @protected
     * @param {PSDEDQCondEngine | null} cond
     * @param {SearchFilter} filter
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    protected searchAppLocal(cond: PSDEDQCondEngine | null, filter: SearchFilter): Promise<IHttpResponse> {
        return this.searchLocal(cond, filter);
    }

    /**
     * 新建本地数据
     *
     * @param {IContext} context
     * @param {T} entity
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    createAppLocal(context: IContext, entity: T): Promise<IHttpResponse> {
        return this.CreateTemp(context, entity);
    }

    /**
     * 获取本地数据[弃用]
     *
     * @param {IContext} context
     * @param {IParams} [params]
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    getAppLocal(context: IContext, params?: IParams): Promise<IHttpResponse> {
        return this.GetTemp(context, params);
    }

    /**
     * 获取默认值[弃用]
     *
     * @param {IContext} context
     * @param {*} [params]
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    getDraftAppLocal(context: IContext, params?: any): Promise<IHttpResponse> {
        return this.GetDraftTemp(context, params);
    }

    /**
     * 更新本地数据
     *
     * @param {IContext} context
     * @param {T} [entity]
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    updateAppLocal(context: IContext, entity: T): Promise<IHttpResponse> {
        return this.UpdateTemp(context, entity);
    }

    /**
     * 删除本地数据
     *
     * @param {IContext} context
     * @param {IParams} [params]
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    async removeAppLocal(context: IContext, params?: IParams): Promise<IHttpResponse> {
        return this.RemoveTemp(context, params);
    }

    /**
     * 获取本地默认数据集
     *
     * @param {IContext} context
     * @param {IParams} [params]
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    selectAppLocal(context: IContext, params?: IParams): Promise<IHttpResponse> {
        return this.FetchDefault(context, params);
    }

    async Create(context: IContext, entity: T): Promise<IHttpResponse> {
        try {
            if (this.appDataEntity.storageMode === 0 || this.appDataEntity.storageMode === 3) {
                throw new Error('执行Create方法异常，[无远程调用接口]');
            }
            return this.createAppLocal(context, entity);
        } catch (error) {
            return new HttpResponse(error, { ok: false, status: 500 });
        }
    }

    async Remove(context: IContext, params?: IParams): Promise<IHttpResponse> {
        try {
            if (this.appDataEntity.storageMode === 0 || this.appDataEntity.storageMode === 3) {
                throw new Error('执行Remove方法异常，[无远程调用接口]');
            }
            return this.removeAppLocal(context, params);
        } catch (error) {
            return new HttpResponse(error, { ok: false, status: 500 });
        }
    }

    async Update(context: IContext, entity: T): Promise<IHttpResponse> {
        try {
            if (this.appDataEntity.storageMode === 0 || this.appDataEntity.storageMode === 3) {
                throw new Error('执行Update方法异常，[无远程调用接口]');
            }
            return this.updateAppLocal(context, entity);
        } catch (error) {
            return new HttpResponse(error, { ok: false, status: 500 });
        }
    }

    async Get(context: IContext, params?: IParams): Promise<IHttpResponse> {
        try {
            if (this.appDataEntity.storageMode === 0 || this.appDataEntity.storageMode === 3) {
                throw new Error('执行Get方法异常，[无远程调用接口]');
            }
            return this.getAppLocal(context, params);
        } catch (error) {
            return new HttpResponse(error, { ok: false, status: 500 });
        }
    }

    async GetDraft(context: IContext, params?: IParams): Promise<IHttpResponse> {
        try {
            if (this.appDataEntity.storageMode === 0 || this.appDataEntity.storageMode === 3) {
                throw new Error('执行GetDraft方法异常，[无远程调用接口]');
            }
            return this.getDraftAppLocal(context, params);
        } catch (error) {
            return new HttpResponse(error, { ok: false, status: 500 });
        }
    }

    CreateBatch(context: IContext, params?: T[]): Promise<IHttpResponse> {
        return this.CreateBatchTemp(context, params);
    }

    checkData(context: IContext, srfkey: string): Promise<boolean> {
        return this.checkDataTemp(context, srfkey);
    }

    async FetchDefault(context: IContext, params?: IParams): Promise<IHttpResponse> {
        try {
            await this.before('FetchDefault', context, params);
            const res = await this.searchLocal(null, new SearchFilter(context, params));
            await this.after('FetchDefault', context, res.data);
            return res;
        } catch (err) {
            return new HttpResponse(err, {
                ok: false,
                status: 500,
            });
        }
    }

    async CreateTemp(context: IContext, entity: T): Promise<IHttpResponse> {
        try {
            await this.before('CreateTemp', context, entity);
            const data = await this.createLocal(context, entity);
            await this.after('CreateTemp', context, data);
            return new HttpResponse(data);
        } catch (err) {
            return new HttpResponse(err, {
                ok: false,
                status: 500,
            });
        }
    }

    async GetDraftTemp(context: IContext, params?: any): Promise<IHttpResponse> {
        try {
            await this.before('GetDraftTemp', context, params);
            const data = await this.getDraftLocal(context, params);
            await this.after('GetDraftTemp', context, data);
            if (data) {
                return new HttpResponse(data);
            }
            return new HttpResponse(data, {
                ok: false,
                status: 500,
            });
        } catch (err) {
            return new HttpResponse(err, {
                ok: false,
                status: 500,
            });
        }
    }

    async RemoveTemp(context: IContext, params?: IParams): Promise<IHttpResponse> {
        try {
            await this.before('RemoveTemp', context, params);
            let key = null;
            if (params) {
                key = params[this.APPDEKEY.toLowerCase()];
            }
            if (!key && context) {
                key = context[this.APPDENAME.toLowerCase()];
            }
            const data = await this.removeLocal(context, key);
            await this.after('RemoveTemp', context, data);
            if (data) {
                return new HttpResponse(data);
            }
            return new HttpResponse(data, {
                ok: false,
                status: 500,
            });
        } catch (err) {
            return new HttpResponse(err, {
                ok: false,
                status: 500,
            });
        }
    }

    async UpdateTemp(context: IContext, entity: T): Promise<IHttpResponse> {
        try {
            await this.before('UpdateTemp', context, entity);
            const data = await this.updateLocal(context, entity);
            await this.after('UpdateTemp', context, data);
            if (data) {
                return new HttpResponse(data);
            }
            return new HttpResponse(data, {
                ok: false,
                status: 500,
            });
        } catch (err) {
            return new HttpResponse(err, {
                ok: false,
                status: 500,
            });
        }
    }

    async GetTemp(context: IContext, params?: IParams): Promise<IHttpResponse> {
        try {
            await this.before('GetTemp', context, params);
            let key = null;
            if (params) {
                key = params[this.APPDEKEY.toLowerCase()];
            }
            if (!key && context) {
                key = context[this.APPDENAME.toLowerCase()];
            }
            const data = await this.getLocal(context, key);
            await this.after('GetTemp', context, data);
            if (data) {
                return new HttpResponse(data);
            }
            return new HttpResponse(data, {
                ok: false,
                status: 500,
            });
        } catch (err) {
            return new HttpResponse(err, {
                ok: false,
                status: 500,
            });
        }
    }

    /**
     * 批量新建本地数据
     *
     * @param {IContext} _context
     * @param {T[]} [_params]
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    async CreateBatchTemp(_context: IContext, _params?: T[]): Promise<IHttpResponse> {
        try {
            if (!_params || !Array.isArray(_params) || _params.length === 0) {
                return new HttpResponse({ message: '传入参数无效' }, {
                    ok: false,
                    status: 500,
                });
            }
            const response = [];
            for (let i = 0; i < _params.length; i++) {
                const data = await this.createLocal(_context, _params[i]);
                response.push(data?.data);
            }
            return new HttpResponse(response);
        } catch (err) {
            return new HttpResponse(err, {
                ok: false,
                status: 500,
            });
        }
    }

    /**
     * 批量删除本地数据
     *
     * @param {IContext} _context
     * @param {IParams} [_params]
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    async RemoveBatchTemp(_context: IContext, _params?: IParams): Promise<IHttpResponse> {
        try {
            let keys = null;
            if (_params) {
                keys = _params[this.APPDEKEY.toLowerCase()];
            }
            const response = [];
            for (let i = 0; i < keys.length; i++) {
                const data = await this.RemoveTemp(_context, { [this.APPDEKEY.toLowerCase()]: keys[i] });
                response.push(data?.data);
            }
            return new HttpResponse(response);
        } catch (err) {
            return new HttpResponse(err, {
                ok: false,
                status: 500,
            });
        }
    }

    /**
     * 删除全部本地数据
     *
     * @param {IContext} _context
     * @param {IParams} [_params]
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    async RemoveAllTemp(_context: IContext, _params?: IParams): Promise<IHttpResponse> {
        try {
            const localItems = await this.getLocals(_context);
            let response = [];
            if (Array.isArray(localItems) && localItems.length > 0) {
                for (let i = 0; i < localItems.length; i++) {
                    const result = await this.RemoveTemp(_context, localItems[i]);
                    response.push(result?.data);
                }
            }
            return new HttpResponse(response);
        } catch (err) {
            return new HttpResponse(err, {
                ok: false,
                status: 500,
            });
        }
    }

    /**
     * 拷贝一条数据
     *
     * @param {IContext} context
     * @param {T} data
     * @return {*}  {Promise<IHttpResponse>}
     * @memberof DataBaseService
     */
    async CopyTemp(context: IContext, data: T): Promise<IHttpResponse> {
        const result = await this.GetTemp(context, data);
        if (result.ok) {
            const entity: T = result.data;
            entity.assign!(data);
            entity.srfkey = createUUID();
            entity.srfmajortext = `${entity.srfmajortext} copy`;
            const draftRes = await this.GetDraftTemp(
                {
                    ...context,
                    [this.APPDENAME.toLowerCase()]: context[this.APPDENAME.toLowerCase()] || entity.srfpkey,
                },
                entity,
            );
            if (draftRes.ok) {
                const res = await this.CreateTemp(context, draftRes.data);
                return res;
            }
        }
        return new HttpResponse(null, { status: 500, statusText: '拷贝数据失败失败' });
    }

    /**
     * FetchTempDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof DataBaseService
     */
    public async FetchTempDefault(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        try {
            if (context && context.srfsessionkey) {
                const tempData = await this.getLocals(context);
                return { status: 200, data: tempData };
            } else {
                return { status: 200, data: [] };
            }
        } catch (error) {
            return { status: 200, data: [] };
        }
    }

    /**
     * 根据主键判断数据是否存在
     *
     * @param {IContext} context
     * @param {string} srfkey
     * @return {*}  {Promise<boolean>}
     * @memberof DataBaseService
     */
    async checkDataTemp(context: IContext, srfkey: string): Promise<boolean> {
        if (this.isLocalStore) {
            return this.db.checkData(context, srfkey);
        }
        return this.cache.checkData(context, srfkey);
    }

    CreateTempMajor(context: IContext, params?: any): Promise<IHttpResponse> {
        return this.Create(context, params);
    }
    GetDraftTempMajor(context: IContext, params?: any): Promise<IHttpResponse> {
        return this.GetDraft(context, params);
    }
    GetTempMajor(context: IContext, params?: IParams): Promise<IHttpResponse> {
        return this.Get(context, params);
    }
    UpdateTempMajor(context: IContext, entity: T): Promise<IHttpResponse> {
        return this.Update(context, entity);
    }
    RemoveTempMajor(context: IContext, params?: IParams): Promise<IHttpResponse> {
        return this.Remove(context, params);
    }

    /**
     * createBatch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async createBatch(context: any = {}, data: any, isloading?: boolean): Promise<any> {
        if (context?.srfparentdename && context?.srfparentkey) {
            const mainDENamePlural = Util.srfpluralize(context.srfparentdename).toLowerCase();
            return Http.getInstance().post(
                `/${mainDENamePlural}/${context.srfparentkey}/${this.APPDENAMEPLURAL.toLowerCase()}/batch`,
                data,
                isloading,
            );
        } else {
            return Http.getInstance().post(`/${this.APPDENAMEPLURAL.toLowerCase()}/batch`, data, isloading);
        }
    }

    /**
     * saveBatch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async saveBatch(context: any = {}, data: any, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/${this.APPDENAMEPLURAL.toLowerCase()}/savebatch`, data, isloading);
    }

    /**
     * updateBatch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async updateBatch(context: any = {}, data: any, isloading?: boolean): Promise<any> {
        return Http.getInstance().put(`/${this.APPDENAMEPLURAL.toLowerCase()}/batch`, data, isloading);
    }

    /**
     * removeBatch接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async removeBatch(context: any = {}, data: any, isloading?: boolean): Promise<any> {
        return Http.getInstance().delete(
            `/${this.APPDENAMEPLURAL.toLowerCase()}/batch`,
            data[this.APPDEKEY],
            isloading
        );
    }

    /**
     * getDataInfo接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async getDataInfo(context: any = {}, data: any, isloading?: boolean): Promise<any> {
        if (context[this.APPDENAME.toLowerCase()]) {
            return this.execute('Get', context, data);
        }
    }

    /**
     * getDynaModel(获取动态模型)接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async getDynaModel(context: any = {}, data: any, isloading?: boolean): Promise<any> {
        if (data && data.configType && data.targetType) {
            return Http.getInstance().get(`/configs/${data.configType}/${data.targetType}`);
        }
    }

    /**
     * setDynaModel(设置动态模型)接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async setDynaModel(context: any = {}, data: any, isloading?: boolean): Promise<any> {
        if (data && data.configType && data.targetType) {
            return Http.getInstance().put(`/configs/${data.configType}/${data.targetType}`, { model: data.model });
        }
    }

    /**
     * getDynaWorkflow接口方法(获取指定工作流版本信息)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async getDynaWorkflow(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${context.srfdynainstid
            }/${this.APPWFDENAME.toLowerCase()}/process-definitions`,
            isloading,
        );
    }

    /**
     * 获取标准工作流版本信息
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async getStandWorkflow(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(
            `/wfcore/${context.srfsystemid
            }-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/process-definitions2`,
            isloading,
        );
    }

    /**
     * 获取副本工作流版本信息
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async getCopyWorkflow(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${context.instTag}/${context.instTag2
            }/${this.APPWFDENAME.toLowerCase()}/process-definitions`,
            isloading,
        );
    }

    /**
     * WFStart接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFStart(context: any = {}, data: any = {}, localdata?: any, isloading?: boolean): Promise<any> {
        const requestData: any = {};
        Object.assign(requestData, { activedata: data });
        Object.assign(requestData, localdata);
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/${data[this.APPDEKEY]
            }/process-instances`,
            requestData,
            isloading,
        );
    }

    /**
     * WFClose接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFClose(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/${this.APPDENAMEPLURAL.toLowerCase()}/${data[this.APPDEKEY]}/wfclose`,
            data,
            isloading,
        );
    }

    /**
     * WFMarkRead接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFMarkRead(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/${this.APPDENAMEPLURAL.toLowerCase()}/${data[this.APPDEKEY]}/wfmarkread`,
            data,
            isloading,
        );
    }

    /**
     * WFGoto接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFGoto(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/${this.APPDENAMEPLURAL.toLowerCase()}/${data[this.APPDEKEY]}/wfgoto`,
            data,
            isloading,
        );
    }

    /**
     * WFRollback接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFRollback(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/${this.APPDENAMEPLURAL.toLowerCase()}/${data[this.APPDEKEY]}/wfrollback`,
            data,
            isloading,
        );
    }

    /**
     * WFRestart接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFRestart(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/${this.APPDENAMEPLURAL.toLowerCase()}/${data[this.APPDEKEY]}/wfrestart`,
            data,
            isloading,
        );
    }

    /**
     * WFReassign接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFReassign(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/${this.APPDENAMEPLURAL.toLowerCase()}/${data[this.APPDEKEY]}/wfreassign`,
            data,
            isloading,
        );
    }

    /**
     * WFGetWorkFlow接口方法(获取工作流定义)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFGetWorkFlow(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(
            `/wfcore/${context.srfsystemid
            }-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/process-definitions`,
        );
    }

    /**
     * WFGetWFStep接口方法(根据系统实体查找当前适配的工作流模型步骤)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFGetWFStep(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${data.srfinsttag}/${data.srfinsttag2
            }/${this.APPWFDENAME.toLowerCase()}/process-definitions-nodes`,
        );
    }

    /**
     * GetWFLink接口方法(根据业务主键和当前步骤获取操作路径)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async GetWFLink(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/${context[this.APPDENAME.toLowerCase()]
            }/usertasks/${data['taskDefinitionKey']}/ways`,
            { activedata: data.activedata },
        );
    }

    /**
     * GetWFLinks接口方法(根据当前步骤和任务获取批量操作路径)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async getWFLinks(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(
            `/wfcore/${context.srfsystemid
            }-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/process-definitions/${data['processDefinitionKey']
            }/usertasks/${data['taskDefinitionKey']}/ways`,
        );
    }

    /**
     * getWFStep接口方法(根据当前步骤和任务获取工作流步骤数据（如：流程表单等）)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async getWFStep(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(
            `/wfcore/${context.srfsystemid
            }-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/process-definitions/${data['processDefinitionKey']
            }/usertasks/${data['taskDefinitionKey']}`,
        );
    }

    /**
     * wfSubmitBatch接口方法(批量提交)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async wfSubmitBatch(context: any = {}, data: any = {}, localdata: any, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid
            }-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/process-definitions/${localdata['processDefinitionKey']
            }/usertasks/${localdata['taskDefinitionKey']}/ways/${localdata['sequenceFlowId']}/submit`,
            data,
        );
    }

    /**
     * GetWFHistory接口方法(根据业务主键获取工作流程图片)
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async GetWFHistory(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/${context[this.APPDENAME.toLowerCase()]
            }/process-instances/alls/history`,
        );
    }

    /**
     * 前加签接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async BeforeSign(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/${context[this.APPDENAME.toLowerCase()]
            }/tasks/${data.taskId}/beforesign`,
            data,
        );
    }

    /**
     * 转办接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async TransFerTask(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/${context[this.APPDENAME.toLowerCase()]
            }/tasks/${data.taskId}/transfer`,
            data,
        );
    }

    /**
     * 回退
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async SendBack(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/${context[this.APPDENAME.toLowerCase()]
            }/tasks/${data.taskId}/sendback`,
            data,
        );
    }

    /**
     * 撤回
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WithDraw(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPDENAME.toLowerCase()}/${context[this.APPDENAME.toLowerCase()]
            }/tasks/${data.taskId}/withdraw`,
            data,
        );
    }

    /**
     * 抄送
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async sendCopy(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/${context[this.APPDENAME.toLowerCase()]
            }/tasks/${data.taskId}/sendcopy`,
            data,
        );
    }

    /**
     * 将待办任务标记为已读
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async ReadTask(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/${context[this.APPDENAME.toLowerCase()]
            }/tasks/${data.taskId}/read`,
            { activedata: data },
        );
    }

    /**
     * WFSubmit接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFSubmit(context: any = {}, data: any = {}, localdata?: any): Promise<any> {
        const requestData: any = {};
        if (data.viewparams) {
            delete data.viewparams;
        }
        Object.assign(requestData, { activedata: data });
        Object.assign(requestData, localdata);
        return Http.getInstance().post(
            `/wfcore/${context.srfsystemid}-app-${this.APPNAME.toLowerCase()}/${this.APPWFDENAME.toLowerCase()}/${data[this.APPDEKEY.toLowerCase()]
            }/tasks/${localdata['taskId']}`,
            requestData,
        );
    }

    /**
     * WFGetProxyData接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof EntityService
     */
    public async WFGetProxyData(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(
            `/${this.APPDENAMEPLURAL.toLowerCase()}/${context[this.APPDENAME.toLowerCase()]}/wfgetproxydata`,
            data,
            isloading,
        );
    }

    /**
     * 测试数据是否在工作流中
     *
     * @param context
     * @param data
     * @param isloading
     */
    public async testDataInWF(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        if (!context.stateField || !context.stateValue) return false;
        if (context.stateValue == data[context.stateField]) {
            return true;
        }
        return false;
    }

    /**
     * 测试当前用户是否提交过工作流
     *
     * @param context
     * @param data
     * @param isloading
     */
    public async testUserWFSubmit(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return true;
    }

    /**
     * 测试当前用户是否存在待办列表
     *
     * @param context
     * @param data
     * @param isloading
     */
    public async testUserExistWorklist(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const requestData: any = {};
        Object.assign(requestData, { wfdata: data });
        return Http.getInstance().post(
            `/${this.APPDENAMEPLURAL.toLowerCase()}/${data[this.APPDENAME.toLowerCase()]}/testuserexistworklist`,
            requestData,
            isloading,
        );
    }

    /**
     * 获取所有应用数据
     *
     * @param context
     * @param data
     * @param isloading
     */
    public async getAllApp(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(`/uaa/access-center/app-switcher/default`, data, isloading);
    }

    /**
     * 更新已选择的应用
     *
     * @param context
     * @param data
     * @param isloading
     */
    public async updateChooseApp(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().put(`/uaa/access-center/app-switcher/default`, data, isloading);
    }

    /**
     * 修改密码
     *
     * @param context
     * @param data
     * @param isloading
     */
    public async changPassword(context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().post(`/v7/changepwd`, data, isloading);
    }

    /**
     * 获取数字字典
     *
     * @param tag
     * @param data
     * @param isloading
     */
    public async getPredefinedCodelist(tag: string, data: any = {}, isloading?: boolean): Promise<any> {
        return Http.getInstance().get(`/dictionaries/codelist/${tag}`, data, isloading);
    }

    /**
     * @description 执行实体方法
     * @param {string} methodName
     * @param {...any[]} args
     * @memberof DataBaseService
     */
    public async execute(methodName: string, ...args: any[]) {
        throw new Error('执行实体方法未实现！');
    }
}