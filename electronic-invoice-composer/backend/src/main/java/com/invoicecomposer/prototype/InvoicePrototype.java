package com.invoicecomposer.prototype;

/**
 * Prototype interface for cloning invoice templates without reconstructing them
 * from scratch.
 */
public interface InvoicePrototype {
    InvoicePrototype clone();
}
