package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl;

public class PSPreviewCtrlCodePublisherImpl extends PSPFCtrlCodePublisherImpl
{
	private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

	
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);

		PSPreviewTemplHelper.fillParams(params);

	}

}
