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

public abstract class OrgSecUserTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(OrgSecUserTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_ORGSECUSERTYPEID = "ORGSECUSERTYPEID";
    public static final String FIELD_ORGSECUSERTYPENAME = "ORGSECUSERTYPENAME";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER10 = "RESERVER10";
    public static final String FIELD_RESERVER11 = "RESERVER11";
    public static final String FIELD_RESERVER12 = "RESERVER12";
    public static final String FIELD_RESERVER13 = "RESERVER13";
    public static final String FIELD_RESERVER14 = "RESERVER14";
    public static final String FIELD_RESERVER15 = "RESERVER15";
    public static final String FIELD_RESERVER16 = "RESERVER16";
    public static final String FIELD_RESERVER17 = "RESERVER17";
    public static final String FIELD_RESERVER18 = "RESERVER18";
    public static final String FIELD_RESERVER19 = "RESERVER19";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER20 = "RESERVER20";
    public static final String FIELD_RESERVER21 = "RESERVER21";
    public static final String FIELD_RESERVER22 = "RESERVER22";
    public static final String FIELD_RESERVER23 = "RESERVER23";
    public static final String FIELD_RESERVER24 = "RESERVER24";
    public static final String FIELD_RESERVER25 = "RESERVER25";
    public static final String FIELD_RESERVER26 = "RESERVER26";
    public static final String FIELD_RESERVER27 = "RESERVER27";
    public static final String FIELD_RESERVER28 = "RESERVER28";
    public static final String FIELD_RESERVER29 = "RESERVER29";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER30 = "RESERVER30";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_RESERVER5 = "RESERVER5";
    public static final String FIELD_RESERVER6 = "RESERVER6";
    public static final String FIELD_RESERVER7 = "RESERVER7";
    public static final String FIELD_RESERVER8 = "RESERVER8";
    public static final String FIELD_RESERVER9 = "RESERVER9";
    public static final String FIELD_TYPECODE = "TYPECODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_ORGSECUSERTYPEID = 4;
    private static final int INDEX_ORGSECUSERTYPENAME = 5;
    private static final int INDEX_RESERVER = 6;
    private static final int INDEX_RESERVER10 = 7;
    private static final int INDEX_RESERVER11 = 8;
    private static final int INDEX_RESERVER12 = 9;
    private static final int INDEX_RESERVER13 = 10;
    private static final int INDEX_RESERVER14 = 11;
    private static final int INDEX_RESERVER15 = 12;
    private static final int INDEX_RESERVER16 = 13;
    private static final int INDEX_RESERVER17 = 14;
    private static final int INDEX_RESERVER18 = 15;
    private static final int INDEX_RESERVER19 = 16;
    private static final int INDEX_RESERVER2 = 17;
    private static final int INDEX_RESERVER20 = 18;
    private static final int INDEX_RESERVER21 = 19;
    private static final int INDEX_RESERVER22 = 20;
    private static final int INDEX_RESERVER23 = 21;
    private static final int INDEX_RESERVER24 = 22;
    private static final int INDEX_RESERVER25 = 23;
    private static final int INDEX_RESERVER26 = 24;
    private static final int INDEX_RESERVER27 = 25;
    private static final int INDEX_RESERVER28 = 26;
    private static final int INDEX_RESERVER29 = 27;
    private static final int INDEX_RESERVER3 = 28;
    private static final int INDEX_RESERVER30 = 29;
    private static final int INDEX_RESERVER4 = 30;
    private static final int INDEX_RESERVER5 = 31;
    private static final int INDEX_RESERVER6 = 32;
    private static final int INDEX_RESERVER7 = 33;
    private static final int INDEX_RESERVER8 = 34;
    private static final int INDEX_RESERVER9 = 35;
    private static final int INDEX_TYPECODE = 36;
    private static final int INDEX_UPDATEDATE = 37;
    private static final int INDEX_UPDATEMAN = 38;
    private static final int INDEX_VALIDFLAG = 39;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private OrgSecUserTypeBase proxyOrgSecUserTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean orgsecusertypeidDirtyFlag = false;
    private boolean orgsecusertypenameDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver10DirtyFlag = false;
    private boolean reserver11DirtyFlag = false;
    private boolean reserver12DirtyFlag = false;
    private boolean reserver13DirtyFlag = false;
    private boolean reserver14DirtyFlag = false;
    private boolean reserver15DirtyFlag = false;
    private boolean reserver16DirtyFlag = false;
    private boolean reserver17DirtyFlag = false;
    private boolean reserver18DirtyFlag = false;
    private boolean reserver19DirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver20DirtyFlag = false;
    private boolean reserver21DirtyFlag = false;
    private boolean reserver22DirtyFlag = false;
    private boolean reserver23DirtyFlag = false;
    private boolean reserver24DirtyFlag = false;
    private boolean reserver25DirtyFlag = false;
    private boolean reserver26DirtyFlag = false;
    private boolean reserver27DirtyFlag = false;
    private boolean reserver28DirtyFlag = false;
    private boolean reserver29DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver30DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean reserver5DirtyFlag = false;
    private boolean reserver6DirtyFlag = false;
    private boolean reserver7DirtyFlag = false;
    private boolean reserver8DirtyFlag = false;
    private boolean reserver9DirtyFlag = false;
    private boolean typecodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="orgsecusertypeid")
    private String orgsecusertypeid;
    @Column(name="orgsecusertypename")
    private String orgsecusertypename;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver10")
    private String reserver10;
    @Column(name="reserver11")
    private Integer reserver11;
    @Column(name="reserver12")
    private Integer reserver12;
    @Column(name="reserver13")
    private Integer reserver13;
    @Column(name="reserver14")
    private Integer reserver14;
    @Column(name="reserver15")
    private Double reserver15;
    @Column(name="reserver16")
    private Double reserver16;
    @Column(name="reserver17")
    private Double reserver17;
    @Column(name="reserver18")
    private Double reserver18;
    @Column(name="reserver19")
    private Timestamp reserver19;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver20")
    private Timestamp reserver20;
    @Column(name="reserver21")
    private Timestamp reserver21;
    @Column(name="reserver22")
    private Timestamp reserver22;
    @Column(name="reserver23")
    private String reserver23;
    @Column(name="reserver24")
    private String reserver24;
    @Column(name="reserver25")
    private String reserver25;
    @Column(name="reserver26")
    private String reserver26;
    @Column(name="reserver27")
    private String reserver27;
    @Column(name="reserver28")
    private String reserver28;
    @Column(name="reserver29")
    private String reserver29;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver30")
    private String reserver30;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="reserver5")
    private String reserver5;
    @Column(name="reserver6")
    private String reserver6;
    @Column(name="reserver7")
    private String reserver7;
    @Column(name="reserver8")
    private String reserver8;
    @Column(name="reserver9")
    private String reserver9;
    @Column(name="typecode")
    private String typecode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_ORGSECUSERTYPEID, 4);
        fieldIndexMap.put(FIELD_ORGSECUSERTYPENAME, 5);
        fieldIndexMap.put(FIELD_RESERVER, 6);
        fieldIndexMap.put(FIELD_RESERVER10, 7);
        fieldIndexMap.put(FIELD_RESERVER11, 8);
        fieldIndexMap.put(FIELD_RESERVER12, 9);
        fieldIndexMap.put(FIELD_RESERVER13, 10);
        fieldIndexMap.put(FIELD_RESERVER14, 11);
        fieldIndexMap.put(FIELD_RESERVER15, 12);
        fieldIndexMap.put(FIELD_RESERVER16, 13);
        fieldIndexMap.put(FIELD_RESERVER17, 14);
        fieldIndexMap.put(FIELD_RESERVER18, 15);
        fieldIndexMap.put(FIELD_RESERVER19, 16);
        fieldIndexMap.put(FIELD_RESERVER2, 17);
        fieldIndexMap.put(FIELD_RESERVER20, 18);
        fieldIndexMap.put(FIELD_RESERVER21, 19);
        fieldIndexMap.put(FIELD_RESERVER22, 20);
        fieldIndexMap.put(FIELD_RESERVER23, 21);
        fieldIndexMap.put(FIELD_RESERVER24, 22);
        fieldIndexMap.put(FIELD_RESERVER25, 23);
        fieldIndexMap.put(FIELD_RESERVER26, 24);
        fieldIndexMap.put(FIELD_RESERVER27, 25);
        fieldIndexMap.put(FIELD_RESERVER28, 26);
        fieldIndexMap.put(FIELD_RESERVER29, 27);
        fieldIndexMap.put(FIELD_RESERVER3, 28);
        fieldIndexMap.put(FIELD_RESERVER30, 29);
        fieldIndexMap.put(FIELD_RESERVER4, 30);
        fieldIndexMap.put(FIELD_RESERVER5, 31);
        fieldIndexMap.put(FIELD_RESERVER6, 32);
        fieldIndexMap.put(FIELD_RESERVER7, 33);
        fieldIndexMap.put(FIELD_RESERVER8, 34);
        fieldIndexMap.put(FIELD_RESERVER9, 35);
        fieldIndexMap.put(FIELD_TYPECODE, 36);
        fieldIndexMap.put(FIELD_UPDATEDATE, 37);
        fieldIndexMap.put(FIELD_UPDATEMAN, 38);
        fieldIndexMap.put(FIELD_VALIDFLAG, 39);
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

    public void setOrderValue(Integer ordervalue) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(ordervalue);
            return;
        }
        this.ordervalue = ordervalue;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setOrgSecUserTypeId(String orgsecusertypeid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgSecUserTypeId(orgsecusertypeid);
            return;
        }
        if (orgsecusertypeid != null && (orgsecusertypeid = StringHelper.trimRight(orgsecusertypeid)).length() == 0) {
            orgsecusertypeid = null;
        }
        this.orgsecusertypeid = orgsecusertypeid;
        this.orgsecusertypeidDirtyFlag = true;
    }

    public String getOrgSecUserTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgSecUserTypeId();
        }
        return this.orgsecusertypeid;
    }

    public boolean isOrgSecUserTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgSecUserTypeIdDirty();
        }
        return this.orgsecusertypeidDirtyFlag;
    }

    public void resetOrgSecUserTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgSecUserTypeId();
            return;
        }
        this.orgsecusertypeidDirtyFlag = false;
        this.orgsecusertypeid = null;
    }

    public void setOrgSecUserTypeName(String orgsecusertypename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgSecUserTypeName(orgsecusertypename);
            return;
        }
        if (orgsecusertypename != null && (orgsecusertypename = StringHelper.trimRight(orgsecusertypename)).length() == 0) {
            orgsecusertypename = null;
        }
        this.orgsecusertypename = orgsecusertypename;
        this.orgsecusertypenameDirtyFlag = true;
    }

    public String getOrgSecUserTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgSecUserTypeName();
        }
        return this.orgsecusertypename;
    }

    public boolean isOrgSecUserTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgSecUserTypeNameDirty();
        }
        return this.orgsecusertypenameDirtyFlag;
    }

    public void resetOrgSecUserTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgSecUserTypeName();
            return;
        }
        this.orgsecusertypenameDirtyFlag = false;
        this.orgsecusertypename = null;
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

    public void setReserver10(String reserver10) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver10(reserver10);
            return;
        }
        if (reserver10 != null && (reserver10 = StringHelper.trimRight(reserver10)).length() == 0) {
            reserver10 = null;
        }
        this.reserver10 = reserver10;
        this.reserver10DirtyFlag = true;
    }

    public String getReserver10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver10();
        }
        return this.reserver10;
    }

    public boolean isReserver10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver10Dirty();
        }
        return this.reserver10DirtyFlag;
    }

    public void resetReserver10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver10();
            return;
        }
        this.reserver10DirtyFlag = false;
        this.reserver10 = null;
    }

    public void setReserver11(Integer reserver11) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver11(reserver11);
            return;
        }
        this.reserver11 = reserver11;
        this.reserver11DirtyFlag = true;
    }

    public Integer getReserver11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver11();
        }
        return this.reserver11;
    }

    public boolean isReserver11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver11Dirty();
        }
        return this.reserver11DirtyFlag;
    }

    public void resetReserver11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver11();
            return;
        }
        this.reserver11DirtyFlag = false;
        this.reserver11 = null;
    }

    public void setReserver12(Integer reserver12) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver12(reserver12);
            return;
        }
        this.reserver12 = reserver12;
        this.reserver12DirtyFlag = true;
    }

    public Integer getReserver12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver12();
        }
        return this.reserver12;
    }

    public boolean isReserver12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver12Dirty();
        }
        return this.reserver12DirtyFlag;
    }

    public void resetReserver12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver12();
            return;
        }
        this.reserver12DirtyFlag = false;
        this.reserver12 = null;
    }

    public void setReserver13(Integer reserver13) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver13(reserver13);
            return;
        }
        this.reserver13 = reserver13;
        this.reserver13DirtyFlag = true;
    }

    public Integer getReserver13() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver13();
        }
        return this.reserver13;
    }

    public boolean isReserver13Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver13Dirty();
        }
        return this.reserver13DirtyFlag;
    }

    public void resetReserver13() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver13();
            return;
        }
        this.reserver13DirtyFlag = false;
        this.reserver13 = null;
    }

    public void setReserver14(Integer reserver14) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver14(reserver14);
            return;
        }
        this.reserver14 = reserver14;
        this.reserver14DirtyFlag = true;
    }

    public Integer getReserver14() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver14();
        }
        return this.reserver14;
    }

    public boolean isReserver14Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver14Dirty();
        }
        return this.reserver14DirtyFlag;
    }

    public void resetReserver14() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver14();
            return;
        }
        this.reserver14DirtyFlag = false;
        this.reserver14 = null;
    }

    public void setReserver15(Double reserver15) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver15(reserver15);
            return;
        }
        this.reserver15 = reserver15;
        this.reserver15DirtyFlag = true;
    }

    public Double getReserver15() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver15();
        }
        return this.reserver15;
    }

    public boolean isReserver15Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver15Dirty();
        }
        return this.reserver15DirtyFlag;
    }

    public void resetReserver15() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver15();
            return;
        }
        this.reserver15DirtyFlag = false;
        this.reserver15 = null;
    }

    public void setReserver16(Double reserver16) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver16(reserver16);
            return;
        }
        this.reserver16 = reserver16;
        this.reserver16DirtyFlag = true;
    }

    public Double getReserver16() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver16();
        }
        return this.reserver16;
    }

    public boolean isReserver16Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver16Dirty();
        }
        return this.reserver16DirtyFlag;
    }

    public void resetReserver16() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver16();
            return;
        }
        this.reserver16DirtyFlag = false;
        this.reserver16 = null;
    }

    public void setReserver17(Double reserver17) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver17(reserver17);
            return;
        }
        this.reserver17 = reserver17;
        this.reserver17DirtyFlag = true;
    }

    public Double getReserver17() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver17();
        }
        return this.reserver17;
    }

    public boolean isReserver17Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver17Dirty();
        }
        return this.reserver17DirtyFlag;
    }

    public void resetReserver17() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver17();
            return;
        }
        this.reserver17DirtyFlag = false;
        this.reserver17 = null;
    }

    public void setReserver18(Double reserver18) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver18(reserver18);
            return;
        }
        this.reserver18 = reserver18;
        this.reserver18DirtyFlag = true;
    }

    public Double getReserver18() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver18();
        }
        return this.reserver18;
    }

    public boolean isReserver18Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver18Dirty();
        }
        return this.reserver18DirtyFlag;
    }

    public void resetReserver18() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver18();
            return;
        }
        this.reserver18DirtyFlag = false;
        this.reserver18 = null;
    }

    public void setReserver19(Timestamp reserver19) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver19(reserver19);
            return;
        }
        this.reserver19 = reserver19;
        this.reserver19DirtyFlag = true;
    }

    public Timestamp getReserver19() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver19();
        }
        return this.reserver19;
    }

    public boolean isReserver19Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver19Dirty();
        }
        return this.reserver19DirtyFlag;
    }

    public void resetReserver19() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver19();
            return;
        }
        this.reserver19DirtyFlag = false;
        this.reserver19 = null;
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

    public void setReserver20(Timestamp reserver20) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver20(reserver20);
            return;
        }
        this.reserver20 = reserver20;
        this.reserver20DirtyFlag = true;
    }

    public Timestamp getReserver20() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver20();
        }
        return this.reserver20;
    }

    public boolean isReserver20Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver20Dirty();
        }
        return this.reserver20DirtyFlag;
    }

    public void resetReserver20() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver20();
            return;
        }
        this.reserver20DirtyFlag = false;
        this.reserver20 = null;
    }

    public void setReserver21(Timestamp reserver21) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver21(reserver21);
            return;
        }
        this.reserver21 = reserver21;
        this.reserver21DirtyFlag = true;
    }

    public Timestamp getReserver21() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver21();
        }
        return this.reserver21;
    }

    public boolean isReserver21Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver21Dirty();
        }
        return this.reserver21DirtyFlag;
    }

    public void resetReserver21() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver21();
            return;
        }
        this.reserver21DirtyFlag = false;
        this.reserver21 = null;
    }

    public void setReserver22(Timestamp reserver22) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver22(reserver22);
            return;
        }
        this.reserver22 = reserver22;
        this.reserver22DirtyFlag = true;
    }

    public Timestamp getReserver22() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver22();
        }
        return this.reserver22;
    }

    public boolean isReserver22Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver22Dirty();
        }
        return this.reserver22DirtyFlag;
    }

    public void resetReserver22() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver22();
            return;
        }
        this.reserver22DirtyFlag = false;
        this.reserver22 = null;
    }

    public void setReserver23(String reserver23) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver23(reserver23);
            return;
        }
        if (reserver23 != null && (reserver23 = StringHelper.trimRight(reserver23)).length() == 0) {
            reserver23 = null;
        }
        this.reserver23 = reserver23;
        this.reserver23DirtyFlag = true;
    }

    public String getReserver23() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver23();
        }
        return this.reserver23;
    }

    public boolean isReserver23Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver23Dirty();
        }
        return this.reserver23DirtyFlag;
    }

    public void resetReserver23() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver23();
            return;
        }
        this.reserver23DirtyFlag = false;
        this.reserver23 = null;
    }

    public void setReserver24(String reserver24) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver24(reserver24);
            return;
        }
        if (reserver24 != null && (reserver24 = StringHelper.trimRight(reserver24)).length() == 0) {
            reserver24 = null;
        }
        this.reserver24 = reserver24;
        this.reserver24DirtyFlag = true;
    }

    public String getReserver24() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver24();
        }
        return this.reserver24;
    }

    public boolean isReserver24Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver24Dirty();
        }
        return this.reserver24DirtyFlag;
    }

    public void resetReserver24() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver24();
            return;
        }
        this.reserver24DirtyFlag = false;
        this.reserver24 = null;
    }

    public void setReserver25(String reserver25) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver25(reserver25);
            return;
        }
        if (reserver25 != null && (reserver25 = StringHelper.trimRight(reserver25)).length() == 0) {
            reserver25 = null;
        }
        this.reserver25 = reserver25;
        this.reserver25DirtyFlag = true;
    }

    public String getReserver25() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver25();
        }
        return this.reserver25;
    }

    public boolean isReserver25Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver25Dirty();
        }
        return this.reserver25DirtyFlag;
    }

    public void resetReserver25() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver25();
            return;
        }
        this.reserver25DirtyFlag = false;
        this.reserver25 = null;
    }

    public void setReserver26(String reserver26) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver26(reserver26);
            return;
        }
        if (reserver26 != null && (reserver26 = StringHelper.trimRight(reserver26)).length() == 0) {
            reserver26 = null;
        }
        this.reserver26 = reserver26;
        this.reserver26DirtyFlag = true;
    }

    public String getReserver26() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver26();
        }
        return this.reserver26;
    }

    public boolean isReserver26Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver26Dirty();
        }
        return this.reserver26DirtyFlag;
    }

    public void resetReserver26() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver26();
            return;
        }
        this.reserver26DirtyFlag = false;
        this.reserver26 = null;
    }

    public void setReserver27(String reserver27) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver27(reserver27);
            return;
        }
        if (reserver27 != null && (reserver27 = StringHelper.trimRight(reserver27)).length() == 0) {
            reserver27 = null;
        }
        this.reserver27 = reserver27;
        this.reserver27DirtyFlag = true;
    }

    public String getReserver27() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver27();
        }
        return this.reserver27;
    }

    public boolean isReserver27Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver27Dirty();
        }
        return this.reserver27DirtyFlag;
    }

    public void resetReserver27() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver27();
            return;
        }
        this.reserver27DirtyFlag = false;
        this.reserver27 = null;
    }

    public void setReserver28(String reserver28) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver28(reserver28);
            return;
        }
        if (reserver28 != null && (reserver28 = StringHelper.trimRight(reserver28)).length() == 0) {
            reserver28 = null;
        }
        this.reserver28 = reserver28;
        this.reserver28DirtyFlag = true;
    }

    public String getReserver28() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver28();
        }
        return this.reserver28;
    }

    public boolean isReserver28Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver28Dirty();
        }
        return this.reserver28DirtyFlag;
    }

    public void resetReserver28() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver28();
            return;
        }
        this.reserver28DirtyFlag = false;
        this.reserver28 = null;
    }

    public void setReserver29(String reserver29) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver29(reserver29);
            return;
        }
        if (reserver29 != null && (reserver29 = StringHelper.trimRight(reserver29)).length() == 0) {
            reserver29 = null;
        }
        this.reserver29 = reserver29;
        this.reserver29DirtyFlag = true;
    }

    public String getReserver29() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver29();
        }
        return this.reserver29;
    }

    public boolean isReserver29Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver29Dirty();
        }
        return this.reserver29DirtyFlag;
    }

    public void resetReserver29() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver29();
            return;
        }
        this.reserver29DirtyFlag = false;
        this.reserver29 = null;
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

    public void setReserver30(String reserver30) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver30(reserver30);
            return;
        }
        if (reserver30 != null && (reserver30 = StringHelper.trimRight(reserver30)).length() == 0) {
            reserver30 = null;
        }
        this.reserver30 = reserver30;
        this.reserver30DirtyFlag = true;
    }

    public String getReserver30() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver30();
        }
        return this.reserver30;
    }

    public boolean isReserver30Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver30Dirty();
        }
        return this.reserver30DirtyFlag;
    }

    public void resetReserver30() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver30();
            return;
        }
        this.reserver30DirtyFlag = false;
        this.reserver30 = null;
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

    public void setReserver5(String reserver5) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver5(reserver5);
            return;
        }
        if (reserver5 != null && (reserver5 = StringHelper.trimRight(reserver5)).length() == 0) {
            reserver5 = null;
        }
        this.reserver5 = reserver5;
        this.reserver5DirtyFlag = true;
    }

    public String getReserver5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver5();
        }
        return this.reserver5;
    }

    public boolean isReserver5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver5Dirty();
        }
        return this.reserver5DirtyFlag;
    }

    public void resetReserver5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver5();
            return;
        }
        this.reserver5DirtyFlag = false;
        this.reserver5 = null;
    }

    public void setReserver6(String reserver6) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver6(reserver6);
            return;
        }
        if (reserver6 != null && (reserver6 = StringHelper.trimRight(reserver6)).length() == 0) {
            reserver6 = null;
        }
        this.reserver6 = reserver6;
        this.reserver6DirtyFlag = true;
    }

    public String getReserver6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver6();
        }
        return this.reserver6;
    }

    public boolean isReserver6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver6Dirty();
        }
        return this.reserver6DirtyFlag;
    }

    public void resetReserver6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver6();
            return;
        }
        this.reserver6DirtyFlag = false;
        this.reserver6 = null;
    }

    public void setReserver7(String reserver7) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver7(reserver7);
            return;
        }
        if (reserver7 != null && (reserver7 = StringHelper.trimRight(reserver7)).length() == 0) {
            reserver7 = null;
        }
        this.reserver7 = reserver7;
        this.reserver7DirtyFlag = true;
    }

    public String getReserver7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver7();
        }
        return this.reserver7;
    }

    public boolean isReserver7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver7Dirty();
        }
        return this.reserver7DirtyFlag;
    }

    public void resetReserver7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver7();
            return;
        }
        this.reserver7DirtyFlag = false;
        this.reserver7 = null;
    }

    public void setReserver8(String reserver8) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver8(reserver8);
            return;
        }
        if (reserver8 != null && (reserver8 = StringHelper.trimRight(reserver8)).length() == 0) {
            reserver8 = null;
        }
        this.reserver8 = reserver8;
        this.reserver8DirtyFlag = true;
    }

    public String getReserver8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver8();
        }
        return this.reserver8;
    }

    public boolean isReserver8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver8Dirty();
        }
        return this.reserver8DirtyFlag;
    }

    public void resetReserver8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver8();
            return;
        }
        this.reserver8DirtyFlag = false;
        this.reserver8 = null;
    }

    public void setReserver9(String reserver9) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver9(reserver9);
            return;
        }
        if (reserver9 != null && (reserver9 = StringHelper.trimRight(reserver9)).length() == 0) {
            reserver9 = null;
        }
        this.reserver9 = reserver9;
        this.reserver9DirtyFlag = true;
    }

    public String getReserver9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver9();
        }
        return this.reserver9;
    }

    public boolean isReserver9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver9Dirty();
        }
        return this.reserver9DirtyFlag;
    }

    public void resetReserver9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver9();
            return;
        }
        this.reserver9DirtyFlag = false;
        this.reserver9 = null;
    }

    public void setTypeCode(String typecode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeCode(typecode);
            return;
        }
        if (typecode != null && (typecode = StringHelper.trimRight(typecode)).length() == 0) {
            typecode = null;
        }
        this.typecode = typecode;
        this.typecodeDirtyFlag = true;
    }

    public String getTypeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeCode();
        }
        return this.typecode;
    }

    public boolean isTypeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeCodeDirty();
        }
        return this.typecodeDirtyFlag;
    }

    public void resetTypeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeCode();
            return;
        }
        this.typecodeDirtyFlag = false;
        this.typecode = null;
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

    public void setValidFlag(Integer validflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    @Override
    protected void onReset() {
        OrgSecUserTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(OrgSecUserTypeBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetOrderValue();
        et.resetOrgSecUserTypeId();
        et.resetOrgSecUserTypeName();
        et.resetReserver();
        et.resetReserver10();
        et.resetReserver11();
        et.resetReserver12();
        et.resetReserver13();
        et.resetReserver14();
        et.resetReserver15();
        et.resetReserver16();
        et.resetReserver17();
        et.resetReserver18();
        et.resetReserver19();
        et.resetReserver2();
        et.resetReserver20();
        et.resetReserver21();
        et.resetReserver22();
        et.resetReserver23();
        et.resetReserver24();
        et.resetReserver25();
        et.resetReserver26();
        et.resetReserver27();
        et.resetReserver28();
        et.resetReserver29();
        et.resetReserver3();
        et.resetReserver30();
        et.resetReserver4();
        et.resetReserver5();
        et.resetReserver6();
        et.resetReserver7();
        et.resetReserver8();
        et.resetReserver9();
        et.resetTypeCode();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetValidFlag();
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
        if (!bDirtyOnly || this.isOrderValueDirty()) {
            params.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bDirtyOnly || this.isOrgSecUserTypeIdDirty()) {
            params.put(FIELD_ORGSECUSERTYPEID, this.getOrgSecUserTypeId());
        }
        if (!bDirtyOnly || this.isOrgSecUserTypeNameDirty()) {
            params.put(FIELD_ORGSECUSERTYPENAME, this.getOrgSecUserTypeName());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver10Dirty()) {
            params.put(FIELD_RESERVER10, this.getReserver10());
        }
        if (!bDirtyOnly || this.isReserver11Dirty()) {
            params.put(FIELD_RESERVER11, this.getReserver11());
        }
        if (!bDirtyOnly || this.isReserver12Dirty()) {
            params.put(FIELD_RESERVER12, this.getReserver12());
        }
        if (!bDirtyOnly || this.isReserver13Dirty()) {
            params.put(FIELD_RESERVER13, this.getReserver13());
        }
        if (!bDirtyOnly || this.isReserver14Dirty()) {
            params.put(FIELD_RESERVER14, this.getReserver14());
        }
        if (!bDirtyOnly || this.isReserver15Dirty()) {
            params.put(FIELD_RESERVER15, this.getReserver15());
        }
        if (!bDirtyOnly || this.isReserver16Dirty()) {
            params.put(FIELD_RESERVER16, this.getReserver16());
        }
        if (!bDirtyOnly || this.isReserver17Dirty()) {
            params.put(FIELD_RESERVER17, this.getReserver17());
        }
        if (!bDirtyOnly || this.isReserver18Dirty()) {
            params.put(FIELD_RESERVER18, this.getReserver18());
        }
        if (!bDirtyOnly || this.isReserver19Dirty()) {
            params.put(FIELD_RESERVER19, this.getReserver19());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver20Dirty()) {
            params.put(FIELD_RESERVER20, this.getReserver20());
        }
        if (!bDirtyOnly || this.isReserver21Dirty()) {
            params.put(FIELD_RESERVER21, this.getReserver21());
        }
        if (!bDirtyOnly || this.isReserver22Dirty()) {
            params.put(FIELD_RESERVER22, this.getReserver22());
        }
        if (!bDirtyOnly || this.isReserver23Dirty()) {
            params.put(FIELD_RESERVER23, this.getReserver23());
        }
        if (!bDirtyOnly || this.isReserver24Dirty()) {
            params.put(FIELD_RESERVER24, this.getReserver24());
        }
        if (!bDirtyOnly || this.isReserver25Dirty()) {
            params.put(FIELD_RESERVER25, this.getReserver25());
        }
        if (!bDirtyOnly || this.isReserver26Dirty()) {
            params.put(FIELD_RESERVER26, this.getReserver26());
        }
        if (!bDirtyOnly || this.isReserver27Dirty()) {
            params.put(FIELD_RESERVER27, this.getReserver27());
        }
        if (!bDirtyOnly || this.isReserver28Dirty()) {
            params.put(FIELD_RESERVER28, this.getReserver28());
        }
        if (!bDirtyOnly || this.isReserver29Dirty()) {
            params.put(FIELD_RESERVER29, this.getReserver29());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver30Dirty()) {
            params.put(FIELD_RESERVER30, this.getReserver30());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isReserver5Dirty()) {
            params.put(FIELD_RESERVER5, this.getReserver5());
        }
        if (!bDirtyOnly || this.isReserver6Dirty()) {
            params.put(FIELD_RESERVER6, this.getReserver6());
        }
        if (!bDirtyOnly || this.isReserver7Dirty()) {
            params.put(FIELD_RESERVER7, this.getReserver7());
        }
        if (!bDirtyOnly || this.isReserver8Dirty()) {
            params.put(FIELD_RESERVER8, this.getReserver8());
        }
        if (!bDirtyOnly || this.isReserver9Dirty()) {
            params.put(FIELD_RESERVER9, this.getReserver9());
        }
        if (!bDirtyOnly || this.isTypeCodeDirty()) {
            params.put(FIELD_TYPECODE, this.getTypeCode());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return OrgSecUserTypeBase.get(this, index);
    }

    private static Object get(OrgSecUserTypeBase et, int index) throws Exception {
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
                return et.getOrderValue();
            }
            case 4: {
                return et.getOrgSecUserTypeId();
            }
            case 5: {
                return et.getOrgSecUserTypeName();
            }
            case 6: {
                return et.getReserver();
            }
            case 7: {
                return et.getReserver10();
            }
            case 8: {
                return et.getReserver11();
            }
            case 9: {
                return et.getReserver12();
            }
            case 10: {
                return et.getReserver13();
            }
            case 11: {
                return et.getReserver14();
            }
            case 12: {
                return et.getReserver15();
            }
            case 13: {
                return et.getReserver16();
            }
            case 14: {
                return et.getReserver17();
            }
            case 15: {
                return et.getReserver18();
            }
            case 16: {
                return et.getReserver19();
            }
            case 17: {
                return et.getReserver2();
            }
            case 18: {
                return et.getReserver20();
            }
            case 19: {
                return et.getReserver21();
            }
            case 20: {
                return et.getReserver22();
            }
            case 21: {
                return et.getReserver23();
            }
            case 22: {
                return et.getReserver24();
            }
            case 23: {
                return et.getReserver25();
            }
            case 24: {
                return et.getReserver26();
            }
            case 25: {
                return et.getReserver27();
            }
            case 26: {
                return et.getReserver28();
            }
            case 27: {
                return et.getReserver29();
            }
            case 28: {
                return et.getReserver3();
            }
            case 29: {
                return et.getReserver30();
            }
            case 30: {
                return et.getReserver4();
            }
            case 31: {
                return et.getReserver5();
            }
            case 32: {
                return et.getReserver6();
            }
            case 33: {
                return et.getReserver7();
            }
            case 34: {
                return et.getReserver8();
            }
            case 35: {
                return et.getReserver9();
            }
            case 36: {
                return et.getTypeCode();
            }
            case 37: {
                return et.getUpdateDate();
            }
            case 38: {
                return et.getUpdateMan();
            }
            case 39: {
                return et.getValidFlag();
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
        OrgSecUserTypeBase.set(this, index, objValue);
    }

    private static void set(OrgSecUserTypeBase et, int index, Object obj) throws Exception {
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
                et.setOrderValue(DataObject.getIntegerValue(obj));
                return;
            }
            case 4: {
                et.setOrgSecUserTypeId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setOrgSecUserTypeName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setReserver10(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setReserver11(DataObject.getIntegerValue(obj));
                return;
            }
            case 9: {
                et.setReserver12(DataObject.getIntegerValue(obj));
                return;
            }
            case 10: {
                et.setReserver13(DataObject.getIntegerValue(obj));
                return;
            }
            case 11: {
                et.setReserver14(DataObject.getIntegerValue(obj));
                return;
            }
            case 12: {
                et.setReserver15(DataObject.getDoubleValue(obj));
                return;
            }
            case 13: {
                et.setReserver16(DataObject.getDoubleValue(obj));
                return;
            }
            case 14: {
                et.setReserver17(DataObject.getDoubleValue(obj));
                return;
            }
            case 15: {
                et.setReserver18(DataObject.getDoubleValue(obj));
                return;
            }
            case 16: {
                et.setReserver19(DataObject.getTimestampValue(obj));
                return;
            }
            case 17: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setReserver20(DataObject.getTimestampValue(obj));
                return;
            }
            case 19: {
                et.setReserver21(DataObject.getTimestampValue(obj));
                return;
            }
            case 20: {
                et.setReserver22(DataObject.getTimestampValue(obj));
                return;
            }
            case 21: {
                et.setReserver23(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setReserver24(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setReserver25(DataObject.getStringValue(obj));
                return;
            }
            case 24: {
                et.setReserver26(DataObject.getStringValue(obj));
                return;
            }
            case 25: {
                et.setReserver27(DataObject.getStringValue(obj));
                return;
            }
            case 26: {
                et.setReserver28(DataObject.getStringValue(obj));
                return;
            }
            case 27: {
                et.setReserver29(DataObject.getStringValue(obj));
                return;
            }
            case 28: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 29: {
                et.setReserver30(DataObject.getStringValue(obj));
                return;
            }
            case 30: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 31: {
                et.setReserver5(DataObject.getStringValue(obj));
                return;
            }
            case 32: {
                et.setReserver6(DataObject.getStringValue(obj));
                return;
            }
            case 33: {
                et.setReserver7(DataObject.getStringValue(obj));
                return;
            }
            case 34: {
                et.setReserver8(DataObject.getStringValue(obj));
                return;
            }
            case 35: {
                et.setReserver9(DataObject.getStringValue(obj));
                return;
            }
            case 36: {
                et.setTypeCode(DataObject.getStringValue(obj));
                return;
            }
            case 37: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 38: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 39: {
                et.setValidFlag(DataObject.getIntegerValue(obj));
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
        return OrgSecUserTypeBase.isNull(this, index);
    }

    private static boolean isNull(OrgSecUserTypeBase et, int index) throws Exception {
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
                return et.getOrderValue() == null;
            }
            case 4: {
                return et.getOrgSecUserTypeId() == null;
            }
            case 5: {
                return et.getOrgSecUserTypeName() == null;
            }
            case 6: {
                return et.getReserver() == null;
            }
            case 7: {
                return et.getReserver10() == null;
            }
            case 8: {
                return et.getReserver11() == null;
            }
            case 9: {
                return et.getReserver12() == null;
            }
            case 10: {
                return et.getReserver13() == null;
            }
            case 11: {
                return et.getReserver14() == null;
            }
            case 12: {
                return et.getReserver15() == null;
            }
            case 13: {
                return et.getReserver16() == null;
            }
            case 14: {
                return et.getReserver17() == null;
            }
            case 15: {
                return et.getReserver18() == null;
            }
            case 16: {
                return et.getReserver19() == null;
            }
            case 17: {
                return et.getReserver2() == null;
            }
            case 18: {
                return et.getReserver20() == null;
            }
            case 19: {
                return et.getReserver21() == null;
            }
            case 20: {
                return et.getReserver22() == null;
            }
            case 21: {
                return et.getReserver23() == null;
            }
            case 22: {
                return et.getReserver24() == null;
            }
            case 23: {
                return et.getReserver25() == null;
            }
            case 24: {
                return et.getReserver26() == null;
            }
            case 25: {
                return et.getReserver27() == null;
            }
            case 26: {
                return et.getReserver28() == null;
            }
            case 27: {
                return et.getReserver29() == null;
            }
            case 28: {
                return et.getReserver3() == null;
            }
            case 29: {
                return et.getReserver30() == null;
            }
            case 30: {
                return et.getReserver4() == null;
            }
            case 31: {
                return et.getReserver5() == null;
            }
            case 32: {
                return et.getReserver6() == null;
            }
            case 33: {
                return et.getReserver7() == null;
            }
            case 34: {
                return et.getReserver8() == null;
            }
            case 35: {
                return et.getReserver9() == null;
            }
            case 36: {
                return et.getTypeCode() == null;
            }
            case 37: {
                return et.getUpdateDate() == null;
            }
            case 38: {
                return et.getUpdateMan() == null;
            }
            case 39: {
                return et.getValidFlag() == null;
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
        return OrgSecUserTypeBase.contains(this, index);
    }

    private static boolean contains(OrgSecUserTypeBase et, int index) throws Exception {
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
                return et.isOrderValueDirty();
            }
            case 4: {
                return et.isOrgSecUserTypeIdDirty();
            }
            case 5: {
                return et.isOrgSecUserTypeNameDirty();
            }
            case 6: {
                return et.isReserverDirty();
            }
            case 7: {
                return et.isReserver10Dirty();
            }
            case 8: {
                return et.isReserver11Dirty();
            }
            case 9: {
                return et.isReserver12Dirty();
            }
            case 10: {
                return et.isReserver13Dirty();
            }
            case 11: {
                return et.isReserver14Dirty();
            }
            case 12: {
                return et.isReserver15Dirty();
            }
            case 13: {
                return et.isReserver16Dirty();
            }
            case 14: {
                return et.isReserver17Dirty();
            }
            case 15: {
                return et.isReserver18Dirty();
            }
            case 16: {
                return et.isReserver19Dirty();
            }
            case 17: {
                return et.isReserver2Dirty();
            }
            case 18: {
                return et.isReserver20Dirty();
            }
            case 19: {
                return et.isReserver21Dirty();
            }
            case 20: {
                return et.isReserver22Dirty();
            }
            case 21: {
                return et.isReserver23Dirty();
            }
            case 22: {
                return et.isReserver24Dirty();
            }
            case 23: {
                return et.isReserver25Dirty();
            }
            case 24: {
                return et.isReserver26Dirty();
            }
            case 25: {
                return et.isReserver27Dirty();
            }
            case 26: {
                return et.isReserver28Dirty();
            }
            case 27: {
                return et.isReserver29Dirty();
            }
            case 28: {
                return et.isReserver3Dirty();
            }
            case 29: {
                return et.isReserver30Dirty();
            }
            case 30: {
                return et.isReserver4Dirty();
            }
            case 31: {
                return et.isReserver5Dirty();
            }
            case 32: {
                return et.isReserver6Dirty();
            }
            case 33: {
                return et.isReserver7Dirty();
            }
            case 34: {
                return et.isReserver8Dirty();
            }
            case 35: {
                return et.isReserver9Dirty();
            }
            case 36: {
                return et.isTypeCodeDirty();
            }
            case 37: {
                return et.isUpdateDateDirty();
            }
            case 38: {
                return et.isUpdateManDirty();
            }
            case 39: {
                return et.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        OrgSecUserTypeBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(OrgSecUserTypeBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", OrgSecUserTypeBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", OrgSecUserTypeBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", OrgSecUserTypeBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getOrderValue() != null) {
            JSONObjectHelper.put(json, "ordervalue", OrgSecUserTypeBase.getJSONValue(et.getOrderValue()), false);
        }
        if (bIncEmpty || et.getOrgSecUserTypeId() != null) {
            JSONObjectHelper.put(json, "orgsecusertypeid", OrgSecUserTypeBase.getJSONValue(et.getOrgSecUserTypeId()), false);
        }
        if (bIncEmpty || et.getOrgSecUserTypeName() != null) {
            JSONObjectHelper.put(json, "orgsecusertypename", OrgSecUserTypeBase.getJSONValue(et.getOrgSecUserTypeName()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", OrgSecUserTypeBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver10() != null) {
            JSONObjectHelper.put(json, "reserver10", OrgSecUserTypeBase.getJSONValue(et.getReserver10()), false);
        }
        if (bIncEmpty || et.getReserver11() != null) {
            JSONObjectHelper.put(json, "reserver11", OrgSecUserTypeBase.getJSONValue(et.getReserver11()), false);
        }
        if (bIncEmpty || et.getReserver12() != null) {
            JSONObjectHelper.put(json, "reserver12", OrgSecUserTypeBase.getJSONValue(et.getReserver12()), false);
        }
        if (bIncEmpty || et.getReserver13() != null) {
            JSONObjectHelper.put(json, "reserver13", OrgSecUserTypeBase.getJSONValue(et.getReserver13()), false);
        }
        if (bIncEmpty || et.getReserver14() != null) {
            JSONObjectHelper.put(json, "reserver14", OrgSecUserTypeBase.getJSONValue(et.getReserver14()), false);
        }
        if (bIncEmpty || et.getReserver15() != null) {
            JSONObjectHelper.put(json, "reserver15", OrgSecUserTypeBase.getJSONValue(et.getReserver15()), false);
        }
        if (bIncEmpty || et.getReserver16() != null) {
            JSONObjectHelper.put(json, "reserver16", OrgSecUserTypeBase.getJSONValue(et.getReserver16()), false);
        }
        if (bIncEmpty || et.getReserver17() != null) {
            JSONObjectHelper.put(json, "reserver17", OrgSecUserTypeBase.getJSONValue(et.getReserver17()), false);
        }
        if (bIncEmpty || et.getReserver18() != null) {
            JSONObjectHelper.put(json, "reserver18", OrgSecUserTypeBase.getJSONValue(et.getReserver18()), false);
        }
        if (bIncEmpty || et.getReserver19() != null) {
            JSONObjectHelper.put(json, "reserver19", OrgSecUserTypeBase.getJSONValue(et.getReserver19()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", OrgSecUserTypeBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver20() != null) {
            JSONObjectHelper.put(json, "reserver20", OrgSecUserTypeBase.getJSONValue(et.getReserver20()), false);
        }
        if (bIncEmpty || et.getReserver21() != null) {
            JSONObjectHelper.put(json, "reserver21", OrgSecUserTypeBase.getJSONValue(et.getReserver21()), false);
        }
        if (bIncEmpty || et.getReserver22() != null) {
            JSONObjectHelper.put(json, "reserver22", OrgSecUserTypeBase.getJSONValue(et.getReserver22()), false);
        }
        if (bIncEmpty || et.getReserver23() != null) {
            JSONObjectHelper.put(json, "reserver23", OrgSecUserTypeBase.getJSONValue(et.getReserver23()), false);
        }
        if (bIncEmpty || et.getReserver24() != null) {
            JSONObjectHelper.put(json, "reserver24", OrgSecUserTypeBase.getJSONValue(et.getReserver24()), false);
        }
        if (bIncEmpty || et.getReserver25() != null) {
            JSONObjectHelper.put(json, "reserver25", OrgSecUserTypeBase.getJSONValue(et.getReserver25()), false);
        }
        if (bIncEmpty || et.getReserver26() != null) {
            JSONObjectHelper.put(json, "reserver26", OrgSecUserTypeBase.getJSONValue(et.getReserver26()), false);
        }
        if (bIncEmpty || et.getReserver27() != null) {
            JSONObjectHelper.put(json, "reserver27", OrgSecUserTypeBase.getJSONValue(et.getReserver27()), false);
        }
        if (bIncEmpty || et.getReserver28() != null) {
            JSONObjectHelper.put(json, "reserver28", OrgSecUserTypeBase.getJSONValue(et.getReserver28()), false);
        }
        if (bIncEmpty || et.getReserver29() != null) {
            JSONObjectHelper.put(json, "reserver29", OrgSecUserTypeBase.getJSONValue(et.getReserver29()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", OrgSecUserTypeBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver30() != null) {
            JSONObjectHelper.put(json, "reserver30", OrgSecUserTypeBase.getJSONValue(et.getReserver30()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", OrgSecUserTypeBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getReserver5() != null) {
            JSONObjectHelper.put(json, "reserver5", OrgSecUserTypeBase.getJSONValue(et.getReserver5()), false);
        }
        if (bIncEmpty || et.getReserver6() != null) {
            JSONObjectHelper.put(json, "reserver6", OrgSecUserTypeBase.getJSONValue(et.getReserver6()), false);
        }
        if (bIncEmpty || et.getReserver7() != null) {
            JSONObjectHelper.put(json, "reserver7", OrgSecUserTypeBase.getJSONValue(et.getReserver7()), false);
        }
        if (bIncEmpty || et.getReserver8() != null) {
            JSONObjectHelper.put(json, "reserver8", OrgSecUserTypeBase.getJSONValue(et.getReserver8()), false);
        }
        if (bIncEmpty || et.getReserver9() != null) {
            JSONObjectHelper.put(json, "reserver9", OrgSecUserTypeBase.getJSONValue(et.getReserver9()), false);
        }
        if (bIncEmpty || et.getTypeCode() != null) {
            JSONObjectHelper.put(json, "typecode", OrgSecUserTypeBase.getJSONValue(et.getTypeCode()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", OrgSecUserTypeBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", OrgSecUserTypeBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            JSONObjectHelper.put(json, "validflag", OrgSecUserTypeBase.getJSONValue(et.getValidFlag()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        OrgSecUserTypeBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(OrgSecUserTypeBase et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getOrderValue() != null) {
            obj = et.getOrderValue();
            node.setAttribute(FIELD_ORDERVALUE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getOrgSecUserTypeId() != null) {
            obj = et.getOrgSecUserTypeId();
            node.setAttribute(FIELD_ORGSECUSERTYPEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrgSecUserTypeName() != null) {
            obj = et.getOrgSecUserTypeName();
            node.setAttribute(FIELD_ORGSECUSERTYPENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver10() != null) {
            obj = et.getReserver10();
            node.setAttribute(FIELD_RESERVER10, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver11() != null) {
            obj = et.getReserver11();
            node.setAttribute(FIELD_RESERVER11, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver12() != null) {
            obj = et.getReserver12();
            node.setAttribute(FIELD_RESERVER12, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver13() != null) {
            obj = et.getReserver13();
            node.setAttribute(FIELD_RESERVER13, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver14() != null) {
            obj = et.getReserver14();
            node.setAttribute(FIELD_RESERVER14, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver15() != null) {
            obj = et.getReserver15();
            node.setAttribute(FIELD_RESERVER15, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver16() != null) {
            obj = et.getReserver16();
            node.setAttribute(FIELD_RESERVER16, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver17() != null) {
            obj = et.getReserver17();
            node.setAttribute(FIELD_RESERVER17, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver18() != null) {
            obj = et.getReserver18();
            node.setAttribute(FIELD_RESERVER18, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReserver19() != null) {
            obj = et.getReserver19();
            node.setAttribute(FIELD_RESERVER19, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver20() != null) {
            obj = et.getReserver20();
            node.setAttribute(FIELD_RESERVER20, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getReserver21() != null) {
            obj = et.getReserver21();
            node.setAttribute(FIELD_RESERVER21, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getReserver22() != null) {
            obj = et.getReserver22();
            node.setAttribute(FIELD_RESERVER22, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getReserver23() != null) {
            obj = et.getReserver23();
            node.setAttribute(FIELD_RESERVER23, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver24() != null) {
            obj = et.getReserver24();
            node.setAttribute(FIELD_RESERVER24, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver25() != null) {
            obj = et.getReserver25();
            node.setAttribute(FIELD_RESERVER25, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver26() != null) {
            obj = et.getReserver26();
            node.setAttribute(FIELD_RESERVER26, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver27() != null) {
            obj = et.getReserver27();
            node.setAttribute(FIELD_RESERVER27, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver28() != null) {
            obj = et.getReserver28();
            node.setAttribute(FIELD_RESERVER28, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver29() != null) {
            obj = et.getReserver29();
            node.setAttribute(FIELD_RESERVER29, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver30() != null) {
            obj = et.getReserver30();
            node.setAttribute(FIELD_RESERVER30, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver5() != null) {
            obj = et.getReserver5();
            node.setAttribute(FIELD_RESERVER5, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver6() != null) {
            obj = et.getReserver6();
            node.setAttribute(FIELD_RESERVER6, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver7() != null) {
            obj = et.getReserver7();
            node.setAttribute(FIELD_RESERVER7, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver8() != null) {
            obj = et.getReserver8();
            node.setAttribute(FIELD_RESERVER8, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver9() != null) {
            obj = et.getReserver9();
            node.setAttribute(FIELD_RESERVER9, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTypeCode() != null) {
            obj = et.getTypeCode();
            node.setAttribute(FIELD_TYPECODE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            obj = et.getValidFlag();
            node.setAttribute(FIELD_VALIDFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        OrgSecUserTypeBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(OrgSecUserTypeBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isOrderValueDirty() && (bIncEmpty || et.getOrderValue() != null)) {
            dst.set(FIELD_ORDERVALUE, et.getOrderValue());
        }
        if (et.isOrgSecUserTypeIdDirty() && (bIncEmpty || et.getOrgSecUserTypeId() != null)) {
            dst.set(FIELD_ORGSECUSERTYPEID, et.getOrgSecUserTypeId());
        }
        if (et.isOrgSecUserTypeNameDirty() && (bIncEmpty || et.getOrgSecUserTypeName() != null)) {
            dst.set(FIELD_ORGSECUSERTYPENAME, et.getOrgSecUserTypeName());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver10Dirty() && (bIncEmpty || et.getReserver10() != null)) {
            dst.set(FIELD_RESERVER10, et.getReserver10());
        }
        if (et.isReserver11Dirty() && (bIncEmpty || et.getReserver11() != null)) {
            dst.set(FIELD_RESERVER11, et.getReserver11());
        }
        if (et.isReserver12Dirty() && (bIncEmpty || et.getReserver12() != null)) {
            dst.set(FIELD_RESERVER12, et.getReserver12());
        }
        if (et.isReserver13Dirty() && (bIncEmpty || et.getReserver13() != null)) {
            dst.set(FIELD_RESERVER13, et.getReserver13());
        }
        if (et.isReserver14Dirty() && (bIncEmpty || et.getReserver14() != null)) {
            dst.set(FIELD_RESERVER14, et.getReserver14());
        }
        if (et.isReserver15Dirty() && (bIncEmpty || et.getReserver15() != null)) {
            dst.set(FIELD_RESERVER15, et.getReserver15());
        }
        if (et.isReserver16Dirty() && (bIncEmpty || et.getReserver16() != null)) {
            dst.set(FIELD_RESERVER16, et.getReserver16());
        }
        if (et.isReserver17Dirty() && (bIncEmpty || et.getReserver17() != null)) {
            dst.set(FIELD_RESERVER17, et.getReserver17());
        }
        if (et.isReserver18Dirty() && (bIncEmpty || et.getReserver18() != null)) {
            dst.set(FIELD_RESERVER18, et.getReserver18());
        }
        if (et.isReserver19Dirty() && (bIncEmpty || et.getReserver19() != null)) {
            dst.set(FIELD_RESERVER19, et.getReserver19());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver20Dirty() && (bIncEmpty || et.getReserver20() != null)) {
            dst.set(FIELD_RESERVER20, et.getReserver20());
        }
        if (et.isReserver21Dirty() && (bIncEmpty || et.getReserver21() != null)) {
            dst.set(FIELD_RESERVER21, et.getReserver21());
        }
        if (et.isReserver22Dirty() && (bIncEmpty || et.getReserver22() != null)) {
            dst.set(FIELD_RESERVER22, et.getReserver22());
        }
        if (et.isReserver23Dirty() && (bIncEmpty || et.getReserver23() != null)) {
            dst.set(FIELD_RESERVER23, et.getReserver23());
        }
        if (et.isReserver24Dirty() && (bIncEmpty || et.getReserver24() != null)) {
            dst.set(FIELD_RESERVER24, et.getReserver24());
        }
        if (et.isReserver25Dirty() && (bIncEmpty || et.getReserver25() != null)) {
            dst.set(FIELD_RESERVER25, et.getReserver25());
        }
        if (et.isReserver26Dirty() && (bIncEmpty || et.getReserver26() != null)) {
            dst.set(FIELD_RESERVER26, et.getReserver26());
        }
        if (et.isReserver27Dirty() && (bIncEmpty || et.getReserver27() != null)) {
            dst.set(FIELD_RESERVER27, et.getReserver27());
        }
        if (et.isReserver28Dirty() && (bIncEmpty || et.getReserver28() != null)) {
            dst.set(FIELD_RESERVER28, et.getReserver28());
        }
        if (et.isReserver29Dirty() && (bIncEmpty || et.getReserver29() != null)) {
            dst.set(FIELD_RESERVER29, et.getReserver29());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver30Dirty() && (bIncEmpty || et.getReserver30() != null)) {
            dst.set(FIELD_RESERVER30, et.getReserver30());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isReserver5Dirty() && (bIncEmpty || et.getReserver5() != null)) {
            dst.set(FIELD_RESERVER5, et.getReserver5());
        }
        if (et.isReserver6Dirty() && (bIncEmpty || et.getReserver6() != null)) {
            dst.set(FIELD_RESERVER6, et.getReserver6());
        }
        if (et.isReserver7Dirty() && (bIncEmpty || et.getReserver7() != null)) {
            dst.set(FIELD_RESERVER7, et.getReserver7());
        }
        if (et.isReserver8Dirty() && (bIncEmpty || et.getReserver8() != null)) {
            dst.set(FIELD_RESERVER8, et.getReserver8());
        }
        if (et.isReserver9Dirty() && (bIncEmpty || et.getReserver9() != null)) {
            dst.set(FIELD_RESERVER9, et.getReserver9());
        }
        if (et.isTypeCodeDirty() && (bIncEmpty || et.getTypeCode() != null)) {
            dst.set(FIELD_TYPECODE, et.getTypeCode());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isValidFlagDirty() && (bIncEmpty || et.getValidFlag() != null)) {
            dst.set(FIELD_VALIDFLAG, et.getValidFlag());
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
        return OrgSecUserTypeBase.remove(this, index);
    }

    private static boolean remove(OrgSecUserTypeBase et, int index) throws Exception {
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
                et.resetOrderValue();
                return true;
            }
            case 4: {
                et.resetOrgSecUserTypeId();
                return true;
            }
            case 5: {
                et.resetOrgSecUserTypeName();
                return true;
            }
            case 6: {
                et.resetReserver();
                return true;
            }
            case 7: {
                et.resetReserver10();
                return true;
            }
            case 8: {
                et.resetReserver11();
                return true;
            }
            case 9: {
                et.resetReserver12();
                return true;
            }
            case 10: {
                et.resetReserver13();
                return true;
            }
            case 11: {
                et.resetReserver14();
                return true;
            }
            case 12: {
                et.resetReserver15();
                return true;
            }
            case 13: {
                et.resetReserver16();
                return true;
            }
            case 14: {
                et.resetReserver17();
                return true;
            }
            case 15: {
                et.resetReserver18();
                return true;
            }
            case 16: {
                et.resetReserver19();
                return true;
            }
            case 17: {
                et.resetReserver2();
                return true;
            }
            case 18: {
                et.resetReserver20();
                return true;
            }
            case 19: {
                et.resetReserver21();
                return true;
            }
            case 20: {
                et.resetReserver22();
                return true;
            }
            case 21: {
                et.resetReserver23();
                return true;
            }
            case 22: {
                et.resetReserver24();
                return true;
            }
            case 23: {
                et.resetReserver25();
                return true;
            }
            case 24: {
                et.resetReserver26();
                return true;
            }
            case 25: {
                et.resetReserver27();
                return true;
            }
            case 26: {
                et.resetReserver28();
                return true;
            }
            case 27: {
                et.resetReserver29();
                return true;
            }
            case 28: {
                et.resetReserver3();
                return true;
            }
            case 29: {
                et.resetReserver30();
                return true;
            }
            case 30: {
                et.resetReserver4();
                return true;
            }
            case 31: {
                et.resetReserver5();
                return true;
            }
            case 32: {
                et.resetReserver6();
                return true;
            }
            case 33: {
                et.resetReserver7();
                return true;
            }
            case 34: {
                et.resetReserver8();
                return true;
            }
            case 35: {
                et.resetReserver9();
                return true;
            }
            case 36: {
                et.resetTypeCode();
                return true;
            }
            case 37: {
                et.resetUpdateDate();
                return true;
            }
            case 38: {
                et.resetUpdateMan();
                return true;
            }
            case 39: {
                et.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private OrgSecUserTypeBase getProxyEntity() {
        return this.proxyOrgSecUserTypeBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyOrgSecUserTypeBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof OrgSecUserTypeBase) {
            this.proxyOrgSecUserTypeBase = (OrgSecUserTypeBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.OrgSecUserTypeService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

