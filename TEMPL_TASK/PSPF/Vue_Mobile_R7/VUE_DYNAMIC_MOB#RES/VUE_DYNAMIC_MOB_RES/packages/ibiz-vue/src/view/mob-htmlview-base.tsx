import { MobHTMLViewInterface, StringUtil } from 'ibiz-core';
import { IPSAppDEHtmlView } from '@ibiz/dynamic-model-api';
import { MainViewBase } from './main-view-base';

/**
 *  实体html视图基类
 *
 * @export
 * @class MobHtmlViewBase
 * @extends {MainViewBase}
 * @implements {HTMLViewInterface}
 */
export class MobHtmlViewBase extends MainViewBase implements MobHTMLViewInterface {
    /**
     * 视图实例
     *
     * @memberof MobHtmlViewBase
     */
    public declare viewInstance: IPSAppDEHtmlView;

    /**
     * 初始化实体html视图实例
     *
     * @memberof MobHtmlViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.parseIframeSrc(this.context, this.viewparams);
    }

    /**
     * 嵌入视图路径
     *
     * @public
     * @type string
     * @memberof MobHtmlViewBase
     */
    public iframeUrl: string = '';

    /**
     * 解析嵌入视图路径
     *
     * @public
     * @memberof MobHtmlViewBase
     */
    public parseIframeSrc(context: any, viewparams: any) {
        this.iframeUrl = StringUtil.fillStrData(this.staticProps.modeldata.htmlUrl, context, viewparams);
    }

    /**
     * 渲染视图主体内容区
     *
     * @memberof MobHtmlViewBase
     */
    public renderMainContent() {
        if (this.iframeUrl?.length > 0) {
            return (
                <iframe class="view-content__body__iframe" src={this.iframeUrl}></iframe>
            );
        } else {
            return (
                <div class='view-content__body__error'>
                    <div class="view-content__body__error__body">
                        <img src={`assets/images/404.jpg`} />
                    </div>
                </div>
            );
        }
    }
}
