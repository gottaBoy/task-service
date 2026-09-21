<template>
    <div class="dropdown-list">
        <i-select v-if="'default' == editorStyle"
        class='dropdown-list__select'
        :transfer="true"
        transfer-class-name="dropdown-list__transfer"
        v-model="currentVal"
        :disabled="disabled || readonly"
        :clearable="clearable"
        :filterable="filterable"
        @on-open-change="onClick"
        @click.native.capture='click' 
        :placeholder="placeholder?placeholder:$t('components.dropdownlist.placeholder')">
        <i-option v-for="(item, index) in items" :key="index" :disabled="item.disabled" :class="item.class" :value="item.value">{{item.text}}</i-option>
        </i-select>
        <app-select-tree v-else-if="'tree' == editorStyle" :transfer="true" class="dropdown-list__tree" :disabled="disabled || readonly" :NodesData="items" v-model="currentVal" :multiple="false"></app-select-tree>
        <el-cascader
            class="dropdown-list__cascader"
            v-else-if="'cascader' == editorStyle"
            :disabled="disabled || readonly"
            :placeholder="placeholder"
            v-model="currentVal"
            :options="items"
            :clearable="clearable"
            :separator="separator"
            :show-all-levels="showAllLevels"
            :props="{ multiple: false }"
            :filterable="filterable"
            @visible-change="onChange"
        >
        </el-cascader>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Watch, Prop, Model } from 'vue-property-decorator';
import { CodeListService, Util, LogUtil } from 'ibiz-core';
import { Subject, Subscription } from 'rxjs';

@Component({
})
export default class DropDownList extends Vue {
    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof DropDownList
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 额外参数
     *
     * @type {*}
     * @memberof DropDownList
     */
    public otherParam:any;

    /**
     * 查询参数
     * @type {*}
     * @memberof DropDownList
     */
    public queryParam:any;

    /**
     * 当前选中值
     * @type {any}
     * @memberof DropDownList
     */
    @Model('change') readonly itemValue!: any;

    /**
     * 监控值变化，根据属性类型强制转换
     *
     * @memberof DropDownList
     */
    @Watch('itemValue',{
        immediate: true
    })
    public valueWatch() {
        try {
            this.readyValue();
            // 代码表集合中不存在改选项，重新准备集合
            if ((this.value == 0 || this.value) && !this.items.find((item: any) => Object.is(this.value, item.value))) {
                this.loadData();
            }
        } catch (error) {
            LogUtil.log(this.$t('components.dropdownlist.valueerror'));
        }
    }

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof DropDownList
     */
    @Prop() public tag?: string;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof DropDownList
     */
    @Prop() public codelistType?: string;

    /**
     * 代码表
     *
     * @type {string}
     * @memberof DropDownList
     */    
    @Prop() public codeList!: any;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof DropDownList
     */
    @Prop() public data?: any;

    /**
     * 表单状态对象
     *
     * @type {Subject<any>}
     * @memberof DropDownList
     */
    @Prop() public formState!: Subject<any>;

    /**
     * 值类型
     *
     * @type {*}
     * @memberof DropDownList
     */
    @Prop({ default: 'SIMPLE' })
    public valueType?: 'SIMPLE' | 'OBJECT';

    /**
     * 对象标识属性
     *
     * @type {*}
     * @memberof DropDownList
     */
    @Prop()
    public objectIdField?: string;

    /**
     * 对象名称属性
     *
     * @type {*}
     * @memberof DropDownList
     */
    @Prop()
    public objectNameField?: string;

    /**
     * 对象值属性
     *
     * @type {*}
     * @memberof DropDownList
     */
    @Prop()
    public objectValueField?: string;

    /**
     * 订阅对象
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof SelectType
     */
    protected formStateEvent: Subscription | undefined;

    /**
     * 局部上下文导航参数
     *
     * @type {*}
     * @memberof DropDownList
     */
    @Prop() public localContext!:any;
    
    /**
     * 局部导航参数
     *
     * @type {*}
     * @memberof DropDownList
     */
    @Prop() public localParam!:any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppAutocomplete
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop() public viewparams!: any;

    /**
     * 是否禁用
     * @type {any}
     * @memberof DropDownList
     * 
     */
    @Prop() public disabled?: any;

	/**
	 * 只读模式
	 * 
	 * @type {boolean}
	 */
	@Prop({default: false}) public readonly?: boolean;

    /**
     * 是否支持过滤
     * @type {boolean}
     * @memberof DropDownList
     */
    @Prop({ default: true })
    public filterable?: boolean;

    /**
     * 连接符 --级联选择器参数
     *
     * @type {string}
     * @memberof DropDownList
     */
     @Prop() public separator?: string;

    /**
     * 是否展示选中数据完整路径 --级联选择器参数
     *
     * @type {boolean}
     * @memberof DropDownList
     */
    @Prop() public showAllLevels?: boolean;

    /**
     * 是否支持清空
     * @type {boolean}
     * @memberof DropDownList
     */
    @Prop({ default: true })
    public clearable?: boolean;

    /**
     * 下拉选提示内容
     * @type {string}
     * @memberof DropDownList
     */
    @Prop() public placeholder?: string;

    /**
     * 属性类型
     *
     * @type {'string' | 'number'}
     * @memberof DropDownList
     */
    @Prop({ default: 'string' })
    public dataType!: 'string' | 'number';

    /**
     *  组件样式 | '联级' | '树' | '默认下拉'
     *
     * @type {boolean}
     * @memberof DropDownList
     */
    @Prop({default:'default'}) public editorStyle?: string | 'cascader' | 'tree' |'default';

    /**
     *  值项
     *
     * @type {string}
     * @memberof DropDownList
     */
    @Prop() valueitem?: string;

     /**
     * 选择实际值
     *
     * @type {*}
     * @memberof DropDownList
     */
    public value: any = null;

    /**
     * 代码表数据
     */
    public codeListData: any[] = [];

    /**
     * 计算属性(当前值)
     * @type {any}
     * @memberof DropDownList
     */
    set currentVal(val: any) {
        let value: any = null;
        if(Object.is(this.editorStyle,'cascader')){
            const value = JSON.stringify(val);
            this.$emit("change",  value );
            return
        }
        if(val && Object.is(this.editorStyle, 'tree')){
            let tempVal:any = JSON.parse(val);
            val = tempVal.length > 0 ? tempVal[0].value : null;
        }
        if (Util.isExistAndNotEmpty(val)) {
            const item = this.codeListData.find((item: any) => val == item.value);
            if (item) {
                if (this.valueType == 'OBJECT') {
                    value = this.handleObjectParams(item);
                } else {
                    value = item.value
                }
                if (this.valueitem) {
                    this.$emit('formitemvaluechange', { name: this.valueitem, value: item.value })
                }
            }
        }
        this.$emit('change', value);
    }

    /**
     * 获取值对象
     *
     * @memberof DropDownList
     */
    get currentVal() {
        if(Object.is(this.editorStyle,'cascader')){
            if (this.itemValue) {
                try {
                    return JSON.parse(this.itemValue);
                } catch {
                    return null;
                }
            }
            return this.itemValue;
        }
        if(this.itemValue && Object.is(this.editorStyle, 'tree')){
            let list:Array<any> = [];
            this.getItemList(list, this.items);
            let result: any = list.find((item:any) =>{
                return this.valueType == 'OBJECT' ? this.itemValue[this.objectIdField as string] : item.value == this.itemValue;
            })
            return !result ? null : JSON.stringify([result]);
        }
        return this.value;
    }

    /**
     * 处理对象类型参数
     * @param select 选中数据
     * @memberof DropDownList
     */
    public handleObjectParams = (select: any): any => {
        const object: any = { };
        if (this.objectNameField) {
            Object.assign(object, {
                [this.objectNameField]: select['text'],
            });
        }
        if (this.objectIdField) {
            Object.assign(object, {
                [this.objectIdField]: select['value'],
            });
        }
        if (this.objectValueField) {
            Object.assign(object, {
                [this.objectValueField]: Util.deepCopy(select),
            });
        }
        return object
    }

    /**
     * 获取代码表列表
     *
     * @memberof DropDownList
     */
    public getItemList(list:Array<any>,items:Array<any>){
        if(items && items.length >0){
            items.forEach((item:any) =>{
                if(item.children){
                    this.getItemList(list,item.children);
                }
                list.push(item);
            })
        }
    }

    /**
     * 代码表
     *
     * @type {any[]}
     * @memberof DropDownList
     */
    public items: any[] = [];

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof DropDownList
     */
    public handlePublicParams(arg: any) {
        // 合并表单参数
        arg.param = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        arg.context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length >0) {
            let _context = this.$util.computedNavData(this.data,arg.context,arg.param,this.localContext);
            Object.assign(arg.context,_context);
        }
        if (this.localParam && Object.keys(this.localParam).length >0) {
            let _param = this.$util.computedNavData(this.data,arg.context,arg.param,this.localParam);
            Object.assign(arg.param,_param);
        }
    }

    /**
     * vue  生命周期
     *
     * @memberof DropDownList
     */
    public created() {
        if(this.formState) {
            this.formStateEvent = this.formState.subscribe(({ type, data }) => {
                if (Object.is('load', type)) {
                    this.loadData();
                    this.readyValue();
                }
            });
        }
        if(this.itemValue){
            this.loadData();
        }
        this.readyValue();
    }

    /**
     * 加载数据
     *
     * @memberof DropDownList
     */
    public loadData(){
        if(this.tag && this.codelistType) {
            let data: any = {};
            this.handlePublicParams(data);
            // 参数处理
            let context = data.context;
            let viewparam = data.param;
            this.codeListService.getDataItems({ tag: this.tag, type: this.codelistType,data: this.codeList,context:context,viewparam:viewparam}).then((codelistItems: Array<any>) => {
                this.codeListData = Util.deepCopy(codelistItems);
                this.formatCodeList(codelistItems);
            }).catch((error: any) => {
                LogUtil.log(`----${this.tag}----${this.$t('app.commonwords.codenotexist')}`);
            })
        }
    }

    /**
     * 准备值
     *
     * @memberof DropDownList
     */
    public readyValue() {
        if (this.itemValue == null) {
            this.value = null;
            return;
        }
        let value: any = this.valueType == 'OBJECT' ? this.itemValue[this.objectIdField as string] : this.itemValue;
        if (this.$util.typeOf(value) === this.dataType) {
            this.value = value;
        } else if (this.dataType === 'number') {
            if (value.indexOf('.') === -1) {
                this.value = parseInt(value);
            } else {
                this.value = parseFloat(value);
            }
        } else {
            this.value = value.toString();
        }
    }
    
    /**
     * 下拉点击事件
     *
     * @param {*} $event
     * @memberof DropDownList
     */
    public onClick($event:any){
        if($event){
            this.loadData();
        }
    }

    /**
     * 代码表类型和属性匹配
     * 
     * @param {*} items
     * @memberof DropDownList
     */
    public formatCodeList(items: Array<any>){
        let matching: boolean = false;
        this.items = [];
        try{
            items.forEach((item: any)=>{
                const type = this.$util.typeOf(item.value);
                if(type != this.dataType){
                    matching = true;
                    if(type === 'number'){
                        item.value = item.value.toString();
                    }else{
                        if(type == "null") {
                            this.dataType == "number" ? item.value = 0 : item.value = '';
                        }else if(item.value.indexOf('.') == -1){
                            item.value = parseInt(item.value);
                        }else{
                            item.value = parseFloat(item.value);
                        }
                    }
                }
                this.items.push(item);
            });
            if(matching){
                LogUtil.warn(`${ this.tag }${this.$t('app.commonwords.codelistwarn')}`);
            }
            
        }catch(error){
            LogUtil.warn(this.$t('app.commonwords.codelistwarn'));
        }
        this.handleLevelCodeList(Util.deepCopy(this.items));
    }

    /**
     * 处理层级代码表
     * 
     * @param {*} items
     * @memberof DropDownList
     */
    public handleLevelCodeList(items: Array<any>){
        if(items && items.length >0){
            const hasChildren = items.some((item:any) =>{
                return item.pvalue;
            })
            if(hasChildren){
                let list:Array<any> = [];
                items.forEach((codeItem:any) =>{
                    if(!codeItem.pvalue){
                        let valueField:string = codeItem.value;
                        this.setChildCodeItems(valueField,items,codeItem);
                        list.push(codeItem);
                    }
                })
                this.items = list;
            }
        }
    }

    /**
     * 计算子类代码表
     * 
     * @param {*} items
     * @memberof DropDownList
     */
    public setChildCodeItems(pValue:string,result:Array<any>,codeItem:any){
        result.forEach((item:any) =>{
            if(item.pvalue == pValue){
                let valueField:string = item.value;
                this.setChildCodeItems(valueField,result,item);
                if(!codeItem.children){
                    codeItem.children = [];
                }
                codeItem.children.push(item);
            }
        })
    }

    /**
     * vue 生命周期
     *
     * @memberof DropDownList
     */
    public destroyed() {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 下拉列表多选点击
     * 
     * @param {*} items
     * @memberof DropDownList
     */
     public click(){
        this.$emit('click',this.currentVal)
    }

    /**
     * 处理下拉变化
     *
     * @param {boolean} value
     * @memberof AppAddressCascader
     */
     public onChange(value: boolean) {
        if (value) {
            this.loadData();
        }
    }

}
</script>