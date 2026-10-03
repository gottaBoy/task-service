package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="0a17383cf8095d9796c32e74a8696e01",name="服务启动模式",type="STATIC",userscope=false)

@CodeItems({
@CodeItem(value="AUTO",text="自动",realtext="自动" )
,@CodeItem(value="MANUAL",text="手动",realtext="手动" )
})


/**
 * 服务启动模式代码表模型基类
 */
public abstract class CodeList37CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

   /**
    *  自动
    */
   public final static String AUTO = "AUTO";
   /**
    *  手动
    */
   public final static String MANUAL = "MANUAL";


   public CodeList37CodeListModelBase(){
        super();
         this.initAnnotation(CodeList37CodeListModelBase.class); 
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList37CodeListModel", this);
      
   }


 
}