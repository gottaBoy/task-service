package net.ibizsys.paas.util.freemarker;

import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;

/**
 * 代码表方法
 * 
 * @author Administrator
 *
 */
public class CodeListMethod implements TemplateMethodModel {
	
	public CodeListMethod() {
	}

	public Object exec(List arg0) throws TemplateModelException {
		try {
			
			if (arg0.size() != 2) {
				throw new Exception(StringHelper.format("传入参数不正确"));
			}
			
			String strCodeListId = arg0.get(0).toString();
			String strKey = arg0.get(1).toString();
			
			return CodeListGlobal.getCodeList(strCodeListId).getCodeListText(strKey, true);

		} catch (Exception ex) {
			throw new TemplateModelException(ex);
		}

	}

}
