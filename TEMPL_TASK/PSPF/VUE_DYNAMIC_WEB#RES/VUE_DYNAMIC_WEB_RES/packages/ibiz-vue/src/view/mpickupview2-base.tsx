import { IPSAppDEPickupView, IPSDEPickupViewPanel, IPSTreeExpBar } from '@ibiz/dynamic-model-api';
import { ModelTool, throttle, MPickupView2Engine, MPickUpView2Interface, Util, IParams } from 'ibiz-core';
import { MainViewBase } from './mainview-base';


/**
 * 数据多项选择视图（左右关系）基类
 *
 * @export
 * @class MPickUpView2Base
 * @extends {MainViewBase}
 */
export class MPickUpView2Base extends MainViewBase implements MPickUpView2Interface {

    /**
     * 视图实例
     * 
     * @memberof MPickUpView2Base
     */
    public declare viewInstance: IPSAppDEPickupView;

    /**
     * 选择视图面板实例
     * 
     * @memberof MPickUpView2Base
     */
    public pickupViewPanelInstance!: IPSDEPickupViewPanel;

    /**
     * 树导航部件
     *
     * @type {IPSTreeExpBar}
     * @memberof MPickUpView2Base
     */
    public treeExpBarInstance!: IPSTreeExpBar;

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof MPickUpView2Base
     */
    public isShowButton: boolean = true;

    /**
     * 选中数据的字符串
     *
     * @type {string}
     * @memberof MPickUpView2Base
     */
    public selectedData: string = "";

    /**
     * 是否初始化已选中项
     *
     * @type {any[]}
     * @memberof MPickUpView2Base
     */
    public isInitSelected: boolean = false;

    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof MPickUpView2Base
     */
    public viewSelections: any[] = [];

    /**
     * 分隔值
     *
     * @type {number}
     * @memberof MPickUpView2Base
     */
    public split: number = 0.2;

    /**
     * 导航项
     *
     * @type {*}
     * @memberof MPickUpView2Base
     */
    public navItem: any;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof MPickUpView2Base
     */
    public isSingleSelect: boolean = false;

    /**
     * 部件模型
     *
     * @type {IParams}
     * @memberof MPickUpView2Base
     */
    public ctrlModel: IParams = {};

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MPickUpView2Base
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        super.onDynamicPropsChange(newVal, oldVal);
        if (this.viewparams?.selectedData) {
            this.selectedData = JSON.stringify(this.viewparams.selectedData);
            this.viewSelections = this.viewparams.selectedData;
        }
    }

    /**
     * 监听部件静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MPickUpView2Base
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.isShowButton = newVal?.isShowButton !== false;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MPickUpView2Base
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let engineOpts = ({
            view: this,
            p2k: '0',
            treeExpBar: (this.$refs[this.treeExpBarInstance?.name] as any).ctrl,
            pickupViewPanel: (this.$refs[this.pickupViewPanelInstance?.name] as any)?.ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
        this.engine.init(engineOpts);
    }

    /**
     *  视图初始化
     *
     * @memberof MPickUpView2Base
     */
    public async containerMounted() {
        super.containerMounted();
        this.initSplit();
    }

    /**
     * 初始化容器模型
     *
     * @param {*} opts
     * @memberof MPickUpView2Base
     */
    public initContainerModel(opts: any) {
        super.initContainerModel(opts);
        const { modeldata } = opts;
        modeldata?.getPSControls().forEach((ctrl: any) => {
            this.ctrlModel[ctrl.name] = { name: `${ctrl.name}`, type: `${ctrl.controlType}` };
        });
    }

    /**
     * 初始化分页导航视图实例
     * 
     * @memberof MPickUpView2Base
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDEPickupView;
        await super.viewModelInit();
        this.pickupViewPanelInstance = ModelTool.findPSControlByType("PICKUPVIEWPANEL", this.viewInstance.getPSControls());
        this.treeExpBarInstance = ModelTool.findPSControlByType('TREEEXPBAR', this.viewInstance.getPSControls());
    }

    /**
     *  渲染视图底部按钮
     * @memberof MPickUpView2Base
     */
    public renderFooter() {
        return (
            this.isShowButton ? <div slot="footer" class="view-footer__buttons">
                <app-button
                    type="primary"
                    disabled={this.viewSelections.length > 0 ? false : true}
                    caption={this.viewButtonModel?.view_okbtn?.text}
                    on-onClick={(e: any) => throttle(this.onClickOk, e, this)}>
                </app-button>
                &nbsp;&nbsp;
                <app-button
                    caption={this.viewButtonModel?.view_cancelbtn?.text}
                    on-onClick={(e: any) => throttle(this.onClickCancel,e,this)}>
                </app-button>
            </div> : null
        )
    }

    /**
     * 渲染按钮
     * 
     * @memberof MPickUpView2Base
     */
    public renderButtons() {
        return [
            <app-button
                type="primary"
                tooltip={this.viewButtonModel?.view_rightbtn.text}
                disabled={this.viewButtonModel?.view_rightbtn.disabled}
                iconcls="el-icon-arrow-right"
                on-onClick={(e: any) => throttle(this.onCLickRight, e, this)}>
            </app-button>,
            <app-button
                type="primary"
                tooltip={this.viewButtonModel?.view_leftbtn.text}
                disabled={this.viewButtonModel?.view_leftbtn.disabled}
                iconcls="el-icon-arrow-left"
                on-onClick={(e: any) => throttle(this.onCLickLeft, e, this)}>
            </app-button>,
            <app-button
                type="primary"
                tooltip={this.viewButtonModel?.view_allrightbtn.text}
                disabled={this.viewButtonModel?.view_allrightbtn.disabled}
                iconcls="el-icon-d-arrow-right"
                on-onClick={(e: any) => throttle(this.onCLickAllRight, e, this)}>
            </app-button>,
            <app-button
                type="primary"
                tooltip={this.viewButtonModel?.view_allleftbtn.text}
                disabled={this.viewButtonModel?.view_allleftbtn.disabled}
                iconcls="el-icon-d-arrow-left"
                on-onClick={(e: any) => throttle(this.onCLickAllLeft, e, this)}>
            </app-button>
        ]
    }

    /**
     * 渲染多数据选择
     * 
     * @memberof MPickUpView2Base
     */
    public renderMpickerSelect() {
        return <div class="view-content__body__transfer__right__select">
            {this.viewSelections.map((item: any, index: number) => {
                return <div key={index} class={{ 'is-active': item._select, 'picker-item': true }} on-click={() => throttle(this.selectionsClick, [item], this)} on-dblclick={() => throttle(this.selectionsDBLClick, [item], this)} title={item.srfmajortext}>
                    <span>{item.srfmajortext}</span>
                </div>
            })}
        </div>
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof MPickUpView2Base
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.dynamicProps, {
            selectedData: this.selectedData,
        })
        Object.assign(targetCtrlParam.staticProps, {
            isSingleSelect: false,
            isShowButton: this.isShowButton,
        })
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent }
    }

    /**
     * 选中数据单击
     *
     * @param {*} item
     * @memberof MPickUpView2Base
     */
    public selectionsClick(item: any): void {
        item._select = !item._select;
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.viewButtonModel.view_leftbtn.disabled = !removeSelect;
        this.$forceUpdate();
    }

    /**
     * 选中树双击
     *
     * @param {*} item
     * @memberof MPickUpView2Base
     */
    public selectionsDBLClick(item: any): void {
        const index: number = this.viewSelections.findIndex((selection: any) => Object.is(selection.srfkey, item.srfkey));
        if (index !== -1) {
            this.viewSelections.splice(index, 1);
        }
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.viewButtonModel.view_leftbtn.disabled = !removeSelect;
        this.selectedData = JSON.stringify(this.viewSelections);
    }

    /**
     * 删除右侧全部选中数据
     *
     * @memberof MPickUpView2Base
     */
    public onCLickLeft(): void {
        if (this.engine) {
            this.engine.toLeft();
        }
    }

    /**
     * 添加左侧选中数据
     *
     * @memberof MPickUpView2Base
     */
    public onCLickRight(): void {
        if (this.engine) {
            this.engine.toRight();
        }
    }

    /**
     * 选中数据全部删除
     *
     * @memberof MPickUpView2Base
     */
    public onCLickAllLeft(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine) {
            this.engine.toAllLeft();
        }
    }

    /**
     * 添加左侧面板所有数据到右侧
     *
     * @memberof MPickUpView2Base
     */
    public onCLickAllRight(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine) {
            this.engine.toAllRight();
        }
    }

    /**
     * 去重
     *
     * @memberof MPickUpView2Base
     */
    public removeDuplicates(data: any): Array<any> {
        const uniqueSet = new Set(data);
        return [...uniqueSet];
    }

    /**
     * 确定
     *
     * @memberof MPickUpView2Base
     */
    public onClickOk(): void {
        this.$emit('view-event', { viewName: this.viewInstance?.name, action: 'viewdataschange', data: this.viewSelections });
        this.$emit('view-event', { viewName: this.viewInstance?.name, action: 'close', data: null });
    }

    /**
     * 取消
     *
     * @memberof MPickUpView2Base
     */
    public onClickCancel(): void {
        this.$emit('view-event', { viewName: this.viewInstance?.name, action: 'viewdataschange', data: null });
        this.$emit('view-event', { viewName: this.viewInstance?.name, action: 'close', data: null });
    }

    /**
     * 处理分隔值变化
     *
     * @memberof MPickUpView2Base
     */
    public handleSplitChange() {
        if (this.split) {
            this.$store.commit("setViewSplit", { viewUID: `${this.viewInstance?.codeName}_${this.treeExpBarInstance?.codeName}`, viewSplit: this.split });
        }
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