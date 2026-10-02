package com.invoicecomposer.abstractfactory;

public class XmlInvoiceDocument implements InvoiceDocument {

    private final String documentType;

    public XmlInvoiceDocument(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public String getDocumentType() {
        return documentType;
    }

    @Override
    public String buildContent() {
        return "<invoice type=\"" + documentType + "\" format=\"UBL 2.1\">XML generado</invoice>";
    }
}
