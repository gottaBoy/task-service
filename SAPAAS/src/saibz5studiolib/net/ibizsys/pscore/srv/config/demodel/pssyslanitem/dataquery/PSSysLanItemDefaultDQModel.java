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
package net.ibizsys.pscore.srv.config.demodel.pssyslanitem.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="549ABD40-E0E5-40A8-BBC9-79F9EF63A5D2", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSLANGUAGEID`, t11.`PSLANGUAGENAME`, t1.`PSSYSLANITEMID`, t1.`PSSYSLANITEMNAME`, t1.`PSSYSLANRESID`, t21.`PSSYSLANRESNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSLANITEM` t1  LEFT JOIN T_SRFPSLANGUAGE t11 ON t1.PSLANGUAGEID = t11.PSLANGUAGEID  LEFT JOIN T_SRFPSSYSLANRES t21 ON t1.PSSYSLANRESID = t21.PSSYSLANRESID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT2", expression="t1.`CONTENT2`", showorder=-1), @DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSLANGUAGEID", expression="t1.`PSLANGUAGEID`", showorder=4), @DEDataQueryCodeExp(name="PSLANGUAGENAME", expression="t11.`PSLANGUAGENAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSLANITEMID", expression="t1.`PSSYSLANITEMID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSLANITEMNAME", expression="t1.`PSSYSLANITEMNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSLANRESID", expression="t1.`PSSYSLANRESID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSLANRESNAME", expression="t21.`PSSYSLANRESNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSLANGUAGEID, t11.PSLANGUAGENAME, t1.PSSYSLANITEMID, t1.PSSYSLANITEMNAME, t1.PSSYSLANRESID, t21.PSSYSLANRESNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSLANITEM t1  LEFT JOIN T_SRFPSLANGUAGE t11 ON t1.PSLANGUAGEID = t11.PSLANGUAGEID  LEFT JOIN T_SRFPSSYSLANRES t21 ON t1.PSSYSLANRESID = t21.PSSYSLANRESID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT2", expression="t1.CONTENT2", showorder=-1), @DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSLANGUAGEID", expression="t1.PSLANGUAGEID", showorder=4), @DEDataQueryCodeExp(name="PSLANGUAGENAME", expression="t11.PSLANGUAGENAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSLANITEMID", expression="t1.PSSYSLANITEMID", showorder=6), @DEDataQueryCodeExp(name="PSSYSLANITEMNAME", expression="t1.PSSYSLANITEMNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSLANRESID", expression="t1.PSSYSLANRESID", showorder=8), @DEDataQueryCodeExp(name="PSSYSLANRESNAME", expression="t21.PSSYSLANRESNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSSysLanItemDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysLanItemDefaultDQModel() {
        this.initAnnotation(PSSysLanItemDefaultDQModel.class);
    }
}

