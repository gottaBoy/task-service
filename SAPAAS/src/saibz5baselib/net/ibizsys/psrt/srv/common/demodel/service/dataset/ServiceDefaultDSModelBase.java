/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.service.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="08903b770bfabc9dbb8e95f19a74ed65",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="DC4E16C1-57A0-46EE-9DC0-E93377809C3C",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class ServiceDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public ServiceDefaultDSModelBase() {
        super();

        this.initAnnotation(ServiceDefaultDSModelBase.class);
    }




}