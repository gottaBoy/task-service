<template>
    <div class="app-text-input">
        <ion-input class="app-ion-input" @ionChange="change" :value="curValue" :placeholder="placeholder"></ion-input>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppTextInput extends Vue {
    /**
     * 输入值
     *
     * @type {*}
     * @memberof AppTextInput
     */
    @Prop() public value!: any;

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppTextInput
     */
    @Prop() public name!: string;

    /**
     * 禁用
     *
     * @type {boolean}
     * @memberof AppTextInput
     */
    @Prop() public disabled?: boolean;

    /**
     * 占位文本
     *
     * @type {string}
     * @memberof AppTextInput
     */
    @Prop({default: ''}) public placeholder?: string;

    /**
     * 输入值发生变化
     *
     * @memberof AppTextInput
     */
    public change(e: any) {
        this.curValue = e.detail.value
    }

    /**
     * 当前值
     *
     * @memberof AppTextInput
     */
    get curValue() {
        return this.value;
    }

    /**
     * 值变化
     *
     * @memberof AppTextInput
     */
    set curValue(val: any) {
        this.$emit('valueChange', { name: this.name, value: val });
    }
}
</script>

<style lang='less'>
@import './app-text-input.less';
</style>