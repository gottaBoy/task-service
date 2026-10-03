package net.ibizsys.model.pub.ionic;

import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.PSPFStyleImpl;

public class PSIonicStyleImpl extends PSPFStyleImpl {
	IPSPFPubCode partPSPFPubCode = null;
	@Override
	protected void onInit() throws Exception {
		
		//this.partPSPFPubCode =this.getPSPF().getPSPFPubCode("PART");
		super.onInit();
		
	}
	
//	@Override
//	public IPSPFCtrlTempl getPSPFCtrlTempl(IPSControlType iPSControlType, IPSPFPubCode iPSPFPubCode) throws Exception {
//		// 找到对于的 发布器
//		IPSPFCtrlTempl iPSPFCtrlTempl = super.getPSPFCtrlTempl(iPSControlType, iPSPFPubCode);
//		if(iPSPFCtrlTempl == null){
//			if(iPSPFPubCode.getName().equals("HTML")){
//				return super.getPSPFCtrlTempl(iPSControlType, partPSPFPubCode);
//			}
//		}
//
//		return iPSPFCtrlTempl;
//	}
}
