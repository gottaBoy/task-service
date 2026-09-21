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
package net.ibizsys.pscore.srv.appdesign.demodel.psdcserverstate.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A63E6413-B30D-48FF-B7CA-0882709C570D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DISKUSAGE`, t1.`MEMUSAGE`, t1.`PSDCSERVERSTATEID`, t1.`PSDCSERVERSTATENAME`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCSERVERSTATE` t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DISKUSAGE", expression="t1.`DISKUSAGE`", showorder=2), @DEDataQueryCodeExp(name="MEMUSAGE", expression="t1.`MEMUSAGE`", showorder=3), @DEDataQueryCodeExp(name="PSDCSERVERSTATEID", expression="t1.`PSDCSERVERSTATEID`", showorder=4), @DEDataQueryCodeExp(name="PSDCSERVERSTATENAME", expression="t1.`PSDCSERVERSTATENAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DISKUSAGE, t1.MEMUSAGE, t1.PSDCSERVERSTATEID, t1.PSDCSERVERSTATENAME, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCSERVERSTATE t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DISKUSAGE", expression="t1.DISKUSAGE", showorder=2), @DEDataQueryCodeExp(name="MEMUSAGE", expression="t1.MEMUSAGE", showorder=3), @DEDataQueryCodeExp(name="PSDCSERVERSTATEID", expression="t1.PSDCSERVERSTATEID", showorder=4), @DEDataQueryCodeExp(name="PSDCSERVERSTATENAME", expression="t1.PSDCSERVERSTATENAME", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDCServerStateDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCServerStateDefaultDQModel() {
        this.initAnnotation(PSDCServerStateDefaultDQModel.class);
    }
}

