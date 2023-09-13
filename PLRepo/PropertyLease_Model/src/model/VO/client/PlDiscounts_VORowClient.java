package model.VO.client;

import oracle.jbo.client.remote.RowImpl;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Timestamp;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed May 16 19:11:30 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PlDiscounts_VORowClient extends RowImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public PlDiscounts_VORowClient() {
    }


    public Number getDiscountId() {
        return (Number)getAttribute("DiscountId");
    }

    public void setDiscountId(Number value) {
        setAttribute("DiscountId", value);
    }

    public String getDiscountName() {
        return (String)getAttribute("DiscountName");
    }

    public void setDiscountName(String value) {
        setAttribute("DiscountName", value);
    }

    public String getDiscountLevel() {
        return (String)getAttribute("DiscountLevel");
    }

    public void setDiscountLevel(String value) {
        setAttribute("DiscountLevel", value);
    }

    public String getDiscountType() {
        return (String)getAttribute("DiscountType");
    }

    public void setDiscountType(String value) {
        setAttribute("DiscountType", value);
    }

    public Number getDiscountValue() {
        return (Number)getAttribute("DiscountValue");
    }

    public void setDiscountValue(Number value) {
        setAttribute("DiscountValue", value);
    }

    public Date getStartDate() {
        return (Date)getAttribute("StartDate");
    }

    public void setStartDate(Date value) {
        setAttribute("StartDate", value);
    }

    public Date getEndDate() {
        return (Date)getAttribute("EndDate");
    }

    public void setEndDate(Date value) {
        setAttribute("EndDate", value);
    }

    public String getCreatedBy() {
        return (String)getAttribute("CreatedBy");
    }

    public void setCreatedBy(String value) {
        setAttribute("CreatedBy", value);
    }

    public Timestamp getCreationDate() {
        return (Timestamp)getAttribute("CreationDate");
    }

    public void setCreationDate(Timestamp value) {
        setAttribute("CreationDate", value);
    }

    public String getLastUpdatedBy() {
        return (String)getAttribute("LastUpdatedBy");
    }

    public void setLastUpdatedBy(String value) {
        setAttribute("LastUpdatedBy", value);
    }

    public Timestamp getLastUpdateDate() {
        return (Timestamp)getAttribute("LastUpdateDate");
    }

    public void setLastUpdateDate(Timestamp value) {
        setAttribute("LastUpdateDate", value);
    }

    public String getLastUpdateLogin() {
        return (String)getAttribute("LastUpdateLogin");
    }

    public void setLastUpdateLogin(String value) {
        setAttribute("LastUpdateLogin", value);
    }

    public Boolean getCheckBox_Trans() {
        return (Boolean)getAttribute("CheckBox_Trans");
    }

    public void setCheckBox_Trans(Boolean value) {
        setAttribute("CheckBox_Trans", value);
    }
}