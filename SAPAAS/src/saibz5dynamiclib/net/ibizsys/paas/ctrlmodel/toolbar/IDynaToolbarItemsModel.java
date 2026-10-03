package net.ibizsys.paas.ctrlmodel.toolbar;

/**
 * 动态工具栏分组模型对象接口
 * @author Administrator
 *
 */
public interface IDynaToolbarItemsModel extends IDynaToolbarItemModel {
	
	/**
	 * 获取成员对象集合
	 * @return
	 */
	java.util.Iterator<IDynaToolbarItemModel> getItemModels();
	
	
	
	/**
	 * 获取显示模式
	 * @return
	 */
	String getShowMode();
	
	
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();

	

	/**
	 * 获取标题语言资源标识
	 * @return
	 */
	String getCapLanResTag();



	/**
	 * 获取项操作提示
	 * @return
	 */
	String getTooltip();
	/**
	 * 获取项操作提示语言资源标识
	 * @return
	 */
	String getTooltipLanResTag();

}
