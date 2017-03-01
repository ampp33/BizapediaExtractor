
package https.www_bizapedia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompanyPrincipalList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompanyPrincipalList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Success" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CompanyPrincipals" type="{https://www.bizapedia.com/}ArrayOfCompanyPrincipal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyPrincipalList", propOrder = {
    "success",
    "errorMessage",
    "companyPrincipals"
})
public class CompanyPrincipalList {

    @XmlElement(name = "Success")
    protected boolean success;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;
    @XmlElement(name = "CompanyPrincipals")
    protected ArrayOfCompanyPrincipal companyPrincipals;

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

}
