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
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpdcworkflow.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D9AE8127-5F75-4F45-8AF1-D5BB8A66803E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`PSWPDCWORKFLOWID`, t1.`PSWPDCWORKFLOWNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`WFSN` FROM `T_SRFPSWPDCWORKFLOW` t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=3), @DEDataQueryCodeExp(name="PSWPDCWORKFLOWID", expression="t1.`PSWPDCWORKFLOWID`", showorder=4), @DEDataQueryCodeExp(name="PSWPDCWORKFLOWNAME", expression="t1.`PSWPDCWORKFLOWNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="WFSN", expression="t1.`WFSN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.PSWPDCWORKFLOWID, t1.PSWPDCWORKFLOWNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFSN FROM T_SRFPSWPDCWORKFLOW t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=3), @DEDataQueryCodeExp(name="PSWPDCWORKFLOWID", expression="t1.PSWPDCWORKFLOWID", showorder=4), @DEDataQueryCodeExp(name="PSWPDCWORKFLOWNAME", expression="t1.PSWPDCWORKFLOWNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="WFSN", expression="t1.WFSN", showorder=8)}, conds={})})
public class PSWPDCWorkflowDefaultDQModel
extends DEDataQueryModelBase {
    public PSWPDCWorkflowDefaultDQModel() {
        this.initAnnotation(PSWPDCWorkflowDefaultDQModel.class);
    }
}

