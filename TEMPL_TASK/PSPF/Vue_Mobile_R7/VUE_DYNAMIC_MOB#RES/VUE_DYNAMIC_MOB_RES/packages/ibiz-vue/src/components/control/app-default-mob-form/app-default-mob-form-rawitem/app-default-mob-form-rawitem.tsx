import { IPSDEFormRawItem } from "@ibiz/dynamic-model-api";
import { Component, Prop } from "vue-property-decorator";
import { AppDefaultMobFormDetail } from "../app-default-mob-form-detail/app-default-mob-form-detail";

@Component({})
export class AppDefaultMobFormRawItem extends AppDefaultMobFormDetail {
    /**
     * 表单项实例对象
     *
     * @type {*}
     * @memberof AppDefaultMobFormRawItem
     */
    @Prop() public declare detailsInstance: IPSDEFormRawItem;

    /**
     * 表单的模型对象
     *
     * @type {*}
     * @memberof AppDefaultMobFormRawItem
     */
    @Prop() public declare controlInstance: any;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppDefaultMobFormRawItem
     */
    @Prop() public data: any;

    /**
     * 表单值规则
     *
     * @type {*}
     * @memberof AppDefaultMobFormRawItem
     */
    @Prop() public rules: any;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof AppDefaultMobFormRawItem
     */
    @Prop() context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppDefaultMobFormRawItem
     */
    @Prop() viewparams: any;

    /**
     * 渲染直接内容
     *
     * @return {*} 
     * @memberof AppDefaultMobFormRawItem
     */
    render() {
        const { detailClassNames } = this.renderOptions;
        const imageDetail = { imageClass: this.detailsInstance.getPSSysImage()?.cssClass, imagePath: this.detailsInstance.getPSSysImage()?.imagePath };
        const { contentType, htmlContent, rawContent, rawItemHeight, rawItemWidth } = this.detailsInstance;
        const style: any = {
            width: rawItemWidth > 0 ? `${rawItemWidth}px` : false,
            height: rawItemHeight > 0 ? `${rawItemHeight}px` : false,
        }
        this.runtimeModel.visible ? '' : Object.assign(style, { display: 'none' });
        const rawItemDetail = this.detailsInstance.M?.getPSRawItem;
        let content: any;
        if(this.detailsInstance.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            Object.assign(detailClassNames,...eval(this.detailsInstance.dynaClass))
        }
        if (Object.is(contentType, 'RAW')) {
            content = rawContent;
        } else if (Object.is(contentType, 'HTML')) {
            content = htmlContent;
        }
        if (content) {
            const items = content.match(/\{{(.+?)\}}/g);
            if (items) {
                const data = this.data;
                items.forEach((item: string) => {
                    content = content.replace(/\{{(.+?)\}}/, eval(item.substring(2, item.length - 2)));
                });
            }
            content = content.replaceAll('&lt;', '<');
            content = content.replaceAll('&gt;', '>');
            content = content.replaceAll('&amp;nbsp;', ' ');
            content = content.replaceAll('&nbsp;', ' ');
        }
        return (
            <app-rawitem
                class={detailClassNames}
                style={style}
                context={this.context}
                viewparams={this.viewparams}
                contentType={contentType}
                rawItemDetail={rawItemDetail}
                imageDetail={imageDetail}
                content={content}
            >
            </app-rawitem>
        )
    }
}