import { IPSAppDataEntity, IPSDEEditForm, IPSDEFormItem, IPSDEFormPage } from '@ibiz/dynamic-model-api';
import { ControlServiceBase, Util, DataServiceHelp, UtilServiceHelp } from 'ibiz-core';
import { AppFormModel } from 'ibiz-vue';
import { notNilEmpty } from 'qx-util';


/**
 * Main 部件服务对象
 *
 * @export
 * @class AppFormService
 */
export class AppFormService extends ControlServiceBase {

    /**
    * 表单实例对象
    *
    * @memberof MainModel
    */
    public declare controlInstance: IPSDEEditForm;

    /**
     * 数据服务对象
     *
     * @type {any}
     * @memberof AppFormService
     */
    public appEntityService!: any;

    /**
     * 远端数据
     *
     * @type {*}
     * @memberof AppFormService
     */
    private remoteCopyData: any = {};

    /**
     * ac服务参数Map
     *
     * @private
     * @type {Map<string, IPSAppDataEntity>}
     * @memberof AppFormService
     */
    private acServiceMap: Map<string, IPSAppDataEntity> = new Map();

    /**
     * 初始化AC参数
     *
     * @private
     * @memberof AppFormService
     */
    private async initAcParam() {
        if (this.controlInstance && this.controlInstance.getPSDEFormPages()) {
            for (let i = 0; i < (this.controlInstance.getPSDEFormPages() as IPSDEFormPage[]).length; i++) {
                const appDEFormPage = (this.controlInstance.getPSDEFormPages() as IPSDEFormPage[])[i];
                await this.initAcServiceParam(appDEFormPage);
            }
        }
    }

    /**
     * 初始化AC服务参数
     *
     * @private
     * @param {*} parentModel
     * @memberof AppFormService
     */
    private async initAcServiceParam(parentModel: any) {
        if (parentModel && parentModel.getPSDEFormDetails && parentModel.getPSDEFormDetails instanceof Function && parentModel.getPSDEFormDetails()?.length > 0) {
            for(let i = 0;i<parentModel.getPSDEFormDetails().length;i++){
                const detail = parentModel.getPSDEFormDetails()[i];
                if (detail && detail.detailType === 'FORMITEM' && detail.getPSEditor()) {
                    if (detail.getPSEditor()?.getPSAppDataEntity?.()) {
                        const appDataEntity = detail.getPSEditor().getPSAppDataEntity();
                        await appDataEntity.fill();
                        this.acServiceMap.set(appDataEntity.codeName, appDataEntity);
                    }
                } else {
                    this.initAcServiceParam(detail);
                }
            }
        }
    }

    /**
     * 初始化服务参数
     *
     * @type {boolean}
     * @memberof AppFormService
     */
    public async initServiceParam() {
        this.appEntityService = await DataServiceHelp.getInstance().getService(this.controlInstance?.getPSAppDataEntity(), { context: this.context });
        this.model = new AppFormModel(this.controlInstance);
    }

    /**
     * Creates an instance of AppFormService.
     * 
     * @param {*} [opts={}]
     * @memberof AppFormService
     */
    constructor(opts: any = {}, context?: any, args?: any) {
        super(opts, context, args);
        this.controlInstance = opts;
    }

    /**
     * loaded
     *
     * @memberof AppFormService
     */
    public async loaded() {
        await this.initServiceParam();
        await this.initAcParam();
    }

    /**
     * 处理数据
     *
     * @private
     * @param {Promise<any>} promise
     * @returns {Promise<any>}
     * @memberof AppFormService
     */
    private doItems(promise: Promise<any>, deKeyField: string, deName: string): Promise<any> {
        return new Promise((resolve, reject) => {
            promise.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    data.forEach((item: any, index: number) => {
                        item[deName] = item[deKeyField];
                        data[index] = item;
                    });
                    resolve(data);
                } else {
                    reject([])
                }
            }).catch((response: any) => {
                reject([])
            });
        });
    }

    /**
     * 获取跨实体数据集合
     *
     * @param {string} serviceName 服务名称
     * @param {string} interfaceName 接口名称
     * @param {*} data
     * @param {boolean} [isloading]
     * @returns {Promise<any[]>}
     * @memberof  AppFormService
     */
    public getItems(serviceName: string, interfaceName: string, context: any = {}, data: any, isloading?: boolean): Promise<any[]> {
        data.page = data.page ? data.page : 0;
        data.size = data.size ? data.size : 1000;
        return new Promise((resolve: any, reject: any) => {
            if (this.acServiceMap.get(serviceName)) {
                DataServiceHelp.getInstance().getService(this.acServiceMap.get(serviceName) as IPSAppDataEntity).then((service: any) => {
                    if (service) {
                        resolve(this.doItems(service.execute(interfaceName, context, data, isloading), service.APPDEKEY.toLowerCase(), service.APPDENAME.toLowerCase()));
                    }
                }).catch((error: any) => {
                    reject([]);
                })
            } else {
                reject([]);
            }
        })
    }

    /**
     * 启动工作流
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof AppFormService
     */
    public wfstart(action: string, context: any = {}, data: any = {}, isloading?: boolean, localdata?: any): Promise<any> {
        data = this.handleWFData(data, true);
        context = this.handleRequestData(action, context, data).context;
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService[action] && this.appEntityService[action] instanceof Function) {
                result = this.appEntityService.execute(context, data, localdata);
            } else {
                result = this.appEntityService.execute('WFStart', context, data, localdata);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 提交工作流
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {*} [localdata]
     * @returns {Promise<any>}
     * @memberof AppFormService
     */
    public wfsubmit(action: string, context: any = {}, data: any = {}, isloading?: boolean, localdata?: any): Promise<any> {
        data = this.handleWFData(data, true);
        context = this.handleRequestData(action, context, data, true).context;
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService[action] && this.appEntityService[action] instanceof Function) {
                result = this.appEntityService.execute(action, context, data, localdata);
            } else {
                result = this.appEntityService.execute('WFSubmit', context, data, localdata);
            }
            result.then((response) => {
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 添加数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {boolean} [isWorkflow] 是否在工作流中添加数据
     * @returns {Promise<any>}
     * @memberof AppFormService
     */
    public add(action: string, context: any = {}, data: any = {}, isloading?: boolean, isWorkflow?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data, isWorkflow);
        // 手动修改数据主键的情况
        this.controlInstance.getPSDEFormItems()?.find((item: IPSDEFormItem) => {
            if (!item.hidden && item.getPSAppDEField()?.keyField) {
                Object.assign(Data, {
                    [this.appDeKeyFieldName.toLowerCase()]: data[item.id],
                    srffrontuf: '1'
                });
                return true;
            }
        })
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                result = this.appEntityService.execute('Create', Context, Data);
            }
            result.then((response) => {
                if (isWorkflow) {
                    resolve(response);
                } else {
                    this.handleResponse(action, response);
                    resolve(response);
                }
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 删除数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppFormService
     */
    public delete(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                result = this.appEntityService.execute('Remove', Context, Data);
            }
            result.then((response) => {
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 修改数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @param {boolean} [isWorkflow] 是否在工作流中修改数据
     * @returns {Promise<any>}
     * @memberof AppFormService
     */
    public update(action: string, context: any = {}, data: any = {}, isloading?: boolean, isWorkflow?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data, isWorkflow);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                result = this.appEntityService.execute('Update', Context, Data);
            }
            result.then((response) => {
                if (isWorkflow) {
                    resolve(response);
                } else {
                    this.handleResponse(action, response);
                    resolve(response);
                }
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 查询数据
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppFormService
     */
    public get(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data, true);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.localSourceTag) {
                result = this.getLocalDataSource({ isSingleCtrl: true });
            } else {
                if (this.appEntityService && action) {
                    result = this.appEntityService.execute(action, Context, Data);
                } else {
                    result = this.appEntityService.execute('Get', Context, Data);
                }
            }
            result.then((response) => {
                this.setRemoteCopyData(response);
                this.handleResponse(action, response);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
     * 加载草稿
     *
     * @param {string} action
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof AppFormService
     */
    public loadDraft(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        if (this.controlInstance?.controlType == "SEARCHFORM") {
            return new Promise((resolve: any, reject: any) => {
                let response: any = { status: 200, data: data };
                this.handleResponse(action, response, true);
                resolve(response);
            });
        }
        const { data: Data, context: Context } = this.handleRequestData(action, context, data, true);
        // 仿真主键数据
        const PrimaryKey = Util.createUUID();
        if (this.controlInstance.controlType != 'SEARCHFORM') {
            Data[this.appDeKeyFieldName.toLowerCase()] = PrimaryKey;
            Data[this.appDeCodeName.toLowerCase()] = PrimaryKey;
        }
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                result = this.appEntityService.execute('GetDraft', Context, Data);
            }
            result.then((response) => {
                this.setRemoteCopyData(response);
                if (response.data && (this.controlInstance.controlType != 'SEARCHFORM') && !response.data[this.appDeKeyFieldName.toLowerCase()]) {
                    response.data[this.appDeKeyFieldName.toLowerCase()] = PrimaryKey;
                }
                this.handleResponse(action, response, true);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        });
    }

    /**
    * 前台逻辑
    * @param {string} action
    * @param {*} [context={}]
    * @param {*} [data={}]
    * @param {boolean} [isloading]
    * @returns {Promise<any>}
    * @memberof AppFormService
    */
    public frontLogic(action: string, context: any = {}, data: any = {}, isloading?: boolean): Promise<any> {
        const { data: Data, context: Context } = this.handleRequestData(action, context, data);
        return new Promise((resolve: any, reject: any) => {
            let result: Promise<any>;
            if (this.appEntityService && action) {
                result = this.appEntityService.execute(action, Context, Data);
            } else {
                return reject({ status: 500, data: { title: '失败', message: `实体服务缺少${action}方法` } });
            }
            result.then((response) => {
                this.handleResponse(action, response, true);
                resolve(response);
            }).catch(response => {
                reject(response);
            });
        })
    }

    /**
     * 处理请求数据
     * 
     * @param action 行为 
     * @param data 数据
     * @memberof AppFormService
     */
    public handleRequestData(action: string, context: any, data: any = {}, isMerge: boolean = false) {
        let mode: any = this.getMode();
        if (!mode && mode.getDataItems instanceof Function) {
            return data;
        }
        let formItemItems: any[] = mode.getDataItems();
        let requestData: any = {};
        if (isMerge && (data && data.viewparams)) {
            Object.assign(requestData, data.viewparams);
        }
        formItemItems.forEach((item: any) => {
            if (item && item.dataType && Object.is(item.dataType, 'FRONTKEY')) {
                if (item && item.prop) {
                    requestData[item.prop] = context[item.name];
                }
            }else if(item && item.dataType && Object.is(item.dataType,'REPEATER')){
                if (mode && mode.getRepeaterModel instanceof Function) {
                    let repeaterModel: any[] = mode.getRepeaterModel();
                    const tempRepeaterModel = repeaterModel.filter((element:any) =>{
                        return element.parentName === item.name;
                    })
                    requestData[item.prop] = this.transformValue(tempRepeaterModel,false,data[item.name]);
                }
            } else {
                if (item && item.prop && item.name && (data[item.name] || data[item.name] === 0 || data[item.name] === null)) {
                    requestData[item.prop] = data[item.name];
                } else {
                    if (item.dataType && Object.is(item.dataType, "FORMPART")) {
                        Object.assign(requestData, data[item.name]);
                    }
                }
            }
        });
        let tempContext: any = JSON.parse(JSON.stringify(context));
        if (tempContext && tempContext.srfsessionid) {
            tempContext.srfsessionkey = tempContext.srfsessionid;
            delete tempContext.srfsessionid;
        }
        return { context: tempContext, data: requestData };
    }

    /**
     * 通过属性名称获取表单项名称
     * 
     * @param name 实体属性名称 
     * @memberof AppFormService
     */
    public getItemNameByDeName(name: string): string {
        let itemName = name;
        let mode: any = this.getMode();
        if (!mode && mode.getDataItems instanceof Function) {
            return name;
        }
        let formItemItems: any[] = mode.getDataItems();
        formItemItems.forEach((item: any) => {
            if (item.prop === name) {
                itemName = item.name;
            }
        });
        return itemName.trim();
    }

    /**
     * 重写处理返回数据
     *
     * @param {string} action
     * @param {*} response
     * @memberof AppFormService
     */
    public handleResponseData(action: string, data: any = {}, isCreate?: boolean, codelistArray?: any) {
        if (data.srfopprivs) {
            this.getStore().commit('authresource/setSrfappdeData', { key: `${this.deName}-${data[this.appDeKeyFieldName.toLowerCase()]}`, value: data.srfopprivs });
        }
        let model: any = this.getMode();
        if (!model && model.getDataItems instanceof Function) {
            return data;
        }
        let item: any = {};
        let dataItems: any[] = model.getDataItems();
        dataItems.forEach(dataitem => {
            if(dataitem && dataitem.dataType && Object.is(dataitem.dataType,'REPEATER')){
                if(model && model.getRepeaterModel instanceof Function){
                    let repeaterModel: any[] = model.getRepeaterModel();
                    const tempRepeaterModel = repeaterModel.filter((item:any) =>{
                        return item.parentName === dataitem.name;
                    })
                    item[dataitem.name] = this.transformValue(tempRepeaterModel,true,data[dataitem.name]);
                }
            }else{
                let val = notNilEmpty(data[dataitem.prop]) ? data[dataitem.prop] : null;
                if (val === null) {
                    val = notNilEmpty(data[dataitem.name]) ? data[dataitem.name] : null;
                }
                if ((isCreate === undefined || isCreate === null) && Object.is(dataitem.dataType, 'GUID') && Object.is(dataitem.name, 'srfkey') && (val && !Object.is(val, ''))) {
                    isCreate = true;
                }
                item[dataitem.name] = val;
                // 转化代码表
                if (codelistArray && dataitem.codelist) {
                    if (codelistArray.get(dataitem.codelist.tag) && codelistArray.get(dataitem.codelist.tag).get(val)) {
                        item[dataitem.name] = codelistArray.get(dataitem.codelist.tag).get(val);
                    }
                }
            }
        });
        item.srfuf = data.srfuf ? data.srfuf : (isCreate ? "0" : "1");
        return item;
    }

    /**
     * 转化表单重复器值
     *
     * @param {*} model
     * @param {boolean} isReverse
     * @param {any[]} [source=[]]
     * @memberof Usr0222816489Service
     */
    public transformValue(model: any, isReverse: boolean, source: any) {
        let returnValues: any;
        const tempMap: Map<string, Array<string>> = new Map();
        if (model && model.length > 0) {
            model.forEach((element: any) => {
                if (element.valueItem) {
                    if (isReverse) {
                        if (tempMap.has(element.valueItem)) {
                            const tempArray: Array<string> = tempMap.get(element.valueItem) as Array<string>;
                            tempArray?.push(element.codeName);
                            tempMap.set(element.valueItem, tempArray);
                        } else {
                            tempMap.set(element.valueItem, [element.codeName]);
                        }
                    } else {
                        tempMap.set(element.codeName, [element.valueItem]);
                    }
                } else {
                    tempMap.set(element.codeName, [element.codeName]);
                }
            });
        }
        if (source && source instanceof Array) {
            returnValues = [];
            if(source.length > 0){
                source.forEach((data: any) => {
                    let tempItem: any = {};
                    if (data && Object.keys(data).length > 0) {
                        Object.keys(data).forEach((field: string) => {
                            if (tempMap.has(field)) {
                               const keys: string[] = tempMap.get(field) as string[];
                                if(keys && keys.length >0){
                                    keys.forEach((key:string) =>{
                                        tempItem[key] = data[field];
                                    })
                                }
                            } else {
                                tempItem[field] = data[field];
                            }
                        });
                    }
                    returnValues.push(tempItem);
                });
            }
        } else if (source && source instanceof Object && Object.keys(source).length > 0) {
            returnValues = {};
            Object.keys(source).forEach((field: string) => {
                if (tempMap.has(field)) {
                    const keys: string[] = tempMap.get(field) as string[];
                    if(keys && keys.length >0){
                        keys.forEach((key:string) =>{
                            returnValues[key] = source[field];
                        })
                    }
                } else {
                    returnValues[field] = source[field];
                }
            });
        }
        return returnValues;
    }

    /**
     * 设置远端数据
     * 
     * @param result 远端请求结果 
     * @memberof AppFormService
     */
    public setRemoteCopyData(result: any) {
        if (result && result.status === 200) {
            this.remoteCopyData = Util.deepCopy(result.data);
        }
    }

    /**
     * 获取远端数据
     * 
     * @memberof AppFormService
     */
    public getRemoteCopyData() {
        return this.remoteCopyData;
    }

    /**
     * 加载数据模型
     *
     * @param {string} serviceName
     * @param {*} context
     * @param {*} viewparams
     * @memberof AppFormService
     */
    public loadModel(serviceName: string, context: any, viewparams: any) {
        return new Promise((resolve: any, reject: any) => {
            UtilServiceHelp.getInstance().getService(context, serviceName).then((service: any) => {
                if (service) {
                    service.loadModelData(JSON.stringify(context), viewparams).then((response: any) => {
                        resolve(response);
                    }).catch((response: any) => {
                        reject(response);
                    });
                }
            }).catch((response: any) => {
                reject(response);
            });
        });
    }

    /**
     * 保存模型
     *
     * @param {string} serviceName
     * @param {*} context
     * @param {*} viewparams
     * @returns
     * @memberof AppFormService
     */
    public saveModel(serviceName: string, context: any, viewparams: any) {
        return new Promise((resolve: any, reject: any) => {
            UtilServiceHelp.getInstance().getService(context, serviceName).then((service: any) => {
                if (service) {
                    service.saveModelData(JSON.stringify(context), viewparams).then((response: any) => {
                        resolve(response);
                    }).catch((response: any) => {
                        reject(response);
                    });
                }
            }).catch((response: any) => {
                reject(response);
            });
        });
    }
}