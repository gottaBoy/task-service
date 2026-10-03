/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orgsecusertype.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="576dd33b28a3ee34ba68561c68aa93b3",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="C8D55807-6E69-4A41-A3A6-0C316E2AE8DC",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class OrgSecUserTypeDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgSecUserTypeDefaultDSModelBase() {
        super();

        this.initAnnotation(OrgSecUserTypeDefaultDSModelBase.class);
    }




}