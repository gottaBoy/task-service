/**
 * 元素选择对象
 */
export class EleSelector {

    /**
     * 操作上下文
     */
    private actionContext: any;

    /**
     * 构造EleSelector对象
     */
    public constructor(actionContext: any) {
        this.actionContext = actionContext;
    }


    /**
     * 元素选择器(顶层路由视图)
     * @param tag （id选择/class类名选择/css元素选择）
     * @returns Array<any>
     */
    public selector(tag: string): Array<any> {
        const targetRange = this.getTargetRange('TOPVIEW');
        return this.getTargetElement(targetRange, tag);
    }

    /**
     * 元素选择器(当前视图)
     * @param tag （id选择/class类名选择/css元素选择）
     * @returns Array<any>
     */
    public viewSelector(tag: string): Array<any> {
        const targetRange = this.getTargetRange('VIEW');
        return this.getTargetElement(targetRange, tag);
    }

    /**
     * 元素选择器(当前应用)
     * @param tag （id选择/class类名选择/css元素选择）
     * @returns Array<any>
     */
    public appSelector(tag: string): Array<any> {
        const targetRange = this.getTargetRange('APP');
        return this.getTargetElement(targetRange, tag);
    }

    /**
     * 获取目标范围
     * @param scope 
     */
    private getTargetRange(scope: 'VIEW' | 'TOPVIEW' | 'APP') {
        if (!this.actionContext || !this.actionContext.viewCtx) {
            return document;
        }
        const viewCtx = this.actionContext.viewCtx;
        if (Object.is(scope, 'VIEW')) {
            let viewElement: any;
            const view = viewCtx.view;
            if (view && view.viewInstance) {
                viewElement = document.querySelector(`#${view.viewInstance.codeName}`);
            }
            return viewElement ? viewElement : document;
        } else if (Object.is(scope, 'TOPVIEW')) {
            let topViewElement: any;
            const topView = viewCtx.topview;
            if (topView && topView.viewInstance) {
                topViewElement = document.querySelector(`#${topView.viewInstance.codeName}`);
            }
            return topViewElement ? topViewElement : document;
        } else {
            return document;
        }
    }

    /**
     * 获取目标元素 
     * @param range 选中范围 
     * @param tag 选择器tag
     */
    private getTargetElement(range: any, tag: string): Array<any> {
        if (!range || !tag) {
            return [];
        }
        // id选择若存在返回数组
        const tryIdEle = range.querySelector(`#${tag}`);
        if (tryIdEle) {
            return [tryIdEle];
        }
        // class类名选择返回数组
        const tryclsNameEle = range.querySelector(`.${tag}`);
        if (tryclsNameEle) {
            return [tryclsNameEle];
        }
        // 通过css元素器获取第一个符合条件的元素的数组
        const tryqueryEle = range.querySelector(tag);
        if (tryqueryEle) {
            return [tryqueryEle];
        }
        // 未找到返回[]
        return [];
    }
}