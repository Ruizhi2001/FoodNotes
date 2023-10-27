package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.stall.Stall;

/**
 * Panel containing the list of persons.
 */
public class OneStallPanel extends UiPart<Region> {
    private static final String FXML = "StallDetailsPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(StallListPanel.class);
    @FXML
    private Label stallRating;

    @FXML
    private Label stallDescription;


    /**
     * Creates a {@code StallListPanel} with the given {@code ObservableList}.
     */
    public OneStallPanel(Stall stall) {
        super(FXML);
        stallRating.setText(stall.getStallStarRating());
        stallDescription.setText(stall.getStallDescription());
    }
}