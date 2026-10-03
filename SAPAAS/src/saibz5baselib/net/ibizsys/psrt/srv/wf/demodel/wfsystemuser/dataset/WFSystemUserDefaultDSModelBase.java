/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfsystemuser.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="3d6fd9746bb1acf4b6af87da05f6a646",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="9424D163-710F-41B8-89CC-D8076504B6E1",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFSystemUserDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFSystemUserDefaultDSModelBase() {
        super();

        this.initAnnotation(WFSystemUserDefaultDSModelBase.class);
    }




}