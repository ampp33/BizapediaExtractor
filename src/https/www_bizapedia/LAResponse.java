
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
 *         &lt;element name="LAResult" type="{https://www.bizapedia.com/}AddressLists" minOccurs="0"/&gt;
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
    "laResult"
})
@XmlRootElement(name = "LAResponse")
public class LAResponse {

    @XmlElement(name = "LAResult")
    protected AddressLists laResult;

    /**
     * Gets the value of the laResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddressLists }
     *     
     */
    public AddressLists getLAResult() {
        return laResult;
    }

    /**
     * Sets the value of the laResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressLists }
     *     
     */
    public void setLAResult(AddressLists value) {
        this.laResult = value;
    }

}
