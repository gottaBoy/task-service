<template>
    <div class="app-mob-span form-value-content" oncontextmenu="return false;" :class="currentItem && currentItem.className?currentItem.className:''" >
        <template v-if="!codeListType">
          <div v-if="textFormat" class="app-mob-span__format__contaner" >
              <span class="app-mob-span__format" v-format="textFormat">{{text}}</span>
          </div>
            <ion-input class="app-mob-span__input" v-else readonly :value="text + (unitName ? unitName : '')"></ion-input>
        </template>
        <template v-else-if="codeListType  && !showSourceMode">
            <ion-input class="app-mob-span__input" v-if="codeListType == 'DYNAMIC'" readonly :value="($t('userCustom.'+tag+'.'+value)!== ('userCustom.'+tag+'.'+value))?$t('userCustom.'+tag+'.'+value) : text"></ion-input>
            <ion-input class="app-mob-span__input" :style="{color:currentItem && currentItem.color?currentItem.color:''}"  v-if="codeListType == 'STATIC'" readonly :value="($t('codelist.'+tag+'.'+value)!== ('codelist.'+tag+'.'+value))?$t('codelist.'+tag+'.'+value) : text"></ion-input>
        </template>
        <template v-else-if="
            Object.is(editorType, 'SPAN_PICTURE') ||
            Object.is(editorType, 'SPAN_PICTURE_ONE') ||
            Object.is(editorType, 'SPAN_FILEUPLOADER')
        ">
          <app-upload-file-info
              :value="value"
              :name="name"
          />
        </template>
    </div>
</template>


<script lang="ts">
import { Vue, Component, Prop, Provide, Emit, Watch, } from "vue-property-decorator";
import { CodeListService, ViewTool } from "ibiz-core";
import { LogUtil } from "ibiz-core";
import moment from "moment";

@Component({
    components: {}
})
export default class AppSpan extends Vue {

    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof AppSelect
     */
    public codeListService: CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 编辑器类型
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop() public editorType?: string;    

    /**
     * 数据类型
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop() public dataType?: string;
    
    /**
     * 单位名称
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop({ default: '' }) public unitName?: string;

    /**
     * 精度
     *
     * @type {number}
     * @memberof AppSpan
     */
    @Prop({ default: '2' }) public precision?: number;

    /**
     * 数据值格式化
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop() public valueFormat!: string;

    /**
     * 无值显示模式
     * 
     * @type {boolean}
     * @memberof AppSpan
     */
    @Prop({default: 'DEFAULT'}) public noValueShowMode?: 'DEFAULT' | 'STYLE1';

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof AppSelect
     */
    @Prop() public tag!: string;

    /**
     * 编辑器名称
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop() public name?:string;    

    /**
     * 代码表类型 
     * STATIC：静态
     * DYNAMIC：动态
     *
     * @type {(string | 'STATIC' | 'DYNAMIC')}
     * @memberof Login
     */
    @Prop() public codeListType!: string | 'STATIC' | 'DYNAMIC';

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppSelect
     */
    @Prop() public viewparams!: any;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof AppSelect
     */
    @Prop() public data?: any;

    /**
     * 值
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop() public value?: any;


    /**
     * 显示模式(为true不做翻译，直接显示值，配合codelist使用)
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop({default: false}) public showSourceMode?: boolean;

    /**
     * 查询参数
     * @type {*}
     * @memberof AppSpan
     */
    public queryParam: any;

    /**
     * 代码表
     *
     * @type {any[]}
     * @memberof AppSpan
     */
    public items: any[] = [];

    /**
     * 显示值
     * @type {*}
     * @memberof AppSpan
     */
    public text: any = '';

    /**
     * 显示值格式
     * @type {*}
     * @memberof AppSpan
     */
    public textFormat: any = '';    

    /**
       * 是否缓存
       *
       * @type {*}
       * @memberof AppSelect
       */
    @Prop({ default: true }) protected isCache?: boolean;

    /**
     * 是否被缓存
     *
     * @type {*}
     * @memberof AppSpan
     */
    public isCached: boolean = false;

    /**
      * 应用上下文
      *
      * @type {*}
      * @memberof AppSpan
      */
    @Prop({ default: ()=>{} }) protected context?: any;

    /**
     * 导航参数
     *
     * @type {*}
     * @memberof AppSelect
     */
    @Prop({ default: () => {} }) protected navigateParam?: any;

    /**
     * 导航上下文
     *
     * @type {*}
     * @memberof AppSelect
     */
    @Prop({ default: () => {}}) protected navigateContext?: any;


    /**
     * 代码表
     *
     * @type {string}
     * @memberof DropDownList
     */    
    @Prop() public codeList?: any;

    /**
      * 当前值项
      *
      * @type {*}
      * @memberof AppSpan
      */
    public currentItem: any = {};


    /**
     * 监控值
     *
     * @memberof AppSpan
     */
    @Watch('value')
    public itemChange() {
        if (this.tag && Object.is(this.codeListType, "DYNAMIC")) {
            this.load();
        } else {
            this.setText();
        }
    }

    /**
     * 加载代码表
     * 
     * @memberof AppSpan
     */
    public async load(): Promise<any> {
        if (Object.is(this.codeListType, "STATIC")  && !this.showSourceMode) {
            return;
        }
        let param: any = {context:{},param:{}};
        this.handleOtherParam(param);
        let tempParam = param.param;
        if(tempParam){
            Object.assign(tempParam,this.queryParam);
        }
        let response: any = await this.codeListService.getItems(this.tag, param.context,tempParam);
        if (response) {
            this.items = response;
            this.setText();
            if (this.isCache) {
                this.isCached = true;
            }
        } else {
            this.items = [];
        }
    }

    /**
     * 处理额外参数
     */
    public handleOtherParam(arg: any) {
        if (!this.data) {
            return false;
        }
        // 附加参数处理
        const { context, param } = ViewTool.formatNavigateParam(this.navigateContext, this.navigateParam, this.context, this.viewparams, this.data);
        arg.context = context;
        arg.param = param;
        return true;
    }

    /**
     * 设置显示值
     * @memberof AppSpan
     */
    public setText() {
        if (!this.value) {  // 新建等没有值的情况
            this.text = "";
        }
        if (this.items.length === 0) {  // 代码表为空的情况
            this.text = this.value || '';
        }
        this.currentItem = this.items.find((item: any) => {
            return item.value == this.value;
        });
        if (!this.currentItem) {
            if (this.dataType) {
              this.dataFormat();
            } else {
              this.text = this.value || '';
            }
        } else {
            this.text = this.currentItem.text || '';
        }
    }

    /**
     * 数据格式化
     *
     * @memberof AppSpan
     */
    public dataFormat() {
        if (this.valueFormat) {
            this.formatData();
            return;
        }
        if (Object.is(this.dataType, 'CURRENCY')) {
            let number: any = Number(this.value);
            this.text = Number(number.toFixed(this.precision)).toLocaleString('en-US');
        } else if (Object.is(this.dataType, 'FLOAT') || Object.is(this.dataType, 'DECIMAL')) {
            let number: any = Number(this.value);
            const decimalCnt: number =
                this.value.toString().split('.').length > 1 ? this.value.toString().split('.')[1].length : 0;
            this.text =
                Number(this.precision) === 0 && decimalCnt !== 0
                    ? number.toFixed(decimalCnt)
                    : number.toFixed(this.precision);
        } else {
            let valueArr: any;
            // 值为字符串类型
            valueArr = this.value?this.value.split(","):"";
            if (valueArr.length > 1) {  // 值为多数据类型
                valueArr.forEach((val: string) => {
                    this.items.forEach((item: any) => {
                        if (val === item.id) {
                            this.text = this.text + `${item.text},`;
                        }
                    });
                });
            }
        }
    }

    /**
     * 数据格式化
     *
     * @memberof AppSpan
     */
    public formatData() {
      if (this.valueFormat && !Object.is(this.getDataType(), 'DATETIME')) {
        this.textFormat = this.unitName ? this.valueFormat + '_' + this.unitName : this.valueFormat;
        //vue-text-format插件重复值修复
        if(this.valueFormat.includes("*")) {
          this.$nextTick(()=> {
            const el: any = this.$el.getElementsByClassName("vue-format-single-fill")[0];
            if (el) {
              el.innerHTML = el.innerHTML.repeat(el.offsetWidth);
            }
          })
        }
      }
      if (Object.is(this.getDataType(), 'DATETIME') && this.valueFormat.length > 0 && this.value) {
        this.text = moment(this.value).format(this.valueFormat);
      }else {
        this.text = this.value || '';
      }
    }    

    /**
     * vue  生命周期
     *
     * @memberof AppSpan
     */
    public created() {
        if (Object.is(this.codeListType, "STATIC")) {
            this.codeListService.getDataItems({ tag: this.tag, type: 'STATIC', data: this.codeList, context:this.context, viewparam:null }).then((codelistItems: Array<any>) => {
                this.items = codelistItems;
                this.setText();
            }).catch((error: any) => {
                LogUtil.log(`----${this.tag}----${this.$t('app.commonWords.codeNotExist')}`);
            })             
            this.setText();
        } else if (Object.is(this.codeListType, "DYNAMIC")) {
            this.load();
        } else {
            this.setText();
        }
    }

    /**
     * 获取数据格式
     *
     * @memberof AppSpan
     */
    public getDataType() {
        if (
            this.dataType &&
            (this.dataType == 'DATETIME' || this.dataType == 'DATE' || this.dataType == 'TIME' || this.dataType == 'SMALLDATETIME')
        ) {
            //  日期格式统一处理
            return 'DATETIME';
        } else {
            return this.dataType;
        }
    }    

}
</script>