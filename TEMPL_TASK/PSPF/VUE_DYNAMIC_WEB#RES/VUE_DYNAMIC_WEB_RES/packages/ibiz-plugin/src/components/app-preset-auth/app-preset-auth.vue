<template>
  <div class="app-preset-auth">
    <auth-puzzle-vcode :show="show" @success="onSuccess" @fail="onFail" />
    <i-button ghost @click="executeOpen" long class="app-preset-auth-button"
      >验证</i-button
    >
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
.app-preset-auth {
  .app-preset-auth-button {
    border: 1px solid #dcdee2;
    border-radius: 4px;
    color: #515a6e;
    &:hover{
      border: 1px solid #dcdee2;
      color: #515a6e;
    }
  }
}
</style>