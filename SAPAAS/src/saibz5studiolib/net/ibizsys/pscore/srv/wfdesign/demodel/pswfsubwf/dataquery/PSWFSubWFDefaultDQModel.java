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
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfsubwf.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="65E516B9-31F1-4953-8357-3575A028472D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DYNAMODELFLAG`, t1.`MEMO`, t1.`PSDYNAINSTID`, t1.`PSWFID`, t11.`PSWORKFLOWNAME` AS `PSWFNAME`, t1.`PSWFSUBWFID`, t1.`PSWFSUBWFNAME`, t1.`SUBPSWFID`, t21.`PSWORKFLOWNAME` AS `SUBPSWFNAME`, t1.`SUBPSWFVERID`, t31.`PSWFVERSIONNAME` AS `SUBPSWFVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSWFSUBWF` t1  LEFT JOIN T_SRFPSWORKFLOW t11 ON t1.PSWFID = t11.PSWORKFLOWID  LEFT JOIN T_SRFPSWORKFLOW t21 ON t1.SUBPSWFID = t21.PSWORKFLOWID  LEFT JOIN T_SRFPSWFVERSION t31 ON t1.SUBPSWFVERID = t31.PSWFVERSIONID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ENABLE", expression="t1.`ENABLE`", showorder=-1), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DYNAMODELFLAG", expression="t1.`DYNAMODELFLAG`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=5), @DEDataQueryCodeExp(name="PSWFID", expression="t1.`PSWFID`", showorder=6), @DEDataQueryCodeExp(name="PSWFNAME", expression="t11.`PSWORKFLOWNAME`", showorder=7), @DEDataQueryCodeExp(name="PSWFSUBWFID", expression="t1.`PSWFSUBWFID`", showorder=8), @DEDataQueryCodeExp(name="PSWFSUBWFNAME", expression="t1.`PSWFSUBWFNAME`", showorder=9), @DEDataQueryCodeExp(name="SUBPSWFID", expression="t1.`SUBPSWFID`", showorder=10), @DEDataQueryCodeExp(name="SUBPSWFNAME", expression="t21.`PSWORKFLOWNAME`", showorder=11), @DEDataQueryCodeExp(name="SUBPSWFVERID", expression="t1.`SUBPSWFVERID`", showorder=12), @DEDataQueryCodeExp(name="SUBPSWFVERNAME", expression="t31.`PSWFVERSIONNAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.DYNAMODELFLAG, t1.MEMO, t1.PSDYNAINSTID, t1.PSWFID, t11.PSWORKFLOWNAME AS PSWFNAME, t1.PSWFSUBWFID, t1.PSWFSUBWFNAME, t1.SUBPSWFID, t21.PSWORKFLOWNAME AS SUBPSWFNAME, t1.SUBPSWFVERID, t31.PSWFVERSIONNAME AS SUBPSWFVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSWFSUBWF t1  LEFT JOIN T_SRFPSWORKFLOW t11 ON t1.PSWFID = t11.PSWORKFLOWID  LEFT JOIN T_SRFPSWORKFLOW t21 ON t1.SUBPSWFID = t21.PSWORKFLOWID  LEFT JOIN T_SRFPSWFVERSION t31 ON t1.SUBPSWFVERID = t31.PSWFVERSIONID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ENABLE", expression="t1.ENABLE", showorder=-1), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DYNAMODELFLAG", expression="t1.DYNAMODELFLAG", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=5), @DEDataQueryCodeExp(name="PSWFID", expression="t1.PSWFID", showorder=6), @DEDataQueryCodeExp(name="PSWFNAME", expression="t11.PSWORKFLOWNAME", showorder=7), @DEDataQueryCodeExp(name="PSWFSUBWFID", expression="t1.PSWFSUBWFID", showorder=8), @DEDataQueryCodeExp(name="PSWFSUBWFNAME", expression="t1.PSWFSUBWFNAME", showorder=9), @DEDataQueryCodeExp(name="SUBPSWFID", expression="t1.SUBPSWFID", showorder=10), @DEDataQueryCodeExp(name="SUBPSWFNAME", expression="t21.PSWORKFLOWNAME", showorder=11), @DEDataQueryCodeExp(name="SUBPSWFVERID", expression="t1.SUBPSWFVERID", showorder=12), @DEDataQueryCodeExp(name="SUBPSWFVERNAME", expression="t31.PSWFVERSIONNAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSWFSubWFDefaultDQModel
extends DEDataQueryModelBase {
    public PSWFSubWFDefaultDQModel() {
        this.initAnnotation(PSWFSubWFDefaultDQModel.class);
    }
}

