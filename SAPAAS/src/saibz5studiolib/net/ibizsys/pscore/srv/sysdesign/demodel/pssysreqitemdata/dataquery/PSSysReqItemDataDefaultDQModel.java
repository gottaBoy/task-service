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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysreqitemdata.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5360CE18-2D3C-4153-A406-9341B14DDE2B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`AIBUILDSTATE`, t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ORDERVALUE`, t1.`PSSYSREQITEMDATAID`, t1.`PSSYSREQITEMDATANAME`, t1.`PSSYSREQITEMID`, t11.`PSSYSREQITEMNAME`, t1.`SUBJECT`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSSYSREQITEMDATA` t1  LEFT JOIN `T_SRFPSSYSREQITEM` t11 ON t1.`PSSYSREQITEMID` = t11.`PSSYSREQITEMID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="AICHOICES", expression="t1.`AICHOICES`", showorder=-1), @DEDataQueryCodeExp(name="AIPROMPT", expression="t1.`AIPROMPT`", showorder=-1), @DEDataQueryCodeExp(name="AIBUILDSTATE", expression="t1.`AIBUILDSTATE`", showorder=0), @DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PSSYSREQITEMDATAID", expression="t1.`PSSYSREQITEMDATAID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSREQITEMDATANAME", expression="t1.`PSSYSREQITEMDATANAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSREQITEMID", expression="t1.`PSSYSREQITEMID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSREQITEMNAME", expression="t11.`PSSYSREQITEMNAME`", showorder=8), @DEDataQueryCodeExp(name="SUBJECT", expression="t1.`SUBJECT`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.AIBUILDSTATE, t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.ORDERVALUE, t1.PSSYSREQITEMDATAID, t1.PSSYSREQITEMDATANAME, t1.PSSYSREQITEMID, t11.PSSYSREQITEMNAME, t1.SUBJECT, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSSYSREQITEMDATA t1  LEFT JOIN T_SRFPSSYSREQITEM t11 ON t1.PSSYSREQITEMID = t11.PSSYSREQITEMID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="AICHOICES", expression="t1.AICHOICES", showorder=-1), @DEDataQueryCodeExp(name="AIPROMPT", expression="t1.AIPROMPT", showorder=-1), @DEDataQueryCodeExp(name="AIBUILDSTATE", expression="t1.AIBUILDSTATE", showorder=0), @DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PSSYSREQITEMDATAID", expression="t1.PSSYSREQITEMDATAID", showorder=5), @DEDataQueryCodeExp(name="PSSYSREQITEMDATANAME", expression="t1.PSSYSREQITEMDATANAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSREQITEMID", expression="t1.PSSYSREQITEMID", showorder=7), @DEDataQueryCodeExp(name="PSSYSREQITEMNAME", expression="t11.PSSYSREQITEMNAME", showorder=8), @DEDataQueryCodeExp(name="SUBJECT", expression="t1.SUBJECT", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=16)}, conds={})})
public class PSSysReqItemDataDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysReqItemDataDefaultDQModel() {
        this.initAnnotation(PSSysReqItemDataDefaultDQModel.class);
    }
}

