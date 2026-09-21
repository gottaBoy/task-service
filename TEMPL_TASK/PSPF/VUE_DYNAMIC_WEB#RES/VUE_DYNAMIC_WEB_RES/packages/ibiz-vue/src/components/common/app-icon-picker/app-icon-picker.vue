<template>
    <div class="app-icon-picker">
        <el-input 
            :placeholder="placeholder"
            :disabled="disabled ? true : false"
            :readonly="readonly"
            v-model="itemValue"
            clearable
            @focus="focus"
            @input="change"
        >
        </el-input>
        <el-dialog
            :title="$t('components.iconpicker.title')"
            :visible.sync="iconSelectorState"
            :before-close="handleCancel"
            :modal="false"
            width="80%">
            <div class="app-icon-picker__box">
                <el-input v-model="searchIconKey" :placeholder="$t('components.iconpicker.placeholder')" @input="handleSearchIconChange"></el-input>
                <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
                    <el-menu-item 
                        v-for="(item, index) in iconCategories"
                        :title="item"
                        :key="index"
                        :index="String(index)">{{ computedIconCategories(item) }}</el-menu-item>
                </el-menu>
                <div class="selector-content__icon-list">
                    <div 
                        class="selector-content__icon-item"
                        v-for="(item, index) in iconData"
                        :key="index"
                    >
                        <div
                            :class="{
                                'icon-item__box': true,
                                'is-active': currentIconKey === (`fa fa-${item.id}`)
                            }"
                            :title="`fa fa-${item.id}`"
                            @click.prevent="handleIconChange((`fa fa-${item.id}`))"
                        >
                            <p
                                class="item-icon"
                            >
                                <i :class="['fa', `fa-${item.id}`]"></i>
                            </p>
                            <p class="icon-tip">{{ item.id }}</p>
                        </div>
                    </div>
                </div>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="handleCancel()">{{$t('app.commonwords.cancel')}}</el-button>
                <el-button type="primary" @click="handleConfirm">{{ $t('app.commonwords.ok') }}</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script lang="ts">
import { Vue, Component, Prop, Watch, Model, Emit } from 'vue-property-decorator';

@Component({})
export default class AppIconPicker extends Vue {
    
    /**
     * 双向绑定值
     * 
     * @type {any}
     * @memberof AppIconPicker
     */
     @Model("change") readonly itemValue?: any;

    /**
     * placeholder值
     * 
     * @type {String}
     * @memberof AppIconPicker
     */
    @Prop() public placeholder?: string;

    /**
     * 是否禁用
     * 
     * @type {boolean}
     * @memberof AppIconPicker
     */
    @Prop() public disabled?: boolean;

    /**
     * 只读模式
     *
     * @type {boolean}
     */
    @Prop({ default: false }) public readonly?: boolean;

    /**
     * 当前渲染的icon数据
     * 
     * @memberof AppIconPicker
     */
    public iconData:any = [];

    /**
     * 所有icon数据集合
     * 
     * @memberof AppIconPicker
     */
    public iconDataSet: any = require(`@/assets/json/icon/awesome.json`);

    /**
     * 图标分类数据
     * 
     * @memberof AppIconPicker
     */
    public iconCategories: any[] = [];

    /**
     * 图标选择弹框状态
     * 
     * @type {boolean}
     * @memberof AppIconPicker
     */
    public iconSelectorState: boolean = false;

    /**
     * 菜单选中下标
     * 
     * @type {string}
     * @memberof AppIconPicker
     */
    public activeIndex: string = '0';

    /**
     * 当前选中的icon
     * 
     * @type {string}
     * @memberof AppIconPicker
     */
    public currentIconKey: string = '';

    /**
     * 搜索关键字过滤icon
     * 
     * @memberof AppIconPicker
     */
     public searchIconKey: string = '';

    @Watch('iconSelectorState')
    public onIconSelectorStateChange(val: boolean, oldVal: boolean) {
        if (val) {
            this.loadData();
            this.handleSelect(Number(this.activeIndex))
        }
    }

    /**
     * 关闭弹框
     * 
     * @memberof AppIconPicker
     */
    public handleCancel() {
        this.searchIconKey = '';
        this.currentIconKey = '';
        this.iconSelectorState = false;
    }

    /**
     * 确认选择
     * 
     * @memberof AppIconPicker
     */
    public handleConfirm() {
        if (this.currentIconKey) {
            this.$emit('change', this.currentIconKey);
        }
        this.handleCancel();
    }

    /**
     * 处理选择图标改变
     * 
     * @param {string} value
     * @memberof AppIconPicker
     */
    public handleIconChange(value: string) {
        this.currentIconKey = value;
    }

    /**
     * 选择需要渲染的分类数据
     * 
     * @param {number} key
     * @memberof AppIconPicker
     */
    public handleSelect(key: number, keyPath?: string[0]) {
        this.searchIconKey = '';
        this.activeIndex = String(key);
        this.computedIconData(this.iconCategories[key]);
    }

    /**
     * 处理icon搜索框change事件
     * 
     * @param {string} data 
     * @memberof AppIconPicker
     */
     public handleSearchIconChange(data: string) {
        const categories = String(this.iconCategories[Number(this.activeIndex)]);
        this.computedIconData(categories, data);
    }

    /**
     * 处理需要渲染的icon分类数据国际化
     * 
     * @memberof AppIconPicker
     */
    public computedIconCategories(categoriesItem: string) {
        if (!categoriesItem) {
            return '';
        }
        const value = categoriesItem.replace(/\s/g, '').replace(/Icons/g, '').toLowerCase();
        return this.$t(`components.iconpicker.${value}`);
    }

    /**
     * 处理需要需要渲染的的icon数据
     * 
     * @type {string}
     * @memberof AppIconPicker
     */
    public computedIconData(categories: string, data?: string) {
        let iconData: any[] = this.iconDataSet.icons.filter((item: any) => {
            return item.categories[0] === categories;
        });
        if (data) {
            this.iconData = iconData.filter((item: any) => {
                return item.id.indexOf(data) !== -1;
            });
        } else {
            this.iconData = iconData;
        }
    }

    /**
     * 初始化渲染内容
     * 
     * @memberof AppIconPicker
     */
    public loadData() {
        this.currentIconKey = this.itemValue;
        let categoriesData: any[] = [];
        this.iconDataSet.icons.forEach((item: any) => {
            if (categoriesData.indexOf(item.categories[0]) === -1) {
                categoriesData.push(item.categories[0]);
            }
        });
        this.iconCategories = categoriesData;
    }

    /**
     * 获取焦点事件
     * 
     * @memberof AppIconPicker
     */
    @Emit()
    public focus(value: string) {
        if (!this.disabled && !this.readonly) {
            this.iconSelectorState = true;
        }
        return this.itemValue;  
    }

    /**
     * change事件
     * 
     * @memberof AppIconPicker
     */
    @Emit()
    public change(value: string) {
        return this.itemValue;
    }
}
</script>