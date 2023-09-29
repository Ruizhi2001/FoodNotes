package seedu.address.logic.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;
import seedu.address.testutil.PersonBuilder;

import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

class RemarkCommandTest {
    private static final String REMARK_STUB = "Some remark";
    private Model model;
    @BeforeEach
    public void setUp() {
        this.model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }
    @Test
    void execute_addRemarkUnfilteredList_success() {
        Person personToEdit = this.model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        RemarkCommand remarkCommand = new RemarkCommand(INDEX_FIRST_PERSON, new Remark(REMARK_STUB));
        Person editedPerson = new PersonBuilder(personToEdit).withRemark(REMARK_STUB).build();

        String expectedMessage = String.format(RemarkCommand.MESSAGE_ADD_REMARK_SUCCESS, editedPerson);

        Model expectedModel = new ModelManager(this.model.getAddressBook(), new UserPrefs());
        expectedModel.setPerson(personToEdit, editedPerson);

        CommandTestUtil.assertCommandSuccess(remarkCommand, this.model, expectedMessage, expectedModel);
    }

    @Test
    void execute_invalidPersonIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(this.model.getFilteredPersonList().size() + 1);
        RemarkCommand remarkCommand = new RemarkCommand(outOfBoundIndex, new Remark(REMARK_STUB));

        CommandTestUtil.assertCommandFailure(remarkCommand, this.model,
                Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }
}