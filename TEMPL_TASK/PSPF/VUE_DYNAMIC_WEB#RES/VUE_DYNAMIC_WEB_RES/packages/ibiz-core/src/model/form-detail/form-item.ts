import { IPSAppCodeList, IPSDEFormDetail } from '@ibiz/dynamic-model-api';
import { FormDetailModel } from './form-detail';

/**
 * 表单项模型
 *
 * @export
 * @class FormItemModel
 * @extends {FormDetailModel}
 */
export class FormItemModel extends FormDetailModel {

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof FormItemModel
     */
    public disabled: boolean = false;

    /**
     * 错误信息
     *
     * @type {string}
     * @memberof FormItemModel
     */
    public error: string = '';

    /**
     * 表单项启用条件
     * 
     * 0 不启用
     * 1 新建
     * 2 更新
     * 3 全部启用
     *
     * @type {(number | 0 | 1 | 2 | 3)}
     * @memberof FormItemModel
     */
    public enableCond: number | 0 | 1 | 2 | 3 = 3;

    /**
     * 是否必填
     *
     * @type {boolean}
     * @memberof FormItemModel
     */
    public $required: boolean = false;

    /**
     * @description 忽略输入值
     * @type {(number | null)}
     * @memberof FormItemModel
     */
    public ignoreInput?: number | null;

    /**
     * 是否转化为代码项文本
     *
     * @type {boolean}
     * @memberof FormItemModel
     */
    public convertToCodeItemText: boolean = false;

    /**
     * 代码表对象
     *
     * @type {(IPSAppCodeList | null)}
     * @memberof FormItemModel
     */
    public codelist: IPSAppCodeList | null = null;

    /**
     * @description 动态值项名称
     * @type {string}
     * @memberof FormItemModel
     */
    public captionItemName: string = '';

    /**
     * 栅格占位
     *
     * @type {number}
     * @memberof FormItemModel
     */
    public col: number = 24;

    /**
     * 栅格偏移
     *
     * @type {number}
     * @memberof FormItemModel
     */
    public offset: number = 0;

    /**
     * Creates an instance of FormItemModel.
     * FormItemModel 实例
     * 
     * @param {*} [opts={}]
     * @memberof FormItemModel
     */
    constructor(opts: any = {}) {
        super(opts);
        this.disabled = opts.disabled ? true : false;
        this.enableCond = opts.enableCond;
        this.$required = opts.required;
        this.ignoreInput = opts.ignoreInput;
        this.captionItemName = opts.captionItemName;
        this.convertToCodeItemText = opts.convertToCodeItemText;
        this.codelist = opts.codelist;
        this.col = opts.col;
        this.offset = opts.offset;
    }


    /**
     * 获取必填
     *
     * @memberof FormItemModel
     */
    get required() {
        const calcRequired = (parentModel: IPSDEFormDetail) =>{
            if (
                parentModel.detailType === "GROUPPANEL" || 
                parentModel.detailType === "FORMPAGE" ||
                parentModel.detailType === "MDCTRL"
            ) {
                const parent = this.form?.detailsModel?.[parentModel.name];
                if (parent) {
                    if (parent.visible) {
                        calcRequired(parentModel.getParentPSModelObject() as IPSDEFormDetail);
                    } else {
                        this.$required = false;
                    }
                }
            }
        }
        if (this.parentModel) {
            calcRequired(this.parentModel);
        }
        return this.$required;
    }

    /**
     * 设置必填
     *
     * @memberof FormItemModel
     */
    set required(state: boolean) {
        this.$required = state;
    }

    /**
     * 设置是否启用
     *
     * @param {boolean} state
     * @memberof FormItemModel
     */
    public setDisabled(state: boolean): void {
        this.disabled = state;
    }

    /**
     * 设置信息内容
     *
     * @param {string} error
     * @memberof FormItemModel
     */
    public setError(error: string): void {
        this.error = error;
    }

    /**
     * 设置是否启用
     *
     * @param {string} srfuf
     * @memberof FormItemModel
     */
    public setEnableCond(srfuf: string): void {
        // 是否有权限
        const isReadOk: boolean = true;
        const _srfuf: number = parseInt(srfuf, 10);
        let state: boolean = true;

        if (isReadOk) {
            if (_srfuf === 1) {
                if ((this.enableCond & 2) === 2) {
                    state = false;
                }
            } else {
                if ((this.enableCond & 1) === 1) {
                    state = false;
                }
            }
        }
        this.setDisabled(state);
    }

} 