<template>
  <el-switch class="app-preset-switch" v-model="curValue" :disabled="disabled"></el-switch>
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