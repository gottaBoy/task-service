package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.demodel.IDEDataSetModel;

/**
 * 动态实体数据集查询对象模型
 * @author Administrator
 *
 */
public class DynaDEDataSetQueryModel  implements IDEDataSetQuery {

	private IPSDEDataQuery iPSDEDataQuery = null;
	public void init(IDEDataSetModel iDEDataSetModel,  IPSDEDataQuery iPSDEDataQuery)throws Exception{
		this.iPSDEDataQuery = iPSDEDataQuery;
	}
	
	@Override
	public String getDEDataQueryId() {
		return this.iPSDEDataQuery.getId();
	}
	
}
