<template>
    <van-radio-group class="app-mob-radio-list" :disabled="disabled" v-model="curValue" direction="horizontal">
        <van-radio v-for="(item,index) in options" :key="index" :name="item.value">{{item.text}}</van-radio>
    </van-radio-group>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import { CodeListService, LogUtil } from "ibiz-core";

@Component({
    components: {}
})
export default class AppMobRadio extends Vue {

    /**
     * 编辑器名称
     *
     * @type {string}
     * @memberof AppMobRadio
     */
    @Prop() public name?: string;      

    /**
     * 禁用
     *
     * @type {string}
     * @memberof AppStepper
     */
    @Prop({default:false}) public disabled?: boolean;

    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof AppMobRadio
     */
    public codeListService: CodeListService = new CodeListService();

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof AppMobRadio
     */
    @Prop() public tag!: string;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof AppMobRadio
     */
    @Prop() public codeListType!: string;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof AppMobActionsheet
     */
    @Prop({ default: {} }) protected context?: any;

    /**
     * 代码表列表项
     *
     * @type {Array<any>}
     * @memberof AppMobRadio
     */
    public options?: Array<any> = [];

    /**
     * 输入值
     *
     * @type {any}
     * @memberof AppMobRadio
     */
    @Prop() public value?: any;

    /**
     * 代码表
     *
     * @type {string}
     * @memberof DropDownList
     */    
    @Prop() public codeList?: any;

    /**
     * 输入值变化后的值
     *
     * @type {any}
     * @memberof AppMobRadio
     */
    get curValue() {
        return this.value;
    }

    set curValue(item:any){
      this.$emit("change", {name:this.name, value:item, event:{}});
    }

    /**
     *  vue 生命周期
     *
     * @returns
     * @memberof AppMobRadio
     */
    public created() {
        if (!this.tag || !this.codeListType) {
            return;
        }
        this.loadItems();
    }

    /**
     * 加载 数据
     *
     * @private
     * @returns {Promise<any>}
     * @memberof AppMobRadio
     */
    private async loadItems(): Promise<any> {
        if (Object.is(this.codeListType, 'dynamic')) {
            const response: any = await this.codeListService.getItems(this.tag);
            if (response) {
                this.options = response;
            } else {
                this.options = [];
            }
        } else {
            this.codeListService.getDataItems({ tag: this.tag, type: 'STATIC', data: this.codeList, context:this.context, viewparam:null }).then((codelistItems: Array<any>) => {
                this.options = codelistItems;
            }).catch((error: any) => {
                LogUtil.log(`----${this.tag}----${this.$t('app.commonWords.codeNotExist')}`);
            }) 
        }
    }
}
</script>

<style lang="less">
    .van-radio-group--horizontal{
        justify-content: flex-end;
    }
    .van-radio{
        margin:5px;
    }
</style>