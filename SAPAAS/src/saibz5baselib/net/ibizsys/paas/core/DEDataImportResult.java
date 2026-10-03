package net.ibizsys.paas.core;

/**
 * 实体数据导入结果对象
 * @author Administrator
 *
 */
public class DEDataImportResult implements IDEDataImportResult {

	private String strRetInfo = null;
	private int nRetCode = Errors.OK;
	private int nRowSN = 0;
	
	@Override
	public String getRetInfo() {
		return this.strRetInfo;
	}

	@Override
	public int getRetCode() {
		return this.nRetCode;
	}

	/**
	 * 设置结果信息
	 * @param strRetInfo
	 */
	public void setRetInfo(String strRetInfo) {
		this.strRetInfo = strRetInfo;
	}

	/**
	 * 设置结果代码
	 * @param nRetCode
	 */
	public void setRetCode(int nRetCode) {
		this.nRetCode = nRetCode;
	}

	@Override
	public int getRowSN() {
		return this.nRowSN;
	}
	
	
	/**
	 * 设置行序号
	 * @param nRowSN
	 */
	public void setRowSN(int nRowSN){
		this.nRowSN = nRowSN;
	}

	
	
}
