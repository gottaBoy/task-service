package net.ibizsys.model.pub.preview;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import SA.SRFDA.PS.Core.Pub.AngularGA.PSAngularCalculatingIteratorLengthMethod;

/**
 * PreViewPCuery 代码模板辅助对象
 * @author Administrator
 *
 */
public class PSPreviewTemplHelper
{
	private static final Log log = LogFactory.getLog(PSPreviewTemplHelper.class);
	
	private static PSPreviewDataTypeMethod psPreViewPCJSDataTypeMethod = new PSPreviewDataTypeMethod();
	private static PSPreviewFileNameMethod psPreViewPCFileNameMethod = new PSPreviewFileNameMethod();
	private static PSAngularCalculatingIteratorLengthMethod psCalculatingIteratorLengthMethod = new PSAngularCalculatingIteratorLengthMethod();

	public static void fillParams(Map<String, Object> params)throws Exception
	{
		params.put("srfextjsdatatype", psPreViewPCJSDataTypeMethod);
		params.put("filename", psPreViewPCFileNameMethod);
		params.put("iteratorlength", psCalculatingIteratorLengthMethod);
		//params.put("srfextjsdatatype", psExtJSDataTypeMethod);
	}
}
