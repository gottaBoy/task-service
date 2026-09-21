import { IPSAppCodeList, IPSAppDEMethod } from "@ibiz/dynamic-model-api";
import { IContext, IEntityEnvContext, IParams } from "../../../interface";
import { HttpResponse, LogUtil } from "../../../utils";
import { AppMethod } from "./app-method";

/**
 *  代码表
 *
 * @export
 * @class AppCodeListMethod
 * @extends {AppMethod}
 */
export class AppCodeListMethod extends AppMethod {

    /**
     * @description 代码表对象
     * @type {IPSAppCodeList}
     * @memberof AppCodeListMethod
     */
    codeList: IPSAppCodeList;

    public constructor(entityEnvContext: IEntityEnvContext, appDEMethod: IPSAppDEMethod) {
      super(entityEnvContext, appDEMethod)
      const { dataEntity, dataService } = entityEnvContext;
      this.codeList = (appDEMethod as any).getPSAppCodeList?.();
    }

    /**
     * @description 执行方法
     * @param {IContext} context 上下文
     * @param {IParams} data 数据
     * @return {*}  {Promise<HttpResponse>}
     * @memberof AppCodeListMethod
     */
    public async execute(context: IContext, data: IParams): Promise<HttpResponse> {
        LogUtil.log(`执行实体内置方法，[方法名称]：${this.codeName}`);
        try {
            const targetResult: Array<any> = [];
            if (this.codeList) {
               const codeListItems: any = this.codeList.getPSCodeItems();
               if (codeListItems && codeListItems.length > 0) {
                 codeListItems.forEach((element: any) => {
                     targetResult.push({ [this.dataService.APPDEKEY]: element.value, [this.dataService.APPDETEXT]: element.text });
                 });
               }
            }
            const headers = new Headers({
              'x-total': targetResult.length.toString(),
            });
            return new HttpResponse(targetResult, { headers });
        } catch (error: any) {
            return new HttpResponse({ message: error.message }, {
                ok: false,
                status: 500
            });
        }
    }

}