import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public enum TransactionType {
    INCOME, EXPENSE

}

public class Transaction {
    private final BigDecimal amount;
    private final TransactionType type;
    private final String category;
    private final String description;
    private final LocalDate date;

public Transaction(BigDecimal amount, TransactionType type, String category, String description, LocalDate date) {

    this.amount = Objects.requireNonNull(amount, "Amount cannot be null");
    this.type = Objects.requireNonNull(type, "Transaction type cannot be null");
    this.category = Objects.requireNonNull(category, "Category cannot be null");
    this.date = Objects.requireNonNull(date, "Transaction date cannot be null");

    this.description = (description != null) ? description : "";

    if (amount.compareTo(BigDecimal.ZERO) <= 0) {
        throw new IllegalArgumentException("Transaction amount cannot be 0");


     }

    // save empty decription and trim spaces
    if (description == null) {
        this.description = "";

    }else {
        this.description = description.trim();
    }

    this.amount = amount;
    this.type = type;
    this.category = category;
    this.date = date;

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public String getCategoty() {
        return category;
    }

    public String getDescription() {
        return description;

    }

    public LocalDate getDate(){
        return date;
    }


@Override
        public String to String() {
        return "Transaction: " + type + " | " + category + " | " + " R" + amount + " | " + description + " made on " + date;
    }


    }

}