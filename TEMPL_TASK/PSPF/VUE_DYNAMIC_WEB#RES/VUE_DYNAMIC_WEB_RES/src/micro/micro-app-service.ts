import { Environment } from "@/environments/environment";
import { Util } from "ibiz-core";
import { MicroActionService } from "./micro-action-service";

type AppState = {
    /**
     * 触发行为
     *
     * @type {string}
     */
    action: string,

    /**
     * 数据
     *
     * @type {*}
     */
    data?: any
}
/**
 * 应用服务
 *
 * @export
 * @class MicroAppService
 */
export class MicroAppService {

    /**
     * 唯一实例
     * 
     * @private
     * @static
     * @memberof MicroAppService
     */
    private static readonly instance = new MicroAppService();

    /**
     * 获取唯一实例
     *
     * @static
     * @return {*}  {MicroAppService}
     * @memberof MicroAppService
     */
    public static getInstance(): MicroAppService {
        return MicroAppService.instance;
    }

    /**
     * 消息对象实例
     * 
     * @private
     * @memberof MicroAppService
     */
    private static AppState: any

    /**
     * 是否为微应用
     *
     * @private
     * @static
     * @type {boolean}
     * @memberof MicroAppService
     */
    private static isMicroApp: boolean = false;

    /**
     * 微应用部署目录
     *
     * @private
     * @static
     * @type {string}
     * @memberof MicroAppService
     */
    private static microAppFolder: string = '';

    /**
     * 微应用激活路由
     *
     * @private
     * @static
     * @type {string}
     * @memberof MicroAppService
     */
    private static microAppActiveRule:string = '';

    /**
     * 消息状态事件
     *
     * @protected
     * @type {*}
     * @memberof MicroAppService
     */
    private AppStateEvent: any;

    /**
     * 获取消息对象
     *
     * @return {*}  {*}
     * @memberof MicroAppService
     */
    public getAppState() {
        return MicroAppService.AppState;
    }

    /**
     * 设置消息对象实例
     *
     * @param {AppState} AppState
     * @memberof MicroAppService
     */
    public setAppState(AppState: any) {
        MicroAppService.AppState = AppState;
    }

    /**
     * 获取当前应用是否为微应用
     *
     * @return {*} 
     * @memberof MicroAppService
     */
    public getIsMicroApp() {
        return MicroAppService.isMicroApp;
    }

    /**
     * 设置当前应用是否为微应用
     *
     * @return {*} 
     * @memberof MicroAppService
     */
    public setIsMicroApp(value: boolean) {
        MicroAppService.isMicroApp = value;
    }

    /**
     * 获取部署路径
     *
     * @return {*} 
     * @memberof MicroAppService
     */
     public getMicroAppFolder() {
        return MicroAppService.microAppFolder;
    }

    /**
     * 设置部署路径
     *
     * @return {*} 
     * @memberof MicroAppService
     */
    public setMicroAppFolder(value: string) {
        MicroAppService.microAppFolder = value;
    }

    /**
     * 获取微应用激活路由
     *
     * @return {*} 
     * @memberof MicroAppService
     */
     public getMicroAppActiveRule(){
        return MicroAppService.microAppActiveRule;
    }

    /**
     * 设置微应用激活路由
     *
     * @return {*} 
     * @memberof MicroAppService
     */
    public setMicroAppActiveRule(value:string){
        MicroAppService.microAppActiveRule = value;
    }

    /**
     * 初始化微应用
     *
     * @memberof MicroAppService
     */
    public initMicroApp(args: any = {}) {
        this.setIsMicroApp(true);
        console.log('初始化微应用...');
    }

    /**
     * 挂载微应用
     *
     * @memberof MicroAppService
     */
    public mountMicroApp(args: any = {}) {
        if (args.AppState) {
            this.setAppState(args.AppState);
            if(this.getAppState()){
                this.AppStateEvent = this.getAppState().subscribe((state: any) => {
                    const { tag } = state;
                    if (Object.is(tag, Environment.microAppName)) {
                        this.handleMicroApp(state);
                    }
                })
            }
        }
        if (args.microAppFolder) {
            this.setMicroAppFolder(args.microAppFolder);
        }
        if(args.activeRule){
            this.setMicroAppActiveRule(args.activeRule);
        }
        console.log('挂载微应用...');
    }

    /**
     * 销毁微应用
     *
     * @static
     * @memberof MicroAppService
     */
    public destroyMicroApp(args: any = {}) {
        let { instance } = args;
        if (instance) {
            instance.$destroy();
            instance.$el.innerHTML = '';
            instance = null;
        }
        if (this.AppStateEvent) {
            this.AppStateEvent.unsubscribe();
        }
        console.log('销毁微应用...');
    }

    /**
     * 通知基座应用
     *
     * @param {AppState} state
     * @memberof MicroAppService
     */
    public noticeBaseApp(state: AppState) {
        const emitState = Util.deepCopy(state);
        Object.assign(emitState, { tag: 'BASEAPP' });
        if(this.getAppState()){
            this.getAppState().next(emitState);
        }
    }

    /**
     * 处理基座应用通知
     *
     * @param {*} state
     * @memberof MicroAppService
     */
    public handleMicroApp(state: any) {
        MicroActionService.getInstance().handleAction(state);
    }

}