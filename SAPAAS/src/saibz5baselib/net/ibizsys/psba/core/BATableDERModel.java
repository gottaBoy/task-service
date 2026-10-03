package net.ibizsys.psba.core;


/**
 * 大数据表关系模型对象
 * 
 * @author Administrator
 *
 */
public class BATableDERModel extends BATableObjectModelBase implements IBATableDERModel {

	private String strMajorDEName = null;
	private String strMinorDEName = null;
	private String strDERFieldName = null;
	
	
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

	@Override
	protected void onInit() throws Exception {
		super.onInit();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableDER#getMajorDEName()
	 */
	@Override
	public String getMajorDEName() {
		return strMajorDEName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableDER#getMinorDEName()
	 */
	@Override
	public String getMinorDEName() {
		return strMinorDEName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableDER#getDERFieldName()
	 */
	@Override
	public String getDERFieldName() {
		return strDERFieldName;
	}

	/**
	 * 设置主实体名称
	 * @param strMajorDEName
	 */
	public void setMajorDEName(String strMajorDEName) {
		this.strMajorDEName = strMajorDEName;
	}

	/**
	 * 设置从实体名称
	 * @param strMinorDEName
	 */
	public void setMinorDEName(String strMinorDEName) {
		this.strMinorDEName = strMinorDEName;
	}

	/**
	 * 设置关系属性名称
	 * @param strDERFieldName
	 */
	public void setDERFieldName(String strDERFieldName) {
		this.strDERFieldName = strDERFieldName;
	}

	
	
	
	
}
