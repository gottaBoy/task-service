/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfviewtype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="83CEE557-132C-4458-8B32-1F2A5A45AAA2", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTROLLERCLASS`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`MODELCLASS`, t1.`PSPFID`, t11.`PSPFNAME`, t1.`PSPFSTYLEID`, t21.`PSPFSTYLENAME`, t1.`PSPFVIEWTYPEID`, t1.`PSPFVIEWTYPENAME`, t1.`PSVIEWTYPEID`, t31.`PSVIEWTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VIEWCLASS` FROM `T_SRFPSPFVIEWTYPE` t1  LEFT JOIN T_SRFPSPF t11 ON t1.PSPFID = t11.PSPFID  LEFT JOIN T_SRFPSPFSTYLE t21 ON t1.PSPFSTYLEID = t21.PSPFSTYLEID  LEFT JOIN T_SRFPSVIEWTYPE t31 ON t1.PSVIEWTYPEID = t31.PSVIEWTYPEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="VIEWDESC", expression="t1.`VIEWDESC`", showorder=-1), @DEDataQueryCodeExp(name="CONTROLLERCLASS", expression="t1.`CONTROLLERCLASS`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="MODELCLASS", expression="t1.`MODELCLASS`", showorder=4), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=5), @DEDataQueryCodeExp(name="PSPFNAME", expression="t11.`PSPFNAME`", showorder=6), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.`PSPFSTYLEID`", showorder=7), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t21.`PSPFSTYLENAME`", showorder=8), @DEDataQueryCodeExp(name="PSPFVIEWTYPEID", expression="t1.`PSPFVIEWTYPEID`", showorder=9), @DEDataQueryCodeExp(name="PSPFVIEWTYPENAME", expression="t1.`PSPFVIEWTYPENAME`", showorder=10), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.`PSVIEWTYPEID`", showorder=11), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t31.`PSVIEWTYPENAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="VIEWCLASS", expression="t1.`VIEWCLASS`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTROLLERCLASS, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.MODELCLASS, t1.PSPFID, t11.PSPFNAME, t1.PSPFSTYLEID, t21.PSPFSTYLENAME, t1.PSPFVIEWTYPEID, t1.PSPFVIEWTYPENAME, t1.PSVIEWTYPEID, t31.PSVIEWTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VIEWCLASS FROM T_SRFPSPFVIEWTYPE t1  LEFT JOIN T_SRFPSPF t11 ON t1.PSPFID = t11.PSPFID  LEFT JOIN T_SRFPSPFSTYLE t21 ON t1.PSPFSTYLEID = t21.PSPFSTYLEID  LEFT JOIN T_SRFPSVIEWTYPE t31 ON t1.PSVIEWTYPEID = t31.PSVIEWTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="VIEWDESC", expression="t1.VIEWDESC", showorder=-1), @DEDataQueryCodeExp(name="CONTROLLERCLASS", expression="t1.CONTROLLERCLASS", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="MODELCLASS", expression="t1.MODELCLASS", showorder=4), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=5), @DEDataQueryCodeExp(name="PSPFNAME", expression="t11.PSPFNAME", showorder=6), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.PSPFSTYLEID", showorder=7), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t21.PSPFSTYLENAME", showorder=8), @DEDataQueryCodeExp(name="PSPFVIEWTYPEID", expression="t1.PSPFVIEWTYPEID", showorder=9), @DEDataQueryCodeExp(name="PSPFVIEWTYPENAME", expression="t1.PSPFVIEWTYPENAME", showorder=10), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.PSVIEWTYPEID", showorder=11), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t31.PSVIEWTYPENAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="VIEWCLASS", expression="t1.VIEWCLASS", showorder=15)}, conds={})})
public class PSPFViewTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFViewTypeDefaultDQModel() {
        this.initAnnotation(PSPFViewTypeDefaultDQModel.class);
    }
}

