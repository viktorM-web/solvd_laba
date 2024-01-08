package com.solvd.post.customException;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

@UtilityClass
public class ExceptionHandlerUtil {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerUtil.class);
    public static final String PATTERN_NAME = "^[A-Z]{1}[a-z]+";
    public static final String PATTERN_PASSPORT = "^[A-Z]{2}(\\d{7})";
    public static final String PATTERN_DOUBLE = "(\\d+)[.](\\d{2})";

    public static Integer handleNotValidException(Scanner scanner) {

        boolean wasException = true;
        Integer id = null;

        while (wasException) {
            try {

                id = scanner.nextInt();
                wasException = false;
            } catch (Exception e) {
                NotValidException notValidException = new NotValidException(e);
                log.error(notValidException.getMessage());
                wasException = true;
                scanner.next();
            }
        }
        return id;
    }

    public static String handleNameValidException(Scanner scanner) {

        boolean wasException = true;
        String str = null;

        while (wasException) {
            try {
                str = scanner.nextLine();
                checkNamePattern(str);
                wasException = false;
            } catch (NameValidationException e) {
                log.error(e.getMessage());
                wasException = true;
            } catch (Exception e) {
                NotValidException notValidException = new NotValidException(e);
                log.error(notValidException.getMessage());
                wasException = true;
            }
        }
        return str;
    }

    public static String handlePassportValidException(Scanner scanner) {

        boolean wasException = true;
        String str = null;

        while (wasException) {
            try {
                str = scanner.nextLine();
                checkPassportPattern(str);
                wasException = false;
            } catch (PassportValidationException e) {
                log.error(e.getMessage());
                wasException = true;
            } catch (Exception e) {
                NotValidException notValidException = new NotValidException(e);
                log.error(notValidException.getMessage());
                wasException = true;
            }
        }
        return str;
    }

    public static Double handleWeightException(Scanner scanner) {

        boolean wasException = true;
        String str = null;

        while (wasException) {
            try {
                str = scanner.nextLine();
                checkWeightPattern(str);
                wasException = false;
            } catch (WeightValidationException e) {
                log.error(e.getMessage());
                wasException = true;
            } catch (Exception e) {
                NotValidException notValidException = new NotValidException(e);
                log.error(notValidException.getMessage());
                wasException = true;
            }
        }
        return Double.parseDouble(str);
    }

    public static Double handleDimensionsException(Scanner scanner) {

        boolean wasException = true;
        String str = null;

        while (wasException) {
            try {
                str = scanner.nextLine();
                checkDimensionsPattern(str);
                wasException = false;
            } catch (DimensionsValidationException e) {
                log.error(e.getMessage());
                wasException = true;
            } catch (Exception e) {
                NotValidException notValidException = new NotValidException(e);
                log.error(notValidException.getMessage());
                wasException = true;
            }
        }
        return Double.parseDouble(str);
    }

    private static void checkNamePattern(String str) throws NameValidationException {
        if (!str.matches(PATTERN_NAME)) {
            throw new NameValidationException();
        }
    }

    private static void checkPassportPattern(String str) throws PassportValidationException {
        if (!str.matches(PATTERN_PASSPORT)) {
            throw new PassportValidationException();
        }
    }

    private static void checkWeightPattern(String str) throws WeightValidationException {
        if (!str.matches(PATTERN_DOUBLE)) {
            throw new WeightValidationException();
        }
    }

    private static void checkDimensionsPattern(String str) throws DimensionsValidationException {
        if (!str.matches(PATTERN_DOUBLE)) {
            throw new DimensionsValidationException();
        }
    }
}
