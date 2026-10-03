package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

/**
 * 动态实体查询对象模型
 * @author Administrator
 *
 */
public class DynaDEDataQueryModel extends DEDataQueryModelBase {
	private IDynaDEModel iDynaDEModel = null;
	private IPSDEDataQuery iPSDEDataQuery = null;

	public void init(IDynaDEModel iDynaDEModel, IPSDEDataQuery iPSDEDataQuery) throws Exception {
		this.iDynaDEModel = iDynaDEModel;
		this.iPSDEDataQuery = iPSDEDataQuery;

		this.init(iDynaDEModel);

	}

	@Override
	public String getId() {
		return iPSDEDataQuery.getId();
	}

	@Override
	public String getName() {
		return iPSDEDataQuery.getName();
	}
	
	
	
	@Override
	public boolean isDefaultMode() {
		return iPSDEDataQuery.isDefaultMode();
	}

	@Override
	protected void onInit() throws Exception {
		
		java.util.Iterator<IPSDEDataQueryCode> psDEDataQueryCodes  = this.iPSDEDataQuery.getAllPSDEDataQueryCodes();
		while(psDEDataQueryCodes.hasNext()){
			DynaDEDataQueryCodeModel psJITDEDataQueryQueryModel = new DynaDEDataQueryCodeModel(this,psDEDataQueryCodes.next());
			deDataQueryCodeMap.put(psJITDEDataQueryQueryModel.getDBType(), psJITDEDataQueryQueryModel);
		}
		super.onInit();
	}
}
