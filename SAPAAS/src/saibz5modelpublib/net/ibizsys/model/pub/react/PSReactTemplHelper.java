package net.ibizsys.model.pub.react;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSReactTemplHelper
{
	private static final Log log = LogFactory.getLog(PSReactTemplHelper.class);
	
	private static PSReactFileNameMethod psFileNameMethod = new PSReactFileNameMethod();
	private static PSReactCalculatingIteratorLengthMethod psCalculatingIteratorLengthMethod = new PSReactCalculatingIteratorLengthMethod();
		
	public static void fillParams(Map<String, Object> params)throws Exception
	{
		params.put("filename", psFileNameMethod);
		params.put("iteratorlength", psCalculatingIteratorLengthMethod);
	}
}
