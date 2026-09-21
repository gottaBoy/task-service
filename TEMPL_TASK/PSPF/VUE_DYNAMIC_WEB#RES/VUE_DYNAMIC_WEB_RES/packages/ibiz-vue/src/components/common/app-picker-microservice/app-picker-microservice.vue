<template>
    <el-autocomplete
        class="app-picker-microservice"
        :disabled="disabled"
        v-model="curvalue"
        size="small"
        :readonly="readonly"
        :placeholder="placeholder"
        :trigger-on-focus="true"
        :popper-class="popperClass"
        :fetch-suggestions="onSearch"
        @select="onSelect"
    >
        <template v-slot:suffix>
            <i v-if="curvalue && !disabled" class="el-icon-circle-close" @click="onClear"></i>
            <i class="el-icon-arrow-down"></i>
        </template>
        <template slot-scope="{ item }">
            <template v-if="Object.is(mode, 'tree')">
                <el-tree
                    ref="tree"
                    :data="treeData"
                    :show-checkbox="multiple"
                    :node-key="showValue"
                    :props="defaultProps"
                    :check-strictly="true"
                    :default-checked-keys="defaultKeys"
                    :filter-node-method="filterNode"
                    :check-on-click-node="true"
                    @check="onTreeSelect"
                ></el-tree>
            </template>
            <template v-else>
                <span>{{ item.label }}</span>
            </template>
        </template>
    </el-autocomplete>
</template>

<script lang="ts">
import { Util } from 'ibiz-core';
import { Subject, Subscription } from 'rxjs';
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppPickerMicroservice extends Vue {
    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    @Prop() public viewparams!: any;

    /**
     * 表单服务
     *
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    @Prop() public service?: any;

    /**
     * 应用实体主信息属性名称
     *
     * @type {string}
     * @memberof AppPickerMicroservice
     */
    @Prop({ default: 'srfmajortext' }) public deMajorField!: string;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppPickerMicroservice
     */
    @Prop({ default: 'srfkey' }) public deKeyField!: string;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    @Prop() public data!: any;

    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppPickerMicroservice
     */
    @Prop() public name!: string;

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof AppPickerMicroservice
     */
    @Prop() public disabled?: boolean;

    /**
     * 只读模式
     * @type {boolean}
     * @memberof AppPickerMicroservice
     */
    @Prop({ default: false }) public readonly?: boolean;

    /**
     * 局部上下文导航参数
     *
     * @type {any}
     * @memberof AppPickerMicroservice
     */
    @Prop() public localContext!: any;

    /**
     * 局部导航参数
     *
     * @type {any}
     * @memberof AppPickerMicroservice
     */
    @Prop() public localParam!: any;

    /**
     * 值项名称
     *
     * @type {string}
     * @memberof AppPickerMicroservice
     */
    @Prop() public valueitem!: string;

    /**
     * 排序
     *
     * @type {string}
     * @memberof AppPickerMicroservice
     */
    @Prop() public sort?: string;

    /**
     * 行为组
     *
     * @type {Array<any>}
     * @memberof AppPickerMicroservice
     */
    @Prop() public actionDetails?: Array<any>;

    /**
     * 值
     *
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    @Prop() public value?: any;

    /**
     * 占位提示
     *
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    @Prop() public placeholder?: string;

    /**
     * 值分割符
     *
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    @Prop({ default: ',' }) public valueSeparator!: string;

    /**
     * @description 数据展示模式
     * @type {string}
     * @memberof AppPickerMicroservice
     */
    @Prop({ default: 'list' }) public mode!: string;

    /**
     * @description 是否多选
     * @type {boolean}
     * @memberof AppPickerMicroservice
     */
    @Prop({ default: false }) public multiple!: boolean;

    /**
     * @description 数据查询地址
     * @type {string}
     * @memberof AppPickerMicroservice
     */
    @Prop() public url?: string;

    /**
     * @description 字节的过滤键
     * @type {string}
     * @memberof AppPickerMicroservice
     */
    @Prop({ default: 'pvalue' }) public leafFilterKey!: string;

    /**
     * @description 是否搜索查询
     * @type {boolean}
     * @memberof AppPickerMicroservice
     */
    @Prop({ default: false }) public enableSearch!: boolean;

    /**
     * @description 是否只允许选中子节点
     * @type {boolean}
     * @memberof AppPickerMicroservice
     */
    @Prop({ default: false }) public onlyLeaf!: boolean;

    /**
     * @description 重置项名称
     * @type {boolean}
     * @memberof AppPickerMicroservice
     */
    @Prop() public resetItemName?: string;

    /**
     * @description 填充对象
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    @Prop() public fillMap?: any;

    /**
     * 表单状态对象
     *
     * @type {Subject<any>}
     * @memberof AppEmbedPicker
     */
    @Prop() public formState!: Subject<any>

    /**
     * 订阅对象
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof SelectType
     */
    protected formStateEvent: Subscription | undefined;

    /**
     * @description 显示值label
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    showLabel: string = 'label';

    /**
     * @description 显示值value
     * @type {*}
     * @memberof AppPickerMicroservice
     */
    showValue: string = 'id';

    /**
     * @description 数据
     * @type {any[]}
     * @memberof AppPickerMicroservice
     */
    public items: any[] = [];

    /**
     * @description 树结构数据
     * @type {any[]}
     * @memberof AppPickerMicroservice
     */
    public treeData: any[] = [];

    /**
     * @description 树结构默认参数
     * @type {any[]}
     * @memberof AppPickerMicroservice
     */
    public defaultProps: any = { label: 'label' };

    /**
     * @description 树默认选中数据
     * @type {any[]}
     * @memberof AppPickerMicroservice
     */
    public defaultKeys: string[] = [];

    /**
     * @description 选中数据map
     * @type {any[]}
     * @memberof AppPickerMicroservice
     */
    public selectionMap: Map<string, any> = new Map();

    /**
     * @description 显示文本
     * @type {any[]}
     * @memberof AppPickerMicroservice
     */
    public text: string = '';

    /**
     * @description 下拉类名
     * @type {any[]}
     * @memberof AppPickerMicroservice
     */
    public popperClass: string = 'app-picker-microservice__popper';

    /**
     * @description 唯一标识
     * @type {any[]}
     * @memberof AppPickerMicroservice
     */
    public uuid: string = Util.createUUID();

    get curvalue() {
        if (this.value && this.valueitem) {
            return this.value;
        }
        return this.text;
    }

    set curvalue(value: string) {
        if (this.enableSearch && this.value) {
            this.handleEmit('', '');
        }
        this.text = value;
    }

    @Watch('data',{deep: true})
    onDataChange(newData: any, oldData: any) {
        if (newData && oldData && this.resetItemName && Object.is(newData[this.resetItemName], oldData[this.resetItemName])) {
            this.items = [];
        }
    }

    /**
     * @description 生命周期
     * @memberof AppPickerMicroservice
     */
    async created() {
        if(this.formState) {
            this.formStateEvent = this.formState.subscribe(({ type, data }) => {
                if (Object.is('load', type) && !this.valueitem) {
                    this.load();
                    if (this.items.length > 0) {
                        const item = this.items.find(item => Object.is(item[this.showValue], this.value));
                        if (item) {
                            this.text = item[this.showLabel];
                        }
                    }
                }
            });
        }
    }

    /**
     * @description 生命周期
     * @memberof AppPickerMicroservice
     */
    mounted() {
        if (this.fillMap) {
            this.showLabel = this.fillMap.label;
            this.showValue = this.fillMap.id;
            this.defaultProps.label = this.fillMap.label;
        }
        this.popperClass += ` app-picker-microservice__popper-${this.uuid}`;
    }

    /**
     * @description 组件销毁
     * @memberof AppPickerMicroservice
     */
    destroyed() {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * @description 搜索数据
     * @memberof AppPickerMicroservice
     */
    async onSearch(query: string, callback: Function) {
        await this.load();
        if (Object.is(this.mode, 'tree')) {
            callback(this.treeData);
        } else {
            callback(this.items);
        }
        this.$nextTick(() => {
            this.filter(query, callback);
        })
        this.togglePopper(true);
    }

    /**
     * @description 数据加载
     * @memberof AppPickerMicroservice
     */
    async load() {
        if (this.url && this.items.length == 0) {
            let queryParam: any = {};
            if (this.localParam && Object.keys(this.localParam).length > 0) {
                queryParam = this.$util.computedNavData(this.data, this.context, this.viewparams, this.localParam);
            }
            try {
                const response = await this.$http.post(this.url, queryParam);
                if (response && response.status !== 200) {
                    this.$throw('数据加载失败', 'onSearch');
                }
                if (Object.is(this.mode, 'tree')) {
                    if (response.data && response.data.length > 1) {
                        this.items = response.data || [];
                        this.handleLevelCodeList(this.items);
                    } else {
                        this.treeData = response.data || [];
                        this.items = [];
                        this.transformTreeData(this.treeData);
                    }
                } else {
                    this.items = response.data || [];
                }
                this.setDefaultSelect();
            } catch (error) {
                this.$throw(error, 'onSearch');
            }
        }
    }

    /**
     * @description 数据过滤
     * @memberof AppPickerMicroservice
     */
    filter(query: string, callback: Function) {
        if (this.enableSearch && !this.multiple) {
            if (Object.is(this.mode, 'tree')) {
                const tree: any = this.$refs.tree;
                if (tree) {
                    tree.filter(query);
                    callback(this.treeData);
                }
            } else {
                const results = query
                    ? this.items.filter(restaurant => {
                          return restaurant[this.showLabel].toLowerCase().indexOf(query.toLowerCase()) === 0;
                      })
                    : this.items;
                callback(results);
            }
        }
    }

    /**
     * @description 数据选中
     * @memberof AppPickerMicroservice
     */
    onSelect(item: any) {
        if (this.multiple) {
            if (this.selectionMap.has(item[this.showValue])) {
                this.selectionMap.delete(item[this.showValue]);
            } else {
                this.selectionMap.set(item[this.showValue], item);
            }
            this.valueChang();
        } else {
            this.handleEmit(item[this.showLabel], item[this.showValue]);
        }
    }

    /**
     * @description 树数据选中
     * @memberof AppPickerMicroservice
     */
    onTreeSelect(item: any, node: any) {
        if (this.onlyLeaf && item.children) {
            return;
        }
        if (this.multiple) {
            if (this.selectionMap.has(item[this.showValue])) {
                this.selectionMap.delete(item[this.showValue]);
            } else {
                this.selectionMap.set(item[this.showValue], item);
            }
            this.valueChang();
        } else {
            this.handleEmit(item[this.showLabel], item[this.showValue]);
        }
        this.togglePopper();
    }

    /**
     * @description 切换下拉显示状态
     * @memberof AppPickerMicroservice
     */
    togglePopper(show: boolean = false) {
        const popper: any = document.querySelector(`.app-picker-microservice__popper-${this.uuid}`);
        if (popper) {
            popper.style.display = show ? 'block' : 'none';
        }
    }

    /**
     * @description 清空
     * @memberof AppPickerMicroservice
     */
    onClear() {
        this.handleEmit('', '');
        this.text = '';
        const tree: any = this.$refs.tree;
        if (tree) {
            tree.filter('');
        }
    }

    /**
     * @description 设置默认选中
     * @memberof AppPickerMicroservice
     */
    setDefaultSelect() {
        if (this.items.length > 0 && this.value) {
            const keys: string[] = this.value.split(this.valueSeparator);
            keys.forEach((key: string) => {
                const data = this.items.find(item => Object.is(item[this.showValue], key));
                if (data) {
                    this.selectionMap.set(key, data);
                }
            });
            this.defaultKeys = keys;
        }
    }

    /**
     * @description 树过滤节点
     * @memberof AppPickerMicroservice
     */
    filterNode(value: string, data: any) {
        if (!value) return true;
        return data.label.indexOf(value) !== -1;
    }

    /**
     * @description 数据变更
     * @memberof AppPickerMicroservice
     */
    valueChang() {
        let value = '';
        let label = '';
        this.selectionMap.forEach((item: any) => {
            value += this.valueSeparator + item[this.showValue];
            label += this.valueSeparator + item[this.showLabel];
        });
        if (value.length > 0) {
            value = value.slice(1);
            label = label.slice(1);
        }
        this.handleEmit(label.slice(1), value.slice(1));
    }

    /**
     * @description 处理抛值
     * @memberof AppPickerMicroservice
     */
    handleEmit(label: string, value: string) {
        this.text = label;
        if (this.valueitem) {
            this.$emit('formitemvaluechange', {
                name: this.name,
                value: label,
            });
            this.$emit('formitemvaluechange', {
                name: this.valueitem,
                value: value,
            });
        } else {
            this.$emit('formitemvaluechange', {
                name: this.name,
                value: value,
            });
        }
    }

    /**
     * 转换树数据为平铺数据
     *
     * @param {*} items
     * @memberof AppPickerMicroservice
     */
    transformTreeData(treeData: any[]) {
        if (treeData.length > 0) {
            treeData.forEach((node: any) => {
                this.items.push(node);
                if (node.children && node.children.length > 0) {
                    this.transformTreeData(node.children);
                }
            });
        }
    }

    /**
     * 处理层级代码表
     *
     * @param {*} items
     * @memberof AppPickerMicroservice
     */
    public handleLevelCodeList(items: Array<any>) {
        if (items && items.length > 0) {
            const hasChildren = items.some((item: any) => {
                return item[this.leafFilterKey];
            });
            if (hasChildren) {
                let list: Array<any> = [];
                items.forEach((codeItem: any) => {
                    if (!codeItem[this.leafFilterKey]) {
                        let valueField: string = codeItem[this.showValue];
                        this.setChildCodeItems(valueField, items, codeItem);
                        list.push(codeItem);
                    }
                });
                this.treeData = list;
            }
        }
    }

    /**
     * 计算子类代码表
     *
     * @param {*} items
     * @memberof AppPickerMicroservice
     */
    public setChildCodeItems(pValue: string, result: Array<any>, codeItem: any) {
        result.forEach((item: any) => {
            if (item[this.leafFilterKey] && item[this.leafFilterKey] == pValue) {
                let valueField: string = item[this.showValue];
                this.setChildCodeItems(valueField, result, item);
                if (!codeItem.children) {
                    codeItem.children = [];
                }
                codeItem.children.push(item);
            }
        });
    }
}
</script>
