/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList
 */
package net.ibizsys.paas.sysmodel;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.DynaCodeItemModel;
import net.ibizsys.paas.sysmodel.IDynaCodeListModel;
import net.ibizsys.paas.sysmodel.IDynaCodeListModelContainer;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList;

public class DefaultDynaStaticCodeListModel
extends StaticCodeListModelBase
implements IDynaCodeListModel {
    private String strDynaInstId = null;
    private ObjectNode modelJsonObject = null;
    private DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
    private IDynaCodeListModelContainer iDynaCodeListModelContainer = null;

    @Override
    public void init(IDynaCodeListModelContainer iDynaCodeListModelContainer, IEntity iEntity) throws Exception {
        iEntity.copyTo((IDataObject)this.dsDynaCodeList, false);
        this.iDynaCodeListModelContainer = iDynaCodeListModelContainer;
        this.strId = this.dsDynaCodeList.getDSDynaCodeListId();
        this.strName = this.dsDynaCodeList.getDSDynaCodeListName();
        this.strDynaInstId = this.dsDynaCodeList.getDynaSysInstId();
        if (!StringHelper.isNullOrEmpty((String)this.dsDynaCodeList.getDynaModel())) {
            ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)this.dsDynaCodeList.getDynaModel());
            this.loadJsonObject(objectNode);
        }
    }

    @Override
    public String getDynaInstId() {
        return this.strDynaInstId;
    }

    @Override
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        ArrayNode arrayNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"items");
        if (arrayNode != null) {
            int nSize = arrayNode.size();
            int i = 0;
            while (i < nSize) {
                ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
                DynaCodeItemModel iDynaCodeItemModel = new DynaCodeItemModel();
                iDynaCodeItemModel.init(this, null, itemNode);
                this.registerCodeItemModel(iDynaCodeItemModel);
                ++i;
            }
        }
    }

    protected ObjectNode getModelJsonObject() {
        return this.modelJsonObject;
    }

    public ISystem getSystem() {
        return this.iDynaCodeListModelContainer.getSystem();
    }

    public String getCodeListType() {
        return this.iDynaCodeListModelContainer.getCodeListType();
    }

    public String getOrMode() {
        return this.iDynaCodeListModelContainer.getOrMode();
    }

    public String getValueSeparator() {
        return this.iDynaCodeListModelContainer.getValueSeparator();
    }

    public String getTextSeparator() {
        return this.iDynaCodeListModelContainer.getTextSeparator();
    }

    public String getEmptyText() {
        return this.iDynaCodeListModelContainer.getEmptyText();
    }

    public boolean isUserScope() {
        return this.iDynaCodeListModelContainer.isUserScope();
    }
}

