package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.DEDataChg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 默认实体数据变更派发参数
 * 
 * @author LionLau
 *
 */

public class DefaultDEDataChangeDispatchParam implements IDEDataChangeDispatchParam {
	private DEDataChg deDataChg = null;
	// private XMLNode xmlNode = null;
	private IDataEntity iDataEntity = null;
	private IEntity logicData = null;
	private ArrayList<IEntity> relatedEntityList = null;

	public DefaultDEDataChangeDispatchParam(IDataEntity iDataEntity, DEDataChg deDataChg) throws Exception {
		this.setDataEntity(iDataEntity);
		this.setDEDataChg(deDataChg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.Ctrl.IDEDataChangeDispatchParam#getDEDataChg()
	 */
	public DEDataChg getDEDataChg() {
		return this.deDataChg;
	}

	/**
	 * 设置实体数据变更对象
	 * 
	 * @param deDataChg
	 */
	protected void setDEDataChg(DEDataChg deDataChg) throws Exception {
		this.deDataChg = deDataChg;
		this.logicData = null;

		if (this.deDataChg == null) return;

		if (this.getDataEntity() == null) {
			this.logicData = new SimpleEntity();
		} else {
			this.logicData = ((IDataEntityModel) this.getDataEntity()).createEntity();// new SimpleEntity();
		}

		DataObject.fromJSONObject(this.logicData, JSONObjectHelper.fromString(this.deDataChg.getLogicData()));

		if (!StringHelper.isNullOrEmpty(this.deDataChg.getData())) {
			this.relatedEntityList = new ArrayList<IEntity>();
			JSONArray jsonArray = JSONArray.fromString(this.deDataChg.getData());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jo = jsonArray.getJSONObject(i);
				SimpleEntity iEntity = new SimpleEntity();
				DataObject.fromJSONObject(iEntity, jo);
				this.relatedEntityList.add(iEntity);
			}
		}
	}

	/**
	 * 获取实体辅助对象
	 * 
	 * @return
	 */
	public IDataEntity getDataEntity() {
		return this.iDataEntity;
	}

	/**
	 * 设置实体辅助对象
	 * 
	 * @param iDataEntity
	 */
	protected void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataChangeDispatchParam#getEntity()
	 */
	@Override
	public IEntity getEntity() {
		return this.logicData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataChangeDispatchParam#getRelatedEntities()
	 */
	@Override
	public Iterator<IEntity> getRelatedEntities() {
		if (relatedEntityList == null) return null;
		return relatedEntityList.iterator();
	}

}
