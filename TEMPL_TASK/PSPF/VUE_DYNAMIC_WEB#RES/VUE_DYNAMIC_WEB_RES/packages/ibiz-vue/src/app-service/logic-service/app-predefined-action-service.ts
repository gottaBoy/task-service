import { Http, IParams, Util } from "ibiz-core";
import { setCookie } from "qx-util";

/**
 * 全局界面行为服务
 * 
 * @export
 * @class AppPredefinedService
 */
export class AppPredefinedService {

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AppPredefinedService}
     * @memberof AppPredefinedService
     */
    private static AppPredefinedService: AppPredefinedService;

    /**
     * 获取 AppPredefinedService 单例对象
     *
     * @static
     * @returns {AppPredefinedService}
     * @memberof AppPredefinedService
     */
    public static getInstance(): AppPredefinedService {
        if (!AppPredefinedService.AppPredefinedService) {
            AppPredefinedService.AppPredefinedService = new AppPredefinedService();
        }
        return this.AppPredefinedService;
    }

    /**
     * 登录
     *
     * @param {*} actionContext
     * @param {IParams} data
     * @memberof AppPredefinedService
     */
    public login(actionContext: any, data: IParams) {
        if (!data || !data['auth_userid']) {
            actionContext.$throw(actionContext.$t('components.login.loginname.message') as string, 'login');
            return;
        }
        if (!data || !data['auth_password']) {
            actionContext.$throw(actionContext.$t('components.login.password.message') as string, 'login');
            return;
        }
        const loginname = data['auth_userid'];
        const requestData = {
            loginname,
            password: data['auth_password']
        }
        Http.getInstance().post('/v7/login', requestData, true).then((response: any) => {
            const data = response.data;
            if (response && response.status === 200) {
                const expirein = Util.formatExpirein(data.expirein);
                if (data && data.token) {
                    setCookie('ibzuaa-token', data.token, expirein, true);
                }
                if (data && data.user) {
                    setCookie('ibzuaa-user', JSON.stringify(data.user), expirein, true);
                }
                // 设置cookie,保存账号密码7天
                setCookie('loginname', loginname, expirein, true);
                // 跳转首页
                const url: any = actionContext.$route.query.redirect ? actionContext.$route.query.redirect : '*';
                actionContext.$router.push({ path: url });
            } else {
                actionContext.$throw(data.message, 'login');
            }

        }).catch((error: any) => {
            const data = error.data;
            if (data && data.message) {
                actionContext.$throw(data.message, 'login');
            }else{
                actionContext.$throw(actionContext.$t('components.login.loginfailed') as string, 'login');
            }
        })
    }

    /**
     * 重置
     *
     * @param {*} actionContext
     * @param {IParams} data
     * @memberof AppPredefinedService
     */
    public reset(actionContext: any, data: IParams){
        actionContext.layoutData['auth_userid'] = '';
        actionContext.layoutData['auth_password'] = '';
        actionContext.$forceUpdate();
    }

}