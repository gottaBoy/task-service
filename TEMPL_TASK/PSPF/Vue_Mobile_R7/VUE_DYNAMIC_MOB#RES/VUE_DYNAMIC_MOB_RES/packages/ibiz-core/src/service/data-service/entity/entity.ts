import { IPSAppDataEntity, IPSAppDEField } from "@ibiz/dynamic-model-api";
import { IEntityBase } from "../../../interface";
export class Entity implements IEntityBase {

    /**
     * 应用实体模型
     *
     * @protected
     * @type {IPSAppDataEntity}
     * @memberof Entity
     */
    private appDataEntity!: IPSAppDataEntity;

    /**
     * 应用实体全部属性
     * 
     *
     * @readonly
     * @type {string[]}
     * @memberof Entity
     */
    private get keys(): string[] {
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
     * 排序值
     *
     * @type {number}
     * @memberof Entity
     */
    public srfordervalue?: number;

    /**
     * 临时数据最后更新时间时间戳
     *
     * @type {number}
     * @memberof Entity
     */
    public srftempdate?: number;

    /**
     * 当前数据所属状态
     *
     * @default 1 默认为非新建状态
     * @type {(0 | 1)} 0: 新建，1: 非新建
     */
    public srfuf?: 0 | 1;

    [key: string]: any;

    /**
     * Creates an instance of Entity.
     * 私有构造，拒绝通过 new 创建对象
     *
     * @memberof Entity
     */
    public constructor(appDataEntity: IPSAppDataEntity, data?: any) {
        this.appDataEntity = appDataEntity;
        this.setData(data);
    }

    /**
     * 实体名称
     *
     * @readonly
     * @type {string}
     * @memberof Entity
     */
    get srfdename(): string {
        if (this.appDataEntity) {
            return this.appDataEntity.name;
        } else {
            return '';
        }
    }

    /**
     * 获取主键属性
     *
     * @memberof Entity
     */
    get srfkey() {
        if (this.appDataEntity && this.appDataEntity.getKeyPSAppDEField()) {
            return this[(this.appDataEntity?.getKeyPSAppDEField() as IPSAppDEField).codeName.toLowerCase()];
        }
    }

    /**
     * 设置主键属性
     *
     * @memberof Entity
     */
    set srfkey(value: any) {
        if (this.appDataEntity && this.appDataEntity.getKeyPSAppDEField()) {
            this[(this.appDataEntity.getKeyPSAppDEField() as IPSAppDEField).codeName.toLowerCase()] = value;
        }
    }

    /**
     * 获取主信息属性
     *
     * @memberof Entity
     */
    get srfmajortext() {
        if (this.appDataEntity && this.appDataEntity.getMajorPSAppDEField()) {
            return this[(this.appDataEntity.getMajorPSAppDEField() as IPSAppDEField).codeName.toLowerCase()];
        }
    }

    /**
     * 设置主信息属性
     *
     * @memberof Entity
     */
    set srfmajortext(value: any) {
        if (this.appDataEntity && this.appDataEntity.getMajorPSAppDEField()) {
            this[(this.appDataEntity.getMajorPSAppDEField() as IPSAppDEField).codeName.toLowerCase()] = value;
        }
    }

    /**
     * 设置数据
     *
     * @public
     * @param {*} [data={}]
     * @param {boolean} [reset=false]
     * @memberof Entity
     */
    public setData(data: any = {}, reset = false): void {
        const keyMap: Map<string, null> = new Map();
        for (const key in data) {
            if (data[key] !== void 0 && typeof data[key] !== 'function') {
                this[key] = data[key];
                keyMap.set(key, null);
            }
        }
        this.keys.forEach((key: string) => {
            if (keyMap.has(key)) {
                return;
            }
            if (data[key] !== void 0) {
                this[key] = data[key];
            } else if (reset && this[key] !== void 0) {
                delete this[key];
            }
        });
    }

    /**
     * 重置实体数据
     *
     * @public
     * @param {*} [data={}]
     * @memberof Entity
     */
    public reset(data: any = {}): void {
        this.setData(data, true);
        if (this.appDataEntity) {
            const keyFieldStr = this.appDataEntity.getKeyPSAppDEField()?.codeName;
            const majorFieldStr = this.appDataEntity.getMajorPSAppDEField()?.codeName;
            if (keyFieldStr) {
                this[keyFieldStr.toLowerCase()] = data[keyFieldStr.toLowerCase()] || data.srfkey;
            }
            if (majorFieldStr) {
                this[majorFieldStr.toLowerCase()] = data[majorFieldStr.toLowerCase()] || data.srfmajortext;
            }
        }
    }

    /**
     * 合并数据
     *
     * @public
     * @param {*} [data={}]
     * @memberof Entity
     */
    public assign(data: any = {}): void {
        this.setData(data);
    }

    /**
     * 克隆实体对象
     *
     * @return {*}  {Entity}
     * @memberof Entity
     */
    public clone(): Entity {
        return new Entity(this.appDataEntity);
    }

}