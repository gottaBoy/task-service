<template>
  <div>
    <app-mob-carousel :data="carouselData"></app-mob-carousel>
  </div>
</template>
<script lang='ts'>
import { Environment } from '@/environments/environment';
import { ImgurlBase64 } from 'ibiz-core';
import { Component, Vue, Prop } from 'vue-property-decorator';

@Component({})
export default class AppPresetMobCarousel extends Vue {
    /**
     * 父项所有数据
     *
     * @type {*}
     * @memberof AppPresetMobCarousel
     */
    @Prop() public contextData?: any;

    /**
     * 输入值(多项图片数据)
     *
     * [{id:string ,name:string },{id:string ,name:string }]
     *
     * @type {*}
     * @memberof AppPresetMobCarousel
     */
    @Prop() public value!: any;

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppPresetMobCarousel
     */
    @Prop() public name!: string;

    /**
     * 类型
     *
     * @type {string}
     * @memberof AppPresetMobCarousel
     */
    @Prop() public type?: string;

    /**
     * 直接内容详情
     *
     * @type {*}
     * @memberof AppPresetMobCarousel
     */
    public rawItemDetail: any = {};

    /**
     * 轮播图数据
     * {
     *   swipeData:[{linkPath:string ,imgPath:string ,iconClass:string }]
     *   swipeConfig:{isAuto:boolean,timeSpan:number}
     * }
     *
     * @type {*}
     * @memberof AppPresetMobCarousel
     */
    public carouselData: any = {};

    /**
     * 生命周期-created
     *
     * @memberof AppPresetMobCarousel
     */
    created() {
        this.handleCarouselData();
    }

    /**
     * 整理轮播图所需数据
     * @memberof AppPresetMobCarousel
     */
    public async handleCarouselData() {
        if (this.value && typeof this.value === 'string') {
            const swipeData = JSON.parse(this.value);
            this.carouselData['swipeData'] = await this.setSwipeData(swipeData);
        }
        this.carouselData['swipeConfig'] = this.setSwipeConfig();
    }

    /**
     * @description 设置轮播图配置
     * @param {*}
     * @memberof AppPresetMobCarousel
     */
    public setSwipeConfig() {
        return {
            isAuto: true,
            timeSpan: 3000,
        };
    }

    /**
     * @description 设置轮播图数据
     * @param {*}
     * @memberof AppPresetMobCarousel
     */
    public async setSwipeData(data: any) {
        let swipeData: any[] = [];
        if (data && data.length > 0) {
            for (let i = 0; i < data.length; i++) {
                const element = data[i];
                let url = `${Environment.BaseUrl}${Environment.ExportFile}/${element.id}`;
                let res = await ImgurlBase64.getInstance().getImgURLOfBase64(url);
                swipeData.push({
                    linkPath: element.linkpath,
                    imgPath: res,
                    iconClass: element.iconclass,
                });              
            }
        }
        return swipeData;
    }
}
</script>

<style lang='less'>
</style>