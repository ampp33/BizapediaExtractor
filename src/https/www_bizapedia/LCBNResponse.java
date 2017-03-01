
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
 *         &lt;element name="LCBNResult" type="{https://www.bizapedia.com/}Company" minOccurs="0"/&gt;
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
    "lcbnResult"
})
@XmlRootElement(name = "LCBNResponse")
public class LCBNResponse {

    @XmlElement(name = "LCBNResult")
    protected Company lcbnResult;

    /**
     * Gets the value of the lcbnResult property.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    public Company getLCBNResult() {
        return lcbnResult;
    }

    /**
     * Sets the value of the lcbnResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    public void setLCBNResult(Company value) {
        this.lcbnResult = value;
    }

}
