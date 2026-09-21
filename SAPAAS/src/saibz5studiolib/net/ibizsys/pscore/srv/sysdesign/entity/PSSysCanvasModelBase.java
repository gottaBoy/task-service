/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCanvas;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCanvasModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCanvasModelBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSMODELTYPE = "PSMODELTYPE";
    public static final String FIELD_PSSYSCANVASID = "PSSYSCANVASID";
    public static final String FIELD_PSSYSCANVASMODELID = "PSSYSCANVASMODELID";
    public static final String FIELD_PSSYSCANVASMODELNAME = "PSSYSCANVASMODELNAME";
    public static final String FIELD_PSSYSCANVASNAME = "PSSYSCANVASNAME";
    public static final String FIELD_SYMBOLNAME = "SYMBOLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSMODELID = 3;
    private static final int INDEX_PSMODELNAME = 4;
    private static final int INDEX_PSMODELTYPE = 5;
    private static final int INDEX_PSSYSCANVASID = 6;
    private static final int INDEX_PSSYSCANVASMODELID = 7;
    private static final int INDEX_PSSYSCANVASMODELNAME = 8;
    private static final int INDEX_PSSYSCANVASNAME = 9;
    private static final int INDEX_SYMBOLNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCanvasModelBase proxyPSSysCanvasModelBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean psmodeltypeDirtyFlag = false;
    private boolean pssyscanvasidDirtyFlag = false;
    private boolean pssyscanvasmodelidDirtyFlag = false;
    private boolean pssyscanvasmodelnameDirtyFlag = false;
    private boolean pssyscanvasnameDirtyFlag = false;
    private boolean symbolnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="psmodeltype")
    private String psmodeltype;
    @Column(name="pssyscanvasid")
    private String pssyscanvasid;
    @Column(name="pssyscanvasmodelid")
    private String pssyscanvasmodelid;
    @Column(name="pssyscanvasmodelname")
    private String pssyscanvasmodelname;
    @Column(name="pssyscanvasname")
    private String pssyscanvasname;
    @Column(name="symbolname")
    private String symbolname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSSysCanvasLock = new Integer(1);
    private PSSysCanvas pssyscanvas = null;

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
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

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
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

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
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

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setPSModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeltype = string;
        this.psmodeltypeDirtyFlag = true;
    }

    public String getPSModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelType();
        }
        return this.psmodeltype;
    }

    public boolean isPSModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelTypeDirty();
        }
        return this.psmodeltypeDirtyFlag;
    }

    public void resetPSModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelType();
            return;
        }
        this.psmodeltypeDirtyFlag = false;
        this.psmodeltype = null;
    }

    public void setPSSysCanvasId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCanvasId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscanvasid = string;
        this.pssyscanvasidDirtyFlag = true;
    }

    public String getPSSysCanvasId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCanvasId();
        }
        return this.pssyscanvasid;
    }

    public boolean isPSSysCanvasIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCanvasIdDirty();
        }
        return this.pssyscanvasidDirtyFlag;
    }

    public void resetPSSysCanvasId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCanvasId();
            return;
        }
        this.pssyscanvasidDirtyFlag = false;
        this.pssyscanvasid = null;
    }

    public void setPSSysCanvasModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCanvasModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscanvasmodelid = string;
        this.pssyscanvasmodelidDirtyFlag = true;
    }

    public String getPSSysCanvasModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCanvasModelId();
        }
        return this.pssyscanvasmodelid;
    }

    public boolean isPSSysCanvasModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCanvasModelIdDirty();
        }
        return this.pssyscanvasmodelidDirtyFlag;
    }

    public void resetPSSysCanvasModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCanvasModelId();
            return;
        }
        this.pssyscanvasmodelidDirtyFlag = false;
        this.pssyscanvasmodelid = null;
    }

    public void setPSSysCanvasModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCanvasModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscanvasmodelname = string;
        this.pssyscanvasmodelnameDirtyFlag = true;
    }

    public String getPSSysCanvasModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCanvasModelName();
        }
        return this.pssyscanvasmodelname;
    }

    public boolean isPSSysCanvasModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCanvasModelNameDirty();
        }
        return this.pssyscanvasmodelnameDirtyFlag;
    }

    public void resetPSSysCanvasModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCanvasModelName();
            return;
        }
        this.pssyscanvasmodelnameDirtyFlag = false;
        this.pssyscanvasmodelname = null;
    }

    public void setPSSysCanvasName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCanvasName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscanvasname = string;
        this.pssyscanvasnameDirtyFlag = true;
    }

    public String getPSSysCanvasName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCanvasName();
        }
        return this.pssyscanvasname;
    }

    public boolean isPSSysCanvasNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCanvasNameDirty();
        }
        return this.pssyscanvasnameDirtyFlag;
    }

    public void resetPSSysCanvasName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCanvasName();
            return;
        }
        this.pssyscanvasnameDirtyFlag = false;
        this.pssyscanvasname = null;
    }

    public void setSymbolName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSymbolName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.symbolname = string;
        this.symbolnameDirtyFlag = true;
    }

    public String getSymbolName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSymbolName();
        }
        return this.symbolname;
    }

    public boolean isSymbolNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSymbolNameDirty();
        }
        return this.symbolnameDirtyFlag;
    }

    public void resetSymbolName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSymbolName();
            return;
        }
        this.symbolnameDirtyFlag = false;
        this.symbolname = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
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

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSSysCanvasModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCanvasModelBase pSSysCanvasModelBase) {
        pSSysCanvasModelBase.resetCreateDate();
        pSSysCanvasModelBase.resetCreateMan();
        pSSysCanvasModelBase.resetMemo();
        pSSysCanvasModelBase.resetPSModelId();
        pSSysCanvasModelBase.resetPSModelName();
        pSSysCanvasModelBase.resetPSModelType();
        pSSysCanvasModelBase.resetPSSysCanvasId();
        pSSysCanvasModelBase.resetPSSysCanvasModelId();
        pSSysCanvasModelBase.resetPSSysCanvasModelName();
        pSSysCanvasModelBase.resetPSSysCanvasName();
        pSSysCanvasModelBase.resetSymbolName();
        pSSysCanvasModelBase.resetUpdateDate();
        pSSysCanvasModelBase.resetUpdateMan();
        pSSysCanvasModelBase.resetUserCat();
        pSSysCanvasModelBase.resetUserTag();
        pSSysCanvasModelBase.resetUserTag2();
        pSSysCanvasModelBase.resetUserTag3();
        pSSysCanvasModelBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSModelTypeDirty()) {
            hashMap.put(FIELD_PSMODELTYPE, this.getPSModelType());
        }
        if (!bl || this.isPSSysCanvasIdDirty()) {
            hashMap.put(FIELD_PSSYSCANVASID, this.getPSSysCanvasId());
        }
        if (!bl || this.isPSSysCanvasModelIdDirty()) {
            hashMap.put(FIELD_PSSYSCANVASMODELID, this.getPSSysCanvasModelId());
        }
        if (!bl || this.isPSSysCanvasModelNameDirty()) {
            hashMap.put(FIELD_PSSYSCANVASMODELNAME, this.getPSSysCanvasModelName());
        }
        if (!bl || this.isPSSysCanvasNameDirty()) {
            hashMap.put(FIELD_PSSYSCANVASNAME, this.getPSSysCanvasName());
        }
        if (!bl || this.isSymbolNameDirty()) {
            hashMap.put(FIELD_SYMBOLNAME, this.getSymbolName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSSysCanvasModelBase.get(this, n);
    }

    private static Object get(PSSysCanvasModelBase pSSysCanvasModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCanvasModelBase.getCreateDate();
            }
            case 1: {
                return pSSysCanvasModelBase.getCreateMan();
            }
            case 2: {
                return pSSysCanvasModelBase.getMemo();
            }
            case 3: {
                return pSSysCanvasModelBase.getPSModelId();
            }
            case 4: {
                return pSSysCanvasModelBase.getPSModelName();
            }
            case 5: {
                return pSSysCanvasModelBase.getPSModelType();
            }
            case 6: {
                return pSSysCanvasModelBase.getPSSysCanvasId();
            }
            case 7: {
                return pSSysCanvasModelBase.getPSSysCanvasModelId();
            }
            case 8: {
                return pSSysCanvasModelBase.getPSSysCanvasModelName();
            }
            case 9: {
                return pSSysCanvasModelBase.getPSSysCanvasName();
            }
            case 10: {
                return pSSysCanvasModelBase.getSymbolName();
            }
            case 11: {
                return pSSysCanvasModelBase.getUpdateDate();
            }
            case 12: {
                return pSSysCanvasModelBase.getUpdateMan();
            }
            case 13: {
                return pSSysCanvasModelBase.getUserCat();
            }
            case 14: {
                return pSSysCanvasModelBase.getUserTag();
            }
            case 15: {
                return pSSysCanvasModelBase.getUserTag2();
            }
            case 16: {
                return pSSysCanvasModelBase.getUserTag3();
            }
            case 17: {
                return pSSysCanvasModelBase.getUserTag4();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSSysCanvasModelBase.set(this, n, object);
    }

    private static void set(PSSysCanvasModelBase pSSysCanvasModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCanvasModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysCanvasModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCanvasModelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCanvasModelBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCanvasModelBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCanvasModelBase.setPSModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCanvasModelBase.setPSSysCanvasId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCanvasModelBase.setPSSysCanvasModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCanvasModelBase.setPSSysCanvasModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCanvasModelBase.setPSSysCanvasName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCanvasModelBase.setSymbolName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysCanvasModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysCanvasModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysCanvasModelBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysCanvasModelBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysCanvasModelBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCanvasModelBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysCanvasModelBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSSysCanvasModelBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCanvasModelBase pSSysCanvasModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCanvasModelBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysCanvasModelBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysCanvasModelBase.getMemo() == null;
            }
            case 3: {
                return pSSysCanvasModelBase.getPSModelId() == null;
            }
            case 4: {
                return pSSysCanvasModelBase.getPSModelName() == null;
            }
            case 5: {
                return pSSysCanvasModelBase.getPSModelType() == null;
            }
            case 6: {
                return pSSysCanvasModelBase.getPSSysCanvasId() == null;
            }
            case 7: {
                return pSSysCanvasModelBase.getPSSysCanvasModelId() == null;
            }
            case 8: {
                return pSSysCanvasModelBase.getPSSysCanvasModelName() == null;
            }
            case 9: {
                return pSSysCanvasModelBase.getPSSysCanvasName() == null;
            }
            case 10: {
                return pSSysCanvasModelBase.getSymbolName() == null;
            }
            case 11: {
                return pSSysCanvasModelBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSysCanvasModelBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSysCanvasModelBase.getUserCat() == null;
            }
            case 14: {
                return pSSysCanvasModelBase.getUserTag() == null;
            }
            case 15: {
                return pSSysCanvasModelBase.getUserTag2() == null;
            }
            case 16: {
                return pSSysCanvasModelBase.getUserTag3() == null;
            }
            case 17: {
                return pSSysCanvasModelBase.getUserTag4() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSSysCanvasModelBase.contains(this, n);
    }

    private static boolean contains(PSSysCanvasModelBase pSSysCanvasModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCanvasModelBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysCanvasModelBase.isCreateManDirty();
            }
            case 2: {
                return pSSysCanvasModelBase.isMemoDirty();
            }
            case 3: {
                return pSSysCanvasModelBase.isPSModelIdDirty();
            }
            case 4: {
                return pSSysCanvasModelBase.isPSModelNameDirty();
            }
            case 5: {
                return pSSysCanvasModelBase.isPSModelTypeDirty();
            }
            case 6: {
                return pSSysCanvasModelBase.isPSSysCanvasIdDirty();
            }
            case 7: {
                return pSSysCanvasModelBase.isPSSysCanvasModelIdDirty();
            }
            case 8: {
                return pSSysCanvasModelBase.isPSSysCanvasModelNameDirty();
            }
            case 9: {
                return pSSysCanvasModelBase.isPSSysCanvasNameDirty();
            }
            case 10: {
                return pSSysCanvasModelBase.isSymbolNameDirty();
            }
            case 11: {
                return pSSysCanvasModelBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSysCanvasModelBase.isUpdateManDirty();
            }
            case 13: {
                return pSSysCanvasModelBase.isUserCatDirty();
            }
            case 14: {
                return pSSysCanvasModelBase.isUserTagDirty();
            }
            case 15: {
                return pSSysCanvasModelBase.isUserTag2Dirty();
            }
            case 16: {
                return pSSysCanvasModelBase.isUserTag3Dirty();
            }
            case 17: {
                return pSSysCanvasModelBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCanvasModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCanvasModelBase pSSysCanvasModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCanvasModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getPSModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltype", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getPSModelType()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getPSSysCanvasId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscanvasid", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getPSSysCanvasId()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getPSSysCanvasModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscanvasmodelid", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getPSSysCanvasModelId()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getPSSysCanvasModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscanvasmodelname", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getPSSysCanvasModelName()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getPSSysCanvasName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscanvasname", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getPSSysCanvasName()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getSymbolName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"symbolname", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getSymbolName()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysCanvasModelBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysCanvasModelBase.getJSONValue((Object)pSSysCanvasModelBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCanvasModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCanvasModelBase pSSysCanvasModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCanvasModelBase.getCreateDate() != null) {
            object = pSSysCanvasModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCanvasModelBase.getCreateMan() != null) {
            object = pSSysCanvasModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getMemo() != null) {
            object = pSSysCanvasModelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getPSModelId() != null) {
            object = pSSysCanvasModelBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getPSModelName() != null) {
            object = pSSysCanvasModelBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getPSModelType() != null) {
            object = pSSysCanvasModelBase.getPSModelType();
            xmlNode.setAttribute(FIELD_PSMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getPSSysCanvasId() != null) {
            object = pSSysCanvasModelBase.getPSSysCanvasId();
            xmlNode.setAttribute(FIELD_PSSYSCANVASID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getPSSysCanvasModelId() != null) {
            object = pSSysCanvasModelBase.getPSSysCanvasModelId();
            xmlNode.setAttribute(FIELD_PSSYSCANVASMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getPSSysCanvasModelName() != null) {
            object = pSSysCanvasModelBase.getPSSysCanvasModelName();
            xmlNode.setAttribute(FIELD_PSSYSCANVASMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getPSSysCanvasName() != null) {
            object = pSSysCanvasModelBase.getPSSysCanvasName();
            xmlNode.setAttribute(FIELD_PSSYSCANVASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getSymbolName() != null) {
            object = pSSysCanvasModelBase.getSymbolName();
            xmlNode.setAttribute(FIELD_SYMBOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getUpdateDate() != null) {
            object = pSSysCanvasModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCanvasModelBase.getUpdateMan() != null) {
            object = pSSysCanvasModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getUserCat() != null) {
            object = pSSysCanvasModelBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getUserTag() != null) {
            object = pSSysCanvasModelBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getUserTag2() != null) {
            object = pSSysCanvasModelBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getUserTag3() != null) {
            object = pSSysCanvasModelBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasModelBase.getUserTag4() != null) {
            object = pSSysCanvasModelBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCanvasModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCanvasModelBase pSSysCanvasModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCanvasModelBase.isCreateDateDirty() && (bl || pSSysCanvasModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCanvasModelBase.getCreateDate());
        }
        if (pSSysCanvasModelBase.isCreateManDirty() && (bl || pSSysCanvasModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCanvasModelBase.getCreateMan());
        }
        if (pSSysCanvasModelBase.isMemoDirty() && (bl || pSSysCanvasModelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCanvasModelBase.getMemo());
        }
        if (pSSysCanvasModelBase.isPSModelIdDirty() && (bl || pSSysCanvasModelBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSSysCanvasModelBase.getPSModelId());
        }
        if (pSSysCanvasModelBase.isPSModelNameDirty() && (bl || pSSysCanvasModelBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSSysCanvasModelBase.getPSModelName());
        }
        if (pSSysCanvasModelBase.isPSModelTypeDirty() && (bl || pSSysCanvasModelBase.getPSModelType() != null)) {
            iDataObject.set(FIELD_PSMODELTYPE, (Object)pSSysCanvasModelBase.getPSModelType());
        }
        if (pSSysCanvasModelBase.isPSSysCanvasIdDirty() && (bl || pSSysCanvasModelBase.getPSSysCanvasId() != null)) {
            iDataObject.set(FIELD_PSSYSCANVASID, (Object)pSSysCanvasModelBase.getPSSysCanvasId());
        }
        if (pSSysCanvasModelBase.isPSSysCanvasModelIdDirty() && (bl || pSSysCanvasModelBase.getPSSysCanvasModelId() != null)) {
            iDataObject.set(FIELD_PSSYSCANVASMODELID, (Object)pSSysCanvasModelBase.getPSSysCanvasModelId());
        }
        if (pSSysCanvasModelBase.isPSSysCanvasModelNameDirty() && (bl || pSSysCanvasModelBase.getPSSysCanvasModelName() != null)) {
            iDataObject.set(FIELD_PSSYSCANVASMODELNAME, (Object)pSSysCanvasModelBase.getPSSysCanvasModelName());
        }
        if (pSSysCanvasModelBase.isPSSysCanvasNameDirty() && (bl || pSSysCanvasModelBase.getPSSysCanvasName() != null)) {
            iDataObject.set(FIELD_PSSYSCANVASNAME, (Object)pSSysCanvasModelBase.getPSSysCanvasName());
        }
        if (pSSysCanvasModelBase.isSymbolNameDirty() && (bl || pSSysCanvasModelBase.getSymbolName() != null)) {
            iDataObject.set(FIELD_SYMBOLNAME, (Object)pSSysCanvasModelBase.getSymbolName());
        }
        if (pSSysCanvasModelBase.isUpdateDateDirty() && (bl || pSSysCanvasModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCanvasModelBase.getUpdateDate());
        }
        if (pSSysCanvasModelBase.isUpdateManDirty() && (bl || pSSysCanvasModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCanvasModelBase.getUpdateMan());
        }
        if (pSSysCanvasModelBase.isUserCatDirty() && (bl || pSSysCanvasModelBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysCanvasModelBase.getUserCat());
        }
        if (pSSysCanvasModelBase.isUserTagDirty() && (bl || pSSysCanvasModelBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysCanvasModelBase.getUserTag());
        }
        if (pSSysCanvasModelBase.isUserTag2Dirty() && (bl || pSSysCanvasModelBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysCanvasModelBase.getUserTag2());
        }
        if (pSSysCanvasModelBase.isUserTag3Dirty() && (bl || pSSysCanvasModelBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysCanvasModelBase.getUserTag3());
        }
        if (pSSysCanvasModelBase.isUserTag4Dirty() && (bl || pSSysCanvasModelBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysCanvasModelBase.getUserTag4());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSSysCanvasModelBase.remove(this, n);
    }

    private static boolean remove(PSSysCanvasModelBase pSSysCanvasModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCanvasModelBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysCanvasModelBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysCanvasModelBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysCanvasModelBase.resetPSModelId();
                return true;
            }
            case 4: {
                pSSysCanvasModelBase.resetPSModelName();
                return true;
            }
            case 5: {
                pSSysCanvasModelBase.resetPSModelType();
                return true;
            }
            case 6: {
                pSSysCanvasModelBase.resetPSSysCanvasId();
                return true;
            }
            case 7: {
                pSSysCanvasModelBase.resetPSSysCanvasModelId();
                return true;
            }
            case 8: {
                pSSysCanvasModelBase.resetPSSysCanvasModelName();
                return true;
            }
            case 9: {
                pSSysCanvasModelBase.resetPSSysCanvasName();
                return true;
            }
            case 10: {
                pSSysCanvasModelBase.resetSymbolName();
                return true;
            }
            case 11: {
                pSSysCanvasModelBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSysCanvasModelBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSysCanvasModelBase.resetUserCat();
                return true;
            }
            case 14: {
                pSSysCanvasModelBase.resetUserTag();
                return true;
            }
            case 15: {
                pSSysCanvasModelBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSSysCanvasModelBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSSysCanvasModelBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCanvas getPSSysCanvas() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCanvas();
        }
        if (this.getPSSysCanvasId() == null) {
            return null;
        }
        Integer n = this.objPSSysCanvasLock;
        synchronized (n) {
            if (this.pssyscanvas != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCanvasId(), (Object)this.pssyscanvas.getPSSysCanvasId()) != 0L) {
                this.pssyscanvas = null;
            }
            if (this.pssyscanvas == null) {
                PSSysCanvas pSSysCanvas = new PSSysCanvas();
                pSSysCanvas.setPSSysCanvasId(this.getPSSysCanvasId());
                PSSysCanvasService pSSysCanvasService = (PSSysCanvasService)ServiceGlobal.getService(PSSysCanvasService.class, (SessionFactory)this.getSessionFactory());
                pSSysCanvasService.autoGet((IEntity)pSSysCanvas);
                this.pssyscanvas = pSSysCanvas;
            }
            return this.pssyscanvas;
        }
    }

    private PSSysCanvasModelBase getProxyEntity() {
        return this.proxyPSSysCanvasModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCanvasModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCanvasModelBase) {
            this.proxyPSSysCanvasModelBase = (PSSysCanvasModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSMODELID, 3);
        fieldIndexMap.put(FIELD_PSMODELNAME, 4);
        fieldIndexMap.put(FIELD_PSMODELTYPE, 5);
        fieldIndexMap.put(FIELD_PSSYSCANVASID, 6);
        fieldIndexMap.put(FIELD_PSSYSCANVASMODELID, 7);
        fieldIndexMap.put(FIELD_PSSYSCANVASMODELNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSCANVASNAME, 9);
        fieldIndexMap.put(FIELD_SYMBOLNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
    }
}

