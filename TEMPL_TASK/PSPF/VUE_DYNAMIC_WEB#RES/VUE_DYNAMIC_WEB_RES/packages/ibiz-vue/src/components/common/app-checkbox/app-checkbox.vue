<template>
    <div class="app-checkbox">
        <checkbox v-model="CurrentVal" :disabled="disabled || readonly"></checkbox>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppCheckbox extends Vue {
    /**
     * 传入值
     * @type {any}
     * @memberof checkbox
     */
    @Prop() public value?: any;

    /**
     * 是否禁用
     * @type {boolean}
     * @memberof checkbox
     */
    @Prop() public disabled?: boolean;

    /**
     * 只读模式
     *
     * @type {boolean}
     */
    @Prop({ default: false }) public readonly?: boolean;

    /**
     * 设置未选中值
     *
     * @type {boolean}
     */
    @Prop({ default: 0 }) public nullValue!: any;

    /**
     * 设置选中值
     *
     * @type {boolean}
     */
    @Prop({ default: 1 }) public selectValue!: any;

    /**
     * 当前值
     *
     * @memberof checkbox
     */
    get CurrentVal() {
        if (this.value === this.selectValue) {
          return true;
        } else {
          return false;
        }
    }

    /**
     * 值变化
     *
     * @memberof checkbox
     */
    set CurrentVal(val: any) {
        let value: any;
        if (val) {
          value = this.selectValue;
        } else {
          value = this.nullValue;
        }
        this.$emit('change', value);
    }
}
</script>
