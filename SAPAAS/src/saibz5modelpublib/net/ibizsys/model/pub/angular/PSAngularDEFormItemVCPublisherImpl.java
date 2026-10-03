package net.ibizsys.model.pub.angular;

import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFEditorCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.res.IPSSysEditorStyleRuntime;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.paas.util.StringHelper;

/**
 * JQ实体表单项视图代码发布对象
 * @author Administrator
 *
 */
public class PSAngularDEFormItemVCPublisherImpl extends PSAngularDEFormDetailVCPublisherImpl
{
	protected IPSDEFormItem iPSDEFormItem = null;

	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEFormItem = (IPSDEFormItem)object;
		return super.generateCode(iPSControl, object);
	}

	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);

		// 根据发布代码类型，优先使用编辑器插件提供的代码。
		IPSEditorType iPSEditorType =
				this.getPSModelStorageContext().getPSEditorType(iPSDEFormItem.getEditorType());
		IPSSysPFPlugin iPSSysPFPlugin = null;
		if(iPSDEFormItem.getPSSysEditorStyle() != null)
		{
			iPSSysPFPlugin =
					((IPSSysEditorStyleRuntime)iPSDEFormItem.getPSSysEditorStyle()).getPSSysPFPlugin();
		}

		if(iPSSysPFPlugin != null)
		{
			String strCodeName = "";
			if(StringHelper.compare(this.getPSPFPubCode().getName(), "HTML", true) == 0)
			{
				strCodeName = "CODE";
			}
			else if(StringHelper.compare(this.getPSPFPubCode().getName(), "SERVICE_TS", true) == 0)
			{
				strCodeName = "CODE2";
			}

			if(!StringHelper.isNullOrEmpty(strCodeName))
			{
				String strCode = iPSSysPFPlugin.getCode(strCodeName, this.iPSPF.getId(),
						this.iPSPFStyle.getId(), this.iPSAppView, this.iPSControl, iPSDEFormItem);
				if(!StringHelper.isNullOrEmpty(strCode))
				{
					PSGenerateCodeResultImpl psGenerateCodeResult = new PSGenerateCodeResultImpl();
					psGenerateCodeResult.setObject(iPSDEFormItem);
					psGenerateCodeResult.setCode(strCode);
					params.put("editor", psGenerateCodeResult);
					return;
				}
			}
		}

		// 插件未提供代码时，使用当前发布风格的编辑器模板。
		IPSPFEditorTempl iPSPFEditorTempl =
				this.iPSPFStyle.getPSPFEditorTempl(iPSEditorType,
						PSPFEditorTempl.CONTAINERTYPE_FORMITEM, this.getPSPFPubCode());
		if(iPSPFEditorTempl != null)
		{
			IPSPFEditorCodePublisher psPFEditorCodePublisher =
					iPSPFEditorTempl.getPSPFEditorCodePublisher();
			if(psPFEditorCodePublisher != null)
			{
				IPSGenerateCodeResult iPSGenerateCodeResult =
						psPFEditorCodePublisher.generateCode(this.iPSControl, iPSDEFormItem);
				params.put("editor", iPSGenerateCodeResult);
			}
		}
	}

}
