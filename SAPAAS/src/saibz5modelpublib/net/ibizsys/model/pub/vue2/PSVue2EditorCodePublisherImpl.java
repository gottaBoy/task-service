package net.ibizsys.model.pub.vue2;

import java.util.HashMap;

import net.ibizsys.model.pub.PSPFEditorCodePublisherImpl;

public class PSVue2EditorCodePublisherImpl extends PSPFEditorCodePublisherImpl
{
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		PSVue2TemplHelper.fillParams(params);
		super.onFillGenerateCodeParams(params);
		
	}
}
