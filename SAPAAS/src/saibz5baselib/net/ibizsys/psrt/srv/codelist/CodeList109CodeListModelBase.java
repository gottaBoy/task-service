/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="72366c28902f0efeab7c6d7999b8a498",name="实体数据处理_变量名称",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="%DEFAULT%",text="默认变量",realtext="默认变量" )
    ,@CodeItem(value="%ENV%",text="环境变量",realtext="环境变量" )
    ,@CodeItem(value="PARAM1",text="变量1",realtext="变量1" )
    ,@CodeItem(value="PARAM2",text="变量2",realtext="变量2" )
    ,@CodeItem(value="PARAM3",text="变量3",realtext="变量3" )
    ,@CodeItem(value="PARAM4",text="变量4",realtext="变量4" )
    ,@CodeItem(value="PARAM5",text="变量5",realtext="变量5" )
    ,@CodeItem(value="%LAST%",text="历史值",realtext="历史值" )
    ,@CodeItem(value="%GLOBAL1%",text="全局变量1",realtext="全局变量1" )
    ,@CodeItem(value="%GLOBAL2%",text="全局变量2",realtext="全局变量2" )
    ,@CodeItem(value="%GLOBAL3%",text="全局变量3",realtext="全局变量3" )
    ,@CodeItem(value="%GLOBAL4%",text="全局变量4",realtext="全局变量4" )
    ,@CodeItem(value="%GLOBAL5%",text="全局变量5",realtext="全局变量5" )
    ,@CodeItem(value="%BRINST%",text="全局规则引擎实例变量",realtext="全局规则引擎实例变量" )
})


/**
 * 静态代码表[实体数据处理_变量名称]模型基类
 */
public abstract class CodeList109CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  默认变量
     */
    public final static String _DEFAULT_ = "%DEFAULT%";
    /**
     *  环境变量
     */
    public final static String _ENV_ = "%ENV%";
    /**
     *  变量1
     */
    public final static String PARAM1 = "PARAM1";
    /**
     *  变量2
     */
    public final static String PARAM2 = "PARAM2";
    /**
     *  变量3
     */
    public final static String PARAM3 = "PARAM3";
    /**
     *  变量4
     */
    public final static String PARAM4 = "PARAM4";
    /**
     *  变量5
     */
    public final static String PARAM5 = "PARAM5";
    /**
     *  历史值
     */
    public final static String _LAST_ = "%LAST%";
    /**
     *  全局变量1
     */
    public final static String _GLOBAL1_ = "%GLOBAL1%";
    /**
     *  全局变量2
     */
    public final static String _GLOBAL2_ = "%GLOBAL2%";
    /**
     *  全局变量3
     */
    public final static String _GLOBAL3_ = "%GLOBAL3%";
    /**
     *  全局变量4
     */
    public final static String _GLOBAL4_ = "%GLOBAL4%";
    /**
     *  全局变量5
     */
    public final static String _GLOBAL5_ = "%GLOBAL5%";
    /**
     *  全局规则引擎实例变量
     */
    public final static String _BRINST_ = "%BRINST%";


    public CodeList109CodeListModelBase() {
        super();
        this.initAnnotation(CodeList109CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList109CodeListModel", this);
    }

}