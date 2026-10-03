package net.ibizsys.sswf.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Workflow service entity metadata.
 */
public class WFServiceEntity {

	private String strWFServiceEntityId;
	private String strWFServiceEntityName;
	private final List<WFServiceEntityView> views = new ArrayList<WFServiceEntityView>();
	private final List<WFServiceEntityForm> forms = new ArrayList<WFServiceEntityForm>();

	public String getWFServiceEntityId() {
		return strWFServiceEntityId;
	}

	public void setWFServiceEntityId(String strWFServiceEntityId) {
		this.strWFServiceEntityId = strWFServiceEntityId;
	}

	public String getWFServiceEntityName() {
		return strWFServiceEntityName;
	}

	public void setWFServiceEntityName(String strWFServiceEntityName) {
		this.strWFServiceEntityName = strWFServiceEntityName;
	}

	public List<WFServiceEntityView> getViews() {
		return views;
	}

	public List<WFServiceEntityForm> getForms() {
		return forms;
	}
}
