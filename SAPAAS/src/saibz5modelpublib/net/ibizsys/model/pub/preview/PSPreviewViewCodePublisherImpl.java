package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.React.PSReactTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.SubSys.IPSSubDEView;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;

/**
 * PreViewPC视图
 * @author Administrator
 *
 */
public class PSPreviewViewCodePublisherImpl extends PSPFViewCodePublisherImpl
{

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
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
//				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"CONTROLLER_BASE_TS",true)==0 
//				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"SERVICE_TS",true)==0 
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"CSS",true)==0
//				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"CONTROLLER_USER",true)==0
//				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"PART",true)==0
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"HTML",true)==0
//				|| StringHelper.Compare(this.getPSPFPubCode().getName(), "MODULE_TS", true)==0
//				|| StringHelper.Compare(this.getPSPFPubCode().getName(), "SHELL_MODULE_TS", true)==0
//				|| StringHelper.Compare(this.getPSPFPubCode().getName(), "MODAL_SERVICE_TS", true)==0
//				|| StringHelper.Compare(this.getPSPFPubCode().getName(), "SHELL_COMPONENT_TS", true)==0
//				|| StringHelper.Compare(this.getPSPFPubCode().getName(), "ROUTES_TS", true)==0
			){
			String strFullName = iPSAppView.getFullCodeName();
			int nPos = strFullName.lastIndexOf(".");
			if(nPos != -1){
				strFullName = StringHelper.Format("%1$s.%2$s.%2$s",PSPreviewFileNameMethod.replaceFullName(strFullName.substring(0, nPos)),PSPreviewFileNameMethod.replaceFullName(strFullName.substring(nPos+1)));
			}
			return strFullName;
		}
//		return super.getPSAppViewCodeName(iPSAppView);
//		if(StringHelper.Compare(this.getPSPFPubCode().getFileNameExt(),".jsp",true)==0)
//			return super.getPSAppViewCodeName(iPSAppView).toLowerCase();
		return super.getPSAppViewCodeName(iPSAppView);
	}
	
	@Override
	protected String generateCode(Map<String, Object> params2) throws Exception {
		if(params2 == null){
			params2 = new HashMap<String, Object>();
		}
		params2.put("viewname", PSPreviewFileNameMethod.replaceFullName(this.iPSAppView.getCodeName()));
		PSReactTemplHelper.fillParams(params2);
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

	@Override
	protected boolean isOutputAllControls() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean isOutputChildControlFirst() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
