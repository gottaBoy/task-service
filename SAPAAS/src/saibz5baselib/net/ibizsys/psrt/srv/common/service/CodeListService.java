package net.ibizsys.psrt.srv.common.service;


import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.psrt.srv.common.entity.CodeList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


//@Service
//@Transactional
@Component

/**
 * 代码表 服务操作对象
 * 
 */
public  class CodeListService extends CodeListServiceBase{

  private static final Log log = LogFactory.getLog(CodeListService.class);
   public CodeListService (){
        super();
        
   }

   @Override
	protected void onRefreshModel(CodeList codeList) throws Exception
	{
		ICodeListModel iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList(codeList.getCodeListId(), this.getSessionFactory());
//		if(this.getWebContext()!=null)
//		{
//			iCodeListModel = (ICodeListModel) this.getWebContext().getUserCodeList(iCodeListModel);
//		}
		iCodeListModel.refresh();
	}
}