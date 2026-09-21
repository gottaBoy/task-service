import { IParams } from "ibiz-core";
import { UILogicParamType } from "../const/ui-logic-param-type";
import { AppDeUILogicParamBase } from "./ui-logic-param-base";

/**
 * 当前视图
 *
 * @export
 * @class UILogicActiveViewParam
 */
export class UILogicActiveViewParam extends AppDeUILogicParamBase {

    /**
     * Creates an instance of UILogicActiveViewParam.
     * @param {*} opts
     * @memberof UILogicActiveViewParam
     */
    public constructor(opts: any) {
        super(opts);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UILogicActiveViewParam
     */
    protected init(params: IParams) {
        this.logicParamType = UILogicParamType.activeViewParam;
        this.setReal(this.getActiveView(params));
    }

    /**
     * 获取激活视图
     *
     * @private
     * @param {IParams} params
     * @memberof UILogicActiveViewParam
     */
    private getActiveView(params: IParams) {
        const { actioncontext } = params;
        if (actioncontext && actioncontext.viewCtx && actioncontext.viewCtx.view) {
            return actioncontext.viewCtx.view;
        } else {
            return null;
        }
    }

    /**
     * 获取指定属性值(获取当前视图指定名称部件)
     *
     * @param {string} strName
     * @memberof UILogicActiveViewParam
     */
    public get(strName: string) {
        const actionContainer = this.actionSession.actionContainer;
        if (actionContainer && actionContainer.viewCtx && actionContainer.viewCtx.view) {
            const view = actionContainer.viewCtx.view;
            let ctrl = view.$refs[strName.toLowerCase()]?.$refs.ctrl;
            if (ctrl) {
                return ctrl;
            } else {
                // 视图布局面板获取
                if (Object.is(actionContainer?.type, 'VIEWLAYOUT')) {
                    const { args } = this.actionSession.additionalParam;
                    // 多数据域
                    if (args && args.hasMulParent) {
                        ctrl = actionContainer.layoutDetailsModel[`${strName.toLowerCase()}_${args.index}`];
                    } else {
                        ctrl = actionContainer.layoutDetailsModel[strName.toLowerCase()];
                    }
                    if (ctrl) {
                        return ctrl;
                    } else {
                        throw new Error(`逻辑参数${this.strCodeName}无法找到指定部件`);
                    }
                } else {
                    throw new Error(`逻辑参数${this.strCodeName}无法找到指定部件`);
                }
            }
        }
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof UILogicActiveViewParam
     */
    public reset(strName: string) {
        throw new Error(`逻辑参数${this.strCodeName}为当前视图类型，无法重置指定属性`);
    }

    /**
     * 重置全部
     *
     * @memberof UILogicActiveViewParam
     */
    public resetAll() {
        throw new Error(`逻辑参数${this.strCodeName}为当前视图类型，无法重置全部`);
    }

    /**
     * 拷贝当前变量到指定变量
     *
     * @param {*} dstParam
     * @memberof UILogicActiveViewParam
     */
    public copyTo(dstParam: any) {
        throw new Error(`逻辑参数${this.strCodeName}为当前视图类型，无法拷贝当前变量到指定变量`);
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof UILogicActiveViewParam
     */
    public bind(opts: any) {
        throw new Error(`逻辑参数${this.strCodeName}为当前视图类型，无法绑定指定参数对象`);
    }

    /**
     * 重新建立参数对象
     *
     * @memberof UILogicActiveViewParam
     */
    public renew() {
        throw new Error(`逻辑参数${this.strCodeName}为当前视图类型，无法重新建立参数对象`);
    }
}