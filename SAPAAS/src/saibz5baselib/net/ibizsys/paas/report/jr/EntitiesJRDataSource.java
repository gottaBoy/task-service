package net.ibizsys.paas.report.jr;

import java.util.ArrayList;

import net.ibizsys.paas.entity.IEntity;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * 报表数据源对象 （数据对象列表）
 * 
 * @author Administrator
 *
 */
public class EntitiesJRDataSource implements JRDataSource {
	private ArrayList<IEntity> entityList = null;
	private int nCurIndex = -1;
	private int nColumnCount = -1;
	private int nMaxRowCount = -1;

	public EntitiesJRDataSource(ArrayList<IEntity> entityList) {
		this.entityList = entityList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.jasperreports.engine.JRDataSource#getFieldValue(net.sf.jasperreports.engine.JRField)
	 */
	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		try {
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
					int nRowCount = this.entityList.size() / getColumnCount();
					if (this.entityList.size() % getColumnCount() != 0) {
						nRowCount += 1;
					}
					nRealIndex = nColumnIndex * nRowCount + nCurIndex;
				}

				if (nRealIndex >= this.entityList.size())
					return null;
				else
					return this.entityList.get(nRealIndex).get(strFieldName);
			} else {
				return this.entityList.get(nCurIndex).get(arg0.getName());
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
	@Override
	public boolean next() throws JRException {
		if (this.entityList == null) return false;

		nCurIndex++;
		if (getColumnCount() > 0) {
			if (getMaxRowCount() > 0) {
				if (nCurIndex >= this.entityList.size()) return false;

				if (nCurIndex >= getMaxRowCount()) return false;

				return true;
			} else {
				// 自动计算行数
				int nRowCount = this.entityList.size() / getColumnCount();
				if (this.entityList.size() % getColumnCount() != 0) {
					nRowCount += 1;
				}

				if (nCurIndex >= nRowCount) return false;

				return true;
			}
		} else {
			if (nCurIndex >= this.entityList.size())
				return false;
			else
				return true;
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
