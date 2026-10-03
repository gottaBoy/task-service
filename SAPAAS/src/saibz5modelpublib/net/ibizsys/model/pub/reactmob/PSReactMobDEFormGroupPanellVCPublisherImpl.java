package net.ibizsys.model.pub.reactmob;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFramework.Utility.StringHelper;

public class PSReactMobDEFormGroupPanellVCPublisherImpl extends PSReactMobDEFormDetailVCPublisherImpl
{
	public class ColumnLayoutGroup
	{
		private ArrayList<IPSGenerateCodeResult> itemCodeList = new  ArrayList<IPSGenerateCodeResult>();
		
		public ArrayList<IPSGenerateCodeResult> getItems()
		{
			return this.itemCodeList;
		}
	}
	
	protected IPSDEFormGroupPanel iPSDEFormGroupPanel = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEFormGroupPanel = (IPSDEFormGroupPanel)object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
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
			ArrayList<IPSDEFormDetail> psDEFormDetailList = new ArrayList<IPSDEFormDetail>();
			java.util.Iterator<IPSDEFormDetail> psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
			while(psDEFormDetails.hasNext())
			{
				IPSDEFormDetail iPSDEFormDetail = psDEFormDetails.next();
				if(iPSDEFormDetail instanceof IPSDEFormItem)
				{
					IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)iPSDEFormDetail;
					if(StringHelper.Compare(iPSDEFormItem.getEditorType(),"HIDDEN",true) == 0)
						continue;
				}
				psDEFormDetailList.add(iPSDEFormDetail);
			}
			
//			
//			
//			String strLayoutType = iPSDEFormGroupPanel.getLayoutMode();
//			if(StringHelper.Compare(strLayoutType, PSDEFormDetail.LAYOUTMODE_TABLE_12COL, true)!=0)
//			{
//				throw new Exception(StringHelper.Format("当前仅支持栅格（12列均分）布局"));
//			}
			
			if(true)
			{
//				int nColPos = 0 ;
//				int nRowId = 0;
				
				//HashMap<Integer,ColumnLayoutGroup> columnLayoutGroupMap = new HashMap<Integer,ColumnLayoutGroup>();
				ArrayList<IPSGenerateCodeResult> formDetailCodeList = new ArrayList<IPSGenerateCodeResult>();
				
				//产生集合代码
				for( IPSDEFormDetail iPSDEFormDetail :psDEFormDetailList)
				{
//					int nColSpan = iPSDEFormDetail.getColSpan();
//					if(nColSpan == 0 || nColSpan> iPSDEFormGroupPanel.getColumnCount() )
//						nColSpan = iPSDEFormGroupPanel.getColumnCount();
//					if(nColPos + nColSpan >  iPSDEFormGroupPanel.getColumnCount())
//					{
//						//换行
//						nRowId ++;
//						nColPos = 0;
//					}
//					else
//					{
//						nColPos += nColSpan;
//					}
//					
//					ColumnLayoutGroup columnLayoutGroup = null;
//					if(columnLayoutGroupMap.containsKey(nRowId))
//					{
//						columnLayoutGroup = columnLayoutGroupMap.get(nRowId);
//					}
//					else
//					{
//						columnLayoutGroup = new ColumnLayoutGroup();
//						columnLayoutGroupMap.put(nRowId, columnLayoutGroup);
//					}
					
					//根据类型，获取对应的编辑器代码
					IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, this.iPSControl,iPSDEFormDetail);		
					iPSPFCtrlPartCodePublisher.close();
					
					formDetailCodeList.add(iPSGenerateCodeResult);
					//columnLayoutGroup.getItems().add(iPSGenerateCodeResult);
				}	
				
//				ArrayList<ColumnLayoutGroup> columnLayoutGroupList = new ArrayList<ColumnLayoutGroup>();
//				for(int i=0;i<1000;i++)
//				{
//					ColumnLayoutGroup columnLayoutGroup = columnLayoutGroupMap.get(i);
//					if(columnLayoutGroup==null)
//						break;
//					columnLayoutGroupList.add(columnLayoutGroup);
//				}
//				params.put("rows", columnLayoutGroupList);
				params.put("items", formDetailCodeList);
//				ArrayList<IPSGenerateCodeResult> psGenerateCodeResultList = new ArrayList<IPSGenerateCodeResult>();
//				for( IPSDEFormDetail iPSDEFormDetail :psDEFormDetailList)
//				{
//					//根据类型，获取对应的编辑器代码
//					IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
//					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, this.iPSControl,iPSDEFormDetail);		
//					iPSPFCtrlPartCodePublisher.close();
//					
//					psGenerateCodeResultList.add(iPSGenerateCodeResult);
//				}	
//				params.put("items", psGenerateCodeResultList);
			}
			else
			{
//				//输出列集合
//				
//				ArrayList<String> itemCodeList = new  ArrayList<String>();
//				//产生集合代码
//				NUActionContextImpl2 nuActionContextImpl2  = new NUActionContextImpl2(iNUActionContext);
//				nuActionContextImpl2.setUserTag("CODETYPE", nuPFCTCode.getNUFPCTCODENAME());
//				
//				for( IPSDEFormDetail iPSDEFormDetail :psDEFormDetailList)
//				{
//					String strItemPublisherId = StringHelper.Format("ITEM:%1$s",iPSDEFormDetail.getNUFormItemType().toUpperCase());
//					
//					INUCtrlTypeDetailPublisher iNUCtrlTypeDetailPublisher= 	this.getNUCtrlTypePublisher().getNUCtrlTypeDetailPublisher(strItemPublisherId);
//					
//					nuActionContextImpl2.setUserTag("NUFORMITEMBASE", iPSDEFormDetail);
//					itemCodeList.add(iNUCtrlTypeDetailPublisher.generateCode(nuActionContextImpl2));
//				}
//			
//				
//				params.put("items", itemCodeList);
			}
			
		
		}
		
	}
	

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDEFormGroupPanel = null;
		super.onClose();
	}
}
