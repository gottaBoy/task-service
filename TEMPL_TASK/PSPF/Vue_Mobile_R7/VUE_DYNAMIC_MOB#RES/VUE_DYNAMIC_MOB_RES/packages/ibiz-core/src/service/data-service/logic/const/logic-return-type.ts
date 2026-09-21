export enum LogicReturnType {
    /**
     *  无值（NONE）
     */
    NONEVALUE = "NONEVALUE",
    /**
     *  空值（NULL）
     */
    NULLVALUE = "NULLVALUE",
    /**
     *  直接值
     */
    SRCVALUE = "SRCVALUE",
    /**
     *  逻辑参数对象
     */
    LOGICPARAM = "LOGICPARAM",
    /**
     *  逻辑参数属性
     */
    LOGICPARAMFIELD = "LOGICPARAMFIELD",
    /**
     *  跳出循环（BREAK）
     */
    BREAK = "BREAK",
}