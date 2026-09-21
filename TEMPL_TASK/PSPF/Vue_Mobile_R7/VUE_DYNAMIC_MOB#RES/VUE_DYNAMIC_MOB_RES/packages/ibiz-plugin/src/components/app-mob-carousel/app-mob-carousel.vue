<template>
  <div class="app-mob-carouse">
    <van-swipe
      class="app-van-swipe"
      :autoplay="swipeConfig.isAuto ? swipeConfig.timeSpan : '0'"
      :loop="true"
      ref="swipe"
    >
      <van-swipe-item v-for="(item, index) in swipeData" :key="index">
        <a v-if="item.linkPath" :href="item.linkPath">
          <van-image
            class="app-carouse-img"
            fit="cover"
            v-if="item.imgPath"
            :src="item.imgPath"
            @click="click(item)"
            @error="imgError"
          />
        </a>
        <van-image class="app-carouse-img" fit="cover" v-else-if="item.imgPath" :src="item.imgPath" @error="imgError" />
        <i v-else :class="item.iconClass.cssClass" :style="handleIconCss(item.iconClass)"></i>
      </van-swipe-item>
    </van-swipe>
  </div>
</template>
<script lang='ts'>
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppMobCarousel extends Vue {
  /**
   * @description 轮播图数据
   * @memberof AppMobCarousel
   * @param {*}
   */
  @Prop()
  data: any;

  /**
   * @description 轮播图图片所有项数据
   * @memberof AppMobCarousel
   */
  public swipeData: any[] = [];

  /**
   * @description 轮播图配置
   * @memberof AppMobCarousel
   */
  public swipeConfig: any = {};

  /**
   * data值变化
   *
   * @param {*} newVal
   * @param {*} oldVal
   * @memberof AppMobCarousel
   */
  @Watch('data', { immediate: true })
  public onDataChange(newVal: any, oldVal: any) {
    if (!Object.is(newVal, oldVal)) {
      this.swipeData = newVal.swipeData;
      this.swipeConfig = newVal.swipeConfig;
    }
  }

  /**
   * @description 生命周期created
   * @memberof AppMobCarousel
   */
  created() {
    if (this.data) {
      this.swipeData = this.data.swipeData;
      this.swipeConfig = this.data.swipeConfig;
    }
  }

  /**
   * @description 生命周期mounted
   * @memberof AppMobCarousel
   */
  mounted() {
    setTimeout(() => {
      (this.$refs.swipe as any)?.resize?.();
    }, 300);
  }

  /**
   * 处理图标大小
   * @memberof AppMobCarousel
   */
  public handleIconCss(data: any) {
    return {
      width: data.width || 6 + 'px',
      height: data.height || 6 + 'px',
    };
  }

  /**
   * @description 重定img src
   * @param {*} event
   * @memberof AppMobCarousel
   */
  public imgError($event: any) {
    let img = $event.srcElement;
    if (img && !img.imgSign) {
      img.src = 'assets/images/404.jpg';
      img.imgSign = true;
      img.onerror = null;
    }
  }
}
</script>

<style lang='less'>
@import './app-mob-carousel.less';
</style>