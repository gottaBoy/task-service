/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFUserCandidateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUserCandidateBase.class);
    public static final String FIELD_CANDIDATEORDER = "CANDIDATEORDER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_WFMAJORUSERID = "WFMAJORUSERID";
    public static final String FIELD_WFMAJORUSERNAME = "WFMAJORUSERNAME";
    public static final String FIELD_WFMINORUSERID = "WFMINORUSERID";
    public static final String FIELD_WFMINORUSERNAME = "WFMINORUSERNAME";
    public static final String FIELD_WFUSERCANDIDATEID = "WFUSERCANDIDATEID";
    public static final String FIELD_WFUSERCANDIDATENAME = "WFUSERCANDIDATENAME";
    private static final int INDEX_CANDIDATEORDER = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final int INDEX_USERDATA = 6;
    private static final int INDEX_USERDATA2 = 7;
    private static final int INDEX_WFMAJORUSERID = 8;
    private static final int INDEX_WFMAJORUSERNAME = 9;
    private static final int INDEX_WFMINORUSERID = 10;
    private static final int INDEX_WFMINORUSERNAME = 11;
    private static final int INDEX_WFUSERCANDIDATEID = 12;
    private static final int INDEX_WFUSERCANDIDATENAME = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFUserCandidateBase proxyWFUserCandidateBase = null;
    private boolean candidateorderDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean wfmajoruseridDirtyFlag = false;
    private boolean wfmajorusernameDirtyFlag = false;
    private boolean wfminoruseridDirtyFlag = false;
    private boolean wfminorusernameDirtyFlag = false;
    private boolean wfusercandidateidDirtyFlag = false;
    private boolean wfusercandidatenameDirtyFlag = false;
    @Column(name="candidateorder")
    private Integer candidateorder;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="wfmajoruserid")
    private String wfmajoruserid;
    @Column(name="wfmajorusername")
    private String wfmajorusername;
    @Column(name="wfminoruserid")
    private String wfminoruserid;
    @Column(name="wfminorusername")
    private String wfminorusername;
    @Column(name="wfusercandidateid")
    private String wfusercandidateid;
    @Column(name="wfusercandidatename")
    private String wfusercandidatename;
    private Integer objWFMajorUserLock = new Integer(1);
    private WFUser wfmajoruser = null;
    private Integer objWFMinorUserLock = new Integer(1);
    private WFUser wfminoruser = null;

    static {
        fieldIndexMap.put(FIELD_CANDIDATEORDER, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
        fieldIndexMap.put(FIELD_USERDATA, 6);
        fieldIndexMap.put(FIELD_USERDATA2, 7);
        fieldIndexMap.put(FIELD_WFMAJORUSERID, 8);
        fieldIndexMap.put(FIELD_WFMAJORUSERNAME, 9);
        fieldIndexMap.put(FIELD_WFMINORUSERID, 10);
        fieldIndexMap.put(FIELD_WFMINORUSERNAME, 11);
        fieldIndexMap.put(FIELD_WFUSERCANDIDATEID, 12);
        fieldIndexMap.put(FIELD_WFUSERCANDIDATENAME, 13);
    }

    public void setCandidateOrder(Integer candidateorder) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCandidateOrder(candidateorder);
            return;
        }
        this.candidateorder = candidateorder;
        this.candidateorderDirtyFlag = true;
    }

    public Integer getCandidateOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCandidateOrder();
        }
        return this.candidateorder;
    }

    public boolean isCandidateOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCandidateOrderDirty();
        }
        return this.candidateorderDirtyFlag;
    }

    public void resetCandidateOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCandidateOrder();
            return;
        }
        this.candidateorderDirtyFlag = false;
        this.candidateorder = null;
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

    public void setUserData(String userdata) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if (userdata != null && (userdata = StringHelper.trimRight(userdata)).length() == 0) {
            userdata = null;
        }
        this.userdata = userdata;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String userdata2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if (userdata2 != null && (userdata2 = StringHelper.trimRight(userdata2)).length() == 0) {
            userdata2 = null;
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }

    public void setWFMajorUserId(String wfmajoruserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMajorUserId(wfmajoruserid);
            return;
        }
        if (wfmajoruserid != null && (wfmajoruserid = StringHelper.trimRight(wfmajoruserid)).length() == 0) {
            wfmajoruserid = null;
        }
        this.wfmajoruserid = wfmajoruserid;
        this.wfmajoruseridDirtyFlag = true;
    }

    public String getWFMajorUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMajorUserId();
        }
        return this.wfmajoruserid;
    }

    public boolean isWFMajorUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFMajorUserIdDirty();
        }
        return this.wfmajoruseridDirtyFlag;
    }

    public void resetWFMajorUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMajorUserId();
            return;
        }
        this.wfmajoruseridDirtyFlag = false;
        this.wfmajoruserid = null;
    }

    public void setWFMajorUserName(String wfmajorusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMajorUserName(wfmajorusername);
            return;
        }
        if (wfmajorusername != null && (wfmajorusername = StringHelper.trimRight(wfmajorusername)).length() == 0) {
            wfmajorusername = null;
        }
        this.wfmajorusername = wfmajorusername;
        this.wfmajorusernameDirtyFlag = true;
    }

    public String getWFMajorUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMajorUserName();
        }
        return this.wfmajorusername;
    }

    public boolean isWFMajorUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFMajorUserNameDirty();
        }
        return this.wfmajorusernameDirtyFlag;
    }

    public void resetWFMajorUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMajorUserName();
            return;
        }
        this.wfmajorusernameDirtyFlag = false;
        this.wfmajorusername = null;
    }

    public void setWFMinorUserId(String wfminoruserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMinorUserId(wfminoruserid);
            return;
        }
        if (wfminoruserid != null && (wfminoruserid = StringHelper.trimRight(wfminoruserid)).length() == 0) {
            wfminoruserid = null;
        }
        this.wfminoruserid = wfminoruserid;
        this.wfminoruseridDirtyFlag = true;
    }

    public String getWFMinorUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMinorUserId();
        }
        return this.wfminoruserid;
    }

    public boolean isWFMinorUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFMinorUserIdDirty();
        }
        return this.wfminoruseridDirtyFlag;
    }

    public void resetWFMinorUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMinorUserId();
            return;
        }
        this.wfminoruseridDirtyFlag = false;
        this.wfminoruserid = null;
    }

    public void setWFMinorUserName(String wfminorusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMinorUserName(wfminorusername);
            return;
        }
        if (wfminorusername != null && (wfminorusername = StringHelper.trimRight(wfminorusername)).length() == 0) {
            wfminorusername = null;
        }
        this.wfminorusername = wfminorusername;
        this.wfminorusernameDirtyFlag = true;
    }

    public String getWFMinorUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMinorUserName();
        }
        return this.wfminorusername;
    }

    public boolean isWFMinorUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFMinorUserNameDirty();
        }
        return this.wfminorusernameDirtyFlag;
    }

    public void resetWFMinorUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMinorUserName();
            return;
        }
        this.wfminorusernameDirtyFlag = false;
        this.wfminorusername = null;
    }

    public void setWFUserCandidateId(String wfusercandidateid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserCandidateId(wfusercandidateid);
            return;
        }
        if (wfusercandidateid != null && (wfusercandidateid = StringHelper.trimRight(wfusercandidateid)).length() == 0) {
            wfusercandidateid = null;
        }
        this.wfusercandidateid = wfusercandidateid;
        this.wfusercandidateidDirtyFlag = true;
    }

    public String getWFUserCandidateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserCandidateId();
        }
        return this.wfusercandidateid;
    }

    public boolean isWFUserCandidateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserCandidateIdDirty();
        }
        return this.wfusercandidateidDirtyFlag;
    }

    public void resetWFUserCandidateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserCandidateId();
            return;
        }
        this.wfusercandidateidDirtyFlag = false;
        this.wfusercandidateid = null;
    }

    public void setWFUserCandidateName(String wfusercandidatename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserCandidateName(wfusercandidatename);
            return;
        }
        if (wfusercandidatename != null && (wfusercandidatename = StringHelper.trimRight(wfusercandidatename)).length() == 0) {
            wfusercandidatename = null;
        }
        this.wfusercandidatename = wfusercandidatename;
        this.wfusercandidatenameDirtyFlag = true;
    }

    public String getWFUserCandidateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserCandidateName();
        }
        return this.wfusercandidatename;
    }

    public boolean isWFUserCandidateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserCandidateNameDirty();
        }
        return this.wfusercandidatenameDirtyFlag;
    }

    public void resetWFUserCandidateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserCandidateName();
            return;
        }
        this.wfusercandidatenameDirtyFlag = false;
        this.wfusercandidatename = null;
    }

    @Override
    protected void onReset() {
        WFUserCandidateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFUserCandidateBase et) {
        et.resetCandidateOrder();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetWFMajorUserId();
        et.resetWFMajorUserName();
        et.resetWFMinorUserId();
        et.resetWFMinorUserName();
        et.resetWFUserCandidateId();
        et.resetWFUserCandidateName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCandidateOrderDirty()) {
            params.put(FIELD_CANDIDATEORDER, this.getCandidateOrder());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserDataDirty()) {
            params.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bDirtyOnly || this.isUserData2Dirty()) {
            params.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bDirtyOnly || this.isWFMajorUserIdDirty()) {
            params.put(FIELD_WFMAJORUSERID, this.getWFMajorUserId());
        }
        if (!bDirtyOnly || this.isWFMajorUserNameDirty()) {
            params.put(FIELD_WFMAJORUSERNAME, this.getWFMajorUserName());
        }
        if (!bDirtyOnly || this.isWFMinorUserIdDirty()) {
            params.put(FIELD_WFMINORUSERID, this.getWFMinorUserId());
        }
        if (!bDirtyOnly || this.isWFMinorUserNameDirty()) {
            params.put(FIELD_WFMINORUSERNAME, this.getWFMinorUserName());
        }
        if (!bDirtyOnly || this.isWFUserCandidateIdDirty()) {
            params.put(FIELD_WFUSERCANDIDATEID, this.getWFUserCandidateId());
        }
        if (!bDirtyOnly || this.isWFUserCandidateNameDirty()) {
            params.put(FIELD_WFUSERCANDIDATENAME, this.getWFUserCandidateName());
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
        return WFUserCandidateBase.get(this, index);
    }

    private static Object get(WFUserCandidateBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCandidateOrder();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getMemo();
            }
            case 4: {
                return et.getUpdateDate();
            }
            case 5: {
                return et.getUpdateMan();
            }
            case 6: {
                return et.getUserData();
            }
            case 7: {
                return et.getUserData2();
            }
            case 8: {
                return et.getWFMajorUserId();
            }
            case 9: {
                return et.getWFMajorUserName();
            }
            case 10: {
                return et.getWFMinorUserId();
            }
            case 11: {
                return et.getWFMinorUserName();
            }
            case 12: {
                return et.getWFUserCandidateId();
            }
            case 13: {
                return et.getWFUserCandidateName();
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
        WFUserCandidateBase.set(this, index, objValue);
    }

    private static void set(WFUserCandidateBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCandidateOrder(DataObject.getIntegerValue(obj));
                return;
            }
            case 1: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 2: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 5: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFMajorUserId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFMajorUserName(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWFMinorUserId(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setWFMinorUserName(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setWFUserCandidateId(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setWFUserCandidateName(DataObject.getStringValue(obj));
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
        return WFUserCandidateBase.isNull(this, index);
    }

    private static boolean isNull(WFUserCandidateBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCandidateOrder() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getMemo() == null;
            }
            case 4: {
                return et.getUpdateDate() == null;
            }
            case 5: {
                return et.getUpdateMan() == null;
            }
            case 6: {
                return et.getUserData() == null;
            }
            case 7: {
                return et.getUserData2() == null;
            }
            case 8: {
                return et.getWFMajorUserId() == null;
            }
            case 9: {
                return et.getWFMajorUserName() == null;
            }
            case 10: {
                return et.getWFMinorUserId() == null;
            }
            case 11: {
                return et.getWFMinorUserName() == null;
            }
            case 12: {
                return et.getWFUserCandidateId() == null;
            }
            case 13: {
                return et.getWFUserCandidateName() == null;
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
        return WFUserCandidateBase.contains(this, index);
    }

    private static boolean contains(WFUserCandidateBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCandidateOrderDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isMemoDirty();
            }
            case 4: {
                return et.isUpdateDateDirty();
            }
            case 5: {
                return et.isUpdateManDirty();
            }
            case 6: {
                return et.isUserDataDirty();
            }
            case 7: {
                return et.isUserData2Dirty();
            }
            case 8: {
                return et.isWFMajorUserIdDirty();
            }
            case 9: {
                return et.isWFMajorUserNameDirty();
            }
            case 10: {
                return et.isWFMinorUserIdDirty();
            }
            case 11: {
                return et.isWFMinorUserNameDirty();
            }
            case 12: {
                return et.isWFUserCandidateIdDirty();
            }
            case 13: {
                return et.isWFUserCandidateNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFUserCandidateBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFUserCandidateBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCandidateOrder() != null) {
            JSONObjectHelper.put(json, "candidateorder", WFUserCandidateBase.getJSONValue(et.getCandidateOrder()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFUserCandidateBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFUserCandidateBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFUserCandidateBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFUserCandidateBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFUserCandidateBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", WFUserCandidateBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", WFUserCandidateBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getWFMajorUserId() != null) {
            JSONObjectHelper.put(json, "wfmajoruserid", WFUserCandidateBase.getJSONValue(et.getWFMajorUserId()), false);
        }
        if (bIncEmpty || et.getWFMajorUserName() != null) {
            JSONObjectHelper.put(json, "wfmajorusername", WFUserCandidateBase.getJSONValue(et.getWFMajorUserName()), false);
        }
        if (bIncEmpty || et.getWFMinorUserId() != null) {
            JSONObjectHelper.put(json, "wfminoruserid", WFUserCandidateBase.getJSONValue(et.getWFMinorUserId()), false);
        }
        if (bIncEmpty || et.getWFMinorUserName() != null) {
            JSONObjectHelper.put(json, "wfminorusername", WFUserCandidateBase.getJSONValue(et.getWFMinorUserName()), false);
        }
        if (bIncEmpty || et.getWFUserCandidateId() != null) {
            JSONObjectHelper.put(json, "wfusercandidateid", WFUserCandidateBase.getJSONValue(et.getWFUserCandidateId()), false);
        }
        if (bIncEmpty || et.getWFUserCandidateName() != null) {
            JSONObjectHelper.put(json, "wfusercandidatename", WFUserCandidateBase.getJSONValue(et.getWFUserCandidateName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFUserCandidateBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFUserCandidateBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCandidateOrder() != null) {
            obj = et.getCandidateOrder();
            node.setAttribute(FIELD_CANDIDATEORDER, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
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
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData() != null) {
            obj = et.getUserData();
            node.setAttribute(FIELD_USERDATA, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            obj = et.getUserData2();
            node.setAttribute(FIELD_USERDATA2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFMajorUserId() != null) {
            obj = et.getWFMajorUserId();
            node.setAttribute(FIELD_WFMAJORUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFMajorUserName() != null) {
            obj = et.getWFMajorUserName();
            node.setAttribute(FIELD_WFMAJORUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFMinorUserId() != null) {
            obj = et.getWFMinorUserId();
            node.setAttribute(FIELD_WFMINORUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFMinorUserName() != null) {
            obj = et.getWFMinorUserName();
            node.setAttribute(FIELD_WFMINORUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserCandidateId() != null) {
            obj = et.getWFUserCandidateId();
            node.setAttribute(FIELD_WFUSERCANDIDATEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserCandidateName() != null) {
            obj = et.getWFUserCandidateName();
            node.setAttribute(FIELD_WFUSERCANDIDATENAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFUserCandidateBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFUserCandidateBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCandidateOrderDirty() && (bIncEmpty || et.getCandidateOrder() != null)) {
            dst.set(FIELD_CANDIDATEORDER, et.getCandidateOrder());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserDataDirty() && (bIncEmpty || et.getUserData() != null)) {
            dst.set(FIELD_USERDATA, et.getUserData());
        }
        if (et.isUserData2Dirty() && (bIncEmpty || et.getUserData2() != null)) {
            dst.set(FIELD_USERDATA2, et.getUserData2());
        }
        if (et.isWFMajorUserIdDirty() && (bIncEmpty || et.getWFMajorUserId() != null)) {
            dst.set(FIELD_WFMAJORUSERID, et.getWFMajorUserId());
        }
        if (et.isWFMajorUserNameDirty() && (bIncEmpty || et.getWFMajorUserName() != null)) {
            dst.set(FIELD_WFMAJORUSERNAME, et.getWFMajorUserName());
        }
        if (et.isWFMinorUserIdDirty() && (bIncEmpty || et.getWFMinorUserId() != null)) {
            dst.set(FIELD_WFMINORUSERID, et.getWFMinorUserId());
        }
        if (et.isWFMinorUserNameDirty() && (bIncEmpty || et.getWFMinorUserName() != null)) {
            dst.set(FIELD_WFMINORUSERNAME, et.getWFMinorUserName());
        }
        if (et.isWFUserCandidateIdDirty() && (bIncEmpty || et.getWFUserCandidateId() != null)) {
            dst.set(FIELD_WFUSERCANDIDATEID, et.getWFUserCandidateId());
        }
        if (et.isWFUserCandidateNameDirty() && (bIncEmpty || et.getWFUserCandidateName() != null)) {
            dst.set(FIELD_WFUSERCANDIDATENAME, et.getWFUserCandidateName());
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
        return WFUserCandidateBase.remove(this, index);
    }

    private static boolean remove(WFUserCandidateBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCandidateOrder();
                return true;
            }
            case 1: {
                et.resetCreateDate();
                return true;
            }
            case 2: {
                et.resetCreateMan();
                return true;
            }
            case 3: {
                et.resetMemo();
                return true;
            }
            case 4: {
                et.resetUpdateDate();
                return true;
            }
            case 5: {
                et.resetUpdateMan();
                return true;
            }
            case 6: {
                et.resetUserData();
                return true;
            }
            case 7: {
                et.resetUserData2();
                return true;
            }
            case 8: {
                et.resetWFMajorUserId();
                return true;
            }
            case 9: {
                et.resetWFMajorUserName();
                return true;
            }
            case 10: {
                et.resetWFMinorUserId();
                return true;
            }
            case 11: {
                et.resetWFMinorUserName();
                return true;
            }
            case 12: {
                et.resetWFUserCandidateId();
                return true;
            }
            case 13: {
                et.resetWFUserCandidateName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUser getWFMajorUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMajorUser();
        }
        if (this.getWFMajorUserId() == null) {
            return null;
        }
        Integer n = this.objWFMajorUserLock;
        synchronized (n) {
            if (this.wfmajoruser != null && DataTypeHelper.compare(25, (Object)this.getWFMajorUserId(), (Object)this.wfmajoruser.getWFUserId()) != 0L) {
                this.wfmajoruser = null;
            }
            if (this.wfmajoruser == null) {
                WFUser wfmajoruser = new WFUser();
                wfmajoruser.setWFUserId(this.getWFMajorUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(wfmajoruser);
                this.wfmajoruser = wfmajoruser;
            }
            return this.wfmajoruser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUser getWFMinorUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMinorUser();
        }
        if (this.getWFMinorUserId() == null) {
            return null;
        }
        Integer n = this.objWFMinorUserLock;
        synchronized (n) {
            if (this.wfminoruser != null && DataTypeHelper.compare(25, (Object)this.getWFMinorUserId(), (Object)this.wfminoruser.getWFUserId()) != 0L) {
                this.wfminoruser = null;
            }
            if (this.wfminoruser == null) {
                WFUser wfminoruser = new WFUser();
                wfminoruser.setWFUserId(this.getWFMinorUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(wfminoruser);
                this.wfminoruser = wfminoruser;
            }
            return this.wfminoruser;
        }
    }

    private WFUserCandidateBase getProxyEntity() {
        return this.proxyWFUserCandidateBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUserCandidateBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFUserCandidateBase) {
            this.proxyWFUserCandidateBase = (WFUserCandidateBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserCandidateService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

