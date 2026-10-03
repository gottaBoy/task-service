package net.ibizsys.model.pub;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSExtJSTemplHelper
{
	private static final Log log = LogFactory.getLog(PSExtJSTemplHelper.class);
	
	private static PSExtJSDataTypeMethod psExtJSDataTypeMethod = new PSExtJSDataTypeMethod();
	private static PSExtJSImagePathMethod psExtJSImagePathMethod = new PSExtJSImagePathMethod();
		
	public static void fillParams(Map<String, Object> params)throws Exception
	{
		params.put("srfextjsdatatype", psExtJSDataTypeMethod);
		params.put("srfextjsimagepath", psExtJSImagePathMethod);
	}
}
