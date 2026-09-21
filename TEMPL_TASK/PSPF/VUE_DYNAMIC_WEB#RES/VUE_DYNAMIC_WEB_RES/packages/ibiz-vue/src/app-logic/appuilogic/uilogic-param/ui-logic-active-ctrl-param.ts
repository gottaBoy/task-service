import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 当前部件对象参数
 *
 * @export
 * @class UILogicActiveCtrlParam
 */
export class UILogicActiveCtrlParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicActiveCtrlParam.
     * @param {*} opts
     * @memberof UILogicActiveCtrlParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicActiveCtrlParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.activeCtrlParam;
        this.setReal(this.getActiveCtrl(params));
    }

    /**
     * 获取激活部件
     *
     * @private
     * @param {IParams} params
     * @memberof UILogicActiveCtrlParam
     */
    private getActiveCtrl(params: IParams) {
        const { actioncontext, xData } = params;
        if (xData) {
            return xData;
        } else {
            // 部件触发肯定存在
            if (actioncontext.viewCtx && actioncontext.viewCtx.ctrl) {
                return actioncontext.viewCtx.ctrl;
            } else {
                // 非部件触发（视图触发）
                if (actioncontext.viewCtx && actioncontext.viewCtx.view) {
                    const view = actioncontext.viewCtx.view;
                    const xDataMap: string[] = ['GRID', 'LIST', 'FORM', 'TREEVIEW', 'DATAVIEW'];
                    const xDataControl = (view.viewInstance.getPSControls?.() || []).find((control: any) => xDataMap.indexOf(control.controlType) !== -1);
                    const xDataCtrl = view.$refs[xDataControl.name.toLowerCase()].ctrl;
                    return xDataCtrl ? xDataCtrl : null;
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof UILogicActiveCtrlParam
     */
    public reset(strName: string) {
        throw new Error(`逻辑参数${this.strCodeName}为当前部件类型，无法重置指定属性`);
    }

    /**
     * 重置全部
     *
     * @memberof UILogicActiveCtrlParam
     */
    public resetAll() {
        throw new Error(`逻辑参数${this.strCodeName}为当前部件类型，无法重置全部`);
    }

    /**
     * 拷贝当前变量到指定变量
     *
     * @param {*} dstParam
     * @memberof UILogicActiveCtrlParam
     */
    public copyTo(dstParam: any) {
        throw new Error(`逻辑参数${this.strCodeName}为当前部件类型，无法拷贝当前变量到指定变量`);
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof UILogicActiveCtrlParam
     */
    public bind(opts: any) {
        throw new Error(`逻辑参数${this.strCodeName}为当前部件类型，无法绑定指定参数对象`);
    }

    /**
     * 重新建立参数对象
     *
     * @memberof UILogicActiveCtrlParam
     */
     public renew() {
        throw new Error(`逻辑参数${this.strCodeName}为当前部件类型，无法重新建立参数对象`);
    }
}