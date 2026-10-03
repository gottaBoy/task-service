package net.ibizsys.model.pub.reactmob;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSReactMobTemplHelper
{
	private static final Log log = LogFactory.getLog(PSReactMobTemplHelper.class);
	
	private static PSReactMobFileNameMethod psIonicFileNameMethod = new PSReactMobFileNameMethod();
		
	public static void fillParams(Map<String, Object> params)throws Exception
	{
		params.put("filename", psIonicFileNameMethod);
	}
}
