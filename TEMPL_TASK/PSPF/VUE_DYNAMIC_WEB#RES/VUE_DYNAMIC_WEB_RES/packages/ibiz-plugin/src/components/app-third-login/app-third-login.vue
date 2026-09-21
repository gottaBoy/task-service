<template>
  <div class="app-third-login">
    <span class="title">{{ $t("components.login.other") }}</span>
    <div class="app-third-login-imgrwap">
      <div class="sign-btn" @click="handleThirdLogin('DINGDING')">
        <img class="third-svg-container" src="@/assets/img/dingding.svg" />
      </div>
      <div class="sign-btn" @click="handleThirdLogin('WXWORK')">
        <img class="third-svg-container" src="@/assets/img/qiyeweixin.svg" />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { AppThirdService } from "ibiz-vue";
import { AppServiceBase } from "ibiz-core";
@Component({})
export default class AppThirdLogin extends Vue {
  /**
   * 第三方登录服务
   *
   * @type {AppThirdService}
   * @memberof AppThirdLogin
   */
  public appThirdService: AppThirdService = AppThirdService.getInstance();

  /**
   * 应用环境
   *
   * @type {*}
   * @memberof AppThirdLogin
   */
  public Environment: any = AppServiceBase.getInstance().getAppEnvironment();

  /**
   * 处理第三方登录
   *
   * @param type 登录类型
   * @memberof AppThirdLogin
   */
  handleThirdLogin(type: string) {
    switch (type) {
      case "DINGDING":
        this.dingTalkHandleClick();
        break;
      case "WXWORK":
        this.wxWorkHandleClick();
        break;
      default:
        console.warn(`暂不支持${type}登录`);
        break;
    }
  }

  /**
   * 钉钉登录
   *
   * @memberof AppThirdLogin
   */
  async dingTalkHandleClick() {
    let result: any = await this.appThirdService.dingtalkLogin(
      this.Environment
    );
    if (result?.state && Object.is(result?.state, "SUCCESS")) {
      const data = result.data;
      // 截取地址，拼接需要部分组成新地址
      const baseUrl = this.getNeedLocation();
      // 1.钉钉开放平台提供的appId
      const appId = data.appid;
      // 2.钉钉扫码后回调地址,需要UrlEncode转码
      const redirect_uri =
        baseUrl + "assets/third/dingdingRedirect.html?id=" + data.appid;
      const redirect_uri_encode = encodeURIComponent(redirect_uri);
      // 3.钉钉扫码url
      const url =
        "https://oapi.dingtalk.com/connect/qrconnect?response_type=code" +
        "&appid=" +
        appId +
        "&redirect_uri=" +
        redirect_uri_encode +
        "&scope=snsapi_login" +
        "&state=STATE";

      // 4.跳转钉钉扫码
      window.location.href = url;
    } else {
      this.$throw(result?.message, "dingtalkHandleClick");
    }
  }

  /**
   * 微信登录
   *
   * @memberof AppThirdLogin
   */
  async wxWorkHandleClick() {
    let result: any = await this.appThirdService.wxWorkLogin(this.Environment);
    if (result?.state && Object.is(result?.state, "SUCCESS")) {
      const data = result.data;
      // 截取地址，拼接需要部分组成新地址
      const baseUrl = this.getNeedLocation();
      // 1.微信平台提供的appId
      const appId = data.corp_id;
      const agentId = data.agentid;
      // 2.微信扫码后回调地址,需要UrlEncode转码
      const redirect_uri =
        baseUrl + "assets/third/wxWorkRedirect.html?id=" + data.appid;
      const redirect_uri_encode = encodeURIComponent(redirect_uri);
      // 3.微信扫码url
      const url =
        "https://open.work.weixin.qq.com/wwopen/sso/qrConnect?state=STATE" +
        "&appid=" +
        appId +
        "&agentid=" +
        agentId +
        "&redirect_uri=" +
        redirect_uri_encode;
      // 4.跳转微信扫码
      window.location.href = url;
    } else {
      this.$throw(result?.message, "wxWorkHandleClick");
    }
  }

  /**
   * 截取地址
   *
   * @memberof AppThirdLogin
   */
  private getNeedLocation() {
    // 截取地址，拼接需要部分组成新地址
    const scheme = window.location.protocol;
    const host = window.location.host;
    let baseUrl: any = scheme + "//" + host;
    const port = window.location.port;
    if (port) {
      if (port == "80" || port == "443") {
        baseUrl += "/";
      } else {
        baseUrl += ":" + port + "/";
      }
    } else {
      baseUrl += "/";
    }
    return baseUrl;
  }
}
</script>

<style lang="less">
@import "./app-third-login.less";
</style>