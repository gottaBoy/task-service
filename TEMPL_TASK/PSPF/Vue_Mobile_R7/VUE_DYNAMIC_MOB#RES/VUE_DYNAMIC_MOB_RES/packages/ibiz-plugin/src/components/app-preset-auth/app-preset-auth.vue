<template>
  <div class="app-preset-auth">
    <auth-puzzle-vcode :show="show" @success="onSuccess" @fail="onFail" />
    <app-mob-button @click="executeOpen">验证</app-mob-button>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model } from "vue-property-decorator";
import AuthPuzzleVcode from "./vue-puzzle-code/vue-puzzle-code.vue";
@Component({
  components: {
    "auth-puzzle-vcode": AuthPuzzleVcode,
  },
})
export default class AppPreSetAuth extends Vue {
  /**
   * 输入值
   *
   * @type {*}
   * @memberof AppPreSetAuth
   */
  @Prop() public value!: any;

  /**
   * 名称
   *
   * @type {string}
   * @memberof AppPreSetAuth
   */
  @Prop() public name!: string;

  /**
   * 类型
   *
   * @type {string}
   * @memberof AppPreSetAuth
   */
  @Prop() public type?: string;

  /**
   * 是否显示
   */
  public show: boolean = false;

  /**
   * 组件创建时触发
   *
   * @type {*}
   * @memberof AppPreSetAuth
   */
  public created() {
    this.$emit("valueChange", { name: this.name, value: false });
  }

  /**
   * 打开
   */
  public executeOpen() {
    this.show = true;
  }

  /**
   * 成功
   */
  public onSuccess() {
    this.show = false;
    this.$emit("valueChange", { name: this.name, value: true });
  }

  /**
   * 成功
   */
  public onFail() {
    this.$emit("valueChange", { name: this.name, value: false });
  }
}
</script>

<style lang='less'>
</style>