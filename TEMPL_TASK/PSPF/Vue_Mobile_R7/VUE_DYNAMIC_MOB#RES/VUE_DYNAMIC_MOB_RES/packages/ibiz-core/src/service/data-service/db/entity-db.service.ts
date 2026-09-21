import Dexie from 'dexie';
import { createUUID, isNilOrEmpty } from 'qx-util';
import { IContext, IEntityBase } from '../../../interface';
import { LogUtil } from '../../../utils';
import { DBService } from './db.service';

/**
 * 数据对象基类 前端应用实体存储主键，统一为srfSessionKey
 *
 * @export
 * @class EntityDBService<T>
 */
export class EntityDBService<T extends IEntityBase> {
    /**
     * 当前表
     *
     * @type {Dexie.Table<T, string>}
     */
    readonly tab!: Dexie.Table<T, string>;

    /**
     * Creates an instance of EntityDBService.
     *
     * @param {string} entityName
     * @param {(data: any) => T} newEntity
     * @param {(entity: T) => any} filterEntityData
     */
    constructor(
        protected entityName: string,
        protected newEntity: (data: any) => T,
        protected filterEntityData: (entity: T) => any,
    ) {
        const db = DBService.getInstance();
        try {
            this.tab = db.table(entityName);
        } catch (err) {
            LogUtil.error(err);
        }
    }

    /**
     * 新增数据
     *
     * @param {IContext} _context
     * @param {T} entity
     * @return {*}  {Promise<T>}
     */
    async create(_context: IContext, entity: T): Promise<T> {
        try {
            if (isNilOrEmpty(entity.srfkey)) {
                entity.srfkey = createUUID();
            }
            const key = await this.tab.add(this.filterEntityData(entity));
            if (key) {
                return entity;
            }
        } catch (err) {
            LogUtil.error(err);
        }
        return null!;
    }

    /**
     * 更新数据
     *
     * @param {IContext} _context
     * @param {T} entity
     * @return {*}  {Promise<T>}
     */
    async update(_context: IContext, entity: T): Promise<T> {
        try {
            const res = await this.tab.put(this.filterEntityData(entity),entity.srfkey!);
            if (res) {
                return entity;
            }
        } catch (err) {
            LogUtil.error(err);
        }
        return null!;
    }

    /**
     * 获取数据
     *
     * @param {IContext} _context
     * @param {string} key
     * @return {*}  {Promise<T>}
     */
    async get(_context: IContext, key: string): Promise<T> {
        try {
            const data = await this.tab.get(key);
            if (data) {
                return this.newEntity(data);
            }
        } catch (err) {
            LogUtil.error(err);
        }
        return null!;
    }

    /**
     * 数据是否存在
     *
     * @param {IContext} _context
     * @param {string} key
     * @return {*}  {Promise<boolean>}
     */
    async checkData(_context: IContext, key: string): Promise<boolean> {
        try {
            const data = await this.tab.get(key);
            if (data) {
                return true;
            }
        } catch (err) {
            LogUtil.error(err);
        }
        return false;
    }

    /**
     * 根据索引查询数据
     *
     * @param {IContext} _context
     * @param {string} val 索引属性值
     * @param {string} indexName 索引属性
     * @return {*}  {Promise<T>}
     */
    async getByIndex(_context: IContext, val: string, indexName: string): Promise<T> {
        try {
            const data = await this.tab
                .where(indexName)
                .equals(val)
                .first();
            if (data) {
                return this.newEntity(data);
            }
        } catch (err) {
            LogUtil.error(err);
        }
        return null!;
    }

    /**
     * 删除数据
     *
     * @param {IContext} _context
     * @param {string} key
     * @return {*}  {Promise<boolean>}
     */
    async remove(_context: IContext, key: string): Promise<boolean> {
        try {
            await this.tab.delete(key);
            return true;
        } catch (err) {
            LogUtil.error(err);
        }
        return false;
    }

    /**
     * 搜索
     * 
     * @param {IContext} _context
     * @return {*}  {Promise<T[]>}
     */
    async search(_context: IContext): Promise<T[]> {
        const items = await this.tab.toArray();
        return items.map(item => this.newEntity(item));
    }

    /**
     * 清空存储
     *
     * @return {*}  {boolean}
     */
    async clear(): Promise<boolean> {
        try {
            await this.tab.clear();
            return true;
        } catch (err) {
            LogUtil.error(err);
        }
        return false;
    }
}
