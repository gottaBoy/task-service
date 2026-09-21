<template>
    <div class="app-input-box" :id="maxlengthAppendId">
        <InputNumber
            v-if="type === 'number'"
            :id="numberId"
            :placeholder="placeholder"
            :formatter="numberFormat"
            :size="size"
            :max="max"
            :min="min"
            :readonly="readonly"
            :precision="precision"
            v-model="CurrentVal"
            :disabled="disabled ? true : false"
            :active-change="false"
            @on-blur="blur"
        ></InputNumber>
        <i-input
            v-else
            :placeholder="placeholder"
            :class="{ 'is-disabled': disabled }"
            :size="size"
            :type="type"
            :rows="rows"
            :password="type == 'password' && enableShowPwd"
            :readonly="readonly"
            :maxlength="maxlength"
            :show-word-limit="showWordLimit"
            v-model="CurrentVal"
            :disabled="disabled ? true : false"
            :element-id="textareaId"
            @on-enter="enter"
            @on-blur="blur"
            @on-focus="focus"
        >
            <template v-if="append" #append>
                <span>{{ append }}</span>
            </template>
            <template v-if="prepend" #prepend>
                <span>{{ prepend }}</span>
            </template>
        </i-input>
        <div class="unit-text">{{ unit }}</div>
    </div>
</template>

<script lang="ts">
import { Util, debounce } from "ibiz-core";
import { Vue, Component, Prop, Model, Emit } from "vue-property-decorator";

@Component({})
export default class InputBox extends Vue {
    /**
     * 双向绑定值
     * @type {any}
     * @memberof InputBox
     */
    @Model("change") readonly itemValue?: any;

    /**
     * 单位
     * @type {String}
     * @memberof InputBox
     */
    @Prop() public unit?: string;

    /**
     * 多行文本十行 特殊参数样式（模型高度自带）
     * @type {*}
     * @memberof InputBox
     */
    @Prop() public textareaStyle?: any;

    /**
     * 多行文本十行 特殊参数id（模型高度自带）
     * @type {String}
     * @memberof InputBox
     */
    @Prop() public textareaId?: string;

    /**
     * 大小
     * @type {String}
     * @memberof InputBox
     */
    @Prop() public size?: string;

    /**
     * 最大值
     * @type {Number}
     * @memberof InputBox
     */
    @Prop() public max?: number;

    /**
     * 最小值
     * @type {Number}
     * @memberof InputBox
     */
    @Prop() public min?: number;

    /**
     * placeholder值
     * @type {String}
     * @memberof InputBox
     */
    @Prop() public placeholder?: string;

    /**
     * 是否禁用
     * @type {boolean}
     * @memberof InputBox
     */
    @Prop() public disabled?: boolean;

    /**
     * 只读模式
     *
     * @type {boolean}
     */
    @Prop({ default: false }) public readonly?: boolean;

    /**
     * 属性类型
     *
     * @type {string}
     * @memberof InputBox
     */
    @Prop() public type?: string;

    /**
     * 文本行数
     * @type {String}
     * @memberof InputBox
     */
    @Prop({ default: 2 }) public rows?: number;

    /**
     * 精度
     *
     * @type {number}
     * @memberof InputBox
     */
    @Prop({ default: 0 }) public precision?: number;

    /**
     * 数值格式化
     *
     * @type {string}
     * @memberof InputBox
     */
    @Prop() public valueFormat?: any;

    /**
     * 是否启用防抖
     *
     * @type {Boolean}
     * @memberof InputBox
     */
    @Prop({ default: true }) public isDebounce?: Boolean;

    /**
     * 密码框是否启用显示值切换图标
     *
     * @type {Boolean}
     * @memberof InputBox
     */
    @Prop({ default: false }) public enableShowPwd!: Boolean;

    /**
     * 输入内容最大长度
     *
     * @type {string}
     * @memberof InputBox
     */
    @Prop() public maxlength?: number;

    /**
     * 输入内容前缀
     *
     * @type {string}
     * @memberof InputBox
     */
    @Prop() public prepend?: any;

    /**
     * 输入内容后缀
     *
     * @type {string}
     * @memberof InputBox
     */
    @Prop() public append?: any;

    /**
     * 是否显示输入内容最大长度
     *
     * @type {string}
     * @memberof InputBox
     */
    @Prop() public showWordLimit?: boolean;

    /**
     * 多行文本类型下最小行数
     *
     * @type {string}
     * @memberof InputBox
     */
    @Prop() public minRows?: number;

    /**
     * 多行文本类型下最大行数
     *
     * @type {string}
     * @memberof InputBox
     */
    @Prop() public maxRows?: number;

    /**
     * 多行文本行数
     *
     * @type {string}
     * @memberof InputBox
     */
    public autoSize: any = {};

    /**
     * 数值框numberId
     */
    public numberId: string = this.$util.createUUID();

    //当同时存在最长长度与后缀词时，input组件的id
    public maxlengthAppendId: string = this.$util.createUUID();

    /**
     * 当前值
     *
     * @memberof InputBox
     */
    get CurrentVal() {
        if (
            Object.is(this.type, "number") &&
            this.itemValue &&
            !isNaN(this.itemValue)
        ) {
            return Number(this.itemValue);
        } else {
            return !this.itemValue && this.itemValue != 0
                ? null
                : this.itemValue;
        }
    }

    /**
     * 值变化
     *
     * @memberof InputBox
     */
    set CurrentVal(val: any) {
        let _data: any = val;
        if (
            Object.is(this.type, "number") &&
            Util.isExistAndNotEmpty(val) &&
            !isNaN(val)
        ) {
            try {
                _data = isNaN(Number(val)) ? null : Number(val);
            } catch (error) {}
        }
        if (Object.is(_data, "")) {
            _data = null;
        }
        if (this.isDebounce) {
            debounce(this.emitChangeEvent, [_data], this, 300);
        } else {
            this.emitChangeEvent(_data);
        }
    }

    /**
     * 生命周期
     * @type {any}
     * @memberof InputBox
     */
    public created() {
        if (this.minRows) {
            this.autoSize.minRows = this.minRows;
        }
        if (this.minRows) {
            this.autoSize.maxRows = this.maxRows;
        }
    }

    /**
     * 生命周期 （多行文本高度问题）
     * @type {any}
     * @memberof InputBox
     */
    public mounted() {
        if (this.textareaId) {
            let textarea: any = document.getElementById(this.textareaId);
            if (textarea && this.textareaStyle) {
                Object.keys(this.textareaStyle).forEach((key: string) => {
                    textarea.style[key] = this.textareaStyle[key]
                }) 
            }
        }
        if (this.showWordLimit && (this.append || this.prepend)) {
            this.setAppendStyle();
        }
    }

    /**
     * 触发change事件
     *
     * @param {*} data
     * @memberof InputBox
     */
    emitChangeEvent(data: any) {
        this.$emit("change", data);
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof InputBox
     */
    @Emit()
    public enter($event: any) {
        if (!$event || $event.keyCode !== 13) {
            return;
        }
        return this.CurrentVal;
    }

    /**
     * 失去焦点事件
     *
     * @param {*} $event
     * @memberof InputBox
     */
    @Emit()
    public blur(event: any) {
        return this.CurrentVal;
    }

    /**
     * 聚焦事件
     *
     * @param {*} $event
     * @memberof InputBox
     */
    @Emit()
    public focus(event: any) {
        return this.CurrentVal;
    }

    /**
     * 数值值格式化
     *
     * @param {*} value
     * @memberof InputBox
     */
    public numberFormat(value: any) {
        if (!this.valueFormat) {
            return value;
        }
        const _this: any = this;
        if (
            !isNaN(parseFloat(value)) &&
            _this.textFormat &&
            _this.textFormat instanceof Function
        ) {
            return _this.textFormat(parseFloat(value), _this.valueFormat);
        }
        return value;
    }

    /**
     * 当同时设置了前缀(或后缀词)与显示最长长度时,或同时拥有单位以及后缀等情况
     * 动态重新设置样式，iview原本的样式不支持同时设置
     *
     * @memberof InputBox
     */
    public setAppendStyle() {
        if (Object.is(this.type, "text") || Object.is(this.type, "textarea")) {
            this.$nextTick(() => {
                let input: any = document.getElementById(
                    this.maxlengthAppendId
                );
                if (input) {
                    let appendEle = input.querySelector(".ivu-input-group-append");
                    let maxlengthEle = input.querySelector(".ivu-input-word-count");
                    let unitEle = input.querySelector(".unit-text");
                    let appendEleWidth = null;
                    let maxlengthEleWidth = null;
                    if (appendEle) {
                        appendEleWidth = window
                            .getComputedStyle(appendEle)
                            .getPropertyValue("width");
                    }
                    if (maxlengthEle) {
                        maxlengthEleWidth = window
                            .getComputedStyle(maxlengthEle)
                            .getPropertyValue("width");
                    }
                    const setEleStyle = (ele: any) => {
                        ele.style.paddingRight = "5px";
                        ele.style.marginRight = "1px";
                        ele.style.zIndex = "10";
                    };
                    if (appendEleWidth && maxlengthEleWidth) {
                        const width =
                            Number(appendEleWidth.slice(0, -2)) +
                            Number(maxlengthEleWidth.slice(0, -2));
                        maxlengthEle.style.right = appendEleWidth;
                        unitEle.style.right = width + "px";
                    } else if (appendEleWidth) {
                        unitEle.style.right = appendEleWidth;
                    } else if (maxlengthEleWidth) {
                        maxlengthEle.style.right = maxlengthEleWidth;
                    }
                    setEleStyle(unitEle);
                    setEleStyle(maxlengthEle);
                    if (this.prepend) {
                        maxlengthEle.style.zIndex = "10";
                    }
                }
            });
        }
    }
}
</script>