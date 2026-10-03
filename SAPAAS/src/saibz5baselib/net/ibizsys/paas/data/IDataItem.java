package net.ibizsys.paas.data;

/**
 * 数据项接口
 * 
 * @author Administrator
 *
 */
public interface IDataItem extends IDataItemParam {
	/**
	 * 主键数据项
	 */
	public final static String KEYITEM = "srfkey";

	/**
	 * 主文本数据项
	 */
	public final static String MAJORTEXTITEM = "srfmajortext";

	/**
	 * 数据访问控制项
	 */
	public final static String DATAACCACTIONITEM = "srfdataaccaction";

	/**
	 * 数据类型
	 */
	public final static String DATATYPEITEM = "srfdatatype";

	/**
	 * 流程步骤
	 */
	public final static String WFSTEPITEM = "srfwfstep";
	
	/**
	 * 流程版本
	 */
	public final static String WFVERITEM = "srfwfver";
	

	/**
	 * 主状态标识
	 */
	public final static String MSTAG = "srfmstag";

	/**
	 * 获取数据类型
	 * 
	 * @return
	 */
	int getDataType();

	/**
	 * 获取参数结合
	 * 
	 * @return
	 */
	IDataItemParam[] getDataItemParams();

}
