package net.ibizsys.model.pub.preview;

import java.util.List;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
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
public class PSPreviewDataTypeMethod implements TemplateMethodModel
{
	public PSPreviewDataTypeMethod()
	{
		super();
	}


	public Object exec(List arg0) throws TemplateModelException
	{
		if(arg0.size()==0)
			return StringHelper.Format("/*%1$s*/","没有指定数据类型");
		
		try
		{
			int nDataType = Integer.parseInt((String) arg0.get(0));
			
			/**
			 * 判断是否为字符串类型
			 * 
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.IsStringType(nDataType))
				return "string";
			
			/**
			 * 是否为长字符串类型
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.IsLongStringType(nDataType))
				return "string";
			
			
			/**
			 * 是否为长字符串类型
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.IsDateTimeType(nDataType))
				return "date";
			
			/**
			 * 是否为长字符串类型
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.IsIntType(nDataType))
				return "int";
			
			
			/**
			 * 是否为长字符串类型
			 * @param dataType
			 * @return
			 */
			if(DataTypeHelper.IsDoubleType(nDataType))
				return "number";
			
			
			return "auto";
		}
		catch (Exception e)
		{
			throw new TemplateModelException(e);
		}
		
	}



}
