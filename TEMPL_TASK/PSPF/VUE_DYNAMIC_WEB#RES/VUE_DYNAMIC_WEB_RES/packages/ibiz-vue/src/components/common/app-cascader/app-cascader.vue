<template>
    <div class="app-cascader">
        <el-cascader
            v-if="Object.is(editorStyle, 'default') && isShowCascader"
            class="app-cascader__default"
            popper-class="app-cascader__default__dropdown"
            clearable
            :options="treeData"
            :size="getSize()"
            :separator="separator"
            :filterable="filterable"
            :placeholder="placeholder"
            :props="{ 
                lazy: true,
                multiple: multiple,
                lazyLoad: loadData,
            }"
            :disabled="disabled || readonly"
            v-model="selectValue"
            @remove-tag="handleRemoveTag"
            @change="handleCascaderValueChange"
        />
        <el-select
            v-else-if="Object.is(editorStyle, 'tree')"
            clearable
            class="app-cascader__tree"
            popper-class="app-cascader__tree__dropdown"
            :popper-append-to-body="false"
            v-model="selectValue"
            :size="getSize()"
            :readonly="readonly"
            :disabled="disabled"
            :multiple="multiple"
            :placeholder="placeholder"
            @clear="handleTreeClear"
            @remove-tag="handleRemoveTag">
            <template slot="empty">
                <el-input v-if="filterable" v-model="searchValue" placeholder="输入关键字过滤" @input="onSearch" size="small"></el-input>
                <el-tree
                    lazy
                    ref="tree"
                    node-key="nodekey"
                    :load="loadData"
                    :props="{
                        disabled: getDisabled, 
                        isLeaf: getIsLeaf
                    }"
                    :show-checkbox="multiple"
                    :check-on-click-node="!multiple"
                    :default-checked-keys="defaultCheckedKeys"
                    :filter-node-method="filterNode"
                    @check="handleTreeSelect"
                ></el-tree>
            </template>
        </el-select>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { DataServiceHelp, ModelTool, Util } from 'ibiz-core';
import { Subject, Subscription } from 'rxjs';

@Component({ })
export default class AppCascader extends Vue {

    /**
     * 编辑器样式
     * 
     * @type { 'default' | 'tree' }
     * @memberof AppCascader
     */
    @Prop({ default: 'default' }) public editorStyle!:  'default' | 'tree';

    /**
     * 当前值
     * 
     * @type {any}
     * @memberof AppCascader
     */
    @Prop() readonly value!: string;

    /**
     * 当前名称
     * 
     * @type {any}
     * @memberof AppCascader
     */
    @Prop() readonly name!: string;

    /**
     * 传入表单数据
     *
     * @type {*}
     * @memberof AppCascader
     */
    @Prop() public data!: any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppCascader
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppCascader
     */
    @Prop() public viewparams!: any;

    /**
     * 是否禁用
     * 
     * @type {any}
     * @memberof AppCascader
     *
     */
    @Prop() public disabled?: any;

    /**
     * 是否支持过滤
     * 
     * @type {boolean}
     * @memberof AppCascader
     */
    @Prop({ default: true }) public filterable?: boolean;

    /**
     * 连接符
     *
     * @type {string}
     * @memberof AppCascader
     */
    @Prop({ default: '/' }) public separator!: string;

    /**
     * 下拉选提示内容
     * 
     * @type {string}
     * @memberof AppCascader
     */
    @Prop() public placeholder?: string;

    /**
     * 只读
     * 
     * @type {boolean}
     * @memberof AppCascader
     */
    @Prop({ default: false }) public readonly?: boolean;

    /**
     * 多选
     * 
     * @type {boolean}
     * @memberof AppCascader
     */
    @Prop({ default: false }) public multiple!: boolean;

    /**
     * 值项集合
     * 
     * @type {string}
     * @memberof AppCascader
     */
    @Prop() public valueItems!: any[];

    /**
     * 尺寸
     *
     * @type {'large' | 'small' | 'default'}
     * @memberof AppCascader
     */
    @Prop({ default: "default" })
    public size!: "large" | "small" | "default";

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
     * 树数据(用于维护级联选择器默认选中数据)
     *
     * @type {any[]}
     * @memberof AppCascader
     */
    public treeData: any[] = [];

    /**
     * 数据集
     *
     * @type {any[]}
     * @memberof AppCascader
     */
    public items: any[] = [];

    /**
     * 选中值
     *
     * @type {any[]}
     * @memberof AppCascader
     */
    public selectValue: any = null;

    /**
     * 树选中数据
     *
     * @type {any[]}
     * @memberof AppCascader
     */
    public treeSelectData: any = [];

    /**
     * 值项数据
     *
     * @type {any[]}
     * @memberof AppCascader
     */
    public valueItemData: any[] = [];

    /**
     * 树默认选中值
     * 
     * @type {string[]}
     * @memberof AppCascader
     */
    public defaultCheckedKeys: string[] = [];

    /**
     * 搜索值
     * 
     * @type {string}
     * @memberof AppCascader
     */
    public searchValue: string = '';

    /**
     * 是否加载完成
     * 
     * @type {string}
     * @memberof AppCascader
     */
    public isLoaded: boolean = false;

    /**
     * 是否显示级联选择器（用于控制加载时机，防止回显值绑定异常）
     * 
     * @type {string}
     * @memberof AppCascader
     */
    public isShowCascader: boolean = false;

    /**
     * 获取尺寸
     *
     * @returns {string}
     * @memberof AppCascader
     */
    public getSize(): string {
        switch (this.size) {
            case "large":
                return "medium";
            case "small":
                return "mini";
            default:
                return "small";
        }
    }

    /**
     * 获取是否为子叶
     *
     * @params data
     * @params node
     * @memberof AppCascader
     */
    public getIsLeaf(data: any, node: any): boolean {
        return data.leaf;
    }

    /**
     * 获取禁用状态
     *
     * @params data
     * @params node
     * @memberof AppCascader
     */
    public getDisabled(data: any, node: any): boolean {
        return node.level !== this.valueItems.length
    }

    /**
     * Vue 生命周期
     *
     * @memberof AppCascader
     */
    public created() {
        if (this.valueItems && this.valueItems.length > 0) {
            this.valueItems.forEach((valueItem: any, index: number) => {
                this.valueItemData.push({ name: valueItem.name, value: [] });
            });
        }
        if(this.formState) {
            this.formStateEvent = this.formState.subscribe(({ type, data }) => {
                if (Object.is('load', type)) {
                    if (Object.is(this.editorStyle, 'default')) {
                        this.isShowCascader = true;
                    } else {
                        this.handleSelectData();
                    }
                }
            });
        }
        this.handleSelectData();
    }

    /**
     * 处理选中数据
     * 
     * @memberof AppCascader
     */
    public handleSelectData() {
        if (this.value && this.valueItems) {
            const treeSelectData: any[] = [];
            const values = JSON.parse(this.value);
            values.forEach((label: string) => {
                treeSelectData.push({
                    label,
                    value: []
                })
            })
            this.valueItemData.forEach((valueItem: any) => {
                const value = this.data[valueItem.name] ? this.data[valueItem.name].split(',') : [];
                valueItem.value = value;
            });
            treeSelectData.forEach((select: any, index: number) => {
                this.valueItemData.forEach((valueItem: any) => {
                    select.value.push(valueItem.value[index])
                });
                const value = select.value.join(this.separator);
                this.treeSelectData.push({
                    label: select.label,
                    value
                })
            });
            this.treeSelectData.forEach((select: any) => {
                const _values: any[] = select.value.split(this.separator);
                const _labels: any[] = select.label.split(this.separator);
                _values.forEach((value: string, index: number) => {
                    const item = this.items.find((item: any) => item.value == value);
                    if (!item) {
                        this.items.push({ value, label: _labels[index] })
                    }
                })
            })
            if (Object.is(this.editorStyle, 'default')) {
                let selectValue: any[] = [];
                if (!this.multiple) {
                    selectValue = this.treeSelectData[0].value.split(this.separator);
                } else {
                    this.treeSelectData.forEach((select: any) => {
                        selectValue.push(select.value.split(this.separator));
                    })
                }
                const setTreeData = (treeData: any, treePath: string[], index: number) => {
                    if (index > -1 && index < treePath.length) {
                        const item = this.items.find((item: any) => item.value == treePath[index]);
                        const treeItem = treeData.find((item: any) => item.value == treePath[index]);
                        if (!treeItem) {
                            const childData: any = { label: item.label, value: item.value, children: [], leaf: index == treePath.length - 1 };
                            setTreeData(childData.children, treePath, index + 1);
                            treeData.push(childData);
                        } else {
                            if (!treeItem.children) {
                                treeItem.children = [];
                            }
                            setTreeData(treeItem.children, treePath, index + 1);
                        }
                    }
                }
                if (this.multiple) {
                    selectValue.forEach((select: any) => {
                        setTreeData(this.treeData, select, 0);
                    })
                } else {
                    setTreeData(this.treeData, selectValue, 0);
                }
                this.selectValue = selectValue;
            } else {
                if (this.multiple) {
                    this.selectValue = values;
                } else {
                    this.selectValue = values.join(this.separator);
                }
                const defaultCheckedKeys: any[] = this.valueItemData[this.valueItemData.length - 1].value;
                if (this.valueItemData.length > 1) {
                    const parentKays = this.valueItemData[this.valueItemData.length - 2].value;
                    if (parentKays && parentKays.length > 0) {
                        parentKays.forEach((parent: string, index: number) => {
                            defaultCheckedKeys[index] = parent + "_" + defaultCheckedKeys[index];
                        })
                    }
                }
                this.defaultCheckedKeys = defaultCheckedKeys;
            }
        }
    }

    /**
     * 加载数据
     * 
     * @params node节点数据
     * @params resolve 懒加载回调
     * @memberof AppCascader
     */
    public async loadData(node: any, resolve: Function) {
        const { level } = node;
        const value = Object.is(this.editorStyle, 'default') ? node.value : node.data ? node.data.value : null;
        const valueItem = this.valueItems[level];
        try {
            if (valueItem && valueItem.appDataEntity) {
                const service = await DataServiceHelp.getInstance().getService(valueItem.appDataEntity);
                if (service) {
                    const { context, viewParams } = this.handleQueryParams(level, value);
                    const response = await service.execute(valueItem.dataSet, context, viewParams);
                    if (response && response.status === 200 && response.data.length > 0) {
                        const nodes: any[] = response.data.map((item: any, index: number) => ({
                            ...item,
                            value: item[(ModelTool.getAppEntityKeyField(valueItem.appDataEntity) as any).codeName.toLowerCase()],
                            label: item[(ModelTool.getAppEntityMajorField(valueItem.appDataEntity) as any).codeName.toLowerCase()] ? item[(ModelTool.getAppEntityMajorField(valueItem.appDataEntity) as any).codeName.toLowerCase()] : '标题'+index,
                            leaf: level == (this.valueItems.length - 1),
                            nodekey: `${value ? value + '_' + item[(ModelTool.getAppEntityKeyField(valueItem.appDataEntity) as any).codeName.toLowerCase()] : item[(ModelTool.getAppEntityKeyField(valueItem.appDataEntity) as any).codeName.toLowerCase()]}`,
                        }));
                        nodes.forEach((node: any) => {
                            const index = this.items.findIndex((item: any) => node.value == item.value);
                            if (index > -1) {
                                this.items[index] = node;
                            } else {
                                this.items.push(node);
                            }
                        })
                        // 级联选择器值回显特殊处理--将懒加载回的数据填充到树型数据中
                        if (Object.is(this.editorStyle, 'default')) {
                            const tempNodes = this.fillTreeData(node, nodes);
                            resolve(tempNodes);
                        } else {
                            resolve(nodes);
                        }
                        return;
                    }
                }
            }
            resolve([])
        } catch (error) {
            this.$throw(`${valueItem.appDataEntity.codeName} 实体查询 ${valueItem.dataSet} 数据集失败`);
            resolve([])
        }
    }

    /**
     * 填充树型数据
     * 
     * @params node 父节点数据
     * @params nodes 子节点数据
     * @memberof AppCascader
     */
    public fillTreeData(node: any, curNodes: any[]): any[] {
        const { level, value } = node;
        this.isLoaded = true;
        let tempNodes: any[] = [];
        if (level == 0) {
            // 已有回显数据
            this.handleSelectData();
            if (this.treeData.length > 0) {
                curNodes.forEach((child: any) => {
                    const index = this.treeData.findIndex((_node: any) => child.value == _node.value);
                    if (index > -1) {
                        Object.assign(this.treeData[index], child);
                    } else {
                        this.treeData.push(child);
                        tempNodes.push(child);
                    }
                })
            } else {
                this.treeData = [...curNodes];
                tempNodes = [...curNodes];
            }
        } else {
            const getTreeData = (nodes: any[], parentKey: string) => {
                if (nodes && nodes.length > 0) {
                    nodes.forEach((_node: any) => {
                        if (_node.value == value) {
                            if (_node.children && _node.children.length > 0) {
                                curNodes.forEach((childNode: any) => {
                                    const index = _node.children.findIndex((child: any) => child.value == childNode.value);
                                    if (index > -1) {
                                        Object.assign(_node.children[index], childNode);
                                    } else {
                                        _node.children.push(childNode);
                                        tempNodes.push(childNode);
                                    }
                                })
                            } else {
                                _node.children = curNodes;
                                tempNodes = curNodes;
                            }
                        } else {
                            getTreeData(_node.children, parentKey)
                        }
                    })
                }
            }
            getTreeData(this.treeData, value);
        }
        // 在数据回显中，已有选中数据时，树重新load会导致selectValue被清空
        const selectValue = this.selectValue || [];
        setTimeout(() => {
            this.selectValue = selectValue;
            this.isLoaded = false;
        })
        return tempNodes;
    }

    /**
     * 处理查询参数
     * 
     * @params index 当前查询层级
     * @params value 父节点数据
     * @memberof AppCascader
     */
    public handleQueryParams(index: number, value: string) {
        const context = Util.deepCopy(this.context);
        const viewParams = Util.deepCopy(this.viewparams);
        if (index > 0) {
            const valueItem = this.valueItems[index - 1];
            Object.assign(context, {
                [valueItem.appDataEntity.codeName]: value,
            })
            Object.assign(viewParams, {
                [`n_${(ModelTool.getAppEntityKeyField(valueItem.appDataEntity) as any).codeName.toLowerCase()}_eq`]: value,
            })
        }
        return { context, viewParams }
    }

    /**
     * 处理树选择清空
     * 
     * @memberof AppCascader
     */
    public handleTreeClear() {
        this.treeSelectData = [];
        this.valueItemData.forEach((valueItem: any) =>{
            valueItem.value = [];
        })
        const tree: any = this.$refs.tree;
        tree.setCheckedKeys([]);
        this.handleTreeValueChange();
    }

    /**
     * 处理删除标签(多选删除)
     * 
     * @params tag 标签删除项
     * @memberof AppCascader
     */
    public handleRemoveTag(tag: string[] | string) {
        setTimeout(() => {
            if (Object.is(this.editorStyle, 'default')) {
                this.handleCascaderValueChange();
            } else {
                const removeIndex = this.treeSelectData.findIndex((select: any) => {
                    return select.label == tag
                })
                this.removeTreeData(removeIndex);
            }
        })  
    }

    /**
     * 处理树数据删除
     * 
     * @params removeIndex 删除项索引
     * @memberof AppCascader
     */
    public removeTreeData(removeIndex: number) {
        const tree: any = this.$refs.tree;
        if (tree) {
            this.valueItemData.forEach((valueItem: any) =>{
                if (valueItem.value.length > 0) {
                    valueItem.value.splice(removeIndex, 1);
                }
            })
            const removeItem = this.treeSelectData[removeIndex];
            const keys: string[] = removeItem.value.split(this.separator);
            tree.setChecked(keys[keys.length - 1], false)
            this.treeSelectData.splice(removeIndex, 1);
            this.handleTreeValueChange();
        }
    }

    /**
     * 处理树选中
     * 
     * @params item 节点绑定数据
     * @params treeSelected 树选中对象
     * @memberof AppCascader
     */
    public handleTreeSelect(item: any, treeSelected: any) {
        let checkedKeys: string[] = [];
        if (this.multiple) {
            checkedKeys = treeSelected.checkedKeys;
        } else {
            checkedKeys = [item.nodekey];
        }
        const nodes: any[] = [];
        const tree: any = this.$refs.tree;
        checkedKeys.forEach((key: string) => {
            nodes.push(tree.getNode(key));
        })
        nodes.filter((node: any) => node.level == this.valueItems.length);
        const getParent = (node: any, pathNode: any[]) => {
            if (node.level > 0) {
                pathNode.unshift(node);
                getParent(node.parent, pathNode);
            }
        }
        const treeSelectPath: any[] = [];
        nodes.forEach((node: any) => {
            const pathNode: any[] = [];
            getParent(node, pathNode);
            treeSelectPath.push(pathNode);
        });
        this.treeSelectData = [];
        this.valueItemData.forEach((valueItem: any) =>{
            valueItem.value = [];
        })
        treeSelectPath.forEach((paths: any[]) => {
            const labels: string[] = [];
            const values: string[] = [];
            paths.forEach((path: any, index: number) => {
                labels.push(path.label);
                values.push(path.key);
                if (this.valueItemData[index]) {
                    this.valueItemData[index].value.push(path.data.value);
                }
            })
            this.treeSelectData.push({ 
                label: labels.join(this.separator),
                value: values.join(this.separator),
            });
        });
        this.handleTreeValueChange();
    }

    /**
     * 过滤节点
     * 
     * @params value 值
     * @params data 数据
     * @memberof AppCascader
     */
    public filterNode(value: string, data: any) {
        if (!value) return true;
        return data.label.indexOf(value) !== -1;
    }

    /**
     * 搜索
     * 
     * @params query 值
     * @memberof AppCascader
     */
    public onSearch(query: string) {
        const tree: any = this.$refs.tree;
        if (tree) {
            tree.filter(query);
        }
    }

    /**
     * 处理级联选择器值改变
     * 
     * @memberof AppCascader
     */
    public handleCascaderValueChange() {
        if (!this.isLoaded) {
            // 计算值项选中数据
            this.valueItemData.forEach((valueItem: any) =>{
                valueItem.value = [];
            })
            this.selectValue.forEach((item: any, index: number) => {
                if (Util.typeOf(item) == 'string') {
                    this.valueItemData[index].value.push(item);
                } else {
                    item.forEach((_item: any, _index: number) => {
                        this.valueItemData[_index].value.push(_item);
                    })
                }
            })
            // 计算当前选中数据文本
            const curSelectPath: any[] = [];
            let curSelectText: string[] = [];
            this.selectValue.forEach((selected: any, index: number) => {
                if (this.multiple) {
                    const selectItems: string[] = selected.map((select: string) => {
                        const selectItem = this.items.find((item: any) => item.value == select);
                        if (selectItem) {
                            return selectItem.label;
                        }
                    })
                    curSelectPath.push(selectItems);
                } else {
                    const selectItem = this.items.find((item: any) => item.value == selected);
                    if (selectItem) {
                        curSelectPath.push(selectItem.label);
                    }
                }
            })
            this.valueItemData.forEach((valueItem: any) =>{
                this.$emit('change', { name: valueItem.name, value: valueItem.value.length > 0 ? valueItem.value.join(',') : null });
            })
            if (curSelectPath.length > 0) {
                if (this.multiple) {
                    curSelectPath.forEach((path: string[]) => {
                        curSelectText.push(path.join(this.separator));
                    })
                } else {
                    curSelectText = [curSelectPath.join(this.separator)]
                }
            }
            this.$emit('change', { name: this.name, value: curSelectText.length > 0 ? JSON.stringify(curSelectText) : null});
        }
    }

    /**
     * 处理树选择器值改变
     * 
     * @memberof AppCascader
     */
    public handleTreeValueChange() {
        const selectValue: any[] = [];
        this.selectValue = [];
        this.treeSelectData.forEach((item: any) => {
            selectValue.push(item.label)
        })
        if (this.multiple) {
            this.selectValue = selectValue;
        } else {
            this.selectValue = selectValue.length > 0 ? selectValue[0] : null;
        }
        this.valueItemData.forEach((valueItem: any) =>{
            this.$emit('change', { name: valueItem.name, value: valueItem.value.length > 0 ? valueItem.value.join(',') : null});
        })
        this.$emit('change', { name: this.name, value: selectValue.length > 0 ? JSON.stringify(selectValue) : null});
    }
}
</script>