package net.ibizsys.sswf.sysmodel.util;

import java.util.ArrayList;

import net.ibizsys.paas.sysmodel.SystemUtilBase;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.sswf.api.SaaSWFActionParam;
import net.ibizsys.sswf.entity.WFServiceEntity;

/**
 * Base system utility for SaaS workflow integration.
 */
public abstract class SaaSWFUtilBase extends SystemUtilBase {

	public abstract ArrayList<WFServiceEntity> getWFServiceEntities() throws Exception;

	protected IWFModel getWFModel(SaaSWFActionParam wfParam) throws Exception {
		if (wfParam == null || wfParam.getWorkflowId() == null) {
			return null;
		}
		return getSystemModel().getWFModel(wfParam.getWorkflowId(), true);
	}
}
