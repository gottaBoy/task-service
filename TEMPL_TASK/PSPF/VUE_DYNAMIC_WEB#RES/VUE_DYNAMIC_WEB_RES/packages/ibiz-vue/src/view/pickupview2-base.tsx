import { IPSAppDEPickupView, IPSDEPickupViewPanel, IPSTreeExpBar } from '@ibiz/dynamic-model-api';
import { ModelTool, PickupView2Engine, PickupView2Interface } from 'ibiz-core';
import { MainViewBase } from './mainview-base';


/**
 * 实体选择视图(左右关系)
 *
 * @export
 * @class PickupView2Base
 * @extends {MainViewBase}
 * @implements {PickupView2Interface}
 */
export class PickupView2Base extends MainViewBase implements PickupView2Interface {

    /**
     * 视图实例
     * 
     * @memberof PickupView2Base
     */
    public declare viewInstance: IPSAppDEPickupView;

    /**
     * 选择视图面板实例对象
     * 
     * @memberof PickupView2Base
     */
    public pickupViewPanelInstance!: IPSDEPickupViewPanel;

    /**
     * 树导航实例对象
     * 
     * @memberof PickupView2Base
     */
    public treeExpBarInstance!: IPSTreeExpBar;

    /**
     * 选中数据的字符串
     *
     * @type {string}
     * @memberof PickupView2Base
     */
    public selectedData: string = "";

    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof PickupView2Base
     */
    public viewSelections: any[] = [];

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof PickupView2Base
     */
    public isShowButton: boolean = true;

    /**
     * 分隔值
     *
     * @type {number}
     * @memberof PickupView2Base
     */
    public split: number = 0.2;

    /**
     * 导航项
     *
     * @protected
     * @type {*}
     * @memberof PickupView2Base
     */
    protected navItem: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PanelControlBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        super.onDynamicPropsChange(newVal, oldVal);
        if (this.viewparams?.selectedData) {
            this.selectedData = JSON.stringify(this.viewparams.selectedData);
        }
    }

    /**
     * 监听部件静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof PickupView2Base
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.isShowButton = newVal?.isShowButton !== false;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 引擎初始化
     *
     * @public
     * @memberof PickupView2Base
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            treeExpBar: (this.$refs[this.treeExpBarInstance?.name] as any)?.ctrl,
            pickupviewpanel: (this.$refs[this.pickupViewPanelInstance?.name] as any)?.ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 处理分隔值变化
     *
     * @memberof PickupView2Base
     */
    public handleSplitChange() {
        if (this.split) {
            this.$store.commit("setViewSplit", { viewUID: `${this.viewInstance?.codeName}_${this.treeExpBarInstance?.codeName}`, viewSplit: this.split });
        }
    }

    /**
     * 确定
     *
     * @memberof PickupView2Base
     */
    public onClickOk(): void {
        this.$emit('view-event', { viewName: this.viewInstance.name, action: 'viewdataschange', data: this.viewSelections });
        this.$emit('view-event', { viewName: this.viewInstance.name, action: 'close', data: null });
    }

    /**
     * 取消
     *
     * @memberof PickupView2Base
     */
    public onClickCancel(): void {
        this.$emit('view-event', { viewName: this.viewInstance.name, action: 'viewdataschange', data: null });
        this.$emit('view-event', { viewName: this.viewInstance.name, action: 'close', data: null });
    }

    /**
     *  视图挂载
     *
     * @memberof PickupView2Base
     */
    public async containerMounted() {
        super.containerMounted();
        if (this.viewparams?.selectedData) {
            this.selectedData = JSON.stringify(this.viewparams.selectedData);
        }
        this.initSplit();
    }

    /**
     * 初始化数据选择视图实例
     * 
     * @memberof PickupView2Base
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDEPickupView;
        await super.viewModelInit();
        const controls = this.viewInstance.getPSControls() || [];
        this.pickupViewPanelInstance = ModelTool.findPSControlByType("PICKUPVIEWPANEL", controls);
        this.treeExpBarInstance = ModelTool.findPSControlByType("TREEEXPBAR", controls);
    }

    /**
     * 初始化分隔值
     *
     * @protected
     * @memberof PickupView2Base
     */
    protected initSplit() {
        const tempSplit = this.$store.getters.getViewSplit(`${this.viewInstance?.codeName}_${this.treeExpBarInstance?.codeName}`);
        if (tempSplit) {
            this.split = Number(tempSplit);
        } else {
            const width = this.treeExpBarInstance.width;
            if (width && width > 0) {
                this.split = width / (this.$el as any).offsetWidth;
            }
            this.$store.commit("setViewSplit", { viewUID: `${this.viewInstance?.codeName}_${this.treeExpBarInstance?.codeName}`, viewSplit: this.split });
        }
    }
}