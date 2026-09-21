import { Http, Util } from 'ibiz-core';
import { AppCenterService } from '../common-service';
import { AsyncResult, IAsyncService, NotificationItem } from './const';

/**
 * 异步作业服务
 *
 * @export
 * @class AsyncActionService
 */
export class AsyncActionService implements IAsyncService {
    /**
     * 异步作业集合
     *
     * @private
     * @type {Array<NotificationItem>}
     * @memberof AsyncActionService
     */
    private asyncActions: Array<NotificationItem> = [];

    /**
     * 操作状态对象（用于数据转化）
     *
     * @private
     * @memberof AsyncActionService
     */
    private actionStateObj: any = {
        10: '未开始',
        20: '执行中',
        30: '已执行',
        40: '执行失败',
    };

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AsyncActionService}
     * @memberof AsyncActionService
     */
    private static AsyncActionService: AsyncActionService;

    /**
     * 获取 AsyncActionService 单例对象
     *
     * @static
     * @returns {AsyncActionService}
     * @memberof AsyncActionService
     */
    public static getInstance(): AsyncActionService {
        if (!AsyncActionService.AsyncActionService) {
            AsyncActionService.AsyncActionService = new AsyncActionService();
        }
        return this.AsyncActionService;
    }

    /**
     * 初始化
     *
     * @memberof AsyncActionService
     */
    public async init(): Promise<AsyncResult> {
        this.asyncActions = [];
        const url = '/portal/asyncaction/all';
        const response = await Http.getInstance().post(url);
        if (response.status && response.status === 200 && response.data && response.data.length > 0) {
            response.data.forEach((item: any) => {
                const data = this.handleItem(item);
                this.asyncActions.push(data);
            });
            AppCenterService.notifyMessage({ name: 'AsyncAction', action: 'InitItem', data: this.asyncActions });
        }
        return { success: true, data: this.asyncActions };
    }

    /**
     * 获取所有异步消息
     * @returns
     */
    public getItems(isunique: boolean): NotificationItem[] {
        if (!isunique) {
            return this.asyncActions;
        } else {
            const targetActions = this.asyncActions.filter(
                (obj, index, self) => index === self.findIndex(t => t.id === obj.id),
            );
            return targetActions;
        }
    }

    /**
     * 添加
     *
     * @memberof AsyncActionService
     */
    public addItem(item: any) {
        const data = this.handleItem(item.data);
        this.asyncActions.unshift(data);
        AppCenterService.notifyMessage({ name: 'AsyncAction', action: 'AddItem', data });
    }

    /**
     * 处理单条异步消息
     *
     * @private
     * @param {*} data
     * @memberof AsyncActionService
     */
    private handleItem(data: any): NotificationItem {
        try {
            return {
                id: data.asyncacitonid,
                name: data.asyncacitonname,
                state: data.actionstate,
                stateText: this.actionStateObj[data.actionstate],
                createdate: Util.dateFormat(new Date(data.createdate)),
                createman: data.createman,
                updatedate: Util.dateFormat(new Date(data.updatedate)),
                updateman: data.updateman,
                begintime: Util.dateFormat(new Date(data.begintime)),
                actionparam: data.actionparam,
                actionparam2: data.actionparam2,
                stepinfo: data.stepinfo,
                completionrate: data.completionrate,
                actionresult: data.actionresult,
                actiontype: data.actiontype,
            };
        } catch (error) {
            throw new Error('处理单条异步消息异常');
        }
    }
}
