package com.example.bankovyucet;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class HelloController {
    @FXML private TextField startingBalanceField, amountField;
    @FXML private ComboBox<String> typeBox;
    @FXML private Label balanceLabel;
    @FXML private TextArea transactionsArea;
    @FXML private Button runOneButton, runFiveButton;

    public volatile BankAccount account;
    private static final Locale SK = Locale.forLanguageTag("sk-SK");

    @FXML
    private void initialize(){
        typeBox.getItems().addAll("Vklad", "Vyber");
        typeBox.getSelectionModel().selectFirst();
        startingBalanceField.setText("1000");
        amountField.setText("100");
        setEnabled(false);
        balanceLabel.setText(money(0));
    }

    @FXML
    private void createAccount(){
        try {
            long cents = parseCents(startingBalanceField.getText(), false);
            account = new BankAccount(cents);
            transactionsArea.clear();
            transactionsArea.appendText("Ucet vytvoreny, pociatocny stav: " + money(cents) + "\n");
            balanceLabel.setText(money(cents));
            setEnabled(true);
        }catch(IllegalArgumentException e){
            transactionsArea.appendText("Error: " + e.getMessage() + "\n");
        }
    }

    @FXML
    private void runOne(){
        BankAccount current = account;
        if(current == null) return;
        try {
            long amount = parseCents(amountField.getText(),true);
            boolean deposit = "Vklad".equals(typeBox.getValue());
            startEmployee(current,deposit,amount);
        }catch(IllegalArgumentException e){
            transactionsArea.appendText("Error: " + e.getMessage() + "\n");
        }
    }

    @FXML
    private void runFive(){
        BankAccount current = account;
        if(current == null) return;
        for(int i = 0; i < 5; i++){
            boolean deposit = ThreadLocalRandom.current().nextBoolean();
            long amount = ThreadLocalRandom.current().nextLong(10,501) * 100L;
            startEmployee(current,deposit,amount);
        }
    }

    private void startEmployee(BankAccount current, boolean deposit, long amount){
        Employee employee = new Employee(current,deposit,amount,this::showTransaction);
        Thread thread = new Thread(employee, "Employee");
        thread.setDaemon(true);
        thread.start();
    }

    private void showTransaction(TransactionResult result){
        Platform.runLater(() -> {
            String type = result.deposit() ? "VKLAD" : "VYBER";
            String status = result.success() ? "OK" : "ZAMIETNUTE " + result.message();
            transactionsArea.appendText("Zamestnanec #" + result.employeeId() + " | " + type + " " + money(result.amountCents()) +
            " | " + status + " | zostatok po operacii: " + money(result.balanceCents()) + "\n");
            BankAccount current = account;
            if(current != null) balanceLabel.setText(money(current.getBalanceCents()));
        });
    }

    private void setEnabled(boolean enabled){
        runOneButton.setDisable(!enabled);
        runFiveButton.setDisable(!enabled);
    }

    private static long parseCents(String text, boolean positiveOnly){
        try {
            String normalized = text.trim().replace(',','.');
            BigDecimal value = new BigDecimal(normalized);
            if(positiveOnly ? value.signum() <= 0 : value.signum() < 0) throw new IllegalArgumentException("Only positive numbers");
            return value.movePointRight(2).setScale(0, RoundingMode.UNNECESSARY).longValueExact();
        }catch(NumberFormatException | ArithmeticException e){
            throw new IllegalArgumentException("Input corrcet amount(example: 100 or 12,50).");
        }
    }

    private static String money(long cents){
        NumberFormat nf = NumberFormat.getCurrencyInstance(SK);
        return nf.format(BigDecimal.valueOf(cents,2));
    }
}
