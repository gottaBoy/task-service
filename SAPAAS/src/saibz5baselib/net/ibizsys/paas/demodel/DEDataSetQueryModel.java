package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.core.IDEDataSetQuery;

/**
 * 数据集合查询模型对象
 * 
 * @author Administrator
 *
 */
public class DEDataSetQueryModel implements IDEDataSetQuery {
	private DEDataSetQuery deDataSetQuery = null;

	public DEDataSetQueryModel(DEDataSetQuery deDataSetQuery) {
		this.deDataSetQuery = deDataSetQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSetQuery#getDEDataQueryId()
	 */
	@Override
	public String getDEDataQueryId() {
		return this.deDataSetQuery.queryid();
	}

}
