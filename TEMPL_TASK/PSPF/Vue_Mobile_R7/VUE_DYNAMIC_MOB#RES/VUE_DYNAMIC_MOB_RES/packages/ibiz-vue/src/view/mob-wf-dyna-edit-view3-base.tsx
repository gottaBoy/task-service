import { IPSAppDEWFDynaEditView, IPSDEDRTab, IPSDEDRTabPage, IPSDEForm } from '@ibiz/dynamic-model-api';
import { Util, ModelTool, MobWFDynaEdit3ViewInterface } from 'ibiz-core';
import { MainViewBase } from './main-view-base';

/**
 * 工作流动态编辑视图(分页关系)基类
 *
 * @export
 * @class MobWFDynaEditView3Base
 * @extends {MainViewBase}
 * @implements {MobWFDynaEdit3ViewInterface}
 */
export class MobWFDynaEditView3Base extends MainViewBase implements MobWFDynaEdit3ViewInterface {

    /**
     * 视图实例
     *
     * @memberof MobWFDynaEditView3Base
     */
    public declare viewInstance: IPSAppDEWFDynaEditView;

    /**
     * 编辑表单实例
     *
     * @type {IPSDEForm}
     * @memberof MobWFDynaEditView3Base
     */
    public editFormInstance!: IPSDEForm;

    /**
     * 数据关系分页部件实例
     *
     * @type {IPSDEDRTab}
     * @memberof MobWFDynaEditView3Base
     */
    public drtabInstance!: IPSDEDRTab;

    /**
     * 工具栏模型数据
     *
     * @memberof MobWFDynaEditView3Base
     */
    public linkModel: Array<any> = [];

    /**
     * 视图引用数据
     *
     * @memberof MobWFDynaEditView3Base
     */
    public viewRefData: any = {};

    /**
     * 工作流按钮显示状态
     *
     * @memberof MobWFDynaEditView3Base
     */
    public toolBarVisible = false;

    /**
     * 关系数据分页部件分页
     *
     * @type {IPSDEDRTabPage[] | null}
     * @memberof MobWFDynaEditView3Base
     */
    public deDRTabPages: IPSDEDRTabPage[] | null = [];

    /**
     * 工作流附加功能类型映射关系对象
     *
     * @memberof MobWFDynaEditView3Base
     */
    public wfAddiFeatureRef: any = {
        reassign: { featureTag: 'REASSIGN', action: 'TransFerTask' },
        addstepbefore: { featureTag: 'ADDSTEPBEFORE', action: 'BeforeSign' },
        sendback: { featureTag: 'SENDBACK', action: 'SendBack' },
        sendcopy: { featureTag: 'SENDCOPY', action: 'sendCopy' },
    };

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MobWFDynaEditView3Base
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
    }

    /**
     * 初始化挂载状态集合
     *
     * @memberof MobWFDynaEditView3Base
     */
    public initUIContainerMountedMap() {
        this.mountedMap.set('self', false);
    }

    /**
     * 设置已经绘制完成状态
     *
     * @memberof MobWFDynaEditView3Base
     */
    public setContainerIsMounted(name: string = 'self') {
        super.setContainerIsMounted(name);
        if (this.editFormInstance?.name == name) {
            this.viewState.next({
                tag: this.editFormInstance.name,
                action: 'autoload',
                data: {
                    srfkey: this.context[this.appDeCodeName.toLowerCase()],
                },
            });
        }
    }

    /**
     * 初始化编辑视图实例
     *
     * @memberof MobWFDynaEditView3Base
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.viewRefData = await ModelTool.loadedAppViewRef(this.viewInstance);
        this.drtabInstance = ModelTool.findPSControlByName('drtab', this.viewInstance.getPSControls()) as IPSDEDRTab;
        this.deDRTabPages = this.drtabInstance?.getPSDEDRTabPages();
    }

    /**
     * 初始化工具栏数据
     *
     * @memberof MobWFDynaEditView3Base
     */
    public renderToolBar() {
        return (
            <div class="wf-button-content">
                <div class="toolbar-container" on-click={() => { this.WFViewEvent({ tag: 'toolBarVisibleChange' }) }}>
                    <ion-fab-button>
                        <ion-icon name="chevron-back-circle-outline"></ion-icon>
                    </ion-fab-button>
                </div>
            </div>
        );
    }

    /**
     * 绘制工作流按钮
     *
     * @return {*} 
     * @memberof MobWFDynaEditView3Base
     */
    public renderToolBarInfo() {
        return (
            <van-action-sheet
                class="wf-action-sheet"
                cancel-text="取消"
                get-container="#app"
                actions={this.linkModel}
                value={this.toolBarVisible}
                on-select={(item: any) => { this.WFViewEvent({ tag: 'WFButtonClick', value: item }) }}
                on-cancel={() => { this.WFViewEvent({ tag: 'toolBarVisibleChange' }) }}
                on-click-overlay={() => { this.WFViewEvent({ tag: 'toolBarVisibleChange' }) }}>
            </van-action-sheet>
        )
    }

    /**
     * 绘制分页关系
     *
     * @return {*} 
     * @memberof MobWFDynaEditView3Base
     */
    public renderDrTabPage() {
        const tempContext = Util.deepCopy(this.context);
        const tabsName = `${this.appDeCodeName?.toLowerCase()}_${this.viewInstance.codeName.toLowerCase()}`;
        const title = this.drtabInstance.M?.editItemCaption ? this.drtabInstance.M?.editItemCaption : this.editFormInstance.logicName;
        return [
            <van-tabs
                animated={false}
                name={tabsName}
                type="card"
            >
                <van-tab
                    tab={tabsName}
                    title={title}
                >
                    {this.renderFormContent()}
                </van-tab>
                {this.deDRTabPages?.map((deDRTabPage: IPSDEDRTabPage) => {
                    const tabTitle = this.$tl(deDRTabPage.getCapPSLanguageRes()?.lanResTag, deDRTabPage.caption);
                    return (
                        <van-tab tab={tabsName} title={tabTitle}                            >
                            {this.$createElement('app-view-shell', {
                                props: {
                                    staticProps: {
                                        appDeCodeName: this.appDeCodeName,
                                    },
                                    dynamicProps: {
                                        _context: JSON.stringify(
                                            Object.assign(tempContext, {
                                                viewpath: deDRTabPage?.M?.getPSAppView?.path,
                                            })
                                        ),
                                        _viewparams: JSON.stringify(
                                            this.viewparams
                                        ),
                                    },
                                },
                                class: 'view-container2'
                            })}
                        </van-tab>
                    );
                })}
            </van-tabs>,
        ]
    }

    /**
     * 渲染流程表单内容区
     *
     * @memberof MobWFDynaEditView3Base
     */
    public renderFormContent() {
        if (!this.editFormInstance) {
            return;
        }
        let {
            targetCtrlName,
            targetCtrlParam,
            targetCtrlEvent,
        } = this.computeTargetCtrlData(this.editFormInstance);
        Object.assign(targetCtrlParam.staticProps, { isautoload: true, });
        return this.$createElement(targetCtrlName, {
            slot: 'default',
            props: targetCtrlParam,
            ref: this.editFormInstance.name,
            on: targetCtrlEvent,
        });
    }

    /**
     * 渲染视图主体内容区
     *
     * @memberof MobWFDynaEditView3Base
     */
    public renderMainContent() {
        if (!this.editFormInstance) {
            return;
        }
        return <div class="app-vc-form">
            {
                this.deDRTabPages && this.deDRTabPages.length > 0 ?
                    this.renderDrTabPage() :
                    this.renderFormContent()
            }
        </div>

    }

    /**
     * 渲染视图底部
     *
     * @return {*} 
     * @memberof MobWFDynaEditView3Base
     */
    renderViewFooter() {
        return <div class="view-footer__buttons">
            {this.renderToolBar()}
            {this.renderToolBarInfo()}
        </div>
    }

    /**
     * 视图事件
     *
     * @param {*} $event
     * @return {*} 
     * @memberof MobWFDynaEditView3Base
     */
    public WFViewEvent($event: any) {
        const { tag, value } = $event;
        if (!tag) {
            console.log('视图事件tag 异常');
            return;
        }
        this.engine.onViewEvent(tag, value);
    }
}
