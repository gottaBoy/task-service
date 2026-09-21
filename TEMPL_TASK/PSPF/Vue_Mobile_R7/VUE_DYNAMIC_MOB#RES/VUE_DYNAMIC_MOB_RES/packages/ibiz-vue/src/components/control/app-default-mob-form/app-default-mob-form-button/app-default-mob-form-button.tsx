import { IPSDEFormButton } from "@ibiz/dynamic-model-api";
import { Component, Prop } from "vue-property-decorator";
import { AppDefaultMobFormDetail } from "../app-default-mob-form-detail/app-default-mob-form-detail";

@Component({})
export class AppDefaultMobFormButton extends AppDefaultMobFormDetail {
    /**
     * 表单项实例对象
     *
     * @type {*}
     * @memberof AppDefaultMobFormButton
     */
    @Prop() public declare detailsInstance: IPSDEFormButton;

    /**
     * 表单的模型对象
     *
     * @type {*}
     * @memberof AppDefaultMobFormButton
     */
    @Prop() public declare controlInstance: any;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppDefaultMobFormButton
     */
    @Prop() public data: any;

    /**
     * 表单值规则
     *
     * @type {*}
     * @memberof AppDefaultMobFormButton
     */
    @Prop() public rules: any;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof AppDefaultMobFormButton
     */
    @Prop() context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppDefaultMobFormButton
     */
    @Prop() viewparams: any;

    /**
     * 按钮禁用
     *
     * @type {*}
     * @memberof AppDefaultMobFormButton
     */
    @Prop() disabled: any;

    /**
     * 处理按钮点击
     * @param {*} event
     * @memberof AppDefaultMobFormButton
     */
    public handleActionClick(event: any) {
        this.$emit('uIAction', { formDetail: this.detailsInstance, event: event });
    }

    /**
     * 绘制
     *
     * @return {*} 
     * @memberof AppDefaultMobFormButton
     */
    render() {
        const { detailClassNames } = this.renderOptions;
        const { caption, showCaption, width, height } = this.detailsInstance;
        let btnStyle = width > 0 && height > 0 ? { width: `${width}px`, height: `${height}px` } : {};
        this.runtimeModel.visible ? '' : Object.assign(btnStyle, { display: 'none' });
        const text = showCaption ? caption : '';
        const dynaClass: any = { detailClassNames,'app-form-button':true};   
        if(this.detailsInstance.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            Object.assign(dynaClass,...eval(this.detailsInstance.dynaClass))
        }
        return (
            <div
                class={dynaClass}
                style={btnStyle}
            >
                <app-mob-button
                    style={btnStyle}
                    modelJson={this.detailsInstance}
                    text={text}
                    disabled={this.disabled}
                    showDefaultIcon={false}
                    on-click={(event: any) => { this.handleActionClick(event) }}>
                </app-mob-button>
            </div>
        )
    }
}