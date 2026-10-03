/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="bd51ee96a28f95295901e9ba2c42091f",name="实体数据处理_数据对象操作",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CREATENEW",text="新建数据对象",realtext="新建数据对象" )
    ,@CodeItem(value="CREATEFROM",text="拷贝新建数据对象",realtext="拷贝新建数据对象" )
    ,@CodeItem(value="COPY",text="拷贝数据对象",realtext="拷贝数据对象" )
    ,@CodeItem(value="COPYRESET",text="拷贝数据对象(重置)",realtext="拷贝数据对象(重置)" )
})


/**
 * 静态代码表[实体数据处理_数据对象操作]模型基类
 */
public abstract class CodeList107CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  新建数据对象
     */
    public final static String CREATENEW = "CREATENEW";
    /**
     *  拷贝新建数据对象
     */
    public final static String CREATEFROM = "CREATEFROM";
    /**
     *  拷贝数据对象
     */
    public final static String COPY = "COPY";
    /**
     *  拷贝数据对象(重置)
     */
    public final static String COPYRESET = "COPYRESET";


    public CodeList107CodeListModelBase() {
        super();
        this.initAnnotation(CodeList107CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList107CodeListModel", this);
    }

}