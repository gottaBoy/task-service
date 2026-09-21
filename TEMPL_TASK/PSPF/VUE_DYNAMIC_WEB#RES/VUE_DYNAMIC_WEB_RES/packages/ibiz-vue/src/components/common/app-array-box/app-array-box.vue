<template>
    <div :class="{'app-array-box': true, 'is-disabled': disabled || readonly}">
        <template v-if="items.length == 0">
            <Icon class="app-array-box__icon" type="md-add" @click="addItem()" />
        </template>
        <template v-else>
            <div v-for="(item, index) in items" :key="item.key" class="app-array-box__item">
                <input-box 
                    v-if="Object.is(editorStyle, 'default')" 
                    :type="type" 
                    :size="size" 
                    v-model="item.value"
                    :placeholder="placeholder" 
                    :class="{'app-inupt-box--correct': item.correct}"
                    :disabled="disabled || readonly"
                    @enter="enter"
                    @blur="blur"
                    @focus="focus" 
                    @change="(value) => handleChange(value, index)" />
                <Tooltip
                    v-else
                    :disabled="!item.value || disabled || readonly"
                    placement="bottom"
                    trigger="hover">
                    <input-box 
                        type="text"
                        :size="size" 
                        v-model="item.value"
                        :placeholder="placeholder"
                        :disabled="disabled || readonly"
                        :class="{'app-inupt-box--correct': item.correct}"
                        :prepend="Object.is(editorStyle, 'url') ? prepend : null" 
                        :append="Object.is(editorStyle, 'url') ? append : null"
                        :maxlength="Object.is(editorStyle, 'url') ? maxlength : null"
                        :showWordLimit="Object.is(editorStyle, 'url') ? showWordLimit : null"
                        @enter="enter"
                        @blur="blur"
                        @focus="focus"
                        @change="(value) => handleChange(value, index)" />
                    <template #content>
                        <el-image v-if="Object.is(editorStyle, 'img')" :src="item.value">
                            <div slot='error' class='image-slot'>
                                <img src="/assets/img/picture.png">
                            </div>
                        </el-image>
                        <el-link v-else type="primary" :href="getUrl(item.value)" :target="target">{{getUrl(item.value)}}</el-link>
                    </template>
                </Tooltip>
                <div v-if="!(disabled || readonly)" class="app-array-box__icons">
                    <Icon v-if="!limit || items.length < limit" class="app-array-box__icon" type="md-add" @click="addItem(index + 1)" />
                    <Icon class="app-array-box__icon" type="md-remove" @click="removeItem(index)" />
                </div>
            </div>
        </template>
    </div>
</template>

<script lang="ts">
import { Util } from 'ibiz-core';
import schema from 'async-validator';
import { Vue, Component, Prop, Watch, Emit } from "vue-property-decorator";

@Component({})
export default class AppArrayBox extends Vue {

    /**
     * 名称
     * 
     * @type {string}
     * @memberof AppArrayBox
     */
    @Prop() public name!: string;

    /**
     * 传入值
     * 
     * @type {string[] | number[]}
     * @memberof AppArrayBox
     */
    @Prop() public value!: string[] | number[];

    /**
     * 编辑器样式
     * 
     * @type {'default' | 'img' | 'url'}
     * @memberof AppArrayBox
     */
    @Prop({ default: 'default' }) public editorStyle!:  'default' | 'img' | 'url';

    /**
     * 输入框类型
     * 
     * @type {'text' | 'number'}
     * @memberof AppArrayBox
     */
    @Prop({ default: 'text' }) type!: 'text' | 'number';

    /**
     * placeholder值
     * 
     * @type {String}
     * @memberof AppArrayBox
     */
    @Prop() public placeholder?: string;

    /**
     * 是否禁用
     * 
     * @type {boolean}
     * @memberof AppArrayBox
     */
    @Prop() public disabled?: boolean;

    /**
     * 是否只读
     * 
     * @type {boolean}
     * @memberof AppArrayBox
     */
    @Prop() public readonly?: boolean;

    /**
     * 大小
     *
     * @type {string}
     * @memberof AppArrayBox
     */
    @Prop() public size?: string;

    /**
     * 数组大小限制
     *
     * @type {string}
     * @memberof AppArrayBox
     */
    @Prop({ default: 0 }) public limit?: number;

    /**
     * 输入内容最长长度
     * 
     * @type {number}
     * @memberof AppArrayBox
     */
    @Prop() public maxlength?: number;

    /**
     * 是否显示输入内容长度
     * 
     * @type {boolean}
     * @memberof AppArrayBox
     */
    @Prop() public showWordLimit?: boolean;

    /**
     * 输入内容前缀
     *
     * @type {string}
     * @memberof AppArrayBox
     */
    @Prop() public prepend?: any;

    /**
    * 输入内容后缀
    *
    * @type {string}
    * @memberof AppArrayBox
    */
    @Prop() public append?: any;

    /**
    * 超链接打开方式
    *
    * @type {'_blank' | '_self' | '_parent' | '_top' | 'framename'}
    * @memberof AppArrayBox
    */
    @Prop({ default: '_blank' }) public target!: '_blank' | '_self' | '_parent' | '_top' | 'framename';

    /**
    * 值规则
    *
    * @type {any[]}
    * @memberof AppArrayBox
    */
    @Prop() public rules?: any[];

    /**
    * 输入内容项集合
    *
    * @type {Array}
    * @memberof AppArrayBox
    */
    public items: any[] = [];

    @Watch('value')
    onValueChange(newVal: string[] | number[]) {
        if (newVal) {
            if (this.items.length == 0) {
                const items = newVal.map((value: any) => {return {value, key: Util.createUUID()}});
                this.items = items;
            }
        }
    }

    /**
    * 校验值
    *
    * @param value 值
    * @memberof AppArrayBox
    */
    public async validate(value: string): Promise<boolean> {
        if (this.rules && this.rules.length > 0) {
            const validator = new schema({ [this.name]: this.rules });
            try {
                await validator.validate({ [this.name]: value });
                return true;
            } catch (error) {
                return false
            }
        }
        return true;
    }

    /**
    * 获取Url路径
    *
    * @param value url值
    * @memberof AppArrayBox
    */
    public getUrl(value: string): string {
        let tempValue = value;
        if (tempValue) {
            if (this.prepend) {
                tempValue = this.prepend + tempValue;
            }
            if (this.append) {
                tempValue = tempValue + this.append;
            }
        }
        return tempValue;
    }

    /**
    * 新增项
    *
    * @param index 添加索引
    * @memberof AppArrayBox
    */
    public addItem(index?: number) {
        if (this.disabled || this.readonly) {
            return;
        }
        const tempLink = {
            key: Util.createUUID(),
            value: null
        }
        if (index) {
            this.items.splice(index, 0, tempLink);
        } else {
            this.items.push(tempLink);
        }
        this.onEmit();
    }

    /**
    * 删除项
    *
    * @type {string}
    * @memberof AppArrayBox
    */
    public removeItem(index: number) {
        this.items.splice(index, 1);
        this.onEmit();
    }

    /**
    *  处理值改变
    *
    * @type {string}
    * @memberof AppArrayBox
    */
    public handleChange(value: string | number, index: number) {
        this.items[index].value = value;
        this.onEmit();
    }

    /**
    * 抛值
    *
    * @memberof AppArrayBox
    */
    public async onEmit() {
        const result = this.items.map((item:any)=>item.value);
        await this.validatorData();
        this.$emit('change', result);
        this.$forceUpdate();
    }

    /**
    * 校验数据
    *
    * @memberof AppArrayBox
    */
    public async validatorData() {
        for (let index = 0; index < this.items.length; index++) {
            this.items[index].correct = await this.validate(this.items[index].value);
        }
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
        return $event;
    }

    /**
     * 失去焦点事件
     *
     * @param {*} $event
     * @memberof InputBox
     */
    @Emit()
    public blur(event: any) {
        return event;
    }

    /**
     * 聚焦事件
     *
     * @param {*} $event
     * @memberof InputBox
     */
    @Emit()
    public focus(event: any) {
        return event;
    }
}
</script>
