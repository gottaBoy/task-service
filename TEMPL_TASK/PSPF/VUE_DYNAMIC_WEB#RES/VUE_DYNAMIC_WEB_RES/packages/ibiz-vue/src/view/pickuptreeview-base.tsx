import { IPSAppDETreeView, IPSDETree } from '@ibiz/dynamic-model-api';
import { ModelTool, PickupTreeViewInterface } from 'ibiz-core';
import { MDViewBase } from './mdview-base';


/**
 * 选择树视图基类
 *
 * @export
 * @class PickupTreeViewBase
 * @extends {MDViewBase}
 * @implements {PickupTreeViewInterface}
 */
export class PickupTreeViewBase extends MDViewBase implements PickupTreeViewInterface {

    /**
     * 选中数据字符串
     * 
     * @type {string}
     * @memberof PickupTreeViewBase
     */
    public selectedData?: string;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof PickupTreeViewBase
     */
    public isSingleSelect: boolean = false;

    /**
     * 视图实例对象
     * 
     * @type {IPSAppDETreeView}
     * @memberof PickupTreeViewBase
     */
    public declare viewInstance: IPSAppDETreeView;

    /**
     * 树视图实例
     *
     * @public
     * @type {IPSDETree}
     * @memberof PickupTreeViewBase
     */
    public treeInstance!: IPSDETree;

    /**
     * 监听视图动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PickupTreeViewBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        super.onDynamicPropsChange(newVal, oldVal);
        if(newVal?.selectedData && newVal.selectedData != oldVal?.selectedData){
            this.selectedData = newVal.selectedData;
        }
    }

    /**
     * 监听参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PickupTreeViewBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.isSingleSelect = newVal.isSingleSelect;
        super.onStaticPropsChange(newVal, oldVal)
    }

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PickupTreeViewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let engineOpts = ({
            view: this,
            p2k: '0',
            tree: (this.$refs[this.treeInstance.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
        this.engine.init(engineOpts);
    }


    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof PickupGridViewBase
     */
    public computeTargetCtrlData(controlInstance:any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.dynamicProps,{
            selectedData: this.selectedData,
        })
        Object.assign(targetCtrlParam.staticProps,{
            isSingleSelect: this.isSingleSelect,
            isSelectFirstDefault: true
        })
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent };
    }

    /**
     * 初始化选择树视图实例
     * 
     * @memberof PickupTreeViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDETreeView;
        await super.viewModelInit();
        this.treeInstance = ModelTool.findPSControlByType("TREEVIEW",this.viewInstance.getPSControls());        
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof PickupTreeViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.treeInstance);
        Object.assign(targetCtrlParam.staticProps, { isSelectFirstDefault: false, treeMode: 'PICKUP' });
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.treeInstance.name, on: targetCtrlEvent });
    }

    /**
     * 快速搜索
     *
     * @returns {void}
     * @memberof PickupTreeViewBase
     */
    public onSearch(): void {
        this.engine.search({ srfnodefilter: this.queryParams.quickSearchValue });
    }

    /**
     * 选中全部
     *
     * @param {any[]} [datas=[]]
     * @memberof PickupTreeViewBase
     */
    public selectAll(datas: any[] = []): void {
        if (this.engine) {
            this.engine.selectAll(datas);
        }
    }
}