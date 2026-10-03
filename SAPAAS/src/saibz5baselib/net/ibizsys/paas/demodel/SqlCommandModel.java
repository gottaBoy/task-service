package net.ibizsys.paas.demodel;

import java.util.Iterator;

import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.db.ProcParamList;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

/**
 * 数据库命令模型对象
 * 
 * @author Administrator
 *
 */
public class SqlCommandModel implements ISqlCommandModel {
	protected String strSql = "";
	protected ProcParamList procParamList = new ProcParamList();

	protected IDBDialect iDBDialect = null;

	protected IDataEntityModel iDataEntityModel = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.ISqlCommand#getSql()
	 */
	@Override
	public String getSql() {
		return strSql;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.db.ISqlCommand#getProcParams()
	 */
	@Override
	public Iterator<IProcParam> getProcParams() {
		return procParamList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.ISqlCommandModel#fillSqlParams(net.ibizsys.paas.entity.IEntity, net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.db.SqlParamList)
	 */
	@Override
	public void fillSqlParams(IEntity iEntity, IWebContext iWebContext, SqlParamList sqlParamList) throws Exception {
		Iterator<IProcParam> procParams = getProcParams();
		while (procParams.hasNext()) {
			IProcParam procParam = procParams.next();

			SqlParam callParam = getProcSqlParam(procParam, iEntity, iWebContext);
			if (callParam == null){
				callParam = new SqlParam();
			}
			sqlParamList.add(callParam);
		}
	}

	/**
	 * 获取过程命令参数
	 * 
	 * @param procParam
	 * @param iEntity
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	protected SqlParam getProcSqlParam(IProcParam procParam, IEntity iEntity, IWebContext iWebContext) throws Exception {
		return DEDBProcModelBase.getProcSqlParam(procParam, iEntity, iWebContext, this.getDataEntityModel());
	}

	/**
	 * @param strSql the strSql to set
	 */
	public void setSql(String strSql) {
		this.strSql = strSql;
	}

	/**
	 * @param procParamList the procParamList to set
	 */
	public void setProcParamList(ProcParamList procParamList) {
		this.procParamList = procParamList;
	}

	/**
	 * @return the iDBDialect
	 */
	public IDBDialect getDBDialect() {
		return iDBDialect;
	}

	/**
	 * @param iDBDialect the iDBDialect to set
	 */
	public void setDBDialect(IDBDialect iDBDialect) {
		this.iDBDialect = iDBDialect;
	}

	/**
	 * @return the iDataEntityModel
	 */
	public IDataEntityModel getDataEntityModel() {
		return iDataEntityModel;
	}

	/**
	 * @param iDataEntityModel the iDataEntityModel to set
	 */
	public void setDataEntityModel(IDataEntityModel iDataEntityModel) {
		this.iDataEntityModel = iDataEntityModel;
	}

}
