package net.ibizsys.model.pub.vue2;

import java.util.List;

import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 属性宏变量，属性名，格式化，默认值
 * auto (Default, implies no conversion)
	string
	int
	number
	boolean
	date
 * @author Administrator
 *
 */
public class PSVue2DataTypeMethod implements TemplateMethodModel
{
	public PSVue2DataTypeMethod()
	{
		super();
	}


	public Object exec(List arg0) throws TemplateModelException
	{
		if(arg0.size()==0)
			return StringHelper.format("/*%1$s*/","没有指定数据类型");
		
		try
		{
			int nDataType = Integer.parseInt((String) arg0.get(0));
			
			/**
			 * 判断是否为字符串类型
			 * 
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.isStringType(nDataType))
				return "string";
			
			/**
			 * 是否为长字符串类型
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.isLongStringType(nDataType))
				return "string";
			
			
			/**
			 * 是否为长字符串类型
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.isDateTimeType(nDataType))
				return "date";
			
			/**
			 * 是否为长字符串类型
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.isIntType(nDataType))
				return "int";
			
			
			/**
			 * 是否为长字符串类型
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.isDoubleType(nDataType))
				return "number";
			
			
			return "auto";
		}
		catch (Exception e)
		{
			throw new TemplateModelException(e);
		}
		
	}



}
