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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.PVPart;
import net.ibizsys.psrt.srv.common.entity.PortalPage;
import net.ibizsys.psrt.srv.common.service.PVPartService;
import net.ibizsys.psrt.srv.common.service.PortalPageService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PPModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PPModelBase.class);
    public static final String FIELD_C1PVPARTCTRLID = "C1PVPARTCTRLID";
    public static final String FIELD_C1PVPARTID = "C1PVPARTID";
    public static final String FIELD_C1PVPARTNAME = "C1PVPARTNAME";
    public static final String FIELD_C2PVPARTCTRLID = "C2PVPARTCTRLID";
    public static final String FIELD_C2PVPARTID = "C2PVPARTID";
    public static final String FIELD_C2PVPARTNAME = "C2PVPARTNAME";
    public static final String FIELD_C3PVPARTCTRLID = "C3PVPARTCTRLID";
    public static final String FIELD_C3PVPARTID = "C3PVPARTID";
    public static final String FIELD_C3PVPARTNAME = "C3PVPARTNAME";
    public static final String FIELD_C4PVPARTCTRLID = "C4PVPARTCTRLID";
    public static final String FIELD_C4PVPARTID = "C4PVPARTID";
    public static final String FIELD_C4PVPARTNAME = "C4PVPARTNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISSYSTEM = "ISSYSTEM";
    public static final String FIELD_L1PVPARTCTRLID = "L1PVPARTCTRLID";
    public static final String FIELD_L1PVPARTID = "L1PVPARTID";
    public static final String FIELD_L1PVPARTNAME = "L1PVPARTNAME";
    public static final String FIELD_L2PVPARTCTRLID = "L2PVPARTCTRLID";
    public static final String FIELD_L2PVPARTID = "L2PVPARTID";
    public static final String FIELD_L2PVPARTNAME = "L2PVPARTNAME";
    public static final String FIELD_L3PVPARTCTRLID = "L3PVPARTCTRLID";
    public static final String FIELD_L3PVPARTID = "L3PVPARTID";
    public static final String FIELD_L3PVPARTNAME = "L3PVPARTNAME";
    public static final String FIELD_L4PVPARTCTRLID = "L4PVPARTCTRLID";
    public static final String FIELD_L4PVPARTID = "L4PVPARTID";
    public static final String FIELD_L4PVPARTNAME = "L4PVPARTNAME";
    public static final String FIELD_OWNERID = "OWNERID";
    public static final String FIELD_PORTALPAGEID = "PORTALPAGEID";
    public static final String FIELD_PORTALPAGENAME = "PORTALPAGENAME";
    public static final String FIELD_PPMODEL = "PPMODEL";
    public static final String FIELD_PPMODELDETAIL = "PPMODELDETAIL";
    public static final String FIELD_PPMODELID = "PPMODELID";
    public static final String FIELD_PPMODELNAME = "PPMODELNAME";
    public static final String FIELD_PPMVERSION = "PPMVERSION";
    public static final String FIELD_R1PVPARTCTRLID = "R1PVPARTCTRLID";
    public static final String FIELD_R1PVPARTID = "R1PVPARTID";
    public static final String FIELD_R1PVPARTNAME = "R1PVPARTNAME";
    public static final String FIELD_R2PVPARTCTRLID = "R2PVPARTCTRLID";
    public static final String FIELD_R2PVPARTID = "R2PVPARTID";
    public static final String FIELD_R2PVPARTNAME = "R2PVPARTNAME";
    public static final String FIELD_R3PVPARTCTRLID = "R3PVPARTCTRLID";
    public static final String FIELD_R3PVPARTID = "R3PVPARTID";
    public static final String FIELD_R3PVPARTNAME = "R3PVPARTNAME";
    public static final String FIELD_R4PVPARTCTRLID = "R4PVPARTCTRLID";
    public static final String FIELD_R4PVPARTID = "R4PVPARTID";
    public static final String FIELD_R4PVPARTNAME = "R4PVPARTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_C1PVPARTCTRLID = 0;
    private static final int INDEX_C1PVPARTID = 1;
    private static final int INDEX_C1PVPARTNAME = 2;
    private static final int INDEX_C2PVPARTCTRLID = 3;
    private static final int INDEX_C2PVPARTID = 4;
    private static final int INDEX_C2PVPARTNAME = 5;
    private static final int INDEX_C3PVPARTCTRLID = 6;
    private static final int INDEX_C3PVPARTID = 7;
    private static final int INDEX_C3PVPARTNAME = 8;
    private static final int INDEX_C4PVPARTCTRLID = 9;
    private static final int INDEX_C4PVPARTID = 10;
    private static final int INDEX_C4PVPARTNAME = 11;
    private static final int INDEX_CREATEDATE = 12;
    private static final int INDEX_CREATEMAN = 13;
    private static final int INDEX_ISSYSTEM = 14;
    private static final int INDEX_L1PVPARTCTRLID = 15;
    private static final int INDEX_L1PVPARTID = 16;
    private static final int INDEX_L1PVPARTNAME = 17;
    private static final int INDEX_L2PVPARTCTRLID = 18;
    private static final int INDEX_L2PVPARTID = 19;
    private static final int INDEX_L2PVPARTNAME = 20;
    private static final int INDEX_L3PVPARTCTRLID = 21;
    private static final int INDEX_L3PVPARTID = 22;
    private static final int INDEX_L3PVPARTNAME = 23;
    private static final int INDEX_L4PVPARTCTRLID = 24;
    private static final int INDEX_L4PVPARTID = 25;
    private static final int INDEX_L4PVPARTNAME = 26;
    private static final int INDEX_OWNERID = 27;
    private static final int INDEX_PORTALPAGEID = 28;
    private static final int INDEX_PORTALPAGENAME = 29;
    private static final int INDEX_PPMODEL = 30;
    private static final int INDEX_PPMODELDETAIL = 31;
    private static final int INDEX_PPMODELID = 32;
    private static final int INDEX_PPMODELNAME = 33;
    private static final int INDEX_PPMVERSION = 34;
    private static final int INDEX_R1PVPARTCTRLID = 35;
    private static final int INDEX_R1PVPARTID = 36;
    private static final int INDEX_R1PVPARTNAME = 37;
    private static final int INDEX_R2PVPARTCTRLID = 38;
    private static final int INDEX_R2PVPARTID = 39;
    private static final int INDEX_R2PVPARTNAME = 40;
    private static final int INDEX_R3PVPARTCTRLID = 41;
    private static final int INDEX_R3PVPARTID = 42;
    private static final int INDEX_R3PVPARTNAME = 43;
    private static final int INDEX_R4PVPARTCTRLID = 44;
    private static final int INDEX_R4PVPARTID = 45;
    private static final int INDEX_R4PVPARTNAME = 46;
    private static final int INDEX_UPDATEDATE = 47;
    private static final int INDEX_UPDATEMAN = 48;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PPModelBase proxyPPModelBase = null;
    private boolean c1pvpartctrlidDirtyFlag = false;
    private boolean c1pvpartidDirtyFlag = false;
    private boolean c1pvpartnameDirtyFlag = false;
    private boolean c2pvpartctrlidDirtyFlag = false;
    private boolean c2pvpartidDirtyFlag = false;
    private boolean c2pvpartnameDirtyFlag = false;
    private boolean c3pvpartctrlidDirtyFlag = false;
    private boolean c3pvpartidDirtyFlag = false;
    private boolean c3pvpartnameDirtyFlag = false;
    private boolean c4pvpartctrlidDirtyFlag = false;
    private boolean c4pvpartidDirtyFlag = false;
    private boolean c4pvpartnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean issystemDirtyFlag = false;
    private boolean l1pvpartctrlidDirtyFlag = false;
    private boolean l1pvpartidDirtyFlag = false;
    private boolean l1pvpartnameDirtyFlag = false;
    private boolean l2pvpartctrlidDirtyFlag = false;
    private boolean l2pvpartidDirtyFlag = false;
    private boolean l2pvpartnameDirtyFlag = false;
    private boolean l3pvpartctrlidDirtyFlag = false;
    private boolean l3pvpartidDirtyFlag = false;
    private boolean l3pvpartnameDirtyFlag = false;
    private boolean l4pvpartctrlidDirtyFlag = false;
    private boolean l4pvpartidDirtyFlag = false;
    private boolean l4pvpartnameDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean portalpageidDirtyFlag = false;
    private boolean portalpagenameDirtyFlag = false;
    private boolean ppmodelDirtyFlag = false;
    private boolean ppmodeldetailDirtyFlag = false;
    private boolean ppmodelidDirtyFlag = false;
    private boolean ppmodelnameDirtyFlag = false;
    private boolean ppmversionDirtyFlag = false;
    private boolean r1pvpartctrlidDirtyFlag = false;
    private boolean r1pvpartidDirtyFlag = false;
    private boolean r1pvpartnameDirtyFlag = false;
    private boolean r2pvpartctrlidDirtyFlag = false;
    private boolean r2pvpartidDirtyFlag = false;
    private boolean r2pvpartnameDirtyFlag = false;
    private boolean r3pvpartctrlidDirtyFlag = false;
    private boolean r3pvpartidDirtyFlag = false;
    private boolean r3pvpartnameDirtyFlag = false;
    private boolean r4pvpartctrlidDirtyFlag = false;
    private boolean r4pvpartidDirtyFlag = false;
    private boolean r4pvpartnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="c1pvpartctrlid")
    private String c1pvpartctrlid;
    @Column(name="c1pvpartid")
    private String c1pvpartid;
    @Column(name="c1pvpartname")
    private String c1pvpartname;
    @Column(name="c2pvpartctrlid")
    private String c2pvpartctrlid;
    @Column(name="c2pvpartid")
    private String c2pvpartid;
    @Column(name="c2pvpartname")
    private String c2pvpartname;
    @Column(name="c3pvpartctrlid")
    private String c3pvpartctrlid;
    @Column(name="c3pvpartid")
    private String c3pvpartid;
    @Column(name="c3pvpartname")
    private String c3pvpartname;
    @Column(name="c4pvpartctrlid")
    private String c4pvpartctrlid;
    @Column(name="c4pvpartid")
    private String c4pvpartid;
    @Column(name="c4pvpartname")
    private String c4pvpartname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="issystem")
    private Integer issystem;
    @Column(name="l1pvpartctrlid")
    private String l1pvpartctrlid;
    @Column(name="l1pvpartid")
    private String l1pvpartid;
    @Column(name="l1pvpartname")
    private String l1pvpartname;
    @Column(name="l2pvpartctrlid")
    private String l2pvpartctrlid;
    @Column(name="l2pvpartid")
    private String l2pvpartid;
    @Column(name="l2pvpartname")
    private String l2pvpartname;
    @Column(name="l3pvpartctrlid")
    private String l3pvpartctrlid;
    @Column(name="l3pvpartid")
    private String l3pvpartid;
    @Column(name="l3pvpartname")
    private String l3pvpartname;
    @Column(name="l4pvpartctrlid")
    private String l4pvpartctrlid;
    @Column(name="l4pvpartid")
    private String l4pvpartid;
    @Column(name="l4pvpartname")
    private String l4pvpartname;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="portalpageid")
    private String portalpageid;
    @Column(name="portalpagename")
    private String portalpagename;
    @Column(name="ppmodel")
    private String ppmodel;
    @Column(name="ppmodeldetail")
    private String ppmodeldetail;
    @Column(name="ppmodelid")
    private String ppmodelid;
    @Column(name="ppmodelname")
    private String ppmodelname;
    @Column(name="ppmversion")
    private Integer ppmversion;
    @Column(name="r1pvpartctrlid")
    private String r1pvpartctrlid;
    @Column(name="r1pvpartid")
    private String r1pvpartid;
    @Column(name="r1pvpartname")
    private String r1pvpartname;
    @Column(name="r2pvpartctrlid")
    private String r2pvpartctrlid;
    @Column(name="r2pvpartid")
    private String r2pvpartid;
    @Column(name="r2pvpartname")
    private String r2pvpartname;
    @Column(name="r3pvpartctrlid")
    private String r3pvpartctrlid;
    @Column(name="r3pvpartid")
    private String r3pvpartid;
    @Column(name="r3pvpartname")
    private String r3pvpartname;
    @Column(name="r4pvpartctrlid")
    private String r4pvpartctrlid;
    @Column(name="r4pvpartid")
    private String r4pvpartid;
    @Column(name="r4pvpartname")
    private String r4pvpartname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPortalPageLock = new Integer(1);
    private PortalPage portalpage = null;
    private Integer objC1PVPartLock = new Integer(1);
    private PVPart c1pvpart = null;
    private Integer objC2PVPartLock = new Integer(1);
    private PVPart c2pvpart = null;
    private Integer objC3PVPartLock = new Integer(1);
    private PVPart c3pvpart = null;
    private Integer objC4PVPartLock = new Integer(1);
    private PVPart c4pvpart = null;
    private Integer objL1PVPartLock = new Integer(1);
    private PVPart l1pvpart = null;
    private Integer objL2PVPartLock = new Integer(1);
    private PVPart l2pvpart = null;
    private Integer objL3PVPartLock = new Integer(1);
    private PVPart l3pvpart = null;
    private Integer objL4PVPartLock = new Integer(1);
    private PVPart l4pvpart = null;
    private Integer objR1PVPartLock = new Integer(1);
    private PVPart r1pvpart = null;
    private Integer objR2PVPartLock = new Integer(1);
    private PVPart r2pvpart = null;
    private Integer objR3PVPartLock = new Integer(1);
    private PVPart r3pvpart = null;
    private Integer objR4PVPartLock = new Integer(1);
    private PVPart r4pvpart = null;

    static {
        fieldIndexMap.put(FIELD_C1PVPARTCTRLID, 0);
        fieldIndexMap.put(FIELD_C1PVPARTID, 1);
        fieldIndexMap.put(FIELD_C1PVPARTNAME, 2);
        fieldIndexMap.put(FIELD_C2PVPARTCTRLID, 3);
        fieldIndexMap.put(FIELD_C2PVPARTID, 4);
        fieldIndexMap.put(FIELD_C2PVPARTNAME, 5);
        fieldIndexMap.put(FIELD_C3PVPARTCTRLID, 6);
        fieldIndexMap.put(FIELD_C3PVPARTID, 7);
        fieldIndexMap.put(FIELD_C3PVPARTNAME, 8);
        fieldIndexMap.put(FIELD_C4PVPARTCTRLID, 9);
        fieldIndexMap.put(FIELD_C4PVPARTID, 10);
        fieldIndexMap.put(FIELD_C4PVPARTNAME, 11);
        fieldIndexMap.put(FIELD_CREATEDATE, 12);
        fieldIndexMap.put(FIELD_CREATEMAN, 13);
        fieldIndexMap.put(FIELD_ISSYSTEM, 14);
        fieldIndexMap.put(FIELD_L1PVPARTCTRLID, 15);
        fieldIndexMap.put(FIELD_L1PVPARTID, 16);
        fieldIndexMap.put(FIELD_L1PVPARTNAME, 17);
        fieldIndexMap.put(FIELD_L2PVPARTCTRLID, 18);
        fieldIndexMap.put(FIELD_L2PVPARTID, 19);
        fieldIndexMap.put(FIELD_L2PVPARTNAME, 20);
        fieldIndexMap.put(FIELD_L3PVPARTCTRLID, 21);
        fieldIndexMap.put(FIELD_L3PVPARTID, 22);
        fieldIndexMap.put(FIELD_L3PVPARTNAME, 23);
        fieldIndexMap.put(FIELD_L4PVPARTCTRLID, 24);
        fieldIndexMap.put(FIELD_L4PVPARTID, 25);
        fieldIndexMap.put(FIELD_L4PVPARTNAME, 26);
        fieldIndexMap.put(FIELD_OWNERID, 27);
        fieldIndexMap.put(FIELD_PORTALPAGEID, 28);
        fieldIndexMap.put(FIELD_PORTALPAGENAME, 29);
        fieldIndexMap.put(FIELD_PPMODEL, 30);
        fieldIndexMap.put(FIELD_PPMODELDETAIL, 31);
        fieldIndexMap.put(FIELD_PPMODELID, 32);
        fieldIndexMap.put(FIELD_PPMODELNAME, 33);
        fieldIndexMap.put(FIELD_PPMVERSION, 34);
        fieldIndexMap.put(FIELD_R1PVPARTCTRLID, 35);
        fieldIndexMap.put(FIELD_R1PVPARTID, 36);
        fieldIndexMap.put(FIELD_R1PVPARTNAME, 37);
        fieldIndexMap.put(FIELD_R2PVPARTCTRLID, 38);
        fieldIndexMap.put(FIELD_R2PVPARTID, 39);
        fieldIndexMap.put(FIELD_R2PVPARTNAME, 40);
        fieldIndexMap.put(FIELD_R3PVPARTCTRLID, 41);
        fieldIndexMap.put(FIELD_R3PVPARTID, 42);
        fieldIndexMap.put(FIELD_R3PVPARTNAME, 43);
        fieldIndexMap.put(FIELD_R4PVPARTCTRLID, 44);
        fieldIndexMap.put(FIELD_R4PVPARTID, 45);
        fieldIndexMap.put(FIELD_R4PVPARTNAME, 46);
        fieldIndexMap.put(FIELD_UPDATEDATE, 47);
        fieldIndexMap.put(FIELD_UPDATEMAN, 48);
    }

    public void setC1PVPartCtrlId(String c1pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC1PVPartCtrlId(c1pvpartctrlid);
            return;
        }
        if (c1pvpartctrlid != null && (c1pvpartctrlid = StringHelper.trimRight(c1pvpartctrlid)).length() == 0) {
            c1pvpartctrlid = null;
        }
        this.c1pvpartctrlid = c1pvpartctrlid;
        this.c1pvpartctrlidDirtyFlag = true;
    }

    public String getC1PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC1PVPartCtrlId();
        }
        return this.c1pvpartctrlid;
    }

    public boolean isC1PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC1PVPartCtrlIdDirty();
        }
        return this.c1pvpartctrlidDirtyFlag;
    }

    public void resetC1PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC1PVPartCtrlId();
            return;
        }
        this.c1pvpartctrlidDirtyFlag = false;
        this.c1pvpartctrlid = null;
    }

    public void setC1PVPartId(String c1pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC1PVPartId(c1pvpartid);
            return;
        }
        if (c1pvpartid != null && (c1pvpartid = StringHelper.trimRight(c1pvpartid)).length() == 0) {
            c1pvpartid = null;
        }
        this.c1pvpartid = c1pvpartid;
        this.c1pvpartidDirtyFlag = true;
    }

    public String getC1PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC1PVPartId();
        }
        return this.c1pvpartid;
    }

    public boolean isC1PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC1PVPartIdDirty();
        }
        return this.c1pvpartidDirtyFlag;
    }

    public void resetC1PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC1PVPartId();
            return;
        }
        this.c1pvpartidDirtyFlag = false;
        this.c1pvpartid = null;
    }

    public void setC1PVPartName(String c1pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC1PVPartName(c1pvpartname);
            return;
        }
        if (c1pvpartname != null && (c1pvpartname = StringHelper.trimRight(c1pvpartname)).length() == 0) {
            c1pvpartname = null;
        }
        this.c1pvpartname = c1pvpartname;
        this.c1pvpartnameDirtyFlag = true;
    }

    public String getC1PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC1PVPartName();
        }
        return this.c1pvpartname;
    }

    public boolean isC1PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC1PVPartNameDirty();
        }
        return this.c1pvpartnameDirtyFlag;
    }

    public void resetC1PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC1PVPartName();
            return;
        }
        this.c1pvpartnameDirtyFlag = false;
        this.c1pvpartname = null;
    }

    public void setC2PVPartCtrlId(String c2pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC2PVPartCtrlId(c2pvpartctrlid);
            return;
        }
        if (c2pvpartctrlid != null && (c2pvpartctrlid = StringHelper.trimRight(c2pvpartctrlid)).length() == 0) {
            c2pvpartctrlid = null;
        }
        this.c2pvpartctrlid = c2pvpartctrlid;
        this.c2pvpartctrlidDirtyFlag = true;
    }

    public String getC2PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC2PVPartCtrlId();
        }
        return this.c2pvpartctrlid;
    }

    public boolean isC2PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC2PVPartCtrlIdDirty();
        }
        return this.c2pvpartctrlidDirtyFlag;
    }

    public void resetC2PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC2PVPartCtrlId();
            return;
        }
        this.c2pvpartctrlidDirtyFlag = false;
        this.c2pvpartctrlid = null;
    }

    public void setC2PVPartId(String c2pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC2PVPartId(c2pvpartid);
            return;
        }
        if (c2pvpartid != null && (c2pvpartid = StringHelper.trimRight(c2pvpartid)).length() == 0) {
            c2pvpartid = null;
        }
        this.c2pvpartid = c2pvpartid;
        this.c2pvpartidDirtyFlag = true;
    }

    public String getC2PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC2PVPartId();
        }
        return this.c2pvpartid;
    }

    public boolean isC2PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC2PVPartIdDirty();
        }
        return this.c2pvpartidDirtyFlag;
    }

    public void resetC2PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC2PVPartId();
            return;
        }
        this.c2pvpartidDirtyFlag = false;
        this.c2pvpartid = null;
    }

    public void setC2PVPartName(String c2pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC2PVPartName(c2pvpartname);
            return;
        }
        if (c2pvpartname != null && (c2pvpartname = StringHelper.trimRight(c2pvpartname)).length() == 0) {
            c2pvpartname = null;
        }
        this.c2pvpartname = c2pvpartname;
        this.c2pvpartnameDirtyFlag = true;
    }

    public String getC2PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC2PVPartName();
        }
        return this.c2pvpartname;
    }

    public boolean isC2PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC2PVPartNameDirty();
        }
        return this.c2pvpartnameDirtyFlag;
    }

    public void resetC2PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC2PVPartName();
            return;
        }
        this.c2pvpartnameDirtyFlag = false;
        this.c2pvpartname = null;
    }

    public void setC3PVPartCtrlId(String c3pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC3PVPartCtrlId(c3pvpartctrlid);
            return;
        }
        if (c3pvpartctrlid != null && (c3pvpartctrlid = StringHelper.trimRight(c3pvpartctrlid)).length() == 0) {
            c3pvpartctrlid = null;
        }
        this.c3pvpartctrlid = c3pvpartctrlid;
        this.c3pvpartctrlidDirtyFlag = true;
    }

    public String getC3PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC3PVPartCtrlId();
        }
        return this.c3pvpartctrlid;
    }

    public boolean isC3PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC3PVPartCtrlIdDirty();
        }
        return this.c3pvpartctrlidDirtyFlag;
    }

    public void resetC3PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC3PVPartCtrlId();
            return;
        }
        this.c3pvpartctrlidDirtyFlag = false;
        this.c3pvpartctrlid = null;
    }

    public void setC3PVPartId(String c3pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC3PVPartId(c3pvpartid);
            return;
        }
        if (c3pvpartid != null && (c3pvpartid = StringHelper.trimRight(c3pvpartid)).length() == 0) {
            c3pvpartid = null;
        }
        this.c3pvpartid = c3pvpartid;
        this.c3pvpartidDirtyFlag = true;
    }

    public String getC3PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC3PVPartId();
        }
        return this.c3pvpartid;
    }

    public boolean isC3PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC3PVPartIdDirty();
        }
        return this.c3pvpartidDirtyFlag;
    }

    public void resetC3PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC3PVPartId();
            return;
        }
        this.c3pvpartidDirtyFlag = false;
        this.c3pvpartid = null;
    }

    public void setC3PVPartName(String c3pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC3PVPartName(c3pvpartname);
            return;
        }
        if (c3pvpartname != null && (c3pvpartname = StringHelper.trimRight(c3pvpartname)).length() == 0) {
            c3pvpartname = null;
        }
        this.c3pvpartname = c3pvpartname;
        this.c3pvpartnameDirtyFlag = true;
    }

    public String getC3PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC3PVPartName();
        }
        return this.c3pvpartname;
    }

    public boolean isC3PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC3PVPartNameDirty();
        }
        return this.c3pvpartnameDirtyFlag;
    }

    public void resetC3PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC3PVPartName();
            return;
        }
        this.c3pvpartnameDirtyFlag = false;
        this.c3pvpartname = null;
    }

    public void setC4PVPartCtrlId(String c4pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC4PVPartCtrlId(c4pvpartctrlid);
            return;
        }
        if (c4pvpartctrlid != null && (c4pvpartctrlid = StringHelper.trimRight(c4pvpartctrlid)).length() == 0) {
            c4pvpartctrlid = null;
        }
        this.c4pvpartctrlid = c4pvpartctrlid;
        this.c4pvpartctrlidDirtyFlag = true;
    }

    public String getC4PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC4PVPartCtrlId();
        }
        return this.c4pvpartctrlid;
    }

    public boolean isC4PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC4PVPartCtrlIdDirty();
        }
        return this.c4pvpartctrlidDirtyFlag;
    }

    public void resetC4PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC4PVPartCtrlId();
            return;
        }
        this.c4pvpartctrlidDirtyFlag = false;
        this.c4pvpartctrlid = null;
    }

    public void setC4PVPartId(String c4pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC4PVPartId(c4pvpartid);
            return;
        }
        if (c4pvpartid != null && (c4pvpartid = StringHelper.trimRight(c4pvpartid)).length() == 0) {
            c4pvpartid = null;
        }
        this.c4pvpartid = c4pvpartid;
        this.c4pvpartidDirtyFlag = true;
    }

    public String getC4PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC4PVPartId();
        }
        return this.c4pvpartid;
    }

    public boolean isC4PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC4PVPartIdDirty();
        }
        return this.c4pvpartidDirtyFlag;
    }

    public void resetC4PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC4PVPartId();
            return;
        }
        this.c4pvpartidDirtyFlag = false;
        this.c4pvpartid = null;
    }

    public void setC4PVPartName(String c4pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setC4PVPartName(c4pvpartname);
            return;
        }
        if (c4pvpartname != null && (c4pvpartname = StringHelper.trimRight(c4pvpartname)).length() == 0) {
            c4pvpartname = null;
        }
        this.c4pvpartname = c4pvpartname;
        this.c4pvpartnameDirtyFlag = true;
    }

    public String getC4PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC4PVPartName();
        }
        return this.c4pvpartname;
    }

    public boolean isC4PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isC4PVPartNameDirty();
        }
        return this.c4pvpartnameDirtyFlag;
    }

    public void resetC4PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetC4PVPartName();
            return;
        }
        this.c4pvpartnameDirtyFlag = false;
        this.c4pvpartname = null;
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

    public void setIsSystem(Integer issystem) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsSystem(issystem);
            return;
        }
        this.issystem = issystem;
        this.issystemDirtyFlag = true;
    }

    public Integer getIsSystem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsSystem();
        }
        return this.issystem;
    }

    public boolean isIsSystemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsSystemDirty();
        }
        return this.issystemDirtyFlag;
    }

    public void resetIsSystem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsSystem();
            return;
        }
        this.issystemDirtyFlag = false;
        this.issystem = null;
    }

    public void setL1PVPartCtrlId(String l1pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL1PVPartCtrlId(l1pvpartctrlid);
            return;
        }
        if (l1pvpartctrlid != null && (l1pvpartctrlid = StringHelper.trimRight(l1pvpartctrlid)).length() == 0) {
            l1pvpartctrlid = null;
        }
        this.l1pvpartctrlid = l1pvpartctrlid;
        this.l1pvpartctrlidDirtyFlag = true;
    }

    public String getL1PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL1PVPartCtrlId();
        }
        return this.l1pvpartctrlid;
    }

    public boolean isL1PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL1PVPartCtrlIdDirty();
        }
        return this.l1pvpartctrlidDirtyFlag;
    }

    public void resetL1PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL1PVPartCtrlId();
            return;
        }
        this.l1pvpartctrlidDirtyFlag = false;
        this.l1pvpartctrlid = null;
    }

    public void setL1PVPartId(String l1pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL1PVPartId(l1pvpartid);
            return;
        }
        if (l1pvpartid != null && (l1pvpartid = StringHelper.trimRight(l1pvpartid)).length() == 0) {
            l1pvpartid = null;
        }
        this.l1pvpartid = l1pvpartid;
        this.l1pvpartidDirtyFlag = true;
    }

    public String getL1PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL1PVPartId();
        }
        return this.l1pvpartid;
    }

    public boolean isL1PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL1PVPartIdDirty();
        }
        return this.l1pvpartidDirtyFlag;
    }

    public void resetL1PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL1PVPartId();
            return;
        }
        this.l1pvpartidDirtyFlag = false;
        this.l1pvpartid = null;
    }

    public void setL1PVPartName(String l1pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL1PVPartName(l1pvpartname);
            return;
        }
        if (l1pvpartname != null && (l1pvpartname = StringHelper.trimRight(l1pvpartname)).length() == 0) {
            l1pvpartname = null;
        }
        this.l1pvpartname = l1pvpartname;
        this.l1pvpartnameDirtyFlag = true;
    }

    public String getL1PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL1PVPartName();
        }
        return this.l1pvpartname;
    }

    public boolean isL1PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL1PVPartNameDirty();
        }
        return this.l1pvpartnameDirtyFlag;
    }

    public void resetL1PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL1PVPartName();
            return;
        }
        this.l1pvpartnameDirtyFlag = false;
        this.l1pvpartname = null;
    }

    public void setL2PVPartCtrlId(String l2pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL2PVPartCtrlId(l2pvpartctrlid);
            return;
        }
        if (l2pvpartctrlid != null && (l2pvpartctrlid = StringHelper.trimRight(l2pvpartctrlid)).length() == 0) {
            l2pvpartctrlid = null;
        }
        this.l2pvpartctrlid = l2pvpartctrlid;
        this.l2pvpartctrlidDirtyFlag = true;
    }

    public String getL2PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL2PVPartCtrlId();
        }
        return this.l2pvpartctrlid;
    }

    public boolean isL2PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL2PVPartCtrlIdDirty();
        }
        return this.l2pvpartctrlidDirtyFlag;
    }

    public void resetL2PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL2PVPartCtrlId();
            return;
        }
        this.l2pvpartctrlidDirtyFlag = false;
        this.l2pvpartctrlid = null;
    }

    public void setL2PVPartId(String l2pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL2PVPartId(l2pvpartid);
            return;
        }
        if (l2pvpartid != null && (l2pvpartid = StringHelper.trimRight(l2pvpartid)).length() == 0) {
            l2pvpartid = null;
        }
        this.l2pvpartid = l2pvpartid;
        this.l2pvpartidDirtyFlag = true;
    }

    public String getL2PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL2PVPartId();
        }
        return this.l2pvpartid;
    }

    public boolean isL2PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL2PVPartIdDirty();
        }
        return this.l2pvpartidDirtyFlag;
    }

    public void resetL2PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL2PVPartId();
            return;
        }
        this.l2pvpartidDirtyFlag = false;
        this.l2pvpartid = null;
    }

    public void setL2PVPartName(String l2pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL2PVPartName(l2pvpartname);
            return;
        }
        if (l2pvpartname != null && (l2pvpartname = StringHelper.trimRight(l2pvpartname)).length() == 0) {
            l2pvpartname = null;
        }
        this.l2pvpartname = l2pvpartname;
        this.l2pvpartnameDirtyFlag = true;
    }

    public String getL2PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL2PVPartName();
        }
        return this.l2pvpartname;
    }

    public boolean isL2PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL2PVPartNameDirty();
        }
        return this.l2pvpartnameDirtyFlag;
    }

    public void resetL2PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL2PVPartName();
            return;
        }
        this.l2pvpartnameDirtyFlag = false;
        this.l2pvpartname = null;
    }

    public void setL3PVPartCtrlId(String l3pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL3PVPartCtrlId(l3pvpartctrlid);
            return;
        }
        if (l3pvpartctrlid != null && (l3pvpartctrlid = StringHelper.trimRight(l3pvpartctrlid)).length() == 0) {
            l3pvpartctrlid = null;
        }
        this.l3pvpartctrlid = l3pvpartctrlid;
        this.l3pvpartctrlidDirtyFlag = true;
    }

    public String getL3PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL3PVPartCtrlId();
        }
        return this.l3pvpartctrlid;
    }

    public boolean isL3PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL3PVPartCtrlIdDirty();
        }
        return this.l3pvpartctrlidDirtyFlag;
    }

    public void resetL3PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL3PVPartCtrlId();
            return;
        }
        this.l3pvpartctrlidDirtyFlag = false;
        this.l3pvpartctrlid = null;
    }

    public void setL3PVPartId(String l3pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL3PVPartId(l3pvpartid);
            return;
        }
        if (l3pvpartid != null && (l3pvpartid = StringHelper.trimRight(l3pvpartid)).length() == 0) {
            l3pvpartid = null;
        }
        this.l3pvpartid = l3pvpartid;
        this.l3pvpartidDirtyFlag = true;
    }

    public String getL3PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL3PVPartId();
        }
        return this.l3pvpartid;
    }

    public boolean isL3PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL3PVPartIdDirty();
        }
        return this.l3pvpartidDirtyFlag;
    }

    public void resetL3PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL3PVPartId();
            return;
        }
        this.l3pvpartidDirtyFlag = false;
        this.l3pvpartid = null;
    }

    public void setL3PVPartName(String l3pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL3PVPartName(l3pvpartname);
            return;
        }
        if (l3pvpartname != null && (l3pvpartname = StringHelper.trimRight(l3pvpartname)).length() == 0) {
            l3pvpartname = null;
        }
        this.l3pvpartname = l3pvpartname;
        this.l3pvpartnameDirtyFlag = true;
    }

    public String getL3PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL3PVPartName();
        }
        return this.l3pvpartname;
    }

    public boolean isL3PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL3PVPartNameDirty();
        }
        return this.l3pvpartnameDirtyFlag;
    }

    public void resetL3PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL3PVPartName();
            return;
        }
        this.l3pvpartnameDirtyFlag = false;
        this.l3pvpartname = null;
    }

    public void setL4PVPartCtrlId(String l4pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL4PVPartCtrlId(l4pvpartctrlid);
            return;
        }
        if (l4pvpartctrlid != null && (l4pvpartctrlid = StringHelper.trimRight(l4pvpartctrlid)).length() == 0) {
            l4pvpartctrlid = null;
        }
        this.l4pvpartctrlid = l4pvpartctrlid;
        this.l4pvpartctrlidDirtyFlag = true;
    }

    public String getL4PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL4PVPartCtrlId();
        }
        return this.l4pvpartctrlid;
    }

    public boolean isL4PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL4PVPartCtrlIdDirty();
        }
        return this.l4pvpartctrlidDirtyFlag;
    }

    public void resetL4PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL4PVPartCtrlId();
            return;
        }
        this.l4pvpartctrlidDirtyFlag = false;
        this.l4pvpartctrlid = null;
    }

    public void setL4PVPartId(String l4pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL4PVPartId(l4pvpartid);
            return;
        }
        if (l4pvpartid != null && (l4pvpartid = StringHelper.trimRight(l4pvpartid)).length() == 0) {
            l4pvpartid = null;
        }
        this.l4pvpartid = l4pvpartid;
        this.l4pvpartidDirtyFlag = true;
    }

    public String getL4PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL4PVPartId();
        }
        return this.l4pvpartid;
    }

    public boolean isL4PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL4PVPartIdDirty();
        }
        return this.l4pvpartidDirtyFlag;
    }

    public void resetL4PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL4PVPartId();
            return;
        }
        this.l4pvpartidDirtyFlag = false;
        this.l4pvpartid = null;
    }

    public void setL4PVPartName(String l4pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setL4PVPartName(l4pvpartname);
            return;
        }
        if (l4pvpartname != null && (l4pvpartname = StringHelper.trimRight(l4pvpartname)).length() == 0) {
            l4pvpartname = null;
        }
        this.l4pvpartname = l4pvpartname;
        this.l4pvpartnameDirtyFlag = true;
    }

    public String getL4PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL4PVPartName();
        }
        return this.l4pvpartname;
    }

    public boolean isL4PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isL4PVPartNameDirty();
        }
        return this.l4pvpartnameDirtyFlag;
    }

    public void resetL4PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetL4PVPartName();
            return;
        }
        this.l4pvpartnameDirtyFlag = false;
        this.l4pvpartname = null;
    }

    public void setOwnerId(String ownerid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerId(ownerid);
            return;
        }
        if (ownerid != null && (ownerid = StringHelper.trimRight(ownerid)).length() == 0) {
            ownerid = null;
        }
        this.ownerid = ownerid;
        this.owneridDirtyFlag = true;
    }

    public String getOwnerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    public boolean isOwnerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    public void resetOwnerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerId();
            return;
        }
        this.owneridDirtyFlag = false;
        this.ownerid = null;
    }

    public void setPortalPageId(String portalpageid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortalPageId(portalpageid);
            return;
        }
        if (portalpageid != null && (portalpageid = StringHelper.trimRight(portalpageid)).length() == 0) {
            portalpageid = null;
        }
        this.portalpageid = portalpageid;
        this.portalpageidDirtyFlag = true;
    }

    public String getPortalPageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortalPageId();
        }
        return this.portalpageid;
    }

    public boolean isPortalPageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortalPageIdDirty();
        }
        return this.portalpageidDirtyFlag;
    }

    public void resetPortalPageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortalPageId();
            return;
        }
        this.portalpageidDirtyFlag = false;
        this.portalpageid = null;
    }

    public void setPortalPageName(String portalpagename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortalPageName(portalpagename);
            return;
        }
        if (portalpagename != null && (portalpagename = StringHelper.trimRight(portalpagename)).length() == 0) {
            portalpagename = null;
        }
        this.portalpagename = portalpagename;
        this.portalpagenameDirtyFlag = true;
    }

    public String getPortalPageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortalPageName();
        }
        return this.portalpagename;
    }

    public boolean isPortalPageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortalPageNameDirty();
        }
        return this.portalpagenameDirtyFlag;
    }

    public void resetPortalPageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortalPageName();
            return;
        }
        this.portalpagenameDirtyFlag = false;
        this.portalpagename = null;
    }

    public void setPPModel(String ppmodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPModel(ppmodel);
            return;
        }
        if (ppmodel != null && (ppmodel = StringHelper.trimRight(ppmodel)).length() == 0) {
            ppmodel = null;
        }
        this.ppmodel = ppmodel;
        this.ppmodelDirtyFlag = true;
    }

    public String getPPModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPModel();
        }
        return this.ppmodel;
    }

    public boolean isPPModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPModelDirty();
        }
        return this.ppmodelDirtyFlag;
    }

    public void resetPPModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPModel();
            return;
        }
        this.ppmodelDirtyFlag = false;
        this.ppmodel = null;
    }

    public void setPPModelDetail(String ppmodeldetail) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPModelDetail(ppmodeldetail);
            return;
        }
        if (ppmodeldetail != null && (ppmodeldetail = StringHelper.trimRight(ppmodeldetail)).length() == 0) {
            ppmodeldetail = null;
        }
        this.ppmodeldetail = ppmodeldetail;
        this.ppmodeldetailDirtyFlag = true;
    }

    public String getPPModelDetail() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPModelDetail();
        }
        return this.ppmodeldetail;
    }

    public boolean isPPModelDetailDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPModelDetailDirty();
        }
        return this.ppmodeldetailDirtyFlag;
    }

    public void resetPPModelDetail() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPModelDetail();
            return;
        }
        this.ppmodeldetailDirtyFlag = false;
        this.ppmodeldetail = null;
    }

    public void setPPModelId(String ppmodelid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPModelId(ppmodelid);
            return;
        }
        if (ppmodelid != null && (ppmodelid = StringHelper.trimRight(ppmodelid)).length() == 0) {
            ppmodelid = null;
        }
        this.ppmodelid = ppmodelid;
        this.ppmodelidDirtyFlag = true;
    }

    public String getPPModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPModelId();
        }
        return this.ppmodelid;
    }

    public boolean isPPModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPModelIdDirty();
        }
        return this.ppmodelidDirtyFlag;
    }

    public void resetPPModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPModelId();
            return;
        }
        this.ppmodelidDirtyFlag = false;
        this.ppmodelid = null;
    }

    public void setPPModelName(String ppmodelname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPModelName(ppmodelname);
            return;
        }
        if (ppmodelname != null && (ppmodelname = StringHelper.trimRight(ppmodelname)).length() == 0) {
            ppmodelname = null;
        }
        this.ppmodelname = ppmodelname;
        this.ppmodelnameDirtyFlag = true;
    }

    public String getPPModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPModelName();
        }
        return this.ppmodelname;
    }

    public boolean isPPModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPModelNameDirty();
        }
        return this.ppmodelnameDirtyFlag;
    }

    public void resetPPModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPModelName();
            return;
        }
        this.ppmodelnameDirtyFlag = false;
        this.ppmodelname = null;
    }

    public void setPPMVersion(Integer ppmversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPMVersion(ppmversion);
            return;
        }
        this.ppmversion = ppmversion;
        this.ppmversionDirtyFlag = true;
    }

    public Integer getPPMVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPMVersion();
        }
        return this.ppmversion;
    }

    public boolean isPPMVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPMVersionDirty();
        }
        return this.ppmversionDirtyFlag;
    }

    public void resetPPMVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPMVersion();
            return;
        }
        this.ppmversionDirtyFlag = false;
        this.ppmversion = null;
    }

    public void setR1PVPartCtrlId(String r1pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR1PVPartCtrlId(r1pvpartctrlid);
            return;
        }
        if (r1pvpartctrlid != null && (r1pvpartctrlid = StringHelper.trimRight(r1pvpartctrlid)).length() == 0) {
            r1pvpartctrlid = null;
        }
        this.r1pvpartctrlid = r1pvpartctrlid;
        this.r1pvpartctrlidDirtyFlag = true;
    }

    public String getR1PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR1PVPartCtrlId();
        }
        return this.r1pvpartctrlid;
    }

    public boolean isR1PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR1PVPartCtrlIdDirty();
        }
        return this.r1pvpartctrlidDirtyFlag;
    }

    public void resetR1PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR1PVPartCtrlId();
            return;
        }
        this.r1pvpartctrlidDirtyFlag = false;
        this.r1pvpartctrlid = null;
    }

    public void setR1PVPartId(String r1pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR1PVPartId(r1pvpartid);
            return;
        }
        if (r1pvpartid != null && (r1pvpartid = StringHelper.trimRight(r1pvpartid)).length() == 0) {
            r1pvpartid = null;
        }
        this.r1pvpartid = r1pvpartid;
        this.r1pvpartidDirtyFlag = true;
    }

    public String getR1PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR1PVPartId();
        }
        return this.r1pvpartid;
    }

    public boolean isR1PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR1PVPartIdDirty();
        }
        return this.r1pvpartidDirtyFlag;
    }

    public void resetR1PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR1PVPartId();
            return;
        }
        this.r1pvpartidDirtyFlag = false;
        this.r1pvpartid = null;
    }

    public void setR1PVPartName(String r1pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR1PVPartName(r1pvpartname);
            return;
        }
        if (r1pvpartname != null && (r1pvpartname = StringHelper.trimRight(r1pvpartname)).length() == 0) {
            r1pvpartname = null;
        }
        this.r1pvpartname = r1pvpartname;
        this.r1pvpartnameDirtyFlag = true;
    }

    public String getR1PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR1PVPartName();
        }
        return this.r1pvpartname;
    }

    public boolean isR1PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR1PVPartNameDirty();
        }
        return this.r1pvpartnameDirtyFlag;
    }

    public void resetR1PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR1PVPartName();
            return;
        }
        this.r1pvpartnameDirtyFlag = false;
        this.r1pvpartname = null;
    }

    public void setR2PVPartCtrlId(String r2pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR2PVPartCtrlId(r2pvpartctrlid);
            return;
        }
        if (r2pvpartctrlid != null && (r2pvpartctrlid = StringHelper.trimRight(r2pvpartctrlid)).length() == 0) {
            r2pvpartctrlid = null;
        }
        this.r2pvpartctrlid = r2pvpartctrlid;
        this.r2pvpartctrlidDirtyFlag = true;
    }

    public String getR2PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR2PVPartCtrlId();
        }
        return this.r2pvpartctrlid;
    }

    public boolean isR2PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR2PVPartCtrlIdDirty();
        }
        return this.r2pvpartctrlidDirtyFlag;
    }

    public void resetR2PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR2PVPartCtrlId();
            return;
        }
        this.r2pvpartctrlidDirtyFlag = false;
        this.r2pvpartctrlid = null;
    }

    public void setR2PVPartId(String r2pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR2PVPartId(r2pvpartid);
            return;
        }
        if (r2pvpartid != null && (r2pvpartid = StringHelper.trimRight(r2pvpartid)).length() == 0) {
            r2pvpartid = null;
        }
        this.r2pvpartid = r2pvpartid;
        this.r2pvpartidDirtyFlag = true;
    }

    public String getR2PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR2PVPartId();
        }
        return this.r2pvpartid;
    }

    public boolean isR2PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR2PVPartIdDirty();
        }
        return this.r2pvpartidDirtyFlag;
    }

    public void resetR2PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR2PVPartId();
            return;
        }
        this.r2pvpartidDirtyFlag = false;
        this.r2pvpartid = null;
    }

    public void setR2PVPartName(String r2pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR2PVPartName(r2pvpartname);
            return;
        }
        if (r2pvpartname != null && (r2pvpartname = StringHelper.trimRight(r2pvpartname)).length() == 0) {
            r2pvpartname = null;
        }
        this.r2pvpartname = r2pvpartname;
        this.r2pvpartnameDirtyFlag = true;
    }

    public String getR2PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR2PVPartName();
        }
        return this.r2pvpartname;
    }

    public boolean isR2PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR2PVPartNameDirty();
        }
        return this.r2pvpartnameDirtyFlag;
    }

    public void resetR2PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR2PVPartName();
            return;
        }
        this.r2pvpartnameDirtyFlag = false;
        this.r2pvpartname = null;
    }

    public void setR3PVPartCtrlId(String r3pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR3PVPartCtrlId(r3pvpartctrlid);
            return;
        }
        if (r3pvpartctrlid != null && (r3pvpartctrlid = StringHelper.trimRight(r3pvpartctrlid)).length() == 0) {
            r3pvpartctrlid = null;
        }
        this.r3pvpartctrlid = r3pvpartctrlid;
        this.r3pvpartctrlidDirtyFlag = true;
    }

    public String getR3PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR3PVPartCtrlId();
        }
        return this.r3pvpartctrlid;
    }

    public boolean isR3PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR3PVPartCtrlIdDirty();
        }
        return this.r3pvpartctrlidDirtyFlag;
    }

    public void resetR3PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR3PVPartCtrlId();
            return;
        }
        this.r3pvpartctrlidDirtyFlag = false;
        this.r3pvpartctrlid = null;
    }

    public void setR3PVPartId(String r3pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR3PVPartId(r3pvpartid);
            return;
        }
        if (r3pvpartid != null && (r3pvpartid = StringHelper.trimRight(r3pvpartid)).length() == 0) {
            r3pvpartid = null;
        }
        this.r3pvpartid = r3pvpartid;
        this.r3pvpartidDirtyFlag = true;
    }

    public String getR3PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR3PVPartId();
        }
        return this.r3pvpartid;
    }

    public boolean isR3PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR3PVPartIdDirty();
        }
        return this.r3pvpartidDirtyFlag;
    }

    public void resetR3PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR3PVPartId();
            return;
        }
        this.r3pvpartidDirtyFlag = false;
        this.r3pvpartid = null;
    }

    public void setR3PVPartName(String r3pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR3PVPartName(r3pvpartname);
            return;
        }
        if (r3pvpartname != null && (r3pvpartname = StringHelper.trimRight(r3pvpartname)).length() == 0) {
            r3pvpartname = null;
        }
        this.r3pvpartname = r3pvpartname;
        this.r3pvpartnameDirtyFlag = true;
    }

    public String getR3PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR3PVPartName();
        }
        return this.r3pvpartname;
    }

    public boolean isR3PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR3PVPartNameDirty();
        }
        return this.r3pvpartnameDirtyFlag;
    }

    public void resetR3PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR3PVPartName();
            return;
        }
        this.r3pvpartnameDirtyFlag = false;
        this.r3pvpartname = null;
    }

    public void setR4PVPartCtrlId(String r4pvpartctrlid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR4PVPartCtrlId(r4pvpartctrlid);
            return;
        }
        if (r4pvpartctrlid != null && (r4pvpartctrlid = StringHelper.trimRight(r4pvpartctrlid)).length() == 0) {
            r4pvpartctrlid = null;
        }
        this.r4pvpartctrlid = r4pvpartctrlid;
        this.r4pvpartctrlidDirtyFlag = true;
    }

    public String getR4PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR4PVPartCtrlId();
        }
        return this.r4pvpartctrlid;
    }

    public boolean isR4PVPartCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR4PVPartCtrlIdDirty();
        }
        return this.r4pvpartctrlidDirtyFlag;
    }

    public void resetR4PVPartCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR4PVPartCtrlId();
            return;
        }
        this.r4pvpartctrlidDirtyFlag = false;
        this.r4pvpartctrlid = null;
    }

    public void setR4PVPartId(String r4pvpartid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR4PVPartId(r4pvpartid);
            return;
        }
        if (r4pvpartid != null && (r4pvpartid = StringHelper.trimRight(r4pvpartid)).length() == 0) {
            r4pvpartid = null;
        }
        this.r4pvpartid = r4pvpartid;
        this.r4pvpartidDirtyFlag = true;
    }

    public String getR4PVPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR4PVPartId();
        }
        return this.r4pvpartid;
    }

    public boolean isR4PVPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR4PVPartIdDirty();
        }
        return this.r4pvpartidDirtyFlag;
    }

    public void resetR4PVPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR4PVPartId();
            return;
        }
        this.r4pvpartidDirtyFlag = false;
        this.r4pvpartid = null;
    }

    public void setR4PVPartName(String r4pvpartname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setR4PVPartName(r4pvpartname);
            return;
        }
        if (r4pvpartname != null && (r4pvpartname = StringHelper.trimRight(r4pvpartname)).length() == 0) {
            r4pvpartname = null;
        }
        this.r4pvpartname = r4pvpartname;
        this.r4pvpartnameDirtyFlag = true;
    }

    public String getR4PVPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR4PVPartName();
        }
        return this.r4pvpartname;
    }

    public boolean isR4PVPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isR4PVPartNameDirty();
        }
        return this.r4pvpartnameDirtyFlag;
    }

    public void resetR4PVPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetR4PVPartName();
            return;
        }
        this.r4pvpartnameDirtyFlag = false;
        this.r4pvpartname = null;
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
        PPModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PPModelBase et) {
        et.resetC1PVPartCtrlId();
        et.resetC1PVPartId();
        et.resetC1PVPartName();
        et.resetC2PVPartCtrlId();
        et.resetC2PVPartId();
        et.resetC2PVPartName();
        et.resetC3PVPartCtrlId();
        et.resetC3PVPartId();
        et.resetC3PVPartName();
        et.resetC4PVPartCtrlId();
        et.resetC4PVPartId();
        et.resetC4PVPartName();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetIsSystem();
        et.resetL1PVPartCtrlId();
        et.resetL1PVPartId();
        et.resetL1PVPartName();
        et.resetL2PVPartCtrlId();
        et.resetL2PVPartId();
        et.resetL2PVPartName();
        et.resetL3PVPartCtrlId();
        et.resetL3PVPartId();
        et.resetL3PVPartName();
        et.resetL4PVPartCtrlId();
        et.resetL4PVPartId();
        et.resetL4PVPartName();
        et.resetOwnerId();
        et.resetPortalPageId();
        et.resetPortalPageName();
        et.resetPPModel();
        et.resetPPModelDetail();
        et.resetPPModelId();
        et.resetPPModelName();
        et.resetPPMVersion();
        et.resetR1PVPartCtrlId();
        et.resetR1PVPartId();
        et.resetR1PVPartName();
        et.resetR2PVPartCtrlId();
        et.resetR2PVPartId();
        et.resetR2PVPartName();
        et.resetR3PVPartCtrlId();
        et.resetR3PVPartId();
        et.resetR3PVPartName();
        et.resetR4PVPartCtrlId();
        et.resetR4PVPartId();
        et.resetR4PVPartName();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isC1PVPartCtrlIdDirty()) {
            params.put(FIELD_C1PVPARTCTRLID, this.getC1PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isC1PVPartIdDirty()) {
            params.put(FIELD_C1PVPARTID, this.getC1PVPartId());
        }
        if (!bDirtyOnly || this.isC1PVPartNameDirty()) {
            params.put(FIELD_C1PVPARTNAME, this.getC1PVPartName());
        }
        if (!bDirtyOnly || this.isC2PVPartCtrlIdDirty()) {
            params.put(FIELD_C2PVPARTCTRLID, this.getC2PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isC2PVPartIdDirty()) {
            params.put(FIELD_C2PVPARTID, this.getC2PVPartId());
        }
        if (!bDirtyOnly || this.isC2PVPartNameDirty()) {
            params.put(FIELD_C2PVPARTNAME, this.getC2PVPartName());
        }
        if (!bDirtyOnly || this.isC3PVPartCtrlIdDirty()) {
            params.put(FIELD_C3PVPARTCTRLID, this.getC3PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isC3PVPartIdDirty()) {
            params.put(FIELD_C3PVPARTID, this.getC3PVPartId());
        }
        if (!bDirtyOnly || this.isC3PVPartNameDirty()) {
            params.put(FIELD_C3PVPARTNAME, this.getC3PVPartName());
        }
        if (!bDirtyOnly || this.isC4PVPartCtrlIdDirty()) {
            params.put(FIELD_C4PVPARTCTRLID, this.getC4PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isC4PVPartIdDirty()) {
            params.put(FIELD_C4PVPARTID, this.getC4PVPartId());
        }
        if (!bDirtyOnly || this.isC4PVPartNameDirty()) {
            params.put(FIELD_C4PVPARTNAME, this.getC4PVPartName());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isIsSystemDirty()) {
            params.put(FIELD_ISSYSTEM, this.getIsSystem());
        }
        if (!bDirtyOnly || this.isL1PVPartCtrlIdDirty()) {
            params.put(FIELD_L1PVPARTCTRLID, this.getL1PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isL1PVPartIdDirty()) {
            params.put(FIELD_L1PVPARTID, this.getL1PVPartId());
        }
        if (!bDirtyOnly || this.isL1PVPartNameDirty()) {
            params.put(FIELD_L1PVPARTNAME, this.getL1PVPartName());
        }
        if (!bDirtyOnly || this.isL2PVPartCtrlIdDirty()) {
            params.put(FIELD_L2PVPARTCTRLID, this.getL2PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isL2PVPartIdDirty()) {
            params.put(FIELD_L2PVPARTID, this.getL2PVPartId());
        }
        if (!bDirtyOnly || this.isL2PVPartNameDirty()) {
            params.put(FIELD_L2PVPARTNAME, this.getL2PVPartName());
        }
        if (!bDirtyOnly || this.isL3PVPartCtrlIdDirty()) {
            params.put(FIELD_L3PVPARTCTRLID, this.getL3PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isL3PVPartIdDirty()) {
            params.put(FIELD_L3PVPARTID, this.getL3PVPartId());
        }
        if (!bDirtyOnly || this.isL3PVPartNameDirty()) {
            params.put(FIELD_L3PVPARTNAME, this.getL3PVPartName());
        }
        if (!bDirtyOnly || this.isL4PVPartCtrlIdDirty()) {
            params.put(FIELD_L4PVPARTCTRLID, this.getL4PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isL4PVPartIdDirty()) {
            params.put(FIELD_L4PVPARTID, this.getL4PVPartId());
        }
        if (!bDirtyOnly || this.isL4PVPartNameDirty()) {
            params.put(FIELD_L4PVPARTNAME, this.getL4PVPartName());
        }
        if (!bDirtyOnly || this.isOwnerIdDirty()) {
            params.put(FIELD_OWNERID, this.getOwnerId());
        }
        if (!bDirtyOnly || this.isPortalPageIdDirty()) {
            params.put(FIELD_PORTALPAGEID, this.getPortalPageId());
        }
        if (!bDirtyOnly || this.isPortalPageNameDirty()) {
            params.put(FIELD_PORTALPAGENAME, this.getPortalPageName());
        }
        if (!bDirtyOnly || this.isPPModelDirty()) {
            params.put(FIELD_PPMODEL, this.getPPModel());
        }
        if (!bDirtyOnly || this.isPPModelDetailDirty()) {
            params.put(FIELD_PPMODELDETAIL, this.getPPModelDetail());
        }
        if (!bDirtyOnly || this.isPPModelIdDirty()) {
            params.put(FIELD_PPMODELID, this.getPPModelId());
        }
        if (!bDirtyOnly || this.isPPModelNameDirty()) {
            params.put(FIELD_PPMODELNAME, this.getPPModelName());
        }
        if (!bDirtyOnly || this.isPPMVersionDirty()) {
            params.put(FIELD_PPMVERSION, this.getPPMVersion());
        }
        if (!bDirtyOnly || this.isR1PVPartCtrlIdDirty()) {
            params.put(FIELD_R1PVPARTCTRLID, this.getR1PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isR1PVPartIdDirty()) {
            params.put(FIELD_R1PVPARTID, this.getR1PVPartId());
        }
        if (!bDirtyOnly || this.isR1PVPartNameDirty()) {
            params.put(FIELD_R1PVPARTNAME, this.getR1PVPartName());
        }
        if (!bDirtyOnly || this.isR2PVPartCtrlIdDirty()) {
            params.put(FIELD_R2PVPARTCTRLID, this.getR2PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isR2PVPartIdDirty()) {
            params.put(FIELD_R2PVPARTID, this.getR2PVPartId());
        }
        if (!bDirtyOnly || this.isR2PVPartNameDirty()) {
            params.put(FIELD_R2PVPARTNAME, this.getR2PVPartName());
        }
        if (!bDirtyOnly || this.isR3PVPartCtrlIdDirty()) {
            params.put(FIELD_R3PVPARTCTRLID, this.getR3PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isR3PVPartIdDirty()) {
            params.put(FIELD_R3PVPARTID, this.getR3PVPartId());
        }
        if (!bDirtyOnly || this.isR3PVPartNameDirty()) {
            params.put(FIELD_R3PVPARTNAME, this.getR3PVPartName());
        }
        if (!bDirtyOnly || this.isR4PVPartCtrlIdDirty()) {
            params.put(FIELD_R4PVPARTCTRLID, this.getR4PVPartCtrlId());
        }
        if (!bDirtyOnly || this.isR4PVPartIdDirty()) {
            params.put(FIELD_R4PVPARTID, this.getR4PVPartId());
        }
        if (!bDirtyOnly || this.isR4PVPartNameDirty()) {
            params.put(FIELD_R4PVPARTNAME, this.getR4PVPartName());
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
        return PPModelBase.get(this, index);
    }

    private static Object get(PPModelBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getC1PVPartCtrlId();
            }
            case 1: {
                return et.getC1PVPartId();
            }
            case 2: {
                return et.getC1PVPartName();
            }
            case 3: {
                return et.getC2PVPartCtrlId();
            }
            case 4: {
                return et.getC2PVPartId();
            }
            case 5: {
                return et.getC2PVPartName();
            }
            case 6: {
                return et.getC3PVPartCtrlId();
            }
            case 7: {
                return et.getC3PVPartId();
            }
            case 8: {
                return et.getC3PVPartName();
            }
            case 9: {
                return et.getC4PVPartCtrlId();
            }
            case 10: {
                return et.getC4PVPartId();
            }
            case 11: {
                return et.getC4PVPartName();
            }
            case 12: {
                return et.getCreateDate();
            }
            case 13: {
                return et.getCreateMan();
            }
            case 14: {
                return et.getIsSystem();
            }
            case 15: {
                return et.getL1PVPartCtrlId();
            }
            case 16: {
                return et.getL1PVPartId();
            }
            case 17: {
                return et.getL1PVPartName();
            }
            case 18: {
                return et.getL2PVPartCtrlId();
            }
            case 19: {
                return et.getL2PVPartId();
            }
            case 20: {
                return et.getL2PVPartName();
            }
            case 21: {
                return et.getL3PVPartCtrlId();
            }
            case 22: {
                return et.getL3PVPartId();
            }
            case 23: {
                return et.getL3PVPartName();
            }
            case 24: {
                return et.getL4PVPartCtrlId();
            }
            case 25: {
                return et.getL4PVPartId();
            }
            case 26: {
                return et.getL4PVPartName();
            }
            case 27: {
                return et.getOwnerId();
            }
            case 28: {
                return et.getPortalPageId();
            }
            case 29: {
                return et.getPortalPageName();
            }
            case 30: {
                return et.getPPModel();
            }
            case 31: {
                return et.getPPModelDetail();
            }
            case 32: {
                return et.getPPModelId();
            }
            case 33: {
                return et.getPPModelName();
            }
            case 34: {
                return et.getPPMVersion();
            }
            case 35: {
                return et.getR1PVPartCtrlId();
            }
            case 36: {
                return et.getR1PVPartId();
            }
            case 37: {
                return et.getR1PVPartName();
            }
            case 38: {
                return et.getR2PVPartCtrlId();
            }
            case 39: {
                return et.getR2PVPartId();
            }
            case 40: {
                return et.getR2PVPartName();
            }
            case 41: {
                return et.getR3PVPartCtrlId();
            }
            case 42: {
                return et.getR3PVPartId();
            }
            case 43: {
                return et.getR3PVPartName();
            }
            case 44: {
                return et.getR4PVPartCtrlId();
            }
            case 45: {
                return et.getR4PVPartId();
            }
            case 46: {
                return et.getR4PVPartName();
            }
            case 47: {
                return et.getUpdateDate();
            }
            case 48: {
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
        PPModelBase.set(this, index, objValue);
    }

    private static void set(PPModelBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setC1PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setC1PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setC1PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setC2PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setC2PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setC2PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setC3PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setC3PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setC3PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setC4PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setC4PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setC4PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 13: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setIsSystem(DataObject.getIntegerValue(obj));
                return;
            }
            case 15: {
                et.setL1PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setL1PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setL1PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setL2PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setL2PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setL2PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setL3PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setL3PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setL3PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 24: {
                et.setL4PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 25: {
                et.setL4PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 26: {
                et.setL4PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 27: {
                et.setOwnerId(DataObject.getStringValue(obj));
                return;
            }
            case 28: {
                et.setPortalPageId(DataObject.getStringValue(obj));
                return;
            }
            case 29: {
                et.setPortalPageName(DataObject.getStringValue(obj));
                return;
            }
            case 30: {
                et.setPPModel(DataObject.getStringValue(obj));
                return;
            }
            case 31: {
                et.setPPModelDetail(DataObject.getStringValue(obj));
                return;
            }
            case 32: {
                et.setPPModelId(DataObject.getStringValue(obj));
                return;
            }
            case 33: {
                et.setPPModelName(DataObject.getStringValue(obj));
                return;
            }
            case 34: {
                et.setPPMVersion(DataObject.getIntegerValue(obj));
                return;
            }
            case 35: {
                et.setR1PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 36: {
                et.setR1PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 37: {
                et.setR1PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 38: {
                et.setR2PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 39: {
                et.setR2PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 40: {
                et.setR2PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 41: {
                et.setR3PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 42: {
                et.setR3PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 43: {
                et.setR3PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 44: {
                et.setR4PVPartCtrlId(DataObject.getStringValue(obj));
                return;
            }
            case 45: {
                et.setR4PVPartId(DataObject.getStringValue(obj));
                return;
            }
            case 46: {
                et.setR4PVPartName(DataObject.getStringValue(obj));
                return;
            }
            case 47: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 48: {
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
        return PPModelBase.isNull(this, index);
    }

    private static boolean isNull(PPModelBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getC1PVPartCtrlId() == null;
            }
            case 1: {
                return et.getC1PVPartId() == null;
            }
            case 2: {
                return et.getC1PVPartName() == null;
            }
            case 3: {
                return et.getC2PVPartCtrlId() == null;
            }
            case 4: {
                return et.getC2PVPartId() == null;
            }
            case 5: {
                return et.getC2PVPartName() == null;
            }
            case 6: {
                return et.getC3PVPartCtrlId() == null;
            }
            case 7: {
                return et.getC3PVPartId() == null;
            }
            case 8: {
                return et.getC3PVPartName() == null;
            }
            case 9: {
                return et.getC4PVPartCtrlId() == null;
            }
            case 10: {
                return et.getC4PVPartId() == null;
            }
            case 11: {
                return et.getC4PVPartName() == null;
            }
            case 12: {
                return et.getCreateDate() == null;
            }
            case 13: {
                return et.getCreateMan() == null;
            }
            case 14: {
                return et.getIsSystem() == null;
            }
            case 15: {
                return et.getL1PVPartCtrlId() == null;
            }
            case 16: {
                return et.getL1PVPartId() == null;
            }
            case 17: {
                return et.getL1PVPartName() == null;
            }
            case 18: {
                return et.getL2PVPartCtrlId() == null;
            }
            case 19: {
                return et.getL2PVPartId() == null;
            }
            case 20: {
                return et.getL2PVPartName() == null;
            }
            case 21: {
                return et.getL3PVPartCtrlId() == null;
            }
            case 22: {
                return et.getL3PVPartId() == null;
            }
            case 23: {
                return et.getL3PVPartName() == null;
            }
            case 24: {
                return et.getL4PVPartCtrlId() == null;
            }
            case 25: {
                return et.getL4PVPartId() == null;
            }
            case 26: {
                return et.getL4PVPartName() == null;
            }
            case 27: {
                return et.getOwnerId() == null;
            }
            case 28: {
                return et.getPortalPageId() == null;
            }
            case 29: {
                return et.getPortalPageName() == null;
            }
            case 30: {
                return et.getPPModel() == null;
            }
            case 31: {
                return et.getPPModelDetail() == null;
            }
            case 32: {
                return et.getPPModelId() == null;
            }
            case 33: {
                return et.getPPModelName() == null;
            }
            case 34: {
                return et.getPPMVersion() == null;
            }
            case 35: {
                return et.getR1PVPartCtrlId() == null;
            }
            case 36: {
                return et.getR1PVPartId() == null;
            }
            case 37: {
                return et.getR1PVPartName() == null;
            }
            case 38: {
                return et.getR2PVPartCtrlId() == null;
            }
            case 39: {
                return et.getR2PVPartId() == null;
            }
            case 40: {
                return et.getR2PVPartName() == null;
            }
            case 41: {
                return et.getR3PVPartCtrlId() == null;
            }
            case 42: {
                return et.getR3PVPartId() == null;
            }
            case 43: {
                return et.getR3PVPartName() == null;
            }
            case 44: {
                return et.getR4PVPartCtrlId() == null;
            }
            case 45: {
                return et.getR4PVPartId() == null;
            }
            case 46: {
                return et.getR4PVPartName() == null;
            }
            case 47: {
                return et.getUpdateDate() == null;
            }
            case 48: {
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
        return PPModelBase.contains(this, index);
    }

    private static boolean contains(PPModelBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isC1PVPartCtrlIdDirty();
            }
            case 1: {
                return et.isC1PVPartIdDirty();
            }
            case 2: {
                return et.isC1PVPartNameDirty();
            }
            case 3: {
                return et.isC2PVPartCtrlIdDirty();
            }
            case 4: {
                return et.isC2PVPartIdDirty();
            }
            case 5: {
                return et.isC2PVPartNameDirty();
            }
            case 6: {
                return et.isC3PVPartCtrlIdDirty();
            }
            case 7: {
                return et.isC3PVPartIdDirty();
            }
            case 8: {
                return et.isC3PVPartNameDirty();
            }
            case 9: {
                return et.isC4PVPartCtrlIdDirty();
            }
            case 10: {
                return et.isC4PVPartIdDirty();
            }
            case 11: {
                return et.isC4PVPartNameDirty();
            }
            case 12: {
                return et.isCreateDateDirty();
            }
            case 13: {
                return et.isCreateManDirty();
            }
            case 14: {
                return et.isIsSystemDirty();
            }
            case 15: {
                return et.isL1PVPartCtrlIdDirty();
            }
            case 16: {
                return et.isL1PVPartIdDirty();
            }
            case 17: {
                return et.isL1PVPartNameDirty();
            }
            case 18: {
                return et.isL2PVPartCtrlIdDirty();
            }
            case 19: {
                return et.isL2PVPartIdDirty();
            }
            case 20: {
                return et.isL2PVPartNameDirty();
            }
            case 21: {
                return et.isL3PVPartCtrlIdDirty();
            }
            case 22: {
                return et.isL3PVPartIdDirty();
            }
            case 23: {
                return et.isL3PVPartNameDirty();
            }
            case 24: {
                return et.isL4PVPartCtrlIdDirty();
            }
            case 25: {
                return et.isL4PVPartIdDirty();
            }
            case 26: {
                return et.isL4PVPartNameDirty();
            }
            case 27: {
                return et.isOwnerIdDirty();
            }
            case 28: {
                return et.isPortalPageIdDirty();
            }
            case 29: {
                return et.isPortalPageNameDirty();
            }
            case 30: {
                return et.isPPModelDirty();
            }
            case 31: {
                return et.isPPModelDetailDirty();
            }
            case 32: {
                return et.isPPModelIdDirty();
            }
            case 33: {
                return et.isPPModelNameDirty();
            }
            case 34: {
                return et.isPPMVersionDirty();
            }
            case 35: {
                return et.isR1PVPartCtrlIdDirty();
            }
            case 36: {
                return et.isR1PVPartIdDirty();
            }
            case 37: {
                return et.isR1PVPartNameDirty();
            }
            case 38: {
                return et.isR2PVPartCtrlIdDirty();
            }
            case 39: {
                return et.isR2PVPartIdDirty();
            }
            case 40: {
                return et.isR2PVPartNameDirty();
            }
            case 41: {
                return et.isR3PVPartCtrlIdDirty();
            }
            case 42: {
                return et.isR3PVPartIdDirty();
            }
            case 43: {
                return et.isR3PVPartNameDirty();
            }
            case 44: {
                return et.isR4PVPartCtrlIdDirty();
            }
            case 45: {
                return et.isR4PVPartIdDirty();
            }
            case 46: {
                return et.isR4PVPartNameDirty();
            }
            case 47: {
                return et.isUpdateDateDirty();
            }
            case 48: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        PPModelBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(PPModelBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getC1PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "c1pvpartctrlid", PPModelBase.getJSONValue(et.getC1PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getC1PVPartId() != null) {
            JSONObjectHelper.put(json, "c1pvpartid", PPModelBase.getJSONValue(et.getC1PVPartId()), false);
        }
        if (bIncEmpty || et.getC1PVPartName() != null) {
            JSONObjectHelper.put(json, "c1pvpartname", PPModelBase.getJSONValue(et.getC1PVPartName()), false);
        }
        if (bIncEmpty || et.getC2PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "c2pvpartctrlid", PPModelBase.getJSONValue(et.getC2PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getC2PVPartId() != null) {
            JSONObjectHelper.put(json, "c2pvpartid", PPModelBase.getJSONValue(et.getC2PVPartId()), false);
        }
        if (bIncEmpty || et.getC2PVPartName() != null) {
            JSONObjectHelper.put(json, "c2pvpartname", PPModelBase.getJSONValue(et.getC2PVPartName()), false);
        }
        if (bIncEmpty || et.getC3PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "c3pvpartctrlid", PPModelBase.getJSONValue(et.getC3PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getC3PVPartId() != null) {
            JSONObjectHelper.put(json, "c3pvpartid", PPModelBase.getJSONValue(et.getC3PVPartId()), false);
        }
        if (bIncEmpty || et.getC3PVPartName() != null) {
            JSONObjectHelper.put(json, "c3pvpartname", PPModelBase.getJSONValue(et.getC3PVPartName()), false);
        }
        if (bIncEmpty || et.getC4PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "c4pvpartctrlid", PPModelBase.getJSONValue(et.getC4PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getC4PVPartId() != null) {
            JSONObjectHelper.put(json, "c4pvpartid", PPModelBase.getJSONValue(et.getC4PVPartId()), false);
        }
        if (bIncEmpty || et.getC4PVPartName() != null) {
            JSONObjectHelper.put(json, "c4pvpartname", PPModelBase.getJSONValue(et.getC4PVPartName()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", PPModelBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", PPModelBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            JSONObjectHelper.put(json, "issystem", PPModelBase.getJSONValue(et.getIsSystem()), false);
        }
        if (bIncEmpty || et.getL1PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "l1pvpartctrlid", PPModelBase.getJSONValue(et.getL1PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getL1PVPartId() != null) {
            JSONObjectHelper.put(json, "l1pvpartid", PPModelBase.getJSONValue(et.getL1PVPartId()), false);
        }
        if (bIncEmpty || et.getL1PVPartName() != null) {
            JSONObjectHelper.put(json, "l1pvpartname", PPModelBase.getJSONValue(et.getL1PVPartName()), false);
        }
        if (bIncEmpty || et.getL2PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "l2pvpartctrlid", PPModelBase.getJSONValue(et.getL2PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getL2PVPartId() != null) {
            JSONObjectHelper.put(json, "l2pvpartid", PPModelBase.getJSONValue(et.getL2PVPartId()), false);
        }
        if (bIncEmpty || et.getL2PVPartName() != null) {
            JSONObjectHelper.put(json, "l2pvpartname", PPModelBase.getJSONValue(et.getL2PVPartName()), false);
        }
        if (bIncEmpty || et.getL3PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "l3pvpartctrlid", PPModelBase.getJSONValue(et.getL3PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getL3PVPartId() != null) {
            JSONObjectHelper.put(json, "l3pvpartid", PPModelBase.getJSONValue(et.getL3PVPartId()), false);
        }
        if (bIncEmpty || et.getL3PVPartName() != null) {
            JSONObjectHelper.put(json, "l3pvpartname", PPModelBase.getJSONValue(et.getL3PVPartName()), false);
        }
        if (bIncEmpty || et.getL4PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "l4pvpartctrlid", PPModelBase.getJSONValue(et.getL4PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getL4PVPartId() != null) {
            JSONObjectHelper.put(json, "l4pvpartid", PPModelBase.getJSONValue(et.getL4PVPartId()), false);
        }
        if (bIncEmpty || et.getL4PVPartName() != null) {
            JSONObjectHelper.put(json, "l4pvpartname", PPModelBase.getJSONValue(et.getL4PVPartName()), false);
        }
        if (bIncEmpty || et.getOwnerId() != null) {
            JSONObjectHelper.put(json, "ownerid", PPModelBase.getJSONValue(et.getOwnerId()), false);
        }
        if (bIncEmpty || et.getPortalPageId() != null) {
            JSONObjectHelper.put(json, "portalpageid", PPModelBase.getJSONValue(et.getPortalPageId()), false);
        }
        if (bIncEmpty || et.getPortalPageName() != null) {
            JSONObjectHelper.put(json, "portalpagename", PPModelBase.getJSONValue(et.getPortalPageName()), false);
        }
        if (bIncEmpty || et.getPPModel() != null) {
            JSONObjectHelper.put(json, "ppmodel", PPModelBase.getJSONValue(et.getPPModel()), false);
        }
        if (bIncEmpty || et.getPPModelDetail() != null) {
            JSONObjectHelper.put(json, "ppmodeldetail", PPModelBase.getJSONValue(et.getPPModelDetail()), false);
        }
        if (bIncEmpty || et.getPPModelId() != null) {
            JSONObjectHelper.put(json, "ppmodelid", PPModelBase.getJSONValue(et.getPPModelId()), false);
        }
        if (bIncEmpty || et.getPPModelName() != null) {
            JSONObjectHelper.put(json, "ppmodelname", PPModelBase.getJSONValue(et.getPPModelName()), false);
        }
        if (bIncEmpty || et.getPPMVersion() != null) {
            JSONObjectHelper.put(json, "ppmversion", PPModelBase.getJSONValue(et.getPPMVersion()), false);
        }
        if (bIncEmpty || et.getR1PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "r1pvpartctrlid", PPModelBase.getJSONValue(et.getR1PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getR1PVPartId() != null) {
            JSONObjectHelper.put(json, "r1pvpartid", PPModelBase.getJSONValue(et.getR1PVPartId()), false);
        }
        if (bIncEmpty || et.getR1PVPartName() != null) {
            JSONObjectHelper.put(json, "r1pvpartname", PPModelBase.getJSONValue(et.getR1PVPartName()), false);
        }
        if (bIncEmpty || et.getR2PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "r2pvpartctrlid", PPModelBase.getJSONValue(et.getR2PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getR2PVPartId() != null) {
            JSONObjectHelper.put(json, "r2pvpartid", PPModelBase.getJSONValue(et.getR2PVPartId()), false);
        }
        if (bIncEmpty || et.getR2PVPartName() != null) {
            JSONObjectHelper.put(json, "r2pvpartname", PPModelBase.getJSONValue(et.getR2PVPartName()), false);
        }
        if (bIncEmpty || et.getR3PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "r3pvpartctrlid", PPModelBase.getJSONValue(et.getR3PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getR3PVPartId() != null) {
            JSONObjectHelper.put(json, "r3pvpartid", PPModelBase.getJSONValue(et.getR3PVPartId()), false);
        }
        if (bIncEmpty || et.getR3PVPartName() != null) {
            JSONObjectHelper.put(json, "r3pvpartname", PPModelBase.getJSONValue(et.getR3PVPartName()), false);
        }
        if (bIncEmpty || et.getR4PVPartCtrlId() != null) {
            JSONObjectHelper.put(json, "r4pvpartctrlid", PPModelBase.getJSONValue(et.getR4PVPartCtrlId()), false);
        }
        if (bIncEmpty || et.getR4PVPartId() != null) {
            JSONObjectHelper.put(json, "r4pvpartid", PPModelBase.getJSONValue(et.getR4PVPartId()), false);
        }
        if (bIncEmpty || et.getR4PVPartName() != null) {
            JSONObjectHelper.put(json, "r4pvpartname", PPModelBase.getJSONValue(et.getR4PVPartName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", PPModelBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", PPModelBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        PPModelBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(PPModelBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getC1PVPartCtrlId() != null) {
            obj = et.getC1PVPartCtrlId();
            node.setAttribute(FIELD_C1PVPARTCTRLID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC1PVPartId() != null) {
            obj = et.getC1PVPartId();
            node.setAttribute(FIELD_C1PVPARTID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC1PVPartName() != null) {
            obj = et.getC1PVPartName();
            node.setAttribute(FIELD_C1PVPARTNAME, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC2PVPartCtrlId() != null) {
            obj = et.getC2PVPartCtrlId();
            node.setAttribute(FIELD_C2PVPARTCTRLID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC2PVPartId() != null) {
            obj = et.getC2PVPartId();
            node.setAttribute(FIELD_C2PVPARTID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC2PVPartName() != null) {
            obj = et.getC2PVPartName();
            node.setAttribute(FIELD_C2PVPARTNAME, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC3PVPartCtrlId() != null) {
            obj = et.getC3PVPartCtrlId();
            node.setAttribute(FIELD_C3PVPARTCTRLID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC3PVPartId() != null) {
            obj = et.getC3PVPartId();
            node.setAttribute(FIELD_C3PVPARTID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC3PVPartName() != null) {
            obj = et.getC3PVPartName();
            node.setAttribute(FIELD_C3PVPARTNAME, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC4PVPartCtrlId() != null) {
            obj = et.getC4PVPartCtrlId();
            node.setAttribute(FIELD_C4PVPARTCTRLID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC4PVPartId() != null) {
            obj = et.getC4PVPartId();
            node.setAttribute(FIELD_C4PVPARTID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getC4PVPartName() != null) {
            obj = et.getC4PVPartName();
            node.setAttribute(FIELD_C4PVPARTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            obj = et.getIsSystem();
            node.setAttribute(FIELD_ISSYSTEM, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getL1PVPartCtrlId() != null) {
            obj = et.getL1PVPartCtrlId();
            node.setAttribute(FIELD_L1PVPARTCTRLID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL1PVPartId() != null) {
            obj = et.getL1PVPartId();
            node.setAttribute(FIELD_L1PVPARTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL1PVPartName() != null) {
            obj = et.getL1PVPartName();
            node.setAttribute(FIELD_L1PVPARTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL2PVPartCtrlId() != null) {
            obj = et.getL2PVPartCtrlId();
            node.setAttribute(FIELD_L2PVPARTCTRLID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL2PVPartId() != null) {
            obj = et.getL2PVPartId();
            node.setAttribute(FIELD_L2PVPARTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL2PVPartName() != null) {
            obj = et.getL2PVPartName();
            node.setAttribute(FIELD_L2PVPARTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL3PVPartCtrlId() != null) {
            obj = et.getL3PVPartCtrlId();
            node.setAttribute(FIELD_L3PVPARTCTRLID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL3PVPartId() != null) {
            obj = et.getL3PVPartId();
            node.setAttribute(FIELD_L3PVPARTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL3PVPartName() != null) {
            obj = et.getL3PVPartName();
            node.setAttribute(FIELD_L3PVPARTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL4PVPartCtrlId() != null) {
            obj = et.getL4PVPartCtrlId();
            node.setAttribute(FIELD_L4PVPARTCTRLID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL4PVPartId() != null) {
            obj = et.getL4PVPartId();
            node.setAttribute(FIELD_L4PVPARTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getL4PVPartName() != null) {
            obj = et.getL4PVPartName();
            node.setAttribute(FIELD_L4PVPARTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOwnerId() != null) {
            obj = et.getOwnerId();
            node.setAttribute(FIELD_OWNERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPortalPageId() != null) {
            obj = et.getPortalPageId();
            node.setAttribute(FIELD_PORTALPAGEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPortalPageName() != null) {
            obj = et.getPortalPageName();
            node.setAttribute(FIELD_PORTALPAGENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPPModel() != null) {
            obj = et.getPPModel();
            node.setAttribute(FIELD_PPMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPPModelDetail() != null) {
            obj = et.getPPModelDetail();
            node.setAttribute(FIELD_PPMODELDETAIL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPPModelId() != null) {
            obj = et.getPPModelId();
            node.setAttribute(FIELD_PPMODELID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPPModelName() != null) {
            obj = et.getPPModelName();
            node.setAttribute(FIELD_PPMODELNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPPMVersion() != null) {
            obj = et.getPPMVersion();
            node.setAttribute(FIELD_PPMVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getR1PVPartCtrlId() != null) {
            obj = et.getR1PVPartCtrlId();
            node.setAttribute(FIELD_R1PVPARTCTRLID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR1PVPartId() != null) {
            obj = et.getR1PVPartId();
            node.setAttribute(FIELD_R1PVPARTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR1PVPartName() != null) {
            obj = et.getR1PVPartName();
            node.setAttribute(FIELD_R1PVPARTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR2PVPartCtrlId() != null) {
            obj = et.getR2PVPartCtrlId();
            node.setAttribute(FIELD_R2PVPARTCTRLID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR2PVPartId() != null) {
            obj = et.getR2PVPartId();
            node.setAttribute(FIELD_R2PVPARTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR2PVPartName() != null) {
            obj = et.getR2PVPartName();
            node.setAttribute(FIELD_R2PVPARTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR3PVPartCtrlId() != null) {
            obj = et.getR3PVPartCtrlId();
            node.setAttribute(FIELD_R3PVPARTCTRLID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR3PVPartId() != null) {
            obj = et.getR3PVPartId();
            node.setAttribute(FIELD_R3PVPARTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR3PVPartName() != null) {
            obj = et.getR3PVPartName();
            node.setAttribute(FIELD_R3PVPARTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR4PVPartCtrlId() != null) {
            obj = et.getR4PVPartCtrlId();
            node.setAttribute(FIELD_R4PVPARTCTRLID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR4PVPartId() != null) {
            obj = et.getR4PVPartId();
            node.setAttribute(FIELD_R4PVPARTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getR4PVPartName() != null) {
            obj = et.getR4PVPartName();
            node.setAttribute(FIELD_R4PVPARTNAME, obj == null ? "" : (String)obj);
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
        PPModelBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(PPModelBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isC1PVPartCtrlIdDirty() && (bIncEmpty || et.getC1PVPartCtrlId() != null)) {
            dst.set(FIELD_C1PVPARTCTRLID, et.getC1PVPartCtrlId());
        }
        if (et.isC1PVPartIdDirty() && (bIncEmpty || et.getC1PVPartId() != null)) {
            dst.set(FIELD_C1PVPARTID, et.getC1PVPartId());
        }
        if (et.isC1PVPartNameDirty() && (bIncEmpty || et.getC1PVPartName() != null)) {
            dst.set(FIELD_C1PVPARTNAME, et.getC1PVPartName());
        }
        if (et.isC2PVPartCtrlIdDirty() && (bIncEmpty || et.getC2PVPartCtrlId() != null)) {
            dst.set(FIELD_C2PVPARTCTRLID, et.getC2PVPartCtrlId());
        }
        if (et.isC2PVPartIdDirty() && (bIncEmpty || et.getC2PVPartId() != null)) {
            dst.set(FIELD_C2PVPARTID, et.getC2PVPartId());
        }
        if (et.isC2PVPartNameDirty() && (bIncEmpty || et.getC2PVPartName() != null)) {
            dst.set(FIELD_C2PVPARTNAME, et.getC2PVPartName());
        }
        if (et.isC3PVPartCtrlIdDirty() && (bIncEmpty || et.getC3PVPartCtrlId() != null)) {
            dst.set(FIELD_C3PVPARTCTRLID, et.getC3PVPartCtrlId());
        }
        if (et.isC3PVPartIdDirty() && (bIncEmpty || et.getC3PVPartId() != null)) {
            dst.set(FIELD_C3PVPARTID, et.getC3PVPartId());
        }
        if (et.isC3PVPartNameDirty() && (bIncEmpty || et.getC3PVPartName() != null)) {
            dst.set(FIELD_C3PVPARTNAME, et.getC3PVPartName());
        }
        if (et.isC4PVPartCtrlIdDirty() && (bIncEmpty || et.getC4PVPartCtrlId() != null)) {
            dst.set(FIELD_C4PVPARTCTRLID, et.getC4PVPartCtrlId());
        }
        if (et.isC4PVPartIdDirty() && (bIncEmpty || et.getC4PVPartId() != null)) {
            dst.set(FIELD_C4PVPARTID, et.getC4PVPartId());
        }
        if (et.isC4PVPartNameDirty() && (bIncEmpty || et.getC4PVPartName() != null)) {
            dst.set(FIELD_C4PVPARTNAME, et.getC4PVPartName());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isIsSystemDirty() && (bIncEmpty || et.getIsSystem() != null)) {
            dst.set(FIELD_ISSYSTEM, et.getIsSystem());
        }
        if (et.isL1PVPartCtrlIdDirty() && (bIncEmpty || et.getL1PVPartCtrlId() != null)) {
            dst.set(FIELD_L1PVPARTCTRLID, et.getL1PVPartCtrlId());
        }
        if (et.isL1PVPartIdDirty() && (bIncEmpty || et.getL1PVPartId() != null)) {
            dst.set(FIELD_L1PVPARTID, et.getL1PVPartId());
        }
        if (et.isL1PVPartNameDirty() && (bIncEmpty || et.getL1PVPartName() != null)) {
            dst.set(FIELD_L1PVPARTNAME, et.getL1PVPartName());
        }
        if (et.isL2PVPartCtrlIdDirty() && (bIncEmpty || et.getL2PVPartCtrlId() != null)) {
            dst.set(FIELD_L2PVPARTCTRLID, et.getL2PVPartCtrlId());
        }
        if (et.isL2PVPartIdDirty() && (bIncEmpty || et.getL2PVPartId() != null)) {
            dst.set(FIELD_L2PVPARTID, et.getL2PVPartId());
        }
        if (et.isL2PVPartNameDirty() && (bIncEmpty || et.getL2PVPartName() != null)) {
            dst.set(FIELD_L2PVPARTNAME, et.getL2PVPartName());
        }
        if (et.isL3PVPartCtrlIdDirty() && (bIncEmpty || et.getL3PVPartCtrlId() != null)) {
            dst.set(FIELD_L3PVPARTCTRLID, et.getL3PVPartCtrlId());
        }
        if (et.isL3PVPartIdDirty() && (bIncEmpty || et.getL3PVPartId() != null)) {
            dst.set(FIELD_L3PVPARTID, et.getL3PVPartId());
        }
        if (et.isL3PVPartNameDirty() && (bIncEmpty || et.getL3PVPartName() != null)) {
            dst.set(FIELD_L3PVPARTNAME, et.getL3PVPartName());
        }
        if (et.isL4PVPartCtrlIdDirty() && (bIncEmpty || et.getL4PVPartCtrlId() != null)) {
            dst.set(FIELD_L4PVPARTCTRLID, et.getL4PVPartCtrlId());
        }
        if (et.isL4PVPartIdDirty() && (bIncEmpty || et.getL4PVPartId() != null)) {
            dst.set(FIELD_L4PVPARTID, et.getL4PVPartId());
        }
        if (et.isL4PVPartNameDirty() && (bIncEmpty || et.getL4PVPartName() != null)) {
            dst.set(FIELD_L4PVPARTNAME, et.getL4PVPartName());
        }
        if (et.isOwnerIdDirty() && (bIncEmpty || et.getOwnerId() != null)) {
            dst.set(FIELD_OWNERID, et.getOwnerId());
        }
        if (et.isPortalPageIdDirty() && (bIncEmpty || et.getPortalPageId() != null)) {
            dst.set(FIELD_PORTALPAGEID, et.getPortalPageId());
        }
        if (et.isPortalPageNameDirty() && (bIncEmpty || et.getPortalPageName() != null)) {
            dst.set(FIELD_PORTALPAGENAME, et.getPortalPageName());
        }
        if (et.isPPModelDirty() && (bIncEmpty || et.getPPModel() != null)) {
            dst.set(FIELD_PPMODEL, et.getPPModel());
        }
        if (et.isPPModelDetailDirty() && (bIncEmpty || et.getPPModelDetail() != null)) {
            dst.set(FIELD_PPMODELDETAIL, et.getPPModelDetail());
        }
        if (et.isPPModelIdDirty() && (bIncEmpty || et.getPPModelId() != null)) {
            dst.set(FIELD_PPMODELID, et.getPPModelId());
        }
        if (et.isPPModelNameDirty() && (bIncEmpty || et.getPPModelName() != null)) {
            dst.set(FIELD_PPMODELNAME, et.getPPModelName());
        }
        if (et.isPPMVersionDirty() && (bIncEmpty || et.getPPMVersion() != null)) {
            dst.set(FIELD_PPMVERSION, et.getPPMVersion());
        }
        if (et.isR1PVPartCtrlIdDirty() && (bIncEmpty || et.getR1PVPartCtrlId() != null)) {
            dst.set(FIELD_R1PVPARTCTRLID, et.getR1PVPartCtrlId());
        }
        if (et.isR1PVPartIdDirty() && (bIncEmpty || et.getR1PVPartId() != null)) {
            dst.set(FIELD_R1PVPARTID, et.getR1PVPartId());
        }
        if (et.isR1PVPartNameDirty() && (bIncEmpty || et.getR1PVPartName() != null)) {
            dst.set(FIELD_R1PVPARTNAME, et.getR1PVPartName());
        }
        if (et.isR2PVPartCtrlIdDirty() && (bIncEmpty || et.getR2PVPartCtrlId() != null)) {
            dst.set(FIELD_R2PVPARTCTRLID, et.getR2PVPartCtrlId());
        }
        if (et.isR2PVPartIdDirty() && (bIncEmpty || et.getR2PVPartId() != null)) {
            dst.set(FIELD_R2PVPARTID, et.getR2PVPartId());
        }
        if (et.isR2PVPartNameDirty() && (bIncEmpty || et.getR2PVPartName() != null)) {
            dst.set(FIELD_R2PVPARTNAME, et.getR2PVPartName());
        }
        if (et.isR3PVPartCtrlIdDirty() && (bIncEmpty || et.getR3PVPartCtrlId() != null)) {
            dst.set(FIELD_R3PVPARTCTRLID, et.getR3PVPartCtrlId());
        }
        if (et.isR3PVPartIdDirty() && (bIncEmpty || et.getR3PVPartId() != null)) {
            dst.set(FIELD_R3PVPARTID, et.getR3PVPartId());
        }
        if (et.isR3PVPartNameDirty() && (bIncEmpty || et.getR3PVPartName() != null)) {
            dst.set(FIELD_R3PVPARTNAME, et.getR3PVPartName());
        }
        if (et.isR4PVPartCtrlIdDirty() && (bIncEmpty || et.getR4PVPartCtrlId() != null)) {
            dst.set(FIELD_R4PVPARTCTRLID, et.getR4PVPartCtrlId());
        }
        if (et.isR4PVPartIdDirty() && (bIncEmpty || et.getR4PVPartId() != null)) {
            dst.set(FIELD_R4PVPARTID, et.getR4PVPartId());
        }
        if (et.isR4PVPartNameDirty() && (bIncEmpty || et.getR4PVPartName() != null)) {
            dst.set(FIELD_R4PVPARTNAME, et.getR4PVPartName());
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
        return PPModelBase.remove(this, index);
    }

    private static boolean remove(PPModelBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetC1PVPartCtrlId();
                return true;
            }
            case 1: {
                et.resetC1PVPartId();
                return true;
            }
            case 2: {
                et.resetC1PVPartName();
                return true;
            }
            case 3: {
                et.resetC2PVPartCtrlId();
                return true;
            }
            case 4: {
                et.resetC2PVPartId();
                return true;
            }
            case 5: {
                et.resetC2PVPartName();
                return true;
            }
            case 6: {
                et.resetC3PVPartCtrlId();
                return true;
            }
            case 7: {
                et.resetC3PVPartId();
                return true;
            }
            case 8: {
                et.resetC3PVPartName();
                return true;
            }
            case 9: {
                et.resetC4PVPartCtrlId();
                return true;
            }
            case 10: {
                et.resetC4PVPartId();
                return true;
            }
            case 11: {
                et.resetC4PVPartName();
                return true;
            }
            case 12: {
                et.resetCreateDate();
                return true;
            }
            case 13: {
                et.resetCreateMan();
                return true;
            }
            case 14: {
                et.resetIsSystem();
                return true;
            }
            case 15: {
                et.resetL1PVPartCtrlId();
                return true;
            }
            case 16: {
                et.resetL1PVPartId();
                return true;
            }
            case 17: {
                et.resetL1PVPartName();
                return true;
            }
            case 18: {
                et.resetL2PVPartCtrlId();
                return true;
            }
            case 19: {
                et.resetL2PVPartId();
                return true;
            }
            case 20: {
                et.resetL2PVPartName();
                return true;
            }
            case 21: {
                et.resetL3PVPartCtrlId();
                return true;
            }
            case 22: {
                et.resetL3PVPartId();
                return true;
            }
            case 23: {
                et.resetL3PVPartName();
                return true;
            }
            case 24: {
                et.resetL4PVPartCtrlId();
                return true;
            }
            case 25: {
                et.resetL4PVPartId();
                return true;
            }
            case 26: {
                et.resetL4PVPartName();
                return true;
            }
            case 27: {
                et.resetOwnerId();
                return true;
            }
            case 28: {
                et.resetPortalPageId();
                return true;
            }
            case 29: {
                et.resetPortalPageName();
                return true;
            }
            case 30: {
                et.resetPPModel();
                return true;
            }
            case 31: {
                et.resetPPModelDetail();
                return true;
            }
            case 32: {
                et.resetPPModelId();
                return true;
            }
            case 33: {
                et.resetPPModelName();
                return true;
            }
            case 34: {
                et.resetPPMVersion();
                return true;
            }
            case 35: {
                et.resetR1PVPartCtrlId();
                return true;
            }
            case 36: {
                et.resetR1PVPartId();
                return true;
            }
            case 37: {
                et.resetR1PVPartName();
                return true;
            }
            case 38: {
                et.resetR2PVPartCtrlId();
                return true;
            }
            case 39: {
                et.resetR2PVPartId();
                return true;
            }
            case 40: {
                et.resetR2PVPartName();
                return true;
            }
            case 41: {
                et.resetR3PVPartCtrlId();
                return true;
            }
            case 42: {
                et.resetR3PVPartId();
                return true;
            }
            case 43: {
                et.resetR3PVPartName();
                return true;
            }
            case 44: {
                et.resetR4PVPartCtrlId();
                return true;
            }
            case 45: {
                et.resetR4PVPartId();
                return true;
            }
            case 46: {
                et.resetR4PVPartName();
                return true;
            }
            case 47: {
                et.resetUpdateDate();
                return true;
            }
            case 48: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PortalPage getPortalPage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortalPage();
        }
        if (this.getPortalPageId() == null) {
            return null;
        }
        Integer n = this.objPortalPageLock;
        synchronized (n) {
            if (this.portalpage != null && DataTypeHelper.compare(25, (Object)this.getPortalPageId(), (Object)this.portalpage.getPortalPageId()) != 0L) {
                this.portalpage = null;
            }
            if (this.portalpage == null) {
                PortalPage portalpage = new PortalPage();
                portalpage.setPortalPageId(this.getPortalPageId());
                PortalPageService service = (PortalPageService)ServiceGlobal.getService(PortalPageService.class, this.getSessionFactory());
                service.autoGet(portalpage);
                this.portalpage = portalpage;
            }
            return this.portalpage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getC1PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC1PVPart();
        }
        if (this.getC1PVPartId() == null) {
            return null;
        }
        Integer n = this.objC1PVPartLock;
        synchronized (n) {
            if (this.c1pvpart != null && DataTypeHelper.compare(25, (Object)this.getC1PVPartId(), (Object)this.c1pvpart.getPVPartId()) != 0L) {
                this.c1pvpart = null;
            }
            if (this.c1pvpart == null) {
                PVPart c1pvpart = new PVPart();
                c1pvpart.setPVPartId(this.getC1PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(c1pvpart);
                this.c1pvpart = c1pvpart;
            }
            return this.c1pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getC2PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC2PVPart();
        }
        if (this.getC2PVPartId() == null) {
            return null;
        }
        Integer n = this.objC2PVPartLock;
        synchronized (n) {
            if (this.c2pvpart != null && DataTypeHelper.compare(25, (Object)this.getC2PVPartId(), (Object)this.c2pvpart.getPVPartId()) != 0L) {
                this.c2pvpart = null;
            }
            if (this.c2pvpart == null) {
                PVPart c2pvpart = new PVPart();
                c2pvpart.setPVPartId(this.getC2PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(c2pvpart);
                this.c2pvpart = c2pvpart;
            }
            return this.c2pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getC3PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC3PVPart();
        }
        if (this.getC3PVPartId() == null) {
            return null;
        }
        Integer n = this.objC3PVPartLock;
        synchronized (n) {
            if (this.c3pvpart != null && DataTypeHelper.compare(25, (Object)this.getC3PVPartId(), (Object)this.c3pvpart.getPVPartId()) != 0L) {
                this.c3pvpart = null;
            }
            if (this.c3pvpart == null) {
                PVPart c3pvpart = new PVPart();
                c3pvpart.setPVPartId(this.getC3PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(c3pvpart);
                this.c3pvpart = c3pvpart;
            }
            return this.c3pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getC4PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getC4PVPart();
        }
        if (this.getC4PVPartId() == null) {
            return null;
        }
        Integer n = this.objC4PVPartLock;
        synchronized (n) {
            if (this.c4pvpart != null && DataTypeHelper.compare(25, (Object)this.getC4PVPartId(), (Object)this.c4pvpart.getPVPartId()) != 0L) {
                this.c4pvpart = null;
            }
            if (this.c4pvpart == null) {
                PVPart c4pvpart = new PVPart();
                c4pvpart.setPVPartId(this.getC4PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(c4pvpart);
                this.c4pvpart = c4pvpart;
            }
            return this.c4pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getL1PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL1PVPart();
        }
        if (this.getL1PVPartId() == null) {
            return null;
        }
        Integer n = this.objL1PVPartLock;
        synchronized (n) {
            if (this.l1pvpart != null && DataTypeHelper.compare(25, (Object)this.getL1PVPartId(), (Object)this.l1pvpart.getPVPartId()) != 0L) {
                this.l1pvpart = null;
            }
            if (this.l1pvpart == null) {
                PVPart l1pvpart = new PVPart();
                l1pvpart.setPVPartId(this.getL1PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(l1pvpart);
                this.l1pvpart = l1pvpart;
            }
            return this.l1pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getL2PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL2PVPart();
        }
        if (this.getL2PVPartId() == null) {
            return null;
        }
        Integer n = this.objL2PVPartLock;
        synchronized (n) {
            if (this.l2pvpart != null && DataTypeHelper.compare(25, (Object)this.getL2PVPartId(), (Object)this.l2pvpart.getPVPartId()) != 0L) {
                this.l2pvpart = null;
            }
            if (this.l2pvpart == null) {
                PVPart l2pvpart = new PVPart();
                l2pvpart.setPVPartId(this.getL2PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(l2pvpart);
                this.l2pvpart = l2pvpart;
            }
            return this.l2pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getL3PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL3PVPart();
        }
        if (this.getL3PVPartId() == null) {
            return null;
        }
        Integer n = this.objL3PVPartLock;
        synchronized (n) {
            if (this.l3pvpart != null && DataTypeHelper.compare(25, (Object)this.getL3PVPartId(), (Object)this.l3pvpart.getPVPartId()) != 0L) {
                this.l3pvpart = null;
            }
            if (this.l3pvpart == null) {
                PVPart l3pvpart = new PVPart();
                l3pvpart.setPVPartId(this.getL3PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(l3pvpart);
                this.l3pvpart = l3pvpart;
            }
            return this.l3pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getL4PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getL4PVPart();
        }
        if (this.getL4PVPartId() == null) {
            return null;
        }
        Integer n = this.objL4PVPartLock;
        synchronized (n) {
            if (this.l4pvpart != null && DataTypeHelper.compare(25, (Object)this.getL4PVPartId(), (Object)this.l4pvpart.getPVPartId()) != 0L) {
                this.l4pvpart = null;
            }
            if (this.l4pvpart == null) {
                PVPart l4pvpart = new PVPart();
                l4pvpart.setPVPartId(this.getL4PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(l4pvpart);
                this.l4pvpart = l4pvpart;
            }
            return this.l4pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getR1PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR1PVPart();
        }
        if (this.getR1PVPartId() == null) {
            return null;
        }
        Integer n = this.objR1PVPartLock;
        synchronized (n) {
            if (this.r1pvpart != null && DataTypeHelper.compare(25, (Object)this.getR1PVPartId(), (Object)this.r1pvpart.getPVPartId()) != 0L) {
                this.r1pvpart = null;
            }
            if (this.r1pvpart == null) {
                PVPart r1pvpart = new PVPart();
                r1pvpart.setPVPartId(this.getR1PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(r1pvpart);
                this.r1pvpart = r1pvpart;
            }
            return this.r1pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getR2PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR2PVPart();
        }
        if (this.getR2PVPartId() == null) {
            return null;
        }
        Integer n = this.objR2PVPartLock;
        synchronized (n) {
            if (this.r2pvpart != null && DataTypeHelper.compare(25, (Object)this.getR2PVPartId(), (Object)this.r2pvpart.getPVPartId()) != 0L) {
                this.r2pvpart = null;
            }
            if (this.r2pvpart == null) {
                PVPart r2pvpart = new PVPart();
                r2pvpart.setPVPartId(this.getR2PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(r2pvpart);
                this.r2pvpart = r2pvpart;
            }
            return this.r2pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getR3PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR3PVPart();
        }
        if (this.getR3PVPartId() == null) {
            return null;
        }
        Integer n = this.objR3PVPartLock;
        synchronized (n) {
            if (this.r3pvpart != null && DataTypeHelper.compare(25, (Object)this.getR3PVPartId(), (Object)this.r3pvpart.getPVPartId()) != 0L) {
                this.r3pvpart = null;
            }
            if (this.r3pvpart == null) {
                PVPart r3pvpart = new PVPart();
                r3pvpart.setPVPartId(this.getR3PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(r3pvpart);
                this.r3pvpart = r3pvpart;
            }
            return this.r3pvpart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PVPart getR4PVPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getR4PVPart();
        }
        if (this.getR4PVPartId() == null) {
            return null;
        }
        Integer n = this.objR4PVPartLock;
        synchronized (n) {
            if (this.r4pvpart != null && DataTypeHelper.compare(25, (Object)this.getR4PVPartId(), (Object)this.r4pvpart.getPVPartId()) != 0L) {
                this.r4pvpart = null;
            }
            if (this.r4pvpart == null) {
                PVPart r4pvpart = new PVPart();
                r4pvpart.setPVPartId(this.getR4PVPartId());
                PVPartService service = (PVPartService)ServiceGlobal.getService(PVPartService.class, this.getSessionFactory());
                service.autoGet(r4pvpart);
                this.r4pvpart = r4pvpart;
            }
            return this.r4pvpart;
        }
    }

    private PPModelBase getProxyEntity() {
        return this.proxyPPModelBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPPModelBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof PPModelBase) {
            this.proxyPPModelBase = (PPModelBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PPModelService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

