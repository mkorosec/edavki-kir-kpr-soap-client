
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentPermissionsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentPermissionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Permissions" type="{http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models}ArrayOfDocumentPermission"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentPermissionsResponse", propOrder = {
    "permissions"
})
public class DocumentPermissionsResponse {

    @XmlElement(name = "Permissions", required = true, nillable = true)
    protected ArrayOfDocumentPermission permissions;

    /**
     * Gets the value of the permissions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDocumentPermission }
     *     
     */
    public ArrayOfDocumentPermission getPermissions() {
        return permissions;
    }

    /**
     * Sets the value of the permissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDocumentPermission }
     *     
     */
    public void setPermissions(ArrayOfDocumentPermission value) {
        this.permissions = value;
    }

}
