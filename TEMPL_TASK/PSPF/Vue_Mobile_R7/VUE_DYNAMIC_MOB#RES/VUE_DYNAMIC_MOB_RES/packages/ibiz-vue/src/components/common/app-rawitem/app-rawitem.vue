<template>
  <div class="app-rawitem">
    <!-- 直接内容类型 -->
    <template v-if="Object.is(contentType, 'RAW')">
      <template v-if="Object.is(renderMode, 'TEXT')">
        <span :style="cssStyle">{{ content }}</span>
      </template>
      <template v-else-if="Object.is(renderMode, 'HEADING1')">
        <h1 :style="cssStyle">{{ content }}</h1>
      </template>
      <template v-else-if="Object.is(renderMode, 'HEADING2')">
        <h2 :style="cssStyle">{{ content }}</h2>
      </template>
      <template v-else-if="Object.is(renderMode, 'HEADING3')">
        <h3 :style="cssStyle">{{ content }}</h3>
      </template>
      <template v-else-if="Object.is(renderMode, 'HEADING4')">
        <h4 :style="cssStyle">{{ content }}</h4>
      </template>
      <template v-else-if="Object.is(renderMode, 'HEADING5')">
        <h5 :style="cssStyle">{{ content }}</h5>
      </template>
      <template v-else-if="Object.is(renderMode, 'HEADING6')">
        <h6 :style="cssStyle">{{ content }}</h6>
      </template>
      <template v-else-if="Object.is(renderMode, 'PARAGRAPH')">
        <p :style="cssStyle">{{ content }}</p>
      </template>
      <template v-else>
        {{ content }}
      </template>
    </template>
    <!-- 图片类型 -->
    <template v-else-if="Object.is(contentType, 'IMAGE')">
      <app-mob-icon
        :style="cssStyle"
        v-if="imageDetail.imageClass"
        :name="imageDetail.imageClass ? imageDetail.imageClass : ''"
      ></app-mob-icon>
      <img :style="cssStyle" v-else :src="imageDetail.imagePath" />
    </template>
    <!-- HTML类型 -->
    <template v-else-if="Object.is(contentType, 'HTML')">
      <div :style="cssStyle" v-html="content" />
    </template>
  </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop } from 'vue-property-decorator';

@Component({})
export default class AppRawItem extends Vue {
  /**
   * 应用上下文
   *
   * @type {string}
   * @memberof AppRawItem
   */
  @Prop() public context!: any;

  /**
   * 视图参数
   *
   * @type {string}
   * @memberof AppRawItem
   */
  @Prop() public viewparams!: any;

  /**
   * 内容类型
   *
   * @type {string}
   * @memberof AppRawItem
   */
  @Prop() public contentType!: string;

  /**
   * 直接内容模型详情
   *
   * @memberof AppRawItem
   */
  @Prop() public rawItemDetail!: any;

  /**
   * 图片参数详情
   *
   * @memberof AppRawItem
   */
  @Prop() public imageDetail!: any;

  /**
   * 内容
   *
   * @type {string}
   * @memberof AppRawItem
   */
  @Prop() public content?: string;

  /**
   * 内容样式
   */
  public cssStyle?: string;

  /**
   * 直接内容参数
   */
  public rawitemParam: any = {};

  /**
   * 绘制模式
   *
   * @type {string}
   * @memberof AppRawItem
   */
  public renderMode:
    | 'TEXT'
    | 'HEADING1'
    | 'HEADING2'
    | 'HEADING3'
    | 'HEADING4'
    | 'HEADING5'
    | 'HEADING6'
    | 'PARAGRAPH'
    | '' = '';

  /**
   * 预定义类型
   *
   * @type {string}
   * @memberof AppRawItem
   */
  public predefinedType: string = '';

  /**
   * 轮播图数据
   * {
   *  swipeData:图片数据对象数组
   *  swipeConfig:是否自动播放配置对象
   * }
   *
   * @type {*}
   * @memberof AppRawItem
   */
  public carouselData: any = {};

  /**
   * 构建之前
   *
   * @type {*}
   * @memberof AppRawItem
   */
  public created() {
    // 直接内容识别绘制模式
    if (Object.is(this.contentType, 'RAW')) {
      this.renderMode = this.rawItemDetail && this.rawItemDetail.renderMode ? this.rawItemDetail.renderMode : '';
    }
    // 预定义类型 主要识别轮播图和视频播放
    this.cssStyle = this.rawItemDetail && this.rawItemDetail.cssStyle ? this.rawItemDetail.cssStyle : '';
  }

}
</script>

<style lang='less'>
.app-rawitem {
  pre,
  p {
    margin: 0;
  }
}
</style>