import { ModelTool, EditView4Interface } from 'ibiz-core';
import { IPSDEDRTab, IPSDRTab } from '@ibiz/dynamic-model-api';
import { EditViewBase } from './editview-base';


/**
 * 编辑视图（上下关系）基类
 *
 * @export
 * @class EditView4Base
 * @extends {EditViewBase}
 * @implements {EditViewInterface}
 */
export class EditView4Base extends EditViewBase implements EditView4Interface {

    /**
     * 数据关系分页部件实例
     *
     * @public
     * @type {IPSDRTab}
     * @memberof EditView4Base
     */
    public drtabInstance!: IPSDRTab;
    
    /**
     * 关系项
     *
     * @type {*}
     * @memberof EditView4Base
     */
    public drItem: any;

    /**
     * 初始化编辑视图实例
     * 
     * @memberof EditView4Base
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.drtabInstance = ModelTool.findPSControlByType("DRTAB", this.viewInstance.getPSControls()) as IPSDEDRTab;
    }

    /**
     * 引擎初始化
     *
     * @public
     * @memberof EditView4Base
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            form: (this.$refs[this.editFormInstance.name] as any).ctrl,
            drtab: (this.$refs[this.drtabInstance.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

}
