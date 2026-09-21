<template>
   <van-stepper class="app-mob-stepper" :disabled="disabled" v-model="curValue" @focus="enter" @blur="leave"/>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { Stepper } from 'vant';
Vue.use(Stepper);
@Component({
    components: {
      
    }
})
export default class AppStepper extends Vue {
    /**
     * 值
     *
     * @type {string}
     * @memberof AppStepper
     */
    @Prop() public value?: string;

    /**
     * 禁用
     *
     * @type {string}
     * @memberof AppStepper
     */
    @Prop({default:false}) public disabled?: boolean;

    /**
     * 编辑器名称
     *
     * @type {string}
     * @memberof AppStepper
     */
    @Prop() public name?:string;


    get curValue(){
        return this.value;
    }

    set curValue(value:any){
        this.$emit('change',{ name:this.name , value:value.toString(), event:{}});
    }


    /**
     * 有焦点时事件
     *
     * @memberof AppStepper
     */
    public enter(e: any) {
        this.$emit('enter', {name: this.name, value: this.value, event:e});
    }

    /**
     * 失去焦点事件
     *
     * @memberof AppStepper
     */
    public leave(e: any) {
        this.$emit('leave', {name: this.name, value: this.value, event:e});
    }

}
</script>