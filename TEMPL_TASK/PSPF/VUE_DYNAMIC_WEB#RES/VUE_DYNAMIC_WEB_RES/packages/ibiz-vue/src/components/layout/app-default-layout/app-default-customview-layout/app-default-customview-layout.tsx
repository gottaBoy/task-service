import { ModelTool } from "ibiz-core";
import { IPSAppDataEntity, IPSAppDEField, IPSAppViewEngine, IPSControl, IPSViewLayoutPanel } from "@ibiz/dynamic-model-api";
import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';

@Component({})
export class AppDefaultCustomViewLayout extends AppDefaultViewLayout {

    /**
     * 计算目标部件所需参数
     *
     * @param {any} [controlInstance] 部件模型实例
     * @returns
     * @memberof AppDefaultCustomViewLayout
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        // 合并视图级参数
        Object.assign(targetCtrlParam.staticProps, { viewState: this.viewState, viewtag: this.viewtag, viewIsProxyMode: this.viewProxyMode });
        Object.assign(targetCtrlEvent, {
            closeView: ($event: any) => {
                this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewClosed', data: $event });
            }
        })
        // 合并多数据视图级参数
        if (Object.is(controlInstance.controlType, 'SEARCHFORM') || Object.is(controlInstance.controlType, 'SEARCHBAR')) {
            Object.assign(targetCtrlParam.dynamicProps, {
                isExpandSearchForm: true
            });
        } else {
            Object.assign(targetCtrlParam.staticProps, {
                mDCtrlActiveMode: (this.viewInstance as any)?.mDCtrlActiveMode,
            });
        }
        // 合并表格视图级参数
        Object.assign(targetCtrlParam.staticProps, {
            isOpenEdit: this.viewInstance?.rowEditDefault,
            gridRowActiveMode: this.viewInstance?.gridRowActiveMode
        })
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}] 引擎参数
     * @memberof AppDefaultCustomViewLayout
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        const engineOptions: any = {
            view: this,
            keyPSDEField: (ModelTool.getContainerAppEntityCodeName(this.viewLayoutPanel) as string).toLowerCase(),
            majorPSDEField: (ModelTool.getAppEntityMajorField((this.viewLayoutPanel as IPSViewLayoutPanel).getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase()
        };
        if (this.viewLayoutPanel && this.viewLayoutPanel.getPSControls() && (this.viewLayoutPanel.getPSControls() as IPSControl[]).length > 0) {
            const ctrlArray: Array<any> = [];
            (this.viewLayoutPanel.getPSControls() as IPSControl[]).forEach((item: IPSControl) => {
                if (!Object.is(item.controlType, 'TOOLBAR') && this.$refs[item.name]) {
                    ctrlArray.push({ name: item.name, ctrl: (this.$refs[item.name] as any).ctrl });
                }
            })
            Object.assign(engineOptions, { ctrl: ctrlArray });
        }
        if (this.viewLayoutPanel && this.viewLayoutPanel.getPSAppViewEngines() && (this.viewLayoutPanel.getPSAppViewEngines() as IPSAppViewEngine[]).length > 0) {
            const engineArray: Array<any> = [];
            (this.viewLayoutPanel.getPSAppViewEngines() as IPSAppViewEngine[]).forEach((item: IPSAppViewEngine) => {
                if (Object.is(item.engineCat, 'CTRL')) {
                    engineArray.push(item.M);
                }
            })
            Object.assign(engineOptions, { engine: engineArray });
        }
        this.engine.init(engineOptions);
    }

}