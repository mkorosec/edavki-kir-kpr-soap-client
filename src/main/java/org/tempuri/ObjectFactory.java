
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.DocumentPermissionsResponse;
import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.InvoiceBookFormat;
import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.InvoiceBookStatusResponse;
import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.OpenPeriodsResponse;
import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.Period;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Format_QNAME = new QName("http://tempuri.org/", "Format");
    private final static QName _CorrelationId_QNAME = new QName("http://tempuri.org/", "CorrelationId");
    private final static QName _SchemaVersion_QNAME = new QName("http://tempuri.org/", "SchemaVersion");
    private final static QName _Period_QNAME = new QName("http://tempuri.org/", "Period");
    private final static QName _GetInvoiceBookStatusResponseGetInvoiceBookStatusResult_QNAME = new QName("http://tempuri.org/", "GetInvoiceBookStatusResult");
    private final static QName _GetInvoiceBookStatusEdpId_QNAME = new QName("http://tempuri.org/", "edpId");
    private final static QName _GetPermissionsFormCode_QNAME = new QName("http://tempuri.org/", "formCode");
    private final static QName _GetOpenPeriodsResponseGetOpenPeriodsResult_QNAME = new QName("http://tempuri.org/", "GetOpenPeriodsResult");
    private final static QName _UploadInvoiceBookResponseEdpId_QNAME = new QName("http://tempuri.org/", "EdpId");
    private final static QName _GetPermissionsResponseGetPermissionsResult_QNAME = new QName("http://tempuri.org/", "GetPermissionsResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInvoiceBookStatusResponse }
     * 
     */
    public GetInvoiceBookStatusResponse createGetInvoiceBookStatusResponse() {
        return new GetInvoiceBookStatusResponse();
    }

    /**
     * Create an instance of {@link GetInvoiceBookStatus }
     * 
     */
    public GetInvoiceBookStatus createGetInvoiceBookStatus() {
        return new GetInvoiceBookStatus();
    }

    /**
     * Create an instance of {@link UploadInvoiceBookResponse }
     * 
     */
    public UploadInvoiceBookResponse createUploadInvoiceBookResponse() {
        return new UploadInvoiceBookResponse();
    }

    /**
     * Create an instance of {@link GetOpenPeriodsResponse }
     * 
     */
    public GetOpenPeriodsResponse createGetOpenPeriodsResponse() {
        return new GetOpenPeriodsResponse();
    }

    /**
     * Create an instance of {@link GetPermissionsResponse }
     * 
     */
    public GetPermissionsResponse createGetPermissionsResponse() {
        return new GetPermissionsResponse();
    }

    /**
     * Create an instance of {@link UploadInvoiceBookRequest }
     * 
     */
    public UploadInvoiceBookRequest createUploadInvoiceBookRequest() {
        return new UploadInvoiceBookRequest();
    }

    /**
     * Create an instance of {@link GetPermissions }
     * 
     */
    public GetPermissions createGetPermissions() {
        return new GetPermissions();
    }

    /**
     * Create an instance of {@link GetOpenPeriods }
     * 
     */
    public GetOpenPeriods createGetOpenPeriods() {
        return new GetOpenPeriods();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceBookFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Format")
    public JAXBElement<InvoiceBookFormat> createFormat(InvoiceBookFormat value) {
        return new JAXBElement<InvoiceBookFormat>(_Format_QNAME, InvoiceBookFormat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CorrelationId")
    public JAXBElement<String> createCorrelationId(String value) {
        return new JAXBElement<String>(_CorrelationId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SchemaVersion")
    public JAXBElement<Integer> createSchemaVersion(Integer value) {
        return new JAXBElement<Integer>(_SchemaVersion_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Period }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Period")
    public JAXBElement<Period> createPeriod(Period value) {
        return new JAXBElement<Period>(_Period_QNAME, Period.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceBookStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetInvoiceBookStatusResult", scope = GetInvoiceBookStatusResponse.class)
    public JAXBElement<InvoiceBookStatusResponse> createGetInvoiceBookStatusResponseGetInvoiceBookStatusResult(InvoiceBookStatusResponse value) {
        return new JAXBElement<InvoiceBookStatusResponse>(_GetInvoiceBookStatusResponseGetInvoiceBookStatusResult_QNAME, InvoiceBookStatusResponse.class, GetInvoiceBookStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "edpId", scope = GetInvoiceBookStatus.class)
    public JAXBElement<String> createGetInvoiceBookStatusEdpId(String value) {
        return new JAXBElement<String>(_GetInvoiceBookStatusEdpId_QNAME, String.class, GetInvoiceBookStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "formCode", scope = GetPermissions.class)
    public JAXBElement<String> createGetPermissionsFormCode(String value) {
        return new JAXBElement<String>(_GetPermissionsFormCode_QNAME, String.class, GetPermissions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenPeriodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOpenPeriodsResult", scope = GetOpenPeriodsResponse.class)
    public JAXBElement<OpenPeriodsResponse> createGetOpenPeriodsResponseGetOpenPeriodsResult(OpenPeriodsResponse value) {
        return new JAXBElement<OpenPeriodsResponse>(_GetOpenPeriodsResponseGetOpenPeriodsResult_QNAME, OpenPeriodsResponse.class, GetOpenPeriodsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "formCode", scope = GetOpenPeriods.class)
    public JAXBElement<String> createGetOpenPeriodsFormCode(String value) {
        return new JAXBElement<String>(_GetPermissionsFormCode_QNAME, String.class, GetOpenPeriods.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "EdpId", scope = UploadInvoiceBookResponse.class)
    public JAXBElement<String> createUploadInvoiceBookResponseEdpId(String value) {
        return new JAXBElement<String>(_UploadInvoiceBookResponseEdpId_QNAME, String.class, UploadInvoiceBookResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentPermissionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPermissionsResult", scope = GetPermissionsResponse.class)
    public JAXBElement<DocumentPermissionsResponse> createGetPermissionsResponseGetPermissionsResult(DocumentPermissionsResponse value) {
        return new JAXBElement<DocumentPermissionsResponse>(_GetPermissionsResponseGetPermissionsResult_QNAME, DocumentPermissionsResponse.class, GetPermissionsResponse.class, value);
    }

}
