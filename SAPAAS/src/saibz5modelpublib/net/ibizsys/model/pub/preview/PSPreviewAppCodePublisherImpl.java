package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;

public class PSPreviewAppCodePublisherImpl extends PSPFAppCodePublisherImpl
{
	private static PSPreviewFileNameMethod psPreViewPCFileNameMethod = new PSPreviewFileNameMethod();

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSPreviewTemplHelper.fillParams(params);
		//合成require
		HashMap<String, String> requireClassMap = new HashMap<String, String>();
		ArrayList<String> requireClasses = new ArrayList<String> ();
	
		
		requireClasses.addAll(requireClassMap.keySet());
		params.put("requires", requireClasses);
		params.put("filename", psPreViewPCFileNameMethod);
	}	
	
	
}
