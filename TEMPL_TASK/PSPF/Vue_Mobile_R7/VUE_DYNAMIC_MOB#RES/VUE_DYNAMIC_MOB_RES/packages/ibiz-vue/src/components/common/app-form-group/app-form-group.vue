<template>
  <van-row class="app-form-group">
    <div class="app-form-group__content">
      <van-collapse v-model="value" class="app-form-group__content__collapse">
      <van-collapse-item :title-class="titleClass" :class="{'collapse__item':true,'app-form-group__content--nocaption':(!_caption || !isShowCaption)}"  :title="_caption" name="1" :disabled="!isCollapseContent"
        :border="false">
        <div slot="value" class="collapse__item__action" v-show="isHaveUiActionGroup">
          <template v-if="uiActionGroup.details.length > 1">
            <div class="collapse__item__action__item">
              <app-mob-icon class="action__icon" name="ellipsis-horizontal-outline" @onClick="openUIAction" />
            </div>
          </template>
          <template v-else-if="uiActionGroup.details.length == 1">
            <div class="collapse__item__action__item" v-for="item in uiActionGroup.details" :key="item.index"
              @click="doUIAction(item, $event)">
              <app-mob-icon :name="item.icon" v-show="item.isShowIcon && item.visabled" />
              <van-button class="action__item__button" plain type="info" v-show="item.isShowCaption && item.visabled">{{ item.caption }}</van-button>
            </div>
          </template>
        </div>
        <app-ps-sys-image slot="icon" :imageModel="iconInfo"></app-ps-sys-image>
        <slot></slot>
      </van-collapse-item>
    </van-collapse>
    </div>
    <van-action-sheet v-model="selectStatus" get-container="#app" :actions="actionBarModelData" cancel-text="取消"
      close-on-click-action @select="doUIAction($event, {}, true)" />
  </van-row>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppFormGroup extends Vue {

  /**
   * 标题
   *
   * @type {string}
   * @memberof AppFormGroup
   */
  @Prop() public caption?: string;

  /**
   * 内置界面样式
   *
   * @type {string}
   * @memberof AppFormGroup
   */
  @Prop() public uiStyle?: string;

  /**
   * 布局模式
   *
   * @type {string}
   * @memberof AppFormGroup
   */
  @Prop() public layoutType?: string;

  /**
   * 标题样式
   *
   * @type {string}
   * @memberof AppFormGroup
   */
  @Prop() public titleStyle?: string;

  /**
   * 是否显示标题
   *
   * @type {boolean}
   * @memberof AppFormGroup
   */
  @Prop({ default: true }) public isShowCaption!: boolean;

  /**
   * 信息面板模式
   *
   * @type {boolean}
   * @memberof AppFormGroup
   */
  @Prop({ default: false }) public isInfoGroupMode!: boolean;

  /**
   * 界面行为组
   *
   * @type {*}
   * @memberof AppFormGroup
   */
  @Prop() public uiActionGroup?: any;

  /**
   * 界面行为组标题
   *
   * @type {*}
   * @memberof AppFormGroup
   */
  @Prop() public groupUiAction?: string;

  /**
   * 分组图标
   *
   * @type {string}
   * @memberof AppFormGroup
   */
  @Prop() public iconInfo?: any;

  /**
   * 标题栏关闭模式
   * 0: 不支持关闭
   * 1: 默认打开
   * 2： 默认关闭
   *
   * @type {(number | 0 | 1 | 2)}
   * @memberof AppFormGroup
   */
  @Prop({ default: 0 }) public titleBarCloseMode!: number | 0 | 1 | 2;

  /**
   * 注入的UI服务
   *
   * @type {*}
   * @memberof AppFormGroup
   */
  @Prop() public uiService!: any;

  /**
   * 注入数据
   *
   * @type {*}
   * @memberof AppFormGroup
   */
  @Prop() public data!: any;

  get _caption() {
    return this.isShowCaption ? this.caption : '';
  }

  actionBarModelData: any = [];

  /**
   * 监听值变化
   *
   * @memberof AppFormGroup
   */
  @Watch('data', { deep: true })
  onDataChange(newVal: any, oldVal: any) {
    if (newVal !== oldVal && this.uiActionGroup.details.length > 0) {
      this.calcActionItemAuthState(newVal, this.uiActionGroup.details, this.uiService);
    }
  }

  /**
   * 收缩内容
   *
   * @type {boolean}
   * @memberof AppFormGroup
   */
  public isCollapseContent: boolean = false;

  /**
   * shell打开状态
   *
   * @type {boolean}
   * @memberof AppFormGroup
   */
  public selectStatus: boolean = false;

  /**
   * 默认展开
   *
   * @type {string}
   * @memberof AppFormGroup
   */
  public value = ['1'];

  /**
   * 是否有界面行为组
   *
   * @type {*}
   * @memberof AppFormGroup
   */
  get isHaveUiActionGroup() {
    if (this.uiActionGroup.details.length > 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 标题样式
   *
   * @readonly
   * @type {string}
   * @memberof AppFormGroup
   */
  get titleClass(): string {
    return this.titleStyle ? this.titleStyle : '';
  }

  /**
   * vue 生命周期
   *
   * @memberof AppFormGroup
   */
  public created() {
    switch (this.titleBarCloseMode) {
      case 0:
        this.isCollapseContent = false;
        break;
      case 1:
        this.isCollapseContent = true;
        this.value = ['1'];
        break;
      case 2:
        this.isCollapseContent = true;
        this.value = [];
        break;
    }
    this.initActionBarModelData();
  }



  /**
   * 执行界面行为
   *
   * @param {*} $event
   * @memberof AppFormGroup
   */
  public doUIAction(item: any, $event: any, isShell = false): void {
    this.uiActionGroup.details.map((detail: any, i: number) => {
      if (!isShell && item.name == detail.name) {
        this.$emit('groupuiactionclick', { event: $event, item: detail });
      } else if (item.id == detail.name) {
        this.$emit('groupuiactionclick', { event: $event, item: detail });
      }
    });
  }

  /**
   * 计算界面行为项权限状态
   *
   * @param {*} [data] 传入数据
   * @param {*} [ActionModel] 界面行为模型
   * @param {*} [UIService] 界面行为服务
   * @memberof AppFormGroup
   */
  public calcActionItemAuthState(data: any, ActionModel: any, UIService: any) {
    for (const key in ActionModel) {
      if (!ActionModel.hasOwnProperty(key)) {
        return;
      }
      const _item = ActionModel[key];
      if (_item && _item['dataaccaction'] && UIService) {
        let dataActionResult: any;
        if (Object.is(_item['actiontarget'], 'NONE') || Object.is(_item['actiontarget'], '')) {
          dataActionResult = UIService.getResourceOPPrivs(_item['dataaccaction']);
        } else {
          if (data && Object.keys(data).length > 0) {
            dataActionResult = UIService.getAllOPPrivs(data)[_item['dataaccaction']];
          }
        }
        // 无权限:0;有权限:1
        if (dataActionResult === 0) {
          // 禁用:1;隐藏:2;隐藏且默认隐藏:6
          if (_item.noprivdisplaymode === 1) {
            _item.disabled = true;
          }
          if (_item.noprivdisplaymode === 2 || _item.noprivdisplaymode === 6) {
            _item.visabled = false;
          } else {
            _item.visabled = true;
          }
        }
        if (dataActionResult === 1) {
          _item.visabled = true;
          _item.disabled = false;
        }
      }
    }
    this.initActionBarModelData();
  }


  /**
   * 初始化shell数据
   *
   * @param {*} $event
   * @memberof AppFormGroup
   */
  initActionBarModelData() {
    this.actionBarModelData = this.uiActionGroup?.details.map((item: any) => {
      return {
        icon: item.icon,
        name: item?.caption,
        disabled: item.disabled,
        visabled: item.visabled,
        id: item.name,
      };
    });

  }
  /**
   * 打开shell
   *
   * @param {*} $event
   * @memberof AppFormGroup
   */
  openUIAction() {
    this.selectStatus = !this.selectStatus;
  }
}
</script>