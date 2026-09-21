import { VNode } from 'vue';

/**
 * 分页偏移指令
 *
 * @export
 * @class TabOffset
 */
export const TabOffset: any = {

    /**
     * 指令更新
     *
     * @param {HTMLDivElement} el
     * @param {*} binding
     * @param {VNode} vNode
     * @param {VNode} oldVNode
     */
    componentUpdated(el: HTMLDivElement, binding: any, vNode: VNode, oldVNode: VNode) {
        bc.update(el, binding);
    },
};

/**
 * 分页偏移控制器
 *
 * @export
 * @class TabOffsetController
 */
export class TabOffsetController {
    /**
     * 唯一实例
     *
     * @private
     * @static
     * @memberof TabOffsetControllerController
     */
    private static readonly instance = new TabOffsetController();

    /**
     * @description 偏移
     * @protected
     * @type {number}
     * @memberof TabOffsetController
     */
    protected offset: number = 0;

    /**
     * @description 间隔
     * @protected
     * @type {number}
     * @memberof TabOffsetController
     */
    protected gap: number = 0;

    /**
     * 创建实列
     * @memberof TabOffsetControllerController
     */
    private constructor() {
        if (TabOffsetController.instance) {
            return TabOffsetController.instance;
        }
    }

    /**
     * 更新
     *
     * @param {HTMLDivElement}
     * @param {any}
     * @memberof TabOffsetController
     */
    public update(el: HTMLDivElement, binding: any): void {
        this.offset = el.offsetWidth;
        const data = binding.value;
        this.gap = data.gap;
        if (data && data.root && data.root.$el) {
            const source = data.root.$el.querySelector(`.${data.targetClass}`);
            if (source) {
                source.style.paddingLeft = `${this.offset + this.gap}px`;
            }
        }
    }

    /**
     * 获取唯一实例
     *
     * @static
     * @returns {TabOffsetController}
     * @memberof TabOffsetController
     */
    public static getInstance(): TabOffsetController {
        return TabOffsetController.instance;
    }
}

// 导出服务
export const bc: TabOffsetController = TabOffsetController.getInstance();
