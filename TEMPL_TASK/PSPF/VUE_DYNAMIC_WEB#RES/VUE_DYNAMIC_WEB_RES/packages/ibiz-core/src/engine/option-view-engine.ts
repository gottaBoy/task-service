import { EditViewEngine } from './edit-view-engine';

/**
 * 实体选项操作视图界面引擎
 *
 * @export
 * @class OptionViewEngine
 * @extends {EditViewEngine}
 */
export class OptionViewEngine extends EditViewEngine {

    /**
     * Creates an instance of OptionViewEngine.
     * 创建 OptionViewEngine 实例对象
     * 
     * @memberof OptionViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 确认
     *
     * @memberof OptionViewEngine
     */
    public ok() {
        const form = this.getForm();
        if (form && form.save instanceof Function) {
            form.save().then((res: any) => {
                if (res.status === 200) {
                    this.emitViewEvent('close', [res.data]);
                }
            });
        }
    }

    /**
     * 取消
     *
     * @memberof OptionViewEngine
     */
    public cancel() {
        this.view.$store.commit('viewAction/setViewDataChange', { viewTag: this.view.viewtag, viewDataChange: false });
        this.emitViewEvent('close', null);
    }
}