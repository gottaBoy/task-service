<template>
    <div class="app-group-picker">
        <div class="app-group-picker__content">
            <div v-if="showTree" class="app-group-picker__content__select-tree">
                <app-select-tree :NodesData="treeItems" v-model="treeSelectVal" :treeOnly="true" :defaultChecked="true" @select="treeSelect"></app-select-tree>
            </div>
            <div class="app-group-picker__content__card">
                <ibiz-group-card :data="cardItems" text="label" value="id" groupName="group" :multiple="multiple" :defaultSelect="cardSelctVal" @select="groupSelect"></ibiz-group-card>
            </div>
        </div>
        <div class="app-group-picker__footer">
            <el-button size="small" type="primary" @click="onOK">{{$t('app.commonwords.ok')}}</el-button>
            <el-button size="small" @click="onCancel">{{$t('app.commonwords.cancel')}}</el-button>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator';
import { LogUtil } from 'ibiz-core';
import axios from 'axios';

@Component({})
export default class AppGroupPicker extends Vue {

    /**
     * 动态参数
     * 
     * @memberof AppGroupPicker
     */
    @Prop() dynamicProps?:any;

    /**
     * 请求方式
     *
     * @type {stinr}
     * @memberof AppGroupSelect
     */ 
    public requestMode: 'get' | 'post' | 'delete' | 'put' = 'get';

    /**
     * 多选
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected multiple: boolean = false;

    /**
     * 加载树url
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected treeurl:any;

    /**
     * 加载人员url
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected url:any;

    /**
     * 树数据集
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected treeItems: any[] = [];

    /**
     * 分组表数据集
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected cardItems: any[] = [];

    /**
     * 视图上下文参数对象
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected viewData: any;

    /**
     * 视图参数对象
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected viewParam: any;

    /**
     * 树选中值
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected treeSelectVal: string = '';

    /**
     * 分组表选中集合
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected cardSelctVal: any = [];

    /**
     * 数据选中集合
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    protected selects: any[] = [];

    /**
     * 是否显示树
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    get showTree() {
        if(this.viewParam) {
            return this.viewParam.showtree;
        }
    }

    /**
     * 生命周期
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    public created() {
        if(!this.dynamicProps?.viewdata || !this.dynamicProps?.viewparam) {
            return;
        }
        this.viewData = JSON.parse(this.dynamicProps.viewdata);
        this.viewParam = JSON.parse(this.dynamicProps.viewparam);
        this.multiple = this.viewParam.multiple;
        this.treeurl = this.viewParam.treeurl;
        this.url = this.viewParam.url;
        this.requestMode = this.viewParam.requestMode;
        if (this.viewParam.selects) {
            this.viewParam.selects.forEach((select: any) => {
                this.selects.push(select);
                this.cardSelctVal.push(select.id)
            })
        }
        this.load();
    }

    /**
     * 加载数据
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    public load() {
        if(this.showTree) {
            this.loadTree();
        } else {
            this.loadGroupData(this.viewParam.filtervalue);
        }
    }

    /**
     * 加载树数据
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    public loadTree() {
        let orgid = this.viewParam.filtervalue;
        let tempTreeUrl: string = '';
        if(this.viewParam.selectType && Object.is(this.viewParam.selectType,"dept")){
            tempTreeUrl = this.treeurl.replace('{deptId}',orgid);
        }else{
            tempTreeUrl = this.treeurl.replace('${orgid}',orgid);
        }
        axios({method: this.requestMode, url: tempTreeUrl, data: {}}).then((response: any) => {
            if(response.status === 200) {
                this.treeItems = response.data;
            }
        }).catch((error: any) => {
            LogUtil.log(error)
        })
    }

    /**
     * 加载分组表数据
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    public loadGroupData(key: string) {
        let tempUrl: string = '';
        if(this.viewParam.selectType && Object.is(this.viewParam.selectType,"dept")){
            tempUrl = this.url.replace('{deptId}',key);
        }else{
             if(this.url && this.url.indexOf('{deptId}') !== -1){
                tempUrl = this.url.replace('{deptId}',key);
            }else{
                tempUrl = this.url.replace('${selected-orgid}',key);
            }
        }
        axios({method: this.requestMode, url: tempUrl, data: {}}).then((response: any) => {
            if(response.status === 200) {
                this.cardItems = response.data;
            }
        }).catch((error: any) => {
            LogUtil.log(error)
        })
    }

    /**
     * 树选中
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    public treeSelect(event: any) {
        if(!event || JSON.parse(event).length == 0) {
            return;
        }
        const items: any = JSON.parse(event);
        this.loadGroupData(items[0].id);
    }

    /**
     * 分组表选中
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    public groupSelect(event: any) {
        if (!event || !event.select) {
            return;
        }
        if(!this.multiple) {
            this.selects = [];
        }
        if(event.rselect) {
            let index: number = this.selects.findIndex((item: any) => Object.is(event.rselect, item.id));
            if(index >= 0) {
                this.selects.splice(index, 1);
            }
        } else {
            event.select.forEach((key: string) => {
                let index: number = this.selects.findIndex((item: any) => Object.is(key, item.id));
                if(index >= 0) {
                    return;
                }
                let item: any = this.cardItems.find((item: any) => Object.is(key, item.id));
                if (item) {
                    this.selects.push(item);
                }
            });
        }
    }

    /**
     * 确认
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    public onOK() {
        this.$emit('close', this.selects);
    }
    
    /**
     * 取消
     *
     * @type {*}
     * @memberof AppGroupPicker
     */  
    public onCancel() {
        this.$emit('close');
    }
}
</script>