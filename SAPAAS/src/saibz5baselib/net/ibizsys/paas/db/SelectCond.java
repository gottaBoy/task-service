package net.ibizsys.paas.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 查询条件对象
 * 
 * @author lionlau
 *
 */
public class SelectCond extends EntityBase implements ISelectCond {

	/**
	 * 常规条件集合
	 */
	public final static String ATTR_CONDS = "conds";
	
	/**
	 * 空值判断条件集合，1:空；0:非空
	 */
	public final static String ATTR_NULLCONDS = "nullconds";
	
	public final static String ATTR_ORDER = "order";
	
	public final static String ATTR_FETCHFIRST = "fetchfirst";
	
	public final static String ATTR_MAXROW = "maxrow";
	
	public final static String ATTR_COND_NAME = "name";
	
	public final static String ATTR_COND_VALUE = "value";
	
	private String strOrderInfo = null;
	private boolean bFetchFirst = false;
	private int nMaxRowCount = -1;
	private ISelectFilter iSelectFilter = null;

	/**
	 * 值为空
	 */
	public static final Object ISNULL = new Object();

	/**
	 * 值不为空
	 */
	public static final Object ISNOTNULL = new Object();

	/**
	 * 设置条件
	 * 
	 * @param strCond
	 * @param objValue
	 * @throws Exception
	 */
	public void setConditon(String strCond, Object objValue) throws Exception {
		this.set(strCond, objValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.ISelectCond#getOrderInfo()
	 */
	@Override
	public String getOrderInfo() {
		return strOrderInfo;
	}

	/**
	 * 设置排序信息
	 * 
	 * @param strOrderInfo
	 */
	public void setOrderInfo(String strOrderInfo) {
		this.strOrderInfo = strOrderInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.ISelectCond#isFetchFirst()
	 */
	@Override
	public boolean isFetchFirst() {
		return bFetchFirst;
	}

	/**
	 * 设置获取第一行数据
	 * 
	 * @param bFetchFirst
	 */
	public void setFetchFirst(boolean bFetchFirst) {
		this.bFetchFirst = bFetchFirst;
		if (this.bFetchFirst) {
			this.nMaxRowCount = 1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.entity.EntityBase#onReset()
	 */
	@Override
	protected void onReset() {
		this.strOrderInfo = null;
		this.bFetchFirst = false;
		this.nMaxRowCount = -1;
		this.iSelectFilter = null;
		
		super.onReset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.ISelectCond#getMaxRowCount()
	 */
	@Override
	public int getMaxRowCount() {
		return this.nMaxRowCount;
	}

	/**
	 * 设置最大行记录
	 * 
	 * @param nMaxRowCount
	 */
	public void setMaxRowCount(int nMaxRowCount) {
		this.nMaxRowCount = nMaxRowCount;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.ISelectCond#getSelectFilter()
	 */
	@Override
	public ISelectFilter getSelectFilter() {
		return this.iSelectFilter;
	}

	/**
	 * 设置过滤条件
	 * @param iSelectFilter
	 */
	public void setSelectFilter(ISelectFilter iSelectFilter){
		this.iSelectFilter = iSelectFilter;
	}
	
	
	/**
	 * 导出到JSON对象
	 * @param iSelectCond
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(ISelectCond iSelectCond,JSONObject jsonObject) throws Exception {
		if(jsonObject==null){
			jsonObject = new JSONObject();
		}
		
		ArrayList<JSONObject> valueJOList = new ArrayList<JSONObject>();
		ArrayList<JSONObject> nullJOList = new ArrayList<JSONObject>();
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		iSelectCond.fillMap(paramMap);
		
		for(Entry<String, Object> entry:paramMap.entrySet()){
			if(entry.getValue() == ISNULL ){
				JSONObject jo = new JSONObject();
				jo.put(ATTR_COND_NAME, JSONObjectHelper.stripQuotes(entry.getKey(),true));
				jo.put(ATTR_COND_VALUE, 1);
				nullJOList.add(jo);
			}
			else if(entry.getValue() == ISNOTNULL ){
				JSONObject jo = new JSONObject();
				jo.put(ATTR_COND_NAME, JSONObjectHelper.stripQuotes(entry.getKey(),true));
				jo.put(ATTR_COND_VALUE, 0);
				nullJOList.add(jo);
			}
			else{
				JSONObject jo = new JSONObject();
				jo.put(ATTR_COND_NAME, JSONObjectHelper.stripQuotes(entry.getKey(),true));
				jo.put(ATTR_COND_VALUE, JSONObjectHelper.stripQuotes(entry.getValue(),true));
				valueJOList.add(jo);
			}
		}
		
		if(nullJOList.size()>0){
			jsonObject.put(ATTR_NULLCONDS, JSONArray.fromCollection(nullJOList));
		}
		if(valueJOList.size()>0){
			jsonObject.put(ATTR_CONDS, JSONArray.fromCollection(valueJOList));
		}
		
		if(iSelectCond.getOrderInfo()!=null){
			JSONObjectHelper.put(jsonObject, ATTR_ORDER, iSelectCond.getOrderInfo());
		}
		
		JSONObjectHelper.put(jsonObject, ATTR_FETCHFIRST, iSelectCond.isFetchFirst());
		if(iSelectCond.getMaxRowCount()>0){
			JSONObjectHelper.put(jsonObject, ATTR_MAXROW, iSelectCond.getMaxRowCount());
		}
		
		return jsonObject;
	}
	
	/**
	 * 从JSON对象中构建
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static ISelectCond fromJSONObject(JSONObject jsonObject) throws Exception {
		return fromJSONObject(jsonObject,new SelectCond());
	}
	
	/**
	 * 从JSON对象中构建
	 * @param jsonObject
	 * @param selectCond
	 * @return
	 * @throws Exception
	 */
	protected static ISelectCond fromJSONObject(JSONObject jsonObject,SelectCond selectCond) throws Exception {
		
		JSONArray valueJA = jsonObject.optJSONArray(ATTR_CONDS);
		if(valueJA!=null){
			for(int i=0;i<valueJA.length();i++){
				JSONObject jo = valueJA.getJSONObject(i);
				String strName = jo.getString(ATTR_COND_NAME);
				Object objValue = jo.getString(ATTR_COND_VALUE);
				selectCond.setConditon(strName, objValue);
			}
		}
		
		JSONArray nullJA = jsonObject.optJSONArray(ATTR_NULLCONDS);
		if(nullJA!=null){
			for(int i=0;i<nullJA.length();i++){
				JSONObject jo = nullJA.getJSONObject(i);
				String strName = jo.getString(ATTR_COND_NAME);
				int nValue  = jo.optInt(ATTR_COND_VALUE,1);
				if(nValue == 1){
					selectCond.setConditon(strName, ISNULL);
				}
				else{
					selectCond.setConditon(strName, ISNOTNULL);
				}
			}
		}
		
		String strOrderInfo = jsonObject.optString(ATTR_ORDER);
		if(strOrderInfo!=null){
			selectCond.setOrderInfo(strOrderInfo);
		}
		
		boolean bFirst = jsonObject.optBoolean(ATTR_FETCHFIRST, false);
		if(bFirst){
			selectCond.setFetchFirst(bFirst);
		}
		
		int nMaxRow = jsonObject.optInt(ATTR_MAXROW,-1);
		if(nMaxRow>0){
			selectCond.setMaxRowCount(nMaxRow);
		}
		
		return selectCond;
	}
	
	/**
	 * 设置为空条件
	 * @param strFieldName
	 * @throws Exception
	 */
	public void setIsNull(String strFieldName) throws Exception{
		this.set(strFieldName, SelectCond.ISNULL);
	}
	
	
	/**
	 * 设置不为空条件
	 * @param strFieldName
	 * @throws Exception
	 */
	public void setIsNotNull(String strFieldName) throws Exception{
		this.set(strFieldName, SelectCond.ISNOTNULL);
	}
}
