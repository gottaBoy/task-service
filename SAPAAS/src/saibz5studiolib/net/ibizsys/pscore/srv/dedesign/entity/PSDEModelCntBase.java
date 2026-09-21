/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.entity;

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
import org.hibernate.SessionFactory;

public abstract class PSDEModelCntBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEModelCntBase.class);
    public static final String FIELD_CLCNT = "CLCNT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEACCNT = "DEACCNT";
    public static final String FIELD_DEACTIONCNT = "DEACTIONCNT";
    public static final String FIELD_DECALENDARCNT = "DECALENDARCNT";
    public static final String FIELD_DECHARTCNT = "DECHARTCNT";
    public static final String FIELD_DEDASHBOARDCNT = "DEDASHBOARDCNT";
    public static final String FIELD_DEDATAVIEWCNT = "DEDATAVIEWCNT";
    public static final String FIELD_DEDQCNT = "DEDQCNT";
    public static final String FIELD_DEDRCNT = "DEDRCNT";
    public static final String FIELD_DEDRGRPCNT = "DEDRGRPCNT";
    public static final String FIELD_DEDRITEMCNT = "DEDRITEMCNT";
    public static final String FIELD_DEDSCNT = "DEDSCNT";
    public static final String FIELD_DEFIELDCNT = "DEFIELDCNT";
    public static final String FIELD_DEFORMCNT = "DEFORMCNT";
    public static final String FIELD_DEGRIDCNT = "DEGRIDCNT";
    public static final String FIELD_DELISTCNT = "DELISTCNT";
    public static final String FIELD_DELOGICCNT = "DELOGICCNT";
    public static final String FIELD_DEMAPVIEWCNT = "DEMAPVIEWCNT";
    public static final String FIELD_DEMSCNT = "DEMSCNT";
    public static final String FIELD_DEOPPRIVCNT = "DEOPPRIVCNT";
    public static final String FIELD_DEPANELCNT = "DEPANELCNT";
    public static final String FIELD_DEPORTLETCNT = "DEPORTLETCNT";
    public static final String FIELD_DERCNT = "DERCNT";
    public static final String FIELD_DERCNT2 = "DERCNT2";
    public static final String FIELD_DEREPORTCNT = "DEREPORTCNT";
    public static final String FIELD_DESEARCHBARCNT = "DESEARCHBARCNT";
    public static final String FIELD_DETOOLBARCNT = "DETOOLBARCNT";
    public static final String FIELD_DETREECNT = "DETREECNT";
    public static final String FIELD_DEUACNT = "DEUACNT";
    public static final String FIELD_DEUAGRPCNT = "DEUAGRPCNT";
    public static final String FIELD_DEWFCNT = "DEWFCNT";
    public static final String FIELD_INDEXCNT = "INDEXCNT";
    public static final String FIELD_PSDEMODELCNTID = "PSDEMODELCNTID";
    public static final String FIELD_PSDEMODELCNTNAME = "PSDEMODELCNTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CLCNT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEACCNT = 3;
    private static final int INDEX_DEACTIONCNT = 4;
    private static final int INDEX_DECALENDARCNT = 5;
    private static final int INDEX_DECHARTCNT = 6;
    private static final int INDEX_DEDASHBOARDCNT = 7;
    private static final int INDEX_DEDATAVIEWCNT = 8;
    private static final int INDEX_DEDQCNT = 9;
    private static final int INDEX_DEDRCNT = 10;
    private static final int INDEX_DEDRGRPCNT = 11;
    private static final int INDEX_DEDRITEMCNT = 12;
    private static final int INDEX_DEDSCNT = 13;
    private static final int INDEX_DEFIELDCNT = 14;
    private static final int INDEX_DEFORMCNT = 15;
    private static final int INDEX_DEGRIDCNT = 16;
    private static final int INDEX_DELISTCNT = 17;
    private static final int INDEX_DELOGICCNT = 18;
    private static final int INDEX_DEMAPVIEWCNT = 19;
    private static final int INDEX_DEMSCNT = 20;
    private static final int INDEX_DEOPPRIVCNT = 21;
    private static final int INDEX_DEPANELCNT = 22;
    private static final int INDEX_DEPORTLETCNT = 23;
    private static final int INDEX_DERCNT = 24;
    private static final int INDEX_DERCNT2 = 25;
    private static final int INDEX_DEREPORTCNT = 26;
    private static final int INDEX_DESEARCHBARCNT = 27;
    private static final int INDEX_DETOOLBARCNT = 28;
    private static final int INDEX_DETREECNT = 29;
    private static final int INDEX_DEUACNT = 30;
    private static final int INDEX_DEUAGRPCNT = 31;
    private static final int INDEX_DEWFCNT = 32;
    private static final int INDEX_INDEXCNT = 33;
    private static final int INDEX_PSDEMODELCNTID = 34;
    private static final int INDEX_PSDEMODELCNTNAME = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEModelCntBase proxyPSDEModelCntBase = null;
    private boolean clcntDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deaccntDirtyFlag = false;
    private boolean deactioncntDirtyFlag = false;
    private boolean decalendarcntDirtyFlag = false;
    private boolean dechartcntDirtyFlag = false;
    private boolean dedashboardcntDirtyFlag = false;
    private boolean dedataviewcntDirtyFlag = false;
    private boolean dedqcntDirtyFlag = false;
    private boolean dedrcntDirtyFlag = false;
    private boolean dedrgrpcntDirtyFlag = false;
    private boolean dedritemcntDirtyFlag = false;
    private boolean dedscntDirtyFlag = false;
    private boolean defieldcntDirtyFlag = false;
    private boolean deformcntDirtyFlag = false;
    private boolean degridcntDirtyFlag = false;
    private boolean delistcntDirtyFlag = false;
    private boolean delogiccntDirtyFlag = false;
    private boolean demapviewcntDirtyFlag = false;
    private boolean demscntDirtyFlag = false;
    private boolean deopprivcntDirtyFlag = false;
    private boolean depanelcntDirtyFlag = false;
    private boolean deportletcntDirtyFlag = false;
    private boolean dercntDirtyFlag = false;
    private boolean dercnt2DirtyFlag = false;
    private boolean dereportcntDirtyFlag = false;
    private boolean desearchbarcntDirtyFlag = false;
    private boolean detoolbarcntDirtyFlag = false;
    private boolean detreecntDirtyFlag = false;
    private boolean deuacntDirtyFlag = false;
    private boolean deuagrpcntDirtyFlag = false;
    private boolean dewfcntDirtyFlag = false;
    private boolean indexcntDirtyFlag = false;
    private boolean psdemodelcntidDirtyFlag = false;
    private boolean psdemodelcntnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="clcnt")
    private Integer clcnt;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deaccnt")
    private Integer deaccnt;
    @Column(name="deactioncnt")
    private Integer deactioncnt;
    @Column(name="decalendarcnt")
    private Integer decalendarcnt;
    @Column(name="dechartcnt")
    private Integer dechartcnt;
    @Column(name="dedashboardcnt")
    private Integer dedashboardcnt;
    @Column(name="dedataviewcnt")
    private Integer dedataviewcnt;
    @Column(name="dedqcnt")
    private Integer dedqcnt;
    @Column(name="dedrcnt")
    private Integer dedrcnt;
    @Column(name="dedrgrpcnt")
    private Integer dedrgrpcnt;
    @Column(name="dedritemcnt")
    private Integer dedritemcnt;
    @Column(name="dedscnt")
    private Integer dedscnt;
    @Column(name="defieldcnt")
    private Integer defieldcnt;
    @Column(name="deformcnt")
    private Integer deformcnt;
    @Column(name="degridcnt")
    private Integer degridcnt;
    @Column(name="delistcnt")
    private Integer delistcnt;
    @Column(name="delogiccnt")
    private Integer delogiccnt;
    @Column(name="demapviewcnt")
    private Integer demapviewcnt;
    @Column(name="demscnt")
    private Integer demscnt;
    @Column(name="deopprivcnt")
    private Integer deopprivcnt;
    @Column(name="depanelcnt")
    private Integer depanelcnt;
    @Column(name="deportletcnt")
    private Integer deportletcnt;
    @Column(name="dercnt")
    private Integer dercnt;
    @Column(name="dercnt2")
    private Integer dercnt2;
    @Column(name="dereportcnt")
    private Integer dereportcnt;
    @Column(name="desearchbarcnt")
    private Integer desearchbarcnt;
    @Column(name="detoolbarcnt")
    private Integer detoolbarcnt;
    @Column(name="detreecnt")
    private Integer detreecnt;
    @Column(name="deuacnt")
    private Integer deuacnt;
    @Column(name="deuagrpcnt")
    private Integer deuagrpcnt;
    @Column(name="dewfcnt")
    private Integer dewfcnt;
    @Column(name="indexcnt")
    private Integer indexcnt;
    @Column(name="psdemodelcntid")
    private String psdemodelcntid;
    @Column(name="psdemodelcntname")
    private String psdemodelcntname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setCLCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLCnt(n);
            return;
        }
        this.clcnt = n;
        this.clcntDirtyFlag = true;
    }

    public Integer getCLCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLCnt();
        }
        return this.clcnt;
    }

    public boolean isCLCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLCntDirty();
        }
        return this.clcntDirtyFlag;
    }

    public void resetCLCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLCnt();
            return;
        }
        this.clcntDirtyFlag = false;
        this.clcnt = null;
    }

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

    public void setDEACCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEACCnt(n);
            return;
        }
        this.deaccnt = n;
        this.deaccntDirtyFlag = true;
    }

    public Integer getDEACCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEACCnt();
        }
        return this.deaccnt;
    }

    public boolean isDEACCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEACCntDirty();
        }
        return this.deaccntDirtyFlag;
    }

    public void resetDEACCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEACCnt();
            return;
        }
        this.deaccntDirtyFlag = false;
        this.deaccnt = null;
    }

    public void setDEActionCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEActionCnt(n);
            return;
        }
        this.deactioncnt = n;
        this.deactioncntDirtyFlag = true;
    }

    public Integer getDEActionCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEActionCnt();
        }
        return this.deactioncnt;
    }

    public boolean isDEActionCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEActionCntDirty();
        }
        return this.deactioncntDirtyFlag;
    }

    public void resetDEActionCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEActionCnt();
            return;
        }
        this.deactioncntDirtyFlag = false;
        this.deactioncnt = null;
    }

    public void setDECalendarCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDECalendarCnt(n);
            return;
        }
        this.decalendarcnt = n;
        this.decalendarcntDirtyFlag = true;
    }

    public Integer getDECalendarCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDECalendarCnt();
        }
        return this.decalendarcnt;
    }

    public boolean isDECalendarCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDECalendarCntDirty();
        }
        return this.decalendarcntDirtyFlag;
    }

    public void resetDECalendarCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDECalendarCnt();
            return;
        }
        this.decalendarcntDirtyFlag = false;
        this.decalendarcnt = null;
    }

    public void setDEChartCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEChartCnt(n);
            return;
        }
        this.dechartcnt = n;
        this.dechartcntDirtyFlag = true;
    }

    public Integer getDEChartCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEChartCnt();
        }
        return this.dechartcnt;
    }

    public boolean isDEChartCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEChartCntDirty();
        }
        return this.dechartcntDirtyFlag;
    }

    public void resetDEChartCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEChartCnt();
            return;
        }
        this.dechartcntDirtyFlag = false;
        this.dechartcnt = null;
    }

    public void setDEDashboardCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDashboardCnt(n);
            return;
        }
        this.dedashboardcnt = n;
        this.dedashboardcntDirtyFlag = true;
    }

    public Integer getDEDashboardCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDashboardCnt();
        }
        return this.dedashboardcnt;
    }

    public boolean isDEDashboardCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDashboardCntDirty();
        }
        return this.dedashboardcntDirtyFlag;
    }

    public void resetDEDashboardCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDashboardCnt();
            return;
        }
        this.dedashboardcntDirtyFlag = false;
        this.dedashboardcnt = null;
    }

    public void setDEDataViewCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDataViewCnt(n);
            return;
        }
        this.dedataviewcnt = n;
        this.dedataviewcntDirtyFlag = true;
    }

    public Integer getDEDataViewCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDataViewCnt();
        }
        return this.dedataviewcnt;
    }

    public boolean isDEDataViewCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDataViewCntDirty();
        }
        return this.dedataviewcntDirtyFlag;
    }

    public void resetDEDataViewCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDataViewCnt();
            return;
        }
        this.dedataviewcntDirtyFlag = false;
        this.dedataviewcnt = null;
    }

    public void setDEDQCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDQCnt(n);
            return;
        }
        this.dedqcnt = n;
        this.dedqcntDirtyFlag = true;
    }

    public Integer getDEDQCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDQCnt();
        }
        return this.dedqcnt;
    }

    public boolean isDEDQCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDQCntDirty();
        }
        return this.dedqcntDirtyFlag;
    }

    public void resetDEDQCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDQCnt();
            return;
        }
        this.dedqcntDirtyFlag = false;
        this.dedqcnt = null;
    }

    public void setDEDRCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDRCnt(n);
            return;
        }
        this.dedrcnt = n;
        this.dedrcntDirtyFlag = true;
    }

    public Integer getDEDRCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDRCnt();
        }
        return this.dedrcnt;
    }

    public boolean isDEDRCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDRCntDirty();
        }
        return this.dedrcntDirtyFlag;
    }

    public void resetDEDRCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDRCnt();
            return;
        }
        this.dedrcntDirtyFlag = false;
        this.dedrcnt = null;
    }

    public void setDEDRGrpCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDRGrpCnt(n);
            return;
        }
        this.dedrgrpcnt = n;
        this.dedrgrpcntDirtyFlag = true;
    }

    public Integer getDEDRGrpCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDRGrpCnt();
        }
        return this.dedrgrpcnt;
    }

    public boolean isDEDRGrpCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDRGrpCntDirty();
        }
        return this.dedrgrpcntDirtyFlag;
    }

    public void resetDEDRGrpCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDRGrpCnt();
            return;
        }
        this.dedrgrpcntDirtyFlag = false;
        this.dedrgrpcnt = null;
    }

    public void setDEDRItemCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDRItemCnt(n);
            return;
        }
        this.dedritemcnt = n;
        this.dedritemcntDirtyFlag = true;
    }

    public Integer getDEDRItemCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDRItemCnt();
        }
        return this.dedritemcnt;
    }

    public boolean isDEDRItemCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDRItemCntDirty();
        }
        return this.dedritemcntDirtyFlag;
    }

    public void resetDEDRItemCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDRItemCnt();
            return;
        }
        this.dedritemcntDirtyFlag = false;
        this.dedritemcnt = null;
    }

    public void setDEDSCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDSCnt(n);
            return;
        }
        this.dedscnt = n;
        this.dedscntDirtyFlag = true;
    }

    public Integer getDEDSCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDSCnt();
        }
        return this.dedscnt;
    }

    public boolean isDEDSCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDSCntDirty();
        }
        return this.dedscntDirtyFlag;
    }

    public void resetDEDSCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDSCnt();
            return;
        }
        this.dedscntDirtyFlag = false;
        this.dedscnt = null;
    }

    public void setDEFieldCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFieldCnt(n);
            return;
        }
        this.defieldcnt = n;
        this.defieldcntDirtyFlag = true;
    }

    public Integer getDEFieldCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFieldCnt();
        }
        return this.defieldcnt;
    }

    public boolean isDEFieldCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFieldCntDirty();
        }
        return this.defieldcntDirtyFlag;
    }

    public void resetDEFieldCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFieldCnt();
            return;
        }
        this.defieldcntDirtyFlag = false;
        this.defieldcnt = null;
    }

    public void setDEFormCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFormCnt(n);
            return;
        }
        this.deformcnt = n;
        this.deformcntDirtyFlag = true;
    }

    public Integer getDEFormCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFormCnt();
        }
        return this.deformcnt;
    }

    public boolean isDEFormCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFormCntDirty();
        }
        return this.deformcntDirtyFlag;
    }

    public void resetDEFormCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFormCnt();
            return;
        }
        this.deformcntDirtyFlag = false;
        this.deformcnt = null;
    }

    public void setDEGridCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEGridCnt(n);
            return;
        }
        this.degridcnt = n;
        this.degridcntDirtyFlag = true;
    }

    public Integer getDEGridCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEGridCnt();
        }
        return this.degridcnt;
    }

    public boolean isDEGridCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEGridCntDirty();
        }
        return this.degridcntDirtyFlag;
    }

    public void resetDEGridCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEGridCnt();
            return;
        }
        this.degridcntDirtyFlag = false;
        this.degridcnt = null;
    }

    public void setDEListCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEListCnt(n);
            return;
        }
        this.delistcnt = n;
        this.delistcntDirtyFlag = true;
    }

    public Integer getDEListCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEListCnt();
        }
        return this.delistcnt;
    }

    public boolean isDEListCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEListCntDirty();
        }
        return this.delistcntDirtyFlag;
    }

    public void resetDEListCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEListCnt();
            return;
        }
        this.delistcntDirtyFlag = false;
        this.delistcnt = null;
    }

    public void setDELogicCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDELogicCnt(n);
            return;
        }
        this.delogiccnt = n;
        this.delogiccntDirtyFlag = true;
    }

    public Integer getDELogicCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDELogicCnt();
        }
        return this.delogiccnt;
    }

    public boolean isDELogicCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDELogicCntDirty();
        }
        return this.delogiccntDirtyFlag;
    }

    public void resetDELogicCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDELogicCnt();
            return;
        }
        this.delogiccntDirtyFlag = false;
        this.delogiccnt = null;
    }

    public void setDEMapViewCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEMapViewCnt(n);
            return;
        }
        this.demapviewcnt = n;
        this.demapviewcntDirtyFlag = true;
    }

    public Integer getDEMapViewCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEMapViewCnt();
        }
        return this.demapviewcnt;
    }

    public boolean isDEMapViewCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEMapViewCntDirty();
        }
        return this.demapviewcntDirtyFlag;
    }

    public void resetDEMapViewCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEMapViewCnt();
            return;
        }
        this.demapviewcntDirtyFlag = false;
        this.demapviewcnt = null;
    }

    public void setDEMSCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEMSCnt(n);
            return;
        }
        this.demscnt = n;
        this.demscntDirtyFlag = true;
    }

    public Integer getDEMSCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEMSCnt();
        }
        return this.demscnt;
    }

    public boolean isDEMSCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEMSCntDirty();
        }
        return this.demscntDirtyFlag;
    }

    public void resetDEMSCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEMSCnt();
            return;
        }
        this.demscntDirtyFlag = false;
        this.demscnt = null;
    }

    public void setDEOPPrivCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEOPPrivCnt(n);
            return;
        }
        this.deopprivcnt = n;
        this.deopprivcntDirtyFlag = true;
    }

    public Integer getDEOPPrivCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEOPPrivCnt();
        }
        return this.deopprivcnt;
    }

    public boolean isDEOPPrivCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEOPPrivCntDirty();
        }
        return this.deopprivcntDirtyFlag;
    }

    public void resetDEOPPrivCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEOPPrivCnt();
            return;
        }
        this.deopprivcntDirtyFlag = false;
        this.deopprivcnt = null;
    }

    public void setDEPanelCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEPanelCnt(n);
            return;
        }
        this.depanelcnt = n;
        this.depanelcntDirtyFlag = true;
    }

    public Integer getDEPanelCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEPanelCnt();
        }
        return this.depanelcnt;
    }

    public boolean isDEPanelCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEPanelCntDirty();
        }
        return this.depanelcntDirtyFlag;
    }

    public void resetDEPanelCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEPanelCnt();
            return;
        }
        this.depanelcntDirtyFlag = false;
        this.depanelcnt = null;
    }

    public void setDEPortletCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEPortletCnt(n);
            return;
        }
        this.deportletcnt = n;
        this.deportletcntDirtyFlag = true;
    }

    public Integer getDEPortletCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEPortletCnt();
        }
        return this.deportletcnt;
    }

    public boolean isDEPortletCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEPortletCntDirty();
        }
        return this.deportletcntDirtyFlag;
    }

    public void resetDEPortletCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEPortletCnt();
            return;
        }
        this.deportletcntDirtyFlag = false;
        this.deportletcnt = null;
    }

    public void setDERCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERCnt(n);
            return;
        }
        this.dercnt = n;
        this.dercntDirtyFlag = true;
    }

    public Integer getDERCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERCnt();
        }
        return this.dercnt;
    }

    public boolean isDERCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERCntDirty();
        }
        return this.dercntDirtyFlag;
    }

    public void resetDERCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERCnt();
            return;
        }
        this.dercntDirtyFlag = false;
        this.dercnt = null;
    }

    public void setDERCnt2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERCnt2(n);
            return;
        }
        this.dercnt2 = n;
        this.dercnt2DirtyFlag = true;
    }

    public Integer getDERCnt2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERCnt2();
        }
        return this.dercnt2;
    }

    public boolean isDERCnt2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERCnt2Dirty();
        }
        return this.dercnt2DirtyFlag;
    }

    public void resetDERCnt2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERCnt2();
            return;
        }
        this.dercnt2DirtyFlag = false;
        this.dercnt2 = null;
    }

    public void setDEReportCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEReportCnt(n);
            return;
        }
        this.dereportcnt = n;
        this.dereportcntDirtyFlag = true;
    }

    public Integer getDEReportCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEReportCnt();
        }
        return this.dereportcnt;
    }

    public boolean isDEReportCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEReportCntDirty();
        }
        return this.dereportcntDirtyFlag;
    }

    public void resetDEReportCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEReportCnt();
            return;
        }
        this.dereportcntDirtyFlag = false;
        this.dereportcnt = null;
    }

    public void setDESearchBarCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDESearchBarCnt(n);
            return;
        }
        this.desearchbarcnt = n;
        this.desearchbarcntDirtyFlag = true;
    }

    public Integer getDESearchBarCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDESearchBarCnt();
        }
        return this.desearchbarcnt;
    }

    public boolean isDESearchBarCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDESearchBarCntDirty();
        }
        return this.desearchbarcntDirtyFlag;
    }

    public void resetDESearchBarCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDESearchBarCnt();
            return;
        }
        this.desearchbarcntDirtyFlag = false;
        this.desearchbarcnt = null;
    }

    public void setDEToolbarCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEToolbarCnt(n);
            return;
        }
        this.detoolbarcnt = n;
        this.detoolbarcntDirtyFlag = true;
    }

    public Integer getDEToolbarCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEToolbarCnt();
        }
        return this.detoolbarcnt;
    }

    public boolean isDEToolbarCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEToolbarCntDirty();
        }
        return this.detoolbarcntDirtyFlag;
    }

    public void resetDEToolbarCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEToolbarCnt();
            return;
        }
        this.detoolbarcntDirtyFlag = false;
        this.detoolbarcnt = null;
    }

    public void setDETreeCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDETreeCnt(n);
            return;
        }
        this.detreecnt = n;
        this.detreecntDirtyFlag = true;
    }

    public Integer getDETreeCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDETreeCnt();
        }
        return this.detreecnt;
    }

    public boolean isDETreeCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDETreeCntDirty();
        }
        return this.detreecntDirtyFlag;
    }

    public void resetDETreeCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDETreeCnt();
            return;
        }
        this.detreecntDirtyFlag = false;
        this.detreecnt = null;
    }

    public void setDEUACnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEUACnt(n);
            return;
        }
        this.deuacnt = n;
        this.deuacntDirtyFlag = true;
    }

    public Integer getDEUACnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEUACnt();
        }
        return this.deuacnt;
    }

    public boolean isDEUACntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEUACntDirty();
        }
        return this.deuacntDirtyFlag;
    }

    public void resetDEUACnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEUACnt();
            return;
        }
        this.deuacntDirtyFlag = false;
        this.deuacnt = null;
    }

    public void setDEUAGrpCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEUAGrpCnt(n);
            return;
        }
        this.deuagrpcnt = n;
        this.deuagrpcntDirtyFlag = true;
    }

    public Integer getDEUAGrpCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEUAGrpCnt();
        }
        return this.deuagrpcnt;
    }

    public boolean isDEUAGrpCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEUAGrpCntDirty();
        }
        return this.deuagrpcntDirtyFlag;
    }

    public void resetDEUAGrpCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEUAGrpCnt();
            return;
        }
        this.deuagrpcntDirtyFlag = false;
        this.deuagrpcnt = null;
    }

    public void setDEWFCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEWFCnt(n);
            return;
        }
        this.dewfcnt = n;
        this.dewfcntDirtyFlag = true;
    }

    public Integer getDEWFCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEWFCnt();
        }
        return this.dewfcnt;
    }

    public boolean isDEWFCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEWFCntDirty();
        }
        return this.dewfcntDirtyFlag;
    }

    public void resetDEWFCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEWFCnt();
            return;
        }
        this.dewfcntDirtyFlag = false;
        this.dewfcnt = null;
    }

    public void setIndexCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIndexCnt(n);
            return;
        }
        this.indexcnt = n;
        this.indexcntDirtyFlag = true;
    }

    public Integer getIndexCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIndexCnt();
        }
        return this.indexcnt;
    }

    public boolean isIndexCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIndexCntDirty();
        }
        return this.indexcntDirtyFlag;
    }

    public void resetIndexCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIndexCnt();
            return;
        }
        this.indexcntDirtyFlag = false;
        this.indexcnt = null;
    }

    public void setPSDEModelCntId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEModelCntId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemodelcntid = string;
        this.psdemodelcntidDirtyFlag = true;
    }

    public String getPSDEModelCntId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEModelCntId();
        }
        return this.psdemodelcntid;
    }

    public boolean isPSDEModelCntIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEModelCntIdDirty();
        }
        return this.psdemodelcntidDirtyFlag;
    }

    public void resetPSDEModelCntId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEModelCntId();
            return;
        }
        this.psdemodelcntidDirtyFlag = false;
        this.psdemodelcntid = null;
    }

    public void setPSDEModelCntName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEModelCntName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemodelcntname = string;
        this.psdemodelcntnameDirtyFlag = true;
    }

    public String getPSDEModelCntName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEModelCntName();
        }
        return this.psdemodelcntname;
    }

    public boolean isPSDEModelCntNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEModelCntNameDirty();
        }
        return this.psdemodelcntnameDirtyFlag;
    }

    public void resetPSDEModelCntName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEModelCntName();
            return;
        }
        this.psdemodelcntnameDirtyFlag = false;
        this.psdemodelcntname = null;
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
        PSDEModelCntBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEModelCntBase pSDEModelCntBase) {
        pSDEModelCntBase.resetCLCnt();
        pSDEModelCntBase.resetCreateDate();
        pSDEModelCntBase.resetCreateMan();
        pSDEModelCntBase.resetDEACCnt();
        pSDEModelCntBase.resetDEActionCnt();
        pSDEModelCntBase.resetDECalendarCnt();
        pSDEModelCntBase.resetDEChartCnt();
        pSDEModelCntBase.resetDEDashboardCnt();
        pSDEModelCntBase.resetDEDataViewCnt();
        pSDEModelCntBase.resetDEDQCnt();
        pSDEModelCntBase.resetDEDRCnt();
        pSDEModelCntBase.resetDEDRGrpCnt();
        pSDEModelCntBase.resetDEDRItemCnt();
        pSDEModelCntBase.resetDEDSCnt();
        pSDEModelCntBase.resetDEFieldCnt();
        pSDEModelCntBase.resetDEFormCnt();
        pSDEModelCntBase.resetDEGridCnt();
        pSDEModelCntBase.resetDEListCnt();
        pSDEModelCntBase.resetDELogicCnt();
        pSDEModelCntBase.resetDEMapViewCnt();
        pSDEModelCntBase.resetDEMSCnt();
        pSDEModelCntBase.resetDEOPPrivCnt();
        pSDEModelCntBase.resetDEPanelCnt();
        pSDEModelCntBase.resetDEPortletCnt();
        pSDEModelCntBase.resetDERCnt();
        pSDEModelCntBase.resetDERCnt2();
        pSDEModelCntBase.resetDEReportCnt();
        pSDEModelCntBase.resetDESearchBarCnt();
        pSDEModelCntBase.resetDEToolbarCnt();
        pSDEModelCntBase.resetDETreeCnt();
        pSDEModelCntBase.resetDEUACnt();
        pSDEModelCntBase.resetDEUAGrpCnt();
        pSDEModelCntBase.resetDEWFCnt();
        pSDEModelCntBase.resetIndexCnt();
        pSDEModelCntBase.resetPSDEModelCntId();
        pSDEModelCntBase.resetPSDEModelCntName();
        pSDEModelCntBase.resetUpdateDate();
        pSDEModelCntBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCLCntDirty()) {
            hashMap.put(FIELD_CLCNT, this.getCLCnt());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEACCntDirty()) {
            hashMap.put(FIELD_DEACCNT, this.getDEACCnt());
        }
        if (!bl || this.isDEActionCntDirty()) {
            hashMap.put(FIELD_DEACTIONCNT, this.getDEActionCnt());
        }
        if (!bl || this.isDECalendarCntDirty()) {
            hashMap.put(FIELD_DECALENDARCNT, this.getDECalendarCnt());
        }
        if (!bl || this.isDEChartCntDirty()) {
            hashMap.put(FIELD_DECHARTCNT, this.getDEChartCnt());
        }
        if (!bl || this.isDEDashboardCntDirty()) {
            hashMap.put(FIELD_DEDASHBOARDCNT, this.getDEDashboardCnt());
        }
        if (!bl || this.isDEDataViewCntDirty()) {
            hashMap.put(FIELD_DEDATAVIEWCNT, this.getDEDataViewCnt());
        }
        if (!bl || this.isDEDQCntDirty()) {
            hashMap.put(FIELD_DEDQCNT, this.getDEDQCnt());
        }
        if (!bl || this.isDEDRCntDirty()) {
            hashMap.put(FIELD_DEDRCNT, this.getDEDRCnt());
        }
        if (!bl || this.isDEDRGrpCntDirty()) {
            hashMap.put(FIELD_DEDRGRPCNT, this.getDEDRGrpCnt());
        }
        if (!bl || this.isDEDRItemCntDirty()) {
            hashMap.put(FIELD_DEDRITEMCNT, this.getDEDRItemCnt());
        }
        if (!bl || this.isDEDSCntDirty()) {
            hashMap.put(FIELD_DEDSCNT, this.getDEDSCnt());
        }
        if (!bl || this.isDEFieldCntDirty()) {
            hashMap.put(FIELD_DEFIELDCNT, this.getDEFieldCnt());
        }
        if (!bl || this.isDEFormCntDirty()) {
            hashMap.put(FIELD_DEFORMCNT, this.getDEFormCnt());
        }
        if (!bl || this.isDEGridCntDirty()) {
            hashMap.put(FIELD_DEGRIDCNT, this.getDEGridCnt());
        }
        if (!bl || this.isDEListCntDirty()) {
            hashMap.put(FIELD_DELISTCNT, this.getDEListCnt());
        }
        if (!bl || this.isDELogicCntDirty()) {
            hashMap.put(FIELD_DELOGICCNT, this.getDELogicCnt());
        }
        if (!bl || this.isDEMapViewCntDirty()) {
            hashMap.put(FIELD_DEMAPVIEWCNT, this.getDEMapViewCnt());
        }
        if (!bl || this.isDEMSCntDirty()) {
            hashMap.put(FIELD_DEMSCNT, this.getDEMSCnt());
        }
        if (!bl || this.isDEOPPrivCntDirty()) {
            hashMap.put(FIELD_DEOPPRIVCNT, this.getDEOPPrivCnt());
        }
        if (!bl || this.isDEPanelCntDirty()) {
            hashMap.put(FIELD_DEPANELCNT, this.getDEPanelCnt());
        }
        if (!bl || this.isDEPortletCntDirty()) {
            hashMap.put(FIELD_DEPORTLETCNT, this.getDEPortletCnt());
        }
        if (!bl || this.isDERCntDirty()) {
            hashMap.put(FIELD_DERCNT, this.getDERCnt());
        }
        if (!bl || this.isDERCnt2Dirty()) {
            hashMap.put(FIELD_DERCNT2, this.getDERCnt2());
        }
        if (!bl || this.isDEReportCntDirty()) {
            hashMap.put(FIELD_DEREPORTCNT, this.getDEReportCnt());
        }
        if (!bl || this.isDESearchBarCntDirty()) {
            hashMap.put(FIELD_DESEARCHBARCNT, this.getDESearchBarCnt());
        }
        if (!bl || this.isDEToolbarCntDirty()) {
            hashMap.put(FIELD_DETOOLBARCNT, this.getDEToolbarCnt());
        }
        if (!bl || this.isDETreeCntDirty()) {
            hashMap.put(FIELD_DETREECNT, this.getDETreeCnt());
        }
        if (!bl || this.isDEUACntDirty()) {
            hashMap.put(FIELD_DEUACNT, this.getDEUACnt());
        }
        if (!bl || this.isDEUAGrpCntDirty()) {
            hashMap.put(FIELD_DEUAGRPCNT, this.getDEUAGrpCnt());
        }
        if (!bl || this.isDEWFCntDirty()) {
            hashMap.put(FIELD_DEWFCNT, this.getDEWFCnt());
        }
        if (!bl || this.isIndexCntDirty()) {
            hashMap.put(FIELD_INDEXCNT, this.getIndexCnt());
        }
        if (!bl || this.isPSDEModelCntIdDirty()) {
            hashMap.put(FIELD_PSDEMODELCNTID, this.getPSDEModelCntId());
        }
        if (!bl || this.isPSDEModelCntNameDirty()) {
            hashMap.put(FIELD_PSDEMODELCNTNAME, this.getPSDEModelCntName());
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
        return PSDEModelCntBase.get(this, n);
    }

    private static Object get(PSDEModelCntBase pSDEModelCntBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEModelCntBase.getCLCnt();
            }
            case 1: {
                return pSDEModelCntBase.getCreateDate();
            }
            case 2: {
                return pSDEModelCntBase.getCreateMan();
            }
            case 3: {
                return pSDEModelCntBase.getDEACCnt();
            }
            case 4: {
                return pSDEModelCntBase.getDEActionCnt();
            }
            case 5: {
                return pSDEModelCntBase.getDECalendarCnt();
            }
            case 6: {
                return pSDEModelCntBase.getDEChartCnt();
            }
            case 7: {
                return pSDEModelCntBase.getDEDashboardCnt();
            }
            case 8: {
                return pSDEModelCntBase.getDEDataViewCnt();
            }
            case 9: {
                return pSDEModelCntBase.getDEDQCnt();
            }
            case 10: {
                return pSDEModelCntBase.getDEDRCnt();
            }
            case 11: {
                return pSDEModelCntBase.getDEDRGrpCnt();
            }
            case 12: {
                return pSDEModelCntBase.getDEDRItemCnt();
            }
            case 13: {
                return pSDEModelCntBase.getDEDSCnt();
            }
            case 14: {
                return pSDEModelCntBase.getDEFieldCnt();
            }
            case 15: {
                return pSDEModelCntBase.getDEFormCnt();
            }
            case 16: {
                return pSDEModelCntBase.getDEGridCnt();
            }
            case 17: {
                return pSDEModelCntBase.getDEListCnt();
            }
            case 18: {
                return pSDEModelCntBase.getDELogicCnt();
            }
            case 19: {
                return pSDEModelCntBase.getDEMapViewCnt();
            }
            case 20: {
                return pSDEModelCntBase.getDEMSCnt();
            }
            case 21: {
                return pSDEModelCntBase.getDEOPPrivCnt();
            }
            case 22: {
                return pSDEModelCntBase.getDEPanelCnt();
            }
            case 23: {
                return pSDEModelCntBase.getDEPortletCnt();
            }
            case 24: {
                return pSDEModelCntBase.getDERCnt();
            }
            case 25: {
                return pSDEModelCntBase.getDERCnt2();
            }
            case 26: {
                return pSDEModelCntBase.getDEReportCnt();
            }
            case 27: {
                return pSDEModelCntBase.getDESearchBarCnt();
            }
            case 28: {
                return pSDEModelCntBase.getDEToolbarCnt();
            }
            case 29: {
                return pSDEModelCntBase.getDETreeCnt();
            }
            case 30: {
                return pSDEModelCntBase.getDEUACnt();
            }
            case 31: {
                return pSDEModelCntBase.getDEUAGrpCnt();
            }
            case 32: {
                return pSDEModelCntBase.getDEWFCnt();
            }
            case 33: {
                return pSDEModelCntBase.getIndexCnt();
            }
            case 34: {
                return pSDEModelCntBase.getPSDEModelCntId();
            }
            case 35: {
                return pSDEModelCntBase.getPSDEModelCntName();
            }
            case 36: {
                return pSDEModelCntBase.getUpdateDate();
            }
            case 37: {
                return pSDEModelCntBase.getUpdateMan();
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
        PSDEModelCntBase.set(this, n, object);
    }

    private static void set(PSDEModelCntBase pSDEModelCntBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEModelCntBase.setCLCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEModelCntBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEModelCntBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEModelCntBase.setDEACCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEModelCntBase.setDEActionCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEModelCntBase.setDECalendarCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEModelCntBase.setDEChartCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEModelCntBase.setDEDashboardCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEModelCntBase.setDEDataViewCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEModelCntBase.setDEDQCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEModelCntBase.setDEDRCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEModelCntBase.setDEDRGrpCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEModelCntBase.setDEDRItemCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEModelCntBase.setDEDSCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDEModelCntBase.setDEFieldCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEModelCntBase.setDEFormCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDEModelCntBase.setDEGridCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEModelCntBase.setDEListCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEModelCntBase.setDELogicCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEModelCntBase.setDEMapViewCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEModelCntBase.setDEMSCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEModelCntBase.setDEOPPrivCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEModelCntBase.setDEPanelCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEModelCntBase.setDEPortletCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEModelCntBase.setDERCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEModelCntBase.setDERCnt2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDEModelCntBase.setDEReportCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEModelCntBase.setDESearchBarCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEModelCntBase.setDEToolbarCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEModelCntBase.setDETreeCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEModelCntBase.setDEUACnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDEModelCntBase.setDEUAGrpCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSDEModelCntBase.setDEWFCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSDEModelCntBase.setIndexCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEModelCntBase.setPSDEModelCntId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEModelCntBase.setPSDEModelCntName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEModelCntBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSDEModelCntBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEModelCntBase.isNull(this, n);
    }

    private static boolean isNull(PSDEModelCntBase pSDEModelCntBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEModelCntBase.getCLCnt() == null;
            }
            case 1: {
                return pSDEModelCntBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEModelCntBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEModelCntBase.getDEACCnt() == null;
            }
            case 4: {
                return pSDEModelCntBase.getDEActionCnt() == null;
            }
            case 5: {
                return pSDEModelCntBase.getDECalendarCnt() == null;
            }
            case 6: {
                return pSDEModelCntBase.getDEChartCnt() == null;
            }
            case 7: {
                return pSDEModelCntBase.getDEDashboardCnt() == null;
            }
            case 8: {
                return pSDEModelCntBase.getDEDataViewCnt() == null;
            }
            case 9: {
                return pSDEModelCntBase.getDEDQCnt() == null;
            }
            case 10: {
                return pSDEModelCntBase.getDEDRCnt() == null;
            }
            case 11: {
                return pSDEModelCntBase.getDEDRGrpCnt() == null;
            }
            case 12: {
                return pSDEModelCntBase.getDEDRItemCnt() == null;
            }
            case 13: {
                return pSDEModelCntBase.getDEDSCnt() == null;
            }
            case 14: {
                return pSDEModelCntBase.getDEFieldCnt() == null;
            }
            case 15: {
                return pSDEModelCntBase.getDEFormCnt() == null;
            }
            case 16: {
                return pSDEModelCntBase.getDEGridCnt() == null;
            }
            case 17: {
                return pSDEModelCntBase.getDEListCnt() == null;
            }
            case 18: {
                return pSDEModelCntBase.getDELogicCnt() == null;
            }
            case 19: {
                return pSDEModelCntBase.getDEMapViewCnt() == null;
            }
            case 20: {
                return pSDEModelCntBase.getDEMSCnt() == null;
            }
            case 21: {
                return pSDEModelCntBase.getDEOPPrivCnt() == null;
            }
            case 22: {
                return pSDEModelCntBase.getDEPanelCnt() == null;
            }
            case 23: {
                return pSDEModelCntBase.getDEPortletCnt() == null;
            }
            case 24: {
                return pSDEModelCntBase.getDERCnt() == null;
            }
            case 25: {
                return pSDEModelCntBase.getDERCnt2() == null;
            }
            case 26: {
                return pSDEModelCntBase.getDEReportCnt() == null;
            }
            case 27: {
                return pSDEModelCntBase.getDESearchBarCnt() == null;
            }
            case 28: {
                return pSDEModelCntBase.getDEToolbarCnt() == null;
            }
            case 29: {
                return pSDEModelCntBase.getDETreeCnt() == null;
            }
            case 30: {
                return pSDEModelCntBase.getDEUACnt() == null;
            }
            case 31: {
                return pSDEModelCntBase.getDEUAGrpCnt() == null;
            }
            case 32: {
                return pSDEModelCntBase.getDEWFCnt() == null;
            }
            case 33: {
                return pSDEModelCntBase.getIndexCnt() == null;
            }
            case 34: {
                return pSDEModelCntBase.getPSDEModelCntId() == null;
            }
            case 35: {
                return pSDEModelCntBase.getPSDEModelCntName() == null;
            }
            case 36: {
                return pSDEModelCntBase.getUpdateDate() == null;
            }
            case 37: {
                return pSDEModelCntBase.getUpdateMan() == null;
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
        return PSDEModelCntBase.contains(this, n);
    }

    private static boolean contains(PSDEModelCntBase pSDEModelCntBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEModelCntBase.isCLCntDirty();
            }
            case 1: {
                return pSDEModelCntBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEModelCntBase.isCreateManDirty();
            }
            case 3: {
                return pSDEModelCntBase.isDEACCntDirty();
            }
            case 4: {
                return pSDEModelCntBase.isDEActionCntDirty();
            }
            case 5: {
                return pSDEModelCntBase.isDECalendarCntDirty();
            }
            case 6: {
                return pSDEModelCntBase.isDEChartCntDirty();
            }
            case 7: {
                return pSDEModelCntBase.isDEDashboardCntDirty();
            }
            case 8: {
                return pSDEModelCntBase.isDEDataViewCntDirty();
            }
            case 9: {
                return pSDEModelCntBase.isDEDQCntDirty();
            }
            case 10: {
                return pSDEModelCntBase.isDEDRCntDirty();
            }
            case 11: {
                return pSDEModelCntBase.isDEDRGrpCntDirty();
            }
            case 12: {
                return pSDEModelCntBase.isDEDRItemCntDirty();
            }
            case 13: {
                return pSDEModelCntBase.isDEDSCntDirty();
            }
            case 14: {
                return pSDEModelCntBase.isDEFieldCntDirty();
            }
            case 15: {
                return pSDEModelCntBase.isDEFormCntDirty();
            }
            case 16: {
                return pSDEModelCntBase.isDEGridCntDirty();
            }
            case 17: {
                return pSDEModelCntBase.isDEListCntDirty();
            }
            case 18: {
                return pSDEModelCntBase.isDELogicCntDirty();
            }
            case 19: {
                return pSDEModelCntBase.isDEMapViewCntDirty();
            }
            case 20: {
                return pSDEModelCntBase.isDEMSCntDirty();
            }
            case 21: {
                return pSDEModelCntBase.isDEOPPrivCntDirty();
            }
            case 22: {
                return pSDEModelCntBase.isDEPanelCntDirty();
            }
            case 23: {
                return pSDEModelCntBase.isDEPortletCntDirty();
            }
            case 24: {
                return pSDEModelCntBase.isDERCntDirty();
            }
            case 25: {
                return pSDEModelCntBase.isDERCnt2Dirty();
            }
            case 26: {
                return pSDEModelCntBase.isDEReportCntDirty();
            }
            case 27: {
                return pSDEModelCntBase.isDESearchBarCntDirty();
            }
            case 28: {
                return pSDEModelCntBase.isDEToolbarCntDirty();
            }
            case 29: {
                return pSDEModelCntBase.isDETreeCntDirty();
            }
            case 30: {
                return pSDEModelCntBase.isDEUACntDirty();
            }
            case 31: {
                return pSDEModelCntBase.isDEUAGrpCntDirty();
            }
            case 32: {
                return pSDEModelCntBase.isDEWFCntDirty();
            }
            case 33: {
                return pSDEModelCntBase.isIndexCntDirty();
            }
            case 34: {
                return pSDEModelCntBase.isPSDEModelCntIdDirty();
            }
            case 35: {
                return pSDEModelCntBase.isPSDEModelCntNameDirty();
            }
            case 36: {
                return pSDEModelCntBase.isUpdateDateDirty();
            }
            case 37: {
                return pSDEModelCntBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEModelCntBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEModelCntBase pSDEModelCntBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEModelCntBase.getCLCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getCLCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEACCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deaccnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEACCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEActionCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deactioncnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEActionCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDECalendarCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"decalendarcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDECalendarCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEChartCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dechartcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEChartCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEDashboardCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedashboardcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEDashboardCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEDataViewCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedataviewcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEDataViewCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEDQCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedqcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEDQCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEDRCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedrcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEDRCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEDRGrpCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedrgrpcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEDRGrpCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEDRItemCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedritemcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEDRItemCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEDSCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedscnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEDSCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEFieldCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defieldcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEFieldCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEFormCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deformcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEFormCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEGridCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"degridcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEGridCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEListCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"delistcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEListCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDELogicCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"delogiccnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDELogicCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEMapViewCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"demapviewcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEMapViewCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEMSCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"demscnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEMSCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEOPPrivCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deopprivcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEOPPrivCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEPanelCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depanelcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEPanelCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEPortletCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deportletcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEPortletCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDERCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dercnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDERCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDERCnt2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dercnt2", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDERCnt2()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEReportCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dereportcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEReportCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDESearchBarCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"desearchbarcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDESearchBarCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEToolbarCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detoolbarcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEToolbarCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDETreeCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detreecnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDETreeCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEUACnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deuacnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEUACnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEUAGrpCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deuagrpcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEUAGrpCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getDEWFCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dewfcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getDEWFCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getIndexCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"indexcnt", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getIndexCnt()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getPSDEModelCntId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemodelcntid", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getPSDEModelCntId()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getPSDEModelCntName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemodelcntname", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getPSDEModelCntName()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEModelCntBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEModelCntBase.getJSONValue((Object)pSDEModelCntBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEModelCntBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEModelCntBase pSDEModelCntBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEModelCntBase.getCLCnt() != null) {
            object = pSDEModelCntBase.getCLCnt();
            xmlNode.setAttribute(FIELD_CLCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getCreateDate() != null) {
            object = pSDEModelCntBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEModelCntBase.getCreateMan() != null) {
            object = pSDEModelCntBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelCntBase.getDEACCnt() != null) {
            object = pSDEModelCntBase.getDEACCnt();
            xmlNode.setAttribute(FIELD_DEACCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEActionCnt() != null) {
            object = pSDEModelCntBase.getDEActionCnt();
            xmlNode.setAttribute(FIELD_DEACTIONCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDECalendarCnt() != null) {
            object = pSDEModelCntBase.getDECalendarCnt();
            xmlNode.setAttribute(FIELD_DECALENDARCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEChartCnt() != null) {
            object = pSDEModelCntBase.getDEChartCnt();
            xmlNode.setAttribute(FIELD_DECHARTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEDashboardCnt() != null) {
            object = pSDEModelCntBase.getDEDashboardCnt();
            xmlNode.setAttribute(FIELD_DEDASHBOARDCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEDataViewCnt() != null) {
            object = pSDEModelCntBase.getDEDataViewCnt();
            xmlNode.setAttribute(FIELD_DEDATAVIEWCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEDQCnt() != null) {
            object = pSDEModelCntBase.getDEDQCnt();
            xmlNode.setAttribute(FIELD_DEDQCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEDRCnt() != null) {
            object = pSDEModelCntBase.getDEDRCnt();
            xmlNode.setAttribute(FIELD_DEDRCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEDRGrpCnt() != null) {
            object = pSDEModelCntBase.getDEDRGrpCnt();
            xmlNode.setAttribute(FIELD_DEDRGRPCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEDRItemCnt() != null) {
            object = pSDEModelCntBase.getDEDRItemCnt();
            xmlNode.setAttribute(FIELD_DEDRITEMCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEDSCnt() != null) {
            object = pSDEModelCntBase.getDEDSCnt();
            xmlNode.setAttribute(FIELD_DEDSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEFieldCnt() != null) {
            object = pSDEModelCntBase.getDEFieldCnt();
            xmlNode.setAttribute(FIELD_DEFIELDCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEFormCnt() != null) {
            object = pSDEModelCntBase.getDEFormCnt();
            xmlNode.setAttribute(FIELD_DEFORMCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEGridCnt() != null) {
            object = pSDEModelCntBase.getDEGridCnt();
            xmlNode.setAttribute(FIELD_DEGRIDCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEListCnt() != null) {
            object = pSDEModelCntBase.getDEListCnt();
            xmlNode.setAttribute(FIELD_DELISTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDELogicCnt() != null) {
            object = pSDEModelCntBase.getDELogicCnt();
            xmlNode.setAttribute(FIELD_DELOGICCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEMapViewCnt() != null) {
            object = pSDEModelCntBase.getDEMapViewCnt();
            xmlNode.setAttribute(FIELD_DEMAPVIEWCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEMSCnt() != null) {
            object = pSDEModelCntBase.getDEMSCnt();
            xmlNode.setAttribute(FIELD_DEMSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEOPPrivCnt() != null) {
            object = pSDEModelCntBase.getDEOPPrivCnt();
            xmlNode.setAttribute(FIELD_DEOPPRIVCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEPanelCnt() != null) {
            object = pSDEModelCntBase.getDEPanelCnt();
            xmlNode.setAttribute(FIELD_DEPANELCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEPortletCnt() != null) {
            object = pSDEModelCntBase.getDEPortletCnt();
            xmlNode.setAttribute(FIELD_DEPORTLETCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDERCnt() != null) {
            object = pSDEModelCntBase.getDERCnt();
            xmlNode.setAttribute(FIELD_DERCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDERCnt2() != null) {
            object = pSDEModelCntBase.getDERCnt2();
            xmlNode.setAttribute(FIELD_DERCNT2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEReportCnt() != null) {
            object = pSDEModelCntBase.getDEReportCnt();
            xmlNode.setAttribute(FIELD_DEREPORTCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDESearchBarCnt() != null) {
            object = pSDEModelCntBase.getDESearchBarCnt();
            xmlNode.setAttribute(FIELD_DESEARCHBARCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEToolbarCnt() != null) {
            object = pSDEModelCntBase.getDEToolbarCnt();
            xmlNode.setAttribute(FIELD_DETOOLBARCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDETreeCnt() != null) {
            object = pSDEModelCntBase.getDETreeCnt();
            xmlNode.setAttribute(FIELD_DETREECNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEUACnt() != null) {
            object = pSDEModelCntBase.getDEUACnt();
            xmlNode.setAttribute(FIELD_DEUACNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEUAGrpCnt() != null) {
            object = pSDEModelCntBase.getDEUAGrpCnt();
            xmlNode.setAttribute(FIELD_DEUAGRPCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getDEWFCnt() != null) {
            object = pSDEModelCntBase.getDEWFCnt();
            xmlNode.setAttribute(FIELD_DEWFCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getIndexCnt() != null) {
            object = pSDEModelCntBase.getIndexCnt();
            xmlNode.setAttribute(FIELD_INDEXCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEModelCntBase.getPSDEModelCntId() != null) {
            object = pSDEModelCntBase.getPSDEModelCntId();
            xmlNode.setAttribute(FIELD_PSDEMODELCNTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelCntBase.getPSDEModelCntName() != null) {
            object = pSDEModelCntBase.getPSDEModelCntName();
            xmlNode.setAttribute(FIELD_PSDEMODELCNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelCntBase.getUpdateDate() != null) {
            object = pSDEModelCntBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEModelCntBase.getUpdateMan() != null) {
            object = pSDEModelCntBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEModelCntBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEModelCntBase pSDEModelCntBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEModelCntBase.isCLCntDirty() && (bl || pSDEModelCntBase.getCLCnt() != null)) {
            iDataObject.set(FIELD_CLCNT, (Object)pSDEModelCntBase.getCLCnt());
        }
        if (pSDEModelCntBase.isCreateDateDirty() && (bl || pSDEModelCntBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEModelCntBase.getCreateDate());
        }
        if (pSDEModelCntBase.isCreateManDirty() && (bl || pSDEModelCntBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEModelCntBase.getCreateMan());
        }
        if (pSDEModelCntBase.isDEACCntDirty() && (bl || pSDEModelCntBase.getDEACCnt() != null)) {
            iDataObject.set(FIELD_DEACCNT, (Object)pSDEModelCntBase.getDEACCnt());
        }
        if (pSDEModelCntBase.isDEActionCntDirty() && (bl || pSDEModelCntBase.getDEActionCnt() != null)) {
            iDataObject.set(FIELD_DEACTIONCNT, (Object)pSDEModelCntBase.getDEActionCnt());
        }
        if (pSDEModelCntBase.isDECalendarCntDirty() && (bl || pSDEModelCntBase.getDECalendarCnt() != null)) {
            iDataObject.set(FIELD_DECALENDARCNT, (Object)pSDEModelCntBase.getDECalendarCnt());
        }
        if (pSDEModelCntBase.isDEChartCntDirty() && (bl || pSDEModelCntBase.getDEChartCnt() != null)) {
            iDataObject.set(FIELD_DECHARTCNT, (Object)pSDEModelCntBase.getDEChartCnt());
        }
        if (pSDEModelCntBase.isDEDashboardCntDirty() && (bl || pSDEModelCntBase.getDEDashboardCnt() != null)) {
            iDataObject.set(FIELD_DEDASHBOARDCNT, (Object)pSDEModelCntBase.getDEDashboardCnt());
        }
        if (pSDEModelCntBase.isDEDataViewCntDirty() && (bl || pSDEModelCntBase.getDEDataViewCnt() != null)) {
            iDataObject.set(FIELD_DEDATAVIEWCNT, (Object)pSDEModelCntBase.getDEDataViewCnt());
        }
        if (pSDEModelCntBase.isDEDQCntDirty() && (bl || pSDEModelCntBase.getDEDQCnt() != null)) {
            iDataObject.set(FIELD_DEDQCNT, (Object)pSDEModelCntBase.getDEDQCnt());
        }
        if (pSDEModelCntBase.isDEDRCntDirty() && (bl || pSDEModelCntBase.getDEDRCnt() != null)) {
            iDataObject.set(FIELD_DEDRCNT, (Object)pSDEModelCntBase.getDEDRCnt());
        }
        if (pSDEModelCntBase.isDEDRGrpCntDirty() && (bl || pSDEModelCntBase.getDEDRGrpCnt() != null)) {
            iDataObject.set(FIELD_DEDRGRPCNT, (Object)pSDEModelCntBase.getDEDRGrpCnt());
        }
        if (pSDEModelCntBase.isDEDRItemCntDirty() && (bl || pSDEModelCntBase.getDEDRItemCnt() != null)) {
            iDataObject.set(FIELD_DEDRITEMCNT, (Object)pSDEModelCntBase.getDEDRItemCnt());
        }
        if (pSDEModelCntBase.isDEDSCntDirty() && (bl || pSDEModelCntBase.getDEDSCnt() != null)) {
            iDataObject.set(FIELD_DEDSCNT, (Object)pSDEModelCntBase.getDEDSCnt());
        }
        if (pSDEModelCntBase.isDEFieldCntDirty() && (bl || pSDEModelCntBase.getDEFieldCnt() != null)) {
            iDataObject.set(FIELD_DEFIELDCNT, (Object)pSDEModelCntBase.getDEFieldCnt());
        }
        if (pSDEModelCntBase.isDEFormCntDirty() && (bl || pSDEModelCntBase.getDEFormCnt() != null)) {
            iDataObject.set(FIELD_DEFORMCNT, (Object)pSDEModelCntBase.getDEFormCnt());
        }
        if (pSDEModelCntBase.isDEGridCntDirty() && (bl || pSDEModelCntBase.getDEGridCnt() != null)) {
            iDataObject.set(FIELD_DEGRIDCNT, (Object)pSDEModelCntBase.getDEGridCnt());
        }
        if (pSDEModelCntBase.isDEListCntDirty() && (bl || pSDEModelCntBase.getDEListCnt() != null)) {
            iDataObject.set(FIELD_DELISTCNT, (Object)pSDEModelCntBase.getDEListCnt());
        }
        if (pSDEModelCntBase.isDELogicCntDirty() && (bl || pSDEModelCntBase.getDELogicCnt() != null)) {
            iDataObject.set(FIELD_DELOGICCNT, (Object)pSDEModelCntBase.getDELogicCnt());
        }
        if (pSDEModelCntBase.isDEMapViewCntDirty() && (bl || pSDEModelCntBase.getDEMapViewCnt() != null)) {
            iDataObject.set(FIELD_DEMAPVIEWCNT, (Object)pSDEModelCntBase.getDEMapViewCnt());
        }
        if (pSDEModelCntBase.isDEMSCntDirty() && (bl || pSDEModelCntBase.getDEMSCnt() != null)) {
            iDataObject.set(FIELD_DEMSCNT, (Object)pSDEModelCntBase.getDEMSCnt());
        }
        if (pSDEModelCntBase.isDEOPPrivCntDirty() && (bl || pSDEModelCntBase.getDEOPPrivCnt() != null)) {
            iDataObject.set(FIELD_DEOPPRIVCNT, (Object)pSDEModelCntBase.getDEOPPrivCnt());
        }
        if (pSDEModelCntBase.isDEPanelCntDirty() && (bl || pSDEModelCntBase.getDEPanelCnt() != null)) {
            iDataObject.set(FIELD_DEPANELCNT, (Object)pSDEModelCntBase.getDEPanelCnt());
        }
        if (pSDEModelCntBase.isDEPortletCntDirty() && (bl || pSDEModelCntBase.getDEPortletCnt() != null)) {
            iDataObject.set(FIELD_DEPORTLETCNT, (Object)pSDEModelCntBase.getDEPortletCnt());
        }
        if (pSDEModelCntBase.isDERCntDirty() && (bl || pSDEModelCntBase.getDERCnt() != null)) {
            iDataObject.set(FIELD_DERCNT, (Object)pSDEModelCntBase.getDERCnt());
        }
        if (pSDEModelCntBase.isDERCnt2Dirty() && (bl || pSDEModelCntBase.getDERCnt2() != null)) {
            iDataObject.set(FIELD_DERCNT2, (Object)pSDEModelCntBase.getDERCnt2());
        }
        if (pSDEModelCntBase.isDEReportCntDirty() && (bl || pSDEModelCntBase.getDEReportCnt() != null)) {
            iDataObject.set(FIELD_DEREPORTCNT, (Object)pSDEModelCntBase.getDEReportCnt());
        }
        if (pSDEModelCntBase.isDESearchBarCntDirty() && (bl || pSDEModelCntBase.getDESearchBarCnt() != null)) {
            iDataObject.set(FIELD_DESEARCHBARCNT, (Object)pSDEModelCntBase.getDESearchBarCnt());
        }
        if (pSDEModelCntBase.isDEToolbarCntDirty() && (bl || pSDEModelCntBase.getDEToolbarCnt() != null)) {
            iDataObject.set(FIELD_DETOOLBARCNT, (Object)pSDEModelCntBase.getDEToolbarCnt());
        }
        if (pSDEModelCntBase.isDETreeCntDirty() && (bl || pSDEModelCntBase.getDETreeCnt() != null)) {
            iDataObject.set(FIELD_DETREECNT, (Object)pSDEModelCntBase.getDETreeCnt());
        }
        if (pSDEModelCntBase.isDEUACntDirty() && (bl || pSDEModelCntBase.getDEUACnt() != null)) {
            iDataObject.set(FIELD_DEUACNT, (Object)pSDEModelCntBase.getDEUACnt());
        }
        if (pSDEModelCntBase.isDEUAGrpCntDirty() && (bl || pSDEModelCntBase.getDEUAGrpCnt() != null)) {
            iDataObject.set(FIELD_DEUAGRPCNT, (Object)pSDEModelCntBase.getDEUAGrpCnt());
        }
        if (pSDEModelCntBase.isDEWFCntDirty() && (bl || pSDEModelCntBase.getDEWFCnt() != null)) {
            iDataObject.set(FIELD_DEWFCNT, (Object)pSDEModelCntBase.getDEWFCnt());
        }
        if (pSDEModelCntBase.isIndexCntDirty() && (bl || pSDEModelCntBase.getIndexCnt() != null)) {
            iDataObject.set(FIELD_INDEXCNT, (Object)pSDEModelCntBase.getIndexCnt());
        }
        if (pSDEModelCntBase.isPSDEModelCntIdDirty() && (bl || pSDEModelCntBase.getPSDEModelCntId() != null)) {
            iDataObject.set(FIELD_PSDEMODELCNTID, (Object)pSDEModelCntBase.getPSDEModelCntId());
        }
        if (pSDEModelCntBase.isPSDEModelCntNameDirty() && (bl || pSDEModelCntBase.getPSDEModelCntName() != null)) {
            iDataObject.set(FIELD_PSDEMODELCNTNAME, (Object)pSDEModelCntBase.getPSDEModelCntName());
        }
        if (pSDEModelCntBase.isUpdateDateDirty() && (bl || pSDEModelCntBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEModelCntBase.getUpdateDate());
        }
        if (pSDEModelCntBase.isUpdateManDirty() && (bl || pSDEModelCntBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEModelCntBase.getUpdateMan());
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
        return PSDEModelCntBase.remove(this, n);
    }

    private static boolean remove(PSDEModelCntBase pSDEModelCntBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEModelCntBase.resetCLCnt();
                return true;
            }
            case 1: {
                pSDEModelCntBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEModelCntBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEModelCntBase.resetDEACCnt();
                return true;
            }
            case 4: {
                pSDEModelCntBase.resetDEActionCnt();
                return true;
            }
            case 5: {
                pSDEModelCntBase.resetDECalendarCnt();
                return true;
            }
            case 6: {
                pSDEModelCntBase.resetDEChartCnt();
                return true;
            }
            case 7: {
                pSDEModelCntBase.resetDEDashboardCnt();
                return true;
            }
            case 8: {
                pSDEModelCntBase.resetDEDataViewCnt();
                return true;
            }
            case 9: {
                pSDEModelCntBase.resetDEDQCnt();
                return true;
            }
            case 10: {
                pSDEModelCntBase.resetDEDRCnt();
                return true;
            }
            case 11: {
                pSDEModelCntBase.resetDEDRGrpCnt();
                return true;
            }
            case 12: {
                pSDEModelCntBase.resetDEDRItemCnt();
                return true;
            }
            case 13: {
                pSDEModelCntBase.resetDEDSCnt();
                return true;
            }
            case 14: {
                pSDEModelCntBase.resetDEFieldCnt();
                return true;
            }
            case 15: {
                pSDEModelCntBase.resetDEFormCnt();
                return true;
            }
            case 16: {
                pSDEModelCntBase.resetDEGridCnt();
                return true;
            }
            case 17: {
                pSDEModelCntBase.resetDEListCnt();
                return true;
            }
            case 18: {
                pSDEModelCntBase.resetDELogicCnt();
                return true;
            }
            case 19: {
                pSDEModelCntBase.resetDEMapViewCnt();
                return true;
            }
            case 20: {
                pSDEModelCntBase.resetDEMSCnt();
                return true;
            }
            case 21: {
                pSDEModelCntBase.resetDEOPPrivCnt();
                return true;
            }
            case 22: {
                pSDEModelCntBase.resetDEPanelCnt();
                return true;
            }
            case 23: {
                pSDEModelCntBase.resetDEPortletCnt();
                return true;
            }
            case 24: {
                pSDEModelCntBase.resetDERCnt();
                return true;
            }
            case 25: {
                pSDEModelCntBase.resetDERCnt2();
                return true;
            }
            case 26: {
                pSDEModelCntBase.resetDEReportCnt();
                return true;
            }
            case 27: {
                pSDEModelCntBase.resetDESearchBarCnt();
                return true;
            }
            case 28: {
                pSDEModelCntBase.resetDEToolbarCnt();
                return true;
            }
            case 29: {
                pSDEModelCntBase.resetDETreeCnt();
                return true;
            }
            case 30: {
                pSDEModelCntBase.resetDEUACnt();
                return true;
            }
            case 31: {
                pSDEModelCntBase.resetDEUAGrpCnt();
                return true;
            }
            case 32: {
                pSDEModelCntBase.resetDEWFCnt();
                return true;
            }
            case 33: {
                pSDEModelCntBase.resetIndexCnt();
                return true;
            }
            case 34: {
                pSDEModelCntBase.resetPSDEModelCntId();
                return true;
            }
            case 35: {
                pSDEModelCntBase.resetPSDEModelCntName();
                return true;
            }
            case 36: {
                pSDEModelCntBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSDEModelCntBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEModelCntBase getProxyEntity() {
        return this.proxyPSDEModelCntBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEModelCntBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEModelCntBase) {
            this.proxyPSDEModelCntBase = (PSDEModelCntBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEModelCntService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLCNT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEACCNT, 3);
        fieldIndexMap.put(FIELD_DEACTIONCNT, 4);
        fieldIndexMap.put(FIELD_DECALENDARCNT, 5);
        fieldIndexMap.put(FIELD_DECHARTCNT, 6);
        fieldIndexMap.put(FIELD_DEDASHBOARDCNT, 7);
        fieldIndexMap.put(FIELD_DEDATAVIEWCNT, 8);
        fieldIndexMap.put(FIELD_DEDQCNT, 9);
        fieldIndexMap.put(FIELD_DEDRCNT, 10);
        fieldIndexMap.put(FIELD_DEDRGRPCNT, 11);
        fieldIndexMap.put(FIELD_DEDRITEMCNT, 12);
        fieldIndexMap.put(FIELD_DEDSCNT, 13);
        fieldIndexMap.put(FIELD_DEFIELDCNT, 14);
        fieldIndexMap.put(FIELD_DEFORMCNT, 15);
        fieldIndexMap.put(FIELD_DEGRIDCNT, 16);
        fieldIndexMap.put(FIELD_DELISTCNT, 17);
        fieldIndexMap.put(FIELD_DELOGICCNT, 18);
        fieldIndexMap.put(FIELD_DEMAPVIEWCNT, 19);
        fieldIndexMap.put(FIELD_DEMSCNT, 20);
        fieldIndexMap.put(FIELD_DEOPPRIVCNT, 21);
        fieldIndexMap.put(FIELD_DEPANELCNT, 22);
        fieldIndexMap.put(FIELD_DEPORTLETCNT, 23);
        fieldIndexMap.put(FIELD_DERCNT, 24);
        fieldIndexMap.put(FIELD_DERCNT2, 25);
        fieldIndexMap.put(FIELD_DEREPORTCNT, 26);
        fieldIndexMap.put(FIELD_DESEARCHBARCNT, 27);
        fieldIndexMap.put(FIELD_DETOOLBARCNT, 28);
        fieldIndexMap.put(FIELD_DETREECNT, 29);
        fieldIndexMap.put(FIELD_DEUACNT, 30);
        fieldIndexMap.put(FIELD_DEUAGRPCNT, 31);
        fieldIndexMap.put(FIELD_DEWFCNT, 32);
        fieldIndexMap.put(FIELD_INDEXCNT, 33);
        fieldIndexMap.put(FIELD_PSDEMODELCNTID, 34);
        fieldIndexMap.put(FIELD_PSDEMODELCNTNAME, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
    }
}

