
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvoiceBookStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InvoiceBookStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Uploaded"/>
 *     &lt;enumeration value="Validating"/>
 *     &lt;enumeration value="ValidatedOk"/>
 *     &lt;enumeration value="ValidationError"/>
 *     &lt;enumeration value="InProcess"/>
 *     &lt;enumeration value="ProcessedOk"/>
 *     &lt;enumeration value="ProcessedError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InvoiceBookStatus")
@XmlEnum
public enum InvoiceBookStatus {

    @XmlEnumValue("Uploaded")
    UPLOADED("Uploaded"),
    @XmlEnumValue("Validating")
    VALIDATING("Validating"),
    @XmlEnumValue("ValidatedOk")
    VALIDATED_OK("ValidatedOk"),
    @XmlEnumValue("ValidationError")
    VALIDATION_ERROR("ValidationError"),
    @XmlEnumValue("InProcess")
    IN_PROCESS("InProcess"),
    @XmlEnumValue("ProcessedOk")
    PROCESSED_OK("ProcessedOk"),
    @XmlEnumValue("ProcessedError")
    PROCESSED_ERROR("ProcessedError");
    private final String value;

    InvoiceBookStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InvoiceBookStatus fromValue(String v) {
        for (InvoiceBookStatus c: InvoiceBookStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
