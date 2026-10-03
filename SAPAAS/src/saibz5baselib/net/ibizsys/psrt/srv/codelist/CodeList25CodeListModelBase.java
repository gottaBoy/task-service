/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="439db79fec36426cb354d983b6b2b117",name="字段排序方向",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="ASC",text="升序",realtext="升序")
    ,@CodeItem(value="DESC",text="降序",realtext="降序")
})


/**
 * 静态代码表[字段排序方向]模型基类
 */
public abstract class CodeList25CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  升序，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ASC = "ASC";
    /**
     *  降序，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DESC = "DESC";

    public CodeList25CodeListModelBase() {
        super();
        this.initAnnotation(CodeList25CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList25CodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList25CodeListModel");
    }

}