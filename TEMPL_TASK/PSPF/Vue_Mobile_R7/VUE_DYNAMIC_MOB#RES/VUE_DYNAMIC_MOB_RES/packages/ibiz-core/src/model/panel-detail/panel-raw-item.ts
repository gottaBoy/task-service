import { PanelDetailModel } from './panel-detail';

/**
 * 直接内容
 *
 * @export
 * @class PanelRawitemModel
 * @extends {PanelDetailModel}
 */
export class PanelRawitemModel extends PanelDetailModel {

    /**
     * 导航数据（主要用于导航区占位）
     *
     * @type {*}
     * @memberof PanelRawitemModel
     */
    private $navdata: any;

    /**
     * Creates an instance of PanelRawitemModel.
     * @param {*} [opts={}]
     * @memberof PanelRawitemModel
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 执行异步逻辑
     *
     * @memberof PanelRawitemModel
     */
    public async loaded() {
        let content: any;
        const { contentType, htmlContent, rawContent } = this.panelItemModel as any;
        if (Object.is(contentType, 'RAW')) {
            content = rawContent;
        } else if (Object.is(contentType, 'HTML')) {
            content = htmlContent;
        }
        if (content) {
            const data = this.panel.layoutData;
            const items = content.match(/\{{(.+?)\}}/g);
            if (items) {
                items.forEach((item: string) => {
                    content = content.replace(/\{{(.+?)\}}/, eval(item.substring(2, item.length - 2)));
                });
            }
            content = content.replaceAll('&lt;', '<');
            content = content.replaceAll('&gt;', '>');
            content = content.replaceAll('&amp;nbsp;', ' ');
            content = content.replaceAll('&nbsp;', ' ');
        }
        this.data = content;
    }

    /**
     * 设置数据
     *
     * @param {*} val (值非对象)
     * @memberof PanelRawitemModel
     */
    public setData(val: any) {
        this.data = val;
    }

    /**
     * 设置导航数据
     *
     * @param {*} value
     * @memberof PanelRawitemModel
     */
    public setNavData(value: any) {
        this.$navdata = value;
    }

    /**
     * 获取导航数据
     *
     * @return {*} 
     * @memberof PanelRawitemModel
     */
    public getNavData() {
        return this.$navdata;
    }
}