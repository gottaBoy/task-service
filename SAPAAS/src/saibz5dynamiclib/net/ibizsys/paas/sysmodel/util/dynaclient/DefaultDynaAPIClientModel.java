package net.ibizsys.paas.sysmodel.util.dynaclient;

import net.ibizsys.paas.api.RestServiceAPIActionModel;

/**
 * 子系统服务API客户端[动态配置接口]基类
 *
 * !! 不要对此代码进行修改
 */
public class DefaultDynaAPIClientModel extends net.ibizsys.paas.api.RestServiceAPIClientModelBase {
	public DefaultDynaAPIClientModel() throws Exception{
		super();
		this.setId("6EE6F748-B8F7-4589-9003-B5B835FEF593");
		this.setName("动态配置接口");
		this.setUniqueTag("DynaSystem");
		
		prepareAPIActions();
	}
    
	protected void prepareAPIActions()throws Exception{
		prepareAPIActions_INT_PSDYNAWFVER();
		prepareAPIActions_INT_PSDYNACODELISTINST();
		prepareAPIActions_INT_PSDYNAWFVERINST();
		prepareAPIActions_INT_PSDYNAAPPVIEW();
		prepareAPIActions_INT_PSDYNAAPPVIEWINST();
	}
	protected void prepareAPIActions_INT_PSDYNAWFVER()throws Exception{
		RestServiceAPIActionModel action12 = new RestServiceAPIActionModel();
		action12.setId("INT_PSDYNAWFVER__DEACTION__GETDRAFT");
		action12.setName("GetDraft");
		action12.setUniqueTag("INT_PSDYNAWFVER__DEACTION__GETDRAFT");
		action12.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action12.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_GET);
		action12.setActionPath("/psdynawfver/getdraft");
		action12.setKeyField("PSDYNAWFVERID");
		this.registerServiceAPIAction(action12);
		RestServiceAPIActionModel action13 = new RestServiceAPIActionModel();
		action13.setId("INT_PSDYNAWFVER__DEACTION__REMOVE");
		action13.setName("Remove");
		action13.setUniqueTag("INT_PSDYNAWFVER__DEACTION__REMOVE");
		action13.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action13.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_DELETE);
		action13.setActionPath("/psdynawfver");
		action13.setKeyField("PSDYNAWFVERID");
		this.registerServiceAPIAction(action13);
		RestServiceAPIActionModel action14 = new RestServiceAPIActionModel();
		action14.setId("INT_PSDYNAWFVER__DEACTION__CHECKKEY");
		action14.setName("CheckKey");
		action14.setUniqueTag("INT_PSDYNAWFVER__DEACTION__CHECKKEY");
		action14.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action14.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action14.setActionPath("/psdynawfver/checkkey");
		action14.setKeyField("PSDYNAWFVERID");
		this.registerServiceAPIAction(action14);
		RestServiceAPIActionModel action15 = new RestServiceAPIActionModel();
		action15.setId("INT_PSDYNAWFVER__DEACTION__GET");
		action15.setName("Get");
		action15.setUniqueTag("INT_PSDYNAWFVER__DEACTION__GET");
		action15.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action15.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_GET);
		action15.setActionPath("/psdynawfver");
		action15.setKeyField("PSDYNAWFVERID");
		this.registerServiceAPIAction(action15);
		RestServiceAPIActionModel action16 = new RestServiceAPIActionModel();
		action16.setId("INT_PSDYNAWFVER__DEACTION__UPDATE");
		action16.setName("Update");
		action16.setUniqueTag("INT_PSDYNAWFVER__DEACTION__UPDATE");
		action16.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action16.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_PUT);
		action16.setActionPath("/psdynawfver");
		action16.setKeyField("PSDYNAWFVERID");
		this.registerServiceAPIAction(action16);
		RestServiceAPIActionModel action17 = new RestServiceAPIActionModel();
		action17.setId("INT_PSDYNAWFVER__DEACTION__CREATE");
		action17.setName("Create");
		action17.setUniqueTag("INT_PSDYNAWFVER__DEACTION__CREATE");
		action17.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action17.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action17.setActionPath("/psdynawfver");
		action17.setKeyField("PSDYNAWFVERID");
		this.registerServiceAPIAction(action17);
		RestServiceAPIActionModel action18 = new RestServiceAPIActionModel();
		action18.setId("INT_PSDYNAWFVER__DEACTION__SAVE");
		action18.setName("Save");
		action18.setUniqueTag("INT_PSDYNAWFVER__DEACTION__SAVE");
		action18.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action18.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action18.setActionPath("/psdynawfver/save");
		action18.setKeyField("PSDYNAWFVERID");
		this.registerServiceAPIAction(action18);
	}
	protected void prepareAPIActions_INT_PSDYNACODELISTINST()throws Exception{
		RestServiceAPIActionModel action19 = new RestServiceAPIActionModel();
		action19.setId("INT_PSDYNACODELISTINST__DEACTION__GET");
		action19.setName("Get");
		action19.setUniqueTag("INT_PSDYNACODELISTINST__DEACTION__GET");
		action19.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action19.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_GET);
		action19.setActionPath("/psdynacodelistinst");
		action19.setKeyField("PSDYNACODELISTINSTID");
		this.registerServiceAPIAction(action19);
		RestServiceAPIActionModel action20 = new RestServiceAPIActionModel();
		action20.setId("INT_PSDYNACODELISTINST__FETCH__BYINST");
		action20.setName("BYINST");
		action20.setUniqueTag("INT_PSDYNACODELISTINST__FETCH__BYINST");
		action20.setActionType(RestServiceAPIActionModel.ACTIONTYPE_FETCH);
		action20.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action20.setActionPath("/psdynacodelistinst/fetchbyinst");
		action20.setKeyField("PSDYNACODELISTINSTID");
		this.registerServiceAPIAction(action20);
	}
	protected void prepareAPIActions_INT_PSDYNAWFVERINST()throws Exception{
		RestServiceAPIActionModel action0 = new RestServiceAPIActionModel();
		action0.setId("INT_PSDYNAWFVERINST__DEACTION__GET");
		action0.setName("Get");
		action0.setUniqueTag("INT_PSDYNAWFVERINST__DEACTION__GET");
		action0.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action0.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_GET);
		action0.setActionPath("/psdynawfverinst");
		action0.setKeyField("PSDYNAWFVERINSTID");
		this.registerServiceAPIAction(action0);
		RestServiceAPIActionModel action1 = new RestServiceAPIActionModel();
		action1.setId("INT_PSDYNAWFVERINST__FETCH__BYINST");
		action1.setName("BYINST");
		action1.setUniqueTag("INT_PSDYNAWFVERINST__FETCH__BYINST");
		action1.setActionType(RestServiceAPIActionModel.ACTIONTYPE_FETCH);
		action1.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action1.setActionPath("/psdynawfverinst/fetchbyinst");
		action1.setKeyField("PSDYNAWFVERINSTID");
		this.registerServiceAPIAction(action1);
	}
	protected void prepareAPIActions_INT_PSDYNAAPPVIEW()throws Exception{
		RestServiceAPIActionModel action21 = new RestServiceAPIActionModel();
		action21.setId("INT_PSDYNAAPPVIEW__DEACTION__GET");
		action21.setName("Get");
		action21.setUniqueTag("INT_PSDYNAAPPVIEW__DEACTION__GET");
		action21.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action21.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_GET);
		action21.setActionPath("/psdynaappview");
		action21.setKeyField("PSDYNAAPPVIEWID");
		this.registerServiceAPIAction(action21);
	}
	protected void prepareAPIActions_INT_PSDYNAAPPVIEWINST()throws Exception{
		RestServiceAPIActionModel action2 = new RestServiceAPIActionModel();
		action2.setId("INT_PSDYNAAPPVIEWINST__SELECT");
		action2.setName("Select");
		action2.setUniqueTag("INT_PSDYNAAPPVIEWINST__SELECT");
		action2.setActionType(RestServiceAPIActionModel.ACTIONTYPE_SELECT);
		action2.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action2.setActionPath("/psdynaappviewinst/select");
		action2.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action2);
		RestServiceAPIActionModel action3 = new RestServiceAPIActionModel();
		action3.setId("INT_PSDYNAAPPVIEWINST__DEACTION__SAVE");
		action3.setName("Save");
		action3.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__SAVE");
		action3.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action3.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action3.setActionPath("/psdynaappviewinst/save");
		action3.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action3);
		RestServiceAPIActionModel action4 = new RestServiceAPIActionModel();
		action4.setId("INT_PSDYNAAPPVIEWINST__DEACTION__GET");
		action4.setName("Get");
		action4.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__GET");
		action4.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action4.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_GET);
		action4.setActionPath("/psdynaappviewinst");
		action4.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action4);
		RestServiceAPIActionModel action5 = new RestServiceAPIActionModel();
		action5.setId("INT_PSDYNAAPPVIEWINST__DEACTION__CHECKKEY");
		action5.setName("CheckKey");
		action5.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__CHECKKEY");
		action5.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action5.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action5.setActionPath("/psdynaappviewinst/checkkey");
		action5.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action5);
		RestServiceAPIActionModel action6 = new RestServiceAPIActionModel();
		action6.setId("INT_PSDYNAAPPVIEWINST__DEACTION__UPDATE");
		action6.setName("Update");
		action6.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__UPDATE");
		action6.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action6.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_PUT);
		action6.setActionPath("/psdynaappviewinst");
		action6.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action6);
		RestServiceAPIActionModel action7 = new RestServiceAPIActionModel();
		action7.setId("INT_PSDYNAAPPVIEWINST__DEACTION__CREATE");
		action7.setName("Create");
		action7.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__CREATE");
		action7.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action7.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action7.setActionPath("/psdynaappviewinst");
		action7.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action7);
		RestServiceAPIActionModel action8 = new RestServiceAPIActionModel();
		action8.setId("INT_PSDYNAAPPVIEWINST__DEACTION__REMOVE");
		action8.setName("Remove");
		action8.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__REMOVE");
		action8.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action8.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_DELETE);
		action8.setActionPath("/psdynaappviewinst");
		action8.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action8);
		RestServiceAPIActionModel action9 = new RestServiceAPIActionModel();
		action9.setId("INT_PSDYNAAPPVIEWINST__DEACTION__GETDRAFT");
		action9.setName("GetDraft");
		action9.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__GETDRAFT");
		action9.setActionType(RestServiceAPIActionModel.ACTIONTYPE_DEACTION);
		action9.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_GET);
		action9.setActionPath("/psdynaappviewinst/getdraft");
		action9.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action9);
		RestServiceAPIActionModel action10 = new RestServiceAPIActionModel();
		action10.setId("INT_PSDYNAAPPVIEWINST__FETCH__BYINST");
		action10.setName("BYINST");
		action10.setUniqueTag("INT_PSDYNAAPPVIEWINST__FETCH__BYINST");
		action10.setActionType(RestServiceAPIActionModel.ACTIONTYPE_FETCH);
		action10.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action10.setActionPath("/psdynaappviewinst/fetchbyinst");
		action10.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action10);
		RestServiceAPIActionModel action11 = new RestServiceAPIActionModel();
		action11.setId("INT_PSDYNAAPPVIEWINST__FETCH__DEFAULT");
		action11.setName("DEFAULT");
		action11.setUniqueTag("INT_PSDYNAAPPVIEWINST__FETCH__DEFAULT");
		action11.setActionType(RestServiceAPIActionModel.ACTIONTYPE_FETCH);
		action11.setRequestMethod(RestServiceAPIActionModel.REQUESTMETHOD_POST);
		action11.setActionPath("/psdynaappviewinst/fetchdefault");
		action11.setKeyField("PSDYNAAPPVIEWINSTID");
		this.registerServiceAPIAction(action11);
	}

}