<template>
  <div class="app-preset-loginmessage">
    <div :class="['alert', {'opacity': !value }]">
      <ion-icon class="icon" name="close-circle"></ion-icon>
      <div class="text">{{ value }}</div>
    </div>
  </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Watch } from "vue-property-decorator";

@Component({})
export default class AppPresetLoginMessage extends Vue {
    /**
     * 名称
     *
     * @type {string}
     * @memberof AppPreSetLoginMessage
     */
    @Prop() public name?: string;

    /**
     * 内容
     *
     * @type {string}
     * @memberof AppPreSetLoginMessage
     */
    @Prop() public value?: string;

    /**
     * 组件创建时触发
     *
     * @type {*}
     * @memberof AppPreSetLoginMessage
     */
    public created() {
      this.$emit("valueChange", { name: this.name, value: '' });
    }
}
</script>

<style lang='less'>
@import "./app-preset-loginmessage.less";
</style>