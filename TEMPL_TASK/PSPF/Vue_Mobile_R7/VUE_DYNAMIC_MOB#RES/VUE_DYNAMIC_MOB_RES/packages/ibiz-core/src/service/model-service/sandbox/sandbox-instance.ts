import {  GlobalHelp, ModelInstanceHelp } from "@ibiz/dynamic-model-api";
import qs from 'qs';
import { Http } from "../../../utils/net/http";
import { AppServiceBase } from "../../app-service/app-base.service";
import { AppModelService } from "../model-service";
import { SandboxService } from "./sandbox-service";

/**
 * 沙箱实例
 *
 * @export
 * @class SandboxInstance
 */
export class SandboxInstance {

    /**
     * 模型帮助实例
     * 
     * @memberof SandboxInstance
     */
    protected help!: ModelInstanceHelp;

    /**
     * 沙箱tag
     * 
     * @memberof SandboxInstance
     */
    protected sandboxTag !: string;

    /**
     * Creates an instance of SandboxInstance.
     * 
     * @param {*} [opts={}]
     * @memberof SandboxInstance
     */
    constructor(opts: any = {}) {
        this.sandboxTag = opts.srfsandboxtag;
    }

    /**
     * 初始化沙箱
     * 
     * @param {*} [opts={}]
     * @memberof SandboxInstance
     */
    public async initSandBox() {
        const service = new AppModelService();
        this.help = await GlobalHelp.sandboxInstall(service, async (strPath: string) => {
            let url: string = '';
            const Environment = AppServiceBase.getInstance().getAppEnvironment();
            if (Environment.bDynamic) {
                url = `${Environment.remoteDynaPath}${strPath}`;
                const queryParam = {};
                const { dynamodeltag } = AppServiceBase.getInstance().getAppStore().getters.getAppData();
                if (dynamodeltag) {
                    Object.assign(queryParam, { dynamodeltag });
                }
                if (queryParam && Object.keys(queryParam).length > 0) {
                    url += `?${qs.stringify(queryParam)}`;
                }
            } else {
                const microAppService = AppServiceBase.getInstance().getMicroAppService();
                if(microAppService && microAppService.getIsMicroApp() && microAppService.getMicroAppFolder()){
                    url = `./${microAppService.getMicroAppFolder()}/assets/model${strPath}`;
                }else{
                    url = `./assets/model${strPath}`;
                }
            }
            try {
                const result: any = await Http.getInstance().getModel(url, { srfdynaorgid: this.sandboxTag });
                return result.data ? result.data : null;
            } catch (error) {
                return null;
            }
        });
        SandboxService.getInstance().setSandBoxInstance(this.sandboxTag, this);
    }

    /**
     * 获取modelService
     * 
     * @param {*} [opts={}]
     * @memberof SandboxInstance
     */
    public async getModelService(param: any) {
        return this.help.getModelService();
    }

}