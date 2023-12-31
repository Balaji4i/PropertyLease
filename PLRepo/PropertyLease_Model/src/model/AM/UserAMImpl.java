package model.AM;

import com.octetstring.vde.util.Base64;

import oracle.jbo.server.ViewObjectImpl;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import model.AM.common.UserAM;

import oracle.adf.share.ADFContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;


import org.json.JSONException;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu May 24 11:46:45 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UserAMImpl extends ApplicationModuleImpl implements UserAM {
    /**
     * This is the default constructor (do not remove).
     */
    public UserAMImpl() {
    }

    /**
     * Container's getter for getMenuAccessforMenuROVO1.
     * @return getMenuAccessforMenuROVO1
     */
    public ViewObjectImpl getgetMenuAccessforMenuROVO1() {
        return (ViewObjectImpl)findViewObject("getMenuAccessforMenuROVO1");
    }

    public String getUserGroup(String UserId) {
        ViewObject getUserDetaiulsVO =
            this.getgetDataCombinationROVO1().getViewObject();
        getUserDetaiulsVO.setNamedWhereClauseParam("P_DATA_ID", UserId);
        getUserDetaiulsVO.executeQuery();


        // RowSetIterator rs = getUserDetaiulsVO.createRowSet("");
        if (getUserDetaiulsVO.getEstimatedRowCount() > 0) {
            Row re = getUserDetaiulsVO.first();
            ADFContext.getCurrent().getSessionScope().put("UserGrpId",
                                                          re.getAttribute("DcombId").toString());
        }

        return null;
    }
    /* This Method is used for get the token from IDCS for accessing the application */
    
//    public String CheckUserNaname(String UserName) {
//
//        String retValu = "invalid";
//        try {
//            ADFContext adfCtx = ADFContext.getCurrent();
//            SecurityContext secCntx = adfCtx.getSecurityContext();
//            String user = secCntx.getUserPrincipal().getName();
//            Object _user = secCntx.getUserName();
//            System.err.println("HELLO--->" + _user);
//            if (_user.equals("anonymous")) {
//                ADFContext.getCurrent().getSessionScope().put("userName",
//                                                              "ERP_user");
//            } else {
//                ADFContext.getCurrent().getSessionScope().put("userName",
//                                                              _user);
//            }
//            String NumberFormat = "###,###,###,###";
//            String DateFormat = "yyyy-MM-dd";
//            String currencyFormat = "ar_AE";
//            String codeFirst =
//                currencyFormat.substring(0, currencyFormat.indexOf("_"));
//            String codeLast =
//                currencyFormat.substring(currencyFormat.indexOf("_") + 1,
//                                         currencyFormat.length());
//            //            System.err.println(codeFirst + "---" + codeLast);
//
//            ADFContext.getCurrent().getSessionScope().put("NumberFormat",
//                                                          NumberFormat);
//
//            ADFContext.getCurrent().getSessionScope().put("Currency",
//                                                          new Locale(codeFirst,
//                                                                     codeLast));
//
//            ADFContext.getCurrent().getSessionScope().put("DateFormat",
//                                                          DateFormat);
//
//
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//
//
//        try {
//            ViewObject getUserDetaiulsVO =
//                this.getgetUserDetailsROVO1().getViewObject();
//            getUserDetaiulsVO.setNamedWhereClauseParam("USER_NAME",
//                                                       ADFContext.getCurrent().getSessionScope().get("userName"));
//            //getUserDetaiulsVO.setNamedWhereClauseParam("USER_NAME","Kavin");
//            getUserDetaiulsVO.executeQuery();
//
//
//            // RowSetIterator rs = getUserDetaiulsVO.createRowSet("");
//            if (getUserDetaiulsVO.getEstimatedRowCount() > 0) {
//                Row re = getUserDetaiulsVO.first();
//                String userRole =
//                    re.getAttribute("LookupValueName").toString();
//
//
//                ADFContext.getCurrent().getSessionScope().put("userRole",
//                                                              userRole);
//                ADFContext.getCurrent().getSessionScope().put("UR", userRole);
//                ADFContext.getCurrent().getSessionScope().put("userRoleId",
//                                                              re.getAttribute("UserRoleId").toString());
//                prepareMenu(re.getAttribute("UserRoleId") == null ? "" :
//                            re.getAttribute("UserRoleId").toString());
//
//                ADFContext.getCurrent().getSessionScope().put("UserGrpId",
//                                                              re.getAttribute("DataGroupId").toString());
//
//                ADFContext.getCurrent().getSessionScope().put("navigation",
//                                                              "Dashboard");
//
//                retValu = "validUser";
//            } else {
//                ADFContext.getCurrent().getSessionScope().put("navigation",
//                                                              "InvalidUser");
//                retValu = "invalid";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "validUser";
//    }


    /* This Method is used for get the JWT token from SaaS for accessing the application */


    public String CheckUserNaname(String UserName) {

        String retValu = "invalid";
        ADFContext.getCurrent().getSessionScope().put("userName",
                                                      "ERP_user");
        String inputEncodedText =
            ADFContext.getCurrent().getPageFlowScope().get("tokens").toString();
        String[] xIn = inputEncodedText.split("\\.");
        byte b[] = Base64.decode(xIn[1]);
        String tempPass = new String(b);
        int chkOccurance = tempPass.lastIndexOf("}");
        if (chkOccurance < 1) {
            tempPass += "}";
        }
        JSONObject jo;
        try {
            jo = new JSONObject(tempPass);
            long millis = System.currentTimeMillis();
            long iatVal = Long.parseLong(jo.get("iat").toString()) * 1000;
            long expVal = Long.parseLong(jo.get("exp").toString()) * 1000;

            ADFContext.getCurrent().getSessionScope().put("userName",
                                                          jo.getString("prn"));
                      System.err.println("==USER NAME FROM TOKEN=="+ADFContext.getCurrent().getSessionScope().get("userName"));
            String NumberFormat = "###,###,###,###";
            String DateFormat = "yyyy-MM-dd";
            String currencyFormat = "ar_AE";
            String codeFirst =
                currencyFormat.substring(0, currencyFormat.indexOf("_"));
            String codeLast =
                currencyFormat.substring(currencyFormat.indexOf("_") + 1,
                                         currencyFormat.length());
            //            System.err.println(codeFirst + "---" + codeLast);

            ADFContext.getCurrent().getSessionScope().put("NumberFormat",
                                                          NumberFormat);

            ADFContext.getCurrent().getSessionScope().put("Currency",
                                                          new Locale(codeFirst,
                                                                     codeLast));

            ADFContext.getCurrent().getSessionScope().put("DateFormat",
                                                          DateFormat);


        } catch (JSONException e) {
        }


        try {
            ViewObject getUserDetaiulsVO =
                this.getgetUserDetailsROVO1().getViewObject();
            getUserDetaiulsVO.setNamedWhereClauseParam("USER_NAME",
                                                       ADFContext.getCurrent().getSessionScope().get("userName"));
//            getUserDetaiulsVO.setNamedWhereClauseParam("USER_NAME","SRIVATSAN.M@4IAPPS.COM");
            getUserDetaiulsVO.executeQuery();


            // RowSetIterator rs = getUserDetaiulsVO.createRowSet("");
            if (getUserDetaiulsVO.getEstimatedRowCount() > 0) {
                Row re = getUserDetaiulsVO.first();
                String userRole =
                    re.getAttribute("LookupValueName").toString();
                String userId =
                    re.getAttribute("UserId").toString();
                ADFContext.getCurrent().getSessionScope().put("userId",
                                                              userId);
                
                System.err.println("===user Role 1==="+userRole);

                ADFContext.getCurrent().getSessionScope().put("userRole",
                                                              userRole);
                System.err.println("===user Role 2==="+ ADFContext.getCurrent().getSessionScope().get("userRole"));
                ADFContext.getCurrent().getSessionScope().put("UR", userRole);
                System.err.println("===UR==="+ ADFContext.getCurrent().getSessionScope().get("UR"));
                ADFContext.getCurrent().getSessionScope().put("userRoleId",
                                                              re.getAttribute("UserRoleId").toString());
                System.err.println("===UR==="+ ADFContext.getCurrent().getSessionScope().get("UR"));
                prepareMenu(re.getAttribute("UserRoleId") == null ? "" :
                            re.getAttribute("UserRoleId").toString());
                
                
                  String DataGrp=re.getAttribute("DataGroupId").toString();
                
                System.err.println("===Data Group Id ==="+re.getAttribute("DataGroupId").toString() );
                
                ADFContext.getCurrent().getSessionScope().put("UserGrpId",
                                                              re.getAttribute("DataGroupId").toString());
//  ADFContext.getCurrent().getSessionScope().put("UserGrpId","12");
                ADFContext.getCurrent().getSessionScope().put("navigation",
                                                              "Dashboard");
                
                System.err.println("====user Group Id======)"+ADFContext.getCurrent().getSessionScope().get("UserGrpId"));

                retValu = "validUser";
            } else {
                ADFContext.getCurrent().getSessionScope().put("navigation",
                                                              "InvalidUser");
                retValu = "invalid";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "validUser";
    }


    public void prepareMenu(String userRole) {
        Map grantMap = new HashMap();

        try {
            if (userRole != null) {
                ViewObject getMenuAccessVo =
                    this.getgetMenuAccessforMenuROVO1().getViewObject();
                getMenuAccessVo.setNamedWhereClauseParam("USER_ROLE",
                                                         userRole);
                getMenuAccessVo.executeQuery();

                if (getMenuAccessVo.getEstimatedRowCount() > 0) {
                    RowSetIterator rs =
                        getMenuAccessVo.createRowSetIterator("");


                    try {

                        while (rs.hasNext()) {
                            Row re = rs.next();
                            //Row re=rs.first();
                            grantMap.put(re.getAttribute("SubMenuName"),
                                         re.getAttribute("MenuControl"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ADFContext.getCurrent().getSessionScope().put("grantMap",
                                                                  grantMap);
                    // JSFUtils.setExpressionValue("#{sessionScope.grantMap}",
                    //  grantMap);
                } else {
                    // JSFUtils.addFacesInformationMessage("This User has not having a any Access..!");
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Container's getter for getUserDetailsROVO1.
     * @return getUserDetailsROVO1
     */
    public ViewObjectImpl getgetUserDetailsROVO1() {
        return (ViewObjectImpl)findViewObject("getUserDetailsROVO1");
    }

    /**
     * Container's getter for getUserGroupIdROVo1.
     * @return getUserGroupIdROVo1
     */
    public ViewObjectImpl getgetUserGroupIdROVo1() {
        return (ViewObjectImpl)findViewObject("getUserGroupIdROVo1");
    }

    /**
     * Container's getter for getDataCombinationROVO1.
     * @return getDataCombinationROVO1
     */
    public ViewObjectImpl getgetDataCombinationROVO1() {
        return (ViewObjectImpl)findViewObject("getDataCombinationROVO1");
    }

    /**
     * Container's getter for userROVO1.
     * @return userROVO1
     */
    public ViewObjectImpl getuserROVO1() {
        return (ViewObjectImpl)findViewObject("userROVO1");
    }

}
