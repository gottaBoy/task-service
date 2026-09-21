<template>
    <div class="app-slider">
        <el-slider
            v-model="currentVal"
            :disabled="disabled || readonly"
            :step="step"
            :min="min"
            :max="max"
            :show-stops="showStops"
            :range="range"
            :show-input="showInput"
            @change="change"
        >
        </el-slider>
    </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";

@Component({})
export default class AppSlider extends Vue {
    /**
     * 传入值
     * @type {any}
     * @memberof AppSlider
     */
    @Prop() public value?: any;

    /**
     * 是否禁用
     * @type {boolean}
     * @memberof AppSlider
     */
    @Prop() public disabled?: boolean;

    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppPicker
     */
    @Prop() public name!: string;

    /**
     * 步长
     * @type {number}
     * @memberof AppSlider
     */
    @Prop({ default: 1 }) public step!: number;

    /**
     * 最小值
     * @type {number}
     * @memberof AppSlider
     */
    @Prop({ default: 0 }) public min!: number;

    /**
     * 最大值
     * @type {number}
     * @memberof AppSlider
     */
    @Prop({ default: 100 }) public max!: number;

    /**
     * 只读模式
     *
     * @type {boolean}
     */
    @Prop({ default: false }) public readonly?: boolean;

    /**
     * 显示间隔点
     * @type {boolean}
     * @memberof AppSlider
     */
    @Prop({ default: false }) public showStops!: boolean;

    /**
     * 显示范围
     * @type {number}
     * @memberof AppSlider
     */
    @Prop({ default: false }) public range!: boolean;

    /**
     * 显示输入框
     * @type {number}
     * @memberof AppSlider
     */
    @Prop({ default: false }) public showInput!: boolean;

    /**
     * 当前值
     *
     * @memberof AppSlider
     */
    currentVal: number | Array<any> = 0;

    /**
     * 值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPicker
     */
    @Watch("value",{immediate:true,deep:true})
    public onValueChange(newVal: any, oldVal: any) {
        if(this.range){
            if(newVal && Array.isArray(newVal) &&  newVal.length > 0){
                //范围滑动条
                this.currentVal = newVal.map((item:any)=>{
                    return parseInt(item);
                })
            }else{
                this.currentVal = [this.min,this.max];
            }

        }else{
            newVal = newVal === null ? 0 : newVal;
            this.currentVal = parseInt(newVal);
        } 
    }

    /**
     * change事件
     *
     * @param {*} val
     * @memberof AppPicker
     */
    public change(val: any) {
        this.$emit("change", { name: this.name, value: val });
    }
}
</script>