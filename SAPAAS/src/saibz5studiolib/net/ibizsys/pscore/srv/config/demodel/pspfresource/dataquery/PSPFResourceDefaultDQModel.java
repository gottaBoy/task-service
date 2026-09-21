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
package net.ibizsys.pscore.srv.config.demodel.pspfresource.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="302C5198-EE2B-4313-9405-7EB9856FE42D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`PSPFID`, t21.`PSPFNAME`, t1.`PSPFRESOURCEID`, t1.`PSPFRESOURCENAME`, t1.`REFRESHVER`, t1.`TEMPLSTATE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`V2FOLDER`, t1.`V2GITPATH`, t1.`VERSTR` FROM `T_SRFPSPFRESOURCE` t1  LEFT JOIN `T_SRFPSDEVCENTER` t11 ON t1.`PSDEVCENTERID` = t11.`PSDEVCENTERID`  LEFT JOIN `T_SRFPSPF` t21 ON t1.`PSPFID` = t21.`PSPFID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TEMPLINFO", expression="t1.`TEMPLINFO`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=4), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=5), @DEDataQueryCodeExp(name="PSPFNAME", expression="t21.`PSPFNAME`", showorder=6), @DEDataQueryCodeExp(name="PSPFRESOURCEID", expression="t1.`PSPFRESOURCEID`", showorder=7), @DEDataQueryCodeExp(name="PSPFRESOURCENAME", expression="t1.`PSPFRESOURCENAME`", showorder=8), @DEDataQueryCodeExp(name="REFRESHVER", expression="t1.`REFRESHVER`", showorder=9), @DEDataQueryCodeExp(name="TEMPLSTATE", expression="t1.`TEMPLSTATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="V2FOLDER", expression="t1.`V2FOLDER`", showorder=13), @DEDataQueryCodeExp(name="V2GITPATH", expression="t1.`V2GITPATH`", showorder=14), @DEDataQueryCodeExp(name="VERSTR", expression="t1.`VERSTR`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.PSPFID, t21.PSPFNAME, t1.PSPFRESOURCEID, t1.PSPFRESOURCENAME, t1.REFRESHVER, t1.TEMPLSTATE, t1.UPDATEDATE, t1.UPDATEMAN, t1.V2FOLDER, t1.V2GITPATH, t1.VERSTR FROM T_SRFPSPFRESOURCE t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  LEFT JOIN T_SRFPSPF t21 ON t1.PSPFID = t21.PSPFID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TEMPLINFO", expression="t1.TEMPLINFO", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=4), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=5), @DEDataQueryCodeExp(name="PSPFNAME", expression="t21.PSPFNAME", showorder=6), @DEDataQueryCodeExp(name="PSPFRESOURCEID", expression="t1.PSPFRESOURCEID", showorder=7), @DEDataQueryCodeExp(name="PSPFRESOURCENAME", expression="t1.PSPFRESOURCENAME", showorder=8), @DEDataQueryCodeExp(name="REFRESHVER", expression="t1.REFRESHVER", showorder=9), @DEDataQueryCodeExp(name="TEMPLSTATE", expression="t1.TEMPLSTATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="V2FOLDER", expression="t1.V2FOLDER", showorder=13), @DEDataQueryCodeExp(name="V2GITPATH", expression="t1.V2GITPATH", showorder=14), @DEDataQueryCodeExp(name="VERSTR", expression="t1.VERSTR", showorder=15)}, conds={})})
public class PSPFResourceDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFResourceDefaultDQModel() {
        this.initAnnotation(PSPFResourceDefaultDQModel.class);
    }
}

