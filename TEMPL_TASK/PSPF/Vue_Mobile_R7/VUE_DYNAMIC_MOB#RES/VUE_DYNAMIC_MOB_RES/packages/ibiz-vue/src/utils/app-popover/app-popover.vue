<template>
  <van-popup
    class="app-popup outside-bottom-center"
    close-icon="close"
    v-model="isShow"
    v-if="visible"
    closeable
    :position="position"
    round
    :lock-scroll="false"
    :close-on-click-overlay="false"
    :close-on-popstate="true"
    @close="onVisibleChange"
    :style="{ height: view.height ? view.height + 'px' : '', width: view.width ? view.width + 'px' : '' }"
  >
    <div class="popup-content">
      <component
        :is="viewName"
        class="view-container2 popup-body"
        :dynamicProps="{ _context: JSON.stringify(context), _viewparams: JSON.stringify(viewparams)}"
        :staticProps="{ viewDefaultUsage: 'INCLUDEDVIEW', viewModelData: view.viewModelData }"
        @viewdataschange="dataChange($event)"
        @close="close($event)"
        :ref="viewName"
      >
      </component>
    </div>
  </van-popup>
</template>
<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { Subject } from 'rxjs';
@Component({
  components: {},
})
export default class AppPopoverComponent extends Vue {
  /**
   * 视图参数
   *
   * @type {*}
   * @memberof AppPopoverComponent
   */
  @Prop() public view!: any;

  /**
   * 视图动态参数
   *
   * @type {any}
   * @memberof AppPopoverComponent
   */
  @Prop({ default: {} }) public context?: any;

  /**
   * 视图静态参数
   *
   * @type {any}
   * @memberof AppPopoverComponent
   */
  @Prop({ default: {} }) public viewparams?: any;

  /**
   * 是否显示头部
   *
   * @type {Subject<any>}
   * @memberof AppPopoverComponent
   */
  @Prop({ default: true }) visibleHeader: boolean;

  /**
   * popup位置
   *
   * @memberof AppPopoverComponent
   */
  position: string = 'center';

  /**
   * 关闭图标位置
   *
   * @type {boolean}
   * @memberof AppPopoverComponent
   */
  closeIconPosition: 'top-right' | 'outside-bottom-center' = 'outside-bottom-center';

  /**
   * 是否显示
   *
   * @type {boolean}
   * @memberof AppPopoverComponent
   */
  isShow: boolean = false;

  /**
   * 元素销毁变量
   *
   * @type {boolean}
   * @memberof AppPopoverComponent
   */
  visible: boolean = true;

  /**
   * 数据传递对象
   *
   * @type {(null | Subject<any>)}
   * @memberof AppPopoverComponent
   */
  public subject: null | Subject<any> = new Subject<any>();

  /**
   * 临时结果
   *
   * @type {*}
   * @memberof AppPopoverComponent
   */
  public tempResult: any = { ret: '' };

  /**
   * 视图名称
   *
   * @type {string}
   * @memberof AppPopoverComponent
   */
  public viewName: string = '';

  /**
   * 获取数据传递对象
   *
   * @returns {(null | Subject<any>)}
   * @memberof AppPopoverComponent
   */
  public getSubject(): null | Subject<any> {
    return this.subject;
  }

  /**
   * Vue生命周期created
   *
   * @memberof AppPopoverComponent
   */
  public created() {
    this.initDefaultParams();
  }

  /**
   * 初始化默认参数
   *
   * @memberof AppPopoverComponent
   */
  initDefaultParams() {
    this.viewName = this.view.viewname;
  }

  /**
   * Vue生命周期mounted
   *
   * @memberof AppPopoverComponent
   */
  mounted() {
    this.isShow = true;
  }

  /**
   * 视图关闭
   *
   * @memberof AppPopoverComponent
   */
  public close(result: any) {
    if (result && Array.isArray(result) && result.length > 0) {
      Object.assign(this.tempResult, { ret: 'OK' }, { datas: JSON.parse(JSON.stringify(result)) });
    }
    this.onVisibleChange();
  }

  /**
   * 视图数据变化
   *
   * @memberof AppPopoverComponent
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
   * @memberof AppPopoverComponent
   */
  public async onVisibleChange(): Promise<any> {
    const component: any = this.$refs[this.viewName];
    if (component) {
      this.handleShowState();
    }
  }

  /**
   * 处理数据，向外抛值
   *
   * @memberof AppPopoverComponent
   */
  public handleShowState() {
    if (this.subject) {
      if (this.tempResult && Object.is(this.tempResult.ret, 'OK')) {
        this.subject.next(this.tempResult);
      } else {
        this.subject.complete();
      }
    }
    this.isShow = false;
    setTimeout(() => {
      this.visible = false;
    }, 500);
  }
}
</script>
<style lang="less">
@import './app-popover.less';
</style>