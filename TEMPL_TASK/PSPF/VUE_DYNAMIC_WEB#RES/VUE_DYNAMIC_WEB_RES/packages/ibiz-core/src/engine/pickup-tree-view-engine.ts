import { Util } from '../utils';
import { TreeViewEngine } from './tree-view-engine';

/**
 * 实体选择树视图（部件视图）界面引擎
 *
 * @export
 * @class PickupTreeViewEngine
 * @extends {TreeViewEngine}
 */
export  class PickupTreeViewEngine extends TreeViewEngine {

    /**
     * 选中处理
     *
     * @param {any[]} args
     * @memberof PickupTreeViewEngine
     */
    public selectionChange(args: any[]): void {
        if (this.view) {
            const selections = args.map((item: any) => item.curData || item);
            this.view.viewSelections =  [...selections];
            this.emitViewEvent('viewdataschange', selections);
        }
    }

    /**
     * 双击选中激活数据
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof PickupTreeViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(ctrlName, 'tree') && Object.is(eventName, 'nodedblclick')) {
            const selections = args.map((item: any) => item.curData || item);
            this.emitViewEvent('viewdatasactivated', selections);
            return;
        }
        super.onCtrlEvent(ctrlName, eventName, args);
    }

    /**
     * 父数据参数模式
     *
     * @param {{ tag: string, action: string, viewdata: any }} { tag, action, viewdata }
     * @memberof PickupTreeViewEngine
     */
     public setViewState2({ tag, action, viewdata }: { tag: string, action: string, viewdata: any }): void {
        if (Util.isExistAndNotEmpty(this.view.context.query)) {
            this.view.viewState.next({ tag: tag, action: 'filter', data: { srfnodefilter: this.view.context.query } });
        } else {
            this.view.viewState.next({ tag: tag, action: action, data: viewdata });
        }
    }

    /**
     * 选择全部
     *
     * @param {any[]} [datas=[]]
     * @memberof PickupTreeViewEngine
     */
    public selectAll(datas: any[] = []) {
        const tree = this.getMDCtrl();
        if (tree && tree.$refs[tree.name]) {
            const keys: string[] = [];
            if (datas && datas.length) {
                datas.forEach((data: any) => {
                    keys.push(data.id);
                })
            }
            tree.$refs[tree.name].setCheckedKeys(keys);
        }
    }
}