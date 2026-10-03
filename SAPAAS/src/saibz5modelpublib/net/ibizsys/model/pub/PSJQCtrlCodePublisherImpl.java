package net.ibizsys.model.pub;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJQCtrlCodePublisherImpl extends PSPFCtrlCodePublisherImpl
{
	private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

	
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);

		PSJQTemplHelper.fillParams(params);

	}

}
