<template>
    <div class="app-qr-code">
        <template v-if="QRCodeConfig.url">
            <ibiz-qr-code
                :size="QRCodeConfig.size"
                :url="QRCodeConfig.url"
                :bgSrc="QRCodeConfig.bgSrc"
                :margin="QRCodeConfig.margin"
                :backgroundColor="QRCodeConfig.backgroundColor"
                :logoSrc="QRCodeConfig.logoSrc"
                :logoMargin="QRCodeConfig.logoMargin"
                :logoBgColor="QRCodeConfig.logoBgColor"
                :logoRadius="QRCodeConfig.logoRadius"
                :whiteMargin="QRCodeConfig.whiteMargin"
                class="ibiz-qr-code"
                :callback="callback">
            </ibiz-qr-code>
        </template>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppPresetQrCode extends Vue {
    /**
     * 内容  value数据格式：对象类型的JSON字符串，参数类型与QRCodeConfig一致："{ "url": "http://www.baidu.com" }"
     *
     * @type {string}
     * @memberof AppRawItem
     */
    @Prop() public value?: any;

    /**
     * ibiz-qr-code组件可传参数
     * @param {number} size  二维码大小，包含边框
     * @param {string} url  二维码内容
     * @param {string} bgSrc  背景图片  
     * @param {number} margin 二维码外边距   
     * @param {string} backgroundColor 背景颜色    
     * @param {string} logoSrc 中央图标logo地址    
     * @param {number} logoMargin logo周围的空白边框   
     * @param {string} logoBgColor logo边框的背景色   
     * @param {number} logoRadius logo边框圆角半径
     * @param {boolean} whiteMargin 背景图外是否设置白色边框  
     * @type {*}
     * @memberof AppQRCode
     */
    public QRCodeConfig: { 
        size?: number, 
        url?: string, 
        bgSrc?: string,
        margin?: number, 
        backgroundColor?: string, 
        logoSrc?: string,
        logoMargin?: number, 
        logoBgColor?: string, 
        logoRadius?: number,
        whiteMargin?: boolean,
    } = {}

    /**
     * 二维码生成的回调函数
     * @type {*}
     * @memberof AppQRCode
     */
    public callback(event: any) {
        // TODO
    }

    /**
     * 获取二维码数据
     * 
     * @memberof AppQRCode
     */
    public created() {
        this.getQRCodeData();
    }

    /**
     * 获取二维码绘制数据
     *
     * @type {*}
     * @memberof AppQRCode
     */
    public getQRCodeData() {
        if(this.value && typeof(this.value) == 'string') {
            const value = JSON.parse(this.value);
            const {
                size, 
                url, 
                bgSrc,
                margin, 
                backgroundColor, 
                logoSrc,
                logoMargin, 
                logoBgColor, 
                logoRadius,
                whiteMargin,
            } = value;
            this.QRCodeConfig = {
                size, 
                url, 
                bgSrc,
                margin, 
                backgroundColor, 
                logoSrc,
                logoMargin, 
                logoBgColor, 
                logoRadius,
                whiteMargin,
            };
            // TODO
        }
    }
}
</script>

<style lang='less'>
@import './app-preset-qrcode.less';
</style>