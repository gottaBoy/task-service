import { IParams, Util } from "ibiz-core";

/**
 * 界面逻辑参数基类
 *
 * @export
 * @class AppDeUILogicParamBase
 */
export class AppDeUILogicParamBase {

    /**
     * 代码名称
     *
     * @type {*}
     * @memberof AppDeUILogicParamBase
     */
    protected strCodeName: any;

    /**
     * 操作会话
     *
     * @type {*}
     * @memberof AppDeUILogicParamBase
     */
    protected actionSession: any;

    /**
     * 逻辑参数模型
     *
     * @type {*}
     * @memberof AppDeUILogicParamBase
     */
    protected logicParamModel: any;

    /**
     * 逻辑类型
     *
     * @type {*}
     * @memberof AppDeUILogicParamBase
     */
    protected logicParamType: any;

    /**
     * 实际值
     *
     * @type {*}
     * @memberof AppDeUILogicParamBase
     */
    protected realValue: any;

    /**
     * Creates an instance of AppDeUILogicParamBase.
     * @param {*} opts
     * @memberof AppDeUILogicParamBase
     */
    public constructor(opts: any) {
        const { actionSession, model, params } = opts;
        this.actionSession = actionSession;
        this.logicParamModel = model;
        this.strCodeName = model.codeName;
        this.init(params);
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof AppDeUILogicParamBase
     */
    protected init(params: IParams) {
        this.setReal(this.getDefaultValue(params, {}));
    }

    /**
     * 获取默认值
     *
     * @protected
     * @memberof AppDeUILogicParamBase
     */
    protected getDefaultValue(params: IParams, defaultValue: any) {
        const { args } = params;
        if (this.logicParamModel.default) {
            return args;
        } else {
            return defaultValue;
        }
    }

    /**
     * 获取实际参数值
     *
     * @memberof AppDeUILogicParamBase
     */
    public getReal() {
        return this.realValue;
    }

    /**
     * 设置实际参数值
     *
     * @param {*} opts
     * @memberof AppDeUILogicParamBase
     */
    public setReal(opts: any) {
        this.realValue = opts;
    }

    /**
     * 设置指定属性值
     *
     * @param {string} strName
     * @param {*} value
     * @memberof AppDeUILogicParamBase
     */
    public set(strName: string, value: any) {
        if (Object.prototype.toString.call(this.realValue) !== '[object Object]') {
            throw new Error(`逻辑参数${this.strCodeName}无法执行绑定非对象类型参数`);
        }
        this.realValue[strName] = value;
    }

    /**
     * 获取指定属性值
     *
     * @param {string} strName
     * @memberof AppDeUILogicParamBase
     */
    public get(strName: string) {
        if (Object.prototype.toString.call(this.realValue) !== '[object Object]') {
            throw new Error(`逻辑参数${this.strCodeName}非对象类型参数无法执行获取指定属性值`);
        }
        return this.realValue[strName];
    }

    /**
     * 重置指定属性
     *
     * @param {string} strName
     * @memberof AppDeUILogicParamBase
     */
    public reset(strName: string) {
        if (Object.prototype.toString.call(this.realValue) !== '[object Object]') {
            throw new Error(`逻辑参数${this.strCodeName}非对象类型参数无法执行重置指定属性`);
        }
        this.realValue[strName] = null;
    }

    /**
     * 重置全部
     *
     * @memberof AppDeUILogicParamBase
     */
    public resetAll() {
        if (Object.prototype.toString.call(this.realValue) !== '[object Object]') {
            throw new Error(`逻辑参数${this.strCodeName}非对象类型参数无法执行重置全部`);
        }
        this.setReal({});
    }

    /**
     * 拷贝当前变量到指定变量
     *
     * @param {*} dstParam
     * @memberof AppDeUILogicParamBase
     */
    public copyTo(dstParam: any) {
        if (Object.is(typeof (this.realValue), 'object')) {
            dstParam.setReal(Util.deepCopy(this.realValue));
        } else {
            dstParam.setReal(this.realValue);
        }
    }

    /**
     * 绑定指定参数对象
     *
     * @param {*} opts
     * @memberof AppDeUILogicParamBase
     */
    public bind(opts: any) {
        this.setReal(opts);
    }

    /**
     * 重新建立参数对象
     *
     * @memberof AppDeUILogicParamBase
     */
    public renew() {
        this.setReal({});
    }

    /**
     * 附加参数对象
     *
     * @param {number} nPos
     * @param {*} paramObject
     * @param {number} nSrcPos
     * @param {number} nSrcLength
     * @memberof AppDeUILogicParamBase
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
     * @memberof AppDeUILogicParamBase
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