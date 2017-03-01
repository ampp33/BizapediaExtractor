
package https.www_bizapedia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LPResult" type="{https://www.bizapedia.com/}CompanyPrincipalList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lpResult"
})
@XmlRootElement(name = "LPResponse")
public class LPResponse {

    @XmlElement(name = "LPResult")
    protected CompanyPrincipalList lpResult;

    /**
     * Gets the value of the lpResult property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyPrincipalList }
     *     
     */
    public CompanyPrincipalList getLPResult() {
        return lpResult;
    }

    /**
     * Sets the value of the lpResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyPrincipalList }
     *     
     */
    public void setLPResult(CompanyPrincipalList value) {
        this.lpResult = value;
    }

}
