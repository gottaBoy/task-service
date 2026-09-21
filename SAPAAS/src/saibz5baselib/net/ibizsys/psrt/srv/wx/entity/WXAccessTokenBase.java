/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wx.entity;

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
import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import net.ibizsys.psrt.srv.wx.service.WXAccountService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WXAccessTokenBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXAccessTokenBase.class);
    public static final String FIELD_ACCESSTOKEN = "ACCESSTOKEN";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPIREDTIME = "EXPIREDTIME";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WXACCESSTOKENID = "WXACCESSTOKENID";
    public static final String FIELD_WXACCESSTOKENNAME = "WXACCESSTOKENNAME";
    public static final String FIELD_WXACCOUNTID = "WXACCOUNTID";
    public static final String FIELD_WXACCOUNTNAME = "WXACCOUNTNAME";
    private static final int INDEX_ACCESSTOKEN = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_EXPIREDTIME = 3;
    private static final int INDEX_RESERVER = 4;
    private static final int INDEX_RESERVER2 = 5;
    private static final int INDEX_RESERVER3 = 6;
    private static final int INDEX_RESERVER4 = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_WXACCESSTOKENID = 10;
    private static final int INDEX_WXACCESSTOKENNAME = 11;
    private static final int INDEX_WXACCOUNTID = 12;
    private static final int INDEX_WXACCOUNTNAME = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WXAccessTokenBase proxyWXAccessTokenBase = null;
    private boolean accesstokenDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expiredtimeDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wxaccesstokenidDirtyFlag = false;
    private boolean wxaccesstokennameDirtyFlag = false;
    private boolean wxaccountidDirtyFlag = false;
    private boolean wxaccountnameDirtyFlag = false;
    @Column(name="accesstoken")
    private String accesstoken;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expiredtime")
    private Timestamp expiredtime;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wxaccesstokenid")
    private String wxaccesstokenid;
    @Column(name="wxaccesstokenname")
    private String wxaccesstokenname;
    @Column(name="wxaccountid")
    private String wxaccountid;
    @Column(name="wxaccountname")
    private String wxaccountname;
    private Integer objWxaccountLock = new Integer(1);
    private WXAccount wxaccount = null;

    static {
        fieldIndexMap.put(FIELD_ACCESSTOKEN, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EXPIREDTIME, 3);
        fieldIndexMap.put(FIELD_RESERVER, 4);
        fieldIndexMap.put(FIELD_RESERVER2, 5);
        fieldIndexMap.put(FIELD_RESERVER3, 6);
        fieldIndexMap.put(FIELD_RESERVER4, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_WXACCESSTOKENID, 10);
        fieldIndexMap.put(FIELD_WXACCESSTOKENNAME, 11);
        fieldIndexMap.put(FIELD_WXACCOUNTID, 12);
        fieldIndexMap.put(FIELD_WXACCOUNTNAME, 13);
    }

    public void setAccessToken(String accesstoken) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAccessToken(accesstoken);
            return;
        }
        if (accesstoken != null && (accesstoken = StringHelper.trimRight(accesstoken)).length() == 0) {
            accesstoken = null;
        }
        this.accesstoken = accesstoken;
        this.accesstokenDirtyFlag = true;
    }

    public String getAccessToken() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAccessToken();
        }
        return this.accesstoken;
    }

    public boolean isAccessTokenDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAccessTokenDirty();
        }
        return this.accesstokenDirtyFlag;
    }

    public void resetAccessToken() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAccessToken();
            return;
        }
        this.accesstokenDirtyFlag = false;
        this.accesstoken = null;
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

    public void setExpiredTime(Timestamp expiredtime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpiredTime(expiredtime);
            return;
        }
        this.expiredtime = expiredtime;
        this.expiredtimeDirtyFlag = true;
    }

    public Timestamp getExpiredTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpiredTime();
        }
        return this.expiredtime;
    }

    public boolean isExpiredTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpiredTimeDirty();
        }
        return this.expiredtimeDirtyFlag;
    }

    public void resetExpiredTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpiredTime();
            return;
        }
        this.expiredtimeDirtyFlag = false;
        this.expiredtime = null;
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

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
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

    public void setWXAccessTokenId(String wxaccesstokenid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccessTokenId(wxaccesstokenid);
            return;
        }
        if (wxaccesstokenid != null && (wxaccesstokenid = StringHelper.trimRight(wxaccesstokenid)).length() == 0) {
            wxaccesstokenid = null;
        }
        this.wxaccesstokenid = wxaccesstokenid;
        this.wxaccesstokenidDirtyFlag = true;
    }

    public String getWXAccessTokenId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccessTokenId();
        }
        return this.wxaccesstokenid;
    }

    public boolean isWXAccessTokenIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccessTokenIdDirty();
        }
        return this.wxaccesstokenidDirtyFlag;
    }

    public void resetWXAccessTokenId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccessTokenId();
            return;
        }
        this.wxaccesstokenidDirtyFlag = false;
        this.wxaccesstokenid = null;
    }

    public void setWXAccessTokenName(String wxaccesstokenname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccessTokenName(wxaccesstokenname);
            return;
        }
        if (wxaccesstokenname != null && (wxaccesstokenname = StringHelper.trimRight(wxaccesstokenname)).length() == 0) {
            wxaccesstokenname = null;
        }
        this.wxaccesstokenname = wxaccesstokenname;
        this.wxaccesstokennameDirtyFlag = true;
    }

    public String getWXAccessTokenName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccessTokenName();
        }
        return this.wxaccesstokenname;
    }

    public boolean isWXAccessTokenNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccessTokenNameDirty();
        }
        return this.wxaccesstokennameDirtyFlag;
    }

    public void resetWXAccessTokenName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccessTokenName();
            return;
        }
        this.wxaccesstokennameDirtyFlag = false;
        this.wxaccesstokenname = null;
    }

    public void setWXAccountId(String wxaccountid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccountId(wxaccountid);
            return;
        }
        if (wxaccountid != null && (wxaccountid = StringHelper.trimRight(wxaccountid)).length() == 0) {
            wxaccountid = null;
        }
        this.wxaccountid = wxaccountid;
        this.wxaccountidDirtyFlag = true;
    }

    public String getWXAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccountId();
        }
        return this.wxaccountid;
    }

    public boolean isWXAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccountIdDirty();
        }
        return this.wxaccountidDirtyFlag;
    }

    public void resetWXAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccountId();
            return;
        }
        this.wxaccountidDirtyFlag = false;
        this.wxaccountid = null;
    }

    public void setWXAccountName(String wxaccountname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccountName(wxaccountname);
            return;
        }
        if (wxaccountname != null && (wxaccountname = StringHelper.trimRight(wxaccountname)).length() == 0) {
            wxaccountname = null;
        }
        this.wxaccountname = wxaccountname;
        this.wxaccountnameDirtyFlag = true;
    }

    public String getWXAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccountName();
        }
        return this.wxaccountname;
    }

    public boolean isWXAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccountNameDirty();
        }
        return this.wxaccountnameDirtyFlag;
    }

    public void resetWXAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccountName();
            return;
        }
        this.wxaccountnameDirtyFlag = false;
        this.wxaccountname = null;
    }

    @Override
    protected void onReset() {
        WXAccessTokenBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WXAccessTokenBase et) {
        et.resetAccessToken();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetExpiredTime();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWXAccessTokenId();
        et.resetWXAccessTokenName();
        et.resetWXAccountId();
        et.resetWXAccountName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isAccessTokenDirty()) {
            params.put(FIELD_ACCESSTOKEN, this.getAccessToken());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isExpiredTimeDirty()) {
            params.put(FIELD_EXPIREDTIME, this.getExpiredTime());
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
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWXAccessTokenIdDirty()) {
            params.put(FIELD_WXACCESSTOKENID, this.getWXAccessTokenId());
        }
        if (!bDirtyOnly || this.isWXAccessTokenNameDirty()) {
            params.put(FIELD_WXACCESSTOKENNAME, this.getWXAccessTokenName());
        }
        if (!bDirtyOnly || this.isWXAccountIdDirty()) {
            params.put(FIELD_WXACCOUNTID, this.getWXAccountId());
        }
        if (!bDirtyOnly || this.isWXAccountNameDirty()) {
            params.put(FIELD_WXACCOUNTNAME, this.getWXAccountName());
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
        return WXAccessTokenBase.get(this, index);
    }

    private static Object get(WXAccessTokenBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAccessToken();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getExpiredTime();
            }
            case 4: {
                return et.getReserver();
            }
            case 5: {
                return et.getReserver2();
            }
            case 6: {
                return et.getReserver3();
            }
            case 7: {
                return et.getReserver4();
            }
            case 8: {
                return et.getUpdateDate();
            }
            case 9: {
                return et.getUpdateMan();
            }
            case 10: {
                return et.getWXAccessTokenId();
            }
            case 11: {
                return et.getWXAccessTokenName();
            }
            case 12: {
                return et.getWXAccountId();
            }
            case 13: {
                return et.getWXAccountName();
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
        WXAccessTokenBase.set(this, index, objValue);
    }

    private static void set(WXAccessTokenBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setAccessToken(DataObject.getStringValue(obj));
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
                et.setExpiredTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 9: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWXAccessTokenId(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setWXAccessTokenName(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setWXAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setWXAccountName(DataObject.getStringValue(obj));
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
        return WXAccessTokenBase.isNull(this, index);
    }

    private static boolean isNull(WXAccessTokenBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAccessToken() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getExpiredTime() == null;
            }
            case 4: {
                return et.getReserver() == null;
            }
            case 5: {
                return et.getReserver2() == null;
            }
            case 6: {
                return et.getReserver3() == null;
            }
            case 7: {
                return et.getReserver4() == null;
            }
            case 8: {
                return et.getUpdateDate() == null;
            }
            case 9: {
                return et.getUpdateMan() == null;
            }
            case 10: {
                return et.getWXAccessTokenId() == null;
            }
            case 11: {
                return et.getWXAccessTokenName() == null;
            }
            case 12: {
                return et.getWXAccountId() == null;
            }
            case 13: {
                return et.getWXAccountName() == null;
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
        return WXAccessTokenBase.contains(this, index);
    }

    private static boolean contains(WXAccessTokenBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isAccessTokenDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isExpiredTimeDirty();
            }
            case 4: {
                return et.isReserverDirty();
            }
            case 5: {
                return et.isReserver2Dirty();
            }
            case 6: {
                return et.isReserver3Dirty();
            }
            case 7: {
                return et.isReserver4Dirty();
            }
            case 8: {
                return et.isUpdateDateDirty();
            }
            case 9: {
                return et.isUpdateManDirty();
            }
            case 10: {
                return et.isWXAccessTokenIdDirty();
            }
            case 11: {
                return et.isWXAccessTokenNameDirty();
            }
            case 12: {
                return et.isWXAccountIdDirty();
            }
            case 13: {
                return et.isWXAccountNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WXAccessTokenBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WXAccessTokenBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getAccessToken() != null) {
            JSONObjectHelper.put(json, "accesstoken", WXAccessTokenBase.getJSONValue(et.getAccessToken()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WXAccessTokenBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WXAccessTokenBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getExpiredTime() != null) {
            JSONObjectHelper.put(json, "expiredtime", WXAccessTokenBase.getJSONValue(et.getExpiredTime()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", WXAccessTokenBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", WXAccessTokenBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", WXAccessTokenBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", WXAccessTokenBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WXAccessTokenBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WXAccessTokenBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWXAccessTokenId() != null) {
            JSONObjectHelper.put(json, "wxaccesstokenid", WXAccessTokenBase.getJSONValue(et.getWXAccessTokenId()), false);
        }
        if (bIncEmpty || et.getWXAccessTokenName() != null) {
            JSONObjectHelper.put(json, "wxaccesstokenname", WXAccessTokenBase.getJSONValue(et.getWXAccessTokenName()), false);
        }
        if (bIncEmpty || et.getWXAccountId() != null) {
            JSONObjectHelper.put(json, "wxaccountid", WXAccessTokenBase.getJSONValue(et.getWXAccountId()), false);
        }
        if (bIncEmpty || et.getWXAccountName() != null) {
            JSONObjectHelper.put(json, "wxaccountname", WXAccessTokenBase.getJSONValue(et.getWXAccountName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WXAccessTokenBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WXAccessTokenBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getAccessToken() != null) {
            obj = et.getAccessToken();
            node.setAttribute(FIELD_ACCESSTOKEN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getExpiredTime() != null) {
            obj = et.getExpiredTime();
            node.setAttribute(FIELD_EXPIREDTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
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
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXAccessTokenId() != null) {
            obj = et.getWXAccessTokenId();
            node.setAttribute(FIELD_WXACCESSTOKENID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXAccessTokenName() != null) {
            obj = et.getWXAccessTokenName();
            node.setAttribute(FIELD_WXACCESSTOKENNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXAccountId() != null) {
            obj = et.getWXAccountId();
            node.setAttribute(FIELD_WXACCOUNTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXAccountName() != null) {
            obj = et.getWXAccountName();
            node.setAttribute(FIELD_WXACCOUNTNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXAccessTokenBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WXAccessTokenBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isAccessTokenDirty() && (bIncEmpty || et.getAccessToken() != null)) {
            dst.set(FIELD_ACCESSTOKEN, et.getAccessToken());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isExpiredTimeDirty() && (bIncEmpty || et.getExpiredTime() != null)) {
            dst.set(FIELD_EXPIREDTIME, et.getExpiredTime());
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
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWXAccessTokenIdDirty() && (bIncEmpty || et.getWXAccessTokenId() != null)) {
            dst.set(FIELD_WXACCESSTOKENID, et.getWXAccessTokenId());
        }
        if (et.isWXAccessTokenNameDirty() && (bIncEmpty || et.getWXAccessTokenName() != null)) {
            dst.set(FIELD_WXACCESSTOKENNAME, et.getWXAccessTokenName());
        }
        if (et.isWXAccountIdDirty() && (bIncEmpty || et.getWXAccountId() != null)) {
            dst.set(FIELD_WXACCOUNTID, et.getWXAccountId());
        }
        if (et.isWXAccountNameDirty() && (bIncEmpty || et.getWXAccountName() != null)) {
            dst.set(FIELD_WXACCOUNTNAME, et.getWXAccountName());
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
        return WXAccessTokenBase.remove(this, index);
    }

    private static boolean remove(WXAccessTokenBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetAccessToken();
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
                et.resetExpiredTime();
                return true;
            }
            case 4: {
                et.resetReserver();
                return true;
            }
            case 5: {
                et.resetReserver2();
                return true;
            }
            case 6: {
                et.resetReserver3();
                return true;
            }
            case 7: {
                et.resetReserver4();
                return true;
            }
            case 8: {
                et.resetUpdateDate();
                return true;
            }
            case 9: {
                et.resetUpdateMan();
                return true;
            }
            case 10: {
                et.resetWXAccessTokenId();
                return true;
            }
            case 11: {
                et.resetWXAccessTokenName();
                return true;
            }
            case 12: {
                et.resetWXAccountId();
                return true;
            }
            case 13: {
                et.resetWXAccountName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WXAccount getWxaccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWxaccount();
        }
        if (this.getWXAccountId() == null) {
            return null;
        }
        Integer n = this.objWxaccountLock;
        synchronized (n) {
            if (this.wxaccount != null && DataTypeHelper.compare(25, (Object)this.getWXAccountId(), (Object)this.wxaccount.getWXAccountId()) != 0L) {
                this.wxaccount = null;
            }
            if (this.wxaccount == null) {
                WXAccount wxaccount = new WXAccount();
                wxaccount.setWXAccountId(this.getWXAccountId());
                WXAccountService service = (WXAccountService)ServiceGlobal.getService(WXAccountService.class, this.getSessionFactory());
                service.autoGet(wxaccount);
                this.wxaccount = wxaccount;
            }
            return this.wxaccount;
        }
    }

    private WXAccessTokenBase getProxyEntity() {
        return this.proxyWXAccessTokenBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXAccessTokenBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WXAccessTokenBase) {
            this.proxyWXAccessTokenBase = (WXAccessTokenBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXAccessTokenService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

