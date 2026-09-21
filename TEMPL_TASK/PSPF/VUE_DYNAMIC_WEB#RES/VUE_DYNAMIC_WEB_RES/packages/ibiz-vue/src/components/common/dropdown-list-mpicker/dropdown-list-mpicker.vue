<template>
    <div class="dropdown-list-mpicker">
        <i-select
            v-if="'default' == editorStyle"
            class='dropdown-list-mpicker__select'
            multiple 
            :transfer="true"
            transfer-class-name="dropdown-list-mpicker__transfer"
            v-model="currentVal"
            :disabled="disabled || readonly"
            :clearable="clearable"
            :filterable="filterable"
            @on-open-change="onClick"
            :placeholder="placeholder?placeholder:$t('components.dropdownlistMpicker.placeholder')">
            <i-option v-for="(item, index) in items" :key="index" :class="item.class" :value="item.value ? item.value.toString():''" :label="item.text">
                <Checkbox :value="(currentVal.indexOf(item.value ? item.value.toString() : '')) == -1 ? false : true">
                    {{item.text}}
                </Checkbox>
            </i-option>
        </i-select>
        <app-select-tree v-else-if="'tree' == editorStyle" class="dropdown-list-mpicker__tree" :disabled="disabled" :NodesData="items" v-model="currentVal" :multiple="true"></app-select-tree>
        <el-cascader
                class="dropdown-list-mpicker__cascader"
                v-else-if="'cascader' == editorStyle"
                :disabled="disabled"
                size="medium"
                :placeholder="placeholder"
                v-model="currentVal"
                :options="items"
                :clearable="clearable"
                :separator="valueSeparator"
                :show-all-levels="showAllLevels"
                :props="{ multiple: true }"
                :filterable="filterable"
                @visible-change="onChange"
            >
        </el-cascader>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Watch } from 'vue-property-decorator';
import { CodeListService, LogUtil, Util } from 'ibiz-core';

@Component({
})
export default class DropDownListMpicker extends Vue {
    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof DropDownListMpicker
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 当前选中值
     * @type {any}
     * @memberof DropDownListMpicker
     */
    @Model('change') readonly itemValue!: any;

    /**
     * 代码表标识
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() public tag?: string;

    /**
     * 代码表类型
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() public codelistType?: string;

    /**
     * 代码表
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */    
    @Prop() public codeList!: any;

    /**
     * 代码表值分隔符
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop({default:','}) public valueSeparator?: string;

    /**
     * 是否禁用
     * @type {any}
     * @memberof DropDownListMpicker
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
     * @memberof DropDownListMpicker
     */
     @Prop({ default: true })
    public filterable?: boolean;

    /**
     * 是否支持清空
     * @type {boolean}
     * @memberof DropDownListMpicker
     */
    @Prop({ default: true })
    public clearable?: boolean;

    /**
     * 下拉选提示内容
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() public placeholder?: string;

    /**
     * 属性类型
     *
     * @type {'string' | 'number'}
     * @memberof DropDownListMpicker
     */
    @Prop({ default: 'string' })
    public dataType!: 'string' | 'number';

    /**
     * 局部上下文导航参数
     * 
     * @type {any}
     * @memberof DropDownListMpicker
     */
    @Prop() public localContext!:any;

    /**
     * 局部导航参数
     * 
     * @type {any}
     * @memberof DropDownListMpicker
     */
    @Prop() public localParam!:any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop() public viewparams!: any;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop() public data?: any;

    /**
     *  组件样式 | '联级' | '树' | '默认下拉'
     *
     * @type {boolean}
     * @memberof DropDownListMpicker
     */
    @Prop({default:'default'}) public editorStyle?: string | 'cascader' | 'tree' |'default';

    /**
     * 是否展示选中数据完整路径
     *
     * @type {boolean} 联级选择器参数
     * @memberof DropDownListMpicker
     */
    @Prop() public showAllLevels?: boolean;
    
    /**
     * 值类型
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop({ default: 'SIMPLE' })
    public valueType?: 'SIMPLE' | 'OBJECTS';

    /**
     * 对象标识属性
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop()
    public objectIdField?: string;

    /**
     * 对象名称属性
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop()
    public objectNameField?: string;

    /**
     * 对象值属性
     *
     * @type {*}
     * @memberof DropDownListMpicker
     */
    @Prop()
    public objectValueField?: string;

    /**
     *  值项
     *
     * @type {string}
     * @memberof DropDownListMpicker
     */
    @Prop() valueitem?: string;

    /**
     * 代码表数据
     */
    public codeListData: any[] = [];

    /**
     * 计算属性(当前值)
     * @type {any}
     * @memberof DropDownListMpicker
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
            if(tempVal.length >0){
                val = tempVal.map((item:any) =>{
                    return item.value;
                })
            }
        }
        if (val && val.length > 0) {
            value = [];
            const valueitem: any[] = [];
            val.forEach((_value: string) => {
                const item = this.codeListData.find((item: any) => _value == item.value);
                if (item) {
                    if (this.valueType == 'OBJECTS') {
                        value.push(this.handleObjectParams(item));
                    } else {
                        value.push(item.value)
                    }
                    valueitem.push(item.value);
                }
            })
            if (this.valueitem) {
                this.$emit('formitemvaluechange', { name: this.valueitem, value: valueitem.join(this.valueSeparator) })
            }
        }
        if (value && value.length > 0 && this.valueType !== 'OBJECTS') {
            value = value.join(this.valueSeparator);
        }
        this.$emit('change', value);
    }

    /**
     * 获取值对象
     *
     * @memberof DropDownListMpicker
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
        let value: any[] = [];
        if (this.valueType == 'OBJECTS') {
            this.itemValue.forEach((item: any) => {
                value.push(item[this.objectIdField as string])
            })
        } else {
            value = this.itemValue?.split(this.valueSeparator)
        }
        if(Object.is(this.editorStyle,'tree')){
            if(this.itemValue){
                let list:Array<any> = [];
                let selectedvalueArray:Array<any> = [];
                let curSelectedValue:Array<any> = value;
                this.getItemList(list,this.items);
                if(curSelectedValue.length > 0){
                    curSelectedValue.forEach((selectedVal:any) =>{
                        let tempResult:any = list.find((item:any) =>{
                            return item.value == selectedVal;
                        })
                        selectedvalueArray.push(tempResult);
                    })
                }
                return selectedvalueArray.length >0?JSON.stringify(selectedvalueArray):null;
            }else{
                return null;
            }

        }
        return value ? value : [];
    }

    /**
     * 处理对象类型参数
     * @param select 选中数据
     * @memberof DropDownListMpicker
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
     * @memberof DropDownListMpicker
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
     * @memberof DropDownListMpicker
     */
    public items: any[] = [];

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof DropDownList
     */
    public handlePublicParams() {
        // 合并表单参数
        let viewparams = this.viewparams ? JSON.parse(JSON.stringify(this.viewparams)) : {};
        let context = this.context ? JSON.parse(JSON.stringify(this.context)) : {};
        // 附加参数处理
        if (this.localContext && Object.keys(this.localContext).length >0) {
            let _context = this.$util.computedNavData(this.data,context,viewparams,this.localContext);
            Object.assign(context,_context);
        }
        if (this.localParam && Object.keys(this.localParam).length >0) {
            let _param = this.$util.computedNavData(this.data,context,viewparams,this.localParam);
            Object.assign(viewparams,_param);
        }
        return {context,viewparams};
    }

    /**
     * 监听值的变化，最初一次变化且代码表没初始化时，初始化代码表
     * @param newVal 
     * @param oldVal 
     */
    @Watch("itemValue",{immediate: true})
    onChange(newVal: any, oldVal: any){
      if(!this.isInit){
        this.handleCodeListItems();
      }
    }

    /**
     * 是否已经初始化
     *
     * @memberof DropDownListMpicker
     */
    isInit: boolean = false;

    /**
     * vue  生命周期
     *
     * @memberof DropDownListMpicker
     */
    public created() {
        if(this.itemValue){
            this.handleCodeListItems();
        }
    }

    /**
     * 代码表类型和属性匹配
     * 
     * @param {*} items
     * @memberof DropDownListMpicker
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
     * 处理代码表
     * 
     * @memberof DropDownListMpicker
     */
    public handleCodeListItems() {
        let arg = this.handlePublicParams();
        if(this.tag && this.codelistType) {
            this.isInit = true;
            this.codeListService.getDataItems({ tag: this.tag, type: this.codelistType,data: this.codeList,context:arg.context,viewparam:arg.viewparams }).then((codelistItems: Array<any>) => {
                this.codeListData = Util.deepCopy(codelistItems);
                this.formatCodeList(codelistItems);   
            }).catch((error: any) => {
                LogUtil.log(`----${this.tag}----${(this.$t('app.commonwords.codenotexist') as string)}`);
            })
        }
    }
    
    /**
     * 下拉点击事件
     *
     * @param {*} $event
     * @memberof DropDownListMpicker
     */
    public onClick($event:any){
        if($event){
            this.handleCodeListItems();
        }
    }

    /**
     * 处理层级代码表
     * 
     * @param {*} items
     * @memberof DropDownListMpicker
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
     * @memberof DropDownListMpicker
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

}
</script>