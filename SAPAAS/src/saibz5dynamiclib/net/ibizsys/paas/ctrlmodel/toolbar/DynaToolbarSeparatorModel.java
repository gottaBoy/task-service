package net.ibizsys.paas.ctrlmodel.toolbar;

/**
 * 默认动态工具栏分隔栏模型对象
 * @author Administrator
 *
 */
public class DynaToolbarSeparatorModel extends DynaToolbarItemModelBase implements IDynaToolbarSeparatorModel{

	@Override
	public String getItemType() {
		return ITEMTYPE_SEPARATOR;
	}

}
