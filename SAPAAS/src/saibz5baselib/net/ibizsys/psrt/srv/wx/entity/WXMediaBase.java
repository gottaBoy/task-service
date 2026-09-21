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
import net.ibizsys.psrt.srv.wx.entity.WXEntApp;
import net.ibizsys.psrt.srv.wx.service.WXAccountService;
import net.ibizsys.psrt.srv.wx.service.WXEntAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WXMediaBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXMediaBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WXACCOUNTID = "WXACCOUNTID";
    public static final String FIELD_WXACCOUNTNAME = "WXACCOUNTNAME";
    public static final String FIELD_WXENTAPPID = "WXENTAPPID";
    public static final String FIELD_WXENTAPPNAME = "WXENTAPPNAME";
    public static final String FIELD_WXMEDIAID = "WXMEDIAID";
    public static final String FIELD_WXMEDIANAME = "WXMEDIANAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_RESERVER = 3;
    private static final int INDEX_RESERVER2 = 4;
    private static final int INDEX_RESERVER3 = 5;
    private static final int INDEX_RESERVER4 = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_WXACCOUNTID = 9;
    private static final int INDEX_WXACCOUNTNAME = 10;
    private static final int INDEX_WXENTAPPID = 11;
    private static final int INDEX_WXENTAPPNAME = 12;
    private static final int INDEX_WXMEDIAID = 13;
    private static final int INDEX_WXMEDIANAME = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WXMediaBase proxyWXMediaBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wxaccountidDirtyFlag = false;
    private boolean wxaccountnameDirtyFlag = false;
    private boolean wxentappidDirtyFlag = false;
    private boolean wxentappnameDirtyFlag = false;
    private boolean wxmediaidDirtyFlag = false;
    private boolean wxmedianameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
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
    @Column(name="wxaccountid")
    private String wxaccountid;
    @Column(name="wxaccountname")
    private String wxaccountname;
    @Column(name="wxentappid")
    private String wxentappid;
    @Column(name="wxentappname")
    private String wxentappname;
    @Column(name="wxmediaid")
    private String wxmediaid;
    @Column(name="wxmedianame")
    private String wxmedianame;
    private Integer objWXAccountLock = new Integer(1);
    private WXAccount wxaccount = null;
    private Integer objWXEntAppLock = new Integer(1);
    private WXEntApp wxentapp = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_RESERVER, 3);
        fieldIndexMap.put(FIELD_RESERVER2, 4);
        fieldIndexMap.put(FIELD_RESERVER3, 5);
        fieldIndexMap.put(FIELD_RESERVER4, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_WXACCOUNTID, 9);
        fieldIndexMap.put(FIELD_WXACCOUNTNAME, 10);
        fieldIndexMap.put(FIELD_WXENTAPPID, 11);
        fieldIndexMap.put(FIELD_WXENTAPPNAME, 12);
        fieldIndexMap.put(FIELD_WXMEDIAID, 13);
        fieldIndexMap.put(FIELD_WXMEDIANAME, 14);
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

    public void setWXEntAppId(String wxentappid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXEntAppId(wxentappid);
            return;
        }
        if (wxentappid != null && (wxentappid = StringHelper.trimRight(wxentappid)).length() == 0) {
            wxentappid = null;
        }
        this.wxentappid = wxentappid;
        this.wxentappidDirtyFlag = true;
    }

    public String getWXEntAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXEntAppId();
        }
        return this.wxentappid;
    }

    public boolean isWXEntAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXEntAppIdDirty();
        }
        return this.wxentappidDirtyFlag;
    }

    public void resetWXEntAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXEntAppId();
            return;
        }
        this.wxentappidDirtyFlag = false;
        this.wxentappid = null;
    }

    public void setWXEntAppName(String wxentappname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXEntAppName(wxentappname);
            return;
        }
        if (wxentappname != null && (wxentappname = StringHelper.trimRight(wxentappname)).length() == 0) {
            wxentappname = null;
        }
        this.wxentappname = wxentappname;
        this.wxentappnameDirtyFlag = true;
    }

    public String getWXEntAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXEntAppName();
        }
        return this.wxentappname;
    }

    public boolean isWXEntAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXEntAppNameDirty();
        }
        return this.wxentappnameDirtyFlag;
    }

    public void resetWXEntAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXEntAppName();
            return;
        }
        this.wxentappnameDirtyFlag = false;
        this.wxentappname = null;
    }

    public void setWXMediaId(String wxmediaid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXMediaId(wxmediaid);
            return;
        }
        if (wxmediaid != null && (wxmediaid = StringHelper.trimRight(wxmediaid)).length() == 0) {
            wxmediaid = null;
        }
        this.wxmediaid = wxmediaid;
        this.wxmediaidDirtyFlag = true;
    }

    public String getWXMediaId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXMediaId();
        }
        return this.wxmediaid;
    }

    public boolean isWXMediaIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXMediaIdDirty();
        }
        return this.wxmediaidDirtyFlag;
    }

    public void resetWXMediaId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXMediaId();
            return;
        }
        this.wxmediaidDirtyFlag = false;
        this.wxmediaid = null;
    }

    public void setWXMediaName(String wxmedianame) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXMediaName(wxmedianame);
            return;
        }
        if (wxmedianame != null && (wxmedianame = StringHelper.trimRight(wxmedianame)).length() == 0) {
            wxmedianame = null;
        }
        this.wxmedianame = wxmedianame;
        this.wxmedianameDirtyFlag = true;
    }

    public String getWXMediaName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXMediaName();
        }
        return this.wxmedianame;
    }

    public boolean isWXMediaNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXMediaNameDirty();
        }
        return this.wxmedianameDirtyFlag;
    }

    public void resetWXMediaName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXMediaName();
            return;
        }
        this.wxmedianameDirtyFlag = false;
        this.wxmedianame = null;
    }

    @Override
    protected void onReset() {
        WXMediaBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WXMediaBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWXAccountId();
        et.resetWXAccountName();
        et.resetWXEntAppId();
        et.resetWXEntAppName();
        et.resetWXMediaId();
        et.resetWXMediaName();
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
        if (!bDirtyOnly || this.isWXAccountIdDirty()) {
            params.put(FIELD_WXACCOUNTID, this.getWXAccountId());
        }
        if (!bDirtyOnly || this.isWXAccountNameDirty()) {
            params.put(FIELD_WXACCOUNTNAME, this.getWXAccountName());
        }
        if (!bDirtyOnly || this.isWXEntAppIdDirty()) {
            params.put(FIELD_WXENTAPPID, this.getWXEntAppId());
        }
        if (!bDirtyOnly || this.isWXEntAppNameDirty()) {
            params.put(FIELD_WXENTAPPNAME, this.getWXEntAppName());
        }
        if (!bDirtyOnly || this.isWXMediaIdDirty()) {
            params.put(FIELD_WXMEDIAID, this.getWXMediaId());
        }
        if (!bDirtyOnly || this.isWXMediaNameDirty()) {
            params.put(FIELD_WXMEDIANAME, this.getWXMediaName());
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
        return WXMediaBase.get(this, index);
    }

    private static Object get(WXMediaBase et, int index) throws Exception {
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
                return et.getReserver();
            }
            case 4: {
                return et.getReserver2();
            }
            case 5: {
                return et.getReserver3();
            }
            case 6: {
                return et.getReserver4();
            }
            case 7: {
                return et.getUpdateDate();
            }
            case 8: {
                return et.getUpdateMan();
            }
            case 9: {
                return et.getWXAccountId();
            }
            case 10: {
                return et.getWXAccountName();
            }
            case 11: {
                return et.getWXEntAppId();
            }
            case 12: {
                return et.getWXEntAppName();
            }
            case 13: {
                return et.getWXMediaId();
            }
            case 14: {
                return et.getWXMediaName();
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
        WXMediaBase.set(this, index, objValue);
    }

    private static void set(WXMediaBase et, int index, Object obj) throws Exception {
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
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 8: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWXAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWXAccountName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setWXEntAppId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setWXEntAppName(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setWXMediaId(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setWXMediaName(DataObject.getStringValue(obj));
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
        return WXMediaBase.isNull(this, index);
    }

    private static boolean isNull(WXMediaBase et, int index) throws Exception {
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
                return et.getReserver() == null;
            }
            case 4: {
                return et.getReserver2() == null;
            }
            case 5: {
                return et.getReserver3() == null;
            }
            case 6: {
                return et.getReserver4() == null;
            }
            case 7: {
                return et.getUpdateDate() == null;
            }
            case 8: {
                return et.getUpdateMan() == null;
            }
            case 9: {
                return et.getWXAccountId() == null;
            }
            case 10: {
                return et.getWXAccountName() == null;
            }
            case 11: {
                return et.getWXEntAppId() == null;
            }
            case 12: {
                return et.getWXEntAppName() == null;
            }
            case 13: {
                return et.getWXMediaId() == null;
            }
            case 14: {
                return et.getWXMediaName() == null;
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
        return WXMediaBase.contains(this, index);
    }

    private static boolean contains(WXMediaBase et, int index) throws Exception {
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
                return et.isReserverDirty();
            }
            case 4: {
                return et.isReserver2Dirty();
            }
            case 5: {
                return et.isReserver3Dirty();
            }
            case 6: {
                return et.isReserver4Dirty();
            }
            case 7: {
                return et.isUpdateDateDirty();
            }
            case 8: {
                return et.isUpdateManDirty();
            }
            case 9: {
                return et.isWXAccountIdDirty();
            }
            case 10: {
                return et.isWXAccountNameDirty();
            }
            case 11: {
                return et.isWXEntAppIdDirty();
            }
            case 12: {
                return et.isWXEntAppNameDirty();
            }
            case 13: {
                return et.isWXMediaIdDirty();
            }
            case 14: {
                return et.isWXMediaNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WXMediaBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WXMediaBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WXMediaBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WXMediaBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WXMediaBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", WXMediaBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", WXMediaBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", WXMediaBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", WXMediaBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WXMediaBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WXMediaBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWXAccountId() != null) {
            JSONObjectHelper.put(json, "wxaccountid", WXMediaBase.getJSONValue(et.getWXAccountId()), false);
        }
        if (bIncEmpty || et.getWXAccountName() != null) {
            JSONObjectHelper.put(json, "wxaccountname", WXMediaBase.getJSONValue(et.getWXAccountName()), false);
        }
        if (bIncEmpty || et.getWXEntAppId() != null) {
            JSONObjectHelper.put(json, "wxentappid", WXMediaBase.getJSONValue(et.getWXEntAppId()), false);
        }
        if (bIncEmpty || et.getWXEntAppName() != null) {
            JSONObjectHelper.put(json, "wxentappname", WXMediaBase.getJSONValue(et.getWXEntAppName()), false);
        }
        if (bIncEmpty || et.getWXMediaId() != null) {
            JSONObjectHelper.put(json, "wxmediaid", WXMediaBase.getJSONValue(et.getWXMediaId()), false);
        }
        if (bIncEmpty || et.getWXMediaName() != null) {
            JSONObjectHelper.put(json, "wxmedianame", WXMediaBase.getJSONValue(et.getWXMediaName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WXMediaBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WXMediaBase et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getWXAccountId() != null) {
            obj = et.getWXAccountId();
            node.setAttribute(FIELD_WXACCOUNTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXAccountName() != null) {
            obj = et.getWXAccountName();
            node.setAttribute(FIELD_WXACCOUNTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXEntAppId() != null) {
            obj = et.getWXEntAppId();
            node.setAttribute(FIELD_WXENTAPPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXEntAppName() != null) {
            obj = et.getWXEntAppName();
            node.setAttribute(FIELD_WXENTAPPNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXMediaId() != null) {
            obj = et.getWXMediaId();
            node.setAttribute(FIELD_WXMEDIAID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXMediaName() != null) {
            obj = et.getWXMediaName();
            node.setAttribute(FIELD_WXMEDIANAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXMediaBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WXMediaBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
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
        if (et.isWXAccountIdDirty() && (bIncEmpty || et.getWXAccountId() != null)) {
            dst.set(FIELD_WXACCOUNTID, et.getWXAccountId());
        }
        if (et.isWXAccountNameDirty() && (bIncEmpty || et.getWXAccountName() != null)) {
            dst.set(FIELD_WXACCOUNTNAME, et.getWXAccountName());
        }
        if (et.isWXEntAppIdDirty() && (bIncEmpty || et.getWXEntAppId() != null)) {
            dst.set(FIELD_WXENTAPPID, et.getWXEntAppId());
        }
        if (et.isWXEntAppNameDirty() && (bIncEmpty || et.getWXEntAppName() != null)) {
            dst.set(FIELD_WXENTAPPNAME, et.getWXEntAppName());
        }
        if (et.isWXMediaIdDirty() && (bIncEmpty || et.getWXMediaId() != null)) {
            dst.set(FIELD_WXMEDIAID, et.getWXMediaId());
        }
        if (et.isWXMediaNameDirty() && (bIncEmpty || et.getWXMediaName() != null)) {
            dst.set(FIELD_WXMEDIANAME, et.getWXMediaName());
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
        return WXMediaBase.remove(this, index);
    }

    private static boolean remove(WXMediaBase et, int index) throws Exception {
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
                et.resetReserver();
                return true;
            }
            case 4: {
                et.resetReserver2();
                return true;
            }
            case 5: {
                et.resetReserver3();
                return true;
            }
            case 6: {
                et.resetReserver4();
                return true;
            }
            case 7: {
                et.resetUpdateDate();
                return true;
            }
            case 8: {
                et.resetUpdateMan();
                return true;
            }
            case 9: {
                et.resetWXAccountId();
                return true;
            }
            case 10: {
                et.resetWXAccountName();
                return true;
            }
            case 11: {
                et.resetWXEntAppId();
                return true;
            }
            case 12: {
                et.resetWXEntAppName();
                return true;
            }
            case 13: {
                et.resetWXMediaId();
                return true;
            }
            case 14: {
                et.resetWXMediaName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WXAccount getWXAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccount();
        }
        if (this.getWXAccountId() == null) {
            return null;
        }
        Integer n = this.objWXAccountLock;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WXEntApp getWXEntApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXEntApp();
        }
        if (this.getWXEntAppId() == null) {
            return null;
        }
        Integer n = this.objWXEntAppLock;
        synchronized (n) {
            if (this.wxentapp != null && DataTypeHelper.compare(25, (Object)this.getWXEntAppId(), (Object)this.wxentapp.getWXEntAppId()) != 0L) {
                this.wxentapp = null;
            }
            if (this.wxentapp == null) {
                WXEntApp wxentapp = new WXEntApp();
                wxentapp.setWXEntAppId(this.getWXEntAppId());
                WXEntAppService service = (WXEntAppService)ServiceGlobal.getService(WXEntAppService.class, this.getSessionFactory());
                service.autoGet(wxentapp);
                this.wxentapp = wxentapp;
            }
            return this.wxentapp;
        }
    }

    private WXMediaBase getProxyEntity() {
        return this.proxyWXMediaBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXMediaBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WXMediaBase) {
            this.proxyWXMediaBase = (WXMediaBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXMediaService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

