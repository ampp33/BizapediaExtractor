
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
 *         &lt;element name="LCSBNResult" type="{https://www.bizapedia.com/}CompanyList" minOccurs="0"/&gt;
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
    "lcsbnResult"
})
@XmlRootElement(name = "LCSBNResponse")
public class LCSBNResponse {

    @XmlElement(name = "LCSBNResult")
    protected CompanyList lcsbnResult;

    /**
     * Gets the value of the lcsbnResult property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyList }
     *     
     */
    public CompanyList getLCSBNResult() {
        return lcsbnResult;
    }

    /**
     * Sets the value of the lcsbnResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyList }
     *     
     */
    public void setLCSBNResult(CompanyList value) {
        this.lcsbnResult = value;
    }

}
