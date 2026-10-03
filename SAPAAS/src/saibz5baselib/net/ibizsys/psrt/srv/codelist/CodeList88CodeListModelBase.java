package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="0fc12871fdb34f9175e0b596e64d3d65",name="实体属性访问控制",type="STATIC",userscope=false)

@CodeItems({
@CodeItem(value="NONE",text="无",realtext="无" )
,@CodeItem(value="READ",text="读取",realtext="读取" )
,@CodeItem(value="UPDATE",text="更新",realtext="更新" )
})


/**
 * 实体属性访问控制代码表模型基类
 */
public abstract class CodeList88CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

   /**
    *  无
    */
   public final static String NONE = "NONE";
   /**
    *  读取
    */
   public final static String READ = "READ";
   /**
    *  更新
    */
   public final static String UPDATE = "UPDATE";


   public CodeList88CodeListModelBase(){
        super();
         this.initAnnotation(CodeList88CodeListModelBase.class); 
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList88CodeListModel", this);
      
   }


 
}