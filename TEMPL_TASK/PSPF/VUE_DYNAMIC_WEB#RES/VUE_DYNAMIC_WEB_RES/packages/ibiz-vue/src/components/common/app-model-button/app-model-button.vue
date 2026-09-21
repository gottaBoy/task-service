<template>
    <app-button
        :styleContent="styleContent"
        :classContent="classContent"
        :name="name"
        :caption="caption"
        :tooltip="tooltip"
        :showCaption="showCaption"
        :showIcon="showIcon"
        :iconcls="iconItem.iconcls"
        :icon="iconItem.icon"
        :iconAlign="iconAlign"
        :disabled="disabled"
        :loading="loading"
        :shape="shape"
        :type="buttonType"
        @onClick="onClick"
    >
        <slot></slot>
    </app-button>
</template>

<script lang="ts">
import { IPSAppDEUIAction } from '@ibiz/dynamic-model-api';
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppModelButton extends Vue {
    /**
     * 按钮ID
     *
     * @type {any}
     * @memberof AppModelButton
     */
    @Prop() public id: any;

    /**
     * 按钮模型数据
     *
     * @type {any}
     * @memberof AppModelButton
     */
    @Prop() public modelJson!: any;

    /**
     * 禁用状态
     *
     * @memberof AppModelButton
     */
    @Prop({ default: false }) public disabled?: boolean;

    /**
     * 加载状态
     *
     * @memberof AppModelButton
     */
    @Prop({ default: false }) public loading?: boolean;

    /**
     * 动态样式
     *
     * @memberof AppModelButton
     */
    @Prop({ default: '' }) public dynaStyle?: any;

    /**
     * 动态类名
     *
     * @memberof AppModelButton
     */
    @Prop({ default: '' }) public dynaClass?: any;

    /**
     * 动态类型
     *
     * @memberof AppModelButton
     */
    @Prop({ default: '' }) public dynaType?: string;

    /**
     * 圆角
     *
     * @memberof AppModelButton
     */
    @Prop({ default: undefined }) public shape?: string | undefined;

    /**
     * 传入数据
     *
     * @memberof AppModelButton
     */
    @Prop() data: any;

    /**
     * 按钮名称
     *
     * @memberof AppModelButton
     */
    public name: string = '';

    /**
     * 图标对象
     *
     * @memberof AppModelButton
     */
    public iconItem: any = {};

    /**
     * 显示提示
     *
     * @memberof AppModelButton
     */
    public tooltip: any = '';

    /**
     * 标题
     *
     * @memberof AppModelButton
     */
    public caption: any = '';

    /**
     * 显示标题
     *
     * @memberof AppModelButton
     */
    public showCaption: boolean = true;

    /**
     * 显示图标
     *
     * @memberof AppModelButton
     */
    public showIcon?: boolean = true;

    /**
     * 按钮绘制模式
     *
     * @memberof AppModelButton
     */
    public renderMode: 'BUTTON' | 'LINK' = 'BUTTON';

    /**
     * 按钮样式
     *
     * @memberof AppModelButton
     */
    get styleContent(){
        let tempStyle = '';
        let { width, height} = this.modelJson;
            // 初始化样式 统一转成字符串传给下面原子组件
            if (width > 0) {
                tempStyle += `width: ${width}px;`;
            }
            if (height > 0) {
                tempStyle += `height: ${width}px;`;
            }
            if (this.modelJson && this.modelJson.M && this.modelJson.M.buttonCssStyle) {
                tempStyle += this.getContentStyle(this.modelJson.M.buttonCssStyle) + ';';
            }
            if (this.dynaStyle) {
                if (typeof this.dynaStyle == 'string') {
                    tempStyle += this.dynaStyle + ';';
                } else if (typeof this.dynaStyle == 'object') {
                    for (const [key, value] of Object.entries(this.dynaStyle)) {
                        tempStyle += `${key}: ${value};`;
                    }
                }
            }
        return tempStyle;
    }

    /**
     * 按钮类名
     *
     * @memberof AppModelButton
     */
    get classContent(): string{
        let _classContent = ''
        if (this.dynaClass) {
            if (typeof this.dynaClass == 'string') {
               _classContent += this.dynaClass + ' ';
            } if(this.dynaClass instanceof Array){
               for (const key in this.dynaClass) {
                    const element = this.dynaClass[key];
                    for (const [key, value] of Object.entries(element)) {
                    if (value == true) {
                       _classContent += `${key} `;
                    }
                }
               }
            }else if (typeof this.dynaClass == 'object') {
                for (const [key, value] of Object.entries(this.dynaClass)) {
                    if (value == true) {
                       _classContent += `${key} `;
                    }
                }
            }
        }
        const sysCss = this.modelJson.getPSSysCss();
        if (sysCss?.cssName) {
           _classContent += sysCss.cssName + ' ';
        }
        return _classContent;
    };

    /**
     * 按钮样式
     *
     * @memberof AppModelButton
     */
    public buttonStyle:
        | 'DEFAULT'
        | 'INVERSE'
        | 'PRIMARY'
        | 'INFO'
        | 'SUCCESS'
        | 'WARNING'
        | 'DANGER'
        | 'STYLE2'
        | 'STYLE3'
        | 'STYLE4' = 'DEFAULT';

    /**
     * 按钮类型
     *
     * @memberof AppModelButton
     */
    get buttonType() {
        if (Object.is(this.renderMode, 'LINK')) {
            return 'text';
        } else {
            if (
                Object.is(this.buttonStyle, 'DEFAULT') ||
                Object.is(this.buttonStyle, 'STYLE2') ||
                Object.is(this.buttonStyle, 'STYLE3') ||
                Object.is(this.buttonStyle, 'STYLE4')
            ) {
                return 'default';
            } else if (Object.is(this.buttonStyle, 'DANGER')) {
                return 'error';
            } else if (Object.is(this.buttonStyle, 'INVERSE')) {
                return 'primary';
            } else if (this.dynaType) {
                return this.dynaType.toLowerCase();
            } else {
                return this.buttonStyle.toLowerCase();
            }
        }
    }

    /**
     * 按钮幽灵属性，使按钮背景透明
     *
     * @memberof AppModelButton
     */
    get buttonGhost() {
        return Object.is(this.buttonStyle, 'INVERSE');
    }

    /**
     * 按钮图标方向
     *
     * @memberof AppModelButton
     */
    public iconAlign: 'LEFT' | 'TOP' | 'RIGHT' | 'BOTTOM' = 'LEFT';

    @Watch('data', { deep: true, immediate: true })
    dataChange(newVal: any, oldVal: any) {
        let { captionItemName } = this.modelJson;
        if (captionItemName && newVal[captionItemName.toLowerCase()]) {
            this.caption = newVal[captionItemName.toLowerCase()];
            this.tooltip = newVal[captionItemName.toLowerCase()];
        }
    }

    /**
     * 初始化完成
     *
     * @memberof AppModelButton
     */
    public created() {
        if (this.modelJson) {
            let { caption, captionItemName, showCaption, name, tooltip } = this.modelJson;
            const uiAction = this.modelJson.getPSUIAction() as IPSAppDEUIAction;
            if (!captionItemName) {
                this.caption = this.$tl(uiAction?.getCapPSLanguageRes()?.lanResTag, caption);
                this.tooltip = this.$tl(uiAction?.getTooltipPSLanguageRes()?.lanResTag, tooltip);
            }
            this.name = name;
            this.showCaption = showCaption;
            // 初始化图标对象
            const sysImage = this.modelJson.getPSSysImage();
            const actionImage = uiAction?.getPSSysImage();
            this.iconItem = {
                iconcls: sysImage?.cssClass || actionImage?.cssClass,
                icon: sysImage?.imagePath || actionImage?.imagePath,
            };
            if (this.modelJson.renderMode) {
                this.renderMode = this.modelJson.renderMode;
            }
            if (this.modelJson.buttonStyle) {
                this.buttonStyle = this.modelJson.buttonStyle;
            }
            if (this.modelJson.iconAlign) {
                this.iconAlign = this.modelJson.iconAlign;
            }
        }
    }

    /**
     * 获取内容样式
     * @param {*} data
     * @memberof AppModelButton
     */
    getContentStyle(data: any) {
        if (data) {
            const res = data.split('\n');
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
     * 点击按钮
     *
     * @param {*} event
     * @memberof AppModelButton
     */
    public onClick(event: any) {
        Object.assign(event, { srfid: this.id });
        this.$emit('onClick', event);
    }
}
</script>