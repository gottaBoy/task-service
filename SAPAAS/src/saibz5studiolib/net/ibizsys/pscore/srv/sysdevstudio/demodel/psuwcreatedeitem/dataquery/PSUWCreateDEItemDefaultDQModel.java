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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwcreatedeitem.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8514C243-9E24-440F-984E-79DD1B2B17E4", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ITEMPARAM`, t1.`ITEMPARAM2`, t1.`ITEMPARAM3`, t1.`ITEMPARAM4`, t1.`NEWCODENAME`, t1.`NEWDELOGICNAME`, t1.`NEWDENAME`, t1.`NEWDETABLENAME`, t1.`NEWDEVIEWNAME`, t1.`PSDEID`, t1.`PSDENAME`, t1.`PSDYNAINSTID`, t1.`PSUWCREATEDEID`, t1.`PSUWCREATEDEITEMID`, t1.`PSUWCREATEDEITEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSUWCREATEDEITEM` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ITEMPARAM", expression="t1.`ITEMPARAM`", showorder=3), @DEDataQueryCodeExp(name="ITEMPARAM2", expression="t1.`ITEMPARAM2`", showorder=4), @DEDataQueryCodeExp(name="ITEMPARAM3", expression="t1.`ITEMPARAM3`", showorder=5), @DEDataQueryCodeExp(name="ITEMPARAM4", expression="t1.`ITEMPARAM4`", showorder=6), @DEDataQueryCodeExp(name="NEWCODENAME", expression="t1.`NEWCODENAME`", showorder=7), @DEDataQueryCodeExp(name="NEWDELOGICNAME", expression="t1.`NEWDELOGICNAME`", showorder=8), @DEDataQueryCodeExp(name="NEWDENAME", expression="t1.`NEWDENAME`", showorder=9), @DEDataQueryCodeExp(name="NEWDETABLENAME", expression="t1.`NEWDETABLENAME`", showorder=10), @DEDataQueryCodeExp(name="NEWDEVIEWNAME", expression="t1.`NEWDEVIEWNAME`", showorder=11), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=12), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=13), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=14), @DEDataQueryCodeExp(name="PSUWCREATEDEID", expression="t1.`PSUWCREATEDEID`", showorder=15), @DEDataQueryCodeExp(name="PSUWCREATEDEITEMID", expression="t1.`PSUWCREATEDEITEMID`", showorder=16), @DEDataQueryCodeExp(name="PSUWCREATEDEITEMNAME", expression="t1.`PSUWCREATEDEITEMNAME`", showorder=17), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=18), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.ITEMPARAM, t1.ITEMPARAM2, t1.ITEMPARAM3, t1.ITEMPARAM4, t1.NEWCODENAME, t1.NEWDELOGICNAME, t1.NEWDENAME, t1.NEWDETABLENAME, t1.NEWDEVIEWNAME, t1.PSDEID, t1.PSDENAME, t1.PSDYNAINSTID, t1.PSUWCREATEDEID, t1.PSUWCREATEDEITEMID, t1.PSUWCREATEDEITEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSUWCREATEDEITEM t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ITEMPARAM", expression="t1.ITEMPARAM", showorder=3), @DEDataQueryCodeExp(name="ITEMPARAM2", expression="t1.ITEMPARAM2", showorder=4), @DEDataQueryCodeExp(name="ITEMPARAM3", expression="t1.ITEMPARAM3", showorder=5), @DEDataQueryCodeExp(name="ITEMPARAM4", expression="t1.ITEMPARAM4", showorder=6), @DEDataQueryCodeExp(name="NEWCODENAME", expression="t1.NEWCODENAME", showorder=7), @DEDataQueryCodeExp(name="NEWDELOGICNAME", expression="t1.NEWDELOGICNAME", showorder=8), @DEDataQueryCodeExp(name="NEWDENAME", expression="t1.NEWDENAME", showorder=9), @DEDataQueryCodeExp(name="NEWDETABLENAME", expression="t1.NEWDETABLENAME", showorder=10), @DEDataQueryCodeExp(name="NEWDEVIEWNAME", expression="t1.NEWDEVIEWNAME", showorder=11), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=12), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=13), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=14), @DEDataQueryCodeExp(name="PSUWCREATEDEID", expression="t1.PSUWCREATEDEID", showorder=15), @DEDataQueryCodeExp(name="PSUWCREATEDEITEMID", expression="t1.PSUWCREATEDEITEMID", showorder=16), @DEDataQueryCodeExp(name="PSUWCREATEDEITEMNAME", expression="t1.PSUWCREATEDEITEMNAME", showorder=17), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=18), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=19)}, conds={})})
public class PSUWCreateDEItemDefaultDQModel
extends DEDataQueryModelBase {
    public PSUWCreateDEItemDefaultDQModel() {
        this.initAnnotation(PSUWCreateDEItemDefaultDQModel.class);
    }
}

