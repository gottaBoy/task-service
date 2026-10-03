package net.ibizsys.model.control.form;

/**
 * 实体编辑表单接口
 * @author lionlau
 *
 */
public interface IPSDEEditForm extends IPSDEForm
{
	/**
	 * 表单数据的键值
	 */
	public final static String KEYITEM = "srfkey";
	
	/**
	 * 表单数据的主信息
	 */
	public final static String MAJORITEM = "srfmajortext";
	
	/**
	 * 表单数据的实际键值（对应临时数据）
	 */
	public final static String ORIKEYITEM = "srforikey";
	/**
	 * 表单数据是否处于更新模式
	 */
	public final static String UFITEM = "srfuf";
	/**
	 * 表单数据的实体标识
	 */
	public final static String DEITEM = "srfdeid";
	
	/**
	 * 表单数据的源数据标识（对应数据复制）
	 */
	public final static String SOURCEKEYITEM = "srfsourcekey";
	
	/**
	 * 表单数据的最后更新时间
	 */
	public final static String UPDATEDATE = "srfupdatedate";
	/**
	 * 表单的临时数据模式
	 */
	public final static String TEMPMODEITEM = "srftempmode";
	
	
	
	/**
	 * 是否显示表单导航栏
	 * @return
	 */
	boolean isShowFormNavBar();
	
	
	
	/**
	 * 是否为信息表单模式
	 * @return
	 */
	boolean isInfoFormMode();
}
