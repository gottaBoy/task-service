package net.ibizsys.psportal.api;

import java.util.ArrayList;

import net.ibizsys.paas.api.FetchResult;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;

public class PortalAPIClientModel extends PortalAPIClientModelBase {

	private PortalAPIClientModel() throws Exception {
		super();
	}

	private static PortalAPIClientModel portalAPIClientModel = null ;

	public static PortalAPIClientModel getCurrent() {
		if(portalAPIClientModel == null) {
			try {
				portalAPIClientModel = new PortalAPIClientModel() ;
				portalAPIClientModel.init(null);
			} catch (Exception e) {
				return null ;
			}
		}
		return portalAPIClientModel;
	}
	
	
	public FetchResult getTopMenu(IDEDataSetFetchContext iDEDataSetFetchContext) {
		try {
			return portalAPIClientModel.fetch("ACUSERFUNCGRPDETAIL__FETCH__TOPUSERGROUP", iDEDataSetFetchContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	
	public ArrayList<IEntity> findLoginAccount(ISelectCond iSelectCond){
		try {
			return portalAPIClientModel.select("ACLOGINACCOUNT__SELECT", iSelectCond);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	
	public IEntity getDataSource(String strDataSourceId) {
		
		DataEntity dataEntity = new DataEntity();
		try {
			dataEntity.set("ACDATASOURCEID", strDataSourceId);
			portalAPIClientModel.execute("ACDATASOURCE__DEACTION__GET", dataEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataEntity ;
	}
	
}
