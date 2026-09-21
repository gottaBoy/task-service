<template>
    <div class="app-quick-group">
        <span class="app-quick-item" v-for="item in showItems" :key="item.id" @click="handleClick(item)">
            <span
                v-if="!item.children"
                :style="{ color: item.color }"
                :class="{ 'app-selected-item': isSelectedItem(item) }"
            >
                <i v-if="item.iconcls && !Object.is(item.iconcls, '')" :class="item.iconcls"></i>
                <img v-else-if="item.icon && !Object.is(item.icon, '')" :src="item.icon" />
                <span class="app-quick-item-label">{{ item.label }}</span>
                <span
                    v-show="
                        isSelectedItem(item) &&
                        counterService &&
                        counterService.counterData &&
                        counterService.counterData[id]
                    "
                    class="app-quick-item-counter"
                    >{{ itemTag(item) }}</span
                >
            </span>
            <el-dropdown
                v-if="item.children"
                style="outline: none !important"
                trigger="hover"
                @command="handleCommand($event, item)"
            >
                <span :style="{ color: item.color }" :class="{ 'app-selected-item': isSelectedItem(item) }">
                    <i v-if="item.iconcls && !Object.is(item.iconcls, '')" :class="item.iconcls"></i>
                    <img v-else-if="item.icon && !Object.is(item.icon, '')" :src="item.icon" />
                    <span class="app-quick-item-label">{{ item.label }}</span>
                    <span
                        v-show="
                            counterService &&
                            counterService.counterData &&
                            counterService.counterData[item.id]
                        "
                        class="app-quick-item-counter"
                        >{{ itemTag(item) }}</span
                    >
                </span>
                <el-dropdown-menu slot="dropdown" placement="bottom">
                    <el-dropdown-item v-for="childitem in item.children" :command="childitem" :key="childitem.id">
                        <span :style="{ color: childitem.value == item.value ? '#557DA5' : childitem.color }">
                            <i
                                v-if="childitem.iconcls && !Object.is(childitem.iconcls, '')"
                                :class="childitem.iconcls"
                            ></i>
                            <img v-else-if="childitem.icon && !Object.is(childitem.icon, '')" :src="childitem.icon" />
                            <span>{{
                                childitem.label
                            }}</span>
                            <span
                                v-show="
                                    counterService &&
                                    counterService.counterData &&
                                    counterService.counterData[childitem.id]
                                "
                                class="app-quick-item-counter"
                                >{{ itemTag(childitem) }}</span
                            >
                        </span>
                    </el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </span>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { CodeListService, Util } from 'ibiz-core';
import { IPSAppCodeList, IPSCodeItem } from '@ibiz/dynamic-model-api';

@Component({})
export default class AppQuickGroup extends Vue {
    /**
     * 传入渲染项
     *
     * @type {Array<any>}
     * @memberof AppQuickGroup
     */
    @Prop() public items?: Array<any>;

    /**
     * 计数器服务名
     *
     * @type {string}
     * @memberof AppQuickGroup
     */
    @Prop() public counterService?: any;

    /**
     * 快速分组代码表模型
     *
     * @type {string}
     * @memberof AppQuickGroup
     */
    @Prop() public codeList?: IPSAppCodeList;

    /**
     * 模式(CODELIST: 代码表加载, ITEMS：使用外置分组项)
     *
     * @type {string}
     * @memberof AppQuickGroup
     */
    @Prop({ default: 'CODELIST' }) public type?: 'CODELIST' | 'ITEMS' | string;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof AppQuickGroup
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppQuickGroup
     */
    @Prop() public viewparams: any;

    /**
     * UI选中项
     *
     * @type {*}
     * @memberof AppQuickGroup
     */
    public selectedUiItem: any;

    /**
     * 渲染列表
     *
     * @type {any[]}
     * @memberof AppQuickGroup
     */
    public showItems: any[] = [];

    /**
     * 翻译代码表后的初始列表
     *
     * @type {any[]}
     * @memberof AppQuickGroup
     */
    public initItems: any[] = [];

    /**
     * Vue生命周期 --- Created
     *
     * @memberof AppQuickGroup
     */
    created() {
        //  使用代码表加载模式
        if (this.type === 'CODELIST') {
            this.handleByCodeList();
        } else if (this.type === 'ITEMS') {
            this.handleByItems();
        } 
    }

    /**
     * 处理代码表模式
     *
     * @memberof AppQuickGroup
     */
    private async handleByCodeList() {
        if (this.codeList) {
            await this.codeList.fill();
            const codeListService = new CodeListService({ $store: this.$store });
            codeListService
                .getDataItems({
                    tag: this.codeList.codeName,
                    type: this.codeList.codeListType || 'STATIC',
                    context: this.context,
                    viewparam: this.viewparams,
                })
                .then((codeListItems: any[]) => {
                    if (codeListItems && codeListItems.length) {
                        const items = this.handleDynamicData(Util.deepCopy(codeListItems));
                        this.initItems = this.handleDataSet(items);
                        this.showItems = Util.deepCopy(this.initItems);
                        const select = this.initItems.find((item: any) => item.default);
                        this.handleClick(select ? select : this.initItems[0]);
                    }
                });
        }
    }

    /**
     * 处理代码表动态数据
     *
     * @memberof AppQuickGroup
     */
    private handleDynamicData(inputArray: Array<any>) {
        if (inputArray.length > 0) {
            const defaultSelect: any = this.getQuickGroupDefaultSelect();
            if (defaultSelect) {
                let select = inputArray.find((item: any) => { return item.value === defaultSelect.value; });
                if (select) select.default = true;
            }
            inputArray.forEach((item: any) => {
                if (item.data && Object.keys(item.data).length > 0) {
                    Object.keys(item.data).forEach((name: any) => {
                        let value: any = item.data[name];
                        if (value && typeof (value) == 'string' && value.startsWith('%') && value.endsWith('%')) {
                            const key = (value.substring(1, value.length - 1)).toLowerCase();
                            if (this.context[key]) {
                                value = this.context[key];
                            } else if (this.viewparams[key]) {
                                value = this.viewparams[key];
                            }
                        }
                        item.data[name] = value;
                    })
                }
            })
        }
        return inputArray;
    }

    /**
     * 获取快速分组默认选中
     *
     * @memberof AppQuickGroup
     */
    private getQuickGroupDefaultSelect() {
        let defaultSelect: any = null;
        const codeItems: Array<IPSCodeItem> = this.codeList?.getPSCodeItems() || [];
        if (codeItems.length > 0) {
            for (const item of codeItems) {
                const childItems = item.getPSCodeItems?.() || [];
                if (childItems.length > 0) {
                    defaultSelect = childItems.find((_item: any) => _item.default);
                }
                if (item.default || defaultSelect) {
                    defaultSelect = item;
                    break;
                }
            }
        }
        return defaultSelect;
    }

    /**
     * 处理集合模式
     *
     * @memberof AppQuickGroup
     */
    private handleByItems() {
        if (this.items && this.items.length) {
            const select = this.items.find((item: any) => {
                return item.default;
            });
            this.showItems = Util.deepCopy(this.items);
            this.handleClick(select ? select : this.items[0]);
        }
    }

    /**
     * 计数器标识
     *
     * @memberof AppQuickGroup
     */
    public itemTag(item: any) {
        if (this.counterService && this.counterService.counterData && item.value) {
            return this.counterService.counterData[item.value];
        } else {
            return '';
        }
    }

    /**
     * 是否选中当前项
     *
     * @param item 传入当前项
     * @memberof AppQuickGroup
     */
    public isSelectedItem(item: any) {
        if (this.selectedUiItem && this.selectedUiItem.value === item.value) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 处理代码表返回数据(树状结构)
     *
     * @param result 返回数组
     * @memberof AppQuickGroup
     */
    public handleDataSet(result: Array<any>) {
        let list: Array<any> = [];
        if (result.length === 0) {
            return list;
        }
        result.forEach((codeItem: any) => {
            if (!codeItem.pvalue) {
                let valueField: string = codeItem.value;
                this.setChildCodeItems(valueField, result, codeItem);
                list.push(codeItem);
            }
        });
        return list;
    }

    /**
     * 处理非根节点数据
     *
     * @param pValue 父值
     * @param result 返回数组
     * @param codeItem 代码项
     * @memberof AppQuickGroup
     */
    public setChildCodeItems(pValue: string, result: Array<any>, codeItem: any) {
        result.forEach((item: any) => {
            if (item.pvalue == pValue) {
                let valueField: string = item.value;
                this.setChildCodeItems(valueField, result, item);
                if (!codeItem.children) {
                    codeItem.children = [];
                }
                codeItem.children.push(item);
            }
        });
    }

    /**
     * 处理点击事件
     *
     * @param $event 值
     * @memberof AppQuickGroup
     */
    public handleClick($event: any) {
        if ((this.selectedUiItem && this.selectedUiItem.id === $event.id)) {
            return;
        }
        this.selectedUiItem = $event;
        for (let i = 0; i < this.showItems.length; i++) {
            if (this.showItems[i].children && this.showItems[i].id !== $event.pvalue) {
                this.showItems[i].label = this.initItems[i].label;
                this.showItems[i].value = this.initItems[i].value;
            }
        }
        this.$emit('valuechange', $event);
        this.$forceUpdate();
    }

    /**
     * 处理子项点击事件
     *
     * @param $event 值
     * @param item 父值
     * @memberof AppQuickGroup
     */
    public handleCommand($event: any, item: any) {
        item.label = $event.label;
        item.value = $event.value;
        this.handleClick($event);
    }
}
</script>
