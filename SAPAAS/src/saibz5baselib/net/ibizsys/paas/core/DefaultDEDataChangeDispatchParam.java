/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataChangeDispatchParam;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.DEDataChg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DefaultDEDataChangeDispatchParam
implements IDEDataChangeDispatchParam {
    private DEDataChg deDataChg = null;
    private IDataEntity iDataEntity = null;
    private IEntity logicData = null;
    private ArrayList<IEntity> relatedEntityList = null;

    public DefaultDEDataChangeDispatchParam(IDataEntity iDataEntity, DEDataChg deDataChg) throws Exception {
        this.setDataEntity(iDataEntity);
        this.setDEDataChg(deDataChg);
    }

    @Override
    public DEDataChg getDEDataChg() {
        return this.deDataChg;
    }

    protected void setDEDataChg(DEDataChg deDataChg) throws Exception {
        this.deDataChg = deDataChg;
        this.logicData = null;
        if (this.deDataChg == null) {
            return;
        }
        this.logicData = this.getDataEntity() == null ? new SimpleEntity() : ((IDataEntityModel)this.getDataEntity()).createEntity();
        DataObject.fromJSONObject(this.logicData, JSONObjectHelper.fromString(this.deDataChg.getLogicData()));
        if (!StringHelper.isNullOrEmpty(this.deDataChg.getData())) {
            this.relatedEntityList = new ArrayList();
            JSONArray jsonArray = JSONArray.fromString((String)this.deDataChg.getData());
            int i = 0;
            while (i < jsonArray.length()) {
                JSONObject jo = jsonArray.getJSONObject(i);
                SimpleEntity iEntity = new SimpleEntity();
                DataObject.fromJSONObject(iEntity, jo);
                this.relatedEntityList.add(iEntity);
                ++i;
            }
        }
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    @Override
    public IEntity getEntity() {
        return this.logicData;
    }

    @Override
    public Iterator<IEntity> getRelatedEntities() {
        if (this.relatedEntityList == null) {
            return null;
        }
        return this.relatedEntityList.iterator();
    }
}

