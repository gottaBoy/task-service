/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.cache.IUniState;
import net.ibizsys.paas.cache.IUniStateManager;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.StringHelper;

public abstract class UniStateModelBase
extends SystemModelObjectBase
implements IUniStateModel {
    private String strUniqueTag = null;
    private String strDEName = null;
    private String strKeyField = null;
    private String strFolderField = null;
    private String strFolder2Field = null;
    private String strFolder3Field = null;
    private String strStateField = null;
    private String strState2Field = null;
    private String strState3Field = null;
    private String strState4Field = null;
    private String strState5Field = null;
    private String strState6Field = null;
    private String strState7Field = null;
    private String strState8Field = null;
    private HashMap<String, String> stateFieldMap = new HashMap();
    private String[] statefields = null;
    private String[] folderfields = null;
    private boolean bEnabled = false;
    private IUniStateManager iUniStateManager = null;

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.setSystemModel(iSystemModel);
        this.stateFieldMap.put("STATE", this.getStateField());
        this.stateFieldMap.put("STATE2", this.getState2Field());
        this.stateFieldMap.put("STATE3", this.getState3Field());
        this.stateFieldMap.put("STATE4", this.getState4Field());
        this.stateFieldMap.put("STATE5", this.getState5Field());
        this.stateFieldMap.put("STATE6", this.getState6Field());
        this.stateFieldMap.put("STATE7", this.getState7Field());
        this.stateFieldMap.put("STATE8", this.getState8Field());
        ArrayList<String> stateFieldsList = new ArrayList<String>();
        if (!StringHelper.isNullOrEmpty(this.getStateField())) {
            stateFieldsList.add(this.getStateField());
        }
        if (!StringHelper.isNullOrEmpty(this.getState2Field())) {
            stateFieldsList.add(this.getState2Field());
        }
        if (!StringHelper.isNullOrEmpty(this.getState3Field())) {
            stateFieldsList.add(this.getState3Field());
        }
        if (!StringHelper.isNullOrEmpty(this.getState4Field())) {
            stateFieldsList.add(this.getState4Field());
        }
        if (!StringHelper.isNullOrEmpty(this.getState5Field())) {
            stateFieldsList.add(this.getState5Field());
        }
        if (!StringHelper.isNullOrEmpty(this.getState6Field())) {
            stateFieldsList.add(this.getState6Field());
        }
        if (!StringHelper.isNullOrEmpty(this.getState7Field())) {
            stateFieldsList.add(this.getState7Field());
        }
        if (!StringHelper.isNullOrEmpty(this.getState8Field())) {
            stateFieldsList.add(this.getState8Field());
        }
        this.statefields = stateFieldsList.toArray(new String[stateFieldsList.size()]);
        ArrayList<String> folderFieldsList = new ArrayList<String>();
        if (!StringHelper.isNullOrEmpty(this.getFolderField())) {
            folderFieldsList.add(this.getFolderField());
        }
        if (!StringHelper.isNullOrEmpty(this.getFolder2Field())) {
            folderFieldsList.add(this.getFolder2Field());
        }
        if (!StringHelper.isNullOrEmpty(this.getFolder3Field())) {
            folderFieldsList.add(this.getFolder3Field());
        }
        this.folderfields = folderFieldsList.toArray(new String[folderFieldsList.size()]);
        this.onInit();
        if (this.getSystemModel().getUniStateManager() != null) {
            this.iUniStateManager = this.getSystemModel().getUniStateManager();
            this.iUniStateManager.regUniState(this);
            this.bEnabled = true;
        }
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    public void setUniqueTag(String strUniqueTag) {
        this.strUniqueTag = strUniqueTag;
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    @Override
    public String getKeyField() {
        return this.strKeyField;
    }

    public void setKeyField(String strKeyField) {
        this.strKeyField = strKeyField;
    }

    @Override
    public String getFolderField() {
        return this.strFolderField;
    }

    public void setFolderField(String strFolderField) {
        this.strFolderField = strFolderField;
    }

    @Override
    public String getFolder2Field() {
        return this.strFolder2Field;
    }

    public void setFolder2Field(String strFolder2Field) {
        this.strFolder2Field = strFolder2Field;
    }

    @Override
    public String getFolder3Field() {
        return this.strFolder3Field;
    }

    public void setFolder3Field(String strFolder3Field) {
        this.strFolder3Field = strFolder3Field;
    }

    @Override
    public String getStateField() {
        return this.strStateField;
    }

    public void setStateField(String strStateField) {
        this.strStateField = strStateField;
    }

    @Override
    public String getState2Field() {
        return this.strState2Field;
    }

    public void setState2Field(String strState2Field) {
        this.strState2Field = strState2Field;
    }

    @Override
    public String getState3Field() {
        return this.strState3Field;
    }

    public void setState3Field(String strState3Field) {
        this.strState3Field = strState3Field;
    }

    @Override
    public String getState4Field() {
        return this.strState4Field;
    }

    public void setState4Field(String strState4Field) {
        this.strState4Field = strState4Field;
    }

    @Override
    public String getState5Field() {
        return this.strState5Field;
    }

    public void setState5Field(String strState5Field) {
        this.strState5Field = strState5Field;
    }

    @Override
    public String getState6Field() {
        return this.strState6Field;
    }

    public void setState6Field(String strState6Field) {
        this.strState6Field = strState6Field;
    }

    @Override
    public String getState7Field() {
        return this.strState7Field;
    }

    public void setState7Field(String strState7Field) {
        this.strState7Field = strState7Field;
    }

    @Override
    public String getState8Field() {
        return this.strState8Field;
    }

    public void setState8Field(String strState8Field) {
        this.strState8Field = strState8Field;
    }

    @Override
    public String[] getFolderFields() {
        return this.folderfields;
    }

    @Override
    public String[] getStateFields() {
        return this.statefields;
    }

    @Override
    public boolean contains(Object objKey) throws Exception {
        this.testEnabled();
        return this.getUniStateManager().containsEntity((IUniState)this, objKey);
    }

    @Override
    public boolean isEnabled() {
        return this.bEnabled;
    }

    protected IUniStateManager getUniStateManager() {
        return this.iUniStateManager;
    }

    protected void testEnabled() throws Exception {
        if (!this.isEnabled()) {
            throw new Exception(StringHelper.format("\u7edf\u4e00\u72b6\u6001\u5bf9\u8c61[%1$s]\u6ca1\u6709\u542f\u7528", this.getName()));
        }
    }

    @Override
    public void update(IEntity iEntity) throws Exception {
        this.testEnabled();
        this.getUniStateManager().updateEntity(this, iEntity);
    }

    @Override
    public void remove(Object objKey) throws Exception {
        this.testEnabled();
        this.getUniStateManager().removeEntity((IUniState)this, objKey);
    }
}

