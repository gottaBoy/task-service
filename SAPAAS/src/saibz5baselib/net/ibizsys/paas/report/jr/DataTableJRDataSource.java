package net.ibizsys.paas.report.jr;

import net.ibizsys.paas.db.IDataTable;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * 报表数据源对象（数据表）
 * 
 * @author Administrator
 * 
 */
public class DataTableJRDataSource implements JRDataSource {
	private IDataTable dataTable = null;
	private int nCurIndex = -1;
	private int nColumnCount = -1;
	private int nMaxRowCount = -1;
	private int nRowIndex = -1;
	private boolean bRowCacheMode = false;

	public DataTableJRDataSource(IDataTable dataTable) {
		this.dataTable = dataTable;
		this.bRowCacheMode = (this.dataTable.getCachedRowCount() != -1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.jasperreports.engine.JRDataSource#getFieldValue(net.sf.jasperreports .engine.JRField)
	 */
	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		try {
			if (this.bRowCacheMode) {
				if (getColumnCount() > 0) {
					int nColumnIndex = 0;
					// 判断列名称是否有列表时
					String strFieldName = arg0.getName();
					if (strFieldName.indexOf("_SRF") == 0) {
						// 虚拟列
						strFieldName = strFieldName.substring(4);
						int nPos = strFieldName.indexOf("_");
						if (nPos != -1) {
							String strIndex = strFieldName.substring(0, nPos);
							strFieldName = strFieldName.substring(nPos + 1);
							nColumnIndex = Integer.parseInt(strIndex);
							nColumnIndex--;
						}
					}

					int nRealIndex = -1;
					if (getMaxRowCount() > 0) {
						nRealIndex = nColumnIndex * getMaxRowCount() + nCurIndex;
					} else {
						int nRowCount = this.dataTable.getCachedRowCount() / getColumnCount();
						if (this.dataTable.getCachedRowCount() % getColumnCount() != 0) {
							nRowCount += 1;
						}
						nRealIndex = nColumnIndex * nRowCount + nCurIndex;
					}

					if (nRealIndex >= this.dataTable.getCachedRowCount())
						return null;
					else
						return this.dataTable.getCachedRow(nRealIndex).get(strFieldName);
				} else {
					return this.dataTable.getCachedRow(nCurIndex).get(arg0.getName());
				}
			} else {
				if (getColumnCount() > 0) {
					int nColumnIndex = 0;
					// 判断列名称是否有列表时
					String strFieldName = arg0.getName();
					if (strFieldName.indexOf("_SRF") == 0) {
						// 虚拟列
						strFieldName = strFieldName.substring(4);
						int nPos = strFieldName.indexOf("_");
						if (nPos != -1) {
							String strIndex = strFieldName.substring(0, nPos);
							strFieldName = strFieldName.substring(nPos + 1);
							nColumnIndex = Integer.parseInt(strIndex);
							nColumnIndex--;
						}
					}

					if (nColumnIndex >= this.dataTable.getCachedRowCount())
						return null;
					else
						return this.dataTable.getCachedRow(nColumnIndex).get(strFieldName);
				} else {
					return this.dataTable.getCachedRow(0).get(arg0.getName());
				}
			}

		} catch (Exception e) {
			throw new JRException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.jasperreports.engine.JRDataSource#next()
	 */
	public boolean next() throws JRException {
		if (this.dataTable == null) return false;
		try {
			if (this.bRowCacheMode) {
				nCurIndex++;
				if (getColumnCount() > 0) {
					// 多列展开
					if (getMaxRowCount() > 0) {
						if (nCurIndex >= this.dataTable.getCachedRowCount()) return false;

						if (nCurIndex >= getMaxRowCount()) return false;

						return true;
					} else {
						// 自动计算行数
						int nRowCount = this.dataTable.getCachedRowCount() / getColumnCount();
						if (this.dataTable.getCachedRowCount() % getColumnCount() != 0) {
							nRowCount += 1;
						}

						if (nCurIndex >= nRowCount) return false;

						return true;
					}
				} else {
					if (nCurIndex >= this.dataTable.getCachedRowCount())
						return false;
					else
						return true;
				}
			} else {

				nRowIndex++;
				if (getMaxRowCount() > 0) {
					if (nRowIndex >= getMaxRowCount()) return false;
				}
				if (getColumnCount() > 0) {
					int nRowCacheCount = this.dataTable.cacheRows(getColumnCount());
					return nRowCacheCount > 0;
				} else {
					// 缓存一行
					int nRowCacheCount = this.dataTable.cacheRows(1);
					return nRowCacheCount > 0;
				}

			}
		} catch (Exception e) {
			throw new JRException(e);
		}
	}

	/**
	 * 获取数据的分区列显示数量
	 * 
	 * @return the nColumnCount
	 */
	public int getColumnCount() {
		return nColumnCount;
	}

	/**
	 * 获取数据的最大行记录数
	 * 
	 * @return the nMaxRowCount
	 */
	public int getMaxRowCount() {
		return nMaxRowCount;
	}

	/**
	 * 设置数据的分区列显示数量
	 * 
	 * @param nColumnCount the nColumnCount to set
	 */
	public void setColumnCount(int nColumnCount) {
		this.nColumnCount = nColumnCount;
	}

	/**
	 * 设置数据的最大行记录数
	 * 
	 * @param nMaxRowCount the nMaxRowCount to set
	 */
	public void setMaxRowCount(int nMaxRowCount) {
		this.nMaxRowCount = nMaxRowCount;
	}

}
