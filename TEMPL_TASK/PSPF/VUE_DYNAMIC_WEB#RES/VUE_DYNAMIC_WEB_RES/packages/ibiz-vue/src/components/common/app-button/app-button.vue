<template>
    <i-button
        :class="buttonClass"
        :type="type"
        :ghost="buttonGhost"
        :style="styleContent"
        :disabled="disabled"
        :title="tooltip"
        :loading="loading"
        :shape="shape"
        @click="onClick"
    >
        <div :class="['btn-content', flexType]">
            <span v-if="(iconcls || icon) && showIcon" class="icon">
                <i v-if="iconcls" :class="iconcls" />
                <img v-else-if="icon" :src="icon" />
            </span>
            <span v-if="showCaption && caption" class="caption">{{ caption }}</span>
            <slot></slot>
        </div>
    </i-button>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppButton extends Vue {
    /**
     * 禁用状态
     *
     * @memberof AppButton
     */
    @Prop({ default: false }) public disabled?: boolean;

    /**
     * 加载状态
     *
     * @memberof AppButton
     */
    @Prop({ default: false }) public loading?: boolean;

    /**
     * 动态样式
     *
     * @memberof AppButton
     */
    @Prop({ default: '' }) public styleContent?: string;

    /**
     * 动态样式类
     *
     * @memberof AppButton
     */
    @Prop({ default: '' }) public classContent?: string;

    /**
     * 阻止冒泡
     *
     * @memberof AppButton
     */
    @Prop({ default: true }) public stopBubble!: boolean;

    /**
     * 按钮样式
     *
     * @memberof AppButton
     */
    get buttonClass() {
        let buttonClass = 'app-button ivu-button ';
        if (this.classContent) {
            buttonClass += this.classContent;
        }
        return buttonClass;
    }

    /**
     * 按钮名称
     *
     * @memberof AppButton
     */
    @Prop({ default: '' }) public name?: string;

    /**
     * 图片路径
     *
     * @memberof AppButton
     */
    @Prop({ default: '' }) public icon?: string;

    /**
     * i图标类名
     *
     * @memberof AppButton
     */
    @Prop({ default: '' }) public iconcls?: string;

    /**
     * 显示提示
     *
     * @memberof AppButton
     */
    @Prop({ default: '' }) public tooltip?: string;

    /**
     * 标题
     *
     * @memberof AppButton
     */
    @Prop({ default: '' }) public caption?: string;

    /**
     * 显示标题
     *
     * @memberof AppButton
     */
    @Prop({ default: true }) public showCaption?: boolean;

    /**
     * 显示图标
     *
     * @memberof AppButton
     */
    @Prop({ default: true }) public showIcon?: boolean;

    /**
     * 按钮类型
     *
     * @memberof AppButton
     */
    @Prop({ default: 'default' }) public type?: string;

    /**
     * 按钮幽灵属性，使按钮背景透明
     *
     * @memberof AppButton
     */
    @Prop({ default: false }) public buttonGhost?: boolean;

    /**
     * 按钮图标方向
     *
     * @memberof AppButton
     */
    @Prop({ default: 'LEFT' }) public iconAlign?: 'LEFT' | 'TOP' | 'RIGHT' | 'BOTTOM';

    /**
     * 按钮内容布局类型
     *
     * @memberof AppButton
     */
    get flexType() {
        let flexClass = 'left';
        if (this.iconAlign) {
            switch (this.iconAlign) {
                case 'LEFT':
                    flexClass = 'left';
                    break;
                case 'TOP':
                    flexClass = 'top';
                    break;
                case 'RIGHT':
                    flexClass = 'right';
                    break;
                case 'BOTTOM':
                    flexClass = 'bottom';
                    break;
            }
        }
        return flexClass;
    }

    /**
     * 圆角
     *
     * @memberof AppButtonContainer
     */
    @Prop({ default: undefined }) public shape?: string | undefined;

    /**
     * 初始化完成
     *
     * @memberof AppButton
     */
    public created() {}

    /**
     * 点击按钮
     *
     * @param {*} event
     * @memberof AppButton
     */
    public onClick(event: any) {
        if (this.stopBubble) {
            event.stopPropagation();
        }
        this.$emit('onClick', event);
    }
}
</script>