import { IPSDEUILogicParam, IPSDEUIMsgBoxLogic } from '@ibiz/dynamic-model-api';
import { Subject } from 'rxjs';
import { AppMessageBoxService } from '../../../app-service';
import { UIActionContext } from '../uiaction-context';
import { AppUILogicNodeBase } from './logic-node-base';
/**
 * 消息弹窗节点
 *
 * @export
 * @class AppUILogicMsgboxNode
 */
export class AppUILogicMsgboxNode extends AppUILogicNodeBase {

    constructor() {
        super();
    }

    /**
     * 执行节点
     *
     * @param {IPSDEUIMsgBoxLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @memberof AppUILogicMsgboxNode
     */
    public async executeNode(logicNode: IPSDEUIMsgBoxLogic, actionContext: UIActionContext) {
        try {
            return new Promise<void>((resolve) => {
                let msgBoxParam: any = actionContext.getParam((logicNode.getMsgBoxParam() as IPSDEUILogicParam)?.codeName);
                const data = msgBoxParam?.getReal();
                const options = {
                    type: logicNode.msgBoxType?.toLowerCase(),
                    title: data?.title ? data.title : logicNode.title ? eval('`' + logicNode.title + '`') : '消息',
                    content: data?.message ? data.message : logicNode.message ? eval('`' + logicNode.message + '`') : '',
                    buttonType: logicNode.buttonsType?.toLowerCase(),
                    showMode: logicNode.showMode?.toLowerCase(),
                    showClose: false,
                    mask: true,
                    maskClosable: true
                };
                const subject: Subject<any> | null = AppMessageBoxService.getInstance().open(options);
                const subscription = subject?.subscribe((result: any) => {
                    resolve(this.handleResponse(logicNode, actionContext, options, result));
                    subscription!.unsubscribe();
                    subject.complete();
                })
            });
        } catch (error: any) {
            throw new Error(`逻辑节点 ${logicNode.name}${error?.message ? error?.message : '发生未知错误！'}`);
        }
    }

    /**
     * 处理响应
     *
     * @param {IPSDEUIMsgBoxLogic} logicNode 逻辑节点模型数据
     * @param {UIActionContext} actionContext 界面逻辑上下文
     * @param {string} result 响应结果
     * @memberof AppUILogicMsgboxNode
     */
    public handleResponse(logicNode: IPSDEUIMsgBoxLogic, actionContext: UIActionContext, options: any, result: string) {
        const { buttonsType } = logicNode;
        if (!Object.is(buttonsType, 'YESNO') && !Object.is(buttonsType, 'YESNOCANCEL') && !Object.is(buttonsType, 'OK') && !Object.is(buttonsType, 'OKCANCEL')) {
            throw new Error(`${buttonsType}未实现`);
        }
        let msgBoxParam: any = actionContext.getParam((logicNode.getMsgBoxParam() as IPSDEUILogicParam)?.codeName);
        if (msgBoxParam){
            msgBoxParam.bind(result);
        }
        actionContext.bindLastReturnParam(result);
        return this.computeNextNodes(logicNode, actionContext);
    }
}