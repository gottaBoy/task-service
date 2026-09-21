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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuawizard3.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="0A5E9215-654E-412F-BE97-05A95EFE0EAB", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEVSERVERCOUNT`, t1.`DEVSLNCODENAME`, t1.`DEVSLNCOUNT`, t1.`DEVSLNNAME`, t1.`MSSQLINSTCOUNT`, t1.`MYSQL5INSTCOUNT`, t1.`ORAINSTCOUNT`, t1.`PSDSCONSOLEID`, t1.`PSUAWIZARD3ID`, t1.`PSUAWIZARD3NAME`, t1.`TOMCAT7ASCOUNT`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCOUNTPERSYS`, t1.`USERLOGINNAME`, t1.`USERNAME` FROM `T_SRFPSUAWIZARD3` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ACTIONRESULT", expression="t1.`ACTIONRESULT`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEVSERVERCOUNT", expression="t1.`DEVSERVERCOUNT`", showorder=2), @DEDataQueryCodeExp(name="DEVSLNCODENAME", expression="t1.`DEVSLNCODENAME`", showorder=3), @DEDataQueryCodeExp(name="DEVSLNCOUNT", expression="t1.`DEVSLNCOUNT`", showorder=4), @DEDataQueryCodeExp(name="DEVSLNNAME", expression="t1.`DEVSLNNAME`", showorder=5), @DEDataQueryCodeExp(name="MSSQLINSTCOUNT", expression="t1.`MSSQLINSTCOUNT`", showorder=6), @DEDataQueryCodeExp(name="MYSQL5INSTCOUNT", expression="t1.`MYSQL5INSTCOUNT`", showorder=7), @DEDataQueryCodeExp(name="ORAINSTCOUNT", expression="t1.`ORAINSTCOUNT`", showorder=8), @DEDataQueryCodeExp(name="PSDSCONSOLEID", expression="t1.`PSDSCONSOLEID`", showorder=9), @DEDataQueryCodeExp(name="PSUAWIZARD3ID", expression="t1.`PSUAWIZARD3ID`", showorder=10), @DEDataQueryCodeExp(name="PSUAWIZARD3NAME", expression="t1.`PSUAWIZARD3NAME`", showorder=11), @DEDataQueryCodeExp(name="TOMCAT7ASCOUNT", expression="t1.`TOMCAT7ASCOUNT`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="USERCOUNTPERSYS", expression="t1.`USERCOUNTPERSYS`", showorder=15), @DEDataQueryCodeExp(name="USERLOGINNAME", expression="t1.`USERLOGINNAME`", showorder=16), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEVSERVERCOUNT, t1.DEVSLNCODENAME, t1.DEVSLNCOUNT, t1.DEVSLNNAME, t1.MSSQLINSTCOUNT, t1.MYSQL5INSTCOUNT, t1.ORAINSTCOUNT, t1.PSDSCONSOLEID, t1.PSUAWIZARD3ID, t1.PSUAWIZARD3NAME, t1.TOMCAT7ASCOUNT, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCOUNTPERSYS, t1.USERLOGINNAME, t1.USERNAME FROM T_SRFPSUAWIZARD3 t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ACTIONRESULT", expression="t1.ACTIONRESULT", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEVSERVERCOUNT", expression="t1.DEVSERVERCOUNT", showorder=2), @DEDataQueryCodeExp(name="DEVSLNCODENAME", expression="t1.DEVSLNCODENAME", showorder=3), @DEDataQueryCodeExp(name="DEVSLNCOUNT", expression="t1.DEVSLNCOUNT", showorder=4), @DEDataQueryCodeExp(name="DEVSLNNAME", expression="t1.DEVSLNNAME", showorder=5), @DEDataQueryCodeExp(name="MSSQLINSTCOUNT", expression="t1.MSSQLINSTCOUNT", showorder=6), @DEDataQueryCodeExp(name="MYSQL5INSTCOUNT", expression="t1.MYSQL5INSTCOUNT", showorder=7), @DEDataQueryCodeExp(name="ORAINSTCOUNT", expression="t1.ORAINSTCOUNT", showorder=8), @DEDataQueryCodeExp(name="PSDSCONSOLEID", expression="t1.PSDSCONSOLEID", showorder=9), @DEDataQueryCodeExp(name="PSUAWIZARD3ID", expression="t1.PSUAWIZARD3ID", showorder=10), @DEDataQueryCodeExp(name="PSUAWIZARD3NAME", expression="t1.PSUAWIZARD3NAME", showorder=11), @DEDataQueryCodeExp(name="TOMCAT7ASCOUNT", expression="t1.TOMCAT7ASCOUNT", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="USERCOUNTPERSYS", expression="t1.USERCOUNTPERSYS", showorder=15), @DEDataQueryCodeExp(name="USERLOGINNAME", expression="t1.USERLOGINNAME", showorder=16), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=17)}, conds={})})
public class PSUAWizard3DefaultDQModel
extends DEDataQueryModelBase {
    public PSUAWizard3DefaultDQModel() {
        this.initAnnotation(PSUAWizard3DefaultDQModel.class);
    }
}

