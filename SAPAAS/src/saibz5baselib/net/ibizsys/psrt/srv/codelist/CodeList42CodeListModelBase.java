package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="1e8acf2ededdd5ba8c440d940b493ef1",name="消息模板内容类型",type="STATIC",userscope=false)

@CodeItems({
@CodeItem(value="TEXT",text="纯文本",realtext="纯文本" )
,@CodeItem(value="HTML",text="HTML网页",realtext="HTML网页" )
})


/**
 * 消息模板内容类型代码表模型基类
 */
public abstract class CodeList42CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

   /**
    *  纯文本
    */
   public final static String TEXT = "TEXT";
   /**
    *  HTML网页
    */
   public final static String HTML = "HTML";


   public CodeList42CodeListModelBase(){
        super();
         this.initAnnotation(CodeList42CodeListModelBase.class); 
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList42CodeListModel", this);
      
   }


 
}