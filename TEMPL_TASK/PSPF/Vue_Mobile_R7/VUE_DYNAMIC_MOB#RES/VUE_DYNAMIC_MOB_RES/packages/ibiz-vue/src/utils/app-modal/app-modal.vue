<template>
  <div class="app-modal">
    <component
      :is="viewName"
      class="view-container2"
      :dynamicProps="{ _context: JSON.stringify(context), _viewparams: JSON.stringify(viewparams) }"
      :staticProps="{ viewDefaultUsage: 'INCLUDEDVIEW', viewModelData: view.viewModelData }"
      @viewdataschange="dataChange($event)"
      @close="close($event)"
      :ref="viewName"
    >
    </component>
  </div>
</template>
<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { Subject } from 'rxjs';
@Component({
  components: {},
})
export default class AppModalComponent extends Vue {
  /**
   * 视图参数
   *
   * @type {*}
   * @memberof AppModalComponent
   */
  @Prop() public view!: any;

  /**
   * 视图动态参数
   *
   * @type {any}
   * @memberof AppDrawerCompponent
   */
  @Prop({ default: {} }) public context?: any;

  /**
   * 视图静态参数
   *
   * @type {any}
   * @memberof AppDrawerCompponent
   */
  @Prop({ default: {} }) public viewparams?: any;

  /**
   * 数据传递对象
   *
   * @type {(null | Subject<any>)}
   * @memberof AppModalComponent
   */
  public subject: null | Subject<any> = new Subject<any>();

  /**
   * 临时结果
   *
   * @type {*}
   * @memberof AppModalComponent
   */
  public tempResult: any = { ret: '' };

  /**
   * 视图名称
   *
   * @type {string}
   * @memberof AppModalComponent
   */
  public viewName: string = '';

  /**
   * 获取数据传递对象
   *
   * @returns {(null | Subject<any>)}
   * @memberof AppModalComponent
   */
  public getSubject(): null | Subject<any> {
    return this.subject;
  }

  /**
   * Vue生命周期created
   *
   * @memberof AppModalComponent
   */
  public created() {
    this.viewName = this.view.viewname;
  }

  /**
   * 视图关闭
   *
   * @memberof AppModalComponent
   */
  public close(result: any) {
    if (result && Array.isArray(result) && result.length > 0) {
      Object.assign(this.tempResult, { ret: 'OK' }, { datas: JSON.parse(JSON.stringify(result)) });
    }
    this.onVisibleChange(true);
  }

  /**
   * 视图数据变化
   *
   * @memberof AppModalComponent
   */
  public dataChange(result: any) {
    this.tempResult = { ret: '' };
    if (result && Array.isArray(result) && result.length > 0) {
      Object.assign(this.tempResult, { ret: 'OK' }, { datas: JSON.parse(JSON.stringify(result)) });
    }
  }

  /**
   * 模态显示隐藏切换回调
   *
   * @memberof AppModalComponent
   */
  public async onVisibleChange($event: any): Promise<any> {
    const component: any = this.$refs[this.viewName];
    if (component) {
      this.handleShowState($event);
    }
  }

  /**
   * 处理数据，向外抛值
   *
   * @memberof AppModalComponent
   */
  public handleShowState($event: any) {
    if (!$event) {
      return;
    }
    if (this.subject) {
      if (this.tempResult && Object.is(this.tempResult.ret, 'OK')) {
        this.subject.next(this.tempResult);
      } else {
        this.subject.complete();
      }
    }
  }
}
</script>
<style lang="less">
@import './app-modal.less';
</style>