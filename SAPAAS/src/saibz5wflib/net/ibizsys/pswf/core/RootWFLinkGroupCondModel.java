package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

/**
 * 根连接组条件模型对象
 * @author Administrator
 *
 */
public class RootWFLinkGroupCondModel extends WFLinkGroupCondModel
{
	protected HashMap<String, WFLinkGroupCondModel> wfLinkGroupCondModelMap = new HashMap<String, WFLinkGroupCondModel>();
	
	/**
	 * 添加组条件
	 * @param strId
	 * @param strPId
	 * @return
	 * @throws Exception
	 */
	public WFLinkGroupCondModel addGroupCond(String strId,String strPId)throws Exception
	{
		WFLinkGroupCondModel wfLinkGroupCondModel = new WFLinkGroupCondModel();
		wfLinkGroupCondModel.setId(strId);
		wfLinkGroupCondModel.setPId(strPId);
		wfLinkGroupCondModelMap.put(strId, wfLinkGroupCondModel);
		if(StringHelper.isNullOrEmpty(strPId))
		{
			this.getWFLinkCondModelList().add(wfLinkGroupCondModel);
			
		}
		else
		{
			//有父对象
			WFLinkGroupCondModel parentWFLinkGroupCondModel = wfLinkGroupCondModelMap.get(strPId);
			if(parentWFLinkGroupCondModel==null){
				throw new Exception(StringHelper.format("无法获取指定条件，标识为[%1$s]",strPId));
			}
			
			parentWFLinkGroupCondModel.getWFLinkCondModelList().add(wfLinkGroupCondModel);
		}
		return wfLinkGroupCondModel;
	}
	
	
	/**
	 * 增加单项条件
	 * @param strId
	 * @param strPId
	 * @return
	 * @throws Exception
	 */
	public WFLinkSingleCondModel addSingleCond(String strId,String strPId)throws Exception
	{
		WFLinkSingleCondModel wfLinkSingleCondModel = new WFLinkSingleCondModel();
		wfLinkSingleCondModel.setId(strId);
		wfLinkSingleCondModel.setPId(strPId);
		if(StringHelper.isNullOrEmpty(strPId))
		{
			this.getWFLinkCondModelList().add(wfLinkSingleCondModel);
		}
		else
		{
			//有父对象
			WFLinkGroupCondModel parentWFLinkGroupCondModel = wfLinkGroupCondModelMap.get(strPId);
			if(parentWFLinkGroupCondModel==null){
				throw new Exception(StringHelper.format("无法获取指定条件，标识为[%1$s]",strPId));
			}
			
			parentWFLinkGroupCondModel.getWFLinkCondModelList().add(wfLinkSingleCondModel);
		}
		return wfLinkSingleCondModel;
	}
	
	/**
	 * 增加自定义条件
	 * @param strId
	 * @param strPId
	 * @return
	 * @throws Exception
	 */
	public WFLinkCustomCondModel addCustomCond(String strId,String strPId)throws Exception
	{
		WFLinkCustomCondModel wfLinkCustomCondModel = new WFLinkCustomCondModel();
		wfLinkCustomCondModel.setId(strId);
		wfLinkCustomCondModel.setPId(strPId);
		if(StringHelper.isNullOrEmpty(strPId))
		{
			this.getWFLinkCondModelList().add(wfLinkCustomCondModel);
		}
		else
		{
			//有父对象
			WFLinkGroupCondModel parentWFLinkGroupCondModel = wfLinkGroupCondModelMap.get(strPId);
			if(parentWFLinkGroupCondModel==null){
				throw new Exception(StringHelper.format("无法获取指定条件，标识为[%1$s]",strPId));
			}
			
			parentWFLinkGroupCondModel.getWFLinkCondModelList().add(wfLinkCustomCondModel);
		}
		return wfLinkCustomCondModel;
	}
	
	
	
	/**
	 * 获取全部条件集合
	 * @return
	 */
	public ArrayList<IWFLinkCondModel> getAllWFLinkCondModels()
	{
		ArrayList<IWFLinkCondModel> allItems = new ArrayList<IWFLinkCondModel>();
		for(IWFLinkCondModel iWFLinkCondModel:this.getWFLinkCondModelList())
		{
			allItems.add(iWFLinkCondModel);
			if(iWFLinkCondModel instanceof IWFLinkGroupCondModel)
			{
				fillLinkCondModels((IWFLinkGroupCondModel)iWFLinkCondModel,allItems);
			}
		}
		return allItems;
	}
	
	/**
	 * 填充当前组条件子条件到列表中
	 * @param wfLinkCondModel
	 * @param allItems
	 */
	protected void fillLinkCondModels(IWFLinkGroupCondModel iWFLinkGroupCondModel,ArrayList<IWFLinkCondModel> allItems)
	{
		java.util.Iterator<IWFLinkCondModel> wfLinkCondModels = iWFLinkGroupCondModel.getWFLinkCondModels();
		while(wfLinkCondModels.hasNext())
		{
			IWFLinkCondModel iWFLinkCondModel = wfLinkCondModels.next();
//			if(iWFLinkCondModel instanceof DRBarItem)
//			{
//				((DRBarItem)childItem).setPId(wfLinkCondModel.getId());
//			}
			allItems.add(iWFLinkCondModel);
			if(iWFLinkCondModel instanceof IWFLinkGroupCondModel)
			{
				fillLinkCondModels((IWFLinkGroupCondModel)iWFLinkCondModel,allItems);
			}
		}
		
	}	
}
