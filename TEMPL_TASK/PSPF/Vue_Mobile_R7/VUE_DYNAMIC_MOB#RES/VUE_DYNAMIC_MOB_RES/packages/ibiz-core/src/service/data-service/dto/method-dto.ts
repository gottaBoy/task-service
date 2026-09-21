import { IPSAppDataEntity, IPSAppDEField, IPSAppDEMethodDTO, IPSAppDEMethodDTOField } from "@ibiz/dynamic-model-api";
import { IContext, IEntityLocalDataService, IParams } from "../../../interface";
import { DataEntityService } from "../data-entity-service";
import { DataServiceHelp } from "../data-service-help";

/**
 * @description 实体DTO类
 * @export
 * @class MethodDto
 */
export class MethodDto {

    /**
     * 应用实体模型
     *
     * @protected
     * @type {IPSAppDataEntity}
     * @memberof MethodDto
     */
    protected appDataEntity !: IPSAppDataEntity;

    /**
     * 应用方法DTO
     *
     * @protected
     * @type {*}
     * @memberof MethodDto
     */
    protected appDEMethodDTO !: IPSAppDEMethodDTO;

    /**
     * 应用实体全部属性
     * 
     *
     * @readonly
     * @type {string[]}
     * @memberof MethodDto
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
     * 是否启用缓存
     *
     * @readonly
     * @type {boolean}
     * @memberof MethodDto
     */
    get enableCache(): boolean {
        const appDEMethodDTOFields = this.appDEMethodDTO.getPSAppDEMethodDTOFields();
        if (this.appDataEntity.storageMode === 4 && appDEMethodDTOFields) {
            const result = appDEMethodDTOFields.find((field: IPSAppDEMethodDTOField) => {
                return field.type === 'DTO' || field.type === 'DTOS';
            })
            if (result) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates an instance of MethodDto.
     * 私有构造，拒绝通过 new 创建对象
     *
     * @memberof MethodDto
     */
    public constructor(appDataEntity: IPSAppDataEntity, appDEMethodDTO: IPSAppDEMethodDTO) {
        this.appDataEntity = appDataEntity;
        this.appDEMethodDTO = appDEMethodDTO;
    }

    /**
     * 获取当前数据服务
     *
     * @param {IContext} context
     * @return {*}  {Promise<IEntityLocalDataService<DataEntityService>>}
     * @memberof MethodDto
     */
    public async getService(context: IContext): Promise<IEntityLocalDataService<DataEntityService>> {
        return DataServiceHelp.getInstance().getService(this.appDataEntity, { context });
    }

    /**
     * DTO转化成数据对象
     *
     * @param {IContext} context 应用上下文对象
     * @param {IParams} source dto对象
     * @returns {*}
     * @memberof MethodDto
     */
    public async ToDataObj(context: IContext, source: IParams) {
        const _data: any = {};
        if (this.appDEMethodDTO.getPSAppDEMethodDTOFields()) {
            for (let i = 0; i < (this.appDEMethodDTO.getPSAppDEMethodDTOFields() as IPSAppDEMethodDTOField[]).length; i++) {
                const field = (this.appDEMethodDTO.getPSAppDEMethodDTOFields() as IPSAppDEMethodDTOField[])[i];
                // 应用实体DTO对象属性类型为简单数据类型
                if (field.type === 'SIMPLE') {
                    if (field.getPSAppDEField()) {
                        _data[(field.getPSAppDEField() as IPSAppDEField).codeName.toLowerCase()] = source[field.codeName.toLowerCase()];
                    } else {
                        _data[field.codeName.toLowerCase()] = source[field.codeName.toLowerCase()];
                    }
                }
                // 应用实体DTO对象属性类型为DTO对象数组
                else if (field.type === 'DTOS') {
                    const refPSAppDataEntity: IPSAppDataEntity | null = field.getRefPSAppDataEntity();
                    const refPSAppDEMethodDTO: IPSAppDEMethodDTO | null = field.getRefPSAppDEMethodDTO();
                    if (refPSAppDataEntity && refPSAppDEMethodDTO) {
                        if (source[field.codeName.toLowerCase()]?.length > 0) {
                            const targetService = await DataServiceHelp.getInstance().getService(refPSAppDataEntity);
                            if (targetService) {
                                const targetMethodDto = targetService.methodDtoMap.get(refPSAppDEMethodDTO.codeName);
                                await targetMethodDto.setCacheDataArray(context, source[field.codeName.toLowerCase()]);
                            }
                        }
                    }
                }
                // 应用实体DTO对象属性类型为DTO对象
                else if (field.type === 'DTO') {
                    const refPSAppDataEntity: IPSAppDataEntity | null = field.getRefPSAppDataEntity();
                    const refPSAppDEMethodDTO: IPSAppDEMethodDTO | null = field.getRefPSAppDEMethodDTO();
                    if (refPSAppDataEntity && refPSAppDEMethodDTO) {
                        if (source[field.codeName.toLowerCase()]) {
                            const targetService = await DataServiceHelp.getInstance().getService(refPSAppDataEntity);
                            if (targetService) {
                                const targetMethodDto = targetService.methodDtoMap.get(refPSAppDEMethodDTO.codeName);
                                await targetMethodDto.setCacheData(context, source[field.codeName.toLowerCase()]);
                            }
                        }
                    }
                }
            }
        }
        // 处理预置字段（以srf开头）
        if (source && Object.keys(source).length > 0) {
            Object.keys(source).forEach((key: string) => {
                if (key.startsWith('srf')) {
                    _data[key] = source[key];
                }
            })
        }
        return _data;
    }

    /**
     * 转化数组(dto转化成数据对象)
     *
     * @param {IContext} context 应用上下文对象
     * @param {any[]} data 数据对象
     * @returns {any[]}
     * @memberof MethodDto
     */
    public async ToDataObjArray(context: IContext, data: any[]) {
        const _data: any[] = [];
        if (data && Array.isArray(data) && data.length > 0) {
            for (let i = 0; i < data.length; i++) {
                const tempdata = await this.ToDataObj(context, data[i]);
                _data.push(tempdata);
            }
        }
        return _data;
    }

    /**
     * 数据对象转化成DTO
     *
     * @param {IContext} context 应用上下文对象
     * @param {*} source 数据对象
     * @returns {*}
     * @memberof MethodDto
     */
    public async ToDto(context: IContext, source: IParams) {
        const _data: any = {};
        const excludes: string[] = [];
        if (this.appDEMethodDTO.getPSAppDEMethodDTOFields()) {
            (this.appDEMethodDTO.getPSAppDEMethodDTOFields() as IPSAppDEMethodDTOField[]).forEach((field: IPSAppDEMethodDTOField) => {
                if (field.type === 'DTOS' || field.type === 'DTO') {
                    excludes.push(field.codeName.toLowerCase());
                }
            })
        }
        if (this.appDEMethodDTO.getPSAppDEMethodDTOFields()) {
            for (let i = 0; i < (this.appDEMethodDTO.getPSAppDEMethodDTOFields() as IPSAppDEMethodDTOField[]).length; i++) {
                const field = (this.appDEMethodDTO.getPSAppDEMethodDTOFields() as IPSAppDEMethodDTOField[])[i];
                // 应用实体DTO对象属性类型为简单数据类型
                if (field.type === 'SIMPLE') {
                    if (field.getPSAppDEField()) {
                        _data[field.codeName.toLowerCase()] = source[(field.getPSAppDEField() as IPSAppDEField).codeName.toLowerCase()];
                    } else {
                        _data[field.codeName.toLowerCase()] = source[field.codeName.toLowerCase()];
                    }
                }
                // 应用实体DTO对象属性类型为DTO对象数组
                else if (field.type === 'DTOS') {
                    const refPSAppDataEntity: IPSAppDataEntity | null = field.getRefPSAppDataEntity();
                    const refPSAppDEMethodDTO: IPSAppDEMethodDTO | null = field.getRefPSAppDEMethodDTO();
                    if (refPSAppDataEntity && refPSAppDEMethodDTO) {
                        const targetService = await DataServiceHelp.getInstance().getService(refPSAppDataEntity);
                        if (targetService) {
                            const targetMethodDto = targetService.methodDtoMap.get(refPSAppDEMethodDTO.codeName);
                            _data[field.codeName.toLowerCase()] = await targetMethodDto.getCacheDataArray(context);
                        }
                    }
                }
                // 应用实体DTO对象属性类型为DTO对象
                else if (field.type === 'DTO') {
                    const refPSAppDataEntity: IPSAppDataEntity | null = field.getRefPSAppDataEntity();
                    const refPSAppDEMethodDTO: IPSAppDEMethodDTO | null = field.getRefPSAppDEMethodDTO();
                    if (refPSAppDataEntity && refPSAppDEMethodDTO) {
                        const targetService = await DataServiceHelp.getInstance().getService(refPSAppDataEntity);
                        if (targetService) {
                            const targetMethodDto = targetService.methodDtoMap.get(refPSAppDEMethodDTO.codeName);
                            _data[field.codeName.toLowerCase()] = await targetMethodDto.getCacheData(context, source[field.codeName.toLowerCase()]);
                        }
                    }
                }
            }
        }
        // 附加额外数据
        if (source && Object.keys(source).length > 0 && this.keys) {
            Object.keys(source).forEach((key: string) => {
                if (!this.keys.includes(key) && !excludes.includes(key)) {
                    _data[key] = source[key];
                }
            })
        }
        return _data;
    }

    /**
     * 转化数组(数据对象转化成dto)
     *
     * @param {IContext} context 应用上下文对象
     * @param {any[]} data 
     * @returns {any[]}
     * @memberof MethodDto
     */
    public async ToDtoArray(context: IContext, data: any[]) {
        const _data: any[] = [];
        if (data && Array.isArray(data) && data.length > 0) {
            for (let i = 0; i < data.length; i++) {
                const tempdata = await this.ToDto(context, data[i]);
                _data.push(tempdata);
            }
        }
        return _data;
    }

    /**
     * 处理响应dto对象
     *
     * @param {*} context 应用上下文对象
     * @param {*} data 响应dto对象
     * @returns {*}
     * @memberof MethodDto
     */
    public async set(context: IContext, data: any) {
        const _data: IParams = await this.ToDataObj(context, data);
        if (this.enableCache) {
            const targetService: IEntityLocalDataService<DataEntityService> = await this.getService(context);
            await targetService.addLocal(context, data);
        }
        return _data;
    }

    /**
     * 处理请求数据对象
     *
     * @param {*} context 应用上下文对象
     * @param {*} data 数据对象
     * @returns {*}
     * @memberof MethodDto
     */
    public async get(context: IContext, data: any = {}) {
        if (this.enableCache) {
            const targetService: IEntityLocalDataService<DataEntityService> = await this.getService(context);
            const keyPSAppDEField: any = this.appDataEntity.getKeyPSAppDEField();
            let localdata: any = await targetService.getLocal(context, data[keyPSAppDEField.codeName.toLowerCase()]);
            if (!localdata) {
                localdata = data;
            } else {
                localdata.assign!(data);
            }
            return await this.ToDto(context, localdata);
        } else {
            return await this.ToDto(context, data);
        }
    }

    /**
     * 获取缓存数据
     *
     * @param {*} context 应用上下文对象
     * @param {*} srfkey 数据主键
     * @returns {*}
     * @memberof MethodDto
     */
    public async getCacheData(context: IContext, srfkey: string) {
        const targetService: IEntityLocalDataService<any> = await this.getService(context);
        const result = await targetService.getLocal(context, srfkey);
        if (result) {
            return await this.ToDto(context, result);
        }
    }

    /**
     * 获取缓存数组
     *
     * @param {*} context 应用上下文对象
     * @returns {any[]}
     * @memberof MethodDto
     */
    public async getCacheDataArray(context: IContext) {
        const targetService: IEntityLocalDataService<any> = await this.getService(context);
        const result = await targetService.getLocals(context);
        if (result && result.length > 0) {
            return await this.ToDtoArray(context, result);
        } else {
            return [];
        }
    }

    /**
     * 设置缓存数据
     *
     * @param {*} context 应用上下文对象
     * @param {any} data 数据
     * @returns {any[]}
     * @memberof MethodDto
     */
    public async setCacheData(context: IContext, data: any) {
        const targetService: IEntityLocalDataService<any> = await this.getService(context);
        const _data: any = await this.set(context, data);
        await targetService.addLocal(context, _data);
    }

    /**
     * 设置缓存数组
     *
     * @param {*} context 应用上下文对象
     * @param {any[]} data 数据
     * @returns {any[]}
     * @memberof MethodDto
     */
    public async setCacheDataArray(context: IContext, data: any[]) {
        if (data && data.length > 0) {
            const targetService: IEntityLocalDataService<any> = await this.getService(context);
            for (let i = 0; i < data.length; i++) {
                const _data = await this.set(context, data[i]);
                await targetService.addLocal(context, _data);
            }
        }
    }
}