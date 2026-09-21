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

public abstract class RegistryBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(RegistryBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM1 = "PARAM1";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PARAM9 = "PARAM9";
    public static final String FIELD_REGISTRYID = "REGISTRYID";
    public static final String FIELD_REGISTRYNAME = "REGISTRYNAME";
    public static final String FIELD_SECTOR = "SECTION";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PARAM1 = 3;
    private static final int INDEX_PARAM2 = 4;
    private static final int INDEX_PARAM3 = 5;
    private static final int INDEX_PARAM4 = 6;
    private static final int INDEX_PARAM5 = 7;
    private static final int INDEX_PARAM6 = 8;
    private static final int INDEX_PARAM7 = 9;
    private static final int INDEX_PARAM8 = 10;
    private static final int INDEX_PARAM9 = 11;
    private static final int INDEX_REGISTRYID = 12;
    private static final int INDEX_REGISTRYNAME = 13;
    private static final int INDEX_SECTOR = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private RegistryBase proxyRegistryBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean param1DirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean param9DirtyFlag = false;
    private boolean registryidDirtyFlag = false;
    private boolean registrynameDirtyFlag = false;
    private boolean sectorDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="param1")
    private String param1;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private String param5;
    @Column(name="param6")
    private String param6;
    @Column(name="param7")
    private String param7;
    @Column(name="param8")
    private String param8;
    @Column(name="param9")
    private String param9;
    @Column(name="registryid")
    private String registryid;
    @Column(name="registryname")
    private String registryname;
    @Column(name="sector")
    private String sector;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PARAM1, 3);
        fieldIndexMap.put(FIELD_PARAM2, 4);
        fieldIndexMap.put(FIELD_PARAM3, 5);
        fieldIndexMap.put(FIELD_PARAM4, 6);
        fieldIndexMap.put(FIELD_PARAM5, 7);
        fieldIndexMap.put(FIELD_PARAM6, 8);
        fieldIndexMap.put(FIELD_PARAM7, 9);
        fieldIndexMap.put(FIELD_PARAM8, 10);
        fieldIndexMap.put(FIELD_PARAM9, 11);
        fieldIndexMap.put(FIELD_REGISTRYID, 12);
        fieldIndexMap.put(FIELD_REGISTRYNAME, 13);
        fieldIndexMap.put(FIELD_SECTOR, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
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

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setParam1(String param1) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam1(param1);
            return;
        }
        if (param1 != null && (param1 = StringHelper.trimRight(param1)).length() == 0) {
            param1 = null;
        }
        this.param1 = param1;
        this.param1DirtyFlag = true;
    }

    public String getParam1() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam1();
        }
        return this.param1;
    }

    public boolean isParam1Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam1Dirty();
        }
        return this.param1DirtyFlag;
    }

    public void resetParam1() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam1();
            return;
        }
        this.param1DirtyFlag = false;
        this.param1 = null;
    }

    public void setParam2(String param2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(param2);
            return;
        }
        if (param2 != null && (param2 = StringHelper.trimRight(param2)).length() == 0) {
            param2 = null;
        }
        this.param2 = param2;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String param3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(param3);
            return;
        }
        if (param3 != null && (param3 = StringHelper.trimRight(param3)).length() == 0) {
            param3 = null;
        }
        this.param3 = param3;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String param4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(param4);
            return;
        }
        if (param4 != null && (param4 = StringHelper.trimRight(param4)).length() == 0) {
            param4 = null;
        }
        this.param4 = param4;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(String param5) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(param5);
            return;
        }
        if (param5 != null && (param5 = StringHelper.trimRight(param5)).length() == 0) {
            param5 = null;
        }
        this.param5 = param5;
        this.param5DirtyFlag = true;
    }

    public String getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(String param6) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(param6);
            return;
        }
        if (param6 != null && (param6 = StringHelper.trimRight(param6)).length() == 0) {
            param6 = null;
        }
        this.param6 = param6;
        this.param6DirtyFlag = true;
    }

    public String getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(String param7) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(param7);
            return;
        }
        if (param7 != null && (param7 = StringHelper.trimRight(param7)).length() == 0) {
            param7 = null;
        }
        this.param7 = param7;
        this.param7DirtyFlag = true;
    }

    public String getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(String param8) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(param8);
            return;
        }
        if (param8 != null && (param8 = StringHelper.trimRight(param8)).length() == 0) {
            param8 = null;
        }
        this.param8 = param8;
        this.param8DirtyFlag = true;
    }

    public String getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
    }

    public void setParam9(String param9) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam9(param9);
            return;
        }
        if (param9 != null && (param9 = StringHelper.trimRight(param9)).length() == 0) {
            param9 = null;
        }
        this.param9 = param9;
        this.param9DirtyFlag = true;
    }

    public String getParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam9();
        }
        return this.param9;
    }

    public boolean isParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam9Dirty();
        }
        return this.param9DirtyFlag;
    }

    public void resetParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam9();
            return;
        }
        this.param9DirtyFlag = false;
        this.param9 = null;
    }

    public void setRegistryId(String registryid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryId(registryid);
            return;
        }
        if (registryid != null && (registryid = StringHelper.trimRight(registryid)).length() == 0) {
            registryid = null;
        }
        this.registryid = registryid;
        this.registryidDirtyFlag = true;
    }

    public String getRegistryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryId();
        }
        return this.registryid;
    }

    public boolean isRegistryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryIdDirty();
        }
        return this.registryidDirtyFlag;
    }

    public void resetRegistryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryId();
            return;
        }
        this.registryidDirtyFlag = false;
        this.registryid = null;
    }

    public void setRegistryName(String registryname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegistryName(registryname);
            return;
        }
        if (registryname != null && (registryname = StringHelper.trimRight(registryname)).length() == 0) {
            registryname = null;
        }
        this.registryname = registryname;
        this.registrynameDirtyFlag = true;
    }

    public String getRegistryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegistryName();
        }
        return this.registryname;
    }

    public boolean isRegistryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegistryNameDirty();
        }
        return this.registrynameDirtyFlag;
    }

    public void resetRegistryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegistryName();
            return;
        }
        this.registrynameDirtyFlag = false;
        this.registryname = null;
    }

    public void setSector(String sector) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSector(sector);
            return;
        }
        if (sector != null && (sector = StringHelper.trimRight(sector)).length() == 0) {
            sector = null;
        }
        this.sector = sector;
        this.sectorDirtyFlag = true;
    }

    public String getSector() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSector();
        }
        return this.sector;
    }

    public boolean isSectorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSectorDirty();
        }
        return this.sectorDirtyFlag;
    }

    public void resetSector() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSector();
            return;
        }
        this.sectorDirtyFlag = false;
        this.sector = null;
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

    @Override
    protected void onReset() {
        RegistryBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(RegistryBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetParam1();
        et.resetParam2();
        et.resetParam3();
        et.resetParam4();
        et.resetParam5();
        et.resetParam6();
        et.resetParam7();
        et.resetParam8();
        et.resetParam9();
        et.resetRegistryId();
        et.resetRegistryName();
        et.resetSector();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isParam1Dirty()) {
            params.put(FIELD_PARAM1, this.getParam1());
        }
        if (!bDirtyOnly || this.isParam2Dirty()) {
            params.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bDirtyOnly || this.isParam3Dirty()) {
            params.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bDirtyOnly || this.isParam4Dirty()) {
            params.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bDirtyOnly || this.isParam5Dirty()) {
            params.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bDirtyOnly || this.isParam6Dirty()) {
            params.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bDirtyOnly || this.isParam7Dirty()) {
            params.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bDirtyOnly || this.isParam8Dirty()) {
            params.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bDirtyOnly || this.isParam9Dirty()) {
            params.put(FIELD_PARAM9, this.getParam9());
        }
        if (!bDirtyOnly || this.isRegistryIdDirty()) {
            params.put(FIELD_REGISTRYID, this.getRegistryId());
        }
        if (!bDirtyOnly || this.isRegistryNameDirty()) {
            params.put(FIELD_REGISTRYNAME, this.getRegistryName());
        }
        if (!bDirtyOnly || this.isSectorDirty()) {
            params.put(FIELD_SECTOR, this.getSector());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return RegistryBase.get(this, index);
    }

    private static Object get(RegistryBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getMemo();
            }
            case 3: {
                return et.getParam1();
            }
            case 4: {
                return et.getParam2();
            }
            case 5: {
                return et.getParam3();
            }
            case 6: {
                return et.getParam4();
            }
            case 7: {
                return et.getParam5();
            }
            case 8: {
                return et.getParam6();
            }
            case 9: {
                return et.getParam7();
            }
            case 10: {
                return et.getParam8();
            }
            case 11: {
                return et.getParam9();
            }
            case 12: {
                return et.getRegistryId();
            }
            case 13: {
                return et.getRegistryName();
            }
            case 14: {
                return et.getSector();
            }
            case 15: {
                return et.getUpdateDate();
            }
            case 16: {
                return et.getUpdateMan();
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
        RegistryBase.set(this, index, objValue);
    }

    private static void set(RegistryBase et, int index, Object obj) throws Exception {
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
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setParam1(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setParam2(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setParam3(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setParam4(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setParam5(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setParam6(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setParam7(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setParam8(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setParam9(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setRegistryId(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setRegistryName(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setSector(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 16: {
                et.setUpdateMan(DataObject.getStringValue(obj));
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
        return RegistryBase.isNull(this, index);
    }

    private static boolean isNull(RegistryBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getMemo() == null;
            }
            case 3: {
                return et.getParam1() == null;
            }
            case 4: {
                return et.getParam2() == null;
            }
            case 5: {
                return et.getParam3() == null;
            }
            case 6: {
                return et.getParam4() == null;
            }
            case 7: {
                return et.getParam5() == null;
            }
            case 8: {
                return et.getParam6() == null;
            }
            case 9: {
                return et.getParam7() == null;
            }
            case 10: {
                return et.getParam8() == null;
            }
            case 11: {
                return et.getParam9() == null;
            }
            case 12: {
                return et.getRegistryId() == null;
            }
            case 13: {
                return et.getRegistryName() == null;
            }
            case 14: {
                return et.getSector() == null;
            }
            case 15: {
                return et.getUpdateDate() == null;
            }
            case 16: {
                return et.getUpdateMan() == null;
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
        return RegistryBase.contains(this, index);
    }

    private static boolean contains(RegistryBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isMemoDirty();
            }
            case 3: {
                return et.isParam1Dirty();
            }
            case 4: {
                return et.isParam2Dirty();
            }
            case 5: {
                return et.isParam3Dirty();
            }
            case 6: {
                return et.isParam4Dirty();
            }
            case 7: {
                return et.isParam5Dirty();
            }
            case 8: {
                return et.isParam6Dirty();
            }
            case 9: {
                return et.isParam7Dirty();
            }
            case 10: {
                return et.isParam8Dirty();
            }
            case 11: {
                return et.isParam9Dirty();
            }
            case 12: {
                return et.isRegistryIdDirty();
            }
            case 13: {
                return et.isRegistryNameDirty();
            }
            case 14: {
                return et.isSectorDirty();
            }
            case 15: {
                return et.isUpdateDateDirty();
            }
            case 16: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        RegistryBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(RegistryBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", RegistryBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", RegistryBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", RegistryBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getParam1() != null) {
            JSONObjectHelper.put(json, "param1", RegistryBase.getJSONValue(et.getParam1()), false);
        }
        if (bIncEmpty || et.getParam2() != null) {
            JSONObjectHelper.put(json, "param2", RegistryBase.getJSONValue(et.getParam2()), false);
        }
        if (bIncEmpty || et.getParam3() != null) {
            JSONObjectHelper.put(json, "param3", RegistryBase.getJSONValue(et.getParam3()), false);
        }
        if (bIncEmpty || et.getParam4() != null) {
            JSONObjectHelper.put(json, "param4", RegistryBase.getJSONValue(et.getParam4()), false);
        }
        if (bIncEmpty || et.getParam5() != null) {
            JSONObjectHelper.put(json, "param5", RegistryBase.getJSONValue(et.getParam5()), false);
        }
        if (bIncEmpty || et.getParam6() != null) {
            JSONObjectHelper.put(json, "param6", RegistryBase.getJSONValue(et.getParam6()), false);
        }
        if (bIncEmpty || et.getParam7() != null) {
            JSONObjectHelper.put(json, "param7", RegistryBase.getJSONValue(et.getParam7()), false);
        }
        if (bIncEmpty || et.getParam8() != null) {
            JSONObjectHelper.put(json, "param8", RegistryBase.getJSONValue(et.getParam8()), false);
        }
        if (bIncEmpty || et.getParam9() != null) {
            JSONObjectHelper.put(json, "param9", RegistryBase.getJSONValue(et.getParam9()), false);
        }
        if (bIncEmpty || et.getRegistryId() != null) {
            JSONObjectHelper.put(json, "registryid", RegistryBase.getJSONValue(et.getRegistryId()), false);
        }
        if (bIncEmpty || et.getRegistryName() != null) {
            JSONObjectHelper.put(json, "registryname", RegistryBase.getJSONValue(et.getRegistryName()), false);
        }
        if (bIncEmpty || et.getSector() != null) {
            JSONObjectHelper.put(json, "section", RegistryBase.getJSONValue(et.getSector()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", RegistryBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", RegistryBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        RegistryBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(RegistryBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam1() != null) {
            obj = et.getParam1();
            node.setAttribute(FIELD_PARAM1, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam2() != null) {
            obj = et.getParam2();
            node.setAttribute(FIELD_PARAM2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam3() != null) {
            obj = et.getParam3();
            node.setAttribute(FIELD_PARAM3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam4() != null) {
            obj = et.getParam4();
            node.setAttribute(FIELD_PARAM4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam5() != null) {
            obj = et.getParam5();
            node.setAttribute(FIELD_PARAM5, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam6() != null) {
            obj = et.getParam6();
            node.setAttribute(FIELD_PARAM6, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam7() != null) {
            obj = et.getParam7();
            node.setAttribute(FIELD_PARAM7, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam8() != null) {
            obj = et.getParam8();
            node.setAttribute(FIELD_PARAM8, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam9() != null) {
            obj = et.getParam9();
            node.setAttribute(FIELD_PARAM9, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRegistryId() != null) {
            obj = et.getRegistryId();
            node.setAttribute(FIELD_REGISTRYID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRegistryName() != null) {
            obj = et.getRegistryName();
            node.setAttribute(FIELD_REGISTRYNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSector() != null) {
            obj = et.getSector();
            node.setAttribute("SECTOR", obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        RegistryBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(RegistryBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isParam1Dirty() && (bIncEmpty || et.getParam1() != null)) {
            dst.set(FIELD_PARAM1, et.getParam1());
        }
        if (et.isParam2Dirty() && (bIncEmpty || et.getParam2() != null)) {
            dst.set(FIELD_PARAM2, et.getParam2());
        }
        if (et.isParam3Dirty() && (bIncEmpty || et.getParam3() != null)) {
            dst.set(FIELD_PARAM3, et.getParam3());
        }
        if (et.isParam4Dirty() && (bIncEmpty || et.getParam4() != null)) {
            dst.set(FIELD_PARAM4, et.getParam4());
        }
        if (et.isParam5Dirty() && (bIncEmpty || et.getParam5() != null)) {
            dst.set(FIELD_PARAM5, et.getParam5());
        }
        if (et.isParam6Dirty() && (bIncEmpty || et.getParam6() != null)) {
            dst.set(FIELD_PARAM6, et.getParam6());
        }
        if (et.isParam7Dirty() && (bIncEmpty || et.getParam7() != null)) {
            dst.set(FIELD_PARAM7, et.getParam7());
        }
        if (et.isParam8Dirty() && (bIncEmpty || et.getParam8() != null)) {
            dst.set(FIELD_PARAM8, et.getParam8());
        }
        if (et.isParam9Dirty() && (bIncEmpty || et.getParam9() != null)) {
            dst.set(FIELD_PARAM9, et.getParam9());
        }
        if (et.isRegistryIdDirty() && (bIncEmpty || et.getRegistryId() != null)) {
            dst.set(FIELD_REGISTRYID, et.getRegistryId());
        }
        if (et.isRegistryNameDirty() && (bIncEmpty || et.getRegistryName() != null)) {
            dst.set(FIELD_REGISTRYNAME, et.getRegistryName());
        }
        if (et.isSectorDirty() && (bIncEmpty || et.getSector() != null)) {
            dst.set(FIELD_SECTOR, et.getSector());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
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
        return RegistryBase.remove(this, index);
    }

    private static boolean remove(RegistryBase et, int index) throws Exception {
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
                et.resetMemo();
                return true;
            }
            case 3: {
                et.resetParam1();
                return true;
            }
            case 4: {
                et.resetParam2();
                return true;
            }
            case 5: {
                et.resetParam3();
                return true;
            }
            case 6: {
                et.resetParam4();
                return true;
            }
            case 7: {
                et.resetParam5();
                return true;
            }
            case 8: {
                et.resetParam6();
                return true;
            }
            case 9: {
                et.resetParam7();
                return true;
            }
            case 10: {
                et.resetParam8();
                return true;
            }
            case 11: {
                et.resetParam9();
                return true;
            }
            case 12: {
                et.resetRegistryId();
                return true;
            }
            case 13: {
                et.resetRegistryName();
                return true;
            }
            case 14: {
                et.resetSector();
                return true;
            }
            case 15: {
                et.resetUpdateDate();
                return true;
            }
            case 16: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private RegistryBase getProxyEntity() {
        return this.proxyRegistryBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyRegistryBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof RegistryBase) {
            this.proxyRegistryBase = (RegistryBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.RegistryService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

