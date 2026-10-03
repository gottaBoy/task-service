package net.ibizsys.model.pub.ionic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import SA.SRFDA.PS.Core.App.View.IPSAppSubSysDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
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
public class PSIonicViewCodePublisherImpl extends PSPFViewCodePublisherImpl
{

	private static PSIonicFileNameMethod psIonicFileNameMethod = new PSIonicFileNameMethod();
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
		if(StringHelper.Compare(this.getPSPFPubCode().getName(),"MODULE_TS",true)==0 
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"CONTROLLER_TS",true)==0 
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"CONTROLLER_BASE_TS",true)==0 
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"SERVICE_TS",true)==0 
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"SCSS",true)==0 
				|| StringHelper.Compare(this.getPSPFPubCode().getName(),"HTML",true)==0){
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
		params2.put("ionicviewname", replaceFullName(this.iPSAppView.getCodeName()));
		params2.put("ionicclassname", psIonicFileNameMethod);
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
	 * 是否输出全部控件
	 * @return
	 */
	protected boolean isOutputAllControls(){
		return true;
	}
}
