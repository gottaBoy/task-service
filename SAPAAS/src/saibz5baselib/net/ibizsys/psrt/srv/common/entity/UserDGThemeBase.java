/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserDGThemeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(UserDGThemeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATAGRIDID = "DATAGRIDID";
    public static final String FIELD_DGTHEMEMODEL = "DGTHEMEMODEL";
    public static final String FIELD_PERSONID = "PERSONID";
    public static final String FIELD_PROJECTID = "PROJECTID";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDGTHEMEID = "USERDGTHEMEID";
    public static final String FIELD_USERDGTHEMENAME = "USERDGTHEMENAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DATAGRIDID = 2;
    private static final int INDEX_DGTHEMEMODEL = 3;
    private static final int INDEX_PERSONID = 4;
    private static final int INDEX_PROJECTID = 5;
    private static final int INDEX_RESERVER = 6;
    private static final int INDEX_RESERVER2 = 7;
    private static final int INDEX_RESERVER3 = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERDGTHEMEID = 11;
    private static final int INDEX_USERDGTHEMENAME = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private UserDGThemeBase proxyUserDGThemeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datagrididDirtyFlag = false;
    private boolean dgthememodelDirtyFlag = false;
    private boolean personidDirtyFlag = false;
    private boolean projectidDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdgthemeidDirtyFlag = false;
    private boolean userdgthemenameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datagridid")
    private String datagridid;
    @Column(name="dgthememodel")
    private String dgthememodel;
    @Column(name="personid")
    private String personid;
    @Column(name="projectid")
    private String projectid;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdgthemeid")
    private String userdgthemeid;
    @Column(name="userdgthemename")
    private String userdgthemename;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DATAGRIDID, 2);
        fieldIndexMap.put(FIELD_DGTHEMEMODEL, 3);
        fieldIndexMap.put(FIELD_PERSONID, 4);
        fieldIndexMap.put(FIELD_PROJECTID, 5);
        fieldIndexMap.put(FIELD_RESERVER, 6);
        fieldIndexMap.put(FIELD_RESERVER2, 7);
        fieldIndexMap.put(FIELD_RESERVER3, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERDGTHEMEID, 11);
        fieldIndexMap.put(FIELD_USERDGTHEMENAME, 12);
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setDataGridId(String datagridid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataGridId(datagridid);
            return;
        }
        if (datagridid != null && (datagridid = StringHelper.trimRight(datagridid)).length() == 0) {
            datagridid = null;
        }
        this.datagridid = datagridid;
        this.datagrididDirtyFlag = true;
    }

    public String getDataGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataGridId();
        }
        return this.datagridid;
    }

    public boolean isDataGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataGridIdDirty();
        }
        return this.datagrididDirtyFlag;
    }

    public void resetDataGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataGridId();
            return;
        }
        this.datagrididDirtyFlag = false;
        this.datagridid = null;
    }

    public void setDGThemeModel(String dgthememodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDGThemeModel(dgthememodel);
            return;
        }
        if (dgthememodel != null && (dgthememodel = StringHelper.trimRight(dgthememodel)).length() == 0) {
            dgthememodel = null;
        }
        this.dgthememodel = dgthememodel;
        this.dgthememodelDirtyFlag = true;
    }

    public String getDGThemeModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDGThemeModel();
        }
        return this.dgthememodel;
    }

    public boolean isDGThemeModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDGThemeModelDirty();
        }
        return this.dgthememodelDirtyFlag;
    }

    public void resetDGThemeModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDGThemeModel();
            return;
        }
        this.dgthememodelDirtyFlag = false;
        this.dgthememodel = null;
    }

    public void setPersonId(String personid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPersonId(personid);
            return;
        }
        if (personid != null && (personid = StringHelper.trimRight(personid)).length() == 0) {
            personid = null;
        }
        this.personid = personid;
        this.personidDirtyFlag = true;
    }

    public String getPersonId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPersonId();
        }
        return this.personid;
    }

    public boolean isPersonIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPersonIdDirty();
        }
        return this.personidDirtyFlag;
    }

    public void resetPersonId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPersonId();
            return;
        }
        this.personidDirtyFlag = false;
        this.personid = null;
    }

    public void setProjectId(String projectid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProjectId(projectid);
            return;
        }
        if (projectid != null && (projectid = StringHelper.trimRight(projectid)).length() == 0) {
            projectid = null;
        }
        this.projectid = projectid;
        this.projectidDirtyFlag = true;
    }

    public String getProjectId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProjectId();
        }
        return this.projectid;
    }

    public boolean isProjectIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProjectIdDirty();
        }
        return this.projectidDirtyFlag;
    }

    public void resetProjectId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProjectId();
            return;
        }
        this.projectidDirtyFlag = false;
        this.projectid = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUserDGThemeId(String userdgthemeid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDGThemeId(userdgthemeid);
            return;
        }
        if (userdgthemeid != null && (userdgthemeid = StringHelper.trimRight(userdgthemeid)).length() == 0) {
            userdgthemeid = null;
        }
        this.userdgthemeid = userdgthemeid;
        this.userdgthemeidDirtyFlag = true;
    }

    public String getUserDGThemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDGThemeId();
        }
        return this.userdgthemeid;
    }

    public boolean isUserDGThemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDGThemeIdDirty();
        }
        return this.userdgthemeidDirtyFlag;
    }

    public void resetUserDGThemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDGThemeId();
            return;
        }
        this.userdgthemeidDirtyFlag = false;
        this.userdgthemeid = null;
    }

    public void setUserDGThemeName(String userdgthemename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDGThemeName(userdgthemename);
            return;
        }
        if (userdgthemename != null && (userdgthemename = StringHelper.trimRight(userdgthemename)).length() == 0) {
            userdgthemename = null;
        }
        this.userdgthemename = userdgthemename;
        this.userdgthemenameDirtyFlag = true;
    }

    public String getUserDGThemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDGThemeName();
        }
        return this.userdgthemename;
    }

    public boolean isUserDGThemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDGThemeNameDirty();
        }
        return this.userdgthemenameDirtyFlag;
    }

    public void resetUserDGThemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDGThemeName();
            return;
        }
        this.userdgthemenameDirtyFlag = false;
        this.userdgthemename = null;
    }

    @Override
    protected void onReset() {
        UserDGThemeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(UserDGThemeBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDataGridId();
        et.resetDGThemeModel();
        et.resetPersonId();
        et.resetProjectId();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserDGThemeId();
        et.resetUserDGThemeName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDataGridIdDirty()) {
            params.put(FIELD_DATAGRIDID, this.getDataGridId());
        }
        if (!bDirtyOnly || this.isDGThemeModelDirty()) {
            params.put(FIELD_DGTHEMEMODEL, this.getDGThemeModel());
        }
        if (!bDirtyOnly || this.isPersonIdDirty()) {
            params.put(FIELD_PERSONID, this.getPersonId());
        }
        if (!bDirtyOnly || this.isProjectIdDirty()) {
            params.put(FIELD_PROJECTID, this.getProjectId());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserDGThemeIdDirty()) {
            params.put(FIELD_USERDGTHEMEID, this.getUserDGThemeId());
        }
        if (!bDirtyOnly || this.isUserDGThemeNameDirty()) {
            params.put(FIELD_USERDGTHEMENAME, this.getUserDGThemeName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return UserDGThemeBase.get(this, index);
    }

    private static Object get(UserDGThemeBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDataGridId();
            }
            case 3: {
                return et.getDGThemeModel();
            }
            case 4: {
                return et.getPersonId();
            }
            case 5: {
                return et.getProjectId();
            }
            case 6: {
                return et.getReserver();
            }
            case 7: {
                return et.getReserver2();
            }
            case 8: {
                return et.getReserver3();
            }
            case 9: {
                return et.getUpdateDate();
            }
            case 10: {
                return et.getUpdateMan();
            }
            case 11: {
                return et.getUserDGThemeId();
            }
            case 12: {
                return et.getUserDGThemeName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        UserDGThemeBase.set(this, index, objValue);
    }

    private static void set(UserDGThemeBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setDataGridId(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setDGThemeModel(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setPersonId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setProjectId(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 10: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserDGThemeId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserDGThemeName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return UserDGThemeBase.isNull(this, index);
    }

    private static boolean isNull(UserDGThemeBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDataGridId() == null;
            }
            case 3: {
                return et.getDGThemeModel() == null;
            }
            case 4: {
                return et.getPersonId() == null;
            }
            case 5: {
                return et.getProjectId() == null;
            }
            case 6: {
                return et.getReserver() == null;
            }
            case 7: {
                return et.getReserver2() == null;
            }
            case 8: {
                return et.getReserver3() == null;
            }
            case 9: {
                return et.getUpdateDate() == null;
            }
            case 10: {
                return et.getUpdateMan() == null;
            }
            case 11: {
                return et.getUserDGThemeId() == null;
            }
            case 12: {
                return et.getUserDGThemeName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return UserDGThemeBase.contains(this, index);
    }

    private static boolean contains(UserDGThemeBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDataGridIdDirty();
            }
            case 3: {
                return et.isDGThemeModelDirty();
            }
            case 4: {
                return et.isPersonIdDirty();
            }
            case 5: {
                return et.isProjectIdDirty();
            }
            case 6: {
                return et.isReserverDirty();
            }
            case 7: {
                return et.isReserver2Dirty();
            }
            case 8: {
                return et.isReserver3Dirty();
            }
            case 9: {
                return et.isUpdateDateDirty();
            }
            case 10: {
                return et.isUpdateManDirty();
            }
            case 11: {
                return et.isUserDGThemeIdDirty();
            }
            case 12: {
                return et.isUserDGThemeNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        UserDGThemeBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(UserDGThemeBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", UserDGThemeBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", UserDGThemeBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDataGridId() != null) {
            JSONObjectHelper.put(json, "datagridid", UserDGThemeBase.getJSONValue(et.getDataGridId()), false);
        }
        if (bIncEmpty || et.getDGThemeModel() != null) {
            JSONObjectHelper.put(json, "dgthememodel", UserDGThemeBase.getJSONValue(et.getDGThemeModel()), false);
        }
        if (bIncEmpty || et.getPersonId() != null) {
            JSONObjectHelper.put(json, "personid", UserDGThemeBase.getJSONValue(et.getPersonId()), false);
        }
        if (bIncEmpty || et.getProjectId() != null) {
            JSONObjectHelper.put(json, "projectid", UserDGThemeBase.getJSONValue(et.getProjectId()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", UserDGThemeBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", UserDGThemeBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", UserDGThemeBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", UserDGThemeBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", UserDGThemeBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserDGThemeId() != null) {
            JSONObjectHelper.put(json, "userdgthemeid", UserDGThemeBase.getJSONValue(et.getUserDGThemeId()), false);
        }
        if (bIncEmpty || et.getUserDGThemeName() != null) {
            JSONObjectHelper.put(json, "userdgthemename", UserDGThemeBase.getJSONValue(et.getUserDGThemeName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        UserDGThemeBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(UserDGThemeBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataGridId() != null) {
            obj = et.getDataGridId();
            node.setAttribute(FIELD_DATAGRIDID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDGThemeModel() != null) {
            obj = et.getDGThemeModel();
            node.setAttribute(FIELD_DGTHEMEMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPersonId() != null) {
            obj = et.getPersonId();
            node.setAttribute(FIELD_PERSONID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getProjectId() != null) {
            obj = et.getProjectId();
            node.setAttribute(FIELD_PROJECTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDGThemeId() != null) {
            obj = et.getUserDGThemeId();
            node.setAttribute(FIELD_USERDGTHEMEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDGThemeName() != null) {
            obj = et.getUserDGThemeName();
            node.setAttribute(FIELD_USERDGTHEMENAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        UserDGThemeBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(UserDGThemeBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDataGridIdDirty() && (bIncEmpty || et.getDataGridId() != null)) {
            dst.set(FIELD_DATAGRIDID, et.getDataGridId());
        }
        if (et.isDGThemeModelDirty() && (bIncEmpty || et.getDGThemeModel() != null)) {
            dst.set(FIELD_DGTHEMEMODEL, et.getDGThemeModel());
        }
        if (et.isPersonIdDirty() && (bIncEmpty || et.getPersonId() != null)) {
            dst.set(FIELD_PERSONID, et.getPersonId());
        }
        if (et.isProjectIdDirty() && (bIncEmpty || et.getProjectId() != null)) {
            dst.set(FIELD_PROJECTID, et.getProjectId());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserDGThemeIdDirty() && (bIncEmpty || et.getUserDGThemeId() != null)) {
            dst.set(FIELD_USERDGTHEMEID, et.getUserDGThemeId());
        }
        if (et.isUserDGThemeNameDirty() && (bIncEmpty || et.getUserDGThemeName() != null)) {
            dst.set(FIELD_USERDGTHEMENAME, et.getUserDGThemeName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return UserDGThemeBase.remove(this, index);
    }

    private static boolean remove(UserDGThemeBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetDataGridId();
                return true;
            }
            case 3: {
                et.resetDGThemeModel();
                return true;
            }
            case 4: {
                et.resetPersonId();
                return true;
            }
            case 5: {
                et.resetProjectId();
                return true;
            }
            case 6: {
                et.resetReserver();
                return true;
            }
            case 7: {
                et.resetReserver2();
                return true;
            }
            case 8: {
                et.resetReserver3();
                return true;
            }
            case 9: {
                et.resetUpdateDate();
                return true;
            }
            case 10: {
                et.resetUpdateMan();
                return true;
            }
            case 11: {
                et.resetUserDGThemeId();
                return true;
            }
            case 12: {
                et.resetUserDGThemeName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private UserDGThemeBase getProxyEntity() {
        return this.proxyUserDGThemeBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyUserDGThemeBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof UserDGThemeBase) {
            this.proxyUserDGThemeBase = (UserDGThemeBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserDGThemeService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

