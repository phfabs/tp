package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.GenerateMemberIds;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.DateOfBirth;
import seedu.address.model.person.Email;
import seedu.address.model.person.EmergencyContact;
import seedu.address.model.person.Gender;
import seedu.address.model.person.MembershipExpiryDate;
import seedu.address.model.person.MembershipJoinDate;
import seedu.address.model.person.MembershipType;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(GenerateMemberIds.generateNextId(), new Name("Alex Yeoh"), new Phone("87438807"),
                new Gender("M"), new DateOfBirth("17-08-2004"),
                new Email("alexyeoh@example.com"), new EmergencyContact("93020640"),
                new MembershipType("annual"), new MembershipJoinDate("12-01-2020"),
                new MembershipExpiryDate("12-01-2021")),
            new Person(GenerateMemberIds.generateNextId(), new Name("Bernice Yu"), new Phone("99272758"),
                new Gender("M"), new DateOfBirth("19-01-2005"),
                new Email("berniceyu@example.com"), new EmergencyContact("93030718"),
                new MembershipType("monthly"), new MembershipJoinDate("11-10-2024"),
                new MembershipExpiryDate("11-09-2026")),
            new Person(GenerateMemberIds.generateNextId(), new Name("Charlotte Oliveiro"), new Phone("93210283"),
                new Gender("F"), new DateOfBirth("02-02-2002"),
                new Email("charlotte@example.com"), new EmergencyContact("81174114"),
                new MembershipType("Monthly"), new MembershipJoinDate("11-03-2026"),
                new MembershipExpiryDate("11-04-2026")),
            new Person(GenerateMemberIds.generateNextId(), new Name("David Li"), new Phone("91031282"),
                new Gender("M"), new DateOfBirth("28-03-1995"),
                new Email("lidavid@example.com"), new EmergencyContact("84362643"),
                new MembershipType("Annual"), new MembershipJoinDate("21-01-2026"),
                new MembershipExpiryDate("21-01-2027")),
            new Person(GenerateMemberIds.generateNextId(), new Name("Irfan Ibrahim"), new Phone("92492021"),
                new Gender("M"), new DateOfBirth("09-11-2001"),
                new Email("irfan@example.com"), new EmergencyContact("94720173"),
                new MembershipType("Annual"), new MembershipJoinDate("11-03-2025"),
                new MembershipExpiryDate("11-03-2026")),
            new Person(GenerateMemberIds.generateNextId(), new Name("Roy Balakrishnan"), new Phone("92624417"),
                new Gender("M"), new DateOfBirth("04-05-1999"),
                new Email("royb@example.com"), new EmergencyContact("94585111"),
                new MembershipType("Monthly"), new MembershipJoinDate("27-02-2026"),
                new MembershipExpiryDate("27-03-2026"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

}
