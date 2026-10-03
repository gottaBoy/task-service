package net.ibizsys.model.pub.angularga;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAngularTemplHelper
{
	private static final Log log = LogFactory.getLog(PSAngularTemplHelper.class);
	
	private static PSAngularFileNameMethod psNgFileNameMethod = new PSAngularFileNameMethod();
	private static PSAngularCalculatingIteratorLengthMethod psCalculatingIteratorLengthMethod = new PSAngularCalculatingIteratorLengthMethod();
		
	public static void fillParams(Map<String, Object> params)throws Exception
	{
		params.put("ngfilename", psNgFileNameMethod);
		params.put("iteratorlength", psCalculatingIteratorLengthMethod);
	}
}
