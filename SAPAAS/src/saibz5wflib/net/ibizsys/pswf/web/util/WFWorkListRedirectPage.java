package net.ibizsys.pswf.web.util;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList;
import net.ibizsys.psrt.srv.wf.service.WFWorkListService;

/**
 * 流程工作清单重定向页面对象
 * @author Administrator
 *
 */
public class WFWorkListRedirectPage extends WFRedirectPage {

	ThreadLocal<WFWorkList> glboalWFWorkList = new ThreadLocal<WFWorkList>();
	
	@Override
	protected void onInit() throws Exception {
		glboalWFWorkList.set(null);
		
		String strKeyValue = this.getWebContext().getPostOrParamValue("srfkey");
		if (StringHelper.isNullOrEmpty(strKeyValue)) {
			strKeyValue = this.getWebContext().getPostOrParamValue("srfkeys");
		}
		if (StringHelper.isNullOrEmpty(strKeyValue)) {
			throw new Exception(StringHelper.format("没有指定视图数据主键"));
		}
		
		WFWorkListService wfWorkListService = (WFWorkListService)ServiceGlobal.getService(WFWorkListService.class,this.getSessionFactory());
		WFWorkList wfWorkList = new WFWorkList();
		wfWorkList.set(WFWorkList.FIELD_WFWORKLISTID, strKeyValue);
		wfWorkListService.get(wfWorkList);
		
		glboalWFWorkList.set(wfWorkList);
		
		super.onInit();
	}

	@Override
	protected String getDEId() throws Exception {
		return glboalWFWorkList.get().getUserData4();
	}

	@Override
	protected String getKeyValue() throws Exception {
		return glboalWFWorkList.get().getUserData();
	}
	
	
	
}
