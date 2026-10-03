package net.ibizsys.psrt.srv.common.demodel.codelist.uiaction;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.psrt.srv.common.entity.CodeList;


public abstract class CodeListRefreshUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<CodeList>{
  
   private static final Log log = LogFactory.getLog(CodeListRefreshUIActionModelBase.class);

   public CodeListRefreshUIActionModelBase(){
        super();

        this.setId("21C9ECE1-5A81-4448-A892-B674240C1FCB");
        this.setName("Refresh");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("Refresh");
        this.setReloadData(true);
        this.setSuccessMsg("刷新代码表成功！");
   }
 
}