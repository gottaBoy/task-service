<template>
  <div class="app-mob-textarea">
        <ion-textarea
        :placeholder="placeholder"
        class="form-value-content app-mob-textarea__content"
        :auto-grow="true"
        :disabled="disabled"
        :value="value"
        @ionChange="($event) => debounce(valueChange, $event)"
        @ionFocus="enter"
        @ionBlur="leave"        
      ></ion-textarea>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { debounce } from 'ibiz-core';

@Component({
    components: {
    }
})
export default class AppTextarea extends Vue {       
    /**
     * 输入值
     *
     * @type {string}
     * @memberof AppTextarea
     */
    @Prop() public value?: string;

    /**
     * 编辑器名称
     *
     * @type {string}
     * @memberof AppMobSwitch
     */
    @Prop() public name?:string;    

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof AppTextarea
     */
    @Prop({default:false}) public disabled?: boolean;

    /**
     * 防抖
     * @memberof AppTextarea
     */
    public debounce: Function = debounce;
        
    /**
     * 值改变
     * 
     * @memberof AppTextarea
     */
    public valueChange(event:any){
     	this.$emit('change',{ name:this.name , value:event.detail.value , event:event});
    }

    /**
     * 有焦点时事件
     *
     * @memberof AppTextarea
     */
    public enter(e: any) {
        this.$emit('enter', {name: this.name, value: this.value, event:e});
    }

    /**
     * 失去焦点事件
     *
     * @memberof AppTextarea
     */
    public leave(e: any) {
        this.$emit('leave', {name: this.name, value: this.value, event:e});
    }

    /**
     * 占位提示文字
     *
     * @type {string}
     * @memberof AppTextarea
     */
    @Prop({default:'暂无内容'}) public placeholder?:string;       
}
</script>