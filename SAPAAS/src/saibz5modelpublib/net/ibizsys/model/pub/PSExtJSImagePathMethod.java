package net.ibizsys.model.pub;

import java.util.List;

import net.ibizsys.paas.util.StringHelper;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;


/**
 * ExtJS 图片路径辅助方法
 * @author Administrator
 *
 */
public class PSExtJSImagePathMethod implements TemplateMethodModel
{
	public PSExtJSImagePathMethod()
	{
		super();
	}


	public Object exec(List arg0) throws TemplateModelException
	{
		if(arg0.size()==0)
			return StringHelper.format("/*%1$s*/","没有指定数据类型");
		
		try
		{
			String strImagePath = arg0.get(0).toString();
			if(StringHelper.isNullOrEmpty(strImagePath))
				return strImagePath;
			
			if ((strImagePath.indexOf('/') == 0) || (strImagePath.indexOf("../") == 0) || (strImagePath.indexOf("://") != -1)) {
				return strImagePath;
			}
			
			return "resources/images/" + strImagePath;
		}
		catch (Exception e)
		{
			throw new TemplateModelException(e);
		}
		
	}



}
