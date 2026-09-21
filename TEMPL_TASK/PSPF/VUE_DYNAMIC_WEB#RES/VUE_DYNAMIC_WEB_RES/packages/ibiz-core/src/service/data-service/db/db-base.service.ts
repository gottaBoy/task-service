import Dexie, { Version } from 'dexie';

/**
 * 库实例基类
 *
 * @export
 * @class DBBaseService
 * @extends {Dexie}
 */
export class DBBaseService extends Dexie {
    protected v: Version;

    /**
     * Creates an instance of DBService.
     */
    constructor() {
        super('DefaultDB');
        this.v = this.version(1);
        this.init();
    }

    /**
     * 数据库初始化
     *
     * @protected
     */
    protected init(): void {
        throw new Error('数据库实例化需要重写!');
    }
}
