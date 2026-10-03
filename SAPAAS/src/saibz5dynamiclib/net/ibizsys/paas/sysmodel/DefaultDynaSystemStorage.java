package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;

import net.ibizsys.paas.api.FetchResult;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.sysmodel.util.dynaclient.DefaultDynaAPIClientModel;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaAppView;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaAppViewInst;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaCodeListInst;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaWFVer;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaWFVerInst;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaView;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;

/**
 * 默认动态系统存储对象
 * @author Administrator
 *
 */
public class DefaultDynaSystemStorage extends DynaSystemStorageBase {

	public final static String ATTR_DYNASYSINSTID = "DYNASYSINSTID";
	
	
	private String strDynaInstId = null;
	
	IServiceAPIClientModel clientModel = null;

	
	@Override
	protected void onInit() throws Exception {
		this.strDynaInstId = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSINSTID, strDynaInstId);
		
		if(StringHelper.isNullOrEmpty(strDynaInstId)) {
			throw new Exception("没有配置动态系统实例。") ;
		}
		
		clientModel = createDynaSystemAPIModel();
		
		super.onInit();
	}

	public IServiceAPIClientModel createDynaSystemAPIModel() {
		IServiceAPIClientModel clientModel = null ;
		try {
			clientModel = new DefaultDynaAPIClientModel();
			clientModel.init(null);
			return clientModel ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	@Override
	public ArrayList<DSDynaViewInst> listDynaViewInsts() throws Exception {
		ArrayList<DSDynaViewInst> dsDynaViewInstList = new ArrayList<DSDynaViewInst>() ;
		
		
		DEDataSetFetchContext iDEDataSetFetchContext = new DEDataSetFetchContext();
		PSDynaAppViewInst cond = new PSDynaAppViewInst();
		cond.setPSDynaInstId(strDynaInstId);
		iDEDataSetFetchContext.setActiveDataObject(cond);
		iDEDataSetFetchContext.setPageSize(99999);
		FetchResult fetchResult = clientModel.fetch("INT_PSDYNAAPPVIEWINST__FETCH__BYINST",iDEDataSetFetchContext);

		
		for (IDataRow row : fetchResult.getDataRows()) {
			PSDynaAppViewInst psDynaAppViewInst = new PSDynaAppViewInst() ;
			DataObject.fromDataRow(psDynaAppViewInst,row);
			psDynaAppViewInst.set("PREDEFINEDVIEWTYPE", row.get("PREDEFINEVIEWTYPE"));
			DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
			
			dsDynaViewInst.setDSDynaViewInstId(psDynaAppViewInst.getPSDynaAppViewInstId());
			dsDynaViewInst.setDSDynaViewInstName(psDynaAppViewInst.getPSDynaAppViewInstName());
			dsDynaViewInst.setDynaSysInstId(psDynaAppViewInst.getPSDynaInstId());
			dsDynaViewInst.setDynaModel(psDynaAppViewInst.getDynaModel());
			dsDynaViewInst.setDSDynaViewId(psDynaAppViewInst.getPSDynaAppViewId());
			dsDynaViewInst.setInstVer(psDynaAppViewInst.getInstVer());
			dsDynaViewInst.setPDVTParam(psDynaAppViewInst.getPDVTParam());
			dsDynaViewInst.setPredefinedViewType(psDynaAppViewInst.getPredefinedViewType());
			dsDynaViewInst.setViewType(psDynaAppViewInst.getPredefinedViewType());
			
			dsDynaViewInstList.add(dsDynaViewInst);
		}
		
		return dsDynaViewInstList;
	}


	@Override
	public DSDynaView getDynaView(String strDynaViewId) throws Exception {
		DSDynaView dsDynaView = new DSDynaView();
		
		PSDynaAppView psDynaAppView = new PSDynaAppView() ;
		psDynaAppView.setPSDynaAppViewId(strDynaViewId);
		clientModel.execute("INT_PSDYNAAPPVIEW__DEACTION__GET", psDynaAppView);
		
		dsDynaView.setDSDynaViewId(psDynaAppView.getPSDynaAppViewId());
		dsDynaView.setDSDynaViewName(psDynaAppView.getPSDynaAppViewName());
		dsDynaView.setDEId(psDynaAppView.getPSDynaDEId());
		dsDynaView.setDEWFId(psDynaAppView.getPSWFDEId());
		dsDynaView.setPDVTParam(psDynaAppView.getPDVTParam());
		dsDynaView.setPredefinedViewType(psDynaAppView.getPredefinedViewType());
//		dsDynaView.setViewDesc(viewdesc);
		dsDynaView.setViewType(psDynaAppView.getViewType());
//		dsDynaView.setViewVer(viewver);
//		dsDynaView.setViewInstObj(viewinstobj);
		return dsDynaView;
	}


	@Override
	public DSDynaViewInst getDynaViewInst(String strDynaViewInstId) throws Exception {
		DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
		
		PSDynaAppViewInst psDynaAppViewInst = new PSDynaAppViewInst() ;
		psDynaAppViewInst.setPSDynaAppViewInstId(strDynaViewInstId);
		clientModel.execute("INT_PSDYNAAPPVIEWINST__DEACTION__GET", psDynaAppViewInst);
		
		dsDynaViewInst.setDSDynaViewInstId(psDynaAppViewInst.getPSDynaAppViewInstId());
		dsDynaViewInst.setDSDynaViewInstName(psDynaAppViewInst.getPSDynaAppViewInstName());
		dsDynaViewInst.setDynaSysInstId(psDynaAppViewInst.getPSDynaInstId());
		dsDynaViewInst.setDynaModel(psDynaAppViewInst.getDynaModel());
		dsDynaViewInst.setDSDynaViewId(psDynaAppViewInst.getPSDynaAppViewId());
		dsDynaViewInst.setInstVer(psDynaAppViewInst.getInstVer());
		dsDynaViewInst.setPDVTParam(psDynaAppViewInst.getPDVTParam());
		dsDynaViewInst.set("PREDEFINEDVIEWTYPE", psDynaAppViewInst.get("PREDEFINEVIEWTYPE"));
//		dsDynaViewInst.setPredefinedViewType(psDynaAppViewInst.getPredefinedViewType());
		dsDynaViewInst.setViewType(psDynaAppViewInst.getPredefinedViewType());

		return dsDynaViewInst;
	}


	@Override
	public ArrayList<DSDynaWFVer> listDynaWFVers() throws Exception {
		
		ArrayList<DSDynaWFVer> dsDynaWFVerList = new ArrayList<DSDynaWFVer>() ;
		
		DEDataSetFetchContext iDEDataSetFetchContext = new DEDataSetFetchContext();
		PSDynaWFVerInst cond = new PSDynaWFVerInst();
		cond.setPSDynaInstId(strDynaInstId);
		iDEDataSetFetchContext.setActiveDataObject(cond);
		iDEDataSetFetchContext.setPageSize(99999);
		FetchResult fetchResult = clientModel.fetch("INT_PSDYNAWFVERINST__FETCH__BYINST",iDEDataSetFetchContext);

		
		for (IDataRow row : fetchResult.getDataRows()) {
			PSDynaWFVerInst dynaWFVerInst = new PSDynaWFVerInst() ;
			DataObject.fromDataRow(dynaWFVerInst,row);
			
			DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();
			
			dsDynaWFVer.setDSDynaWFVerId(dynaWFVerInst.getPSDynaWFVerInstId());
			dsDynaWFVer.setDSDynaWFVerName(dynaWFVerInst.getPSDynaWFVerInstName());
			dsDynaWFVer.setDSDynaWFId(dynaWFVerInst.getPSDynaWFVerId());
//			dsDynaWFVer.setDSDynaWFName("");
			dsDynaWFVer.setDynaModel(dynaWFVerInst.getDynaModel());
			dsDynaWFVer.setWFVersion(dynaWFVerInst.getWFVersion());
			dsDynaWFVer.setDynaSysInstId(dynaWFVerInst.getPSDynaInstId());
			
			dsDynaWFVerList.add(dsDynaWFVer);
		}
		
		return dsDynaWFVerList;
	}


	@Override
	public DSDynaWF getDynaWF(String strDynaWFId) throws Exception {
		
		PSDynaWFVer psDynaWFVer = new PSDynaWFVer();
		psDynaWFVer.setPSDynaWFVerId(strDynaWFId);
		clientModel.execute("INT_PSDYNAWFVER__DEACTION__GET", psDynaWFVer);
		
		DSDynaWF dsDynaWF = new DSDynaWF();
		dsDynaWF.setDSDynaWFId(psDynaWFVer.getPSDynaWFVerId());
		dsDynaWF.setDSDynaWFName(psDynaWFVer.getPSDynaWFVerName());
		dsDynaWF.setWFWorkflowId(psDynaWFVer.getPSDynaWFId());
		dsDynaWF.setWFWorkflowName(psDynaWFVer.getPSDynaWFName());
		return dsDynaWF;
	}


	@Override
	public DSDynaWFVer getDynaWFVer(String strDynaWFVerId) throws Exception {
		DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();

		PSDynaWFVerInst dynaWFVerInst = new PSDynaWFVerInst() ;
		dynaWFVerInst.setPSDynaWFVerInstId(strDynaWFVerId);
		clientModel.execute("INT_PSDYNAWFVERINST__DEACTION__GET", dynaWFVerInst);
		
		dsDynaWFVer.setDSDynaWFVerId(dynaWFVerInst.getPSDynaWFVerInstId());
		dsDynaWFVer.setDSDynaWFVerName(dynaWFVerInst.getPSDynaWFVerInstName());
		dsDynaWFVer.setDSDynaWFId(dynaWFVerInst.getPSDynaWFVerId());
//		dsDynaWFVer.setDSDynaWFName("");
		dsDynaWFVer.setDynaModel(dynaWFVerInst.getDynaModel());
		dsDynaWFVer.setWFVersion(dynaWFVerInst.getWFVersion());
		dsDynaWFVer.setDynaSysInstId(dynaWFVerInst.getPSDynaInstId());
		
		return dsDynaWFVer;
	}


	@Override
	public ArrayList<DSDynaCodeList> listDynaCodeLists() throws Exception {
		ArrayList<DSDynaCodeList> dsDynaCodeListList = new ArrayList<DSDynaCodeList>() ;
		
		DEDataSetFetchContext iDEDataSetFetchContext = new DEDataSetFetchContext();
		PSDynaCodeListInst cond = new PSDynaCodeListInst();
		cond.setPSDynaInstId(strDynaInstId);
		iDEDataSetFetchContext.setActiveDataObject(cond);
		iDEDataSetFetchContext.setPageSize(99999);
		
		FetchResult fetchResult = clientModel.fetch("INT_PSDYNACODELISTINST__FETCH__BYINST",iDEDataSetFetchContext);

		
		for (IDataRow row : fetchResult.getDataRows()) {
			PSDynaCodeListInst psDynaCodeListInst = new PSDynaCodeListInst() ;
			DataObject.fromDataRow(psDynaCodeListInst,row);
			
			DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
			
			dsDynaCodeList.setDSDynaCodeListId(psDynaCodeListInst.getPSDynaCodeListInstId());
			dsDynaCodeList.setDSDynaCodeListName(psDynaCodeListInst.getPSDynaCodeListInstName());
			dsDynaCodeList.setCodeListId(psDynaCodeListInst.getPSDynaCodeListId());
			dsDynaCodeList.setDynaModel(psDynaCodeListInst.getDynaModel());
			dsDynaCodeList.setDynaSysInstId(psDynaCodeListInst.getPSDynaInstId());
			dsDynaCodeList.setInstVer(psDynaCodeListInst.getInstVer());
			
			dsDynaCodeListList.add(dsDynaCodeList);
		}
		
		return dsDynaCodeListList;
	}


	@Override
	public DSDynaCodeList getDynaCodeList(String strDynaCodeListId) throws Exception {
		DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
		
		PSDynaCodeListInst psDynaCodeListInst = new PSDynaCodeListInst() ;
		psDynaCodeListInst.setPSDynaCodeListInstId(strDynaCodeListId);
		clientModel.execute("INT_PSDYNACODELISTINST__DEACTION__GET", psDynaCodeListInst);
		
		dsDynaCodeList.setDSDynaCodeListId(psDynaCodeListInst.getPSDynaCodeListInstId());
		dsDynaCodeList.setDSDynaCodeListName(psDynaCodeListInst.getPSDynaCodeListInstName());
		dsDynaCodeList.setCodeListId(psDynaCodeListInst.getPSDynaCodeListId());
		dsDynaCodeList.setDynaModel(psDynaCodeListInst.getDynaModel());
		dsDynaCodeList.setDynaSysInstId(psDynaCodeListInst.getPSDynaInstId());
		dsDynaCodeList.setInstVer(psDynaCodeListInst.getInstVer());
		
		return dsDynaCodeList;
	}

}
