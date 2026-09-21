<template>
    <h1 class="app-preset-title">{{ curValue }}</h1>
</template>

<script lang="ts">
import { AppServiceBase } from 'ibiz-core';
import { Vue, Component, Prop, Model } from 'vue-property-decorator';

@Component({})
export default class AppPreSetTitle extends Vue {

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

    /**
     * 当前值
     *
     * @memberof AppPreSetTitle
     */
    public curValue: string = '';

    /**
     * 初始化
     *
     * @memberof AppPreSetTitle
     */
    public created() {
        this.curValue = AppServiceBase.getInstance().getAppEnvironment().AppTitle;
    }
}
</script>

<style lang='less'>
@import './app-preset-title.less';
</style>