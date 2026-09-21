<template>
  <div class="third-party-login">
    <span class="title">其他登录方式</span>
    <div class="third-party-login-imgrwap">
      <img @click="thirdLogin('钉钉')" src="assets/aliiconfont/dingding.svg" />
      <img @click="thirdLogin('微信')" src="assets/aliiconfont/weixin.svg" />
    </div>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from "vue-property-decorator";
import { ThirdPartyService } from "ibiz-core";

@Component({})
export default class thirdPartyLogin extends Vue {
  /**
   * 第三方服务
   *
   * @type {string}
   * @memberof thirdPartyLogin
   */
  public thirdPartyService: ThirdPartyService = ThirdPartyService.getInstance();

  /**
   * 第三方登录
   *
   * @type {string}
   * @memberof thirdPartyLogin
   */
  public async thirdLogin(name: string) {
    const info: string = window.navigator.userAgent.toUpperCase();
    if (info.indexOf("DINGTALK") == -1 && info.indexOf("WXWORK") == -1) {
      this.$Notice.error(`不在${name}容器`);
    }

    let loginStatus: any = await this.thirdPartyService.login();
    if (!loginStatus.issuccess) {
      this.$Notice.error(
        loginStatus.message
          ? loginStatus.message
          : `${this.$t("dingdingfailed")}`
      );
      setTimeout(() => {
        this.thirdPartyService.close();
      }, 1500);
    } else if (loginStatus.issuccess) {
      const url: any = this.$route.query.redirect
        ? this.$route.query.redirect
        : "*";
      this.$router.replace({ path: url });
    }
  }
}
</script>

<style lang="less" scoped>
@import "./third-party-login.less";
</style>;
