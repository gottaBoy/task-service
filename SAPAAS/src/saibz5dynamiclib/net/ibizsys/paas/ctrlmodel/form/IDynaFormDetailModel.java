package net.ibizsys.paas.ctrlmodel.form;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.IDynaFormModel;

/**
 * 动态表单成员对象接口
 * @author Administrator
 *
 */
public interface IDynaFormDetailModel extends IDynaModel,IDynaModelJsonExporter,IDynaModelJsonLoader {

	/**
	 * 模型属性：显示标题
	 */
	final static String ATTR_SHOWCAPTION = "showcaption";
	
	/**
	 * 模型属性：栅格布局 超小列宽
	 */
	final static String ATTR_COLXS = "colxs";
	
	/**
	 * 模型属性：栅格布局 小列宽
	 */
	final static String ATTR_COLSM = "colsm";
	
	/**
	 * 模型属性：栅格布局 中等列宽
	 */
	final static String ATTR_COLMD = "colmd";
	
	/**
	 * 模型属性：栅格布局 大型列宽
	 */
	final static String ATTR_COLLG = "collg";
	
	
	/**
	 * 模型属性：栅格布局 超小偏移数量
	 */
	final static String ATTR_COLXSOFFSET = "colxsoffset";
	
	/**
	 * 模型属性：栅格布局 小偏移数量
	 */
	final static String ATTR_COLSMOFFSET = "colsmoffset";
	
	/**
	 * 模型属性：栅格布局 中等偏移数量
	 */
	final static String ATTR_COLMDOFFSET = "colmdoffset";
	
	/**
	 * 模型属性：栅格布局 大型偏移数量
	 */
	final static String ATTR_COLLGOFFSET = "collgoffset";

	
	
	/**
	*表单成员类型：表单分页
	*/
	final String DETAILTYPE_FORMPAGE = "FORMPAGE" ;

	/**
	*表单成员类型：分页部件
	*/
	final String DETAILTYPE_TABPANEL = "TABPANEL" ;

	/**
	*表单成员类型：分页面板
	*/
	final String DETAILTYPE_TABPAGE = "TABPAGE" ;

	/**
	*表单成员类型：表单项
	*/
	final String DETAILTYPE_FORMITEM = "FORMITEM" ;

	/**
	*表单成员类型：用户控件
	*/
	final String DETAILTYPE_USERCONTROL = "USERCONTROL" ;

	/**
	*表单成员类型：表单部件
	*/
	final String DETAILTYPE_FORMPART = "FORMPART" ;

	/**
	*表单成员类型：分组面板
	*/
	final String DETAILTYPE_GROUPPANEL = "GROUPPANEL" ;

	/**
	*表单成员类型：数据关系界面
	*/
	final String DETAILTYPE_DRUIPART = "DRUIPART" ;
	
	
	
	/**
	*表单成员类型：按钮
	*/
	final String DETAILTYPE_BUTTON = "BUTTON" ;
	
	
	/**
	*表单成员类型：直接内容
	*/
	final String DETAILTYPE_RAWITEM = "RAWITEM" ;
	
	
	/**
	 * 初始化
	 * @param iDynaFormModel
	 * @param parentModel
	 * @param modelObject
	 * @throws Exception
	 */
	void init(IDynaFormModel iDynaFormModel,IDynaFormDetailModel parentModel,Object modelObject) throws Exception ;
	
	
	/**
	 * 获取成员类型，值参考 net.ibizsys.paas.ctrlmodel.form.IDynaFormDetailModel.DETAILTYPE_XXX 定义
	 * @return
	 */
	String getDetailType();
	
	/**
	 * 获取动态表单模型对象
	 * @return
	 */
	IDynaFormModel getDynaFormModel();
	
	
	/**
	 * 获取父表单成员对象
	 * @return
	 */
	IDynaFormDetailModel getParentModel();
	
	
	
	/**
	 * 
	 * @return
	 */
	int getColXS();

	
	/**
	 * @return
	 */
	int getColSM();
	
	
	/**
	 * @return
	 */
	int getColMD();
	
	
	/**
	 * @return
	 */
	int getColLG();
	
	
	/**
	 * @return
	 */
	int getColXSOffset();

	/**
	 * @return
	 */
	int getColSMOffset();
	
	
	/**
	 * @return
	 */
	int getColMDOffset();
	
	
	/**
	 * 获取列偏移（大型界面）
	 * @return
	 */
	int getColLGOffset();
	
	
	
	/**
	 * 获取宽度
	 * @return
	 */
	double getWidth();
	
	
	
	/**
	 * 获取高度
	 * @return
	 */
	double getHeight();
	
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();
	
	
	/**
	 * 是否显示标题
	 * @return
	 */
	boolean isShowCaption();

}
