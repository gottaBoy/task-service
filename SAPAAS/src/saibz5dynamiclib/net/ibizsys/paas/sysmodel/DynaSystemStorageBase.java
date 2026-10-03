package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.ViewControllerGlobal;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaView;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaCodeListService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService;
import net.ibizsys.pswf.core.IDynaWFModel;
import net.ibizsys.pswf.core.IDynaWFVersionModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.WFModelGlobal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 动态系统模型同步对象基类
 * @author Administrator
 *
 */
public abstract class DynaSystemStorageBase extends ModelBaseImpl implements IDynaSystemStorage {

	private static Log log = LogFactory.getLog(DynaSystemStorageBase.class);
	private  IDynaSystemSetting iDynaSystemSetting = null;
	@Override
	public void init(IDynaSystemSetting iDynaSystemSetting) throws Exception {
		this.iDynaSystemSetting = iDynaSystemSetting;
		this.onInit();
	}
	
	public IDynaSystemSetting getDynaSystemSetting(){
		return this.iDynaSystemSetting;
	}

	@Override
	public void syncAll() throws Exception {
		syncAllCodeLists();
		syncAllViews();
		syncAllWorkflows();
		
	}
	
	
	

	@Override
	public void installAll() throws Exception {
		installAllCodeLists();
		installAllWorkflows();
	}

	@Override
	public void syncAllViews() throws Exception {

		ArrayList<DSDynaViewInst> dynaViewInstList =  listDynaViewInsts();
		DSDynaViewInstService dsDynaViewInstService = (DSDynaViewInstService) ServiceGlobal.getService(DSDynaViewInstService.class.getName(),this.getDynaSystemSetting().getSessionFactory());
		DSDynaViewService dsDynaViewService = (DSDynaViewService) ServiceGlobal.getService(DSDynaViewService.class.getName(),this.getDynaSystemSetting().getSessionFactory());
		
		String strDynaSysInstId = WebConfig.getCurrent().getDynaSysInstId();
		//清除历史数据
		if(true) {
			SelectCond selectCond = new SelectCond();
			selectCond.setConditon(DSDynaViewInst.FIELD_DYNASYSINSTID, strDynaSysInstId);
			dsDynaViewInstService.remove(selectCond, false);
		}
		if(true) {
			SelectCond selectCond = new SelectCond();
//			selectCond.setConditon(DSDynaView.FIELD_DYNASYSINSTID, strDynaSysInstId);
			dsDynaViewService.remove(new SelectCond(), false);
		}
		
		for(DSDynaViewInst dsDynaViewInst:dynaViewInstList){
			String strDSDynaViewId = DataObject.getStringValue(dsDynaViewInst.getDSDynaViewId(),"");
			String strDSDynaViewInstId = DataObject.getStringValue(dsDynaViewInst.getDSDynaViewInstId(),"");
			int nInstVer = DataObject.getIntegerValue(dsDynaViewInst.get("instver"),1);
			
			DSDynaView dsDynaView = new DSDynaView();
			dsDynaView.setDSDynaViewId(strDSDynaViewId);
			try {
				if(dsDynaViewService.checkKey(dsDynaView) == IService.CHECKKEYSTATE_OK){
					dsDynaView = getDynaView(strDSDynaViewId);
					//dsDynaView.setDynaSysInstId(strDynaSysInstId);
					dsDynaViewService.create(dsDynaView,false);
				}
				else{
					dsDynaView = getDynaView(strDSDynaViewId);
					dsDynaViewService.update(dsDynaView,false);
				}
			} catch (Exception e) {
				throw new Exception(StringHelper.format("建立动态视图发生异常,%1$s",e.getMessage()),e);
			}
			
			dsDynaViewInst.setDSDynaViewInstId(strDSDynaViewInstId);
			if(dsDynaViewInstService.get(dsDynaViewInst,true)){
				//判断版本
			}
			dsDynaViewInst = getDynaViewInst(strDSDynaViewInstId);
			dsDynaViewInstService.save(dsDynaViewInst,false);
		}
		
		//重置全部动态视图实例缓存数据
		ViewControllerGlobal.resetAllDynaViewControllerInsts(); 
		
	}
	
	/**
	 * 列出所有的动态视图实例
	 * @return
	 * @throws Exception
	 */
	protected abstract ArrayList<DSDynaViewInst> listDynaViewInsts() throws Exception;
	
	
	/**
	 * 获取动态视图
	 * @param strDynaViewId
	 * @return
	 * @throws Exception
	 */
	protected abstract DSDynaView getDynaView(String strDynaViewId) throws Exception;
	
	
	/**
	 * 获取动态视图实例
	 * @param strDynaViewInstId
	 * @return
	 * @throws Exception
	 */
	protected abstract DSDynaViewInst getDynaViewInst(String strDynaViewInstId) throws Exception;
	

	@Override
	public void syncAllWorkflows() throws Exception {
		
		ArrayList<DSDynaWFVer> dsDynaWFVerList = new ArrayList<DSDynaWFVer>();
		
		ArrayList<DSDynaWFVer> dynaWFVerList =  listDynaWFVers();
		DSDynaWFVerService dsDynaWFVerService = (DSDynaWFVerService) ServiceGlobal.getService(DSDynaWFVerService.class.getName(),this.getDynaSystemSetting().getSessionFactory());
		DSDynaWFService dsDynaWFService = (DSDynaWFService) ServiceGlobal.getService(DSDynaWFService.class.getName(),this.getDynaSystemSetting().getSessionFactory());
		for(DSDynaWFVer dsDynaWFVer:dynaWFVerList){
			String strDSDynaWFId = DataObject.getStringValue(dsDynaWFVer.getDSDynaWFId(),"");
			String strDSDynaWFVerId = DataObject.getStringValue(dsDynaWFVer.getDSDynaWFVerId(),"");
			int nWFVer = DataObject.getIntegerValue(dsDynaWFVer.get("wfversion"),1);
			
			DSDynaWF dsDynaWF = new DSDynaWF();
			dsDynaWF.setDSDynaWFId(strDSDynaWFId);
			if(dsDynaWFService.checkKey(dsDynaWF) == IService.CHECKKEYSTATE_OK){
				dsDynaWF = getDynaWF(strDSDynaWFId);
				dsDynaWFService.create(dsDynaWF,false);
			}
			
			dsDynaWFVer.setDSDynaWFVerId(strDSDynaWFVerId);
			if(dsDynaWFVerService.get(dsDynaWFVer,true)){
				//判断版本
			}
			dsDynaWFVer = getDynaWFVer(strDSDynaWFVerId);
			dsDynaWFVerService.save(dsDynaWFVer,false);
			dsDynaWFVerList.add(dsDynaWFVer);
		}
		
		
		HashMap<String, IDynaWFModel> dynaWFModelMap = new HashMap<String, IDynaWFModel>();
		//进行模型安装
		for(DSDynaWFVer dsDynaWFVer:dsDynaWFVerList){
			
			IDynaWFModel iDynaWFModel = dynaWFModelMap.get(dsDynaWFVer.getDSDynaWF().getWFWorkflowId());
			if(iDynaWFModel == null){
				//获取对应的工作流
				IWFModel iWFModel = WFModelGlobal.getWFModel(dsDynaWFVer.getDSDynaWF().getWFWorkflowId(), true);
				if(iWFModel == null) {
					continue;
				}
				if(!(iWFModel instanceof IDynaWFModel)){
					throw new Exception(StringHelper.format("工作流模型[%1$s]类型不正确",iWFModel.getId()));
				}
				iDynaWFModel = (IDynaWFModel)iWFModel;
				iDynaWFModel.resetCurrentDynaSysInst();
				dynaWFModelMap.put(dsDynaWFVer.getDSDynaWF().getWFWorkflowId(),iDynaWFModel);
			}
		
			IDynaWFVersionModel defaultDynaWFVersionModel = iDynaWFModel.createDynaWFVersionModel(dsDynaWFVer);
			defaultDynaWFVersionModel.init(iDynaWFModel,dsDynaWFVer);
			iDynaWFModel.registerDynaWFVersionModel(defaultDynaWFVersionModel);
		}
		
	}
	
	@Override
	public void installAllWorkflows() throws Exception {
		
		DSDynaWFVerService dsDynaWFVerService = (DSDynaWFVerService) ServiceGlobal.getService(DSDynaWFVerService.class.getName(),this.getDynaSystemSetting().getSessionFactory());
		
		SelectCond selectCond = new SelectCond();
		selectCond.setConditon(DSDynaCodeList.FIELD_DYNASYSINSTID, WebConfig.getCurrent().getDynaSysInstId());
		ArrayList<DSDynaWFVer> dsDynaWFVerList =  dsDynaWFVerService.select(selectCond);
		
		HashMap<String, IDynaWFModel> dynaWFModelMap = new HashMap<String, IDynaWFModel>();
		//进行模型安装
		for(DSDynaWFVer dsDynaWFVer:dsDynaWFVerList){
			
			//获取对应的工作流
			IDynaWFModel iDynaWFModel = dynaWFModelMap.get(dsDynaWFVer.getDSDynaWF().getWFWorkflowId());
			if(iDynaWFModel == null){
				//获取对应的工作流
				IWFModel iWFModel = WFModelGlobal.getWFModel(dsDynaWFVer.getDSDynaWF().getWFWorkflowId(), true);
				if(iWFModel == null) {
					log.warn(StringHelper.format("无法获取指定流程模型[%1$s]",dsDynaWFVer.getDSDynaWF().getWFWorkflowId()));
					continue;
				}
				if(!(iWFModel instanceof IDynaWFModel)){
					throw new Exception(StringHelper.format("工作流模型[%1$s]类型不正确",iWFModel.getId()));
				}
				iDynaWFModel = (IDynaWFModel)iWFModel;
				iDynaWFModel.resetAllDynaSysInst();
				dynaWFModelMap.put(dsDynaWFVer.getDSDynaWF().getWFWorkflowId(),iDynaWFModel);
			}
			
			try {
				IDynaWFVersionModel defaultDynaWFVersionModel = iDynaWFModel.createDynaWFVersionModel(dsDynaWFVer);
				defaultDynaWFVersionModel.init(iDynaWFModel,dsDynaWFVer);
				iDynaWFModel.registerDynaWFVersionModel(defaultDynaWFVersionModel);
			} catch (Exception e) {
				log.warn(StringHelper.format("工作流版本[%1$s]安装失败,错误信息:%2$s", dsDynaWFVer.getDSDynaWFVerName(),e.getMessage()));
			}
		}
		
	}
	

	@Override
	public void syncView(String strViewId) throws Exception {
		throw new Exception("没有实现");
	}

	
	
	
	@Override
	public void syncCodeList(String strCodeListId) throws Exception {
		throw new Exception("没有实现");
	}

	@Override
	public void syncWorkflow(String strWorkflowId) throws Exception {
		throw new Exception("没有实现");
	}
	
	
	
	@Override
	public void syncAllCodeLists() throws Exception {
		
		ArrayList<DSDynaCodeList> dsDynaCodeListList = new ArrayList<DSDynaCodeList>();
		
		ArrayList<DSDynaCodeList> dynaCodeListList =  listDynaCodeLists();
		DSDynaCodeListService dsDynaCodeListService = (DSDynaCodeListService) ServiceGlobal.getService(DSDynaCodeListService.class.getName(),this.getDynaSystemSetting().getSessionFactory());
		for(DSDynaCodeList dsDynaCodeList:dynaCodeListList){
			String strCodeListId = DataObject.getStringValue(dsDynaCodeList.getCodeListId(),"");
			String strDSDynaCodeListId = DataObject.getStringValue(dsDynaCodeList.getDSDynaCodeListId(),"");
			int nInstVer = DataObject.getIntegerValue(dsDynaCodeList.get("instver"),1);
			
			dsDynaCodeList.setDSDynaCodeListId(strDSDynaCodeListId);
			if(dsDynaCodeListService.get(dsDynaCodeList,true)){
				//判断版本
			}
			dsDynaCodeList = getDynaCodeList(strDSDynaCodeListId);
			dsDynaCodeListService.save(dsDynaCodeList,false);
			dsDynaCodeListList.add(dsDynaCodeList);
		}
		
		
		HashMap<String, IDynaCodeListModelContainer> dynaCodeListModelContainerMap = new HashMap<String, IDynaCodeListModelContainer>();
		//进行模型安装
		for(DSDynaCodeList dsDynaCodeList:dsDynaCodeListList){
			
			IDynaCodeListModelContainer iDynaCodeListModelContainer = dynaCodeListModelContainerMap.get(dsDynaCodeList.getCodeListId());
			if(iDynaCodeListModelContainer == null){
				//获取对应的代码表
				ICodeList iCodeList = CodeListGlobal.getCodeList(dsDynaCodeList.getCodeListId(), true);
				if(iCodeList == null)
					continue;
				if(!(iCodeList instanceof IDynaCodeListModelContainer)){
					throw new Exception(StringHelper.format("代码表模型[%1$s]类型不正确",iCodeList.getId()));
				}
				iDynaCodeListModelContainer = (IDynaCodeListModelContainer)iCodeList;
				iDynaCodeListModelContainer.resetCurrentDynaSysInst();
				dynaCodeListModelContainerMap.put(dsDynaCodeList.getCodeListId(),iDynaCodeListModelContainer);
			}
		
			IDynaCodeListModel defaultDynaStaticCodeListModel = iDynaCodeListModelContainer.createDynaCodeListModel(dsDynaCodeList);
			defaultDynaStaticCodeListModel.init(iDynaCodeListModelContainer,dsDynaCodeList);
			iDynaCodeListModelContainer.registerDynaCodeListModel(defaultDynaStaticCodeListModel);
		}
		
	}
	
	@Override
	public void installAllCodeLists() throws Exception {
		
		DSDynaCodeListService dsDynaCodeListService = (DSDynaCodeListService) ServiceGlobal.getService(DSDynaCodeListService.class.getName(),this.getDynaSystemSetting().getSessionFactory());
		
		SelectCond selectCond = new SelectCond();
		selectCond.setConditon(DSDynaCodeList.FIELD_DYNASYSINSTID, WebConfig.getCurrent().getDynaSysInstId());
		ArrayList<DSDynaCodeList> dsDynaCodeListList =  dsDynaCodeListService.select(selectCond);
		
		HashMap<String, IDynaCodeListModelContainer> dynaCodeListModelContainerMap = new HashMap<String, IDynaCodeListModelContainer>();
		//进行模型安装
		for(DSDynaCodeList dsDynaCodeList:dsDynaCodeListList){
			
			IDynaCodeListModelContainer iDynaCodeListModelContainer = dynaCodeListModelContainerMap.get(dsDynaCodeList.getCodeListId());
			if(iDynaCodeListModelContainer == null){
				//获取对应的代码表
				ICodeList iCodeList = CodeListGlobal.getCodeList(dsDynaCodeList.getCodeListId(), true);
				if(iCodeList == null) {
					log.warn(StringHelper.format("无法获取指定代码表[%1$s]", dsDynaCodeList.getCodeListId()));
					continue;
				}
				if(!(iCodeList instanceof IDynaCodeListModelContainer)){
					throw new Exception(StringHelper.format("代码表模型[%1$s]类型不正确",iCodeList.getId()));
				}
				iDynaCodeListModelContainer = (IDynaCodeListModelContainer)iCodeList;
				iDynaCodeListModelContainer.resetAllDynaSysInst();
				dynaCodeListModelContainerMap.put(dsDynaCodeList.getCodeListId(),iDynaCodeListModelContainer);
			}
		
			IDynaCodeListModel defaultDynaStaticCodeListModel = iDynaCodeListModelContainer.createDynaCodeListModel(dsDynaCodeList);
			defaultDynaStaticCodeListModel.init(iDynaCodeListModelContainer,dsDynaCodeList);
			iDynaCodeListModelContainer.registerDynaCodeListModel(defaultDynaStaticCodeListModel);
		}
	}
	
	

	/**
	 * 列出所有的动态流程版本
	 * @return
	 * @throws Exception
	 */
	protected abstract ArrayList<DSDynaWFVer> listDynaWFVers() throws Exception;
	
	
	/**
	 * 获取动态流程
	 * @param strDynaWFId
	 * @return
	 * @throws Exception
	 */
	protected abstract DSDynaWF getDynaWF(String strDynaWFId) throws Exception;
	
	
	/**
	 * 获取动态流程版本
	 * @param strDynaWFVerId
	 * @return
	 * @throws Exception
	 */
	protected abstract DSDynaWFVer getDynaWFVer(String strDynaWFVerId) throws Exception;
	
	
	
	/**
	 * 列出所有的动态代码表
	 * @return
	 * @throws Exception
	 */
	protected abstract ArrayList<DSDynaCodeList> listDynaCodeLists() throws Exception;

	
	
	/**
	 * 获取动态代码表
	 * @param strDynaCodeListId
	 * @return
	 * @throws Exception
	 */
	protected abstract DSDynaCodeList getDynaCodeList(String strDynaCodeListId) throws Exception;
}
