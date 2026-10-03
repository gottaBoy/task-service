package net.ibizsys.model.pub.react;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFramework.Utility.StringHelper;

public class PSReactViewServiceCodePublisherImpl extends PSReactViewCodePublisherImpl
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
		StringBuffer ctrlImports = new StringBuffer();
		for (IPSGenerateCodeResult ipsGenerateCodeResult : psGenerateCodeResultList) {
			ctrlImports.append(ipsGenerateCodeResult.getCode2());
		}
		String[] imports = ctrlImports.toString().replace("\n", "").split(";");
		for (String str : imports) {
			str += ";";
			if(!StringHelper.IsNullOrEmpty(str)){
				if(!strList.contains(str)){
					strList.add(str);
				}
			}
		}
		params.put("imports", strList);
	}
}
