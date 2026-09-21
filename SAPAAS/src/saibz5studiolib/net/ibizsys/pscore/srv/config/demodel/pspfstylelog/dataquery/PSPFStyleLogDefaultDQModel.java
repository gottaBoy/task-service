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
package net.ibizsys.pscore.srv.config.demodel.pspfstylelog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="263CFB10-72B7-462E-96EC-4CCF0DF2980C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSPFID`, t1.`PSPFNAME`, t1.`PSPFSTYLEID`, t1.`PSPFSTYLELOGID`, t1.`PSPFSTYLELOGNAME`, t1.`PSPFSTYLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFSTYLELOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CHANGELOG", expression="t1.`CHANGELOG`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=2), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.`PSPFNAME`", showorder=3), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.`PSPFSTYLEID`", showorder=4), @DEDataQueryCodeExp(name="PSPFSTYLELOGID", expression="t1.`PSPFSTYLELOGID`", showorder=5), @DEDataQueryCodeExp(name="PSPFSTYLELOGNAME", expression="t1.`PSPFSTYLELOGNAME`", showorder=6), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t1.`PSPFSTYLENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSPFID, t1.PSPFNAME, t1.PSPFSTYLEID, t1.PSPFSTYLELOGID, t1.PSPFSTYLELOGNAME, t1.PSPFSTYLENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFSTYLELOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CHANGELOG", expression="t1.CHANGELOG", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=2), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.PSPFNAME", showorder=3), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.PSPFSTYLEID", showorder=4), @DEDataQueryCodeExp(name="PSPFSTYLELOGID", expression="t1.PSPFSTYLELOGID", showorder=5), @DEDataQueryCodeExp(name="PSPFSTYLELOGNAME", expression="t1.PSPFSTYLELOGNAME", showorder=6), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t1.PSPFSTYLENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSPFStyleLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFStyleLogDefaultDQModel() {
        this.initAnnotation(PSPFStyleLogDefaultDQModel.class);
    }
}

