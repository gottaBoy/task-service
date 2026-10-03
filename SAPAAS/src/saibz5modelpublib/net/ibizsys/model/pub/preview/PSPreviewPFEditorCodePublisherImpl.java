package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSPFEditorCodePublisherImpl;

public class PSPreviewPFEditorCodePublisherImpl extends PSPFEditorCodePublisherImpl {
	private static PSPreviewFileNameMethod psPreViewPCFileNameMethod = new PSPreviewFileNameMethod();
	private static PSPreviewPanelItemLogicMethod psPreviewPanelItemLogicMethod = new PSPreviewPanelItemLogicMethod();
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params ) throws Exception
	{
		params.put("filename", psPreViewPCFileNameMethod);
		params.put("srfpanelitemlogic", psPreviewPanelItemLogicMethod);
	}
}
