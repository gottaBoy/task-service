<template>
  <van-dropdown-menu class="app-van-select">
    <van-dropdown-item get-container="#app" :lazy-render="false" :title="showTitle" ref="item" >
        <div class="app-van-select__container">
        <div v-for="(item,index) in items" :key="index" class="app-van-select__item" @click="itemClick(item)">
            <div v-show="selectItem == item" class="app-van-select__icon"><van-icon name="success" /></div>
            <div  class="app-van-select__text">{{item.label}}</div>
        </div>
        </div>
      <van-button  class="app-van-select__btn" @click="onReset" >{{$t('reset')}}</van-button>
      <van-button  class="app-van-select__btn" type="info" @click="onConfirm">{{$t('confirm')}}</van-button>
    </van-dropdown-item>
  </van-dropdown-menu>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";

@Component({
    components: {},
    i18n: {
        messages: {
            'ZH-CN': {
                confirm: '确定',
                reset: '重置',
            },
            'EN-US': {
                confirm: 'Confirm',
                reset: 'Reset',
            }
        }
    }
})
export default class AppVanSelect extends Vue {

    /**
      * 数据集
      *
      * @type {any}
      * @memberof AppVanSelect
      */
    @Prop() public items?: any;

    /**
     * 搜索名
     *
     * @type {any}
     * @memberof AppVanSelect
     */
    @Prop() public name!: string;

    /**
     * 名称
     *
     * @type {any}
     * @memberof AppVanSelect
     */
    @Prop() public title?: any;

    /**
     * 展示信息
     *
     * @type {any}
     * @memberof AppVanSelect
     */
    public showTitle: any = "";

    /**
     * 当前选中数据
     *
     * @type {any}
     * @memberof AppVanSelect
     */
    public selectItem: any = {};

    /**
     * 重置按钮
     *
     * @type {string}
     * @memberof AppVanSelect
     */
    public onReset() {
        this.selectItem = {};
        this.showTitle = this.title;
        this.closeDropdown();
        this.$emit('onConfirm', {tag:'oncategory',value: { [this.name]: this.selectItem.value }})
    }

    /**
     * 数据点击事件
     *
     * @type {any}
     * @memberof AppVanSelect
     */
    public itemClick(item: any) {
        this.selectItem = item;
    }



    /**
     * 收起数据
     *
     * @type {any}
     * @memberof AppVanSelect
     */
    public closeDropdown() {
        let dropdown: any = this.$refs.item;
        if (dropdown.toggle && dropdown.toggle instanceof Function) {
            dropdown.toggle();
        }

    }

    /**
     * 提交事件
     *
     * @type {any}
     * @memberof AppVanSelect
     */
    public onConfirm() {
        if (this.selectItem.label) {
            this.showTitle = this.selectItem.label;
        }
        this.closeDropdown();
        this.$emit('onConfirm',{tag:'oncategory',value: { [this.name]: this.selectItem.value }})
    }

    /**
     * 生命周期
     *
     * @memberof AppVanSelect
     */
    created() {
        this.showTitle = this.title;
    }

}
</script>