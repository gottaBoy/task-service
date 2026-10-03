/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.sysadminfunc.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="2e71859d8147cd788d815a3371f9ebd6",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="52B5E5D1-4857-479F-AEAF-69B444AE4B5A",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class SysAdminFuncDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public SysAdminFuncDefaultDSModelBase() {
        super();

        this.initAnnotation(SysAdminFuncDefaultDSModelBase.class);
    }




}