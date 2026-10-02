package com.invoicecomposer.abstractfactory;

public class PdfInvoiceDocument implements InvoiceDocument {

    private final String documentType;

    public PdfInvoiceDocument(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public String getDocumentType() {
        return documentType;
    }

    @Override
    public String buildContent() {
        return "Reporte PDF del documento " + documentType + " listo para entrega al cliente.";
    }
}
