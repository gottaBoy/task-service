package net.ibizsys.paas.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.StringHelper;

/**
 * 视图消息组模型
 * 
 * @author Administrator
 *
 */
public class ViewMsgGroupModel extends SystemModelObjectBase implements IViewMsgGroupModel {

	protected ArrayList<IViewMsgModel> viewMsgModelList = new ArrayList<IViewMsgModel>();
	private String strUniqueTag = null;
		
	
	/**
	 * 设置标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	/**
	 * 设置名称
	 * @param strId
	 */
	public void setName(String strName){
		this.strName = strName;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IViewMsgGroupModel#init(net.ibizsys.paas.sysmodel.ISystemModel)
	 */
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.setSystemModel(iSystemModel);
		
		if(!StringHelper.isNullOrEmpty(this.getUserTag())&&!StringHelper.isNullOrEmpty(this.getUserTag2())){
			strUniqueTag = StringHelper.format("%1$s||%2$s",this.getUserTag(),this.getUserTag2());
		}
		else
			if(!StringHelper.isNullOrEmpty(this.getUserTag())){
				strUniqueTag = this.getUserTag();
			}
			else
				if(!StringHelper.isNullOrEmpty(this.getUserTag2())){
					strUniqueTag = this.getUserTag2();
				}
		
		this.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.view.IViewMsgGroupModel#registerViewMsgModel(net.ibizsys.paas.view.IViewMsgModel)
	 */
	@Override
	public void registerViewMsgModel(IViewMsgModel iViewMsgModel) throws Exception {
		this.viewMsgModelList.add(iViewMsgModel);
	}





	@Override
	public void fillViewMessages(IViewController iViewController,ArrayList<IViewMessage> viewMessageList) throws Exception {
		
		ArrayList<IViewMsgModel> viewMsgModelList2 = new ArrayList<IViewMsgModel>();
		
		for(IViewMsgModel iViewMsgModel:viewMsgModelList){
			iViewMsgModel.fillViewMessages(iViewController,viewMsgModelList2);
		}
		
		Collections.sort(viewMsgModelList2, new Comparator<IViewMsgModel>() {
			@Override
			public int compare(IViewMsgModel o1, IViewMsgModel o2) {
				return o1.getOrderValue() - o2.getOrderValue();
			}
		});
		
		viewMessageList.addAll(viewMsgModelList2);
	}


	@Override
	public String getUniqueTag() {
		return strUniqueTag;
	}

	
	
}
