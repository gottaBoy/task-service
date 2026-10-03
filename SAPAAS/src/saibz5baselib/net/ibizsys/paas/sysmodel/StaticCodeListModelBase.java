package net.ibizsys.paas.sysmodel;

import java.lang.annotation.Annotation;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.util.StringHelper;

/**
 * 静态代码表模型
 * 
 * @author Administrator
 *
 */
public abstract class StaticCodeListModelBase extends CodeListModelBase {
	/**
	 * 初始化注解
	 * 
	 * @param c
	 * @throws Exception
	 */
	@Override
	protected void initAnnotation(Class c) {

		super.initAnnotation(c);
		Annotation[] annotations = c.getAnnotations();
		if (annotations != null) {
			for (Annotation annotation : annotations) {
				if (annotation instanceof CodeItems) {
					prepareCodeItems((CodeItems) annotation);
					continue;
				}
			}
		}
	}

	/**
	 * 准备代码表项
	 * 
	 * @param codeItems
	 */
	protected void prepareCodeItems(CodeItems codeItems) {

		for (CodeItem codeItem : codeItems.value()) {
			CodeItemModel codeItemModel = createCodeItemModel(codeItem);
			this.registerCodeItemModel(codeItemModel);
		}
	}

	/**
	 * 建立代码表项
	 * 
	 * @param codeItem
	 * @return
	 */
	protected CodeItemModel createCodeItemModel(CodeItem codeItem) {
		CodeItemModel codeItemModel = new CodeItemModel();
		if (StringHelper.isNullOrEmpty(codeItem.parentvalue())) {
			codeItemModel.init(this, null, codeItem);
		} else {
			codeItemModel.init(this, this.getCodeItemModel(codeItem.parentvalue()), codeItem);
		}
		return codeItemModel;
	}

}
