<template>
  <div class="app-search-history">
    <ion-toolbar class="app-search-history__toolbar">
      <ion-searchbar
        :placeholder="realPlaceholder"
        debounce="500"
        @ionChange="quickValueChange($event)"
        ref="searchbar"
      ></ion-searchbar>
    </ion-toolbar>
  </div>
</template>
<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { IPSAppDEMultiDataView, IPSAppDEField } from '@ibiz/dynamic-model-api';
@Component({
  components: {},
})
export default class AppSearchHistory extends Vue {
  /**
   * 视图模型数据
   *
   * @type {any}
   * @memberof AppSearchHistory
   */
  @Prop() public parentModel: any;

  /**
   * placeholder
   *
   * @type {string}
   * @memberof AppSearchHistory
   */
  @Prop() public placeholder?: string;

  /**
   * 应用实体
   *
   * @type {string}
   * @memberof AppSearchHistory
   */
  @Prop() public appDataEntity?: any;

  /**
   * placeholder
   *
   * @type {string}
   * @memberof AppSearchHistory
   */
  public realPlaceholder: string = '';

  /**
   * 初始化Placeholder
   *
   * @type {string}
   * @memberof AppSearchHistory
   */
  public initRealPlaceholder() {
    if (this.placeholder) {
      this.realPlaceholder = this.placeholder;
    } else {
      const quickSearchFields: Array<IPSAppDEField> =
        (this.parentModel as IPSAppDEMultiDataView).getPSAppDataEntity()?.getQuickSearchPSAppDEFields() || [];
      if (quickSearchFields.length > 0) {
        quickSearchFields.forEach((field: IPSAppDEField, index: number) => {
          const _field: IPSAppDEField | null | undefined = this.appDataEntity?.findPSAppDEField(field.codeName);
          if (_field) {
              if(_field.quickSearchPlaceHolder){
                  this.realPlaceholder += (this.$tl(_field.getQSPHPSLanguageRes()?.lanResTag, _field.quickSearchPlaceHolder) + (index === quickSearchFields.length - 1 ? '' : ', '));
              }else{
                  this.realPlaceholder += (this.$tl(_field.getLNPSLanguageRes()?.lanResTag, _field.logicName) + (index === quickSearchFields.length - 1 ? '' : ', '));
              }
          }
        });
      }
    }
  }

  /**
   * 快速搜索值变化
   *
   * @param {*} event
   * @returns
   * @memberof AppSearchHistory
   */
  public quickValueChange($event: any) {
    this.$emit('quickValueChange', { tag: 'quickValueChange', value: $event });
  }

  /**
   * 生命周期
   *
   * @memberof AppSearchHistory
   */
  created() {
    this.initRealPlaceholder();
  }
}
</script>