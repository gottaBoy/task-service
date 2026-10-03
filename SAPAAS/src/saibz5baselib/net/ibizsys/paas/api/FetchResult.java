package net.ibizsys.paas.api;

import java.util.ArrayList;

import net.ibizsys.paas.db.IDataRow;

/**
 * 获取数据结果对象
 * @author Administrator
 *
 */
public class FetchResult {

	private int nTotalRow = -1; 
	private ArrayList<IDataRow> items = new ArrayList<IDataRow>();
	
	
	
	/**
	 * 获取全部行数
	 * @return
	 */
	public int getTotalRow(){
		return this.nTotalRow;
	}
	
	
	/**
	 * 设置全部行数
	 * @param nTotalRow
	 */
	public void setTotalRow(int nTotalRow){
		this.nTotalRow = nTotalRow;
	}
	
	
	/**
	 * 获取数据项集合
	 * @return
	 */
	public ArrayList<IDataRow> getDataRows(){
		return this.items;
	}
	
}
