/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="54d9e0999e903b29cf629dcc1ec68f88",name="性能分析指标",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="PODBACTION",text="数据库操作性能",realtext="数据库操作性能" )
    ,@CodeItem(value="PODBQUERY",text="数据库查询性能",realtext="数据库查询性能" )
    ,@CodeItem(value="PODEDC",text="实体处理逻辑性能",realtext="实体处理逻辑性能" )
    ,@CodeItem(value="POWORKFLOW",text="工作流性能",realtext="工作流性能" )
    ,@CodeItem(value="POPAGE",text="页面性能",realtext="页面性能" )
    ,@CodeItem(value="POPAGEBACKEND",text="页面性能(后台)",realtext="页面性能(后台)" )
    ,@CodeItem(value="POPAGESESSION",text="并发性能",realtext="并发性能" )
})


/**
 * 静态代码表[性能分析指标]模型基类
 */
public abstract class CodeList117CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  数据库操作性能
     */
    public final static String PODBACTION = "PODBACTION";
    /**
     *  数据库查询性能
     */
    public final static String PODBQUERY = "PODBQUERY";
    /**
     *  实体处理逻辑性能
     */
    public final static String PODEDC = "PODEDC";
    /**
     *  工作流性能
     */
    public final static String POWORKFLOW = "POWORKFLOW";
    /**
     *  页面性能
     */
    public final static String POPAGE = "POPAGE";
    /**
     *  页面性能(后台)
     */
    public final static String POPAGEBACKEND = "POPAGEBACKEND";
    /**
     *  并发性能
     */
    public final static String POPAGESESSION = "POPAGESESSION";


    public CodeList117CodeListModelBase() {
        super();
        this.initAnnotation(CodeList117CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList117CodeListModel", this);
    }

}