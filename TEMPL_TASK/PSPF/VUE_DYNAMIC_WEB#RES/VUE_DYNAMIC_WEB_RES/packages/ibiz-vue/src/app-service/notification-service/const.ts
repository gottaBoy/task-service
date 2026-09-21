import { IParams } from "ibiz-core";

// 类型
export enum Type {
    // 命令
    COMMAND = 'COMMAND',
    // 控制信息
    CONSOLE = 'CONSOLE',
}

// 子类型
export enum SubType {
    // 标注打开数据
    MARKOPENDATA = 'MARKOPENDATA',
    // 刷新待办（暂未支持）
    REFRESHTODO = 'REFRESHTODO',
    // 异步作业
    ASYNCACTION = 'ASYNCACTION',
}

// 执行状态
export enum ActionState {
    // 未开始
    NOTCREATED = 10,
    // 执行中
    CREATING = 20,
    // 已执行
    CREATED = 30,
    // 执行失败
    FAILED = 40,
}

/**
 * 消息接口
 *
 * @export
 * @interface NotificationItem
 */
export interface NotificationItem {
    // 标识
    id: string;
    // 名称
    name: string;
    // 状态
    state: number;
    // 状态文本
    stateText: string;
    // 创建时间
    createdate: string;
    // 创建人
    createman: string;
    // 更新时间
    updatedate: string;
    // 更新人
    updateman: string;
    // 开始时间
    begintime: string;
    // 操作参数
    actionparam: string;
    // 操作参数2
    actionparam2: string;
    // 执行信息
    stepinfo: string | undefined;
    // 执行完成率
    completionrate: number | undefined;
    // 操作结果
    actionresult: string | undefined;
    // 行为类型
    actiontype: string | undefined;
}

// 异步结果
export interface AsyncResult{
    // 是否成功
    success:boolean;
    // 数据
    data:IParams;
}

// 异步服务接口
export interface IAsyncService{

    /**
     * 初始化
     *
     * @return {*}  {Promise<AsyncResult>}
     * @memberof IAsyncService
     */
    init():Promise<AsyncResult>;

    /**
     * 获取所有异步通知
     *
     * @param {boolean} isunique 去重
     * @return {*}  {NotificationItem[]}
     * @memberof IAsyncService
     */
    getItems(isunique:boolean): NotificationItem[];
    
    /**
     * 添加异步通知
     *
     * @param {*} item
     * @memberof IAsyncService
     */
    addItem(item: any):void;
}