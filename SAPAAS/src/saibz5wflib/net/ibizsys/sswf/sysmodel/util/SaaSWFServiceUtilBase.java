package net.ibizsys.sswf.sysmodel.util;

import java.util.ArrayList;

import net.ibizsys.paas.sysmodel.SystemUtilBase;
import net.ibizsys.sswf.api.SaaSWFActionParam;
import net.ibizsys.sswf.entity.WFProxyEntity;
import net.ibizsys.sswf.entity.WFServiceEntity;

/**
 * Base service utility for SaaS workflow integration.
 */
public abstract class SaaSWFServiceUtilBase extends SystemUtilBase {

	public abstract ArrayList<WFServiceEntity> getWFServiceEntities() throws Exception;

	/**
	 * Resolve a workflow proxy target. Concrete deployments may enrich the
	 * returned metadata with an application-specific view URL.
	 */
	public WFProxyEntity getProxyEntity(SaaSWFActionParam wfParam) throws Exception {
		return new WFProxyEntity();
	}
}
