import { IParams } from 'ibiz-core';
import { AppCenterService } from '../common-service';
import { AsyncActionService } from './async-action-service';
import { NotificationItem, SubType } from './const';
import { ws } from './ws-service';

/**
 * 通知工厂
 */
export class NotificationFactory {
    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {NotificationFactory}
     * @memberof NotificationFactory
     */
    private static NotificationFactory: NotificationFactory;

    /**
     * 获取 NotificationFactory 单例对象
     *
     * @static
     * @returns {NotificationFactory}
     * @memberof NotificationFactory
     */
    public static getInstance(): NotificationFactory {
        if (!NotificationFactory.NotificationFactory) {
            NotificationFactory.NotificationFactory = new NotificationFactory();
        }
        return this.NotificationFactory;
    }

    /**
     * 初始化
     *
     * @param {IParams} args
     * @memberof NotificationFactory
     */
    public init(args: IParams) {
        const { host, port, url, id } = args;
        ws.init(host, port, url, id);
        AsyncActionService.getInstance().init().then((res:any) =>{
            if(res.success){
                AppCenterService.notifyMessage({ name: 'Notification', action: 'InitItem', data: res.data });
            }
        })
    }

    /**
     * 销毁
     *
     * @memberof WSService
     */
    public destroy(){
        ws.destroy();
    }

    /**
     * 获取通知子实例
     *
     * @param {string} type
     * @memberof NotificationFactory
     */
    public getSubInstance(type: string): AsyncActionService | null {
        if (!type) {
            return null;
        }
        switch (type) {
            case SubType.ASYNCACTION:
                return AsyncActionService.getInstance();
            default:
                console.log(`${type}暂未支持`);
                return null;
        }
    }

    /**
     * 获取所有异步通知(目前仅实现异步作业，后续应该统一返回)
     *
     * @param {boolean} [isunique=false] 去重
     * @return {*}  {Array<NotificationItem>}
     * @memberof NotificationFactory
     */
    public getItems(isunique:boolean = false): Array<NotificationItem> {
        return AsyncActionService.getInstance().getItems(isunique);
    }

    /**
     * 添加异步通知(目前仅实现异步作业，后续应该统一返回)
     *
     * @memberof NotificationFactory
     */
    public addItem(item: any) {
        if (!item || !item.subtype) {
            return;
        }
        console.warn('异步通知内容:', item);
        switch (item.subtype) {
            case SubType.ASYNCACTION:
                AsyncActionService.getInstance().addItem(item);
                AppCenterService.notifyMessage({ name: 'Notification', action: 'AddItem', data: item });
                break;
            default:
                console.log(`${item.subtype}暂未支持`);
                break;
        }
    }
}
