<template>
    <div class="app-auth-org-picker">
        <app-orgsector
            v-if="containerType === 'APPINDEXVIEW' || Object.is(sourceMode, selectMode)"
            dropdownClass="auth-org-picker-dropdown"
        ></app-orgsector>
        <div class="app-org-sector-remote" v-else>
            <dropdown @on-click="orgSelect" @on-visible-change="visibleChange">
                <div class="org-sector">
                    <Input :value="getSelectedOrgName" placeholder="请选择部门" readonly :icon="iconClass" />
                </div>
                <dropdown-menu slot="list">
                    <dropdown-item
                        :class="{ 'org-sector-choice': Object.is(item.srforgsectorid, getSelectedOrgName) }"
                        :name="item.srforgsectorid"
                        v-for="(item, index) in selectedOrgArray"
                        :key="index"
                    >
                        {{ item.srforgsectorname }}
                    </dropdown-item>
                    <div class="menu-item-no-data" v-show="!selectedOrgArray.length">暂无数据</div>
                </dropdown-menu>
            </dropdown>
        </div>
    </div>
</template>
<script lang='ts'>
import { Vue, Component, Inject, Prop } from 'vue-property-decorator';
import { LogUtil } from 'ibiz-core';

@Component({})
export default class AppAuthOrgPicker extends Vue {
    /**
     * 注入加载行为
     *
     * @memberof AppAuthOrgPicker
     */
    @Inject('reload')
    reload!: any;

    /**
     * 组织数据
     *
     * @type {any}
     * @memberof AppAuthOrgPicker
     */
    @Prop() public editorInstance!: any;

    /**
     * 输入值
     *
     * @type {*}
     * @memberof AppAuthOrgPicker
     */
    @Prop() public value!: any;

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppAuthOrgPicker
     */
    @Prop() public name!: string;

    /**
     * 数据来源模式
     *
     * @type {string}
     * @memberof AppAuthOrgPicker
     */
    @Prop() public sourceMode?: string;

    /**
     * 应用上下文
     *
     * @type {string}
     * @memberof AppAuthOrgPicker
     */
    @Prop() public context!: any;

    /**
     * 容器类型
     *
     * @type {string}
     * @memberof AppAuthOrgPicker
     */
    @Prop() public containerType?: string;

    /**
     * 默认数据来源模式
     *
     * @type {string}
     * @memberof AppAuthOrgPicker
     *
     */
    public selectMode: 'REMOTE' | 'LOCAL' = 'LOCAL';

    /**
     * 选中组织部门id
     *
     * @type {string}
     * @memberof AppAuthOrgPicker
     */
    public selectedOrgId: string = '';

    /**
     * 图标名称
     *
     * @type {boolean}
     * @memberof AppAuthOrgPicker
     */
    public iconClass: string = 'ios-arrow-down';

    /**
     * 选中组织部门名称
     *
     * @type {string}
     * @memberof AppAuthOrgPicker
     */
    get getSelectedOrgName() {
        if (this.value) {
            const selectedValue = this.selectedOrgArray.find((item: any) => {
                return item.srforgsectorid == this.value;
            });
            return selectedValue?.srforgsectorname;
        }
    }

    /**
     * 组织部门名称数组
     *
     * @type {Array<any>}
     * @memberof AppAuthOrgPicker
     */
    public selectedOrgArray: Array<any> = [];

    /**
     * 组件初始化数据，vue生命周期
     *
     * @memberof AppAuthOrgPicker
     */
    public created() {
        //暂时写死的获取远程数据的request
        this.getOrgData();
    }

    /**
     * 选择组织部门回调
     *
     * @memberof AppAuthOrgPicker
     */
    public orgSelect(data: string) {
        if (Object.is(data, this.selectedOrgId)) {
            return;
        }
        let item: any = this.selectedOrgArray.find((_item: any) => Object.is(_item.srforgsectorid, data));
        this.$emit('valueChange', { name: this.name, value: item.srforgsectorid });
    }

    /**
     * 下拉框打开或收起回调
     *
     * @memberof AppAuthOrgPicker
     */
    visibleChange(data: boolean) {
        this.iconClass = data ? 'ios-arrow-up' : 'ios-arrow-down';
    }

    /**
     * 获取数据
     *
     * @memberof AppAuthOrgPicker
     */
    public async getOrgData() {
        LogUtil.warn('获取数据暂未实现');
    }
}
</script>
<style lang="less">
@import './app-preset-org-picker.less';
</style>