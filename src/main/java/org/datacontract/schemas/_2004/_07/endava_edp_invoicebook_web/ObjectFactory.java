
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.endava_edp_invoicebook_web package. 
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

    private final static QName _ServerErrorFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", "ServerErrorFault");
    private final static QName _BasicFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", "BasicFault");
    private final static QName _TaxPayerType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "TaxPayerType");
    private final static QName _DocumentPermission_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "DocumentPermission");
    private final static QName _BadRequestFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", "BadRequestFault");
    private final static QName _ForbiddenFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", "ForbiddenFault");
    private final static QName _NotFoundFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", "NotFoundFault");
    private final static QName _InvoiceBookFormat_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "InvoiceBookFormat");
    private final static QName _UnauthorizedFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", "UnauthorizedFault");
    private final static QName _TaxPayer_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "TaxPayer");
    private final static QName _Period_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "Period");
    private final static QName _InvoiceBookStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "InvoiceBookStatus");
    private final static QName _DocumentPermissionsResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "DocumentPermissionsResponse");
    private final static QName _InvoiceBookStatusResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "InvoiceBookStatusResponse");
    private final static QName _OpenPeriod_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "OpenPeriod");
    private final static QName _OpenPeriodsResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "OpenPeriodsResponse");
    private final static QName _ArrayOfOpenPeriod_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "ArrayOfOpenPeriod");
    private final static QName _ArrayOfDocumentPermission_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "ArrayOfDocumentPermission");
    private final static QName _DocumentPermissionMandator_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "Mandator");
    private final static QName _DocumentPermissionFormCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "FormCode");
    private final static QName _OpenPeriodDueDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "DueDate");
    private final static QName _OpenPeriodRepresentedForeignerId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "RepresentedForeignerId");
    private final static QName _BasicFaultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", "Message");
    private final static QName _PeriodEnd_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "End");
    private final static QName _PeriodBegin_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "Begin");
    private final static QName _InvoiceBookStatusResponseValidationMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "ValidationMessage");
    private final static QName _InvoiceBookStatusResponseBackendMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", "BackendMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.endava_edp_invoicebook_web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UnauthorizedFault }
     * 
     */
    public UnauthorizedFault createUnauthorizedFault() {
        return new UnauthorizedFault();
    }

    /**
     * Create an instance of {@link BadRequestFault }
     * 
     */
    public BadRequestFault createBadRequestFault() {
        return new BadRequestFault();
    }

    /**
     * Create an instance of {@link ForbiddenFault }
     * 
     */
    public ForbiddenFault createForbiddenFault() {
        return new ForbiddenFault();
    }

    /**
     * Create an instance of {@link NotFoundFault }
     * 
     */
    public NotFoundFault createNotFoundFault() {
        return new NotFoundFault();
    }

    /**
     * Create an instance of {@link ServerErrorFault }
     * 
     */
    public ServerErrorFault createServerErrorFault() {
        return new ServerErrorFault();
    }

    /**
     * Create an instance of {@link BasicFault }
     * 
     */
    public BasicFault createBasicFault() {
        return new BasicFault();
    }

    /**
     * Create an instance of {@link OpenPeriodsResponse }
     * 
     */
    public OpenPeriodsResponse createOpenPeriodsResponse() {
        return new OpenPeriodsResponse();
    }

    /**
     * Create an instance of {@link ArrayOfOpenPeriod }
     * 
     */
    public ArrayOfOpenPeriod createArrayOfOpenPeriod() {
        return new ArrayOfOpenPeriod();
    }

    /**
     * Create an instance of {@link TaxPayer }
     * 
     */
    public TaxPayer createTaxPayer() {
        return new TaxPayer();
    }

    /**
     * Create an instance of {@link ArrayOfDocumentPermission }
     * 
     */
    public ArrayOfDocumentPermission createArrayOfDocumentPermission() {
        return new ArrayOfDocumentPermission();
    }

    /**
     * Create an instance of {@link Period }
     * 
     */
    public Period createPeriod() {
        return new Period();
    }

    /**
     * Create an instance of {@link InvoiceBookStatusResponse }
     * 
     */
    public InvoiceBookStatusResponse createInvoiceBookStatusResponse() {
        return new InvoiceBookStatusResponse();
    }

    /**
     * Create an instance of {@link OpenPeriod }
     * 
     */
    public OpenPeriod createOpenPeriod() {
        return new OpenPeriod();
    }

    /**
     * Create an instance of {@link DocumentPermissionsResponse }
     * 
     */
    public DocumentPermissionsResponse createDocumentPermissionsResponse() {
        return new DocumentPermissionsResponse();
    }

    /**
     * Create an instance of {@link DocumentPermission }
     * 
     */
    public DocumentPermission createDocumentPermission() {
        return new DocumentPermission();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServerErrorFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", name = "ServerErrorFault")
    public JAXBElement<ServerErrorFault> createServerErrorFault(ServerErrorFault value) {
        return new JAXBElement<ServerErrorFault>(_ServerErrorFault_QNAME, ServerErrorFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", name = "BasicFault")
    public JAXBElement<BasicFault> createBasicFault(BasicFault value) {
        return new JAXBElement<BasicFault>(_BasicFault_QNAME, BasicFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxPayerType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "TaxPayerType")
    public JAXBElement<TaxPayerType> createTaxPayerType(TaxPayerType value) {
        return new JAXBElement<TaxPayerType>(_TaxPayerType_QNAME, TaxPayerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentPermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "DocumentPermission")
    public JAXBElement<DocumentPermission> createDocumentPermission(DocumentPermission value) {
        return new JAXBElement<DocumentPermission>(_DocumentPermission_QNAME, DocumentPermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadRequestFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", name = "BadRequestFault")
    public JAXBElement<BadRequestFault> createBadRequestFault(BadRequestFault value) {
        return new JAXBElement<BadRequestFault>(_BadRequestFault_QNAME, BadRequestFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForbiddenFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", name = "ForbiddenFault")
    public JAXBElement<ForbiddenFault> createForbiddenFault(ForbiddenFault value) {
        return new JAXBElement<ForbiddenFault>(_ForbiddenFault_QNAME, ForbiddenFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", name = "NotFoundFault")
    public JAXBElement<NotFoundFault> createNotFoundFault(NotFoundFault value) {
        return new JAXBElement<NotFoundFault>(_NotFoundFault_QNAME, NotFoundFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceBookFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "InvoiceBookFormat")
    public JAXBElement<InvoiceBookFormat> createInvoiceBookFormat(InvoiceBookFormat value) {
        return new JAXBElement<InvoiceBookFormat>(_InvoiceBookFormat_QNAME, InvoiceBookFormat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnauthorizedFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", name = "UnauthorizedFault")
    public JAXBElement<UnauthorizedFault> createUnauthorizedFault(UnauthorizedFault value) {
        return new JAXBElement<UnauthorizedFault>(_UnauthorizedFault_QNAME, UnauthorizedFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxPayer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "TaxPayer")
    public JAXBElement<TaxPayer> createTaxPayer(TaxPayer value) {
        return new JAXBElement<TaxPayer>(_TaxPayer_QNAME, TaxPayer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Period }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "Period")
    public JAXBElement<Period> createPeriod(Period value) {
        return new JAXBElement<Period>(_Period_QNAME, Period.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceBookStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "InvoiceBookStatus")
    public JAXBElement<InvoiceBookStatus> createInvoiceBookStatus(InvoiceBookStatus value) {
        return new JAXBElement<InvoiceBookStatus>(_InvoiceBookStatus_QNAME, InvoiceBookStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentPermissionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "DocumentPermissionsResponse")
    public JAXBElement<DocumentPermissionsResponse> createDocumentPermissionsResponse(DocumentPermissionsResponse value) {
        return new JAXBElement<DocumentPermissionsResponse>(_DocumentPermissionsResponse_QNAME, DocumentPermissionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceBookStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "InvoiceBookStatusResponse")
    public JAXBElement<InvoiceBookStatusResponse> createInvoiceBookStatusResponse(InvoiceBookStatusResponse value) {
        return new JAXBElement<InvoiceBookStatusResponse>(_InvoiceBookStatusResponse_QNAME, InvoiceBookStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenPeriod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "OpenPeriod")
    public JAXBElement<OpenPeriod> createOpenPeriod(OpenPeriod value) {
        return new JAXBElement<OpenPeriod>(_OpenPeriod_QNAME, OpenPeriod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenPeriodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "OpenPeriodsResponse")
    public JAXBElement<OpenPeriodsResponse> createOpenPeriodsResponse(OpenPeriodsResponse value) {
        return new JAXBElement<OpenPeriodsResponse>(_OpenPeriodsResponse_QNAME, OpenPeriodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOpenPeriod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "ArrayOfOpenPeriod")
    public JAXBElement<ArrayOfOpenPeriod> createArrayOfOpenPeriod(ArrayOfOpenPeriod value) {
        return new JAXBElement<ArrayOfOpenPeriod>(_ArrayOfOpenPeriod_QNAME, ArrayOfOpenPeriod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDocumentPermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "ArrayOfDocumentPermission")
    public JAXBElement<ArrayOfDocumentPermission> createArrayOfDocumentPermission(ArrayOfDocumentPermission value) {
        return new JAXBElement<ArrayOfDocumentPermission>(_ArrayOfDocumentPermission_QNAME, ArrayOfDocumentPermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxPayer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "Mandator", scope = DocumentPermission.class)
    public JAXBElement<TaxPayer> createDocumentPermissionMandator(TaxPayer value) {
        return new JAXBElement<TaxPayer>(_DocumentPermissionMandator_QNAME, TaxPayer.class, DocumentPermission.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "FormCode", scope = DocumentPermission.class)
    public JAXBElement<String> createDocumentPermissionFormCode(String value) {
        return new JAXBElement<String>(_DocumentPermissionFormCode_QNAME, String.class, DocumentPermission.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "DueDate", scope = OpenPeriod.class)
    public JAXBElement<XMLGregorianCalendar> createOpenPeriodDueDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_OpenPeriodDueDate_QNAME, XMLGregorianCalendar.class, OpenPeriod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "RepresentedForeignerId", scope = OpenPeriod.class)
    public JAXBElement<String> createOpenPeriodRepresentedForeignerId(String value) {
        return new JAXBElement<String>(_OpenPeriodRepresentedForeignerId_QNAME, String.class, OpenPeriod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap", name = "Message", scope = BasicFault.class)
    public JAXBElement<String> createBasicFaultMessage(String value) {
        return new JAXBElement<String>(_BasicFaultMessage_QNAME, String.class, BasicFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "End", scope = Period.class)
    public JAXBElement<XMLGregorianCalendar> createPeriodEnd(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PeriodEnd_QNAME, XMLGregorianCalendar.class, Period.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "Begin", scope = Period.class)
    public JAXBElement<XMLGregorianCalendar> createPeriodBegin(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_PeriodBegin_QNAME, XMLGregorianCalendar.class, Period.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "ValidationMessage", scope = InvoiceBookStatusResponse.class)
    public JAXBElement<String> createInvoiceBookStatusResponseValidationMessage(String value) {
        return new JAXBElement<String>(_InvoiceBookStatusResponseValidationMessage_QNAME, String.class, InvoiceBookStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", name = "BackendMessage", scope = InvoiceBookStatusResponse.class)
    public JAXBElement<String> createInvoiceBookStatusResponseBackendMessage(String value) {
        return new JAXBElement<String>(_InvoiceBookStatusResponseBackendMessage_QNAME, String.class, InvoiceBookStatusResponse.class, value);
    }

}
