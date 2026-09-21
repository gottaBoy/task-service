import * as dd from 'dingtalk-jsapi';
import { Http, ViewTool } from "ibiz-core";

export interface stateResult {

    /**
     * 状态
     *
     * @memberof stateResult
     */
    state: "SUCCESS" | "ERROR";

    /**
     * 数据
     *
     * @memberof stateResult
     */
    result: any;

}
/**
 * 第三方登录服务
 * 
 * @memberof AppThirdService
 */
export class AppThirdService {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AppThirdService}
     * @memberof AppThirdService
     */
    private static appThirdService: AppThirdService;

    /**
     * 获取 AppThirdService 单例对象
     *
     * @static
     * @returns {AppThirdService}
     * @memberof AppThirdService
     */
    public static getInstance(): AppThirdService {
        if (!AppThirdService.appThirdService) {
            AppThirdService.appThirdService = new AppThirdService();
        }
        return this.appThirdService;
    }

    /**
     * 钉钉授权登录
     * 
     * @memberof AppThirdService
     */
    public dingtalkLogin(Environment: any): Promise<any> {
        return new Promise((resolve) => {
            //  请求头
            const headers = {};
            const tempViewParam = ViewTool.getDcSystemIdViewParam();
            if (tempViewParam && tempViewParam.srfdcsystem) {
                Object.assign(headers, { srfdcsystem: tempViewParam.srfdcsystem });
            }
            const get: Promise<any> = Http.getInstance().get('/uaa/open/dingtalk/appid', {}, false, headers);
            get.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && data.appid) {
                        resolve({ state: "SUCCESS", data: data });
                    } else {
                        resolve({ state: "ERROR", message: `获取网站应用appid失败，${data.detail}` });
                    }
                }
            }).catch((error: any) => {
                const data = error.data;
                if (data && data.detail) {
                    resolve({ state: "ERROR", message: `获取网站应用appid失败，${data.detail}` });
                } else {
                    resolve({ state: "ERROR", message: `获取网站应用appid失败` });
                }
            });
        })
    }

    /**
     * 企业微信授权登录
     * 
     * @memberof AppThirdService
     */
    public wxWorkLogin(Environment: any): Promise<any> {
        return new Promise((resolve) => {
            //  请求头
            const headers = {};
            const tempViewParam = ViewTool.getDcSystemIdViewParam();
            if (tempViewParam && tempViewParam.srfdcsystem) {
                Object.assign(headers, { srfdcsystem: tempViewParam.srfdcsystem });
            }
            const get: Promise<any> = Http.getInstance().get('/uaa/open/wxwork/appid', {}, false, headers);
            get.then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && (data.corp_id || data.appid)) {
                        resolve({ state: "SUCCESS", data: data });
                    } else {
                        resolve({ state: "ERROR", message: `获取网站应用appid失败，${data.detail}` });
                    }
                }
            }).catch((error: any) => {
                const data = error.data;
                if (data && data.detail) {
                    resolve({ state: "ERROR", message: `获取网站应用appid失败，${data.detail}` });
                } else {
                    resolve({ state: "ERROR", message: `获取网站应用appid失败` });
                }
            });
        })
    }

    /**
     * 钉钉内部免登
     * 
     * @memberof AppThirdService
     */
    public embedDingTalkLogin(Environment: any): Promise<any> {
        return new Promise((resolve) => {
            //  请求头
            const headers = {};
            const tempViewParam = ViewTool.getDcSystemIdViewParam();
            if (tempViewParam && tempViewParam.srfdcsystem) {
                Object.assign(headers, { srfdcsystem: tempViewParam.srfdcsystem });
            }
            const param = ViewTool.handleViewParam(window.location.href);
            if(param.corpId){
                let corpId:string = param.corpId;
                if(corpId.indexOf("#") > -1){
                    corpId = corpId.split("#")[0];
                }
                dd.runtime.permission.requestAuthCode({ corpId }).then((res: any) => {
                    if (res && res.code) {
                        Http.getInstance().get(`/uaa/open/dingtalk/auth/${res.code}`, {}, false, headers).then((res: any) => {
                            if (res.status == 200 && (res.data.token || res.data.user)) {
                                resolve({ state: "SUCCESS", data: res.data });
                            } else {
                                resolve({ state: "ERROR", message: `${res.data.message}` });
                            }
                        })
                    } else {
                        resolve({ state: "ERROR", message: `钉钉用户信息获取失败` });
                    }
                }).catch((error: any) => {
                    resolve({ state: "ERROR", message: `钉钉用户信息获取失败` });
                })
            }else{
                resolve({ state: "ERROR", message: `获取企业ID失败` });
            }
        })
    }


}