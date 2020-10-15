package br.com.andre.services;

import br.com.andre.utils.OperationsUtils;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculusService {

    public Double sum(String numberOne, String numberTwo) {
        return OperationsUtils.convertToDouble(numberOne) + OperationsUtils.convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        return OperationsUtils.convertToDouble(numberOne) - OperationsUtils.convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        return OperationsUtils.convertToDouble(numberOne) / OperationsUtils.convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        return OperationsUtils.convertToDouble(numberOne) * OperationsUtils.convertToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) {
        return (OperationsUtils.convertToDouble(numberOne) + OperationsUtils.convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {
        return (Double) Math.sqrt(OperationsUtils.convertToDouble(number));
    }
}
