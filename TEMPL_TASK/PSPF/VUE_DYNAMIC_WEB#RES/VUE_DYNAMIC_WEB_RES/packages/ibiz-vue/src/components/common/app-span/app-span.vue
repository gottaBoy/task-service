<template>
    <codelist
        v-if="codeList"
        :codeList="codeList"
        :value="value"
        :data="data"
        ref="codelist"
        :localContext="localContext"
        :localParam="localParam"
        :context="context"
        :translatorMode="showSourceMode"
        :viewparams="viewparams"
    ></codelist>
    <app-upload-file-info
        v-else-if="
            Object.is(this.editorType, 'PICTURE') ||
            Object.is(this.editorType, 'PICTURE_ONE') ||
            Object.is(this.editorType, 'FILEUPLOADER')
        "
        :value="value"
        :name="name"
    />
    <span class="app-span" :title="text" v-else>
        <span v-if="!text && text !== 0 && !unitName && Object.is('STYLE1', noValueShowMode)">- - -</span>
        <span v-else-if="textFormat">
            <span class="app-span-value-format" v-format="textFormat">{{ text }}</span>
        </span>
        <span v-else class="app-span--no-textFormat">
            {{ text + '&nbsp;' + (unitName ? unitName : '') }}
        </span>
    </span>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import moment from 'moment';
import { Util } from 'ibiz-core';
@Component({})
export default class AppSpan extends Vue {
    /**
     * 当前值
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public value?: any;

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
     * 当前表单项名称
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public name?: any;

    /**
     * 代码表模型
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public codeList?: any;

    /**
     * 显示模式(为true不做翻译，直接显示值，配合codelist使用)
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop({ default: false }) public showSourceMode?: boolean;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public data?: any;

    /**
     * 局部上下文导航参数
     *
     * @type {any}
     * @memberof AppSpan
     */
    @Prop() public localContext!: any;

    /**
     * 局部导航参数
     *
     * @type {any}
     * @memberof AppSpan
     */
    @Prop() public localParam!: any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop() public viewparams!: any;

    /**
     * 无值显示模式
     *
     * @type {boolean}
     * @memberof AppSpan
     */
    @Prop({ default: 'DEFAULT' }) public noValueShowMode?: 'DEFAULT' | 'STYLE1';

    /**
     * 值类型
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop({ default: 'SIMPLE' })
    public valueType!: 'SIMPLE' | 'SIMPLES' | 'OBJECT' | 'OBJECTS';

    /**
     * 文本分隔符
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop({ default: ',' })
    public textSeparator?: string;

    /**
     * 对象标识属性
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop()
    public objectIdField?: string;

    /**
     * 对象名称属性
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop()
    public objectNameField?: string;

    /**
     * 对象值属性
     *
     * @type {*}
     * @memberof AppSpan
     */
    @Prop()
    public objectValueField?: string;

    /**
     * 应用实体主信息属性名称
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop({ default: 'srfmajortext' }) public deMajorField!: string;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop({ default: 'srfkey' }) public deKeyField!: string;

    /**
     * 监控表单属性 data 值
     *
     * @memberof AppSpan
     */
    @Watch('value')
    onDataChange(newVal: any, oldVal: any) {
        if (newVal !== oldVal) {
            this.load();
        }
    }

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
     * 编辑器类型
     *
     * @type {string}
     * @memberof AppSpan
     */
    @Prop() public editorType?: string;

    /**
     * vue  生命周期
     *
     * @memberof AppSpan
     */
    public created() {
        this.load();
    }

    /**
     * 处理数据
     *
     * @memberof AppSpan
     */
    public load() {
        if (!this.codeList) {
            if (Util.isEmpty(this.value)) {
                this.text = '';
            } else {
                this.handleData();
            }
            this.formatData();
        }
    }

    /**
     * 处理值类型
     *
     * @memberof AppSpan
     */
    public handleValueType() {
        let value: any;
        if (this.value) {
            if (this.valueType == 'SIMPLES') {
                this.text = this.value.join(this.textSeparator);
            } else if (this.valueType == 'OBJECT') {
                this.text = this.value[this.objectNameField ? this.objectNameField : this.deMajorField];
            } else if (this.valueType == 'OBJECTS') {
                value = [];
                this.value.forEach((_item: any) => {
                    value.push(_item[this.objectNameField ? this.objectNameField : this.deMajorField]);
                });
                this.text = value.join(this.textSeparator);
            } else {
                // 解析地址选择器的JSON字符串数据
                if (this.editorType === 'ADDRESSPICKUP') {
                    value = [];
                    const items: any[] = JSON.parse(this.value);
                    items.forEach((_item: any) => {
                        value.push(_item[this.objectNameField ? this.objectNameField : this.deMajorField]);
                    });
                    this.text = value.join(this.textSeparator);
                } else {
                    this.text = this.value;
                }
            }
        } else {
            this.text = this.value;
        }
    }

    /**
     * 处理数据
     *
     * @memberof AppSpan
     */
    public handleData() {
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
            this.handleValueType();
        }
    }

    /**
     * 数据格式化
     *
     * @memberof AppSpan
     */
    public formatData() {
        if (this.valueFormat) {
            if (Object.is(this.getDataType(), 'DATETIME')) {
                this.text = moment(this.value).format(this.valueFormat);
            } else {
                this.textFormat = this.unitName ? this.valueFormat + '_' + this.unitName : this.valueFormat;
                //vue-text-format插件重复值修复
                if (this.valueFormat.includes('*')) {
                    this.$nextTick(() => {
                        const el: any = this.$el.getElementsByClassName('vue-format-single-fill')[0];
                        el.innerHTML = el.innerHTML.repeat(el.offsetWidth);
                    });
                }
            }
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
            (this.dataType == 'DATETIME' ||
                this.dataType == 'DATE' ||
                this.dataType == 'TIME' ||
                this.dataType == 'SMALLDATETIME')
        ) {
            //  日期格式统一处理
            return 'DATETIME';
        } else {
            return this.dataType;
        }
    }
}
</script>