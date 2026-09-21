<template>
    <div :class="['app-rawitem', `app-rawtime--${contentType.toLowerCase()}`]">
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
        </template>
        <!-- 图片类型 -->
        <template v-else-if="Object.is(contentType, 'IMAGE')">
            <img :style="cssStyle" class="app-rawitem__image" v-if="imgUrl" :src="imgUrl" />
            <i :style="cssStyle" v-else :class="imageClass ? imageClass : ''"></i>
        </template>
        <!-- HTML类型 -->
        <template v-else-if="Object.is(contentType, 'HTML')">
            <div :style="cssStyle" class="app-rawitem__html" v-html="content" />
        </template>
        <!-- MARKDOWN类型 -->
        <template v-else-if="Object.is(contentType, 'MARKDOWN')">
            <app-markdown-editor v-if="itemValue" :style="cssStyle" mode="PREVIEWONLY" :itemValue="itemValue"></app-markdown-editor>
        </template>
        <!-- VIDEO类型 -->
        <template v-else-if="Object.is(contentType, 'VIDEO')">
            <!-- 视频 -->
            <div :style="cssStyle" class="app-rawitem__video">
                <video
                    :id="playerParams.uuid"
                    :src="playerParams.path"
                    :autoplay="playerParams.autoplay"
                    :controls="playerParams.showcontrols"
                    :loop="playerParams.replay"
                    :muted="playerParams.mute"
                >
                    <source :src="playerParams.path" type="video/mp4" />
                    <source :src="playerParams.path" type="video/ogg" />
                    <source :src="playerParams.path" type="video/webm" />
                </video>
            </div>
        </template>
        <!-- PLACEHOLDER类型 -->
        <template v-else-if="Object.is(contentType, 'PLACEHOLDER')">
            <!-- 占位 -->
            <div :style="cssStyle"></div>
        </template>
        <!-- DIVIDER类型 -->
        <template v-else-if="Object.is(contentType, 'DIVIDER')">
            <!-- 分割线 -->
            <app-divider
                class="app-rawitem__divider"
                :style="cssStyle"
                :contentPosition="divider_params.contentPosition"
                :html="divider_params.html"
            ></app-divider>
        </template>
        <!-- INFO，WARNING，ERROR类型 -->
        <!-- 提示 -->
        <template
            v-else-if="
                Object.is(contentType, 'INFO') || Object.is(contentType, 'WARNING') || Object.is(contentType, 'ERROR')
            "
        >
            <app-raw-alert
                class="app-rawitem__alert"
                :type="alert_params.type"
                :title="alert_params.title"
                :showIcon="alert_params.showIcon"
                :closeable="alert_params.closeable"
            ></app-raw-alert>
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
    @Prop({ default: 'RAW' }) public contentType!:
        | 'RAW'
        | 'HTML'
        | 'IMAGE'
        | 'MARKDOWN'
        | 'VIDEO'
        | 'PLACEHOLDER'
        | 'DIVIDER'
        | 'INFO'
        | 'WARNING'
        | 'ERROR';

    /**
     * 直接内容详情
     *
     * @type {*}
     * @memberof AppRawItem
     */
    @Prop() public rawItemDetail: any;

    /**
     * 内容
     *
     * @type {string}
     * @memberof AppRawItem
     */
    @Prop() public content?: string;

    /**
     * 图标
     *
     * @type {string}
     * @memberof AppRawItem
     */
    @Prop() public imageClass?: string;

    /**
     * 图片
     *
     * @type {string}
     * @memberof AppRawItem
     */
    @Prop() public imgUrl?: string;

    /**
     * 编辑器值
     *
     * @type {*}
     * @memberof AppRawItem
     */
    @Prop() public itemValue?: any;

    /**
     * 直接内容-视频参数
     */
    @Prop({default:()=>{}}) public videoParams?: any;

    /**
     * 直接内容-分割线参数
     */
    @Prop({default:()=>{}}) public dividerParams?: any;

    /**
     * 直接内容-提示参数
     */
    @Prop({default:()=>{}}) public alertParams?: any;

    /**
     * 内容样式
     */
    public cssStyle?: string;
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
        | '' = 'TEXT';

    /**
     * 预定义类型
     *
     * @type {string}
     * @memberof AppRawItem
     */
    public predefinedType: string = '';

    /**
     *  uuid
     *
     * @type {*}
     * @memberof AppRawItem
     */
    public uuid = this.$util.createUUID();

    /**
     * 视频类型内容参数
     *
     * @type {*}
     * @memberof AppRawItem
     */
    public playerParams: any = {
        id: this.uuid,
        path: '',
        mute: true,
        autoplay: true,
        replay: false,
        showcontrols: true,
    };

    /**
     * 分割线类型参数
     *
     * @type {*}
     * @memberof AppRawItem
     */
    public divider_params: any = {
        contentPosition: 'center',
        html: '',
    };

    /**
     *  消息提示类型参数
     *
     * @type {*}
     * @memberof AppRawItem
     */
    public alert_params: any = {
        type: 'info',
        title: '',
        closeable: true,
        showIcon: false,
    };

    /**
     * 构建之前
     *
     * @type {*}
     * @memberof AppRawItem
     */
    public created() {
        this.cssStyle = this.rawItemDetail && this.rawItemDetail.cssStyle ? this.rawItemDetail.cssStyle : '';
        switch (this.contentType) {
            case 'RAW':
                // 直接内容识别绘制模式
                this.renderMode =
                    this.rawItemDetail && this.rawItemDetail.renderMode ? this.rawItemDetail.renderMode : 'TEXT';
                if (
                    this.rawItemDetail &&
                    this.rawItemDetail.predefinedType &&
                    this.rawItemDetail.predefinedType === 'STATIC_LABEL'
                ) {
                    this.cssStyle += 'white-space: nowrap;overflow: hidden;text-overflow: ellipsis;';
                }
                break;
            case 'VIDEO':
                if (this.videoParams) {
                    Object.assign(this.playerParams, this.videoParams);
                }
                break;
            case 'PLACEHOLDER':
                break;
            case 'DIVIDER':
                if (this.dividerParams) {
                    Object.assign(this.divider_params, this.dividerParams);
                }
                break;
            case 'INFO':
            case 'WARNING':
            case 'ERROR':
                this.alert_params.type = this.contentType.toLocaleLowerCase();
                if (this.alertParams) {
                    Object.assign(this.alert_params,this.alertParams);
                }
                break;
        }
    }
}
</script>