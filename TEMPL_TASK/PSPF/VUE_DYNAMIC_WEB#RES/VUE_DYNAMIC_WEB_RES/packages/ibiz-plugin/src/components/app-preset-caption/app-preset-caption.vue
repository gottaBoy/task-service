<template>
  <div class="app-preset-caption">
    <slot></slot>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from "vue-property-decorator";

@Component({})
export default class AppPreSetCaption extends Vue {}
</script>

<style lang='less'>
@import "./app-preset-caption.less";
</style>