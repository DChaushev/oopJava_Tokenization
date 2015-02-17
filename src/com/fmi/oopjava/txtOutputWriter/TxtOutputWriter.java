package com.fmi.oopjava.txtOutputWriter;

import com.fmi.oopjava.bankCard.BankCard;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * One of the requests of the task is to have the functionality of outputting
 * Card number - tokens table in .txt file.
 * 
 * This class is doing just that.
 * It takes all the cards from the XML files, generates the output and writes it
 * in a file, called -current_time-.txt in /TokensOutput folder.
 * 
 * @author Dimitar
 */
public class TxtOutputWriter {

    private static final String OUTPUT_FOLDER = "./TokensOutput";

    public static void writeOutput(Set<BankCard> cards) {

        String result = createOutput(cards);

        try (PrintWriter out = new PrintWriter(new File(OUTPUT_FOLDER + "/" + System.currentTimeMillis() + ".txt"))) {

            out.println(result);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TxtOutputWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void appendBorders(StringBuilder result) {
        for (int i = 0; i < 40; i++) {
            result.append("-");
        }
    }

    private static String createOutput(Set<BankCard> cards) {
        StringBuilder result = new StringBuilder();

        for (BankCard card : cards) {
            Set<String> tokens = card.getTokens();
            appendBorders(result);
            result.append("\n");
            result.append(String.format("%s:", card.getCardNumber()));
            for (String token : tokens) {
                if (result.charAt(result.length() - 1) == '\n') {
                    result.append(String.format("%" + card.getCardNumber().length() + "s\t%s\n", " ", token));
                } else {
                    result.append(String.format("\t%s\n", token));
                }
            }
        }
        appendBorders(result);
        System.out.println(result.toString());
        return result.toString();
    }

}
