package net.ibizsys.paas.db;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

/**
 * 数据查询上下文条件2接口实现
 * @author Administrator
 *
 */
public class SelectContext2 extends SelectContext implements ISelectContext2 {

	public final static String ATTR_PAGING = "paging";
	public final static String ATTR_START = "start";
	public final static String ATTR_SIZE = "size";
	
	
	private int nStartRow = 0;
	private int nPageSize = -1;
	private boolean bPaging = false;
	private int nDefaultPageSize = 25;
	
	
	/**
	 * 导出到JSON对象
	 * @param iSelectContext
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(ISelectContext2 iSelectContext2,JSONObject jsonObject) throws Exception {
		if(jsonObject==null){
			jsonObject = new JSONObject();
		}
		
		if(iSelectContext2.isPaging()) {
			JSONObjectHelper.put(jsonObject, ATTR_PAGING, iSelectContext2.isPaging());

			if(iSelectContext2.getStartRow()>=0){
				JSONObjectHelper.put(jsonObject, ATTR_START, iSelectContext2.getStartRow());
			}
			if(iSelectContext2.getPageSize()>0){
				JSONObjectHelper.put(jsonObject, ATTR_SIZE, iSelectContext2.getPageSize());
			}
		}
		
		return SelectContext.toJSONObject(iSelectContext2, jsonObject);
	}
	
	
	
	/**
	 * 从JSON对象中构造选择上下文对象2
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static ISelectContext2 fromJSONObject(JSONObject jsonObject) throws Exception {
		SelectContext2 selectContext2 = new SelectContext2();
		fromJSONObject(jsonObject,selectContext2);
		return selectContext2;
	}
	
	/**
	 * 从JSON对象中构造选择上下文对象2
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static ISelectContext2 fromJSONObject(JSONObject jsonObject,SelectContext2 selectContext2) throws Exception {
		
		selectContext2.setPaging(jsonObject.optBoolean(ATTR_PAGING, false));
		if(selectContext2.isPaging()) {
			int nStartRow = jsonObject.optInt(ATTR_START,-1);
			if(nStartRow>=0){
				selectContext2.setStartRow(nStartRow);
			}
				
			int nPageSize = jsonObject.optInt(ATTR_SIZE,-1);
			if(nPageSize>0){
				selectContext2.setPageSize(nPageSize);
			}
		}
		
		SelectContext.fromJSONObject(jsonObject, selectContext2);
		return selectContext2;
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.ISelectContext2#getStartRow()
	 */
	@Override
	public int getStartRow() {
		return nStartRow;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.ISelectContext2#getPageSize()
	 */
	@Override
	public int getPageSize() {
		if (this.nPageSize <= 0) return this.getDefaultPageSize();
		return nPageSize;
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

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.db.ISelectContext2#isPaging()
	 */
	@Override
	public boolean isPaging() {
		return this.bPaging && !this.isFetchFirst();
	}
	
	
	/**
	 * 设置是否进行分页查询
	 * @param bPaging
	 */
	public void setPaging(boolean bPaging){
		this.bPaging  = bPaging;
	}
}
