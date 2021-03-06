
package org.tempuri;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HelloWorld2Result" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "helloWorld2Result"
})
@XmlRootElement(name = "HelloWorld2Response")
public class HelloWorld2Response {

    @XmlElement(name = "HelloWorld2Result")
    protected String helloWorld2Result;

    /**
     * Gets the value of the helloWorld2Result property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHelloWorld2Result() {
        return helloWorld2Result;
    }

    /**
     * Sets the value of the helloWorld2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHelloWorld2Result(String value) {
        this.helloWorld2Result = value;
    }

}
