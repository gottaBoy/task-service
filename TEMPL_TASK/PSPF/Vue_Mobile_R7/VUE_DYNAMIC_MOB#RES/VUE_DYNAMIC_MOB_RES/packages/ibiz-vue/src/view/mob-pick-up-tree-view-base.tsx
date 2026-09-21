import { MobPickupTreeViewInterface, ModelTool } from 'ibiz-core';
import { MDViewBase } from './md-view-base';
import { IPSAppDETreeView, IPSDETree } from '@ibiz/dynamic-model-api';

export class MobPickupTreeViewBase extends MDViewBase implements MobPickupTreeViewInterface {

    /**
     * 选中数据字符串
     * 
     * @type {string}
     * @memberof MobPickupTreeViewBase
     */
    public selectedData?: string;

    /**
     * 视图实例对象
     * 
     * @type {IBizPickupGridViewModel}
     * @memberof MobPickupTreeViewBase
     */
    public declare viewInstance: IPSAppDETreeView;

    /**
     * 树视图实例
     *
     * @public
     * @type {IBizTreeModel}
     * @memberof MobPickupTreeViewBase
     */
    public treeInstance !: IPSDETree;

    /**
     * 搜索值
     *
     * @memberof MobPickupTreeViewBase
     */
    public query = "";

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MobPickupTreeViewBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        super.onDynamicPropsChange(newVal, oldVal);
        if (newVal?.selectedData && newVal.selectedData != oldVal?.selectedData) {
            this.selectedData = newVal.selectedData;
        }
    }

    /**
     * 监听参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MobPickupTreeViewBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.isSingleSelect = newVal.isSingleSelect;
        super.onStaticPropsChange(newVal, oldVal)
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof PickupGridViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.dynamicProps, {
            selectedData: this.selectedData,
        })
        Object.assign(targetCtrlParam.staticProps, {
            isSingleSelect: this.isSingleSelect,
        })
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

    /**
     * 初始化选择树视图实例
     * 
     * @memberof MobPickupTreeViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDETreeView;
        await super.viewModelInit();
        this.treeInstance = ModelTool.findPSControlByName("tree", this.viewInstance.getPSControls());
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof MobPickupTreeViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.treeInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.treeInstance.name, on: targetCtrlEvent });
    }

}