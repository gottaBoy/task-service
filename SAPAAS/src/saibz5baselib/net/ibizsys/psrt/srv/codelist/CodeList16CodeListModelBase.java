package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="04d9f3b1fba109da46d2381b8c8c86a0",name="统一资源类型",type="STATIC",userscope=false)

@CodeItems({
@CodeItem(value="PAGE",text="内置页面",realtext="内置页面" )
,@CodeItem(value="REPORT",text="报表",realtext="报表" )
,@CodeItem(value="CUSTOM",text="自定义",realtext="自定义" )
})


/**
 * 统一资源类型代码表模型基类
 */
public abstract class CodeList16CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

   /**
    *  内置页面
    */
   public final static String PAGE = "PAGE";
   /**
    *  报表
    */
   public final static String REPORT = "REPORT";
   /**
    *  自定义
    */
   public final static String CUSTOM = "CUSTOM";


   public CodeList16CodeListModelBase(){
        super();
         this.initAnnotation(CodeList16CodeListModelBase.class); 
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList16CodeListModel", this);
      
   }


 
}