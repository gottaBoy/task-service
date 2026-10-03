package net.ibizsys.model.pub.ionic4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;

public class PSIonic4TabExpViewControllerCodePublisherImpl extends PSIonic4ViewControllerCodePublisherImpl {
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
		super.onFillGenerateCodeParams(params);
		Iterator<IPSControl> iterator = this.iPSAppView.getPSControls();
		ArrayList<IPSControl> controls = new ArrayList<IPSControl>();
		iterator.hasNext();
		while (iterator.hasNext()) {
			IPSControl control = iterator.next();
			if (control.getControlType() == "TABVIEWPANEL") {				
				controls.add(control);
			}
		}
		// 排序
		for (int i = 0; i < controls.size(); i++) {
			for (int j = i + 1; j < controls.size(); j++) {
				IPSControl c1 = controls.get(i);
				IPSControl c2 = controls.get(j);
				if (c1.getOrderValue() > c2.getOrderValue()) {
					controls.remove(j);
					controls.add(i, c2);
				}
			}
		}
		params.put("tabviewpanelcontrols", controls);
		
		ArrayList<IPSGenerateCodeResult> codes = new ArrayList<IPSGenerateCodeResult>();
		for (int i = 0; i < controls.size(); i++) {
			IPSControl control = controls.get(i);
			IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(control.getPSControlType(), this.getPSPFPubCode());
			if(iPSPFCtrlTempl!=null) {
				IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, control);
				if(iPSGenerateCodeResult != null) {
					codes.add(iPSGenerateCodeResult);
				}
				iPSPFCtrlCodePublisher.close();
			}
		}
		params.put("tabviewpanels", codes);
	}
	
}
