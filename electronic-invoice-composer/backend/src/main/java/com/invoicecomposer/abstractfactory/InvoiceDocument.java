package com.invoicecomposer.abstractfactory;

/**
 * Product interface for the Abstract Factory implementation used to create
 * invoice document variants for DIAN scenarios.
 */
public interface InvoiceDocument {
    String getDocumentType();
    String buildContent();
}
