<template>
    <div class="app-mob-input">
        <ion-input 
            class="form-value-content" 
            debounce="300" 
            :type="type" 
            :min="min" 
            :max="max" 
            :disabled="disabled" 
            :value="value" 
            :placeholder="placeholder" 
            @ionChange="change" 
            @ionFocus="enter"
            @ionBlur="leave"
            ref="ioninput"
        />
        <div class="app-mob-input__unit" v-if="unit">{{unit}}</div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop} from 'vue-property-decorator';

@Component({
    components: {
    }
})
export default class AppInput extends Vue {  
  
    /**
     * 编辑器名称
     *
     * @type {string}
     * @memberof AppInput
     */
    @Prop() public name?: string;

    /**
     * 值
     *
     * @type {string}
     * @memberof AppInput
     */
    @Prop() public value?: string;

    /**
     * 禁用
     *
     * @type {string}
     * @memberof AppInput
     */
    @Prop({default:false}) public disabled?: boolean;
    
    /**
     * 类型
     *
     * @type {string}
     * @memberof AppInput
     */
    @Prop() public type?: string;


    /**
     * 占位提示文字
     *
     * @type {string}
     * @memberof AppInput
     */
    @Prop() public placeholder?:string;  
    
    /**
     * 单位
     *
     * @type {string}
     * @memberof AppInput
     */
    @Prop() public unit?: string;

    /**
     * 最小值
     *
     * @type {number}
     * @memberof AppInput
     */
    @Prop() public min?: number;

    /**
     * 最大值
     *
     * @type {number}
     * @memberof AppInput
     */
    @Prop() public max?: number;

    /**
     * change事件
     *
     * @memberof AppInput
     */
    public change(value: any) {
        if(value?.detail?.value == this.value ){
            return;
        }
        if(!value?.detail?.value){
            this.$emit("change", {name:this.name, value:null, event:value});
            return;
        }
        if(this.type == "number"){
            if (this.min && value.detail.value < this.min) {
                this.$emit("change", {name:this.name, value:this.min, event:value});
                // 手动ion数值框设为最小值
                let ioninput:any = this.$refs.ioninput;
                ioninput.value = this.min;
                return
            }
            if (this.max && value.detail.value > this.max) {
                this.$emit("change", {name:this.name, value:this.max, event:value});
                // 手动ion数值框设为最大值
                let ioninput:any = this.$refs.ioninput;
                ioninput.value = this.max;
                return
            }
            this.$emit("change", {name:this.name, value:value.detail.value ? parseFloat(value.detail.value) : "", event:value});
        }else{
            this.$emit("change", {name:this.name, value:value.detail.value, event:value});
        }
    }

    /**
     * 有焦点时事件
     *
     * @memberof AppInput
     */
    public enter(e: any) {
        this.$emit('enter', {name: this.name, value: this.value, event: e});
    }

    /**
     * 失去焦点事件
     *
     * @memberof AppInput
     */
    public leave(e: any) {
        this.$emit('leave', {name: this.name, value: this.value, event: e});
    }
}
</script>