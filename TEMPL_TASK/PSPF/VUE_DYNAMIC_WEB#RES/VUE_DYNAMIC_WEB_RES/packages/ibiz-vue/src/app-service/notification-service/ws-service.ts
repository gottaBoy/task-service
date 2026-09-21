import { getCookie } from 'qx-util';
import { NotificationFactory } from './notification-factory';
import { AppServiceBase } from 'ibiz-core';
/**
 * ws服务
 *
 * @export
 * @class WSService
 */
export class WSService {
    /**
     * 客户端标识
     *
     * @private
     * @type {string}
     * @memberof WSService
     */
    private clientId: string = '';

    /**
     * 监听标识
     *
     * @private
     * @type {string}
     * @memberof WSService
     */
    private id: string = '';

    /**
     * 客户端
     *
     * @private
     * @type {*}
     * @memberof WSService
     */
    private client: any;

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {WSService}
     * @memberof WSService
     */
    private static WSService: WSService;

    /**
     * 获取 WSService 单例对象
     *
     * @static
     * @returns {WSService}
     * @memberof WSService
     */
    public static getInstance(): WSService {
        if (!WSService.WSService) {
            WSService.WSService = new WSService();
        }
        return this.WSService;
    }

    /**
     * Creates an instance of WSService.
     * @memberof WSService
     */
    public constructor() {
        this.clientId = 'client_' + parseInt((Math.random() * 100000).toString());
    }

    /**
     * 初始化
     *
     * @param {string} host
     * @param {number} port
     * @param {string} url
     * @param {string} id
     * @memberof WSService
     */
    public init(host: string, port: number, url: string, id: string) {
        if(!this.client){
            this.client = new (window as any).Paho.MQTT.Client(host, port, url, this.clientId);
            this.id = id;
            this.connect();
        }
    }

    /**
     * 销毁
     *
     * @memberof WSService
     */
    public destroy(){
        if(this.client){
            this.client.unsubscribe();
            this.client.disconnect();
        }
    }

    /**
     * 连接ws
     *
     * @memberof WSService
     */
    private connect() {
        const options = {};
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        Object.assign(options, {
            userName: this.id,
            password: getCookie('ibzuaa-token'),
            invocationContext: {
                path: this.client.path,
                clientId: this.clientId,
            },
            onSuccess: () => {
                console.log('连接成功');
                this.client.subscribe(this.id);
            },
            onFailure: (err: any) => {
                if (Environment.wsRetry) {
                    console.error(`连接失败: ${err.errorMessage}, 正在重连...`);
                    Environment.wsRetry--;
                    this.connect();
                } else {
                    console.error('连接失败:' + err.errorMessage);
                }
            },
        });
        this.client.connect(options);
        this.client.onMessageArrived = this.handleMessage.bind(this);
    }

    /**
     * 处理消息
     *
     * @param {*} message
     * @memberof WSService
     */
    public handleMessage(message: any){
        if (message && message.payloadString) {
            const msg = JSON.parse(message.payloadString);
            NotificationFactory.getInstance().addItem(msg);
        }
    }
}
// 导出默认实例
export const ws = WSService.getInstance();
