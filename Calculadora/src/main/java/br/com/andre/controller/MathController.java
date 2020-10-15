package br.com.andre.controller;

import br.com.andre.services.SimpleCalculusService;
import br.com.andre.exception.UnsuportedOperationMathException;
import br.com.andre.utils.OperationsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    private SimpleCalculusService calculusService;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!OperationsUtils.isNumeric(numberOne) || !OperationsUtils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationMathException("Please set a numeric value.");
        }
        return calculusService.sum(numberOne, numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!OperationsUtils.isNumeric(numberOne) || !OperationsUtils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationMathException("Please set a numeric value.");
        }
        return calculusService.subtraction(numberOne, numberTwo);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!OperationsUtils.isNumeric(numberOne) || !OperationsUtils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationMathException("Please set a numeric value.");
        }
        return calculusService.multiplication(numberOne, numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!OperationsUtils.isNumeric(numberOne) || !OperationsUtils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationMathException("Please set a numeric value.");
        }
        if (OperationsUtils.convertToDouble(numberOne) == 0) throw new UnsuportedOperationMathException("Não pode ser zero.");
        return calculusService.division(numberOne, numberTwo);
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne,
                         @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!OperationsUtils.isNumeric(numberOne) || !OperationsUtils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationMathException("Please set a numeric value.");
        }
        return calculusService.mean(numberOne, numberTwo);
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!OperationsUtils.isNumeric(number)) {
            throw new UnsuportedOperationMathException("Please set a numeric value.");
        }
        return calculusService.squareRoot(number);
    }

}
