<template>
    <Select
        v-model="value"
        class="cron-editor__transfer-select"
        @on-change='handleCronChange'
        :disabled="disabled || readonly"
        :placeholder="placeholder">
        <Option class="hidden" :value="defaultLabel" :label="defaultLabel">
        </Option>
        <vue-cron class='vue-cron' :value="value"  @cronValue='handleCronChange'></vue-cron>
    </Select>
    
</template>


<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import VueCron from './vue-cron/vue-cron.vue';

@Component({
    components: {
        'vue-cron': VueCron,
    }
})
export default class CronEditor extends Vue {

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof CronEditor
     */
    @Prop() public data?: any;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof CronEditor
     */
    @Prop() public itemValue!: string;
    
    /**
     * 启用状态
     *
     * @type {any}
     * @memberof CronEditor
     */ 
    @Prop() disabled: any;

	/**
     * 只读模式
     * 
     * @type {boolean}
     */
    @Prop({default: false}) public readonly?: boolean;

    /**
     * 下拉框显示值
     *
     * @type {any}
     * @memberof CronEditor
     */ 
    @Prop() placeholder:any;

    /**
     * 监控值变化，根据属性类型强制转换
     *
     * @memberof CronEditor
     */
    @Watch('itemValue',{
        immediate: true
    })
    public valueWatch(newVal: string) {
        if (newVal) {
          this.defaultLabel = newVal;
          this.value = newVal;
        }
    }

    /**
     * 绑定Cron表达式
     * 
     * @type {any[]}
     * @memberof CronEditor
     */
    public value: string = '';

    /**
     * 默认label
     * 
     * @type {any[]}
     * @memberof CronEditor
     */
    public defaultLabel: string = '';

    /**
     * 处理返回Cron表达式
     *
     * @type {any}
     * @memberof CronEditor
     */ 
    public handleCronChange(val: any) {
        this.value = val;
        this.$emit('change', val);
    }
}

</script>