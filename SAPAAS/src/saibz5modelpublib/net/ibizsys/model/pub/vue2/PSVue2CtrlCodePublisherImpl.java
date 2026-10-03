package net.ibizsys.model.pub.vue2;

import java.util.HashMap;

import net.ibizsys.model.pub.PSPFCtrlCodePublisherImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSVue2CtrlCodePublisherImpl extends PSPFCtrlCodePublisherImpl
{
	private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

	
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);

		PSVue2TemplHelper.fillParams(params);

	}

}
