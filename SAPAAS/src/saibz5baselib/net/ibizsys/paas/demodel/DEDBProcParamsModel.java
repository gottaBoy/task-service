package net.ibizsys.paas.demodel;

import java.util.ArrayList;

import net.ibizsys.paas.core.DBProcParam;
import net.ibizsys.paas.core.DBProcParams;
import net.ibizsys.paas.db.IProcParam;

/**
 * 实体数据库过程参数集合模型
 * 
 * @author Administrator
 *
 */
public class DEDBProcParamsModel {
	protected DBProcParams dbProcParams = null;
	protected ArrayList<IProcParam> procParamList = new ArrayList<IProcParam>();

	public DEDBProcParamsModel() {

	}

	public void init(DBProcParams dbProcParams) {
		this.dbProcParams = dbProcParams;

		for (DBProcParam dbProcParam : this.dbProcParams.value()) {
			IProcParam iProcParam = createProcParam(dbProcParam);
			procParamList.add(iProcParam);
		}
	}

	protected IProcParam createProcParam(DBProcParam dbProcParam) {
		DEDBProcParamModel dbDBProcParamModel = new DEDBProcParamModel();
		dbDBProcParamModel.init(dbProcParam);
		return dbDBProcParamModel;
	}

	public String getDBType() {
		return dbProcParams.dbtype();
	}

	public java.util.Iterator<IProcParam> getProcParams() {
		return this.procParamList.iterator();
	}
}
