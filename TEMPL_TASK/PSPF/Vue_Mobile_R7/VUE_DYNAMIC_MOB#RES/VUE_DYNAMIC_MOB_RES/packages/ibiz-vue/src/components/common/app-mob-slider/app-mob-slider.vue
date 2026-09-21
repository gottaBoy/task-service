<template>
  <div class="app-mob-slider">
      <ion-range class="app-mob-slider__range" :value="value" :min="min" :max="max" :step="step" pin :disabled="disabled" @ionChange="($event) => debounce(change, $event)" @ionFocus="enter" @ionBlur="leave"></ion-range>
  </div>
</template>



<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { debounce } from 'ibiz-core';

@Component({
    components: {
      
    }
})
export default class AppMobSlider extends Vue {
    /**
     * 值
     *
     * @type {number}
     * @memberof AppMobSlider
     */
    @Prop() public value?:number;

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppMobSlider
     */
    @Prop() public name?:string;

    /**
    * 步长
    * @type {number}
    * @memberof AppMobSlider
    */
    @Prop({default:1}) public step!: number;

    /**
    * 最小值
    * @type {number}
    * @memberof AppMobSlider
    */
    @Prop({default:0}) public min!: number;

    /**
    * 最大值
    * @type {number}
    * @memberof AppMobSlider
    */
    @Prop({default:100}) public max!: number;

    /**
     * 禁用
     *
     * @type {boolean}
     * @memberof AppMobSlider
     */
    @Prop({default:false}) public disabled?:boolean;

    /**
     * 防抖
     * @memberof AppMobSlider
     */
    public debounce: Function = debounce;

    /**
     * change事件
     */
    public change(data:any) {
        this.$emit('change',{name:this.name,value:data.detail.value.toString(),event:data});
    }


    /**
     * 有焦点时事件
     *
     * @memberof AppMobSlider
     */
    public enter(e: any) {
        this.$emit('enter', {name: this.name, value: this.value, event:e});
    }

    /**
     * 失去焦点事件
     *
     * @memberof AppMobSlider
     */
    public leave(e: any) {
        this.$emit('leave', {name: this.name, value: this.value, event:e });
    }    
 
}
</script>