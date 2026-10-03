package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.db.SelectGroupFilter;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 实体数据集合查询条件对象
 * 
 * @author Administrator
 *
 */
public class DEDataSetCond extends DEDataQueryCodeCondImpl implements IDEDataSetCond {
	
	private String strDEDataQueryName = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetCond#getDEDataQueryName()
	 */
	@Override
	public String getDEDataQueryName() {
		return strDEDataQueryName;
	}

	/**
	 * 设置实体数据查询名称
	 * 
	 * @param strDEDataQueryName the strDEDataQueryName to set
	 */
	public void setDEDataQueryName(String strDEDataQueryName) {
		this.strDEDataQueryName = strDEDataQueryName;
	}
	
	

	/**
	 * 导出到JSON对象
	 * @param iDEDataSetCond
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IDEDataSetCond iDEDataSetCond,JSONObject jsonObject) throws Exception {
		if(jsonObject==null){
			jsonObject = new JSONObject();
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEDataQueryName())){
			JSONObjectHelper.put(jsonObject, SelectContext.ATTR_DEDATAQUERYNAME, iDEDataSetCond.getDEDataQueryName());
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetCond.getCondType())){
			JSONObjectHelper.put(jsonObject, SelectFieldFilter.ATTR_CONDTYPE, iDEDataSetCond.getCondType());
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetCond.getCondOp())){
			JSONObjectHelper.put(jsonObject, SelectFieldFilter.ATTR_CONDOP, iDEDataSetCond.getCondOp());
		}
		
		if(iDEDataSetCond.getCondValue()!=null){
			JSONObjectHelper.put(jsonObject, SelectFieldFilter.ATTR_CONDVALUE, iDEDataSetCond.getCondValue());
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEFName())){
			JSONObjectHelper.put(jsonObject, SelectFieldFilter.ATTR_DEFNAME, iDEDataSetCond.getDEFName());
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetCond.getDEFieldExp())){
			JSONObjectHelper.put(jsonObject, SelectFieldFilter.ATTR_DEFIELDEXP, iDEDataSetCond.getDEFieldExp());
		}
		
		
		if(iDEDataSetCond.getStdDataType()!=DataTypes.UNKNOWN){
			JSONObjectHelper.put(jsonObject, SelectFieldFilter.ATTR_DATATYPE, iDEDataSetCond.getStdDataType());
		}
		
		if(iDEDataSetCond.isNotMode()){
			JSONObjectHelper.put(jsonObject, SelectGroupFilter.ATTR_NOT, iDEDataSetCond.isNotMode());
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetCond.getCustomCond())){
			JSONObjectHelper.put(jsonObject, SelectFieldFilter.ATTR_CUSTOMCOND, iDEDataSetCond.getCustomCond());
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetCond.getValueFunc())){
			JSONObjectHelper.put(jsonObject, SelectFieldFilter.ATTR_FUNC, iDEDataSetCond.getValueFunc());
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetCond.getPredefinedCode())){
			JSONObjectHelper.put(jsonObject, SelectFieldFilter.ATTR_PREDEFINED, iDEDataSetCond.getPredefinedCode());
		}
		
		Iterator<IDEDataQueryCodeCond>  conds = iDEDataSetCond.getChildDEDataQueryConds();
		if(conds!=null){
			ArrayList<JSONObject> childCondList = new ArrayList<JSONObject>();
			while(conds.hasNext()){
				IDEDataQueryCodeCond iDEDataQueryCodeCond = conds.next();
				if(iDEDataQueryCodeCond instanceof IDEDataSetCond){
					JSONObject childJsonObject = toJSONObject((IDEDataSetCond)iDEDataQueryCodeCond,null);
					childCondList.add(childJsonObject);
				}
				
			}
			if(childCondList.size()>0){
				JSONObjectHelper.put(jsonObject, SelectGroupFilter.ATTR_CONDS,JSONArray.fromArray(childCondList.toArray()));
			}
		}

		return jsonObject;
	}
	
	/**
	 * 从JSON对象中构建
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static IDEDataSetCond fromJSONObject(JSONObject jsonObject) throws Exception {
		DEDataSetCond deDataSetCond = new DEDataSetCond();
		
		String strDEDataQueryName = jsonObject.optString(SelectContext.ATTR_DEDATAQUERYNAME);
		if(!StringHelper.isNullOrEmpty(strDEDataQueryName)){
			deDataSetCond.setDEDataQueryName(strDEDataQueryName);
		}
		
		
		String strCondType = jsonObject.optString(SelectFieldFilter.ATTR_CONDTYPE);
		if(!StringHelper.isNullOrEmpty(strCondType)){
			deDataSetCond.setCondType(strCondType);
		}
		
		String strCondOp = jsonObject.optString(SelectFieldFilter.ATTR_CONDOP);
		if(!StringHelper.isNullOrEmpty(strCondOp)){
			deDataSetCond.setCondOp(strCondOp);
		}
		
		String strCondValue = jsonObject.optString(SelectFieldFilter.ATTR_CONDVALUE);
		if(strCondValue!=null){
			deDataSetCond.setCondValue(strCondValue);
		}
		

		String strDEFName = jsonObject.optString(SelectFieldFilter.ATTR_DEFNAME);
		if(!StringHelper.isNullOrEmpty(strDEFName)){
			deDataSetCond.setDEFName(strDEFName);
		}
		
		String strDEFieldExp = jsonObject.optString(SelectFieldFilter.ATTR_DEFIELDEXP);
		if(!StringHelper.isNullOrEmpty(strDEFieldExp)){
			deDataSetCond.setDEFieldExp(strDEFieldExp);
		}
	
		int nDataType = jsonObject.optInt(SelectFieldFilter.ATTR_DATATYPE,DataTypes.UNKNOWN);
		if(nDataType!=DataTypes.UNKNOWN){
			deDataSetCond.setStdDataType(nDataType);
		}

		boolean bNotMode = jsonObject.optBoolean(SelectGroupFilter.ATTR_NOT,false);
		if(bNotMode){
			deDataSetCond.setNotMode(bNotMode);
		}
		
		String strCustomCond = jsonObject.optString(SelectFieldFilter.ATTR_CUSTOMCOND);
		if(!StringHelper.isNullOrEmpty(strCustomCond)){
			deDataSetCond.setCustomCond(strCustomCond);
		}
		
		String strValueFunc = jsonObject.optString(SelectFieldFilter.ATTR_FUNC);
		if(!StringHelper.isNullOrEmpty(strValueFunc)){
			deDataSetCond.setValueFunc(strValueFunc);
		}
		
		String strPredefinedCode = jsonObject.optString(SelectFieldFilter.ATTR_PREDEFINED);
		if(!StringHelper.isNullOrEmpty(strPredefinedCode)){
			deDataSetCond.setPredefinedCond(strPredefinedCode);
		}
		
		
		JSONArray ja = jsonObject.optJSONArray(SelectGroupFilter.ATTR_CONDS);
		if(ja!=null){
			for(int i =0;i<ja.length();i++){
				JSONObject childJsonObject = (JSONObject)ja.get(i);
				 IDEDataSetCond childDEDataSetCond =  fromJSONObject(childJsonObject) ;
				 deDataSetCond.addChildDEDataQueryCond(childDEDataSetCond);
			}
		}
		
		return deDataSetCond;
	}

}
