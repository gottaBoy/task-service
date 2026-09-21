<template>
  <div class="app-scroll-container">
    <div
      v-if="containerModel.NORTH"
      :style="containerModel.NORTH.style"
      class="no-style overflow-auto app-scroll-container__header"
    >
      <template v-for="name of containerModel.NORTH.name">
        <slot :name="name"></slot>
      </template>
    </div>
    <div class="app-scroll-container__middle" :style="middleContainerStyle">
      <div
        v-if="containerModel.WEST"
        :style="containerModel.WEST.style"
        class="no-style overflow-auto app-scroll-container__left"
      >
        <template v-for="name of containerModel.WEST.name">
          <slot :name="name"></slot>
        </template>
      </div>
      <div
        v-if="containerModel.CENTER"
        :style="containerModel.CENTER.style"
        class="no-style overflow-auto app-scroll-container__center"
      >
        <template v-for="name of containerModel.CENTER.name">
          <slot :name="name"></slot>
        </template>
      </div>
      <div
        v-if="containerModel.EAST"
        :style="containerModel.EAST.style"
        class="no-style overflow-auto app-scroll-container__right"
      >
        <template v-for="name of containerModel.EAST.name">
          <slot :name="name"></slot>
        </template>
      </div>
    </div>
    <div
      v-if="containerModel.SOUTH"
      :style="containerModel.SOUTH.style"
      class="no-style overflow-auto app-scroll-container__bottom"
    >
      <template v-for="name of containerModel.SOUTH.name">
        <slot :name="name"></slot>
      </template>
    </div>
  </div>
</template>

<script lang="ts">
import { IPSPanelItem } from '@ibiz/dynamic-model-api';
import { IParams } from 'ibiz-core';
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component({})
export default class AppScrollContainer extends Vue {
  /**
   * 子容器模型
   *
   * @type {*}
   * @memberof AppScrollContainer
   */
  @Prop() public panelItems!: any;

  /**
   * 插槽对象
   *
   * @memberof AppScrollContainer
   */
  public containerModel: IParams = {};

  /**
   * 中间区域样式
   *
   * @memberof AppScrollContainer
   */
  public middleContainerStyle: IParams = {};

  /**
   * 组件初始化
   *
   * @memberof AppScrollContainer
   */
  public created() {
    this.initScrollContainer();
  }

  /**
   * 初始化滚动容器
   *
   * @memberof AppScrollContainer
   */
  public initScrollContainer() {
    let minusHeight = 0;
    if (this.panelItems && this.panelItems.length > 0) {
      this.panelItems.forEach((panelItem: IPSPanelItem) => {
        const { name, width, height } = panelItem;
        const tag = (panelItem.getPSLayoutPos() as any).layoutPos;
        const style = {};
        if (width) {
          Object.assign(style, { width: `${width}px` });
        }
        if (height) {
          Object.assign(style, { height: `${height}px` });
          if (tag && (Object.is(tag, 'NORTH') || Object.is(tag, 'SOUTH'))) {
            minusHeight += height;
          }
        }
        if (this.containerModel.hasOwnProperty(tag)) {
          Object.assign(this.containerModel[tag], { style });
          this.containerModel[tag].name.push(name);
        } else {
          this.containerModel[tag] = { style, name: [name] };
        }
      });
    }
    this.middleContainerStyle.height = minusHeight ? `calc(100% - ${minusHeight}px)` : '100%';
  }
}
</script>