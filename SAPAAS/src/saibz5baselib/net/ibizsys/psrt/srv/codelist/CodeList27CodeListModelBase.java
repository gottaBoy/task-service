package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="d54260d064a4fea75dd5e1ee7b812790",name="审计行为",type="STATIC",userscope=false)

@CodeItems({
@CodeItem(value="CREATE",text="建立",realtext="建立" )
,@CodeItem(value="UPDATE",text="更新",realtext="更新" )
,@CodeItem(value="DELETE",text="删除",realtext="删除" )
})


/**
 * 审计行为代码表模型基类
 */
public abstract class CodeList27CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

   /**
    *  建立
    */
   public final static String CREATE = "CREATE";
   /**
    *  更新
    */
   public final static String UPDATE = "UPDATE";
   /**
    *  删除
    */
   public final static String DELETE = "DELETE";


   public CodeList27CodeListModelBase(){
        super();
         this.initAnnotation(CodeList27CodeListModelBase.class); 
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList27CodeListModel", this);
      
   }


 
}