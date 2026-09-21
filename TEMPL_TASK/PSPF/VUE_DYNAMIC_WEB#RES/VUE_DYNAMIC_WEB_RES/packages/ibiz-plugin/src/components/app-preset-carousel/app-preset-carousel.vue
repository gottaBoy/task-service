<template>
    <app-carousel v-if="carouselData" :data="carouselData" class="app-carouse"></app-carousel>
</template>
<script lang='ts'>
import { Environment } from '@/environments/environment';
import { ImgurlBase64 } from 'ibiz-core';
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppPresetCarousel extends Vue {
    /**
     * 父项所有数据
     *
     * @type {*}
     * @memberof AppPresetCarousel
     */
    @Prop() public contextData?: any;

    /**
     * 输入值
     *
     * [{id:string ,name:string },{id:string ,name:string }]
     *
     * @type {*}
     * @memberof AppPresetCarousel
     */
    @Prop() public value!: any;

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppPresetCarousel
     */
    @Prop() public name!: string;

    /**
     * 类型
     *
     * @type {string}
     * @memberof AppPresetCarousel
     */
    @Prop() public type?: string;

    /**
     * 直接内容详情
     *
     * @type {*}
     * @memberof AppPresetCarousel
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
     * @memberof AppPresetCarousel
     */
    public carouselData: any = {};

    /**
     * 生命周期-created
     *
     * @memberof AppPresetCarousel
     */
    created() {
        this.handleCarouselData();
    }

    /**
     * 整理轮播图所需数据
     * @memberof AppPresetCarousel
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