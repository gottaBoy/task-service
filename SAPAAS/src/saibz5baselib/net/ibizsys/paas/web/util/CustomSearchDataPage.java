package net.ibizsys.paas.web.util;

import java.util.Iterator;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.sf.json.JSONObject;

/**
 * 自定义搜索数据加载
 * @author hebao
 *
 */
public class CustomSearchDataPage extends Page {

	@Override
	protected void onInit() throws Exception {
		super.onInit();
		long startTime = System.currentTimeMillis();
		try {
			JSONObject jo = new JSONObject();
			String strDEName = this.getWebContext().getPostValue("dename");
			IDataEntityModel iDEModel = DEModelGlobal.getDEModel(strDEName);
			
			JSONObject fieldArray = new JSONObject();
			JSONObject codeListArray = new JSONObject();
			
			java.util.Iterator<IDEField> iDEFields = iDEModel.getDEFields();
			while (iDEFields.hasNext()) {
				IDEField iDEFieldModel = iDEFields.next();
				String strDEFName = iDEFieldModel.getName();
				
				//无权限属性不下发
				if(!this.isAccessDEField(strDEName, strDEFName))
					continue;
				
				String strDataType = this.getDEFDataType(iDEModel, iDEFieldModel);
				
				String strCodeListId = iDEFieldModel.getCodeListId();
				if (!StringHelper.isNullOrEmpty(strCodeListId)) {
					ICodeList iCodeList = CodeListGlobal.getCodeList(strCodeListId);
					Iterator<ICodeItem> codeItems = iCodeList.getCodeItems();
					while (codeItems.hasNext()) {
						JSONObject codeItemArray = new JSONObject();
						ICodeItem codeItem = codeItems.next();
						codeItemArray.put("value", JSONObjectHelper.stripQuotes(codeItem.getValue(),true));
						codeItemArray.put("text", JSONObjectHelper.stripQuotes(codeItem.getText(),true));
						codeItemArray.put("realtext", JSONObjectHelper.stripQuotes(codeItem.getText(),true));
						codeListArray.put(strDEFName, codeItemArray);
					}
				}

				JSONObject joDEField = new JSONObject();

				joDEField.put("defid", JSONObjectHelper.stripQuotes(strDEFName,true));
				joDEField.put("defname", JSONObjectHelper.stripQuotes(iDEFieldModel.getLogicName(),true));
				joDEField.put("stddatatype", JSONObjectHelper.stripQuotes(strDataType,true));
				joDEField.put("condtype", IDEDataSetCond.CONDTYPE_DEFIELD);
				fieldArray.put(strDEFName, joDEField);

				JSONObject codeListFieldArr = new JSONObject();
				codeListFieldArr.put("value", JSONObjectHelper.stripQuotes(strDEFName,true));
				codeListFieldArr.put("text", JSONObjectHelper.stripQuotes(iDEFieldModel.getLogicName(),true));
				codeListFieldArr.put("realtext", JSONObjectHelper.stripQuotes(iDEFieldModel.getLogicName(),true));
				codeListArray.put(strDEName, codeListFieldArr);
				
			}
			jo.put("defieldArr", fieldArray);
			jo.put("codeListArr", codeListArray);
			this.getResponse().getWriter().write(jo.toString());
			
		} catch (Exception e) {
			
		}
		long endTime = System.currentTimeMillis();

		float seconds = (endTime - startTime) / 1000F;

//		System.out.println(Float.toString(seconds) + " seconds.");
	}

	/**
	 * 功能：获取外键附加数据的属性类型
	 * 
	 * @param iDEModel
	 * @param iDEField
	 * @return
	 */
	public String getDEFDataType(IDataEntityModel iDEModel, IDEField iDEField) {
		String strDadaType = iDEField.getDataType();
		try {
			if(StringHelper.compare(strDadaType, "PICKUPDATA", true) == 0){
				String strDERName = iDEField.getDERName();
				String strLinkDEFName = iDEField.getLinkDEFName();// 关系属性
				Iterator<IDERBase> iDERs = iDEModel.getDERs(false);
				while (iDERs.hasNext()) {
					IDERBase iDER = (IDERBase) iDERs.next();
					String strMajorDERName = iDER.getName();
					if (StringHelper.compare(strDERName, strMajorDERName, true) == 0) {
						String strMajorDEId = iDER.getMajorDEId();
						IDataEntityModel majorDEModel = DEModelGlobal.getDEModel(strMajorDEId);
						if (majorDEModel != null) {
							Iterator<IDEField> majorDEFields = majorDEModel.getDEFields();
							while (majorDEFields.hasNext()) {
								IDEField majorDEField = (IDEField) majorDEFields.next();
								if (StringHelper.compare(majorDEField.getName(), strLinkDEFName, true) == 0) {
									strDadaType = this.getDEFDataType(majorDEModel, majorDEField);
								}
							}
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strDadaType;
	}

	protected boolean isAccessDEField(String strDEName, String strDEFName) throws Exception{
		boolean bAccess = true;
		if(StringHelper.compare(strDEFName, "ENABLE", true)==0)
			bAccess = false;
		
//		int nAccessAction = WebContext.getCurrent().getUserRoleMgr().testUserRoleDEField(strDEName, strDEFName);
//		if(nAccessAction > PrivilegeAbilities.NONE)
//			bAccess = true;
		
		return bAccess;
		
	}
}
