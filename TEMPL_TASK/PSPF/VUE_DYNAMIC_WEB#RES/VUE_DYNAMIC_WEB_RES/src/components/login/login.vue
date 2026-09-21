<template>
    <component v-if="layoutComponent != null" :is="layoutComponent" :viewInstance="viewInstance"
        :modelService="modelService" :model="model" :context="{}" :viewparams="{}">
        <div class="login">
            <img src="@/assets/img/background.png" v-if="!isEmbedThridPlatForm && !isThridLink" />
            <div class="login-con" v-if="!isEmbedThridPlatForm && !isThridLink">
                <card :bordered="false">
                    <p slot="title" style="text-align: center">&nbsp;&nbsp;{{ appTitle }}</p>
                    <div class="form-con">
                        <i-form ref="loginForm" :rules="rules" :model="form">
                            <form-item prop="loginname">
                                <i-input size="large" prefix="ios-contact" v-model.trim="form.loginname"
                                    :placeholder="$t('components.login.placeholder1')"
                                    @keyup.enter.native="handleSubmit">
                                </i-input>
                            </form-item>
                            <form-item prop="password">
                                <i-input size="large" prefix="ios-key" v-model.trim="form.password" type="password"
                                    :placeholder="$t('components.login.placeholder2')"
                                    @keyup.enter.native="handleSubmit">
                                </i-input>
                            </form-item>
                            <form-item prop="rememberme">
                                <checkbox v-model.trim="form.rememberme">{{ $t('components.login.rememberme') }}
                                </checkbox>
                            </form-item>
                            <form-item>
                                <i-button @click="handleSubmit" type="primary" class="login_btn">{{
                                        $t('components.login.name')
                                }}
                                </i-button>
                                <i-button @click="goReset" type="success" class="login_reset">{{
                                        $t('components.login.reset')
                                }}
                                </i-button>
                            </form-item>

                            <form-item>
                                <div style="text-align: center">
                                    <span class="form_tipinfo">{{ $t('components.login.other') }}</span>
                                </div>
                                <div style="text-align: center">
                                    <div class="sign-btn" @click="handleThridLogin('DINGDING')">
                                        <img src="@/assets/img/dingding.svg" class="third-svg-container"
                                            draggable="false" />
                                    </div>
                                    <div class="sign-btn" @click="handleThridLogin('WXWORK')">
                                        <img src="@/assets/img/qiyeweixin.svg" class="third-svg-container"
                                            draggable="false" />
                                    </div>
                                </div>
                            </form-item>
                        </i-form>
                        <p class="login-tip">
                            {{ loginTip }}
                        </p>
                    </div>
                </card>
                <div class="log_footer">
                    <div class="copyright">
                        <a href="https://www.ibizlab.cn/" target="_blank">{{ appTitle }} is based on ibizlab .</a>
                    </div>
                </div>
            </div>
            <div class="login-loadding-container" v-if="isEmbedThridPlatForm || isThridLink">
                <div class="content-loadding">
                    <span>第三方登录跳转中</span>
                    <div class="loading">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>
            </div>
        </div>
    </component>
</template>

<script lang="ts">
import { Vue, Component, Watch } from 'vue-property-decorator';
import { clearCookie, setCookie } from 'qx-util';
import { Environment } from '@/environments/environment';
import {
    removeSessionStorage,
    Util,
    LogUtil,
    ViewTool,
    AppModelService,
    AppServiceBase,
    IParams,
    Http,
} from 'ibiz-core';
import { AppAuthService, AppLayoutService, AppThirdService } from 'ibiz-vue';
import { AppNoAuthDataService } from '@/utils/service/app-no-auth-data-service';

@Component({
    components: {},
})
export default class Login extends Vue {
    /**
     * 布局组件
     *
     * @type {*}
     * @memberof Login
     */
    public layoutComponent: any = null;

    /**
     * 模型服务
     *
     * @type {AppModelService | undefined | null}
     * @memberof Login
     */
    public modelService: AppModelService | undefined | null = null;

    /**
     * 视图实例
     *
     * @type {any}
     * @memberof Login
     */
    public viewInstance: any = null;

    /**
     * 表单对象
     *
     * @type {*}
     * @memberof Login
     */
    public form: any = { loginname: '', password: '', rememberme: false };

    /**
     * 第三方登录服务
     *
     * @type {AppThirdService}
     * @memberof Login
     */
    public appThirdService: AppThirdService = AppThirdService.getInstance();

    /**
     *　登录提示语
     *
     * @type {string}
     * @memberof Login
     */
    public loginTip: string = '';

    /**
     * 运行平台
     *
     * @type {*}
     * @memberof Login
     */
    public platform: any;

    /**
     * 是否嵌入第三方平台
     *
     * @type {boolean}
     * @memberof Login
     */
    public isEmbedThridPlatForm: boolean = false;

    /**
     * 
     * 是否为第三方跳转
     *
     * @type {boolean}
     * @memberof Login
     */
    public isThridLink: boolean = false;

    /**
     * 
     * 当前路由参数
     *
     * @type {IParams}
     * @memberof Login
     */
    public curRouteParams: IParams = {};

    /**
     *　按钮可点击
     *
     * @type {boolean}
     * @memberof Login
     */
    public canClick: boolean = true;

    /**
     * 应用名称
     *
     * @type {string}
     * @memberof Login
     */
    public appTitle: string = Environment.AppTitle;

    /**
     * 值规则
     *
     * @type {*}
     * @memberof Login
     */
    public rules = {};

    /**
     * 模型
     * @description 自定义登录视图时使用
     * @type {*}
     * @memberof Login
     */
    public model: any = {};

    /**
     * 生命周期
     *
     * @memberof Login
     */
    public created() {
        this.curRouteParams = Util.getRouteParams(window.location.href);
        this.unifiedLogin();
        this.setRules();
        this.initLoginView().then((result: boolean) => {
            if (!result) {
                this.platform = window.navigator.userAgent.toUpperCase();
                if (this.platform.indexOf('DINGTALK') !== -1) {
                    this.isEmbedThridPlatForm = true;
                    this.DingDingLogin();
                } else if (this.platform.indexOf('WXWORK') !== -1) {
                    this.isEmbedThridPlatForm = true;
                    this.WXWorkLogin();
                }
            }
        });
    }

    /**
     * 统一登录
     * 
     * @memberof Login
     */
    public async unifiedLogin() {
        if (!this.curRouteParams || Object.keys(this.curRouteParams).length === 0) {
            return null;
        }
        // 不存在code且存在redirect_uri
        if (this.curRouteParams.redirect_uri) {
            const token = localStorage.getItem('ibzuaa-token');
            // 已经登录
            if (token) {
                this.isThridLink = true;
                //  系统ID
                let srfdcsystem: string = '';
                const tempViewParam = ViewTool.getDcSystemIdViewParam();
                if (tempViewParam && tempViewParam.srfdcsystem) {
                    srfdcsystem = tempViewParam.srfdcsystem;
                }
                try {
                    const response = await Http.getInstance().get('/uaa/oauth/code', { 'client_id': this.curRouteParams.client_id }, false, {
                        'Authorization': `Bearer ${token}`,
                        'srfsystemid': srfdcsystem
                    });
                    const { status, data } = response;
                    if (status == 200) {
                        window.location.href = `${this.curRouteParams.redirect_uri}?code=${data}&state=${this.curRouteParams.state}`;
                    } else {
                        this.isThridLink = false;
                    }
                } catch (error: any) {
                    this.isThridLink = false;
                }
            } else {
                this.isThridLink = false;
            }
        } else {
            this.isThridLink = false;
        }
    }

    /**
     * 初始化登录页
     *
     * @memberof Login
     */
    public async initLoginView() {
        const result = await AppNoAuthDataService.getInstance().mountedAppBasicData();
        if (result) {
            const noAuthData = AppServiceBase.getInstance().getAppNoAuthData();
            if (noAuthData && noAuthData.cache && noAuthData.cache.getPSAppViews && noAuthData.cache.getPSAppViews.length > 0) {
                const loginView = noAuthData.cache.getPSAppViews?.find((item: IParams) => {
                    return item.viewType === 'APPLOGINVIEW';
                });
                if (loginView) {
                    this.modelService = new AppModelService();
                    this.viewInstance = await this.modelService?.getPSAppView(loginView);
                    this.model.srfCaption = this.$tl(
                        this.viewInstance.getCapPSLanguageRes?.()?.lanResTag,
                        this.viewInstance.caption,
                    );
                    // 计算视图布局面板组件
                    this.layoutComponent = AppLayoutService.getLayoutComponent('APPLOGIN-DEFAULT');
                    return true;
                } else {
                    // 计算视图布局面板组件
                    this.layoutComponent = AppLayoutService.getLayoutComponent('APPLOGIN-DEFAULT');
                    return false;
                }
            } else {
                // 计算视图布局面板组件
                this.layoutComponent = AppLayoutService.getLayoutComponent('APPLOGIN-DEFAULT');
                return false;
            }
        } else {
            // 计算视图布局面板组件
            this.layoutComponent = AppLayoutService.getLayoutComponent('APPLOGIN-DEFAULT');
            return false;
        }
    }

    /**
     * 生命周期 -- mounted
     *
     * @memberof Login
     */
    public mounted() {
        setTimeout(() => {
            const el = document.getElementById('app-loading-x');
            if (el) {
                el.style.display = 'none';
            }
        }, 300);
    }

    /**
     * 监听语言变化
     *
     * @memberof Login
     */
    @Watch('$i18n.locale')
    onLocaleChange(newval: any, val: any) {
        this.setRules();
    }

    /**
     * 设置值规则
     *
     * @memberof Login
     */
    public setRules() {
        this.rules = {
            loginname: [{ required: true, message: this.$t('components.login.loginname.message'), trigger: 'change' }],
            password: [{ required: true, message: this.$t('components.login.password.message'), trigger: 'change' }],
        };
    }

    /**
     * 重置页面
     *
     * @memberof Login
     */
    public goReset(): void {
        const _this = this;
        _this.form = { loginname: '', password: '' };
    }

    /**
     * 登陆处理
     *
     * @memberof Login
     */
    public handleSubmit(): void {
        this.clearAppData();
        const form: any = this.$refs.loginForm;
        let validatestate: boolean = true;
        form.validate((valid: boolean) => {
            validatestate = valid ? true : false;
        });
        if (!validatestate) {
            return;
        }
        const loginname: any = this.form.loginname;
        const post: Promise<any> = AppAuthService.getInstance().login(this.form);
        post.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                const expirein = Util.formatExpirein(data.expirein);
                if (data && data.token) {
                    setCookie('ibzuaa-token', data.token, expirein, true);
                    localStorage.setItem('ibzuaa-token', data.token);
                }
                if (data && data.user) {
                    setCookie('ibzuaa-user', JSON.stringify(data.user), expirein, true);
                }
                // 设置cookie,保存账号密码7天
                setCookie('loginname', loginname, expirein, true);
                if (data && data.token && this.curRouteParams.redirect_uri) {
                    Http.getInstance().get('/uaa/oauth/code', { 'client_id': this.curRouteParams.client_id }, false, {
                        'Authorization': `Bearer ${data.token}`,
                    }).then((response: any) => {
                        const { status, data } = response;
                        if (status == 200) {
                            window.location.href = `${this.curRouteParams.redirect_uri}?code=${data}&state=${this.curRouteParams.state}`;
                        } else {
                            this.$throw(this.$t('components.login.loginfailed') as string, 'loginInit');
                        }
                    })
                } else {
                    // 跳转首页
                    const url: any = this.$route.query.redirect ? this.$route.query.redirect : '*';
                    this.$router.push({ path: url });
                }
            } else {
                const data = response.data;
                if (data && data.message) {
                    this.loginTip = data.message;
                    this.$throw((this.$t('components.login.loginfailed') as string) + ' ' + data.message, 'handleSubmit');
                } else {
                    this.$throw(this.$t('components.login.loginfailed') as string, 'handleSubmit');
                }
            }
        }).catch((error: any) => {
            // 登录提示
            const data = error.data;
            if (data && data.message) {
                this.loginTip = data.message;
                this.$throw((this.$t('components.login.loginfailed') as string) + ' ' + data.message, 'handleSubmit');
            } else {
                this.$throw(this.$t('components.login.loginfailed') as string, 'handleSubmit');
            }
        });
    }

    /**
     * 清除应用数据
     *
     * @private
     * @memberof Login
     */
    private clearAppData() {
        // 清除user、token
        clearCookie('ibzuaa-token', true);
        clearCookie('ibzuaa-expired', true);
        clearCookie('ibzuaa-user', true);
        // 清除应用级数据
        localStorage.removeItem('localdata');
        this.$store.commit('addAppData', {});
        this.$store.dispatch('authresource/commitAuthData', {});
        // 清除租户相关信息
        removeSessionStorage('activeOrgData');
        removeSessionStorage('srfdynaorgid');
        removeSessionStorage('dcsystem');
        removeSessionStorage('orgsData');
    }

    /**
     * 第三方登录(网页扫码方式)
     *
     * @memberof Login
     */
    public handleThridLogin(type: string) {
        if (!type) return;
        switch (type) {
            case 'DINGDING':
                this.dingtalkHandleClick();
                break;
            case 'WXWORK':
                this.wxWorkHandleClick();
                break;
            default:
                LogUtil.log(`暂不支持${type}登录`);
                break;
        }
    }

    /**
     * 钉钉授权登录
     *
     * @memberof Login
     */
    public async dingtalkHandleClick() {
        let result: any = await this.appThirdService.dingtalkLogin(Environment);
        if (result?.state && Object.is(result?.state, 'SUCCESS')) {
            const data = result.data;
            // 截取地址，拼接需要部分组成新地址
            const baseUrl = this.getNeedLocation();
            // 1.钉钉开放平台提供的appId
            const appId = data.appid;
            //  系统ID
            let srfdcsystem: string = '';
            const tempViewParam = ViewTool.getDcSystemIdViewParam();
            if (tempViewParam && tempViewParam.srfdcsystem) {
                srfdcsystem = tempViewParam.srfdcsystem;
            }
            // 2.钉钉扫码后回调地址,需要UrlEncode转码
            let redirect_uri =
                baseUrl +
                'assets/third/dingdingRedirect.html?id=' +
                data.appid +
                `&srfdcsystem=${srfdcsystem}` +
                `&baseUrl=${Environment.BaseUrl}`;
            if (this.curRouteParams.redirect_uri) {
                redirect_uri += `&redirect_uri=${this.curRouteParams.redirect_uri}`;
            }
            if (this.curRouteParams.client_id) {
                redirect_uri += `&client_id=${this.curRouteParams.client_id}`;
            } else {
                console.error('未传入客户端ID');
                this.$throw(this.$t('components.login.loginfailed') as string, 'dingtalkHandleClick');
            }
            if (this.curRouteParams.state) {
                redirect_uri += `&redirect_state=${this.curRouteParams.state}`;
            } else {
                console.error('未传入state');
                this.$throw(this.$t('components.login.loginfailed') as string, 'dingtalkHandleClick');
            }
            const redirect_uri_encode = encodeURIComponent(redirect_uri);
            // 3.钉钉扫码url
            const url =
                'https://oapi.dingtalk.com/connect/qrconnect?response_type=code' +
                '&appid=' +
                appId +
                '&redirect_uri=' +
                redirect_uri_encode +
                '&scope=snsapi_login' +
                '&state=STATE';

            // 4.跳转钉钉扫码
            window.location.href = url;
        } else {
            this.$throw(result?.message, 'dingtalkHandleClick');
        }
    }

    /**
     * 企业微信授权登录
     *
     * @memberof Login
     */
    public async wxWorkHandleClick() {
        let result: any = await this.appThirdService.wxWorkLogin(Environment);
        if (result?.state && Object.is(result?.state, 'SUCCESS')) {
            const data = result.data;
            // 截取地址，拼接需要部分组成新地址
            const baseUrl = this.getNeedLocation();
            const appId = data.appid;
            const agentId = data.agentid;
            //  系统ID
            let srfdcsystem: string = '';
            const tempViewParam = ViewTool.getDcSystemIdViewParam();
            if (tempViewParam && tempViewParam.srfdcsystem) {
                srfdcsystem = tempViewParam.srfdcsystem;
            }
            // 2.钉钉扫码后回调地址,需要UrlEncode转码
            let redirect_uri =
                baseUrl +
                'assets/third/wxWorkRedirect.html?id=' +
                agentId +
                `&srfdcsystem=${srfdcsystem}` +
                `&baseUrl=${Environment.BaseUrl}`;
            if (this.curRouteParams.redirect_uri) {
                redirect_uri += `&redirect_uri=${this.curRouteParams.redirect_uri}`;
            }
            if (this.curRouteParams.client_id) {
                redirect_uri += `&client_id=${this.curRouteParams.client_id}`;
            } else {
                console.error('未传入客户端ID');
                this.$throw(this.$t('components.login.loginfailed') as string, 'wxWorkHandleClick');
            }
            if (this.curRouteParams.state) {
                redirect_uri += `&redirect_state=${this.curRouteParams.state}`;
            } else {
                console.error('未传入state');
                this.$throw(this.$t('components.login.loginfailed') as string, 'wxWorkHandleClick');
            }
            const redirect_uri_encode = encodeURIComponent(redirect_uri);
            // 3.钉钉扫码url
            const url =
                'https://open.work.weixin.qq.com/wwopen/sso/qrConnect?state=STATE' +
                '&appid=' +
                appId +
                '&agentid=' +
                agentId +
                '&redirect_uri=' +
                redirect_uri_encode;
            // 4.跳转钉钉扫码
            window.location.href = url;
        } else {
            this.$throw(result?.message, 'wxWorkHandleClick');
        }
    }

    /**
     * 钉钉免登
     *
     * @memberof Login
     */
    public async DingDingLogin() {
        let result: any = await this.appThirdService.embedDingTalkLogin(Environment);
        if (result && result.state && Object.is(result.state, 'SUCCESS') && result.data) {
            try {
                const expirein = Util.formatExpirein(result.data.expirein);
                if (result.data.token) {
                    setCookie('ibzuaa-token', result.data.token, expirein, true);
                }
                if (result.data.user) {
                    setCookie('ibzuaa-user', JSON.stringify(result.data.user), expirein, true);
                    setCookie('loginname', result.data.user.loginname, expirein, true);
                }
                this.$router.push('/');
            } catch (error) {
                alert(JSON.stringify(error));
            }
        } else {
            this.$throw(result?.message, 'DingDingLogin');
        }
    }

    /**
     * 企业微信免登
     *
     * @memberof Login
     */
    public async WXWorkLogin() {
        let result: any = await this.appThirdService.wxWorkLogin(Environment);
        if (result?.state && Object.is(result?.state, 'SUCCESS')) {
            const data = result.data;
            // 截取地址，拼接需要部分组成新地址
            const baseUrl = this.getNeedLocation();
            const appId = data.appid;
            const agentId = data.agentid;
            //  系统ID
            let srfdcsystem: string = '';
            const tempViewParam = ViewTool.getDcSystemIdViewParam();
            if (tempViewParam && tempViewParam.srfdcsystem) {
                srfdcsystem = tempViewParam.srfdcsystem;
            }
            // 2.认证成功后回调地址,需要UrlEncode转码
            const redirect_uri =
                baseUrl +
                'assets/third/wxWorkRedirect.html?id=' +
                agentId +
                `&srfdcsystem=${srfdcsystem}` +
                `&baseUrl=${Environment.BaseUrl}`;
            const redirect_uri_encode = encodeURIComponent(redirect_uri);
            // 3.微信认证url
            const url =
                'https://open.weixin.qq.com/connect/oauth2/authorize?response_type=code&scope=snsapi_base&#wechat_redirect' +
                '&appid=' +
                appId +
                '&redirect_uri=' +
                redirect_uri_encode +
                '&scope=snsapi_base' +
                '&state=STATE';
            // 4.跳转到微信认证地址
            window.location.href = url;
        } else {
            this.$throw(result?.message, 'WXWorkLogin');
        }
    }

    /**
     * 获取需要的location部分
     *
     * @memberof Login
     */
    private getNeedLocation() {
        // 截取地址，拼接需要部分组成新地址
        const scheme = window.location.protocol;
        const host = window.location.hostname;
        let baseUrl: any = scheme + '//' + host;
        const port = window.location.port;
        if (port && port !== '80' && port !== '443') {
            baseUrl += ':' + port;
        }
        baseUrl += window.location.pathname;
        return baseUrl;
    }

}
</script>

<style lang='less'>
@import './login.less';
</style>