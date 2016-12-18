
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="packageId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tracked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "packageId",
    "tracked"
})
@XmlRootElement(name = "updatePackage")
public class UpdatePackage {

    protected int packageId;
    protected boolean tracked;

    /**
     * Gets the value of the packageId property.
     * 
     */
    public int getPackageId() {
        return packageId;
    }

    /**
     * Sets the value of the packageId property.
     * 
     */
    public void setPackageId(int value) {
        this.packageId = value;
    }

    /**
     * Gets the value of the tracked property.
     * 
     */
    public boolean isTracked() {
        return tracked;
    }

    /**
     * Sets the value of the tracked property.
     * 
     */
    public void setTracked(boolean value) {
        this.tracked = value;
    }

}
