package net.ibizsys.paas.db;


/**
 * 数据查询结果对象
 * 
 * @author Administrator
 *
 */
public class DBFetchResult extends DBCallResult {
	protected int nTotalRow = -1;

	/**
	 * 设置总记录数
	 * 
	 * @param nTotalRow
	 */
	public void setTotalRow(int nTotalRow) {
		this.nTotalRow = nTotalRow;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getTotalRow() {
		return this.nTotalRow;
	}
	
	
	/**
	 * 从DB结果建立
	 * 
	 * @param result
	 */
	public void from(DBFetchResult result) {
		this.setTotalRow(result.getTotalRow());
		super.from(result);
	}
}
