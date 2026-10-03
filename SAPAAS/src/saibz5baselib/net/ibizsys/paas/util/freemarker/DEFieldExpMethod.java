package net.ibizsys.paas.util.freemarker;

import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.util.StringHelper;

/**
 * 实体属性表达式方法
 * 
 * @author Administrator
 *
 */
public class DEFieldExpMethod implements TemplateMethodModel {
	private IDEDataQueryCode iDEDataQueryCode = null;

	public DEFieldExpMethod(IDEDataQueryCode iDEDataQueryCode) {
		this.iDEDataQueryCode = iDEDataQueryCode;
	}

	public Object exec(List arg0) throws TemplateModelException {
		try {
			if (arg0.size() == 0) {
				throw new Exception(StringHelper.format("没有指定当前数据参数"));
			}

			String strKey = arg0.get(0).toString().toUpperCase();

			String strExp = iDEDataQueryCode.getDEFieldExp(strKey, false);
			return strExp;
		} catch (Exception ex) {
			throw new TemplateModelException(ex);
		}

	}

}
