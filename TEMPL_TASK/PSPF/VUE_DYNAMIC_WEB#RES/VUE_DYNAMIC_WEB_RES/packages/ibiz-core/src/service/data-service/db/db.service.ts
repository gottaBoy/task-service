import { DBBaseService } from './db-base.service';

/**
 * 库实例
 *
 * @export
 * @class DBService
 * @extends {DBBaseService}
 */
export class DBService extends DBBaseService {
    /**
     * 唯一实例
     *
     * @protected
     * @static
     */
    protected static instance: any;

    /**
     * Creates an instance of DBService.
     *
     */
    constructor() {
        if (DBService.instance) {
            return DBService.instance;
        }
        super();
    }

    /**
     * 数据库初始化
     *
     * @protected
     */
    protected init(): void {
        this.v = this.v.stores({
            // <#if app.getAllPSAppDataEntities?? && app.getAllPSAppDataEntities()??>
            //     <#list app.getAllPSAppDataEntities() as entity>
            //         <#assign keyField = entity.getKeyPSAppDEField()>
            //         <#if keyField?? && entity.getStorageMode?? && entity.getStorageMode()?? && entity.getStorageMode() == 1>
            //             ${entity.getCodeName()}: '&${keyField.getCodeName()?lower_case}',
            //         </#if>
            //     </#list>
            // </#if>
        });
    }

    /**
     * 获取实例
     *
     * @static
     * @return {*}  {DBService}
     */
    static getInstance(): DBService {
        if (!this.instance) {
            this.instance = new DBService();
        }
        return this.instance;
    }
}
