<template>
    <div class="app-date-range-picker">
        <el-time-picker
            v-if="Object.is(type, 'timerange')"
            v-model="curValue"
            is-range
            :size="size"
            popper-class="app-date-range-picker-popper"
            :format="format"
            :value-format="valueFormat"
            :disabled="disabled"
            :readonly="readonly"
            :range-separator="$t('components.appdaterangepicker.separator')"
            :start-placeholder="startPlaceholder || $t('components.appdaterangepicker.start')"
            :end-placeholder="endPlaceholder || $t('components.appdaterangepicker.end')"
            @focus="handleFocus"
            @blur="handleBlur"
        >
        </el-time-picker>
        <el-date-picker
            v-else
            v-model="curValue"
            :type="type"
            :size="size"
            popper-class="app-date-range-picker-popper"
            :format="format"
            :value-format="valueFormat"
            :disabled="disabled"
            :readonly="readonly"
            :unlink-panels="unlinkPanels"
            :range-separator="$t('components.appdaterangepicker.separator')"
            :start-placeholder="startPlaceholder || $t('components.appdaterangepicker.start')"
            :end-placeholder="endPlaceholder || $t('components.appdaterangepicker.end')"
            @focus="handleFocus"
            @blur="handleBlur"
        >
        </el-date-picker>
    </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Model } from 'vue-property-decorator';

@Component({})
export default class AppDateRangePicker extends Vue {
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
     * @memberof AppRangDate
     */
    @Prop() public name!: string;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppRangDate
     */
    @Prop() public data: any;

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof AppRangDate
     */
    @Prop({ default: false }) public disabled!: boolean;

    /**
     * 只读
     *
     * @type {boolean}
     * @memberof AppRangDate
     */
    @Prop({ default: false }) public readonly?: boolean;

    /**
     * 类型
     *
     * @type {string}
     * @memberof AppRangDate
     */
    @Prop({ default: 'daterange' }) public type!: string;

    /**
     * 显示格式化
     *
     * @type {string}
     * @memberof AppRangDate
     */
    @Prop() public format?: string;

    /**
     * 值格式化
     *
     * @type {string}
     * @memberof AppRangDate
     */
    @Prop() public valueFormat?: string;

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
     * 大小
     *
     * @type {string}
     * @memberof AppRangDate
     */
    @Prop({default: 'small'}) public size?: 'large' | 'small' | 'mini';

    /**
     * 关系表单项集合
     *
     * @type {string}
     * @memberof AppRangDate
     */
    @Prop() public valueItemNames?: string;

    /**
     * 取消范围联动
     *
     * @type {boolean}
     * @memberof AppRangDate
     */
    @Prop({ default: false }) public unlinkPanels!: boolean;

    /**
     * 值分割符
     *
     * @type {boolean}
     * @memberof AppRangDate
     */
    @Prop({ default: ',' }) public valueSeparator!: string;

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

    get curValue() {
        let value: any[] = [];
        if (this.valueItemNames) {
            this.valueItemNames.split(',').forEach((name: any) => {
                if (this.data[name]) {
                    value.push(this.data[name]);
                }
            });
        } else if (this.value) {
            value = this.value.split(this.valueSeparator);
        }
        return value;
    }

    set curValue(dates: string[]) {
        if (dates) {
            this.$emit('change', dates.join(this.valueSeparator));
            if (this.valueItemNames) {
                const valueItemNames: string[] = this.valueItemNames.split(',');
                dates.forEach((value: any, index: number) => {
                    this.$emit('itemChange', { name: valueItemNames[index], value: value });
                });
            }
        } else {
            this.$emit('change', null);
            if (this.valueItemNames) {
                this.valueItemNames.split(',').forEach((name: any) => {
                    this.$emit('itemChange', { name: name, value: null });
                });
            }
        }
    }
}
</script>
