package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 实体数据集合获取上下文参数
 * 
 * @author lionlau
 *
 */
public class DEDataSetFetchContext extends ActionContext implements IDEDataSetFetchContext {
	
	public final static String ATTR_START = "start";
	public final static String ATTR_SIZE = "size";
	public final static String ATTR_SORT = "sort";
	public final static String ATTR_SORTDIR = "sortdir";
	public final static String ATTR_SORT2 = "sort2";
	public final static String ATTR_SORT2DIR = "sort2dir";
	public final static String ATTR_ACTIVEDATA = "activedata";
	public final static String ATTR_JOINSCRIPT = "joinscript";
	public final static String ATTR_GROUPTOP = "grouptop";
	public final static String ATTR_FETCHDATA = "fetchdata";
	public final static String ATTR_FETCHTOTAL = "fetchtotal";
	public final static String ATTR_FETCHINFO = "fetchinfo";
	public final static String ATTR_CACHE = "cache";
	public final static String ATTR_PAGING = "paging";
	public final static String ATTR_CONDS = "conds";
	
	/**
	 * 当前线程的上下文参数对象
	 */
	private static ThreadLocal<IDEDataSetFetchContext> deDataSetFetchContext = new ThreadLocal<IDEDataSetFetchContext>();

	private static final Log log = LogFactory.getLog(DEDataSetFetchContext.class);

	private int nStartRow = 0;
	private int nPageSize = -1;
	private int nDefaultPageSize = 25;
	private String strSort = null;
	private String strSortDir = "";
	private String strSort2 = null;
	private String strSort2Dir = "";
	private ISimpleDataObject activeDataObject = null;
	private String strJoinScript = "";
	private int nGroupTopCount = -1;
	private boolean bFetchData = true;
	private boolean bFetchTotalRow = true;
	private boolean bCancel = false;
	private String strFetchInfo = "";
	private boolean bCacheDataSet = true;
	private boolean bPaging = true;

	private HashMap<String, String> joinScriptMap = null;

	protected ArrayList<IDEDataSetCond> userConditionList = new ArrayList<IDEDataSetCond>();

	public DEDataSetFetchContext() {
		super(null);
	}

	public DEDataSetFetchContext(IWebContext iWebContext) {
		super(iWebContext);

		if (iWebContext != null) {
			this.setStartRow(WebContext.getFetchStart(iWebContext, this.nStartRow));
			this.setPageSize(WebContext.getFetchSize(iWebContext, this.nPageSize));
			String strSortParam = WebContext.getSortParam(iWebContext);
			if (!StringHelper.isNullOrEmpty(strSortParam)) {
				try {
					if ((strSortParam.charAt(0) == '{') || (strSortParam.charAt(0) == '[')) {
						JSONArray jo = JSONArray.fromString(strSortParam);
						if (jo.length() >= 1) {
							JSONObject item = jo.getJSONObject(0);
							this.strSort = item.optString("property", "");
							this.strSortDir = item.optString("direction", "ASC");
						}
						if (jo.length() >= 2) {
							JSONObject item = jo.getJSONObject(1);
							this.strSort2 = item.optString("property", "");
							this.strSort2Dir = item.optString("direction", "ASC");
						}
					} else {
						this.strSort = strSortParam;
						this.strSortDir = WebContext.getSortDir(iWebContext);
						if (StringHelper.isNullOrEmpty(this.strSortDir)) this.strSortDir = "asc";
					}
				} catch (Exception ex) {

				}
			}
		}
	}

	@Override
	public int getStartRow() {
		return nStartRow;
	}

	@Override
	public int getPageSize() {
		if (this.nPageSize <= 0) return this.getDefaultPageSize();
		return nPageSize;
	}

	@Override
	public String getSort() {
		return strSort;
	}

	@Override
	public String getSortDir() {
		return strSortDir;
	}

	@Override
	public String getSort2() {
		return strSort2;
	}

	@Override
	public String getSort2Dir() {
		return strSort2Dir;
	}

	/**
	 * 设置起始行记录
	 * 
	 * @param nStartRow the nStartRow to set
	 */
	public void setStartRow(int nStartRow) {
		this.nStartRow = nStartRow;
	}

	/**
	 * 设置分页大小
	 * 
	 * @param nPageSize the nPageSize to set
	 */
	public void setPageSize(int nPageSize) {
		this.nPageSize = nPageSize;
	}

	/**
	 * 设置排序字段
	 * 
	 * @param strSort the strSort to set
	 */
	public void setSort(String strSort) {
		this.strSort = strSort;
	}

	/**
	 * 设置排序字段方向
	 * 
	 * @param strSortDir the strSortDir to set
	 */
	public void setSortDir(String strSortDir) {
		this.strSortDir = strSortDir;
	}

	/**
	 * 设置排序字段2
	 * 
	 * @param strSort2 the strSort2 to set
	 */
	public void setSort2(String strSort2) {
		this.strSort2 = strSort2;
	}

	/**
	 * 设置排序字段方向2
	 * 
	 * @param strSort2Dir the strSort2Dir to set
	 */
	public void setSort2Dir(String strSort2Dir) {
		this.strSort2Dir = strSort2Dir;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetFetchContext#getUserConditionList()
	 */
	@Override
	public ArrayList<IDEDataSetCond> getConditionList() {
		return userConditionList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetFetchContext#getDeclareScript()
	 */
	@Override
	public String getDeclareScript() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetFetchContext#fillDeclareParams(net.ibizsys.paas.db.SqlParamList)
	 */
	@Override
	public void fillDeclareParams(SqlParamList list) throws Exception {

	}

	/**
	 * 获取当前数据对象
	 * 
	 * @return
	 */
	@Override
	public ISimpleDataObject getActiveDataObject() {
		return this.activeDataObject;
	}

	/**
	 * 设置当前数据对象
	 * 
	 * @param activeDataObject
	 */
	@Override
	public void setActiveDataObject(ISimpleDataObject activeDataObject) {
		this.activeDataObject = activeDataObject;
	}

	/**
	 * 重置排序信息
	 */
	public void resetSortInfo() {
		this.setSort("");
		this.setSort2("");

		this.setSortDir("");
		this.setSort2Dir("");
		this.setJoinScript("");
	}

	/**
	 * 获取连接代码
	 * 
	 * @return the strJoinScript
	 */
	@Override
	public String getJoinScript() {
		if (this.joinScriptMap == null) {
			return strJoinScript;
		} else {
			String strTotal = "";
			if (!StringHelper.isNullOrEmpty(this.strJoinScript)) {
				strTotal += this.strJoinScript;
			}
			for (String strValue : this.joinScriptMap.values()) {
				strTotal += strValue;
			}
			return strTotal;
		}
	}

	/**
	 * 设置连接代码
	 * 
	 * @param strJoinScript the strJoinScript to set
	 */
	@Override
	public void setJoinScript(String strJoinScript) {
		this.strJoinScript = strJoinScript;
	}

	/**
	 * 获取分组处理的前面记录数
	 * 
	 * @return the nGroupTopCount
	 */
	@Override
	public int getGroupTopCount() {
		return nGroupTopCount;
	}

	/**
	 * 设置分组处理的前面记录数
	 * 
	 * @param nGroupTopCount the nGroupTopCount to set
	 */
	public void setGroupTopCount(int nGroupTopCount) {
		this.nGroupTopCount = nGroupTopCount;
	}

	/**
	 * 是否为获取数据处理
	 * 
	 * @return the bFetchData
	 */
	public boolean isFetchData() {
		return bFetchData;
	}

	/**
	 * 设置是否为获取数据处理
	 * 
	 * @param bFetchData the bFetchData to set
	 */
	public void setFetchData(boolean bFetchData) {
		this.bFetchData = bFetchData;
	}

	/**
	 * 是否为获取第一行记录
	 * 
	 * @return the bFetchTotalRow
	 */
	public boolean isFetchTotalRow() {
		return bFetchTotalRow;
	}

	/**
	 * 设置是否为获取第一行记录
	 * 
	 * @param bFetchTotalRow the bFetchTotalRow to set
	 */
	public void setFetchTotalRow(boolean bFetchTotalRow) {
		this.bFetchTotalRow = bFetchTotalRow;
	}

	/**
	 * 获取实体数据集合获取上下文参数
	 * 
	 * @return
	 */
	public static IDEDataSetFetchContext getCurrent() {
		return deDataSetFetchContext.get();
	}

	/**
	 * 设置实体数据集合获取上下文参数
	 * 
	 * @param value
	 */
	public static void setCurrent(IDEDataSetFetchContext value) {
		deDataSetFetchContext.set(value);
	}

	/**
	 * 是否取消
	 * 
	 * @return the bCancel
	 */
	public boolean isCancel() {
		return bCancel;
	}

	/**
	 * 设置是否取消
	 * 
	 * @param bCancel the bCancel to set
	 */
	public void setCancel(boolean bCancel) {
		this.bCancel = bCancel;
	}

	/**
	 * 启用组织数据范围条件
	 * 
	 * @param deDataSetFetchContextImpl
	 * @param orgIdDEField
	 * @param secIdDEField
	 * @param condList
	 * @throws Exception
	 */
	public static void enableOrgDRCond(IDEDataSetFetchContext deDataSetFetchContextImpl, IDEField orgIdDEField, IDEField secIdDEField, ArrayList<String> condList) throws Exception {
//		String strOrgIdAlias = "t1";
//		String strOrgSecIdAlias = "t1";
//		if (orgIdDEField != null && StringHelper.compare(orgIdDEField.getDataType(), IDEField.DATATYPE_INHERIT, true) == 0) {
//			strOrgIdAlias = "t11";
//		}
//		if (secIdDEField != null && StringHelper.compare(secIdDEField.getDataType(), IDEField.DATATYPE_INHERIT, true) == 0) {
//			strOrgSecIdAlias = "t11";
//		}

		if (condList.size() == 0) {
			// 有权限，但是没有任何约束
			DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
			deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
			deDataSetCondImpl.setCustomCond(StringHelper.format("1<>1"));
			deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);
		} else {
			StringBuilderEx sBuilderEx = new StringBuilderEx();
			boolean bFirst = true;
			for (int i = 0; i < condList.size(); i++) {
				if(StringHelper.isNullOrEmpty(condList.get(i)))
					continue;
				if(bFirst){
					bFirst = false;
				}
				else{
					sBuilderEx.append(" OR ");
				}
				sBuilderEx.append(condList.get(i));
			}

			boolean bJoinOrg = true;
			boolean bJoinOrgSector = true;
			String strCode = sBuilderEx.toString();

			/**
			 * by : hebao
			 * 
			 * 业务条线使用的是部门中的数据，优化后会导致无法获取到条线代码，后面考虑在具体实现处进行优化
			 */

			/*
			 * String strCode2 = strCode.toLowerCase(); if(strCode2.indexOf("o1.levelcode")==-1) { if(orgIdDEField!=null) { if(StringHelper.compare(orgIdDEField.getName(), "ORGID", true)==0) { bJoinOrg = false; strCode = strCode.replace("o1.",strOrgIdAlias+"."); } } } if(strCode2.indexOf("o2.levelcode")==-1) { if(secIdDEField!=null) { if(StringHelper.compare(secIdDEField.getName(), "ORGSECTORID", true)==0) { bJoinOrgSector = false; strCode = strCode.replace("o2.",strOrgSecIdAlias+"."); } } }
			 */

			sBuilderEx.reset();
			if (bJoinOrg && orgIdDEField != null) {
				sBuilderEx.append(" INNER JOIN T_SRFORG o1  ON  ${srfdefieldexp('%1$s')} = o1.ORGID ", orgIdDEField.getName());
			}
			if (bJoinOrgSector && secIdDEField != null) {
				sBuilderEx.append(" INNER JOIN T_SRFORGSECTOR o2  ON ${srfdefieldexp('%1$s')} = o2.ORGSECTORID ", secIdDEField.getName());
			}

			String strJoinCode = deDataSetFetchContextImpl.getJoinScript();
			if (!StringHelper.isNullOrEmpty(strJoinCode)) {
				if(strJoinCode.indexOf(sBuilderEx.toString())==-1) //判断代码中是否已经连接
					strJoinCode += sBuilderEx.toString();
			} else {
				strJoinCode = sBuilderEx.toString();
			}
			deDataSetFetchContextImpl.setJoinScript(strJoinCode);

			// 有权限，但是没有任何约束
			if(!StringHelper.isNullOrEmpty(strCode)){
				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
				deDataSetCondImpl.setCustomCond(strCode);
				deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);
			}
		}
	}

	/**
	 * 获取获取数据信息
	 * 
	 * @return the strFetchInfo
	 */
	public String getFetchInfo() {
		return strFetchInfo;
	}

	/**
	 * 设置获取数据信息
	 * 
	 * @param strFetchInfo the strFetchInfo to set
	 */
	public void setFetchInfo(String strFetchInfo) {
		this.strFetchInfo = strFetchInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetFetchContext#isCacheDataSet()
	 */
	@Override
	public boolean isCacheDataSet() {
		return bCacheDataSet;
	}

	/**
	 * 设置是否缓存结果集合
	 * 
	 * @param bCacheDataSet
	 */
	public void setCacheDataSet(boolean bCacheDataSet) {
		this.bCacheDataSet = bCacheDataSet;
	}

	/**
	 * 设置默认分页大小
	 * 
	 * @param nDefaultPageSize
	 */
	public void setDefaultPageSize(int nDefaultPageSize) {
		this.nDefaultPageSize = nDefaultPageSize;
	}

	/**
	 * 获取默认分页大小
	 * 
	 * @return
	 */
	public int getDefaultPageSize() {
		return this.nDefaultPageSize;
	}

	/**
	 * 设置连接的语句
	 * 
	 * @param strMode
	 * @param strJoinScript
	 */
	public void setJoinScript(String strMode, String strJoinScript) {
		if (StringHelper.isNullOrEmpty(strJoinScript)) {
			if (this.joinScriptMap == null) return;
			this.joinScriptMap.remove(strMode);
		} else {
			if (this.joinScriptMap == null) this.joinScriptMap = new HashMap<String, String>();
			this.joinScriptMap.put(strMode, strJoinScript);
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetFetchContext#isPaging()
	 */
	@Override
	public boolean isPaging() {
		return this.bPaging;
	}
	
	
	/**
	 * 设置是否进行分页查询
	 * @param bPaging
	 */
	public void setPaging(boolean bPaging){
		this.bPaging  = bPaging;
	}
	
	/**
	 * 导出到JSON对象
	 * @param iDEDataSetFetchContext
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IDEDataSetFetchContext iDEDataSetFetchContext,JSONObject jsonObject) throws Exception {
		if(jsonObject==null){
			jsonObject = new JSONObject();
		}
		
		if(iDEDataSetFetchContext.getStartRow()>=0){
			JSONObjectHelper.put(jsonObject, ATTR_START, iDEDataSetFetchContext.getStartRow());
		}
		
		if(iDEDataSetFetchContext.getPageSize()>0){
			JSONObjectHelper.put(jsonObject, ATTR_SIZE, iDEDataSetFetchContext.getPageSize());
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort())){
			JSONObjectHelper.put(jsonObject, ATTR_SORT, iDEDataSetFetchContext.getSort());
			if(!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSortDir())){
				JSONObjectHelper.put(jsonObject, ATTR_SORTDIR, iDEDataSetFetchContext.getSortDir());
			}
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort2())){
			JSONObjectHelper.put(jsonObject, ATTR_SORT2, iDEDataSetFetchContext.getSort2());
			if(!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getSort2Dir())){
				JSONObjectHelper.put(jsonObject, ATTR_SORT2DIR, iDEDataSetFetchContext.getSort2Dir());
			}
		}
		
		if(iDEDataSetFetchContext.getActiveDataObject()!=null){
			jsonObject.put(ATTR_ACTIVEDATA, DataObject.toJSONObject((IDataObject)iDEDataSetFetchContext.getActiveDataObject(), false));
		}
		
		if(!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getJoinScript())){
			JSONObjectHelper.put(jsonObject, ATTR_JOINSCRIPT, iDEDataSetFetchContext.getJoinScript());
		}
		
		if(iDEDataSetFetchContext.getGroupTopCount()>=0){
			JSONObjectHelper.put(jsonObject, ATTR_GROUPTOP, iDEDataSetFetchContext.getGroupTopCount());
		}
		
		JSONObjectHelper.put(jsonObject, ATTR_FETCHDATA, iDEDataSetFetchContext.isFetchData());
		JSONObjectHelper.put(jsonObject, ATTR_FETCHTOTAL, iDEDataSetFetchContext.isFetchTotalRow());
		if(!StringHelper.isNullOrEmpty(iDEDataSetFetchContext.getFetchInfo())){
			JSONObjectHelper.put(jsonObject, ATTR_FETCHINFO, iDEDataSetFetchContext.getFetchInfo());
		}
		JSONObjectHelper.put(jsonObject, ATTR_CACHE, iDEDataSetFetchContext.isCacheDataSet());
		JSONObjectHelper.put(jsonObject, ATTR_PAGING, iDEDataSetFetchContext.isPaging());
		
		ArrayList<IDEDataSetCond> deDataSetCondList = iDEDataSetFetchContext.getConditionList();
		if(deDataSetCondList!=null && deDataSetCondList.size()>0){
			ArrayList<JSONObject> joList = new ArrayList<JSONObject>();
			for(IDEDataSetCond iDEDataSetCond:deDataSetCondList){
				joList.add(DEDataSetCond.toJSONObject(iDEDataSetCond, null));
			}
			jsonObject.put(ATTR_CONDS, JSONArray.fromCollection(joList));
		}
		
		
		return jsonObject;
	}
	
	/**
	 * 从JSON对象中构建
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static IDEDataSetFetchContext fromJSONObject(JSONObject jsonObject) throws Exception {
		DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext();
	
		int nStartRow = jsonObject.optInt(ATTR_START,-1);
		if(nStartRow>=0){
			deDataSetFetchContext.setStartRow(nStartRow);
		}
			
		
		int nPageSize = jsonObject.optInt(ATTR_SIZE,-1);
		if(nPageSize>0){
			deDataSetFetchContext.setPageSize(nPageSize);
		}
			
		
		String strSort = jsonObject.optString(ATTR_SORT,null);
		if(!StringHelper.isNullOrEmpty(strSort)){
			deDataSetFetchContext.setSort(strSort);
			String strSortDir = jsonObject.optString(ATTR_SORTDIR,null);
			if(!StringHelper.isNullOrEmpty(strSortDir)){
				deDataSetFetchContext.setSortDir(strSortDir);
			}
		}
		
		String strSort2 = jsonObject.optString(ATTR_SORT2,null);
		if(!StringHelper.isNullOrEmpty(strSort2)){
			deDataSetFetchContext.setSort2(strSort2);
			String strSort2Dir = jsonObject.optString(ATTR_SORT2DIR,null);
			if(!StringHelper.isNullOrEmpty(strSort2Dir)){
				deDataSetFetchContext.setSort2Dir(strSort2Dir);
			}
		}
		
		JSONObject activeDataJO = jsonObject.optJSONObject(ATTR_ACTIVEDATA);
		if(activeDataJO!=null){
			deDataSetFetchContext.setActiveDataObject(DataObject.fromJSONObject(activeDataJO));
		}
		
		String strJoinScript = jsonObject.optString(ATTR_JOINSCRIPT,null);
		if(!StringHelper.isNullOrEmpty(strJoinScript)){
			deDataSetFetchContext.setJoinScript(strJoinScript);
		}

		int nGroupTop = jsonObject.optInt(ATTR_GROUPTOP,-1);
		if(nGroupTop>=0){
			deDataSetFetchContext.setGroupTopCount(nGroupTop);
		}
	
		deDataSetFetchContext.setFetchData(jsonObject.optBoolean(ATTR_FETCHDATA, true));
		deDataSetFetchContext.setFetchTotalRow(jsonObject.optBoolean(ATTR_FETCHTOTAL, true));
		
		String strFetchInfo = jsonObject.optString(ATTR_FETCHINFO,null);
		if(!StringHelper.isNullOrEmpty(strFetchInfo)){
			deDataSetFetchContext.setFetchInfo(strFetchInfo);
		}
		deDataSetFetchContext.setCacheDataSet(jsonObject.optBoolean(ATTR_CACHE, true));
		deDataSetFetchContext.setPaging(jsonObject.optBoolean(ATTR_PAGING, true));
		
		JSONArray condJA = jsonObject.optJSONArray(ATTR_CONDS);
		if(condJA!=null){
			for(int i =0;i<condJA.length();i++){
				JSONObject jo = condJA.getJSONObject(i);
				IDEDataSetCond iDEDataSetCond  = DEDataSetCond.fromJSONObject(jo);
				deDataSetFetchContext.getConditionList().add(iDEDataSetCond);
			}
		}
			
		
		
		return deDataSetFetchContext;
	}
	
}
