<template>
  <div class="app-mob-auth-org-picker">
    <app-mob-org-picker v-if="containerType === 'APPINDEXVIEW' || Object.is(sourceMode, selectMode)"></app-mob-org-picker>
    <van-dropdown-menu v-else class="app-mob-dropdown-menu" :overlay="false">
      <van-dropdown-item v-model="selectedOrgId" :options="selectedOrgArray">
        <van-cell v-if="selectedOrgArray.length < 1" title="暂无数据" title-class="org-picker-title-no-data"></van-cell>
      </van-dropdown-item>
    </van-dropdown-menu>
  </div>
</template>
<script lang="ts">
// import { GlobalService } from 'ibiz-service';
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppMobAuthOrgPicker extends Vue {
  /**
   * 编辑器模型实例
   *
   * @type {*}
   * @memberof AppMobAuthOrgPicker
   */
  @Prop() public editorInstance: any;

  /**
   * 应用上下文
   *
   * @type {*}
   * @memberof AppMobAuthOrgPicker
   */
  @Prop() public context!: any;

  /**
   * 预定义值
   *
   * @type {*}
   * @memberof AppMobAuthOrgPicker
   */
  @Prop({ default: '' }) public value?: any;

  /**
   * 名称
   *
   * @type {string}
   * @memberof AppMobAuthOrgPicker
   */
  @Prop() public name?: string;

  /**
   * 类型
   *
   * @type {*}
   * @memberof AppMobAuthOrgPicker
   */
  @Prop() public type: any;

  /**
   * 数据来源模式 ROMOTE | LOCAL
   *
   * @type {string}
   * @memberof AppMobAuthOrgPicker
   */
  @Prop() public sourceMode?: string;

  /**
   * 父容器类型（区分首页视图下）
   *
   * @type {string}
   * @memberof AppMobAuthOrgPicker
   */
  @Prop() public containerType?: string;

  /**
   * 选中组织部门名称
   *
   * @type {string}
   * @memberof AppMobAuthOrgPicker
   */
  public selectedOrgName: string = '';

  /**
   * 组织部门名称数组
   *
   * @type {Array<any>}
   * @memberof AppMobAuthOrgPicker
   */
  public selectedOrgArray: Array<any> = [];

  /**
   * 组织部门默认选择来源
   *
   * @type {string}
   * @memberof AppMobAuthOrgPicker
   */
  public selectMode: 'REMOTE' | 'LOCAL' = 'LOCAL';

  /**
   *  获取选中值
   *
   * @type {string}
   * @memberof AppMobAuthOrgPicker
   */
  get selectedOrgId() {
    return this.value;
  }

  /**
   *  设置选中值
   *
   * @type {string}
   * @memberof AppMobAuthOrgPicker
   */
  set selectedOrgId(value: any) {
    this.$emit('valueChange', { name: this.name, value: value });
  }

  /**
   * 监听editor实例
   */
  @Watch('editorInstance', { immediate: true, deep: true })
  public handleOrgData(newValue: any, oldValue: any) {
    if (newValue && !Object.is(newValue, oldValue) && Object.is(this.type, newValue._data?.predefinedType)) {
      this.getRemoteOrgData(null);
    }
  }
  /**
   * 获取远程数据
   *
   * @memberof AppMobAuthOrgPicker
   */
  public async getRemoteOrgData(data: any) {
    // try {
    //   const service: any = await new GlobalService().getService('MOBDYNAMIC', this.context);
    //   if (service && service['getOrgData'] && service['getOrgData'] instanceof Function) {
    //     service['getOrgData']().then((res: any) => {
    //       if (res && res.ok && res.data) {
    //         this.selectedOrgArray = res.data;
    //         if (this.selectedOrgArray && this.value) {
    //           this.selectedOrgId = this.value;
    //         }
    //       }
    //     });
    //   }
    // } catch (error) {
      
    // }
  }
}
</script>
<style lang="less">
@import './app-preset-mob-org-picker.less';
</style>