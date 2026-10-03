package net.ibizsys.paas.ctrlmodel.form;

/**
 * 默认动态表单分组模型对象
 * @author Administrator
 *
 */
public class DynaFormGroupModel extends DynaFormGroupModelBase implements IDynaFormGroupModel {

	@Override
	public String getDetailType() {
		return IDynaFormDetailModel.DETAILTYPE_GROUPPANEL;
	}

}
