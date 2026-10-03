package net.ibizsys.paas.db;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 数据查询操作上下文对象
 * 
 * @author Administrator
 *
 */
public class SelectContext extends SelectCond implements ISelectContext {

	public final static String ATTR_SELECTFIELDS = "fields";
	public final static String ATTR_DEDATAQUERYNAME = "dedqname";
	public final static String ATTR_VIEWLEVEL = "viewlevel";
	public final static String ATTR_SORT = "sort";
	public final static String ATTR_SORTDIR = "sortdir";

	
	
	private ArrayList<ISelectField> selectFieldList = null;
	private String strDEDataQueryName = null;
	private IWebContext iWebContext = null;
	private int nViewLevel = IDataEntity.VIEWLEVEL_DEFAULT;
	private String strSort = null;
	private String strSortDir = null;

	

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.ISelectContext#getSelectFields()
	 */
	@Override
	public Iterator<ISelectField> getSelectFields() {
		if (selectFieldList == null) return null;
		return selectFieldList.iterator();
	}

	/**
	 * 增加查询字段
	 * 
	 * @param iSelectField
	 */
	public void addSelectField(ISelectField iSelectField) {
		if (selectFieldList == null) {
			selectFieldList = new ArrayList<ISelectField>();
		}
		selectFieldList.add(iSelectField);
	}
	
	
	
	/**
	 * 创建选择字段对象
	 * @param strName
	 * @return
	 */
	public void addSelectField(String strName){
		this.addSelectField(SelectField.create(strName));
	}
	
	
	/**
	 * 创建选择字段对象
	 * @param strName
	 * @param strAlias 
	 * @return
	 */
	public void addSelectField(String strName,String strAlias){
		this.addSelectField(SelectField.create(strName,strAlias));
	}
	
	
	/**
	 * 创建选择字段对象
	 * @param strName
	 * @param strAlias 
	 * @param strFunc
	 * @return
	 */
	public void addSelectField(String strName,String strAlias,String strFunc){
		this.addSelectField(SelectField.create(strName,strAlias,strFunc));
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.ISelectContext#getDEDataQueryName()
	 */
	@Override
	public String getDEDataQueryName() {
		return this.strDEDataQueryName;
	}
	
	/**
	 * 设置实体数据查询名称
	 * @param strDEDataQueryName
	 */
	public void setDEDataQueryName(String strDEDataQueryName){
		this.strDEDataQueryName = strDEDataQueryName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.ISelectContext#getWebContext()
	 */
	@Override
	public IWebContext getWebContext() {
		if(iWebContext == null)
			return WebContext.getCurrent();
		return null;
	}

	
	/**
	 * 设置网络访问上下文
	 * @param iWebContext
	 */
	public void setWebContext(IWebContext iWebContext){
		this.iWebContext = iWebContext;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.ISelectContext#getViewLevel()
	 */
	@Override
	public int getViewLevel() {
		return nViewLevel;
	}

	/**
	 * 设置查询的视图级别
	 * @param nViewLevel
	 */
	protected void setViewLevel(int nViewLevel) {
		this.nViewLevel = nViewLevel;
	}
	
		
	@Override
	protected void onReset() {
		this.selectFieldList = null;
		this.strDEDataQueryName = null;
		this.iWebContext = null;
		this.nViewLevel = IDataEntity.VIEWLEVEL_DEFAULT;
		this.strSort = null;
		this.strSortDir = null;	
		super.onReset();
	}
	
	
	
	/**
	 * 导出到JSON对象
	 * @param iSelectContext
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(ISelectContext iSelectContext,JSONObject jsonObject) throws Exception {
		if(jsonObject==null){
			jsonObject = new JSONObject();
		}
		
		java.util.Iterator<ISelectField> selectFields = iSelectContext.getSelectFields();
		if(selectFields!=null){
			ArrayList<JSONObject> joList = new ArrayList<JSONObject>();
			while(selectFields.hasNext()){
				ISelectField iSelectField = selectFields.next();
				joList.add(SelectField.toJSONObject(iSelectField));
			}
			JSONObjectHelper.put(jsonObject, ATTR_SELECTFIELDS,JSONArray.fromCollection(joList));
		}
		
		if(iSelectContext.getDEDataQueryName()!=null){
			JSONObjectHelper.put(jsonObject, ATTR_DEDATAQUERYNAME,iSelectContext.getDEDataQueryName());
		}
		JSONObjectHelper.put(jsonObject, ATTR_VIEWLEVEL,iSelectContext.getViewLevel());
		
		if(!StringHelper.isNullOrEmpty(iSelectContext.getSort())){
			JSONObjectHelper.put(jsonObject, ATTR_SORT,iSelectContext.getSort());
		}
		
		if(!StringHelper.isNullOrEmpty(iSelectContext.getSortDir())){
			JSONObjectHelper.put(jsonObject, ATTR_SORTDIR,iSelectContext.getSortDir());
		}
		
	
		//进一步导出
		SelectCond.toJSONObject(iSelectContext, jsonObject);
		
		
		
		return jsonObject;
	}
	
	
	/**
	 * 从JSON对象中构造选择上下文对象
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static ISelectContext fromJSONObject(JSONObject jsonObject) throws Exception {
		SelectContext selectContext = new SelectContext();
		fromJSONObject(jsonObject,selectContext);
		return selectContext;
	}
	
	/**
	 * 从JSON对象中构造选择上下文对象
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static ISelectContext fromJSONObject(JSONObject jsonObject,SelectContext selectContext) throws Exception {
		
		JSONArray selectFields = jsonObject.optJSONArray(ATTR_SELECTFIELDS);
		if(selectFields!=null){
			for(int i = 0;i<selectFields.length();i++){
				selectContext.addSelectField(SelectField.fromJSONObject(selectFields.getJSONObject(i)));
			}
		}
		
		selectContext.setDEDataQueryName(jsonObject.optString(ATTR_DEDATAQUERYNAME));
		selectContext.setViewLevel(jsonObject.optInt(ATTR_VIEWLEVEL,selectContext.getViewLevel()));
		selectContext.setSort(jsonObject.optString(ATTR_SORT));
		selectContext.setSortDir(jsonObject.optString(ATTR_SORTDIR));
		
		SelectCond.fromJSONObject(jsonObject, selectContext);
		
		return selectContext;
	}

	@Override
	public String getSort() {
		return this.strSort;
	}

	@Override
	public String getSortDir() {
		return this.strSortDir;
	}

	/**
	 * 设置排序属性
	 * @param strSort
	 */
	public void setSort(String strSort) {
		this.strSort = strSort;
	}

	/**
	 * 设置排序方向
	 * @param strSortDir
	 */
	public void setSortDir(String strSortDir) {
		this.strSortDir = strSortDir;
	}
	
	
	@Override
	public String getOrderInfo() {
		String strOrderInfo =  super.getOrderInfo();
		if(StringHelper.isNullOrEmpty(strOrderInfo)){
			if(!StringHelper.isNullOrEmpty(this.getSort()))
				return StringHelper.format("ORDER BY %1$s %2$s",this.getSort(),(this.getSortDir()==null)?"":this.getSortDir());
		}
		return strOrderInfo;
	}
	
	
	
	
}
