package net.ibizsys.model.pub.reactmob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.ibizsys.paas.view.IView;
import net.sf.json.JSONObject;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.View.IPSAppDERedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel;
import SA.SRFDA.PS.Core.PF.IPSNGState;
import SA.SRFDA.PS.Core.PF.PSNGStateImpl;
import SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.SubSys.IPSSubDEView;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;

/**
 * JQ视图
 * @author Administrator
 *
 */
public class PSReactMobViewCodePublisherImpl extends PSPFViewCodePublisherImpl
{

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		ArrayList<IPSNGState> psNGStateList = null;
		if (StringHelper.Compare(this.getPSPFPubCode().getName(), "ROUTER", true) == 0 || StringHelper.Compare(this.getPSPFPubCode().getName(), "SHELL", true) == 0 || StringHelper.Compare(this.getPSPFPubCode().getName(), "CONTROLLER_BASE", true) == 0) {
			psNGStateList = new ArrayList<IPSNGState>();
			HashMap<String, IPSNGState> psNGStateMap =  new HashMap<String, IPSNGState>();
			this.fillNGStates(this.iPSAppView, null, "", null,psNGStateList, true,psNGStateMap);
			
			params.put("ngstates", psNGStateList);
		}
		
		if (true) {
			ArrayList<IPSAppView> refPSAppViewList = null;
			
			// 关联视图去重
			refPSAppViewList  = new ArrayList<IPSAppView>();
			HashMap<String, IPSAppView> refViewMap = new HashMap<String, IPSAppView>();
			
			java.util.Iterator<IPSAppView> psAppViewLists = this.iPSAppView.getAllRelatedPSAppViews();
			while(psAppViewLists.hasNext()) {
				IPSAppView iPSAppView = psAppViewLists.next();
				refViewMap.put(iPSAppView.getId(), iPSAppView);
			}
			
			if (refViewMap.containsKey(this.iPSAppView.getId())) {
				refViewMap.remove(this.iPSAppView.getId());
			}
			
			refPSAppViewList.addAll(refViewMap.values());
			params.put("refviews", refPSAppViewList);
		}
		
		//合成require
//		ArrayList<String> psAppViewIdList = new  ArrayList<String>();
//		this.iPSAppView.fillRelatedPSAppViewIds(psAppViewIdList);
		
		String strFullClassName = this.iPSApplication.getPKGCodeName();
		if(!StringHelper.IsNullOrEmpty(this.getPSPFPubCode().getPKGCodeName()))
		{
			strFullClassName += StringHelper.Format(".%1$s",this.getPSPFPubCode().getPKGCodeName());
		}
		
		if(!StringHelper.IsNullOrEmpty(strFullClassName))
		{
			strFullClassName += StringHelper.Format(".");
		}
		HashMap<String, String> requireClassMap = new HashMap<String, String>();
		ArrayList<String> requireClasses = new ArrayList<String> ();
		
		strFullClassName = this.iPSApplication.getPKGCodeName();
		if(!StringHelper.IsNullOrEmpty(this.getPSPFPubCode().getPKGCodeName()))
		{
			strFullClassName += StringHelper.Format(".%1$s",this.getPSPFPubCode().getPKGCodeName());
		}
		
		if(!StringHelper.IsNullOrEmpty(strFullClassName))
		{
			strFullClassName += StringHelper.Format(".");
		}
		
		if(false)
		//if(this.iPSAppView instanceof IPSAppIndexView )
		{
			java.util.Iterator<IPSAppView> psAppViews =   this.iPSApplication.getAllPSAppViews();
			while(psAppViews.hasNext())
			{
				IPSAppView iPSAppView = psAppViews.next();
				if(iPSAppView == this.iPSAppView)
					continue;
					
				String strAppViewClassName = strFullClassName + iPSAppView.getFullCodeName();
				requireClassMap.put(strAppViewClassName, "");
			}
		}
		

		
	/*	for(String strPSAppViewId :psAppViewIdList)
		{
			IPSAppView iPSAppView = this.iPSApplication.getPSAppView(strPSAppViewId);
			String strAppViewClassName = strFullClassName + iPSAppView.getFullCodeName();
			requireClassMap.put(strAppViewClassName, "");
		}*/
		requireClasses.addAll(requireClassMap.keySet());
	
		params.put("requires", requireClasses);
		
		
		
		String strAliasName = this.iPSAppView.getFullCodeName().replace('.','_').toLowerCase();
		//附加填入参数
		params.put("viewaliasname", strAliasName);
		
		ArrayList<IPSAppViewRef> embedPSAppViewRefList = new ArrayList<IPSAppViewRef>();
		HashMap<String, IPSViewType> psViewTypeMap = new  HashMap<String, IPSViewType>();
		HashMap<String, IPSAppView> psAppViewMap = new  HashMap<String, IPSAppView>();
		HashMap<String,String> includeCssFileIdMap  = new  HashMap<String,String>();
		HashMap<String,String> includeJsFileIdMap  = new  HashMap<String,String>();
		String strCurIncludeCssFileId = "";
		String strCurIncludeJsFileId = "";
		java.util.Iterator<IPSAppViewRef> psAppViewRefs = this.iPSAppView.getEmbeddedPSAppViewRefs(null);
		if(psAppViewRefs!=null)
		{
			while(psAppViewRefs.hasNext())
			{
				IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
				psViewTypeMap.put(iPSAppViewRef.getRefPSAppView().getPSViewType().getId(), iPSAppViewRef.getRefPSAppView().getPSViewType());
				psAppViewMap.put(iPSAppViewRef.getRefPSAppView().getId(), iPSAppViewRef.getRefPSAppView());
				if(iPSAppViewRef.getRefPSAppView() instanceof IPSAppSubSysDEView)
				{
					IPSAppSubSysDEView iPSAppSubSysDEView = (IPSAppSubSysDEView)iPSAppViewRef.getRefPSAppView();
					IPSSubDEView ipsSubDEView = iPSAppSubSysDEView.getPSSubAppRef().getPSSubApp().getPSSubSys().getPSSubDEView(iPSAppSubSysDEView.getPSSubAppView().getPSSubDEViewId());
					psViewTypeMap.put(ipsSubDEView.getPSViewType().getId(), ipsSubDEView.getPSViewType());
					continue;
				}
				
				if(iPSAppViewRef.getEmbedId().indexOf("_")==-1)
				{
					embedPSAppViewRefList.add(iPSAppViewRef);
				}
				
				String strIncludeCssFileId = "";
				String strIncludeJsFileId = "";
				
				strIncludeCssFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
				strIncludeJsFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
				
				IPSSubViewType iPSSubViewType=iPSAppViewRef.getRefPSAppView().getPSSubViewType();
				if(iPSSubViewType!=null)
				{
					//判断文件类型
					if(iPSSubViewType.isExtendView())
					{
						if(StringHelper.Compare(iPSSubViewType.getNameMode(),IPSSubViewType.NAMEMODE_APPEND,true) == 0)
						{
							strIncludeCssFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
							strIncludeCssFileId += "_";
							strIncludeCssFileId += iPSSubViewType.getTypeCode();
						}
						else
							if(StringHelper.Compare(iPSSubViewType.getNameMode(),IPSSubViewType.NAMEMODE_REPLACE,true) == 0)
							{
								strIncludeCssFileId = iPSSubViewType.getTypeCode();
							}
					}
					
					if(iPSSubViewType.isExtendCtrl())
					{
						if(StringHelper.Compare(iPSSubViewType.getNameMode(),IPSSubViewType.NAMEMODE_APPEND,true) == 0)
						{
							strIncludeJsFileId = iPSAppViewRef.getRefPSAppView().getPSViewType().getId();
							strIncludeJsFileId += "_";
							strIncludeJsFileId += iPSSubViewType.getTypeCode();
						}else
							if(StringHelper.Compare(iPSSubViewType.getNameMode(),IPSSubViewType.NAMEMODE_REPLACE,true) == 0)
							{
								strIncludeJsFileId = iPSSubViewType.getTypeCode();
							}
					}
				}

				
				includeCssFileIdMap.put(strIncludeCssFileId, "");
				includeJsFileIdMap.put(strIncludeJsFileId, "");
			}
			
			psViewTypeMap.remove(this.iPSAppView.getPSViewType().getId());
			psAppViewMap.remove(this.iPSAppView.getId());
			
			if(true)
			{
				strCurIncludeCssFileId = this.iPSAppView.getPSViewType().getId();
				strCurIncludeJsFileId = this.iPSAppView.getPSViewType().getId();
				
				IPSSubViewType iPSSubViewType=this.iPSAppView.getPSSubViewType();
				if(iPSSubViewType!=null)
				{
					//判断文件类型
					if(iPSSubViewType.isExtendView())
					{
						if(StringHelper.Compare(iPSSubViewType.getNameMode(),IPSSubViewType.NAMEMODE_APPEND,true) == 0)
						{
							strCurIncludeCssFileId = this.iPSAppView.getPSViewType().getId();
							strCurIncludeCssFileId += "_";
							strCurIncludeCssFileId += iPSSubViewType.getTypeCode();
						}
						else
							if(StringHelper.Compare(iPSSubViewType.getNameMode(),IPSSubViewType.NAMEMODE_REPLACE,true) == 0)
							{
								strCurIncludeCssFileId = iPSSubViewType.getTypeCode();
							}
					}
					
					if(iPSSubViewType.isExtendCtrl())
					{
						if(StringHelper.Compare(iPSSubViewType.getNameMode(),IPSSubViewType.NAMEMODE_APPEND,true) == 0)
						{
							strCurIncludeJsFileId = this.iPSAppView.getPSViewType().getId();
							strCurIncludeJsFileId += "_";
							strCurIncludeJsFileId += iPSSubViewType.getTypeCode();
						}else
							if(StringHelper.Compare(iPSSubViewType.getNameMode(),IPSSubViewType.NAMEMODE_REPLACE,true) == 0)
							{
								strCurIncludeJsFileId = iPSSubViewType.getTypeCode();
							}
					}
				}

				
				includeCssFileIdMap.remove(strCurIncludeCssFileId);
				includeJsFileIdMap.remove(strCurIncludeJsFileId);
			}
		}
		
		ArrayList<IPSViewType> embedPSViewTypeList = new ArrayList<IPSViewType>();
		ArrayList<IPSAppView> embedPSAppViewList = new ArrayList<IPSAppView>();
		
		embedPSViewTypeList.addAll(psViewTypeMap.values());
		embedPSAppViewList.addAll(psAppViewMap.values());
		
		params.put("allembedviewtypes", embedPSViewTypeList);
		params.put("allembedviews", embedPSAppViewList);
		params.put("curembedviewrefs", embedPSAppViewRefList);
		
		ArrayList<String> allCssFileList = new ArrayList<String>();
		ArrayList<String> allJsFileList = new ArrayList<String>();
		allCssFileList.addAll(includeCssFileIdMap.keySet());
		allJsFileList.addAll(includeJsFileIdMap.keySet());
		
		params.put("allcssfiles", allCssFileList);
		params.put("alljsfiles", allJsFileList);
		
		params.put("curcssfile", strCurIncludeCssFileId);
		params.put("curjsfile", strCurIncludeJsFileId);
		
	}

	/* (non-Javadoc) 
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#getPSAppViewCodeName(SA.SRFDA.PS.Core.App.View.IPSAppView)
	 */
	@Override
	protected String getPSAppViewCodeName(IPSAppView iPSAppView)
	{
		if(StringHelper.Compare(this.getPSPFPubCode().getName(),"CONTROLLER",true)==0 
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"CONTROLLER_BASE",true)==0
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"CONTROL",true)==0
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"ROUTER",true)==0
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"SHELL",true)==0
				|| StringHelper.Compare(this.getPSPFPubCode().getName(), "LESS", true)==0){
			String strFullName = iPSAppView.getFullCodeName();
			int nPos = strFullName.lastIndexOf(".");
			if(nPos != -1){
				strFullName = StringHelper.Format("%1$s.%2$s.%2$s",replaceFullName(strFullName.substring(0, nPos)),replaceFullName(strFullName.substring(nPos+1)));
			}
			return strFullName;
		}
		return super.getPSAppViewCodeName(iPSAppView);
	}
	
	private String replaceFullName(String strFullName) {
		strFullName = strFullName.replaceAll("_", "-");
		int state = 0;//0代表前一个字母是小写，1代表前一个字母是大写
        String str = strFullName;
        StringBuilder strBuilder = new StringBuilder();
		if(Character.isUpperCase(str.charAt(0))){
			strBuilder.append(str.substring(0,1).toLowerCase());
			state = 1;
		} else {
			strBuilder.append(str.substring(0,1));
			state = 0;
		}
        for(int i = 1; i< str.length(); i++){
        	char chr = str.charAt(i);
            if(Character.isUpperCase(chr)){
            	if(state == 1){
            		strBuilder.append(str.substring(i,(i+1)).toLowerCase());
            	} else {
            		strBuilder.append("-");
            		strBuilder.append(str.substring(i,(i+1)).toLowerCase());
            	}
            	state = 1;
            } else {
            	strBuilder.append(chr);
            	state = 0;
            }
        }
        String resultStr = strBuilder.toString();
        resultStr = resultStr.replaceAll("--", "-");
        resultStr = resultStr.replaceAll("---", "-");
		return resultStr;
	}
	
	@Override
	protected String generateCode(Map<String, Object> params2) throws Exception {
		if(params2 == null){
			params2 = new HashMap<String, Object>();
		}
		params2.put("viewname", replaceFullName(this.iPSAppView.getCodeName()));
		PSReactMobTemplHelper.fillParams(params2);
		return super.generateCode(params2);
	}

	@Override
	protected 	String generateCode(BaseDataEntity templData,String strCodeName,HashMap<String, Object> params ) throws Exception
	{
//		if(iPSAppView.getPSSysPFPlugin()==null)
//		{
//			IPSSysPFPluginTempl iPSSysPFPluginTempl =  iPSAppView.getPSSysPFPlugin().getPSSysPFPluginTempl(this.iPSPF.getId());
//			PSSysPFPluginTempl psPluginTemplData = iPSSysPFPluginTempl.getPSSysPFPluginTemplData(this.iPSPFStyle);
//			
//			if(StringHelper.Compare(this.getPSPFPubCode().getName(),"PART",true)==0)
//			{
//				if(!StringHelper.IsNullOrEmpty(psPluginTemplData.getTEMPLCODE()))
//				{
//					return PSTemplHelper.generateCode(psPluginTemplData,PSPFViewTempl.TAG_TEMPLCODE,params);
//				}
//			}
//			
//			if(StringHelper.Compare(this.getPSPFPubCode().getName(),"CONTROLLER",true)==0)
//			{
//				if(!StringHelper.IsNullOrEmpty(psPluginTemplData.getTEMPLCODE2()))
//				{
//					return PSTemplHelper.generateCode(psPluginTemplData,PSPFViewTempl.TAG_TEMPLCODE2,params);
//				}
//			}
//			
//		}
		return super.generateCode(templData, strCodeName, params);
	}
	
	/**
	 * 
	 * @param iPSAppView 当前视图
	 * @param parentPSNGState 当前视图的状态
	 * @param strName 节点名称
	 * @param viewParamJO 视图参数
	 * @param psNGStateList 当前视图路由数据集
	 * @param bNext 是否还有下一级路由
	 * @param psNGStateMap
	 * @throws Exception
	 */
	protected void fillNGStates(IPSAppView iPSAppView, IPSNGState parentPSNGState, String strName, JSONObject viewParamJO,ArrayList<IPSNGState> psNGStateList, boolean bNext, HashMap<String, IPSNGState> psNGStateMap) throws Exception {
		// 路由层级,最多4级
		if (parentPSNGState != null && parentPSNGState.getLevel() >= 4)
			return;
		// 节点是否出现过
		if (psNGStateMap.containsKey(strName)) {
			return ;
		}

		PSNGStateImpl psNGStateImpl = new PSNGStateImpl();
		psNGStateImpl.init(null, strName);
		psNGStateImpl.setPSAppView(iPSAppView);
		psNGStateImpl.setIndex(psNGStateList.size());
		psNGStateImpl.setViewParamJO(viewParamJO);
		psNGStateList.add(psNGStateImpl);

		psNGStateMap.put(strName, psNGStateImpl);
		// 第一次入口
		if (iPSAppView != null && bNext) {
			if (true) {
				java.util.Iterator<IPSAppFunc> psAppFuncs = iPSAppView.getPSAppFuncs();
				// 应用功能遍历
				while(psAppFuncs.hasNext()) {
					IPSAppFunc psAppFunc = psAppFuncs.next();
					if (psAppFunc.getPSAppView() != null) {
						String routeName = psAppFunc.getCodeName();
						if (StringHelper.IsNullOrEmpty(routeName)) {
							// 路由名称：模块+视图代码名称
							routeName = StringHelper.Format("%1$s_%2$s", psAppFunc.getPSAppView().getPSAppModule().getCodeName(),psAppFunc.getPSAppView().getCodeName()).toLowerCase();
						}
						
						this.fillNGStates(psAppFunc.getPSAppView(), psNGStateImpl, routeName,null, psNGStateList, false,psNGStateMap);
					}
				}
			}
//			if(iPSAppView instanceof IPSAppDEMultiDataView){
//				// 获取新建及编辑视图
//				java.util.Iterator<IPSAppViewRef> psAppViewRefs = iPSAppView.getPSAppViewRefs();
//				if (psAppViewRefs != null) {
//					while (psAppViewRefs.hasNext()) {
//						IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
//						if(iPSAppViewRef.getRefPSAppView()==null)
//							continue;
//						
//						String strRefMode = iPSAppViewRef.getName();
//						String strStateName = "";
//						JSONObject stateViewParamJO = null;
//						// 新建视图X
//						if (strRefMode.indexOf("NEWDATA:") == 0) {
//							String strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
//							if (StringHelper.IsNullOrEmpty(strOpenMode)) {
//								strStateName = StringHelper.Format("new_%1$s", strRefMode.substring(8).replace(":", "__").replace("@", "__"));
//								stateViewParamJO = viewParamJO;
//							} else
//								continue;
//						} else
//						// 编辑视图X
//						if (strRefMode.indexOf("EDITDATA:") == 0) {
//							String strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
//							if (StringHelper.IsNullOrEmpty(strOpenMode)) {
//								strStateName = StringHelper.Format("edit_%1$s", strRefMode.substring(9).replace(":", "__").replace("@", "__"));
//							} else
//								continue;
//						} else
//						// 新建视图X
//						if (StringHelper.Compare(strRefMode, "NEWDATA", true) == 0) {
//							String strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
//							if (StringHelper.IsNullOrEmpty(strOpenMode)) {
//								strStateName = StringHelper.Format("new");
//								stateViewParamJO = viewParamJO;
//							} else
//								continue;
//						} else
//						// 编辑视图X
//						if (StringHelper.Compare(strRefMode, "EDITDATA", true) == 0) {
//							String strOpenMode = iPSAppViewRef.getRefPSAppView().getOpenMode(iPSAppViewRef);
//							if (StringHelper.IsNullOrEmpty(strOpenMode)) {
//								strStateName = StringHelper.Format("edit");
//							} else
//								continue;
//						} else
//							continue;
//						// 递归填充
//						strStateName = StringHelper.Format("%1$s%2$s",strName,strStateName);
//						this.fillNGStates(iPSAppViewRef.getRefPSAppView(), psNGStateImpl, strStateName,stateViewParamJO, psNGStateList, false,psNGStateMap);
//					}
//				}
//			}
			
			if(iPSAppView instanceof IPSAppExplorerView){
				// 获取导航视图项
				java.util.Iterator<IPSAppViewRef> psAppViewRefs = iPSAppView.getPSAppViewRefs();
				if (psAppViewRefs != null) {
					while (psAppViewRefs.hasNext()) {
						IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
						if(iPSAppViewRef.getRefPSAppView()==null)
							continue;
						
						String strRefMode = iPSAppViewRef.getName();
						String strStateName = "";
						JSONObject stateViewParamJO = null;
						// 导航视图项
						if (strRefMode.indexOf("EXPITEM:") == 0) {
							strStateName = StringHelper.Format("%1$s", strRefMode.substring(8).replace(":", "__").replace("@", "__"));
							stateViewParamJO = viewParamJO;
						}
						else
							continue;
						// 递归填充
						//strStateName = StringHelper.Format("%1$s$%2$s",strName,strStateName);
						this.fillNGStates(iPSAppViewRef.getRefPSAppView(), psNGStateImpl, strStateName,stateViewParamJO, psNGStateList, false,psNGStateMap);
					}
				}
			}
			
			if(iPSAppView instanceof IPSAppIndexView){
				java.util.Iterator<IPSAppView> psAppViews = null;
				if (this.iPSApplication.isPubRefViewOnly()) {
					psAppViews = this.iPSApplication.getAllRefPSAppViews();
				} else {
					psAppViews = this.iPSApplication.getAllPSAppViews();
				}
				
//				while(psAppViews.hasNext()) {    //加入此段语句会关联出多余视图
//					IPSAppView editView = psAppViews.next();
//					if (editView.getViewType().indexOf("EDITVIEW") != -1 && editView.getViewType().indexOf("EDITVIEW9") == -1) {
//						String strStateName = StringHelper.Format("%1$s_%2$s", editView.getPSAppModule().getCodeName(),editView.getCodeName()).toLowerCase();
//						this.fillNGStates(editView, psNGStateImpl, strStateName,null, psNGStateList, false,psNGStateMap);
//					}
//				}
			} else {
				
				
				java.util.Iterator<IPSAppView> psAppViews = iPSAppView.getAllRelatedPSAppViews();
				
				while(psAppViews.hasNext()) {
					IPSAppView editView = psAppViews.next();
					if (editView.getViewType().indexOf("EDITVIEW") != -1 && editView.getViewType().indexOf("EDITVIEW9") == -1) {
						String strStateName = StringHelper.Format("%1$s_%2$s", editView.getPSAppModule().getCodeName(),editView.getCodeName()).toLowerCase();
						this.fillNGStates(editView, psNGStateImpl, strStateName,null, psNGStateList, false,psNGStateMap);
					} else if (editView instanceof IPSAppDERedirectView) {
						IPSAppDERedirectView iPSAppDERedirectView = (IPSAppDERedirectView)editView;
						Iterator<IPSAppView> redirectViews = iPSAppDERedirectView.getRedirectPSAppViews();
						if(redirectViews!=null){
							while(redirectViews.hasNext()) {
								IPSAppView redirectView = redirectViews.next();
								String strStateName = StringHelper.Format("%1$s_%2$s", redirectView.getPSAppModule().getCodeName(),redirectView.getCodeName()).toLowerCase();
								this.fillNGStates(redirectView, psNGStateImpl, strStateName,null, psNGStateList, false,psNGStateMap);
							}
						}
					}
				}
			}
			
			//实体选择视图
//			if(iPSAppView instanceof IPSAppDEPickupView){
//				java.util.ArrayList<IPSControl> psControls =  iPSAppView.getPSControls("pickupviewpanel", 10);
//				for(IPSControl iPSControl:psControls){
//					// 放入关系项
//					this.fillNGStates(iPSDEDRCtrlItem.getPSAppView(), psNGStateImpl, iPSDEDRCtrlItem.getName(),iPSDEDRCtrlItem.getViewParamJO(), psNGStateList);
//				}
//			}
			
			if(true){
				// 获取视图部件，根据部件等展开
				java.util.Iterator<IPSControl> psControls = iPSAppView.getAllPSControls().iterator();
				if (psControls != null) {
					while (psControls.hasNext()) {
						IPSControl iPSControl = psControls.next();
						if (iPSControl instanceof IPSDEDRCtrl) {
							// 关系部件
							IPSDEDRCtrl iPSDEDRCtrl = (IPSDEDRCtrl) iPSControl;
							if(iPSDEDRCtrl.isIncludeMajor()){
								// 放入表单
								this.fillNGStates(null, psNGStateImpl, "form",null, psNGStateList, false,psNGStateMap);
							}

							// 循环其它部件
							java.util.Iterator<IPSDEDRCtrlItem> psDEDRCtrlItems = iPSDEDRCtrl.getPSDEDRCtrlItems();
							if (psDEDRCtrlItems != null) {
								while (psDEDRCtrlItems.hasNext()) {
									IPSDEDRCtrlItem iPSDEDRCtrlItem = psDEDRCtrlItems.next();
									// 放入关系项
									this.fillNGStates(iPSDEDRCtrlItem.getPSAppView(), psNGStateImpl, iPSDEDRCtrlItem.getName(),iPSDEDRCtrlItem.getViewParamJO(), psNGStateList, false,psNGStateMap);
								}
							}
							continue;
						}
						
						if (iPSControl instanceof IPSDEViewPanel) {
							IPSDEViewPanel iPSDEViewPanel = (IPSDEViewPanel)iPSControl;
							this.fillNGStates(iPSDEViewPanel.getPSAppDEView(), psNGStateImpl, iPSDEViewPanel.getName(),null, psNGStateList, false,psNGStateMap);
						}
					}
				}
			}
		}

	}
	
	/**
	 * 填充嵌入关联试图，不包含选择试图和模式弹出试图
	 * 
	 * @param iPSAppView
	 * @param embeddedPSAppViewList
	 * @throws Exception
	 */
	protected void fillEmbeddedPSAppViews(IPSAppView iPSAppView,ArrayList<IPSAppView> embeddedPSAppViewList) throws Exception {
		java.util.Iterator<IPSAppViewRef> psAppViewRefLists  = iPSAppView.getEmbeddedPSAppViewRefs(""); 
		
		HashMap<String, IPSAppView> embeddedViewMap = new HashMap<String, IPSAppView>();
		
		while(psAppViewRefLists.hasNext()) {
			IPSAppViewRef iPSAPPViewRef = psAppViewRefLists.next();
			if (iPSAPPViewRef.getRefPSAppView() == null) {
				continue;
			}
			
			if (StringHelper.IsNullOrEmpty(iPSAPPViewRef.getEmbedId())) {
				continue;
			}
			
			if (iPSAPPViewRef.getRefPSAppView().isPickupView() || StringHelper.Compare(iPSAPPViewRef.getRefPSAppView().getOpenMode(), IView.OPENMODE_POPUPMODAL, true) == 0) {
				continue;
			}
			
			if (iPSAPPViewRef.getEmbedId().indexOf("_") == -1) {
				embeddedViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
			}
		}
		
		if (embeddedViewMap.containsKey(iPSAppView.getId())) {
			embeddedViewMap.remove(iPSAppView.getId());
		}
		
		embeddedPSAppViewList.addAll(embeddedViewMap.values());
		
	}
	
	/**
	 * 填充视图模态框状态
	 * 
	 * @param iPSAppView
	 * @param modalPSAppViewList
	 * @throws Exception
	 */
	protected void fillModalPSAppViews(IPSAppView iPSAppView,ArrayList<IPSAppView> modalPSAppViewList) throws Exception {
		java.util.Iterator<IPSAppViewRef> psAppViewRefLists  = iPSAppView.getPSAppViewRefs(); 
		
		HashMap<String, IPSAppView> modalViewMap = new HashMap<String, IPSAppView>();
		
		while(psAppViewRefLists.hasNext()) {
			IPSAppViewRef iPSAPPViewRef = psAppViewRefLists.next();
			if (iPSAPPViewRef.getRefPSAppView() == null) {
				continue;
			}
			
			if (StringHelper.Compare(iPSAPPViewRef.getRealOpenMode(), IView.OPENMODE_POPUP, true) == 0 
					|| StringHelper.Compare(iPSAPPViewRef.getRealOpenMode(), IView.OPENMODE_POPUPMODAL, true) == 0) {
				modalViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
				
			}
		}
		
		java.util.Iterator<IPSAppView> psAppViewLists  = iPSAppView.getAllRelatedPSAppViews();
		while(psAppViewLists.hasNext()) {
			IPSAppView psAppView = psAppViewLists.next();
			
			if (psAppView == null) {
				continue;
			}
			
			if (StringHelper.Compare(psAppView.getOpenMode(), IView.OPENMODE_POPUP, true) == 0 
					|| StringHelper.Compare(psAppView.getOpenMode(), IView.OPENMODE_POPUPMODAL, true) == 0) {
				
				modalViewMap.put(psAppView.getId(), psAppView);
				continue;
			}
			
			if (psAppView.isPickupView()) {
				modalViewMap.put(psAppView.getId(), psAppView);
				continue;
			}
		}
		
		if (modalViewMap.containsKey(iPSAppView.getId())) {
			modalViewMap.remove(iPSAppView.getId());
		}
		
		modalPSAppViewList.addAll(modalViewMap.values());
		
	}
	
	/**
	 * 所有模态框打开试图
	 * 
	 * @param iPSAppView
	 * @param modalViewMap
	 * @param level
	 * @throws Exception
	 */
	protected void fillAllModalPSAppViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> modalViewMap, int level) throws Exception {
		if (level > 3) {
			return ;
		}
		java.util.Iterator<IPSAppViewRef> psAppViewRefLists  = iPSAppView.getPSAppViewRefs(); 
		
		
		while(psAppViewRefLists.hasNext()) {
			IPSAppViewRef iPSAPPViewRef = psAppViewRefLists.next();
			if (iPSAPPViewRef.getRefPSAppView() == null) {
				continue;
			}
			
			if (StringHelper.Compare(iPSAPPViewRef.getRealOpenMode(), IView.OPENMODE_POPUP, true) == 0 
					|| StringHelper.Compare(iPSAPPViewRef.getRealOpenMode(), IView.OPENMODE_POPUPMODAL, true) == 0) {
				if (!modalViewMap.containsKey(iPSAPPViewRef.getRefPSAppView().getId())) {
					modalViewMap.put(iPSAPPViewRef.getRefPSAppView().getId(), iPSAPPViewRef.getRefPSAppView());
					this.fillAllModalPSAppViews(iPSAPPViewRef.getRefPSAppView(), modalViewMap, level+1);
				}
				
			}
		}
		
		java.util.Iterator<IPSAppView> psAppViewLists  = iPSAppView.getAllRelatedPSAppViews();
		while(psAppViewLists.hasNext()) {
			IPSAppView psAppView = psAppViewLists.next();
			
			if (psAppView == null) {
				continue;
			}
			
			if (StringHelper.Compare(psAppView.getOpenMode(), IView.OPENMODE_POPUP, true) == 0 
					|| StringHelper.Compare(psAppView.getOpenMode(), IView.OPENMODE_POPUPMODAL, true) == 0) {
				
				if (!modalViewMap.containsKey(psAppView.getId())) {
					modalViewMap.put(psAppView.getId(), psAppView);
					this.fillAllModalPSAppViews(psAppView, modalViewMap, level+1);
					continue;
				}
				
			}
			
			if (psAppView.isPickupView()) {
				modalViewMap.put(psAppView.getId(), psAppView);
				continue;
			}
		}
		
	}
	
	/**
	 * 是否输出全部控件
	 * @return
	 */
	protected boolean isOutputAllControls(){
		return true;
	}
}
