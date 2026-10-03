package net.ibizsys.psba.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.dao.BADAOGlobal;
import net.ibizsys.psba.dao.IBADAO;
import net.ibizsys.psba.entity.BAEntity;
import net.ibizsys.psba.entity.IBAEntity;

/**
 * 大数据架构模型
 * 
 * @author Administrator
 *
 */
public abstract class BASchemeModelBase extends BAModelBase implements IBASchemeModel, IBASchemeRuntime {

	private HashMap<String, IBATable> baTableMap = new HashMap<String, IBATable>();
	private ArrayList<IBATable> baTableList = new ArrayList<IBATable>();
	private String strNamespace = null;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBASchemeModel#registerBATable(net.ibizsys.psba.core.IBATable)
	 */
	@Override
	public void registerBATable(IBATable iBATable) {
		String strId = iBATable.getId();
		String strName = iBATable.getName();

		baTableMap.put(strId, iBATable);
		baTableMap.put(strName, iBATable);
		baTableList.add(iBATable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAScheme#getBATable(java.lang.String, boolean)
	 */
	@Override
	public IBATable getBATable(String strName, boolean bTry) throws Exception {
		IBATable iBATable = baTableMap.get(strName);
		if (iBATable == null) {
			if (!bTry) {
				throw new Exception(StringHelper.format("无法获取大数据表[%1$s]", strName));
			}
		}

		return iBATable;
	}

	/**
	 * 建立大数据表对象
	 * 
	 * @param strBATableName
	 * @return
	 * @throws Exception
	 */
	protected IBATable createBATable(String strBATableName) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAScheme#getBATables()
	 */
	@Override
	public Iterator<IBATable> getBATables() {
		if (baTableList.size() == 0) return null;
		return baTableList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAScheme#getSystem()
	 */
	@Override
	public ISystem getSystem() {
		return this.getSystemModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBASchemeRuntime#install()
	 */
	@Override
	public void install() throws Exception {
		Object conn = null;
		try {
			conn = this.getBADataSource().getConnection();
			this.getBADialect().install(conn, this);
		} catch (Exception ex) {
			if (conn != null) {
				this.getBADataSource().closeConnection(conn);
			}
		}
	}

	@Override
	public IBADAO getBADAO(IBATable  iBATable) throws Exception {
		return   BADAOGlobal.getBADAO(iBATable.getId());
	}

	@Override
	public String getNamespace() {
		if(StringHelper.isNullOrEmpty(strNamespace))
			return this.getBADataSource().getNamespace();
		return strNamespace;
	}
	
	
	
	/**
	 * 设置命名空间
	 * @param strNamespace
	 */
	public void setNamespace(String strNamespace){
		this.strNamespace = strNamespace;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBASchemeModel#createBAEntity(net.ibizsys.psba.core.IBATable)
	 */
	@Override
	public IBAEntity createBAEntity(IBATable iBATable) throws Exception {
		IBAEntity iBAEntity = onCreateBAEntity(iBATable);
		iBAEntity.setActionHelper(this.getBADAO(iBATable).getBAEntityActionHelper());
		return iBAEntity;
	}
	
	protected IBAEntity onCreateBAEntity(IBATable iBATable)throws Exception {
		return new BAEntity();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBASchemeRuntime#getMaxVersions()
	 */
	@Override
	public int getMaxVersions(){
		return this.getBADataSource().getMaxVersions();
	}
	
	
	
}
