package net.ibizsys.model.pub.vue;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFramework.Utility.StringHelper;

public class PSVueViewServiceCodePublisherImpl extends PSVueViewCodePublisherImpl
{
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		ArrayList<IPSGenerateCodeResult> psGenerateCodeResultList = (ArrayList<IPSGenerateCodeResult>) params.get("ctrls");
		ArrayList<String> strList = new ArrayList<String>();
		for (IPSGenerateCodeResult ipsGenerateCodeResult : psGenerateCodeResultList) {
			String strImport = ipsGenerateCodeResult.getCode2();
			if(!StringHelper.IsNullOrEmpty(strImport)){
				if(!strList.contains(strImport)){
					strList.add(strImport);
				}
			}
		}
		params.put("imports", strList);
	}
}
