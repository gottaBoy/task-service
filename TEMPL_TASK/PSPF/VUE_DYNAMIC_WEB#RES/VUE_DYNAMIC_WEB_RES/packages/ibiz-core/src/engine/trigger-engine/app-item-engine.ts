import { Util } from "../../utils";
import { AppUITriggerEngine } from "./app-ui-trigger-engine";

/**
 * 项界面逻辑
 *
 * @export
 * @class AppItemEngine
 */
export class AppItemEngine extends AppUITriggerEngine {

    /**
     * Creates an instance of AppCustomEngine.
     * @memberof AppItemEngine
     */
    constructor(opts: any) {
        super(opts);
        this.triggerType = opts.triggerType;
        this.itemName = opts.itemName;
    }

    /**
     * 触发类型
     *
     * @type {('ITEMVISIBLE' | 'ITEMENABLE' | 'ITEMBLANK')}
     * @memberof AppItemEngine
     */
    public triggerType: 'ITEMVISIBLE' | 'ITEMENABLE' | 'ITEMBLANK';

    /**
     * 项名称
     *
     * @type {string}
     * @memberof AppItemEngine
     */
    public itemName: string;

    /**
     * 执行默认脚本
     *
     * @param {*} opts
     * @param {string} scriptCode
     * @return {*} 
     * @memberof AppItemEngine
     */
    public executeDefaultScriptLogic(opts: any, scriptCode: string) {
        const { arg, utils, app, view, ctrl } = opts;
        const { sender, navParam: viewparam, navContext: context, data: _data, itemModels } = arg;
        const data = _data && _data.length > 0 && _data[0] || {};
        try {
            const result = eval(scriptCode);
            if (itemModels) {
                let itemDetail: any;
                if (Util.typeOf(itemModels) == 'object') {
                  itemDetail = Object.values(itemModels).find((item: any) => {
                    return item.name == this.itemName;
                  });
                } else if (Util.typeOf(itemModels) == 'array') {
                  itemDetail = itemModels.find((item: any) => {
                    return item.name == this.itemName;
                  });
                }
                if (itemDetail) {
                    switch (this.triggerType) {
                        case 'ITEMVISIBLE':
                            itemDetail.visabled = result !== undefined ? result : itemDetail.visabled;
                            break;
                        case 'ITEMENABLE':
                            itemDetail.disabled = result !== undefined ? result : itemDetail.disabled;
                            break;
                        case 'ITEMBLANK':
                            itemDetail.required = result !== undefined ? result : itemDetail.required;
                            break;
                    }
                }
            }
        } catch (error: any) {
            console.error(`执行脚本界面逻辑异常，脚本代码为：${scriptCode}`);
        }
        return arg;
    }
}