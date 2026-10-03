package net.ibizsys.paas.demodel;

import java.util.ArrayList;

import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.impl.SimpleDataSetImpl;
import net.ibizsys.paas.db.impl.SimpleDataTableImpl;

/**
 * 预定义的结果集对象
 * 
 * @author lionlau
 *
 */
public abstract class PredefinedDEDataSetModelBase extends DEDataSetModelBase {
	private ArrayList<IDataRow> dataRowList = new ArrayList<IDataRow>();
	private Boolean bPrepareDataRowList = false;
	private Object objPrepareDataRowList = new Object();

	@Override
	protected void onInit() throws Exception {
		super.onInit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataSetModel#isCustomDS()
	 */
	@Override
	public boolean isCustomDS() {
		return true;
	}

	/**
	 * 准备数据行记录
	 */
	protected void onFillDataRowList(ArrayList<IDataRow> dataRowList) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DEDataSetModelBase#fetchDEDataSet(net.ibizsys.paas.core.IDEDataSetFetchContext)
	 */
	@Override
	public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
		DBFetchResult dbFetchResult = new DBFetchResult();
		SimpleDataSetImpl simpleDataSetImpl = new SimpleDataSetImpl();

		SimpleDataTableImpl simpleDataTableImpl = new SimpleDataTableImpl(simpleDataSetImpl);

		synchronized (objPrepareDataRowList) {
			if (!bPrepareDataRowList) {
				onFillDataRowList(dataRowList);
				bPrepareDataRowList = true;
			}
		}

		for (IDataRow iDataRow : dataRowList) {
			if (this.testAddDataRow(iDEDataSetFetchContext, iDataRow)) simpleDataTableImpl.addCachedRow(iDataRow);
		}
		simpleDataSetImpl.addDataTable(simpleDataTableImpl);
		dbFetchResult.setDataSet(simpleDataSetImpl);
		return dbFetchResult;
	}

	/**
	 * 判断是否加入指定行记录（用于控制输出）
	 * 
	 * @param iDEDataSetFetchContext
	 * @param iDataRow
	 * @return
	 * @throws Exception
	 */
	protected boolean testAddDataRow(IDEDataSetFetchContext iDEDataSetFetchContext, IDataRow iDataRow) throws Exception {
		return true;
	}
}
