import { Environment } from "@/environments/environment";
import { AppServiceBase, Http, LogUtil, ViewTool } from "ibiz-core";

/**
 * 应用无权限服务
 * 
 * @memberof AppNoAuthDataService
 */
export class AppNoAuthDataService {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AppNoAuthDataService}
     * @memberof AppNoAuthDataService
     */
    private static AppNoAuthDataService: AppNoAuthDataService;

    /**
     * 样式表请求路径
     *
     * @private
     * @type {string}
     * @memberof AppNoAuthDataService
     */
    private appUserStyleUrl: string = 'simple/PSSYSAPP.simple.json.css';

    /**
     * 样式表是否挂载
     *
     * @public
     * @type {boolean}
     * @memberof AppNoAuthDataService
     */
    public appUserStyleIsMounted: boolean = false;

    /**
     * 无权限数据请求路径
     *
     * @private
     * @type {string}
     * @memberof AppNoAuthDataService
     */
    private appNoAuthDataUrl: string = 'simple/PSSYSAPP.simple.json';

    /**
     * 无权限数据是否挂载
     *
     * @type {boolean}
     * @memberof AppNoAuthDataService
     */
    public appNoAuthDataIsMounted: boolean = false;

    /**
     * 获取AppNoAuthDataService单例对象
     *
     * @static
     * @returns {AppNoAuthDataService}
     * @memberof AppNoAuthDataService
     */
    public static getInstance(): AppNoAuthDataService {
        if (!this.AppNoAuthDataService) {
            this.AppNoAuthDataService = new AppNoAuthDataService();
        }
        return this.AppNoAuthDataService;
    }

    /**
     * 挂载基础数据
     *
     * @return {*} 
     * @memberof AppNoAuthDataService
     */
    public async mountedAppBasicData() {
        if (!this.appUserStyleIsMounted) {
            const result = await this.mountedAppStyle();
        }
        if (!this.appNoAuthDataIsMounted) {
            const result = await this.mountedAppNoAuthData();
        }
        return true;
    }

    /**
     * 挂载应用样式表
     * 
     */
    public async mountedAppStyle() {
        const cssUrl = this.appUserStyleUrl;
        try {
            const cssContent = await this.loadAppUserStyle(cssUrl);
            if (!cssContent) {
                return true;
            }
            this.mountedAppUserStyle(cssContent);
            AppServiceBase.getInstance().setAppUserStyle(cssContent);
            return true;
        } catch (error) {
            LogUtil.error("挂载应用样式表异常");
            return true;
        } finally {
            this.appUserStyleIsMounted = true;
        }
    }

    /**
     * 挂载应用无权限数据
     *
     * @memberof AppNoAuthDataService
     */
    public async mountedAppNoAuthData() {
        const dataUrl = this.appNoAuthDataUrl;
        try {
            const noAuthData = await this.loadNoAuthData(dataUrl);
            if (!noAuthData) {
                return true;
            }
            AppServiceBase.getInstance().setAppNoAuthData(noAuthData);
            if(noAuthData.name){
                Object.assign(Environment,{AppTitle:noAuthData.name});
                document.title = Environment.AppTitle;
            }
            return true;
        } catch (error) {
            LogUtil.error("挂载应用无权限数据异常");
            return true;
        } finally {
            this.appNoAuthDataIsMounted = true;
        }
    }

    /**
     * 加载应用自定义样式表
     * 
     * @param cssUrl 样式路径
     */
    public async loadAppUserStyle(cssUrl: string) {
        let url = '';
        if (Environment.bDynamic) {
            url = `${Environment.remoteDynaPath}/${cssUrl}`;
        } else {
            const microAppService = AppServiceBase.getInstance().getMicroAppService();
            if (microAppService && microAppService.getIsMicroApp() && microAppService.getMicroAppFolder()) {
                url = `./${microAppService.getMicroAppFolder()}/assets/model/${cssUrl}`;
            } else {
                url = `./assets/model/${cssUrl}`;
            }
        }
        try {
            let headers: any = {};
            const tempViewParam = ViewTool.getDcSystemIdViewParam();
            if (tempViewParam.srfdcsystem) {
                headers.srfdcsystem = tempViewParam.srfdcsystem
            }
            const result: any = await Http.getInstance().get(url, {}, false, headers);
            return result.data ? result.data : null;
        } catch (error) {
            LogUtil.error("加载应用样式表异常");
            return null;
        }
    }

    /**
     * 加载应用无权限数据
     * 
     * @param dataUrl 无权限数据路径
     */
    public async loadNoAuthData(dataUrl: string) {
        let url = '';
        if (Environment.bDynamic) {
            url = `${Environment.remoteDynaPath}/${dataUrl}`;
        } else {
            const microAppService = AppServiceBase.getInstance().getMicroAppService();
            if (microAppService && microAppService.getIsMicroApp() && microAppService.getMicroAppFolder()) {
                url = `./${microAppService.getMicroAppFolder()}/assets/model/${dataUrl}`;
            } else {
                url = `./assets/model/${dataUrl}`;
            }
        }
        try {
            let headers: any = {};
            const tempViewParam = ViewTool.getDcSystemIdViewParam();
            if (tempViewParam.srfdcsystem) {
                headers.srfdcsystem = tempViewParam.srfdcsystem
            }
            const result: any = await Http.getInstance().get(url, {}, false, headers);
            return result.data ? result.data : null;
        } catch (error) {
            LogUtil.error("加载应用无权限数据异常");
            return null;
        }
    }

    /**
     * 挂载应用自定义样式表
     * 
     * @param cssContent 样式内容
     */
    public mountedAppUserStyle(cssContent: string) {
        let appStyleDom: any;
        for (let i = document.head.childNodes.length - 1; i >= 0; i--) {
            const children: any = document.head.childNodes[i]
            if (children.nodeName == "STYLE" && children.getAttribute('title') && children.getAttribute('title') == 'app-style-css') {
                appStyleDom = children;
            }
        }
        if (appStyleDom) {
            appStyleDom.innerText = cssContent;
        } else {
            const styleDom = document.createElement('style');
            styleDom.type = "text/css";
            styleDom.setAttribute('title', 'app-style-css');
            styleDom.innerText = cssContent;
            document.head.appendChild(styleDom);
        }
    }

}