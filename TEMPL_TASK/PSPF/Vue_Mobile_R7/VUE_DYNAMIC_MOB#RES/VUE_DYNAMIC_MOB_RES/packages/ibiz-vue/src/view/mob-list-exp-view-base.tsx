import { IPSAppDataEntity, IPSAppDEField, IPSAppDEMobListExplorerView, IPSListExpBar } from '@ibiz/dynamic-model-api';
import { MobListExpViewInterface, ModelTool } from 'ibiz-core';
import { MobExpViewBase } from './mob-exp-view-base';


/**
 * 列表导航视图基类
 *
 * @export
 * @class MobListExpViewBase
 * @extends {ExpViewBase}
 */
export class MobListExpViewBase extends MobExpViewBase implements MobListExpViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MobListExpViewBase
     */
    public declare viewInstance: IPSAppDEMobListExplorerView;

    /**
     * 导航栏实例
     * 
     * @memberof MobListExpViewBase
     */
    public declare expBarInstance: IPSListExpBar;


    /**
     * 选中数据
     *
     * @type {*}
     * @memberof MobListExpViewBase
     */
    public selection: any = {};

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MobListExpViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        let engineOpts = ({
            view: this,
            p2k: '0',
            listexpbar: (this.$refs[this.expBarInstance.name] as any).ctrl,
            keyPSDEField: (ModelTool.getContainerAppEntityCodeName(this.viewInstance) as string).toLowerCase(),
            majorPSDEField: (ModelTool.getAppEntityMajorField(this.viewInstance.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
        this.engine.init(engineOpts);
    }

    /**
     * 初始化分页导航视图实例
     * 
     * @memberof MobListExpViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.expBarInstance = ModelTool.findPSControlByName('listexpbar', this.viewInstance.getPSControls()) as IPSListExpBar;
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof MobListExpViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.staticProps, {
            sideBarLayout: this.viewInstance.sideBarLayout
        })
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 列表导航栏
     *
     * @return {*} 
     * @memberof MobListExpViewBase
     */
    public renderListExpBar() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.expBarInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.expBarInstance.name, on: targetCtrlEvent });
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof ExpViewBase
     */
    public renderMainContent() {
        return (<div class="app-vc-expbar">
            <div class= "app-vc-expbar__left">
                {this.renderListExpBar()}
            </div>
            <div class="app-vc-expbar__body">
                {this.renderNavView()} 
            </div>
        </div>)
    }

    /**
     * 绘制导航视图
     *
     * @memberof MobListExpViewBase
     */
    public renderNavView() {
        const { srfnavdata } = this.selection;
        if (!srfnavdata) {
            return;
        }
        const { context, viewparams } = srfnavdata;
        let targetCtrlParam: any = {
            staticProps: {
                viewDefaultUsage: 'INCLUDEDVIEW',
                viewpath: this.context.viewpath
            },
            dynamicProps: {
                _viewparams: JSON.stringify(viewparams),
                _context: JSON.stringify(context),
            }
        };
        return this.$createElement('app-view-shell', {
            class: "view-container2",
            props: targetCtrlParam,
        });
    }
}