/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSSysSearchDEFieldDTO;
import net.ibizsys.modelapi.dto.PSWFLinkCondDTO;
import net.ibizsys.modelapi.util.PSModelServiceSession;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import net.ibizsys.modelapi.util.PSModelServiceUtilEx;

public class Test {
    public static void main(String[] args) {
        try {
            List psSysSearchDEFieldDTOs;
            PSWFLinkCondDTO psWFLinkCondDTO = new PSWFLinkCondDTO();
            PSWFLinkCondDTO psWFLinkCondDTO2 = new PSWFLinkCondDTO();
            System.out.println(String.format("%1$s-%2$s", psWFLinkCondDTO.hashCode(), psWFLinkCondDTO2.hashCode()));
            PSModelServiceUtil.setInstance(new PSModelServiceUtilEx());
            PSModelServiceSession psModelServiceSession = PSModelServiceSession.open();
            psModelServiceSession.setPSModelFolderPath("C:\\SRFEX_TEMP\\2019-09-14\\MODEL.api");
            psModelServiceSession.setPSDynaInstFolderPath("C:\\SRFEX_TEMP\\2019-09-14\\MODEL.d1");
            psModelServiceSession.setPSGlobalModelFolderPath("C:\\SRFEX_TEMP\\2019-09-14\\MODEL.global");
            psModelServiceSession.setPSDynaInstId("MODEL.d1");
            PSSystem psSystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(null, false);
            List psAppViewDTOs = PSModelServiceUtil.getInstance().getPSAppViewService().listAllDTO();
            if (psAppViewDTOs != null) {
                for (PSAppViewDTO psAppViewDTO : psAppViewDTOs) {
                    System.out.println(String.format("\u5e94\u7528\u89c6\u56fe[%1$s]-[%2$s]-[%3$s]", psAppViewDTO.getPSAppViewName(), psAppViewDTO.getPSAppModuleId(), psAppViewDTO.getPSSysAppId()));
                }
            }
            if ((psSysSearchDEFieldDTOs = PSModelServiceUtil.getInstance().getPSSysSearchDEFieldService().listAllDTO()) != null) {
                for (PSSysSearchDEFieldDTO psSysSearchDEFieldDTO : psSysSearchDEFieldDTOs) {
                    System.out.println(String.format("\u68c0\u7d22\u5b9e\u4f53\u5c5e\u6027[%1$s]-[%2$s]-[%3$s]", psSysSearchDEFieldDTO.getPSSysSearchDEFieldName(), psSysSearchDEFieldDTO.getPSSysSearchDEId(), psSysSearchDEFieldDTO.getPSDEFId()));
                }
            }
            PSModelServiceSession.close(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            PSModelServiceSession.close(false);
        }
    }
}

