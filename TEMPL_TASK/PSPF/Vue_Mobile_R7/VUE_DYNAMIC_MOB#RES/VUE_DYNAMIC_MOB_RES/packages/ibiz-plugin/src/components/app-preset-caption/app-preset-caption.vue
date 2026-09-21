<template>
    <div class="app-preset-caption">
        <slot></slot>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model } from 'vue-property-decorator';

@Component({})
export default class AppPreSetCaption extends Vue {

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppPreSetTitle
     */
    @Prop() public name!: string;

    /**
     * 类型
     *
     * @type {string}
     * @memberof AppPreSetTitle
     */
    @Prop() public type?: string;
}
</script>

<style lang='less'>
@import './app-preset-caption.less';
</style>