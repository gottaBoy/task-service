package net.ibizsys.paas.web;

import java.util.ArrayList;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 多数据异步请求结果对象
 * 
 * @author lionlau
 *
 */
public class MDAjaxActionResult extends SDAjaxActionResult {
	protected ArrayList items = new ArrayList();
	protected ArrayList columns = new ArrayList();
	protected int nTotalRow = 0;
	protected String strSearchCondition = "";
	protected String strSummaryInfo = "";
	private int nStartRow = 0;
	private int nPageSize = -1;
	private boolean bArrayMode = false;
	private JSONObject summaryItem = null;

	public MDAjaxActionResult() {

	}

	/**
	 * 获取结果数组
	 * 
	 * @return
	 */
	public ArrayList getRows() {
		return items;
	}

	/**
	 * 获取列集合数组
	 * 
	 * @return
	 */
	public ArrayList getColumns() {
		return this.columns;
	}

	/**
	 * 获取全部行记录数量
	 * 
	 * @return
	 */
	public int getTotalRow() {
		return nTotalRow;
	}

	/**
	 * 设置全部行记录数量
	 * 
	 * @param nTotalRow
	 */
	public void setTotalRow(int nTotalRow) {
		this.nTotalRow = nTotalRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.AjaxActionResult#toJSONString()
	 */
	@Override
	public String toJSONString() {
		if (this.isArrayMode()) {
			return JSONArray.fromArray(items.toArray()).toString();
		}
		return super.toJSONString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.SDAjaxActionResult#fillJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	protected void fillJSONObject(JSONObject objJSON) {
		super.fillJSONObject(objJSON);

		if (this.getRetCode() != Errors.OK) {
			objJSON.put("totalrow", nTotalRow);
			objJSON.put("items", new JSONArray());

			return;
		} else {
			objJSON.put("totalrow", nTotalRow);
			objJSON.put("startrow", nStartRow);
			if (nPageSize > 0) {
				objJSON.put("limit", nPageSize);
			}
			objJSON.put("items", JSONArray.fromArray(items.toArray()));
			if (this.columns.size() > 0) {
				objJSON.put("columns", JSONArray.fromArray(columns.toArray()));
			}
			objJSON.put("summaryinfo", strSummaryInfo);
			if(this.getSummaryItem()!=null) {
				objJSON.put("summaryitem", this.getSummaryItem());
			}
		}
	}

	/**
	 * 获取多项数据概要信息
	 * 
	 * @return the strSummaryInfo
	 */
	public String getSummaryInfo() {
		return strSummaryInfo;
	}

	/**
	 * 设置多项数据概要信息
	 * 
	 * @param strSummaryInfo the strSummaryInfo to set
	 */
	public void setSummaryInfo(String strSummaryInfo) {
		this.strSummaryInfo = strSummaryInfo;
	}

	/**
	 * 获取多项数据概要数据项
	 * @param bCreateIf 不存在则建立
	 * @return the summaryItem
	 */
	public JSONObject getSummaryItem(boolean bCreateIf) {
		if(this.summaryItem == null && bCreateIf) {
			this.summaryItem = new JSONObject();
		}
		return this.summaryItem;
	}
	
	
	/**
	 * 获取多项数据概要数据项
	 * 
	 * @return the summaryItem
	 */
	public JSONObject getSummaryItem() {
		return summaryItem;
	}

	/**
	 * 设置多项数据概要数据项
	 * 
	 * @param summaryItem the summaryItem to set
	 */
	public void setSummaryItem(JSONObject summaryItem) {
		this.summaryItem = summaryItem;
	}
	
	
	
	/**
	 * 获取起始行号
	 * 
	 * @return the nStartRow
	 */
	public int getStartRow() {
		return nStartRow;
	}

	/**
	 * 设置起始行号
	 * 
	 * @param nStartRow the nStartRow to set
	 */
	public void setStartRow(int nStartRow) {
		this.nStartRow = nStartRow;
	}

	/**
	 * 获取分页记录数
	 * 
	 * @return the nPageSize
	 */
	public int getPageSize() {
		return nPageSize;
	}

	/**
	 * 设置分页记录数
	 * 
	 * @param nPageSize the nPageSize to set
	 */
	public void setPageSize(int nPageSize) {
		this.nPageSize = nPageSize;
	}

	/**
	 * 设置以数组形式输出行记录结果
	 * 
	 * @param bArrayMode
	 */
	public void setArrayMode(boolean bArrayMode) {
		this.bArrayMode = bArrayMode;
	}

	/**
	 * 是否以数组形式输出行记录结果
	 * 
	 * @return
	 */
	public boolean isArrayMode() {
		return this.bArrayMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.AjaxActionResult#fromJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	public void fromJSONObject(JSONObject jo) throws Exception {
		this.nTotalRow = jo.optInt("totalrow", 0);
		JSONObjectHelper.remove(jo, "totalrow");

		JSONArray ja = jo.optJSONArray("items");
		this.items.clear();
		if (ja != null) {
			for (int i = 0; i < ja.length(); i++) {
				this.items.add(ja.get(i));
			}
		}
		JSONObjectHelper.remove(jo, "items");

		this.nStartRow = jo.optInt("startrow", -1);
		JSONObjectHelper.remove(jo, "startrow");

		this.nPageSize = jo.optInt("limit", 0);
		JSONObjectHelper.remove(jo, "limit");

		this.strSummaryInfo = jo.optString("summaryinfo", null);
		JSONObjectHelper.remove(jo, "summaryinfo");
		
		this.summaryItem = jo.optJSONObject("summaryitem");
		JSONObjectHelper.remove(jo, "summaryitem");

		ja = jo.optJSONArray("columns");

		this.columns.clear();
		if (ja != null) {
			for (int i = 0; i < ja.length(); i++) {
				this.columns.add(ja.get(i));
			}
		}

		JSONObjectHelper.remove(jo, "columns");

		super.fromJSONObject(jo);
	}

}
