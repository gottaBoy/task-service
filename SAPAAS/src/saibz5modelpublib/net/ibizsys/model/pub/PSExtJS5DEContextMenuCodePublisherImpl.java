package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.toolbar.IPSDEContextMenu;
import net.ibizsys.model.control.toolbar.IPSDEContextMenuItem;


/**
 * 上下文菜单代码发布器
 * @author Administrator
 *
 */
public class PSExtJS5DEContextMenuCodePublisherImpl extends PSExtJS5CtrlCodePublisherImpl
{
	protected IPSDEContextMenu iPSDEContextMenu = null;
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDEContextMenu = (IPSDEContextMenu)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		if(true)
		{
			ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSDEContextMenuItem> psDEContextMenuItems = 	iPSDEContextMenu.getPSDEContextMenuItems();
			while(psDEContextMenuItems.hasNext())
			{
				IPSDEContextMenuItem iPSDEContextMenuItem = psDEContextMenuItems.next();
				IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSDEContextMenuItem.getItemType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode( iPSDEContextMenu,iPSDEContextMenuItem);
				if(iPSGenerateCodeResult!=null)
					itemList.add(iPSGenerateCodeResult);
			}		
			
			params.put("items", itemList);
		}
	}

}
