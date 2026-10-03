package net.ibizsys.paas.control.map;

import net.ibizsys.paas.core.IModelBase;
import net.sf.json.JSONObject;

/**
 * 地图项接口
 * 
 * @author Administrator
 *
 */
public interface IMapItem extends IModelBase {
	
	/**
	*项展现样式：点
	*/
	public final static String ITEMSTYLE_POINT = "POINT" ;

	/**
	*项展现样式：点2
	*/
	public final static String ITEMSTYLE_POINT2 = "POINT2" ;

	/**
	*项展现样式：点3
	*/
	public final static String ITEMSTYLE_POINT3 = "POINT3" ;

	/**
	*项展现样式：点4
	*/
	public final static String ITEMSTYLE_POINT4 = "POINT4" ;

	/**
	*项展现样式：连线
	*/
	public final static String ITEMSTYLE_LINE = "LINE" ;

	/**
	*项展现样式：连线2
	*/
	public final static String ITEMSTYLE_LINE2 = "LINE2" ;

	/**
	*项展现样式：连线3
	*/
	public final static String ITEMSTYLE_LINE3 = "LINE3" ;

	/**
	*项展现样式：连线4
	*/
	public final static String ITEMSTYLE_LINE4 = "LINE4" ;

	/**
	*项展现样式：区域
	*/
	public final static String ITEMSTYLE_REGION = "REGION" ;

	/**
	*项展现样式：区域2
	*/
	public final static String ITEMSTYLE_REGION2 = "REGION2" ;

	/**
	*项展现样式：区域3
	*/
	public final static String ITEMSTYLE_REGION3 = "REGION3" ;

	/**
	*项展现样式：区域4
	*/
	public final static String ITEMSTYLE_REGION4 = "REGION4" ;

	/**
	*项展现样式：用户自定义
	*/
	public final static String ITEMSTYLE_USER = "USER" ;

	/**
	*项展现样式：用户自定义2
	*/
	public final static String ITEMSTYLE_USER2 = "USER2" ;

	/**
	*项展现样式：用户自定义3
	*/
	public final static String ITEMSTYLE_USER3 = "USER3" ;

	/**
	*项展现样式：用户自定义4
	*/
	public final static String ITEMSTYLE_USER4 = "USER4" ;

	
	/**
	 * 获取地图项类型
	 * 
	 * @return
	 */
	String getItemType();

	
	/**
	 * 获取是否禁用
	 * 
	 * @return
	 */
	boolean isDisabled();



	/**
	 * 获取样式
	 * 
	 * @return
	 */
	String getCssClass();

	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	String getIconCssClass();

	/**
	 * 获取图标
	 * 
	 * @return
	 */
	String getIcon();

	/**
	 * 获取链接
	 * 
	 * @return
	 */
	String getHref();

	/**
	 * 获取链接目标
	 * 
	 * @return
	 */
	String getHrefTarget();

	/**
	 * 获取节点提示信息
	 * 
	 * @return
	 */
	String getTips();

	/**
	 * 获取节点文本
	 * 
	 * @return
	 */
	String getText();
	
	
	/**
	 * 获取内容
	 * @return
	 */
	String getContent();

	
	/**
	 * 获取字体颜色
	 * @return
	 */
	String getColor();
	
	
	/**
	 * 获取背景颜色
	 * @return
	 */
	String getBKColor();
	
	

	/**
	 * 获取边框颜色
	 * @return
	 */
	String getBorderColor();
	
	
	/**
	 * 获取边框宽度
	 * @return
	 */
	int getBorderWidth();
	
	
	/**
	 * 获取半径
	 * @return
	 */
	int getRadius();
	
	/**
	 * 获取经度
	 * @return
	 */
	Double getLongitude();
	
	
	/**
	 * 获取维度
	 * @return
	 */
	Double getLatitude();
	
	
	/**
	 * 获取高度
	 * @return
	 */
	Double getAltitude();
	

	/**
	 * 获取节点的标记值
	 * 
	 * @param strKey
	 * @return
	 */
	Object getTagValue(String strKey);

	/**
	 * 获取标记对象
	 * 
	 * @return
	 */
	JSONObject getTag();

	

	/**
	 * 获取地图项的数据源
	 * 
	 * @return
	 */
	Object getDataSource();
	

}
