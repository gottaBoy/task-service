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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psmodelimport.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="0364F7FB-F428-4FAD-97E0-D04BFBEF83BE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DYNAMODELFLAG`, t1.`IMPORTMODE`, t1.`MEMO`, t1.`MODELFILE`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSDYNAINSTID`, t1.`PSMODELIMPORTID`, t1.`PSMODELIMPORTNAME`, t1.`PSOBJID`, t1.`PSOBJNAME`, t1.`PSOBJTYPE`, t1.`PSOBJTYPENAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELIMPORT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DYNAMODELFLAG", expression="t1.`DYNAMODELFLAG`", showorder=2), @DEDataQueryCodeExp(name="IMPORTMODE", expression="t1.`IMPORTMODE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="MODELFILE", expression="t1.`MODELFILE`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=8), @DEDataQueryCodeExp(name="PSMODELIMPORTID", expression="t1.`PSMODELIMPORTID`", showorder=9), @DEDataQueryCodeExp(name="PSMODELIMPORTNAME", expression="t1.`PSMODELIMPORTNAME`", showorder=10), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.`PSOBJID`", showorder=11), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.`PSOBJNAME`", showorder=12), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.`PSOBJTYPE`", showorder=13), @DEDataQueryCodeExp(name="PSOBJTYPENAME", expression="t1.`PSOBJTYPENAME`", showorder=14), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=15), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DYNAMODELFLAG, t1.IMPORTMODE, t1.MEMO, t1.MODELFILE, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSDYNAINSTID, t1.PSMODELIMPORTID, t1.PSMODELIMPORTNAME, t1.PSOBJID, t1.PSOBJNAME, t1.PSOBJTYPE, t1.PSOBJTYPENAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELIMPORT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DYNAMODELFLAG", expression="t1.DYNAMODELFLAG", showorder=2), @DEDataQueryCodeExp(name="IMPORTMODE", expression="t1.IMPORTMODE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="MODELFILE", expression="t1.MODELFILE", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=7), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=8), @DEDataQueryCodeExp(name="PSMODELIMPORTID", expression="t1.PSMODELIMPORTID", showorder=9), @DEDataQueryCodeExp(name="PSMODELIMPORTNAME", expression="t1.PSMODELIMPORTNAME", showorder=10), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.PSOBJID", showorder=11), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.PSOBJNAME", showorder=12), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.PSOBJTYPE", showorder=13), @DEDataQueryCodeExp(name="PSOBJTYPENAME", expression="t1.PSOBJTYPENAME", showorder=14), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=15), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=18)}, conds={})})
public class PSModelImportDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelImportDefaultDQModel() {
        this.initAnnotation(PSModelImportDefaultDQModel.class);
    }
}

