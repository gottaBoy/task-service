package net.ibizsys.paas.control.grid;

/**
 * 表格行处理异常对象
 * 
 * @author lionlau
 *
 */
public class GridRowException extends Exception {
	private GridRowError gridRowError = null;

	public GridRowException(GridRowError gridRowError) {
		super();
		this.gridRowError = gridRowError;

	}

	/**
	 * 获取表格行错误对象
	 * 
	 * @return
	 */
	public GridRowError getGridRowError() {
		return this.gridRowError;
	}
}
