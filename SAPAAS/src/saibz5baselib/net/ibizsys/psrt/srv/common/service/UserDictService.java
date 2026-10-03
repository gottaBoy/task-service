package net.ibizsys.psrt.srv.common.service;


import java.util.ArrayList;

import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.CodeList;
import net.ibizsys.psrt.srv.common.entity.UserDict;
import net.ibizsys.psrt.srv.common.entity.UserDictCat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;



//@Service
//@Transactional
@Component

/**
 * 用户词典 服务操作对象
 * 
 */
public  class UserDictService extends UserDictServiceBase{

  private static final Log log = LogFactory.getLog(UserDictService.class);
   public UserDictService (){
        super();
        
   }
   
   
   @Override
	protected void onReloadCurUser(UserDict userDict) throws Exception
	{
		IWebContext iWebContext = this.getWebContext();
		if(iWebContext == null)
		{
			throw new Exception(StringHelper.format("当前用户身份无效"));
		}
		
		//查出分类
		UserDictCatService userDictCatService = (UserDictCatService)ServiceGlobal.getService(UserDictCatService.class,this.getSessionFactory());
		CodeListService codeListService = (CodeListService)ServiceGlobal.getService(CodeListService.class,this.getSessionFactory());
		SelectCond selectCond = new SelectCond();
		ArrayList<UserDictCat> userDictCatList = userDictCatService.select(selectCond);
		//刷新代码表
		for(UserDictCat userDictCat:userDictCatList)
		{
			try
			{
				String strUserDictCatCodeListId = UserDictCatService.calcUserDictCatCodeListId(userDictCat.getUserDictCatId());
				CodeList codeList  = new CodeList();
				codeList.setCodeListId(strUserDictCatCodeListId);
				codeListService.refreshModel(codeList);
			}
			catch(Exception ex)
			{
				log.error(StringHelper.format("刷新用户词条[%1$s]代码表发生异常，%2$s",userDictCat.getUserDictCatName(),ex.getMessage()),ex);
			}
		}
		
		
	}

}