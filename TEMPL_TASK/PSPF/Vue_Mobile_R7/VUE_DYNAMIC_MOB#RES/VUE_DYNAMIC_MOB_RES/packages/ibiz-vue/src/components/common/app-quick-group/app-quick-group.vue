<template>
  <div class="app-quick-group">
    <div class="app-quick-group-container">
      <div
        :class="{ 'app-quick-group__tab': true, 'app-quick-group__tab--selected': isSelectedItem(item) || item.childSelected }"
        v-for="(item, index) in showItems"
        :key="index"
        @click="handleClick(item)"
      >
        <div :style="{ color: item.color }">
          <ion-icon
            v-if="item.iconcls && !Object.is(item.iconcls, '')"
            :name="ViewTool.setIcon(item.iconcls)"
          ></ion-icon>
          <img v-else-if="item.icon && !Object.is(item.icon, '')" :src="item.icon" />
          <span v-if="item.selectChildLabel" class="app-quick-group__tab__label">{{ item.selectChildLabel }}</span>
          <span v-else class="app-quick-group__tab__label">{{ item.label }}</span>
          <ion-icon v-if="item.children" name="caret-down-outline" style="margin-left: 4px"></ion-icon>
        </div>
        <ion-badge class="app-quick-group__tab__badge" v-if="isSelectedItem(item) && pageTotal !== 0 && !item.children">{{
          pageTotal
        }}</ion-badge>
        <ion-badge class="app-quick-group__tab__badge" v-if="item.childSelected && pageTotal">{{ pageTotal }}</ion-badge>
      </div>
    </div>
    <div ref="child-list" :class="{ 'app-quick-group__list': true, 'app-quick-group__list--open': subItems.length > 0 }">
      <div
        :class="{ 'app-quick-group__list__item': true, 'app-quick-group__list__item--selected': item.selected }"
        v-for="(item, index) in subItems"
        :key="index"
        @click="handleClick(item)"
      >
        <span>
          <ion-icon
            v-if="item.iconcls && !Object.is(item.iconcls, '')"
            :name="ViewTool.setIcon(item.iconcls)"
          ></ion-icon>
          <img v-else-if="item.icon && !Object.is(item.icon, '')" :src="item.icon" />
          <span>{{ item.label }}</span>
        </span>
        <ion-badge class="app-quick-group__tab__badge" v-if="pageTotal !== 0 && item.selected">{{ pageTotal }}</ion-badge>
        <ion-icon
          size="small"
          v-if="item.selected"
          style="margin-left: auto; color: green"
          name="checkmark-outline"
        ></ion-icon>
      </div>
    </div>
    <ion-backdrop
      style="height: 100vh; z-index: -1"
      v-show="subItems.length > 0"
      visible="true"
      tappable="true"
      @ionBackdropTap="closeBackdrop"
    ></ion-backdrop>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import { CodeListService, Util } from 'ibiz-core';
import { IPSAppCodeList, IPSCodeItem } from '@ibiz/dynamic-model-api';
@Component({
  components: {},
})
export default class AppQuickGroupTab extends Vue {
  /**
   * 分页数据
   *
   * @type {any[]}
   * @memberof ViewQuickGroupTab
   */
  @Prop({ default: 0 }) public pageTotal!: number;

  /**
   * 快速分组代码表数据
   *
   * @type {any[]}
   * @memberof ViewQuickGroupTab
   */
  @Prop() public items!: any[];

  /**
   * 上下文
   *
   * @type {any[]}
   * @memberof ViewQuickGroupTab
   */
  @Prop() public context!: any;

  /**
   * 视图参数
   *
   * @type {any[]}
   * @memberof ViewQuickGroupTab
   */
  @Prop() public viewparams!: any;

  /**
   * 代码表
   *
   * @type {any[]}
   * @memberof ViewQuickGroupTab
   */
  @Prop() public codeList!: any;

  quickGroupModel: any = [];

  /**
   * 渲染列表
   *
   * @type {any[]}
   * @memberof AppQuickGroup
   */
  public showItems: any[] = [];

  /**
   * 代码表服务对象
   *
   * @type {CodeListService}
   * @memberof MDViewBase
   */
  public codeListService!: CodeListService;

  /**
   * 子项列表
   *
   * @type {any[]}
   * @memberof AppQuickGroup
   */
  public subItems: any[] = [];

  created() {
    let _this: any = this;
    if (!this.codeList) {
      this.showItems = this.handleDataSet(this.items);
      const defaultSelect: any = this.getQuickGroupDefaultSelect(this.showItems);
      this.selectedUiItem = defaultSelect || this.showItems[0];
      this.$emit('valueChange', { tag: 'quickGroupValueChange', value: this.selectedUiItem });
    } else {
      this.codeListService = new CodeListService({ $store: _this.$store });
      this.loadQuickGroupModel();
    }
  }

  /**
   * 加载快速分组模型
   *
   * @memberof MDViewBase
   */
  public async loadQuickGroupModel() {
    try {
      await this.codeList?.fill?.();
      if (!(this.codeList && this.codeList.codeName)) {
        return;
      }
      let res: any = await this.codeListService.getDataItems({
        tag: this.codeList.codeName,
        type: this.codeList.codeListType,
        data: this.codeList,
        context: this.context,
      });
      this.quickGroupModel = this.handleDynamicData(Util.deepCopy(res));
      this.showItems = this.handleDataSet(this.quickGroupModel);
    } catch (error: any) {}
  }

  /**
   * 处理快速分组模型动态数据部分(%xxx%)
   *
   * @memberof MDViewBase
   */
  public handleDynamicData(inputArray: Array<any>) {
    if (inputArray.length > 0) {
      const codeItems: Array<IPSCodeItem> = (this.codeList as IPSAppCodeList).getPSCodeItems() || [];
      const defaultSelect: any = this.getQuickGroupDefaultSelect();
      if (defaultSelect) {
        let select = inputArray.find((item: any) => {
          return item.value === defaultSelect.value;
        });
        if (select) select.default = true;
      }
      this.selectedUiItem = defaultSelect || inputArray[0];
      this.$emit('valueChange', { tag: 'quickGroupValueChange', value: this.selectedUiItem });
      inputArray.forEach((item: any) => {
        if (item.data && Object.keys(item.data).length > 0) {
          Object.keys(item.data).forEach((name: any) => {
            let value: any = item.data[name];
            if (value && typeof value == 'string' && value.startsWith('%') && value.endsWith('%')) {
              const key = value.substring(1, value.length - 1).toLowerCase();
              if (this.context[key]) {
                value = this.context[key];
              } else if (this.viewparams[key]) {
                value = this.viewparams[key];
              }
            }
            item.data[name] = value;
          });
        }
      });
    }
    return inputArray;
  }

  /**
   * 获取快速分组默认选中项
   *
   * @memberof MDViewBase
   */
  public getQuickGroupDefaultSelect(items?: any[]) {
    let codeItems: any;
    if (!items) {
      const codeItems: Array<IPSCodeItem> = (this.codeList as IPSAppCodeList).getPSCodeItems() || [];
    } else {
      codeItems = items;
    }
    let defaultSelect: any = null;
    if (codeItems?.length > 0) {
      for (const item of codeItems) {
        const childItems = item.getPSCodeItems?.() || [];
        if (childItems.length > 0) {
          defaultSelect = childItems.find((_item: any) => {
            return _item.default;
          });
        }
        if (item.default || defaultSelect) {
          defaultSelect = item;
          break;
        }
      }
    }
    return defaultSelect || this.showItems[0];
  }

  /**
   * UI选中项
   *
   * @type {*}
   * @memberof AppQuickGroup
   */
  public selectedUiItem: any = {};

  /**
   * 是否选中当前项
   *
   * @param item 传入当前项
   * @memberof AppQuickGroup
   */
  public isSelectedItem(item: any): boolean {
    if (this.selectedUiItem && this.selectedUiItem.id === item.id) {
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
  public handleDataSet(result: Array<any>): any[] {
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
  public setChildCodeItems(pValue: string, result: Array<any>, codeItem: any): void {
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
   * @param isswitch 是否切换UI选中项
   * @memberof AppQuickGroup
   */
  public handleClick($event: any, isfirst: boolean = false): void {
    this.selectedUiItem = $event;
    if ($event.children) {
      if (this.subItems.length > 0) {
        this.subItems.length = 0;
      } else {
        if (!isfirst) {
          this.subItems.push(...$event.children);
        }
      }
    } else {
      this.subItems.length = 0;
      this.quickGroupModel.forEach((item: any) => {
        item.selected = false;
        item.childSelected = false;
        item.selectChildLabel = '';
      });
      $event.selected = true;
      if ($event.pvalue) {
        this.quickGroupModel.forEach((item: any) => {
          if (item.value === $event.pvalue) {
            item.childSelected = true;
            item.selectChildLabel = $event.label;
          }
        });
      }
      this.$emit('valueChange', { tag: 'quickGroupValueChange', value: $event });
    }
    this.$forceUpdate();
  }

  /**
   * 关闭遮罩层
   *
   * @type {any[]}
   * @memberof AppQuickGroup
   */
  public closeBackdrop() {
    this.subItems.length = 0;
    this.$forceUpdate();
  }
}
</script>