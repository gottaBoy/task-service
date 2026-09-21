<template>
    <app-rawitem
        v-if="type == 'FIELD_IMAGE' || type == 'FIELD_TEXT_DYNAMIC' || type == 'STATIC_LABEL' || type == 'STATIC_TEXT'"
        class="app-preset-rawitem"
        :rawItemDetail="rawItemDetail"
        :contentType="contentType"
        :imgUrl="isImg(imgUrl)? imgUrl: ''"
        :imageClass="!isImg(imgUrl)? imgUrl: ''"
        :content="value"
        :context="context"
        :viewparams="viewparams"
        :itemValue="value"
    />
    <div class="app-preset-rawitem" v-else-if="type == 'STATIC_VIDEOPLAYER'">
        <app-video :videoParmas="rawParams" />
    </div>
    <app-carousel
        v-else-if="type == 'STATIC_CAROUSEL'"
        class="app-preset-rawitem"
        :data="rawParams"
        :style="getContentStyle(rawItemDetail.cssStyle)"
        :class="getCssName(rawItemDetail)"
    ></app-carousel>
    <app-nav-pos
        v-else-if="type == 'NAV_POS' || type == 'NAV_POS_INDEX'"
        class="app-preset-rawitem"
        :navData="navData"
        :dynaNavMode="detailModel.dynaNavMode"
        :enableCache="detailModel.enableCache"
    ></app-nav-pos>
    <tab-page-exp v-else-if="type == 'NAV_TABS'" class="app-preset-rawitem" :modelService="modelService"></tab-page-exp>
    <app-user v-else-if="type == 'AUTH_USERINFO'"></app-user>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { AppServiceBase, ImgurlBase64 } from 'ibiz-core';
import { IPSEditor } from '@ibiz/dynamic-model-api';

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
    @Prop({
        default: () => {
            return {};
        },
    })
    detailModel: any;

    /**
     * 导航数据
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() navData: any;

    /**
     * 直接内容模型
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() rawItemDetail: any;

    /**
     * 模型服务
     *
     * @type {*}
     * @memberof AppPresetRawitem
     */
    @Prop() modelService: any;

   /**
     * 编辑器实例
     *
     * @type {IPSEditor}
     * @memberof AppPresetRawitem
     */
    @Prop() editorInstance!: IPSEditor;

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
     * @memberof AppPresetRawitem
     */
    protected downloadUrl = AppServiceBase.getInstance().getAppEnvironment().ExportFile;

    /**
     * 动态图片路径
     *
     * @memberof AppPresetRawitem
     */
    protected dynaImgUrl: string = '';

    /**
     * 图片路径
     *
     * @memberof AppPresetRawitem
     */
    get imgUrl(): string {
        return this.dynaImgUrl;
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
            case 'STATIC_TEXT':
            case 'STATIC_LABEL':
                this.contentType = this.editorInstance?.editorParams?.['CONTENTTYPE'] || 'RAW';
                break;
            case 'NAV_POS':
            case 'NAV_POS_INDEX':
                break;
            case 'STATIC_VIDEOPLAYER':
                this.handleStaticVideo();
                break;
            case 'STATIC_CAROUSEL':
                this.handleStaticCarousel();
            case 'NAV_TABS':
                break;
            case 'AUTH_USERINFO':
                break;
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
        this.contentType = this.editorInstance?.editorParams?.['CONTENTTYPE'] || 'IMAGE';
        if (this.value && typeof this.value == 'string') {
            // 默认识别文件对象形式，识别失败则为全路径模式
            try {
                const _files = JSON.parse(this.value);
                const file = _files instanceof Array ? _files[0] : null;
                const url = file && file.id ? `${this.downloadUrl}/${file.id}` : '';
                ImgurlBase64.getInstance()
                .getImgURLOfBase64(url)
                .then((res: any) => {
                    this.dynaImgUrl = res;
                });
            } catch (error) {
                this.dynaImgUrl = this.value;
            }
        }
    }

    /**
     * 处理动态文本
     *
     * @memberof AppPresetRawitem
     */
    protected handleDynaText() {
        this.contentType = this.editorInstance?.editorParams?.['CONTENTTYPE'] || 'RAW';
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

    /**
     * 判断是否为图片路径
     * 
     * @param {string} imgUrl
     */
     public isImg(imgUrl: string) {
        const reg = /^https?:|^http?:|(\.png|\.svg|\.jpg|\.png|\.gif|\.psd|\.tif|\.bmp|\.jpeg)/;
        return reg.test(imgUrl);
    }
}
</script>
<style lang="less">
@import './app-preset-rawitem.less';
</style>