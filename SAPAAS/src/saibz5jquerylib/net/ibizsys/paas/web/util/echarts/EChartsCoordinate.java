package net.ibizsys.paas.web.util.echarts;

/**
 * EChart坐标系统
 * 
 * @author Administrator
 *
 */
public class EChartsCoordinate {
	private String strName = null;
	private String strType = null;

	/**
	 * 获取名称
	 * 
	 * @return the strName
	 */
	public String getName() {
		return strName;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName the strName to set
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 获取类型
	 * 
	 * @return the strType
	 */
	public String getType() {
		return strType;
	}

	/**
	 * 设置类型
	 * 
	 * @param strType the strType to set
	 */
	public void setType(String strType) {
		this.strType = strType;
	}
}
