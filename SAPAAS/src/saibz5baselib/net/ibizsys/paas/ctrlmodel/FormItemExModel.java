package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 复合表单项模型对象
 * @author Administrator
 *
 */
public class FormItemExModel extends FormItemModel implements IFormItemExModel {

	private ArrayList<String> itemNameList = null;
	
	@Override
	public Iterator<String> getItemNames() {
		if(this.itemNameList == null || this.itemNameList.size() == 0)
			return null;
		return this.itemNameList.iterator();
	}
	
	@Override
	public void registerItemName(String strItemName) {
		if(this.itemNameList == null) {
			this.itemNameList = new ArrayList<String>();
		}
		this.itemNameList.add(strItemName);
	}

}
