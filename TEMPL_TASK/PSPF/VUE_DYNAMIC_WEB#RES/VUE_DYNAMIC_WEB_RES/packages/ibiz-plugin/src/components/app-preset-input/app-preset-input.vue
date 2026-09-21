<template>
    <div class="app-preset-input">
        <i-input size="default" v-model="curValue" :type="curType" :disabled="disabled" :placeholder="curPlaceHolder"
            :password="curType == 'password' && enableShowPwd" @on-blur="valueChange">
        </i-input>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppPreSetInput extends Vue {
    /**
     * 输入值
     *
     * @type {*}
     * @memberof AppPreSetInput
     */
    @Prop() public value!: any;

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppPreSetInput
     */
    @Prop() public name!: string;

    /**
     * 类型
     *
     * @type {string}
     * @memberof AppPreSetInput
     */
    @Prop() public type?: string;

    /**
     * 禁用
     *
     * @type {boolean}
     * @memberof AppPreSetInput
     */
    @Prop() public disabled?: boolean;

    /**
     * 密码框是否启用显示值切换图标
     *
     * @type {boolean}
     * @memberof AppPreSetInput
     */
    @Prop({ default: false }) public enableShowPwd!: boolean;

    /**
     * 占位文本
     *
     * @type {string}
     * @memberof AppPreSetInput
     */
    @Prop() public placeholder?: any;

    /**
     * 当前占位文本
     *
     * @type {string}
     * @memberof AppPreSetInput
     */
    get curPlaceHolder() {
        if (this.placeholder) {
            return this.placeholder;
        } else {
            if (Object.is(this.type, 'AUTH_USERID')) {
                return '请输入登录账号';
            } else if (Object.is(this.type, 'AUTH_PASSWORD')) {
                return '请输入密码';
            } else {
                return '';
            }
        }
    }

    /**
     * 当前类型
     *
     * @type {string}
     * @memberof AppPreSetInput
     */
    get curType() {
        if (Object.is(this.type, 'AUTH_PASSWORD')) {
            return 'password';
        } else {
            return 'text';
        }
    }

    /**
     * 当前值
     *
     * @memberof AppPreSetInput
     */
    public curValue: any;


    /**
     * 值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPreSetInput
     */
    @Watch('value', { immediate: true })
    public onValueChange(newVal: any, oldVal: any) {
        this.curValue = newVal;
    }

    /**
     * 值变化
     *
     * @memberof AppPreSetInput
     */
    public valueChange() {
        this.$emit('valueChange', { name: this.name, value: this.curValue });
    }
}
</script>

<style lang='less'>
@import './app-preset-input.less';
</style>