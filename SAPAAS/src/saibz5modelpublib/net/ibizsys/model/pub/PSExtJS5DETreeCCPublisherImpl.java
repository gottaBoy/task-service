package net.ibizsys.model.pub;

import java.util.HashMap;

import net.ibizsys.model.control.tree.IPSDETree;
import net.ibizsys.model.control.tree.IPSDETreeNode;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pub.util.PSCtrlMethod;

/**
 * 实体树代码发布对象
 * @author Administrator
 *
 */
public class PSExtJS5DETreeCCPublisherImpl extends PSExtJS5CtrlCodePublisherImpl {

	protected IPSDETree iPSDETree = null;
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDETree = (IPSDETree)this.iPSControl;
		return  super.onGenerateCode();
	}

//	
//	/* (non-Javadoc)
//	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
//	 */
//	@Override
//	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
//	{
//		super.onFillGenerateCodeParams(params);
//		PSCtrlMethod psCMMethod = new PSCtrlMethod();
//		psCMMethod.resetCtrlResult();
//		params.put("srfcm", psCMMethod);
//		
//		java.util.Iterator<IPSDETreeNode> psDETreeNodes = this.iPSDETree.getPSDETreeNodes();
//		if(psDETreeNodes!=null)
//		{
//			while(psDETreeNodes.hasNext()){
//				IPSDETreeNode iPSDETreeNode = psDETreeNodes.next();
//				if(iPSDETreeNode.getPSDEContextMenu() == null)
//					continue;
//				IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSDETreeNode.getPSDEContextMenu().getPSControlType(), this.getPSPFPubCode());
//				if(iPSPFCtrlTempl!=null)
//				{
//					IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
//					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSDETreeNode.getPSDEContextMenu());
//					if(iPSGenerateCodeResult!=null)
//					{
//						psCMMethod.registerCtrlResult(iPSDETreeNode.getNodeType(), iPSGenerateCodeResult);
//					}
//					iPSPFCtrlCodePublisher.close();
//				}
//			}
//		}
//	}



}
