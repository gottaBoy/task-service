/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="c0a4a9b8e56cd645bb9a2dd3f5d10e54",name="实体关系明细类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="PAGE",text="内建页面",realtext="内建页面" )
    ,@CodeItem(value="PAGEPATH",text="页面路径",realtext="页面路径" )
    ,@CodeItem(value="DER1N",text="1:N关系",realtext="1:N关系" )
    ,@CodeItem(value="DER11",text="1:1关系",realtext="1:1关系" )
    ,@CodeItem(value="WFSTEP",text="工作流处理步骤",realtext="工作流处理步骤" )
    ,@CodeItem(value="WFSTEPACTOR",text="工作流当前处理用户",realtext="工作流当前处理用户" )
    ,@CodeItem(value="FILELIST",text="附件列表",realtext="附件列表" )
    ,@CodeItem(value="DATAAUDIT",text="行为审计",realtext="行为审计" )
    ,@CodeItem(value="DERTYPE",text="实体关系分组",realtext="实体关系分组" )
})


/**
 * 静态代码表[实体关系明细类型]模型基类
 */
public abstract class CodeList14CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  内建页面
     */
    public final static String PAGE = "PAGE";
    /**
     *  页面路径
     */
    public final static String PAGEPATH = "PAGEPATH";
    /**
     *  1:N关系
     */
    public final static String DER1N = "DER1N";
    /**
     *  1:1关系
     */
    public final static String DER11 = "DER11";
    /**
     *  工作流处理步骤
     */
    public final static String WFSTEP = "WFSTEP";
    /**
     *  工作流当前处理用户
     */
    public final static String WFSTEPACTOR = "WFSTEPACTOR";
    /**
     *  附件列表
     */
    public final static String FILELIST = "FILELIST";
    /**
     *  行为审计
     */
    public final static String DATAAUDIT = "DATAAUDIT";
    /**
     *  实体关系分组
     */
    public final static String DERTYPE = "DERTYPE";


    public CodeList14CodeListModelBase() {
        super();
        this.initAnnotation(CodeList14CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList14CodeListModel", this);
    }

}