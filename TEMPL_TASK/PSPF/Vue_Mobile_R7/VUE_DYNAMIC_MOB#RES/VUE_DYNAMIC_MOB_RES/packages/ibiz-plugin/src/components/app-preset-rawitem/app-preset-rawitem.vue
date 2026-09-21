<template>
    <app-rawitem
        v-if="type == 'FIELD_IMAGE' || type == 'FIELD_TEXT_DYNAMIC'"
        class="app-preset-rawitem"
        :rawItemDetail="rawItemDetail"
        :imageDetail="{ imagePath: imgUrl }"
        :contentType="contentType"
        :content="value"
        :context="context"
        :viewparams="viewparams"
    />
    <div class="app-preset-rawitem" v-else-if="type == 'STATIC_VIDEOPLAYER'">
        <app-video :videoParmas="rawParams" />
    </div>
    <app-mob-carousel
        v-else-if="type == 'STATIC_CAROUSEL'"
        class="app-preset-rawitem"
        :data="rawParams"
        :style="getContentStyle(rawItemDetail.cssStyle)"
        :class="getCssName(rawItemDetail)"
    ></app-mob-carousel>
    <app-nav-pos
        v-else-if="type == 'NAV_POS'"
        class="app-preset-rawitem"
        :navData="navData"
    ></app-nav-pos >
</template>

<script lang="ts">
import { Environment } from '@/environments/environment';
import { Vue, Component, Prop } from 'vue-property-decorator';
import './app-preset-rawitem.less';

@Component({})
export default class AppPresetRawitem extends Vue {

    /**
     * 父项所有数据
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() public contextData?: any;

    /**
     * 输入值
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() public value!: any;

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppPresetRawitem
     */
    @Prop() public name!: string;

    /**
     * 类型
     *
     * @type {string}
     * @memberof AppPresetRawitem
     */
    @Prop() public type?: string;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() viewparams: any;

    /**
     * 模型
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() detailModel: any;

    /**
     * 直接内容模型
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() rawItemDetail: any;

    /**
     * 图片模型
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() imageDetail: any;

    /**
     * 导航数据
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() navData: any;

    /**
     * 内容类型
     *
     * @type {string}
     * @memberof AppPresetRawitem
     */
    public contentType: string = '';

    /**
     * 直接内容参数
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    public rawParams: any = {};

    /**
     * 下载文件路径
     *
     * @memberof AppPreSetRowItem
     */
    protected downloadUrl = Environment.BaseUrl + Environment.ExportFile;

    /**
     * 图片路径
     *
     * @memberof AppPreSetRowItem
     */
    get imgUrl(): string {
        let url: string = '';
        if (this.value && typeof this.value == 'string') {
            try {
                const _files = JSON.parse(this.value);
                const file = _files instanceof Array ? _files[0] : null;
                url = file && file.id ? `${this.downloadUrl}/${file.id}` : '';
            } catch (error) {
                return '';
            }
        }
        return url;
    }

    /**
     * Vue生命周期 --- Created
     *
     * @memberof AppPresetRawitem
     */
    created() {
        this.init();
    }

    /**
     * 初始化
     *
     * @memberof AppPresetRawitem
     */
    protected init() {
        switch (this.type) {
            case 'FIELD_IMAGE':
                this.handleDynaImg();
                break;
            case 'FIELD_TEXT_DYNAMIC':
                this.handleDynaText();
                break;
            case 'STATIC_VIDEOPLAYER':
                this.handleStaticVideo();
                break;
            case 'STATIC_CAROUSEL':
                this.handleStaticCarousel();
                break;
            case 'STATIC_TEXT':
                break;
            case 'STATIC_LABEL':
                break;
            case 'STATIC_IMAGE':
                break;
            case 'NAV_POS':
            case 'NAV_TABS':
            default:
                console.warn(`${this.type}暂未支持`);
                break;
        }
    }

    /**
     * 处理动态图片
     *
     * @memberof AppPresetRawitem
     */
    protected handleDynaImg() {
        this.contentType = 'IMAGE';
    }

    /**
     * 处理动态文本
     *
     * @memberof AppPresetRawitem
     */
    protected handleDynaText() {
        this.contentType = 'RAW';
    }

    /**
     * 处理静态视频播放
     *
     * @memberof AppPresetRawitem
     */
    protected handleStaticVideo() {
        if (this.rawItemDetail && this.rawItemDetail.getPSRawItemParams) {
            const rawParams: any = {};
            this.rawItemDetail.getPSRawItemParams.forEach((param: any) => {
                rawParams[param.key.toLowerCase()] = param.value;
            });
            this.rawParams = rawParams;
        }
    }

    /**
     * 处理静态轮播图
     *
     * @memberof AppPresetRawitem
     */
    protected handleStaticCarousel() {
        let swipeData: any[] = [];
        let swipeConfig: any = {};
        if (this.rawItemDetail && this.rawItemDetail.getPSRawItemParams) {
            // 判断imgsData后两位是否有配置参数
            const imgsData = this.rawItemDetail.getPSRawItemParams;
            const configItem = imgsData.findIndex((item: any) => Object.is(item.key, 'autoplay'));
            if (configItem > -1) {
                // 有配置参数就截掉配置参数
                swipeData = imgsData.slice(0, -2);
                swipeConfig = this.setSwipeConfig(imgsData.slice(-2));
            } else {
                swipeData = imgsData;
                swipeConfig = this.setSwipeConfig(imgsData);
            }
        }
        swipeData = swipeData.map((item: any) => {
            return this.addressProcessing(item);
        });
        this.rawParams = {
            swipeData: swipeData,
            swipeConfig: swipeConfig,
        };
    }

    /**
     * @description 设置轮播图配置
     * @param {*}
     * @memberof AppRawItem
     */
    private setSwipeConfig(data: any) {
        const autoPlay: any = data.find((item: any) => Object.is(item.key, 'autoplay')) || {};
        const timeSpan: any = data.find((item: any) => Object.is(item.key, 'timespan')) || {};
        return {
            isAuto: Object.is(autoPlay?.value, '1') ? true : false,
            timeSpan: Number(timeSpan?.value) || 0,
        };
    }

    /**
     * 处理轮播图地址
     *
     * @memberof AppPresetRawitem
     */
    private addressProcessing(item: any) {
        let _item: any = {};
        _item.linkPath = item.linkPath;
        _item.imgPath = this.getImagePath(item);
        _item.iconClass = this.getImageClass(item) || '';
        return _item;
    }

    /**
     * 获取图片路径
     *
     * @memberof AppPresetRawitem
     */
    public getImagePath(item: any) {
        if (item && item.getPSSysImage && item.getPSSysImage.imagePath) {
            return item.getPSSysImage.imagePath;
        }
    }

    /**
     * @description 获取imageClass
     * @param {*}
     * @memberof AppRawItem
     */
    public getImageClass(item: any) {
        if (item && item.getPSSysImage && item.getPSSysImage.cssClass) {
            return item.getPSSysImage.cssClass;
        }
    }

    /**
     * 获取内容样式
     *
     * @memberof AppPresetRawitem
     */
    public getContentStyle(data: any) {
        if (data && data.cssStyle) {
            const res = data.cssStyle.split('\n');
            const target: string[] = [];
            res.forEach((item: any) => {
                target.push(...item.split(';').filter((value: any) => value));
            });
            return target
                .filter((value: string) => {
                    return value.split(':').length === 2;
                })
                .join(';');
        }
    }

    /**
     * @description 获取cssName
     * @param {*} data
     */
    public getCssName(data: any) {
        if (data && data.getPSSysCss && data.getPSSysCss.cssName) {
            return data.getPSSysCss.cssName;
        }
    }
}
</script>