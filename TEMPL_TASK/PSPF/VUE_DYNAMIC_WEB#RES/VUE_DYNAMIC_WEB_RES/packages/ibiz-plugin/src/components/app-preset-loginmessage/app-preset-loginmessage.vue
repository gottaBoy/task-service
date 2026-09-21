<template>
  <div class="app-preset-loginmessage">
    <alert :class="['app-alert', {'opacity': !value }]" type="error" show-icon>{{ value }}</alert>
  </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop } from "vue-property-decorator";

@Component({})
export default class AppPreSetLoginMessage extends Vue {

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