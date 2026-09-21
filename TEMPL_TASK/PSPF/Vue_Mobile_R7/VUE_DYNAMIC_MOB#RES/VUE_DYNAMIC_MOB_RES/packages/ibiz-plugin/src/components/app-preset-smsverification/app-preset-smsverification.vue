<template>
  <div class="app-preset-smsverification">
    <div class="content">
      <ion-input size="default" type="text" placeholder="请输入手机号码" @ionBlur="veriPhoneNumber"></ion-input>
      <app-mob-button :disabled="disabled" size="small" type="primary" @ionBlur="getVeriCode()">
        {{ disabled ? `${countDown}s 后获取验证码` : `获取验证码` }}
      </app-mob-button>
    </div>
    <div class="code">
      <ion-input
        size="default"
        type="text"
        :value="currentValue"
        @ionChange="codeChange"
        placeholder="请输入验证码"
      ></ion-input>
    </div>
  </div>
</template>

<script lang='ts'>
import { Vue, Component, Prop, Model } from 'vue-property-decorator';
import { Http } from 'ibiz-core';

@Component({})
export default class AppPresetSmsVerification extends Vue {
  /**
   *名称
   *
   * @type {string}
   * @memberof AppPresetSmsVerification
   */
  @Prop() public name!: string;

  /**
   *验证码值
   *
   * @type {string}
   * @memberof AppPresetSmsVerification
   */
  @Prop() public value!: string;

  /**
   *验证码当前值
   *
   * @type {string}
   * @memberof AppPresetSmsVerification
   */
  get currentValue(): string {
    return this.value;
  }

  /**
   * 手机号
   *
   * @type {string}
   * @memberof AppPresetSmsVerification
   */
  public phoneNumber: string = '';

  /**
   * 倒计时
   *
   * @type {number}
   * @memberof AppPresetSmsVerification
   */
  public countDown: number = 60;

  /**
   * 错误提示
   * @type {boolean}
   * @memberof AppPresetSmsVerification
   */
  public phoneError = false;

  /**
   * 是否禁用获取验证码按钮
   *
   * @type {boolean}
   * @memberof AppPresetSmsVerification
   */
  public disabled: boolean = false;

  /**
   * @description 网络请求接口对象
   * @type {IHttp}
   * @memberof AppPresetSmsVerification
   */
  public http: any = Http.getInstance();

  /**
   * 定时器
   *
   * @type {*}
   * @memberof AppPresetSmsVerification
   */
  public timer: any;

  /**
   * 组件创建时触发
   *
   * @type {*}
   * @memberof AppPresetSmsVerification
   */
  public created() {
    this.$emit("valueChange", { name: this.name, value: '' });
  }

  /**
   * @description 设置倒计时
   * @memberof AppPresetSmsVerification
   */
  public setCountDown() {
    if (this.countDown > 0) {
      this.countDown--;
    } else {
      this.countDown = 60;
      this.disabled = false;
      clearInterval(this.timer);
    }
    this.$forceUpdate();
  }

  /**
   * @description 验证码输入变化
   * @memberof AppPresetSmsVerification
   */
  public codeChange(event: any) {
    const value = event.detail.value;
    this.$emit('valueChange', { name: this.name, value });
  }

  /**
   * @description 校验手机号
   * @memberof AppPresetSmsVerification
   */
  public veriPhoneNumber(): boolean {
    this.phoneError = !/^1[3-9]\d{9}$/.test(this.phoneNumber);
    if (this.phoneError) {
      this.$emit('error', '手机号输入错误');
    }
    return this.phoneError;
  }

  /**
   * @description 获取验证码
   * @memberof AppPresetSmsVerification
   */
  public getVeriCode() {
    if (this.phoneError) return;
    // this.http.post(``, {}).then((response: any) => {
    //   if (response.status == 200) {
    //     this.disabled = true;
    //     this.timer = setInterval(() => {
    //       this.setCountDown();
    //     }, 1000);
    //   }
    // });
  }
}
</script>

<style lang='less'>
@import './app-preset-smsverification.less';
</style>