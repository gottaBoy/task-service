<template>
  <ion-button
    :class="{'app-mob-button':true,'text-button':buttonType==='text'}"
    :fill="buttonFill"
    :color="buttonColor"
    :disabled="disabled"
    @click.stop="handleClick"
  >
    <div :class="['button__content', flexType == 'horizontal' ? 'horizontal' : 'vertical']">
      <img v-if="iconItem.imagePath" class="button__image" :src="iconItem.imagePath" />
      <i v-else-if="iconItem.fontClass" :class="iconItem.fontClass" class="button__icon"></i>
      <ion-icon v-else-if="iconItem.iconName" class="button__icon" :name="iconItem.iconName" />
      <span v-if="text" class="button__text">{{ text }} </span>
      <slot></slot>
    </div>
  </ion-button>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';
import { IPSAppDEUIAction } from '@ibiz/dynamic-model-api';
import { ViewTool } from 'ibiz-core';
@Component({})
export default class AppMobButton extends Vue {
  /**
   * 唯一标识
   *
   */
  @Prop() public id?: string;

  /**
   * 按钮模型数据
   *
   */
  @Prop() public modelJson!: any;

  /**
   * 按钮名称
   */
  @Prop() public text?: string;

  /**
   * 是否显示默认图标
   */
  @Prop({ default: true }) private showDefaultIcon?: boolean;

  /**
   * 按钮是否禁用
   */
  @Prop({ default: false }) public disabled?: boolean;

  /**
   * 运行时图标对象
   *
   */
  @Prop() public runTimeIconItem?: any;

  /**
   * 按钮填充方式
   *
   */
  @Prop({ default: 'horizontal' }) public flexType!: string;

  /**
   * 按钮填充方式
   *
   */
  @Prop({ default: '' }) public buttonType!: string;



  /**
   * 图标对象
   *
   */
  public iconItem: any = {};

  /**
   * 按钮图标方向
   *
   */
  public iconAlign: 'LEFT' | 'TOP' | 'RIGHT' | 'BOTTOM' = 'RIGHT';

  /**
   * 按钮样式
   *
   */
  public buttonStyle:
    | 'DEFAULT'
    | 'INVERSE'
    | 'PRIMARY'
    | 'INFO'
    | 'SUCCESS'
    | 'WARNING'
    | 'DANGER'
    | 'STYLE2'
    | 'STYLE3'
    | 'STYLE4' = 'DEFAULT';

  /**
   * 按钮背景颜色
   *
   */
  get buttonColor() {
    switch (this.buttonStyle) {
      case 'DEFAULT':
        return 'primary';
      case 'INVERSE':
        return 'dark';
      case 'PRIMARY':
        return 'primary';
      case 'INFO':
        return 'secondary';
      case 'SUCCESS':
        return 'success';
      case 'WARNING':
        return 'warning';
      case 'DANGER':
        return 'danger';
      default:
        return 'primary';
    }
  }

  /**
   * 按钮绘制模式
   *
   */
  public renderMode: 'BUTTON' | 'LINK' = 'BUTTON';

  /**
   * 透明按钮
   *
   */
  get buttonFill() {
    if (Object.is(this.renderMode, 'LINK')) {
      return 'clear';
    } else {
      if (this.modelJson?.buttonStyle) {
        return 'solid';
      }
      return 'default';
    }
  }

  /**
   * 初始化完成
   */
  public created() {
    if (this.modelJson) {
      const uiAction = this.modelJson?.getPSUIAction() as IPSAppDEUIAction;
      const sysImage = this.modelJson?.getPSSysImage();
      const actionImage = uiAction?.getPSSysImage();
      if (sysImage?.imagePath || actionImage?.imagePath) {
        this.iconItem.imagePath = sysImage?.imagePath || actionImage?.imagePath;
      } else {
        const iconcls = sysImage?.cssClass || actionImage?.cssClass;
        if (iconcls) {
          if (iconcls.startsWith('fa fa-')) {
            this.iconItem.fontClass = iconcls;
          } else {
            this.iconItem.iconName = ViewTool.setIcon(iconcls);
          }
        } else {
          if (this.showDefaultIcon) {
            this.iconItem.iconName = 'file-text-o';
          }
        }
      }
      if (this.modelJson.renderMode) {
        this.renderMode = this.modelJson.renderMode;
      }
      if (this.modelJson.buttonStyle) {
        this.buttonStyle = this.modelJson.buttonStyle;
      }
      if (this.modelJson.iconAlign) {
        this.iconAlign = this.modelJson.iconAlign;
      }
    } else {
      if (this.runTimeIconItem) {
        if (this.runTimeIconItem.iconName) {
          if (this.runTimeIconItem.iconName.startsWith('fa fa-')) {
            this.iconItem.fontClass = this.runTimeIconItem.iconName;
          } else {
            this.iconItem.iconName = ViewTool.setIcon(this.runTimeIconItem.iconName);
          }
        }
        if (this.runTimeIconItem.imagePath) {
          this.iconItem.imagePath = this.runTimeIconItem.imagePath;
        }
      }
    }
  }

  /**
   * 按钮点击事件
   */
   public handleClick(event: any) {
    Object.assign(event, { srfid: this.id });
    this.$emit('click', event);
  }
}
</script>