package seedu.address.ui;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import javafx.collections.ObservableList;
import seedu.address.model.person.Person;

/**
 * Provides an overview of memberships, e.g. total members, total membership types, expiring memberships
 */
public class DashboardStats {
    public static int getTotal(ObservableList<Person> list) {
        return list.size();
    }
    public static int getAnnual(ObservableList<Person> list) {
        return (int) list.stream().filter(
                p -> p.getMembershipType().value.equalsIgnoreCase("annual")).count();
    }
    public static int getMonthly(ObservableList<Person> list) {
        return (int) list.stream().filter(
                p -> p.getMembershipType().value.equalsIgnoreCase("monthly")).count();
    }
    public static int getExpiring(ObservableList<Person> list) {
        return (int) list.stream().filter(
                p -> (!p.getExpiryDate().getExpiryDate().isBefore(LocalDate.now()))
                        && (!p.getExpiryDate().getExpiryDate().isAfter(LocalDate.now().plusDays(7)))
        ).count();
    }
    /**
     * Counts members whose join date falls in the current ISO calendar week (Monday–Sunday, inclusive).
     */
    public static int getNewMembers(ObservableList<Person> list) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        return (int) list.stream().filter(
                p -> !p.getJoinDate().getDate().isBefore(startOfWeek)
                        && !p.getJoinDate().getDate().isAfter(endOfWeek)
        ).count();
    }
}
