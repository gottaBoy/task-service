import { MainControlBase } from "./main-control-base";
import { IPSAppDEView, IPSDETabViewPanel } from "@ibiz/dynamic-model-api";
import { MobTabViewPanelControlInterface } from "ibiz-core";

/**
 * 分页视图面板基类
 *
 * @export
 * @class AppControlBase
 * @extends {TabViewPanelControlBase}
 */
export class MobTabViewPanelControlBase extends MainControlBase implements MobTabViewPanelControlInterface {

    /**
     * 部件模型
     *
     * @type {AppTabViewPanelBase}
     * @memberof MobTabViewPanelControlBase
     */
    public declare controlInstance: IPSDETabViewPanel;

    /**
     * 是否激活
     *
     * @memberof MobTabViewPanelControlBase
     */
    public isActive = false;

    /**
     * 部件模型数据初始化实例
     *
     * @memberof MobTabViewPanelControlBase
     */
    public async ctrlModelInit(args?: any) {
        await super.ctrlModelInit();
        const embedView: IPSAppDEView = this.controlInstance.getEmbeddedPSAppDEView() as IPSAppDEView;
        if (embedView && !embedView.name) {
            await embedView.fill();
        }
    }

    /**
     * 部件初始化
     *
     * @param {*} [args]
     * @memberof MobTabViewPanelControlBase
     */
    public ctrlInit(args?: any) {
        super.ctrlInit(args);
        const _this = this;
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }: any) => {
                if (data.activeItem === _this.controlInstance.name) {
                    this.$nextTick(() => {
                        this.actived();
                    });
                } else {
                    this.isActive = false;
                }
            });
        }
    }

    /**
     * 激活
     *
     * @param {*} [args]
     * @memberof MobTabViewPanelControlBase
     */
    public async actived() {
        const embedView: IPSAppDEView = this.controlInstance.getEmbeddedPSAppDEView() as IPSAppDEView;
        if (embedView && !embedView.name) {
            await embedView.fill();
        }
        this.isActive = true;
    }

}