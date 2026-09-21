<template>
    <div class="app-number-range-picker">
        <input-number
            :min="min"
            :max="maxLimit"
            :size="size"
            :step="step"
            :active-change="false"
            :value="minValue"
            :disabled="disabled"
            :readonly="readonly"
            :precision="precision"
            :placeholder="startPlaceholder"
            @on-focus="handleFocus"
            @on-blur="handleBlur"
            @on-change="(value) => {handleChange(value, 0)}">
        </input-number>
        <div class="app-number-range-picker__separator"> ~ </div>
        <input-number
            :min="minLimit"
            :max="max"
            :size="size"
            :step="step"
            :active-change="false"
            :value="maxValue"
            :disabled="disabled"
            :readonly="readonly"
            :precision="precision"
            :placeholder="endPlaceholder"
            @on-focus="handleFocus"
            @on-blur="handleBlur"
            @on-change="(value) => {handleChange(value, 1)}">
        </input-number>
    </div>     
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model } from 'vue-property-decorator';

@Component({})
export default class AppNumberRangePicker extends Vue {

    /**
     * 双向绑定表单项值
     *
     * @type {*}
     * @memberof AppDateRangePicker
     */

    @Model('change') public value: any;

    /**
     * 编辑项名称
     *
     * @type {string}
     * @memberof AppNumberRangePicker
     */
    @Prop() public name!: string;

    /**
     * 是否禁用
     * 
     * @type {boolean}
     * @memberof AppNumberRangePicker
     */
    @Prop({default: false}) public disabled!: boolean;

    /**
     * 只读模式
     * 
     * @type {boolean}
     */
    @Prop({default: false}) public readonly!: boolean;

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof AppNumberRangePicker
     */
    @Prop() public data: any;

    /**
     * 精度
     *
     * @type {number}
     * @memberof AppNumberRangePicker
     */
    @Prop({ default: 0 }) public precision?: number;

    /**
     * 大小
     *
     * @type {string}
     * @memberof AppRangDate
     */
    @Prop() public size?: 'large' | 'small' | 'default';

    /**
     * 开始占位提示
     *
     * @type {string}
     * @memberof AppRangDate
     */
    @Prop() public startPlaceholder?: string;

    /**
     * 结束占位提示
     *
     * @type {string}
     * @memberof AppRangDate
     */
    @Prop() public endPlaceholder?: string;

    /**
     * 步长
     *
     * @type {number}
     * @memberof AppRangDate
     */
    @Prop({default: 1}) public step!: number;

    /**
     * 最小值
     *
     * @type {number}
     * @memberof AppRangDate
     */
    @Prop() public min?: number;

    /**
     * 最大值
     *
     * @type {number}
     * @memberof AppRangDate
     */
    @Prop() public max?: number;

    /**
     * 值分割符
     *
     * @type {boolean}
     * @memberof AppRangDate
     */
    @Prop({ default: ',' }) public valueSeparator!: string;

    /**
     * 值项集合
     *
     * @type {string}
     * @memberof AppRangDate
     */
    @Prop() public valueItemNames?: string;

    /**
     * 输入框失焦
     * @param e
     */
    public handleBlur(e: any): void {
        this.$emit('blur', this.value);
    }

    /**
     * 输入框聚焦
     * @param e
     */
    public handleFocus(e: any): void {
        this.$emit('focus', this.value);
    }

    /**
     * 最小值
     * 
     * @memberof AppNumberRangePicker
     */
    get minValue() {
        if (this.valueItemNames) {
            const minValueName =  this.valueItemNames.split(',')[0];
            const value = this.data[minValueName] && Number(this.data[minValueName]);
            this.items[0] = value;
            return value;
        } else if (this.value) {
            const value = Number(this.value.split(this.valueSeparator)[0]);
            this.items[0] = value;
            return value;
        } else {
            return null;
        }
    }

    /**
     * 最大值
     * 
     * @memberof AppNumberRangePicker
     */
    get maxValue() {
        if (this.valueItemNames && this.valueItemNames.split(',').length > 1) {
            const maxValueName =  this.valueItemNames.split(',')[1];
            const value = this.data[maxValueName] && Number(this.data[maxValueName]);
            this.items[1] = value;
            return value;
        } else if (this.value) {
            const value = Number(this.value.split(this.valueSeparator)[1]);
            this.items[1] = value;
            return value;
        }else{
            return null;
        }
    }

    /**
     * 最小值范围
     * 
     * @memberof AppNumberRangePicker
     */
    get minLimit(): number {
        if (this.minValue) {
            return this.minValue + this.step;
        } else if (this.min) {
            return this.min + this.step;
        } else {
            return -Infinity;
        }
    }

    /**
     * 最大值范围
     * 
     * @memberof AppNumberRangePicker
     */
    get maxLimit(): number {
        if (this.maxValue) {
            return this.maxValue - this.step;
        } else if (this.max) {
            return this.max - this.step;
        } else {
            return Infinity;
        }
    }

    /**
     * 数据
     * 
     * @memberof AppNumberRangePicker
     */
    public items: number[] = [];

    /**
     * 值改变
     *
     * @param {number} value 值
     * @param {number} index 项下标
     * @memberof AppNumberRangePicker
     */
    public handleChange(value: number, index: number) {
        this.items[index] = value;
        this.$emit('change', this.items.join(this.valueSeparator));
        if (this.valueItemNames && this.valueItemNames.split(',').length > index) {
            const valueName =  this.valueItemNames.split(',')[index];
            this.$emit('itemChange', { name: valueName, value: value.toString() });
        }
    }
}
</script>