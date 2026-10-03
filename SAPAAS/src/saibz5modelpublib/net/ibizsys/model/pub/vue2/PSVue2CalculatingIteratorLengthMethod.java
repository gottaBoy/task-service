package net.ibizsys.model.pub.vue2;

import java.util.List;

import freemarker.template.SimpleCollection;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateModelIterator;

/**
 * 
 * @author Administrator
 *
 */
public class PSVue2CalculatingIteratorLengthMethod implements TemplateMethodModelEx {
	public Integer exec(List arg0) throws TemplateModelException {
		if(arg0.size()==0) {
			return 0;
		}
		SimpleCollection iteratorObj = (SimpleCollection)arg0.get(0);
		TemplateModelIterator iterator = iteratorObj.iterator();
		int num = 0;
		while (iterator.hasNext()) {
			iterator.next();
			++num;
		}
		return num;
	}
}
