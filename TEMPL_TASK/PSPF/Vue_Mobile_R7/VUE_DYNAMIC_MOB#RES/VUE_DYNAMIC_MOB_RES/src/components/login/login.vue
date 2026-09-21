<template>
  <component
    v-if="layoutComponent != null"
    :is="layoutComponent"
    :viewInstance="viewInstance"
    :modelService="modelService"
    :context="{}"
    :viewparams="{}"
  >
    <ion-page :className="{ 'app-login': true }">
      <div class="background"></div>
      <div class="header">
        <div class="logo">
          <img :src="path" alt="logo" />
        </div>
        <div class="text">{{ AppCaption }}</div>
      </div>
      <div class="content">
        <div class="login-form">
          <form>
            <div class="item">
              <div class="field-label">{{ $t('username') }}</div>
              <van-field v-model="form.loginname" placeholder="请输入用户名" />
            </div>
            <div class="item">
              <div class="field-label">{{ $t('password') }}</div>
              <van-field v-model="form.password" type="password" placeholder="请输入密码" />
            </div>
            <div class="item">
              <app-mob-button expand="block" @click="login('login')">{{ $t('submit') }}</app-mob-button>
            </div>
          </form>
        </div>
        <div class="login__tool">
          <van-checkbox v-model="form.rememberme" class="login__rememberme" shape="square">记住我</van-checkbox>
          <div class="find-password">找回密码</div>
        </div>
        <div class="footer">还没有账号？<span>立即注册</span></div>
      </div>
    </ion-page>
  </component>
</template>
<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { Environment } from '@/environments/environment';
import {  removeSessionStorage, AppModelService, AppServiceBase, GetModelService, ThirdPartyService, ViewTool, Http } from 'ibiz-core';
import { AppLayoutService,AppAuthService } from 'ibiz-vue';
import { setCookie } from 'qx-util';
import { IPSAppView } from '@ibiz/dynamic-model-api';

@Component({
  components: {},
  i18n: {
    messages: {
      'ZH-CN': {
        username: '用户名',
        password: '密码',
        submit: '提交',
        usernametipinfo: '用户名为空',
        passwordtipinfo: '密码为空',
        dingdingfailed: '钉钉认证失败，请联系管理员',
        badlogin: '登录异常',
        login: '登录',
        forgetPas: '忘记密码?',
        hadAccount: '已有账户？',
        loginNow: '立刻登录!',
        guestLogin: '以访客身份登录',
        reg: '注册',
        noAccount: '还没有账户？',
        regNow: '立刻注册!',
        regNotSupport: '注册暂未支持,请联系管理员',
        PasNotSupport: '暂未支持找回密码,请联系管理员',
      },
      'EN-US': {
        username: 'User name',
        password: 'Password',
        submit: 'Submit',
        usernametipinfo: 'User name is empty.',
        passwordtipinfo: 'Password id empty.',
        dingdingfailed: 'Dingding authentication failed, please contact the administrator',
        badlogin: 'Login exception',
        login: 'Login',
        forgetPas: 'Forgot password?',
        hadAccount: 'Already have an account?',
        loginNow: 'Sign in now!',
        guestLogin: 'Log in as a guest',
        reg: 'Registered',
        noAccount: 'Don’t have an account yet?',
        regNow: 'Sign up now!',
        regNotSupport: 'Registration is not yet supported, please contact the administrator',
        PasNotSupport: 'Password retrieval is not supported yet, please contact the administrator',
      },
    },
  },
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
   * 应用标题
   *
   * @type {*}
   * @memberof Login
   */
  public AppCaption: string = Environment.AppCaption;

  /**
   * 模型服务
   *
   * @type {AppModelService | undefined | null}
   * @memberof Login
   */
  public modelService: AppModelService | undefined | null = null;

  /**
   * 第三方服务
   *
   * @type {AppModelService | undefined | null}
   * @memberof Login
   */
  public thirdPartyService:ThirdPartyService = ThirdPartyService.getInstance();

  /**
   * 视图实例
   *
   * @type {any}
   * @memberof Login
   */
  public viewInstance: any = null;

  /**
   * 是否为登录
   *
   * @type {boolean}
   * @memberof Login
   */
  public isloginPage: boolean = true;

  public form = {

    loginname :'',

    password :'',

    rememberme:false
  }

  /**
   * 是否加载中
   *
   * @type {boolean}
   * @memberof Login
   */
  public isLoadding: boolean = false;

  /**
   * logo路径
   *
   * @type {string}
   * @memberof Login
   */
  public path :string = './assets/images/logo.png';


  /**
   * 初始化完成
   *
   * @memberof Login
   */
  public created() {
    this.initLoginView();
    if(this.thirdPartyService.isInit){
      this.doThirdLogin();
    }
  }

  /**
   * 初始化登录页
   *
   * @memberof Login
   */
  public async initLoginView() {
    const app = AppServiceBase.getInstance().getAppModelDataObject();
    if (app && app.getAllPSAppViews() && (app.getAllPSAppViews() as IPSAppView[]).length > 0) {
      const loginView = app.getAllPSAppViews()?.find((item: IPSAppView) => {
        if (item.isFill) {
          return item.viewType === 'APPLOGINVIEW';
        } else {
          return item.refM?.viewType === 'APPLOGINVIEW';
        }
      });
      if (loginView) {
        // 初始化模型服务/初始化视图模型
        this.modelService = await GetModelService();
        this.viewInstance = await this.modelService?.getPSAppView(loginView.modelFilePath as string);
        await this.viewInstance.fill(true);
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
  }

  /**
   * 密码
   *
   * @memberof Login
   */
  public activeChange() {
    this.isloginPage = !this.isloginPage;
  }

  /**
   * 登录
   *
   * @memberof Login
   */
  public login(tag: any) {
    let url = '';
    let token = localStorage.getItem('token');
    let user = localStorage.getItem('user');
    if (token) {
      localStorage.removeItem('token');
    }
    if (user) {
      localStorage.removeItem('user');
    }
    this.clearAppData();
    if (tag === 'login') {
      if (Object.is(this.form.loginname, '')) {
        this.$Notice.error(`${this.$t('usernametipinfo')}`);
        return;
      }
      if (Object.is(this.form.password, '')) {
        this.$Notice.error(`${this.$t('passwordtipinfo')}`);
        return;
      }
      url = Environment.RemoteLogin;
    } else {
      url = Environment.VisitorsUrl;
    }
    const post: Promise<any> = AppAuthService.getInstance().login(this.form);
    this.isLoadding = true;
    post.then((response: any) => {
        this.isLoadding = false;
        if (response && response.status === 200) {
          const data = response.data;
          if (data && data.token) {
            setCookie('ibzuaa-token', data.token, 7);
          }
          if (data && data.user) {
            setCookie('ibzuaa-user', JSON.stringify(data.user), 7);
          }
          // 设置cookie,保存账号密码7天
          setCookie('loginname', this.form.loginname, 7);
          localStorage.setItem('token', data.token);
          localStorage.setItem('user', JSON.stringify(data.user));
          const url: any = this.$route.query.redirect ? this.$route.query.redirect : '*';
          this.$router.replace({ path: url });
        }
      })
      .catch((error: any) => {
        this.isLoadding = false;
        this.$Notice.error(error ? error.data.message : `${this.$t('badlogin')}`);
      });
  }

  /**
   * 清除数据
   *
   * @memberof register
   */
  private clearAppData() {
    // 清除user、token
    let leftTime = new Date();
    leftTime.setTime(leftTime.getSeconds() - 1);
    document.cookie = 'ibzuaa-token=;expires=' + leftTime.toUTCString();
    document.cookie = 'ibzuaa-user=;expires=' + leftTime.toUTCString();
    // 清除应用级数据
    localStorage.removeItem('localdata');
    this.$store.commit('addAppData', null);
    this.$store.dispatch('authresource/commitAuthData', {});
    // 清除租户相关信息
    removeSessionStorage('activeOrgData');
    removeSessionStorage('srfdynaorgid');
    removeSessionStorage('dcsystem');
    removeSessionStorage('orgsData');
  }

  /**
   * 获取需要的location部分
   *
   * @memberof Login
   */
  private getNeedLocation() {
      // 截取地址，拼接需要部分组成新地址
      const scheme = window.location.protocol;
      const host = window.location.host;
      let baseUrl: any = scheme + '//' + host;
      const port = window.location.port;
      if (port) {
          if (port == '80' || port == '443') {
              baseUrl += '/';
          }
      } else {
          baseUrl += '/';
      }
      return baseUrl + '/' + Environment.AppName.toLowerCase();
  }

  /**
   * 第三方服务登录
   *
   * @memberof Login
   */
  private doThirdLogin(){
    const third :any= sessionStorage.getItem('third');
    if(!third){
      this.thirdPartyService.login(Environment).then((result:any)=>{
      if (result?.state && Object.is(result?.state, 'SUCCESS')) {
          if(this.thirdPartyService.isWeChat()){
            this.doWXLogin(result);
          }else{
            this.doDingLogin(result);
          }
        } else {
           alert('登录失败'+JSON.stringify(result));
        }
      });
      return;
    }
  }

  /**
   * 钉钉免登
   *
   * @memberof Login
   */
  private doDingLogin(result:any){
    // todo
  }

  /**
   * 企业微信免登
   *
   * @memberof Login
   */
  private doWXLogin(result:any){
        const data = result.data;
        // 截取地址，拼接需要部分组成新地址
        const baseUrl = this.getNeedLocation();
        // 1.钉钉开放平台提供的appId
        const appId = data.appid;
        const agentId = data.agentid;
        //  系统ID
        let srfdcsystem: string = '';
        const tempViewParam = ViewTool.getDcSystemIdViewParam();
        if (tempViewParam && tempViewParam.srfdcsystem) {
            srfdcsystem = tempViewParam.srfdcsystem;
        }
        // 2.钉钉扫码后回调地址,需要UrlEncode转码
        const host = window.location.host;
        const redirect_uri = baseUrl + '/assets/third/wxWorkRedirect.html?id=' + data.appid + `&srfdcsystem=${srfdcsystem}`;
        const redirect_uri_encode = encodeURIComponent(redirect_uri);
        // 3.钉钉扫码url
        const url =`https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appId}&redirect_uri=${redirect_uri_encode}&response_type=code&scope=snsapi_base&state=STATE&agentid=${agentId}#wechat_redirect`;
        sessionStorage.setItem('third','true');
        window.location.href = url;
  }

}
</script>

<style lang='less'>
@import './login.less';
</style>