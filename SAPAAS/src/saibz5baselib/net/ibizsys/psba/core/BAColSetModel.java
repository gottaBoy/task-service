package net.ibizsys.psba.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.util.StringHelper;

/**
 * 大数据表列族模型对象
 * 
 * @author Administrator
 *
 */
public class BAColSetModel extends BATableObjectModelBase implements IBAColSetModel {

	private ArrayList<IBAColumn> baColumnList = new ArrayList<IBAColumn>();
	private HashMap<String, IBAColumn> baColumnMap = new HashMap<String, IBAColumn>();
	
	/**
	 * 初始化
	 * 
	 * @param iBATable
	 * @throws Exception
	 */
	public void init(IBATable iBATable) throws Exception {
		this.setBATable(iBATable);
		this.onInit();
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBAColSetModel#registerBAColumn(net.ibizsys.psba.core.IBAColumn)
	 */
	@Override
	public void registerBAColumn(IBAColumn iBAColumn)  throws Exception {
		this.baColumnList.add(iBAColumn);
		this.baColumnMap.put(iBAColumn.getId(), iBAColumn);
		this.baColumnMap.put(iBAColumn.getName(), iBAColumn);
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBAColSet#getBAColumn(java.lang.String)
	 */
	@Override
	public IBAColumn getBAColumn(String strBAColumnName) throws Exception {
		IBAColumn iBAColumn = baColumnMap.get(strBAColumnName);
		if (iBAColumn == null) {
			throw new Exception(StringHelper.format("无法获取大数据表列[%1$s]", strBAColumnName));
		}
		return iBAColumn;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBAColSet#getBAColumns()
	 */
	@Override
	public Iterator<IBAColumn> getBAColumns() {
		if (this.baColumnList == null || this.baColumnList.size() == 0) return null;
		return this.baColumnList.iterator();
	}
}
