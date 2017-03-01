
package https.www_bizapedia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressLists complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressLists"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Success" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Companies" type="{https://www.bizapedia.com/}ArrayOfCompany" minOccurs="0"/&gt;
 *         &lt;element name="CompanyPrincipals" type="{https://www.bizapedia.com/}ArrayOfCompanyPrincipal" minOccurs="0"/&gt;
 *         &lt;element name="Trademarks" type="{https://www.bizapedia.com/}ArrayOfTrademark" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressLists", propOrder = {
    "success",
    "errorMessage",
    "companies",
    "companyPrincipals",
    "trademarks"
})
public class AddressLists {

    @XmlElement(name = "Success")
    protected boolean success;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;
    @XmlElement(name = "Companies")
    protected ArrayOfCompany companies;
    @XmlElement(name = "CompanyPrincipals")
    protected ArrayOfCompanyPrincipal companyPrincipals;
    @XmlElement(name = "Trademarks")
    protected ArrayOfTrademark trademarks;

    /**
     * Gets the value of the success property.
     * 
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the companies property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCompany }
     *     
     */
    public ArrayOfCompany getCompanies() {
        return companies;
    }

    /**
     * Sets the value of the companies property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCompany }
     *     
     */
    public void setCompanies(ArrayOfCompany value) {
        this.companies = value;
    }

    /**
     * Gets the value of the companyPrincipals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCompanyPrincipal }
     *     
     */
    public ArrayOfCompanyPrincipal getCompanyPrincipals() {
        return companyPrincipals;
    }

    /**
     * Sets the value of the companyPrincipals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCompanyPrincipal }
     *     
     */
    public void setCompanyPrincipals(ArrayOfCompanyPrincipal value) {
        this.companyPrincipals = value;
    }

    /**
     * Gets the value of the trademarks property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTrademark }
     *     
     */
    public ArrayOfTrademark getTrademarks() {
        return trademarks;
    }

    /**
     * Sets the value of the trademarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTrademark }
     *     
     */
    public void setTrademarks(ArrayOfTrademark value) {
        this.trademarks = value;
    }

}
