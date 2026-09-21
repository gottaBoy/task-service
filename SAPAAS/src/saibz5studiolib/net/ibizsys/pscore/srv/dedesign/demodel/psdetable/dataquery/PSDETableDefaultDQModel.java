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
package net.ibizsys.pscore.srv.dedesign.demodel.psdetable.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3A72AB3A-D6B5-4229-90D7-6521F9B62621", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`COLINHERITMODE`, t1.`COLUMNS`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDEID`, t1.`PSDENAME`, t1.`PSDETABLEID`, t1.`PSDETABLENAME`, t1.`PSSYSDBTABLEID`, t11.`PSSYSDBTABLENAME`, t1.`TABLETYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSDETABLE` t1  LEFT JOIN `T_SRFPSSYSDBTABLE` t11 ON t1.`PSSYSDBTABLEID` = t11.`PSSYSDBTABLEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="COLINHERITMODE", expression="t1.`COLINHERITMODE`", showorder=0), @DEDataQueryCodeExp(name="COLUMNS", expression="t1.`COLUMNS`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=5), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=6), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=7), @DEDataQueryCodeExp(name="PSDETABLEID", expression="t1.`PSDETABLEID`", showorder=8), @DEDataQueryCodeExp(name="PSDETABLENAME", expression="t1.`PSDETABLENAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSDBTABLEID", expression="t1.`PSSYSDBTABLEID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSDBTABLENAME", expression="t11.`PSSYSDBTABLENAME`", showorder=11), @DEDataQueryCodeExp(name="TABLETYPE", expression="t1.`TABLETYPE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.COLINHERITMODE, t1.COLUMNS, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSDEID, t1.PSDENAME, t1.PSDETABLEID, t1.PSDETABLENAME, t1.PSSYSDBTABLEID, t11.PSSYSDBTABLENAME, t1.TABLETYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSDETABLE t1  LEFT JOIN T_SRFPSSYSDBTABLE t11 ON t1.PSSYSDBTABLEID = t11.PSSYSDBTABLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="COLINHERITMODE", expression="t1.COLINHERITMODE", showorder=0), @DEDataQueryCodeExp(name="COLUMNS", expression="t1.COLUMNS", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=5), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=6), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=7), @DEDataQueryCodeExp(name="PSDETABLEID", expression="t1.PSDETABLEID", showorder=8), @DEDataQueryCodeExp(name="PSDETABLENAME", expression="t1.PSDETABLENAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSDBTABLEID", expression="t1.PSSYSDBTABLEID", showorder=10), @DEDataQueryCodeExp(name="PSSYSDBTABLENAME", expression="t11.PSSYSDBTABLENAME", showorder=11), @DEDataQueryCodeExp(name="TABLETYPE", expression="t1.TABLETYPE", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=19)}, conds={})})
public class PSDETableDefaultDQModel
extends DEDataQueryModelBase {
    public PSDETableDefaultDQModel() {
        this.initAnnotation(PSDETableDefaultDQModel.class);
    }
}

