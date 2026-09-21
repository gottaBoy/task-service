import { IPSDETabViewPanel } from "@ibiz/dynamic-model-api";
import { MobTabExpPanelControlInterface, Util } from "ibiz-core";
import { MainControlBase } from "./main-control-base";

/**
 * 分页面板部件基类
 *
 * @export
 * @class MobTabExpPanelControlBase
 * @extends {MainControlBase}
 */
export class MobTabExpPanelControlBase extends MainControlBase implements MobTabExpPanelControlInterface {

    /**
     * 被激活的分页面板
     *
     * @type {string}
     * @memberof MobTabExpPanelControlBase
     */
     public activeTabViewPanel?: string;

    /**
     *
     *
     * @memberof MobTabExpPanelControlBase
     */
    ctrlMounted() {
        super.ctrlMounted();
        if (this.activeTabViewPanel) {
            this.viewState.next({ tag: this.activeTabViewPanel, action: 'active', data: { activeItem: this.activeTabViewPanel } });
        }
    }

    /**
     * 初始化激活tab栏
     *
     * @memberof MobTabExpPanelControlBase
     */
    public initActiveTab() {
        const allControls = this.controlInstance.getPSControls() as IPSDETabViewPanel[];
        const activeTab: any = this.$route.query?.activeTab;
        if (activeTab) {
            this.activeTabViewPanel = activeTab;
        } else if (allControls?.length > 0) {
            this.activeTabViewPanel = allControls[0].name;
        }
        this.viewState.next({ tag: this.activeTabViewPanel, action: 'active', data: { activeItem: this.activeTabViewPanel } });
        this.$forceUpdate();
    }

    /**
     * 部件事件
     * @param ctrl 部件 
     * @param action  行为
     * @param data 数据
     * 
     * @memberof MobTabExpPanelControlBase
     */
     public onCtrlEvent(controlname: string, action: string, data: any) {
        if(Object.is(action,'controlIsMounted')){
            this.initActiveTab();
        }
        super.onCtrlEvent(controlname,action,data);
    }


    /**
     *  分页切换
     *
     * @param {*} $event
     * @return {*} 
     * @memberof MobTabExpPanelControlBase
     */
    async tabExpPanelChange($event: any) {
        let { detail } = $event;
        if (!detail) {
            return;
        }
        let { value } = detail;
        if (!value) {
            return;
        }
        if (!(await this.handleCtrlEvents('onbeforetabexpchange', { action: 'tabexpchange', data: value }))) {
            return;
        }
        if (this.activeTabViewPanel) {
            this.viewState.next({ tag: this.activeTabViewPanel, action: 'active', data: { activeItem: value } });
        }
        if (!(await this.handleCtrlEvents('ontabexpchangesuccess', { action: 'tabexpchange', data: value }))) {
            return;
        }
    }


}