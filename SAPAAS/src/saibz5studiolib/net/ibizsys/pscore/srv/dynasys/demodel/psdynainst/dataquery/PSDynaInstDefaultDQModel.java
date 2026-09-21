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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynainst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="959851AA-B7DC-4EDA-87E8-095E73A437C8", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INSTMODE`, t1.`INSTVER`, t1.`MEMO`, t1.`PPSDYNAINSTID`, t1.`PPSDYNAINSTNAME`, t1.`PSDEVSLNSYSID`, t1.`PSDYNAINSTID`, t1.`PSDYNAINSTNAME`, t1.`PSDYNASYSID`, t1.`PSDYNASYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`VALIDFLAG` FROM `T_SRFPSDYNAINST` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="INSTMODE", expression="t1.`INSTMODE`", showorder=2), @DEDataQueryCodeExp(name="INSTVER", expression="t1.`INSTVER`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PPSDYNAINSTID", expression="t1.`PPSDYNAINSTID`", showorder=5), @DEDataQueryCodeExp(name="PPSDYNAINSTNAME", expression="t1.`PPSDYNAINSTNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=7), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=8), @DEDataQueryCodeExp(name="PSDYNAINSTNAME", expression="t1.`PSDYNAINSTNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDYNASYSID", expression="t1.`PSDYNASYSID`", showorder=10), @DEDataQueryCodeExp(name="PSDYNASYSNAME", expression="t1.`PSDYNASYSNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.INSTMODE, t1.INSTVER, t1.MEMO, t1.PPSDYNAINSTID, t1.PPSDYNAINSTNAME, t1.PSDEVSLNSYSID, t1.PSDYNAINSTID, t1.PSDYNAINSTNAME, t1.PSDYNASYSID, t1.PSDYNASYSNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.VALIDFLAG FROM T_SRFPSDYNAINST t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="INSTMODE", expression="t1.INSTMODE", showorder=2), @DEDataQueryCodeExp(name="INSTVER", expression="t1.INSTVER", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PPSDYNAINSTID", expression="t1.PPSDYNAINSTID", showorder=5), @DEDataQueryCodeExp(name="PPSDYNAINSTNAME", expression="t1.PPSDYNAINSTNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=7), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=8), @DEDataQueryCodeExp(name="PSDYNAINSTNAME", expression="t1.PSDYNAINSTNAME", showorder=9), @DEDataQueryCodeExp(name="PSDYNASYSID", expression="t1.PSDYNASYSID", showorder=10), @DEDataQueryCodeExp(name="PSDYNASYSNAME", expression="t1.PSDYNASYSNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={})})
public class PSDynaInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaInstDefaultDQModel() {
        this.initAnnotation(PSDynaInstDefaultDQModel.class);
    }
}

