package net.ibizsys.paas.ctrlmodel.toolbar;

import net.ibizsys.paas.ctrlmodel.DynaToolbarModelBase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 默认的动态工具栏模型对象
 * @author Administrator
 *
 */
public class DefaultDynaToolbarModel extends DynaToolbarModelBase {

	private static Log log = LogFactory.getLog(DefaultDynaToolbarModel.class);
	
	public final static String MODEL_NODE_TOOLBAR = "TOOLBAR";
	public final static String MODEL_NODE_ITEMS = "ITEMS";
	public final static String MODEL_NODE_SEPARATOR = "SEPARATOR";
	public final static String MODEL_NODE_UIACTION = "UIACTION";
	
	/**
	 * 界面行为标识
	 */
	public final static String MODEL_ATTR_UIACTIONID = "UIACTIONID";
	
	
	
	/**
	 * 界面行为参数
	 */
	public final static String MODEL_ATTR_UIACTIONPARAM = "UIACTIONPARAM";
	
	/**
	 * 分组展开模式
	 */
	public final static String MODEL_ATTR_GROUPEXTRACTMODE = "GROUPEXTRACTMODE";
	
	/**
	 * 项显示模式
	 */
	public final static String MODEL_ATTR_SHOWMODE = "SHOWMODE";
	
	
	/**
	 * 项显示标题
	 */
	public final static String MODEL_ATTR_CAPTION = "CAPTION";
	
	/**
	 * 项显示标题语言资源
	 */
	public final static String MODEL_ATTR_CAPLANRESTAG = "CAPLANRESTAG";
	
	
	/**
	 * 项操作提示
	 */
	public final static String MODEL_ATTR_TOOLTIP = "TOOLTIP";
	
	/**
	 * 项操作提示语言资源
	 */
	public final static String MODEL_ATTR_TOOLTIPLANRESTAG = "TOOLTIPLANRESTAG";
	
	
	/**
	*行为组展开模式：按项展开
	*/
	public final static String GROUPEXTRACTMODE_ITEM = "ITEM" ;

	/**
	*行为组展开模式：按分组展开
	*/
	public final static String GROUPEXTRACTMODE_ITEMS = "ITEMS" ;
	
	
	
	
	

	
//	protected void loadToolbarModel(String strModel)throws Exception{
//		if(StringHelper.isNullOrEmpty(strModel)){
//			throw new Exception("工具栏配置模型无效");
//		}
//		
//		XmlNode xmlNode = XmlNode.loadFromXML(strModel);
//		java.util.Iterator<XmlNode> itemXmlNodes = xmlNode.getChildNodes();
//		if(itemXmlNodes== null)
//			return;
//		
//		while(itemXmlNodes.hasNext()){
//			XmlNode itemXmlNode = itemXmlNodes.next();
//			if(StringHelper.compare(itemXmlNode.getNodeName(), MODEL_NODE_ITEMS, true) == 0){
//				this.loadItemsModel(null, itemXmlNode);
//				continue;
//			}
//			
//			if(StringHelper.compare(itemXmlNode.getNodeName(), MODEL_NODE_UIACTION, true) == 0){
//				this.loadUIActionModel(null, itemXmlNode);
//				continue;
//			}
//			
//			if(StringHelper.compare(itemXmlNode.getNodeName(), MODEL_NODE_SEPARATOR, true) == 0){
//				this.loadSeparatorModel(null, itemXmlNode);
//				continue;
//			}
//			
//			throw new Exception(StringHelper.format("无法识别的节点类型[%1$s]",itemXmlNode.getNodeName()));
//		}
//		
//		loadItemsModel(null, xmlNode);
//	}
//	
//	protected void loadItemsModel(DynaToolbarItemsModel parentModel,XmlNode itemsXmlNode)throws Exception{
//		
//		DynaToolbarItemsModel defaultDynaToolbarItemsModel = new DynaToolbarItemsModel();
//		defaultDynaToolbarItemsModel.setParentModel(parentModel);
//		defaultDynaToolbarItemsModel.setToolbarModel(this);
//		defaultDynaToolbarItemsModel.init();
//		
//		if(parentModel == null){
//			this.registerItemModel(defaultDynaToolbarItemsModel);
//		}
//		else{
//			parentModel.registerItemModel(defaultDynaToolbarItemsModel);
//		}
//		
//		
//		java.util.Iterator<XmlNode> itemXmlNodes = itemsXmlNode.getChildNodes();
//		if(itemXmlNodes!= null)
//		{
//			while(itemXmlNodes.hasNext()){
//				XmlNode itemXmlNode = itemXmlNodes.next();
//				if(StringHelper.compare(itemXmlNode.getNodeName(), MODEL_NODE_ITEMS, true) == 0){
//					this.loadItemsModel(defaultDynaToolbarItemsModel, itemXmlNode);
//					continue;
//				}
//				
//				if(StringHelper.compare(itemXmlNode.getNodeName(), MODEL_NODE_UIACTION, true) == 0){
//					this.loadUIActionModel(defaultDynaToolbarItemsModel, itemXmlNode);
//					continue;
//				}
//				
//				if(StringHelper.compare(itemXmlNode.getNodeName(), MODEL_NODE_SEPARATOR, true) == 0){
//					this.loadSeparatorModel(defaultDynaToolbarItemsModel, itemXmlNode);
//					continue;
//				}
//				
//				throw new Exception(StringHelper.format("无法识别的节点类型[%1$s]",itemXmlNode.getNodeName()));
//			}
//		}
//		
//	}
//	
//	protected void loadUIActionModel(DynaToolbarItemsModel parentModel,XmlNode uiActionXmlNode)throws Exception{
//		
//		String strUIActionId = uiActionXmlNode.getAttribute(MODEL_ATTR_UIACTIONID,"");
//		if(StringHelper.isNullOrEmpty(strUIActionId)){
//			throw new Exception("没有指定界面行为工具栏项界面行为标识");
//		}
//		IUIAction iUIAction = this.getDEModel().getDEUIAction(strUIActionId);
//		if(!(iUIAction instanceof IDynaUIActionModel)){
//			throw new Exception("界面行为对象没有实现指定接口");
//		}
//		
//		IDynaUIActionModel iDynaUIActionModel = (IDynaUIActionModel) iUIAction;
//		
//		String strUIActionParam = uiActionXmlNode.getAttribute(MODEL_ATTR_UIACTIONPARAM,"");
//		JSONObject uiActionParam  = null;
//		if(!StringHelper.isNullOrEmpty(strUIActionParam)){
//			uiActionParam = JSONObject.fromString(strUIActionParam);
//		}
//		
//		if(!iDynaUIActionModel.isValid(this.getView()))
//			return ;
//		
//		String strShowMode = uiActionXmlNode.getAttribute(MODEL_ATTR_SHOWMODE,null);
//		
//		if(!iDynaUIActionModel.isUIActionGroup(this.getView()))
//		{
//			//放入界面行为项
//			DynaToolbarUIActionItemModel dynaToolbarUIActionItemModel = new DynaToolbarUIActionItemModel();
//			dynaToolbarUIActionItemModel.setParentModel(parentModel);
//			dynaToolbarUIActionItemModel.setToolbarModel(this);
//			dynaToolbarUIActionItemModel.setUIActionModel(iDynaUIActionModel);
//			dynaToolbarUIActionItemModel.setUIActionParam(uiActionParam);
//			dynaToolbarUIActionItemModel.setShowMode(strShowMode);
//			dynaToolbarUIActionItemModel.setCaption(uiActionXmlNode.getAttribute(MODEL_ATTR_CAPTION,iDynaUIActionModel.getCaption()));
//			dynaToolbarUIActionItemModel.setCapLanResTag(uiActionXmlNode.getAttribute(MODEL_ATTR_CAPLANRESTAG,iDynaUIActionModel.getCapLanResTag()));
//			dynaToolbarUIActionItemModel.setTooltip(uiActionXmlNode.getAttribute(MODEL_ATTR_TOOLTIP,iDynaUIActionModel.getTooltip()));
//			dynaToolbarUIActionItemModel.setTooltipLanResTag(uiActionXmlNode.getAttribute(MODEL_ATTR_TOOLTIPLANRESTAG,iDynaUIActionModel.getTooltipLanResTag()));
//			dynaToolbarUIActionItemModel.init();
//			
//			if(parentModel == null)
//				this.registerItemModel(dynaToolbarUIActionItemModel);
//			else{
//				parentModel.registerItemModel(dynaToolbarUIActionItemModel);
//			}
//			return;
//		}
//		
//		
//			
//		IUIActionGroup iUIActionGroup = iDynaUIActionModel.getUIActionGroup(this.getView());
//		if(iUIActionGroup == null)
//			return;
//		
//		java.util.Iterator<IUIActionGroupDetail> uiActionGroupDetails = iUIActionGroup.getDetails();
//		if(uiActionGroupDetails==null)
//			return;
//		
//		String strGroupExtractMode = uiActionXmlNode.getAttribute(MODEL_ATTR_GROUPEXTRACTMODE,GROUPEXTRACTMODE_ITEM);
//		
//		
//		//判断展开方式
//		DynaToolbarItemsModel dynaToolbarItemsModel = null;
//		if(StringHelper.compare(strGroupExtractMode, GROUPEXTRACTMODE_ITEMS,true)==0){
//			
//			//放入界面行为项
//			DynaToolbarItemsModel uaDynaToolbarItemsModel = new DynaToolbarItemsModel();
//			uaDynaToolbarItemsModel.setParentModel(parentModel);
//			uaDynaToolbarItemsModel.setToolbarModel(this);
//			uaDynaToolbarItemsModel.setShowMode(strShowMode);
//			uaDynaToolbarItemsModel.setCaption(uiActionXmlNode.getAttribute(MODEL_ATTR_CAPTION,iDynaUIActionModel.getCaption()));
//			uaDynaToolbarItemsModel.setCapLanResTag(uiActionXmlNode.getAttribute(MODEL_ATTR_CAPLANRESTAG,iDynaUIActionModel.getCapLanResTag()));
//			uaDynaToolbarItemsModel.setTooltip(uiActionXmlNode.getAttribute(MODEL_ATTR_TOOLTIP,iDynaUIActionModel.getTooltip()));
//			uaDynaToolbarItemsModel.setTooltipLanResTag(uiActionXmlNode.getAttribute(MODEL_ATTR_TOOLTIPLANRESTAG,iDynaUIActionModel.getTooltipLanResTag()));
//			uaDynaToolbarItemsModel.init();
//			
//			if(parentModel == null)
//				this.registerItemModel(uaDynaToolbarItemsModel);
//			else{
//				parentModel.registerItemModel(uaDynaToolbarItemsModel);
//			}
//			
//		}
//		
//		//判断是否递归
//		boolean bClose=false;
//		try
//		{
//			ActionSession actionSession = ActionSessionManager.getCurrentSession();
//			if(actionSession==null)
//			{
//				bClose = true;
//				actionSession  = ActionSessionManager.openSession("LOADUIACTIONMODEL");
//				actionSession.registerRecursion("UIACTION", iUIAction.getId());
//			}
//			else
//			{
//				if(!actionSession.registerRecursion("UIACTION", iUIAction.getId()))
//				{
//					throw new Exception(StringHelper.format("界面行为[%1$s]存在递归关系",iUIAction.getName()));
//				}
//			}
//			
//			while(uiActionGroupDetails.hasNext())
//			{
//				IUIActionGroupDetail iUIActionGroupDetail = uiActionGroupDetails.next();
//				IUIAction childUIAction = iUIActionGroupDetail.getUIAction();
//				if(childUIAction==null && childUIAction instanceof IDynaUIActionModel)
//					continue;
//				
//				//放入界面行为项
//				DynaToolbarUIActionItemModel dynaToolbarUIActionItemModel = new DynaToolbarUIActionItemModel();
//				dynaToolbarUIActionItemModel.setParentModel(parentModel);
//				dynaToolbarUIActionItemModel.setToolbarModel(this);
//				dynaToolbarUIActionItemModel.setShowMode(strShowMode);
//				dynaToolbarUIActionItemModel.setUIActionModel((IDynaUIActionModel)childUIAction);
//				dynaToolbarUIActionItemModel.setUIActionParam(iUIActionGroupDetail.getUIActionParam());
//				dynaToolbarUIActionItemModel.setCaption(uiActionXmlNode.getAttribute(MODEL_ATTR_CAPTION,iDynaUIActionModel.getCaption()));
//				dynaToolbarUIActionItemModel.setCapLanResTag(uiActionXmlNode.getAttribute(MODEL_ATTR_CAPLANRESTAG,iDynaUIActionModel.getCapLanResTag()));
//				dynaToolbarUIActionItemModel.setTooltip(uiActionXmlNode.getAttribute(MODEL_ATTR_TOOLTIP,iDynaUIActionModel.getTooltip()));
//				dynaToolbarUIActionItemModel.setTooltipLanResTag(uiActionXmlNode.getAttribute(MODEL_ATTR_TOOLTIPLANRESTAG,iDynaUIActionModel.getTooltipLanResTag()));
//				dynaToolbarUIActionItemModel.init();
//				if(dynaToolbarItemsModel!=null){
//					dynaToolbarItemsModel.registerItemModel(dynaToolbarUIActionItemModel);
//				}
//				else{
//					if(parentModel == null)
//						this.registerItemModel(dynaToolbarUIActionItemModel);
//					else{
//						parentModel.registerItemModel(dynaToolbarUIActionItemModel);
//					}
//				}
//			}
//			
//			if(bClose){
//				ActionSessionManager.closeSession();
//			}
//		}
//		catch(Exception ex)
//		{
//			if(bClose){
//				ActionSessionManager.closeSession();
//			}
//			throw ex;
//		}
//		
//	}
//	
//	protected void loadSeparatorModel(DynaToolbarItemsModel parentModel,XmlNode seperatorXmlNode)throws Exception{
//		DynaToolbarSeparatorModel dynaToolbarSeparatorModel = new DynaToolbarSeparatorModel();
//		dynaToolbarSeparatorModel.setParentModel(parentModel);
//		dynaToolbarSeparatorModel.setToolbarModel(this);
//		dynaToolbarSeparatorModel.init();
//		
//		if(parentModel == null)
//			this.registerItemModel(dynaToolbarSeparatorModel);
//		else{
//			parentModel.registerItemModel(dynaToolbarSeparatorModel);
//		}
//	}
	
}
