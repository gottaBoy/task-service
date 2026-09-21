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
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpdcengineinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5E557625-1C6A-49AD-9CE6-B22CCDFABC98", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`PSWPDCENGINEINSTID`, t1.`PSWPDCENGINEINSTNAME`, t1.`PSWPENGINEINSTID`, t21.`PSWPENGINEINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSWPDCENGINEINST` t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  LEFT JOIN T_SRFPSWPENGINEINST t21 ON t1.PSWPENGINEINSTID = t21.PSWPENGINEINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=3), @DEDataQueryCodeExp(name="PSWPDCENGINEINSTID", expression="t1.`PSWPDCENGINEINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSWPDCENGINEINSTNAME", expression="t1.`PSWPDCENGINEINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSWPENGINEINSTID", expression="t1.`PSWPENGINEINSTID`", showorder=6), @DEDataQueryCodeExp(name="PSWPENGINEINSTNAME", expression="t21.`PSWPENGINEINSTNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.PSWPDCENGINEINSTID, t1.PSWPDCENGINEINSTNAME, t1.PSWPENGINEINSTID, t21.PSWPENGINEINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSWPDCENGINEINST t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  LEFT JOIN T_SRFPSWPENGINEINST t21 ON t1.PSWPENGINEINSTID = t21.PSWPENGINEINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=3), @DEDataQueryCodeExp(name="PSWPDCENGINEINSTID", expression="t1.PSWPDCENGINEINSTID", showorder=4), @DEDataQueryCodeExp(name="PSWPDCENGINEINSTNAME", expression="t1.PSWPDCENGINEINSTNAME", showorder=5), @DEDataQueryCodeExp(name="PSWPENGINEINSTID", expression="t1.PSWPENGINEINSTID", showorder=6), @DEDataQueryCodeExp(name="PSWPENGINEINSTNAME", expression="t21.PSWPENGINEINSTNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSWPDCEngineInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSWPDCEngineInstDefaultDQModel() {
        this.initAnnotation(PSWPDCEngineInstDefaultDQModel.class);
    }
}

