package net.ibizsys.model.pub;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * JQuery 代码模板辅助对象
 * @author Administrator
 *
 */
public class PSJQTemplHelper
{
	private static final Log log = LogFactory.getLog(PSJQTemplHelper.class);
	
	private static PSJQDataTypeMethod psJQJSDataTypeMethod = new PSJQDataTypeMethod();
		
	public static void fillParams(Map<String, Object> params)throws Exception
	{
		params.put("srfextjsdatatype", psJQJSDataTypeMethod);
		//params.put("srfextjsdatatype", psExtJSDataTypeMethod);
	}
}
