<template>
    <ion-toggle
    class="app-mob-switch"
    :checked="curValue"
    @ionChange="change"
    @ionFocus="enter"
    @ionBlur="leave"  
    :disabled="disabled"
    >
  </ion-toggle>
</template>

<script lang="ts">
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';

@Component({
    components: {
    }
})
export default class AppMobSwitch extends Vue {  
    /**
     * checked选中状态
     *
     * @type {boolean}
     * @memberof AppMobSwitch
     */
    @Prop() public value?: any;

    /**
     * 编辑器名称
     *
     * @type {string}
     * @memberof AppMobSwitch
     */
    @Prop() public name?:string;    

    /**
     * 禁用
     *
     * @type {boolean}
     * @memberof AppMobSwitch
     */
    @Prop({default:false}) public disabled?:boolean;

    
    get curValue(){
        return this.value == 1 ? true:false;
    }
    /**
     * change事件
     *
     * @memberof AppMobSwitch
     */
    public change(value:any){
        this.$emit('change',{ name:this.name , value:value.detail.checked == true ? '1':'0', event:{}}); 
    }


    /**
     * 有焦点时事件
     *
     * @memberof AppMobSwitch
     */
    public enter(e: any) {
        this.$emit('enter', {name: this.name, value: this.value, event:e});
    }

    /**
     * 失去焦点事件
     *
     * @memberof AppMobSwitch
     */
    public leave(e: any) {
        this.$emit('leave', {name: this.name, value: this.value, event:e});
    }    
}
</script>
