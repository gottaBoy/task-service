import { IPSAppView, IPSDEForm } from '@ibiz/dynamic-model-api';
import { AppModelService, GetModelService } from '../service';
import { LogUtil, ModelTool, Util } from '../utils';
import { MobEditViewEngine } from './mob-edit-view-engine';
/**
 * 实体移动端工作流动态编辑视图引擎基础
 *
 * @export
 * @class WFDynaEditViewEngine
 * @extends {EditViewEngine}
 */
export class MobWFDynaEditViewEngine extends MobEditViewEngine {

    /**
     * Creates an instance of WFDynaEditViewEngine.
     * @memberof WFDynaEditViewEngine
     */
    constructor() {
        super();
    }


    /**
     * 引擎加载
     *
     * @param {*} [opts={}]
     * @memberof WFDynaEditViewEngine
     */
    public load(opts: any = {}): void {
        this.getFormModel();
    }

    /**
     * 部件事件机制
     *
     * @param {string} ctrlName
     * @param {string} eventName
     * @param {*} args
     * @memberof WFDynaEditViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any): void {
        if (Object.is(eventName, 'load')) {
            this.onFormLoad(args);
        }
    }

    /**
     * 视图事件
     *
     * @param {string} tag
     * @param {*} args
     * @memberof MDViewEngineBase
     */
    onViewEvent(tag: string, args: any) {
        switch (tag) {
            case 'WFButtonClick':
                this.dynamic_toolbar_click(args);
                break;
            case 'toolBarVisibleChange':
                this.view.toolBarVisible = !this.view.toolBarVisible;
                break
            default:
                break;
        }
    }

    /**
     * 表单加载完成
     *
     * @param {*} args
     * @memberof WFDynaEditViewEngine
     */
    public onFormLoad(arg: any): void {
        // 设置已读
        if (Object.is(this.view?.viewparams?.srfwf, "toread") || Object.is(this.view?.viewparams?.srfwf, "todo")) {
            Object.assign(arg, { taskId: this.view.viewparams.srftaskid });
            this.view.readTask(arg);
        }
        // 获取工具栏模型
        this.getWFLinkModel(arg);
    }

    /**
     * 获取动态表单模型
     *
     * @memberof WFDynaEditViewBase
     */
    public getFormModel(): Promise<any> {
        if (!this.view) {
            return Promise.resolve(null);
        }
        const _this: any = this.view;
        return new Promise((resolve: any, reject: any) => {
            let datas: any[] = [];
            if (Object.keys(_this.viewparams).length > 0) {
                Object.assign(datas, {
                    processDefinitionKey: _this.viewparams.processDefinitionKey,
                });
                Object.assign(datas, {
                    taskDefinitionKey: _this.viewparams.taskDefinitionKey,
                });
            }
            _this.appEntityService.getWFStep(JSON.parse(JSON.stringify(_this.context)), datas, true).then((response: any) => {
                if (response && response.status === 200) {
                    const data = response.data;
                    if (data && data['process-mobform']) {
                        this.computeActivedForm(data['process-mobform']);
                    } else {
                        this.computeActivedForm(null);
                    }
                    resolve(response);
                }
            }).catch((response: any) => {
                _this.$Notice.error(response);
                reject(response);
            });
        });
    }

    /**
     * 计算激活表单
     *
     * @memberof MobWFDynaEditView3Base
     */
    public computeActivedForm(inputForm: any) {
        if (!this.view) {
            return;
        }
        const _this: any = this.view;
        if (!inputForm) {
            _this.editFormInstance = ModelTool.findPSControlByName(
                'form',
                _this.viewInstance.getPSControls()
            ) as IPSDEForm;
        } else {
            _this.editFormInstance = ModelTool.findPSControlByName(
                `wfform_${inputForm.toLowerCase()}`,
                _this.viewInstance.getPSControls()
            ) as IPSDEForm;
        }
        _this.mountedMap.set(_this.editFormInstance.name, false);
        _this.$forceUpdate();
    }

    /**
     * 获取工具栏按钮
     *
     * @memberof MobWFDynaEditView3Base
     */
    public getWFLinkModel(arg: any): Promise<any> {
        if (!this.view) {
            return Promise.resolve(null);
        }
        const _this: any = this.view;
        return new Promise((resolve: any, reject: any) => {
            let datas: any[] = [];
            if (Object.keys(_this.viewparams).length > 0) {
                Object.assign(datas, {
                    processDefinitionKey: _this.viewparams.processDefinitionKey,
                });
                Object.assign(datas, {
                    taskDefinitionKey: _this.viewparams.taskDefinitionKey,
                });
            }
            if (arg && Object.keys(arg).length > 0) {
                Object.assign(datas, { activedata: arg });
            }
            _this.appEntityService.GetWFLink(JSON.parse(JSON.stringify(_this.context)), datas, true).then((response: any) => {
                if (response && response.status === 200) {
                    _this.linkModel = response.data;
                    _this.linkModel.forEach((item: any) => {
                        item.name = item.sequenceFlowName;
                    })
                    resolve(response.data);
                }
            }).catch((response: any) => {
                reject(response);
                _this.$Notice.error(response);
            });
        });
    }

    /**
     * 处理工作流辅助功能
     *
     * @memberof MobWFDynaEditView3Base
     */
    public handleWFAddiFeature(linkItem: any) {
        if (!this.view) {
            return;
        }
        const _this: any = this.view;
        let featureTag: string = _this.wfAddiFeatureRef[linkItem?.type]?.featureTag;
        if (!featureTag) return;
        let targetViewRef: any = _this.viewRefData.find((item: any) => {
            return item.name === `WFUTILACTION@${featureTag}`;
        });
        if (!targetViewRef) {
            LogUtil.warn(_this.$t('app.warn.dynaViewNotFound'));
            return;
        }
        // 准备参数
        let datas: any[] = [];
        let xData: any = (_this.$refs[_this.editFormInstance.name] as any).ctrl;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        let tempContext: any = Util.deepCopy(_this.context);
        let tempViewParam: any = { actionView: linkItem.sequenceflowmobview, actionForm: linkItem.sequenceflowmobform };
        Object.assign(tempContext, { viewpath: targetViewRef?.getRefPSAppView?.path });
        GetModelService(tempContext).then((modelService: AppModelService) => {
            modelService.getPSAppView(targetViewRef?.getRefPSAppView?.path).then((viewResult: IPSAppView) => {
                const appmodal = _this.$appmodal.openModal({ viewname: 'app-view-shell', title: viewResult.title, height: viewResult.height, width: viewResult.width, }, tempContext, tempViewParam);
                appmodal.subscribe((result: any) => {
                    if (!result || !Object.is(result.ret, 'OK')) {
                        return;
                    }
                    let tempSubmitData: any = Util.deepCopy(datas[0]);
                    if (result.datas && result.datas[0]) {
                        const resultData: any = result.datas[0];
                        if (Object.keys(resultData).length > 0) {
                            let tempData: any = {};
                            Object.keys(resultData).forEach((key: any) => {
                                if (resultData[key] && key !== 'srfuf')
                                    tempData[key] = resultData[key];
                            });
                            Object.assign(tempSubmitData, tempData);
                        }
                        _this.submitWFAddiFeature(linkItem, tempSubmitData);
                    }
                });
            });
        });
    }

    /**
     * 提交工作流辅助功能
     *
     * @memberof MobWFDynaEditView3Base
     */
    public submitWFAddiFeature(linkItem: any, submitData: any) {
        if (!this.view) {
            return;
        }
        const _this: any = this.view;
        let tempSubmitData: any = Object.assign(linkItem, { activedata: submitData, });
        let action: string = _this.wfAddiFeatureRef[linkItem?.type]?.action;
        if (!action) return;
        _this.appEntityService[action](Util.deepCopy(_this.context), tempSubmitData).then((response: any) => {
            const { data: data } = response;
            if (!response || response.status !== 200) {
                _this.$Notice.error(response);
                return;
            }
            if (_this._context) {
                _this.$emit('view-event', {
                    viewName: _this.viewInstance.name,
                    action: 'viewdataschange',
                    data: [{ ...data }],
                });
                _this.$emit('view-event', {
                    viewName: _this.viewInstance.name,
                    action: 'close',
                    data: null,
                });
            } else {
                _this.closeView([{ ...data }]);
            }
            _this.$Notice.success(data?.message ? data.message : _this.$t('app.success.submitSuccess'));
        }).catch((error: any) => {
            _this.$Notice.error(error);
        });
    }

    /**
     * 将待办任务标记为已读
     *
     * @param data 业务数据
     * @memberof MobWFDynaEditView3Base
     */
    public readTask(data: any) {
        if (!this.view) {
            return;
        }
        const _this: any = this.view;
        _this.appEntityService.ReadTask(_this.context, data).then((response: any) => {
            if (!response || response.status !== 200) {
                LogUtil.warn(_this.$t('app.warn.markAsFailRead'));
                return;
            }
        }).catch((error: any) => {
            LogUtil.warn(_this.$t('app.warn.markAsFailRead'));
        });
    }

    /**
     * 动态工具栏点击
     *
     * @memberof MobWFDynaEditView3Base
     */
    public dynamic_toolbar_click(linkItem: any) {
        if (!this.view) {
            return;
        }
        const _this: any = this.view;
        let datas: any[] = [];
        let xData: any = (_this.$refs[_this.editFormInstance.name] as any).ctrl;
        if (xData.getDatas && xData.getDatas instanceof Function) {
            datas = [...xData.getDatas()];
        }
        const submit: Function = (submitData: any, linkItem: any) => {
            xData.wfsubmit(submitData, linkItem).then((response: any) => {
                if (!response || response.status !== 200) {
                    return;
                }
                const { data: _data } = response;
                if (_this._context) {
                    _this.$emit('view-event', {
                        viewName: _this.viewInstance.name,
                        action: 'viewdataschange',
                        data: [{ ..._data }],
                    });
                    _this.$emit('view-event', {
                        viewName: _this.viewInstance.name,
                        action: 'close',
                        data: null,
                    });
                } else {
                    _this.closeView([{ ..._data }]);
                }
            });
        };
        const submitAction: Function = () => {
            if (linkItem && linkItem.sequenceflowmobview) {
                const targetViewRef: any = _this.viewRefData.find((item: any) => {
                    return (item.name === `WFACTION@${linkItem.sequenceflowmobview}`);
                }
                );
                if (targetViewRef) {
                    let tempContext: any = Util.deepCopy(_this.context);
                    if (datas && datas[0].srfkey) {
                        Object.assign(tempContext, { [_this.appDeCodeName.toLowerCase()]: datas && datas[0].srfkey });
                    }
                    let tempViewParam: any = {
                        actionView: linkItem.sequenceflowmobview,
                        actionForm: linkItem.sequenceflowmobform,
                    };
                    Object.assign(tempContext, {
                        viewpath: targetViewRef?.getRefPSAppView?.path,
                    });
                    GetModelService(tempContext).then((modelService: AppModelService) => {
                        modelService.getPSAppView(targetViewRef?.getRefPSAppView?.path).then((viewResult: IPSAppView) => {
                            _this.$appmodal.openModal({ viewname: 'app-view-shell', title: viewResult.title, height: viewResult.height, width: viewResult.width }, tempContext, tempViewParam).then((result: any) => {
                                if (!result || !Object.is(result.ret, 'OK')) {
                                    return;
                                }
                                let tempSubmitData: any = Util.deepCopy(
                                    datas[0]
                                );
                                if (result.datas && result.datas[0]) {
                                    const resultData: any =
                                        result.datas[0];
                                    if (Object.keys(resultData).length > 0) {
                                        let tempData: any = {};
                                        Object.keys(resultData).forEach((key: any) => {
                                            if (resultData[key] && key !== 'srfuf') {
                                                tempData[key] = resultData[key];
                                            }
                                        });
                                        Object.assign(tempSubmitData, tempData);
                                    }
                                }
                                submit([tempSubmitData], linkItem);
                            });
                        });
                    }
                    );
                }
            } else {
                submit(datas, linkItem);
            }
        };
        if (linkItem && linkItem.type) {
            if (Object.is(linkItem.type, 'finish')) {
                submitAction();
            } else {
                this.handleWFAddiFeature(linkItem)
            }
        } else {
            submitAction();
        }
    }
}