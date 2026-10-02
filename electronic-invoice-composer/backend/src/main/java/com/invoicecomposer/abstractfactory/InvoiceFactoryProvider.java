package com.invoicecomposer.abstractfactory;

import java.util.List;
import java.util.Locale;

/**
 * Concrete factory provider that chooses the family of products based on the
 * business scenario.
 */
public final class InvoiceFactoryProvider {

    private InvoiceFactoryProvider() {
    }

    public static InvoiceFamilyFactory createFactory(String family) {
        String normalized = family == null ? "" : family.trim().toUpperCase(Locale.ROOT);

        return switch (normalized) {
            case "STANDARD" -> new StandardInvoiceFactory();
            case "DIGITAL" -> new DigitalInvoiceFactory();
            default -> throw new IllegalArgumentException("Unsupported invoice family: " + family);
        };
    }

    public static List<String> getSupportedFamilies() {
        return List.of("STANDARD", "DIGITAL");
    }
}
