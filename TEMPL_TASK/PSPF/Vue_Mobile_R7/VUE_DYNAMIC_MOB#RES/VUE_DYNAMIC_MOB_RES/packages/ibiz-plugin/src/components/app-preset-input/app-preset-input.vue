<template>
  <ion-input
    class="app-preset-input"
    :type="curType"
    debounce="300"
    :disabled="disabled"
    :value="value"
    :placeholder="curPlaceHolder"
    @ionChange="change"
  ></ion-input>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model } from 'vue-property-decorator';

@Component({})
export default class AppPreSetInput extends Vue {
  /**
   * 输入值
   *
   * @type {*}
   * @memberof AppPreSetInput
   */
  @Prop() public value!: any;

  /**
   * 名称
   *
   * @type {string}
   * @memberof AppPreSetInput
   */
  @Prop() public name!: string;

  /**
   * 类型
   *
   * @type {string}
   * @memberof AppPreSetInput
   */
  @Prop() public type?: string;

  /**
   * 禁用
   *
   * @type {boolean}
   * @memberof AppPreSetInput
   */
  @Prop() public disabled?: boolean;

  /**
   * 值变化
   *
   * @memberof AppPreSetInput
   */
  public change(val: any) {
    this.$emit('valueChange', { name: this.name, value: val.detail.value });
  }

  /**
   * 当前类型
   *
   * @type {string}
   * @memberof AppPreSetInput
   */
  get curType() {
    if (Object.is(this.type, 'AUTH_PASSWORD')) {
      return 'password';
    } else {
      return 'text';
    }
  }

  /**
   * 占位文本
   *
   * @type {string}
   * @memberof AppPreSetInput
   */
  @Prop() public placeholder?: any;

  /**
   * 当前占位文本
   *
   * @type {string}
   * @memberof AppPreSetInput
   */
  get curPlaceHolder() {
    if (this.placeholder) {
      return this.placeholder;
    } else {
      if (Object.is(this.type, 'AUTH_USERID')) {
        return '请输入登录账号';
      } else if (Object.is(this.type, 'AUTH_PASSWORD')) {
        return '请输入密码';
      } else {
        return '';
      }
    }
  }
}
</script>

<style lang='less'>
@import './app-preset-input.less';
</style>