<template>
    <el-switch
        v-model="curValue"
        :disabled="disabled || readonly"
        :active-text="activeText"
        :inactive-text="inactiveText"
    ></el-switch>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";

@Component({})
export default class AppSwitch extends Vue {
    /**
     * checked选中状态
     * @type {boolean}
     * @memberof Appswitch
     */
    @Prop() public value?: any;

    /**
     * 禁用
     * @type {boolean}
     * @memberof Appswitch
     */
    @Prop() public disabled?: boolean;

    /**
     * 只读模式
     * @type {boolean}
     * @memberof Appswitch
     */
    @Prop({ default: false }) public readonly?: boolean;

    /**
     * 开关前后缀
     * @type {*}
     * @memberof Appswitch
     */
    @Prop({ default: () => [] }) public dicData?: any;

    /**
     * 开关前缀label
     * @type {*}
     * @memberof Appswitch
     */
    public inactiveText: any = null;

    /**
     * 开关后缀label
     * @type {*}
     * @memberof Appswitch
     */
    public activeText: any = null;

    /**
     * 获取值
     * @memberof Appswitch
     */
    get curValue() {
        return this.value == 1 ? true : false;
    }

    /**
     * 设置值
     * @param value
     * @memberof Appswitch
     */
    set curValue(value: any) {
        let emitValue = value == true ? 1 : 0;
        this.$emit("change", emitValue);
    }

    /**
     * create生命周期,初始化前后缀
     * @type {*}
     * @memberof Appswitch
     */
    public created() {
        if (this.dicData && Array.isArray(this.dicData)) {
            const result_inactive = this.dicData.find((item: any) => {
                return item.value === 0;
            });
            if (result_inactive) {
                this.inactiveText = result_inactive.label;
            }
            const result_active = this.dicData.find((item: any) => {
                return item.value === 1;
            });
            if (result_active) {
                this.activeText = result_active.label;
            }
        }
    }
}
</script>
