export enum LogicParamType {

    /**
     * 简单数据变量
     */
    simpleParam = 'simpleParam',

    /**
     * 数据对象变量
     */
    entityParam = 'entityParam',

    /**
     * 分页查询结果变量
     */
    entityPageParam = 'entityPageParam',

    /**
     * 数据对象列表变量
     */
    entityListParam = 'entityListParam',

    /**
     * 上一次调用返回变量
     */
    lastReturnParam = 'lastReturnParam',

    /**
     * 过滤器对象变量
     */
    filterParam = 'filterParam',

    /**
     * 简单数据列表变量
     */
    simpleListParam = 'simpleListParam',

    /**
     * 应用上下文变量
     */
   appContextParam = 'appContextParam',

   /**
    * 应用全局变量
    */
   appGlobalParam = 'appGlobalParam'

}