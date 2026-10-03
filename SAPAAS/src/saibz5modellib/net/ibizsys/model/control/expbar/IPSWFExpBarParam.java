package net.ibizsys.model.control.expbar;


/**
 * 流程导航栏参数对象接口
 * @author lionlau
 *
 */
public interface IPSWFExpBarParam extends IPSExpBarParam
{

	/**
	 * 工作流数据分组,我的数据
	 */
	final static String SECTION_MYDATA ="MY";
	
	/**
	 * 工作流数据分组,全部数据
	 */
	final static String SECTION_ALLDATA ="ALL";
	

	/**
	 * 工作流数据分组，我的流程工作
	 */
	final static String SECTION_MYWFWORK= "MYWFWORK";
	
	
	/**
	 * 工作流数据分组，处理中
	 */
	final static String SECTION_PROCESSING = "PROCESSING";

	
	
	/**
	 * 是否先输出我的工作
	 * @return the bOutputMyWorkFirst
	 */
	boolean isOutputMyWorkFirst();
	
	
	
	/**
	 * 是否定义先输出我的工作参数
	 * @return
	 */
	boolean hasOutputMyWorkFirstParam() ;
	
	/**
	 * 是否展开我的工作
	 * @return
	 */
	boolean isExpandMyWork();
	
	
	/**
	 * 是否输出我的历史工作
	 * @return
	 */
	boolean isOutputMyHistoryWork();
	
	
	
	/**
	 * 获取流程数据分区
	 * @return
	 */
	String getWFDataSector();
	
	
	
	
	/**
	 * 获取我的临时工作名称
	 * @return
	 */
	String getMyHistoryWorkName();
	
	
	
	/**
	 * 获取我的工作名称
	 * @return
	 */
	String getMyWorkName();
	
	
	
	/**
	 * 是否输出并行流程目录
	 * @return
	 */
	boolean isOutputWFParallelFolder();
	
	
	
	
	/**
	 * 是否展开我的数据的流程步骤
	 * @return
	 */
	boolean isOutputMyDataWFSteps();
	
	
	
	/**
	 * 是否有输出我的数据流程步骤明细参数
	 * @return
	 */
	boolean hasOutputMyDataWFStepsParam();
}
