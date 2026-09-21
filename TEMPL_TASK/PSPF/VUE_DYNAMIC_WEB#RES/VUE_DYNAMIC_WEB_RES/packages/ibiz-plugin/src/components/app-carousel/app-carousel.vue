<template>
    <div class="app-carouse">
        <Carousel :autoplay="swipeConfig.isAuto" :autoplay-speed="swipeConfig.timeSpan" radius-dot>
            <CarouselItem v-for="(item, index) in swipeData" :key="index">
                <div class="carousel-img-item">
                    <a v-if="item.linkPath" :href="item.linkPath">
                        <img class="app-carouse-img" v-if="item.imgPath" :src="item.imgPath" @error="imgError" />
                        <i v-else :class="item.iconClass"></i>
                    </a>
                    <img class="app-carouse-img" v-else-if="item.imgPath" :src="item.imgPath" @error="imgError" />
                    <i v-else :class="item.iconClass.cssClass" :style="handleIconCss(item.iconClass)"></i>
                </div>
            </CarouselItem>
        </Carousel>
    </div>
</template>
<script lang='ts'>
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppCarousel extends Vue {
    /**
     * @description 轮播图数据
     * @param {*}
     * @memberof AppCarousel
     */
    @Prop() public data: any;

    /**
     * @description 轮播图图片所有项数据
     * @memberof AppCarousel
     */

    public swipeData: any[] = [];

    /**
     * @description 轮播图配置
     * @memberof AppCarousel
     */
    public swipeConfig: any = {};

    /**
     * data值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppCarousel
     */
    @Watch('data', { immediate: true })
    public onDataChange(newVal: any, oldVal: any) {
        if (!Object.is(newVal, oldVal)) {
            this.swipeData = newVal.swipeData;
            this.swipeConfig = newVal.swipeConfig;
        }
    }

    /**
     * @description 构建之前
     * @memberof AppCarousel
     */
    created() {
        this.swipeData = this.data.swipeData;
        this.swipeConfig = this.data.swipeConfig;
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
     * img src错误
     *
     * @param {*} $event
     * @memberof AppCarousel
     */
    imgError($event: any) {
        let img = $event.srcElement;
        if (img && !img.imgSign) {
            if (img && !img.imgSign) {
                img.src = 'assets/img/404.png';
                img.imgSign = true;
                img.imgSign = true;
            }
            img.onerror = null;
        }
    }
}
</script>

<style lang='less'>
@import './app-carousel.less';
</style>