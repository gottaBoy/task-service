<template>
    <div class="app-preset-switch">
        <ion-toggle class="app-preset-switch__toggle" :color="fieldStyle" :checked="curValue" :disabled="disabled" @ionChange="toggleChange"></ion-toggle>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppPresetSwitch extends Vue {
    /**
     * 开关值
     *
     * @type {*}
     * @memberof AppPresetSwitch
     */
    @Prop() public value!: any

    /**
     * 名称
     *
     * @type {*}
     * @memberof AppPresetSwitch
     */
    @Prop() public name!: string

    /**
     * 名称
     *
     * @type {*}
     * @memberof AppPresetSwitch
     */
    @Prop({default: false}) public disabled?: boolean

    /**
     * 按钮类型
     *
     * @type {*}
     * @memberof AppPresetSwitch
     */
    @Prop({default: 'primary'}) public fieldStyle?: string

    /**
     * 按钮状态改变时触发
     * @memberof AppPresetSwitch
     */
    public toggleChange(e: any) {
        this.curValue = e.detail.checked;
    }

    /**
     * 获取开关状态
     *
     * @type {*}
     * @memberof AppPresetSwitch
     */
    get curValue(): boolean {
        return !!this.value;
    }

    /**
     * 开关状态发生变化
     *
     * @type {*}
     * @memberof AppPresetSwitch
     */
    set curValue(value: boolean) {
        this.$emit('valueChange', {name: this.name, value});
    }
}
</script>

<style lang='less'>
@import './app-preset-switch.less';
</style>