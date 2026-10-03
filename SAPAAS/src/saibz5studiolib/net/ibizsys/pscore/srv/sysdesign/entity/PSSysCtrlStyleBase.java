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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCtrlStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCtrlStyleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLPARAM = "CTRLPARAM";
    public static final String FIELD_CTRLPARAM10 = "CTRLPARAM10";
    public static final String FIELD_CTRLPARAM11 = "CTRLPARAM11";
    public static final String FIELD_CTRLPARAM12 = "CTRLPARAM12";
    public static final String FIELD_CTRLPARAM2 = "CTRLPARAM2";
    public static final String FIELD_CTRLPARAM3 = "CTRLPARAM3";
    public static final String FIELD_CTRLPARAM4 = "CTRLPARAM4";
    public static final String FIELD_CTRLPARAM5 = "CTRLPARAM5";
    public static final String FIELD_CTRLPARAM6 = "CTRLPARAM6";
    public static final String FIELD_CTRLPARAM7 = "CTRLPARAM7";
    public static final String FIELD_CTRLPARAM8 = "CTRLPARAM8";
    public static final String FIELD_CTRLPARAM9 = "CTRLPARAM9";
    public static final String FIELD_CTRLTYPE = "CTRLTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSCTRLSTYLEID = "PSSYSCTRLSTYLEID";
    public static final String FIELD_PSSYSCTRLSTYLENAME = "PSSYSCTRLSTYLENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLPARAM = 2;
    private static final int INDEX_CTRLPARAM10 = 3;
    private static final int INDEX_CTRLPARAM11 = 4;
    private static final int INDEX_CTRLPARAM12 = 5;
    private static final int INDEX_CTRLPARAM2 = 6;
    private static final int INDEX_CTRLPARAM3 = 7;
    private static final int INDEX_CTRLPARAM4 = 8;
    private static final int INDEX_CTRLPARAM5 = 9;
    private static final int INDEX_CTRLPARAM6 = 10;
    private static final int INDEX_CTRLPARAM7 = 11;
    private static final int INDEX_CTRLPARAM8 = 12;
    private static final int INDEX_CTRLPARAM9 = 13;
    private static final int INDEX_CTRLTYPE = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_PSSYSCTRLSTYLEID = 16;
    private static final int INDEX_PSSYSCTRLSTYLENAME = 17;
    private static final int INDEX_PSSYSTEMID = 18;
    private static final int INDEX_PSSYSTEMNAME = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCtrlStyleBase proxyPSSysCtrlStyleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlparamDirtyFlag = false;
    private boolean ctrlparam10DirtyFlag = false;
    private boolean ctrlparam11DirtyFlag = false;
    private boolean ctrlparam12DirtyFlag = false;
    private boolean ctrlparam2DirtyFlag = false;
    private boolean ctrlparam3DirtyFlag = false;
    private boolean ctrlparam4DirtyFlag = false;
    private boolean ctrlparam5DirtyFlag = false;
    private boolean ctrlparam6DirtyFlag = false;
    private boolean ctrlparam7DirtyFlag = false;
    private boolean ctrlparam8DirtyFlag = false;
    private boolean ctrlparam9DirtyFlag = false;
    private boolean ctrltypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysctrlstyleidDirtyFlag = false;
    private boolean pssysctrlstylenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlparam")
    private String ctrlparam;
    @Column(name="ctrlparam10")
    private Double ctrlparam10;
    @Column(name="ctrlparam11")
    private Integer ctrlparam11;
    @Column(name="ctrlparam12")
    private Integer ctrlparam12;
    @Column(name="ctrlparam2")
    private String ctrlparam2;
    @Column(name="ctrlparam3")
    private String ctrlparam3;
    @Column(name="ctrlparam4")
    private String ctrlparam4;
    @Column(name="ctrlparam5")
    private Integer ctrlparam5;
    @Column(name="ctrlparam6")
    private Integer ctrlparam6;
    @Column(name="ctrlparam7")
    private Integer ctrlparam7;
    @Column(name="ctrlparam8")
    private Integer ctrlparam8;
    @Column(name="ctrlparam9")
    private Double ctrlparam9;
    @Column(name="ctrltype")
    private String ctrltype;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysctrlstyleid")
    private String pssysctrlstyleid;
    @Column(name="pssysctrlstylename")
    private String pssysctrlstylename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPssystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setCtrlParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam = string;
        this.ctrlparamDirtyFlag = true;
    }

    public String getCtrlParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam();
        }
        return this.ctrlparam;
    }

    public boolean isCtrlParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParamDirty();
        }
        return this.ctrlparamDirtyFlag;
    }

    public void resetCtrlParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam();
            return;
        }
        this.ctrlparamDirtyFlag = false;
        this.ctrlparam = null;
    }

    public void setCtrlParam10(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam10(d);
            return;
        }
        this.ctrlparam10 = d;
        this.ctrlparam10DirtyFlag = true;
    }

    public Double getCtrlParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam10();
        }
        return this.ctrlparam10;
    }

    public boolean isCtrlParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam10Dirty();
        }
        return this.ctrlparam10DirtyFlag;
    }

    public void resetCtrlParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam10();
            return;
        }
        this.ctrlparam10DirtyFlag = false;
        this.ctrlparam10 = null;
    }

    public void setCtrlParam11(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam11(n);
            return;
        }
        this.ctrlparam11 = n;
        this.ctrlparam11DirtyFlag = true;
    }

    public Integer getCtrlParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam11();
        }
        return this.ctrlparam11;
    }

    public boolean isCtrlParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam11Dirty();
        }
        return this.ctrlparam11DirtyFlag;
    }

    public void resetCtrlParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam11();
            return;
        }
        this.ctrlparam11DirtyFlag = false;
        this.ctrlparam11 = null;
    }

    public void setCtrlParam12(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam12(n);
            return;
        }
        this.ctrlparam12 = n;
        this.ctrlparam12DirtyFlag = true;
    }

    public Integer getCtrlParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam12();
        }
        return this.ctrlparam12;
    }

    public boolean isCtrlParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam12Dirty();
        }
        return this.ctrlparam12DirtyFlag;
    }

    public void resetCtrlParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam12();
            return;
        }
        this.ctrlparam12DirtyFlag = false;
        this.ctrlparam12 = null;
    }

    public void setCtrlParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam2 = string;
        this.ctrlparam2DirtyFlag = true;
    }

    public String getCtrlParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam2();
        }
        return this.ctrlparam2;
    }

    public boolean isCtrlParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam2Dirty();
        }
        return this.ctrlparam2DirtyFlag;
    }

    public void resetCtrlParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam2();
            return;
        }
        this.ctrlparam2DirtyFlag = false;
        this.ctrlparam2 = null;
    }

    public void setCtrlParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam3 = string;
        this.ctrlparam3DirtyFlag = true;
    }

    public String getCtrlParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam3();
        }
        return this.ctrlparam3;
    }

    public boolean isCtrlParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam3Dirty();
        }
        return this.ctrlparam3DirtyFlag;
    }

    public void resetCtrlParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam3();
            return;
        }
        this.ctrlparam3DirtyFlag = false;
        this.ctrlparam3 = null;
    }

    public void setCtrlParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlparam4 = string;
        this.ctrlparam4DirtyFlag = true;
    }

    public String getCtrlParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam4();
        }
        return this.ctrlparam4;
    }

    public boolean isCtrlParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam4Dirty();
        }
        return this.ctrlparam4DirtyFlag;
    }

    public void resetCtrlParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam4();
            return;
        }
        this.ctrlparam4DirtyFlag = false;
        this.ctrlparam4 = null;
    }

    public void setCtrlParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam5(n);
            return;
        }
        this.ctrlparam5 = n;
        this.ctrlparam5DirtyFlag = true;
    }

    public Integer getCtrlParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam5();
        }
        return this.ctrlparam5;
    }

    public boolean isCtrlParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam5Dirty();
        }
        return this.ctrlparam5DirtyFlag;
    }

    public void resetCtrlParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam5();
            return;
        }
        this.ctrlparam5DirtyFlag = false;
        this.ctrlparam5 = null;
    }

    public void setCtrlParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam6(n);
            return;
        }
        this.ctrlparam6 = n;
        this.ctrlparam6DirtyFlag = true;
    }

    public Integer getCtrlParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam6();
        }
        return this.ctrlparam6;
    }

    public boolean isCtrlParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam6Dirty();
        }
        return this.ctrlparam6DirtyFlag;
    }

    public void resetCtrlParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam6();
            return;
        }
        this.ctrlparam6DirtyFlag = false;
        this.ctrlparam6 = null;
    }

    public void setCtrlParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam7(n);
            return;
        }
        this.ctrlparam7 = n;
        this.ctrlparam7DirtyFlag = true;
    }

    public Integer getCtrlParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam7();
        }
        return this.ctrlparam7;
    }

    public boolean isCtrlParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam7Dirty();
        }
        return this.ctrlparam7DirtyFlag;
    }

    public void resetCtrlParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam7();
            return;
        }
        this.ctrlparam7DirtyFlag = false;
        this.ctrlparam7 = null;
    }

    public void setCtrlParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam8(n);
            return;
        }
        this.ctrlparam8 = n;
        this.ctrlparam8DirtyFlag = true;
    }

    public Integer getCtrlParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam8();
        }
        return this.ctrlparam8;
    }

    public boolean isCtrlParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam8Dirty();
        }
        return this.ctrlparam8DirtyFlag;
    }

    public void resetCtrlParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam8();
            return;
        }
        this.ctrlparam8DirtyFlag = false;
        this.ctrlparam8 = null;
    }

    public void setCtrlParam9(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlParam9(d);
            return;
        }
        this.ctrlparam9 = d;
        this.ctrlparam9DirtyFlag = true;
    }

    public Double getCtrlParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlParam9();
        }
        return this.ctrlparam9;
    }

    public boolean isCtrlParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlParam9Dirty();
        }
        return this.ctrlparam9DirtyFlag;
    }

    public void resetCtrlParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlParam9();
            return;
        }
        this.ctrlparam9DirtyFlag = false;
        this.ctrlparam9 = null;
    }

    public void setCtrlType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrltype = string;
        this.ctrltypeDirtyFlag = true;
    }

    public String getCtrlType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlType();
        }
        return this.ctrltype;
    }

    public boolean isCtrlTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlTypeDirty();
        }
        return this.ctrltypeDirtyFlag;
    }

    public void resetCtrlType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlType();
            return;
        }
        this.ctrltypeDirtyFlag = false;
        this.ctrltype = null;
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

    public void setPSSysCtrlStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCtrlStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysctrlstyleid = string;
        this.pssysctrlstyleidDirtyFlag = true;
    }

    public String getPSSysCtrlStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCtrlStyleId();
        }
        return this.pssysctrlstyleid;
    }

    public boolean isPSSysCtrlStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCtrlStyleIdDirty();
        }
        return this.pssysctrlstyleidDirtyFlag;
    }

    public void resetPSSysCtrlStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCtrlStyleId();
            return;
        }
        this.pssysctrlstyleidDirtyFlag = false;
        this.pssysctrlstyleid = null;
    }

    public void setPSSysCtrlStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCtrlStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysctrlstylename = string;
        this.pssysctrlstylenameDirtyFlag = true;
    }

    public String getPSSysCtrlStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCtrlStyleName();
        }
        return this.pssysctrlstylename;
    }

    public boolean isPSSysCtrlStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCtrlStyleNameDirty();
        }
        return this.pssysctrlstylenameDirtyFlag;
    }

    public void resetPSSysCtrlStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCtrlStyleName();
            return;
        }
        this.pssysctrlstylenameDirtyFlag = false;
        this.pssysctrlstylename = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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

    protected void onReset() {
        PSSysCtrlStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCtrlStyleBase pSSysCtrlStyleBase) {
        pSSysCtrlStyleBase.resetCreateDate();
        pSSysCtrlStyleBase.resetCreateMan();
        pSSysCtrlStyleBase.resetCtrlParam();
        pSSysCtrlStyleBase.resetCtrlParam10();
        pSSysCtrlStyleBase.resetCtrlParam11();
        pSSysCtrlStyleBase.resetCtrlParam12();
        pSSysCtrlStyleBase.resetCtrlParam2();
        pSSysCtrlStyleBase.resetCtrlParam3();
        pSSysCtrlStyleBase.resetCtrlParam4();
        pSSysCtrlStyleBase.resetCtrlParam5();
        pSSysCtrlStyleBase.resetCtrlParam6();
        pSSysCtrlStyleBase.resetCtrlParam7();
        pSSysCtrlStyleBase.resetCtrlParam8();
        pSSysCtrlStyleBase.resetCtrlParam9();
        pSSysCtrlStyleBase.resetCtrlType();
        pSSysCtrlStyleBase.resetMemo();
        pSSysCtrlStyleBase.resetPSSysCtrlStyleId();
        pSSysCtrlStyleBase.resetPSSysCtrlStyleName();
        pSSysCtrlStyleBase.resetPSSystemId();
        pSSysCtrlStyleBase.resetPSSystemName();
        pSSysCtrlStyleBase.resetUpdateDate();
        pSSysCtrlStyleBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlParamDirty()) {
            hashMap.put(FIELD_CTRLPARAM, this.getCtrlParam());
        }
        if (!bl || this.isCtrlParam10Dirty()) {
            hashMap.put(FIELD_CTRLPARAM10, this.getCtrlParam10());
        }
        if (!bl || this.isCtrlParam11Dirty()) {
            hashMap.put(FIELD_CTRLPARAM11, this.getCtrlParam11());
        }
        if (!bl || this.isCtrlParam12Dirty()) {
            hashMap.put(FIELD_CTRLPARAM12, this.getCtrlParam12());
        }
        if (!bl || this.isCtrlParam2Dirty()) {
            hashMap.put(FIELD_CTRLPARAM2, this.getCtrlParam2());
        }
        if (!bl || this.isCtrlParam3Dirty()) {
            hashMap.put(FIELD_CTRLPARAM3, this.getCtrlParam3());
        }
        if (!bl || this.isCtrlParam4Dirty()) {
            hashMap.put(FIELD_CTRLPARAM4, this.getCtrlParam4());
        }
        if (!bl || this.isCtrlParam5Dirty()) {
            hashMap.put(FIELD_CTRLPARAM5, this.getCtrlParam5());
        }
        if (!bl || this.isCtrlParam6Dirty()) {
            hashMap.put(FIELD_CTRLPARAM6, this.getCtrlParam6());
        }
        if (!bl || this.isCtrlParam7Dirty()) {
            hashMap.put(FIELD_CTRLPARAM7, this.getCtrlParam7());
        }
        if (!bl || this.isCtrlParam8Dirty()) {
            hashMap.put(FIELD_CTRLPARAM8, this.getCtrlParam8());
        }
        if (!bl || this.isCtrlParam9Dirty()) {
            hashMap.put(FIELD_CTRLPARAM9, this.getCtrlParam9());
        }
        if (!bl || this.isCtrlTypeDirty()) {
            hashMap.put(FIELD_CTRLTYPE, this.getCtrlType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysCtrlStyleIdDirty()) {
            hashMap.put(FIELD_PSSYSCTRLSTYLEID, this.getPSSysCtrlStyleId());
        }
        if (!bl || this.isPSSysCtrlStyleNameDirty()) {
            hashMap.put(FIELD_PSSYSCTRLSTYLENAME, this.getPSSysCtrlStyleName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSSysCtrlStyleBase.get(this, n);
    }

    private static Object get(PSSysCtrlStyleBase pSSysCtrlStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCtrlStyleBase.getCreateDate();
            }
            case 1: {
                return pSSysCtrlStyleBase.getCreateMan();
            }
            case 2: {
                return pSSysCtrlStyleBase.getCtrlParam();
            }
            case 3: {
                return pSSysCtrlStyleBase.getCtrlParam10();
            }
            case 4: {
                return pSSysCtrlStyleBase.getCtrlParam11();
            }
            case 5: {
                return pSSysCtrlStyleBase.getCtrlParam12();
            }
            case 6: {
                return pSSysCtrlStyleBase.getCtrlParam2();
            }
            case 7: {
                return pSSysCtrlStyleBase.getCtrlParam3();
            }
            case 8: {
                return pSSysCtrlStyleBase.getCtrlParam4();
            }
            case 9: {
                return pSSysCtrlStyleBase.getCtrlParam5();
            }
            case 10: {
                return pSSysCtrlStyleBase.getCtrlParam6();
            }
            case 11: {
                return pSSysCtrlStyleBase.getCtrlParam7();
            }
            case 12: {
                return pSSysCtrlStyleBase.getCtrlParam8();
            }
            case 13: {
                return pSSysCtrlStyleBase.getCtrlParam9();
            }
            case 14: {
                return pSSysCtrlStyleBase.getCtrlType();
            }
            case 15: {
                return pSSysCtrlStyleBase.getMemo();
            }
            case 16: {
                return pSSysCtrlStyleBase.getPSSysCtrlStyleId();
            }
            case 17: {
                return pSSysCtrlStyleBase.getPSSysCtrlStyleName();
            }
            case 18: {
                return pSSysCtrlStyleBase.getPSSystemId();
            }
            case 19: {
                return pSSysCtrlStyleBase.getPSSystemName();
            }
            case 20: {
                return pSSysCtrlStyleBase.getUpdateDate();
            }
            case 21: {
                return pSSysCtrlStyleBase.getUpdateMan();
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
        PSSysCtrlStyleBase.set(this, n, object);
    }

    private static void set(PSSysCtrlStyleBase pSSysCtrlStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCtrlStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysCtrlStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCtrlStyleBase.setCtrlParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCtrlStyleBase.setCtrlParam10(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSSysCtrlStyleBase.setCtrlParam11(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysCtrlStyleBase.setCtrlParam12(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysCtrlStyleBase.setCtrlParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCtrlStyleBase.setCtrlParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCtrlStyleBase.setCtrlParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCtrlStyleBase.setCtrlParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysCtrlStyleBase.setCtrlParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysCtrlStyleBase.setCtrlParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysCtrlStyleBase.setCtrlParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysCtrlStyleBase.setCtrlParam9(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 14: {
                pSSysCtrlStyleBase.setCtrlType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysCtrlStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCtrlStyleBase.setPSSysCtrlStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysCtrlStyleBase.setPSSysCtrlStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysCtrlStyleBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysCtrlStyleBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysCtrlStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSSysCtrlStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysCtrlStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCtrlStyleBase pSSysCtrlStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCtrlStyleBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysCtrlStyleBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysCtrlStyleBase.getCtrlParam() == null;
            }
            case 3: {
                return pSSysCtrlStyleBase.getCtrlParam10() == null;
            }
            case 4: {
                return pSSysCtrlStyleBase.getCtrlParam11() == null;
            }
            case 5: {
                return pSSysCtrlStyleBase.getCtrlParam12() == null;
            }
            case 6: {
                return pSSysCtrlStyleBase.getCtrlParam2() == null;
            }
            case 7: {
                return pSSysCtrlStyleBase.getCtrlParam3() == null;
            }
            case 8: {
                return pSSysCtrlStyleBase.getCtrlParam4() == null;
            }
            case 9: {
                return pSSysCtrlStyleBase.getCtrlParam5() == null;
            }
            case 10: {
                return pSSysCtrlStyleBase.getCtrlParam6() == null;
            }
            case 11: {
                return pSSysCtrlStyleBase.getCtrlParam7() == null;
            }
            case 12: {
                return pSSysCtrlStyleBase.getCtrlParam8() == null;
            }
            case 13: {
                return pSSysCtrlStyleBase.getCtrlParam9() == null;
            }
            case 14: {
                return pSSysCtrlStyleBase.getCtrlType() == null;
            }
            case 15: {
                return pSSysCtrlStyleBase.getMemo() == null;
            }
            case 16: {
                return pSSysCtrlStyleBase.getPSSysCtrlStyleId() == null;
            }
            case 17: {
                return pSSysCtrlStyleBase.getPSSysCtrlStyleName() == null;
            }
            case 18: {
                return pSSysCtrlStyleBase.getPSSystemId() == null;
            }
            case 19: {
                return pSSysCtrlStyleBase.getPSSystemName() == null;
            }
            case 20: {
                return pSSysCtrlStyleBase.getUpdateDate() == null;
            }
            case 21: {
                return pSSysCtrlStyleBase.getUpdateMan() == null;
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
        return PSSysCtrlStyleBase.contains(this, n);
    }

    private static boolean contains(PSSysCtrlStyleBase pSSysCtrlStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCtrlStyleBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysCtrlStyleBase.isCreateManDirty();
            }
            case 2: {
                return pSSysCtrlStyleBase.isCtrlParamDirty();
            }
            case 3: {
                return pSSysCtrlStyleBase.isCtrlParam10Dirty();
            }
            case 4: {
                return pSSysCtrlStyleBase.isCtrlParam11Dirty();
            }
            case 5: {
                return pSSysCtrlStyleBase.isCtrlParam12Dirty();
            }
            case 6: {
                return pSSysCtrlStyleBase.isCtrlParam2Dirty();
            }
            case 7: {
                return pSSysCtrlStyleBase.isCtrlParam3Dirty();
            }
            case 8: {
                return pSSysCtrlStyleBase.isCtrlParam4Dirty();
            }
            case 9: {
                return pSSysCtrlStyleBase.isCtrlParam5Dirty();
            }
            case 10: {
                return pSSysCtrlStyleBase.isCtrlParam6Dirty();
            }
            case 11: {
                return pSSysCtrlStyleBase.isCtrlParam7Dirty();
            }
            case 12: {
                return pSSysCtrlStyleBase.isCtrlParam8Dirty();
            }
            case 13: {
                return pSSysCtrlStyleBase.isCtrlParam9Dirty();
            }
            case 14: {
                return pSSysCtrlStyleBase.isCtrlTypeDirty();
            }
            case 15: {
                return pSSysCtrlStyleBase.isMemoDirty();
            }
            case 16: {
                return pSSysCtrlStyleBase.isPSSysCtrlStyleIdDirty();
            }
            case 17: {
                return pSSysCtrlStyleBase.isPSSysCtrlStyleNameDirty();
            }
            case 18: {
                return pSSysCtrlStyleBase.isPSSystemIdDirty();
            }
            case 19: {
                return pSSysCtrlStyleBase.isPSSystemNameDirty();
            }
            case 20: {
                return pSSysCtrlStyleBase.isUpdateDateDirty();
            }
            case 21: {
                return pSSysCtrlStyleBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCtrlStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCtrlStyleBase pSSysCtrlStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCtrlStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam10", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam10()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam11", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam11()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam12", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam12()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam2", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam2()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam3", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam3()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam4", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam4()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam5", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam5()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam6", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam6()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam7", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam7()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam8", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam8()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlparam9", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlParam9()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltype", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getCtrlType()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getPSSysCtrlStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysctrlstyleid", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getPSSysCtrlStyleId()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getPSSysCtrlStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysctrlstylename", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getPSSysCtrlStyleName()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCtrlStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCtrlStyleBase.getJSONValue((Object)pSSysCtrlStyleBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCtrlStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCtrlStyleBase pSSysCtrlStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCtrlStyleBase.getCreateDate() != null) {
            object = pSSysCtrlStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getCreateMan() != null) {
            object = pSSysCtrlStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam();
            xmlNode.setAttribute(FIELD_CTRLPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam10() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam10();
            xmlNode.setAttribute(FIELD_CTRLPARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam11() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam11();
            xmlNode.setAttribute(FIELD_CTRLPARAM11, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam12() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam12();
            xmlNode.setAttribute(FIELD_CTRLPARAM12, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam2() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam2();
            xmlNode.setAttribute(FIELD_CTRLPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam3() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam3();
            xmlNode.setAttribute(FIELD_CTRLPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam4() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam4();
            xmlNode.setAttribute(FIELD_CTRLPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam5() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam5();
            xmlNode.setAttribute(FIELD_CTRLPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam6() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam6();
            xmlNode.setAttribute(FIELD_CTRLPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam7() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam7();
            xmlNode.setAttribute(FIELD_CTRLPARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam8() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam8();
            xmlNode.setAttribute(FIELD_CTRLPARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getCtrlParam9() != null) {
            object = pSSysCtrlStyleBase.getCtrlParam9();
            xmlNode.setAttribute(FIELD_CTRLPARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getCtrlType() != null) {
            object = pSSysCtrlStyleBase.getCtrlType();
            xmlNode.setAttribute(FIELD_CTRLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getMemo() != null) {
            object = pSSysCtrlStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getPSSysCtrlStyleId() != null) {
            object = pSSysCtrlStyleBase.getPSSysCtrlStyleId();
            xmlNode.setAttribute(FIELD_PSSYSCTRLSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getPSSysCtrlStyleName() != null) {
            object = pSSysCtrlStyleBase.getPSSysCtrlStyleName();
            xmlNode.setAttribute(FIELD_PSSYSCTRLSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getPSSystemId() != null) {
            object = pSSysCtrlStyleBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getPSSystemName() != null) {
            object = pSSysCtrlStyleBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCtrlStyleBase.getUpdateDate() != null) {
            object = pSSysCtrlStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCtrlStyleBase.getUpdateMan() != null) {
            object = pSSysCtrlStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCtrlStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCtrlStyleBase pSSysCtrlStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCtrlStyleBase.isCreateDateDirty() && (bl || pSSysCtrlStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCtrlStyleBase.getCreateDate());
        }
        if (pSSysCtrlStyleBase.isCreateManDirty() && (bl || pSSysCtrlStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCtrlStyleBase.getCreateMan());
        }
        if (pSSysCtrlStyleBase.isCtrlParamDirty() && (bl || pSSysCtrlStyleBase.getCtrlParam() != null)) {
            iDataObject.set(FIELD_CTRLPARAM, (Object)pSSysCtrlStyleBase.getCtrlParam());
        }
        if (pSSysCtrlStyleBase.isCtrlParam10Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam10() != null)) {
            iDataObject.set(FIELD_CTRLPARAM10, (Object)pSSysCtrlStyleBase.getCtrlParam10());
        }
        if (pSSysCtrlStyleBase.isCtrlParam11Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam11() != null)) {
            iDataObject.set(FIELD_CTRLPARAM11, (Object)pSSysCtrlStyleBase.getCtrlParam11());
        }
        if (pSSysCtrlStyleBase.isCtrlParam12Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam12() != null)) {
            iDataObject.set(FIELD_CTRLPARAM12, (Object)pSSysCtrlStyleBase.getCtrlParam12());
        }
        if (pSSysCtrlStyleBase.isCtrlParam2Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam2() != null)) {
            iDataObject.set(FIELD_CTRLPARAM2, (Object)pSSysCtrlStyleBase.getCtrlParam2());
        }
        if (pSSysCtrlStyleBase.isCtrlParam3Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam3() != null)) {
            iDataObject.set(FIELD_CTRLPARAM3, (Object)pSSysCtrlStyleBase.getCtrlParam3());
        }
        if (pSSysCtrlStyleBase.isCtrlParam4Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam4() != null)) {
            iDataObject.set(FIELD_CTRLPARAM4, (Object)pSSysCtrlStyleBase.getCtrlParam4());
        }
        if (pSSysCtrlStyleBase.isCtrlParam5Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam5() != null)) {
            iDataObject.set(FIELD_CTRLPARAM5, (Object)pSSysCtrlStyleBase.getCtrlParam5());
        }
        if (pSSysCtrlStyleBase.isCtrlParam6Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam6() != null)) {
            iDataObject.set(FIELD_CTRLPARAM6, (Object)pSSysCtrlStyleBase.getCtrlParam6());
        }
        if (pSSysCtrlStyleBase.isCtrlParam7Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam7() != null)) {
            iDataObject.set(FIELD_CTRLPARAM7, (Object)pSSysCtrlStyleBase.getCtrlParam7());
        }
        if (pSSysCtrlStyleBase.isCtrlParam8Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam8() != null)) {
            iDataObject.set(FIELD_CTRLPARAM8, (Object)pSSysCtrlStyleBase.getCtrlParam8());
        }
        if (pSSysCtrlStyleBase.isCtrlParam9Dirty() && (bl || pSSysCtrlStyleBase.getCtrlParam9() != null)) {
            iDataObject.set(FIELD_CTRLPARAM9, (Object)pSSysCtrlStyleBase.getCtrlParam9());
        }
        if (pSSysCtrlStyleBase.isCtrlTypeDirty() && (bl || pSSysCtrlStyleBase.getCtrlType() != null)) {
            iDataObject.set(FIELD_CTRLTYPE, (Object)pSSysCtrlStyleBase.getCtrlType());
        }
        if (pSSysCtrlStyleBase.isMemoDirty() && (bl || pSSysCtrlStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCtrlStyleBase.getMemo());
        }
        if (pSSysCtrlStyleBase.isPSSysCtrlStyleIdDirty() && (bl || pSSysCtrlStyleBase.getPSSysCtrlStyleId() != null)) {
            iDataObject.set(FIELD_PSSYSCTRLSTYLEID, (Object)pSSysCtrlStyleBase.getPSSysCtrlStyleId());
        }
        if (pSSysCtrlStyleBase.isPSSysCtrlStyleNameDirty() && (bl || pSSysCtrlStyleBase.getPSSysCtrlStyleName() != null)) {
            iDataObject.set(FIELD_PSSYSCTRLSTYLENAME, (Object)pSSysCtrlStyleBase.getPSSysCtrlStyleName());
        }
        if (pSSysCtrlStyleBase.isPSSystemIdDirty() && (bl || pSSysCtrlStyleBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysCtrlStyleBase.getPSSystemId());
        }
        if (pSSysCtrlStyleBase.isPSSystemNameDirty() && (bl || pSSysCtrlStyleBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysCtrlStyleBase.getPSSystemName());
        }
        if (pSSysCtrlStyleBase.isUpdateDateDirty() && (bl || pSSysCtrlStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCtrlStyleBase.getUpdateDate());
        }
        if (pSSysCtrlStyleBase.isUpdateManDirty() && (bl || pSSysCtrlStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCtrlStyleBase.getUpdateMan());
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
        return PSSysCtrlStyleBase.remove(this, n);
    }

    private static boolean remove(PSSysCtrlStyleBase pSSysCtrlStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCtrlStyleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysCtrlStyleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysCtrlStyleBase.resetCtrlParam();
                return true;
            }
            case 3: {
                pSSysCtrlStyleBase.resetCtrlParam10();
                return true;
            }
            case 4: {
                pSSysCtrlStyleBase.resetCtrlParam11();
                return true;
            }
            case 5: {
                pSSysCtrlStyleBase.resetCtrlParam12();
                return true;
            }
            case 6: {
                pSSysCtrlStyleBase.resetCtrlParam2();
                return true;
            }
            case 7: {
                pSSysCtrlStyleBase.resetCtrlParam3();
                return true;
            }
            case 8: {
                pSSysCtrlStyleBase.resetCtrlParam4();
                return true;
            }
            case 9: {
                pSSysCtrlStyleBase.resetCtrlParam5();
                return true;
            }
            case 10: {
                pSSysCtrlStyleBase.resetCtrlParam6();
                return true;
            }
            case 11: {
                pSSysCtrlStyleBase.resetCtrlParam7();
                return true;
            }
            case 12: {
                pSSysCtrlStyleBase.resetCtrlParam8();
                return true;
            }
            case 13: {
                pSSysCtrlStyleBase.resetCtrlParam9();
                return true;
            }
            case 14: {
                pSSysCtrlStyleBase.resetCtrlType();
                return true;
            }
            case 15: {
                pSSysCtrlStyleBase.resetMemo();
                return true;
            }
            case 16: {
                pSSysCtrlStyleBase.resetPSSysCtrlStyleId();
                return true;
            }
            case 17: {
                pSSysCtrlStyleBase.resetPSSysCtrlStyleName();
                return true;
            }
            case 18: {
                pSSysCtrlStyleBase.resetPSSystemId();
                return true;
            }
            case 19: {
                pSSysCtrlStyleBase.resetPSSystemName();
                return true;
            }
            case 20: {
                pSSysCtrlStyleBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSSysCtrlStyleBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPssystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPssystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysCtrlStyleBase getProxyEntity() {
        return this.proxyPSSysCtrlStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCtrlStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCtrlStyleBase) {
            this.proxyPSSysCtrlStyleBase = (PSSysCtrlStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCtrlStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLPARAM, 2);
        fieldIndexMap.put(FIELD_CTRLPARAM10, 3);
        fieldIndexMap.put(FIELD_CTRLPARAM11, 4);
        fieldIndexMap.put(FIELD_CTRLPARAM12, 5);
        fieldIndexMap.put(FIELD_CTRLPARAM2, 6);
        fieldIndexMap.put(FIELD_CTRLPARAM3, 7);
        fieldIndexMap.put(FIELD_CTRLPARAM4, 8);
        fieldIndexMap.put(FIELD_CTRLPARAM5, 9);
        fieldIndexMap.put(FIELD_CTRLPARAM6, 10);
        fieldIndexMap.put(FIELD_CTRLPARAM7, 11);
        fieldIndexMap.put(FIELD_CTRLPARAM8, 12);
        fieldIndexMap.put(FIELD_CTRLPARAM9, 13);
        fieldIndexMap.put(FIELD_CTRLTYPE, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_PSSYSCTRLSTYLEID, 16);
        fieldIndexMap.put(FIELD_PSSYSCTRLSTYLENAME, 17);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
    }
}

