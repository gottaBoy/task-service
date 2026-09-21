import { IParams } from "../../../interface";
import { Util } from "../../../utils";

/**
 * 逻辑参数基类
 *
 * @export
 * @class AppDeLogicParamBase
 */
export class AppDeLogicParamBase {

    /**
     * 代码名称
     *
     * @type {*}
     * @memberof AppDeLogicParamBase
     */
    protected strCodeName: any;

    /**
     * 逻辑类型
     *
     * @type {*}
     * @memberof AppDeLogicParamBase
     */
    protected logicParamType: any;

    /**
     * 操作会话
     *
     * @type {*}
     * @memberof AppDeLogicParamBase
     */
    protected actionSession: any;

    /**
     * 逻辑参数模型
     *
     * @type {*}
     * @memberof AppDeLogicParamBase
     */
    protected logicParamModel: any;

    /**
     * 实际值
     *
     * @type {*}
     * @memberof AppDeLogicParamBase
     */
    protected realValue: any;

    /**
     * Creates an instance of AppDeLogicParamBase.
     * @param {*} opts
     * @memberof AppDeLogicParamBase
     */
    public constructor(opts: any) {
        const { actionSession, model, value } = opts;
        this.logicParamModel = model;
        this.actionSession = actionSession;
        this.realValue = value ? value : {};
        this.strCodeName = model.codeName;
    }

    /**
     * 获取实际参数值
     *
     * @memberof AppDeLogicParamBase
     */
    public getReal() {
        return this.realValue;
    }

    /**
     * 设置实际参数值
     *
     * @param {*} opts
     * @memberof AppDeLogicParamBase
     */
    public setReal(opts: any) {
        this.realValue = opts;
    }

    /**
     * 设置指定属性值
     *
     * @param {string} strName
     * @param {*} value
     * @memberof AppDeLogicParamBase
     */
    public set(strName: string, value: any) {
        this.realValue[strName] = value;
    }

    /**
     * 获取指定属性值
     *
     * @param {string} strName
     * @memberof AppDeLogicParamBase
     */
    public get(strName: string) {
        return this.realValue[strName];
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeLogicParamBase
     */
    public bind(opts: any) {
        if (Object.prototype.toString.call(opts) !== '[object Object]') {
            throw new Error(`逻辑参数${this.strCodeName}无法绑定非对象类型参数`);
        }
        this.setReal(opts);
    }

    /**
     * 重新建立参数对象
     *
     * @memberof AppDeLogicParamBase
     */
    public renew() {
        this.setReal({});
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof AppDeLogicParamBase
     */
    public reset(strName: string) {
        this.realValue[strName] = null;
    }

    /**
     * 重置全部
     *
     * @memberof AppDeLogicParamBase
     */
    public resetAll() {
        this.setReal({});
    }

    /**
     * 拷贝当前变量到指定变量
     *
     * @param {*} dstParam
     * @memberof AppDeLogicParamBase
     */
    public copyTo(dstParam: any) {
        if (Object.is(typeof (this.realValue), 'object')) {
            dstParam.realValue = Util.deepCopy(this.realValue);
        } else {
            dstParam.realValue = this.realValue;
        }
    }

    /**
     * 附加参数对象
     *
     * @param {number} nPos
     * @param {*} paramObject
     * @param {number} nSrcPos
     * @param {number} nSrcLength
     * @memberof AppDeLogicParamBase
     */
    public append(nPos: number, paramObject: any, nSrcPos: number, nSrcLength: number) {
        if (Object.prototype.toString.call(paramObject) !== '[object Array]') {
            throw new Error(`逻辑参数${this.strCodeName}源数据不是数据对象列表类型`);
        }
        if (this.realValue && !Array.isArray(this.realValue)) {
            throw new Error(`逻辑参数${this.strCodeName}不是数据对象列表类型`);
        }
        // 补足参数
        if (nPos === -1) {
            nPos = 0;
        }
        if (nSrcPos === -1) {
            nSrcPos = 0;
        }
        if (nSrcLength === -1) {
            nSrcLength = paramObject.length;
        }
        const list: Array<any> = this.realValue;
        if (nPos > list.length) {
            throw new Error(`逻辑参数${this.strCodeName}插入位置溢出`);
        }
        const srcList = paramObject.slice(nSrcPos, nSrcLength);
        list.splice(nPos, 0, ...srcList);
    }

    /**
     * 排序参数对象
     *
     * @param {string} strField
     * @param {string} strSortDir
     * @memberof AppDeLogicParamBase
     */
    public sort(strField: string, strSortDir: string) {
        if (this.realValue && !Array.isArray(this.realValue)) {
            throw new Error(`逻辑参数${this.strCodeName}不是数据对象列表类型`);
        }
        // 是否降序
        const bSortDesc: boolean = Object.is(strSortDir?.toLowerCase(), 'desc') ? true : false;
        // 对数组排序(升序)
        this.realValue.sort((a: any, b: any) => {
            return a[strField] - b[strField];
        })
        if (bSortDesc) {
            this.realValue.reverse();
        }
    }
}