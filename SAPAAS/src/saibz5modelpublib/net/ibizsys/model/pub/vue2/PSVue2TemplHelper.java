package net.ibizsys.model.pub.vue2;

import java.util.Map;

import net.ibizsys.model.pub.angularga.PSAngularCalculatingIteratorLengthMethod;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * PreViewPCuery 代码模板辅助对象
 * @author Administrator
 *
 */
public class PSVue2TemplHelper
{
	private static final Log log = LogFactory.getLog(PSVue2TemplHelper.class);
	
	private static PSVue2DataTypeMethod psVue2DataTypeMethod = new PSVue2DataTypeMethod();
	private static PSVue2FileNameMethod psVue2FileNameMethod = new PSVue2FileNameMethod();
	private static PSAngularCalculatingIteratorLengthMethod psCalculatingIteratorLengthMethod = new PSAngularCalculatingIteratorLengthMethod();
	public static void fillParams(Map<String, Object> params)throws Exception
	{
		params.put("srfextjsdatatype", psVue2DataTypeMethod);
		params.put("filename", psVue2FileNameMethod);
		params.put("iteratorlength", psCalculatingIteratorLengthMethod);
		
	}
}
