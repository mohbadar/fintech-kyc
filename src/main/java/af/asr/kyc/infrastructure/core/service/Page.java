
package af.asr.kyc.infrastructure.core.service;

import java.util.List;

public class Page<E> {

    private final int totalFilteredRecords;
    private final List<E> pageItems;

    public Page(final List<E> pageItems, final int totalFilteredRecords) {
        this.pageItems = pageItems;
        this.totalFilteredRecords = totalFilteredRecords;
    }

    public int getTotalFilteredRecords() {
        return this.totalFilteredRecords;
    }

    public List<E> getPageItems() {
        return this.pageItems;
    }
}