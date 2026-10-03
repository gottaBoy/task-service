package net.ibizsys.paas.ctrlmodel.form;

/**
 * 默认动态表单分页模型对象
 * @author Administrator
 *
 */
public class DynaFormPageModel extends DynaFormGroupModelBase implements IDynaFormPageModel{

	@Override
	public String getDetailType() {
		return IDynaFormDetailModel.DETAILTYPE_FORMPAGE;
	}

}
