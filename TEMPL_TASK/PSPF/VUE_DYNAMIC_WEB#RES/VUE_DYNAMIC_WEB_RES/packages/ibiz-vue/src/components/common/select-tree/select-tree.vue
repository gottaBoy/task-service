<template>
  <div class="select-tree">
    <template v-if="!treeOnly">
      <Dropdown :visible="visible" trigger="custom" style="left:0px;width: 100%;position: relative;" :transfer-class-name="transferClassName" :transfer="transfer" @on-clickoutside="() => {triggerMenu(false);}" @on-visible-change="onVisibleChange">
        <el-select popper-class="select-no-dropdown" :value="keySet" :multiple="multiple" :clearable="!multiple" :transfer="transfer" filterable :filter-method="selectFilter" style="width:100%;" @change="onSelectChange" @focus="() => {triggerMenu(true);}" :disabled="disabled" >
              <el-option v-for="item in selectItems" :key="item.id" :label="item.label" :value="item.id"></el-option>
        </el-select>
        <DropdownMenu slot="list">
            <el-tree style="width:100%;" ref="tree" :data="NodesData" @current-change="onNodeClick" :highlight-current="true" :show-checkbox="multiple" @check="onCheck" node-key="id" :filter-node-method="filterNode">
              <span slot-scope="{ node, data }" :title="data.label" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">{{ data.label }}</span>
            </el-tree>
        </DropdownMenu>
      </Dropdown>
    </template>
    <template v-if="treeOnly">
        <el-tree ref="tree" :data="NodesData" @current-change="onNodeClick" :highlight-current="true" :show-checkbox="multiple" @check="onCheck" node-key="id" :filter-node-method="filterNode">
          <span slot-scope="{ node, data }" :title="data.label" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">{{ data.label }}</span>
        </el-tree>
    </template>
  </div>
</template>

<script>
import 'element-ui/lib/theme-chalk/index.css';
import {Select,Option,Tree} from 'element-ui';
import 'view-design/dist/styles/iview.css';
import { Util } from 'ibiz-core';
import { Dropdown, DropdownMenu, Input, Icon } from 'view-design';
export default {
    name: 'app-select-tree',
    components:{
      Dropdown,
      DropdownMenu,
      Input,
      Icon,
      'el-select':Select,
      'el-option':Option,
      'el-tree':Tree
    },
    props:{
      value:{
        type: String,
      },
      disabled:{
        type: Boolean,
        default: false,
      },
      treeOnly:{
        type: Boolean,
        default: false,
      },
      defaultChecked:{
        type: Boolean,
        default: false,
      },
      multiple:{
        type: Boolean,
        default: false,
      },
      NodesData:{
        type: Array,
      },
      transfer: {
        type: Boolean,
        default: false,
      }
    },
    model:{
      prop: 'value',
      event: 'select',
    },
    data(){
      return {
        keySet: this.multiple ? [] : "",
        selectItems: [],
        queryValue: '',
        visible: false,
        transferClassName: Util.createUUID(),
      }
    },
    watch: {
      value:{ handler(newVal,oldVal){
          this.selectItems = [];
          this.keySet = this.multiple ? [] : "";
          let _keySet = [];
          if (newVal) {
              try {
                  this.selectItems = JSON.parse(newVal);
              } catch (d) {
                  console.error("JSON解析错误！")
                  this.selectItems = [];
              }
              this.selectItems.forEach((item) => {
                  _keySet.push(item.id);
              });
              this.keySet = this.multiple ? _keySet : _keySet[0];
          }
          this.$nextTick(() => {
              const tree = this.$refs.tree;
              if(this.multiple){
                  tree.setCheckedNodes(this.selectItems);
              }else{
                  tree.setCurrentKey(this.keySet);
              }
          })
          this.$forceUpdate();
      },immediate: true},
      NodesData:{ handler(newVal,oldVal){
          if(newVal && newVal.length > 0){
              this.$nextTick(function () {
                this.setDefaultChecked();
              });
          }
      },immediate: true,deep: true}
    },
    methods: {
      triggerMenu(visible){
          if(this.disabled){
              return;
          }
          if (!visible) {
              this.visible = !this.visible;
          } else {
              this.visible = visible;
          }
      },
      onSelectChange(selects) {
          let val= [];
          if (selects.length > 0) {
              selects.forEach((select) => {
                  let index = this.selectItems.findIndex((item) => Object.is(item.id, select));
                  if (index >= 0) {
                      val.push(this.selectItems[index]);
                  }
              });
          }
          let value = val.length > 0 ? JSON.stringify(val) : "[]";
          this.$emit('select', value);
      },
      onVisibleChange(visible){
        if(!visible){
          setTimeout(() => {
            this.$refs.tree.filter("");
          }, 250);
        }
      },
      selectFilter(val){
        this.$refs.tree.filter(val);
      },
      filterNode(value, data) {
          if (!value) return true;
          return data.label.indexOf(value) !== -1;
      },
      onNodeClick(data, node){
          if(!this.multiple && !data.disabled){
              this.selectItems = [JSON.parse(JSON.stringify(data))];
              this.$emit("select",JSON.stringify(this.selectItems));
              this.triggerMenu(false);
          }
      },
      onCheck(data, checkedState) {
          // 处理多选数据
          if(this.multiple){
              let availableNodes = checkedState.checkedNodes.filter((item) => !item.disabled);
              this.selectItems = JSON.parse(JSON.stringify(availableNodes));
              this.$emit('select', JSON.stringify(this.selectItems));
          }
      },
      setDefaultChecked(){
        if(this.treeOnly && this.defaultChecked && !this.value && this.NodesData && this.NodesData.length >0){
          this.selectItems = [JSON.parse(JSON.stringify(this.NodesData[0]))];
          this.keySet = this.multiple ? this.selectItems[0].id : [this.selectItems[0].id];
          const tree = this.$refs.tree;
          if(this.multiple){
            tree.setCheckedNodes(this.selectItems);
          }else{
            tree.setCurrentKey(this.keySet);
          }
          this.$emit("select",JSON.stringify(this.selectItems));
        }
      }
    },
    mounted() {
        // const curSelectTree = this.$el.getElementsByClassName('ivu-dropdown');
        // const transferDom = document.getElementsByClassName(this.transferClassName);
        // if (curSelectTree[0] && transferDom[0]) {
        //     transferDom[0].style.width = `${curSelectTree[0].offsetWidth}px`
        // }
    }
}
</script>

<style>
.select-no-dropdown.el-select-dropdown{
  display: none;
}
</style>