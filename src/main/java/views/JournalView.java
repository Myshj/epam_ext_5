package views;

import models.Record;
import utils.Repository;

public class JournalView extends PromtingView {
    private static final String HEADER = "All records in journal:";
    private static final String BACK = "1. Back";

    private final Repository<Record> journal;
    private final RecordView recordView;

    public JournalView(
            String HINT,
            Repository<Record> journal,
            RecordView recordView
    ) {
        super(HINT);
        this.journal = journal;
        this.recordView = recordView;
    }

    @Override
    void displayHeader() {
        System.out.println(HEADER);
    }

    @Override
    void displayBody() {
        for (Record record : journal.all()) {
            recordView.setRecord(record);
            recordView.display();
        }
        System.out.println(BACK);
    }
}
