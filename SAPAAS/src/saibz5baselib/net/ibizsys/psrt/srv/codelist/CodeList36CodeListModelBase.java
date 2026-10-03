/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="55109493d150336bdcd4710454f76d72",name="补丁归属",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="框架基本",realtext="框架基本" )
    ,@CodeItem(value="2",text="框架高级",realtext="框架高级" )
    ,@CodeItem(value="4",text="工作流",realtext="工作流" )
    ,@CodeItem(value="8",text="EAI",realtext="EAI" )
    ,@CodeItem(value="16",text="UAC",realtext="UAC" )
    ,@CodeItem(value="32",text="全文检索",realtext="全文检索" )
    ,@CodeItem(value="64",text="数据分析",realtext="数据分析" )
    ,@CodeItem(value="128",text="基础网盘",realtext="基础网盘" )
    ,@CodeItem(value="256",text="基础组织",realtext="基础组织" )
})


/**
 * 静态代码表[补丁归属]模型基类
 */
public abstract class CodeList36CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  框架基本
     */
    public final static String ITEM_1 = "1";
    /**
     *  框架高级
     */
    public final static String ITEM_2 = "2";
    /**
     *  工作流
     */
    public final static String ITEM_4 = "4";
    /**
     *  EAI
     */
    public final static String ITEM_8 = "8";
    /**
     *  UAC
     */
    public final static String ITEM_16 = "16";
    /**
     *  全文检索
     */
    public final static String ITEM_32 = "32";
    /**
     *  数据分析
     */
    public final static String ITEM_64 = "64";
    /**
     *  基础网盘
     */
    public final static String ITEM_128 = "128";
    /**
     *  基础组织
     */
    public final static String ITEM_256 = "256";


    public CodeList36CodeListModelBase() {
        super();
        this.initAnnotation(CodeList36CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList36CodeListModel", this);
    }

}