<template>
  <van-popup
    class="app-drawer outside-bottom-center"
    close-icon="close"
    v-model="isShow"
    v-if="visible"
    :round="round"
    :lock-scroll="false"
    :position="position"
    :close-on-click-overlay="false"
    :close-on-popstate="true"
    :style="{ height: view.height ? view.height + 'px' : '', width: view.width ? view.width+ 'px' : '' }"
    @close="onVisibleChange"
  >
    <div class="drawer-content" >
      <component
        :is="viewName"
        class="view-container2 drawer-body"
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
export default class AppDrawerComponent extends Vue {
  /**
   * 视图参数
   *
   * @type {*}
   * @memberof AppDrawerComponent
   */
  @Prop() public view!: any;

  /**
   * 视图动态参数
   *
   * @type {any}
   * @memberof AppDrawerComponent
   */
  @Prop({ default: {} }) public context?: any;

  /**
   * 视图静态参数
   *
   * @type {any}
   * @memberof AppDrawerComponent
   */
  @Prop({ default: {} }) public viewparams?: any;

  /**
   * 是否显示头部
   *
   * @type {Subject<any>}
   * @memberof AppDrawerComponent
   */
  @Prop({ default: true }) visibleHeader: boolean;

  /**
   * drawer位置
   *
   * @memberof AppDrawerComponent
   */
  position: string = 'bottom';

  /**
   * 关闭图标位置
   *
   * @type {boolean}
   * @memberof AppDrawerComponent
   */
  closeIconPosition: 'top-right' | 'outside-bottom-center' = 'top-right';

  /**
   * 是否显示
   *
   * @type {boolean}
   * @memberof AppDrawerComponent
   */
  isShow: boolean = false;

  round:boolean = false;

  /**
   * 元素销毁变量
   *
   * @type {boolean}
   * @memberof AppDrawerComponent
   */
  visible: boolean = true;

  /**
   * 数据传递对象
   *
   * @type {(null | Subject<any>)}
   * @memberof AppDrawerComponent
   */
  public subject: null | Subject<any> = new Subject<any>();

  /**
   * 临时结果
   *
   * @type {*}
   * @memberof AppDrawerComponent
   */
  public tempResult: any = { ret: '' };

  /**
   * 视图名称
   *
   * @type {string}
   * @memberof AppDrawerComponent
   */
  public viewName: string = '';

  /**
   * 获取数据传递对象
   *
   * @returns {(null | Subject<any>)}
   * @memberof AppDrawerComponent
   */
  public getSubject(): null | Subject<any> {
    return this.subject;
  }

  /**
   * Vue生命周期created
   *
   * @memberof AppDrawerComponent
   */
  public created() {
    this.initDefaultParams();
  }

  /**
   * 初始化默认参数
   *
   * @memberof AppDrawerComponent
   */
  initDefaultParams() {
    this.viewName = this.view.viewname;
    const openMode  = this.view.placement;
    switch (openMode) {
      case 'DRAWER_TOP':
        this.position = 'top';
        break;
      case 'DRAWER_RIGHT':
        this.position = 'right';
        break;
      case 'DRAWER_BOTTOM':
        this.round = true;
        this.position = 'bottom';
        break;
      case 'DRAWER_LEFT':
        this.position = 'left';
        break;
    }
  }

  /**
   * Vue生命周期mounted
   *
   * @memberof AppDrawerComponent
   */
  mounted() {
    this.isShow = true;
  }

  /**
   * 视图关闭
   *
   * @memberof AppDrawerComponent
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
   * @memberof AppDrawerComponent
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
   * @memberof AppDrawerComponent
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
   * @memberof AppDrawerComponent
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
@import './app-drawer.less';
</style>