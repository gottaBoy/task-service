<template>
  <div class="app-mob-department-select" @click="openView">
    <div class="form-value-content app-mob-department-select__value">{{ value }}</div>
    <van-icon class="app-mob-department-select__icon select-color" name="arrow" />
  </div>
</template>

<script lang="ts">
import { Vue, Component, Watch, Prop, Model } from 'vue-property-decorator';
import { Http } from 'ibiz-core';
import { CodeListService } from 'ibiz-core';
@Component({})
export default class AppMobDepartmentSelect extends Vue {
  /**
   * 名称标识
   *
   * @type {*}
   * @memberof AppMobDepartmentSelect
   */
  @Prop() public name!: string;

  /**
   * 关联属性
   *
   * @type {*}
   * @memberof AppMobDepartmentSelect
   */
  @Prop() public valueitem: any;

  /**
   * 接口url
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  @Prop() public url?: any;

  /**
   * 代码表标识
   *
   * @memberof AppDepartmentSelect
   */
  @Prop() public tag?: string;

  /**
   * 代码表类型
   *
   * @memberof AppDepartmentSelect
   */
  @Prop() public codelistType?: string;

  /**
   * 过滤项
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  @Prop() public filter?: any;

  /**
   * 过滤项
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  @Prop() public fillMap?: any;

  /**
   * 是否多选
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  @Prop({ default: false }) public multiple?: any;

  /**
   * 是否禁用
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  @Prop({ default: false }) public disabled?: boolean;

  /**
   * 只读模式
   *
   * @type {boolean}
   */
  @Prop({ default: false }) public readonly?: boolean;

  /**
   * 表单数据
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  @Prop() public data!: any;

  /**
   * 上下文变量
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  @Prop() public context!: any;

  /**
   * 值
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  @Prop() public value!: any;

  /**
   * 请求方式
   *
   * @type {string}
   * @memberof AppDepartmentSelect
   */
  @Prop({ default: 'get' })
  public requestMode!: 'get' | 'post' | 'delete' | 'put';

  /**
   * 选中数值
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  public selectTreeValue: any = '';

  /**
   * 树节点数据
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  public nodesData: any[] = [];

  /**
   * 当前树节点数据的url
   *
   * @type {*}
   * @memberof AppDepartmentSelect
   */
  public oldurl: any;

  /**
   * 获取节点数据
   *
   * @memberof AppDepartmentSelect
   */
  public handleFilter() {
    if (this.filter) {
      if (this.data && this.data[this.filter]) {
        return this.data[this.filter];
      } else if (this.context && this.context[this.filter]) {
        return this.context[this.filter];
      } else {
        return this.context.srforgid;
      }
    } else {
      return this.context.srforgid;
    }
  }

  /**
   * 获取节点数据
   *
   * @memberof AppDepartmentSelect
   */
  public searchNodesData() {
    // 处理过滤参数，生成url
    let param = this.handleFilter();
    let _url = this.url.replace('${orgid}', param);
    if (this.oldurl === _url) {
      return;
    }
    this.oldurl = _url;
    // 缓存机制
    const result: any = this.$store.getters.getDepData(_url);
    if (result) {
      this.nodesData = result;
      return;
    }
    Http.getInstance()
      [this.requestMode](_url, {})
      .then((response: any) => {
        let data = response.data;
        this.nodesData = this.handleTreeData(data);
        this.$store.commit('addDepData', { srfkey: _url, depData: data });
      })
      .catch((response: any) => {
        this.$Notice.error(response?.message);
        // 插件代码 （模拟数据） 需删除
        // const data = response.data;
        // this.nodesData = this.handleTreeData(data);
        // this.$store.commit('addDepData', { srfkey: _url, depData: data });
      });
  }

  /**
   * 递归处理树形数据 根据fillmap填充label id
   *
   * @memberof AppDepartmentSelect
   */
  public handleTreeData(datas: any) {
    if (datas.length && datas.length > 0) {
      datas.forEach((_item: any) => {
        if (this.fillMap) {
          _item.label = _item[this.fillMap.label] ? _item[this.fillMap.label] : _item.label;
          _item.id = _item[this.fillMap.id] ? _item[this.fillMap.id] : _item.id;
        }
        if (_item.children && _item.length && _item.children.length > 0) {
          this.handleTreeData(_item.children);
        }
      });
    }
    return datas;
  }

  /**
   * 值变化
   *
   * @param {*} newVal
   * @param {*} oldVal
   * @memberof AppDepartmentSelect
   */
  @Watch('data', { immediate: true, deep: true })
  public onValueChange(newVal: any, oldVal: any) {
    if (newVal) {
      this.computedSelectedData();
      this.$nextTick(() => {
        this.searchNodesData();
      });
    }
  }

  /**
   * 计算选中值
   *
   * @memberof AppOrgSelect
   */
  public computedSelectedData() {
    // 单选
    if (!this.multiple) {
      const id = this.data[this.valueitem];
      const label = this.data[this.name];
      this.selectTreeValue = JSON.stringify([{ id, label }]);
      // }
    } else {
      // 多选
      const values = this.data[this.valueitem]?.split(',');
      const labels = this.data[this.name]?.split(',');
      const multipleData = labels?.map((label: any, index: any) => {
        return { label, id: values[index] };
      });
      this.selectTreeValue = JSON.stringify(multipleData);
    }
  }

  /**
   * select事件处理
   *
   * @param {*} $event
   * @memberof AppDepartmentSelect
   */
  public onSelect($event: any) {
    let selectArr = JSON.parse($event);
    let item: any = {};
    item[this.name] = null;
    if (this.valueitem) {
      item[this.valueitem] = null;
    }
    if (this.fillMap) {
      for (let key in this.fillMap) {
        item[key] = null;
      }
    }
    if (this.multiple) {
      selectArr.forEach((select: any) => {
        item[this.name] = item[this.name] ? `${item[this.name]},${select.label}` : select.label;
        if (this.valueitem) {
          item[this.valueitem] = item[this.valueitem] ? `${item[this.valueitem]},${select.id}` : select.id;
        }
        if (this.fillMap) {
          for (let key in this.fillMap) {
            item[key] = item[key] ? `${item[key]},${select[this.fillMap[key]]}` : select[this.fillMap[key]];
          }
        }
      });
    } else {
      item[this.name] = selectArr.length > 0 ? selectArr[0].label : null;
      if (this.valueitem) {
        item[this.valueitem] = selectArr.length > 0 ? selectArr[0].id : null;
      }
      if (this.fillMap) {
        for (let key in this.fillMap) {
          item[key] = selectArr.length > 0 ? selectArr[0][this.fillMap[key]] : null;
        }
      }
    }
    // 组件自身抛值事件
    this.$emit('formitemvaluechange', { name: this.name, value: item.label || item[this.name] });
    // 抛出值项
    this.$emit('formitemvaluechange', { name: this.valueitem, value: item.id || item[this.valueitem] });
  }

  /**
   * 填充label
   *
   * @memberof AppOrgSelect
   */
  public fillLabel(tempObject: any, valueItem: any, callback: any) {
    if (
      !tempObject.label &&
      tempObject.id &&
      this.tag &&
      this.codelistType &&
      Object.is(this.codelistType, 'DYNAMIC')
    ) {
      let codeListService: CodeListService = new CodeListService();
      codeListService
        .getItems(this.tag)
        .then((items: any) => {
          if (items && items.length > 0) {
            let result: any = items.find((item: any) => {
              return item.id === valueItem;
            });
            Object.assign(tempObject, { label: result.label });
          }
          callback(tempObject);
        })
        .catch((error: any) => {
          // LogUtil.log(error);
        });
    }
  }

  /**
   * 打开选择视图
   *
   * @type {*}
   * @memberof AppMobGroupSelect
   */
  public async openView() {
    const view: any = {
      viewname: 'app-tree',
      title: this.$t('components.AppMobOrgSelect.orgSelect') as string,
    };
    const context: any = JSON.parse(JSON.stringify(this.context));
    const param: any = {};
    Object.assign(param, {
      selectTreeValue: this.selectTreeValue,
      multiple: this.multiple,
      nodesData: this.nodesData,
    });
    this.$appmodal.openModal(view, context, param).then((result: any) => {
      if (result.ret != 'OK') {
        return;
      }
      this.onSelect(JSON.stringify(result.datas));
    });
  }
}
</script>